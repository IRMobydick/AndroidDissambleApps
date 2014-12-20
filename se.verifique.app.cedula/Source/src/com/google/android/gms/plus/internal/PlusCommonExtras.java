package com.google.android.gms.plus.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;

public class PlusCommonExtras
  implements SafeParcelable
{
  public static String a = "PlusCommonExtras";
  public static final a b = new a();
  private final int c;
  private String d;
  private String e;

  public PlusCommonExtras()
  {
    this.c = 1;
    this.d = "";
    this.e = "";
  }

  PlusCommonExtras(int paramInt, String paramString1, String paramString2)
  {
    this.c = paramInt;
    this.d = paramString1;
    this.e = paramString2;
  }

  public int a()
  {
    return this.c;
  }

  public String b()
  {
    return this.d;
  }

  public String c()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 0;
    if (!(paramObject instanceof PlusCommonExtras));
    while (true)
    {
      return i;
      PlusCommonExtras localPlusCommonExtras = (PlusCommonExtras)paramObject;
      if ((this.c != localPlusCommonExtras.c) || (!kt.a(this.d, localPlusCommonExtras.d)) || (!kt.a(this.e, localPlusCommonExtras.e)))
        continue;
      i = 1;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.c);
    arrayOfObject[1] = this.d;
    arrayOfObject[2] = this.e;
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return kt.a(this).a("versionCode", Integer.valueOf(this.c)).a("Gpsrc", this.d).a("ClientCallingPackage", this.e).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.PlusCommonExtras
 * JD-Core Version:    0.6.0
 */