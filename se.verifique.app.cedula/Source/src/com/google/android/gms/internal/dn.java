package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.SystemClock;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class dn extends dz
{
  private String a;
  private Context b;
  private String c;
  private ArrayList d;

  public dn(String paramString1, ArrayList paramArrayList, Context paramContext, String paramString2)
  {
    this.c = paramString1;
    this.d = paramArrayList;
    this.a = paramString2;
    this.b = paramContext;
  }

  private void b()
  {
    try
    {
      Class localClass = this.b.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter");
      Class[] arrayOfClass = new Class[4];
      arrayOfClass[0] = Context.class;
      arrayOfClass[1] = String.class;
      arrayOfClass[2] = String.class;
      arrayOfClass[3] = Boolean.TYPE;
      Method localMethod = localClass.getDeclaredMethod("reportWithProductId", arrayOfClass);
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = this.b;
      arrayOfObject[1] = this.c;
      arrayOfObject[2] = "";
      arrayOfObject[3] = Boolean.valueOf(true);
      localMethod.invoke(null, arrayOfObject);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        hi.e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      while (true)
        hi.e("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
    }
    catch (Exception localException)
    {
      while (true)
        hi.c("Fail to report a conversion.", localException);
    }
  }

  protected int a(int paramInt)
  {
    int i = 1;
    if (paramInt == 0);
    while (true)
    {
      return i;
      if (paramInt == i)
      {
        i = 2;
        continue;
      }
      if (paramInt == 4)
      {
        i = 3;
        continue;
      }
      i = 0;
    }
  }

  public String a()
  {
    return this.c;
  }

  protected String a(String paramString, HashMap paramHashMap)
  {
    String str1 = this.b.getPackageName();
    String str14;
    String str15;
    Object[] arrayOfObject14;
    try
    {
      String str18 = this.b.getPackageManager().getPackageInfo(str1, 0).versionName;
      str2 = str18;
      l = SystemClock.elapsedRealtime() - gm.d().a();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str16 = (String)localIterator.next();
        Object[] arrayOfObject15 = new Object[1];
        arrayOfObject15[0] = str16;
        String str17 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", arrayOfObject15);
        Object[] arrayOfObject16 = new Object[1];
        arrayOfObject16[0] = paramHashMap.get(str16);
        paramString = paramString.replaceAll(str17, String.format("$1%s$2", arrayOfObject16));
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      String str2;
      long l;
      while (true)
      {
        hi.c("Error to retrieve app version", localNameNotFoundException);
        str2 = "";
      }
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = "sessionid";
      String str3 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", arrayOfObject1);
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = gm.a;
      String str4 = paramString.replaceAll(str3, String.format("$1%s$2", arrayOfObject2));
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = "appid";
      String str5 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", arrayOfObject3);
      Object[] arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = str1;
      String str6 = str4.replaceAll(str5, String.format("$1%s$2", arrayOfObject4));
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = "osversion";
      String str7 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", arrayOfObject5);
      Object[] arrayOfObject6 = new Object[1];
      arrayOfObject6[0] = String.valueOf(Build.VERSION.SDK_INT);
      String str8 = str6.replaceAll(str7, String.format("$1%s$2", arrayOfObject6));
      Object[] arrayOfObject7 = new Object[1];
      arrayOfObject7[0] = "sdkversion";
      String str9 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", arrayOfObject7);
      Object[] arrayOfObject8 = new Object[1];
      arrayOfObject8[0] = this.a;
      String str10 = str8.replaceAll(str9, String.format("$1%s$2", arrayOfObject8));
      Object[] arrayOfObject9 = new Object[1];
      arrayOfObject9[0] = "appversion";
      String str11 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", arrayOfObject9);
      Object[] arrayOfObject10 = new Object[1];
      arrayOfObject10[0] = str2;
      String str12 = str10.replaceAll(str11, String.format("$1%s$2", arrayOfObject10));
      Object[] arrayOfObject11 = new Object[1];
      arrayOfObject11[0] = "timestamp";
      String str13 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", arrayOfObject11);
      Object[] arrayOfObject12 = new Object[1];
      arrayOfObject12[0] = String.valueOf(l);
      str14 = str12.replaceAll(str13, String.format("$1%s$2", arrayOfObject12));
      Object[] arrayOfObject13 = new Object[1];
      arrayOfObject13[0] = "[^@]+";
      str15 = String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", arrayOfObject13);
      arrayOfObject14 = new Object[1];
      arrayOfObject14[0] = "";
    }
    return str14.replaceAll(str15, String.format("$1%s$2", arrayOfObject14)).replaceAll("@@", "@");
  }

  public void b(int paramInt)
  {
    if (paramInt == 1)
      b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", String.valueOf(paramInt));
    localHashMap.put("sku", this.c);
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      new hg(this.b, this.a, a(str, localHashMap)).e();
    }
  }

  public void c(int paramInt)
  {
    if (paramInt == 0)
      b();
    HashMap localHashMap = new HashMap();
    localHashMap.put("google_play_status", String.valueOf(paramInt));
    localHashMap.put("sku", this.c);
    localHashMap.put("status", String.valueOf(a(paramInt)));
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      new hg(this.b, this.a, a(str, localHashMap)).e();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dn
 * JD-Core Version:    0.6.0
 */