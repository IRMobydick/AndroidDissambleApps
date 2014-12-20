package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fp
  implements SafeParcelable
{
  public static final jb a = new jb();
  final int b;
  public final String c;
  public final String d;
  public final boolean e;
  public final int f;
  public final boolean g;
  public final String h;
  public final fm[] i;
  final int[] j;
  public final String k;

  fp(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString3, fm[] paramArrayOffm, int[] paramArrayOfInt, String paramString4)
  {
    this.b = paramInt1;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramBoolean1;
    this.f = paramInt2;
    this.g = paramBoolean2;
    this.h = paramString3;
    this.i = paramArrayOffm;
    this.j = paramArrayOfInt;
    this.k = paramString4;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int m = 0;
    if ((paramObject instanceof fp))
    {
      fp localfp = (fp)paramObject;
      if ((this.c.equals(localfp.c)) && (this.d.equals(localfp.d)) && (this.e == localfp.e))
        m = 1;
    }
    return m;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jb.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fp
 * JD-Core Version:    0.6.0
 */