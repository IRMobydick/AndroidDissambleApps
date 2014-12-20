package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fr
  implements SafeParcelable
{
  public static final jc a = new jc();
  final int b;
  final fi c;
  final long d;
  final int e;
  public final String f;
  final fg g;

  fr(int paramInt1, fi paramfi, long paramLong, int paramInt2, String paramString, fg paramfg)
  {
    this.b = paramInt1;
    this.c = paramfi;
    this.d = paramLong;
    this.e = paramInt2;
    this.f = paramString;
    this.g = paramfg;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.c;
    arrayOfObject[1] = Long.valueOf(this.d);
    arrayOfObject[2] = Integer.valueOf(this.e);
    return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d]", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jc.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fr
 * JD-Core Version:    0.6.0
 */