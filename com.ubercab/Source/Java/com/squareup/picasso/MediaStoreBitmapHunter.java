package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video.Thumbnails;
import java.io.IOException;

class MediaStoreBitmapHunter extends ContentStreamBitmapHunter
{
  private static final String[] CONTENT_ORIENTATION = { "orientation" };

  MediaStoreBitmapHunter(Context paramContext, Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    super(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
  }

  static int getExifOrientation(ContentResolver paramContentResolver, Uri paramUri)
  {
    Cursor localCursor = null;
    try
    {
      localCursor = paramContentResolver.query(paramUri, CONTENT_ORIENTATION, null, null, null);
      if (localCursor != null)
      {
        boolean bool = localCursor.moveToFirst();
        if (bool);
      }
      else
      {
        if (localCursor != null)
          localCursor.close();
        j = 0;
        return j;
      }
      int i = localCursor.getInt(0);
      int j = i;
      return j;
    }
    catch (RuntimeException localRuntimeException)
    {
      return 0;
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
  }

  static PicassoKind getPicassoKind(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= PicassoKind.MICRO.width) && (paramInt2 <= PicassoKind.MICRO.height))
      return PicassoKind.MICRO;
    if ((paramInt1 <= PicassoKind.MINI.width) && (paramInt2 <= PicassoKind.MINI.height))
      return PicassoKind.MINI;
    return PicassoKind.FULL;
  }

  Bitmap decode(Request paramRequest)
    throws IOException
  {
    ContentResolver localContentResolver = this.context.getContentResolver();
    setExifRotation(getExifOrientation(localContentResolver, paramRequest.uri));
    String str = localContentResolver.getType(paramRequest.uri);
    int i;
    PicassoKind localPicassoKind;
    Bitmap localBitmap;
    if ((str != null) && (str.startsWith("video/")))
    {
      i = 1;
      if (!paramRequest.hasSize())
        break label171;
      localPicassoKind = getPicassoKind(paramRequest.targetWidth, paramRequest.targetHeight);
      if ((i != 0) || (localPicassoKind != PicassoKind.FULL))
        break label94;
      localBitmap = super.decode(paramRequest);
    }
    label171: label203: 
    while (true)
    {
      return localBitmap;
      i = 0;
      break;
      label94: long l = ContentUris.parseId(paramRequest.uri);
      BitmapFactory.Options localOptions = createBitmapOptions(paramRequest);
      localOptions.inJustDecodeBounds = true;
      calculateInSampleSize(paramRequest.targetWidth, paramRequest.targetHeight, localPicassoKind.width, localPicassoKind.height, localOptions);
      int j;
      if (i != 0)
        if (localPicassoKind == PicassoKind.FULL)
          j = 1;
      for (localBitmap = MediaStore.Video.Thumbnails.getThumbnail(localContentResolver, l, j, localOptions); ; localBitmap = MediaStore.Images.Thumbnails.getThumbnail(localContentResolver, l, localPicassoKind.androidKind, localOptions))
      {
        if (localBitmap != null)
          break label203;
        return super.decode(paramRequest);
        j = localPicassoKind.androidKind;
        break;
      }
    }
  }

  static enum PicassoKind
  {
    final int androidKind;
    final int height;
    final int width;

    static
    {
      FULL = new PicassoKind("FULL", 2, 2, -1, -1);
      PicassoKind[] arrayOfPicassoKind = new PicassoKind[3];
      arrayOfPicassoKind[0] = MICRO;
      arrayOfPicassoKind[1] = MINI;
      arrayOfPicassoKind[2] = FULL;
    }

    private PicassoKind(int paramInt1, int paramInt2, int paramInt3)
    {
      this.androidKind = paramInt1;
      this.width = paramInt2;
      this.height = paramInt3;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.MediaStoreBitmapHunter
 * JD-Core Version:    0.6.2
 */