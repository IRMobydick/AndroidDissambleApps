package com.ubercab.client.core.model;

public final class DropNotification
{
  private Double defaultExpirationTime;
  private Boolean enabled;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    DropNotification localDropNotification;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localDropNotification = (DropNotification)paramObject;
      if (this.defaultExpirationTime != null)
      {
        if (this.defaultExpirationTime.equals(localDropNotification.defaultExpirationTime));
      }
      else
        while (localDropNotification.defaultExpirationTime != null)
          return false;
      if (this.enabled == null)
        break;
    }
    while (this.enabled.equals(localDropNotification.enabled));
    while (true)
    {
      return false;
      if (localDropNotification.enabled == null)
        break;
    }
  }

  public double getDefaultExpirationTime()
  {
    if (this.defaultExpirationTime == null)
      return 0.0D;
    return this.defaultExpirationTime.doubleValue();
  }

  public double getDefaultExpirationTimeInMinutes()
  {
    return getDefaultExpirationTime() / 60.0D;
  }

  public int hashCode()
  {
    if (this.enabled != null);
    for (int i = this.enabled.hashCode(); ; i = 0)
    {
      int j = i * 31;
      Double localDouble = this.defaultExpirationTime;
      int k = 0;
      if (localDouble != null)
        k = this.defaultExpirationTime.hashCode();
      return j + k;
    }
  }

  public boolean isEnabled()
  {
    if (this.enabled == null)
      return false;
    return this.enabled.booleanValue();
  }

  public void setDefaultExpirationTime(double paramDouble)
  {
    this.defaultExpirationTime = Double.valueOf(paramDouble);
  }

  public void setEnabled(boolean paramBoolean)
  {
    this.enabled = Boolean.valueOf(paramBoolean);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.DropNotification
 * JD-Core Version:    0.6.2
 */