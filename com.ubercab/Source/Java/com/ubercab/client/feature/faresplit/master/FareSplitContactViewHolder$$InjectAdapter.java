package com.ubercab.client.feature.faresplit.master;

import com.squareup.picasso.Picasso;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class FareSplitContactViewHolder$$InjectAdapter extends Binding<FareSplitContactViewHolder>
  implements MembersInjector<FareSplitContactViewHolder>
{
  private Binding<Picasso> mPicasso;

  public FareSplitContactViewHolder$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.faresplit.master.FareSplitContactViewHolder", false, FareSplitContactViewHolder.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mPicasso = paramLinker.requestBinding("com.squareup.picasso.Picasso", FareSplitContactViewHolder.class, getClass().getClassLoader());
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mPicasso);
  }

  public void injectMembers(FareSplitContactViewHolder paramFareSplitContactViewHolder)
  {
    paramFareSplitContactViewHolder.mPicasso = ((Picasso)this.mPicasso.get());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitContactViewHolder..InjectAdapter
 * JD-Core Version:    0.6.2
 */