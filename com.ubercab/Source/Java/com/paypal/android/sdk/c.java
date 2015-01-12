package com.paypal.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.TelephonyManager;
import java.util.UUID;

public class c
{
  private static final String a = c.class.getSimpleName();
  private Context b;
  private String c;

  public c(Context paramContext, String paramString)
  {
    this.b = paramContext;
    this.c = paramString;
  }

  public final String a(String paramString1, String paramString2)
  {
    return this.b.getSharedPreferences(this.c, 0).getString(paramString1, paramString2);
  }

  public final boolean a()
  {
    NetworkInfo[] arrayOfNetworkInfo = ((ConnectivityManager)this.b.getSystemService("connectivity")).getAllNetworkInfo();
    int i = arrayOfNetworkInfo.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      NetworkInfo.State localState = arrayOfNetworkInfo[j].getState();
      if ((localState == NetworkInfo.State.CONNECTED) || (localState == NetworkInfo.State.CONNECTING))
        k++;
      j++;
    }
    return (k != 0) || (k > 0);
  }

  public final int b()
  {
    return ((TelephonyManager)this.b.getSystemService("phone")).getPhoneType();
  }

  public final void b(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = this.b.getSharedPreferences(this.c, 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }

  public final String c()
  {
    try
    {
      PackageManager localPackageManager = this.b.getPackageManager();
      String str = localPackageManager.getPackageInfo(this.b.getPackageName(), 0).applicationInfo.loadLabel(localPackageManager).toString();
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  public final String d()
  {
    return ((TelephonyManager)this.b.getSystemService("phone")).getSimOperatorName();
  }

  public final String e()
  {
    String str = a("InstallationGUID", null);
    if (str != null)
      return str;
    b("InstallationGUID", UUID.randomUUID().toString());
    return a("InstallationGUID", null);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.c
 * JD-Core Version:    0.6.2
 */