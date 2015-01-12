package com.squareup.picasso;

import android.graphics.Bitmap;

public abstract interface Cache
{
  public static final Cache NONE = new Cache()
  {
    public void clear()
    {
    }

    public Bitmap get(String paramAnonymousString)
    {
      return null;
    }

    public int maxSize()
    {
      return 0;
    }

    public void set(String paramAnonymousString, Bitmap paramAnonymousBitmap)
    {
    }

    public int size()
    {
      return 0;
    }
  };

  public abstract void clear();

  public abstract Bitmap get(String paramString);

  public abstract int maxSize();

  public abstract void set(String paramString, Bitmap paramBitmap);

  public abstract int size();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Cache
 * JD-Core Version:    0.6.2
 */