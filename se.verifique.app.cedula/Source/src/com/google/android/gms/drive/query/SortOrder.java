package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class SortOrder
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new c();
  final List a;
  final int b;

  SortOrder(int paramInt, List paramList)
  {
    this.b = paramInt;
    this.a = paramList;
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
 * Qualified Name:     com.google.android.gms.drive.query.SortOrder
 * JD-Core Version:    0.6.0
 */