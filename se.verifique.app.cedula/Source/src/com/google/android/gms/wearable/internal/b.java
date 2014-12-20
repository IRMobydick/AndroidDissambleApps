package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class b
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new n();
  final int a;
  public final c b;
  public final IntentFilter[] c;

  b(int paramInt, IBinder paramIBinder, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.a = paramInt;
    if (paramIBinder != null);
    for (this.b = d.a(paramIBinder); ; this.b = null)
    {
      this.c = paramArrayOfIntentFilter;
      return;
    }
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
    n.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.b
 * JD-Core Version:    0.6.0
 */