package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class e<T extends SafeParcelable> extends DataBuffer<T>
{
  private static final String[] JZ = { "data" };
  private final Parcelable.Creator<T> Ka;

  public e(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator)
  {
    super(paramDataHolder);
    this.Ka = paramCreator;
  }

  public T aq(int paramInt)
  {
    byte[] arrayOfByte = this.II.f("data", paramInt, 0);
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
    localParcel.setDataPosition(0);
    SafeParcelable localSafeParcelable = (SafeParcelable)this.Ka.createFromParcel(localParcel);
    localParcel.recycle();
    return localSafeParcelable;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.e
 * JD-Core Version:    0.6.2
 */