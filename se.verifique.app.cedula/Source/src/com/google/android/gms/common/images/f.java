package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.internal.kt;

final class f
{
  public final Uri a;

  public f(Uri paramUri)
  {
    this.a = paramUri;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (!(paramObject instanceof f))
      bool = false;
    while (true)
    {
      return bool;
      if (this == paramObject)
      {
        bool = true;
        continue;
      }
      bool = kt.a(((f)paramObject).a, this.a);
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.a;
    return kt.a(arrayOfObject);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.f
 * JD-Core Version:    0.6.0
 */