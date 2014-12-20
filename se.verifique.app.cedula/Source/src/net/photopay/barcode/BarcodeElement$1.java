package net.photopay.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class BarcodeElement$1
  implements Parcelable.Creator
{
  public final BarcodeElement createFromParcel(Parcel paramParcel)
  {
    return new BarcodeElement(paramParcel);
  }

  public final BarcodeElement[] newArray(int paramInt)
  {
    return new BarcodeElement[paramInt];
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.barcode.BarcodeElement.1
 * JD-Core Version:    0.6.0
 */