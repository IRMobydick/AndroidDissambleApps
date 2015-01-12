package com.ubercab.client.feature.faresplit.master;

import com.squareup.picasso.Picasso;
import com.ubercab.client.core.ui.ContactChipAdapter;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

public final class FareSplitChipAdapter$$InjectAdapter extends Binding<FareSplitChipAdapter>
  implements MembersInjector<FareSplitChipAdapter>
{
  private Binding<Picasso> mPicasso;
  private Binding<ContactChipAdapter> supertype;

  public FareSplitChipAdapter$$InjectAdapter()
  {
    super(null, "members/com.ubercab.client.feature.faresplit.master.FareSplitChipAdapter", false, FareSplitChipAdapter.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mPicasso = paramLinker.requestBinding("com.squareup.picasso.Picasso", FareSplitChipAdapter.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.ui.ContactChipAdapter", FareSplitChipAdapter.class, getClass().getClassLoader(), false, true);
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mPicasso);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(FareSplitChipAdapter paramFareSplitChipAdapter)
  {
    paramFareSplitChipAdapter.mPicasso = ((Picasso)this.mPicasso.get());
    this.supertype.injectMembers(paramFareSplitChipAdapter);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.faresplit.master.FareSplitChipAdapter..InjectAdapter
 * JD-Core Version:    0.6.2
 */