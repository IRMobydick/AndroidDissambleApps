package com.baidu.location;

import android.text.TextUtils;

public abstract interface BDGeofence
{
  public static final String COORD_TYPE_BD09 = "bd09";
  public static final String COORD_TYPE_BD09LL = "bd09ll";
  public static final String COORD_TYPE_GCJ = "gcj02";
  public static final int GEOFENCE_TRANSITION_ENTER = 1;
  public static final int RADIUS_TYPE_SMALL = 1;

  public abstract String getGeofenceId();

  public static final class Builder
  {
    private int a;
    private String jdField_do = null;
    private double jdField_for;
    private long jdField_if = -9223372036854775808L;
    private String jdField_int;
    private boolean jdField_new = false;
    private double jdField_try;

    public BDGeofence build()
    {
      if (TextUtils.isEmpty(this.jdField_do))
        throw new IllegalArgumentException("BDGeofence name not set.");
      if (!this.jdField_new)
        throw new IllegalArgumentException("BDGeofence region not set.");
      if (this.jdField_if == -9223372036854775808L)
        throw new IllegalArgumentException("BDGeofence Expiration not set.");
      if (TextUtils.isEmpty(this.jdField_int))
        throw new IllegalArgumentException("BDGeofence CoordType not set.");
      return new aq(this.jdField_do, this.jdField_try, this.jdField_for, this.a, this.jdField_if, this.jdField_int);
    }

    public Builder setCircularRegion(double paramDouble1, double paramDouble2, int paramInt)
    {
      this.jdField_new = true;
      this.jdField_try = paramDouble1;
      this.jdField_for = paramDouble2;
      this.a = 1;
      return this;
    }

    public Builder setCoordType(String paramString)
    {
      this.jdField_int = paramString;
      return this;
    }

    public Builder setExpirationDruation(long paramLong)
    {
      if (paramLong < 0L)
      {
        this.jdField_if = -1L;
        return this;
      }
      this.jdField_if = paramLong;
      return this;
    }

    public Builder setGeofenceId(String paramString)
    {
      this.jdField_do = paramString;
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.BDGeofence
 * JD-Core Version:    0.6.2
 */