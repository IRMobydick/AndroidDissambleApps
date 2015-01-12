package com.baidu.location;

import android.app.AlarmManager;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.text.TextUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

class l
  implements ax, n
{
  private static final int b5 = 200;
  private static File b7 = null;
  private static File bD;
  private static final int bK = 800;
  public static final String bM = "com.baidu.locTest.LocationServer4.2";
  private static final int bW = 24;
  private static String bZ = I + "/glb.dat";
  private long b0 = 0L;
  private final int b1 = 200;
  private int b2 = 0;
  private int b3 = 1;
  private boolean b4 = false;
  long b6 = 0L;
  private a b8 = null;
  private Handler bA = null;
  private boolean bB = false;
  private long[] bC = new long[20];
  private boolean bE = false;
  private boolean bF = false;
  private String bG = I + "/vm.dat";
  private int bH = 0;
  private AlarmManager bI = null;
  private PendingIntent bJ = null;
  private Context bL = null;
  private String bN = null;
  private long bO = 0L;
  private boolean bP = false;
  private long bQ = 0L;
  private t.a bR = null;
  private long bS = c.ad;
  private final int bT = 1;
  String bU = "dlcu.dat";
  ArrayList bV = null;
  private long bX = 0L;
  ArrayList bY = null;
  c bx = null;
  private final long by = 86100000L;
  private String bz = "";

  static
  {
    bD = null;
  }

  public l(Context paramContext)
  {
    this.bL = paramContext;
    this.b6 = 0L;
    try
    {
      this.bx = new c();
    }
    catch (Exception localException)
    {
      try
      {
        while (true)
        {
          this.bA = new l.1(this);
          this.bX = System.currentTimeMillis();
          this.bI = ((AlarmManager)paramContext.getSystemService("alarm"));
          this.b8 = new a();
          paramContext.registerReceiver(this.b8, new IntentFilter("com.baidu.locTest.LocationServer4.2"));
          this.bJ = PendingIntent.getBroadcast(paramContext, 0, new Intent("com.baidu.locTest.LocationServer4.2"), 134217728);
          this.bI.set(0, 1000L + System.currentTimeMillis(), this.bJ);
          this.bS = c.ad;
          this.bY = new ArrayList();
          this.bV = new ArrayList();
          t();
          this.bE = true;
          return;
          localException = localException;
          this.bx = null;
        }
      }
      finally
      {
      }
    }
  }

  private void jdMethod_if(boolean paramBoolean)
  {
    String str1 = c.jdMethod_byte();
    if (str1 == null)
      return;
    String str2 = str1 + File.separator + "baidu/tempdata/" + this.bU;
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(str2, "rw");
      if (paramBoolean)
      {
        localRandomAccessFile.seek(0L);
        localRandomAccessFile.writeLong(System.currentTimeMillis());
        localRandomAccessFile.writeInt(2125);
        this.b2 = 0;
        this.bQ = System.currentTimeMillis();
      }
      while (true)
      {
        localRandomAccessFile.writeInt(this.b2);
        localRandomAccessFile.writeInt(2125);
        localRandomAccessFile.close();
        return;
        localRandomAccessFile.seek(12L);
      }
    }
    catch (Exception localException)
    {
    }
  }

  public static void q()
  {
    try
    {
      if (bZ != null)
      {
        b7 = new File(bZ);
        if (!b7.exists())
        {
          File localFile = new File(I);
          if (!localFile.exists())
            localFile.mkdirs();
          b7.createNewFile();
          RandomAccessFile localRandomAccessFile = new RandomAccessFile(b7, "rw");
          localRandomAccessFile.seek(0L);
          localRandomAccessFile.writeInt(-1);
          localRandomAccessFile.writeInt(-1);
          localRandomAccessFile.writeInt(0);
          localRandomAccessFile.writeLong(0L);
          localRandomAccessFile.writeInt(0);
          localRandomAccessFile.writeInt(0);
          localRandomAccessFile.close();
        }
      }
      else
      {
        b7 = null;
        return;
      }
    }
    catch (Exception localException)
    {
      b7 = null;
    }
  }

  public static String s()
  {
    return null;
  }

  private void t()
  {
    String str1 = c.jdMethod_byte();
    if (str1 == null)
      return;
    String str2 = str1 + File.separator + "baidu/tempdata/" + this.bU;
    try
    {
      localRandomAccessFile = new RandomAccessFile(str2, "r");
      localRandomAccessFile.seek(0L);
      long l2 = localRandomAccessFile.readLong();
      l1 = l2;
    }
    catch (Exception localException4)
    {
      try
      {
        if (localRandomAccessFile.readInt() == 2125)
        {
          int k = localRandomAccessFile.readInt();
          i = k;
        }
      }
      catch (Exception localException4)
      {
        while (true)
        {
          try
          {
            int m = localRandomAccessFile.readInt();
            if (m == 2125)
              j = 1;
          }
          catch (Exception localException4)
          {
            try
            {
              RandomAccessFile localRandomAccessFile;
              localRandomAccessFile.close();
              if (j != 0)
              {
                this.b2 = i;
                this.bQ = l1;
                return;
              }
              this.b2 = 0;
              this.bQ = 0L;
              return;
              localException1 = localException1;
              long l1 = 0L;
              i = 0;
              j = 0;
              continue;
              localException2 = localException2;
              i = 0;
              j = 0;
              continue;
              localException4 = localException4;
              j = 0;
              continue;
            }
            catch (Exception localException3)
            {
              continue;
            }
            j = 0;
            continue;
          }
          int i = 0;
          int j = 0;
        }
      }
    }
  }

  boolean jdMethod_if(double paramDouble1, double paramDouble2)
  {
    return 0.8428018000000001D + (-2.1971522D * paramDouble1 + -0.70587059D * paramDouble2) > 0.0D;
  }

  public boolean r()
  {
    return ((KeyguardManager)this.bL.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }

  public void u()
  {
    try
    {
      this.bE = false;
      if (this.b8 != null)
        this.bL.unregisterReceiver(this.b8);
      this.b8 = null;
      if ((this.bI != null) && (this.bJ != null))
        this.bI.cancel(this.bJ);
      this.bI = null;
      this.bJ = null;
      bD = null;
      this.bY.clear();
      this.bV.clear();
      this.bY = null;
      this.bV = null;
      this.b6 = 0L;
      this.b0 = 0L;
      this.bz = "";
      this.bB = false;
      return;
    }
    finally
    {
    }
  }

  void v()
  {
    if (!this.bE)
      return;
    if (this.b0 != 0L);
    for (long l1 = 30000L + (System.currentTimeMillis() - this.b0); ; l1 = 0L)
    {
      this.b0 = System.currentTimeMillis();
      String str1 = c.jdMethod_byte();
      if (str1 == null)
      {
        this.bI.set(0, System.currentTimeMillis() + c.aQ, this.bJ);
        return;
      }
      t.a locala = t.an().ak();
      if (locala == null)
      {
        this.bI.set(0, System.currentTimeMillis() + c.aQ, this.bJ);
        return;
      }
      ar.b localb1 = ar.bW().b1();
      boolean bool1 = this.b6 < 0L;
      int i = 0;
      if (!bool1)
      {
        i = 1;
        this.bY.clear();
        this.bV.clear();
      }
      int j = i;
      int k = 0;
      if (j == 0)
      {
        int i10 = this.bV.size();
        k = 0;
        if (i10 > 0)
        {
          boolean bool2 = locala.a((t.a)this.bV.get(i10 - 1));
          k = 0;
          if (bool2)
          {
            int i11 = this.bY.size();
            k = 0;
            if (i11 >= i10)
            {
              ar.b localb2 = (ar.b)this.bY.get(i10 - 1);
              boolean bool3 = jdMethod_if(ar.jdMethod_if(localb1, localb2), new b(localb2).a(new b(localb1)));
              k = 0;
              if (!bool3)
                k = -1;
            }
          }
        }
      }
      int m = 0;
      if (k < 0)
        m = 1;
      if (m == 0)
      {
        if ((System.currentTimeMillis() - this.bQ <= 86400000L) && (System.currentTimeMillis() - this.bQ >= 0L))
          break label423;
        this.b2 = 0;
        jdMethod_if(true);
        if (this.b2 > c.a5)
          this.bO = (86400000L + this.bQ - System.currentTimeMillis());
      }
      if (this.bO > 900000L)
      {
        this.bS = this.bO;
        this.bI.set(0, System.currentTimeMillis() + this.bS, this.bJ);
        this.bO = 0L;
      }
      while (true)
      {
        this.b6 = System.currentTimeMillis();
        if (m == 0)
          break label610;
        q.x().z();
        return;
        label423: this.b2 = (1 + this.b2);
        jdMethod_if(false);
        break;
        if (k < 0)
        {
          this.bS += c.ao;
          if ((localb1 == null) || (localb1.jdField_for == null) || (localb1.jdField_for.size() == 0))
            if (this.bS > c.aK)
              this.bS = c.aK;
          while (true)
          {
            this.bI.set(0, System.currentTimeMillis() + this.bS, this.bJ);
            this.bB = true;
            break;
            if (this.bS > c.aQ)
              this.bS = c.aQ;
          }
        }
        this.bS = c.ad;
        this.bI.set(0, System.currentTimeMillis() + this.bS, this.bJ);
        if (System.currentTimeMillis() - this.b6 > 840000L)
        {
          this.bY.clear();
          this.bV.clear();
        }
      }
      label610: StringBuffer localStringBuffer = new StringBuffer(200);
      if (j != 0)
        localStringBuffer.append("s");
      localStringBuffer.append("v");
      localStringBuffer.append(4);
      int n = (int)(System.currentTimeMillis() >> 15);
      localStringBuffer.append("t");
      localStringBuffer.append(n);
      if (locala.jdMethod_for())
      {
        if (locala.jdField_do != 460)
          break label960;
        localStringBuffer.append("x,");
      }
      String str2;
      int i1;
      int i2;
      Object localObject1;
      int i3;
      String str4;
      int i5;
      int i6;
      Object localObject3;
      int i8;
      int i4;
      while (true)
      {
        localStringBuffer.append(locala.jdField_if);
        localStringBuffer.append(",");
        localStringBuffer.append(locala.jdField_for);
        localStringBuffer.append(",");
        localStringBuffer.append(locala.jdField_try);
        str2 = ar.bW().b4();
        i1 = 0;
        i2 = 0;
        localObject1 = null;
        if ((localb1 == null) || (localb1.jdField_for == null))
          break label1167;
        i3 = 0;
        while (true)
        {
          if (i3 >= localb1.jdField_for.size())
            break label1484;
          str4 = ((ScanResult)localb1.jdField_for.get(i3)).BSSID.replace(":", "");
          i5 = ((ScanResult)localb1.jdField_for.get(i3)).level;
          if (i5 >= 0)
            break label1477;
          i6 = -i5;
          if (i1 >= 3)
            break label1466;
          if ((i3 < 2) || (i2 != 0) || (str2 == null) || (str2.equals(str4)))
            break;
          if (localObject1 != null)
            break label1451;
          localObject3 = "," + str4 + ";" + i6;
          i8 = i2;
          i4 = i1;
          label942: i3++;
          i1 = i4;
          i2 = i8;
          localObject1 = localObject3;
        }
        label960: localStringBuffer.append("x");
        localStringBuffer.append(locala.jdField_do);
        localStringBuffer.append(",");
      }
      label1098: int i7;
      if (i3 == 0)
      {
        localStringBuffer.append("w");
        localStringBuffer.append(str4);
        if ((str2 != null) && (str2.equals(str4)))
        {
          String str5 = ((ScanResult)localb1.jdField_for.get(i3)).capabilities;
          if (TextUtils.isEmpty(str5))
            break label1358;
          String str6 = str5.toUpperCase(Locale.CHINA);
          if ((!str6.contains("WEP")) && (!str6.contains("WPA")))
            break label1346;
          localStringBuffer.append("l");
          i2 = 1;
        }
        localStringBuffer.append(";" + i6);
        int i9 = i1 + 1;
        i7 = i2;
        i4 = i9;
        label1142: if (i4 <= 2)
          break label1436;
      }
      while (true)
      {
        while (true)
        {
          if ((i4 < 3) && (localObject1 != null))
            localStringBuffer.append(localObject1);
          try
          {
            label1167: if (r())
              str3 = "y2";
            while (true)
            {
              if (aw.jdMethod_do().a() != null)
                str3 = str3 + aw.jdMethod_do().a();
              localStringBuffer.append(str3);
              if (this.bB)
              {
                if (l1 > 0L)
                {
                  long l2 = l1 / 60000L;
                  this.bz = ("r" + l2);
                  localStringBuffer.append(this.bz);
                  this.bz = "";
                }
                this.bB = false;
              }
              System.currentTimeMillis();
              Jni.jdMethod_int(str1, localStringBuffer.toString());
              this.bY.add(localb1);
              while (this.bY.size() > 3)
                this.bY.remove(0);
              localStringBuffer.append(",");
              break;
              label1346: localStringBuffer.append("j");
              break label1098;
              label1358: localStringBuffer.append("j");
              break label1098;
              str3 = "y1";
              ad.cM().jdMethod_goto(n);
            }
          }
          catch (Exception localException)
          {
            while (true)
              String str3 = "y";
            this.bV.add(locala);
            while (this.bV.size() > 3)
              this.bV.remove(0);
            q.x().z();
            return;
          }
        }
        label1436: Object localObject2 = localObject1;
        i8 = i7;
        localObject3 = localObject2;
        break label942;
        label1451: localObject3 = localObject1;
        i8 = i2;
        i4 = i1;
        break label942;
        label1466: i7 = i2;
        i4 = i1;
        break label1142;
        label1477: i6 = i5;
        break;
        label1484: i4 = i1;
      }
    }
  }

  public class a extends BroadcastReceiver
  {
    public a()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("com.baidu.locTest.LocationServer4.2"))
        l.jdMethod_if(l.this).sendEmptyMessage(1);
    }
  }

  class b
  {
    public static final double jdField_do = 0.8D;
    public static final double jdField_if = 0.7D;
    private double jdField_for = 1.0D;
    private HashMap jdField_int = new HashMap();

    public b(ar.b arg2)
    {
      Object localObject;
      Iterator localIterator;
      if (localObject.jdField_for != null)
        localIterator = localObject.jdField_for.iterator();
      int k;
      for (int i = 0; ; i = k)
        if (localIterator.hasNext())
        {
          ScanResult localScanResult = (ScanResult)localIterator.next();
          int j = Math.abs(localScanResult.level);
          this.jdField_int.put(localScanResult.BSSID, Integer.valueOf(j));
          this.jdField_for += (100 - j) * (100 - j);
          k = i + 1;
          if (k <= 16);
        }
        else
        {
          this.jdField_for = Math.sqrt(this.jdField_for);
          return;
        }
    }

    public double a()
    {
      return this.jdField_for;
    }

    double a(b paramb)
    {
      Iterator localIterator = this.jdField_int.keySet().iterator();
      double d = 0.0D;
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        int i = ((Integer)this.jdField_int.get(str)).intValue();
        Integer localInteger = (Integer)paramb.jdField_if().get(str);
        if (localInteger != null)
        {
          int j = localInteger.intValue();
          d += (100 - i) * (100 - j);
        }
      }
      return d / (this.jdField_for * paramb.a());
    }

    public HashMap jdField_if()
    {
      return this.jdField_int;
    }
  }

  class c extends BroadcastReceiver
  {
    boolean jdField_if = false;

    public c()
    {
      a(f.getServiceContext());
    }

    public void a(Context paramContext)
    {
      if (!this.jdField_if)
      {
        this.jdField_if = true;
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        paramContext.registerReceiver(this, localIntentFilter);
      }
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      String str = paramIntent.getAction();
      if (str.equals("android.intent.action.SCREEN_ON"));
      while (!str.equals("android.intent.action.SCREEN_OFF"))
        return;
      ad.cM().cK();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.l
 * JD-Core Version:    0.6.2
 */