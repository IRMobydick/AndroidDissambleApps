package com.ubercab.client.feature.faresplit.minion;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Subscribe;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.FareSplitEvent;
import com.ubercab.client.core.app.RiderDialogFragment;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.FareSplit;
import com.ubercab.client.core.model.FareSplitClient;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.FareSplitAcceptResponseEvent;
import com.ubercab.client.core.network.events.FareSplitDeclineResponseEvent;
import com.ubercab.client.core.vendor.paypal.PayPalUtils;
import com.ubercab.common.base.Objects;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class FareSplitInvitationFragment extends RiderDialogFragment
  implements DialogInterface.OnKeyListener
{

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @InjectView(2131427462)
  UberButton mButtonAccept;

  @InjectView(2131427461)
  UberButton mButtonDecline;

  @InjectView(2131427457)
  ImageView mImageViewPicture;
  private PaymentProfile mPaymentProfile;

  @Inject
  Picasso mPicasso;

  @InjectView(2131427463)
  ProgressBar mProgressBarLoading;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427460)
  UberTextView mTextViewFee;

  @InjectView(2131427459)
  UberTextView mTextViewSubtitle;

  @InjectView(2131427458)
  UberTextView mTextViewTitle;

  @InjectView(2131427452)
  View mViewContent;

  private void sendFareSplitAcceptRequest()
  {
    showLoading(true);
    PaymentProfile localPaymentProfile = this.mPaymentProfile;
    String str1 = null;
    String str2 = null;
    if (localPaymentProfile != null)
    {
      boolean bool = "PayPal".equals(this.mPaymentProfile.getCardType());
      str1 = null;
      str2 = null;
      if (bool)
      {
        str1 = this.mPaymentProfile.getId();
        str2 = PayPalUtils.getCorrelationId(getActivity());
      }
    }
    this.mRiderClient.fareSplitAccept(str1, str2);
    this.mAnalyticsManager.fareSplitEvent().accept();
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.FARE_SPLIT_ACCEPT);
  }

  private void sendFareSplitDeclineRequest()
  {
    showLoading(true);
    this.mRiderClient.fareSplitDecline();
    this.mAnalyticsManager.fareSplitEvent().decline();
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.FARE_SPLIT_REJECT);
  }

  private void showLoading(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mProgressBarLoading.setVisibility(0);
      this.mViewContent.setVisibility(4);
      return;
    }
    this.mProgressBarLoading.setVisibility(4);
    this.mViewContent.setVisibility(0);
  }

  @OnClick({2131427462})
  public void onButtonAcceptClicked()
  {
    sendFareSplitAcceptRequest();
  }

  @OnClick({2131427461})
  public void onButtonDeclineClicked()
  {
    sendFareSplitDeclineRequest();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setStyle(1, 2131624113);
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    Dialog localDialog = super.onCreateDialog(paramBundle);
    localDialog.setCancelable(false);
    localDialog.setCanceledOnTouchOutside(false);
    localDialog.setOnKeyListener(this);
    return localDialog;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903085, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @Subscribe
  public void onFareSplitAcceptResponseEvent(FareSplitAcceptResponseEvent paramFareSplitAcceptResponseEvent)
  {
    if (!paramFareSplitAcceptResponseEvent.isSuccess())
    {
      Toast.makeText(getActivity(), paramFareSplitAcceptResponseEvent.getErrorMessage(getActivity()), 0).show();
      showLoading(false);
      return;
    }
    dismiss();
  }

  @Subscribe
  public void onFareSplitDeclineResponseEvent(FareSplitDeclineResponseEvent paramFareSplitDeclineResponseEvent)
  {
    if (!paramFareSplitDeclineResponseEvent.isSuccess())
    {
      Toast.makeText(getActivity(), paramFareSplitDeclineResponseEvent.getErrorMessage(getActivity()), 0).show();
      showLoading(false);
      return;
    }
    dismiss();
  }

  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    return paramInt == 4;
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    FareSplitClient localFareSplitClient1 = localPing.getFareSplit().getClientInitiator();
    FareSplitClient localFareSplitClient2 = localPing.getFareSplit().getClientSelf();
    if ((localFareSplitClient2 == null) || (!localFareSplitClient2.getStatus().equals("Pending")))
    {
      dismiss();
      return;
    }
    String str = localFareSplitClient1.getDisplayNameOrNumber();
    this.mTextViewSubtitle.setText(getString(2131558863, new Object[] { str }));
    this.mTextViewFee.setText(localFareSplitClient2.getFeeString());
    if (!TextUtils.isEmpty(localFareSplitClient1.getPictureUrl()))
      if (!Objects.equal(localFareSplitClient1.getPictureUrl(), this.mImageViewPicture.getTag()))
      {
        this.mImageViewPicture.setTag(localFareSplitClient1.getPictureUrl());
        this.mPicasso.load(localFareSplitClient1.getPictureUrl()).placeholder(2130837854).error(2130837854).into(this.mImageViewPicture);
      }
    while (true)
    {
      showLoading(false);
      return;
      this.mImageViewPicture.setImageResource(2130837854);
    }
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mTextViewTitle.setText(getString(2131559078));
    this.mButtonAccept.setText(getString(2131558861));
    this.mButtonDecline.setText(getString(2131558862));
    showLoading(true);
  }

  public void setPaymentProfile(PaymentProfile paramPaymentProfile)
  {
    this.mPaymentProfile = paramPaymentProfile;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.minion.FareSplitInvitationFragment
 * JD-Core Version:    0.6.2
 */