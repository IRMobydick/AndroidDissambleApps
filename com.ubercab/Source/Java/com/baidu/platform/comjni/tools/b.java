package com.baidu.platform.comjni.tools;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<ParcelItem>
{
  public ParcelItem a(Parcel paramParcel)
  {
    ParcelItem localParcelItem = new ParcelItem();
    localParcelItem.setBundle(paramParcel.readBundle());
    return localParcelItem;
  }

  public ParcelItem[] a(int paramInt)
  {
    return new ParcelItem[paramInt];
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.platform.comjni.tools.b
 * JD-Core Version:    0.6.2
 */