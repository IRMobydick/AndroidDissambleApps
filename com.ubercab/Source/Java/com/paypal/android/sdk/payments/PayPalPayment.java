package com.paypal.android.sdk.payments;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.paypal.android.sdk.b;
import com.paypal.android.sdk.br;
import com.paypal.android.sdk.j;
import com.paypal.android.sdk.l;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class PayPalPayment
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new R();
  public static final String PAYMENT_INTENT_AUTHORIZE = "authorize";
  public static final String PAYMENT_INTENT_SALE = "sale";
  private static final String a = PayPalPayment.class.getSimpleName();
  private BigDecimal b;
  private String c;
  private String d;
  private String e;
  private PayPalPaymentDetails f;
  private String g;
  private PayPalItem[] h;

  private PayPalPayment(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    try
    {
      this.b = new BigDecimal(paramParcel.readString());
      label27: this.d = paramParcel.readString();
      this.g = paramParcel.readString();
      this.e = paramParcel.readString();
      this.f = ((PayPalPaymentDetails)paramParcel.readParcelable(b.a().b().getClassLoader()));
      int i = paramParcel.readInt();
      if (i > 0)
      {
        this.h = new PayPalItem[i];
        paramParcel.readTypedArray(this.h, PayPalItem.CREATOR);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label27;
    }
  }

  public PayPalPayment(BigDecimal paramBigDecimal, String paramString1, String paramString2, String paramString3)
  {
    this.b = paramBigDecimal;
    this.c = paramString1;
    this.d = paramString2;
    this.g = paramString3;
    this.f = null;
    this.e = null;
    toString();
  }

  private static void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
      Log.e(a, paramString + " is invalid.  Please see the docs.");
  }

  private boolean h()
  {
    if (this.c == null)
      return false;
    try
    {
      Currency localCurrency = Currency.getInstance(this.c);
      boolean bool = l.a().contains(localCurrency);
      return bool;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
    return false;
  }

  protected final BigDecimal a()
  {
    return this.b;
  }

  protected final String b()
  {
    return this.d;
  }

  public final PayPalPayment bnCode(String paramString)
  {
    this.e = paramString;
    return this;
  }

  protected final String c()
  {
    return this.g;
  }

  protected final String d()
  {
    return this.c;
  }

  public final int describeContents()
  {
    return 0;
  }

  protected final String e()
  {
    return this.e;
  }

  protected final PayPalPaymentDetails f()
  {
    return this.f;
  }

  protected final PayPalItem[] g()
  {
    return this.h;
  }

  public final String getAmountAsLocalizedString()
  {
    if (this.b == null)
      return null;
    br localbr = br.d();
    return l.a(localbr.c(), localbr.a().a(), this.b.doubleValue(), this.c, true);
  }

  public final boolean isProcessable()
  {
    boolean bool1 = h();
    boolean bool2;
    boolean bool3;
    boolean bool4;
    label73: boolean bool5;
    label83: boolean bool6;
    label96: boolean bool7;
    if ((this.b != null) && (this.b.compareTo(BigDecimal.ZERO) == 1))
    {
      bool2 = true;
      bool3 = com.paypal.android.sdk.R.b(this.d);
      if ((!com.paypal.android.sdk.R.d(this.g)) || ((!this.g.equals("sale")) && (!this.g.equals("authorize"))))
        break label199;
      bool4 = true;
      if (this.f != null)
        break label205;
      bool5 = true;
      if (!com.paypal.android.sdk.R.c(this.e))
        break label217;
      bool6 = true;
      if ((this.h != null) && (this.h.length != 0))
        break label229;
      bool7 = true;
    }
    while (true)
    {
      a(bool1, "currencyCode");
      a(bool2, "amount");
      a(bool3, "shortDescription");
      a(bool4, "paymentIntent");
      a(bool5, "details");
      a(bool6, "bnCode");
      a(bool7, "items");
      if ((!bool1) || (!bool2) || (!bool3) || (!bool5) || (!bool4) || (!bool6) || (!bool7))
        break label279;
      return true;
      bool2 = false;
      break;
      label199: bool4 = false;
      break label73;
      label205: bool5 = this.f.isProcessable();
      break label83;
      label217: bool6 = com.paypal.android.sdk.R.a(this.e);
      break label96;
      label229: PayPalItem[] arrayOfPayPalItem = this.h;
      int i = arrayOfPayPalItem.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label273;
        if (!arrayOfPayPalItem[j].isValid())
        {
          bool7 = false;
          break;
        }
      }
      label273: bool7 = true;
    }
    label279: return false;
  }

  public final PayPalPayment items(PayPalItem[] paramArrayOfPayPalItem)
  {
    this.h = paramArrayOfPayPalItem;
    return this;
  }

  public final PayPalPayment paymentDetails(PayPalPaymentDetails paramPayPalPaymentDetails)
  {
    this.f = paramPayPalPaymentDetails;
    return this;
  }

  public final JSONObject toJSONObject()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("amount", this.b.toPlainString());
      localJSONObject1.put("currency_code", this.c);
      if (this.f != null)
        localJSONObject1.put("details", this.f.toJSONObject());
      localJSONObject1.put("short_description", this.d);
      localJSONObject1.put("intent", this.g.toString());
      if (com.paypal.android.sdk.R.d(this.e))
        localJSONObject1.put("bn_code", this.e);
      if ((this.h != null) && (this.h.length > 0))
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.accumulate("items", PayPalItem.toJSONArray(this.h));
        localJSONObject1.put("item_list", localJSONObject2);
      }
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      Log.e(a, "error encoding JSON", localJSONException);
    }
    return null;
  }

  public final String toString()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.d;
    if (this.b != null);
    for (String str = this.b.toString(); ; str = null)
    {
      arrayOfObject[1] = str;
      arrayOfObject[2] = this.c;
      arrayOfObject[3] = this.g;
      return String.format("PayPalPayment: {%s: $%s %s, %s}", arrayOfObject);
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.b.toString());
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.e);
    paramParcel.writeParcelable(this.f, 0);
    if (this.h != null)
    {
      paramParcel.writeInt(this.h.length);
      paramParcel.writeTypedArray(this.h, 0);
      return;
    }
    paramParcel.writeInt(0);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalPayment
 * JD-Core Version:    0.6.2
 */