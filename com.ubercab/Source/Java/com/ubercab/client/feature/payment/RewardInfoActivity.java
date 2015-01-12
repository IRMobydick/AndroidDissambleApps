package com.ubercab.client.feature.payment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.ubercab.client.core.model.PaymentProfile;
import com.ubercab.client.core.model.RewardInfo;
import com.ubercab.common.base.Optional;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.Iterables;
import com.ubercab.common.collect.Lists;
import java.util.List;

public class RewardInfoActivity extends PaymentBaseActivity
{
  private static final String EXTRA_CARD_NUMBER = "card_number";
  private static final String EXTRA_IS_EARN_ONLY = "is_earn_only";
  private static final String EXTRA_PAYMENT_PROFILE_ID = "payment_profile_id";

  private static PaymentProfile findOnePaymentProfileToEnroll(List<PaymentProfile> paramList)
  {
    return (PaymentProfile)Iterables.tryFind(paramList, new Predicate()
    {
      public boolean apply(PaymentProfile paramAnonymousPaymentProfile)
      {
        RewardInfo localRewardInfo = paramAnonymousPaymentProfile.getRewardInfo();
        return (localRewardInfo != null) && (localRewardInfo.eligibleToUsePoints());
      }
    }).or(paramList.get(0));
  }

  public static PaymentProfile findPaymentProfileToEnroll(List<PaymentProfile> paramList)
  {
    if (!paramList.isEmpty())
    {
      List localList = findPaymentProfilesEligibleToEnroll(paramList);
      if (!localList.isEmpty())
        return findOnePaymentProfileToEnroll(localList);
    }
    return null;
  }

  private static List<PaymentProfile> findPaymentProfilesEligibleToEnroll(List<PaymentProfile> paramList)
  {
    return Lists.newArrayList(Iterables.filter(paramList, new Predicate()
    {
      public boolean apply(PaymentProfile paramAnonymousPaymentProfile)
      {
        RewardInfo localRewardInfo = paramAnonymousPaymentProfile.getRewardInfo();
        return (localRewardInfo != null) && (localRewardInfo.isEligible()) && (!localRewardInfo.isEnrolled()) && (!localRewardInfo.hasTakenEnrollAction());
      }
    }));
  }

  public static Intent newIntent(Context paramContext, PaymentProfile paramPaymentProfile)
  {
    String str1 = paramPaymentProfile.getId();
    String str2 = paramPaymentProfile.getCardNumber();
    RewardInfo localRewardInfo = paramPaymentProfile.getRewardInfo();
    if ((localRewardInfo != null) && (localRewardInfo.isEarnOnly()));
    for (boolean bool = true; ; bool = false)
      return newIntent(paramContext, str1, str2, bool);
  }

  public static Intent newIntent(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    return new Intent(paramContext, RewardInfoActivity.class).putExtra("payment_profile_id", paramString1).putExtra("card_number", paramString2).putExtra("is_earn_only", paramBoolean);
  }

  private void putAddPaymentFragment(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (findFragment(RewardInfoFragment.class) == null)
      putFragment(2131427551, RewardInfoFragment.newInstance(paramString1, paramString2, paramBoolean), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903128);
    Intent localIntent = getIntent();
    putAddPaymentFragment(localIntent.getStringExtra("payment_profile_id"), localIntent.getStringExtra("card_number"), localIntent.getBooleanExtra("is_earn_only", false));
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
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.RewardInfoActivity
 * JD-Core Version:    0.6.2
 */