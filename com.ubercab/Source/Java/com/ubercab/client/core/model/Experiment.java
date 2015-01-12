package com.ubercab.client.core.model;

public final class Experiment
{
  public static final String KEY_AMEX_REWARDS = "amex_rewards";
  public static final String KEY_DESTINATION_HIGHLIGHT_ON_DISPATCH = "destination_not_set_highlight";
  private String treatment_group_name;
  private Integer treatment_group_serial;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Experiment localExperiment;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localExperiment = (Experiment)paramObject;
      if (this.treatment_group_name != null)
      {
        if (this.treatment_group_name.equals(localExperiment.treatment_group_name));
      }
      else
        while (localExperiment.treatment_group_name != null)
          return false;
      if (this.treatment_group_serial == null)
        break;
    }
    while (this.treatment_group_serial.equals(localExperiment.treatment_group_serial));
    while (true)
    {
      return false;
      if (localExperiment.treatment_group_serial == null)
        break;
    }
  }

  public String getGroupName()
  {
    return this.treatment_group_name;
  }

  public int getGroupSerial()
  {
    if (this.treatment_group_serial == null)
      return 0;
    return this.treatment_group_serial.intValue();
  }

  public int hashCode()
  {
    if (this.treatment_group_name != null);
    for (int i = this.treatment_group_name.hashCode(); ; i = 0)
    {
      int j = i * 31;
      Integer localInteger = this.treatment_group_serial;
      int k = 0;
      if (localInteger != null)
        k = this.treatment_group_serial.hashCode();
      return j + k;
    }
  }

  public void setGroupSerial(int paramInt)
  {
    this.treatment_group_serial = Integer.valueOf(paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.Experiment
 * JD-Core Version:    0.6.2
 */