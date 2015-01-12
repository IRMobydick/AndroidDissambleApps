package com.ubercab.client.feature.signup;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderDialogFragment;
import com.ubercab.client.core.model.ApiResponse;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.ValidatePromoResponseEvent;
import com.ubercab.library.util.KeyboardUtils;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberEditText;
import javax.inject.Inject;

public class SignupPromoFragment extends RiderDialogFragment
{
  public static final String BUNDLE_SIGNUP_DATA = "signup_data";

  @InjectView(2131427754)
  UberButton mButtonAddPromo;

  @InjectView(2131427752)
  UberEditText mEditTextPromo;

  @InjectView(2131427463)
  ProgressBar mProgressBarLoading;

  @Inject
  RiderClient mRiderClient;
  private SignupData mSignupData;

  @InjectView(2131427751)
  View mViewContent;

  public static DialogFragment newInstance(SignupData paramSignupData, int paramInt)
  {
    Bundle localBundle = createArguments(paramInt);
    localBundle.putParcelable("signup_data", paramSignupData);
    SignupPromoFragment localSignupPromoFragment = new SignupPromoFragment();
    localSignupPromoFragment.setArguments(localBundle);
    return localSignupPromoFragment;
  }

  private void sendValidatePromoRequest()
  {
    showLoading(true);
    this.mEditTextPromo.setError(null);
    String str = this.mEditTextPromo.getText().toString();
    this.mRiderClient.validatePromo(str, false);
  }

  private void showLoading(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mProgressBarLoading.setVisibility(0);
      this.mViewContent.setVisibility(4);
      return;
    }
    this.mProgressBarLoading.setVisibility(8);
    this.mViewContent.setVisibility(0);
  }

  public int getTheme()
  {
    return 16973942;
  }

  @OnClick({2131427754})
  public void onAddPromoClicked()
  {
    sendValidatePromoRequest();
  }

  @OnClick({2131427753})
  public void onCancelClicked()
  {
    dismiss();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.mSignupData = ((SignupData)paramBundle.getParcelable("signup_data"));
      return;
    }
    this.mSignupData = ((SignupData)getArguments().getParcelable("signup_data"));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903183, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    KeyboardUtils.hideKeyboard(getActivity());
  }

  @OnEditorAction({2131427752})
  public boolean onEditorActionPromo()
  {
    sendValidatePromoRequest();
    return true;
  }

  public void onPause()
  {
    super.onPause();
    KeyboardUtils.hideKeyboard(getActivity(), this.mEditTextPromo);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("signup_data", this.mSignupData);
  }

  @OnTextChanged({2131427752})
  public void onTextChangedPromo(CharSequence paramCharSequence)
  {
    UberButton localUberButton = this.mButtonAddPromo;
    if (!TextUtils.isEmpty(this.mEditTextPromo.getText()));
    for (boolean bool = true; ; bool = false)
    {
      localUberButton.setEnabled(bool);
      return;
    }
  }

  @Subscribe
  public void onValidatePromoResponseEvent(ValidatePromoResponseEvent paramValidatePromoResponseEvent)
  {
    final ApiResponse localApiResponse = ((Ping)paramValidatePromoResponseEvent.getModel()).getApiResponse();
    if (!paramValidatePromoResponseEvent.isSuccess())
    {
      showLoading(false);
      this.mEditTextPromo.postDelayed(new Runnable()
      {
        public void run()
        {
          SignupPromoFragment.this.mEditTextPromo.setError(localApiResponse.getErrorMessage());
        }
      }
      , getResources().getInteger(17694720));
      return;
    }
    String str = this.mEditTextPromo.getText().toString();
    this.mSignupData.setPromoCode(SignupData.PromoCode.createFromData(str, localApiResponse.getData()));
    KeyboardUtils.hideKeyboard(getActivity(), this.mEditTextPromo);
    getArguments().putParcelable("signup_data", this.mSignupData);
    onResult(-1);
    dismiss();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mButtonAddPromo.setText(getString(2131558436));
    this.mEditTextPromo.setHint(getString(2131558844));
    KeyboardUtils.showKeyboard(getActivity());
    UberButton localUberButton = this.mButtonAddPromo;
    if (!TextUtils.isEmpty(this.mEditTextPromo.getText()));
    for (boolean bool = true; ; bool = false)
    {
      localUberButton.setEnabled(bool);
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPromoFragment
 * JD-Core Version:    0.6.2
 */