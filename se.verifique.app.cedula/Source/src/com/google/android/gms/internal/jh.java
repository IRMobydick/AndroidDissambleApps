package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class jh
  implements SafeParcelable
{
  public static final mo a = new mo();
  private final int b;
  private final String c;
  private final long d;
  private final short e;
  private final double f;
  private final double g;
  private final float h;
  private final int i;
  private final int j;
  private final int k;

  public jh(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    a(paramString);
    a(paramFloat);
    a(paramDouble1, paramDouble2);
    int m = a(paramInt2);
    this.b = paramInt1;
    this.e = paramShort;
    this.c = paramString;
    this.f = paramDouble1;
    this.g = paramDouble2;
    this.h = paramFloat;
    this.d = paramLong;
    this.i = m;
    this.j = paramInt3;
    this.k = paramInt4;
  }

  private static int a(int paramInt)
  {
    int m = paramInt & 0x7;
    if (m == 0)
      throw new IllegalArgumentException("No supported transition specified: " + paramInt);
    return m;
  }

  private static void a(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D))
      throw new IllegalArgumentException("invalid latitude: " + paramDouble1);
    if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D))
      throw new IllegalArgumentException("invalid longitude: " + paramDouble2);
  }

  private static void a(float paramFloat)
  {
    if (paramFloat <= 0.0F)
      throw new IllegalArgumentException("invalid radius: " + paramFloat);
  }

  private static void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 100))
      throw new IllegalArgumentException("requestId is null or too long: " + paramString);
  }

  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 1:
    }
    for (String str = null; ; str = "CIRCLE")
      return str;
  }

  public int a()
  {
    return this.b;
  }

  public short b()
  {
    return this.e;
  }

  public double c()
  {
    return this.f;
  }

  public double d()
  {
    return this.g;
  }

  public int describeContents()
  {
    return 0;
  }

  public float e()
  {
    return this.h;
  }

  public boolean equals(Object paramObject)
  {
    int m = 1;
    if (this == paramObject);
    while (true)
    {
      return m;
      if (paramObject == null)
      {
        m = 0;
        continue;
      }
      if (!(paramObject instanceof jh))
      {
        m = 0;
        continue;
      }
      jh localjh = (jh)paramObject;
      if (this.h != localjh.h)
      {
        m = 0;
        continue;
      }
      if (this.f != localjh.f)
      {
        m = 0;
        continue;
      }
      if (this.g != localjh.g)
      {
        m = 0;
        continue;
      }
      if (this.e == localjh.e)
        continue;
      m = 0;
    }
  }

  public String f()
  {
    return this.c;
  }

  public long g()
  {
    return this.d;
  }

  public int h()
  {
    return this.i;
  }

  public int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.f);
    int m = 31 + (int)(l1 ^ l1 >>> 32);
    long l2 = Double.doubleToLongBits(this.g);
    return 31 * (31 * (31 * (m * 31 + (int)(l2 ^ l2 >>> 32)) + Float.floatToIntBits(this.h)) + this.e) + this.i;
  }

  public int i()
  {
    return this.j;
  }

  public int j()
  {
    return this.k;
  }

  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = b(this.e);
    arrayOfObject[1] = this.c;
    arrayOfObject[2] = Integer.valueOf(this.i);
    arrayOfObject[3] = Double.valueOf(this.f);
    arrayOfObject[4] = Double.valueOf(this.g);
    arrayOfObject[5] = Float.valueOf(this.h);
    arrayOfObject[6] = Integer.valueOf(this.j / 1000);
    arrayOfObject[7] = Integer.valueOf(this.k);
    arrayOfObject[8] = Long.valueOf(this.d);
    return String.format(localLocale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mo.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jh
 * JD-Core Version:    0.6.0
 */