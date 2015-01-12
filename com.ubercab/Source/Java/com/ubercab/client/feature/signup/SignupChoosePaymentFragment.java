package com.ubercab.client.feature.signup;

import android.app.ActionBar;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Custom;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.ClientSignupResponse;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.SignupClient;
import com.ubercab.client.core.network.events.ClientSignupResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.payment.PaymentWalletConfirmationFragment;
import com.ubercab.client.feature.signup.event.SignupChooseInternationalCreditCardEvent;
import com.ubercab.client.feature.signup.event.SignupCompletedEvent;
import com.ubercab.client.feature.signup.event.SignupPendingEvent;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.app.UberActivity;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.library.ui.MessageDialogFragment;
import com.ubercab.library.util.PhoneNumberUtils;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class SignupChoosePaymentFragment extends RiderFragment
  implements SignupEvents
{
  private static final String BUNDLE_SIGNUP_DATA = "signup_data";
  private static final int REQUEST_CODE_PROMO = 100;
  private static final int REQUEST_CODE_WALLET_CONFIRMATION = 200;

  @Inject
  ActionBar mActionBar;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  Bus mBus;

  @Inject
  RiderClient mRiderClient;

  @Inject
  SignupClient mSignupClient;
  private SignupData mSignupData;

  @InjectView(2131427928)
  UberTextView mTextViewOr;

  public static boolean isEligible(GeoManager paramGeoManager)
  {
    return paramGeoManager.getGeo() == 4;
  }

  static Fragment newInstance(SignupData paramSignupData)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("signup_data", paramSignupData);
    SignupChoosePaymentFragment localSignupChoosePaymentFragment = new SignupChoosePaymentFragment();
    localSignupChoosePaymentFragment.setArguments(localBundle);
    return localSignupChoosePaymentFragment;
  }

  private void sendPingClientRequest()
  {
    this.mRiderClient.pingClient();
  }

  private void sendSignUpRequestPayTm()
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
        break label137;
      str2 = localThirdPartyToken.getType();
      if (localThirdPartyToken == null)
        break label142;
      str3 = localThirdPartyToken.getToken();
      label59: if (localThirdPartyToken == null)
        break label148;
    }
    label137: label142: label148: for (long l = localThirdPartyToken.getExpiresInMs(); ; l = 0L)
    {
      this.mSignupClient.signUpWithPayTm(this.mSignupData.getEmail(), this.mSignupData.getMobile(), this.mSignupData.getMobileCountryIso2(), this.mSignupData.getFirstName(), this.mSignupData.getLastName(), str1, this.mSignupData.getPassword(), this.mSignupData.getGoogleToken(), str2, str3, l);
      return;
      str1 = null;
      break;
      str2 = null;
      break label49;
      str3 = null;
      break label59;
    }
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.SIGN_UP_INDIA_PAYMENT_CHOICE;
  }

  public void onCancel()
  {
  }

  @OnClick({2131427591})
  public void onClickCreditCard()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_METHOD_ADD_CC_INTL);
    this.mBus.post(new SignupChooseInternationalCreditCardEvent(this.mSignupData));
  }

  @OnClick({2131427597})
  public void onClickLegal()
  {
    startActivity(new Intent(getActivity(), LegalActivity.class));
  }

  @OnClick({2131427593})
  public void onClickPrepaid()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_METHOD_ADD_PREPAID_WALLET);
    String str = PhoneNumberUtils.getDisplayPhoneNumber(this.mSignupData.getMobile(), this.mSignupData.getMobileCountryIso2());
    PaymentWalletConfirmationFragment.show((UberActivity)getActivity(), 200, str);
  }

  @Subscribe
  public void onClientSignupResponseEvent(ClientSignupResponseEvent paramClientSignupResponseEvent)
  {
    if (!paramClientSignupResponseEvent.isSuccess())
    {
      hideLoadingDialog();
      if (paramClientSignupResponseEvent.getErrorMessage() == null);
      for (String str4 = getString(2131559073); ; str4 = paramClientSignupResponseEvent.getErrorMessage())
      {
        MessageDialogFragment.show(getRiderActivity(), 0, null, str4);
        return;
      }
    }
    if (paramClientSignupResponseEvent.isPending())
    {
      hideLoadingDialog();
      this.mBus.post(new SignupPendingEvent(this.mSignupData.getEmail()));
      return;
    }
    ClientSignupResponse localClientSignupResponse = (ClientSignupResponse)paramClientSignupResponseEvent.getModel();
    String str1 = localClientSignupResponse.getUuid();
    String str2 = localClientSignupResponse.getToken();
    String str3 = localClientSignupResponse.getEmail();
    RiderApplication.get(getActivity()).setCurrentUser(str1, str2, str3);
    sendPingClientRequest();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    if (paramBundle != null)
    {
      this.mSignupData = ((SignupData)paramBundle.getParcelable("signup_data"));
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
    View localView = paramLayoutInflater.inflate(2130903135, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  boolean onDialogResult(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt1 == 200)
    {
      if (paramInt2 == -1)
      {
        this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_METHOD_LINK_PAYTM_ACCEPT);
        sendSignUpRequestPayTm();
      }
      while (true)
      {
        return true;
        if (paramInt2 == 0)
          this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_METHOD_LINK_PAYTM_CANCEL);
      }
    }
    if ((paramInt1 == 100) && (paramInt2 == -1))
    {
      this.mAnalyticsClient.sendCustomEvent(RiderEvents.Custom.SIGN_UP_PAYMENT_PROMO_APPLIED);
      this.mSignupData = ((SignupData)paramBundle.getParcelable("signup_data"));
      showToast(getString(2131559014));
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
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("signup_data", this.mSignupData);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mTextViewOr.setText(getString(2131558979));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupChoosePaymentFragment
 * JD-Core Version:    0.6.2
 */