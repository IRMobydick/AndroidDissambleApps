package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.a;

final class jt extends Handler
{
  public jt(jr paramjr, Looper paramLooper)
  {
    super(paramLooper);
  }

  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (!this.a.h()))
    {
      jv localjv2 = (jv)paramMessage.obj;
      localjv2.a();
      localjv2.c();
    }
    while (true)
    {
      return;
      if (paramMessage.what == 3)
      {
        jr.a(this.a).a(new a(((Integer)paramMessage.obj).intValue(), null));
        continue;
      }
      if (paramMessage.what == 4)
      {
        jr.a(this.a, 1);
        jr.a(this.a, null);
        jr.a(this.a).a(((Integer)paramMessage.obj).intValue());
        continue;
      }
      if ((paramMessage.what == 2) && (!this.a.g()))
      {
        jv localjv1 = (jv)paramMessage.obj;
        localjv1.a();
        localjv1.c();
        continue;
      }
      if ((paramMessage.what == 2) || (paramMessage.what == 1))
      {
        ((jv)paramMessage.obj).b();
        continue;
      }
      Log.wtf("GmsClient", "Don't know how to handle this message.");
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jt
 * JD-Core Version:    0.6.0
 */