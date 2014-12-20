package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.kt;
import java.lang.ref.WeakReference;

public final class g extends e
{
  private WeakReference d;

  protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!paramBoolean2)
    {
      a locala = (a)this.d.get();
      if (locala != null)
        locala.a(this.a.a, paramDrawable, paramBoolean3);
    }
  }

  public boolean equals(Object paramObject)
  {
    int i = 0;
    if (!(paramObject instanceof g));
    while (true)
    {
      return i;
      if (this != paramObject)
        break;
      i = 1;
    }
    g localg = (g)paramObject;
    a locala1 = (a)this.d.get();
    a locala2 = (a)localg.d.get();
    if ((locala2 != null) && (locala1 != null) && (kt.a(locala2, locala1)) && (kt.a(localg.a, this.a)));
    for (int j = 1; ; j = 0)
    {
      i = j;
      break;
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
 * Qualified Name:     com.google.android.gms.common.images.g
 * JD-Core Version:    0.6.0
 */