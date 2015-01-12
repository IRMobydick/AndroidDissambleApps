package com.ubercab.client.feature.verification;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.locale.SelectCountryActivity;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.ClientUpdateResponseEvent;
import com.ubercab.client.core.ui.FlagButton;
import com.ubercab.client.core.ui.PhoneNumberCountryTextWatcher;
import com.ubercab.client.core.ui.PhoneNumberCountryTextWatcher.Listener;
import com.ubercab.client.feature.verification.event.PhoneNumberChangeEvent;
import com.ubercab.library.ui.MessageDialogFragment;
import com.ubercab.library.util.KeyboardUtils;
import com.ubercab.ui.TextWatcherAdapter;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;
import java.util.Locale;
import javax.inject.Inject;

public class MobileVerificationChangeNumberFragment extends RiderFragment
  implements PhoneNumberCountryTextWatcher.Listener
{
  private static final int REQUEST_CODE_SELECT_COUNTRY = 800;

  @Inject
  ActionBar mActionBar;

  @Inject
  Bus mBus;

  @InjectView(2131427910)
  UberButton mButtonContinue;

  @InjectView(2131427726)
  UberEditText mEditTextPhone;

  @InjectView(2131427725)
  FlagButton mFlagButtonCountry;
  private boolean mIsPhoneNumberSet;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427909)
  UberTextView mTextViewNotice;
  private PhoneNumberCountryTextWatcher mTextWatcherPhone;

  public static MobileVerificationChangeNumberFragment newInstance()
  {
    return new MobileVerificationChangeNumberFragment();
  }

  private void setCountry(String paramString)
  {
    if (paramString != null)
      paramString = paramString.toUpperCase(Locale.US);
    this.mFlagButtonCountry.setCountryIso2(paramString);
    this.mTextWatcherPhone.setCountryCode(paramString);
    PhoneNumberUtil localPhoneNumberUtil = PhoneNumberUtil.getInstance();
    Phonenumber.PhoneNumber localPhoneNumber = localPhoneNumberUtil.getExampleNumber(paramString);
    if (localPhoneNumber != null)
    {
      this.mEditTextPhone.setHint(localPhoneNumberUtil.format(localPhoneNumber, PhoneNumberUtil.PhoneNumberFormat.NATIONAL));
      return;
    }
    this.mEditTextPhone.setHint(getString(2131558932));
  }

  private void startSelectCountryActivityForResult()
  {
    startActivityForResult(new Intent(getActivity(), SelectCountryActivity.class), 800);
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 800) && (paramInt2 == -1))
    {
      setCountry(paramIntent.getStringExtra("country_iso2"));
      this.mEditTextPhone.setText(null);
    }
  }

  @OnClick({2131427910})
  public void onClickButtonContinue()
  {
    showLoadingDialogSticky(getString(2131558909), null);
    String str1 = this.mEditTextPhone.getText().toString();
    String str2 = this.mFlagButtonCountry.getCountryIso2();
    this.mRiderClient.updateMobileNumber(str1, str2);
  }

  @OnClick({2131427725})
  public void onClickButtonFlag()
  {
    startSelectCountryActivityForResult();
  }

  @Subscribe
  public void onClientUpdated(ClientUpdateResponseEvent paramClientUpdateResponseEvent)
  {
    hideLoadingDialog();
    if (paramClientUpdateResponseEvent.isSuccess())
    {
      this.mBus.post(new PhoneNumberChangeEvent());
      return;
    }
    String str = getString(2131558973);
    MessageDialogFragment.show(getRiderActivity(), 0, null, paramClientUpdateResponseEvent.getErrorMessage(getActivity()), str);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mTextWatcherPhone = new PhoneNumberCountryTextWatcher();
    this.mTextWatcherPhone.setListener(this);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903224, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    KeyboardUtils.hideKeyboard(getActivity(), this.mEditTextPhone);
    ButterKnife.reset(this);
  }

  public void onPhoneTextWatcherCountryChanged(String paramString)
  {
    setCountry(paramString);
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    if (this.mIsPhoneNumberSet)
      return;
    Client localClient = paramPingEvent.getPing().getClient();
    this.mEditTextPhone.setText(localClient.getMobile());
    this.mEditTextPhone.setSelection(this.mEditTextPhone.getText().length());
    setCountry(localClient.getMobileCountryIso2());
    KeyboardUtils.showKeyboard(getActivity(), this.mEditTextPhone);
    this.mIsPhoneNumberSet = true;
  }

  public void onResume()
  {
    super.onResume();
    this.mActionBar.setTitle(getString(2131558517));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mButtonContinue.setText(getString(2131558524));
    this.mTextViewNotice.setText(getString(2131559334));
    this.mEditTextPhone.addTextChangedListener(this.mTextWatcherPhone);
    this.mEditTextPhone.addTextChangedListener(new UpdateUITextWatcher(null));
  }

  private class UpdateUITextWatcher extends TextWatcherAdapter
  {
    private UpdateUITextWatcher()
    {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      UberButton localUberButton = MobileVerificationChangeNumberFragment.this.mButtonContinue;
      if (!TextUtils.isEmpty(MobileVerificationChangeNumberFragment.this.mEditTextPhone.getText()));
      for (boolean bool = true; ; bool = false)
      {
        localUberButton.setEnabled(bool);
        return;
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.verification.MobileVerificationChangeNumberFragment
 * JD-Core Version:    0.6.2
 */