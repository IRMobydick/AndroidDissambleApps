package com.ubercab.client.feature.verification;

import android.app.ActionBar;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
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
import com.ubercab.client.core.network.events.ConfirmMobileResponseEvent;
import com.ubercab.client.core.network.events.RequestMobileConfirmationResponseEvent;
import com.ubercab.client.feature.verification.event.SelectPhoneNumberChangeEvent;
import com.ubercab.library.util.PhoneNumberUtils;
import com.ubercab.ui.TextWatcherAdapter;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class MobileVerificationTokenFragment extends RiderFragment
{
  private static int MAX_LENGTH_TOKEN = 4;

  @Inject
  ActionBar mActionBar;

  @Inject
  Bus mBus;

  @InjectView(2131427916)
  UberButton mButtonChangeNumber;

  @InjectView(2131427920)
  UberButton mButtonResendToken;

  @InjectView(2131427919)
  UberEditText mEditTextToken;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427918)
  UberTextView mTextViewTokenMessage;

  @InjectView(2131427917)
  UberTextView mTextViewTokenTitle;

  public static MobileVerificationTokenFragment newInstance()
  {
    return new MobileVerificationTokenFragment();
  }

  private void sendConfirmMobileRequest(String paramString)
  {
    showLoadingDialogSticky(getString(2131559343), null);
    this.mRiderClient.confirmMobile(paramString);
  }

  @OnClick({2131427916})
  public void onClickButtonChangeNumber()
  {
    this.mBus.post(new SelectPhoneNumberChangeEvent());
  }

  @OnClick({2131427920})
  public void onClickButtonResendToken()
  {
    showLoadingDialogSticky(getString(2131559036), null);
    this.mRiderClient.requestMobileConfirmation();
  }

  @Subscribe
  public void onConfirmMobileResponseEvent(ConfirmMobileResponseEvent paramConfirmMobileResponseEvent)
  {
    hideLoadingDialog();
    if (!paramConfirmMobileResponseEvent.isSuccess())
      showToast(paramConfirmMobileResponseEvent.getErrorMessage(getActivity()));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903226, paramViewGroup, false);
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
    String str = PhoneNumberUtils.getDisplayPhoneNumber(localClient.getMobileDigits(), localClient.getMobileCountryIso2());
    this.mTextViewTokenMessage.setText(getString(2131559337, new Object[] { str }));
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
    this.mButtonResendToken.setText(getString(2131559035));
    this.mButtonChangeNumber.setText(getString(2131559333));
    this.mTextViewTokenTitle.setText(getString(2131559338));
    UberEditText localUberEditText = this.mEditTextToken;
    InputFilter[] arrayOfInputFilter = new InputFilter[1];
    arrayOfInputFilter[0] = new InputFilter.LengthFilter(MAX_LENGTH_TOKEN);
    localUberEditText.setFilters(arrayOfInputFilter);
    this.mEditTextToken.addTextChangedListener(new TextWatcherAdapter()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        String str = paramAnonymousEditable.toString();
        if (str.length() == MobileVerificationTokenFragment.MAX_LENGTH_TOKEN)
          MobileVerificationTokenFragment.this.sendConfirmMobileRequest(str);
      }
    });
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.verification.MobileVerificationTokenFragment
 * JD-Core Version:    0.6.2
 */