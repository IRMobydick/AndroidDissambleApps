package com.baidu.location;

import android.os.HandlerThread;

class ao
{
  private static HandlerThread a = null;

  static HandlerThread a()
  {
    if (a == null)
    {
      a = new HandlerThread("ServiceStartArguments", 10);
      a.start();
    }
    return a;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.ao
 * JD-Core Version:    0.6.2
 */