package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fm
  implements SafeParcelable
{
  public static final iz a = new iz();
  final int b;
  public final int c;
  final Bundle d;

  fm(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBundle;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    iz.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fm
 * JD-Core Version:    0.6.0
 */