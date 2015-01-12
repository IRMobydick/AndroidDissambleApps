package com.paypal.android.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

public final class bf extends bh
{
  private Context a;
  private String b;
  private Handler c;

  public bf(Context paramContext, String paramString, Handler paramHandler)
  {
    this.a = paramContext;
    this.b = paramString;
    this.c = paramHandler;
  }

  public final void run()
  {
    this.c.sendMessage(Message.obtain(this.c, 10, this.b));
    try
    {
      aT localaT = new aT(this.a, this.b);
      this.c.sendMessage(Message.obtain(this.c, 12, localaT));
      return;
    }
    catch (Exception localException)
    {
      this.c.sendMessage(Message.obtain(this.c, 11, localException));
      return;
    }
    finally
    {
      bi.a().b(this);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.bf
 * JD-Core Version:    0.6.2
 */