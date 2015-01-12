package com.ubercab.client.feature.promo;

import android.app.ActionBar;
import android.os.Bundle;
import com.ubercab.client.core.app.RiderPingActivity;

public class PromoActivity extends RiderPingActivity
{
  private void putPromoFragment()
  {
    if (findFragment(PromoFragment.class) == null)
      putFragment(2131427670, new PromoFragment(), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903158);
    getActionBar().setTitle(getString(2131559017));
    putPromoFragment();
  }

  public void onDialogResult(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super.onDialogResult(paramInt1, paramInt2, paramBundle);
    if ((paramInt1 == 1321) && (paramInt2 == -1))
    {
      PromoFragment localPromoFragment = (PromoFragment)findFragment(PromoFragment.class);
      if (localPromoFragment != null)
        localPromoFragment.applyPromo(true);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.promo.PromoActivity
 * JD-Core Version:    0.6.2
 */