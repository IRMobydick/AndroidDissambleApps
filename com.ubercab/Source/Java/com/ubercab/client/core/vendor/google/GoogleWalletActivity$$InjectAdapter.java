package com.ubercab.client.core.vendor.google;

import com.ubercab.client.core.app.RiderPreferences;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.feature.payment.UberBraintree;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

public final class GoogleWalletActivity$$InjectAdapter extends Binding<GoogleWalletActivity>
  implements Provider<GoogleWalletActivity>, MembersInjector<GoogleWalletActivity>
{
  private Binding<UberBraintree> mBraintree;
  private Binding<PingProvider> mPingProvider;
  private Binding<RiderClient> mRiderClient;
  private Binding<RiderPreferences> mRiderPreferences;
  private Binding<SessionPreferences> mSessionPreferences;
  private Binding<RiderPublicActivity> supertype;

  public GoogleWalletActivity$$InjectAdapter()
  {
    super("com.ubercab.client.core.vendor.google.GoogleWalletActivity", "members/com.ubercab.client.core.vendor.google.GoogleWalletActivity", false, GoogleWalletActivity.class);
  }

  public void attach(Linker paramLinker)
  {
    this.mSessionPreferences = paramLinker.requestBinding("com.ubercab.client.core.content.SessionPreferences", GoogleWalletActivity.class, getClass().getClassLoader());
    this.mRiderClient = paramLinker.requestBinding("com.ubercab.client.core.network.RiderClient", GoogleWalletActivity.class, getClass().getClassLoader());
    this.mBraintree = paramLinker.requestBinding("com.ubercab.client.feature.payment.UberBraintree", GoogleWalletActivity.class, getClass().getClassLoader());
    this.mPingProvider = paramLinker.requestBinding("com.ubercab.client.core.content.PingProvider", GoogleWalletActivity.class, getClass().getClassLoader());
    this.mRiderPreferences = paramLinker.requestBinding("com.ubercab.client.core.app.RiderPreferences", GoogleWalletActivity.class, getClass().getClassLoader());
    this.supertype = paramLinker.requestBinding("members/com.ubercab.client.core.app.RiderPublicActivity", GoogleWalletActivity.class, getClass().getClassLoader(), false, true);
  }

  public GoogleWalletActivity get()
  {
    GoogleWalletActivity localGoogleWalletActivity = new GoogleWalletActivity();
    injectMembers(localGoogleWalletActivity);
    return localGoogleWalletActivity;
  }

  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(this.mSessionPreferences);
    paramSet2.add(this.mRiderClient);
    paramSet2.add(this.mBraintree);
    paramSet2.add(this.mPingProvider);
    paramSet2.add(this.mRiderPreferences);
    paramSet2.add(this.supertype);
  }

  public void injectMembers(GoogleWalletActivity paramGoogleWalletActivity)
  {
    paramGoogleWalletActivity.mSessionPreferences = ((SessionPreferences)this.mSessionPreferences.get());
    paramGoogleWalletActivity.mRiderClient = ((RiderClient)this.mRiderClient.get());
    paramGoogleWalletActivity.mBraintree = ((UberBraintree)this.mBraintree.get());
    paramGoogleWalletActivity.mPingProvider = ((PingProvider)this.mPingProvider.get());
    paramGoogleWalletActivity.mRiderPreferences = ((RiderPreferences)this.mRiderPreferences.get());
    this.supertype.injectMembers(paramGoogleWalletActivity);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.GoogleWalletActivity..InjectAdapter
 * JD-Core Version:    0.6.2
 */