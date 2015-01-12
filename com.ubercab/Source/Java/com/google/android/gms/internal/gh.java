package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

@ez
public final class gh
{
  public static void a(Context paramContext, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = n(paramContext).edit();
    localEditor.putBoolean("use_https", paramBoolean);
    localEditor.commit();
  }

  private static SharedPreferences n(Context paramContext)
  {
    return paramContext.getSharedPreferences("admob", 0);
  }

  public static boolean o(Context paramContext)
  {
    return n(paramContext).getBoolean("use_https", true);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gh
 * JD-Core Version:    0.6.2
 */