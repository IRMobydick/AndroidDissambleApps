package net.photopay.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BarcodeElement
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new BarcodeElement.1();
  private byte[] elementBytes_;
  private ElementType elementType_;

  public BarcodeElement(Parcel paramParcel)
  {
    this.elementType_ = ElementType.values()[paramParcel.readInt()];
    this.elementBytes_ = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.elementBytes_);
  }

  public BarcodeElement(ElementType paramElementType, byte[] paramArrayOfByte)
  {
    this.elementType_ = paramElementType;
    this.elementBytes_ = paramArrayOfByte;
    if ((this.elementType_ == null) || (this.elementBytes_ == null))
      throw new NullPointerException("Either element type or element bytes is null");
  }

  public int describeContents()
  {
    return 43;
  }

  public byte[] getElementBytes()
  {
    return this.elementBytes_;
  }

  public ElementType getElementType()
  {
    return this.elementType_;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.elementType_.ordinal());
    paramParcel.writeInt(this.elementBytes_.length);
    paramParcel.writeByteArray(this.elementBytes_);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.barcode.BarcodeElement
 * JD-Core Version:    0.6.0
 */