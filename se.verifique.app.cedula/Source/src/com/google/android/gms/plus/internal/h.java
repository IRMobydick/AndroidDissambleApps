package com.google.android.gms.plus.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;
import java.util.Arrays;

public class h
  implements SafeParcelable
{
  public static final b a = new b();
  private final int b;
  private final String c;
  private final String[] d;
  private final String[] e;
  private final String[] f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  private final PlusCommonExtras k;

  h(int paramInt, String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5, PlusCommonExtras paramPlusCommonExtras)
  {
    this.b = paramInt;
    this.c = paramString1;
    this.d = paramArrayOfString1;
    this.e = paramArrayOfString2;
    this.f = paramArrayOfString3;
    this.g = paramString2;
    this.h = paramString3;
    this.i = paramString4;
    this.j = paramString5;
    this.k = paramPlusCommonExtras;
  }

  public int a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public String[] c()
  {
    return this.d;
  }

  public String[] d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public String[] e()
  {
    return this.f;
  }

  public boolean equals(Object paramObject)
  {
    int m = 0;
    if (!(paramObject instanceof h));
    while (true)
    {
      return m;
      h localh = (h)paramObject;
      if ((this.b != localh.b) || (!kt.a(this.c, localh.c)) || (!Arrays.equals(this.d, localh.d)) || (!Arrays.equals(this.e, localh.e)) || (!Arrays.equals(this.f, localh.f)) || (!kt.a(this.g, localh.g)) || (!kt.a(this.h, localh.h)) || (!kt.a(this.i, localh.i)) || (!kt.a(this.j, localh.j)) || (!kt.a(this.k, localh.k)))
        continue;
      m = 1;
    }
  }

  public String f()
  {
    return this.g;
  }

  public String g()
  {
    return this.h;
  }

  public String h()
  {
    return this.i;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = Integer.valueOf(this.b);
    arrayOfObject[1] = this.c;
    arrayOfObject[2] = this.d;
    arrayOfObject[3] = this.e;
    arrayOfObject[4] = this.f;
    arrayOfObject[5] = this.g;
    arrayOfObject[6] = this.h;
    arrayOfObject[7] = this.i;
    arrayOfObject[8] = this.j;
    arrayOfObject[9] = this.k;
    return kt.a(arrayOfObject);
  }

  public String i()
  {
    return this.j;
  }

  public PlusCommonExtras j()
  {
    return this.k;
  }

  public String toString()
  {
    return kt.a(this).a("versionCode", Integer.valueOf(this.b)).a("accountName", this.c).a("requestedScopes", this.d).a("visibleActivities", this.e).a("requiredFeatures", this.f).a("packageNameForAuth", this.g).a("callingPackageName", this.h).a("applicationName", this.i).a("extra", this.k.toString()).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.h
 * JD-Core Version:    0.6.0
 */