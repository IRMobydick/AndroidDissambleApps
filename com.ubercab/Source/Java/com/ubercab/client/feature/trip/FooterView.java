package com.ubercab.client.feature.trip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.model.AppConfig;
import com.ubercab.client.core.model.Capabilities;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.RewardInfo;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripDriver;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.music.MusicTrayView;
import com.ubercab.client.feature.payment.expense.ExpenseLinkResource;
import com.ubercab.client.feature.payment.expense.ExpenseLinkResources;
import com.ubercab.client.feature.trip.confirm.ConfirmationView;
import com.ubercab.client.feature.trip.confirm.ConfirmationView.Listener;
import com.ubercab.client.feature.trip.dispatch.CancelView;
import com.ubercab.client.feature.trip.dispatch.CancelView.Listener;
import com.ubercab.client.feature.trip.driver.DriverView;
import com.ubercab.client.feature.trip.driver.DriverView.Listener;
import com.ubercab.client.feature.trip.slider.VehicleSlider;
import com.ubercab.client.feature.trip.slider.VehicleSlider.Listener;
import com.ubercab.library.app.UberActivity;
import java.util.List;
import javax.inject.Inject;

public class FooterView extends FrameLayout
{

  @Inject
  ExpenseLinkResources mExpenseLinkResources;

  @Inject
  PingProvider mPingProvider;

  @Inject
  SessionPreferences mSessionPreferences;

  @InjectView(2131427780)
  CancelView mViewCancel;

  @InjectView(2131427781)
  ConfirmationView mViewConfirmation;

  @InjectView(2131427783)
  DriverView mViewDriver;

  @InjectView(2131427782)
  MusicTrayView mViewMusicTray;

  @InjectView(2131427785)
  VehicleSlider mViewVehicleSlider;

  public FooterView(Context paramContext)
  {
    this(paramContext, null);
  }

