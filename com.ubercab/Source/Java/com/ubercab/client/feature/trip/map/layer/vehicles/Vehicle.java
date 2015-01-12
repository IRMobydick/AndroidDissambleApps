package com.ubercab.client.feature.trip.map.layer.vehicles;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.animation.LinearInterpolator;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import com.ubercab.client.core.model.VehiclePathPoint;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.util.LatLngInterpolator;
import com.ubercab.client.core.util.MathUtils;
import com.ubercab.library.content.TargetAdapter;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.map.UberBitmapDescriptor;
import com.ubercab.library.map.UberBitmapDescriptorFactory;
import com.ubercab.library.map.UberMap;
import com.ubercab.library.map.UberMarker;
import com.ubercab.library.map.UberMarkerOptions;
import com.ubercab.library.ui.AnimatorCancelAdapter;
import com.ubercab.library.util.TimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Provider;

final class Vehicle
{
  private static final long ANIMATION_FADE = 200L;
  private static final long ANIMATION_LOOP = 750L;
  private static final long FIXED_TIME_DELAY_MS = 16000L;
  private static long sFixedDelayInMs;
  private AnimatorSet mAnimatorSet;
  private final UberBitmapDescriptorFactory mBitmapDescriptorFactory;
  private final Context mContext;
  private Animator mFadeAnimator;
  private final Handler mHandler = new Handler();
  private boolean mIsAnimating;
  private UberMarker mMarker;
  private final Provider<UberMarkerOptions> mMarkerOptionsProvider;
  private final List<VehiclePathPoint> mPathPoints = new CopyOnWriteArrayList();
  private final Picasso mPicasso;
  private final Runnable mRunnable = new Runnable()
  {
    public void run()
    {
      Vehicle.this.animate();
    }
  };
  private long mSyncDelayInMs;
  private Target mTarget;
  private final UberMap mUberMap;
  private String mVehicleId;
  private final VehicleView mVehicleView;

  Vehicle(Context paramContext, Picasso paramPicasso, VehicleView paramVehicleView, String paramString, List<VehiclePathPoint> paramList, UberMap paramUberMap, UberBitmapDescriptorFactory paramUberBitmapDescriptorFactory, Provider<UberMarkerOptions> paramProvider)
  {
    this.mVehicleId = paramString;
    this.mUberMap = paramUberMap;
    this.mContext = paramContext;
    this.mPicasso = paramPicasso;
    this.mVehicleView = paramVehicleView;
    this.mSyncDelayInMs = (TimeUtils.getEpochTimeMs() - ((VehiclePathPoint)paramList.get(-1 + paramList.size())).getEpoch());
    this.mBitmapDescriptorFactory = paramUberBitmapDescriptorFactory;
    this.mMarkerOptionsProvider = paramProvider;
    updatePathPoints(paramList);
  }

