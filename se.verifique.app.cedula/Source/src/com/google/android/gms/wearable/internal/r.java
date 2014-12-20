package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.c;

public class r
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new u();
  public final int a;
  public final int b;
  public final c c;

  r(int paramInt1, int paramInt2, c paramc)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramc;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    u.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.r
 * JD-Core Version:    0.6.0
 */