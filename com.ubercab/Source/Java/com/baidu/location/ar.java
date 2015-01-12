package com.baidu.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ar
  implements ax, n
{
  private static final int hN = 15;
  private static ar hW = null;
  private a h0 = null;
  private final long hM = 3000L;
  private boolean hO = true;
  private long hP = 0L;
  private b hQ = null;
  private Object hR = null;
  private final long hS = 3000L;
  private long hT = 0L;
  private final long hU = 5000L;
  private WifiManager hV = null;
  private Method hX = null;
  private boolean hY = false;
  private long hZ = 0L;

  public static boolean bU()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)f.getServiceContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
      {
        int i = localNetworkInfo.getType();
        if (i == 1)
          return true;
      }
      return false;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private void bV()
  {
    if (this.hV == null);
    while (true)
    {
      return;
      try
      {
        List localList = this.hV.getScanResults();
        b localb = new b(localList, this.hT);
        this.hT = 0L;
        if ((this.hQ == null) || (!localb.jdMethod_if(this.hQ)))
        {
          this.hQ = localb;
          return;
        }
      }
      catch (Exception localException)
      {
      }
    }
  }

  public static ar bW()
  {
    if (hW == null)
      hW = new ar();
    return hW;
  }

  public static double jdMethod_if(b paramb1, b paramb2)
  {
    double d = 1.0D;
    if ((paramb1 == null) || (paramb2 == null))
      d = 0.0D;
    List localList1;
    List localList2;
    int i;
    int j;
    float f;
    do
    {
      do
      {
        return d;
        localList1 = paramb1.jdField_for;
        localList2 = paramb2.jdField_for;
      }
      while (localList1 == localList2);
      if ((localList1 == null) || (localList2 == null))
        return 0.0D;
      i = localList1.size();
      j = localList2.size();
      f = i + j;
    }
    while ((i == 0) && (j == 0));
    if ((i == 0) || (j == 0))
      return 0.0D;
    int k = 0;
    int m = 0;
    String str;
    int i1;
    if (k < i)
    {
      str = ((ScanResult)localList1.get(k)).BSSID;
      if (str == null)
        i1 = m;
    }
    while (true)
    {
      k++;
      m = i1;
      break;
      int n = 0;
      while (true)
        if (n < j)
        {
          if (str.equals(((ScanResult)localList2.get(n)).BSSID))
          {
            i1 = m + 1;
            break;
          }
          n++;
          continue;
          if (f <= 0.0F)
            return 0.0D;
          return m / f;
        }
      i1 = m;
    }
  }

  public static boolean jdMethod_if(b paramb1, b paramb2, float paramFloat)
  {
    if ((paramb1 == null) || (paramb2 == null))
      return false;
    List localList1 = paramb1.jdField_for;
    List localList2 = paramb2.jdField_for;
    if (localList1 == localList2)
      return true;
    if ((localList1 == null) || (localList2 == null))
      return false;
    int i = localList1.size();
    int j = localList2.size();
    float f = i + j;
    if ((i == 0) && (j == 0))
      return true;
    if ((i == 0) || (j == 0))
      return false;
    int k = 0;
    int m = 0;
    String str;
    int i1;
    if (k < i)
    {
      str = ((ScanResult)localList1.get(k)).BSSID;
      if (str == null)
        i1 = m;
    }
    while (true)
    {
      k++;
      m = i1;
      break;
      int n = 0;
      while (true)
        if (n < j)
        {
          if (str.equals(((ScanResult)localList2.get(n)).BSSID))
          {
            i1 = m + 1;
            break;
          }
          n++;
          continue;
          return m * 2 >= f * paramFloat;
        }
      i1 = m;
    }
  }

  private boolean q(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    return Pattern.compile("wpa|wep", 2).matcher(paramString).find();
  }

  public String b0()
  {
    try
    {
      WifiInfo localWifiInfo = this.hV.getConnectionInfo();
      Object localObject = null;
      if (localWifiInfo != null)
      {
        String str = localWifiInfo.getMacAddress();
        localObject = str;
      }
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public b b1()
  {
    if ((this.hQ == null) || (!this.hQ.jdMethod_new()))
      return bY();
    return this.hQ;
  }

  // ERROR //
  public void b2()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/baidu/location/ar:hY	Z
    //   6: istore_2
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpne +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: getstatic 205	com/baidu/location/ab:gv	Z
    //   18: ifeq -6 -> 12
    //   21: aload_0
    //   22: invokestatic 80	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   25: ldc 207
    //   27: invokevirtual 88	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   30: checkcast 103	android/net/wifi/WifiManager
    //   33: putfield 52	com/baidu/location/ar:hV	Landroid/net/wifi/WifiManager;
    //   36: aload_0
    //   37: new 209	com/baidu/location/ar$a
    //   40: dup
    //   41: aload_0
    //   42: aconst_null
    //   43: invokespecial 212	com/baidu/location/ar$a:<init>	(Lcom/baidu/location/ar;Lcom/baidu/location/ar$1;)V
    //   46: putfield 54	com/baidu/location/ar:h0	Lcom/baidu/location/ar$a;
    //   49: invokestatic 80	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   52: aload_0
    //   53: getfield 54	com/baidu/location/ar:h0	Lcom/baidu/location/ar$a;
    //   56: new 214	android/content/IntentFilter
    //   59: dup
    //   60: ldc 216
    //   62: invokespecial 219	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   65: invokevirtual 223	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   68: pop
    //   69: aload_0
    //   70: iconst_1
    //   71: putfield 62	com/baidu/location/ar:hY	Z
    //   74: ldc 225
    //   76: invokestatic 231	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   79: ldc 233
    //   81: invokevirtual 237	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   84: astore 5
    //   86: aload 5
    //   88: ifnull -76 -> 12
    //   91: aload 5
    //   93: iconst_1
    //   94: invokevirtual 243	java/lang/reflect/Field:setAccessible	(Z)V
    //   97: aload_0
    //   98: aload 5
    //   100: aload_0
    //   101: getfield 52	com/baidu/location/ar:hV	Landroid/net/wifi/WifiManager;
    //   104: invokevirtual 246	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: putfield 64	com/baidu/location/ar:hR	Ljava/lang/Object;
    //   110: aload_0
    //   111: getfield 64	com/baidu/location/ar:hR	Ljava/lang/Object;
    //   114: invokevirtual 250	java/lang/Object:getClass	()Ljava/lang/Class;
    //   117: astore 6
    //   119: iconst_1
    //   120: anewarray 227	java/lang/Class
    //   123: astore 7
    //   125: aload 7
    //   127: iconst_0
    //   128: getstatic 256	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   131: aastore
    //   132: aload_0
    //   133: aload 6
    //   135: ldc_w 258
    //   138: aload 7
    //   140: invokevirtual 262	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   143: putfield 66	com/baidu/location/ar:hX	Ljava/lang/reflect/Method;
    //   146: aload_0
    //   147: getfield 66	com/baidu/location/ar:hX	Ljava/lang/reflect/Method;
    //   150: ifnull -138 -> 12
    //   153: aload_0
    //   154: getfield 66	com/baidu/location/ar:hX	Ljava/lang/reflect/Method;
    //   157: iconst_1
    //   158: invokevirtual 265	java/lang/reflect/Method:setAccessible	(Z)V
    //   161: goto -149 -> 12
    //   164: astore 4
    //   166: goto -154 -> 12
    //   169: astore_1
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_1
    //   173: athrow
    //   174: astore_3
    //   175: goto -106 -> 69
    //
    // Exception table:
    //   from	to	target	type
    //   74	86	164	java/lang/Exception
    //   91	161	164	java/lang/Exception
    //   2	7	169	finally
    //   15	49	169	finally
    //   49	69	169	finally
    //   69	74	169	finally
    //   74	86	169	finally
    //   91	161	169	finally
    //   49	69	174	java/lang/Exception
  }

  public boolean b3()
  {
    long l = System.currentTimeMillis();
    if (l - this.hZ <= 10000L)
      return false;
    this.hZ = l;
    return bX();
  }

  public String b4()
  {
    WifiInfo localWifiInfo = this.hV.getConnectionInfo();
    if (localWifiInfo == null)
      return null;
    while (true)
    {
      try
      {
        String str1 = localWifiInfo.getBSSID();
        if (str1 != null)
        {
          str2 = str1.replace(":", "");
          if ("000000000000".equals(str2))
            break;
          boolean bool = "".equals(str2);
          if (bool)
            break;
          return str2;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
      String str2 = null;
    }
  }

  public boolean b5()
  {
    try
    {
      if (this.hV.isWifiEnabled())
      {
        if (this.hX != null)
        {
          Object localObject1 = this.hR;
          if (localObject1 == null);
        }
        while (true)
        {
          try
          {
            Method localMethod = this.hX;
            Object localObject2 = this.hR;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Boolean.valueOf(this.hO);
            localMethod.invoke(localObject2, arrayOfObject);
            this.hT = System.currentTimeMillis();
            return true;
          }
          catch (Exception localException2)
          {
            this.hV.startScan();
            continue;
          }
          this.hV.startScan();
        }
      }
      this.hT = 0L;
      return false;
    }
    catch (Exception localException1)
    {
    }
    return false;
  }

  public b bS()
  {
    if ((this.hQ == null) || (!this.hQ.jdMethod_for()))
      return bY();
    return this.hQ;
  }

  // ERROR //
  public void bT()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/baidu/location/ar:hY	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 80	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   17: aload_0
    //   18: getfield 54	com/baidu/location/ar:h0	Lcom/baidu/location/ar$a;
    //   21: invokevirtual 313	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   24: aload_0
    //   25: lconst_0
    //   26: putfield 70	com/baidu/location/ar:hP	J
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 54	com/baidu/location/ar:h0	Lcom/baidu/location/ar$a;
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 52	com/baidu/location/ar:hV	Landroid/net/wifi/WifiManager;
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 62	com/baidu/location/ar:hY	Z
    //   44: goto -33 -> 11
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    //   52: astore_3
    //   53: goto -24 -> 29
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   14	29	47	finally
    //   29	44	47	finally
    //   14	29	52	java/lang/Exception
  }

  public boolean bX()
  {
    if (this.hV == null);
    while (System.currentTimeMillis() - this.hT <= 3000L)
      return false;
    return b5();
  }

  public b bY()
  {
    if (this.hV != null)
      try
      {
        b localb = new b(this.hV.getScanResults(), 0L);
        return localb;
      }
      catch (Exception localException)
      {
      }
    return new b(null, 0L);
  }

  public boolean bZ()
  {
    return (this.hV.isWifiEnabled()) && (3 == this.hV.getWifiState());
  }

  private class a extends BroadcastReceiver
  {
    private a()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramContext == null);
      do
      {
        do
          return;
        while (!paramIntent.getAction().equals("android.net.wifi.SCAN_RESULTS"));
        ar.jdMethod_if(ar.this, System.currentTimeMillis() / 1000L);
        ar.jdMethod_if(ar.this);
        ab.bj().obtainMessage(41).sendToTarget();
      }
      while (!ae.bp().bs());
      ae.bp().g1.obtainMessage(41).sendToTarget();
    }
  }

  protected class b
  {
    private boolean jdField_do = false;
    public List jdField_for = null;
    private long jdField_if = 0L;
    private long jdField_int = 0L;
    private boolean jdField_new;

    public b(b arg2)
    {
      Object localObject;
      if (localObject != null)
      {
        this.jdField_for = localObject.jdField_for;
        this.jdField_if = localObject.jdField_if;
        this.jdField_int = localObject.jdField_int;
        this.jdField_do = localObject.jdField_do;
      }
    }

    public b(List paramLong, long arg3)
    {
      Object localObject;
      this.jdField_if = localObject;
      this.jdField_for = paramLong;
      this.jdField_int = System.currentTimeMillis();
      a();
      c.jdField_if("baidu_location_service", jdField_int());
    }

    private void a()
    {
      if (jdMethod_try() < 1)
        return;
      int i = -1 + this.jdField_for.size();
      int j = 1;
      label23: int k;
      if ((i >= 1) && (j != 0))
      {
        k = 0;
        j = 0;
        label36: if (k < i)
        {
          if (((ScanResult)this.jdField_for.get(k)).level >= ((ScanResult)this.jdField_for.get(k + 1)).level)
            break label149;
          ScanResult localScanResult = (ScanResult)this.jdField_for.get(k + 1);
          this.jdField_for.set(k + 1, this.jdField_for.get(k));
          this.jdField_for.set(k, localScanResult);
        }
      }
      label149: for (int m = 1; ; m = j)
      {
        k++;
        j = m;
        break label36;
        i--;
        break label23;
        break;
      }
    }

    public String a(int paramInt)
    {
      if (jdMethod_try() < 1)
        return null;
      int i = 0;
      Random localRandom = new Random();
      StringBuffer localStringBuffer = new StringBuffer(512);
      String str1 = ar.this.b4();
      int j = 0;
      int k = 0;
      int m = this.jdField_for.size();
      int n = 1;
      if (m > paramInt);
      while (true)
      {
        int i1 = 0;
        int i8;
        int i9;
        int i7;
        int i6;
        label156: int i4;
        while (true)
          if (i1 < paramInt)
            if (((ScanResult)this.jdField_for.get(i1)).level == 0)
            {
              i8 = n;
              i9 = j;
              int i12 = k;
              i7 = i;
              i6 = i12;
              i1++;
              j = i9;
              n = i8;
              int i10 = i6;
              i = i7;
              k = i10;
            }
            else if (n != 0)
            {
              n = 0;
              localStringBuffer.append("&wf=");
              String str2 = ((ScanResult)this.jdField_for.get(i1)).BSSID.replace(":", "");
              localStringBuffer.append(str2);
              int i3 = ((ScanResult)this.jdField_for.get(i1)).level;
              if (i3 < 0)
                i3 = -i3;
              Locale localLocale = Locale.CHINA;
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = Integer.valueOf(i3);
              localStringBuffer.append(String.format(localLocale, ";%d;", arrayOfObject));
              i4 = j + 1;
              if ((str1 != null) && (str1.equals(str2)))
              {
                this.jdField_new = ar.jdField_if(ar.this, ((ScanResult)this.jdField_for.get(i1)).capabilities);
                k = i4;
              }
              if (i != 0)
                break label422;
            }
        while (true)
        {
          try
          {
            if ((localRandom.nextInt(10) != 2) || (((ScanResult)this.jdField_for.get(i1)).SSID == null) || (((ScanResult)this.jdField_for.get(i1)).SSID.length() >= 30))
              break label673;
            localStringBuffer.append(((ScanResult)this.jdField_for.get(i1)).SSID);
            i5 = 1;
            i6 = k;
            i7 = i5;
            i8 = n;
            i9 = i4;
            break;
            localStringBuffer.append("|");
            break label156;
            label422: if ((i != 1) || (localRandom.nextInt(20) != 1) || (((ScanResult)this.jdField_for.get(i1)).SSID == null) || (((ScanResult)this.jdField_for.get(i1)).SSID.length() >= 30))
              break label673;
            localStringBuffer.append(((ScanResult)this.jdField_for.get(i1)).SSID);
            i5 = 2;
            continue;
          }
          catch (Exception localException)
          {
            i8 = n;
            i9 = i4;
            int i11 = k;
            i7 = i;
            i6 = i11;
          }
          break;
          if (n == 0)
          {
            localStringBuffer.append("&wf_n=" + k);
            localStringBuffer.append("&wf_st=");
            localStringBuffer.append(this.jdField_if);
            localStringBuffer.append("&wf_et=");
            localStringBuffer.append(this.jdField_int);
            localStringBuffer.append("&wf_vt=");
            localStringBuffer.append(ar.jdField_do(ar.this));
            if (k > 0)
            {
              this.jdField_do = true;
              localStringBuffer.append("&wf_en=");
              if (!this.jdField_new)
                break label665;
            }
            label665: for (int i2 = 1; ; i2 = 0)
            {
              localStringBuffer.append(i2);
              return localStringBuffer.toString();
            }
          }
          return null;
          label673: int i5 = i;
        }
        paramInt = m;
      }
    }

    public boolean a(b paramb)
    {
      return ar.jdField_if(paramb, this, c.aU);
    }

    public String jdMethod_byte()
    {
      try
      {
        String str = a(15);
        return str;
      }
      catch (Exception localException)
      {
      }
      return null;
    }

    public boolean jdMethod_case()
    {
      return this.jdField_do;
    }

    public String jdMethod_char()
    {
      try
      {
        String str = a(c.aX);
        return str;
      }
      catch (Exception localException)
      {
      }
      return null;
    }

    public int jdField_do()
    {
      for (int i = 0; ; i++)
      {
        int j = jdMethod_try();
        int k = 0;
        if (i < j)
        {
          int m = -((ScanResult)this.jdField_for.get(i)).level;
          if (m > 0)
            k = m;
        }
        else
        {
          return k;
        }
      }
    }

    public boolean jdField_do(b paramb)
    {
      if ((this.jdField_for != null) && (paramb != null) && (paramb.jdField_for != null))
      {
        int i;
        if (this.jdField_for.size() < paramb.jdField_for.size())
          i = this.jdField_for.size();
        for (int j = 0; ; j++)
        {
          if (j >= i)
            break label166;
          String str1 = ((ScanResult)this.jdField_for.get(j)).BSSID;
          int k = ((ScanResult)this.jdField_for.get(j)).level;
          String str2 = ((ScanResult)paramb.jdField_for.get(j)).BSSID;
          int m = ((ScanResult)paramb.jdField_for.get(j)).level;
          if ((!str1.equals(str2)) || (k != m))
          {
            return false;
            i = paramb.jdField_for.size();
            break;
          }
        }
        label166: return true;
      }
      return false;
    }

    public String jdMethod_else()
    {
      StringBuffer localStringBuffer = new StringBuffer(512);
      localStringBuffer.append("wifi info:");
      if (jdMethod_try() < 1)
        return localStringBuffer.toString();
      int i = this.jdField_for.size();
      if (i > 10)
        i = 10;
      int j = 0;
      int k = 1;
      if (j < i)
      {
        int n;
        if (((ScanResult)this.jdField_for.get(j)).level == 0)
          n = k;
        while (true)
        {
          j++;
          k = n;
          break;
          if (k != 0)
          {
            localStringBuffer.append("wifi=");
            localStringBuffer.append(((ScanResult)this.jdField_for.get(j)).BSSID.replace(":", ""));
            int i1 = ((ScanResult)this.jdField_for.get(j)).level;
            Locale localLocale2 = Locale.CHINA;
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = Integer.valueOf(i1);
            localStringBuffer.append(String.format(localLocale2, ";%d;", arrayOfObject2));
            n = 0;
          }
          else
          {
            localStringBuffer.append(";");
            localStringBuffer.append(((ScanResult)this.jdField_for.get(j)).BSSID.replace(":", ""));
            int m = ((ScanResult)this.jdField_for.get(j)).level;
            Locale localLocale1 = Locale.CHINA;
            Object[] arrayOfObject1 = new Object[1];
            arrayOfObject1[0] = Integer.valueOf(m);
            localStringBuffer.append(String.format(localLocale1, ",%d;", arrayOfObject1));
            n = k;
          }
        }
      }
      return localStringBuffer.toString();
    }

    public boolean jdField_for()
    {
      return System.currentTimeMillis() - this.jdField_int < 3000L;
    }

    public String jdField_if(int paramInt)
    {
      if ((paramInt == 0) || (jdMethod_try() < 1))
        return null;
      StringBuffer localStringBuffer = new StringBuffer(256);
      if (this.jdField_for.size() > c.aX);
      int i = 0;
      int j = 1;
      int k = 0;
      if (k < c.aX)
      {
        if ((j & paramInt) != 0)
        {
          if (i != 0)
            break label144;
          localStringBuffer.append("&ssid=");
        }
        while (true)
        {
          localStringBuffer.append(((ScanResult)this.jdField_for.get(k)).BSSID);
          localStringBuffer.append(";");
          localStringBuffer.append(((ScanResult)this.jdField_for.get(k)).SSID);
          i++;
          j <<= 1;
          k++;
          break;
          label144: localStringBuffer.append("|");
        }
      }
      return localStringBuffer.toString();
    }

    public boolean jdField_if()
    {
      return System.currentTimeMillis() - this.jdField_if < 3000L;
    }

    public boolean jdField_if(b paramb)
    {
      if ((this.jdField_for != null) && (paramb != null) && (paramb.jdField_for != null))
      {
        int i;
        if (this.jdField_for.size() < paramb.jdField_for.size())
          i = this.jdField_for.size();
        for (int j = 0; ; j++)
        {
          if (j >= i)
            break label115;
          if (!((ScanResult)this.jdField_for.get(j)).BSSID.equals(((ScanResult)paramb.jdField_for.get(j)).BSSID))
          {
            return false;
            i = paramb.jdField_for.size();
            break;
          }
        }
        label115: return true;
      }
      return false;
    }

    public String jdField_int()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("wifi=");
      if (this.jdField_for == null)
        return localStringBuilder.toString();
      for (int i = 0; i < this.jdField_for.size(); i++)
      {
        int j = ((ScanResult)this.jdField_for.get(i)).level;
        localStringBuilder.append(((ScanResult)this.jdField_for.get(i)).BSSID.replace(":", ""));
        Locale localLocale = Locale.CHINA;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(j);
        localStringBuilder.append(String.format(localLocale, ",%d;", arrayOfObject));
      }
      return localStringBuilder.toString();
    }

    public boolean jdField_new()
    {
      return System.currentTimeMillis() - this.jdField_int < 5000L;
    }

    public int jdMethod_try()
    {
      if (this.jdField_for == null)
        return 0;
      return this.jdField_for.size();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.ar
 * JD-Core Version:    0.6.2
 */