package com.ubercab.client.feature.trip.address;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.ubercab.client.core.location.RiderLocation;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MultiAddressView extends LinearLayout
  implements AddressView.OnClickAddListener, AddressView.OnClickClearListener
{
  private static final int ALPHA_GONE = 0;
  private static final int ALPHA_VISIBLE = 255;

  @InjectView(2131427893)
  AddressView mAddressViewDestination;

  @InjectView(2131427892)
  AddressView mAddressViewPickup;
  private int mAlphaBg = 0;
  private ValueAnimator mAnimatorFadeIn;
  private ValueAnimator mAnimatorFadeOut;
  private int mDurationDestinationSlide;
  private int mDurationPickupBgFade;
  private Integer mLastTripUIState;
  private List<Listener> mListeners = new CopyOnWriteArrayList();
  private Runnable mRunnableNotifyOnSlideEnd;

  public MultiAddressView(Context paramContext)
  {
    this(paramContext, null);
  }

  public MultiAddressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public MultiAddressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void hideBackground(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.mAnimatorFadeIn.cancel();
      this.mAnimatorFadeOut.cancel();
      getBackground().setAlpha(0);
      this.mAlphaBg = 0;
    }
    do
    {
      return;
      if (this.mAnimatorFadeIn.isRunning())
      {
        this.mAnimatorFadeIn.reverse();
        return;
      }
    }
    while (this.mAlphaBg <= 0);
    ValueAnimator localValueAnimator = this.mAnimatorFadeOut;
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.mAlphaBg;
    arrayOfInt[1] = 0;
    localValueAnimator.setIntValues(arrayOfInt);
    this.mAnimatorFadeOut.start();
  }

  private void notifyOnSlideEnd()
  {
    if (this.mAddressViewDestination.getTop() == 0)
      postDelayed(this.mRunnableNotifyOnSlideEnd, 50L);
    while (true)
    {
      return;
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
        ((Listener)localIterator.next()).onShowDestinationAddress(this.mAddressViewDestination.getTop());
    }
  }

  private void showBackground(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.mAnimatorFadeIn.cancel();
      this.mAnimatorFadeOut.cancel();
      getBackground().setAlpha(255);
      this.mAlphaBg = 255;
    }
    do
    {
      return;
      if (this.mAnimatorFadeOut.isRunning())
      {
        this.mAnimatorFadeOut.reverse();
        return;
      }
    }
    while (this.mAlphaBg >= 255);
    ValueAnimator localValueAnimator = this.mAnimatorFadeIn;
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.mAlphaBg;
    arrayOfInt[1] = 255;
    localValueAnimator.setIntValues(arrayOfInt);
    this.mAnimatorFadeIn.start();
  }

  private void showConfirmingState(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    hideBackground(paramBoolean2);
    this.mAddressViewPickup.setClickable(true);
    this.mAddressViewPickup.setVisibility(0);
    this.mAddressViewPickup.fadeIn(paramBoolean2);
    this.mAddressViewPickup.setLabelVisibility(8);
    this.mAddressViewPickup.showBackground(paramBoolean2);
    this.mAddressViewDestination.setEnabled(true);
    this.mAddressViewDestination.setTranslationY(0.0F);
    this.mAddressViewDestination.setLabelVisibility(8);
    if (!paramBoolean3)
    {
      this.mAddressViewPickup.setAddButtonVisibility(8);
      this.mAddressViewPickup.setIconMode(1);
      this.mAddressViewPickup.setBackgroundMode(0);
      this.mAddressViewDestination.setVisibility(8);
      return;
    }
    if (paramBoolean1)
    {
      this.mAddressViewPickup.setAddButtonVisibility(8);
      this.mAddressViewPickup.setIconMode(2);
      this.mAddressViewPickup.setBackgroundMode(1);
      this.mAddressViewDestination.setSubtextVisibility(8);
      this.mAddressViewDestination.setIconMode(2);
      this.mAddressViewDestination.setBackgroundMode(1);
      this.mAddressViewDestination.setClearButtonVisibility(0);
    }
    while ((paramBoolean4) || (paramBoolean1))
    {
      slideDownDestination(paramBoolean2);
      return;
      if (paramBoolean4)
      {
        this.mAddressViewPickup.setAddButtonVisibility(8);
        this.mAddressViewPickup.setIconMode(1);
        this.mAddressViewPickup.setBackgroundMode(1);
        this.mAddressViewDestination.setSubtextVisibility(0);
        this.mAddressViewDestination.setClearButtonVisibility(8);
        this.mAddressViewDestination.setIconMode(0);
        this.mAddressViewDestination.setBackgroundMode(1);
        this.mAddressViewDestination.setHintTextColor(getResources().getColor(2131296316));
      }
      else
      {
        this.mAddressViewPickup.setAddButtonVisibility(0);
        this.mAddressViewPickup.setIconMode(1);
        this.mAddressViewPickup.setBackgroundMode(0);
        this.mAddressViewDestination.setSubtextVisibility(8);
      }
    }
    this.mAddressViewDestination.setVisibility(8);
  }

  private void showLookingState(boolean paramBoolean)
  {
    hideBackground(paramBoolean);
    this.mAddressViewPickup.setClickable(true);
    this.mAddressViewPickup.setVisibility(0);
    this.mAddressViewPickup.fadeIn(paramBoolean);
    this.mAddressViewPickup.setLabelVisibility(0);
    this.mAddressViewPickup.setAddButtonVisibility(8);
    this.mAddressViewPickup.showBackground(paramBoolean);
    this.mAddressViewPickup.setIconMode(0);
    this.mAddressViewPickup.setBackgroundMode(0);
    this.mAddressViewDestination.setTranslationY(0.0F);
    this.mAddressViewDestination.setVisibility(8);
    this.mAddressViewDestination.setSubtextVisibility(8);
    this.mAddressViewPickup.invalidate();
    this.mAddressViewDestination.invalidate();
  }

  private void showOnTripState(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    hideBackground(paramBoolean2);
    this.mAddressViewPickup.setClickable(false);
    this.mAddressViewDestination.setLabelVisibility(8);
    this.mAddressViewDestination.setSubtextVisibility(8);
    AddressView localAddressView1 = this.mAddressViewDestination;
    boolean bool;
    int j;
    if (!paramBoolean4)
    {
      bool = true;
      localAddressView1.setEnabled(bool);
      this.mAddressViewDestination.setBackgroundMode(0);
      if (!paramBoolean1)
        break label182;
      this.mAddressViewDestination.setVisibility(0);
      this.mAddressViewDestination.setIconMode(1);
      AddressView localAddressView3 = this.mAddressViewDestination;
      if (!paramBoolean4)
        break label176;
      j = 8;
      label95: localAddressView3.setClearButtonVisibility(j);
    }
    while (true)
      if (paramBoolean2)
      {
        this.mAddressViewPickup.fadeOut(true);
        if (paramBoolean3)
        {
          this.mAddressViewDestination.animate().setDuration(this.mDurationDestinationSlide).setInterpolator(new DecelerateInterpolator()).translationY(-this.mAddressViewPickup.getHeight()).setListener(new AnimatorListenerAdapter()
          {
            public void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              MultiAddressView.this.mAddressViewPickup.setVisibility(8);
              MultiAddressView.this.mAddressViewDestination.setTranslationY(0.0F);
            }
          }).start();
          return;
          bool = false;
          break;
          label176: j = 0;
          break label95;
          label182: this.mAddressViewDestination.setClearButtonVisibility(8);
          this.mAddressViewDestination.setIconMode(0);
          if (paramBoolean3)
          {
            slideDownDestination(paramBoolean2);
            continue;
          }
          this.mAddressViewDestination.setVisibility(8);
          continue;
        }
        this.mAddressViewDestination.setVisibility(8);
        return;
      }
    this.mAddressViewPickup.setVisibility(8);
    this.mAddressViewDestination.setTranslationY(0.0F);
    AddressView localAddressView2 = this.mAddressViewDestination;
    int i = 0;
    if (paramBoolean3);
    while (true)
    {
      localAddressView2.setVisibility(i);
      return;
      i = 8;
    }
  }

  private void showPreTripState(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.mAddressViewPickup.setAddButtonVisibility(8);
    this.mAddressViewPickup.setClickable(false);
    this.mAddressViewPickup.setVisibility(0);
    this.mAddressViewPickup.setLabelVisibility(8);
    this.mAddressViewPickup.hideBackground(paramBoolean2);
    this.mAddressViewDestination.setLabelVisibility(8);
    this.mAddressViewDestination.setSubtextVisibility(8);
    AddressView localAddressView1 = this.mAddressViewDestination;
    if (!paramBoolean4);
    for (boolean bool = true; ; bool = false)
    {
      localAddressView1.setEnabled(bool);
      this.mAddressViewDestination.setBackgroundMode(0);
      if (!paramBoolean1)
        break;
      showBackground(paramBoolean2);
      this.mAddressViewPickup.setIconMode(2);
      this.mAddressViewDestination.setVisibility(0);
      this.mAddressViewDestination.setIconMode(2);
      AddressView localAddressView2 = this.mAddressViewDestination;
      int i = 0;
      if (paramBoolean4)
        i = 8;
      localAddressView2.setClearButtonVisibility(i);
      return;
    }
    this.mAddressViewPickup.setIconMode(1);
    this.mAddressViewDestination.setClearButtonVisibility(8);
    this.mAddressViewDestination.setIconMode(0);
    if (paramBoolean3)
    {
      showBackground(paramBoolean2);
      slideDownDestination(paramBoolean2);
      return;
    }
    hideBackground(paramBoolean2);
    this.mAddressViewPickup.fadeOut(paramBoolean2);
    this.mAddressViewPickup.setBackgroundMode(0);
    this.mAddressViewDestination.setVisibility(8);
  }

  private void slideDownDestination(boolean paramBoolean)
  {
    if (this.mAddressViewDestination.isShown())
    {
      notifyOnSlideEnd();
      return;
    }
    if (!paramBoolean)
    {
      this.mAddressViewDestination.setTranslationY(0.0F);
      this.mAddressViewDestination.setVisibility(0);
      notifyOnSlideEnd();
      return;
    }
    this.mAddressViewDestination.setAlpha(0.0F);
    this.mAddressViewDestination.setVisibility(0);
    this.mAddressViewDestination.setTranslationY(-this.mAddressViewPickup.getHeight());
    this.mAddressViewDestination.animate().alpha(1.0F).translationY(0.0F).setStartDelay(this.mDurationPickupBgFade).setDuration(this.mDurationDestinationSlide).setInterpolator(new DecelerateInterpolator()).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        MultiAddressView.this.notifyOnSlideEnd();
      }
    });
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  public int getHeightForPadding()
  {
    int i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.mAddressViewPickup.measure(i, j);
    int k = this.mAddressViewPickup.getMeasuredHeight() + getPaddingTop();
    if (this.mAddressViewDestination.isShown())
    {
      this.mAddressViewDestination.measure(i, j);
      k += this.mAddressViewDestination.getMeasuredHeight();
    }
    return k;
  }

  public void onClickAdd(AddressView paramAddressView)
  {
    if (paramAddressView.getId() == 2131427892)
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
        ((Listener)localIterator.next()).onClickAddDestinationAddress();
    }
  }

  @OnClick({2131427893})
  public void onClickAddressViewDestination()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onClickDestinationAddress();
  }

  @OnClick({2131427892})
  public void onClickAddressViewPickup()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onClickPickupAddress();
  }

  public void onClickClear(AddressView paramAddressView)
  {
    if (paramAddressView.getId() == 2131427893)
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
        ((Listener)localIterator.next()).onClickDestinationAddressClear();
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.mRunnableNotifyOnSlideEnd);
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
    this.mDurationPickupBgFade = getResources().getInteger(2131492872);
    this.mDurationDestinationSlide = getResources().getInteger(2131492871);
    this.mAddressViewPickup.addOnClickAddListener(this);
    this.mAddressViewPickup.setIconMode(2);
    this.mAddressViewPickup.setIconDotResource(2130837841);
    this.mAddressViewPickup.setHintTextColor(getResources().getColor(2131296316));
    this.mAddressViewPickup.setLabelTextColor(getResources().getColor(2131296321));
    this.mAddressViewPickup.setIconDotSplitResource(2130837842);
    this.mAddressViewPickup.setBackgroundSplitResource(2130837716);
    this.mAddressViewDestination.addOnClickClearListener(this);
    this.mAddressViewDestination.setClearButtonVisibility(0);
    this.mAddressViewDestination.setIconMode(2);
    this.mAddressViewDestination.setIconDotResource(2130837743);
    this.mAddressViewDestination.setLabelTextColor(getResources().getColor(2131296325));
    this.mAddressViewDestination.setIconDotSplitResource(2130837741);
    this.mAddressViewDestination.setHintTextColor(getResources().getColor(2131296328));
    this.mAddressViewDestination.setBackgroundSplitResource(2130837686);
    Drawable localDrawable = getBackground();
    localDrawable.setAlpha(this.mAlphaBg);
    this.mAnimatorFadeIn = ObjectAnimator.ofInt(localDrawable, "alpha", new int[] { 0, 255 });
    this.mAnimatorFadeIn.setDuration(this.mDurationPickupBgFade);
    this.mAnimatorFadeOut = ObjectAnimator.ofInt(localDrawable, "alpha", new int[] { 255, 0 });
    this.mAnimatorFadeOut.setDuration(this.mDurationPickupBgFade);
    this.mAnimatorFadeIn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        MultiAddressView.access$002(MultiAddressView.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
      }
    });
    this.mAnimatorFadeOut.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        MultiAddressView.access$002(MultiAddressView.this, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
      }
    });
    this.mRunnableNotifyOnSlideEnd = new Runnable()
    {
      public void run()
      {
        MultiAddressView.this.notifyOnSlideEnd();
      }
    };
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  public void setDestinationHintText(String paramString)
  {
    this.mAddressViewDestination.setHintText(paramString);
  }

  public void setDestinationLabel(String paramString)
  {
    this.mAddressViewDestination.setLabelText(paramString);
  }

  public void setDestinationSubtextText(String paramString)
  {
    this.mAddressViewDestination.setSubtextText(paramString);
  }

  public void setPickupHintText(String paramString)
  {
    this.mAddressViewPickup.setHintText(paramString);
  }

  public void setPickupLabel(String paramString)
  {
    this.mAddressViewPickup.setLabelText(paramString);
  }

  public void showDestinationError()
  {
    this.mAddressViewDestination.showError();
  }

  public void updateUI(int paramInt, RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    boolean bool1;
    label14: boolean bool2;
    boolean bool3;
    if (paramRiderLocation1 != null)
    {
      i = 1;
      if (paramRiderLocation2 == null)
        break label82;
      bool1 = true;
      bool2 = this.mAddressViewPickup.locationEquals(paramRiderLocation1);
      bool3 = this.mAddressViewDestination.locationEquals(paramRiderLocation2);
      if ((this.mLastTripUIState == null) || (this.mLastTripUIState.intValue() == paramInt))
        break label88;
    }
    label82: label88: for (boolean bool4 = true; ; bool4 = false)
    {
      if ((bool4) || (i == 0) || (!bool2) || (!bool3))
        break label94;
      return;
      i = 0;
      break;
      bool1 = false;
      break label14;
    }
    label94: switch (paramInt)
    {
    default:
    case -1:
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      this.mAddressViewPickup.setLocation(paramRiderLocation1);
      this.mAddressViewDestination.setLocation(paramRiderLocation2);
      this.mLastTripUIState = Integer.valueOf(paramInt);
      return;
      showLookingState(bool4);
      continue;
      showConfirmingState(bool1, bool4, paramBoolean1, paramBoolean2);
      continue;
      showPreTripState(bool1, bool4, paramBoolean1, paramBoolean2);
      continue;
      showOnTripState(bool1, bool4, paramBoolean1, paramBoolean2);
    }
  }

  public static abstract interface Listener
  {
    public abstract void onClickAddDestinationAddress();

    public abstract void onClickDestinationAddress();

    public abstract void onClickDestinationAddressClear();

    public abstract void onClickPickupAddress();

    public abstract void onShowDestinationAddress(int paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.address.MultiAddressView
 * JD-Core Version:    0.6.2
 */