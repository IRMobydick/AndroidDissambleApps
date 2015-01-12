package com.squareup.picasso;

import android.graphics.Bitmap;

class GetAction extends Action<Void>
{
  GetAction(Picasso paramPicasso, Request paramRequest, boolean paramBoolean, String paramString)
  {
    super(paramPicasso, null, paramRequest, paramBoolean, false, 0, null, paramString);
  }

  void complete(Bitmap paramBitmap, Picasso.LoadedFrom paramLoadedFrom)
  {
  }

  public void error()
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.GetAction
 * JD-Core Version:    0.6.2
 */