package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.gms.wallet.MaskedWallet;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalService;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.AddExpenseInfoEvent;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.model.Trip;
import com.ubercab.client.core.model.TripExpenseInfo;
import com.ubercab.client.core.model.UnpaidBill;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.PayBillResponseEvent;
import com.ubercab.client.core.network.events.SelectPaymentProfileResponseEvent;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.vendor.google.GoogleWalletActivity;
import com.ubercab.client.core.vendor.paypal.PayPalUtils;
import com.ubercab.client.feature.payment.event.ChangePaymentProfileEvent;
import com.ubercab.client.feature.payment.event.EditPaymentProfileEvent;
import com.ubercab.client.feature.payment.event.PaymentProfileSelectedEvent;
import com.ubercab.client.feature.payment.event.SelectExpenseInfoEvent;
import com.ubercab.client.feature.payment.event.SelectGoogleWalletEvent;
import com.ubercab.client.feature.payment.event.SelectPromoCodeEvent;
import com.ubercab.client.feature.payment.event.SendExpenseToggledEvent;
import com.ubercab.client.feature.payment.event.UseCreditsToggledEvent;
import com.ubercab.client.feature.payment.expense.ExpenseInfoActivity;
import com.ubercab.client.feature.promo.PromoFragment;
import com.ubercab.common.base.Preconditions;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import java.util.ArrayList;
import javax.inject.Inject;

public class PaymentActivity extends PaymentBaseActivity
{
  public static final String ACTION_ARREARS = "com.ubercab.ACTION_ARREARS";
  public static final String ACTION_CHANGE_PAYMENT = "com.ubercab.CHANGE_PAYMENT";
  public static final String ACTION_MANAGE_PAYMENT = "com.ubercab.MANAGE_PAYMENT";
  public static final String ACTION_SELECT_PAYMENT = "com.ubercab.SELECT_PAYMENT";
  private static final String BUNDLE_ACTION = "com.ubercab.ACTION";
  public static final String EXTRA_EXPENSE_INFO = "com.ubercab.EXPENSE_INFO";
  public static final String EXTRA_PAYMENT_PROFILE = "com.ubercab.PAYMENT_PROFILE";
  public static final String EXTRA_SHOW_PROMO = "com.ubercab.SHOW_PROMO";
  public static final String EXTRA_UNPAID_BILLS = "com.ubercab.UNPAID_BILLS";
  public static final String EXTRA_USE_CREDITS = "com.ubercab.USE_CREDITS";
  public static final String EXTRA_USE_POINTS = "com.ubercab.USE_POINTS";
  private static final int REQUEST_CODE_EDIT = 1;
  private static final int REQUEST_CODE_EXPENSE_INFO = 5004;
  private static final int REQUEST_CODE_GOOGLE_WALLET = 5005;
  private String mAction;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  AnalyticsManager mAnalyticsManager;
  private TripExpenseInfo mExpenseInfo = new TripExpenseInfo();
  private String mGoogleWalletPaymentProfileId;
  private boolean mIsUsingCredits;
  private boolean mIsUsingPoints;
  private ArrayList<UnpaidBill> mListUnpaidBills;
  private MaskedWallet mMaskedWallet;

  @Inject
  PayPalConfiguration mPayPalConfiguration;

  @Inject
  RiderClient mRiderClient;
  private boolean mShowPromo;

  private Intent createDataForResult()
  {
    Intent localIntent = new Intent();
    putDataForResult(localIntent);
    return localIntent;
  }

  private void finishOKResult(Intent paramIntent)
  {
    setResult(-1, paramIntent);
    finish();
  }

  private void finishSelectedPaymentProfileActivity(PaymentProfile paramPaymentProfile)
  {
    Intent localIntent = getIntent();
    putDataForResult(localIntent, paramPaymentProfile);
    finishOKResult(localIntent);
  }

