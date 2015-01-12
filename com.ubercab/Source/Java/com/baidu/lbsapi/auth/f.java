package com.baidu.lbsapi.auth;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Hashtable;

class f extends Handler
{
  f(e parame, Looper paramLooper)
  {
    super(paramLooper);
  }

  public void handleMessage(Message paramMessage)
  {
    if (a.a)
      a.a("handleMessage !!");
    String str = paramMessage.getData().getString("listenerKey");
    i locali = (i)e.a().get(str);
    if (a.a)
      a.a("handleMessage listener = " + locali);
    if (locali != null)
      locali.a(paramMessage.what, paramMessage.obj.toString());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.lbsapi.auth.f
 * JD-Core Version:    0.6.2
 */