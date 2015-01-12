package com.ubercab.client.core.model;

public final class AddFundsDefaultValues
{
  Integer denomination1;
  Integer denomination2;
  Integer denomination3;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AddFundsDefaultValues localAddFundsDefaultValues;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localAddFundsDefaultValues = (AddFundsDefaultValues)paramObject;
      if (this.denomination1 != null)
      {
        if (this.denomination1.equals(localAddFundsDefaultValues.denomination1));
      }
      else
        while (localAddFundsDefaultValues.denomination1 != null)
          return false;
      if (this.denomination2 != null)
      {
        if (this.denomination2.equals(localAddFundsDefaultValues.denomination2));
      }
      else
        while (localAddFundsDefaultValues.denomination2 != null)
          return false;
      if (this.denomination3 == null)
        break;
    }
    while (this.denomination3.equals(localAddFundsDefaultValues.denomination3));
    while (true)
    {
      return false;
      if (localAddFundsDefaultValues.denomination3 == null)
        break;
    }
  }

  public int getDenomination1()
  {
    if (this.denomination1 != null)
      return this.denomination1.intValue();
    return 0;
  }

  public int getDenomination2()
  {
    if (this.denomination2 != null)
      return this.denomination2.intValue();
    return 0;
  }

  public int getDenomination3()
  {
    if (this.denomination3 != null)
      return this.denomination3.intValue();
    return 0;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.denomination1 != null)
    {
      i = this.denomination1.hashCode();
      j = i * 31;
      if (this.denomination2 == null)
        break label77;
    }
    label77: for (int k = this.denomination2.hashCode(); ; k = 0)
    {
      int m = 31 * (j + k);
      Integer localInteger = this.denomination3;
      int n = 0;
      if (localInteger != null)
        n = this.denomination3.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.AddFundsDefaultValues
 * JD-Core Version:    0.6.2
 */