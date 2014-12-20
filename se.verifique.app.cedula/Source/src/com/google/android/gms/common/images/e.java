package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.ji;
import com.google.android.gms.internal.jj;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jn;

public abstract class e
{
  final f a;
  protected int b;
  protected int c;

  private Drawable a(Context paramContext, jj paramjj, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    Drawable localDrawable;
    if (this.c > 0)
    {
      jl localjl = new jl(paramInt, this.c);
      localDrawable = (Drawable)paramjj.a(localjl);
      if (localDrawable == null)
      {
        localDrawable = localResources.getDrawable(paramInt);
        if ((0x1 & this.c) != 0)
          localDrawable = a(localResources, localDrawable);
        paramjj.b(localjl, localDrawable);
      }
    }
    while (true)
    {
      return localDrawable;
      localDrawable = localResources.getDrawable(paramInt);
    }
  }

  protected Drawable a(Resources paramResources, Drawable paramDrawable)
  {
    return ji.a(paramResources, paramDrawable);
  }

  void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    jn.a(paramBitmap);
    if ((0x1 & this.c) != 0)
      paramBitmap = ji.a(paramBitmap);
    a(new BitmapDrawable(paramContext.getResources(), paramBitmap), paramBoolean, false, true);
  }

  void a(Context paramContext, jj paramjj, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (this.b != 0)
      localDrawable = a(paramContext, paramjj, this.b);
    a(localDrawable, paramBoolean, false, false);
  }

  protected abstract void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.e
 * JD-Core Version:    0.6.0
 */