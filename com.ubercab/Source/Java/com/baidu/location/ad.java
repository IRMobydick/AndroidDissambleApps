package com.baidu.location;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import java.io.File;
import java.io.RandomAccessFile;

class ad
  implements ax, SensorEventListener, b
{
  private static ad kg;
  private Runnable j6 = null;
  private Sensor j7;
  private final int j8 = 2;
  private boolean j9 = false;
  private boolean ka = false;
  private int kb = 0;
  private boolean kc = false;
  private Sensor kd;
  private boolean ke = false;
  private Handler kf;
  private boolean kh = false;
  private int ki = 0;
  private StringBuffer kj = null;
  private SensorManager kk;
  private StringBuffer kl = null;
  private Runnable km = null;
  private final int kn = 1;

  private ad()
  {
    try
    {
      this.kk = ((SensorManager)f.getServiceContext().getSystemService("sensor"));
      this.j7 = this.kk.getDefaultSensor(1);
      this.kd = this.kk.getDefaultSensor(2);
      label108: this.kf = new Handler();
      return;
    }
    catch (Exception localException)
    {
      break label108;
    }
  }

  private void cC()
  {
    if ((this.kk == null) || (this.kd == null));
    while (this.j9)
      return;
    try
    {
      this.kk.registerListener(this, this.kd, 2, this.kf);
      this.j9 = true;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void cD()
  {
    if (this.j9);
    try
    {
      this.kk.unregisterListener(this, this.kd);
      this.j9 = false;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void cE()
  {
    if ((this.kk == null) || (this.j7 == null));
    while (this.ka)
      return;
    try
    {
      this.kk.registerListener(this, this.j7, 2, this.kf);
      this.ka = true;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void cF()
  {
    if ((this.kc) || (this.ke))
      cE();
    if (this.kc)
      cC();
  }

  private String cH()
  {
    int i = 0;
    String str1 = jdMethod_void(1);
    String[] arrayOfString = { "lmibaca.dat", "lmibacb.dat" };
    int j = arrayOfString.length;
    while (i < j)
    {
      String str2 = arrayOfString[i];
      if (!new File(str1 + File.separator + str2).exists())
        return str1 + File.separator + str2;
      i++;
    }
    return null;
  }

  private void cI()
  {
    if (this.ka);
    try
    {
      this.kk.unregisterListener(this, this.j7);
      this.ka = false;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void cJ()
  {
    this.kc = true;
    this.kj = new StringBuffer(8192);
    cF();
    this.km = new ad.3(this);
    this.kf.postDelayed(this.km, 60000L);
  }

  private void cL()
  {
    if (this.kc)
      return;
    if (this.ke)
    {
      cD();
      return;
    }
    cD();
    cI();
    this.ki = 0;
    this.kb = 0;
  }

  public static ad cM()
  {
    if (kg == null)
      kg = new ad();
    return kg;
  }

  private String cN()
  {
    int i = 0;
    String str1 = jdMethod_void(2);
    String[] arrayOfString = { "lbaca.dat", "lbacb.dat", "lbacc.dat", "lbacd.dat" };
    int j = arrayOfString.length;
    while (i < j)
    {
      String str2 = arrayOfString[i];
      if (!new File(str1 + File.separator + str2).exists())
        return str1 + File.separator + str2;
      i++;
    }
    return null;
  }

  private boolean cQ()
  {
    String str = cR();
    if (str == null)
      return false;
    try
    {
      File localFile = new File(str);
      if (!localFile.exists())
      {
        localFile.createNewFile();
        RandomAccessFile localRandomAccessFile2 = new RandomAccessFile(localFile, "rw");
        jdMethod_if(localRandomAccessFile2, 0);
        localRandomAccessFile2.close();
        return true;
      }
      RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(localFile, "rw");
      localRandomAccessFile1.seek(4L);
      long l1 = localRandomAccessFile1.readLong();
      int i = localRandomAccessFile1.readInt();
      if (localRandomAccessFile1.readInt() == 3321)
      {
        long l2 = System.currentTimeMillis() - l1;
        if ((l2 < 0L) || (l2 > 86400000L))
        {
          localRandomAccessFile1.seek(4L);
          localRandomAccessFile1.writeLong(System.currentTimeMillis());
          localRandomAccessFile1.writeInt(0);
          localRandomAccessFile1.close();
          return true;
        }
        if (i > 96000)
        {
          localRandomAccessFile1.close();
          return false;
        }
        localRandomAccessFile1.close();
        return true;
      }
      jdMethod_if(localRandomAccessFile1, 0);
      localRandomAccessFile1.close();
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private String cR()
  {
    String str1 = jdMethod_void(1);
    if (str1 == null)
      return null;
    String str2 = str1 + File.separator + "lscts.dat";
    File localFile = new File(str2);
    if (!localFile.exists());
    try
    {
      localFile.createNewFile();
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
      jdMethod_if(localRandomAccessFile, 0);
      localRandomAccessFile.close();
      return str2;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private void d(int paramInt)
  {
    String str = cR();
    if (str == null);
    while (true)
    {
      return;
      try
      {
        File localFile = new File(str);
        if (localFile.exists())
        {
          RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
          localRandomAccessFile.seek(0L);
          int i = localRandomAccessFile.readInt();
          localRandomAccessFile.readLong();
          int j = localRandomAccessFile.readInt();
          if ((localRandomAccessFile.readInt() == 3321) && (i == 3321))
          {
            int k = j + paramInt;
            localRandomAccessFile.seek(12L);
            localRandomAccessFile.writeInt(k);
          }
          while (true)
          {
            localRandomAccessFile.close();
            return;
            jdMethod_if(localRandomAccessFile, 48000 + paramInt);
          }
        }
      }
      catch (Exception localException)
      {
      }
    }
  }

  private void jdMethod_do(StringBuffer paramStringBuffer)
  {
    if ((!this.kc) || (this.kj == null))
      return;
    jdMethod_if(this.kj, paramStringBuffer, e(2));
  }

  private String e(int paramInt)
  {
    String str = jdMethod_void(paramInt);
    if (str == null);
    do
    {
      return null;
      if (paramInt == 2)
        return str + File.separator + "lbacz.dat";
    }
    while (paramInt != 1);
    return str + File.separator + "lmibacz.dat";
  }

  private void jdMethod_if(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    try
    {
      paramRandomAccessFile.seek(0L);
      paramRandomAccessFile.writeInt(3321);
      paramRandomAccessFile.writeLong(System.currentTimeMillis());
      paramRandomAccessFile.writeInt(paramInt);
      paramRandomAccessFile.writeInt(3321);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void jdMethod_if(StringBuffer paramStringBuffer)
  {
    if ((!this.ke) || (this.kl == null))
      return;
    jdMethod_if(this.kl, paramStringBuffer, e(1));
  }

  // ERROR //
  private void jdMethod_if(StringBuffer paramStringBuffer, File paramFile)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_2
    //   3: invokevirtual 150	java/io/File:exists	()Z
    //   6: ifne +4 -> 10
    //   9: return
    //   10: new 262	java/util/zip/GZIPOutputStream
    //   13: dup
    //   14: new 264	java/io/BufferedOutputStream
    //   17: dup
    //   18: new 266	java/io/FileOutputStream
    //   21: dup
    //   22: aload_2
    //   23: iconst_1
    //   24: invokespecial 269	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   27: invokespecial 272	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: invokespecial 273	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   33: astore 4
    //   35: iconst_0
    //   36: istore 5
    //   38: iload 5
    //   40: iconst_3
    //   41: if_icmpge +19 -> 60
    //   44: aload 4
    //   46: aload_1
    //   47: invokevirtual 274	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   50: invokevirtual 278	java/lang/String:getBytes	()[B
    //   53: invokevirtual 282	java/util/zip/GZIPOutputStream:write	([B)V
    //   56: iload_3
    //   57: ifeq +19 -> 76
    //   60: aload 4
    //   62: invokevirtual 283	java/util/zip/GZIPOutputStream:close	()V
    //   65: return
    //   66: astore 6
    //   68: return
    //   69: astore 7
    //   71: iconst_0
    //   72: istore_3
    //   73: goto -17 -> 56
    //   76: iinc 5 1
    //   79: goto -41 -> 38
    //
    // Exception table:
    //   from	to	target	type
    //   10	35	66	java/lang/Exception
    //   60	65	66	java/lang/Exception
    //   44	56	69	java/lang/Exception
  }

  private void jdMethod_if(StringBuffer paramStringBuffer1, StringBuffer paramStringBuffer2, String paramString)
  {
    if (paramStringBuffer1.length() + paramStringBuffer2.length() < 8190)
    {
      paramStringBuffer1.append(paramStringBuffer2);
      return;
    }
    File localFile = new File(paramString);
    d(paramStringBuffer1.length());
    jdMethod_if(paramStringBuffer1, localFile);
    this.kh = true;
    paramStringBuffer1.delete(0, paramStringBuffer1.length());
    paramStringBuffer1.append(paramStringBuffer2);
  }

  private boolean jdMethod_if(File paramFile)
  {
    try
    {
      paramFile.createNewFile();
      StringBuffer localStringBuffer = new StringBuffer(256);
      localStringBuffer.append("C");
      localStringBuffer.append("\t");
      localStringBuffer.append(Jni.i(az.cn().cl()));
      localStringBuffer.append("\n");
      jdMethod_if(localStringBuffer, paramFile);
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private boolean jdMethod_if(File paramFile, int paramInt)
  {
    String str;
    if (paramInt == 2)
      str = cN();
    while (str == null)
    {
      return false;
      str = null;
      if (paramInt == 1)
        str = cH();
    }
    return paramFile.renameTo(new File(str));
  }

  // ERROR //
  private boolean jdMethod_long(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokespecial 250	com/baidu/location/ad:e	(I)Ljava/lang/String;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnonnull +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: iload_1
    //   13: iconst_2
    //   14: if_icmpne +70 -> 84
    //   17: new 129	java/io/File
    //   20: dup
    //   21: aload_2
    //   22: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore_3
    //   26: aload_3
    //   27: invokevirtual 150	java/io/File:exists	()Z
    //   30: ifeq +23 -> 53
    //   33: aload_3
    //   34: invokevirtual 334	java/io/File:length	()J
    //   37: ldc2_w 335
    //   40: lcmp
    //   41: ifle +41 -> 82
    //   44: aload_0
    //   45: aload_3
    //   46: iload_1
    //   47: invokespecial 338	com/baidu/location/ad:if	(Ljava/io/File;I)Z
    //   50: ifeq -40 -> 10
    //   53: new 129	java/io/File
    //   56: dup
    //   57: aload_2
    //   58: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   61: astore 4
    //   63: aload 4
    //   65: invokevirtual 150	java/io/File:exists	()Z
    //   68: ifne -58 -> 10
    //   71: aload_0
    //   72: aload 4
    //   74: invokespecial 340	com/baidu/location/ad:if	(Ljava/io/File;)Z
    //   77: istore 6
    //   79: iload 6
    //   81: ireturn
    //   82: iconst_1
    //   83: ireturn
    //   84: iload_1
    //   85: iconst_1
    //   86: if_icmpne -76 -> 10
    //   89: aload_0
    //   90: invokespecial 342	com/baidu/location/ad:cQ	()Z
    //   93: ifeq -83 -> 10
    //   96: new 129	java/io/File
    //   99: dup
    //   100: aload_2
    //   101: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   104: astore 7
    //   106: aload 7
    //   108: invokevirtual 150	java/io/File:exists	()Z
    //   111: ifeq +25 -> 136
    //   114: aload 7
    //   116: invokevirtual 334	java/io/File:length	()J
    //   119: ldc2_w 335
    //   122: lcmp
    //   123: ifle +42 -> 165
    //   126: aload_0
    //   127: aload 7
    //   129: iload_1
    //   130: invokespecial 338	com/baidu/location/ad:if	(Ljava/io/File;I)Z
    //   133: ifeq -123 -> 10
    //   136: new 129	java/io/File
    //   139: dup
    //   140: aload_2
    //   141: invokespecial 146	java/io/File:<init>	(Ljava/lang/String;)V
    //   144: astore 8
    //   146: aload 8
    //   148: invokevirtual 150	java/io/File:exists	()Z
    //   151: ifne -141 -> 10
    //   154: aload_0
    //   155: aload 8
    //   157: invokespecial 340	com/baidu/location/ad:if	(Ljava/io/File;)Z
    //   160: istore 10
    //   162: iload 10
    //   164: ireturn
    //   165: iconst_1
    //   166: ireturn
    //   167: astore 5
    //   169: iconst_0
    //   170: ireturn
    //   171: astore 9
    //   173: iconst_0
    //   174: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   71	79	167	java/lang/Exception
    //   154	162	171	java/lang/Exception
  }

  private String jdMethod_void(int paramInt)
  {
    String str1 = c.jdMethod_else();
    String str2;
    if (str1 == null)
      str2 = null;
    while (true)
    {
      return str2;
      label44: File localFile;
      if (paramInt == 1)
      {
        str2 = str1 + File.separator + "llmis1";
        localFile = new File(str2);
        if (localFile.exists());
      }
      else
      {
        try
        {
          boolean bool = localFile.mkdirs();
          if (!bool)
          {
            return null;
            if (paramInt == 2)
            {
              str2 = str1 + File.separator + "llmis2";
              break label44;
            }
            return null;
          }
        }
        catch (Exception localException)
        {
        }
      }
    }
    return null;
  }

  public String cG()
  {
    int i = 0;
    String str1 = jdMethod_void(1);
    String[] arrayOfString = { "lmibaca.dat", "lmibacb.dat", "lmibacz.dat" };
    while (true)
    {
      try
      {
        int j = arrayOfString.length;
        if (i >= j)
          break;
        String str2 = arrayOfString[i];
        File localFile = new File(str1 + File.separator + str2);
        if (localFile.exists())
          if (localFile.length() > 92160L)
          {
            localFile.delete();
          }
          else if (localFile.length() >= 4096L)
          {
            if ((str2.equals("lmibacz.dat")) && (this.ke))
              return null;
            String str3 = str1 + File.separator + str2;
            return str3;
          }
      }
      catch (Exception localException)
      {
        return null;
      }
      i++;
    }
    return null;
  }

  public void cK()
  {
    this.kf.post(new ad.2(this));
  }

  public void cO()
  {
    this.ke = false;
    if (((this.kl != null) && (this.kl.length() > 3800)) || (this.kh))
    {
      File localFile = new File(e(1));
      d(this.kl.length());
      jdMethod_if(this.kl, localFile);
      this.kh = false;
    }
    this.kl = null;
    cL();
  }

  public void cP()
  {
    this.kc = false;
    if ((this.kj != null) && (this.kj.length() > 3800))
    {
      File localFile = new File(e(2));
      jdMethod_if(this.kj, localFile);
    }
    this.kj = null;
    cL();
  }

  public void jdMethod_goto(int paramInt)
  {
    if (this.ke);
    while (!jdMethod_long(1))
      return;
    StringBuffer localStringBuffer = new StringBuffer(128);
    this.ke = true;
    this.kl = new StringBuffer(8192);
    localStringBuffer.append("T1");
    localStringBuffer.append("\t");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("\n");
    jdMethod_if(localStringBuffer);
    cF();
    this.j6 = new ad.1(this);
    this.kf.postDelayed(this.j6, 8000L);
  }

  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
  }

  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i = paramSensorEvent.sensor.getType();
    StringBuffer localStringBuffer = new StringBuffer(256);
    if (i == 1)
    {
      this.ki = (1 + this.ki);
      localStringBuffer.append("A");
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[0]);
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[1]);
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[2]);
      if (this.ki == 1)
      {
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.timestamp);
      }
      if (this.ki >= 14)
        this.ki = 0;
      localStringBuffer.append("\n");
      jdMethod_do(localStringBuffer);
      jdMethod_if(localStringBuffer);
    }
    if (i == 2)
    {
      this.kb = (1 + this.kb);
      localStringBuffer.append("M");
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[0]);
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[1]);
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[2]);
      if (this.kb == 1)
      {
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.timestamp);
      }
      if (this.kb > 13)
        this.kb = 0;
      localStringBuffer.append("\n");
      jdMethod_do(localStringBuffer);
    }
  }

  class a
  {
    StringBuffer jdField_do = null;
    public boolean jdField_if = false;

    a()
    {
    }

    public void a()
    {
    }

    public void jdField_do()
    {
    }

    public void jdField_if()
    {
    }
  }

  class b
  {
    public b()
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.ad
 * JD-Core Version:    0.6.2
 */