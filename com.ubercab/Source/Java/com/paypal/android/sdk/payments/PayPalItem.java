package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.paypal.android.sdk.R;
import java.math.BigDecimal;
import org.json.JSONArray;
import org.json.JSONObject;

public final class PayPalItem
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new P();
  private static final String a = PayPalItem.class.getSimpleName();
  private String b;
  private Integer c;
  private BigDecimal d;
  private String e;
  private String f;

  private PayPalItem(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.c = Integer.valueOf(paramParcel.readInt());
    try
    {
      this.d = new BigDecimal(paramParcel.readString());
      label38: this.e = paramParcel.readString();
      this.f = paramParcel.readString();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label38;
    }
  }

  public PayPalItem(String paramString1, Integer paramInteger, BigDecimal paramBigDecimal, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.c = paramInteger;
    this.d = paramBigDecimal;
    this.e = paramString2;
    this.f = paramString3;
  }

  public static BigDecimal getItemTotal(PayPalItem[] paramArrayOfPayPalItem)
  {
    BigDecimal localBigDecimal = new BigDecimal("0.00");
    int i = paramArrayOfPayPalItem.length;
    for (int j = 0; j < i; j++)
    {
      PayPalItem localPayPalItem = paramArrayOfPayPalItem[j];
      localBigDecimal = localBigDecimal.add(localPayPalItem.d.multiply(BigDecimal.valueOf(localPayPalItem.c.intValue())));
    }
    return localBigDecimal;
  }

  public static JSONArray toJSONArray(PayPalItem[] paramArrayOfPayPalItem)
  {
    JSONArray localJSONArray = new JSONArray();
    int i = paramArrayOfPayPalItem.length;
    for (int j = 0; j < i; j++)
    {
      PayPalItem localPayPalItem = paramArrayOfPayPalItem[j];
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.accumulate("quantity", Integer.toString(localPayPalItem.c.intValue()));
      localJSONObject.accumulate("name", localPayPalItem.b);
      localJSONObject.accumulate("price", localPayPalItem.d.toString());
      localJSONObject.accumulate("currency", localPayPalItem.e);
      localJSONObject.accumulate("sku", localPayPalItem.f);
      localJSONArray.put(localJSONObject);
    }
    return localJSONArray;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String getCurrency()
  {
    return this.e;
  }

  public final String getName()
  {
    return this.b;
  }

  public final BigDecimal getPrice()
  {
    return this.d;
  }

  public final Integer getQuantity()
  {
    return this.c;
  }

  public final String getSku()
  {
    return this.f;
  }

  public final boolean isValid()
  {
    if (this.c.intValue() <= 0)
    {
      Log.e(a, "item.quantity must be a positive integer.");
      return false;
    }
    if (R.c(this.e))
    {
      Log.e(a, "item.currency field is required.");
      return false;
    }
    if (R.c(this.b))
    {
      Log.e(a, "item.name field is required.");
      return false;
    }
    if (R.c(this.f))
    {
      Log.e(a, "item.sku field is required.");
      return false;
    }
    if (this.d == null)
    {
      Log.e(a, "item.price field is required.");
      return false;
    }
    return true;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c.intValue());
    paramParcel.writeString(this.d.toString());
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalItem
 * JD-Core Version:    0.6.2
 */