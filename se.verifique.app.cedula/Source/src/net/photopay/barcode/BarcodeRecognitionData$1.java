package net.photopay.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class BarcodeRecognitionData$1
  implements Parcelable.Creator
{
  public final BarcodeRecognitionData createFromParcel(Parcel paramParcel)
  {
    return new BarcodeRecognitionData(paramParcel);
  }

  public final BarcodeRecognitionData[] newArray(int paramInt)
  {
    return new BarcodeRecognitionData[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.barcode.BarcodeRecognitionData.1
 * JD-Core Version:    0.6.0
 */