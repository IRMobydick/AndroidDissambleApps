package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jf;
import com.google.android.gms.internal.kt;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  String a;
  String b;
  List c;
  List d;
  String e;
  Uri f;
  private final int g;

  private ApplicationMetadata()
  {
    this.g = 1;
    this.c = new ArrayList();
    this.d = new ArrayList();
  }

  ApplicationMetadata(int paramInt, String paramString1, String paramString2, List paramList1, List paramList2, String paramString3, Uri paramUri)
  {
    this.g = paramInt;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramList1;
    this.d = paramList2;
    this.e = paramString3;
    this.f = paramUri;
  }

  int a()
  {
    return this.g;
  }

  public String b()
  {
    return this.a;
  }

  public String c()
  {
    return this.b;
  }

  public String d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public Uri e()
  {
    return this.f;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (paramObject == this);
    while (true)
    {
      return i;
      if (!(paramObject instanceof ApplicationMetadata))
      {
        i = 0;
        continue;
      }
      ApplicationMetadata localApplicationMetadata = (ApplicationMetadata)paramObject;
      if ((jf.a(this.a, localApplicationMetadata.a)) && (jf.a(this.c, localApplicationMetadata.c)) && (jf.a(this.b, localApplicationMetadata.b)) && (jf.a(this.d, localApplicationMetadata.d)) && (jf.a(this.e, localApplicationMetadata.e)) && (jf.a(this.f, localApplicationMetadata.f)))
        continue;
      i = 0;
    }
  }

  public List f()
  {
    return this.c;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.g);
    arrayOfObject[1] = this.a;
    arrayOfObject[2] = this.b;
    arrayOfObject[3] = this.c;
    arrayOfObject[4] = this.d;
    arrayOfObject[5] = this.e;
    arrayOfObject[6] = this.f;
    return kt.a(arrayOfObject);
  }

  public String toString()
  {
    return this.b;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.ApplicationMetadata
 * JD-Core Version:    0.6.0
 */