package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class v
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new y();
  public final int a;
  public final int b;
  public final m c;

  v(int paramInt1, int paramInt2, m paramm)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramm;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    y.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.v
 * JD-Core Version:    0.6.0
 */