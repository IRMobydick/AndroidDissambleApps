package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;
import com.google.android.gms.internal.kv;

public class StreetViewPanoramaLink
  implements SafeParcelable
{
  public static final k a = new k();
  public final String b;
  public final float c;
  private final int d;

  StreetViewPanoramaLink(int paramInt, String paramString, float paramFloat)
  {
    this.d = paramInt;
    this.b = paramString;
    if (paramFloat <= 0.0D)
      paramFloat = 360.0F + paramFloat % 360.0F;
    this.c = (paramFloat % 360.0F);
  }

  int a()
  {
    return this.d;
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
      if (!(paramObject instanceof StreetViewPanoramaLink))
      {
        i = 0;
        continue;
      }
      StreetViewPanoramaLink localStreetViewPanoramaLink = (StreetViewPanoramaLink)paramObject;
      if ((this.b.equals(localStreetViewPanoramaLink.b)) && (Float.floatToIntBits(this.c) == Float.floatToIntBits(localStreetViewPanoramaLink.c)))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = Float.valueOf(this.c);
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return kt.a(this).a("panoId", this.b).a("bearing", Float.valueOf(this.c)).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    k.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaLink
 * JD-Core Version:    0.6.0
 */