package com.ubercab.client.feature.signin;

import android.app.ActionBar;
import android.os.Bundle;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.network.RiderClient;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.signin.event.SignInSuccessfulEvent;
import com.ubercab.library.network.dispatch.DispatchRequest;
import javax.inject.Inject;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SignInActivity extends RiderPublicActivity
{

  @Inject
  RiderClient mRiderClient;

  private void putSignInFragment()
  {
    if (findFragment(SignInFragment.class) == null)
      putFragment(2131427713, new SignInFragment(), false);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903175);
    String str = getString(2131558917);
    getActionBar().setTitle(str);
    putSignInFragment();
  }

  public void onDispatchError(DispatchRequest paramDispatchRequest, Ping paramPing, Response paramResponse)
  {
  }

  public void onDispatchNetworkError(DispatchRequest paramDispatchRequest, RetrofitError paramRetrofitError)
  {
  }

  @Subscribe
  public void onSignInSuccessfulEvent(SignInSuccessfulEvent paramSignInSuccessfulEvent)
  {
    Ping localPing = paramSignInSuccessfulEvent.getPing();
    if (!PingUtils.hasClient(localPing))
      return;
    String str1 = localPing.getClient().getUuid();
    String str2 = localPing.getClient().getToken();
    String str3 = localPing.getClient().getEmail();
    RiderApplication.get(this).setCurrentUser(str1, str2, str3);
    this.mRiderClient.pingClient();
    setResult(-1);
    finish();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signin.SignInActivity
 * JD-Core Version:    0.6.2
 */