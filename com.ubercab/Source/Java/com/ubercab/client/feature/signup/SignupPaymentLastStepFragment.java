package com.ubercab.client.feature.signup;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
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
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.feature.payment.AddFundsActivity;
import com.ubercab.client.feature.signup.event.SignupSelectPromoCodeEvent;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class SignupPaymentLastStepFragment extends RiderFragment
{
  private static final String ARG_UUID = "uuid";

  @Inject
  ActionBar mActionBar;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  Bus mBus;

  @InjectView(2131427659)
  UberButton mButtonAddFunds;

  @InjectView(2131427745)
  UberButton mButtonPromoCode;

  @Inject
  Context mContext;
  private MenuItem mMenuItemEdit;

  @InjectView(2131427744)
  UberTextView mTextViewDescription;

  @InjectView(2131427928)
  UberTextView mTextViewTitle;
  private String mUuid;

  public static SignupPaymentLastStepFragment newInstance(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uuid", paramString);
    SignupPaymentLastStepFragment localSignupPaymentLastStepFragment = new SignupPaymentLastStepFragment();
    localSignupPaymentLastStepFragment.setArguments(localBundle);
    return localSignupPaymentLastStepFragment;
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.WALLET_FUND;
  }

  @OnClick({2131427659})
  public void onClickAddFunds()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.WALLET_FUND_ADD_MONEY_BUTTON);
    startActivity(AddFundsActivity.newIntent(this.mContext, this.mUuid));
    getActivity().finish();
  }

  @OnClick({2131427745})
  public void onClickPromoCode()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.WALLET_FUND_PROMO);
    this.mBus.post(new SignupSelectPromoCodeEvent());
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
    View localView = paramLayoutInflater.inflate(2130903181, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem == this.mMenuItemEdit)
    {
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.WALLET_FUND_X_OUT);
      getActivity().finish();
      return true;
    }
    return false;
  }

  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    super.onPrepareOptionsMenu(paramMenu);
    this.mMenuItemEdit.setTitle(getString(2131559074));
  }

  public void onResume()
  {
    super.onResume();
    this.mActionBar.setTitle(getString(2131558446));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mButtonAddFunds.setText(getString(2131558434));
    this.mButtonPromoCode.setText(getString(2131558889));
    this.mTextViewTitle.setText(getString(2131558975));
    this.mTextViewDescription.setText(getString(2131558976));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupPaymentLastStepFragment
 * JD-Core Version:    0.6.2
 */