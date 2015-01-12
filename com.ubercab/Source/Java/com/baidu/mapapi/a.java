package com.baidu.mapapi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.mapapi.utils.PermissionCheck;
import com.baidu.mapapi.utils.PermissionCheck.b;
import com.baidu.mapapi.utils.PermissionCheck.c;
import com.baidu.platform.comapi.c.c;
import com.baidu.platform.comjni.engine.AppEngine;
import com.baidu.vi.VMsg;

public class a
  implements PermissionCheck.c
{
  private static final String a = a.class.getSimpleName();
  private static a f;
  private Context b;
  private Handler c;
  private com.baidu.platform.comapi.a d;
  private int e;

  static
  {
    System.loadLibrary("BaiduMapSDK_v3_1_0");
    AppEngine.InitClass();
  }

  public static a a()
  {
    if (f == null)
      f = new a();
    return f;
  }

  private void e()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    if ((this.b != null) && (this.d != null))
      this.b.registerReceiver(this.d, localIntentFilter);
  }

  private void f()
  {
    if ((this.d != null) && (this.b != null))
      this.b.unregisterReceiver(this.d);
  }

  public void a(Context paramContext)
  {
    this.b = paramContext;
  }

  public void a(Message paramMessage)
  {
    if (paramMessage.what == 2012)
    {
      Intent localIntent1 = new Intent("permission check error");
      localIntent1.putExtra("error_code", paramMessage.arg1);
      this.b.sendBroadcast(localIntent1);
    }
    do
    {
      return;
      if (paramMessage.arg2 == 3)
      {
        Intent localIntent2 = new Intent("network error");
        this.b.sendBroadcast(localIntent2);
      }
    }
    while ((paramMessage.arg2 != 2) && (paramMessage.arg2 != 404) && (paramMessage.arg2 != 5) && (paramMessage.arg2 != 8));
    Intent localIntent3 = new Intent("network error");
    this.b.sendBroadcast(localIntent3);
  }

  public void a(PermissionCheck.b paramb)
  {
    if (paramb == null)
      return;
    if ((this.c != null) && (paramb.a != 0))
      Message.obtain(this.c, 2012, paramb.a, paramb.a, null).sendToTarget();
    if (paramb.a == 0)
    {
      c.F = paramb.e;
      c.a(paramb.b, paramb.c);
      return;
    }
    Log.e("baidumapsdk", "Authentication Error " + paramb.toString());
  }

  public void b()
  {
    if (this.e == 0)
    {
      if (this.b == null)
        throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
      com.baidu.platform.comjni.engine.a.a(2000, this.c);
      this.c = new b(this);
      c.c(this.b);
      c.d(this.b);
      com.baidu.vi.b.a(this.b);
      VMsg.init();
      AppEngine.InitEngine(this.b, c.c());
      c.e();
      c.h();
      AppEngine.StartSocketProc();
      PermissionCheck.init(this.b);
      PermissionCheck.setPermissionCheckResultListener(this);
      this.d = new com.baidu.platform.comapi.a();
      e();
      com.baidu.platform.comapi.c.b.a(this.b);
    }
    this.e = (1 + this.e);
  }

  public void c()
  {
    this.e = (-1 + this.e);
    if (this.e == 0)
    {
      com.baidu.platform.comjni.engine.a.b(2000, this.c);
      PermissionCheck.destory();
      f();
      VMsg.destroy();
      com.baidu.platform.comjni.engine.a.a();
      c.b();
      AppEngine.UnInitEngine();
    }
  }

  public Context d()
  {
    if (this.b == null)
      throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
    return this.b;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.a
 * JD-Core Version:    0.6.2
 */