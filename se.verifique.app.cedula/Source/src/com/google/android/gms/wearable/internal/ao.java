package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ao
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new j();
  final int a;
  public final c b;

  ao(int paramInt, IBinder paramIBinder)
  {
    this.a = paramInt;
    if (paramIBinder != null);
    for (this.b = d.a(paramIBinder); ; this.b = null)
      return;
  }

  IBinder a()
  {
    if (this.b == null);
    for (IBinder localIBinder = null; ; localIBinder = this.b.asBinder())
      return localIBinder;
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
 * Qualified Name:     com.google.android.gms.wearable.internal.ao
 * JD-Core Version:    0.6.0
 */