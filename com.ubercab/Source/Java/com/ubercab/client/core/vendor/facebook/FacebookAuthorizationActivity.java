package com.ubercab.client.core.vendor.facebook;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderPublicActivity;
import com.ubercab.client.core.util.NumberUtils;
import com.ubercab.client.feature.signin.SignInFragment;
import com.ubercab.common.base.Joiner;

public class FacebookAuthorizationActivity extends RiderPublicActivity
{
  public static final String AUTH_CLASS_NAME = "com.facebook.katana.ProxyAuth";
  public static final String AUTH_PACKAGE_NAME = "com.facebook.katana";
  public static final String AUTH_REDIRECT_URI = "https://www.facebook.com/connect/login_success.html";
  public static final String EXTRA_TOKEN = "token";
  public static final String EXTRA_TOKEN_EXPIRY = "tokenExpiry";
  public static final String PARAM_ACCESS_TOKEN = "access_token";
  public static final String PARAM_CLIENT_ID = "client_id";
  public static final String PARAM_EXPIRES_IN = "expires_in";
  public static final String PARAM_REDIRECT_URI = "redirect_uri";
  public static final String PARAM_RESPONSE_TYPE = "response_type";
  public static final String PARAM_SCOPE = "scope";
  public static final String PERMISSION_EMAIL = "email";
  public static final String PERMISSION_PUBLIC_PROFILE = "public_profile";
  public static final String PERMISSION_USER_FRIENDS = "user_friends";
  private static final int REQUEST_CODE_FACEBOOK_AUTH = 1;

  private String getAppId()
  {
    return getResources().getString(2131559271);
  }

  private static String getPermissions()
  {
    return Joiner.on(",").join("email", "public_profile", new Object[] { "user_friends" });
  }

  private boolean isFacebookAppInstalled()
  {
    try
    {
      getPackageManager().getApplicationInfo("com.facebook.katana", 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  private void putSignInFragment()
  {
    if (findFragment(SignInFragment.class) == null)
      putFragment(2131427422, FacebookAuthorizationFragment.newInstance(buildUrl()), false);
  }

  String buildUrl()
  {
    return new Uri.Builder().scheme("https").authority("www.facebook.com").appendPath("dialog").appendPath("oauth").appendQueryParameter("client_id", getAppId()).appendQueryParameter("redirect_uri", "https://www.facebook.com/connect/login_success.html").appendQueryParameter("response_type", "token").appendQueryParameter("scope", getPermissions()).build().toString();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      int i = 0;
      if (paramIntent != null)
      {
        String str = paramIntent.getStringExtra("access_token");
        boolean bool = TextUtils.isEmpty(str);
        i = 0;
        if (!bool)
        {
          onFacebookTokenEvent(new FacebookTokenEvent(str, NumberUtils.tryParseLong(paramIntent.getStringExtra("expires_in"), 0L)));
          i = 1;
        }
      }
      if (i == 0)
        onFacebookTokenEvent(new FacebookTokenEvent());
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903069);
    if ((paramBundle != null) || (isFacebookAppInstalled()))
      try
      {
        startActivityForResult(new Intent().setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth").putExtra("client_id", getAppId()).putExtra("scope", getPermissions()), 1);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        putSignInFragment();
        return;
      }
    putSignInFragment();
  }

  @Subscribe
  public void onFacebookTokenEvent(FacebookTokenEvent paramFacebookTokenEvent)
  {
    setResult(-1, new Intent().putExtra("token", paramFacebookTokenEvent.getToken()).putExtra("tokenExpiry", paramFacebookTokenEvent.getTokenExpiry()));
    finish();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.facebook.FacebookAuthorizationActivity
 * JD-Core Version:    0.6.2
 */