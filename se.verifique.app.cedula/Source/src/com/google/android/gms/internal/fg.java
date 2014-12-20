package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class fg
  implements SafeParcelable
{
  public static final iw a = new iw();
  final int b;
  final fk[] c;
  public final String d;
  public final boolean e;

  fg(int paramInt, fk[] paramArrayOffk, String paramString, boolean paramBoolean)
  {
    this.b = paramInt;
    this.c = paramArrayOffk;
    this.d = paramString;
    this.e = paramBoolean;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    iw.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fg
 * JD-Core Version:    0.6.0
 */