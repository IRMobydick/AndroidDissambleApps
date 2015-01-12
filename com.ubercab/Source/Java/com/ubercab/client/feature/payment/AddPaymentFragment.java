package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import com.paypal.android.sdk.payments.PayPalAuthorization;
import com.paypal.android.sdk.payments.PayPalFuturePaymentActivity;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.locale.SelectCountryActivity;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.CreatePaymentProfileResponseEvent;
import com.ubercab.client.core.ui.CountryButton;
import com.ubercab.client.core.ui.MonthEditText;
import com.ubercab.client.core.ui.MonthEditText.Listener;
import com.ubercab.client.core.ui.YearEditText;
import com.ubercab.client.core.ui.YearEditText.Listener;
import com.ubercab.client.core.util.CardIoUtils;
import com.ubercab.client.core.vendor.alipay.model.AlipayCredentials;
import com.ubercab.client.core.vendor.paypal.PayPalUtils;
import com.ubercab.client.feature.payment.event.PaymentProfileAddedEvent;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.app.annotation.ForActivity;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.library.ui.ZipEditText;
import com.ubercab.library.ui.ZipEditText.Listener;
import com.ubercab.library.util.KeyboardUtils;
import com.ubercab.payment.ui.CreditCardEditText;
import com.ubercab.payment.ui.CreditCardEditText.Listener;
import com.ubercab.payment.ui.SecurityCodeEditText;
import com.ubercab.payment.ui.SecurityCodeEditText.Listener;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;
import java.util.Locale;
import javax.inject.Inject;

