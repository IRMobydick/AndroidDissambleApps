package com.ubercab.library.location.model;

public final class UberLocationRequest
{
  private static final long DEFAULT_FASTEST_INTERVAL = 600000L;
  private static final long DEFAULT_INTERVAL = 3600000L;
  public static final int PRIORITY_BALANCED_POWER_ACCURACY = 0;
  public static final int PRIORITY_HIGH_ACCURACY = 1;
  public static final int PRIORITY_LOW_POWER = 2;
  public static final int PRIORITY_NO_POWER = 3;
  private long mFastestInterval = 600000L;
  private long mInterval = 3600000L;
  private int mPriority = 0;

  public static UberLocationRequest create()
  {
    return new UberLocationRequest();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    UberLocationRequest localUberLocationRequest;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localUberLocationRequest = (UberLocationRequest)paramObject;
      if (this.mFastestInterval != localUberLocationRequest.mFastestInterval)
        return false;
      if (this.mInterval != localUberLocationRequest.mInterval)
        return false;
    }
    while (this.mPriority == localUberLocationRequest.mPriority);
    return false;
  }

  public long getFastestInterval()
  {
    return this.mFastestInterval;
  }

  public long getInterval()
  {
    return this.mInterval;
  }

  public int getPriority()
  {
    return this.mPriority;
  }

  public int hashCode()
  {
    return 31 * (31 * (int)(this.mFastestInterval ^ this.mFastestInterval >>> 32) + (int)(this.mInterval ^ this.mInterval >>> 32)) + this.mPriority;
  }

  public UberLocationRequest setFastestInterval(long paramLong)
  {
    this.mFastestInterval = paramLong;
    return this;
  }

  public UberLocationRequest setInterval(long paramLong)
  {
    this.mInterval = paramLong;
    return this;
  }

  public UberLocationRequest setPriority(int paramInt)
  {
    this.mPriority = paramInt;
    return this;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.location.model.UberLocationRequest
 * JD-Core Version:    0.6.2
 */