package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;

final class gl
{
  private long a = -1L;
  private long b = -1L;

  public long a()
  {
    return this.b;
  }

  public void b()
  {
    this.b = SystemClock.elapsedRealtime();
  }

  public void c()
  {
    this.a = SystemClock.elapsedRealtime();
  }

  public Bundle d()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("topen", this.a);
    localBundle.putLong("tclose", this.b);
    return localBundle;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gl
 * JD-Core Version:    0.6.0
 */