package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class am
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new i();
  public final int a;
  public final int b;
  public final m c;

  am(int paramInt1, int paramInt2, m paramm)
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
    i.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.am
 * JD-Core Version:    0.6.0
 */