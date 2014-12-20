package net.photopay.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.photopay.recognition.RecognitionData;
import net.photopay.util.Log;

public class BarcodeRecognitionData extends RecognitionData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new BarcodeRecognitionData.1();
  private boolean mDataUncertain;
  private Map mRawElements;

  public BarcodeRecognitionData(Parcel paramParcel)
  {
    super(paramParcel);
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mDataUncertain = bool;
      this.mRawElements = new HashMap();
      int j = paramParcel.readInt();
      while (i < j)
      {
        String str = paramParcel.readString();
        BarcodeDetailedData localBarcodeDetailedData = (BarcodeDetailedData)paramParcel.readParcelable(BarcodeDetailedData.class.getClassLoader());
        this.mRawElements.put(str, localBarcodeDetailedData);
        i++;
      }
    }
  }

  public BarcodeRecognitionData(Map paramMap1, Map paramMap2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramMap1, paramBoolean1, paramBoolean2);
    this.mRawElements = paramMap2;
    this.mDataUncertain = paramBoolean3;
    if (this.mRawElements == null)
      throw new NullPointerException("Raw elements map cannot be null");
  }

  public BarcodeDetailedData getRawElement(String paramString)
  {
    return (BarcodeDetailedData)this.mRawElements.get(paramString);
  }

  public Map getRawElements()
  {
    return this.mRawElements;
  }

  public boolean isDataUncertain()
  {
    return this.mDataUncertain;
  }

  public void log()
  {
    super.log();
    Iterator localIterator = this.mRawElements.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = str;
      arrayOfObject[1] = this.mRawElements.get(str);
      Log.d(this, "{} : {}", arrayOfObject);
    }
  }

  public void toStringList(Map paramMap, List paramList1, List paramList2)
  {
    super.toStringList(paramMap, paramList1, paramList2);
    Iterator localIterator = this.mRawElements.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      BarcodeDetailedData localBarcodeDetailedData = (BarcodeDetailedData)this.mRawElements.get(str1);
      String str2 = resolveUIName(paramMap, str1);
      if ((str2 == null) || (localBarcodeDetailedData == null))
        continue;
      paramList1.add(str2 + " ");
      paramList2.add(localBarcodeDetailedData.toString());
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    int i;
    if (this.mDataUncertain)
      i = 1;
    while (true)
    {
      paramParcel.writeByte((byte)i);
      if (this.mRawElements != null)
      {
        paramParcel.writeInt(this.mRawElements.keySet().size());
        Iterator localIterator = this.mRawElements.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramParcel.writeString(str);
          paramParcel.writeParcelable((Parcelable)this.mRawElements.get(str), paramInt);
        }
        i = 0;
        continue;
      }
      paramParcel.writeInt(0);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.barcode.BarcodeRecognitionData
 * JD-Core Version:    0.6.0
 */