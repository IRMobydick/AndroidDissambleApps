package com.ubercab.client.core.model;

public class Surge extends Fare
{
  public static final float DEFAULT_MULTIPLIER = 1.0F;
  public static final String SURGE_SCREEN_TYPE_SOBRIETY = "sobriety";
  DropNotification dropNotification;
  Long expirationTime;
  Long fareId;
  Boolean forceFareEstimate;
  Float multiplier;
  String screenType;
  Boolean showRates;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Surge localSurge;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      if (!super.equals(paramObject))
        return false;
      localSurge = (Surge)paramObject;
      if (this.dropNotification != null)
      {
        if (this.dropNotification.equals(localSurge.dropNotification));
      }
      else
        while (localSurge.dropNotification != null)
          return false;
      if (this.expirationTime != null)
      {
        if (this.expirationTime.equals(localSurge.expirationTime));
      }
      else
        while (localSurge.expirationTime != null)
          return false;
      if (this.fareId != null)
      {
        if (this.fareId.equals(localSurge.fareId));
      }
      else
        while (localSurge.fareId != null)
          return false;
      if (this.forceFareEstimate != null)
      {
        if (this.forceFareEstimate.equals(localSurge.forceFareEstimate));
      }
      else
        while (localSurge.forceFareEstimate != null)
          return false;
      if (this.multiplier != null)
      {
        if (this.multiplier.equals(localSurge.multiplier));
      }
      else
        while (localSurge.multiplier != null)
          return false;
      if (this.screenType != null)
      {
        if (this.screenType.equals(localSurge.screenType));
      }
      else
        while (localSurge.screenType != null)
          return false;
      if (this.showRates == null)
        break;
    }
    while (this.showRates.equals(localSurge.showRates));
    while (true)
    {
      return false;
      if (localSurge.showRates == null)
        break;
    }
  }

  public DropNotification getDropNotification()
  {
    return this.dropNotification;
  }

  public long getExpirationTime()
  {
    if (this.expirationTime == null)
      return 0L;
    return this.expirationTime.longValue();
  }

  public long getFareId()
  {
    if (this.fareId == null)
      return 0L;
    return this.fareId.longValue();
  }

  public float getMultiplier()
  {
    if (this.multiplier == null)
      return 1.0F;
    return this.multiplier.floatValue();
  }

  public String getScreenType()
  {
    return this.screenType;
  }

  public int hashCode()
  {
    int i = 31 * super.hashCode();
    int j;
    int m;
    label46: int i1;
    label71: int i3;
    label97: int i5;
    label123: int i6;
    if (this.showRates != null)
    {
      j = this.showRates.hashCode();
      int k = 31 * (i + j);
      if (this.forceFareEstimate == null)
        break label193;
      m = this.forceFareEstimate.hashCode();
      int n = 31 * (k + m);
      if (this.fareId == null)
        break label199;
      i1 = this.fareId.hashCode();
      int i2 = 31 * (n + i1);
      if (this.expirationTime == null)
        break label205;
      i3 = this.expirationTime.hashCode();
      int i4 = 31 * (i2 + i3);
      if (this.multiplier == null)
        break label211;
      i5 = this.multiplier.hashCode();
      i6 = 31 * (i4 + i5);
      if (this.screenType == null)
        break label217;
    }
    label193: label199: label205: label211: label217: for (int i7 = this.screenType.hashCode(); ; i7 = 0)
    {
      int i8 = 31 * (i6 + i7);
      DropNotification localDropNotification = this.dropNotification;
      int i9 = 0;
      if (localDropNotification != null)
        i9 = this.dropNotification.hashCode();
      return i8 + i9;
      j = 0;
      break;
      m = 0;
      break label46;
      i1 = 0;
      break label71;
      i3 = 0;
      break label97;
      i5 = 0;
      break label123;
    }
  }

  public boolean isForceFareEstimate()
  {
    if (this.forceFareEstimate == null)
      return false;
    return this.forceFareEstimate.booleanValue();
  }

  public boolean isShowRates()
  {
    if (this.showRates == null)
      return false;
    return this.showRates.booleanValue();
  }

  public void setDropNotification(DropNotification paramDropNotification)
  {
    this.dropNotification = paramDropNotification;
  }

  public void setExpirationTime(long paramLong)
  {
    this.expirationTime = Long.valueOf(paramLong);
  }

  public void setFareId(long paramLong)
  {
    this.fareId = Long.valueOf(paramLong);
  }

  public void setForceFareEstimate(boolean paramBoolean)
  {
    this.forceFareEstimate = Boolean.valueOf(paramBoolean);
  }

  public void setMultiplier(float paramFloat)
  {
    this.multiplier = Float.valueOf(paramFloat);
  }

  public void setScreenType(String paramString)
  {
    this.screenType = paramString;
  }

  public void setShowRates(boolean paramBoolean)
  {
    this.showRates = Boolean.valueOf(paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.Surge
 * JD-Core Version:    0.6.2
 */