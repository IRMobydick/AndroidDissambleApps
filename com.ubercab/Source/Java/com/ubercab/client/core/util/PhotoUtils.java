package com.ubercab.client.core.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public final class PhotoUtils
{
  private static final String[] PHOTO_PROJECTION = { "data15" };

  public static byte[] getPhoto(Context paramContext, Uri paramUri)
  {
    Object localObject2;
    if (paramContext == null)
      localObject2 = null;
    while (true)
    {
      return localObject2;
      if (paramUri == null)
        return null;
      Cursor localCursor = null;
      try
      {
        localCursor = paramContext.getContentResolver().query(paramUri, PHOTO_PROJECTION, null, null, null);
        int i = localCursor.getCount();
        if (i == 0)
          return null;
        localCursor.moveToFirst();
        byte[] arrayOfByte = localCursor.getBlob(localCursor.getColumnIndex("data15"));
        localObject2 = arrayOfByte;
        return localObject2;
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.PhotoUtils
 * JD-Core Version:    0.6.2
 */