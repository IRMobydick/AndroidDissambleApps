package com.baidu.lbsapi.auth;

import android.util.Log;

class a
{
  public static boolean a = false;

  public static String a()
  {
    StackTraceElement localStackTraceElement = new java.lang.Throwable().getStackTrace()[2];
    return localStackTraceElement.getFileName() + "[" + localStackTraceElement.getLineNumber() + "]";
  }

  public static void a(String paramString)
  {
    if (Thread.currentThread().getStackTrace().length == 0)
      return;
    Log.d(a(), paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.lbsapi.auth.a
 * JD-Core Version:    0.6.2
 */