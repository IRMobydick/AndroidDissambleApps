package com.ubercab.client.feature.signup;

import android.app.ActionBar;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.paypal.android.sdk.payments.PayPalAuthorization;
import com.paypal.android.sdk.payments.PayPalFuturePaymentActivity;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.SignUpEvent;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.app.event.RiderServiceReadyEvent;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.locale.SelectCountryActivity;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Custom;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.ClientSignupResponse;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.SignupClient;
import com.ubercab.client.core.network.events.ClientSignupResponseEvent;
import com.ubercab.client.core.ui.CountryButton;
import com.ubercab.client.core.ui.MonthEditText;
import com.ubercab.client.core.ui.YearEditText;
import com.ubercab.client.core.util.CardIoUtils;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.vendor.alipay.model.AlipayCredentials;
import com.ubercab.client.core.vendor.google.GoogleWalletActivity;
import com.ubercab.client.core.vendor.paypal.PayPalUtils;
import com.ubercab.client.feature.payment.AddAlipayActivity;
import com.ubercab.client.feature.payment.UberBraintree;
import com.ubercab.client.feature.signup.event.SignupCompletedEvent;
import com.ubercab.client.feature.signup.event.SignupPendingEvent;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.library.ui.MessageDialogFragment;
import com.ubercab.library.ui.ZipEditText;
import com.ubercab.payment.ui.CreditCardEditText;
import com.ubercab.payment.ui.CreditCardEditText.Listener;
import com.ubercab.payment.ui.SecurityCodeEditText;
import com.ubercab.ui.TextWatcherAdapter;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;
import javax.inject.Inject;

