package com.ubercab.client.feature.about;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.feature.about.event.SelectLegalEvent;
import com.ubercab.client.feature.about.event.SelectOtherEvent;
import com.ubercab.client.feature.about.event.SelectPdfEvent;
import com.ubercab.client.feature.about.event.SelectWebViewEvent;

public class AboutActivity extends RiderPingActivity
{
  private void putAboutFragment()
  {
    if (findFragment(AboutFragment.class) == null)
      putFragment(2131427414, AboutFragment.newInstance(), true);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903064);
    putAboutFragment();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem.getItemId() == 16908332) && (getFragmentManager().getBackStackEntryCount() > 0))
    {
      getFragmentManager().popBackStack();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  @Subscribe
  public void onSelectLegalEvent(SelectLegalEvent paramSelectLegalEvent)
  {
    if (findFragment(AboutLegalFragment.class) == null)
      pushFragment(2131427414, AboutLegalFragment.newInstance(), true);
  }

  @Subscribe
  public void onSelectOtherEvent(SelectOtherEvent paramSelectOtherEvent)
  {
    if (findFragment(OtherFragment.class) == null)
      pushFragment(2131427414, OtherFragment.newInstance(), true);
  }

  @Subscribe
  public void onSelectPdfEvent(SelectPdfEvent paramSelectPdfEvent)
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramSelectPdfEvent.getUrl())));
  }

  @Subscribe
  public void onSelectWebViewEvent(SelectWebViewEvent paramSelectWebViewEvent)
  {
    if (findFragment(WebViewFragment.class) == null)
      pushFragment(2131427414, WebViewFragment.newInstance(paramSelectWebViewEvent.getTitle(), paramSelectWebViewEvent.getUrl(), paramSelectWebViewEvent.getImpressionEventName()), true);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.AboutActivity
 * JD-Core Version:    0.6.2
 */