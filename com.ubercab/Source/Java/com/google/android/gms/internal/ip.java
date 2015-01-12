package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

public class ip
{
  private static boolean GX = false;
  private boolean GY;
  private boolean GZ;
  private String Ha;
  private final String mTag;

  public ip(String paramString)
  {
    this(paramString, fS());
  }

  public ip(String paramString, boolean paramBoolean)
  {
    this.mTag = paramString;
    this.GY = paramBoolean;
    this.GZ = false;
  }

  private String e(String paramString, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length == 0);
    while (true)
    {
      if (!TextUtils.isEmpty(this.Ha))
        paramString = this.Ha + paramString;
      return paramString;
      paramString = String.format(paramString, paramArrayOfObject);
    }
  }

  public static boolean fS()
  {
    return GX;
  }

  public void a(String paramString, Object[] paramArrayOfObject)
  {
    if (fR())
      Log.v(this.mTag, e(paramString, paramArrayOfObject));
  }

  public void a(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    if ((fQ()) || (GX))
      Log.d(this.mTag, e(paramString, paramArrayOfObject), paramThrowable);
  }

  public void aK(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    for (String str = null; ; str = String.format("[%s] ", new Object[] { paramString }))
    {
      this.Ha = str;
      return;
    }
  }

  public void b(String paramString, Object[] paramArrayOfObject)
  {
    if ((fQ()) || (GX))
      Log.d(this.mTag, e(paramString, paramArrayOfObject));
  }

  public void c(String paramString, Object[] paramArrayOfObject)
  {
    Log.i(this.mTag, e(paramString, paramArrayOfObject));
  }

  public void d(String paramString, Object[] paramArrayOfObject)
  {
    Log.w(this.mTag, e(paramString, paramArrayOfObject));
  }

  public boolean fQ()
  {
    return this.GY;
  }

  public boolean fR()
  {
    return this.GZ;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ip
 * JD-Core Version:    0.6.2
 */