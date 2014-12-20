package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.a;

public class NotFilter
  implements SafeParcelable, a
{
  public static final Parcelable.Creator CREATOR = new j();
  final FilterHolder a;
  final int b;

  NotFilter(int paramInt, FilterHolder paramFilterHolder)
  {
    this.b = paramInt;
    this.a = paramFilterHolder;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.NotFilter
 * JD-Core Version:    0.6.0
 */