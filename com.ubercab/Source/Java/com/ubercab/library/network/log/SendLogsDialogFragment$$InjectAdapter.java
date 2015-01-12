package com.ubercab.library.network.log;

import android.content.Context;
import com.ubercab.library.app.UberDialogFragment;
import com.ubercab.library.network.cn.CnClient;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class SendLogsDialogFragment$$InjectAdapter extends Binding<SendLogsDialogFragment>
  implements Provider<SendLogsDialogFragment>, MembersInjector<SendLogsDialogFragment>
{
  private Binding<CnClient> mCnClient;
  private Binding<Context> mContext;
  private Binding<UberDialogFragment> supertype;

  public SendLogsDialogFragment$$InjectAdapter()
  {
    super("com.ubercab.library.network.log.SendLogsDialogFragment", "members/com.ubercab.library.network.log.SendLogsDialogFragment", false, SendLogsDialogFragment.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mContext = paramLinker.requestBinding("@com.ubercab.library.app.annotation.ForApp()/android.content.Context", SendLogsDialogFragment.class, getClass().getClassLoader());
    this.mCnClient = paramLinker.requestBinding("com.ubercab.library.network.cn.CnClient", SendLogsDialogFragment.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.library.app.UberDialogFragment", SendLogsDialogFragment.class, getClass().getClassLoader(), false, true);
  }

  public SendLogsDialogFragment get()
  {
    SendLogsDialogFragment localSendLogsDialogFragment = new SendLogsDialogFragment();
    injectMembers(localSendLogsDialogFragment);
    return localSendLogsDialogFragment;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mContext);
    paramSet2.add(this.mCnClient);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(SendLogsDialogFragment paramSendLogsDialogFragment)
  {
    paramSendLogsDialogFragment.mContext = ((Context)this.mContext.get());
    paramSendLogsDialogFragment.mCnClient = ((CnClient)this.mCnClient.get());
    this.supertype.injectMembers(paramSendLogsDialogFragment);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.log.SendLogsDialogFragment..InjectAdapter
 * JD-Core Version:    0.6.2
 */