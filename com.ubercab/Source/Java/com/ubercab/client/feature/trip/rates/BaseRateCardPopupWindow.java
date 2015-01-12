package com.ubercab.client.feature.trip.rates;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.TripEvent;
import com.ubercab.client.core.app.RiderPopupWindow;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Fare;
import com.ubercab.client.core.model.NearbyVehicle;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Surge;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.trip.event.FooterSizeChangedEvent;
import com.ubercab.client.feature.trip.event.MultiFareEstimateEvent;
import com.ubercab.client.feature.trip.event.VehicleViewSelectedEvent;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;

public abstract class BaseRateCardPopupWindow extends RiderPopupWindow
{
  private static final String DEFAULT_FARE_DETAILS_URL = "https://www.uber.com";
  private WeakReference<Activity> mActivity;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  AnalyticsManager mAnalyticsManager;
  private ValueAnimator mAnimatorDown;
  private ValueAnimator mAnimatorUp;
  RiderLocation mDestination;
  private int mFareEstimateEventState;
  private Map<String, String> mFareEstimates;
  boolean mIsMinViewEnabled;
  private List<Listener> mListeners = new CopyOnWriteArrayList();
  RiderLocation mPickup;

  @Inject
  PingProvider mPingProvider;
  Resources mResources;

  @InjectView(2131427814)
  TextView mTextViewEta;

  @InjectView(2131427821)
  TextView mTextViewMessage;

  @InjectView(2131427815)
  TextView mTextViewPassengers;

  @InjectView(2131427825)
  TextView mTextViewSurgeSubtitle;

  @InjectView(2131427824)
  TextView mTextViewSurgeTitle;

  @InjectView(2131427822)
  TextView mTextViewUrl;
  private String mVehicleViewId;

  @InjectView(2131427803)
  ViewGroup mViewGroupContent;

  @InjectView(2131427817)
  ViewGroup mViewGroupMessage;

  @InjectView(2131427804)
  ViewGroup mViewGroupSurgeHeader;
  private int mWindowHeight;

  public BaseRateCardPopupWindow(Activity paramActivity, String paramString, RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2, int paramInt)
  {
    this(paramActivity, paramString, paramRiderLocation1, paramRiderLocation2, paramInt, false);
  }

  public BaseRateCardPopupWindow(Activity paramActivity, String paramString, RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2, int paramInt, boolean paramBoolean)
  {
    super(paramActivity);
    this.mActivity = new WeakReference(paramActivity);
    this.mResources = paramActivity.getResources();
    this.mVehicleViewId = paramString;
    this.mPickup = paramRiderLocation1;
    this.mDestination = paramRiderLocation2;
    this.mIsMinViewEnabled = paramBoolean;
    initView();
    setBackgroundDrawable(new ColorDrawable(this.mResources.getColor(2131296318)));
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    this.mWindowHeight = localRect.height();
    setWidth(localRect.width());
    setHeight(this.mWindowHeight - paramInt);
    this.mAnalyticsManager.tripEvent().rateCardViewOn(paramString);
  }

  public static BaseRateCardPopupWindow getInstance(Activity paramActivity, String paramString1, RiderLocation paramRiderLocation1, RiderLocation paramRiderLocation2, int paramInt, String paramString2)
  {
    if ((paramString2.equals("rateCardVariant1NewConfirmation")) || (paramString2.equals("rateCardVariant1OldConfirmation")))
      return new RateCardV1PopupWindow(paramActivity, paramString1, paramRiderLocation1, paramRiderLocation2, paramInt);
    if ((paramString2.equals("rateCardVariant2OldConfirmation")) || (paramString2.equals("rateCardVariant2NewConfirmation")))
      return new RateCardV2PopupWindow(paramActivity, paramString1, paramRiderLocation1, paramRiderLocation2, paramInt);
    return new RateCardPopupWindow(paramActivity, paramString1, paramRiderLocation1, paramRiderLocation2, paramInt, false);
  }

