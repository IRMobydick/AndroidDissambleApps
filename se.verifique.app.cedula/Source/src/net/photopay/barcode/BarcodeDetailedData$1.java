package net.photopay.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class BarcodeDetailedData$1
  implements Parcelable.Creator
{
  public final BarcodeDetailedData createFromParcel(Parcel paramParcel)
  {
    return new BarcodeDetailedData(paramParcel);
  }

  public final BarcodeDetailedData[] newArray(int paramInt)
  {
    return new BarcodeDetailedData[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.barcode.BarcodeDetailedData.1
 * JD-Core Version:    0.6.0
 */