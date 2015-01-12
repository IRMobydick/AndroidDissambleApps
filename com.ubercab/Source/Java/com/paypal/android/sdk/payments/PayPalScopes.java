package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public final class PayPalScopes
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new T();
  private List a = new ArrayList();

  static
  {
    PayPalScopes.class.getSimpleName();
  }

  public PayPalScopes()
  {
  }

  private PayPalScopes(Parcel paramParcel)
  {
    paramParcel.readList(this.a, null);
  }

  final List a()
  {
    return this.a;
  }

  public final PayPalScopes addFuturePaymentsScope()
  {
    this.a.add(PayPalScope.FUTURE_PAYMENTS);
    return this;
  }

  public final PayPalScopes addProfileScope()
  {
    this.a.add(PayPalScope.PROFILE);
    return this;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String toString()
  {
    String str = PayPalScopes.class.getSimpleName() + ": {%s}";
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.a;
    return String.format(str, arrayOfObject);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalScopes
 * JD-Core Version:    0.6.2
 */