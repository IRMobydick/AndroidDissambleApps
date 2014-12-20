package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator
{
  public RealTimeMessage a(Parcel paramParcel)
  {
    return new RealTimeMessage(paramParcel, null);
  }

  public RealTimeMessage[] a(int paramInt)
  {
    return new RealTimeMessage[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.a
 * JD-Core Version:    0.6.0
 */