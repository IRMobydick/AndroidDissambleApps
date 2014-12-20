package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class t
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new w();
  public final int a;
  public final int b;
  public final List c;

  t(int paramInt1, int paramInt2, List paramList)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    w.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.t
 * JD-Core Version:    0.6.0
 */