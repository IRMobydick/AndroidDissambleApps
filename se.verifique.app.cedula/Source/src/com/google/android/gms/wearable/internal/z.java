package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class z
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  public final int a;
  public final int b;
  public final ai c;

  z(int paramInt1, int paramInt2, ai paramai)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramai;
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
 * Qualified Name:     com.google.android.gms.wearable.internal.z
 * JD-Core Version:    0.6.0
 */