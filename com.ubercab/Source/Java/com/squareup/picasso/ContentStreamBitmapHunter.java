package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.IOException;

class ContentStreamBitmapHunter extends BitmapHunter
{
  final Context context;

  ContentStreamBitmapHunter(Context paramContext, Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    super(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    this.context = paramContext;
  }

  Bitmap decode(Request paramRequest)
    throws IOException
  {
    return decodeContentStream(paramRequest);
  }

  // ERROR //
  protected Bitmap decodeContentStream(Request paramRequest)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	com/squareup/picasso/ContentStreamBitmapHunter:context	Landroid/content/Context;
    //   4: invokevirtual 26	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore_2
    //   8: aload_1
    //   9: invokestatic 30	com/squareup/picasso/ContentStreamBitmapHunter:createBitmapOptions	(Lcom/squareup/picasso/Request;)Landroid/graphics/BitmapFactory$Options;
    //   12: astore_3
    //   13: aload_3
    //   14: invokestatic 34	com/squareup/picasso/ContentStreamBitmapHunter:requiresInSampleSize	(Landroid/graphics/BitmapFactory$Options;)Z
    //   17: ifeq +41 -> 58
    //   20: aconst_null
    //   21: astore 7
    //   23: aload_2
    //   24: aload_1
    //   25: getfield 40	com/squareup/picasso/Request:uri	Landroid/net/Uri;
    //   28: invokevirtual 46	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   31: astore 7
    //   33: aload 7
    //   35: aconst_null
    //   36: aload_3
    //   37: invokestatic 52	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   40: pop
    //   41: aload 7
    //   43: invokestatic 58	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   46: aload_1
    //   47: getfield 62	com/squareup/picasso/Request:targetWidth	I
    //   50: aload_1
    //   51: getfield 65	com/squareup/picasso/Request:targetHeight	I
    //   54: aload_3
    //   55: invokestatic 69	com/squareup/picasso/ContentStreamBitmapHunter:calculateInSampleSize	(IILandroid/graphics/BitmapFactory$Options;)V
    //   58: aload_2
    //   59: aload_1
    //   60: getfield 40	com/squareup/picasso/Request:uri	Landroid/net/Uri;
    //   63: invokevirtual 46	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   66: astore 4
    //   68: aload 4
    //   70: aconst_null
    //   71: aload_3
    //   72: invokestatic 52	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   75: astore 6
    //   77: aload 4
    //   79: invokestatic 58	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   82: aload 6
    //   84: areturn
    //   85: astore 8
    //   87: aload 7
    //   89: invokestatic 58	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   92: aload 8
    //   94: athrow
    //   95: astore 5
    //   97: aload 4
    //   99: invokestatic 58	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   102: aload 5
    //   104: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   23	41	85	finally
    //   68	77	95	finally
  }

  Picasso.LoadedFrom getLoadedFrom()
  {
    return Picasso.LoadedFrom.DISK;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.ContentStreamBitmapHunter
 * JD-Core Version:    0.6.2
 */