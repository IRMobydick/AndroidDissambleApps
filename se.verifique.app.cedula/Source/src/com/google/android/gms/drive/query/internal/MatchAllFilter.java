package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.a;

public class MatchAllFilter
  implements SafeParcelable, a
{
  public static final i a = new i();
  final int b;

  public MatchAllFilter()
  {
    this(1);
  }

  MatchAllFilter(int paramInt)
  {
    this.b = paramInt;
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
 * Qualified Name:     com.google.android.gms.drive.query.internal.MatchAllFilter
 * JD-Core Version:    0.6.0
 */