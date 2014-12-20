package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.kt;

public final class WebImage
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new h();
  private final int a;
  private final Uri b;
  private final int c;
  private final int d;

  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramUri;
    this.c = paramInt2;
    this.d = paramInt3;
  }

  int a()
  {
    return this.a;
  }

  public Uri b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public int d()
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
      if ((paramObject == null) || (!(paramObject instanceof WebImage)))
      {
        i = 0;
        continue;
      }
      WebImage localWebImage = (WebImage)paramObject;
      if ((kt.a(this.b, localWebImage.b)) && (this.c == localWebImage.c) && (this.d == localWebImage.d))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.b;
    arrayOfObject[1] = Integer.valueOf(this.c);
    arrayOfObject[2] = Integer.valueOf(this.d);
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.c);
    arrayOfObject[1] = Integer.valueOf(this.d);
    arrayOfObject[2] = this.b.toString();
    return String.format("Image %dx%d %s", arrayOfObject);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.WebImage
 * JD-Core Version:    0.6.0
 */