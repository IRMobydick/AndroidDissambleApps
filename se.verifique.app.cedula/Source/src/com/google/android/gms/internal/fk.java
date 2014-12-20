package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fk
  implements SafeParcelable
{
  public static final int a = Integer.parseInt("-1");
  public static final iy b = new iy();
  final int c;
  public final String d;
  final fp e;
  public final int f;
  public final byte[] g;

  fk(int paramInt1, String paramString, fp paramfp, int paramInt2, byte[] paramArrayOfByte)
  {
    if ((paramInt2 == a) || (ja.a(paramInt2) != null));
    for (boolean bool = true; ; bool = false)
    {
      kx.b(bool, "Invalid section type " + paramInt2);
      this.c = paramInt1;
      this.d = paramString;
      this.e = paramfp;
      this.f = paramInt2;
      this.g = paramArrayOfByte;
      String str = a();
      if (str == null)
        break;
      throw new IllegalArgumentException(str);
    }
  }

  public String a()
  {
    String str;
    if ((this.f != a) && (ja.a(this.f) == null))
      str = "Invalid section type " + this.f;
    while (true)
    {
      return str;
      if ((this.d != null) && (this.g != null))
      {
        str = "Both content and blobContent set";
        continue;
      }
      str = null;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    iy.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fk
 * JD-Core Version:    0.6.0
 */