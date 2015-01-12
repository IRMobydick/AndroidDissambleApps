package com.ubercab.client.feature.estimate;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.feature.trip.address.AddressView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FareEstimateMultiAddressView extends LinearLayout
{

  @InjectView(2131427450)
  AddressView mAddressViewDestination;

  @InjectView(2131427449)
  AddressView mAddressViewPickup;
  private List<Listener> mListeners = new CopyOnWriteArrayList();

  public FareEstimateMultiAddressView(Context paramContext)
  {
    this(paramContext, null);
  }

  public FareEstimateMultiAddressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FareEstimateMultiAddressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  @OnClick({2131427450})
  public void onClickAddressViewDestination()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onClickDestinationAddress();
  }

  @OnClick({2131427449})
  public void onClickAddressViewPickup()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onClickPickupAddress();
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    if (isInEditMode())
      return;
    ButterKnife.inject(this);
    this.mAddressViewPickup.setIconDotSplitResource(2130837842);
    this.mAddressViewPickup.setBackgroundSplitResource(2130837716);
    this.mAddressViewPickup.setIconMode(2);
    this.mAddressViewPickup.setBackgroundMode(1);
    this.mAddressViewDestination.setIconDotSplitResource(2130837741);
    this.mAddressViewDestination.setBackgroundSplitResource(2130837686);
    this.mAddressViewDestination.setIconMode(2);
    this.mAddressViewDestination.setBackgroundMode(1);
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  public void setDestinationLabel(String paramString)
  {
    this.mAddressViewDestination.setLabelText(paramString);
  }

  public void setPickupHintText(String paramString)
  {
    this.mAddressViewPickup.setHintText(paramString);
  }

  public void setPickupLabel(String paramString)
  {
    this.mAddressViewPickup.setLabelText(paramString);
  }

  public void update(RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2)
  {
    this.mAddressViewPickup.setLocation(paramRiderLocation1);
    this.mAddressViewDestination.setLocation(paramRiderLocation2);
  }

  public static abstract interface Listener
  {
    public abstract void onClickDestinationAddress();

    public abstract void onClickPickupAddress();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.estimate.FareEstimateMultiAddressView
 * JD-Core Version:    0.6.2
 */