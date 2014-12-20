package net.photopay.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class BarcodeDetailedData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new BarcodeDetailedData.1();
  private List elements_ = new ArrayList();
  private byte[] mergedData_ = null;

  public BarcodeDetailedData()
  {
  }

  public BarcodeDetailedData(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    for (int j = 0; j < i; j++)
    {
      BarcodeElement localBarcodeElement = (BarcodeElement)paramParcel.readParcelable(BarcodeElement.class.getClassLoader());
      this.elements_.add(localBarcodeElement);
    }
  }

  public void addElement(BarcodeElement paramBarcodeElement)
  {
    this.elements_.add(paramBarcodeElement);
  }

  public int describeContents()
  {
    return 42;
  }

  public byte[] getAllData()
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    byte[] arrayOfByte1;
    if (this.mergedData_ == null)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      int i = 0;
      while (true)
        if (i < this.elements_.size())
        {
          byte[] arrayOfByte2 = ((BarcodeElement)this.elements_.get(i)).getElementBytes();
          try
          {
            localByteArrayOutputStream.write(arrayOfByte2);
            i++;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            arrayOfByte1 = null;
          }
        }
    }
    while (true)
    {
      return arrayOfByte1;
      this.mergedData_ = localByteArrayOutputStream.toByteArray();
      arrayOfByte1 = this.mergedData_;
    }
  }

  public List getElements()
  {
    return this.elements_;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Total elements: ");
    localStringBuilder.append(this.elements_.size());
    localStringBuilder.append("\n");
    int i = 0;
    while (true)
      if (i < this.elements_.size())
      {
        localStringBuilder.append("Element #");
        localStringBuilder.append(i + 1);
        localStringBuilder.append(" is of type ");
        BarcodeElement localBarcodeElement = (BarcodeElement)this.elements_.get(i);
        if (localBarcodeElement.getElementType() == ElementType.TEXT_DATA);
        byte[] arrayOfByte;
        for (String str1 = "text"; ; str1 = "byte")
        {
          localStringBuilder.append(str1);
          localStringBuilder.append("\n");
          arrayOfByte = localBarcodeElement.getElementBytes();
          localStringBuilder.append("Length = ");
          localStringBuilder.append(arrayOfByte.length);
          localStringBuilder.append(" {");
          for (int j = 0; j < arrayOfByte.length; j++)
          {
            localStringBuilder.append(0xFF & arrayOfByte[j]);
            if (j == -1 + arrayOfByte.length)
              continue;
            localStringBuilder.append(", ");
          }
        }
        localStringBuilder.append("}\n");
        if (localBarcodeElement.getElementType() == ElementType.TEXT_DATA);
        try
        {
          String str2 = new String(arrayOfByte, "UTF-8");
          localStringBuilder.append("Text representation (UTF-8 decoded): ");
          localStringBuilder.append(str2);
          localStringBuilder.append("\n");
          i++;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          while (true)
            localUnsupportedEncodingException.printStackTrace();
        }
      }
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.elements_.size());
    for (int i = 0; i < this.elements_.size(); i++)
      paramParcel.writeParcelable((Parcelable)this.elements_.get(i), paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.barcode.BarcodeDetailedData
 * JD-Core Version:    0.6.0
 */