package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class PayPalAuthorization
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new J();
  private static final String a = PayPalAuthorization.class.getSimpleName();
  private String b;
  private String c;
  private String d;

  private PayPalAuthorization(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }

  PayPalAuthorization(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String getAuthorizationCode()
  {
    return this.c;
  }

  public final String getEnvironment()
  {
    return this.b;
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
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("code", this.c);
      localJSONObject1.put("response", localJSONObject3);
      localJSONObject1.put("response_type", "authorization_code");
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
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalAuthorization
 * JD-Core Version:    0.6.2
 */