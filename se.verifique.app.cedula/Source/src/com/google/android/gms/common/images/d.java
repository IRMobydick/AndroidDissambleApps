package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.internal.jn;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class d
  implements Runnable
{
  private final Uri b;
  private final Bitmap c;
  private final CountDownLatch d;
  private boolean e;

  public d(ImageManager paramImageManager, Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
  {
    this.b = paramUri;
    this.c = paramBitmap;
    this.e = paramBoolean;
    this.d = paramCountDownLatch;
  }

  private void a(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
  {
    ArrayList localArrayList = ImageManager.ImageReceiver.a(paramImageReceiver);
    int i = localArrayList.size();
    int j = 0;
    if (j < i)
    {
      e locale = (e)localArrayList.get(j);
      if (paramBoolean)
        locale.a(ImageManager.b(this.a), this.c, false);
      while (true)
      {
        if (!(locale instanceof g))
          ImageManager.a(this.a).remove(locale);
        j++;
        break;
        ImageManager.d(this.a).put(this.b, Long.valueOf(SystemClock.elapsedRealtime()));
        locale.a(ImageManager.b(this.a), ImageManager.c(this.a), false);
      }
    }
  }

  public void run()
  {
    jn.a("OnBitmapLoadedRunnable must be executed in the main thread");
    boolean bool;
    if (this.c != null)
    {
      bool = true;
      if (ImageManager.h(this.a) == null)
        break label97;
      if (!this.e)
        break label67;
      ImageManager.h(this.a).a();
      System.gc();
      this.e = false;
      ImageManager.g(this.a).post(this);
    }
    while (true)
    {
      return;
      bool = false;
      break;
      label67: if (bool)
        ImageManager.h(this.a).b(new f(this.b), this.c);
      label97: ImageManager.ImageReceiver localImageReceiver = (ImageManager.ImageReceiver)ImageManager.e(this.a).remove(this.b);
      if (localImageReceiver != null)
        a(localImageReceiver, bool);
      this.d.countDown();
      synchronized (ImageManager.a())
      {
        ImageManager.b().remove(this.b);
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.d
 * JD-Core Version:    0.6.0
 */