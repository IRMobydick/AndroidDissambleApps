package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ez
public final class x
  implements SafeParcelable
{
  public static final y CREATOR = new y();
  public final boolean lX;
  public final boolean mh;
  public final int versionCode;

  x(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.versionCode = paramInt;
    this.lX = paramBoolean1;
    this.mh = paramBoolean2;
  }

  public x(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.versionCode = 1;
    this.lX = paramBoolean1;
    this.mh = paramBoolean2;
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

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.x
 * JD-Core Version:    0.6.2
 */