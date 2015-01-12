package com.google.android.gms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

class a
  implements l
{
  private static a xA;
  private static Object xz = new Object();
  private Context mContext;
  private AdvertisingIdClient.Info xB;
  private long xC;
  private String xD;
  private boolean xE = false;
  private Object xF = new Object();

  a(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }

  private boolean a(AdvertisingIdClient.Info paramInfo1, AdvertisingIdClient.Info paramInfo2)
  {
    if (paramInfo2 == null);
    for (Object localObject1 = null; TextUtils.isEmpty((CharSequence)localObject1); localObject1 = paramInfo2.getId())
      return true;
    h.y(this.mContext);
    h localh = h.dQ();
    String str1 = localh.getValue("&cid");
    String str3;
    while (true)
    {
      synchronized (this.xF)
      {
        if (!this.xE)
        {
          this.xD = x(this.mContext);
          this.xE = true;
          str3 = aa((String)localObject1 + str1);
          if (!TextUtils.isEmpty(str3))
            break;
          return false;
        }
      }
      if (TextUtils.isEmpty(this.xD))
      {
        String str2 = null;
        if (paramInfo1 == null);
        while (str2 == null)
        {
          boolean bool1 = ab((String)localObject1 + str1);
          return bool1;
          str2 = paramInfo1.getId();
        }
        this.xD = aa(str2 + str1);
      }
    }
    if (str3.equals(this.xD))
      return true;
    String str4;
    if (!TextUtils.isEmpty(this.xD))
    {
      z.V("Resetting the client id because Advertising Id changed.");
      str4 = localh.dR();
      z.V("New client Id: " + str4);
    }
    while (true)
    {
      boolean bool2 = ab((String)localObject1 + str4);
      return bool2;
      str4 = str1;
    }
  }

  static String aa(String paramString)
  {
    MessageDigest localMessageDigest = aj.ap("MD5");
    if (localMessageDigest == null)
      return null;
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = new BigInteger(1, localMessageDigest.digest(paramString.getBytes()));
    return String.format(localLocale, "%032X", arrayOfObject);
  }

  private boolean ab(String paramString)
  {
    try
    {
      String str = aa(paramString);
      z.V("Storing hashed adid.");
      FileOutputStream localFileOutputStream = this.mContext.openFileOutput("gaClientIdData", 0);
      localFileOutputStream.write(str.getBytes());
      localFileOutputStream.close();
      this.xD = str;
      return true;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      z.T("Error creating hash file.");
      return false;
    }
    catch (IOException localIOException)
    {
      z.T("Error writing to hash file.");
    }
    return false;
  }

  public static l w(Context paramContext)
  {
    if (xA == null);
    synchronized (xz)
    {
      if (xA == null)
        xA = new a(paramContext);
      return xA;
    }
  }

  static String x(Context paramContext)
  {
    Object localObject = null;
    try
    {
      localFileInputStream = paramContext.openFileInput("gaClientIdData");
      byte[] arrayOfByte = new byte[''];
      int i = localFileInputStream.read(arrayOfByte, 0, 128);
      if (localFileInputStream.available() > 0)
      {
        z.W("Hash file seems corrupted, deleting it.");
        localFileInputStream.close();
        paramContext.deleteFile("gaClientIdData");
        return null;
      }
      if (i <= 0)
      {
        z.U("Hash file is empty.");
        localFileInputStream.close();
        return null;
      }
      str = new String(arrayOfByte, 0, i);
    }
    catch (IOException localIOException1)
    {
      try
      {
        FileInputStream localFileInputStream;
        localFileInputStream.close();
        return str;
        localIOException1 = localIOException1;
        z.W("Error reading Hash file, deleting it.");
        paramContext.deleteFile("gaClientIdData");
        return localObject;
      }
      catch (IOException localIOException2)
      {
        while (true)
          localObject = str;
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        String str;
        return str;
      }
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
    }
    return null;
  }

  AdvertisingIdClient.Info dG()
  {
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
      return localInfo;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      z.W("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
      return null;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      z.W("GooglePlayServicesRepairableException getting Ad Id Info");
      return null;
    }
    catch (IOException localIOException)
    {
      z.W("IOException getting Ad Id Info");
      return null;
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      z.W("GooglePlayServicesNotAvailableException getting Ad Id Info");
      return null;
    }
    catch (Throwable localThrowable)
    {
      z.W("Unknown exception. Could not get the ad Id.");
    }
    return null;
  }

  public String getValue(String paramString)
  {
    long l = System.currentTimeMillis();
    AdvertisingIdClient.Info localInfo;
    if (l - this.xC > 1000L)
    {
      localInfo = dG();
      if (!a(this.xB, localInfo))
        break label72;
    }
    label72: for (this.xB = localInfo; ; this.xB = new AdvertisingIdClient.Info("", false))
    {
      this.xC = l;
      if (this.xB == null)
        break label118;
      if (!"&adid".equals(paramString))
        break;
      return this.xB.getId();
    }
    if ("&ate".equals(paramString))
    {
      if (this.xB.isLimitAdTrackingEnabled())
        return "0";
      return "1";
    }
    label118: return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.a
 * JD-Core Version:    0.6.2
 */