package com.ubercab.client.feature.faresplit.master;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.FareSplitEvent;
import com.ubercab.client.core.app.RiderDialogFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.FareSplit;
import com.ubercab.client.core.model.FareSplitClient;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.FareSplitDeclineResponseEvent;
import com.ubercab.client.core.network.events.FareSplitUnInviteResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.faresplit.master.event.FareSplitClientUninvitedEvent;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import java.util.List;
import javax.inject.Inject;

public class FareSplitSummaryFragment extends RiderDialogFragment
  implements FareSplitSummaryAdapter.Listener
{
  private static final int RESULT_CODE_INVITE = 2001;
  private FareSplitSummaryAdapter mAdapterSummary;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @Inject
  Bus mBus;

  @InjectView(2131427465)
  ImageButton mButtonInvite;

  @InjectView(2131427468)
  UberButton mButtonOk;

  @InjectView(2131427467)
  ListView mListViewSummary;

  @Inject
  PingProvider mPingProvider;

  @InjectView(2131427463)
  ProgressBar mProgressBarLoading;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427458)
  UberTextView mTextViewTitle;

  @InjectView(2131427464)
  ViewGroup mViewGroupContent;

  private void sendFareSplitDeclineRequest()
  {
    showLoading(true);
    this.mRiderClient.fareSplitDecline();
    this.mAnalyticsManager.fareSplitEvent().decline();
  }

  private void sendFareSplitUninviteRequest(FareSplitClient paramFareSplitClient)
  {
    String str = paramFareSplitClient.getMobileDigits();
    if (TextUtils.isEmpty(str))
      return;
    showLoading(true);
    this.mRiderClient.fareSplitUninvite(str);
    this.mAnalyticsManager.fareSplitEvent().uninvite();
  }

  private void showLoading(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mProgressBarLoading.setVisibility(0);
      this.mViewGroupContent.setVisibility(4);
      return;
    }
    this.mProgressBarLoading.setVisibility(4);
    this.mViewGroupContent.setVisibility(0);
  }

  private void updateUI(Ping paramPing)
  {
    if (!PingUtils.hasFareSplit(paramPing))
    {
      dismiss();
      return;
    }
    FareSplit localFareSplit = paramPing.getFareSplit();
    UberTextView localUberTextView = this.mTextViewTitle;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(localFareSplit.getClients().size());
    localUberTextView.setText(getString(2131558865, arrayOfObject));
    this.mAdapterSummary.update(localFareSplit);
    FareSplitClient localFareSplitClient = localFareSplit.getClientSelf();
    if ((localFareSplitClient == null) || (!localFareSplitClient.isInitiator()))
    {
      this.mButtonInvite.setVisibility(8);
      return;
    }
    int i = paramPing.getMaxFareSplits();
    int j = localFareSplit.getClients().size();
    ImageButton localImageButton = this.mButtonInvite;
    int k = 0;
    if (j < i);
    while (true)
    {
      localImageButton.setVisibility(k);
      return;
      k = 8;
    }
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 2001) && (paramInt2 == -1))
      updateUI(this.mPingProvider.get());
  }

  @OnClick({2131427465})
  public void onClickButtonInvite()
  {
    startActivityForResult(new Intent(getActivity(), FareSplitInviteActivity.class), 2001);
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.FARE_SPLIT_SEND);
  }

  @OnClick({2131427468})
  public void onClickButtonOk()
  {
    dismiss();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mAnalyticsManager.setProductDetailShowing(true);
    setStyle(1, 0);
    this.mAdapterSummary = new FareSplitSummaryAdapter(getActivity());
    this.mAdapterSummary.setListener(this);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903086, paramViewGroup, false);
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
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.FARE_SPLIT_CANCEL);
    this.mAnalyticsManager.setProductDetailShowing(false);
  }

  @Subscribe
  public void onFareSplitDeclineResponseEvent(FareSplitDeclineResponseEvent paramFareSplitDeclineResponseEvent)
  {
    dismiss();
  }

  @Subscribe
  public void onFareSplitUnInviteReceived(FareSplitUnInviteResponseEvent paramFareSplitUnInviteResponseEvent)
  {
    showLoading(false);
    this.mBus.post(new FareSplitClientUninvitedEvent());
  }

  public void onUninviteClicked(FareSplitClient paramFareSplitClient)
  {
    if (paramFareSplitClient == null)
      return;
    if (paramFareSplitClient.isSelf())
    {
      sendFareSplitDeclineRequest();
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.FARE_SPLIT_REMOVE_SELF);
      return;
    }
    sendFareSplitUninviteRequest(paramFareSplitClient);
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.FARE_SPLIT_REMOVE_RECIPIENT);
  }

  @Subscribe
  public void onUpdatePing(PingEvent paramPingEvent)
  {
    updateUI(paramPingEvent.getPing());
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.mButtonInvite.setContentDescription(getString(2131558869));
    this.mListViewSummary.setDrawSelectorOnTop(true);
    this.mListViewSummary.setAdapter(this.mAdapterSummary);
    this.mButtonOk.setText(getString(2131558973));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitSummaryFragment
 * JD-Core Version:    0.6.2
 */