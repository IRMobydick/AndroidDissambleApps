package com.baidu.location;

import android.net.wifi.ScanResult;
import android.os.Environment;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class am
  implements ax, n
{
  private static am hE;
  private static String[] hF;
  private static final String hG = "loc_cache.dat";
  private static final String hH = ";";
  private static final String hJ = ",";
  private static final int hK = 5;
  private static final double hL = 121.31399999999999D;
  private String[] hI = null;

  private double bJ()
  {
    double d = 0.0D;
    if ((this.hI != null) && (this.hI.length > 2))
      d = Double.valueOf(this.hI[2]).doubleValue();
    return d;
  }

  private double bK()
  {
    double d = 0.0D;
    if ((this.hI != null) && (this.hI.length > 1))
      d = Double.valueOf(this.hI[1]).doubleValue() - 121.31399999999999D;
    return d;
  }

  private long bL()
  {
    long l = 0L;
    if ((this.hI != null) && (this.hI.length >= 3))
      l = Long.valueOf(this.hI[3]).longValue();
    return l;
  }

  private boolean bM()
  {
    boolean bool = true;
    t.a locala = t.an().ak();
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(locala.jdField_do);
    arrayOfObject[bool] = Integer.valueOf(locala.jdField_if);
    arrayOfObject[2] = Integer.valueOf(locala.jdField_for);
    arrayOfObject[3] = Integer.valueOf(locala.jdField_try);
    String str1 = String.format("%s|%s|%s|%s", arrayOfObject);
    String str2 = hF[bool];
    if ((TextUtils.isEmpty(hF[bool])) || (!str2.equals(str1)))
      bool = false;
    return bool;
  }

  private void bO()
  {
    if ((this.hI == null) && (hF != null))
    {
      String str = hF[0];
      if (!TextUtils.isEmpty(str))
        this.hI = str.split(",");
    }
  }

  private double bP()
  {
    double d = 0.0D;
    if ((this.hI != null) && (this.hI.length > 0))
      d = Double.valueOf(this.hI[0]).doubleValue() - 121.31399999999999D;
    return d;
  }

  public static am bQ()
  {
    if (hE == null)
      hE = new am();
    return hE;
  }

  public a bN()
  {
    boolean bool1 = "mounted".equals(Environment.getExternalStorageState());
    byte[] arrayOfByte1 = null;
    FileInputStream localFileInputStream;
    ByteArrayOutputStream localByteArrayOutputStream;
    if (bool1)
    {
      File localFile = new File(I + File.separator + "loc_cache.dat");
      boolean bool2 = localFile.exists();
      arrayOfByte1 = null;
      if (bool2)
        try
        {
          localFileInputStream = new FileInputStream(localFile);
          byte[] arrayOfByte2 = new byte[''];
          localByteArrayOutputStream = new ByteArrayOutputStream();
          while (true)
          {
            int i = localFileInputStream.read(arrayOfByte2);
            if (i == -1)
              break;
            localByteArrayOutputStream.write(arrayOfByte2, 0, i);
          }
        }
        catch (Exception localException)
        {
        }
    }
    while (true)
    {
      hF = new String(arrayOfByte1).split(";");
      bO();
      a locala = new a();
      locala.jdField_int = bP();
      locala.jdField_try = bK();
      locala.jdField_if = bJ();
      locala.jdField_for = bM();
      locala.jdField_do = bR();
      locala.jdField_new = bL();
      return locala;
      arrayOfByte1 = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      localFileInputStream.close();
    }
  }

  public int bR()
  {
    if (hF[2] != null);
    for (String[] arrayOfString = hF[2].split(","); ; arrayOfString = null)
    {
      ar.b localb = ar.bW().bS();
      int i = 0;
      int j;
      int k;
      int n;
      if (localb != null)
      {
        List localList = localb.jdField_for;
        i = 0;
        if (localList != null)
        {
          j = 0;
          k = 0;
          if (j < 5)
          {
            ScanResult localScanResult = (ScanResult)localList.get(j);
            if (localScanResult == null)
              break label139;
            String str = localScanResult.BSSID.replace(":", "");
            n = 0;
            label93: if (n >= arrayOfString.length)
              break label139;
            if (!str.equals(arrayOfString[n]));
          }
        }
      }
      label139: for (int m = k + 1; ; m = k)
      {
        j++;
        k = m;
        break;
        n++;
        break label93;
        i = k;
        return i;
      }
    }
  }

  public void jdMethod_new(BDLocation paramBDLocation)
  {
    int i = 0;
    if (paramBDLocation.getLocType() != 161)
      return;
    Object[] arrayOfObject1 = new Object[4];
    arrayOfObject1[0] = Double.valueOf(121.31399999999999D + paramBDLocation.getLongitude());
    arrayOfObject1[1] = Double.valueOf(121.31399999999999D + paramBDLocation.getLatitude());
    arrayOfObject1[2] = Float.valueOf(paramBDLocation.getRadius());
    arrayOfObject1[3] = Long.valueOf(System.currentTimeMillis());
    String str1 = String.format("%s,%s,%s,%d", arrayOfObject1);
    t.a locala = t.an().ak();
    Object[] arrayOfObject2;
    if (locala.jdMethod_for())
    {
      arrayOfObject2 = new Object[4];
      arrayOfObject2[0] = Integer.valueOf(locala.jdField_do);
      arrayOfObject2[1] = Integer.valueOf(locala.jdField_if);
      arrayOfObject2[2] = Integer.valueOf(locala.jdField_for);
      arrayOfObject2[3] = Integer.valueOf(locala.jdField_try);
    }
    for (String str2 = String.format("%s|%s|%s|%s", arrayOfObject2); ; str2 = null)
    {
      ar.b localb = ar.bW().bS();
      String str3 = null;
      if (localb != null)
      {
        List localList = localb.jdField_for;
        str3 = null;
        if (localList != null)
        {
          ArrayList localArrayList = new ArrayList();
          while (i < 5)
          {
            ScanResult localScanResult = (ScanResult)localList.get(i);
            if (localScanResult != null)
              localArrayList.add(localScanResult.BSSID.replace(":", ""));
            i++;
          }
          str3 = TextUtils.join(",", localArrayList);
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1).append(";").append(str2).append(";").append(str3);
      String str4 = localStringBuilder.toString();
      if (!"mounted".equals(Environment.getExternalStorageState()))
        break;
      File localFile1 = new File(I + File.separator + "loc_cache.dat");
      File localFile2 = localFile1.getParentFile();
      if (!localFile2.exists())
        localFile2.mkdirs();
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(localFile1);
        localFileOutputStream.write(str4.getBytes());
        localFileOutputStream.close();
        return;
      }
      catch (Exception localException)
      {
        return;
      }
    }
  }

  public class a
  {
    public int jdField_do;
    public boolean jdField_for;
    public double jdField_if;
    public double jdField_int;
    public long jdField_new;
    public double jdField_try;

    public a()
    {
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.am
 * JD-Core Version:    0.6.2
 */