  private void initAnimators(int paramInt1, int paramInt2)
  {
    if (this.mAnimatorUp == null)
    {
      this.mAnimatorUp = ObjectAnimator.ofInt(this, "layoutHeight", new int[] { paramInt2, paramInt1 });
      this.mAnimatorUp.setInterpolator(new DecelerateInterpolator());
      this.mAnimatorUp.setDuration(this.mResources.getInteger(2131492872));
    }
    while (this.mAnimatorDown == null)
    {
      this.mAnimatorDown = ObjectAnimator.ofInt(this, "layoutHeight", new int[] { paramInt1, paramInt2 });
      this.mAnimatorDown.setInterpolator(new DecelerateInterpolator());
      this.mAnimatorDown.setDuration(this.mResources.getInteger(2131492872));
      return;
      this.mAnimatorUp.setIntValues(new int[] { paramInt2, paramInt1 });
    }
    this.mAnimatorDown.setIntValues(new int[] { paramInt1, paramInt2 });
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  public void dismiss()
  {
    super.dismiss();
    this.mAnalyticsManager.tripEvent().rateCardViewOff(this.mVehicleViewId);
  }

  void displayFareEstimateView(String paramString)
  {
    switch (this.mFareEstimateEventState)
    {
    default:
      return;
    case 1:
      if (!TextUtils.isEmpty(paramString))
      {
        showFareEstimateSuccessState(paramString);
        return;
      }
      showFareEstimatePendingState();
      return;
    case 2:
      showFareEstimateFailureState();
      return;
    case 0:
    }
    showFareEstimatePendingState();
  }

  protected String getVehicleViewId()
  {
    return this.mVehicleViewId;
  }

  abstract View getView(Context paramContext);

  protected abstract void hideAddressView();

  abstract void hideFareEstimateView();

  boolean includesFareEstimate()
  {
    return true;
  }

  void initView()
  {
    Context localContext = (Context)this.mActivity.get();
    if (localContext == null)
      return;
    View localView = getView(localContext);
    ButterKnife.inject(this, localView);
    setContentView(localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        BaseRateCardPopupWindow.this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PRODUCTDETAIL_DISMISS_MAP);
        BaseRateCardPopupWindow.this.dismiss();
      }
    });
    this.mViewGroupMessage.setClickable(true);
    this.mViewGroupContent.setClickable(true);
  }

  @Subscribe
  public void onFooterSizeChangedEvent(FooterSizeChangedEvent paramFooterSizeChangedEvent)
  {
    initAnimators(this.mWindowHeight - paramFooterSizeChangedEvent.getMaxFooterHeight(), this.mWindowHeight - paramFooterSizeChangedEvent.getMinFooterHeight());
    if (this.mAnimatorUp.isStarted())
      this.mAnimatorUp.cancel();
    if (this.mAnimatorDown.isStarted())
      this.mAnimatorDown.cancel();
    if (paramFooterSizeChangedEvent.isOptionsBarVisible())
    {
      this.mAnimatorUp.start();
      return;
    }
    this.mAnimatorDown.start();
  }

  @Subscribe
  public void onMultiFareEstimateEvent(MultiFareEstimateEvent paramMultiFareEstimateEvent)
  {
    this.mFareEstimateEventState = paramMultiFareEstimateEvent.getState();
    this.mFareEstimates = paramMultiFareEstimateEvent.getFareEstimates();
    updateFareEstimate();
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    updateUI(paramPingEvent.getPing());
  }

  @Subscribe
  public void onVehicleViewEvent(VehicleViewSelectedEvent paramVehicleViewSelectedEvent)
  {
    setVehicleViewId(paramVehicleViewSelectedEvent.getVehicleViewId());
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  public void setDestinationLocation(RiderLocation paramRiderLocation)
  {
    this.mDestination = paramRiderLocation;
    updateUI(this.mPingProvider.get());
  }

  public void setLayoutHeight(int paramInt)
  {
    FrameLayout localFrameLayout = (FrameLayout)getContentView().getParent();
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)localFrameLayout.getLayoutParams();
    localLayoutParams.height = paramInt;
    Activity localActivity = (Activity)this.mActivity.get();
    if (localActivity != null)
      localActivity.getWindowManager().updateViewLayout(localFrameLayout, localLayoutParams);
  }

  public void setPickupLocation(RiderLocation paramRiderLocation)
  {
    this.mPickup = paramRiderLocation;
    updateUI(this.mPingProvider.get());
  }

  public void setVehicleViewId(String paramString)
  {
    this.mVehicleViewId = paramString;
    updateUI(this.mPingProvider.get());
  }

  protected abstract void showAddressView();

  abstract void showFareEstimateFailureState();

  abstract void showFareEstimatePendingState();

  abstract void showFareEstimateSuccessState(String paramString);

  protected void triggerDestinationSelection()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onClickRateCardDestinationAddress();
  }

  protected void triggerPickupSelection()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((Listener)localIterator.next()).onClickRateCardPickupAddress();
  }

  void updateFareEstimate()
  {
    int i = 1;
    if (!includesFareEstimate())
      return;
    int j;
    if (this.mDestination != null)
    {
      j = i;
      if (j == 0)
        break label84;
      if ((this.mFareEstimates == null) || (this.mFareEstimates.isEmpty()))
        break label74;
      label42: if (i == 0)
        break label79;
    }
    label74: label79: for (String str = (String)this.mFareEstimates.get(this.mVehicleViewId); ; str = null)
    {
      displayFareEstimateView(str);
      return;
      j = 0;
      break;
      i = 0;
      break label42;
    }
    label84: hideFareEstimateView();
  }

  void updateFareInfo(Fare paramFare, float paramFloat, String paramString1, String paramString2)
  {
  }

  void updateUI(Ping paramPing)
  {
    if (!PingUtils.hasFare(paramPing, this.mVehicleViewId))
    {
      dismiss();
      return;
    }
    VehicleView localVehicleView = paramPing.getCity().findVehicleView(this.mVehicleViewId);
    String str1 = localVehicleView.getFareMessage();
    String str2 = localVehicleView.getFareDetailsUrl();
    if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2)));
    for (int i = 1; i != 0; i = 0)
    {
      this.mTextViewMessage.setText(str1);
      if (TextUtils.isEmpty(str2))
        str2 = "https://www.uber.com";
      this.mTextViewUrl.setText(str2);
      Linkify.addLinks(this.mTextViewUrl, 1);
      this.mViewGroupContent.setVisibility(8);
      this.mViewGroupMessage.setVisibility(0);
      return;
    }
    this.mViewGroupMessage.setVisibility(8);
    this.mViewGroupContent.setVisibility(0);
    if (PingUtils.isSurging(paramPing, this.mVehicleViewId))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Float.valueOf(localVehicleView.getSurge().getMultiplier());
      String str3 = String.format("%sx", arrayOfObject);
      this.mTextViewSurgeTitle.setText(str3);
      this.mTextViewSurgeSubtitle.setText(this.mResources.getString(2131559109));
      this.mViewGroupSurgeHeader.setVisibility(0);
      if (!localVehicleView.isDestinationEnabled())
        break label250;
      showAddressView();
      updateFareEstimate();
    }
    while (true)
    {
      updateValuesFromPing(paramPing, localVehicleView);
      return;
      this.mViewGroupSurgeHeader.setVisibility(8);
      break;
      label250: hideAddressView();
    }
  }

  void updateValuesFromPing(Ping paramPing, VehicleView paramVehicleView)
  {
    NearbyVehicle localNearbyVehicle = (NearbyVehicle)paramPing.getNearbyVehicles().get(paramVehicleView.getId());
    if (localNearbyVehicle == null)
    {
      dismiss();
      return;
    }
    String str1 = localNearbyVehicle.getEtaStringShort();
    if (!TextUtils.isEmpty(str1))
      this.mTextViewEta.setText(str1);
    while (true)
    {
      TextView localTextView = this.mTextViewPassengers;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramVehicleView.getCapacity());
      arrayOfObject[1] = this.mResources.getString(2131559000);
      localTextView.setText(String.format("%s %s", arrayOfObject));
      if (!PingUtils.hasFare(paramPing, paramVehicleView.getId()))
        break;
      Object localObject = paramVehicleView.getFare();
      String str2 = ((Fare)localObject).getSafeRidesFee();
      String str3 = ((Fare)localObject).getType();
      float f = 1.0F;
      if (paramVehicleView.isSurging())
      {
        localObject = paramVehicleView.getSurge();
        f = paramVehicleView.getSurge().getMultiplier();
      }
      updateFareInfo((Fare)localObject, f, str3, str2);
      return;
      this.mTextViewEta.setText(2131559289);
    }
  }

  public static abstract interface Listener
  {
    public abstract void onClickRateCardDestinationAddress();

    public abstract void onClickRateCardPickupAddress();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.rates.BaseRateCardPopupWindow
 * JD-Core Version:    0.6.2
 */