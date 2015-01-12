package com.ubercab.library.app;

import android.os.Handler;
import android.os.Looper;
import com.squareup.otto.Bus;

public class AndroidBus extends Bus
{
  private final Handler mHandlerMain = new Handler(Looper.getMainLooper());

  public void post(final Object paramObject)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      super.post(paramObject);
      return;
    }
    this.mHandlerMain.post(new Runnable()
    {
      public void run()
      {
        AndroidBus.this.post(paramObject);
      }
    });
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.AndroidBus
 * JD-Core Version:    0.6.2
 */