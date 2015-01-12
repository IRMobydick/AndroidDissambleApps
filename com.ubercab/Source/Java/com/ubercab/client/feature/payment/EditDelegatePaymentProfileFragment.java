package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.payment.event.DeletedPaymentProfileEvent;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class EditDelegatePaymentProfileFragment extends RiderFragment
{
  private static final String ARG_PAYMENT_PROFILE_ID = "payment_profile_id";

  @Inject
  ActionBar mActionBar;

  @Inject
  Bus mBus;
  private String mPaymentProfileId;

  @Inject
  PingProvider mPingProvider;

  @InjectView(2131427561)
  UberTextView mTextViewNoEditMessage;

  @InjectView(2131427560)
  UberTextView mTextViewPaymentProfileName;

  public static EditDelegatePaymentProfileFragment newInstance(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("payment_profile_id", paramString);
    EditDelegatePaymentProfileFragment localEditDelegatePaymentProfileFragment = new EditDelegatePaymentProfileFragment();
    localEditDelegatePaymentProfileFragment.setArguments(localBundle);
    return localEditDelegatePaymentProfileFragment;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null)
      this.mPaymentProfileId = localBundle.getString("payment_profile_id");
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903129, paramViewGroup, false);
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
    Ping localPing = paramPingEvent.getPing();
    if (!PingUtils.hasClientPaymentProfiles(localPing))
      this.mBus.post(new DeletedPaymentProfileEvent());
    while (localPing.getClient().findPaymentProfileWithId(this.mPaymentProfileId) != null)
      return;
    this.mBus.post(new DeletedPaymentProfileEvent());
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    PaymentProfile localPaymentProfile = this.mPingProvider.get().getClient().findPaymentProfileWithId(this.mPaymentProfileId);
    this.mTextViewPaymentProfileName.setText(localPaymentProfile.getAccountName());
    this.mTextViewNoEditMessage.setText(getString(2131558798));
    this.mActionBar.setTitle(getString(2131558985));
    this.mActionBar.setDisplayShowCustomEnabled(false);
    this.mActionBar.setDisplayShowTitleEnabled(true);
    this.mActionBar.setDisplayHomeAsUpEnabled(true);
    this.mActionBar.setDisplayShowHomeEnabled(true);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditDelegatePaymentProfileFragment
 * JD-Core Version:    0.6.2
 */