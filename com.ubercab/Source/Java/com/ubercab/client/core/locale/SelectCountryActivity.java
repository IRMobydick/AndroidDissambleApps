package com.ubercab.client.core.locale;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.ubercab.client.core.app.RiderPublicActivity;

public class SelectCountryActivity extends RiderPublicActivity
  implements SelectCountryFragment.Listener
{
  public static final String EXTRA_COUNTRY_ISO2 = "country_iso2";
  public static final String EXTRA_COUNTRY_NAME = "country_name";

  private void putSelectCountryFragment()
  {
    if (findFragment(SelectCountryFragment.class) == null)
      putFragment(2131427424, new SelectCountryFragment(), true);
  }

  public void onCountrySelected(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("country_name", paramString1);
    localIntent.putExtra("country_iso2", paramString2);
    setResult(-1, localIntent);
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setLayout(-1, -1);
    setContentView(2130903071);
    setTitle(getString(2131559047));
    putSelectCountryFragment();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.locale.SelectCountryActivity
 * JD-Core Version:    0.6.2
 */