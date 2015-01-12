package com.ubercab.client.feature.trip;

import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.feature.payment.expense.ExpenseLinkResources;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class FooterView$$InjectAdapter extends Binding<FooterView>
  implements MembersInjector<FooterView>
{
  private Binding<ExpenseLinkResources> mExpenseLinkResources;
  private Binding<PingProvider> mPingProvider;
  private Binding<SessionPreferences> mSessionPreferences;

  public FooterView$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.trip.FooterView", false, FooterView.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mExpenseLinkResources = paramLinker.requestBinding("com.ubercab.client.feature.payment.expense.ExpenseLinkResources", FooterView.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", FooterView.class, getClass().getClassLoader());
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", FooterView.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mExpenseLinkResources);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mSessionPreferences);
  }

  public void injectMembers(FooterView paramFooterView)
  {
    paramFooterView.mExpenseLinkResources = ((ExpenseLinkResources)this.mExpenseLinkResources.get());
    paramFooterView.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramFooterView.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.FooterView..InjectAdapter
 * JD-Core Version:    0.6.2
 */