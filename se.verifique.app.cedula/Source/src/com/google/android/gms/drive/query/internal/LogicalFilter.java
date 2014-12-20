package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.a;
import java.util.List;

public class LogicalFilter
  implements SafeParcelable, a
{
  public static final Parcelable.Creator CREATOR = new h();
  final Operator a;
  final List b;
  final int c;

  LogicalFilter(int paramInt, Operator paramOperator, List paramList)
  {
    this.c = paramInt;
    this.a = paramOperator;
    this.b = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.LogicalFilter
 * JD-Core Version:    0.6.0
 */