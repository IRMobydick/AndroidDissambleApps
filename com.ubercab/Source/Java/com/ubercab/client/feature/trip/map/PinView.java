package com.ubercab.client.feature.trip.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.NearbyVehicle;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.ui.UberTextView;
import java.util.Map;

public class PinView extends FrameLayout
{
  private int mAnimationTime;
  private int mPaddingBottom;
  private boolean mPaddingSet;
  private int mPaddingTop;
  private Integer mPendingVisibility;

  @InjectView(2131427898)
  UberTextView mTextViewEtaLabel;

  @InjectView(2131427897)
  UberTextView mTextViewEtaNumber;

  @InjectView(2131427899)
  UberTextView mTextViewPickup;

  @InjectView(2131427896)
  ViewGroup mViewGroupEta;

  @InjectView(2131427894)
  ViewGroup mViewGroupPin;

  @InjectView(2131427895)
  View mViewPinButton;

  public PinView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PinView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PinView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
      return;
    this.mAnimationTime = getResources().getInteger(2131492872);
  }

  private void applyPendingVisibility()
  {
    if ((this.mPendingVisibility == null) || (!this.mPaddingSet))
      return;
    if (this.mPendingVisibility.intValue() == 0)
      this.mViewGroupPin.animate().alpha(1.0F).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          PinView.this.mViewGroupPin.setVisibility(0);
        }
      }).start();
    while (true)
    {
      this.mPendingVisibility = null;
      return;
      this.mViewGroupPin.animate().alpha(0.0F).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          PinView.this.mViewGroupPin.setVisibility(8);
        }
      }).start();
    }
  }

  private void hideSetPickupButton()
  {
    this.mViewPinButton.animate().alpha(0.0F).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        PinView.this.mViewPinButton.setClickable(false);
      }
    }).start();
  }

  private void setLookingPinButtonUI(Ping paramPing, String paramString)
  {
    VehicleView localVehicleView = paramPing.getCity().findVehicleView(paramString);
    Map localMap = paramPing.getNearbyVehicles();
    Context localContext = getContext();
    if ((localVehicleView != null) && (localMap.containsKey(localVehicleView.getId())))
    {
      NearbyVehicle localNearbyVehicle = (NearbyVehicle)localMap.get(localVehicleView.getId());
      if ((localNearbyVehicle.getVehiclePaths() != null) && (!localNearbyVehicle.getVehiclePaths().isEmpty()) && (!TextUtils.isEmpty(localNearbyVehicle.getEtaStringShort())))
      {
        String str1 = localNearbyVehicle.getEtaStringShort();
        String str2 = str1.substring(0, str1.indexOf(" "));
        this.mTextViewEtaNumber.setText(str2);
        this.mTextViewEtaLabel.setText(localContext.getString(2131558927).toUpperCase());
        this.mViewGroupEta.setVisibility(0);
        String str3 = localVehicleView.getSetPickupLocationString();
        if (TextUtils.isEmpty(str3))
          str3 = localContext.getString(2131559052).toUpperCase();
        this.mTextViewPickup.setText(str3);
        return;
      }
      this.mViewGroupEta.setVisibility(8);
      this.mTextViewPickup.setText(localVehicleView.getNoneAvailableString());
      return;
    }
    this.mViewGroupEta.setVisibility(8);
    this.mTextViewPickup.setText(localContext.getString(2131559052).toUpperCase());
  }

  private void showSetPickupButton()
  {
    this.mViewPinButton.animate().alpha(1.0F).setListener(new AnimatorListenerAdapter()
    {
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        PinView.this.mViewPinButton.setClickable(true);
      }
    }).start();
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
  }

  public void setPadding(int paramInt1, int paramInt2)
  {
    this.mPaddingSet = true;
    if ((this.mPaddingTop == paramInt1) && (this.mPaddingBottom == paramInt2))
      return;
    this.mPaddingTop = paramInt1;
    this.mPaddingBottom = paramInt2;
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.mViewGroupPin.measure(i, i);
    int j = getHeight() - this.mPaddingTop - this.mPaddingBottom;
    float f = this.mPaddingTop + j / 2.0F - this.mViewGroupPin.getMeasuredHeight();
    if (this.mViewGroupPin.getVisibility() == 0)
      this.mViewGroupPin.animate().translationY(f).setInterpolator(new DecelerateInterpolator()).setDuration(this.mAnimationTime).start();
    while (true)
    {
      applyPendingVisibility();
      return;
      this.mViewGroupPin.setTranslationY(f);
    }
  }

  public void updateUI(int paramInt, Ping paramPing, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!paramBoolean1)
    {
      this.mPendingVisibility = Integer.valueOf(8);
      applyPendingVisibility();
      return;
    }
    switch (paramInt)
    {
    default:
      this.mPendingVisibility = Integer.valueOf(8);
      applyPendingVisibility();
      return;
    case 0:
      setLookingPinButtonUI(paramPing, paramString);
      showSetPickupButton();
      this.mPendingVisibility = Integer.valueOf(0);
      applyPendingVisibility();
      return;
    case 1:
    }
    if ((paramBoolean3) && (paramBoolean2));
    for (this.mPendingVisibility = Integer.valueOf(8); ; this.mPendingVisibility = Integer.valueOf(0))
    {
      applyPendingVisibility();
      return;
      hideSetPickupButton();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.map.PinView
 * JD-Core Version:    0.6.2
 */