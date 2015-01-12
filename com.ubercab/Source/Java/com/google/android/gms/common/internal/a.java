package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;

public final class a
{
  public static void I(boolean paramBoolean)
  {
    if (!paramBoolean)
      throw new IllegalStateException();
  }

  public static void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
      throw new IllegalStateException(String.valueOf(paramObject));
  }

  public static void aT(String paramString)
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread())
    {
      Log.e("Asserts", "checkMainThread: current thread " + Thread.currentThread() + " IS NOT the main thread " + Looper.getMainLooper().getThread() + "!");
      throw new IllegalStateException(paramString);
    }
  }

  public static void aU(String paramString)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      Log.e("Asserts", "checkNotMainThread: current thread " + Thread.currentThread() + " IS the main thread " + Looper.getMainLooper().getThread() + "!");
      throw new IllegalStateException(paramString);
    }
  }

  public static void f(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("null reference");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.a
 * JD-Core Version:    0.6.2
 */