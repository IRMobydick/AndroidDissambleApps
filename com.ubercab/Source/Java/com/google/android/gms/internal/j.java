package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

public class j extends i
{
  protected j(Context paramContext, m paramm, n paramn)
  {
    super(paramContext, paramm, paramn);
  }

  public static j a(String paramString, Context paramContext)
  {
    e locale = new e();
    a(paramString, paramContext, locale);
    return new j(paramContext, locale, new p(239));
  }

  protected void b(Context paramContext)
  {
    super.b(paramContext);
    try
    {
      a locala1 = h(paramContext);
      if (locala1.isLimitAdTrackingEnabled());
      for (long l = 1L; ; l = 0L)
      {
        a(28, l);
        String str = locala1.getId();
        if (str != null)
        {
          a(26, 5L);
          a(24, str);
        }
        return;
      }
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      a(24, d(paramContext));
      return;
    }
    catch (IOException localIOException)
    {
    }
    catch (i.a locala)
    {
    }
  }

  a h(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException
  {
    int i = 0;
    AdvertisingIdClient.Info localInfo;
    String str1;
    byte[] arrayOfByte;
    try
    {
      localInfo = AdvertisingIdClient.getAdvertisingIdInfo(paramContext);
      str1 = localInfo.getId();
      if ((str1 != null) && (str1.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")))
      {
        arrayOfByte = new byte[16];
        int j = 0;
        while (i < str1.length())
        {
          if ((i == 8) || (i == 13) || (i == 18) || (i == 23))
            i++;
          arrayOfByte[j] = ((byte)((Character.digit(str1.charAt(i), 16) << 4) + Character.digit(str1.charAt(i + 1), 16)));
          j++;
          i += 2;
        }
      }
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      throw new IOException(localGooglePlayServicesRepairableException);
    }
    catch (SecurityException localSecurityException)
    {
      throw new IOException(localSecurityException);
    }
    for (String str2 = this.ky.a(arrayOfByte, true); ; str2 = str1)
      return new a(str2, localInfo.isLimitAdTrackingEnabled());
  }

  class a
  {
    private String kO;
    private boolean kP;

    public a(String paramBoolean, boolean arg3)
    {
      this.kO = paramBoolean;
      boolean bool;
      this.kP = bool;
    }

    public String getId()
    {
      return this.kO;
    }

    public boolean isLimitAdTrackingEnabled()
    {
      return this.kP;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.j
 * JD-Core Version:    0.6.2
 */