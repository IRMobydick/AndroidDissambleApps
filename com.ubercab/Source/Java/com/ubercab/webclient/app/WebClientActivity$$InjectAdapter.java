package com.ubercab.webclient.app;

import com.inauth.mme.InAuthManager;
import com.mobileapptracker.MobileAppTracker;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class WebClientActivity$$InjectAdapter extends Binding<WebClientActivity>
  implements Provider<WebClientActivity>, MembersInjector<WebClientActivity>
{
  private Binding<InAuthManager> mInAuthManager;
  private Binding<MobileAppTracker> mMobileAppTracker;

  public WebClientActivity$$InjectAdapter()
  {
    super("com.ubercab.webclient.app.WebClientActivity", "members/com.ubercab.webclient.app.WebClientActivity", false, WebClientActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mMobileAppTracker = paramLinker.requestBinding("com.mobileapptracker.MobileAppTracker", WebClientActivity.class, getClass().getClassLoader());
    this.mInAuthManager = paramLinker.requestBinding("com.inauth.mme.InAuthManager", WebClientActivity.class, getClass().getClassLoader());
  }

  public WebClientActivity get()
  {
    WebClientActivity localWebClientActivity = new WebClientActivity();
    injectMembers(localWebClientActivity);
    return localWebClientActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mMobileAppTracker);
    paramSet2.add(this.mInAuthManager);
  }

  public void injectMembers(WebClientActivity paramWebClientActivity)
  {
    paramWebClientActivity.mMobileAppTracker = ((MobileAppTracker)this.mMobileAppTracker.get());
    paramWebClientActivity.mInAuthManager = ((InAuthManager)this.mInAuthManager.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.webclient.app.WebClientActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */