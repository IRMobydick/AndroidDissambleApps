package com.baidu.location;

import android.location.Location;
import android.os.Handler;
import android.os.Message;

class x$1 extends Handler
{
  x$1(x paramx)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    if (!ab.gv);
    do
    {
      return;
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        x.jdMethod_do(this.a, (Location)paramMessage.obj);
        return;
      case 2:
      case 3:
      case 4:
      }
    }
    while (x.jdMethod_for(this.a) == null);
    x.jdMethod_for(this.a).a((String)paramMessage.obj);
    return;
    x.jdMethod_if(this.a, "&og=1", (Location)paramMessage.obj);
    return;
    x.jdMethod_if(this.a, "&og=2", (Location)paramMessage.obj);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.x.1
 * JD-Core Version:    0.6.2
 */