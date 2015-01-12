package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;

class AssetBitmapHunter extends BitmapHunter
{
  protected static final String ANDROID_ASSET = "android_asset";
  private static final int ASSET_PREFIX_LENGTH = "file:///android_asset/".length();
  private final AssetManager assetManager;

  public AssetBitmapHunter(Context paramContext, Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    super(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    this.assetManager = paramContext.getAssets();
  }

  Bitmap decode(Request paramRequest)
    throws IOException
  {
    return decodeAsset(paramRequest.uri.toString().substring(ASSET_PREFIX_LENGTH));
  }

  // ERROR //
  Bitmap decodeAsset(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 65	com/squareup/picasso/AssetBitmapHunter:data	Lcom/squareup/picasso/Request;
    //   4: invokestatic 69	com/squareup/picasso/AssetBitmapHunter:createBitmapOptions	(Lcom/squareup/picasso/Request;)Landroid/graphics/BitmapFactory$Options;
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 73	com/squareup/picasso/AssetBitmapHunter:requiresInSampleSize	(Landroid/graphics/BitmapFactory$Options;)Z
    //   12: ifeq +47 -> 59
    //   15: aconst_null
    //   16: astore 6
    //   18: aload_0
    //   19: getfield 37	com/squareup/picasso/AssetBitmapHunter:assetManager	Landroid/content/res/AssetManager;
    //   22: aload_1
    //   23: invokevirtual 79	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   26: astore 6
    //   28: aload 6
    //   30: aconst_null
    //   31: aload_2
    //   32: invokestatic 85	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   35: pop
    //   36: aload 6
    //   38: invokestatic 91	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   41: aload_0
    //   42: getfield 65	com/squareup/picasso/AssetBitmapHunter:data	Lcom/squareup/picasso/Request;
    //   45: getfield 94	com/squareup/picasso/Request:targetWidth	I
    //   48: aload_0
    //   49: getfield 65	com/squareup/picasso/AssetBitmapHunter:data	Lcom/squareup/picasso/Request;
    //   52: getfield 97	com/squareup/picasso/Request:targetHeight	I
    //   55: aload_2
    //   56: invokestatic 101	com/squareup/picasso/AssetBitmapHunter:calculateInSampleSize	(IILandroid/graphics/BitmapFactory$Options;)V
    //   59: aload_0
    //   60: getfield 37	com/squareup/picasso/AssetBitmapHunter:assetManager	Landroid/content/res/AssetManager;
    //   63: aload_1
    //   64: invokevirtual 79	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   67: astore_3
    //   68: aload_3
    //   69: aconst_null
    //   70: aload_2
    //   71: invokestatic 85	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   74: astore 5
    //   76: aload_3
    //   77: invokestatic 91	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   80: aload 5
    //   82: areturn
    //   83: astore 7
    //   85: aload 6
    //   87: invokestatic 91	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   90: aload 7
    //   92: athrow
    //   93: astore 4
    //   95: aload_3
    //   96: invokestatic 91	com/squareup/picasso/Utils:closeQuietly	(Ljava/io/InputStream;)V
    //   99: aload 4
    //   101: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   18	36	83	finally
    //   68	76	93	finally
  }

  Picasso.LoadedFrom getLoadedFrom()
  {
    return Picasso.LoadedFrom.DISK;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.AssetBitmapHunter
 * JD-Core Version:    0.6.2
 */