package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class v
  implements SafeParcelable
{
  public static final ok a = new ok();
  public final int b;
  public final boolean c;
  public final boolean d;

  v(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramInt;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }

  public v(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = 1;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ok.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.v
 * JD-Core Version:    0.6.0
 */