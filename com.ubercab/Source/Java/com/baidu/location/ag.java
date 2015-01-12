package com.baidu.location;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

abstract class ag
  implements ax, n
{
  public static String ee = null;
  private boolean ed = false;
  private boolean ef = true;
  final Handler eg = new b();
  public t.a eh = null;
  private boolean ei = false;
  private boolean ej = false;
  public ar.b ek = null;

  abstract void at();

  abstract void jdMethod_byte(Message paramMessage);

  public String e(String paramString)
  {
    if ((this.eh == null) || (!this.eh.jdMethod_do()))
      this.eh = t.an().ak();
    label92: Location localLocation;
    String str1;
    String str2;
    if (this.eh != null)
    {
      c.jdMethod_if("baidu_location_service", this.eh.jdMethod_if());
      if ((this.ek == null) || (!this.ek.jdMethod_for()))
        this.ek = ar.bW().b1();
      if (this.ek == null)
        break label215;
      c.jdMethod_if("baidu_location_service", this.ek.jdMethod_else());
      boolean bool = x.a4().aR();
      localLocation = null;
      if (bool)
        localLocation = x.a4().aS();
      str1 = k.p().o();
      if (!ar.bU())
        break label225;
      str2 = "&cn=32";
      label130: if (!this.ef)
        break label263;
      this.ef = false;
    }
    while (true)
    {
      String str6 = str2 + str1;
      if (paramString != null)
        str6 = paramString + str6;
      return c.jdMethod_if(this.eh, this.ek, localLocation, str6, 0);
      c.jdMethod_if("baidu_location_service", "cellInfo null...");
      break;
      label215: c.jdMethod_if("baidu_location_service", "wifi list null");
      break label92;
      label225: Locale localLocale = Locale.CHINA;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(t.an().ap());
      str2 = String.format(localLocale, "&cn=%d", arrayOfObject);
      break label130;
      label263: if (!this.ed)
      {
        String str3 = q.y();
        if (str3 != null)
          str2 = str2 + str3;
        String str4 = ar.bW().b0();
        if (!TextUtils.isEmpty(str4))
        {
          String str5 = str4.replace(":", "");
          str2 = String.format(Locale.CHINA, "%s&mac=%s", new Object[] { str2, str5 });
          this.ed = true;
        }
      }
    }
  }

  class a extends s
  {
    String dx = null;
    String dy = null;

    public a()
    {
      this.cT = new ArrayList();
    }

    void T()
    {
      this.cR = c.jdMethod_for();
      String str1 = Jni.i(this.dx);
      if (ab.gE)
        Log.i("baidu_location_service", str1);
      ak.a().a(str1);
      this.dx = null;
      if (this.dy == null)
        this.dy = q.B();
      this.cT.add(new BasicNameValuePair("bloc", str1));
      if (this.dy != null)
        this.cT.add(new BasicNameValuePair("up", this.dy));
      StringBuffer localStringBuffer = new StringBuffer(512);
      Locale localLocale1 = Locale.CHINA;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = v.a(f.getServiceContext());
      arrayOfObject1[1] = v.jdMethod_if(f.getServiceContext());
      localStringBuffer.append(String.format(localLocale1, "&ki=%s&sn=%s", arrayOfObject1));
      String str2 = j.cZ().cY();
      if (str2 != null)
        localStringBuffer.append(str2);
      if (localStringBuffer.length() > 0)
        this.cT.add(new BasicNameValuePair("ext", Jni.i(localStringBuffer.toString())));
      Locale localLocale2 = Locale.CHINA;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Long.valueOf(System.currentTimeMillis());
      String str3 = String.format(localLocale2, "%d", arrayOfObject2);
      this.cT.add(new BasicNameValuePair("trtm", str3));
      g.e().h();
    }

    public void d(String paramString)
    {
      this.dx = paramString;
      N();
    }

    void jdMethod_do(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.cS != null));
      while (true)
      {
        try
        {
          String str = EntityUtils.toString(this.cS, "utf-8");
          ag.ee = str;
          ak.a().jdMethod_if(str);
          try
          {
            localBDLocation = new BDLocation(str);
            if (localBDLocation.getLocType() == 161)
            {
              g.e().jdMethod_try(localBDLocation.getTime());
              localBDLocation.jdMethod_byte(t.an().aq());
              if (af.bw().by())
                localBDLocation.setDirection(af.bw().bu());
            }
            Message localMessage3 = ag.this.eg.obtainMessage(21);
            localMessage3.obj = localBDLocation;
            localMessage3.sendToTarget();
            this.dy = null;
            if (this.cT != null)
              this.cT.clear();
            return;
          }
          catch (Exception localException2)
          {
            BDLocation localBDLocation = new BDLocation();
            localBDLocation.setLocType(63);
            continue;
          }
        }
        catch (Exception localException1)
        {
          Message localMessage2 = ag.this.eg.obtainMessage(63);
          localMessage2.obj = "HttpStatus error";
          localMessage2.sendToTarget();
          continue;
        }
        ak.a().jdMethod_if("network exception");
        Message localMessage1 = ag.this.eg.obtainMessage(63);
        localMessage1.obj = "HttpStatus error";
        localMessage1.sendToTarget();
      }
    }
  }

  public class b extends Handler
  {
    public b()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      if (!ab.gv)
        return;
      switch (paramMessage.what)
      {
      default:
        return;
      case 21:
        ag.this.jdMethod_byte(paramMessage);
        return;
      case 62:
      case 63:
      }
      ag.this.at();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.ag
 * JD-Core Version:    0.6.2
 */