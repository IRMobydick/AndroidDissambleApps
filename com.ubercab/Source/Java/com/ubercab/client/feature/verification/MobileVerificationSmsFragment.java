package com.ubercab.client.feature.verification;

import android.app.ActionBar;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.RequestMobileConfirmationResponseEvent;
import com.ubercab.client.feature.verification.event.SelectPhoneNumberChangeEvent;
import com.ubercab.library.util.PhoneNumberUtils;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class MobileVerificationSmsFragment extends RiderFragment
{

  @Inject
  ActionBar mActionBar;

  @Inject
  Bus mBus;

  @InjectView(2131427916)
  UberButton mButtonChangeNumber;

  @InjectView(2131427915)
  UberButton mButtonResendSms;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427928)
  UberTextView mTextViewActionRequired;

  @InjectView(2131427914)
  UberTextView mTextViewPhoneNumber;

  @InjectView(2131427913)
  UberTextView mTextViewReplyMessage;

  @InjectView(2131427911)
  UberTextView mTextViewReplyTitle;

  private void displayPhoneNumber(String paramString1, String paramString2)
  {
    String str = PhoneNumberUtils.getDisplayPhoneNumber(paramString1, paramString2);
    this.mTextViewPhoneNumber.setText(str);
  }

  public static MobileVerificationSmsFragment newInstance()
  {
    return new MobileVerificationSmsFragment();
  }

  @OnClick({2131427916})
  public void onClickButtonChangeNumber()
  {
    this.mBus.post(new SelectPhoneNumberChangeEvent());
  }

  @OnClick({2131427915})
  public void onClickButtonResendSms()
  {
    showLoadingDialogSticky(getString(2131559036), null);
    this.mRiderClient.requestMobileConfirmation();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903225, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Client localClient = paramPingEvent.getPing().getClient();
    displayPhoneNumber(localClient.getMobileDigits(), localClient.getMobileCountryIso2());
  }

  @Subscribe
  public void onRequestMobileConfirmationResponseEvent(RequestMobileConfirmationResponseEvent paramRequestMobileConfirmationResponseEvent)
  {
    hideLoadingDialog();
    if (!paramRequestMobileConfirmationResponseEvent.isSuccess())
      showToast(paramRequestMobileConfirmationResponseEvent.getErrorMessage(getActivity()));
  }

  public void onResume()
  {
    super.onResume();
    this.mActionBar.setTitle(getString(2131559332));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mButtonResendSms.setText(getString(2131559035));
    this.mButtonChangeNumber.setText(getString(2131559333));
    this.mTextViewActionRequired.setText(getString(2131558421));
    this.mTextViewReplyMessage.setText(getString(2131559335));
    SpannableString localSpannableString = new SpannableString(getString(2131559310));
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131296333)), 0, localSpannableString.length(), 33);
    localSpannableString.setSpan(new StyleSpan(1), 0, localSpannableString.length(), 33);
    String str = getString(2131559336, new Object[] { localSpannableString });
    this.mTextViewReplyTitle.setText(str);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.verification.MobileVerificationSmsFragment
 * JD-Core Version:    0.6.2
 */