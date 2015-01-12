package com.ubercab.client.feature.surge;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.Optional;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.DropNotification;
import com.ubercab.client.core.model.Fare;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Surge;
import com.ubercab.client.core.model.VehicleView;
import com.ubercab.client.core.ui.DiscreteCharacterInputLayout;
import com.ubercab.client.core.ui.DiscreteCharacterInputLayout.InputCompleteListener;
import com.ubercab.client.core.util.AndroidUtils;
import com.ubercab.client.core.util.CharacterUtils;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.util.TimeStringUtils;
import com.ubercab.client.core.vendor.google.GmmProductSurge;
import com.ubercab.client.feature.surge.event.SurgeAcceptedEvent;
import com.ubercab.client.feature.surge.event.SurgeConfirmNotificationEvent;
import com.ubercab.client.feature.surge.event.SurgeExpiredEvent;
import com.ubercab.client.feature.surge.event.SurgeSobrietyFailEvent;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.util.KeyboardUtils;
import com.ubercab.library.util.TimeUtils;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

public class SurgeFragment extends RiderFragment
  implements DiscreteCharacterInputLayout.InputCompleteListener
{
  private static final String BUNDLE_DISPLAY_SOBRIETY_SCREEN = "display_sobriety";
  private static final String BUNDLE_GMM_PRODUCT_SURGE_DISPLAYED = "gmm_surge_displayed";
  private static final int WHAT_EXPIRED = 1;

  @InjectView(2131427796)
  @Optional
  UberButton mAcceptButton;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @InjectView(2131427841)
  @Optional
  UberTextView mAndOrText;

  @Inject
  Bus mBus;
  private boolean mDisplaySobrietyScreen;

  @InjectView(2131427842)
  @Optional
  UberTextView mDistanceFareTextView;
  private GmmProductSurge mGmmProductSurgeDisplayed;
  private Handler mHandler;

  @InjectView(2131427839)
  @Optional
  UberTextView mMinimumFareTextView;

  @InjectView(2131427840)
  @Optional
  UberTextView mMinuteFareTextView;

  @InjectView(2131427846)
  @Optional
  UberTextView mMultiplierRateTextView;

  @InjectView(2131427845)
  @Optional
  UberTextView mMultiplierTextView;

  @InjectView(2131427797)
  @Optional
  UberButton mNotificationButton;

  @Inject
  PingProvider mPingProvider;

  @InjectView(2131427798)
  @Optional
  UberTextView mRateExpirationTextView;

  @InjectView(2131427844)
  @Optional
  UberTextView mSafeRidesFee;

  @InjectView(2131427843)
  @Optional
  LinearLayout mSafeRidesFeeModule;

  @Inject
  SessionPreferences mSessionPreferences;

  @InjectView(2131427799)
  @Optional
  UberTextView mSobrietyInstructions;

  @InjectView(2131427801)
  @Optional
  DiscreteCharacterInputLayout mSobrietyMultiplierLayout;

  @InjectView(2131427800)
  @Optional
  UberTextView mSobrietyMyFare;

  @InjectView(2131427802)
  @Optional
  UberTextView mSobrietyNormalRate;
  private Surge mSurge;

  @InjectView(2131427793)
  @Optional
  UberTextView mSurgeRationaleTextView;

  private Spannable createColorSpannable(String paramString, int paramInt)
  {
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(getResources().getColor(paramInt));
    SpannableString localSpannableString = new SpannableString(paramString);
    localSpannableString.setSpan(localForegroundColorSpan, 0, paramString.length(), 18);
    return localSpannableString;
  }

  private void displayNativeSurgeScreen(View paramView, VehicleView paramVehicleView)
  {
    View localView = ((ViewStub)paramView.findViewById(2131427791)).inflate();
    ButterKnife.inject(this, localView);
    String str1 = paramVehicleView.getFare().getSafeRidesFee();
    Context localContext;
    UberTextView localUberTextView2;
    if (TextUtils.isEmpty(str1))
    {
      this.mSafeRidesFeeModule.setVisibility(8);
      UberTextView localUberTextView1 = this.mMultiplierTextView;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Float.valueOf(this.mSurge.getMultiplier());
      localUberTextView1.setText(String.format("%sx", arrayOfObject1));
      this.mMultiplierRateTextView.setText(getString(2131559092));
      this.mSurgeRationaleTextView.setText(getString(2131559101));
      CharSequence localCharSequence2 = CharacterUtils.convertToUpperCase(getString(2131558999, new Object[] { createColorSpannable(this.mSurge.getPerMinute(), 2131296330) }));
      this.mMinuteFareTextView.setText(localCharSequence2);
      CharSequence localCharSequence3 = CharacterUtils.convertToUpperCase(getString(2131559091, new Object[] { createColorSpannable(this.mSurge.getBase(), 2131296330) }));
      this.mMinimumFareTextView.setText(localCharSequence3);
      localContext = localView.getContext();
      boolean bool = "TimeAndDistance".equals(paramVehicleView.getFare().getType());
      localUberTextView2 = this.mAndOrText;
      if (!bool)
        break label460;
    }
    label460: for (String str2 = localContext.getString(2131558447); ; str2 = localContext.getString(2131558979))
    {
      localUberTextView2.setText(str2);
      Spannable localSpannable = createColorSpannable(this.mSurge.getPerDistanceUnit(), 2131296330);
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = localSpannable;
      arrayOfObject2[1] = this.mSurge.getDistanceUnit();
      CharSequence localCharSequence4 = CharacterUtils.convertToUpperCase(getString(2131558998, arrayOfObject2));
      this.mDistanceFareTextView.setText(localCharSequence4);
      String str3 = TimeStringUtils.convertMSToFormattedString(getActivity(), 1000L * this.mSurge.getExpirationTime(), ",");
      this.mRateExpirationTextView.setText(getString(2131559098, new Object[] { str3 }));
      this.mAcceptButton.setText(getString(2131558417));
      DropNotification localDropNotification = this.mSurge.getDropNotification();
      if ((localDropNotification != null) && (localDropNotification.isEnabled()))
      {
        this.mNotificationButton.setText(getString(2131559094));
        this.mNotificationButton.setVisibility(0);
      }
      if (shouldShowGmmSurgeChangedText(paramVehicleView))
        showGmmSurgeChangedToast(paramView);
      return;
      this.mSafeRidesFeeModule.setVisibility(0);
      CharSequence localCharSequence1 = CharacterUtils.convertToUpperCase(getString(2131559041, new Object[] { createColorSpannable(str1, 2131296330) }));
      this.mSafeRidesFee.setText(localCharSequence1);
      break;
    }
  }

  private void displaySobrietyScreen(View paramView)
  {
    ButterKnife.inject(this, ((ViewStub)paramView.findViewById(2131427792)).inflate());
    Spannable localSpannable = createColorSpannable("(" + this.mSurge.getMultiplier() + ")", 2131296333);
    this.mSobrietyInstructions.setText(getString(2131559103, new Object[] { localSpannable }));
    HashMap localHashMap = new HashMap();
    localHashMap.put(Character.valueOf('.'), Integer.valueOf(2130837918));
    this.mSobrietyMultiplierLayout.addInputListener(this);
    this.mSobrietyMultiplierLayout.initializeValues(String.valueOf(this.mSurge.getMultiplier()), localHashMap);
    this.mSobrietyMyFare.setText(getString(2131559102));
    this.mSobrietyNormalRate.setText(getString(2131559104));
  }

  private VehicleView getCurrentVehicleView()
  {
    Ping localPing = this.mPingProvider.get();
    String str = this.mSessionPreferences.getSelectedVehicleViewId();
    if (!PingUtils.hasVehicleView(localPing, str))
      return null;
    return localPing.getCity().findVehicleView(str);
  }

  private Spanned getGmmSurgeChangedText()
  {
    Float localFloat = this.mGmmProductSurgeDisplayed.getSurge();
    if (localFloat == null)
      return null;
    int i;
    if (Float.compare(localFloat.floatValue(), this.mSurge.getMultiplier()) > 0)
    {
      i = 1;
      if (i == 0)
        break label124;
    }
    label124: for (int j = 2131559097; ; j = 2131559099)
    {
      Object[] arrayOfObject1 = new Object[2];
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.mGmmProductSurgeDisplayed.getSurge();
      arrayOfObject1[0] = String.format("<b>%sx</b>", arrayOfObject2);
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Float.valueOf(this.mSurge.getMultiplier());
      arrayOfObject1[1] = String.format("<b>%sx</b>", arrayOfObject3);
      return Html.fromHtml(getString(j, arrayOfObject1));
      i = 0;
      break;
    }
  }

  public static SurgeFragment getInstance(boolean paramBoolean, GmmProductSurge paramGmmProductSurge)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("display_sobriety", paramBoolean);
    localBundle.putParcelable("gmm_surge_displayed", paramGmmProductSurge);
    SurgeFragment localSurgeFragment = new SurgeFragment();
    localSurgeFragment.setArguments(localBundle);
    return localSurgeFragment;
  }

  private boolean shouldShowGmmSurgeChangedText(VehicleView paramVehicleView)
  {
    if ((this.mGmmProductSurgeDisplayed == null) || (paramVehicleView == null));
    Float localFloat;
    do
    {
      do
        return false;
      while (!TextUtils.equals(this.mGmmProductSurgeDisplayed.getUuid(), paramVehicleView.getUuid()));
      localFloat = this.mGmmProductSurgeDisplayed.getSurge();
    }
    while ((localFloat == null) || (localFloat.equals(Float.valueOf(this.mSurge.getMultiplier()))));
    return true;
  }

  private void showGmmSurgeChangedToast(View paramView)
  {
    Spanned localSpanned = getGmmSurgeChangedText();
    if (localSpanned == null)
      return;
    Toast localToast = Toast.makeText(paramView.getContext(), localSpanned, 1);
    localToast.setGravity(49, 0, AndroidUtils.getThemeAttributeDimensionSize(paramView.getContext(), 16843499));
    View localView = localToast.getView();
    if (localView != null)
    {
      TextView localTextView = (TextView)localView.findViewById(16908299);
      if (localTextView != null)
        localTextView.setGravity(17);
    }
    localToast.show();
  }

  @OnClick({2131427796})
  @Optional
  public void onAcceptClick()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SURGE_PRICING_ACCEPT);
    this.mBus.post(new SurgeAcceptedEvent(this.mSurge.getFareId()));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
      this.mGmmProductSurgeDisplayed = ((GmmProductSurge)paramBundle.getParcelable("gmm_surge_displayed"));
    this.mHandler = new Handler(new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 1)
          SurgeFragment.this.mBus.post(new SurgeExpiredEvent());
        return false;
      }
    });
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.mDisplaySobrietyScreen = localBundle.getBoolean("display_sobriety", false);
      this.mGmmProductSurgeDisplayed = ((GmmProductSurge)localBundle.getParcelable("gmm_surge_displayed"));
    }
    return paramLayoutInflater.inflate(2130903195, paramViewGroup, false);
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.mSobrietyMultiplierLayout != null)
      this.mSobrietyMultiplierLayout.removeInputListener(this);
    ButterKnife.reset(this);
  }

  public void onInputFail()
  {
    this.mBus.post(new SurgeSobrietyFailEvent(this.mSurge.getMultiplier()));
  }

  public void onInputSuccess()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SURGE_SOBRIETY_CHECK_SUBMIT);
    this.mBus.post(new SurgeAcceptedEvent(this.mSurge.getFareId()));
  }

  public void onPause()
  {
    super.onPause();
    KeyboardUtils.hideKeyboard(getActivity());
    this.mHandler.removeCallbacksAndMessages(null);
  }

  public void onResume()
  {
    super.onResume();
    VehicleView localVehicleView = getCurrentVehicleView();
    if (localVehicleView == null)
      return;
    long l1 = localVehicleView.getSurge().getExpirationTime();
    long l2 = this.mPingProvider.getEpochTime();
    long l3 = TimeUtils.getEpochTime() - l2;
    if (l3 >= l1)
    {
      this.mBus.post(new SurgeExpiredEvent());
      return;
    }
    long l4 = l1 - l3;
    this.mHandler.sendEmptyMessageDelayed(1, 1000L * l4);
  }

  @OnClick({2131427797})
  @Optional
  public void onSurgeNotificationClick()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SURGE_DROP_NOTIFY);
    this.mBus.post(new SurgeConfirmNotificationEvent(this.mSurge.getFareId()));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    VehicleView localVehicleView = getCurrentVehicleView();
    if ((localVehicleView == null) || (localVehicleView.getSurge() == null))
      return;
    this.mSurge = localVehicleView.getSurge();
    if (this.mDisplaySobrietyScreen)
    {
      this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.SURGE_SOBRIETY_CHECK);
      displaySobrietyScreen(paramView);
      return;
    }
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.SURGE_PRICING);
    displayNativeSurgeScreen(paramView, localVehicleView);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.surge.SurgeFragment
 * JD-Core Version:    0.6.2
 */