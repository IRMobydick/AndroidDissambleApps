package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.paypal.android.sdk.R;
import org.json.JSONException;
import org.json.JSONObject;

public final class ProofOfPayment
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new aA();
  private static final String a = ProofOfPayment.class.getSimpleName();
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;

  private ProofOfPayment(Parcel paramParcel)
  {
    this(paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString(), paramParcel.readString());
  }

  ProofOfPayment(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String getAuthorizationId()
  {
    return this.f;
  }

  public final String getCreateTime()
  {
    return this.d;
  }

  public final String getIntent()
  {
    return this.e;
  }

  public final String getPaymentId()
  {
    return this.c;
  }

  public final String getState()
  {
    return this.b;
  }

  public final JSONObject toJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("create_time", this.d);
      localJSONObject.put("id", this.c);
      localJSONObject.put("intent", this.e);
      localJSONObject.put("state", this.b);
      if (R.d(this.f))
        localJSONObject.put("authorization_id", this.f);
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
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.ProofOfPayment
 * JD-Core Version:    0.6.2
 */