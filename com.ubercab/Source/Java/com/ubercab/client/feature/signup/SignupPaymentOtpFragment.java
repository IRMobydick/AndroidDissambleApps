package com.ubercab.client.feature.signup;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.PaymentClient;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.ClientUpdateResponseEvent;
import com.ubercab.client.core.network.events.PaymentSendCodeResponseEvent;
import com.ubercab.client.core.network.events.PaymentValidateCodeResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.library.app.UberActivity;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.library.ui.MessageDialogFragment;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class SignupPaymentOtpFragment extends RiderFragment
{
  private static final String ARG_UUID = "uuid";
  private static final int REQUEST_CODE_INVALID_OTP = 900;

  @Inject
  ActionBar mActionBar;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @InjectView(2131427612)
  UberButton mButtonVerify;
  private Client mClient;

  @Inject
  Context mContext;

  @InjectView(2131427611)
  UberEditText mEditTextOtp;
  private MenuItem mMenuItemEdit;

  @Inject
  PaymentClient mPaymentClient;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427610)
  UberTextView mTextViewInstructionsSubtext;
  private String mUuid;

  public static SignupPaymentOtpFragment newInstance(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uuid", paramString);
    SignupPaymentOtpFragment localSignupPaymentOtpFragment = new SignupPaymentOtpFragment();
    localSignupPaymentOtpFragment.setArguments(localBundle);
    return localSignupPaymentOtpFragment;
  }

  private void updateUI()
  {
    UberButton localUberButton = this.mButtonVerify;
    if (!TextUtils.isEmpty(this.mEditTextOtp.getText()));
    for (boolean bool = true; ; bool = false)
    {
      localUberButton.setEnabled(bool);
      return;
    }
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.WALLET_OTP_AUTH;
  }

  @OnClick({2131427612})
  public void onClickVerify()
  {
    showLoadingDialogSticky(getString(2131559342), null);
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.WALLET_OTP_AUTH_VERIFY);
    this.mPaymentClient.validateCode(this.mUuid, this.mEditTextOtp.getText().toString());
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    this.mUuid = getArguments().getString("uuid");
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(2131689476, paramMenu);
    this.mMenuItemEdit = paramMenu.findItem(2131427938);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903137, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @Subscribe
  public void onManualRefreshEvent(ClientUpdateResponseEvent paramClientUpdateResponseEvent)
  {
    hideLoadingDialog();
    showToast(getString(2131559339));
    startActivity(SignupPaymentLastStepActivity.newIntent(this.mContext, this.mUuid));
    getActivity().finish();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem == this.mMenuItemEdit)
    {
      showLoadingDialogSticky(getString(2131559032), null);
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.WALLET_OTP_AUTH_RESEND);
      this.mPaymentClient.sendCode(this.mUuid);
      return true;
    }
    return false;
  }

  @Subscribe
  public void onPaymentSendCodeResponseEvent(PaymentSendCodeResponseEvent paramPaymentSendCodeResponseEvent)
  {
    hideLoadingDialog();
    if (paramPaymentSendCodeResponseEvent.isSuccess())
    {
      showToast(getString(2131559034));
      return;
    }
    showToast(getString(2131559033));
  }

  @Subscribe
  public void onPaymentValidateCodeResponseEvent(PaymentValidateCodeResponseEvent paramPaymentValidateCodeResponseEvent)
  {
    if (!paramPaymentValidateCodeResponseEvent.isSuccess())
    {
      this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.WALLET_OTP_AUTH_FAILURE);
      this.mEditTextOtp.setText(null);
      hideLoadingDialog();
      MessageDialogFragment.show((UberActivity)getActivity(), 900, null, getString(2131558894), getString(2131559111));
      return;
    }
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.WALLET_OTP_AUTH_SUCCESS);
    this.mRiderClient.manualRefresh();
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    if (!PingUtils.hasClient(localPing))
      return;
    this.mClient = localPing.getClient();
    String str = this.mClient.getEmail();
    this.mTextViewInstructionsSubtext.setText(String.format(getString(2131558982), new Object[] { str }));
  }

  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    super.onPrepareOptionsMenu(paramMenu);
    this.mMenuItemEdit.setTitle(getString(2131559031));
  }

  public void onResume()
  {
    super.onResume();
    this.mActionBar.setTitle(getString(2131558985));
  }

  @OnTextChanged({2131427611})
  public void onTextChangedOtp()
  {
    updateUI();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    updateUI();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPaymentOtpFragment
 * JD-Core Version:    0.6.2
 */