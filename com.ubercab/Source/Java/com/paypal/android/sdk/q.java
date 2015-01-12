package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import java.math.BigDecimal;
import java.util.Currency;

public class q
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  private BigDecimal a;
  private Currency b;
  private long c;

  static
  {
    if (!q.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      d = bool;
      CREATOR = new r();
      return;
    }
  }

  public q(Parcel paramParcel)
  {
    this.c = paramParcel.readLong();
    this.a = new BigDecimal(paramParcel.readString());
    try
    {
      this.b = Currency.getInstance(paramParcel.readString());
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.e("MoneySpec", "Exception reading currency code from parcel, reset to default");
      this.b = Currency.getInstance(null.c());
    }
  }

  public q(BigDecimal paramBigDecimal, String paramString)
  {
    Currency localCurrency = Currency.getInstance(paramString);
    this.c = System.currentTimeMillis();
    this.a = paramBigDecimal;
    this.b = localCurrency;
  }

  public final BigDecimal a()
  {
    return this.a;
  }

  public final Currency b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if ((!d) && (!(paramObject instanceof q)))
      throw new AssertionError();
    q localq = (q)paramObject;
    return (localq.a == this.a) && (localq.b.equals(this.b));
  }

  public String toString()
  {
    return l.a(null.c(), this.a.doubleValue(), this.b);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.c);
    paramParcel.writeString(this.a.toString());
    paramParcel.writeString(this.b.getCurrencyCode());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.q
 * JD-Core Version:    0.6.2
 */