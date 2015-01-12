package com.ubercab.client.feature.about;

import android.app.ActionBar;
import com.ubercab.client.core.app.RiderFragment;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class WebViewFragment$$InjectAdapter extends Binding<WebViewFragment>
  implements Provider<WebViewFragment>, MembersInjector<WebViewFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<RiderFragment> supertype;

  public WebViewFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.about.WebViewFragment", "members/com.ubercab.client.feature.about.WebViewFragment", false, WebViewFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", WebViewFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", WebViewFragment.class, getClass().getClassLoader(), false, true);
  }

  public WebViewFragment get()
  {
    WebViewFragment localWebViewFragment = new WebViewFragment();
    injectMembers(localWebViewFragment);
    return localWebViewFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(WebViewFragment paramWebViewFragment)
  {
    paramWebViewFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    this.supertype.injectMembers(paramWebViewFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.WebViewFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */