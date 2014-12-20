package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jo
  implements SafeParcelable
{
  public static final mr a = new mr();
  final int b;
  private final String c;
  private final String d;

  jo(int paramInt, String paramString1, String paramString2)
  {
    this.b = paramInt;
    this.c = paramString1;
    this.d = paramString2;
  }

  public String a()
  {
    return this.c;
  }

  public String b()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 0;
    if (!(paramObject instanceof jo));
    while (true)
    {
      return i;
      jo localjo = (jo)paramObject;
      if ((!kt.a(this.c, localjo.c)) || (!kt.a(this.d, localjo.d)))
        continue;
      i = 1;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.c;
    arrayOfObject[1] = this.d;
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return kt.a(this).a("mPlaceId", this.c).a("mTag", this.d).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mr.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jo
 * JD-Core Version:    0.6.0
 */