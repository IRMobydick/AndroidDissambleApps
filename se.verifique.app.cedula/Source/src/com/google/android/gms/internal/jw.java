package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class jw
  implements SafeParcelable
{
  public static final jw a = a("test_type", 1);
  public static final jw b = a("saved_offers", 4);
  public static final Set c;
  public static final mv d;
  final int e;
  final String f;
  final int g;

  static
  {
    jw[] arrayOfjw = new jw[2];
    arrayOfjw[0] = a;
    arrayOfjw[1] = b;
    c = Collections.unmodifiableSet(new HashSet(Arrays.asList(arrayOfjw)));
    d = new mv();
  }

  jw(int paramInt1, String paramString, int paramInt2)
  {
    kx.a(paramString);
    this.e = paramInt1;
    this.f = paramString;
    this.g = paramInt2;
  }

  private static jw a(String paramString, int paramInt)
  {
    return new jw(0, paramString, paramInt);
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
      if (!(paramObject instanceof jw))
      {
        i = 0;
        continue;
      }
      jw localjw = (jw)paramObject;
      if ((this.f.equals(localjw.f)) && (this.g == localjw.g))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    return this.f.hashCode();
  }

  public String toString()
  {
    return this.f;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mv.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jw
 * JD-Core Version:    0.6.0
 */