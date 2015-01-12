package com.ubercab.client.feature.receipt;

import android.app.ActionBar;
import android.content.Context;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.network.RiderClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class ReceiptFragment$$InjectAdapter extends Binding<ReceiptFragment>
  implements Provider<ReceiptFragment>, MembersInjector<ReceiptFragment>
{
  private Binding<ActionBar> mActionBar;
  private Binding<AnalyticsManager> mAnalyticsManager;
  private Binding<Bus> mBus;
  private Binding<Context> mContext;
  private Binding<Picasso> mPicasso;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderClient> mRiderClient;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<RiderFragment> supertype;

  public ReceiptFragment$$InjectAdapter()
  {
    super("com.ubercab.client.feature.receipt.ReceiptFragment", "members/com.ubercab.client.feature.receipt.ReceiptFragment", false, ReceiptFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mBus = paramLinker.requestBinding("com.squareup.otto.Bus", ReceiptFragment.class, getClass().getClassLoader());
    this.mContext = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForActivity()/android.content.Context", ReceiptFragment.class, getClass().getClassLoader());
    this.mPicasso = paramLinker.requestBinding("com.squareup.picasso.Picasso", ReceiptFragment.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", ReceiptFragment.class, getClass().getClassLoader());
    this.mActionBar = paramLinker.requestBinding("android.app.ActionBar", ReceiptFragment.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", ReceiptFragment.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", ReceiptFragment.class, getClass().getClassLoader());
    this.mAnalyticsManager = paramLinker.requestBinding("com.ubercab.client.core.analytics.AnalyticsManager", ReceiptFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderFragment", ReceiptFragment.class, getClass().getClassLoader(), false, true);
  }

  public ReceiptFragment get()
  {
    ReceiptFragment localReceiptFragment = new ReceiptFragment();
    injectMembers(localReceiptFragment);
    return localReceiptFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mBus);
    paramSet2.add(this.mContext);
    paramSet2.add(this.mPicasso);
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mActionBar);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mAnalyticsManager);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(ReceiptFragment paramReceiptFragment)
  {
    paramReceiptFragment.mBus = ((Bus)this.mBus.get());
    paramReceiptFragment.mContext = ((Context)this.mContext.get());
    paramReceiptFragment.mPicasso = ((Picasso)this.mPicasso.get());
    paramReceiptFragment.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramReceiptFragment.mActionBar = ((ActionBar)this.mActionBar.get());
    paramReceiptFragment.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramReceiptFragment.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramReceiptFragment.mAnalyticsManager = ((AnalyticsManager)this.mAnalyticsManager.get());
    this.supertype.injectMembers(paramReceiptFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.receipt.ReceiptFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */