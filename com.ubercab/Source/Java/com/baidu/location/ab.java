package com.baidu.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;

public class ab extends Service
  implements ax, n, LLSInterface
{
  private static long gC = 0L;
  static a gD = null;
  public static boolean gE;
  public static boolean gv;
  public static long gw;
  private static Context gy = null;
  private HandlerThread gA;
  private Looper gB;
  private boolean gx = false;
  Messenger gz = null;

  static
  {
    gv = false;
  }

  public static long bi()
  {
    return gC;
  }

  public static Handler bj()
  {
    return gD;
  }

  private void bk()
  {
    t.an().as();
    ah.ay().ax();
    ae.bp().br();
    q.w();
    k.p().n();
    if (!this.gx)
      Process.killProcess(Process.myPid());
  }

  private void bl()
  {
    gv = true;
    t.an().am();
    ar.bW().b2();
    az.cn();
    x.a4().aU();
    r.H().K();
    ah.ay().aC();
    ay.cd().ci();
    y.a7().a8();
    aw.jdMethod_do().jdMethod_for();
    aa.bg().bh();
  }

  private void d(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.obj != null));
  }

  private void e(Message paramMessage)
  {
    k.p().jdMethod_do(paramMessage);
  }

  private void h(Message paramMessage)
  {
    k.p().jdMethod_new(paramMessage);
    y.a7().a9();
    d.X().Z();
  }

  private void i(Message paramMessage)
  {
    k.p().jdMethod_int(paramMessage);
  }

  public double getVersion()
  {
    return 4.199999809265137D;
  }

  public IBinder onBind(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    boolean bool = false;
    if (localBundle != null)
    {
      bool = localBundle.getBoolean("cache_exception");
      this.gx = localBundle.getBoolean("kill_process");
      gE = localBundle.getBoolean("debug_dev");
      gw = localBundle.getLong("interval");
    }
    if (!bool)
      Thread.setDefaultUncaughtExceptionHandler(aa.bg());
    return this.gz.getBinder();
  }

  public void onCreate(Context paramContext)
  {
    gC = System.currentTimeMillis();
    gy = paramContext;
    this.gA = ao.a();
    this.gB = this.gA.getLooper();
    gD = new a(this.gB);
    this.gz = new Messenger(gD);
    gD.sendEmptyMessage(0);
    Log.d("baidu_location_service", "baidu location service start1 ..." + Process.myPid());
  }

  public void onDestroy()
  {
    gv = false;
    ar.bW().bT();
    h.jdMethod_for().jdMethod_do();
    r.H().G();
    x.a4().aW();
    aw.jdMethod_do().jdMethod_if();
    gD.sendEmptyMessage(1);
    Log.d("baidu_location_service", "baidu location service stop ...");
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 1;
  }

  public boolean onUnBind(Intent paramIntent)
  {
    return false;
  }

  public class a extends Handler
  {
    public a(Looper arg2)
    {
      super();
    }

    public void handleMessage(Message paramMessage)
    {
      if (ab.gv == true)
        switch (paramMessage.what)
        {
        default:
        case 11:
        case 12:
        case 15:
        case 57:
        case 22:
        case 28:
        case 25:
        case 41:
        case 110:
        case 111:
        case 201:
        case 202:
        case 203:
        case 206:
        case 207:
        }
      while (true)
      {
        if (paramMessage.what == 0)
          ab.jdMethod_do(ab.this);
        if (paramMessage.what == 1)
          ab.jdMethod_if(ab.this);
        super.handleMessage(paramMessage);
        return;
        ab.jdMethod_for(ab.this, paramMessage);
        continue;
        ab.jdMethod_if(ab.this, paramMessage);
        continue;
        ab.jdMethod_do(ab.this, paramMessage);
        continue;
        ab.jdMethod_int(ab.this, paramMessage);
        continue;
        ah.ay().jdMethod_case(paramMessage);
        continue;
        ay.cd().j(paramMessage);
        continue;
        u.aG().jdMethod_long(paramMessage);
        continue;
        ah.ay().aw();
        continue;
        ae.bp().bt();
        continue;
        ae.bp().br();
        continue;
        ak.a().jdMethod_do();
        continue;
        ak.a().jdMethod_if();
        continue;
        ak.a().a(paramMessage);
        continue;
        a0.cq().jdMethod_if(f.getServiceContext(), paramMessage);
        continue;
        au.jdMethod_int(f.getServiceContext());
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.ab
 * JD-Core Version:    0.6.2
 */