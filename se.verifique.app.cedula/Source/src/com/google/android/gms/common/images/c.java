package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.internal.jn;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

final class c
  implements Runnable
{
  private final Uri b;
  private final ParcelFileDescriptor c;

  public c(ImageManager paramImageManager, Uri paramUri, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.b = paramUri;
    this.c = paramParcelFileDescriptor;
  }

  public void run()
  {
    jn.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
    boolean bool = false;
    Object localObject = null;
    if (this.c != null);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFileDescriptor(this.c.getFileDescriptor());
      localObject = localBitmap;
    }
    catch (IOException localIOException)
    {
      try
      {
        this.c.close();
        localCountDownLatch = new CountDownLatch(1);
        ImageManager.g(this.a).post(new d(this.a, this.b, localObject, bool, localCountDownLatch));
      }
      catch (IOException localIOException)
      {
        try
        {
          while (true)
          {
            CountDownLatch localCountDownLatch;
            localCountDownLatch.await();
            return;
            localOutOfMemoryError = localOutOfMemoryError;
            Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.b, localOutOfMemoryError);
            bool = true;
          }
          localIOException = localIOException;
          Log.e("ImageManager", "closed failed", localIOException);
        }
        catch (InterruptedException localInterruptedException)
        {
          while (true)
            Log.w("ImageManager", "Latch interrupted while posting " + this.b);
        }
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.c
 * JD-Core Version:    0.6.0
 */