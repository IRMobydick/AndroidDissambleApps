package mobi.pdf417;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import net.photopay.barcode.BarcodeDetailedData;

public class Pdf417MobiScanData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new Pdf417MobiScanData.1();
  private String IlIllIlIIl;
  private String jdField_llIIlIlIIl_of_type_JavaLangString;
  private BarcodeDetailedData jdField_llIIlIlIIl_of_type_NetPhotopayBarcodeBarcodeDetailedData;
  private boolean mUncertain;

  private Pdf417MobiScanData(Parcel paramParcel)
  {
    this.jdField_llIIlIlIIl_of_type_JavaLangString = paramParcel.readString();
    this.IlIllIlIIl = paramParcel.readString();
    this.jdField_llIIlIlIIl_of_type_NetPhotopayBarcodeBarcodeDetailedData = ((BarcodeDetailedData)paramParcel.readParcelable(BarcodeDetailedData.class.getClassLoader()));
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mUncertain = bool;
      return;
    }
  }

  public Pdf417MobiScanData(String paramString1, String paramString2, BarcodeDetailedData paramBarcodeDetailedData, boolean paramBoolean)
  {
    this.jdField_llIIlIlIIl_of_type_JavaLangString = paramString1;
    this.IlIllIlIIl = paramString2;
    this.jdField_llIIlIlIIl_of_type_NetPhotopayBarcodeBarcodeDetailedData = paramBarcodeDetailedData;
    this.mUncertain = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getBarcodeData()
  {
    return this.IlIllIlIIl;
  }

  public BarcodeDetailedData getBarcodeRawData()
  {
    return this.jdField_llIIlIlIIl_of_type_NetPhotopayBarcodeBarcodeDetailedData;
  }

  public String getBarcodeType()
  {
    return this.jdField_llIIlIlIIl_of_type_JavaLangString;
  }

  public boolean isResultUncertain()
  {
    return this.mUncertain;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_llIIlIlIIl_of_type_JavaLangString);
    paramParcel.writeString(this.IlIllIlIIl);
    paramParcel.writeParcelable(this.jdField_llIIlIlIIl_of_type_NetPhotopayBarcodeBarcodeDetailedData, paramInt);
    if (this.mUncertain);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      return;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     mobi.pdf417.Pdf417MobiScanData
 * JD-Core Version:    0.6.0
 */