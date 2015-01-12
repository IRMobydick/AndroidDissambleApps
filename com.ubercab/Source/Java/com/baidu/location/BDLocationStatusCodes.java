package com.baidu.location;

public final class BDLocationStatusCodes
{
  public static final int ERROR = 1;
  public static final int GEOFENCE_NOT_AVAIABLE = 1000;
  public static final int GEOFENCE_SERVICE_NO_ALIVIABLE = 1002;
  public static final int GEOFENCE_TOO_MANY_GEOFENCES = 1001;
  public static final int SUCCESS;

  public static int getStatusCode(int paramInt)
  {
    if (((paramInt >= 0) && (paramInt <= 1)) || ((1000 <= paramInt) && (paramInt <= 1002)))
      return paramInt;
    return 1;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.BDLocationStatusCodes
 * JD-Core Version:    0.6.2
 */