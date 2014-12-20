package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ev
  implements SafeParcelable
{
  public static final hj a = new hj();
  public final int b;
  public String c;
  public int d;
  public int e;
  public boolean f;

  public ev(int paramInt1, int paramInt2, boolean paramBoolean)
  {
  }

  ev(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.b = paramInt1;
    this.c = paramString;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hj.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ev
 * JD-Core Version:    0.6.0
 */