package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;

class NetworkBitmapHunter extends BitmapHunter
{
  static final int DEFAULT_RETRY_COUNT = 2;
  private static final int MARKER = 65536;
  private final Downloader downloader;
  int retryCount;

  public NetworkBitmapHunter(Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction, Downloader paramDownloader)
  {
    super(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    this.downloader = paramDownloader;
    this.retryCount = 2;
  }

  private Bitmap decodeStream(InputStream paramInputStream, Request paramRequest)
    throws IOException
  {
    MarkableInputStream localMarkableInputStream = new MarkableInputStream(paramInputStream);
    long l = localMarkableInputStream.savePosition(65536);
    BitmapFactory.Options localOptions = createBitmapOptions(paramRequest);
    boolean bool1 = requiresInSampleSize(localOptions);
    boolean bool2 = Utils.isWebPFile(localMarkableInputStream);
    localMarkableInputStream.reset(l);
    Bitmap localBitmap;
    if (bool2)
    {
      byte[] arrayOfByte = Utils.toByteArray(localMarkableInputStream);
      if (bool1)
      {
        BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
        calculateInSampleSize(paramRequest.targetWidth, paramRequest.targetHeight, localOptions);
      }
      localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
    }
    do
    {
      return localBitmap;
      if (bool1)
      {
        BitmapFactory.decodeStream(localMarkableInputStream, null, localOptions);
        calculateInSampleSize(paramRequest.targetWidth, paramRequest.targetHeight, localOptions);
        localMarkableInputStream.reset(l);
      }
      localBitmap = BitmapFactory.decodeStream(localMarkableInputStream, null, localOptions);
    }
    while (localBitmap != null);
    throw new IOException("Failed to decode stream.");
  }

  Bitmap decode(Request paramRequest)
    throws IOException
  {
    if (this.retryCount == 0);
    Downloader.Response localResponse;
    Bitmap localBitmap1;
    for (boolean bool = true; ; bool = false)
    {
      localResponse = this.downloader.load(paramRequest.uri, bool);
      if (localResponse != null)
        break;
      localBitmap1 = null;
      return localBitmap1;
    }
    if (localResponse.cached);
    InputStream localInputStream;
    for (Picasso.LoadedFrom localLoadedFrom = Picasso.LoadedFrom.DISK; ; localLoadedFrom = Picasso.LoadedFrom.NETWORK)
    {
      this.loadedFrom = localLoadedFrom;
      localBitmap1 = localResponse.getBitmap();
      if (localBitmap1 != null)
        break;
      localInputStream = localResponse.getInputStream();
      if (localInputStream != null)
        break label89;
      return null;
    }
    label89: if (localResponse.getContentLength() == 0L)
    {
      Utils.closeQuietly(localInputStream);
      throw new IOException("Received response with 0 content-length header.");
    }
    if ((this.loadedFrom == Picasso.LoadedFrom.NETWORK) && (localResponse.getContentLength() > 0L))
      this.stats.dispatchDownloadFinished(localResponse.getContentLength());
    try
    {
      Bitmap localBitmap2 = decodeStream(localInputStream, paramRequest);
      return localBitmap2;
    }
    finally
    {
      Utils.closeQuietly(localInputStream);
    }
  }

  boolean shouldRetry(boolean paramBoolean, NetworkInfo paramNetworkInfo)
  {
    int i;
    if (this.retryCount > 0)
    {
      i = 1;
      if (i != 0)
        break label20;
    }
    label20: 
    do
    {
      return false;
      i = 0;
      break;
      this.retryCount = (-1 + this.retryCount);
    }
    while ((paramNetworkInfo != null) && (!paramNetworkInfo.isConnected()));
    return true;
  }

  boolean supportsReplay()
  {
    return true;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.NetworkBitmapHunter
 * JD-Core Version:    0.6.2
 */