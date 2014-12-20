package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kx;
import com.google.android.gms.wearable.b;

public class DataItemAssetParcelable
  implements SafeParcelable, b
{
  public static final Parcelable.Creator CREATOR = new o();
  final int a;
  private final String b;
  private final String c;

  DataItemAssetParcelable(int paramInt, String paramString1, String paramString2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
  }

  public DataItemAssetParcelable(b paramb)
  {
    this.a = 1;
    this.b = ((String)kx.a(paramb.b()));
    this.c = ((String)kx.a(paramb.c()));
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public b d()
  {
    return this;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataItemAssetParcelable[");
    localStringBuilder.append("@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.b == null)
      localStringBuilder.append(",noid");
    while (true)
    {
      localStringBuilder.append(", key=");
      localStringBuilder.append(this.c);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(",");
      localStringBuilder.append(this.b);
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    o.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.DataItemAssetParcelable
 * JD-Core Version:    0.6.0
 */