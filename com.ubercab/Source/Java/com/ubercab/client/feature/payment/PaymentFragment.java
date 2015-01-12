package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.AddExpenseInfoEvent;
import com.ubercab.client.core.analytics.event.SetUseCreditsEvent;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.PaymentCheckBalanceResponse;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.TripExpenseInfo;
import com.ubercab.client.core.model.UnpaidBill;
import com.ubercab.client.core.model.event.ClientEvent;
import com.ubercab.client.core.network.PaymentClient;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.AddExpenseInfoResponseEvent;
import com.ubercab.client.core.network.events.PayBillResponseEvent;
import com.ubercab.client.core.network.events.PaymentCheckBalanceResponseEvent;
import com.ubercab.client.core.network.events.SetUseCreditsResponseEvent;
import com.ubercab.client.core.ui.MergedSectionAdapter;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.payment.event.ChangePaymentProfileEvent;
import com.ubercab.client.feature.payment.event.EditPaymentProfileEvent;
import com.ubercab.client.feature.payment.event.PaymentProfileSelectedEvent;
import com.ubercab.client.feature.payment.event.SelectExpenseInfoEvent;
import com.ubercab.client.feature.payment.event.SelectGoogleWalletEvent;
import com.ubercab.client.feature.payment.event.SendExpenseToggledEvent;
import com.ubercab.client.feature.payment.event.ShowRewardInfoEvent;
import com.ubercab.client.feature.payment.event.UseCreditsToggledEvent;
import com.ubercab.library.app.annotation.ForActivity;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.AnalyticsEvent.Builder;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class PaymentFragment extends RiderFragment
  implements CreditsAdapter.Listener, ExpenseAdapter.Listener
{
  private static final String ARG_EXPENSE_INFO = "com.ubercab.EXPENSE_INFO";
  private static final String ARG_IS_USING_CREDITS = "com.ubercab.IS_USING_CREDITS";
  private static final String ARG_IS_USING_POINTS = "com.ubercab.IS_USING_POINTS";
  private static final String ARG_MODE = "com.ubercab.MODE";
  private static final String ARG_PAYMENT_PROFILE = "com.ubercab.PAYMENT_PROFILE";
  private static final String ARG_SHOW_PROMO = "com.ubercab.SHOW_PROMO";
  private static final String ARG_UNPAID_BILLS = "com.ubercab.UNPAID_BILLS_JSON";
  public static final int MODE_ARREARS = 3;
  public static final int MODE_CHANGE = 2;
  public static final int MODE_MANAGE = 0;
  public static final int MODE_SELECT = 1;
  private static final int REQUEST_CODE_ADD_PAYMENT = 500;

  @Inject
  ActionBar mActionBar;
  private CreditsAdapter mAdapterCredits;
  private ExpenseAdapter mAdapterExpenses;
  private PaymentProfileAdapter mAdapterPaymentProfiles;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @Inject
  Bus mBus;

  @ForActivity
  @Inject
  Context mContext;

  @InjectView(2131427568)
  ListView mListView;
  private int mMode;

  @Inject
  PaymentClient mPaymentClient;

  @Inject
  PingProvider mPingProvider;

  @Inject
  RiderClient mRiderClient;
  private ArrearsView mViewArrears;

  private void addCredits(List<ListAdapter> paramList, List<String> paramList1, String paramString)
  {
    boolean bool = true;
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.getBoolean("com.ubercab.IS_USING_CREDITS", bool)));
    while (true)
    {
      this.mAdapterCredits = new CreditsAdapter(this.mContext, this.mMode, bool);
      this.mAdapterCredits.setListener(this);
      paramList.add(this.mAdapterCredits);
      paramList1.add(paramString);
      return;
      bool = false;
    }
  }

  private void addExpenses(List<ListAdapter> paramList, List<String> paramList1)
  {
    this.mAdapterExpenses = createExpenseAdapter(this.mMode);
    if (this.mAdapterExpenses != null)
    {
      paramList.add(this.mAdapterExpenses);
      paramList1.add(getString(2131558850));
    }
  }

  private void addPayments(List<ListAdapter> paramList, List<String> paramList1, String paramString)
  {
    Bundle localBundle = getArguments();
    PaymentProfile localPaymentProfile = null;
    boolean bool = false;
    if (localBundle != null)
    {
      localPaymentProfile = (PaymentProfile)localBundle.getParcelable("com.ubercab.PAYMENT_PROFILE");
      bool = localBundle.getBoolean("com.ubercab.IS_USING_POINTS", false);
    }
    this.mAdapterPaymentProfiles = new PaymentProfileAdapter(PingUtils.hasExperimentSerial(this.mPingProvider.get(), "amex_rewards", 1), this.mBus, this.mContext, this.mMode, localPaymentProfile, bool);
    paramList.add(this.mAdapterPaymentProfiles);
    paramList1.add(paramString);
  }

  private void addTripBalances(List<ListAdapter> paramList, List<String> paramList1)
  {
  }

  private ExpenseAdapter createExpenseAdapter(int paramInt)
  {
    ExpenseAdapter localExpenseAdapter;
    if (paramInt != 1)
    {
      localExpenseAdapter = null;
      if (paramInt != 2);
    }
    else
    {
      Object localObject = new TripExpenseInfo();
      if (getArguments() != null)
      {
        TripExpenseInfo localTripExpenseInfo = (TripExpenseInfo)getArguments().getParcelable("com.ubercab.EXPENSE_INFO");
        if (localTripExpenseInfo != null)
          localObject = localTripExpenseInfo;
      }
      localExpenseAdapter = new ExpenseAdapter(this.mContext, this.mMode, (TripExpenseInfo)localObject);
      localExpenseAdapter.setListener(this);
    }
    return localExpenseAdapter;
  }

  private String getTitleFor(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "";
    case 0:
      return getString(2131558985);
    case 1:
      return getString(2131559048);
    case 2:
      return getString(2131558476);
    case 3:
    }
    return getString(2131558457);
  }

  public static Fragment newArrearsInstance(PaymentProfile paramPaymentProfile, ArrayList<UnpaidBill> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.ubercab.MODE", 3);
    localBundle.putParcelable("com.ubercab.PAYMENT_PROFILE", paramPaymentProfile);
    localBundle.putParcelableArrayList("com.ubercab.UNPAID_BILLS_JSON", paramArrayList);
    PaymentFragment localPaymentFragment = new PaymentFragment();
    localPaymentFragment.setArguments(localBundle);
    return localPaymentFragment;
  }

  public static Fragment newChangePaymentInstance(TripExpenseInfo paramTripExpenseInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.ubercab.MODE", 2);
    localBundle.putParcelable("com.ubercab.EXPENSE_INFO", paramTripExpenseInfo);
    PaymentFragment localPaymentFragment = new PaymentFragment();
    localPaymentFragment.setArguments(localBundle);
    return localPaymentFragment;
  }

  public static Fragment newManagePaymentInstance()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.ubercab.MODE", 0);
    PaymentFragment localPaymentFragment = new PaymentFragment();
    localPaymentFragment.setArguments(localBundle);
    return localPaymentFragment;
  }

  public static Fragment newSelectPaymentInstance(PaymentProfile paramPaymentProfile, boolean paramBoolean1, boolean paramBoolean2, TripExpenseInfo paramTripExpenseInfo, boolean paramBoolean3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.ubercab.MODE", 1);
    localBundle.putParcelable("com.ubercab.PAYMENT_PROFILE", paramPaymentProfile);
    localBundle.putParcelable("com.ubercab.EXPENSE_INFO", paramTripExpenseInfo);
    localBundle.putBoolean("com.ubercab.IS_USING_CREDITS", paramBoolean1);
    localBundle.putBoolean("com.ubercab.IS_USING_POINTS", paramBoolean2);
    localBundle.putBoolean("com.ubercab.SHOW_PROMO", paramBoolean3);
    PaymentFragment localPaymentFragment = new PaymentFragment();
    localPaymentFragment.setArguments(localBundle);
    return localPaymentFragment;
  }

  private void sendAnalyticsArrearsTap(PaymentProfile paramPaymentProfile)
  {
    if (paramPaymentProfile.isMobileWallet())
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.ARREARS_WALLET);
  }

  private void sendUseCreditsRequest(boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = getString(2131559114); ; str = getString(2131559113))
    {
      showLoadingDialogSticky(str, null);
      this.mRiderClient.setUseCredits(paramBoolean);
      this.mAnalyticsManager.setUseCreditsEvent().setUseCreditsRequest(paramBoolean);
      return;
    }
  }

  private void startAddPaymentActivityForResult()
  {
    startActivityForResult(new Intent(this.mContext, AddPaymentActivity.class), 500);
  }

  public void checkBalanceForMobileWallet(Client paramClient)
  {
    List localList = paramClient.getPaymentProfiles();
    if ((localList == null) || (localList.isEmpty()));
    PaymentProfile localPaymentProfile;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
        localIterator = localList.iterator();
      localPaymentProfile = (PaymentProfile)localIterator.next();
    }
    while (!localPaymentProfile.isMobileWallet());
    this.mPaymentClient.checkBalance(localPaymentProfile.getUuid());
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    switch (this.mMode)
    {
    default:
      return null;
    case 3:
      return RiderEvents.Impression.PAYMENT_LIST_ARREARS;
    case 1:
      return RiderEvents.Impression.PAYMENT_LIST_SELECT;
    case 2:
      return RiderEvents.Impression.PAYMENT_LIST_CHANGE;
    case 0:
    }
    return RiderEvents.Impression.PAYMENT_LIST_EDIT;
  }

  void handlePayBillError(PayBillResponseEvent paramPayBillResponseEvent)
  {
    PaymentProfile localPaymentProfile = this.mAdapterPaymentProfiles.getSelectedPaymentProfile();
    if (localPaymentProfile == null);
    while (!AddFundsActivity.isEligible(localPaymentProfile))
      return;
    RiderEvents.Impression localImpression = RiderEvents.Impression.ARREARS_WALLET_ADD_FUNDS_INSUFFICIENT;
    this.mAnalyticsClient.sendImpressionEvent(localImpression);
    startActivity(AddFundsActivity.newIntent(this.mContext, localPaymentProfile.getUuid()));
  }

  void handlePaymentProfileSelection(PaymentProfile paramPaymentProfile)
  {
    if (paramPaymentProfile.isBusinessCard())
    {
      this.mBus.post(new SelectExpenseInfoEvent(paramPaymentProfile, true));
      return;
    }
    this.mAdapterPaymentProfiles.setSelectedPaymentProfile(paramPaymentProfile);
    this.mBus.post(new PaymentProfileSelectedEvent(paramPaymentProfile));
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    String str = getTitleFor(this.mMode);
    this.mActionBar.setTitle(str);
  }

  @Subscribe
  public void onAddExpenseInfoResponseEvent(AddExpenseInfoResponseEvent paramAddExpenseInfoResponseEvent)
  {
    hideLoadingDialog();
    this.mAnalyticsManager.addExpenseInfoEvent().addExpenseInfoResponse(paramAddExpenseInfoResponseEvent.getStatusCode());
  }

  @Subscribe
  public void onClientEvent(ClientEvent paramClientEvent)
  {
    checkBalanceForMobileWallet(paramClientEvent.getClient());
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    Bundle localBundle = getArguments();
    if (localBundle != null)
      this.mMode = localBundle.getInt("com.ubercab.MODE");
  }

  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    paramMenuInflater.inflate(2131689475, paramMenu);
    paramMenu.findItem(2131427937).setTitle(getString(2131558423));
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903132, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    if (this.mMode == 3)
    {
      this.mViewArrears = ((ArrearsView)paramLayoutInflater.inflate(2130903147, this.mListView, false));
      inject(this.mViewArrears);
      this.mListView.addHeaderView(this.mViewArrears, null, false);
    }
    while ((this.mMode != 1) && (this.mMode != 2))
      return localView;
    PaymentFooterView localPaymentFooterView = (PaymentFooterView)paramLayoutInflater.inflate(2130903131, this.mListView, false);
    if (!getArguments().getBoolean("com.ubercab.SHOW_PROMO", false))
      localPaymentFooterView.hidePromoButton();
    this.mListView.addFooterView(localPaymentFooterView, null, false);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @OnItemClick({2131427568})
  public void onItemClick(int paramInt)
  {
    Object localObject = this.mListView.getItemAtPosition(paramInt);
    if ((localObject instanceof PaymentProfile))
    {
      localPaymentProfile = (PaymentProfile)localObject;
      switch (this.mMode)
      {
      default:
        if (localPaymentProfile == PaymentProfile.GOOGLE_WALLET)
          this.mBus.post(new SelectGoogleWalletEvent());
        break;
      case 3:
      case 1:
      case 2:
      case 0:
      }
    }
    while (!(localObject instanceof TripBalanceSummary))
    {
      PaymentProfile localPaymentProfile;
      while (true)
      {
        return;
        this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_LIST_METHOD_ARREARS);
        continue;
        this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_LIST_METHOD_SELECT);
        continue;
        this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_LIST_METHOD_CHANGE);
        continue;
        this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_LIST_METHOD_EDIT);
      }
      switch (this.mMode)
      {
      default:
        return;
      case 0:
        this.mBus.post(new EditPaymentProfileEvent(localPaymentProfile.getId()));
        return;
      case 3:
        sendAnalyticsArrearsTap(localPaymentProfile);
        handlePaymentProfileSelection(localPaymentProfile);
        return;
      case 1:
        handlePaymentProfileSelection(localPaymentProfile);
        return;
      case 2:
      }
      if (localPaymentProfile.isBusinessCard())
      {
        this.mBus.post(new SelectExpenseInfoEvent(localPaymentProfile, true));
        return;
      }
      this.mBus.post(new ChangePaymentProfileEvent(localPaymentProfile));
      return;
    }
    startActivity(new Intent(getActivity(), TripBalancesActivity.class));
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131427937)
    {
      this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.ARREARS_ADD_PAYMENT_METHOD);
      startAddPaymentActivityForResult();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  @Subscribe
  public void onPaymentCheckBalanceResponseEvent(PaymentCheckBalanceResponseEvent paramPaymentCheckBalanceResponseEvent)
  {
    if (paramPaymentCheckBalanceResponseEvent.isSuccess())
    {
      PaymentCheckBalanceResponse localPaymentCheckBalanceResponse = (PaymentCheckBalanceResponse)paramPaymentCheckBalanceResponseEvent.getModel();
      this.mAdapterPaymentProfiles.setPaymentProfileBalance(localPaymentCheckBalanceResponse.getDisplayAmount());
      this.mAdapterPaymentProfiles.notifyDataSetChanged();
    }
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    Ping localPing = paramPingEvent.getPing();
    this.mAdapterPaymentProfiles.update(localPing);
    if (this.mMode == 3)
      this.mViewArrears.update(localPing);
    while (true)
    {
      if (this.mAdapterExpenses != null)
        this.mAdapterExpenses.update(localPing);
      return;
      this.mAdapterCredits.update(localPing);
    }
  }

  public void onSendExpenseChanged(boolean paramBoolean)
  {
    this.mBus.post(new SendExpenseToggledEvent(paramBoolean));
  }

  @Subscribe
  public void onSetUseCreditsResponseEvent(SetUseCreditsResponseEvent paramSetUseCreditsResponseEvent)
  {
    hideLoadingDialog();
    this.mAnalyticsManager.setUseCreditsEvent().setUseCreditsResponse(paramSetUseCreditsResponseEvent.getStatusCode());
  }

  @Subscribe
  public void onShowRewardInfoEvent(ShowRewardInfoEvent paramShowRewardInfoEvent)
  {
    startActivity(RewardInfoActivity.newIntent(this.mContext, paramShowRewardInfoEvent.getPaymentProfileId(), paramShowRewardInfoEvent.getCardNumber(), paramShowRewardInfoEvent.isEarnOnly()));
  }

  public void onUseCreditsChanged(boolean paramBoolean)
  {
    if (this.mMode == 2)
    {
      sendUseCreditsRequest(paramBoolean);
      if (!paramBoolean)
        break label78;
    }
    label78: for (String str = "on"; ; str = "off")
    {
      this.mAnalyticsClient.addEvent(new AnalyticsEvent.Builder("tap").setName(RiderEvents.Tap.PAYMENT_APPLY_CREDITS_TOGGLE).setValue(str).build());
      return;
      if (this.mMode != 1)
        break;
      this.mBus.post(new UseCreditsToggledEvent(paramBoolean));
      break;
    }
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    String str1;
    switch (this.mMode)
    {
    default:
      str1 = getString(2131559351);
    case 1:
    case 2:
    case 3:
    }
    for (String str2 = getString(2131558788); ; str2 = getString(2131558451))
    {
      if (this.mMode == 3)
        this.mViewArrears.setUnpaidBills(getArguments().getParcelableArrayList("com.ubercab.UNPAID_BILLS_JSON"));
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      addPayments(localArrayList1, localArrayList2, str1);
      if (this.mMode != 3)
      {
        addTripBalances(localArrayList1, localArrayList2);
        addCredits(localArrayList1, localArrayList2, str2);
        addExpenses(localArrayList1, localArrayList2);
      }
      MergedSectionAdapter localMergedSectionAdapter = new MergedSectionAdapter(this.mContext, localArrayList1, localArrayList2);
      localMergedSectionAdapter.setItemPaddingHorizontal(getResources().getDimensionPixelSize(2131361892));
      this.mListView.setAdapter(localMergedSectionAdapter);
      return;
      str1 = getString(2131559048);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentFragment
 * JD-Core Version:    0.6.2
 */