public class AddPaymentFragment extends RiderFragment
  implements SecurityCodeEditText.Listener, CreditCardEditText.Listener, YearEditText.Listener, MonthEditText.Listener, ZipEditText.Listener
{
  private static final String BUNDLE_COUNTRY_ISO2 = "com.ubercab.client.feature.payment.COUNTRY_ISO2";
  private static final String BUNDLE_USING_CARDIO = "com.ubercab.client.feature.payment.USING_CARDIO";
  private static final int REQUEST_CODE_ALIPAY = 600;
  private static final int REQUEST_CODE_PAYPAL = 700;
  private static final int REQUEST_CODE_SCAN_CARD = 900;
  private static final int REQUEST_CODE_SELECT_COUNTRY = 800;

  @Inject
  ActionBar mActionBar;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  UberBraintree mBraintree;

  @Inject
  Bus mBus;

  @InjectView(2131427576)
  UberButton mButtonAddPayment;

  @InjectView(2131427575)
  CountryButton mButtonCountry;

  @InjectView(2131427571)
  UberButton mButtonScanCard;

  @ForActivity
  @Inject
  Context mContext;
  private String mCountryIso2Code;

  @InjectView(2131427573)
  SecurityCodeEditText mEditTextCreditCardCode;

  @InjectView(2131427569)
  CreditCardEditText mEditTextCreditCardNumber;

  @InjectView(2131427570)
  MonthEditText mEditTextExpirationMonth;

  @InjectView(2131427572)
  YearEditText mEditTextExpirationYear;

  @InjectView(2131427574)
  ZipEditText mEditTextZip;

  @Inject
  GeoManager mGeoManager;

  @InjectView(2131427579)
  ImageButton mImageButtonAlipay;

  @InjectView(2131427578)
  ImageButton mImageButtonPayPal;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427928)
  UberTextView mTextViewHeaderOr;
  private boolean mUsingCardIo;

  @InjectView(2131427577)
  ViewGroup mViewGroupHeaderOr;

  private boolean checkIfDataIsValid()
  {
    if ((this.mEditTextCreditCardNumber.isValid()) && (this.mEditTextExpirationMonth.isValid()) && (this.mEditTextExpirationMonth.isValid()) && (this.mEditTextExpirationYear.isValid()) && (this.mEditTextCreditCardCode.isValid()) && (this.mEditTextZip.isValid()));
    for (boolean bool = true; ; bool = false)
    {
      this.mButtonAddPayment.setEnabled(bool);
      return bool;
    }
  }

  private void moveToNextField(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean);
    View localView;
    do
    {
      return;
      localView = getView().findViewById(paramView.getNextFocusForwardId());
    }
    while (localView == null);
    localView.requestFocus();
  }

  public static AddPaymentFragment newInstance()
  {
    return new AddPaymentFragment();
  }

  private void sendCreateAlipayPaymentProfileRequest(AlipayCredentials paramAlipayCredentials)
  {
    showLoadingDialogSticky(getString(2131558437), null);
    this.mRiderClient.createPaymentProfileAlipay(paramAlipayCredentials.getAccountId(), paramAlipayCredentials.getMobile());
  }

  private void sendCreatePayPalPaymentProfileRequest(PayPalAuthorization paramPayPalAuthorization)
  {
    showLoadingDialogSticky(getString(2131558439), null);
    this.mRiderClient.createPaymentProfilePayPal(paramPayPalAuthorization.getAuthorizationCode(), PayPalUtils.getCorrelationId(getActivity()));
  }

  private void sendCreatePaymentProfileRequest(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    showLoadingDialogSticky(getString(2131558438), null);
    this.mRiderClient.createPaymentProfile(this.mBraintree.encrypt(paramString1), this.mBraintree.encrypt(paramString2), this.mBraintree.encrypt(paramString3), this.mBraintree.encrypt(paramString4), paramString5, paramString6, "personal", false, this.mUsingCardIo);
  }

  private void setCountry(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = Locale.getDefault().getCountry();
    this.mCountryIso2Code = paramString;
    this.mEditTextZip.setCountry(paramString);
    this.mButtonCountry.setCountry(paramString);
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.PAYMENT_METHOD_ADD_CC;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (paramBundle != null)
    {
      setCountry(paramBundle.getString("com.ubercab.client.feature.payment.COUNTRY_ISO2"));
      this.mUsingCardIo = paramBundle.getBoolean("com.ubercab.client.feature.payment.USING_CARDIO");
    }
    this.mActionBar.setTitle(getString(2131558423));
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 800) && (paramInt2 == -1))
      setCountry(paramIntent.getStringExtra("country_iso2"));
    do
    {
      PayPalAuthorization localPayPalAuthorization;
      do
      {
        return;
        if ((paramInt1 != 700) || (paramInt2 != -1))
          break;
        localPayPalAuthorization = (PayPalAuthorization)paramIntent.getParcelableExtra("com.paypal.android.sdk.authorization");
      }
      while (localPayPalAuthorization == null);
      sendCreatePayPalPaymentProfileRequest(localPayPalAuthorization);
      return;
      if ((paramInt1 == 600) && (paramInt2 == -1))
      {
        sendCreateAlipayPaymentProfileRequest((AlipayCredentials)paramIntent.getParcelableExtra("alipay_credentials"));
        return;
      }
    }
    while ((paramInt1 != 900) || (paramInt2 != CardIOActivity.RESULT_CARD_INFO));
    CreditCard localCreditCard = (CreditCard)paramIntent.getParcelableExtra("io.card.payment.scanResult");
    this.mEditTextCreditCardNumber.setText(localCreditCard.cardNumber);
    if (localCreditCard.isExpiryValid())
    {
      MonthEditText localMonthEditText = this.mEditTextExpirationMonth;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(localCreditCard.expiryMonth);
      localMonthEditText.setText(String.format("%d", arrayOfObject1));
      YearEditText localYearEditText = this.mEditTextExpirationYear;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(localCreditCard.expiryYear);
      localYearEditText.setText(String.format("%d", arrayOfObject2).substring(2));
    }
    this.mUsingCardIo = true;
  }

  public boolean onBackPressed()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_METHOD_ADD_CC_CANCEL);
    return false;
  }

  @OnClick({2131427576})
  public void onClickButtonAddPayment(UberButton paramUberButton)
  {
    String str1 = this.mEditTextZip.getText().toString();
    String str2 = this.mEditTextCreditCardCode.getText().toString();
    String str3 = this.mEditTextExpirationYear.getText().toString();
    String str4 = this.mEditTextExpirationMonth.getText().toString();
    sendCreatePaymentProfileRequest(this.mEditTextCreditCardNumber.getText().toString(), str4, str3, str2, this.mCountryIso2Code, str1);
    KeyboardUtils.hideKeyboard(this.mContext, paramUberButton);
  }

  @OnClick({2131427575})
  public void onClickCountry()
  {
    startActivityForResult(new Intent(this.mContext, SelectCountryActivity.class), 800);
  }

  @OnClick({2131427579})
  public void onClickImageButtonAlipay()
  {
    startActivityForResult(new Intent(getActivity(), AddAlipayActivity.class), 600);
  }

  @OnClick({2131427578})
  public void onClickImageButtonPayPal()
  {
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.PAYMENT_METHOD_ADD_PAYPAL);
    startActivityForResult(new Intent(getActivity(), PayPalFuturePaymentActivity.class), 700);
  }

  @OnClick({2131427571})
  public void onClickScanCard()
  {
    startActivityForResult(CardIoUtils.createScanIntent(getActivity()), 900);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  @Subscribe
  public void onCreatePaymentProfileResponseEvent(CreatePaymentProfileResponseEvent paramCreatePaymentProfileResponseEvent)
  {
    hideLoadingDialog();
    if (paramCreatePaymentProfileResponseEvent.isSuccess())
    {
      this.mBus.post(new PaymentProfileAddedEvent());
      return;
    }
    showToast(paramCreatePaymentProfileResponseEvent.getErrorMessage(getActivity()));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903133, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onCreditCardCodeChanged(SecurityCodeEditText paramSecurityCodeEditText, boolean paramBoolean)
  {
    checkIfDataIsValid();
    moveToNextField(this.mEditTextCreditCardCode, paramBoolean);
  }

  public void onCreditCardNumberChanged(CreditCardEditText paramCreditCardEditText, boolean paramBoolean, String paramString)
  {
    this.mUsingCardIo = false;
    this.mEditTextCreditCardCode.setCardType(paramString);
    checkIfDataIsValid();
    if (("Union".equals(paramString)) || ("Laser".equals(paramString)) || ("Maestro".equals(paramString)))
      return;
    moveToNextField(this.mEditTextCreditCardNumber, paramBoolean);
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @OnEditorAction({2131427574})
  public boolean onEditorAction()
  {
    if (checkIfDataIsValid())
    {
      onClickButtonAddPayment(this.mButtonAddPayment);
      return true;
    }
    return false;
  }

  public void onHomePressed()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_METHOD_ADD_CC_CANCEL);
  }

  public void onMonthChanged(MonthEditText paramMonthEditText, boolean paramBoolean)
  {
    int i = 1;
    checkIfDataIsValid();
    MonthEditText localMonthEditText = this.mEditTextExpirationMonth;
    if ((this.mEditTextExpirationMonth.length() > i) && (paramBoolean));
    while (true)
    {
      moveToNextField(localMonthEditText, i);
      return;
      int j = 0;
    }
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    if (this.mCountryIso2Code == null)
      setCountry(paramPingEvent.getPing().getClient().getMobileCountryIso2());
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("com.ubercab.client.feature.payment.COUNTRY_ISO2", this.mCountryIso2Code);
    paramBundle.putBoolean("com.ubercab.client.feature.payment.USING_CARDIO", this.mUsingCardIo);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mButtonAddPayment.setText(getString(2131558423));
    this.mEditTextCreditCardNumber.setListener(this);
    this.mEditTextExpirationMonth.setListener(this);
    this.mEditTextCreditCardCode.setListener(this);
    this.mEditTextExpirationYear.setListener(this);
    this.mEditTextZip.setListener(this);
    this.mEditTextZip.setHint(getString(2131559356));
    boolean bool = PayPalUtils.isSupported(getActivity(), this.mGeoManager);
    int i = 0;
    if (bool)
    {
      this.mImageButtonPayPal.setContentDescription(getString(2131558996));
      this.mImageButtonPayPal.setVisibility(0);
      i = 1;
    }
    if (AddAlipayActivity.isEligible(this.mGeoManager))
    {
      this.mImageButtonAlipay.setContentDescription(getString(2131558441));
      this.mImageButtonAlipay.setVisibility(0);
      i = 1;
    }
    if (i != 0)
    {
      this.mTextViewHeaderOr.setText(getString(2131558979));
      this.mViewGroupHeaderOr.setVisibility(0);
    }
    this.mButtonScanCard.setText(getString(2131559043));
    if (Camera.getNumberOfCameras() == 0)
      this.mButtonScanCard.setVisibility(8);
  }

  public void onYearChanged(YearEditText paramYearEditText, boolean paramBoolean)
  {
    int i = 1;
    checkIfDataIsValid();
    YearEditText localYearEditText = this.mEditTextExpirationYear;
    if ((this.mEditTextExpirationYear.length() > i) && (paramBoolean));
    while (true)
    {
      moveToNextField(localYearEditText, i);
      return;
      int j = 0;
    }
  }

  public void onZipChanged(boolean paramBoolean)
  {
    checkIfDataIsValid();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.AddPaymentFragment
 * JD-Core Version:    0.6.2
 */