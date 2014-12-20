package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class gy$a
  implements SafeParcelable
{
  public static final kw a = new kw();
  private final int b;
  private final String c;
  private final List d = new ArrayList();
  private final int e;
  private final String f;

  gy$a(int paramInt1, String paramString1, List paramList, int paramInt2, String paramString2)
  {
    this.b = paramInt1;
    this.c = paramString1;
    this.d.addAll(paramList);
    this.e = paramInt2;
    this.f = paramString2;
  }

  public String a()
  {
    return this.c;
  }

  public int b()
  {
    return this.e;
  }

  public String c()
  {
    return this.f;
  }

  public List d()
  {
    return new ArrayList(this.d);
  }

  public int describeContents()
  {
    return 0;
  }

  public int e()
  {
    return this.b;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kw.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gy.a
 * JD-Core Version:    0.6.0
 */