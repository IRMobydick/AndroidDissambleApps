package com.baidu.location;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class LocationClient
  implements n, ax
{
  private static final int j1 = 11;
  private static final int j4 = 4;
  private static final int jB = 3;
  private static final int jC = 8;
  private static final int jF = 9;
  private static final int jH = 7;
  private static final int jO = 5;
  private static final int jP = 12;
  private static final int jR = 6;
  private static final int jS = 2;
  private static final int jo = 10;
  private static final String jq = "baidu_location_Client";
  private static final int jt = 1;
  private static final int jx = 1000;
  private BDLocation j0 = null;
  private String j2 = null;
  private String j3 = null;
  private ArrayList j5 = null;
  private boolean jA = false;
  private BDLocationListener jD = null;
  private boolean jE = false;
  private boolean jG = false;
  private boolean jI;
  private final Messenger jJ = new Messenger(this.jp);
  private Context jK = null;
  private Messenger jL = null;
  private long jM = 0L;
  private LocationClientOption jN = new LocationClientOption();
  private Boolean jQ = Boolean.valueOf(true);
  private boolean jT = false;
  private long jU = 0L;
  private long jV = 0L;
  private ServiceConnection jW = new LocationClient.1(this);
  private String jX;
  private boolean jY = false;
  private boolean jZ = false;
  private boolean jn = false;
  private a jp = new a(null);
  private final Object jr = new Object();
  private BDErrorReport js = null;
  private b ju = null;
  private Boolean jv = Boolean.valueOf(false);
  private z jw = null;
  private long jy = 0L;
  private Boolean jz = Boolean.valueOf(false);

  public LocationClient(Context paramContext)
  {
    this.jK = paramContext;
    this.jN = new LocationClientOption();
    this.jw = new z(this.jK, this);
  }

  public LocationClient(Context paramContext, LocationClientOption paramLocationClientOption)
  {
    this.jK = paramContext;
    this.jN = paramLocationClientOption;
    this.jw = new z(this.jK, this);
  }

  private void cA()
  {
    if (this.jL == null)
      return;
    Message localMessage = Message.obtain(null, 22);
    try
    {
      localMessage.replyTo = this.jJ;
      this.jL.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void cB()
  {
    Message localMessage = Message.obtain(null, 28);
    try
    {
      localMessage.replyTo = this.jJ;
      this.jL.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void jdMethod_char(int paramInt)
  {
    if ((this.jE == true) || ((this.jN.jdField_goto == true) && (this.j0.getLocType() == 61)) || (this.j0.getLocType() == 66) || (this.j0.getLocType() == 67) || (this.jA))
    {
      Iterator localIterator = this.j5.iterator();
      while (localIterator.hasNext())
        ((BDLocationListener)localIterator.next()).onReceiveLocation(this.j0);
      if ((this.j0.getLocType() != 66) && (this.j0.getLocType() != 67));
    }
    else
    {
      return;
    }
    this.jE = false;
    this.jV = System.currentTimeMillis();
  }

  private Bundle cw()
  {
    if (this.jN == null)
      return null;
    Bundle localBundle = new Bundle();
    localBundle.putInt("num", this.jN.jdField_long);
    localBundle.putFloat("distance", this.jN.c);
    localBundle.putBoolean("extraInfo", this.jN.e);
    return localBundle;
  }

  private Bundle cx()
  {
    if (this.jN == null)
      return null;
    Bundle localBundle = new Bundle();
    localBundle.putString("packName", this.j3);
    localBundle.putString("prodName", this.jN.jdField_if);
    localBundle.putString("coorType", this.jN.jdField_do);
    localBundle.putString("addrType", this.jN.jdField_else);
    localBundle.putBoolean("openGPS", this.jN.jdField_for);
    localBundle.putBoolean("location_change_notify", this.jN.jdField_goto);
    localBundle.putInt("scanSpan", this.jN.jdField_int);
    localBundle.putInt("timeOut", this.jN.d);
    localBundle.putInt("priority", this.jN.h);
    localBundle.putBoolean("map", this.jz.booleanValue());
    localBundle.putBoolean("import", this.jv.booleanValue());
    localBundle.putBoolean("needDirect", this.jN.g);
    return localBundle;
  }

  private void cy()
  {
    if (this.jT == true)
      return;
    c.jdMethod_char();
    this.j3 = this.jK.getPackageName();
    this.j2 = (this.j3 + "_bdls_v2.9");
    getAccessKey();
    Intent localIntent = new Intent(this.jK, f.class);
    try
    {
      localIntent.putExtra("debug_dev", this.jI);
      label82: if (this.jN == null)
        this.jN = new LocationClientOption();
      if (this.jN.getLocationMode() == LocationClientOption.LocationMode.Device_Sensors)
        this.jN.setIsNeedAddress(false);
      localIntent.putExtra("cache_exception", this.jN.b);
      localIntent.putExtra("kill_process", this.jN.jdField_char);
      try
      {
        this.jK.bindService(localIntent, this.jW, 1);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        this.jT = false;
        return;
      }
    }
    catch (Exception localException1)
    {
      break label82;
    }
  }

  // ERROR //
  private void cz()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 101	com/baidu/location/LocationClient:jT	Z
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: getfield 105	com/baidu/location/LocationClient:jL	Landroid/os/Messenger;
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aconst_null
    //   16: bipush 12
    //   18: invokestatic 194	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   21: astore_1
    //   22: aload_1
    //   23: aload_0
    //   24: getfield 119	com/baidu/location/LocationClient:jJ	Landroid/os/Messenger;
    //   27: putfield 197	android/os/Message:replyTo	Landroid/os/Messenger;
    //   30: aload_0
    //   31: getfield 105	com/baidu/location/LocationClient:jL	Landroid/os/Messenger;
    //   34: aload_1
    //   35: invokevirtual 200	android/os/Messenger:send	(Landroid/os/Message;)V
    //   38: aload_0
    //   39: getfield 103	com/baidu/location/LocationClient:jK	Landroid/content/Context;
    //   42: aload_0
    //   43: getfield 168	com/baidu/location/LocationClient:jW	Landroid/content/ServiceConnection;
    //   46: invokevirtual 412	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   49: aload_0
    //   50: getfield 135	com/baidu/location/LocationClient:jr	Ljava/lang/Object;
    //   53: astore 4
    //   55: aload 4
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 129	com/baidu/location/LocationClient:jG	Z
    //   62: iconst_1
    //   63: if_icmpne +19 -> 82
    //   66: aload_0
    //   67: getfield 112	com/baidu/location/LocationClient:jp	Lcom/baidu/location/LocationClient$a;
    //   70: aload_0
    //   71: getfield 131	com/baidu/location/LocationClient:ju	Lcom/baidu/location/LocationClient$b;
    //   74: invokevirtual 416	com/baidu/location/LocationClient$a:removeCallbacks	(Ljava/lang/Runnable;)V
    //   77: aload_0
    //   78: iconst_0
    //   79: putfield 129	com/baidu/location/LocationClient:jG	Z
    //   82: aload 4
    //   84: monitorexit
    //   85: aload_0
    //   86: getfield 141	com/baidu/location/LocationClient:jw	Lcom/baidu/location/z;
    //   89: invokevirtual 419	com/baidu/location/z:be	()V
    //   92: aload_0
    //   93: aconst_null
    //   94: putfield 105	com/baidu/location/LocationClient:jL	Landroid/os/Messenger;
    //   97: invokestatic 421	com/baidu/location/c:case	()V
    //   100: aload_0
    //   101: iconst_0
    //   102: putfield 149	com/baidu/location/LocationClient:jA	Z
    //   105: aload_0
    //   106: iconst_0
    //   107: putfield 101	com/baidu/location/LocationClient:jT	Z
    //   110: return
    //   111: astore_2
    //   112: aload_2
    //   113: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   116: goto -78 -> 38
    //   119: astore 6
    //   121: aload 4
    //   123: monitorexit
    //   124: aload 6
    //   126: athrow
    //   127: astore 5
    //   129: goto -47 -> 82
    //   132: astore_3
    //   133: goto -84 -> 49
    //
    // Exception table:
    //   from	to	target	type
    //   30	38	111	java/lang/Exception
    //   58	82	119	finally
    //   82	85	119	finally
    //   121	124	119	finally
    //   58	82	127	java/lang/Exception
    //   38	49	132	java/lang/Exception
  }

  private boolean jdMethod_else(int paramInt)
  {
    if ((this.jL == null) || (!this.jT))
      return false;
    try
    {
      Message localMessage = Message.obtain(null, paramInt);
      this.jL.send(localMessage);
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private void jdMethod_goto(boolean paramBoolean)
  {
    if (this.js != null)
      this.js.onReportResult(paramBoolean);
    this.js = null;
    this.jy = 0L;
  }

  private void jdMethod_if(Message paramMessage, int paramInt)
  {
    Bundle localBundle = paramMessage.getData();
    localBundle.setClassLoader(BDLocation.class.getClassLoader());
    this.j0 = ((BDLocation)localBundle.getParcelable("locStr"));
    if (this.j0.getLocType() == 61)
      this.jM = System.currentTimeMillis();
    jdMethod_char(paramInt);
  }

  private void l(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null))
      return;
    BDNotifyListener localBDNotifyListener = (BDNotifyListener)paramMessage.obj;
    this.jw.jdMethod_do(localBDNotifyListener);
  }

  private void m(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null));
    BDLocationListener localBDLocationListener;
    do
    {
      return;
      localBDLocationListener = (BDLocationListener)paramMessage.obj;
    }
    while ((this.j5 == null) || (!this.j5.contains(localBDLocationListener)));
    this.j5.remove(localBDLocationListener);
  }

  private void n(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null));
    while (true)
    {
      return;
      LocationClientOption localLocationClientOption = (LocationClientOption)paramMessage.obj;
      if (this.jN.equals(localLocationClientOption))
        continue;
      if (this.jN.jdField_int != localLocationClientOption.jdField_int);
      try
      {
        synchronized (this.jr)
        {
          if (this.jG == true)
          {
            this.jp.removeCallbacks(this.ju);
            this.jG = false;
          }
          if ((localLocationClientOption.jdField_int >= 1000) && (!this.jG))
          {
            if (this.ju == null)
              this.ju = new b(null);
            this.jp.postDelayed(this.ju, localLocationClientOption.jdField_int);
            this.jG = true;
          }
          label140: this.jN = new LocationClientOption(localLocationClientOption);
          if (this.jL == null)
            continue;
          try
          {
            Message localMessage = Message.obtain(null, 15);
            localMessage.replyTo = this.jJ;
            localMessage.setData(cx());
            this.jL.send(localMessage);
            return;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        break label140;
      }
    }
  }

  private void o(Message paramMessage)
  {
    if (this.jL == null)
      return;
    Message localMessage;
    if (((System.currentTimeMillis() - this.jM > 3000L) || (!this.jN.jdField_goto)) && ((!this.jA) || (System.currentTimeMillis() - this.jV > 20000L)))
      localMessage = Message.obtain(null, 22);
    try
    {
      localMessage.replyTo = this.jJ;
      localMessage.arg1 = paramMessage.arg1;
      this.jL.send(localMessage);
      this.jU = System.currentTimeMillis();
      this.jE = true;
      synchronized (this.jr)
      {
        if ((this.jN != null) && (this.jN.jdField_int >= 1000) && (!this.jG))
        {
          if (this.ju == null)
            this.ju = new b(null);
          this.jp.postDelayed(this.ju, this.jN.jdField_int);
          this.jG = true;
        }
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private void p(Message paramMessage)
  {
    Bundle localBundle = paramMessage.getData();
    localBundle.setClassLoader(BDLocation.class.getClassLoader());
    BDLocation localBDLocation = (BDLocation)localBundle.getParcelable("locStr");
    if ((this.jD == null) || ((this.jN != null) && (this.jN.a()) && (localBDLocation.getLocType() == 65)))
      return;
    this.jD.onReceiveLocation(localBDLocation);
  }

  private void q(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null))
      return;
    BDNotifyListener localBDNotifyListener = (BDNotifyListener)paramMessage.obj;
    this.jw.jdMethod_for(localBDNotifyListener);
  }

  private void r(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null))
      return;
    BDLocationListener localBDLocationListener = (BDLocationListener)paramMessage.obj;
    if (this.j5 == null)
      this.j5 = new ArrayList();
    this.j5.add(localBDLocationListener);
  }

  private void s(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null))
      return;
    this.jD = ((BDLocationListener)paramMessage.obj);
  }

  public void cancleError()
  {
    jdMethod_else(202);
  }

  public String getAccessKey()
  {
    this.jX = v.a(this.jK);
    if (TextUtils.isEmpty(this.jX))
      throw new IllegalStateException("please setting key from Manifest.xml");
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.jX;
    arrayOfObject[1] = v.jdMethod_if(this.jK);
    return String.format("KEY=%s;SHA1=%s", arrayOfObject);
  }

  public BDLocation getLastKnownLocation()
  {
    return this.j0;
  }

  public LocationClientOption getLocOption()
  {
    return this.jN;
  }

  public String getVersion()
  {
    return "4.2";
  }

  public boolean isStarted()
  {
    return this.jT;
  }

  public boolean notifyError()
  {
    return jdMethod_else(201);
  }

  public void registerLocationListener(BDLocationListener paramBDLocationListener)
  {
    if (paramBDLocationListener == null)
      throw new IllegalStateException("please set a non-null listener");
    Message localMessage = this.jp.obtainMessage(5);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }

  public void registerNotify(BDNotifyListener paramBDNotifyListener)
  {
    Message localMessage = this.jp.obtainMessage(9);
    localMessage.obj = paramBDNotifyListener;
    localMessage.sendToTarget();
  }

  public void registerNotifyLocationListener(BDLocationListener paramBDLocationListener)
  {
    Message localMessage = this.jp.obtainMessage(8);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }

  public void removeNotifyEvent(BDNotifyListener paramBDNotifyListener)
  {
    Message localMessage = this.jp.obtainMessage(10);
    localMessage.obj = paramBDNotifyListener;
    localMessage.sendToTarget();
  }

  public int reportErrorWithInfo(BDErrorReport paramBDErrorReport)
  {
    if ((this.jL == null) || (!this.jT))
      return 1;
    if (paramBDErrorReport == null)
      return 2;
    if ((System.currentTimeMillis() - this.jy < 50000L) && (this.js != null))
      return 4;
    Bundle localBundle = paramBDErrorReport.getErrorInfo();
    if (localBundle == null)
      return 3;
    try
    {
      Message localMessage = Message.obtain(null, 203);
      localMessage.replyTo = this.jJ;
      localMessage.setData(localBundle);
      this.jL.send(localMessage);
      this.js = paramBDErrorReport;
      this.jy = System.currentTimeMillis();
      return 0;
    }
    catch (Exception localException)
    {
    }
    return 1;
  }

  public int requestLocation()
  {
    if ((this.jL == null) || (this.jJ == null))
      return 1;
    if ((this.j5 == null) || (this.j5.size() < 1))
      return 2;
    if (System.currentTimeMillis() - this.jU < 1000L)
      return 6;
    Message localMessage = this.jp.obtainMessage(4);
    localMessage.arg1 = 1;
    localMessage.sendToTarget();
    return 0;
  }

  public void requestNotifyLocation()
  {
    this.jp.obtainMessage(11).sendToTarget();
  }

  public int requestOfflineLocation()
  {
    if ((this.jL == null) || (this.jJ == null))
      return 1;
    if ((this.j5 == null) || (this.j5.size() < 1))
      return 2;
    this.jp.obtainMessage(12).sendToTarget();
    return 0;
  }

  public void setDebug(boolean paramBoolean)
  {
    this.jI = paramBoolean;
  }

  public void setForBaiduMap(boolean paramBoolean)
  {
    this.jz = Boolean.valueOf(paramBoolean);
  }

  public void setLocOption(LocationClientOption paramLocationClientOption)
  {
    if (paramLocationClientOption == null)
      paramLocationClientOption = new LocationClientOption();
    while (true)
    {
      Message localMessage = this.jp.obtainMessage(3);
      localMessage.obj = paramLocationClientOption;
      localMessage.sendToTarget();
      return;
      switch (paramLocationClientOption.h)
      {
      default:
        break;
      case 1:
        if ((paramLocationClientOption.jdField_int != 0) && (paramLocationClientOption.jdField_int < 1000))
        {
          Object[] arrayOfObject3 = new Object[1];
          arrayOfObject3[0] = Integer.valueOf(paramLocationClientOption.jdField_int);
          Log.w("baidu_location_service", String.format("scanSpan time %d less than 1 second, location services may not star", arrayOfObject3));
        }
        break;
      case 3:
        if ((paramLocationClientOption.jdField_int != 0) && (paramLocationClientOption.jdField_int < 1000))
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Integer.valueOf(paramLocationClientOption.jdField_int);
          Log.w("baidu_location_service", String.format("scanSpan time %d less than 1 second, location services may not star", arrayOfObject2));
        }
        else if (paramLocationClientOption.jdField_int == 0)
        {
          paramLocationClientOption.jdField_int = 1000;
        }
        break;
      case 2:
        if ((paramLocationClientOption.jdField_int > 1000) && (paramLocationClientOption.jdField_int < 3000))
        {
          paramLocationClientOption.jdField_int = 3000;
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = Integer.valueOf(paramLocationClientOption.jdField_int);
          Log.w("baidu_location_service", String.format("scanSpan time %d less than 3 second, location services may not star", arrayOfObject1));
        }
        break;
      }
    }
  }

  public void start()
  {
    this.jp.obtainMessage(1).sendToTarget();
  }

  public void stop()
  {
    cz();
  }

  public void unRegisterLocationListener(BDLocationListener paramBDLocationListener)
  {
    if (paramBDLocationListener == null)
      throw new IllegalStateException("please set a non-null listener");
    Message localMessage = this.jp.obtainMessage(6);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }

  public boolean updateLocation(Location paramLocation)
  {
    if ((this.jL == null) || (this.jJ == null) || (paramLocation == null))
      return false;
    try
    {
      Message localMessage = Message.obtain(null, 57);
      localMessage.obj = paramLocation;
      this.jL.send(localMessage);
      return true;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private class a extends Handler
  {
    private a()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        super.handleMessage(paramMessage);
      case 7:
      case 3:
      case 8:
      case 5:
      case 6:
      case 9:
      case 10:
      case 1:
      case 2:
      case 11:
      case 4:
      case 12:
      case 54:
      case 55:
        do
        {
          do
          {
            return;
            LocationClient.jdMethod_for(LocationClient.this, paramMessage);
            return;
            LocationClient.jdMethod_do(LocationClient.this, paramMessage);
            return;
            LocationClient.jdMethod_if(LocationClient.this, paramMessage);
            return;
            LocationClient.jdMethod_case(LocationClient.this, paramMessage);
            return;
            LocationClient.jdMethod_byte(LocationClient.this, paramMessage);
            return;
            LocationClient.jdMethod_new(LocationClient.this, paramMessage);
            return;
            LocationClient.jdMethod_do(LocationClient.this);
            return;
            LocationClient.jdMethod_try(LocationClient.this);
            return;
            LocationClient.jdMethod_case(LocationClient.this);
            return;
            LocationClient.jdMethod_int(LocationClient.this, paramMessage);
            return;
            LocationClient.jdMethod_int(LocationClient.this);
            return;
          }
          while (!LocationClient.jdMethod_else(LocationClient.this).jdField_goto);
          LocationClient.jdMethod_for(LocationClient.this, true);
          return;
        }
        while (!LocationClient.jdMethod_else(LocationClient.this).jdField_goto);
        LocationClient.jdMethod_for(LocationClient.this, false);
        return;
      case 21:
        LocationClient.jdMethod_if(LocationClient.this, paramMessage, 21);
        return;
      case 26:
        LocationClient.jdMethod_if(LocationClient.this, paramMessage, 26);
        return;
      case 27:
        LocationClient.jdMethod_try(LocationClient.this, paramMessage);
        return;
      case 205:
        LocationClient.jdMethod_do(LocationClient.this, true);
        return;
      case 204:
      }
      LocationClient.jdMethod_do(LocationClient.this, false);
    }
  }

  private class b
    implements Runnable
  {
    private b()
    {
    }

    public void run()
    {
      synchronized (LocationClient.jdMethod_for(LocationClient.this))
      {
        LocationClient.jdMethod_int(LocationClient.this, false);
        if ((LocationClient.jdMethod_char(LocationClient.this) == null) || (LocationClient.jdMethod_new(LocationClient.this) == null))
          return;
        if ((LocationClient.jdMethod_goto(LocationClient.this) == null) || (LocationClient.jdMethod_goto(LocationClient.this).size() < 1))
          return;
      }
      LocationClient.jdMethod_byte(LocationClient.this).obtainMessage(4).sendToTarget();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.LocationClient
 * JD-Core Version:    0.6.2
 */