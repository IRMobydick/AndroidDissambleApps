package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldWithSortOrder
  implements SafeParcelable
{
  public static final c a = new c();
  final String b;
  final boolean c;
  final int d;

  FieldWithSortOrder(int paramInt, String paramString, boolean paramBoolean)
  {
    this.d = paramInt;
    this.b = paramString;
    this.c = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.FieldWithSortOrder
 * JD-Core Version:    0.6.0
 */