package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class af
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new f();
  final int a;
  private final int b;
  private final String c;
  private final byte[] d;
  private final String e;

  af(int paramInt1, int paramInt2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString1;
    this.d = paramArrayOfByte;
    this.e = paramString2;
  }

  public int a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public byte[] c()
  {
    return this.d;
  }

  public String d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("MessageEventParcelable[").append(this.b).append(",").append(this.c).append(", size=");
    if (this.d == null);
    for (Object localObject = "null"; ; localObject = Integer.valueOf(this.d.length))
      return localObject + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.af
 * JD-Core Version:    0.6.0
 */