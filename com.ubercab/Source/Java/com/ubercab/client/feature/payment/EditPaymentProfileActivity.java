package com.ubercab.client.feature.payment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Tap;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.payment.event.DeletedPaymentProfileEvent;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import javax.inject.Inject;

public class EditPaymentProfileActivity extends PaymentBaseActivity
{
  private static final String EXTRA_PAYMENT_PROFILE_ID = "payment_profile_id";

  @Inject
  AnalyticsClient mAnalyticsClient;
  private PaymentProfile mPaymentProfile;

  @Inject
  PingProvider mPingProvider;

  public static Intent newIntent(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, EditPaymentProfileActivity.class);
    localIntent.putExtra("payment_profile_id", paramString);
    return localIntent;
  }

  private void putEditPaymentProfileFragment(String paramString)
  {
    this.mAnalyticsClient.sendImpressionEvent(RiderEvents.Impression.PAYMENT_METHOD_DETAIL);
    if (this.mPaymentProfile.isMobileWallet())
      if ((EditWalletPaymentFragment)findFragment(EditWalletPaymentFragment.class) == null)
        putFragment(2131427551, EditWalletPaymentFragment.newInstance(paramString), true);
    do
    {
      do
      {
        do
        {
          return;
          if ((!"PayPal".equals(this.mPaymentProfile.getCardType())) && (!"Alipay".equals(this.mPaymentProfile.getCardType())))
            break;
        }
        while ((EditThirdPartyPaymentProviderFragment)findFragment(EditThirdPartyPaymentProviderFragment.class) != null);
        putFragment(2131427551, EditThirdPartyPaymentProviderFragment.newInstance(paramString), true);
        return;
        if (!"Delegate".equals(this.mPaymentProfile.getCardType()))
          break;
      }
      while ((EditDelegatePaymentProfileFragment)findFragment(EditDelegatePaymentProfileFragment.class) != null);
      putFragment(2131427551, EditDelegatePaymentProfileFragment.newInstance(paramString), true);
      return;
    }
    while ((EditCreditCardFragment)findFragment(EditCreditCardFragment.class) != null);
    putFragment(2131427551, EditCreditCardFragment.newInstance(paramString), true);
  }

  public void onBackPressed()
  {
    EditCreditCardFragment localEditCreditCardFragment = (EditCreditCardFragment)findFragment(EditCreditCardFragment.class);
    if ((localEditCreditCardFragment != null) && (localEditCreditCardFragment.onBackPressed()));
    EditWalletPaymentFragment localEditWalletPaymentFragment;
    do
    {
      return;
      localEditWalletPaymentFragment = (EditWalletPaymentFragment)findFragment(EditWalletPaymentFragment.class);
    }
    while ((localEditWalletPaymentFragment != null) && (localEditWalletPaymentFragment.onBackPressed()));
    this.mAnalyticsClient.sendTapEvent(RiderEvents.Tap.PAYMENT_METHOD_DETAIL_CLOSE);
    super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903127);
    String str = getIntent().getStringExtra("payment_profile_id");
    if (PingUtils.hasClientPaymentProfiles(this.mPingProvider.get()))
      this.mPaymentProfile = this.mPingProvider.get().getClient().findPaymentProfileWithId(str);
    while (true)
    {
      putEditPaymentProfileFragment(str);
      return;
      finish();
    }
  }

  @Subscribe
  public void onDeletedPaymentProfileEvent(DeletedPaymentProfileEvent paramDeletedPaymentProfileEvent)
  {
    setResult(-1);
    finish();
  }

  public void onDialogResult(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super.onDialogResult(paramInt1, paramInt2, paramBundle);
    if (this.mPaymentProfile.isMobileWallet())
    {
      ((EditWalletPaymentFragment)findFragment(EditWalletPaymentFragment.class)).onDialogResult(paramInt1, paramInt2);
      return;
    }
    if ("PayPal".equals(this.mPaymentProfile.getCardType()))
    {
      ((EditThirdPartyPaymentProviderFragment)findFragment(EditThirdPartyPaymentProviderFragment.class)).onDialogResult(paramInt1, paramInt2);
      return;
    }
    ((EditCreditCardFragment)findFragment(EditCreditCardFragment.class)).onDialogResult(paramInt1, paramInt2);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      onBackPressed();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditPaymentProfileActivity
 * JD-Core Version:    0.6.2
 */