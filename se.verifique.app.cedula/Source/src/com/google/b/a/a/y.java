package com.google.b.a.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class y
  implements Handler.Callback
{
  y(w paramw)
  {
  }

  public boolean handleMessage(Message paramMessage)
  {
    if ((1 == paramMessage.what) && (w.f().equals(paramMessage.obj)))
    {
      am.a().a(true);
      this.a.c();
      am.a().a(false);
      if ((w.b(this.a) > 0) && (!w.c(this.a)))
        w.d(this.a).sendMessageDelayed(w.d(this.a).obtainMessage(1, w.f()), 1000 * w.b(this.a));
    }
    return true;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.y
 * JD-Core Version:    0.6.0
 */