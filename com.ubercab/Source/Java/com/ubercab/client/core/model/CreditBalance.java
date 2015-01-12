package com.ubercab.client.core.model;

public final class CreditBalance
{
  private String amountString;
  private String displayName;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    CreditBalance localCreditBalance;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localCreditBalance = (CreditBalance)paramObject;
      if (this.amountString != null)
      {
        if (this.amountString.equals(localCreditBalance.amountString));
      }
      else
        while (localCreditBalance.amountString != null)
          return false;
      if (this.displayName == null)
        break;
    }
    while (this.displayName.equals(localCreditBalance.displayName));
    while (true)
    {
      return false;
      if (localCreditBalance.displayName == null)
        break;
    }
  }

  public String getAmountString()
  {
    return this.amountString;
  }

  public String getDisplayName()
  {
    return this.displayName;
  }

  public int hashCode()
  {
    if (this.amountString != null);
    for (int i = this.amountString.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.displayName;
      int k = 0;
      if (str != null)
        k = this.displayName.hashCode();
      return j + k;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.CreditBalance
 * JD-Core Version:    0.6.2
 */