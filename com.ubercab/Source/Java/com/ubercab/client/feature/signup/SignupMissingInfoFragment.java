package com.ubercab.client.feature.signup;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.SignUpEvent;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.locale.SelectCountryActivity;
import com.ubercab.client.core.network.SignupClient;
import com.ubercab.client.core.network.events.ValidateAccountResponseEvent;
import com.ubercab.client.core.ui.FlagButton;
import com.ubercab.client.core.ui.PhoneNumberCountryTextWatcher;
import com.ubercab.client.core.ui.PhoneNumberCountryTextWatcher.Listener;
import com.ubercab.client.core.util.ValidationUtils;
import com.ubercab.client.feature.signup.event.SignupValidatedEvent;
import com.ubercab.common.collect.ImmutableMap;
import com.ubercab.library.ui.MessageDialogFragment;
import com.ubercab.library.util.KeyboardUtils;
import com.ubercab.ui.TextWatcherAdapter;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;

public class SignupMissingInfoFragment extends RiderFragment
  implements SignupEvents, PhoneNumberCountryTextWatcher.Listener
{
  private static final String ARG_SIGNUP_DATA = "signup_data";
  private static final int REQUEST_CODE_SELECT_COUNTRY = 800;

  @Inject
  ActionBar mActionBar;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @Inject
  Bus mBus;

  @InjectView(2131427727)
  UberButton mButtonNext;

  @InjectView(2131427722)
  UberEditText mEditTextFirstName;

  @InjectView(2131427723)
  UberEditText mEditTextLastName;

  @InjectView(2131427726)
  UberEditText mEditTextPhone;

  @InjectView(2131427725)
  FlagButton mFlagButtonCountry;

  @Inject
  SignupClient mSignupClient;
  private SignupData mSignupData;
  private PhoneNumberCountryTextWatcher mTextWatcherPhone;
  private UpdateUITextWatcher mTextWatcherUpdateUI;

  public static Fragment newInstance(SignupData paramSignupData)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("signup_data", paramSignupData);
    SignupMissingInfoFragment localSignupMissingInfoFragment = new SignupMissingInfoFragment();
    localSignupMissingInfoFragment.setArguments(localBundle);
    return localSignupMissingInfoFragment;
  }

  private void sendValidateAccountRequest()
  {
    KeyboardUtils.hideKeyboard(getActivity(), this.mEditTextFirstName);
    String str1 = this.mEditTextPhone.getText().toString();
    String str2 = this.mFlagButtonCountry.getCountryIso2();
    showLoadingDialogSticky(getString(2131559341), null);
    this.mSignupClient.validateAccount(this.mSignupData.getEmail(), str1, str2, "thisisnotarealpassword1234567$");
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

  private void updateUI()
  {
    if ((!TextUtils.isEmpty(this.mEditTextFirstName.getText())) && (!TextUtils.isEmpty(this.mEditTextLastName.getText())) && (!TextUtils.isEmpty(this.mEditTextPhone.getText())));
    for (boolean bool = true; ; bool = false)
    {
      this.mButtonNext.setEnabled(bool);
      return;
    }
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 800) && (paramInt2 == -1))
    {
      setCountry(paramIntent.getStringExtra("country_iso2"));
      this.mEditTextPhone.setText("");
    }
  }

  public void onCancel()
  {
    this.mAnalyticsManager.signUpEvent().signUpCancel(this.mSignupData);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mSignupData = ((SignupData)getArguments().getParcelable("signup_data"));
    this.mTextWatcherUpdateUI = new UpdateUITextWatcher(null);
    this.mTextWatcherPhone = new PhoneNumberCountryTextWatcher();
    this.mTextWatcherPhone.setListener(this);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903179, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    ButterKnife.reset(this);
  }

  @OnEditorAction({2131427726})
  public boolean onEditorActionPhone()
  {
    sendValidateAccountRequest();
    return true;
  }

  @OnClick({2131427725})
  public void onFlagClicked()
  {
    startActivityForResult(new Intent(getActivity(), SelectCountryActivity.class), 800);
  }

  @OnClick({2131427727})
  public void onNextClicked()
  {
    sendValidateAccountRequest();
  }

  public void onPhoneTextWatcherCountryChanged(String paramString)
  {
    setCountry(paramString);
  }

  public void onResume()
  {
    super.onResume();
    this.mActionBar.setTitle(getString(2131558785));
    updateUI();
  }

  @Subscribe
  public void onValidateAccountResponseEvent(ValidateAccountResponseEvent paramValidateAccountResponseEvent)
  {
    hideLoadingDialog();
    if (paramValidateAccountResponseEvent.isSuccess())
    {
      this.mSignupData.setFirstName(this.mEditTextFirstName.getText().toString());
      this.mSignupData.setLastName(this.mEditTextLastName.getText().toString());
      this.mSignupData.setMobile(this.mEditTextPhone.getText().toString(), this.mFlagButtonCountry.getCountryIso2());
      this.mBus.post(new SignupValidatedEvent(this.mSignupData));
    }
    Map localMap;
    do
    {
      do
      {
        return;
        localMap = paramValidateAccountResponseEvent.getErrorHash();
      }
      while (localMap == null);
      ValidationUtils.showValidationErrors(localMap, ImmutableMap.of("mobile", this.mEditTextPhone));
    }
    while (!localMap.containsKey("error"));
    MessageDialogFragment.show(getRiderActivity(), 0, null, (String)localMap.get("error"));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mEditTextFirstName.setHint(getString(2131558875));
    this.mEditTextFirstName.addTextChangedListener(this.mTextWatcherUpdateUI);
    this.mEditTextLastName.setHint(getString(2131558903));
    this.mEditTextLastName.addTextChangedListener(this.mTextWatcherUpdateUI);
    this.mEditTextPhone.setHint(getString(2131558932));
    this.mEditTextPhone.addTextChangedListener(this.mTextWatcherUpdateUI);
    this.mEditTextPhone.addTextChangedListener(this.mTextWatcherPhone);
    this.mButtonNext.setText(getString(2131558936));
    if (paramBundle == null)
    {
      this.mEditTextFirstName.setText(this.mSignupData.getFirstName());
      this.mEditTextLastName.setText(this.mSignupData.getLastName());
      this.mEditTextPhone.setText(this.mSignupData.getMobile());
      this.mFlagButtonCountry.setCountryIso2(this.mSignupData.getMobileCountryIso2());
    }
  }

  private class UpdateUITextWatcher extends TextWatcherAdapter
  {
    private UpdateUITextWatcher()
    {
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      SignupMissingInfoFragment.this.updateUI();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupMissingInfoFragment
 * JD-Core Version:    0.6.2
 */