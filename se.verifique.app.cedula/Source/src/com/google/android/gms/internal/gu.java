package com.google.android.gms.internal;

import android.os.Process;

final class gu
  implements Runnable
{
  gu(Runnable paramRunnable)
  {
  }

  public void run()
  {
    Process.setThreadPriority(10);
    this.a.run();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gu
 * JD-Core Version:    0.6.0
 */