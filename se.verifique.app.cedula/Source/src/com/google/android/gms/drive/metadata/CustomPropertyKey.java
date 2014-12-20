package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kx;

public class CustomPropertyKey
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new h();
  final int a;
  final String b;
  final int c;

  CustomPropertyKey(int paramInt1, String paramString, int paramInt2)
  {
    this.a = paramInt1;
    kx.a(paramString, "key");
    if ((paramInt2 == 0) || (paramInt2 == i));
    while (true)
    {
      kx.a(i, "visibility must be either PUBLIC or PRIVATE");
      this.b = paramString;
      this.c = paramInt2;
      return;
      i = 0;
    }
  }

  public String a()
  {
    return this.b;
  }

  public int b()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    int j = 0;
    if (paramObject == null);
    do
      while (true)
      {
        return j;
        if (paramObject != this)
          break;
        j = i;
      }
    while (!(paramObject instanceof CustomPropertyKey));
    CustomPropertyKey localCustomPropertyKey = (CustomPropertyKey)paramObject;
    if ((localCustomPropertyKey.a().equals(this.b)) && (localCustomPropertyKey.b() == this.c));
    while (true)
    {
      j = i;
      break;
      i = 0;
    }
  }

  public int hashCode()
  {
    return (this.b + this.c).hashCode();
  }

  public String toString()
  {
    return "CustomPropertyKey(" + this.b + "," + this.c + ")";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.CustomPropertyKey
 * JD-Core Version:    0.6.0
 */