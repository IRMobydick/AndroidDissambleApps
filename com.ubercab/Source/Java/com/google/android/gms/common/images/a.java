package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.internal.iw;
import com.google.android.gms.internal.ix;
import com.google.android.gms.internal.iy;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.iz.a;
import java.lang.ref.WeakReference;

public abstract class a
{
  final a KH;
  protected int KI = 0;
  protected int KJ = 0;
  protected ImageManager.OnImageLoadedListener KK;
  private boolean KL = true;
  private boolean KM = false;
  protected int KN;

  public a(Uri paramUri, int paramInt)
  {
    this.KH = new a(paramUri);
    this.KJ = paramInt;
  }

  private Drawable a(Context paramContext, iz paramiz, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    if (this.KN > 0)
    {
      iz.a locala = new iz.a(paramInt, this.KN);
      Drawable localDrawable = (Drawable)paramiz.get(locala);
      if (localDrawable == null)
      {
        localDrawable = localResources.getDrawable(paramInt);
        if ((0x1 & this.KN) != 0)
          localDrawable = a(localResources, localDrawable);
        paramiz.put(locala, localDrawable);
      }
      return localDrawable;
    }
    return localResources.getDrawable(paramInt);
  }

  protected Drawable a(Resources paramResources, Drawable paramDrawable)
  {
    return ix.a(paramResources, paramDrawable);
  }

  protected iw a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null)
      if (!(paramDrawable1 instanceof iw));
    for (paramDrawable1 = ((iw)paramDrawable1).gK(); ; paramDrawable1 = null)
      return new iw(paramDrawable1, paramDrawable2);
  }

  void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    com.google.android.gms.common.internal.a.f(paramBitmap);
    if ((0x1 & this.KN) != 0)
      paramBitmap = ix.a(paramBitmap);
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), paramBitmap);
    if (this.KK != null)
      this.KK.onImageLoaded(this.KH.uri, localBitmapDrawable, true);
    a(localBitmapDrawable, paramBoolean, false, true);
  }

  void a(Context paramContext, iz paramiz)
  {
    int i = this.KI;
    Drawable localDrawable = null;
    if (i != 0)
      localDrawable = a(paramContext, paramiz, this.KI);
    a(localDrawable, false, true, false);
  }

  void a(Context paramContext, iz paramiz, boolean paramBoolean)
  {
    int i = this.KJ;
    Drawable localDrawable = null;
    if (i != 0)
      localDrawable = a(paramContext, paramiz, this.KJ);
    if (this.KK != null)
      this.KK.onImageLoaded(this.KH.uri, localDrawable, false);
    a(localDrawable, paramBoolean, false, false);
  }

  protected abstract void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);

  public void aw(int paramInt)
  {
    this.KJ = paramInt;
  }

  protected boolean b(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.KL) && (!paramBoolean2) && ((!paramBoolean1) || (this.KM));
  }

  static final class a
  {
    public final Uri uri;

    public a(Uri paramUri)
    {
      this.uri = paramUri;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a))
        return false;
      if (this == paramObject)
        return true;
      return n.equal(((a)paramObject).uri, this.uri);
    }

    public int hashCode()
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.uri;
      return n.hashCode(arrayOfObject);
    }
  }

  public static final class b extends a
  {
    private WeakReference<ImageView> KO;

    public b(ImageView paramImageView, int paramInt)
    {
      super(paramInt);
      com.google.android.gms.common.internal.a.f(paramImageView);
      this.KO = new WeakReference(paramImageView);
    }

    public b(ImageView paramImageView, Uri paramUri)
    {
      super(0);
      com.google.android.gms.common.internal.a.f(paramImageView);
      this.KO = new WeakReference(paramImageView);
    }

    private void a(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if ((!paramBoolean2) && (!paramBoolean3));
      for (int i = 1; (i != 0) && ((paramImageView instanceof iy)); i = 0)
      {
        int k = ((iy)paramImageView).gM();
        if ((this.KJ == 0) || (k != this.KJ))
          break;
        return;
      }
      boolean bool = b(paramBoolean1, paramBoolean2);
      if (bool);
      for (Object localObject = a(paramImageView.getDrawable(), paramDrawable); ; localObject = paramDrawable)
      {
        paramImageView.setImageDrawable((Drawable)localObject);
        iy localiy;
        Uri localUri;
        if ((paramImageView instanceof iy))
        {
          localiy = (iy)paramImageView;
          if (!paramBoolean3)
            break label157;
          localUri = this.KH.uri;
          label115: localiy.g(localUri);
          if (i == 0)
            break label163;
        }
        label157: label163: for (int j = this.KJ; ; j = 0)
        {
          localiy.ay(j);
          if (!bool)
            break;
          ((iw)localObject).startTransition(250);
          return;
          localUri = null;
          break label115;
        }
      }
    }

    protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      ImageView localImageView = (ImageView)this.KO.get();
      if (localImageView != null)
        a(localImageView, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof b))
        return false;
      if (this == paramObject)
        return true;
      b localb = (b)paramObject;
      ImageView localImageView1 = (ImageView)this.KO.get();
      ImageView localImageView2 = (ImageView)localb.KO.get();
      if ((localImageView2 != null) && (localImageView1 != null) && (n.equal(localImageView2, localImageView1)));
      for (boolean bool = true; ; bool = false)
        return bool;
    }

    public int hashCode()
    {
      return 0;
    }
  }

  public static final class c extends a
  {
    private WeakReference<ImageManager.OnImageLoadedListener> KP;

    public c(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
    {
      super(0);
      com.google.android.gms.common.internal.a.f(paramOnImageLoadedListener);
      this.KP = new WeakReference(paramOnImageLoadedListener);
    }

    protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if (!paramBoolean2)
      {
        ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.KP.get();
        if (localOnImageLoadedListener != null)
          localOnImageLoadedListener.onImageLoaded(this.KH.uri, paramDrawable, paramBoolean3);
      }
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof c))
        return false;
      if (this == paramObject)
        return true;
      c localc = (c)paramObject;
      ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)this.KP.get();
      ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)localc.KP.get();
      if ((localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (n.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (n.equal(localc.KH, this.KH)));
      for (boolean bool = true; ; bool = false)
        return bool;
    }

    public int hashCode()
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.KH;
      return n.hashCode(arrayOfObject);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.a
 * JD-Core Version:    0.6.2
 */