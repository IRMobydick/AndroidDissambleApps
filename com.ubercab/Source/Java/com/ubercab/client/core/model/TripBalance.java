package com.ubercab.client.core.model;

public final class TripBalance
{
  public static final boolean INJECT_FREE_RIDES_FEATURE_FLAG;
  public static final boolean SHOW_FREE_RIDES_FEATURE_FLAG;
  String amount;
  Integer count;
  String currency;
  String detail;
  String endsAt;
  String label;
  String startsAt;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TripBalance localTripBalance;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTripBalance = (TripBalance)paramObject;
      if (this.amount != null)
      {
        if (this.amount.equals(localTripBalance.amount));
      }
      else
        while (localTripBalance.amount != null)
          return false;
      if (this.count != null)
      {
        if (this.count.equals(localTripBalance.count));
      }
      else
        while (localTripBalance.count != null)
          return false;
      if (this.currency != null)
      {
        if (this.currency.equals(localTripBalance.currency));
      }
      else
        while (localTripBalance.currency != null)
          return false;
      if (this.detail != null)
      {
        if (this.detail.equals(localTripBalance.detail));
      }
      else
        while (localTripBalance.detail != null)
          return false;
      if (this.endsAt != null)
      {
        if (this.endsAt.equals(localTripBalance.endsAt));
      }
      else
        while (localTripBalance.endsAt != null)
          return false;
      if (this.label != null)
      {
        if (this.label.equals(localTripBalance.label));
      }
      else
        while (localTripBalance.label != null)
          return false;
      if (this.startsAt == null)
        break;
    }
    while (this.startsAt.equals(localTripBalance.startsAt));
    while (true)
    {
      return false;
      if (localTripBalance.startsAt == null)
        break;
    }
  }

  public String getAmount()
  {
    return this.amount;
  }

  public Integer getCount()
  {
    if (this.count == null);
    for (int i = 1; ; i = this.count.intValue())
      return Integer.valueOf(i);
  }

  public String getCurrency()
  {
    return this.currency;
  }

  public String getDetail()
  {
    return this.detail;
  }

  public String getEndsAt()
  {
    return this.endsAt;
  }

  public String getLabel()
  {
    return this.label;
  }

  public String getStartsAt()
  {
    return this.startsAt;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label85: int i4;
    label111: int i5;
    if (this.label != null)
    {
      i = this.label.hashCode();
      int j = i * 31;
      if (this.detail == null)
        break label181;
      k = this.detail.hashCode();
      int m = 31 * (j + k);
      if (this.startsAt == null)
        break label186;
      n = this.startsAt.hashCode();
      int i1 = 31 * (m + n);
      if (this.endsAt == null)
        break label192;
      i2 = this.endsAt.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.amount == null)
        break label198;
      i4 = this.amount.hashCode();
      i5 = 31 * (i3 + i4);
      if (this.currency == null)
        break label204;
    }
    label181: label186: label192: label198: label204: for (int i6 = this.currency.hashCode(); ; i6 = 0)
    {
      int i7 = 31 * (i5 + i6);
      Integer localInteger = this.count;
      int i8 = 0;
      if (localInteger != null)
        i8 = this.count.hashCode();
      return i7 + i8;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
      i2 = 0;
      break label85;
      i4 = 0;
      break label111;
    }
  }

  public void setAmount(String paramString)
  {
    this.amount = paramString;
  }

  public void setCount(Integer paramInteger)
  {
    this.count = paramInteger;
  }

  public void setCurrency(String paramString)
  {
    this.currency = paramString;
  }

  public void setDetail(String paramString)
  {
    this.detail = paramString;
  }

  public void setEndsAt(String paramString)
  {
    this.endsAt = paramString;
  }

  public void setLabel(String paramString)
  {
    this.label = paramString;
  }

  public void setStartsAt(String paramString)
  {
    this.startsAt = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.TripBalance
 * JD-Core Version:    0.6.2
 */