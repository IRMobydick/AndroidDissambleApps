package com.ubercab.client.feature.signup;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.feature.signup.event.SignupPendingConfirmedEvent;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class SignupPendingFragment extends RiderFragment
  implements SignupEvents
{
  private static final String ARG_EMAIL = "email";

  @Inject
  ActionBar mActionBar;

  @Inject
  Bus mBus;
  private String mClientEmail;

  @InjectView(2131427750)
  UberButton mDoneButton;

  @InjectView(2131427748)
  UberTextView mEmail;

  @InjectView(2131427747)
  UberTextView mExplanation;

  @InjectView(2131427749)
  UberTextView mNextSteps;

  public static Fragment newInstance(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("email", paramString);
    SignupPendingFragment localSignupPendingFragment = new SignupPendingFragment();
    localSignupPendingFragment.setArguments(localBundle);
    return localSignupPendingFragment;
  }

  public void onCancel()
  {
  }

  @OnClick({2131427750})
  public void onClickDone()
  {
    this.mBus.post(new SignupPendingConfirmedEvent());
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mClientEmail = getArguments().getString("email");
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903182, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    ButterKnife.reset(this);
  }

  public void onResume()
  {
    super.onResume();
    this.mActionBar.setTitle(getString(2131558874));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mExplanation.setText(getString(2131558831));
    this.mNextSteps.setText(getString(2131558828));
    this.mDoneButton.setText(getString(2131558813));
    this.mEmail.setText(this.mClientEmail);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPendingFragment
 * JD-Core Version:    0.6.2
 */