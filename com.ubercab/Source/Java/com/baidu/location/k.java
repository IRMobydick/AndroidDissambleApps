package com.baidu.location;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

class k
  implements ax, n
{
  private static k bv = null;
  private boolean bt = false;
  private ArrayList bu = null;
  private boolean bw = false;

  private a jdMethod_if(Messenger paramMessenger)
  {
    if (this.bu == null)
      return null;
    Iterator localIterator = this.bu.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.jdField_for.equals(paramMessenger))
        return locala;
    }
    return null;
  }

  private void jdMethod_if(a parama)
  {
    if (parama == null)
      return;
    if (jdMethod_if(parama.jdField_for) != null)
    {
      a.a(parama, 14);
      return;
    }
    this.bu.add(parama);
    a.a(parama, 13);
  }

  private void j()
  {
    l();
    m();
  }

  private void l()
  {
    Iterator localIterator = this.bu.iterator();
    boolean bool1 = false;
    boolean bool2 = false;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.jdField_do.jdField_for)
        bool2 = true;
      if (!locala.jdField_do.jdField_goto)
        break label93;
    }
    label93: for (boolean bool3 = true; ; bool3 = bool1)
    {
      bool1 = bool3;
      break;
      c.a3 = bool1;
      if (this.bw != bool2)
      {
        this.bw = bool2;
        x.a4().jdMethod_int(this.bw);
      }
      return;
    }
  }

  public static k p()
  {
    if (bv == null)
      bv = new k();
    return bv;
  }

  public void jdMethod_byte(String paramString)
  {
    BDLocation localBDLocation = new BDLocation(paramString);
    ak.a().jdField_new = paramString;
    Iterator localIterator = this.bu.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).jdMethod_if(localBDLocation);
  }

  public void jdMethod_do(Message paramMessage)
  {
    a locala = jdMethod_if(paramMessage.replyTo);
    if (locala != null)
      this.bu.remove(locala);
    az.cn().cp();
    af.bw().bv();
    h.jdMethod_for().jdMethod_do();
    j();
  }

  public void jdMethod_do(BDLocation paramBDLocation)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.bu.iterator();
    while (localIterator1.hasNext())
    {
      a locala2 = (a)localIterator1.next();
      locala2.a(paramBDLocation);
      if (locala2.jdField_if > 4)
        localArrayList.add(locala2);
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        a locala1 = (a)localIterator2.next();
        this.bu.remove(locala1);
      }
    }
  }

  public int jdMethod_for(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.replyTo == null));
    a locala;
    do
    {
      return 1;
      locala = jdMethod_if(paramMessage.replyTo);
    }
    while ((locala == null) || (locala.jdField_do == null));
    return locala.jdField_do.h;
  }

  public void i()
  {
    Iterator localIterator = this.bu.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).a();
  }

  public String jdMethod_if(Message paramMessage)
  {
    String str = null;
    if (paramMessage != null)
    {
      Messenger localMessenger = paramMessage.replyTo;
      str = null;
      if (localMessenger != null)
        break label19;
    }
    label19: a locala;
    do
    {
      do
      {
        return str;
        locala = jdMethod_if(paramMessage.replyTo);
        str = null;
      }
      while (locala == null);
      locala.jdField_do.jdField_long = paramMessage.getData().getInt("num", locala.jdField_do.jdField_long);
      locala.jdField_do.c = paramMessage.getData().getFloat("distance", locala.jdField_do.c);
      locala.jdField_do.e = paramMessage.getData().getBoolean("extraInfo", locala.jdField_do.e);
      locala.jdField_do.jdField_new = true;
      Locale localLocale = Locale.CHINA;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Float.valueOf(locala.jdField_do.c);
      arrayOfObject[1] = Integer.valueOf(locala.jdField_do.jdField_long);
      str = String.format(localLocale, "&poi=%.1f|%d", arrayOfObject);
    }
    while (!locala.jdField_do.e);
    return str + "|1";
  }

  public void jdMethod_if(BDLocation paramBDLocation, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.bu.iterator();
    while (localIterator1.hasNext())
    {
      a locala2 = (a)localIterator1.next();
      locala2.a(paramBDLocation, paramInt);
      if (locala2.jdField_if > 4)
        localArrayList.add(locala2);
    }
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        a locala1 = (a)localIterator2.next();
        this.bu.remove(locala1);
      }
    }
  }

  public void jdMethod_if(BDLocation paramBDLocation, Message paramMessage)
  {
    if ((paramBDLocation == null) || (paramMessage == null));
    a locala;
    do
    {
      do
      {
        return;
        locala = jdMethod_if(paramMessage.replyTo);
      }
      while (locala == null);
      locala.a(paramBDLocation);
    }
    while (locala.jdField_if <= 4);
    this.bu.remove(locala);
  }

  public boolean jdMethod_int(Message paramMessage)
  {
    a locala = jdMethod_if(paramMessage.replyTo);
    if (locala == null)
      return false;
    int i = locala.jdField_do.jdField_int;
    locala.jdField_do.jdField_int = paramMessage.getData().getInt("scanSpan", locala.jdField_do.jdField_int);
    boolean bool;
    String str1;
    label210: String str2;
    LocationClientOption localLocationClientOption2;
    if (locala.jdField_do.jdField_int < 1000)
    {
      h.jdMethod_for().a();
      az.cn().cp();
      af.bw().bv();
      x.a4().a0();
      int j = locala.jdField_do.jdField_int;
      bool = false;
      if (j > 999)
      {
        bool = false;
        if (i < 1000)
        {
          bool = true;
          if (locala.jdField_do.g)
          {
            af.bw().jdMethod_try(locala.jdField_do.g);
            af.bw().bx();
          }
          az.cn().cm();
        }
      }
      locala.jdField_do.jdField_for = paramMessage.getData().getBoolean("openGPS", locala.jdField_do.jdField_for);
      str1 = paramMessage.getData().getString("coorType");
      LocationClientOption localLocationClientOption1 = locala.jdField_do;
      if ((str1 == null) || (str1.equals("")))
        break label378;
      localLocationClientOption1.jdField_do = str1;
      str2 = paramMessage.getData().getString("addrType");
      localLocationClientOption2 = locala.jdField_do;
      if ((str2 == null) || (str2.equals("")))
        break label390;
    }
    while (true)
    {
      localLocationClientOption2.jdField_else = str2;
      if (!c.aw.equals(locala.jdField_do.jdField_else))
        ah.ay().az();
      c.aw = locala.jdField_do.jdField_else;
      locala.jdField_do.d = paramMessage.getData().getInt("timeOut", locala.jdField_do.d);
      locala.jdField_do.jdField_goto = paramMessage.getData().getBoolean("location_change_notify", locala.jdField_do.jdField_goto);
      locala.jdField_do.h = paramMessage.getData().getInt("priority", locala.jdField_do.h);
      j();
      return bool;
      h.jdMethod_for().jdMethod_if();
      break;
      label378: str1 = locala.jdField_do.jdField_do;
      break label210;
      label390: str2 = locala.jdField_do.jdField_else;
    }
  }

  public boolean k()
  {
    return this.bw;
  }

  public void m()
  {
    Iterator localIterator = this.bu.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).jdMethod_if();
  }

  public void n()
  {
    this.bu.clear();
    j();
  }

  public void jdMethod_new(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.replyTo == null))
      return;
    jdMethod_if(new a(paramMessage));
    j();
  }

  public String o()
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    if (this.bu.isEmpty())
      return "&prod=" + az.iM + ":" + az.iH;
    a locala = (a)this.bu.get(0);
    if (locala.jdField_do.jdField_if != null)
      localStringBuffer.append(locala.jdField_do.jdField_if);
    if (locala.jdField_int != null)
    {
      localStringBuffer.append(":");
      localStringBuffer.append(locala.jdField_int);
      localStringBuffer.append("|");
    }
    String str = localStringBuffer.toString();
    if ((str != null) && (!str.equals("")))
      return "&prod=" + str;
    return null;
  }

  private class a
  {
    public LocationClientOption jdField_do = new LocationClientOption();
    public Messenger jdField_for = null;
    public int jdField_if = 0;
    public String jdField_int = null;

    public a(Message arg2)
    {
      Object localObject;
      this.jdField_for = localObject.replyTo;
      this.jdField_int = localObject.getData().getString("packName");
      this.jdField_do.jdField_if = localObject.getData().getString("prodName");
      az.cn().jdMethod_try(this.jdField_do.jdField_if, this.jdField_int);
      this.jdField_do.jdField_do = localObject.getData().getString("coorType");
      this.jdField_do.jdField_else = localObject.getData().getString("addrType");
      c.aw = this.jdField_do.jdField_else;
      this.jdField_do.jdField_for = localObject.getData().getBoolean("openGPS");
      this.jdField_do.jdField_int = localObject.getData().getInt("scanSpan");
      this.jdField_do.d = localObject.getData().getInt("timeOut");
      this.jdField_do.h = localObject.getData().getInt("priority");
      this.jdField_do.jdField_goto = localObject.getData().getBoolean("location_change_notify");
      this.jdField_do.g = localObject.getData().getBoolean("needDirect");
      if (this.jdField_do.g)
      {
        af.bw().jdMethod_try(this.jdField_do.g);
        af.bw().bx();
      }
      if (this.jdField_do.jdField_int > 1000)
      {
        az.cn().cm();
        h.jdField_for().jdField_int();
      }
      if (this.jdField_do.getLocationMode() == LocationClientOption.LocationMode.Hight_Accuracy)
      {
        if (!ar.bW().bZ())
          Log.w("baidu_location_service", "use hight accuracy mode does not use open wifi");
        if (!x.a4().a1())
          Log.w("baidu_location_service", "use hight accuracy mode does not use open gps");
      }
    }

    private void a(int paramInt)
    {
      Message localMessage = Message.obtain(null, paramInt);
      try
      {
        if (this.jdField_for != null)
          this.jdField_for.send(localMessage);
        this.jdField_if = 0;
        return;
      }
      catch (Exception localException)
      {
        while (!(localException instanceof DeadObjectException));
        this.jdField_if = (1 + this.jdField_if);
      }
    }

    private void a(int paramInt, String paramString, BDLocation paramBDLocation)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable(paramString, paramBDLocation);
      Message localMessage = Message.obtain(null, paramInt);
      localMessage.setData(localBundle);
      try
      {
        if (this.jdField_for != null)
          this.jdField_for.send(localMessage);
        this.jdField_if = 0;
        return;
      }
      catch (Exception localException)
      {
        while (!(localException instanceof DeadObjectException));
        this.jdField_if = (1 + this.jdField_if);
      }
    }

    public void a()
    {
      a(23);
    }

    public void a(BDLocation paramBDLocation)
    {
      a(paramBDLocation, 21);
    }

    public void a(BDLocation paramBDLocation, int paramInt)
    {
      BDLocation localBDLocation = new BDLocation(paramBDLocation);
      localBDLocation.internalSet(0, az.cn().iP);
      if (localBDLocation == null)
        return;
      if (paramInt == 21)
        a(27, "locStr", localBDLocation);
      if ((this.jdField_do.jdField_do != null) && (!this.jdField_do.jdField_do.equals("gcj02")))
      {
        double d1 = localBDLocation.getLongitude();
        double d2 = localBDLocation.getLatitude();
        if ((d1 != 4.9E-324D) && (d2 != 4.9E-324D))
        {
          double[] arrayOfDouble = Jni.jdField_if(d1, d2, this.jdField_do.jdField_do);
          localBDLocation.setLongitude(arrayOfDouble[0]);
          localBDLocation.setLatitude(arrayOfDouble[1]);
        }
      }
      a(paramInt, "locStr", localBDLocation);
    }

    public void jdField_if()
    {
      if (this.jdField_do.jdField_goto == true)
      {
        if (c.am)
          a(54);
      }
      else
        return;
      a(55);
    }

    public void jdField_if(BDLocation paramBDLocation)
    {
      if ((this.jdField_do.jdField_goto != true) || (ae.bp().bq()))
        return;
      a(paramBDLocation);
      ak.a().a(null);
      ak.a().jdField_if(ak.a().jdField_new);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.k
 * JD-Core Version:    0.6.2
 */