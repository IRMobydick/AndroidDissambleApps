package com.baidu.location;

import android.os.Handler;
import android.os.Message;

class ah extends ag
  implements ax, n
{
  private static ah eo = null;
  final int eA = 2000;
  private String eB = null;
  final Handler eg = new ag.b(this);
  final int el = 1000;
  public ag.a em = null;
  private volatile boolean en = false;
  private int ep;
  private long eq = 0L;
  private as er = null;
  private long es = 0L;
  private t.a et = null;
  private ar.b eu = null;
  private boolean ev = false;
  private boolean ew = true;
  private boolean ex = true;
  private BDLocation ey = null;
  private BDLocation ez = null;

  private void aB()
  {
    if (this.ex)
      aE();
    while (this.en)
      return;
    if (ar.bW().bX())
    {
      this.ev = true;
      this.eg.postDelayed(new a(null), 2000L);
      return;
    }
    aE();
  }

  private void aD()
  {
    if (this.ey != null)
      q.x().E();
  }

  private void aE()
  {
    if (this.en)
      return;
    if ((System.currentTimeMillis() - this.eq < 1000L) && (this.ey != null))
    {
      k.p().jdMethod_do(this.ey);
      av();
      return;
    }
    c.jdMethod_if("baidu_location_service", "start network locating ...");
    this.en = true;
    this.ew = jdMethod_if(this.et);
    if ((!jdMethod_if(this.eu)) && (!this.ew) && (this.ey != null) && (this.ep == 0))
    {
      if ((this.ez != null) && (System.currentTimeMillis() - this.es > 30000L))
      {
        this.ey = this.ez;
        this.ez = null;
      }
      k.p().jdMethod_do(this.ey);
      av();
      return;
    }
    String str = e(null);
    if (str == null)
    {
      BDLocation localBDLocation = new BDLocation();
      localBDLocation.setLocType(62);
      k.p().jdMethod_do(localBDLocation);
      av();
      return;
    }
    if (this.eB != null)
    {
      str = str + this.eB;
      this.eB = null;
    }
    this.em.d(str);
    this.et = this.eh;
    this.eu = this.ek;
    if (this.ex == true)
      this.ex = false;
    this.eq = System.currentTimeMillis();
  }

  private boolean au()
  {
    this.ek = ar.bW().b1();
    return !this.er.jdMethod_do(this.ek);
  }

  private void av()
  {
    this.en = false;
    aD();
  }

  public static ah ay()
  {
    if (eo == null)
      eo = new ah();
    return eo;
  }

  private void jdMethod_char(Message paramMessage)
  {
    String str = x.a4().aP();
    BDLocation localBDLocation = new BDLocation(str);
    k.p().jdMethod_if(localBDLocation, paramMessage);
    ak.a().a(null);
    ak.a().jdMethod_if(str);
  }

  private void jdMethod_else(Message paramMessage)
  {
    c.jdMethod_if("baidu_location_service", "on request location ...");
    if (ae.bp().bq());
    do
    {
      return;
      int i = k.p().jdMethod_for(paramMessage);
      this.ep = paramMessage.arg1;
      switch (i)
      {
      default:
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(i);
        throw new IllegalArgumentException(String.format("this type %d is illegal", arrayOfObject));
      case 3:
      case 1:
      case 2:
      }
    }
    while (!x.a4().aR());
    jdMethod_char(paramMessage);
    return;
    jdMethod_goto(paramMessage);
    return;
    aB();
  }

  private void jdMethod_goto(Message paramMessage)
  {
    if (x.a4().aR())
    {
      jdMethod_char(paramMessage);
      return;
    }
    aB();
  }

  private boolean jdMethod_if(ar.b paramb)
  {
    boolean bool = true;
    this.ek = ar.bW().b1();
    if (paramb == this.ek)
      bool = false;
    while ((this.ek == null) || (paramb == null) || (!paramb.a(this.ek)))
      return bool;
    return false;
  }

  private boolean jdMethod_if(t.a parama)
  {
    boolean bool = true;
    this.eh = t.an().ak();
    if (this.eh == parama)
      bool = false;
    while ((this.eh == null) || (parama == null) || (!parama.a(this.eh)))
      return bool;
    return false;
  }

  public boolean aA()
  {
    return this.ew;
  }

  void aC()
  {
    this.ex = true;
    this.en = false;
  }

  void at()
  {
    c.jdMethod_if("baidu_location_service", "on network exception");
    if ((this.ew) || (this.ey == null))
      k.p().jdMethod_if(ay.cd().jdMethod_case(false), 21);
    while (true)
    {
      this.ey = null;
      this.ez = null;
      this.er.b6();
      av();
      return;
      k.p().jdMethod_if(this.ey, 21);
    }
  }

  public void aw()
  {
    if (this.ev)
    {
      aE();
      this.ev = false;
    }
  }

  void ax()
  {
    this.en = false;
    az();
  }

  void az()
  {
    this.ey = null;
    this.er.b6();
  }

  void jdMethod_byte(Message paramMessage)
  {
    c.jdMethod_if("baidu_location_service", "on network success");
    BDLocation localBDLocation1 = (BDLocation)paramMessage.obj;
    BDLocation localBDLocation2 = new BDLocation(localBDLocation1);
    this.ez = null;
    int i = localBDLocation1.getLocType();
    int j = 0;
    if (i == 161)
    {
      boolean bool1 = "cl".equals(localBDLocation1.getNetworkLocationType());
      j = 0;
      if (bool1)
      {
        BDLocation localBDLocation3 = this.ey;
        j = 0;
        if (localBDLocation3 != null)
        {
          int m = this.ey.getLocType();
          j = 0;
          if (m == 161)
          {
            boolean bool2 = "wf".equals(this.ey.getNetworkLocationType());
            j = 0;
            if (bool2)
            {
              boolean bool3 = System.currentTimeMillis() - this.es < 30000L;
              j = 0;
              if (bool3)
              {
                j = 1;
                this.ez = localBDLocation1;
              }
            }
          }
        }
      }
    }
    label188: int k;
    if (j != 0)
    {
      k.p().jdMethod_if(this.ey, 21);
      if (!c.jdMethod_if(localBDLocation1))
        break label279;
      if (j == 0)
        this.ey = localBDLocation1;
      k = c.jdMethod_do(ee, "ssid\":\"", "\"");
      if ((k == -2147483648) || (this.eu == null))
        break label294;
    }
    label279: label294: for (this.eB = this.eu.jdMethod_if(k); ; this.eB = null)
    {
      ay.cd().jdMethod_if(ee, this.et, this.eu, localBDLocation2);
      j.cZ().jdMethod_byte(localBDLocation2);
      av();
      return;
      k.p().jdMethod_if(localBDLocation1, 21);
      this.es = System.currentTimeMillis();
      break;
      this.ey = null;
      this.er.b6();
      break label188;
    }
  }

  public void jdMethod_case(Message paramMessage)
  {
    jdMethod_else(paramMessage);
  }

  public void jdMethod_for(BDLocation paramBDLocation)
  {
    az();
    this.ey = paramBDLocation;
  }

  private class a
    implements Runnable
  {
    private a()
    {
    }

    public void run()
    {
      if (ah.jdMethod_do(ah.this) == true)
      {
        ah.jdMethod_if(ah.this, false);
        ah.jdMethod_if(ah.this);
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.ah
 * JD-Core Version:    0.6.2
 */