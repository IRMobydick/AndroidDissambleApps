package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.ubercab.client.core.app.RiderPublicActivity;

public class AddFundsWebViewActivity extends RiderPublicActivity
{
  private static final String EXTRA_PAYMENT_POST_DATA = "post_data";
  private static final String EXTRA_PAYMENT_TITLE = "title";
  private static final String EXTRA_PAYMENT_URL = "url";

  public static Intent newIntent(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramContext, AddFundsWebViewActivity.class);
    localIntent.putExtra("post_data", paramString3);
    localIntent.putExtra("title", paramString1);
    localIntent.putExtra("url", paramString2);
    return localIntent;
  }

  private void putAddFundsWebViewFragment(String paramString1, String paramString2, String paramString3)
  {
    if (findFragment(AddFundsWebViewFragment.class) == null)
      putFragment(2131427551, AddFundsWebViewFragment.newInstance(paramString1, paramString2, paramString3), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903124);
    String str1 = getIntent().getStringExtra("post_data");
    String str2 = getIntent().getStringExtra("title");
    String str3 = getIntent().getStringExtra("url");
    getActionBar().setDisplayHomeAsUpEnabled(true);
    putAddFundsWebViewFragment(str2, str3, str1);
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
 * Qualified Name:     com.ubercab.client.feature.payment.AddFundsWebViewActivity
 * JD-Core Version:    0.6.2
 */