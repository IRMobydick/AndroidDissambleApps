package com.ubercab.client.core.vendor.google;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.Cart.Builder;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.FullWalletRequest.Builder;
import com.google.android.gms.wallet.LineItem;
import com.google.android.gms.wallet.LineItem.Builder;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest.Builder;
import com.google.android.gms.wallet.ProxyCard;
import com.google.android.gms.wallet.Wallet;
import com.google.android.gms.wallet.Wallet.WalletOptions;
import com.google.android.gms.wallet.Wallet.WalletOptions.Builder;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.model.ApiResponse;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.network.events.CreatePaymentProfileResponseEvent;
import com.ubercab.client.feature.payment.PaymentModule;
import com.ubercab.client.feature.payment.UberBraintree;
import com.ubercab.common.base.Preconditions;
import com.ubercab.common.collect.ImmutableList.Builder;
import com.ubercab.common.collect.ObjectArrays;
import com.ubercab.library.ui.UberProgressDialog;
import com.ubercab.library.vendor.google.GoogleUtils;
import java.lang.ref.WeakReference;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import timber.log.Timber;

public class GoogleWalletActivity extends RiderPublicActivity
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public static final String ACTION_CHANGE_MASKED_WALLET = "com.ubercab.ACTION_CHANGE_MASKED_WALLET";
  public static final String ACTION_CREATE_PAYMENT_PROFILE = "com.ubercab.ACTION_CREATE_PAYMENT_PROFILE";
  public static final String ACTION_LOAD_FULL_WALLET = "com.ubercab.ACTION_LOAD_FULL_WALLET";
  public static final String ACTION_LOAD_MASKED_WALLET = "com.ubercab.ACTION_LOAD_MASKED_WALLET";
  private static final String BUNDLE_WALLET_SDK_IN_FOREGROUND = "com.ubercab.SDK_IN_FORGROUND";
  private static final int ERROR_CODE_NONE = -1;
  public static final String EXTRA_PAYMENT_PROFILE_ID = "com.ubercab.PAYMENT_PROFILE_ID";
  private static final String LINE_ITEM = "Uber";
  private static final List<Locale> LOCALE_WHITE_LIST = new ImmutableList.Builder().add(Locale.US).build();
  private static final String MERCHANT_NAME = "Uber";
  private static final int MESSAGE_RETRY_CONNECTION = 400;
  private static final int QUANTITY = 1;
  private static final int REQUEST_CODE_RESOLVE_ERROR = 8000;
  private static final int REQUEST_CODE_WALLET_CHANGE_MASKED = 8003;
  private static final int REQUEST_CODE_WALLET_LOAD_FULL = 8004;
  private static final int REQUEST_CODE_WALLET_LOAD_MASKED = 8002;
  private static final int REQUEST_CODE_WALLET_PREAUTHORIZATION = 8001;
  private static final int RETRY_ATTEMPT_MAX = 3;
  private static final int RETRY_INITIAL_DELAY = 2000;
  private static final double TOTAL_PRICE = 833.33000000000004D;
  private String mAction;

  @Inject
  UberBraintree mBraintree;
  private FullWallet mFullWallet;
  private GoogleApiClient mGoogleApiClient;
  private boolean mIsWalletPreAuthorized;
  private boolean mIsWalletSdkInForeground;
  private MaskedWallet mMaskedWallet;

  @Inject
  PingProvider mPingProvider;
  private ProgressDialog mProgressDialog;
  private int mRetryCount;
  private RetryHandler mRetryHandler;

  @Inject
  RiderClient mRiderClient;

  @Inject
  RiderPreferences mRiderPreferences;

  @Inject
  SessionPreferences mSessionPreferences;

  private void changeMaskedWallet()
  {
    this.mIsWalletSdkInForeground = true;
    Wallet.changeMaskedWallet(this.mGoogleApiClient, this.mMaskedWallet.getGoogleTransactionId(), this.mMaskedWallet.getMerchantTransactionId(), 8003);
  }

  private void handleError(int paramInt)
  {
    switch (paramInt)
    {
    case 403:
    case 407:
    case 408:
    case 410:
    default:
    case 409:
    case 402:
    case 404:
    case 405:
    case 406:
    case 411:
    case 412:
    case 413:
    }
    while (true)
    {
      finish();
      return;
      showToast(getString(2131558887));
      continue;
      handleUnrecoverableGoogleWalletError(paramInt);
    }
  }

  private void handleUnrecoverableGoogleWalletError(int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    Timber.i("Unrecoverable Google Wallet Error: %d", arrayOfObject);
    showToast(getString(2131558886));
    setResult(0, getIntent());
  }

  public static boolean isEligible(Context paramContext)
  {
    if (!GoogleUtils.isGooglePlayServicesInstalled(paramContext));
    String str;
    Iterator localIterator;
    do
      while (!localIterator.hasNext())
      {
        return false;
        str = ((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso();
        if (TextUtils.isEmpty(str))
          return LOCALE_WHITE_LIST.contains(Locale.getDefault());
        localIterator = LOCALE_WHITE_LIST.iterator();
      }
    while (!str.equalsIgnoreCase(((Locale)localIterator.next()).getCountry()));
    return true;
  }

  private void loadFullWallet()
  {
    this.mIsWalletSdkInForeground = true;
    if (this.mMaskedWallet == null)
    {
      loadMaskedWallet();
      return;
    }
    String str1 = this.mSessionPreferences.getSelectedVehicleViewId();
    String str2 = String.format("%s %s %s", new Object[] { "Uber", this.mPingProvider.get().getCity().getCityName(), str1 });
    String str3 = Integer.toString(1);
    String str4 = Double.toString(833.33000000000004D);
    String str5 = Double.toString(833.33000000000004D);
    String str6 = Currency.getInstance(Locale.US).getCurrencyCode();
    LineItem localLineItem = LineItem.newBuilder().setDescription(str2).setCurrencyCode(str6).setTotalPrice(str4).setUnitPrice(str5).setQuantity(str3).build();
    Cart localCart = Cart.newBuilder().setCurrencyCode(str6).setTotalPrice(str4).addLineItem(localLineItem).build();
    FullWalletRequest localFullWalletRequest = FullWalletRequest.newBuilder().setGoogleTransactionId(this.mMaskedWallet.getGoogleTransactionId()).setMerchantTransactionId(this.mMaskedWallet.getMerchantTransactionId()).setCart(localCart).build();
    Wallet.loadFullWallet(this.mGoogleApiClient, localFullWalletRequest, 8004);
  }

  private void loadMaskedWallet()
  {
    String str1 = Double.toString(833.33000000000004D);
    String str2 = Currency.getInstance(Locale.US).getCurrencyCode();
    MaskedWalletRequest localMaskedWalletRequest = MaskedWalletRequest.newBuilder().setAllowPrepaidCard(false).setCurrencyCode(str2).setPhoneNumberRequired(false).setShippingAddressRequired(false).setMerchantName("Uber").setEstimatedTotalPrice(str1).build();
    this.mIsWalletSdkInForeground = true;
    Wallet.loadMaskedWallet(this.mGoogleApiClient, localMaskedWalletRequest, 8002);
  }

  private void reconnect()
  {
    if (this.mRetryCount >= 3)
    {
      handleUnrecoverableGoogleWalletError(402);
      return;
    }
    Message localMessage = this.mRetryHandler.obtainMessage(400);
    long l = ()(2000.0D * Math.pow(2.0D, this.mRetryCount));
    this.mRetryHandler.sendMessageDelayed(localMessage, l);
    this.mRetryCount = (1 + this.mRetryCount);
  }

  private void resolveUnsuccessfulConnectionResult(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult == null)
      return;
    int i = paramConnectionResult.getErrorCode();
    if (paramConnectionResult.hasResolution())
      try
      {
        paramConnectionResult.startResolutionForResult(this, 8000);
        return;
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        reconnect();
        return;
      }
    if (GooglePlayServicesUtil.isUserRecoverableError(i))
    {
      GooglePlayServicesUtil.getErrorDialog(i, this, 8000, new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GoogleWalletActivity.this.mGoogleApiClient.connect();
        }
      }).show();
      return;
    }
    switch (i)
    {
    default:
      handleError(i);
      return;
    case 7:
    case 8:
    }
    reconnect();
  }

  private void toggleProgressDialog()
  {
    if (this.mProgressDialog != null)
    {
      this.mProgressDialog.dismiss();
      return;
    }
    this.mProgressDialog = UberProgressDialog.create(this, getString(2131558888), true, null, 3);
    this.mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        GoogleWalletActivity.this.setResult(0);
        GoogleWalletActivity.this.finish();
      }
    });
    this.mProgressDialog.show();
  }

  protected Object[] getModules()
  {
    return ObjectArrays.concat(super.getModules(), new PaymentModule());
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mIsWalletSdkInForeground = false;
    if (paramInt2 == 0)
    {
      setResult(0);
      finish();
    }
    do
    {
      do
      {
        return;
        if (paramInt2 == 1)
        {
          if (paramIntent.getIntExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", 0) == 410)
          {
            this.mMaskedWallet = null;
            this.mFullWallet = null;
            loadMaskedWallet();
            return;
          }
          showToast(getString(2131558886));
          setResult(0);
          finish();
          return;
        }
        if ((paramInt1 == 8001) && (paramInt2 == -1))
        {
          this.mIsWalletPreAuthorized = paramIntent.getBooleanExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", false);
          loadMaskedWallet();
          return;
        }
        if ((paramInt1 == 8003) && (paramInt2 == -1))
        {
          setResult(paramInt2, paramIntent);
          finish();
          return;
        }
        if ((paramInt1 == 8002) && (paramInt2 == -1))
        {
          this.mMaskedWallet = ((MaskedWallet)paramIntent.getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET"));
          if (this.mAction.equals("com.ubercab.ACTION_CHANGE_MASKED_WALLET"))
          {
            if (this.mIsWalletPreAuthorized)
            {
              changeMaskedWallet();
              return;
            }
            setResult(paramInt2, paramIntent);
            finish();
            return;
          }
          if (this.mAction.equals("com.ubercab.ACTION_LOAD_MASKED_WALLET"))
          {
            setResult(paramInt2, paramIntent);
            finish();
            return;
          }
          if ((this.mAction.equals("com.ubercab.ACTION_LOAD_FULL_WALLET")) || (this.mAction.equals("com.ubercab.ACTION_CREATE_PAYMENT_PROFILE")))
          {
            loadFullWallet();
            return;
          }
        }
      }
      while ((paramInt1 != 8004) || (paramInt2 != -1));
      this.mFullWallet = ((FullWallet)paramIntent.getParcelableExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET"));
      if (this.mAction.equals("com.ubercab.ACTION_LOAD_FULL_WALLET"))
      {
        paramIntent.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", this.mMaskedWallet);
        setResult(-1, paramIntent);
        finish();
        return;
      }
    }
    while (!this.mAction.equals("com.ubercab.ACTION_CREATE_PAYMENT_PROFILE"));
    ProxyCard localProxyCard = this.mFullWallet.getProxyCard();
    Address localAddress = this.mFullWallet.getBillingAddress();
    this.mRiderClient.createPaymentProfile(this.mBraintree.encrypt(localProxyCard.getPan()), this.mBraintree.encrypt(Integer.toString(localProxyCard.getExpirationMonth())), this.mBraintree.encrypt(Integer.toString(localProxyCard.getExpirationYear())), this.mBraintree.encrypt(localProxyCard.getCvn()), localAddress.getCountryCode(), localAddress.getPostalCode(), "personal", true, false);
  }

  public void onConnected(Bundle paramBundle)
  {
    if (this.mIsWalletSdkInForeground);
    do
    {
      return;
      if (this.mMaskedWallet == null)
      {
        Wallet.checkForPreAuthorization(this.mGoogleApiClient, 8001);
        return;
      }
      if (this.mAction.equals("com.ubercab.ACTION_CHANGE_MASKED_WALLET"))
      {
        changeMaskedWallet();
        return;
      }
      if (this.mAction.equals("com.ubercab.ACTION_LOAD_MASKED_WALLET"))
      {
        loadMaskedWallet();
        return;
      }
    }
    while ((!this.mAction.equals("com.ubercab.ACTION_LOAD_FULL_WALLET")) && (!this.mAction.equals("com.ubercab.ACTION_CREATE_PAYMENT_PROFILE")));
    loadFullWallet();
  }

  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    resolveUnsuccessfulConnectionResult(paramConnectionResult);
  }

  public void onConnectionSuspended(int paramInt)
  {
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Preconditions.checkNotNull(getIntent().getAction());
    if (!isEligible(this))
    {
      finish();
      return;
    }
    toggleProgressDialog();
    this.mAction = getIntent().getAction();
    this.mMaskedWallet = ((MaskedWallet)getIntent().getParcelableExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET"));
    Wallet.WalletOptions localWalletOptions = new Wallet.WalletOptions.Builder().setEnvironment(this.mRiderPreferences.getGoogleWalletEnvironment()).build();
    this.mGoogleApiClient = new GoogleApiClient.Builder(this).addApi(Wallet.API, localWalletOptions).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
    this.mRetryHandler = new RetryHandler(this);
  }

  @Subscribe
  public void onCreatePaymentProfileResponseEvent(CreatePaymentProfileResponseEvent paramCreatePaymentProfileResponseEvent)
  {
    if (paramCreatePaymentProfileResponseEvent.isSuccess())
    {
      Intent localIntent = new Intent();
      Map localMap = ((Ping)paramCreatePaymentProfileResponseEvent.getModel()).getApiResponse().getData();
      if (localMap != null)
        localIntent.putExtra("com.ubercab.PAYMENT_PROFILE_ID", Integer.toString(((Double)localMap.get("id")).intValue()));
      localIntent.putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", this.mFullWallet);
      localIntent.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", this.mMaskedWallet);
      setResult(-1, localIntent);
      finish();
      return;
    }
    showToast(getString(2131558886));
    setResult(0);
    finish();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    toggleProgressDialog();
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.mFullWallet = ((FullWallet)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_FULL_WALLET"));
    this.mMaskedWallet = ((MaskedWallet)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_MASKED_WALLET"));
    this.mIsWalletSdkInForeground = paramBundle.getBoolean("com.ubercab.SDK_IN_FORGROUND");
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("com.google.android.gms.wallet.EXTRA_FULL_WALLET", this.mFullWallet);
    paramBundle.putParcelable("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", this.mMaskedWallet);
    paramBundle.putBoolean("com.ubercab.SDK_IN_FORGROUND", this.mIsWalletSdkInForeground);
  }

  protected void onStart()
  {
    super.onStart();
    this.mGoogleApiClient.connect();
  }

  protected void onStop()
  {
    super.onStop();
    this.mRetryHandler.removeMessages(400);
    this.mGoogleApiClient.disconnect();
  }

  private static class RetryHandler extends Handler
  {
    private WeakReference<GoogleWalletActivity> mActivityReference;

    protected RetryHandler(GoogleWalletActivity paramGoogleWalletActivity)
    {
      this.mActivityReference = new WeakReference(paramGoogleWalletActivity);
    }

    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 400)
      {
        GoogleWalletActivity localGoogleWalletActivity = (GoogleWalletActivity)this.mActivityReference.get();
        if (localGoogleWalletActivity != null)
          localGoogleWalletActivity.mGoogleApiClient.connect();
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.GoogleWalletActivity
 * JD-Core Version:    0.6.2
 */