  private void handleChangePaymentExpenseInfoActivity(Intent paramIntent)
  {
    this.mRiderClient.addExpenseInfo(this.mExpenseInfo);
    this.mAnalyticsManager.addExpenseInfoEvent().addExpenseInfoRequest(this.mExpenseInfo.isExpenseTrip());
    if (paramIntent.hasExtra("com.ubercab.PAYMENT_PROFILE"))
    {
      if ((PaymentFragment)findFragment(PaymentFragment.class) != null)
      {
        PaymentProfile localPaymentProfile = (PaymentProfile)paramIntent.getParcelableExtra("com.ubercab.PAYMENT_PROFILE");
        sendSelectPaymentProfileRequest(localPaymentProfile);
        processSelectedPaymentProfile(localPaymentProfile);
      }
      return;
    }
    finishOKResult(paramIntent);
  }

  private void handleSelectedPaymentProfileInArrears(PaymentProfile paramPaymentProfile)
  {
    if (this.mAction.equals("com.ubercab.ACTION_ARREARS"))
      sendPayBillRequest(paramPaymentProfile.getId());
  }

  private void processSelectedPaymentProfile(PaymentProfile paramPaymentProfile)
  {
    if (this.mAction.equals("com.ubercab.ACTION_ARREARS"))
    {
      handleSelectedPaymentProfileInArrears(paramPaymentProfile);
      return;
    }
    finishSelectedPaymentProfileActivity(paramPaymentProfile);
  }

  private void putArrearsFragment()
  {
    if (findFragment(PaymentFragment.class) != null)
      return;
    putFragment(2131427551, PaymentFragment.newArrearsInstance((PaymentProfile)getIntent().getParcelableExtra("com.ubercab.PAYMENT_PROFILE"), this.mListUnpaidBills), true);
  }

  private void putChangePaymentFragment()
  {
    if (findFragment(PaymentFragment.class) != null)
      return;
    putFragment(2131427551, PaymentFragment.newChangePaymentInstance(this.mExpenseInfo), true);
  }

  private void putDataForResult(Intent paramIntent)
  {
    putDataForResult(paramIntent, null);
  }

  private void putDataForResult(Intent paramIntent, PaymentProfile paramPaymentProfile)
  {
    if (paramPaymentProfile != null)
      paramIntent.putExtra("com.ubercab.PAYMENT_PROFILE", paramPaymentProfile);
    paramIntent.putExtra("com.ubercab.EXPENSE_INFO", this.mExpenseInfo);
    paramIntent.putExtra("com.ubercab.USE_CREDITS", this.mIsUsingCredits);
    paramIntent.putExtra("com.ubercab.USE_POINTS", this.mIsUsingPoints);
  }

  private void putManagePaymentFragment()
  {
    if (findFragment(PaymentFragment.class) != null)
      return;
    putFragment(2131427551, PaymentFragment.newManagePaymentInstance(), true);
  }

  private void putSelectPaymentFragment()
  {
    if (findFragment(PaymentFragment.class) != null)
      return;
    PaymentProfile localPaymentProfile = (PaymentProfile)getIntent().getParcelableExtra("com.ubercab.PAYMENT_PROFILE");
    boolean bool = getIntent().getBooleanExtra("com.ubercab.SHOW_PROMO", false);
    putFragment(2131427551, PaymentFragment.newSelectPaymentInstance(localPaymentProfile, this.mIsUsingCredits, this.mIsUsingPoints, this.mExpenseInfo, bool), true);
  }

  private void sendAddExpenseInfoRequest()
  {
    if (this.mExpenseInfo.isExpenseTrip());
    for (String str = getString(2131559116); ; str = getString(2131559115))
    {
      showLoadingDialogSticky(str, null);
      this.mRiderClient.addExpenseInfo(this.mExpenseInfo);
      this.mAnalyticsManager.addExpenseInfoEvent().addExpenseInfoRequest(this.mExpenseInfo.isExpenseTrip());
      return;
    }
  }

  private void sendPayBillRequest(String paramString)
  {
    if (this.mListUnpaidBills.isEmpty())
      return;
    showLoadingDialogSticky(getString(2131558452), null);
    int i = ((UnpaidBill)this.mListUnpaidBills.get(0)).getId();
    this.mRiderClient.payBill(i, paramString);
  }

