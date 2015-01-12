package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.DeletePaymentProfileResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.payment.event.DeletedPaymentProfileEvent;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import java.util.List;
import javax.inject.Inject;

public class EditThirdPartyPaymentProviderFragment extends RiderFragment
{
  private static final String ARG_PAYMENT_PROFILE_ID = "payment_profile_id";
  private static final int REQUEST_CODE_DELETE_PAYMENT_METHOD = 1;

  @Inject
  ActionBar mActionBar;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  Bus mBus;

  @InjectView(2131427605)
  UberButton mButtonDelete;

  @Inject
  DeletePaymentDialogPresenter mDeletePaymentDialogPresenter;

  @InjectView(2131427647)
  ImageView mImageViewPaymentProvider;
  private String mPaymentProfileId;

  @Inject
  PingProvider mPingProvider;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427648)
  UberTextView mTextViewEmail;

  public static EditThirdPartyPaymentProviderFragment newInstance(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("payment_profile_id", paramString);
    EditThirdPartyPaymentProviderFragment localEditThirdPartyPaymentProviderFragment = new EditThirdPartyPaymentProviderFragment();
    localEditThirdPartyPaymentProviderFragment.setArguments(localBundle);
    return localEditThirdPartyPaymentProviderFragment;
  }

  private void sendDeletePaymentProfileRequest()
  {
    showLoadingDialogSticky(getString(2131558802), null);
    this.mRiderClient.deletePaymentProfile(this.mPaymentProfileId);
  }

  @OnClick({2131427605})
  public void onClickButtonDelete()
  {
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.PAYMENT_METHOD_DELETE_CONFIRMATION);
    this.mDeletePaymentDialogPresenter.show(getRiderActivity(), 1);
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
    View localView = paramLayoutInflater.inflate(2130903148, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  @Subscribe
  public void onDeletePaymentProfileResponseEvent(DeletePaymentProfileResponseEvent paramDeletePaymentProfileResponseEvent)
  {
    hideLoadingDialog();
    if (!paramDeletePaymentProfileResponseEvent.isSuccess())
    {
      showToast(paramDeletePaymentProfileResponseEvent.getErrorMessage(getActivity()));
      return;
    }
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.PAYMENT_METHOD_DELETE_SUCCESS);
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  public void onDialogResult(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
      sendDeletePaymentProfileRequest();
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    if (!PingUtils.hasClientPaymentProfiles(localPing))
    {
      this.mBus.post(new DeletedPaymentProfileEvent());
      return;
    }
    if (localPing.getClient().findPaymentProfileWithId(this.mPaymentProfileId) == null)
    {
      this.mBus.post(new DeletedPaymentProfileEvent());
      return;
    }
    if (localPing.getClient().getPaymentProfiles().size() > 1)
    {
      this.mButtonDelete.setVisibility(0);
      return;
    }
    this.mButtonDelete.setVisibility(8);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    PaymentProfile localPaymentProfile = this.mPingProvider.get().getClient().findPaymentProfileWithId(this.mPaymentProfileId);
    this.mTextViewEmail.setText(localPaymentProfile.getAccountName());
    String str = localPaymentProfile.getCardType();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 1963873898:
    case -1911368973:
    }
    while (true)
      switch (i)
      {
      default:
        throw new RuntimeException("Payment type is not supported.");
        if (str.equals("Alipay"))
        {
          i = 0;
          continue;
          if (str.equals("PayPal"))
            i = 1;
        }
        break;
      case 0:
      case 1:
      }
    this.mImageViewPaymentProvider.setContentDescription(getString(2131558441));
    this.mImageViewPaymentProvider.setImageDrawable(getResources().getDrawable(2130837621));
    while (true)
    {
      this.mButtonDelete.setText(getString(2131558799));
      this.mActionBar.setTitle(getString(2131558985));
      this.mActionBar.setDisplayShowCustomEnabled(false);
      this.mActionBar.setDisplayShowTitleEnabled(true);
      this.mActionBar.setDisplayHomeAsUpEnabled(true);
      this.mActionBar.setDisplayShowHomeEnabled(true);
      return;
      this.mImageViewPaymentProvider.setContentDescription(getString(2131558996));
      this.mImageViewPaymentProvider.setImageDrawable(getResources().getDrawable(2130837839));
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditThirdPartyPaymentProviderFragment
 * JD-Core Version:    0.6.2
 */