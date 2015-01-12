package com.ubercab.client.feature.payment;

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
import android.widget.ImageView;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.PaymentCheckBalanceResponse;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.event.ClientEvent;
import com.ubercab.client.core.network.PaymentClient;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.DeletePaymentProfileResponseEvent;
import com.ubercab.client.core.network.events.PaymentCheckBalanceResponseEvent;
import com.ubercab.client.feature.payment.event.DeletedPaymentProfileEvent;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.ui.UberButton;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class EditWalletPaymentFragment extends RiderFragment
{
  private static final String ARG_PAYMENT_PROFILE_ID = "payment_profile_id";
  private static final String BUNDLE_IS_EDIT_MODE = "is_edit_mode";
  private static final int REQUEST_CODE_DELETE_PAYMENT_METHOD = 1;

  @Inject
  ActionBar mActionBar;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  Bus mBus;

  @InjectView(2131427659)
  UberButton mButtonAddFunds;

  @InjectView(2131427605)
  UberButton mButtonDelete;

  @Inject
  Context mContext;

  @Inject
  DeletePaymentDialogPresenter mDeletePaymentDialogPresenter;

  @InjectView(2131427658)
  ImageView mImageViewWalletPaymentProvider;
  private boolean mIsEditMode;
  private MenuItem mMenuItemEdit;
  private String mMobile;

  @Inject
  PaymentClient mPaymentClient;
  private String mPaymentProfileId;

  @InjectView(2131427584)
  ProgressBar mProgressBarCurrentBalanceRequest;

  @Inject
  RiderClient mRiderClient;

  @InjectView(2131427583)
  UberTextView mTextViewBalanceValue;

  @InjectView(2131427928)
  UberTextView mTextViewHeader;

  @InjectView(2131427650)
  UberTextView mTextViewNumber;
  private String mUuid;

  public static EditWalletPaymentFragment newInstance(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("payment_profile_id", paramString);
    EditWalletPaymentFragment localEditWalletPaymentFragment = new EditWalletPaymentFragment();
    localEditWalletPaymentFragment.setArguments(localBundle);
    return localEditWalletPaymentFragment;
  }

  private void sendDeletePaymentProfileRequest()
  {
    showLoadingDialogSticky(getString(2131558802), null);
    this.mRiderClient.deletePaymentProfile(this.mPaymentProfileId);
  }

  private void sendImpressionEvent()
  {
    if (this.mIsEditMode)
    {
      this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.WALLET_EDIT_OPTIONS);
      return;
    }
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.WALLET_EDIT);
  }

  private void setEditMode(boolean paramBoolean)
  {
    this.mIsEditMode = paramBoolean;
    getActivity().invalidateOptionsMenu();
    UberButton localUberButton1 = this.mButtonAddFunds;
    int i;
    UberButton localUberButton2;
    int j;
    if (!paramBoolean)
    {
      i = 0;
      localUberButton1.setVisibility(i);
      localUberButton2 = this.mButtonDelete;
      j = 0;
      if (!paramBoolean)
        break label55;
    }
    while (true)
    {
      localUberButton2.setVisibility(j);
      return;
      i = 8;
      break;
      label55: j = 8;
    }
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    if (this.mIsEditMode)
      return RiderEvents.Impression.WALLET_EDIT_OPTIONS;
    return RiderEvents.Impression.WALLET_EDIT;
  }

  public boolean onBackPressed()
  {
    boolean bool1 = this.mIsEditMode;
    boolean bool2 = false;
    if (bool1)
    {
      setEditMode(false);
      bool2 = true;
    }
    return bool2;
  }

  @OnClick({2131427659})
  public void onClickButtonAddFunds()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.EDIT_WALLET_ADD_MONEY);
    startActivity(AddFundsActivity.newIntent(this.mContext, this.mUuid));
    getActivity().finish();
  }

  @OnClick({2131427605})
  public void onClickButtonDelete()
  {
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.EDIT_WALLET_DELETE);
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.PAYMENT_METHOD_DELETE_CONFIRMATION);
    this.mDeletePaymentDialogPresenter.show(getRiderActivity(), 1);
  }

  @Subscribe
  public void onClientEvent(ClientEvent paramClientEvent)
  {
    Client localClient = paramClientEvent.getClient();
    if (localClient == null)
      return;
    this.mMobile = localClient.getMobile();
    this.mTextViewNumber.setText(this.mMobile);
    if (localClient.getPaymentProfiles() == null)
    {
      this.mBus.post(new DeletedPaymentProfileEvent());
      return;
    }
    PaymentProfile localPaymentProfile = localClient.findPaymentProfileWithId(this.mPaymentProfileId);
    if (localPaymentProfile == null)
    {
      this.mBus.post(new DeletedPaymentProfileEvent());
      return;
    }
    this.mUuid = localPaymentProfile.getUuid();
    this.mPaymentClient.checkBalance(this.mUuid);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    Bundle localBundle = getArguments();
    if (localBundle != null)
      this.mPaymentProfileId = localBundle.getString("payment_profile_id");
    if (paramBundle != null)
      this.mIsEditMode = paramBundle.getBoolean("is_edit_mode", false);
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(2131689476, paramMenu);
    this.mMenuItemEdit = paramMenu.findItem(2131427938);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903153, paramViewGroup, false);
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
    if (paramInt1 == 1)
    {
      if (paramInt2 != -1)
        break label25;
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_METHOD_DELETE_CONFIRM);
      sendDeletePaymentProfileRequest();
    }
    label25: 
    while (paramInt2 != 0)
      return;
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_METHOD_DELETE_CANCEL);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem == this.mMenuItemEdit)
    {
      sendImpressionEvent();
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.EDIT_WALLET_EDIT);
      boolean bool1 = this.mIsEditMode;
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      setEditMode(bool2);
      return true;
    }
    return false;
  }

  @Subscribe
  public void onPaymentCheckBalanceResponseEvent(PaymentCheckBalanceResponseEvent paramPaymentCheckBalanceResponseEvent)
  {
    this.mProgressBarCurrentBalanceRequest.setVisibility(8);
    if (!paramPaymentCheckBalanceResponseEvent.isSuccess())
    {
      showToast(getString(2131558428));
      return;
    }
    String str = ((PaymentCheckBalanceResponse)paramPaymentCheckBalanceResponseEvent.getModel()).getDisplayAmount();
    this.mTextViewBalanceValue.setText(str);
  }

  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    MenuItem localMenuItem;
    if (this.mMenuItemEdit != null)
    {
      localMenuItem = this.mMenuItemEdit;
      if (!this.mIsEditMode)
        break label36;
    }
    label36: for (String str = getString(2131558813); ; str = getString(2131558824))
    {
      localMenuItem.setTitle(str);
      return;
    }
  }

  public void onResume()
  {
    super.onResume();
    setEditMode(this.mIsEditMode);
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("is_edit_mode", this.mIsEditMode);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.mActionBar.setTitle(getString(2131558985));
    this.mActionBar.setDisplayHomeAsUpEnabled(true);
    this.mButtonAddFunds.setText(getString(2131558434));
    this.mButtonDelete.setText(getString(2131558801));
    this.mTextViewHeader.setText(getString(2131558460));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditWalletPaymentFragment
 * JD-Core Version:    0.6.2
 */