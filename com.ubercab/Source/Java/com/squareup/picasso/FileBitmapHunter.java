package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import java.io.IOException;

class FileBitmapHunter extends ContentStreamBitmapHunter
{
  FileBitmapHunter(Context paramContext, Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    super(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
  }

  static int getFileExifRotation(Uri paramUri)
    throws IOException
  {
    switch (new ExifInterface(paramUri.getPath()).getAttributeInt("Orientation", 1))
    {
    case 4:
    case 5:
    case 7:
    default:
      return 0;
    case 6:
      return 90;
    case 3:
      return 180;
    case 8:
    }
    return 270;
  }

  Bitmap decode(Request paramRequest)
    throws IOException
  {
    setExifRotation(getFileExifRotation(paramRequest.uri));
    return super.decode(paramRequest);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.FileBitmapHunter
 * JD-Core Version:    0.6.2
 */