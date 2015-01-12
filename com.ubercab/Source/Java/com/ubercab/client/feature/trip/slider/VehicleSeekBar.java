package com.ubercab.client.feature.trip.slider;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.ui.ColorStateDrawable;
import com.ubercab.common.base.Optional;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.Iterables;
import com.ubercab.library.app.UberApplication;
import com.ubercab.library.util.BitmapUtils;
import com.ubercab.library.util.DisplayUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class VehicleSeekBar extends SeekBar
  implements SeekBar.OnSeekBarChangeListener
{
  private static final int ALPHA_OPAQUE = 255;
  private static final int ALPHA_SEMI_TRANSPARENT = 80;
  private static final int NUMBER_OF_INTERVALS_PER_SEGMENT = 2;
  private static final int SEEKBAR_MAX = 1000;
  private static final int SLIDE_DURATION = 200;
  private static final int THUMB_ICON_SIZE_DP = 30;
  private static final int THUMB_SIZE_DP = 52;
  private static final int THUMB_SIZE_PX = DisplayUtils.convertDpToPixel(52);
  private Uri mCurrentVehicleViewUri;
  private Drawable mDrawableBackground;
  private Drawable mDrawableNode;
  private LayerDrawable mDrawableThumb;
  private Interpolator mInterpolator;
  private boolean mIsSlideInitiated;
  private Listener mListener;

  @Inject
  Picasso mPicasso;
  private int mProgressChangedCount;
  private int mProgressStartTracking;
  private int mScaledTouchSlop;
  private float mTouchDownX;
  private Map<String, ColorStateDrawable> mVehicleIconDrawables = new HashMap();
  private Set<Target> mVehicleTargets = new HashSet();
  private List<VehicleViewGroup> mVehicleViewGroups;

  public VehicleSeekBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public VehicleSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public VehicleSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setMax(1000);
    this.mScaledTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.mDrawableBackground = getResources().getDrawable(2130837922);
    setOnSeekBarChangeListener(this);
    if (!isInEditMode())
      UberApplication.get(paramContext).inject(this);
  }

  private void cacheAndLoadVehicleImage(VehicleView paramVehicleView, Uri paramUri, Bitmap paramBitmap)
  {
    String str = paramVehicleView.getId();
    if (paramUri.equals(this.mCurrentVehicleViewUri))
    {
      ColorStateDrawable localColorStateDrawable = createVehicleViewDrawable(paramBitmap);
      this.mVehicleIconDrawables.put(str, localColorStateDrawable);
      drawVehicleViewImageOnThumb(str, localColorStateDrawable);
    }
  }

  private int calculateVehicleViewIndex()
  {
    int i = getMax();
    int j = getProgress();
    int k = this.mVehicleViewGroups.size();
    if (k > 1)
      return (1 + j / (i / (2 * (k - 1)))) / 2;
    return 0;
  }

  private ColorStateDrawable createVehicleViewDrawable(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
      paramBitmap = Bitmap.createBitmap(30, 30, Bitmap.Config.ARGB_8888);
    Bitmap localBitmap = BitmapUtils.scaleToMaxSize(paramBitmap, DisplayUtils.convertDpToPixel(30));
    return new ColorStateDrawable(new BitmapDrawable(getResources(), localBitmap));
  }

  private void drawVehicleViewImageOnThumb(String paramString, ColorStateDrawable paramColorStateDrawable)
  {
    if (paramColorStateDrawable == null)
      return;
    int i = (THUMB_SIZE_PX - paramColorStateDrawable.getIntrinsicHeight()) / 2;
    int j = (THUMB_SIZE_PX - paramColorStateDrawable.getIntrinsicWidth()) / 2;
    paramColorStateDrawable.setColorState(16842919, -1);
    paramColorStateDrawable.setColorState(16842910, -16777216);
    paramColorStateDrawable.setState(this.mDrawableThumb.getState());
    VehicleViewGroup localVehicleViewGroup = findVehicleViewGroupByVehicleViewId(paramString);
    if ((localVehicleViewGroup != null) && (localVehicleViewGroup.isAvailable()));
    for (int k = 255; ; k = 80)
    {
      paramColorStateDrawable.setAlpha(k);
      this.mDrawableThumb.setLayerInset(1, j, i, j, i);
      this.mDrawableThumb.setDrawableByLayerId(2131427933, paramColorStateDrawable);
      Rect localRect = this.mDrawableThumb.copyBounds();
      this.mDrawableThumb.setBounds(0, 0, 0, 0);
      this.mDrawableThumb.setBounds(localRect);
      invalidate();
      return;
    }
  }

  private VehicleViewGroup findVehicleViewGroupByVehicleViewId(final String paramString)
  {
    return (VehicleViewGroup)Iterables.tryFind(this.mVehicleViewGroups, new Predicate()
    {
      public boolean apply(VehicleViewGroup paramAnonymousVehicleViewGroup)
      {
        return paramAnonymousVehicleViewGroup.hasVehicleView(paramString);
      }
    }).orNull();
  }

  private boolean hasMovedPastThreshold(float paramFloat)
  {
    return Math.abs(paramFloat - this.mTouchDownX) > this.mScaledTouchSlop;
  }

  private void loadVehicleViewImage(String paramString)
  {
    if (this.mVehicleIconDrawables.containsKey(paramString))
      drawVehicleViewImageOnThumb(paramString, (ColorStateDrawable)this.mVehicleIconDrawables.get(paramString));
    VehicleViewGroup localVehicleViewGroup;
    do
    {
      return;
      this.mDrawableThumb.setDrawableByLayerId(2131427933, new ColorDrawable(0));
      localVehicleViewGroup = findVehicleViewGroupByVehicleViewId(paramString);
    }
    while (localVehicleViewGroup == null);
    loadVehicleViewImageFromResources(localVehicleViewGroup.getPrimary());
  }

  private void loadVehicleViewImageFromResources(final VehicleView paramVehicleView)
  {
    final Uri localUri = paramVehicleView.getMonoImageResourceUri(getContext());
    this.mCurrentVehicleViewUri = localUri;
    Target local2 = new Target()
    {
      public void onBitmapFailed(Drawable paramAnonymousDrawable)
      {
        VehicleSeekBar.this.loadVehicleViewImageFromWeb(paramVehicleView);
        VehicleSeekBar.this.mVehicleTargets.remove(this);
      }

      public void onBitmapLoaded(Bitmap paramAnonymousBitmap, Picasso.LoadedFrom paramAnonymousLoadedFrom)
      {
        VehicleSeekBar.this.cacheAndLoadVehicleImage(paramVehicleView, localUri, paramAnonymousBitmap);
        VehicleSeekBar.this.mVehicleTargets.remove(this);
      }

      public void onPrepareLoad(Drawable paramAnonymousDrawable)
      {
        VehicleSeekBar.this.mVehicleTargets.add(this);
      }
    };
    this.mPicasso.load(localUri).noFade().into(local2);
  }

  private void loadVehicleViewImageFromWeb(final VehicleView paramVehicleView)
  {
    final Uri localUri = paramVehicleView.getMonoImagePublicUri();
    this.mCurrentVehicleViewUri = localUri;
    Target local3 = new Target()
    {
      public void onBitmapFailed(Drawable paramAnonymousDrawable)
      {
        VehicleSeekBar.this.mVehicleTargets.remove(this);
      }

      public void onBitmapLoaded(Bitmap paramAnonymousBitmap, Picasso.LoadedFrom paramAnonymousLoadedFrom)
      {
        VehicleSeekBar.this.cacheAndLoadVehicleImage(paramVehicleView, localUri, paramAnonymousBitmap);
        VehicleSeekBar.this.mVehicleTargets.remove(this);
      }

      public void onPrepareLoad(Drawable paramAnonymousDrawable)
      {
        VehicleSeekBar.this.mVehicleTargets.add(this);
      }
    };
    this.mPicasso.load(localUri).noFade().into(local3);
  }

  private void snapThumbToNode(String paramString, boolean paramBoolean)
  {
    int i = this.mVehicleViewGroups.indexOf(findVehicleViewGroupByVehicleViewId(paramString));
    int j = this.mProgressStartTracking;
    int k = i * getMax() / Math.max(1, -1 + this.mVehicleViewGroups.size());
    if (this.mProgressChangedCount > 1)
      j = getProgress();
    if (paramBoolean)
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { j, k });
      localValueAnimator.setDuration(200L);
      localValueAnimator.setInterpolator(this.mInterpolator);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          VehicleSeekBar.this.setProgress(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
        }
      });
      localValueAnimator.start();
      return;
    }
    setProgress(k);
  }

  public Drawable getThumb()
  {
    return this.mDrawableThumb;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      int i = this.mVehicleViewGroups.size();
      if (i > 1)
      {
        int j = getWidth() - getPaddingLeft() - getPaddingRight();
        int k = getHeight();
        int m = getPaddingLeft();
        Rect localRect = new Rect();
        this.mDrawableBackground.getPadding(localRect);
        int n = m - localRect.left + this.mDrawableNode.getIntrinsicWidth() / 2;
        int i1 = getWidth() - n;
        this.mDrawableBackground.setBounds(n, 0, i1, getHeight());
        this.mDrawableBackground.draw(paramCanvas);
        int i2 = j / (i - 1);
        float f = this.mDrawableNode.getIntrinsicWidth() / 2.0F;
        for (int i3 = 1; i3 < i - 1; i3++)
        {
          int i4 = (int)(m + i2 * i3 - f);
          int i5 = (int)(k / 2.0F - this.mDrawableNode.getIntrinsicHeight() / 2.0F + getPaddingTop() / 2.0F);
          paramCanvas.save();
          paramCanvas.translate(i4, i5);
          this.mDrawableNode.draw(paramCanvas);
          paramCanvas.restore();
        }
      }
      super.onDraw(paramCanvas);
      return;
    }
    finally
    {
    }
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.mDrawableNode = getResources().getDrawable(2130837928);
    this.mDrawableNode.setBounds(0, 0, this.mDrawableNode.getIntrinsicWidth(), this.mDrawableNode.getIntrinsicHeight());
    this.mDrawableThumb = ((LayerDrawable)getResources().getDrawable(2130837923));
    setThumb(this.mDrawableThumb);
    this.mInterpolator = new DecelerateInterpolator();
    setInterpolator(this.mInterpolator);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      int i;
      int j;
      if (this.mDrawableThumb == null)
      {
        i = 0;
        LayerDrawable localLayerDrawable = this.mDrawableThumb;
        j = 0;
        if (localLayerDrawable != null)
          break label87;
      }
      while (true)
      {
        int m = i + (getPaddingLeft() + getPaddingRight());
        int n = j + (getPaddingTop() + getPaddingBottom());
        setMeasuredDimension(resolveSizeAndState(m, paramInt1, 0), resolveSizeAndState(n, paramInt2, 0));
        return;
        i = this.mDrawableThumb.getIntrinsicWidth();
        break;
        label87: int k = this.mDrawableThumb.getIntrinsicHeight();
        j = k;
      }
    }
    finally
    {
    }
  }

  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
      return;
    this.mProgressChangedCount = (1 + this.mProgressChangedCount);
    int i = calculateVehicleViewIndex();
    VehicleViewGroup localVehicleViewGroup = (VehicleViewGroup)this.mVehicleViewGroups.get(i);
    loadVehicleViewImage(localVehicleViewGroup.getPrimaryVehicleId());
    this.mListener.onVehicleSeekBarChanged(localVehicleViewGroup.getPrimaryVehicleId());
  }

  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.mProgressChangedCount = 0;
    this.mProgressStartTracking = paramSeekBar.getProgress();
  }

  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = calculateVehicleViewIndex();
    snapThumbToNode(((VehicleViewGroup)this.mVehicleViewGroups.get(i)).getPrimaryVehicleId(), true);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
    case 1:
    }
    label155: 
    do
      while (true)
      {
        i = super.onTouchEvent(paramMotionEvent);
        do
        {
          return i;
          this.mIsSlideInitiated = false;
          float f;
          if (this.mVehicleViewGroups.size() == i)
          {
            f = paramMotionEvent.getX() - getPaddingLeft();
            if ((f <= this.mDrawableThumb.getBounds().left) || (f >= this.mDrawableThumb.getBounds().right))
              break label155;
          }
          int k;
          for (int j = i; ; k = 0)
          {
            if (j != 0)
            {
              setPressed(i);
              invalidate(this.mDrawableThumb.getBounds());
            }
            this.mTouchDownX = paramMotionEvent.getX();
            return i;
            f = paramMotionEvent.getX() - this.mDrawableBackground.getBounds().left;
            break;
          }
        }
        while (!isPressed());
        if (!this.mIsSlideInitiated)
        {
          if (!hasMovedPastThreshold(paramMotionEvent.getX()))
            return false;
          this.mIsSlideInitiated = i;
          continue;
          if (!isPressed())
            break;
          setPressed(false);
          invalidate(this.mDrawableThumb.getBounds());
          if ((!this.mIsSlideInitiated) && (!hasMovedPastThreshold(paramMotionEvent.getX())) && (this.mListener != null))
            this.mListener.onVehicleSeekBarThumbClicked();
        }
      }
    while (!hasMovedPastThreshold(paramMotionEvent.getX()));
    return i;
  }

  void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  void setSelectedVehicleView(String paramString)
  {
    VehicleViewGroup localVehicleViewGroup = findVehicleViewGroupByVehicleViewId(paramString);
    if (localVehicleViewGroup == null);
    do
    {
      return;
      loadVehicleViewImage(localVehicleViewGroup.getPrimaryVehicleId());
    }
    while (isPressed());
    snapThumbToNode(paramString, false);
  }

  void setVehicleGroups(List<VehicleViewGroup> paramList)
  {
    this.mVehicleViewGroups = paramList;
    if (paramList.size() < 2)
    {
      setMax(0);
      setThumbOffset(0);
    }
    for (getLayoutParams().width = -2; ; getLayoutParams().width = -1)
    {
      requestLayout();
      invalidate();
      return;
      setMax(1000);
      setThumbOffset(this.mDrawableThumb.getIntrinsicWidth() / 2);
    }
  }

  public static abstract interface Listener
  {
    public abstract void onVehicleSeekBarChanged(String paramString);

    public abstract void onVehicleSeekBarThumbClicked();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleSeekBar
 * JD-Core Version:    0.6.2
 */