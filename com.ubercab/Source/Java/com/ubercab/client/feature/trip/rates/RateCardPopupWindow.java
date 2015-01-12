package com.ubercab.client.feature.trip.rates;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.InjectView;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.Fare;
import com.ubercab.client.feature.trip.event.FooterSizeChangedEvent;
import com.ubercab.client.feature.trip.event.VehicleViewSelectedEvent;

public class RateCardPopupWindow extends BaseRateCardPopupWindow
{

  @InjectView(2131427809)
  TextView mTextViewAndOr;

  @InjectView(2131427806)
  TextView mTextViewBaseFare;

  @InjectView(2131427807)
  TextView mTextViewBaseFareSeparator;

  @InjectView(2131427805)
  TextView mTextViewMinFareSubtitle;

  @InjectView(2131427810)
  TextView mTextViewPerDistance;

  @InjectView(2131427808)
  TextView mTextViewPerMinute;

  @InjectView(2131427812)
  TextView mTextViewSafeRide;

  @InjectView(2131427816)
  TextView mTextViewSurgeSubtext;

  @InjectView(2131427811)
  ViewGroup mViewGroupSafeRide;

  @InjectView(2131427813)
  ViewGroup mViewGroupVehicleDetails;

  public RateCardPopupWindow(Activity paramActivity, String paramString, RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2, int paramInt, boolean paramBoolean)
  {
    super(paramActivity, paramString, paramRiderLocation1, paramRiderLocation2, paramInt, paramBoolean);
  }

  View getView(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2130903198, null, false);
  }

  protected void hideAddressView()
  {
  }

  void hideFareEstimateView()
  {
  }

  boolean includesFareEstimate()
  {
    return false;
  }

  void initView()
  {
    super.initView();
    if (this.mIsMinViewEnabled)
      this.mViewGroupVehicleDetails.setVisibility(8);
  }

  @Subscribe
  public void onFooterSizeChangedEvent(FooterSizeChangedEvent paramFooterSizeChangedEvent)
  {
    if (this.mIsMinViewEnabled)
      return;
    super.onFooterSizeChangedEvent(paramFooterSizeChangedEvent);
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    super.onPingEvent(paramPingEvent);
  }

  @Subscribe
  public void onVehicleViewEvent(VehicleViewSelectedEvent paramVehicleViewSelectedEvent)
  {
    if (this.mIsMinViewEnabled)
      return;
    super.onVehicleViewEvent(paramVehicleViewSelectedEvent);
  }

  protected void showAddressView()
  {
  }

  void showFareEstimateFailureState()
  {
  }

  void showFareEstimatePendingState()
  {
  }

  void showFareEstimateSuccessState(String paramString)
  {
  }

  void updateFareInfo(Fare paramFare, float paramFloat, String paramString1, String paramString2)
  {
    boolean bool = "TimeAndDistance".equals(paramString1);
    TextView localTextView1 = this.mTextViewAndOr;
    String str1;
    if (bool)
    {
      str1 = this.mResources.getString(2131558447);
      localTextView1.setText(str1);
      if (TextUtils.isEmpty(paramFare.getSafeRidesFee()))
        break label361;
      TextView localTextView6 = this.mTextViewSafeRide;
      Resources localResources = this.mResources;
      Object[] arrayOfObject6 = new Object[1];
      arrayOfObject6[0] = paramFare.getSafeRidesFee();
      localTextView6.setText(localResources.getString(2131559041, arrayOfObject6));
      this.mViewGroupSafeRide.setVisibility(0);
      label95: if (paramFloat <= 1.0F)
        break label373;
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = Float.valueOf(paramFloat);
      String str2 = String.format("%sx", arrayOfObject5);
      String str3 = this.mResources.getString(2131559100, new Object[] { str2 });
      this.mTextViewSurgeSubtext.setText(str3);
      this.mTextViewSurgeSubtext.setVisibility(0);
      label161: if (TextUtils.isEmpty(paramFare.getBase()))
        break label385;
      TextView localTextView5 = this.mTextViewBaseFare;
      Object[] arrayOfObject4 = new Object[2];
      arrayOfObject4[0] = paramFare.getBase();
      arrayOfObject4[1] = this.mResources.getString(2131558462);
      localTextView5.setText(String.format("%s %s", arrayOfObject4));
    }
    while (true)
    {
      TextView localTextView2 = this.mTextViewPerMinute;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramFare.getPerMinute();
      arrayOfObject1[1] = this.mResources.getString(2131558927);
      localTextView2.setText(String.format("%s / %s", arrayOfObject1));
      TextView localTextView3 = this.mTextViewPerDistance;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = paramFare.getPerDistanceUnit();
      arrayOfObject2[1] = paramFare.getDistanceUnit();
      localTextView3.setText(String.format("%s / %s", arrayOfObject2));
      TextView localTextView4 = this.mTextViewMinFareSubtitle;
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = paramFare.getMinimum();
      arrayOfObject3[1] = this.mResources.getString(2131558930);
      localTextView4.setText(String.format("%s %s", arrayOfObject3));
      return;
      str1 = this.mResources.getString(2131558979);
      break;
      label361: this.mViewGroupSafeRide.setVisibility(8);
      break label95;
      label373: this.mTextViewSurgeSubtext.setVisibility(8);
      break label161;
      label385: this.mTextViewBaseFare.setVisibility(8);
      this.mTextViewBaseFareSeparator.setVisibility(8);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.rates.RateCardPopupWindow
 * JD-Core Version:    0.6.2
 */