package android.support.v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;

public class ConnectivityManagerCompat
{
  private static final ConnectivityManagerCompatImpl IMPL;

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
      IMPL = new ConnectivityManagerCompat.JellyBeanConnectivityManagerCompatImpl();
    while (true)
    {
      return;
      if (Build.VERSION.SDK_INT >= 13)
      {
        IMPL = new ConnectivityManagerCompat.HoneycombMR2ConnectivityManagerCompatImpl();
        continue;
      }
      if (Build.VERSION.SDK_INT >= 8)
      {
        IMPL = new ConnectivityManagerCompat.GingerbreadConnectivityManagerCompatImpl();
        continue;
      }
      IMPL = new ConnectivityManagerCompat.BaseConnectivityManagerCompatImpl();
    }
  }

  public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager paramConnectivityManager, Intent paramIntent)
  {
    return paramConnectivityManager.getNetworkInfo(((NetworkInfo)paramIntent.getParcelableExtra("networkInfo")).getType());
  }

  public static boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager)
  {
    return IMPL.isActiveNetworkMetered(paramConnectivityManager);
  }

  static abstract interface ConnectivityManagerCompatImpl
  {
    public abstract boolean isActiveNetworkMetered(ConnectivityManager paramConnectivityManager);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.net.ConnectivityManagerCompat
 * JD-Core Version:    0.6.0
 */