package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;

public class Asset
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new d();
  final int a;
  public ParcelFileDescriptor b;
  public Uri c;
  private byte[] d;
  private String e;

  Asset(int paramInt, byte[] paramArrayOfByte, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, Uri paramUri)
  {
    this.a = paramInt;
    this.d = paramArrayOfByte;
    this.e = paramString;
    this.b = paramParcelFileDescriptor;
    this.c = paramUri;
  }

  public byte[] a()
  {
    return this.d;
  }

  public String b()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if (!(paramObject instanceof Asset))
      {
        i = 0;
        continue;
      }
      Asset localAsset = (Asset)paramObject;
      if ((kt.a(this.d, localAsset.d)) && (kt.a(this.e, localAsset.e)) && (kt.a(this.b, localAsset.b)) && (kt.a(this.c, localAsset.c)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.d;
    arrayOfObject[1] = this.e;
    arrayOfObject[2] = this.b;
    arrayOfObject[3] = this.c;
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Asset[@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.e == null)
      localStringBuilder.append(", nodigest");
    while (true)
    {
      if (this.d != null)
      {
        localStringBuilder.append(", size=");
        localStringBuilder.append(this.d.length);
      }
      if (this.b != null)
      {
        localStringBuilder.append(", fd=");
        localStringBuilder.append(this.b);
      }
      if (this.c != null)
      {
        localStringBuilder.append(", uri=");
        localStringBuilder.append(this.c);
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(", ");
      localStringBuilder.append(this.e);
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt | 0x1);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.Asset
 * JD-Core Version:    0.6.0
 */