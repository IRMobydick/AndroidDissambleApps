package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.bbalbs.common.a.b;
import com.baidu.android.bbalbs.common.a.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public final class a
{
  public static String a(Context paramContext)
  {
    a(paramContext, "android.permission.WRITE_SETTINGS");
    a(paramContext, "android.permission.READ_PHONE_STATE");
    a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE");
    a locala = a.a(paramContext);
    String str1 = locala.a;
    if (locala.b);
    String str2;
    for (int i = 0; ; i = 1)
    {
      str2 = c(paramContext);
      if (i == 0)
        break;
      return c.a(("com.baidu" + str2).getBytes(), true);
    }
    String str3 = Settings.System.getString(paramContext.getContentResolver(), "com.baidu.deviceid");
    boolean bool = TextUtils.isEmpty(str3);
    String str4 = null;
    if (bool)
    {
      str4 = c.a(("com.baidu" + str1 + str2).getBytes(), true);
      str3 = Settings.System.getString(paramContext.getContentResolver(), str4);
      if (!TextUtils.isEmpty(str3))
      {
        Settings.System.putString(paramContext.getContentResolver(), "com.baidu.deviceid", str3);
        a(str1, str3);
      }
    }
    if (TextUtils.isEmpty(str3))
    {
      str3 = a(str1);
      if (!TextUtils.isEmpty(str3))
      {
        Settings.System.putString(paramContext.getContentResolver(), str4, str3);
        Settings.System.putString(paramContext.getContentResolver(), "com.baidu.deviceid", str3);
      }
    }
    if (TextUtils.isEmpty(str3))
    {
      String str5 = UUID.randomUUID().toString();
      str3 = c.a((str1 + str2 + str5).getBytes(), true);
      Settings.System.putString(paramContext.getContentResolver(), str4, str3);
      Settings.System.putString(paramContext.getContentResolver(), "com.baidu.deviceid", str3);
      a(str1, str3);
    }
    return str3;
  }

  private static String a(String paramString)
  {
    String str1;
    if (TextUtils.isEmpty(paramString))
      str1 = "";
    while (true)
    {
      return str1;
      str1 = "";
      File localFile = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new FileReader(localFile));
        StringBuilder localStringBuilder = new StringBuilder();
        while (true)
        {
          String str2 = localBufferedReader.readLine();
          if (str2 == null)
          {
            localBufferedReader.close();
            String[] arrayOfString = new String(com.baidu.android.bbalbs.common.a.a.b("30212102dicudiab", "30212102dicudiab", b.a(localStringBuilder.toString().getBytes()))).split("=");
            if ((arrayOfString == null) || (arrayOfString.length != 2) || (!paramString.equals(arrayOfString[0])))
              break;
            return arrayOfString[1];
          }
          localStringBuilder.append(str2);
          localStringBuilder.append("\r\n");
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        return str1;
      }
      catch (Exception localException)
      {
        return str1;
      }
      catch (IOException localIOException)
      {
      }
    }
    return str1;
  }

  private static void a(Context paramContext, String paramString)
  {
    if (paramContext.checkCallingOrSelfPermission(paramString) == 0);
    for (int i = 1; i == 0; i = 0)
      throw new SecurityException("Permission Denial: requires permission " + paramString);
  }

  private static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      return;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("=");
    localStringBuilder.append(paramString2);
    File localFile = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
    try
    {
      new File(localFile.getParent()).mkdirs();
      FileWriter localFileWriter = new FileWriter(localFile, false);
      localFileWriter.write(b.a(com.baidu.android.bbalbs.common.a.a.a("30212102dicudiab", "30212102dicudiab", localStringBuilder.toString().getBytes()), "utf-8"));
      localFileWriter.flush();
      localFileWriter.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
    catch (Exception localException)
    {
    }
  }

  public static String b(Context paramContext)
  {
    return a.a(paramContext).a;
  }

  public static String c(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if (TextUtils.isEmpty(str))
      str = "";
    return str;
  }

  static final class a
  {
    public final String a;
    public final boolean b;

    private a(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }

    static a a(Context paramContext)
    {
      int i = 0;
      String str = "";
      try
      {
        str = Settings.System.getString(paramContext.getContentResolver(), "bd_setting_i");
        if (TextUtils.isEmpty(str))
          str = a(paramContext, "");
        Settings.System.putString(paramContext.getContentResolver(), "bd_setting_i", str);
        if (i != 0)
        {
          bool = false;
          return new a(str, bool);
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          boolean bool;
          Log.e("DeviceId", "Settings.System.getString or putString failed", localException);
          i = 1;
          if (TextUtils.isEmpty(str))
          {
            str = a(paramContext, "");
            continue;
            bool = true;
          }
        }
      }
    }

    private static String a(Context paramContext, String paramString)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        localObject = null;
        if (localTelephonyManager != null)
        {
          String str2 = localTelephonyManager.getDeviceId();
          localObject = str2;
        }
        String str1 = a(localObject);
        if (TextUtils.isEmpty(str1))
          str1 = paramString;
        return str1;
      }
      catch (Exception localException)
      {
        while (true)
        {
          Log.e("DeviceId", "Read IMEI failed", localException);
          Object localObject = null;
        }
      }
    }

    private static String a(String paramString)
    {
      if ((paramString != null) && (paramString.contains(":")))
        paramString = "";
      return paramString;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.android.bbalbs.common.util.a
 * JD-Core Version:    0.6.2
 */