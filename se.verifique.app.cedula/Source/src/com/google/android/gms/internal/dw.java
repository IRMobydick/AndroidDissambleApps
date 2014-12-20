package com.google.android.gms.internal;

import android.content.Intent;

public class dw
{
  private final String a;

  public dw(String paramString)
  {
    this.a = paramString;
  }

  public String a()
  {
    return gw.d();
  }

  public boolean a(String paramString, int paramInt, Intent paramIntent)
  {
    int i = 0;
    if ((paramString == null) || (paramIntent == null));
    while (true)
    {
      return i;
      String str1 = dv.b(paramIntent);
      String str2 = dv.c(paramIntent);
      if ((str1 == null) || (str2 == null))
        continue;
      if (!paramString.equals(dv.a(str1)))
      {
        hi.e("Developer payload not match.");
        continue;
      }
      if ((this.a != null) && (!dx.a(this.a, str1, str2)))
      {
        hi.e("Fail to verify signature.");
        continue;
      }
      i = 1;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dw
 * JD-Core Version:    0.6.0
 */