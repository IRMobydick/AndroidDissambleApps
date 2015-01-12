package com.google.android.gms.analytics;

import android.os.Build.VERSION;
import java.io.File;

class o
{
  static boolean ag(String paramString)
  {
    if (version() < 9)
      return false;
    File localFile = new File(paramString);
    localFile.setReadable(false, false);
    localFile.setWritable(false, false);
    localFile.setReadable(true, true);
    localFile.setWritable(true, true);
    return true;
  }

  public static int version()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      z.T("Invalid version number: " + Build.VERSION.SDK);
    }
    return 0;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.o
 * JD-Core Version:    0.6.2
 */