package com.ubercab.client.feature.trip;

import android.content.Context;
import android.util.AttributeSet;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.ui.RiderLinearLayout;
import com.ubercab.client.core.util.AndroidUtils;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.trip.address.MultiAddressView;
import com.ubercab.client.feature.trip.address.MultiAddressView.Listener;
import com.ubercab.library.app.UberActivity;

public class HeaderView extends RiderLinearLayout
{
  private final int mActionBarSize;

  @InjectView(2131427778)
  MultiAddressView mMultiAddressView;

  public HeaderView(Context paramContext)
  {
    this(paramContext, null);
  }

  public HeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public HeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ((UberActivity)paramContext).inject(this);
    this.mActionBarSize = AndroidUtils.getThemeAttributeDimensionSize(paramContext, 16843499);
  }

  public void addListener(Listener paramListener)
  {
    this.mMultiAddressView.addListener(paramListener);
  }

  public int getHeightForPadding()
  {
    if (this.mMultiAddressView.getVisibility() == 0)
      return this.mMultiAddressView.getHeightForPadding() + this.mActionBarSize;
    return this.mActionBarSize;
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode())
      return;
    ButterKnife.inject(this);
    Context localContext = getContext();
    this.mMultiAddressView.setPickupHintText(localContext.getString(2131558883));
    this.mMultiAddressView.setPickupLabel(localContext.getString(2131559002));
    this.mMultiAddressView.setDestinationLabel(localContext.getString(2131559051));
    this.mMultiAddressView.setDestinationHintText(localContext.getString(2131558805));
    this.mMultiAddressView.setDestinationSubtextText(localContext.getString(2131559030));
  }

  public void removeListener(Listener paramListener)
  {
    this.mMultiAddressView.removeListener(paramListener);
  }

  public void setPickupHintText(String paramString)
  {
    this.mMultiAddressView.setPickupHintText(paramString);
  }

  public void showDestinationError()
  {
    this.mMultiAddressView.showDestinationError();
  }

  public void updateUI(int paramInt, Ping paramPing, RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2, String paramString)
  {
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
      while (true)
      {
        boolean bool2 = PingUtils.hasVehicleView(paramPing, paramString);
        boolean bool3 = false;
        boolean bool4 = false;
        if (bool2)
        {
          VehicleView localVehicleView = paramPing.getCity().findVehicleView(paramString);
          bool3 = localVehicleView.isDestinationEnabled();
          bool4 = localVehicleView.isDestinationRequired();
        }
        this.mMultiAddressView.updateUI(paramInt, paramRiderLocation1, paramRiderLocation2, bool3, bool4);
        return;
        this.mMultiAddressView.setVisibility(0);
        continue;
        this.mMultiAddressView.setVisibility(0);
        continue;
        this.mMultiAddressView.setVisibility(0);
      }
    case 3:
    case 4:
      MultiAddressView localMultiAddressView2 = this.mMultiAddressView;
      boolean bool5 = PingUtils.isTripMaster(paramPing);
      int j = 0;
      if (bool5);
      while (true)
      {
        localMultiAddressView2.setVisibility(j);
        break;
        j = 8;
      }
    case 5:
    }
    MultiAddressView localMultiAddressView1 = this.mMultiAddressView;
    boolean bool1 = PingUtils.isTripMaster(paramPing);
    int i = 0;
    if (bool1);
    while (true)
    {
      localMultiAddressView1.setVisibility(i);
      break;
      i = 8;
    }
  }

  public static abstract interface Listener extends MultiAddressView.Listener
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.HeaderView
 * JD-Core Version:    0.6.2
 */