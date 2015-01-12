package com.baidu.location;

class Jni
  implements ax, n
{
  private static int e7;
  private static int e8;
  private static int e9;
  private static int fa;
  private static int fb;
  private static boolean fc;
  private static int fd;
  private static int fe;
  private static int ff = 0;

  static
  {
    fd = 1;
    fe = 2;
    fa = 11;
    fb = 12;
    e8 = 13;
    e7 = 14;
    e9 = 1024;
    fc = false;
    try
    {
      System.loadLibrary("locSDK4d");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      fc = true;
    }
    throw new IllegalStateException("no found the liblocSDK4d.so file, please correct settings");
  }

  private static native String a(byte[] paramArrayOfByte, int paramInt);

  private static native String b(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2);

  private static native String c(byte[] paramArrayOfByte, int paramInt);

  private static native void f(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

  private static native String g(byte[] paramArrayOfByte);

  public static String i(String paramString)
  {
    if (fc)
      return "err!";
    return l(paramString) + "|tp=3";
  }

  public static double[] jdMethod_if(double paramDouble1, double paramDouble2, String paramString)
  {
    double[] arrayOfDouble = { 0.0D, 0.0D };
    if (fc)
      return arrayOfDouble;
    int i = -1;
    if (paramString.equals("bd09"))
      i = ff;
    try
    {
      while (true)
      {
        String[] arrayOfString = b(paramDouble1, paramDouble2, i, 132456).split(":");
        arrayOfDouble[0] = Double.parseDouble(arrayOfString[0]);
        arrayOfDouble[1] = Double.parseDouble(arrayOfString[1]);
        label78: return arrayOfDouble;
        if (paramString.equals("bd09ll"))
          i = fd;
        else if (paramString.equals("gcj02"))
          i = fe;
        else if (paramString.equals("gps2gcj"))
          i = fa;
        else if (paramString.equals("bd092gcj"))
          i = fb;
        else if (paramString.equals("bd09ll2gcj"))
          i = e8;
      }
    }
    catch (Exception localException)
    {
      break label78;
    }
  }

  public static void jdMethod_int(String paramString1, String paramString2)
  {
    try
    {
      f(paramString1.getBytes(), paramString2.getBytes());
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static String j(String paramString)
  {
    if (fc)
      return "err!";
    return c(paramString.getBytes(), 132456);
  }

  public static String k(String paramString)
  {
    try
    {
      String str = g(paramString.getBytes());
      if (str == null);
      while ((str.length() < 2) || ("no".equals(str)))
        return null;
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String l(String paramString)
  {
    int i = 740;
    int j = 0;
    if (fc)
      return "err!";
    byte[] arrayOfByte1 = paramString.getBytes();
    byte[] arrayOfByte2 = new byte[e9];
    int k = arrayOfByte1.length;
    if (k > i);
    while (true)
    {
      int m = 0;
      while (j < i)
      {
        if (arrayOfByte1[j] != 0)
        {
          arrayOfByte2[m] = arrayOfByte1[j];
          m++;
        }
        j++;
      }
      return a(arrayOfByte2, 132456);
      i = k;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.Jni
 * JD-Core Version:    0.6.2
 */