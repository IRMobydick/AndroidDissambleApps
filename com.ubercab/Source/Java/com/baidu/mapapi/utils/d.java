package com.baidu.mapapi.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public final class d
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;

  d(Context paramContext)
  {
    this.a = Environment.getExternalStorageDirectory().getAbsolutePath();
    this.b = (this.a + File.separator + "BaiduMapSDK");
    this.c = paramContext.getCacheDir().getAbsolutePath();
    this.d = "";
    this.e = "";
  }

  d(String paramString1, String paramString2, Context paramContext)
  {
    this.a = paramString1;
    this.b = (this.a + File.separator + "BaiduMapSDK");
    this.c = (this.b + File.separator + "cache");
    this.d = paramContext.getCacheDir().getAbsolutePath();
    this.e = paramString2;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.a + File.separator + "BaiduMapSDK";
  }

  public String c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!d.class.isInstance(paramObject)))
      return false;
    d locald = (d)paramObject;
    return this.a.equals(locald.a);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.utils.d
 * JD-Core Version:    0.6.2
 */