package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class mc
  implements SafeParcelable, Geofence
{
  public static final md CREATOR = new md();
  private final int BR;
  private final String XC;
  private final int aeh;
  private final short aej;
  private final double aek;
  private final double ael;
  private final float aem;
  private final int aen;
  private final int aeo;
  private final long afm;

  public mc(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    bY(paramString);
    b(paramFloat);
    a(paramDouble1, paramDouble2);
    int i = ek(paramInt2);
    this.BR = paramInt1;
    this.aej = paramShort;
    this.XC = paramString;
    this.aek = paramDouble1;
    this.ael = paramDouble2;
    this.aem = paramFloat;
    this.afm = paramLong;
    this.aeh = i;
    this.aen = paramInt3;
    this.aeo = paramInt4;
  }

  public mc(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
  {
    this(1, paramString, paramInt1, paramShort, paramDouble1, paramDouble2, paramFloat, paramLong, paramInt2, paramInt3);
  }

  private static void a(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D))
      throw new IllegalArgumentException("invalid latitude: " + paramDouble1);
    if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D))
      throw new IllegalArgumentException("invalid longitude: " + paramDouble2);
  }

  private static void b(float paramFloat)
  {
    if (paramFloat <= 0.0F)
      throw new IllegalArgumentException("invalid radius: " + paramFloat);
  }

  private static void bY(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 100))
      throw new IllegalArgumentException("requestId is null or too long: " + paramString);
  }

  private static int ek(int paramInt)
  {
    int i = paramInt & 0x7;
    if (i == 0)
      throw new IllegalArgumentException("No supported transition specified: " + paramInt);
    return i;
  }

  private static String el(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
    }
    return "CIRCLE";
  }

  public static mc h(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    mc localmc = CREATOR.cw(localParcel);
    localParcel.recycle();
    return localmc;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    mc localmc;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (!(paramObject instanceof mc))
        return false;
      localmc = (mc)paramObject;
      if (this.aem != localmc.aem)
        return false;
      if (this.aek != localmc.aek)
        return false;
      if (this.ael != localmc.ael)
        return false;
    }
    while (this.aej == localmc.aej);
    return false;
  }

  public long getExpirationTime()
  {
    return this.afm;
  }

  public double getLatitude()
  {
    return this.aek;
  }

  public double getLongitude()
  {
    return this.ael;
  }

  public int getNotificationResponsiveness()
  {
    return this.aen;
  }

  public String getRequestId()
  {
    return this.XC;
  }

  public int getVersionCode()
  {
    return this.BR;
  }

  public int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.aek);
    int i = 31 + (int)(l1 ^ l1 >>> 32);
    long l2 = Double.doubleToLongBits(this.ael);
    return 31 * (31 * (31 * (i * 31 + (int)(l2 ^ l2 >>> 32)) + Float.floatToIntBits(this.aem)) + this.aej) + this.aeh;
  }

  public short ma()
  {
    return this.aej;
  }

  public float mb()
  {
    return this.aem;
  }

  public int mc()
  {
    return this.aeh;
  }

  public int md()
  {
    return this.aeo;
  }

  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = el(this.aej);
    arrayOfObject[1] = this.XC;
    arrayOfObject[2] = Integer.valueOf(this.aeh);
    arrayOfObject[3] = Double.valueOf(this.aek);
    arrayOfObject[4] = Double.valueOf(this.ael);
    arrayOfObject[5] = Float.valueOf(this.aem);
    arrayOfObject[6] = Integer.valueOf(this.aen / 1000);
    arrayOfObject[7] = Integer.valueOf(this.aeo);
    arrayOfObject[8] = Long.valueOf(this.afm);
    return String.format(localLocale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    md.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mc
 * JD-Core Version:    0.6.2
 */