  private void animate()
  {
    while (true)
    {
      float f3;
      float f4;
      try
      {
        boolean bool = this.mIsAnimating;
        if (!bool)
          return;
        VehiclePathPoint localVehiclePathPoint = getPathPointAtTime(750L + getCurrentTimeWithSyncInMs());
        if (localVehiclePathPoint == null)
          continue;
        UberLatLng localUberLatLng = localVehiclePathPoint.getUberLatLng();
        TypeEvaluator local4 = new TypeEvaluator()
        {
          public UberLatLng evaluate(float paramAnonymousFloat, UberLatLng paramAnonymousUberLatLng1, UberLatLng paramAnonymousUberLatLng2)
          {
            return LatLngInterpolator.linear(paramAnonymousFloat, paramAnonymousUberLatLng1, paramAnonymousUberLatLng2);
          }
        };
        ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofObject(this.mMarker, "position", local4, new Object[] { localUberLatLng });
        float f1 = MathUtils.degreesToRadians(this.mMarker.getRotation());
        float f2 = MathUtils.degreesToRadians(localVehiclePathPoint.getCourse());
        f3 = MathUtils.normalizeRadians(f1);
        f4 = MathUtils.normalizeRadians(f2);
        if ((f4 > f3) && (f4 - f3 > 3.141592653589793D))
        {
          f4 = (float)(f4 - 6.283185307179586D);
          float f5 = MathUtils.radiansToDegrees(f3);
          float f6 = MathUtils.radiansToDegrees(f4);
          ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.mMarker, "rotation", new float[] { f5, f6 });
          AnimatorSet localAnimatorSet = new AnimatorSet();
          localAnimatorSet.setDuration(750L);
          localAnimatorSet.setInterpolator(new LinearInterpolator());
          localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
          if ((this.mAnimatorSet != null) && (this.mAnimatorSet.isRunning()))
            this.mAnimatorSet.cancel();
          this.mAnimatorSet = localAnimatorSet;
          this.mAnimatorSet.start();
          this.mHandler.postDelayed(this.mRunnable, 500L);
          continue;
        }
      }
      finally
      {
      }
      if ((f4 < f3) && (f3 - f4 > 3.141592653589793D))
        f3 = (float)(f3 - 6.283185307179586D);
    }
  }

  private void fadeInMarker(Bitmap paramBitmap)
  {
    if (this.mMarker == null)
      return;
    this.mMarker.setIcon(this.mBitmapDescriptorFactory.fromBitmap(paramBitmap));
    if ((this.mFadeAnimator != null) && (this.mFadeAnimator.isRunning()))
      this.mFadeAnimator.cancel();
    UberMarker localUberMarker = this.mMarker;
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = this.mMarker.getAlpha();
    arrayOfFloat[1] = 1.0F;
    this.mFadeAnimator = ObjectAnimator.ofFloat(localUberMarker, "alpha", arrayOfFloat);
    this.mFadeAnimator.setInterpolator(new LinearInterpolator());
    this.mFadeAnimator.setDuration(200L);
    this.mFadeAnimator.start();
  }

  public static void setFixedDelayInMs(long paramLong)
  {
    sFixedDelayInMs = paramLong;
  }

  private void setMarkerIcon()
  {
    this.mTarget = new TargetAdapter()
    {
      public void onBitmapFailed(Drawable paramAnonymousDrawable)
      {
        Vehicle.access$202(Vehicle.this, new TargetAdapter()
        {
          public void onBitmapLoaded(Bitmap paramAnonymous2Bitmap, Picasso.LoadedFrom paramAnonymous2LoadedFrom)
          {
            Vehicle.this.fadeInMarker(paramAnonymous2Bitmap);
            Vehicle.access$202(Vehicle.this, null);
          }
        });
        Vehicle.this.mPicasso.load(Vehicle.this.mVehicleView.getMapImagePublicUri()).transform(new VehicleViewMapImageTransformation()).into(Vehicle.this.mTarget);
      }

      public void onBitmapLoaded(Bitmap paramAnonymousBitmap, Picasso.LoadedFrom paramAnonymousLoadedFrom)
      {
        Vehicle.this.fadeInMarker(paramAnonymousBitmap);
        Vehicle.access$202(Vehicle.this, null);
      }
    };
    this.mPicasso.load(this.mVehicleView.getMapImageResourceUri(this.mContext)).into(this.mTarget);
  }

  private void trimPathPoints()
  {
    long l = getCurrentTimeWithSyncInMs();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; ; i++)
    {
      VehiclePathPoint localVehiclePathPoint;
      if (i < -1 + this.mPathPoints.size())
      {
        localVehiclePathPoint = (VehiclePathPoint)this.mPathPoints.get(i);
        if (localVehiclePathPoint.getEpoch() <= l);
      }
      else
      {
        this.mPathPoints.remove(localArrayList);
        return;
      }
      localArrayList.add(localVehiclePathPoint);
    }
  }

  public long getCurrentTimeWithSyncInMs()
  {
    if (sFixedDelayInMs == 0L)
      sFixedDelayInMs = 16000L;
    return TimeUtils.getEpochTimeMs() - (sFixedDelayInMs + this.mSyncDelayInMs);
  }

  public String getId()
  {
    return this.mVehicleId;
  }

  public UberLatLng getMarkerPosition()
  {
    if (this.mMarker == null)
      return null;
    return this.mMarker.getPosition();
  }

  public VehiclePathPoint getPathPointAtTime(long paramLong)
  {
    trimPathPoints();
    int i = this.mPathPoints.size();
    Object localObject1 = null;
    int j;
    Object localObject2;
    VehiclePathPoint localVehiclePathPoint1;
    long l1;
    long l2;
    if (i >= 2)
    {
      j = 1;
      int k = this.mPathPoints.size();
      localObject2 = null;
      localVehiclePathPoint1 = null;
      if (j < k)
      {
        VehiclePathPoint localVehiclePathPoint2 = (VehiclePathPoint)this.mPathPoints.get(j);
        if (localVehiclePathPoint2.getEpoch() <= paramLong)
          break label163;
        localVehiclePathPoint1 = (VehiclePathPoint)this.mPathPoints.get(j - 1);
        localObject2 = localVehiclePathPoint2;
      }
      if (localObject2 == null)
        break label212;
      l1 = localVehiclePathPoint1.getEpoch();
      l2 = localObject2.getEpoch();
      if (l1 != l2)
        break label169;
      localObject1 = localVehiclePathPoint1;
    }
    while (true)
    {
      if ((localObject1 == null) && (this.mPathPoints.size() > 0))
        localObject1 = (VehiclePathPoint)this.mPathPoints.get(0);
      return localObject1;
      label163: j++;
      break;
      label169: localObject1 = new VehiclePathPoint(paramLong, LatLngInterpolator.linear((float)(paramLong - l1) / (float)(l2 - l1), localVehiclePathPoint1.getUberLatLng(), localObject2.getUberLatLng()), localVehiclePathPoint1.getCourse());
      continue;
      label212: if (paramLong > ((VehiclePathPoint)this.mPathPoints.get(-1 + this.mPathPoints.size())).getEpoch())
        localObject1 = (VehiclePathPoint)this.mPathPoints.get(-1 + this.mPathPoints.size());
      else
        localObject1 = (VehiclePathPoint)this.mPathPoints.get(0);
    }
  }

  public String getViewId()
  {
    return this.mVehicleView.getId();
  }

  public boolean isAnimating()
  {
    return this.mIsAnimating;
  }

  public void startAnimation()
  {
    try
    {
      boolean bool = this.mIsAnimating;
      if (bool);
      while (true)
      {
        return;
        this.mIsAnimating = true;
        VehiclePathPoint localVehiclePathPoint = getPathPointAtTime(getCurrentTimeWithSyncInMs());
        if (localVehiclePathPoint != null)
        {
          Bitmap localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
          UberBitmapDescriptor localUberBitmapDescriptor = this.mBitmapDescriptorFactory.fromBitmap(localBitmap);
          UberMarkerOptions localUberMarkerOptions = ((UberMarkerOptions)this.mMarkerOptionsProvider.get()).position(localVehiclePathPoint.getUberLatLng()).rotation(localVehiclePathPoint.getCourse()).icon(localUberBitmapDescriptor).anchor(0.5F, 0.5F).alpha(0.0F);
          this.mMarker = this.mUberMap.addMarker(localUberMarkerOptions);
          setMarkerIcon();
        }
        this.mHandler.post(this.mRunnable);
      }
    }
    finally
    {
    }
  }

  public void stopAnimation()
  {
    try
    {
      this.mIsAnimating = false;
      this.mHandler.removeCallbacks(this.mRunnable);
      final UberMarker localUberMarker = this.mMarker;
      this.mMarker = null;
      if (this.mAnimatorSet != null)
        this.mAnimatorSet.cancel();
      if (localUberMarker != null)
      {
        if ((this.mFadeAnimator != null) && (this.mFadeAnimator.isRunning()))
          this.mFadeAnimator.cancel();
        float[] arrayOfFloat = new float[2];
        arrayOfFloat[0] = localUberMarker.getAlpha();
        arrayOfFloat[1] = 0.0F;
        this.mFadeAnimator = ObjectAnimator.ofFloat(localUberMarker, "alpha", arrayOfFloat);
        this.mFadeAnimator.setDuration(200L);
        this.mFadeAnimator.setInterpolator(new LinearInterpolator());
        this.mFadeAnimator.addListener(new AnimatorCancelAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            super.onAnimationEnd(paramAnonymousAnimator);
            localUberMarker.remove();
          }
        });
        this.mFadeAnimator.start();
      }
      return;
    }
    finally
    {
    }
  }

  public void updatePathPoints(List<VehiclePathPoint> paramList)
  {
    if (paramList.size() == 0)
      return;
    int i = 0;
    long l = ((VehiclePathPoint)paramList.get(0)).getEpoch();
    Iterator localIterator = this.mPathPoints.iterator();
    while (true)
    {
      if ((!localIterator.hasNext()) || (((VehiclePathPoint)localIterator.next()).getEpoch() >= l))
      {
        this.mPathPoints.subList(i, this.mPathPoints.size()).clear();
        this.mPathPoints.addAll(paramList);
        trimPathPoints();
        return;
      }
      i++;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.layer.vehicles.Vehicle
 * JD-Core Version:    0.6.2
 */