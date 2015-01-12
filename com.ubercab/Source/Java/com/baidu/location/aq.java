package com.baidu.location;

import android.text.TextUtils;

public class aq
  implements BDGeofence
{
  private static final String jdField_byte = "Administrative";
  private static final int jdField_case = 2;
  private static final int d = 100;
  private static final int e = 2;
  private static final int jdField_else = 1;
  private static final String jdField_for = "Circle";
  private static final int i = 3;
  public static final int jdField_int = 1;
  private static final long jdField_void = 2592000L;
  private final int a;
  private float b;
  private final int c;
  private boolean jdField_char;
  private final String jdField_do;
  private boolean f;
  protected int g;
  private final double jdField_goto;
  private long h;
  private boolean jdField_if;
  private final long jdField_long;
  private final String jdField_new;
  private final double jdField_try;

  public aq(int paramInt1, String paramString1, double paramDouble1, double paramDouble2, int paramInt2, long paramLong, String paramString2)
  {
    jdField_do(paramInt2);
    jdField_if(paramString1);
    a(paramDouble1, paramDouble2);
    a(paramString2);
    jdField_if(paramLong);
    this.c = paramInt1;
    this.jdField_do = paramString1;
    this.jdField_goto = paramDouble1;
    this.jdField_try = paramDouble2;
    this.a = paramInt2;
    this.jdField_long = paramLong;
    this.jdField_new = paramString2;
  }

  public aq(String paramString1, double paramDouble1, double paramDouble2, int paramInt, long paramLong, String paramString2)
  {
    this(1, paramString1, paramDouble2, paramDouble1, paramInt, paramLong, paramString2);
  }

  private static void a(double paramDouble1, double paramDouble2)
  {
  }

  private static void a(String paramString)
  {
    if ((!paramString.equals("bd09")) && (!paramString.equals("bd09ll")) && (!paramString.equals("gcj02")))
      throw new IllegalArgumentException("invalid coord type: " + paramString);
  }

  private static void jdField_do(int paramInt)
  {
    if (paramInt != 1)
      throw new IllegalArgumentException("invalid radius type: " + paramInt);
  }

  private static String jdField_if(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return "Circle";
    case 2:
    }
    return "Administrative";
  }

  private static void jdField_if(long paramLong)
  {
    if (paramLong / 1000.0D > 2592000.0D)
      throw new IllegalArgumentException("invalid druationMillis :" + paramLong);
  }

  private static void jdField_if(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() > 100))
      throw new IllegalArgumentException("Geofence name is null or too long: " + paramString);
  }

  public double a()
  {
    return this.jdField_try;
  }

  public void a(float paramFloat)
  {
    this.b = paramFloat;
  }

  protected void a(int paramInt)
  {
    this.g = paramInt;
  }

  public void a(long paramLong)
  {
    this.h = paramLong;
  }

  public void a(boolean paramBoolean)
  {
    this.jdField_if = paramBoolean;
  }

  public boolean jdField_byte()
  {
    return this.f;
  }

  public double jdField_case()
  {
    return this.jdField_goto;
  }

  public int jdField_char()
  {
    if (this.jdField_char)
      return 1;
    if (this.jdField_if)
      return 2;
    return 3;
  }

  public float jdField_do()
  {
    return this.b;
  }

  public void jdField_do(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public long jdField_else()
  {
    return this.h;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    aq localaq;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (!(paramObject instanceof aq))
        return false;
      localaq = (aq)paramObject;
      if (this.a != localaq.a)
        return false;
      if (this.jdField_goto != localaq.jdField_goto)
        return false;
      if (this.jdField_try != localaq.jdField_try)
        return false;
      if (this.c != localaq.c)
        return false;
    }
    while (this.jdField_new == localaq.jdField_new);
    return false;
  }

  public boolean jdField_for()
  {
    return this.jdField_char;
  }

  public String getGeofenceId()
  {
    return this.jdField_do;
  }

  public long jdField_goto()
  {
    return this.jdField_long;
  }

  public void jdField_if(boolean paramBoolean)
  {
    this.jdField_char = paramBoolean;
  }

  public boolean jdField_if()
  {
    return this.jdField_if;
  }

  public String jdField_int()
  {
    return this.jdField_new;
  }

  public int jdField_new()
  {
    return this.a;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = jdField_if(this.c);
    arrayOfObject[1] = this.jdField_do;
    arrayOfObject[2] = Double.valueOf(this.jdField_goto);
    arrayOfObject[3] = Double.valueOf(this.jdField_try);
    arrayOfObject[4] = Float.valueOf(this.b);
    arrayOfObject[5] = Long.valueOf(this.jdField_long);
    arrayOfObject[6] = this.jdField_new;
    arrayOfObject[7] = Integer.valueOf(jdField_char());
    return String.format("Geofence[Type:%s, Name:%s, latitude:%.6f, longitude:%.6f, radius:%.0f, expriation:%d, coordType:%s, fenceType:%d]", arrayOfObject);
  }

  protected int jdField_try()
  {
    return this.g;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.aq
 * JD-Core Version:    0.6.2
 */