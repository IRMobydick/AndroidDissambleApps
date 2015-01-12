package com.ubercab.client.feature.signup;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.feature.about.AboutLegalFragment;
import com.ubercab.client.feature.about.WebViewFragment;
import com.ubercab.client.feature.about.event.SelectWebViewEvent;

public class LegalActivity extends RiderPublicActivity
{
  private void putLegalFragment()
  {
    if (findFragment(AboutLegalFragment.class) == null)
      putFragment(2131427488, SignupLegalFragment.newInstance(), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903094);
    putLegalFragment();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      if (getFragmentManager().getBackStackEntryCount() > 0)
        getFragmentManager().popBackStack();
      while (true)
      {
        return true;
        finish();
      }
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  @Subscribe
  public void onSelectWebViewEvent(SelectWebViewEvent paramSelectWebViewEvent)
  {
    if (findFragment(WebViewFragment.class) == null)
      pushFragment(2131427488, WebViewFragment.newInstance(paramSelectWebViewEvent.getTitle(), paramSelectWebViewEvent.getUrl()), true);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.LegalActivity
 * JD-Core Version:    0.6.2
 */