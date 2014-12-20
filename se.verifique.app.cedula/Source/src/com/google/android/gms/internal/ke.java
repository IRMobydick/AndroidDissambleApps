package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.c;
import java.util.ArrayList;

final class ke extends Handler
{
  public ke(kd paramkd, Looper paramLooper)
  {
    super(paramLooper);
  }

  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
      synchronized (kd.a(this.a))
      {
        if ((kd.b(this.a).n()) && (kd.b(this.a).g()) && (kd.a(this.a).contains(paramMessage.obj)))
        {
          Bundle localBundle = kd.b(this.a).l();
          ((c)paramMessage.obj).a(localBundle);
        }
      }
    Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ke
 * JD-Core Version:    0.6.0
 */