package com.paypal.android.sdk;

import android.os.Parcel;

public abstract class bo
{
  protected String a;
  protected long b;

  public bo()
  {
  }

  public bo(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readLong();
  }

  public final String b()
  {
    return this.a;
  }

  public final boolean c()
  {
    return this.b > System.currentTimeMillis();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.bo
 * JD-Core Version:    0.6.2
 */