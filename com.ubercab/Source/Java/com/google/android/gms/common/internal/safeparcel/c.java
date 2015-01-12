package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.o;

public final class c
{
  public static <T extends SafeParcelable> T a(Intent paramIntent, String paramString, Parcelable.Creator<T> paramCreator)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra(paramString);
    if (arrayOfByte == null)
      return null;
    return a(arrayOfByte, paramCreator);
  }

  public static <T extends SafeParcelable> T a(byte[] paramArrayOfByte, Parcelable.Creator<T> paramCreator)
  {
    o.i(paramCreator);
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    SafeParcelable localSafeParcelable = (SafeParcelable)paramCreator.createFromParcel(localParcel);
    localParcel.recycle();
    return localSafeParcelable;
  }

  public static <T extends SafeParcelable> void a(T paramT, Intent paramIntent, String paramString)
  {
    paramIntent.putExtra(paramString, a(paramT));
  }

  public static <T extends SafeParcelable> byte[] a(T paramT)
  {
    Parcel localParcel = Parcel.obtain();
    paramT.writeToParcel(localParcel, 0);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    return arrayOfByte;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.c
 * JD-Core Version:    0.6.2
 */