package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ka
  implements SafeParcelable
{
  public static final mx a = new mx();
  public final int b;
  public final String c;
  public final String d;

  public ka(int paramInt, String paramString1, String paramString2)
  {
    this.b = paramInt;
    this.c = paramString1;
    this.d = paramString2;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject == null) || (!(paramObject instanceof ka)))
      {
        i = 0;
        continue;
      }
      ka localka = (ka)paramObject;
      if ((this.d.equals(localka.d)) && (this.c.equals(localka.c)))
        continue;
      i = 0;
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
    return kt.a(this).a("clientPackageName", this.c).a("locale", this.d).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mx.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ka
 * JD-Core Version:    0.6.0
 */