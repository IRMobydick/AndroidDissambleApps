package com.baidu.platform.comapi.b;

import android.os.Handler;
import android.os.Message;

class e extends Handler
{
  e(d paramd)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    if (d.a(this.a) == 0);
    while ((d.a(this.a) != ((Integer)paramMessage.obj).intValue()) || (d.b(this.a) == null))
      return;
    d.b(this.a).a(paramMessage);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comapi.b.e
 * JD-Core Version:    0.6.2
 */