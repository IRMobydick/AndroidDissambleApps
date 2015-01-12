package com.baidu.location;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import java.util.ArrayList;
import java.util.Iterator;

public class z
  implements ax, n
{
  public static final String gi = "android.com.baidu.location.TIMER.NOTIFY";
  private int ge = 0;
  private Context gf = null;
  private AlarmManager gg = null;
  private a gh = new a();
  private PendingIntent gj = null;
  private ArrayList gk = null;
  private BDLocation gl = null;
  private long gm = 0L;
  private b gn = null;
  private float go = 3.4028235E+38F;
  private boolean gp = false;
  private boolean gq = false;
  private long gr = 0L;
  private boolean gs = false;
  private LocationClient gt = null;

  public z(Context paramContext, LocationClient paramLocationClient)
  {
    this.gf = paramContext;
    this.gt = paramLocationClient;
    this.gt.registerNotifyLocationListener(this.gh);
    this.gg = ((AlarmManager)this.gf.getSystemService("alarm"));
    this.gn = new b();
    this.gs = false;
  }

  private void bd()
  {
    int i = 10000;
    if (!bf())
      return;
    int j;
    if (this.go > 5000.0F)
    {
      j = 600000;
      if (!this.gp)
        break label138;
      this.gp = false;
    }
    while (true)
    {
      if (this.ge != 0)
      {
        long l = this.gm + this.ge - System.currentTimeMillis();
        if (i <= l);
      }
      for (int k = 0; ; k = 1)
      {
        if (k == 0)
          break label136;
        this.ge = i;
        this.gm = System.currentTimeMillis();
        jdMethod_if(this.ge);
        return;
        if (this.go > 1000.0F)
        {
          j = 120000;
          break;
        }
        if (this.go > 500.0F)
        {
          j = 60000;
          break;
        }
        j = i;
        break;
      }
      label136: break;
      label138: i = j;
    }
  }

  private boolean bf()
  {
    if ((this.gk == null) || (this.gk.isEmpty()))
    {
      bool1 = false;
      return bool1;
    }
    Iterator localIterator = this.gk.iterator();
    boolean bool1 = false;
    label31: if (localIterator.hasNext())
      if (((BDNotifyListener)localIterator.next()).Notified >= 3)
        break label63;
    label63: for (boolean bool2 = true; ; bool2 = bool1)
    {
      bool1 = bool2;
      break label31;
      break;
    }
  }

  private void jdMethod_if(long paramLong)
  {
    if (this.gq)
      this.gg.cancel(this.gj);
    this.gj = PendingIntent.getBroadcast(this.gf, 0, new Intent("android.com.baidu.location.TIMER.NOTIFY"), 134217728);
    this.gg.set(0, paramLong + System.currentTimeMillis(), this.gj);
  }

  private void jdMethod_int(BDLocation paramBDLocation)
  {
    this.gq = false;
    if ((paramBDLocation.getLocType() != 61) && (paramBDLocation.getLocType() != 161) && (paramBDLocation.getLocType() != 65))
      jdMethod_if(120000L);
    while ((System.currentTimeMillis() - this.gr < 5000L) || (this.gk == null))
      return;
    this.gl = paramBDLocation;
    this.gr = System.currentTimeMillis();
    float[] arrayOfFloat = new float[1];
    Iterator localIterator = this.gk.iterator();
    float f1 = 3.4028235E+38F;
    if (localIterator.hasNext())
    {
      BDNotifyListener localBDNotifyListener = (BDNotifyListener)localIterator.next();
      Location.distanceBetween(paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), localBDNotifyListener.mLatitudeC, localBDNotifyListener.mLongitudeC, arrayOfFloat);
      float f2 = arrayOfFloat[0] - localBDNotifyListener.mRadius - paramBDLocation.getRadius();
      if (f2 > 0.0F)
        if (f2 >= f1)
          break label215;
      while (true)
      {
        f1 = f2;
        break;
        if (localBDNotifyListener.Notified < 3)
        {
          localBDNotifyListener.Notified = (1 + localBDNotifyListener.Notified);
          localBDNotifyListener.onNotify(paramBDLocation, arrayOfFloat[0]);
          if (localBDNotifyListener.Notified < 3)
            this.gp = true;
        }
        label215: f2 = f1;
      }
    }
    if (f1 < this.go)
      this.go = f1;
    this.ge = 0;
    bd();
  }

  public void be()
  {
    if (this.gq)
      this.gg.cancel(this.gj);
    this.gl = null;
    this.gr = 0L;
    if (this.gs)
      this.gf.unregisterReceiver(this.gn);
    this.gs = false;
  }

  public int jdMethod_do(BDNotifyListener paramBDNotifyListener)
  {
    if (this.gk == null)
      this.gk = new ArrayList();
    this.gk.add(paramBDNotifyListener);
    paramBDNotifyListener.isAdded = true;
    paramBDNotifyListener.mNotifyCache = this;
    if (!this.gs)
    {
      this.gf.registerReceiver(this.gn, new IntentFilter("android.com.baidu.location.TIMER.NOTIFY"));
      this.gs = true;
    }
    if (paramBDNotifyListener.mCoorType == null)
      return 1;
    if (!paramBDNotifyListener.mCoorType.equals("gcj02"))
    {
      double[] arrayOfDouble = Jni.jdMethod_if(paramBDNotifyListener.mLongitude, paramBDNotifyListener.mLatitude, paramBDNotifyListener.mCoorType + "2gcj");
      paramBDNotifyListener.mLongitudeC = arrayOfDouble[0];
      paramBDNotifyListener.mLatitudeC = arrayOfDouble[1];
    }
    if ((this.gl == null) || (System.currentTimeMillis() - this.gr > 30000L))
      this.gt.requestNotifyLocation();
    while (true)
    {
      bd();
      return 1;
      float[] arrayOfFloat = new float[1];
      Location.distanceBetween(this.gl.getLatitude(), this.gl.getLongitude(), paramBDNotifyListener.mLatitudeC, paramBDNotifyListener.mLongitudeC, arrayOfFloat);
      float f = arrayOfFloat[0] - paramBDNotifyListener.mRadius - this.gl.getRadius();
      if (f > 0.0F)
      {
        if (f < this.go)
          this.go = f;
      }
      else if (paramBDNotifyListener.Notified < 3)
      {
        paramBDNotifyListener.Notified = (1 + paramBDNotifyListener.Notified);
        paramBDNotifyListener.onNotify(this.gl, arrayOfFloat[0]);
        if (paramBDNotifyListener.Notified < 3)
          this.gp = true;
      }
    }
  }

  public int jdMethod_for(BDNotifyListener paramBDNotifyListener)
  {
    if (this.gk == null)
      return 0;
    if (this.gk.contains(paramBDNotifyListener))
      this.gk.remove(paramBDNotifyListener);
    if ((this.gk.size() == 0) && (this.gq))
      this.gg.cancel(this.gj);
    return 1;
  }

  public void jdMethod_if(BDNotifyListener paramBDNotifyListener)
  {
    if (paramBDNotifyListener.mCoorType == null)
      return;
    if (!paramBDNotifyListener.mCoorType.equals("gcj02"))
    {
      double[] arrayOfDouble = Jni.jdMethod_if(paramBDNotifyListener.mLongitude, paramBDNotifyListener.mLatitude, paramBDNotifyListener.mCoorType + "2gcj");
      paramBDNotifyListener.mLongitudeC = arrayOfDouble[0];
      paramBDNotifyListener.mLatitudeC = arrayOfDouble[1];
    }
    if ((this.gl == null) || (System.currentTimeMillis() - this.gr > 300000L))
      this.gt.requestNotifyLocation();
    while (true)
    {
      bd();
      return;
      float[] arrayOfFloat = new float[1];
      Location.distanceBetween(this.gl.getLatitude(), this.gl.getLongitude(), paramBDNotifyListener.mLatitudeC, paramBDNotifyListener.mLongitudeC, arrayOfFloat);
      float f = arrayOfFloat[0] - paramBDNotifyListener.mRadius - this.gl.getRadius();
      if (f > 0.0F)
      {
        if (f < this.go)
          this.go = f;
      }
      else if (paramBDNotifyListener.Notified < 3)
      {
        paramBDNotifyListener.Notified = (1 + paramBDNotifyListener.Notified);
        paramBDNotifyListener.onNotify(this.gl, arrayOfFloat[0]);
        if (paramBDNotifyListener.Notified < 3)
          this.gp = true;
      }
    }
  }

  public class a
    implements BDLocationListener
  {
    public a()
    {
    }

    public void a(BDLocation paramBDLocation)
    {
    }

    public void onReceiveLocation(BDLocation paramBDLocation)
    {
      z.jdMethod_if(z.this, paramBDLocation);
    }
  }

  public class b extends BroadcastReceiver
  {
    public b()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((z.jdMethod_do(z.this) == null) || (z.jdMethod_do(z.this).isEmpty()))
        return;
      z.jdMethod_if(z.this).requestNotifyLocation();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.z
 * JD-Core Version:    0.6.2
 */