  private void sendSelectPaymentProfileRequest(PaymentProfile paramPaymentProfile)
  {
    showLoadingDialogSticky(getString(2131558478), null);
    boolean bool = "PayPal".equals(paramPaymentProfile.getCardType());
    String str = null;
    if (bool)
      str = PayPalUtils.getCorrelationId(this);
    this.mRiderClient.selectPaymentProfile(paramPaymentProfile.getId(), false, str);
  }

  private void startEditPaymentProfileActivityForResult(String paramString)
  {
    startActivityForResult(EditPaymentProfileActivity.newIntent(this, paramString), 1);
  }

  private void startPayPalService()
  {
    Intent localIntent = new Intent(this, PayPalService.class);
    localIntent.putExtra("com.paypal.android.sdk.paypalConfiguration", this.mPayPalConfiguration);
    startService(localIntent);
  }

  private void stopPayPalService()
  {
    stopService(new Intent(this, PayPalService.class));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 5005) && (paramInt2 == -1))
      if (this.mAction.equals("com.ubercab.MANAGE_PAYMENT"))
      {
        this.mMaskedWallet = ((MaskedWallet)paramIntent.getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET"));
        setResult(paramInt2, paramIntent);
      }
    while (paramInt1 != 5004)
    {
      do
      {
        return;
        if (this.mAction.equals("com.ubercab.SELECT_PAYMENT"))
        {
          this.mMaskedWallet = ((MaskedWallet)paramIntent.getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET"));
          putDataForResult(paramIntent, PaymentProfile.GOOGLE_WALLET);
          finishOKResult(paramIntent);
          return;
        }
        if (this.mAction.equals("com.ubercab.CHANGE_PAYMENT"))
        {
          this.mGoogleWalletPaymentProfileId = paramIntent.getStringExtra("com.ubercab.PAYMENT_PROFILE_ID");
          putDataForResult(paramIntent);
          return;
        }
      }
      while (!this.mAction.equals("com.ubercab.ACTION_ARREARS"));
      this.mGoogleWalletPaymentProfileId = paramIntent.getStringExtra("com.ubercab.PAYMENT_PROFILE_ID");
      return;
    }
    if (paramInt2 == -1)
    {
      this.mExpenseInfo = ((TripExpenseInfo)paramIntent.getParcelableExtra("com.ubercab.EXPENSE_INFO"));
      if (paramIntent.hasExtra("com.ubercab.PAYMENT_PROFILE"))
        this.mIsUsingCredits = false;
      putDataForResult(paramIntent);
      if (this.mAction.equals("com.ubercab.CHANGE_PAYMENT"))
      {
        handleChangePaymentExpenseInfoActivity(paramIntent);
        return;
      }
      finishOKResult(paramIntent);
      return;
    }
    setResult(0, paramIntent);
  }

  @Subscribe
  public void onChangePaymentProfileEvent(ChangePaymentProfileEvent paramChangePaymentProfileEvent)
  {
    sendSelectPaymentProfileRequest(paramChangePaymentProfileEvent.getPaymentProfile());
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    startPayPalService();
    setContentView(2130903121);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    Intent localIntent = getIntent();
    Preconditions.checkNotNull(localIntent);
    Preconditions.checkNotNull(localIntent.getAction());
    this.mAction = localIntent.getAction();
    this.mExpenseInfo = ((TripExpenseInfo)localIntent.getParcelableExtra("com.ubercab.EXPENSE_INFO"));
    this.mIsUsingCredits = localIntent.getBooleanExtra("com.ubercab.USE_CREDITS", true);
    this.mIsUsingPoints = localIntent.getBooleanExtra("com.ubercab.USE_POINTS", false);
    this.mShowPromo = localIntent.getBooleanExtra("com.ubercab.SHOW_PROMO", false);
    this.mListUnpaidBills = localIntent.getParcelableArrayListExtra("com.ubercab.UNPAID_BILLS");
    this.mMaskedWallet = ((MaskedWallet)localIntent.getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET"));
    String str = this.mAction;
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case -956851128:
    case -395009795:
    case 280998292:
    case -533285754:
    }
    while (true)
      switch (i)
      {
      default:
        finish();
        return;
        if (str.equals("com.ubercab.CHANGE_PAYMENT"))
        {
          i = 0;
          continue;
          if (str.equals("com.ubercab.MANAGE_PAYMENT"))
          {
            i = 1;
            continue;
            if (str.equals("com.ubercab.SELECT_PAYMENT"))
            {
              i = 2;
              continue;
              if (str.equals("com.ubercab.ACTION_ARREARS"))
                i = 3;
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    putChangePaymentFragment();
    return;
    putManagePaymentFragment();
    return;
    putSelectPaymentFragment();
    return;
    putArrearsFragment();
  }

  protected void onDestroy()
  {
    stopPayPalService();
    super.onDestroy();
  }

  @Subscribe
  public void onEditPaymentProfileEvent(EditPaymentProfileEvent paramEditPaymentProfileEvent)
  {
    startEditPaymentProfileActivityForResult(paramEditPaymentProfileEvent.getPaymentProfileId());
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  @Subscribe
  public void onPayBillResponseEvent(PayBillResponseEvent paramPayBillResponseEvent)
  {
    hideLoadingDialog();
    if (!paramPayBillResponseEvent.isSuccess())
    {
      PaymentFragment localPaymentFragment = (PaymentFragment)findFragment(PaymentFragment.class);
      if (localPaymentFragment != null)
        localPaymentFragment.handlePayBillError(paramPayBillResponseEvent);
      showToast(paramPayBillResponseEvent.getErrorMessage(this));
      return;
    }
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.ARREARS_BALANCE_PAID);
    finish();
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    String str = paramPingEvent.getPing().getClient().getStatus();
    if (("com.ubercab.SELECT_PAYMENT".equals(this.mAction)) && (!"Looking".equals(str)))
    {
      setResult(0);
      finish();
    }
    while ((!"com.ubercab.CHANGE_PAYMENT".equals(this.mAction)) || ("WaitingForPickup".equals(str)) || ("OnTrip".equals(str)))
      return;
    setResult(0);
    finish();
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.mAction = paramBundle.getString("com.ubercab.ACTION");
    this.mMaskedWallet = ((MaskedWallet)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_MASKED_WALLET"));
    this.mExpenseInfo = ((TripExpenseInfo)paramBundle.getParcelable("com.ubercab.EXPENSE_INFO"));
    this.mIsUsingCredits = paramBundle.getBoolean("com.ubercab.USE_CREDITS");
    this.mIsUsingPoints = paramBundle.getBoolean("com.ubercab.USE_POINTS");
    this.mListUnpaidBills = paramBundle.getParcelableArrayList("com.ubercab.UNPAID_BILLS");
  }

  public void onResume()
  {
    super.onResume();
    if ((this.mAction.equals("com.ubercab.CHANGE_PAYMENT")) && (this.mGoogleWalletPaymentProfileId != null))
    {
      showLoadingDialogSticky(getString(2131558478), null);
      this.mRiderClient.selectPaymentProfile(this.mGoogleWalletPaymentProfileId, true, null);
      this.mGoogleWalletPaymentProfileId = null;
    }
    if ((this.mAction.equals("com.ubercab.ACTION_ARREARS")) && (this.mGoogleWalletPaymentProfileId != null))
    {
      sendPayBillRequest(this.mGoogleWalletPaymentProfileId);
      this.mGoogleWalletPaymentProfileId = null;
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("com.ubercab.ACTION", this.mAction);
    paramBundle.putParcelable("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", this.mMaskedWallet);
    paramBundle.putParcelable("com.ubercab.EXPENSE_INFO", this.mExpenseInfo);
    paramBundle.putBoolean("com.ubercab.USE_CREDITS", this.mIsUsingCredits);
    paramBundle.putBoolean("com.ubercab.USE_POINTS", this.mIsUsingPoints);
    paramBundle.putParcelableArrayList("com.ubercab.UNPAID_BILLS", this.mListUnpaidBills);
  }

  @Subscribe
  public void onSelectExpenseInfoEvent(SelectExpenseInfoEvent paramSelectExpenseInfoEvent)
  {
    startActivityForResult(ExpenseInfoActivity.newIntent(this, this.mExpenseInfo, paramSelectExpenseInfoEvent.isShowSkipButton(), paramSelectExpenseInfoEvent.getPaymentProfile()), 5004);
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.EXPENSE_BUTTON_PAYMENT);
  }

  @Subscribe
  public void onSelectGoogleWalletEvent(SelectGoogleWalletEvent paramSelectGoogleWalletEvent)
  {
    if ((this.mAction.equals("com.ubercab.SELECT_PAYMENT")) && (this.mMaskedWallet != null))
    {
      Intent localIntent2 = createDataForResult();
      localIntent2.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", this.mMaskedWallet);
      localIntent2.putExtra("com.ubercab.PAYMENT_PROFILE", PaymentProfile.GOOGLE_WALLET);
      finishOKResult(localIntent2);
      return;
    }
    Intent localIntent1 = new Intent(this, GoogleWalletActivity.class);
    localIntent1.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", this.mMaskedWallet);
    if (this.mAction.equals("com.ubercab.MANAGE_PAYMENT"))
      localIntent1.setAction("com.ubercab.ACTION_CHANGE_MASKED_WALLET");
    while (true)
    {
      startActivityForResult(localIntent1, 5005);
      return;
      if (this.mAction.equals("com.ubercab.SELECT_PAYMENT"))
        localIntent1.setAction("com.ubercab.ACTION_LOAD_MASKED_WALLET");
      else if (this.mAction.equals("com.ubercab.CHANGE_PAYMENT"))
        localIntent1.setAction("com.ubercab.ACTION_CREATE_PAYMENT_PROFILE");
      else if (this.mAction.equals("com.ubercab.ACTION_ARREARS"))
        localIntent1.setAction("com.ubercab.ACTION_CREATE_PAYMENT_PROFILE");
    }
  }

  @Subscribe
  public void onSelectPaymentProfileResponseEvent(SelectPaymentProfileResponseEvent paramSelectPaymentProfileResponseEvent)
  {
    Ping localPing = (Ping)paramSelectPaymentProfileResponseEvent.getModel();
    hideLoadingDialog();
    if (!paramSelectPaymentProfileResponseEvent.isSuccess())
    {
      showToast(localPing.getDescription());
      return;
    }
    if ((!PingUtils.hasTrip(localPing)) || (!PingUtils.hasClient(localPing)))
    {
      setResult(0);
      finish();
      return;
    }
    String str = localPing.getTrip().getPaymentProfileId();
    PaymentProfile localPaymentProfile = localPing.getClient().findPaymentProfileWithId(str);
    Intent localIntent = new Intent();
    localIntent.putExtra("com.ubercab.PAYMENT_PROFILE", localPaymentProfile);
    setResult(-1, localIntent);
  }

  @Subscribe
  public void onSelectedPaymentProfileEvent(PaymentProfileSelectedEvent paramPaymentProfileSelectedEvent)
  {
    this.mIsUsingPoints = paramPaymentProfileSelectedEvent.isUsingPoints();
    processSelectedPaymentProfile(paramPaymentProfileSelectedEvent.getPaymentProfile());
  }

  @Subscribe
  public void onSelectedPromoCodeEvent(SelectPromoCodeEvent paramSelectPromoCodeEvent)
  {
    if (findFragment(PromoFragment.class) == null)
      PromoFragment.newInstance().show(getFragmentManager(), PromoFragment.class.getName());
  }

  @Subscribe
  public void onSendExpenseToggledEvent(SendExpenseToggledEvent paramSendExpenseToggledEvent)
  {
    this.mExpenseInfo.setExpenseTrip(paramSendExpenseToggledEvent.isSendExpense());
    if (this.mAction.equals("com.ubercab.CHANGE_PAYMENT"))
      sendAddExpenseInfoRequest();
    setResult(-1, createDataForResult());
  }

  @Subscribe
  public void onUseCreditsToggledEvent(UseCreditsToggledEvent paramUseCreditsToggledEvent)
  {
    this.mIsUsingCredits = paramUseCreditsToggledEvent.isUsingCredits();
    setResult(-1, createDataForResult());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.PaymentActivity
 * JD-Core Version:    0.6.2
 */