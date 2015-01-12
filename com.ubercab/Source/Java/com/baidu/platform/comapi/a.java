package com.baidu.platform.comapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.platform.comapi.c.b;
import com.baidu.platform.comapi.c.c;

public class a extends BroadcastReceiver
{
  public static final String a = a.class.getSimpleName();

  public void a(Context paramContext)
  {
    String str = b.c(paramContext);
    if (!c.g().equals(str))
      c.a(str);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    a(paramContext);
    b.a(paramContext);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comapi.a
 * JD-Core Version:    0.6.2
 */