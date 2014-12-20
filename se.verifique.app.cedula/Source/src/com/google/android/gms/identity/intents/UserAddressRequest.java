package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class UserAddressRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  List a;
  private final int b;

  UserAddressRequest()
  {
    this.b = 1;
  }

  UserAddressRequest(int paramInt, List paramList)
  {
    this.b = paramInt;
    this.a = paramList;
  }

  public int a()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.identity.intents.UserAddressRequest
 * JD-Core Version:    0.6.0
 */