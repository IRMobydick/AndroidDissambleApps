package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;

public class c
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new e();
  final int a;
  private final String b;
  private final String c;
  private final int d;
  private final int e;
  private final boolean f;

  c(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramBoolean;
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public int c()
  {
    return this.d;
  }

  public int d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean e()
  {
    return this.f;
  }

  public boolean equals(Object paramObject)
  {
    int i = 0;
    if (!(paramObject instanceof c));
    while (true)
    {
      return i;
      c localc = (c)paramObject;
      if ((!kt.a(Integer.valueOf(this.a), Integer.valueOf(localc.a))) || (!kt.a(this.b, localc.b)) || (!kt.a(this.c, localc.c)) || (!kt.a(Integer.valueOf(this.d), Integer.valueOf(localc.d))) || (!kt.a(Integer.valueOf(this.e), Integer.valueOf(localc.e))) || (!kt.a(Boolean.valueOf(this.f), Boolean.valueOf(localc.f))))
        continue;
      i = 1;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = this.b;
    arrayOfObject[2] = this.c;
    arrayOfObject[3] = Integer.valueOf(this.d);
    arrayOfObject[4] = Integer.valueOf(this.e);
    arrayOfObject[5] = Boolean.valueOf(this.f);
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    localStringBuilder.append("mName=" + this.b);
    localStringBuilder.append(", mAddress=" + this.c);
    localStringBuilder.append(", mType=" + this.d);
    localStringBuilder.append(", mRole=" + this.e);
    localStringBuilder.append(", mEnabled=" + this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.c
 * JD-Core Version:    0.6.0
 */