public class SignupPaymentFragment extends RiderFragment
  implements CreditCardEditText.Listener, SignupEvents
{
  private static final String BUNDLE_SIGNUP_DATA = "signup_data";
  private static final String BUNDLE_USING_CARDIO = "using_cardio";
  private static final int REQUEST_CODE_ALIPAY = 600;
  private static final int REQUEST_CODE_GOOGLE_WALLET = 300;
  private static final int REQUEST_CODE_PAYPAL = 200;
  private static final int REQUEST_CODE_PROMO = 100;
  private static final int REQUEST_CODE_SCAN_CARD = 500;
  private static final int REQUEST_CODE_SELECT_COUNTRY = 400;

  @Inject
  ActionBar mActionBar;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @Inject
  UberBraintree mBraintree;

  @Inject
  Bus mBus;

  @InjectView(2131427742)
  ImageButton mButtonAlipay;

  @InjectView(2131427739)
  UberButton mButtonDone;

  @InjectView(2131427741)
  ImageButton mButtonGoogleWallet;

  @InjectView(2131427597)
  UberButton mButtonLegal;

  @InjectView(2131427740)
  ImageButton mButtonPaypal;

  @InjectView(2131427734)
  UberButton mButtonScanCard;

  @InjectView(2131427738)
  CountryButton mCountryButton;

  @InjectView(2131427736)
  SecurityCodeEditText mEditTextCardCode;

  @InjectView(2131427732)
  CreditCardEditText mEditTextCardNumber;

  @InjectView(2131427733)
  MonthEditText mEditTextMonth;

  @InjectView(2131427735)
  YearEditText mEditTextYear;

  @InjectView(2131427737)
  ZipEditText mEditTextZip;

  @Inject
  GeoManager mGeoManager;

  @InjectView(2131427729)
  ImageView mImageViewPromoPicture;

  @InjectView(2131427743)
  UberTextView mLegalDescription;
  private boolean mPendingSendSignUpRequestPayPal;

  @Inject
  Picasso mPicasso;

  @Inject
  RiderClient mRiderClient;

  @Inject
  SignupClient mSignupClient;
  private SignupData mSignupData;

  @InjectView(2131427928)
  UberTextView mTextViewOr;

  @InjectView(2131427730)
  UberTextView mTextViewPromo1;

  @InjectView(2131427731)
  UberTextView mTextViewPromo2;
  private UpdateUITextWatcher mTextWatcherUI;
  private boolean mUsingCardIo;

  @InjectView(2131427577)
  ViewGroup mViewGroupHeaderOr;

  @InjectView(2131427728)
  ViewGroup mViewGroupPromo;

  public static Fragment newInstance(SignupData paramSignupData)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("signup_data", paramSignupData);
    SignupPaymentFragment localSignupPaymentFragment = new SignupPaymentFragment();
    localSignupPaymentFragment.setArguments(localBundle);
    return localSignupPaymentFragment;
  }

  private void sendPingClientRequest()
  {
    this.mRiderClient.pingClient();
  }

  private void sendSignUpRequestCreditCard()
  {
    showLoadingDialogSticky(getString(2131559072), null);
    String str1;
    ThirdPartyToken localThirdPartyToken;
    String str2;
    label49: String str3;
    if (this.mSignupData.getPromoCode() != null)
    {
      str1 = this.mSignupData.getPromoCode().getCode();
      localThirdPartyToken = this.mSignupData.getThirdPartyToken();
      if (localThirdPartyToken == null)
        break label238;
      str2 = localThirdPartyToken.getType();
      if (localThirdPartyToken == null)
        break label243;
      str3 = localThirdPartyToken.getToken();
      label59: if (localThirdPartyToken == null)
        break label249;
    }
    label238: label243: label249: for (long l = localThirdPartyToken.getExpiresInMs(); ; l = 0L)
    {
      this.mSignupClient.signUpWithCreditCard(this.mSignupData.getEmail(), this.mSignupData.getMobile(), this.mSignupData.getMobileCountryIso2(), this.mSignupData.getFirstName(), this.mSignupData.getLastName(), this.mBraintree.encrypt(this.mEditTextCardNumber.getText().toString()), this.mBraintree.encrypt(this.mEditTextCardCode.getText().toString()), this.mBraintree.encrypt(this.mEditTextMonth.getText().toString()), this.mBraintree.encrypt(this.mEditTextYear.getText().toString()), this.mEditTextZip.getText().toString(), this.mCountryButton.getCountryIso2(), "personal", str1, this.mUsingCardIo, this.mSignupData.getPassword(), this.mSignupData.getGoogleToken(), str2, str3, l);
      this.mAnalyticsManager.signUpEvent().signUpRequest();
      return;
      str1 = null;
      break;
      str2 = null;
      break label49;
      str3 = null;
      break label59;
    }
  }

  private void sendSignUpRequestPayPal()
  {
    showLoadingDialogSticky(getString(2131559072), null);
    String str1;
    ThirdPartyToken localThirdPartyToken;
    String str2;
    label49: String str3;
    if (this.mSignupData.getPromoCode() != null)
    {
      str1 = this.mSignupData.getPromoCode().getCode();
      localThirdPartyToken = this.mSignupData.getThirdPartyToken();
      if (localThirdPartyToken == null)
        break label161;
      str2 = localThirdPartyToken.getType();
      if (localThirdPartyToken == null)
        break label166;
      str3 = localThirdPartyToken.getToken();
      label59: if (localThirdPartyToken == null)
        break label172;
    }
    label161: label166: label172: for (long l = localThirdPartyToken.getExpiresInMs(); ; l = 0L)
    {
      this.mSignupClient.signUpWithPaypal(this.mSignupData.getEmail(), this.mSignupData.getMobile(), this.mSignupData.getMobileCountryIso2(), this.mSignupData.getFirstName(), this.mSignupData.getLastName(), this.mSignupData.getPayPalAuthorizationCode(), str1, this.mSignupData.getPassword(), this.mSignupData.getGoogleToken(), str2, str3, l, PayPalUtils.getCorrelationId(getActivity()));
      this.mAnalyticsManager.signUpEvent().signUpRequest();
      return;
      str1 = null;
      break;
      str2 = null;
      break label49;
      str3 = null;
      break label59;
    }
  }

  private void sendSignupRequestAlipay()
  {
    showLoadingDialogSticky(getString(2131559072), null);
    SignupData.PromoCode localPromoCode = this.mSignupData.getPromoCode();
    String str = null;
    if (localPromoCode != null)
      str = this.mSignupData.getPromoCode().getCode();
    this.mSignupClient.signupWithAlipay(this.mSignupData.getEmail(), this.mSignupData.getMobile(), this.mSignupData.getMobileCountryIso2(), this.mSignupData.getFirstName(), this.mSignupData.getLastName(), this.mSignupData.getAlipayAccountId(), this.mSignupData.getAlipayMobile(), str, this.mSignupData.getPassword());
    this.mAnalyticsManager.signUpEvent().signUpRequest();
  }

  private void setCountry(String paramString)
  {
    this.mCountryButton.setCountry(paramString);
    this.mEditTextZip.setCountry(paramString);
  }

  private void startGoogleWallet()
  {
    Intent localIntent = new Intent(getActivity(), GoogleWalletActivity.class);
    localIntent.setAction("com.ubercab.ACTION_LOAD_MASKED_WALLET");
    startActivityForResult(localIntent, 300);
  }

  private void updatePromoUI()
  {
    if ((this.mSignupData == null) || (this.mSignupData.getPromoCode() == null))
    {
      this.mViewGroupPromo.setVisibility(8);
      return;
    }
    SignupData.PromoCode localPromoCode = this.mSignupData.getPromoCode();
    this.mImageViewPromoPicture.setImageDrawable(null);
    if (!TextUtils.isEmpty(localPromoCode.getInviterPictureUrl()))
    {
      this.mImageViewPromoPicture.setVisibility(0);
      this.mPicasso.load(localPromoCode.getInviterPictureUrl()).fit().into(this.mImageViewPromoPicture);
      if (TextUtils.isEmpty(localPromoCode.getInviterFirstName()))
        break label153;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localPromoCode.getInviterFirstName();
      String str = getString(2131559016, arrayOfObject);
      this.mTextViewPromo1.setText(str);
    }
    while (true)
    {
      this.mTextViewPromo2.setText(localPromoCode.getValue());
      this.mViewGroupPromo.setVisibility(0);
      return;
      this.mImageViewPromoPicture.setVisibility(8);
      break;
      label153: this.mTextViewPromo1.setText(localPromoCode.getCode());
    }
  }

  private void updateUI()
  {
    updatePromoUI();
    if ((this.mEditTextCardNumber.isValid()) && (this.mEditTextCardCode.isValid()) && (this.mEditTextMonth.isValid()) && (this.mEditTextYear.isValid()) && (this.mEditTextZip.isValid()));
    for (boolean bool = true; ; bool = false)
    {
      this.mButtonDone.setEnabled(bool);
      return;
    }
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.SIGN_UP_2;
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 200) && (paramInt2 == -1))
    {
      PayPalAuthorization localPayPalAuthorization = (PayPalAuthorization)paramIntent.getParcelableExtra("com.paypal.android.sdk.authorization");
      if (localPayPalAuthorization != null)
      {
        this.mSignupData.setPayPalAuthorizationCode(localPayPalAuthorization.getAuthorizationCode());
        this.mPendingSendSignUpRequestPayPal = true;
      }
    }
    do
    {
      return;
      if ((paramInt1 == 300) && (paramInt2 == -1))
      {
        sendSignUpRequestGoogleWallet();
        return;
      }
      if ((paramInt1 == 600) && (paramInt2 == -1))
      {
        AlipayCredentials localAlipayCredentials = (AlipayCredentials)paramIntent.getParcelableExtra("alipay_credentials");
        this.mSignupData.setAlipayAccountId(localAlipayCredentials.getAccountId());
        this.mSignupData.setAlipayMobile(localAlipayCredentials.getMobile());
        sendSignupRequestAlipay();
        return;
      }
      if ((paramInt1 == 400) && (paramInt2 == -1))
      {
        setCountry(paramIntent.getStringExtra("country_iso2"));
        return;
      }
    }
    while ((paramInt1 != 500) || (paramInt2 != CardIOActivity.RESULT_CARD_INFO));
    CreditCard localCreditCard = (CreditCard)paramIntent.getParcelableExtra("io.card.payment.scanResult");
    this.mEditTextCardNumber.setText(localCreditCard.cardNumber);
    if (localCreditCard.isExpiryValid())
    {
      MonthEditText localMonthEditText = this.mEditTextMonth;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(localCreditCard.expiryMonth);
      localMonthEditText.setText(String.format("%d", arrayOfObject1));
      YearEditText localYearEditText = this.mEditTextYear;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(localCreditCard.expiryYear);
      localYearEditText.setText(String.format("%d", arrayOfObject2).substring(2));
    }
    this.mUsingCardIo = true;
  }

  public void onCancel()
  {
    PaymentData localPaymentData = new PaymentData(this.mEditTextCardNumber.getText().toString(), this.mEditTextCardCode.getText().toString(), this.mEditTextMonth.getText().toString(), this.mEditTextYear.getText().toString());
    this.mAnalyticsManager.signUpEvent().signUpCancel(this.mSignupData, localPaymentData);
  }

  @OnClick({2131427742})
  public void onClickAlipay()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SIGN_UP_PAYMENT_BUTTON_ALIPAY);
    startActivityForResult(new Intent(getActivity(), AddAlipayActivity.class), 600);
  }

  @OnClick({2131427739})
  public void onClickDone()
  {
    sendSignUpRequestCreditCard();
  }

  @OnClick({2131427738})
  public void onClickFlag()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SIGN_UP_PAYMENT_BUTTON_COUNTRY);
    startActivityForResult(new Intent(getActivity(), SelectCountryActivity.class), 400);
  }

  @OnClick({2131427741})
  public void onClickGoogleWallet()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SIGN_UP_PAYMENT_GOOGLE_WALLET);
    startGoogleWallet();
  }

  @OnClick({2131427597})
  public void onClickLegal()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SIGN_UP_PAYMENT_LEGAL);
    startActivity(new Intent(getActivity(), LegalActivity.class));
  }

  @OnClick({2131427740})
  public void onClickPayPal()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SIGN_UP_PAYMENT_BUTTON_PAYPAL);
    startActivityForResult(new Intent(getActivity(), PayPalFuturePaymentActivity.class), 200);
  }

  @OnClick({2131427734})
  public void onClickScanCard()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SIGN_UP_PAYMENT_CARDIO_START);
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.CARDIO);
    startActivityForResult(CardIoUtils.createScanIntent(getActivity()), 500);
  }

  @Subscribe
  public void onClientSignupResponseEvent(ClientSignupResponseEvent paramClientSignupResponseEvent)
  {
    this.mAnalyticsManager.signUpEvent().signUpResponse(paramClientSignupResponseEvent.getStatusCode());
    if (!paramClientSignupResponseEvent.isSuccess())
    {
      hideLoadingDialog();
      if (paramClientSignupResponseEvent.getErrorMessage() != null);
      for (String str4 = paramClientSignupResponseEvent.getErrorMessage(); ; str4 = getString(2131559073))
      {
        MessageDialogFragment.show(getRiderActivity(), 0, null, str4);
        this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.SIGN_UP_PAYMENT_ERROR_DIALOG);
        return;
      }
    }
    if (paramClientSignupResponseEvent.isPending())
    {
      hideLoadingDialog();
      this.mAnalyticsManager.signUpEvent().signUpPending();
      this.mBus.post(new SignupPendingEvent(this.mSignupData.getEmail()));
      return;
    }
    ClientSignupResponse localClientSignupResponse = (ClientSignupResponse)paramClientSignupResponseEvent.getModel();
    String str1 = localClientSignupResponse.getUuid();
    String str2 = localClientSignupResponse.getToken();
    String str3 = localClientSignupResponse.getEmail();
    RiderApplication.get(getActivity()).setCurrentUser(str1, str2, str3);
    this.mAnalyticsManager.signUpEvent().signUpSuccess();
    sendPingClientRequest();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    this.mTextWatcherUI = new UpdateUITextWatcher(null);
    if (paramBundle != null)
    {
      this.mSignupData = ((SignupData)paramBundle.getParcelable("signup_data"));
      this.mUsingCardIo = paramBundle.getBoolean("using_cardio");
      return;
    }
    this.mSignupData = ((SignupData)getArguments().getParcelable("signup_data"));
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(2131689477, paramMenu);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903180, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onCreditCardNumberChanged(CreditCardEditText paramCreditCardEditText, boolean paramBoolean, String paramString)
  {
    this.mUsingCardIo = false;
    this.mEditTextCardCode.setCardType(paramString);
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  public boolean onDialogResult(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if ((paramInt1 == 100) && (paramInt2 == -1))
    {
      this.mAnalyticsClient.sendCustomEvent(RiderEvents.Custom.SIGN_UP_PAYMENT_PROMO_APPLIED);
      this.mSignupData = ((SignupData)paramBundle.getParcelable("signup_data"));
      updateUI();
      return true;
    }
    return false;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131427939)
    {
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.SIGN_UP_PAYMENT_PROMO);
      SignupPromoFragment.newInstance(this.mSignupData, 100).show(getFragmentManager(), SignupPromoFragment.class.getName());
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    hideLoadingDialog();
    if (PingUtils.hasClient(paramPingEvent.getPing()))
      this.mBus.post(new SignupCompletedEvent());
  }

  public void onResume()
  {
    super.onResume();
    this.mActionBar.setTitle(getString(2131558985));
    updateUI();
  }

  @Subscribe
  public void onRiderServiceReadyEvent(RiderServiceReadyEvent paramRiderServiceReadyEvent)
  {
    if (this.mPendingSendSignUpRequestPayPal)
    {
      this.mPendingSendSignUpRequestPayPal = false;
      sendSignUpRequestPayPal();
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("signup_data", this.mSignupData);
    paramBundle.putBoolean("using_cardio", this.mUsingCardIo);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mButtonDone.setText(getString(2131559023));
    this.mButtonScanCard.setText(getString(2131559043));
    this.mLegalDescription.setText(getString(2131558988));
    this.mButtonLegal.setText(getString(2131558987));
    this.mButtonLegal.setPaintFlags(0x8 | this.mButtonLegal.getPaintFlags());
    this.mEditTextCardNumber.addTextChangedListener(this.mTextWatcherUI);
    this.mEditTextCardCode.addTextChangedListener(this.mTextWatcherUI);
    this.mEditTextMonth.addTextChangedListener(this.mTextWatcherUI);
    this.mEditTextYear.addTextChangedListener(this.mTextWatcherUI);
    this.mEditTextZip.addTextChangedListener(this.mTextWatcherUI);
    this.mEditTextZip.setHint(getString(2131559356));
    setCountry(this.mSignupData.getMobileCountryIso2());
    this.mEditTextCardNumber.setListener(this);
    boolean bool = PayPalUtils.isSupported(getActivity(), this.mGeoManager);
    int i = 0;
    if (bool)
    {
      i = 1;
      this.mButtonPaypal.setContentDescription(getString(2131558996));
      this.mButtonPaypal.setVisibility(0);
    }
    if (GoogleWalletActivity.isEligible(getActivity()))
    {
      i = 1;
      this.mButtonGoogleWallet.setContentDescription(getString(2131558885));
      this.mButtonGoogleWallet.setVisibility(0);
    }
    if (AddAlipayActivity.isEligible(this.mGeoManager))
    {
      i = 1;
      this.mButtonAlipay.setContentDescription(getString(2131558441));
      this.mButtonAlipay.setVisibility(0);
    }
    if (i != 0)
    {
      this.mTextViewOr.setText(getString(2131558979));
      this.mViewGroupHeaderOr.setVisibility(0);
    }
    if (Camera.getNumberOfCameras() == 0)
      this.mButtonScanCard.setVisibility(8);
  }

  public void sendSignUpRequestGoogleWallet()
  {
    showLoadingDialogSticky(getString(2131559072), null);
    String str1;
    ThirdPartyToken localThirdPartyToken;
    String str2;
    label49: String str3;
    if (this.mSignupData.getPromoCode() != null)
    {
      str1 = this.mSignupData.getPromoCode().getCode();
      localThirdPartyToken = this.mSignupData.getThirdPartyToken();
      if (localThirdPartyToken == null)
        break label147;
      str2 = localThirdPartyToken.getType();
      if (localThirdPartyToken == null)
        break label152;
      str3 = localThirdPartyToken.getToken();
      label59: if (localThirdPartyToken == null)
        break label158;
    }
    label147: label152: label158: for (long l = localThirdPartyToken.getExpiresInMs(); ; l = 0L)
    {
      this.mSignupClient.signUpWithGoogleWallet(this.mSignupData.getEmail(), this.mSignupData.getMobile(), this.mSignupData.getMobileCountryIso2(), this.mSignupData.getFirstName(), this.mSignupData.getLastName(), str1, this.mSignupData.getPassword(), this.mSignupData.getGoogleToken(), str2, str3, l);
      this.mAnalyticsManager.signUpEvent().signUpRequest();
      return;
      str1 = null;
      break;
      str2 = null;
      break label49;
      str3 = null;
      break label59;
    }
  }

  private class UpdateUITextWatcher extends TextWatcherAdapter
  {
    private UpdateUITextWatcher()
    {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      SignupPaymentFragment.this.updateUI();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPaymentFragment
 * JD-Core Version:    0.6.2
 */