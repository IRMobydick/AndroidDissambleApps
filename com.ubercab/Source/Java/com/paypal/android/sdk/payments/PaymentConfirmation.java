package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class PaymentConfirmation
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ar();
  private static final String a = PaymentConfirmation.class.getSimpleName();
  private String b;
  private PayPalPayment c;
  private ProofOfPayment d;

  private PaymentConfirmation(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.c = ((PayPalPayment)paramParcel.readParcelable(PayPalPayment.class.getClassLoader()));
    this.d = ((ProofOfPayment)paramParcel.readParcelable(ProofOfPayment.class.getClassLoader()));
  }

  PaymentConfirmation(String paramString, PayPalPayment paramPayPalPayment, ProofOfPayment paramProofOfPayment)
  {
    this.b = paramString;
    this.c = paramPayPalPayment;
    this.d = paramProofOfPayment;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String getEnvironment()
  {
    return this.b;
  }

  public final PayPalPayment getPayment()
  {
    return this.c;
  }

  public final ProofOfPayment getProofOfPayment()
  {
    return this.d;
  }

  public final JSONObject toJSONObject()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("environment", this.b);
      localJSONObject2.put("paypal_sdk_version", "2.2.2");
      localJSONObject2.put("platform", "Android");
      localJSONObject2.put("product_name", "PayPal-Android-SDK");
      localJSONObject1.put("client", localJSONObject2);
      localJSONObject1.put("response", this.d.toJSONObject());
      localJSONObject1.put("response_type", "payment");
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      Log.e(a, "Error encoding JSON", localJSONException);
    }
    return null;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.c, 0);
    paramParcel.writeParcelable(this.d, 0);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.PaymentConfirmation
 * JD-Core Version:    0.6.2
 */