  public FooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ((UberActivity)paramContext).inject(this);
  }

  public void addListener(Listener paramListener)
  {
    this.mViewDriver.addListener(paramListener);
    this.mViewConfirmation.addListener(paramListener);
    this.mViewVehicleSlider.addListener(paramListener);
    this.mViewCancel.addListener(paramListener);
  }

  public int getHeightForModal()
  {
    return this.mViewVehicleSlider.getHeightForModal();
  }

  public int getHeightForMyLocation()
  {
    int i;
    if (this.mViewVehicleSlider.getVisibility() == 0)
      i = this.mViewVehicleSlider.getMaxHeight();
    do
    {
      return i;
      if (this.mViewConfirmation.getVisibility() == 0)
        return this.mViewConfirmation.getHeight();
      if (this.mViewDriver.getVisibility() != 0)
        break;
      i = this.mViewDriver.getHeight();
    }
    while (this.mViewMusicTray.getVisibility() != 0);
    return i + this.mViewMusicTray.getHeight();
    return 0;
  }

  public int getHeightForPadding()
  {
    return getMinHeight();
  }

  public int getMaxHeight()
  {
    if (this.mViewConfirmation.getVisibility() == 0)
      return this.mViewConfirmation.getHeight();
    if (this.mViewDriver.getVisibility() == 0)
      return this.mViewDriver.getHeight();
    if (this.mViewVehicleSlider.getVisibility() == 0)
      return this.mViewVehicleSlider.getMaxHeight();
    return 0;
  }

  public int getMinHeight()
  {
    int i = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    int m;
    if (this.mViewConfirmation.getVisibility() == 0)
    {
      this.mViewConfirmation.measure(i, j);
      m = this.mViewConfirmation.getMeasuredHeight();
    }
    int k;
    do
    {
      return m;
      if (this.mViewDriver.getVisibility() == 0)
      {
        this.mViewDriver.measure(i, j);
        return this.mViewDriver.getMeasuredHeight();
      }
      k = this.mViewVehicleSlider.getVisibility();
      m = 0;
    }
    while (k != 0);
    return this.mViewVehicleSlider.getMinHeight();
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
  }

  public void removeListener(Listener paramListener)
  {
    this.mViewDriver.removeListener(paramListener);
    this.mViewConfirmation.removeListener(paramListener);
    this.mViewVehicleSlider.removeListener(paramListener);
    this.mViewCancel.removeListener(paramListener);
  }

  public void updateUI(int paramInt, Ping paramPing, String paramString, PaymentProfile paramPaymentProfile, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    VehicleView localVehicleView = paramPing.getCity().findVehicleView(paramString);
    if ((paramInt == 1) && (localVehicleView == null))
      paramInt = 0;
    this.mViewDriver.update(paramPing);
    switch (paramInt)
    {
    default:
      this.mViewCancel.setVisibility(8);
      this.mViewConfirmation.setVisibility(8);
      this.mViewVehicleSlider.setVisibility(8);
      this.mViewDriver.setVisibility(8);
      this.mViewMusicTray.setVisibility(8);
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    label360: 
    do
    {
      return;
      this.mViewCancel.setVisibility(8);
      this.mViewDriver.setVisibility(8);
      this.mViewMusicTray.setVisibility(8);
      this.mViewConfirmation.setVisibility(8);
      if ((PingUtils.hasNonEmptyVehicleViews(paramPing)) && (paramBoolean4))
      {
        this.mViewVehicleSlider.update(paramPing);
        this.mViewVehicleSlider.setSelectedVehicleViewId(paramString);
        this.mViewVehicleSlider.setVisibility(0);
        return;
      }
      this.mViewVehicleSlider.setVisibility(8);
      return;
      this.mViewCancel.setVisibility(8);
      this.mViewDriver.setVisibility(8);
      this.mViewMusicTray.setVisibility(8);
      this.mViewVehicleSlider.setVisibility(8);
      this.mViewConfirmation.setVisibility(0);
      this.mViewConfirmation.updateRequestUberButton(localVehicleView);
      this.mViewConfirmation.updateClosestVehicleEta(paramPing, localVehicleView);
      boolean bool7 = PingUtils.hasExperimentSerial(this.mPingProvider.get(), "amex_rewards", 1);
      boolean bool8 = false;
      if (bool7)
      {
        bool8 = false;
        if (paramPaymentProfile != null)
        {
          RewardInfo localRewardInfo = paramPaymentProfile.getRewardInfo();
          if ((localRewardInfo == null) || (!localRewardInfo.isEnrolled()) || (localRewardInfo.isEarnOnly()) || (localRewardInfo.usePointsDisabled()))
            break label441;
          bool8 = true;
          if (bool8)
            this.mViewConfirmation.setIsUsingPoints(paramBoolean1, paramPaymentProfile);
        }
      }
      ConfirmationView localConfirmationView1 = this.mViewConfirmation;
      boolean bool9;
      ConfirmationView localConfirmationView2;
      if (!paramBoolean6)
      {
        bool9 = true;
        localConfirmationView1.updateUI(bool9, bool8, localVehicleView);
        List localList = paramPing.getClient().getPaymentProfiles();
        this.mViewConfirmation.setPaymentProfile(paramPaymentProfile, localList);
        localConfirmationView2 = this.mViewConfirmation;
        if (paramPing.findCreditBalanceForCity() == null)
          break label453;
      }
      for (boolean bool10 = true; ; bool10 = false)
      {
        localConfirmationView2.setIsUsingCredits(paramBoolean2, bool10);
        ExpenseLinkResource localExpenseLinkResource = this.mExpenseLinkResources.getResource(paramPing.getExpenseLinkType());
        this.mViewConfirmation.setIsSendExpense(paramBoolean3, localExpenseLinkResource);
        return;
        bool8 = false;
        break;
        bool9 = false;
        break label360;
      }
      boolean bool5 = this.mSessionPreferences.isDestinationTutorialDismissed();
      boolean bool6 = PingUtils.hasExperimentSerial(paramPing, "destination_not_set_highlight", 1);
      if ((!paramBoolean5) && (bool6) && (bool5))
        bringToFront();
      this.mViewCancel.setVisibility(0);
      this.mViewDriver.setVisibility(8);
      this.mViewMusicTray.setVisibility(8);
      this.mViewVehicleSlider.setVisibility(8);
      this.mViewConfirmation.setVisibility(8);
      return;
      this.mViewCancel.setVisibility(8);
      this.mViewConfirmation.setVisibility(8);
      this.mViewVehicleSlider.setVisibility(8);
      this.mViewDriver.setVisibility(0);
    }
    while (!PingUtils.hasTripDriver(paramPing));
    label441: label453: Capabilities localCapabilities = paramPing.getTrip().getDriver().getCapabilities();
    if ((localCapabilities != null) && (localCapabilities.isMusicEnabled()))
    {
      boolean bool1 = PingUtils.hasClient(paramPing);
      boolean bool2 = false;
      if (bool1)
        bool2 = paramPing.getClient().isAdmin();
      boolean bool3 = PingUtils.hasAppConfig(paramPing);
      boolean bool4 = false;
      if (bool3)
        bool4 = paramPing.getAppConfig().getMusicTrayEnabled();
      if ((bool2) || (bool4))
      {
        this.mViewMusicTray.update(paramPing);
        this.mViewMusicTray.setVisibility(0);
        return;
      }
      this.mViewMusicTray.setVisibility(8);
      return;
    }
    this.mViewMusicTray.setVisibility(8);
  }

  public static abstract interface Listener extends DriverView.Listener, VehicleSlider.Listener, ConfirmationView.Listener, CancelView.Listener
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.FooterView
 * JD-Core Version:    0.6.2
 */