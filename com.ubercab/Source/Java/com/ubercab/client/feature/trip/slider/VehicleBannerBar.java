package com.ubercab.client.feature.trip.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.model.VehicleViewTagline;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.util.TextMarkupUtils;
import com.ubercab.client.feature.trip.TripUIStateManager;
import com.ubercab.library.app.UberActivity;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

public class VehicleBannerBar extends LinearLayout
{
  private ObjectAnimator mAnimatorHide;
  private ObjectAnimator mAnimatorShow;
  private boolean mIsVisible;
  private final List<Listener> mListeners = new CopyOnWriteArrayList();

  @InjectView(2131427853)
  TextView mTextViewDetail;

  @InjectView(2131427852)
  TextView mTextViewTitle;

  @Inject
  TripUIStateManager mTripUIStateManager;

  public VehicleBannerBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public VehicleBannerBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public VehicleBannerBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
      ((UberActivity)paramContext).inject(this);
  }

  private void cancelAnimators()
  {
    this.mAnimatorHide.cancel();
    this.mAnimatorShow.cancel();
  }

  private void ensureCorrectVisibility()
  {
    if (this.mIsVisible);
    for (int i = 0; ; i = 8)
    {
      setVisibility(i);
      return;
    }
  }

  private BannerStrings getBannerStrings(Ping paramPing)
  {
    if (PingUtils.hasTrip(paramPing));
    VehicleView localVehicleView;
    do
    {
      return null;
      String str = this.mTripUIStateManager.getSelectedVehicleViewId();
      localVehicleView = paramPing.getCity().findVehicleView(str);
    }
    while ((localVehicleView == null) || (!localVehicleView.hasValidTagline()));
    VehicleViewTagline localVehicleViewTagline = localVehicleView.getTagline();
    return new BannerStrings(TextMarkupUtils.parseMarkup(localVehicleViewTagline.getTitle(), getResources().getColor(2131296333)), localVehicleViewTagline.getDetail(), null);
  }

  private void initAnimators()
  {
    int i = getBarHeight();
    int j = getContext().getResources().getInteger(2131492872);
    float[] arrayOfFloat1 = new float[2];
    arrayOfFloat1[0] = i;
    arrayOfFloat1[1] = 0.0F;
    this.mAnimatorShow = ObjectAnimator.ofFloat(this, "translationY", arrayOfFloat1);
    float[] arrayOfFloat2 = new float[2];
    arrayOfFloat2[0] = 0.0F;
    arrayOfFloat2[1] = i;
    this.mAnimatorHide = ObjectAnimator.ofFloat(this, "translationY", arrayOfFloat2);
    this.mAnimatorShow.setDuration(j);
    this.mAnimatorHide.setDuration(j);
    this.mAnimatorShow.setInterpolator(new DecelerateInterpolator());
    this.mAnimatorHide.setInterpolator(new DecelerateInterpolator());
    this.mAnimatorShow.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        VehicleBannerBar.this.ensureCorrectVisibility();
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        VehicleBannerBar.this.ensureCorrectVisibility();
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        VehicleBannerBar.access$102(VehicleBannerBar.this, true);
        VehicleBannerBar.this.ensureCorrectVisibility();
      }
    });
    this.mAnimatorHide.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        VehicleBannerBar.this.ensureCorrectVisibility();
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        VehicleBannerBar.this.ensureCorrectVisibility();
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        VehicleBannerBar.access$102(VehicleBannerBar.this, false);
      }
    });
  }

  private void startHideAnimator()
  {
    this.mAnimatorHide.start();
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onBannerBarVisibilityChanged(8);
  }

  private void startShowAnimator()
  {
    this.mAnimatorShow.start();
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onBannerBarVisibilityChanged(0);
  }

  void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  int getBarHeight()
  {
    return getResources().getDimensionPixelSize(2131362020);
  }

  void hideWithoutAnimating()
  {
    this.mIsVisible = false;
    ensureCorrectVisibility();
  }

  boolean isVisible()
  {
    return this.mIsVisible;
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
    initAnimators();
  }

  void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  void update(Ping paramPing)
  {
    BannerStrings localBannerStrings = getBannerStrings(paramPing);
    if (localBannerStrings == null)
      if (this.mIsVisible)
      {
        cancelAnimators();
        startHideAnimator();
      }
    do
    {
      return;
      this.mTextViewTitle.setText(localBannerStrings.title);
      this.mTextViewDetail.setText(localBannerStrings.detail);
    }
    while (this.mIsVisible);
    cancelAnimators();
    startShowAnimator();
  }

  private static final class BannerStrings
  {
    final CharSequence detail;
    final CharSequence title;

    private BannerStrings(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
    {
      this.title = paramCharSequence1;
      this.detail = paramCharSequence2;
    }
  }

  public static abstract interface Listener
  {
    public abstract void onBannerBarVisibilityChanged(int paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleBannerBar
 * JD-Core Version:    0.6.2
 */