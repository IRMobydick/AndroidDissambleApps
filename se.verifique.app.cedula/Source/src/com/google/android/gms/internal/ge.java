package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ge
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new je();
  private final int a;
  private String b;

  public ge()
  {
    this(1, null);
  }

  ge(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }

  public int a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (paramObject == this)
      bool = true;
    while (true)
    {
      return bool;
      if (!(paramObject instanceof ge))
      {
        bool = false;
        continue;
      }
      ge localge = (ge)paramObject;
      bool = jf.a(this.b, localge.b);
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.b;
    return kt.a(arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    je.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ge
 * JD-Core Version:    0.6.0
 */