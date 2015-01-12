package com.ubercab.client.feature.receipt;

import com.ubercab.client.core.app.RiderPingActivity;
import com.ubercab.client.core.content.PingProvider;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class ReceiptActivity$$InjectAdapter extends Binding<ReceiptActivity>
  implements Provider<ReceiptActivity>, MembersInjector<ReceiptActivity>
{
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderPingActivity> supertype;

  public ReceiptActivity$$InjectAdapter()
  {
    super("com.ubercab.client.feature.receipt.ReceiptActivity", "members/com.ubercab.client.feature.receipt.ReceiptActivity", false, ReceiptActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", ReceiptActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPingActivity", ReceiptActivity.class, getClass().getClassLoader(), false, true);
  }

  public ReceiptActivity get()
  {
    ReceiptActivity localReceiptActivity = new ReceiptActivity();
    injectMembers(localReceiptActivity);
    return localReceiptActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(ReceiptActivity paramReceiptActivity)
  {
    paramReceiptActivity.mPingProvider = ((PingProvider)this.mPingProvider.get());
    this.supertype.injectMembers(paramReceiptActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.receipt.ReceiptActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */