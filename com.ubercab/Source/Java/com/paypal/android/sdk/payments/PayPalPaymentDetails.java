package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public final class PayPalPaymentDetails
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new S();
  private static final String a = PayPalPaymentDetails.class.getSimpleName();
  private BigDecimal b;
  private BigDecimal c;
  private BigDecimal d;

  private PayPalPaymentDetails(Parcel paramParcel)
  {
    while (true)
    {
      String str2;
      String str3;
      try
      {
        String str1 = paramParcel.readString();
        BigDecimal localBigDecimal1;
        if (str1 == null)
        {
          localBigDecimal1 = null;
          this.c = localBigDecimal1;
          str2 = paramParcel.readString();
          if (str2 == null)
          {
            localBigDecimal2 = null;
            this.b = localBigDecimal2;
            str3 = paramParcel.readString();
            localBigDecimal3 = null;
            if (str3 != null)
              break label101;
            this.d = localBigDecimal3;
          }
        }
        else
        {
          localBigDecimal1 = new BigDecimal(str1);
          continue;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new RuntimeException("error unparceling PayPalPaymentDetails");
      }
      BigDecimal localBigDecimal2 = new BigDecimal(str2);
      continue;
      label101: BigDecimal localBigDecimal3 = new BigDecimal(str3);
    }
  }

  public PayPalPaymentDetails(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3)
  {
    this.c = paramBigDecimal1;
    this.b = paramBigDecimal2;
    this.d = paramBigDecimal3;
  }

  protected final BigDecimal a()
  {
    return this.b;
  }

  protected final BigDecimal b()
  {
    return this.c;
  }

  protected final BigDecimal c()
  {
    return this.d;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean isProcessable()
  {
    return this.b != null;
  }

  public final JSONObject toJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.c != null)
        localJSONObject.put("shipping", this.c.toPlainString());
      if (this.b != null)
        localJSONObject.put("subtotal", this.b.toPlainString());
      if (this.d != null)
        localJSONObject.put("tax", this.d.toPlainString());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Log.e(a, "error encoding JSON", localJSONException);
    }
    return null;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    String str1;
    String str2;
    label24: String str3;
    if (this.c == null)
    {
      str1 = null;
      paramParcel.writeString(str1);
      if (this.b != null)
        break label62;
      str2 = null;
      paramParcel.writeString(str2);
      BigDecimal localBigDecimal = this.d;
      str3 = null;
      if (localBigDecimal != null)
        break label74;
    }
    while (true)
    {
      paramParcel.writeString(str3);
      return;
      str1 = this.c.toString();
      break;
      label62: str2 = this.b.toString();
      break label24;
      label74: str3 = this.d.toString();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalPaymentDetails
 * JD-Core Version:    0.6.2
 */