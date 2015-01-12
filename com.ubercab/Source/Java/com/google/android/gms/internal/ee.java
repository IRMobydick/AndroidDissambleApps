package com.google.android.gms.internal;

import android.content.Intent;

@ez
public class ee
{
  private final String oA;

  public ee(String paramString)
  {
    this.oA = paramString;
  }

  public boolean a(String paramString, int paramInt, Intent paramIntent)
  {
    if ((paramString == null) || (paramIntent == null));
    String str1;
    String str2;
    do
    {
      return false;
      str1 = ed.e(paramIntent);
      str2 = ed.f(paramIntent);
    }
    while ((str1 == null) || (str2 == null));
    if (!paramString.equals(ed.D(str1)))
    {
      gs.W("Developer payload not match.");
      return false;
    }
    if ((this.oA != null) && (!ef.b(this.oA, str1, str2)))
    {
      gs.W("Fail to verify signature.");
      return false;
    }
    return true;
  }

  public String ct()
  {
    return gj.jdMethod_do();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ee
 * JD-Core Version:    0.6.2
 */