package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.ja;
import com.google.android.gms.internal.kc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager
{
  private static final Object Ks = new Object();
  private static HashSet<Uri> Kt = new HashSet();
  private static ImageManager Ku;
  private static ImageManager Kv;
  private final Map<Uri, ImageReceiver> KA;
  private final Map<Uri, Long> KB;
  private final ExecutorService Kw;
  private final b Kx;
  private final iz Ky;
  private final Map<a, ImageReceiver> Kz;
  private final Context mContext;
  private final Handler mHandler;

  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(Looper.getMainLooper());
    this.Kw = Executors.newFixedThreadPool(4);
    if (paramBoolean)
    {
      this.Kx = new b(this.mContext);
      if (kc.hE())
        gG();
    }
    while (true)
    {
      this.Ky = new iz();
      this.Kz = new HashMap();
      this.KA = new HashMap();
      this.KB = new HashMap();
      return;
      this.Kx = null;
    }
  }

  private Bitmap a(a.a parama)
  {
    if (this.Kx == null)
      return null;
    return (Bitmap)this.Kx.get(parama);
  }

  public static ImageManager c(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Kv == null)
        Kv = new ImageManager(paramContext, true);
      return Kv;
    }
    if (Ku == null)
      Ku = new ImageManager(paramContext, false);
    return Ku;
  }

  public static ImageManager create(Context paramContext)
  {
    return c(paramContext, false);
  }

  private void gG()
  {
    this.mContext.registerComponentCallbacks(new e(this.Kx));
  }

  public void a(a parama)
  {
    com.google.android.gms.common.internal.a.aT("ImageManager.loadImage() must be called in the main thread");
    new d(parama).run();
  }

  public void loadImage(ImageView paramImageView, int paramInt)
  {
    a(new a.b(paramImageView, paramInt));
  }

  public void loadImage(ImageView paramImageView, Uri paramUri)
  {
    a(new a.b(paramImageView, paramUri));
  }

  public void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    a.b localb = new a.b(paramImageView, paramUri);
    localb.aw(paramInt);
    a(localb);
  }

  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    a(new a.c(paramOnImageLoadedListener, paramUri));
  }

  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    a.c localc = new a.c(paramOnImageLoadedListener, paramUri);
    localc.aw(paramInt);
    a(localc);
  }

  private final class ImageReceiver extends ResultReceiver
  {
    private final ArrayList<a> KC;
    private final Uri mUri;

    ImageReceiver(Uri arg2)
    {
      super();
      Object localObject;
      this.mUri = localObject;
      this.KC = new ArrayList();
    }

    public void b(a parama)
    {
      com.google.android.gms.common.internal.a.aT("ImageReceiver.addImageRequest() must be called in the main thread");
      this.KC.add(parama);
    }

    public void c(a parama)
    {
      com.google.android.gms.common.internal.a.aT("ImageReceiver.removeImageRequest() must be called in the main thread");
      this.KC.remove(parama);
    }

    public void gJ()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.b(ImageManager.this).sendBroadcast(localIntent);
    }

    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      ParcelFileDescriptor localParcelFileDescriptor = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager.f(ImageManager.this).execute(new ImageManager.c(ImageManager.this, this.mUri, localParcelFileDescriptor));
    }
  }

  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }

  private static final class a
  {
    static int a(ActivityManager paramActivityManager)
    {
      return paramActivityManager.getLargeMemoryClass();
    }
  }

  private static final class b extends ja<a.a, Bitmap>
  {
    public b(Context paramContext)
    {
      super();
    }

    private static int I(Context paramContext)
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      int i;
      if ((0x100000 & paramContext.getApplicationInfo().flags) != 0)
      {
        i = 1;
        if ((i == 0) || (!kc.hB()))
          break label55;
      }
      label55: for (int j = ImageManager.a.a(localActivityManager); ; j = localActivityManager.getMemoryClass())
      {
        return (int)(0.33F * (j * 1048576));
        i = 0;
        break;
      }
    }

    protected int a(a.a parama, Bitmap paramBitmap)
    {
      return paramBitmap.getHeight() * paramBitmap.getRowBytes();
    }

    protected void a(boolean paramBoolean, a.a parama, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super.entryRemoved(paramBoolean, parama, paramBitmap1, paramBitmap2);
    }
  }

  private final class c
    implements Runnable
  {
    private final ParcelFileDescriptor KE;
    private final Uri mUri;

    public c(Uri paramParcelFileDescriptor, ParcelFileDescriptor arg3)
    {
      this.mUri = paramParcelFileDescriptor;
      Object localObject;
      this.KE = localObject;
    }

    public void run()
    {
      com.google.android.gms.common.internal.a.aU("LoadBitmapFromDiskRunnable can't be executed in the main thread");
      ParcelFileDescriptor localParcelFileDescriptor = this.KE;
      Object localObject = null;
      boolean bool = false;
      if (localParcelFileDescriptor != null);
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFileDescriptor(this.KE.getFileDescriptor());
        localObject = localBitmap;
      }
      catch (OutOfMemoryError localIOException)
      {
        try
        {
          this.KE.close();
          localCountDownLatch = new CountDownLatch(1);
          ImageManager.g(ImageManager.this).post(new ImageManager.f(ImageManager.this, this.mUri, localObject, bool, localCountDownLatch));
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
              Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, localOutOfMemoryError);
              bool = true;
              localObject = null;
            }
            localIOException = localIOException;
            Log.e("ImageManager", "closed failed", localIOException);
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
          }
        }
      }
    }
  }

  private final class d
    implements Runnable
  {
    private final a KF;

    public d(a arg2)
    {
      Object localObject;
      this.KF = localObject;
    }

    public void run()
    {
      com.google.android.gms.common.internal.a.aT("LoadImageRunnable must be executed on the main thread");
      ImageManager.ImageReceiver localImageReceiver1 = (ImageManager.ImageReceiver)ImageManager.a(ImageManager.this).get(this.KF);
      if (localImageReceiver1 != null)
      {
        ImageManager.a(ImageManager.this).remove(this.KF);
        localImageReceiver1.c(this.KF);
      }
      a.a locala = this.KF.KH;
      if (locala.uri == null)
      {
        this.KF.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), true);
        return;
      }
      Bitmap localBitmap = ImageManager.a(ImageManager.this, locala);
      if (localBitmap != null)
      {
        this.KF.a(ImageManager.b(ImageManager.this), localBitmap, true);
        return;
      }
      Long localLong = (Long)ImageManager.d(ImageManager.this).get(locala.uri);
      if (localLong != null)
      {
        if (SystemClock.elapsedRealtime() - localLong.longValue() < 3600000L)
        {
          this.KF.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), true);
          return;
        }
        ImageManager.d(ImageManager.this).remove(locala.uri);
      }
      this.KF.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this));
      ImageManager.ImageReceiver localImageReceiver2 = (ImageManager.ImageReceiver)ImageManager.e(ImageManager.this).get(locala.uri);
      if (localImageReceiver2 == null)
      {
        localImageReceiver2 = new ImageManager.ImageReceiver(ImageManager.this, locala.uri);
        ImageManager.e(ImageManager.this).put(locala.uri, localImageReceiver2);
      }
      localImageReceiver2.b(this.KF);
      if (!(this.KF instanceof a.c))
        ImageManager.a(ImageManager.this).put(this.KF, localImageReceiver2);
      synchronized (ImageManager.gH())
      {
        if (!ImageManager.gI().contains(locala.uri))
        {
          ImageManager.gI().add(locala.uri);
          localImageReceiver2.gJ();
        }
        return;
      }
    }
  }

  private static final class e
    implements ComponentCallbacks2
  {
    private final ImageManager.b Kx;

    public e(ImageManager.b paramb)
    {
      this.Kx = paramb;
    }

    public void onConfigurationChanged(Configuration paramConfiguration)
    {
    }

    public void onLowMemory()
    {
      this.Kx.evictAll();
    }

    public void onTrimMemory(int paramInt)
    {
      if (paramInt >= 60)
        this.Kx.evictAll();
      while (paramInt < 20)
        return;
      this.Kx.trimToSize(this.Kx.size() / 2);
    }
  }

  private final class f
    implements Runnable
  {
    private boolean KG;
    private final Bitmap mBitmap;
    private final Uri mUri;
    private final CountDownLatch mg;

    public f(Uri paramBitmap, Bitmap paramBoolean, boolean paramCountDownLatch, CountDownLatch arg5)
    {
      this.mUri = paramBitmap;
      this.mBitmap = paramBoolean;
      this.KG = paramCountDownLatch;
      Object localObject;
      this.mg = localObject;
    }

    private void a(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
    {
      ArrayList localArrayList = ImageManager.ImageReceiver.a(paramImageReceiver);
      int i = localArrayList.size();
      int j = 0;
      if (j < i)
      {
        a locala = (a)localArrayList.get(j);
        if (paramBoolean)
          locala.a(ImageManager.b(ImageManager.this), this.mBitmap, false);
        while (true)
        {
          if (!(locala instanceof a.c))
            ImageManager.a(ImageManager.this).remove(locala);
          j++;
          break;
          ImageManager.d(ImageManager.this).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
          locala.a(ImageManager.b(ImageManager.this), ImageManager.c(ImageManager.this), false);
        }
      }
    }

    public void run()
    {
      com.google.android.gms.common.internal.a.aT("OnBitmapLoadedRunnable must be executed in the main thread");
      boolean bool;
      if (this.mBitmap != null)
        bool = true;
      while (ImageManager.h(ImageManager.this) != null)
        if (this.KG)
        {
          ImageManager.h(ImageManager.this).evictAll();
          System.gc();
          this.KG = false;
          ImageManager.g(ImageManager.this).post(this);
          return;
          bool = false;
        }
        else if (bool)
        {
          ImageManager.h(ImageManager.this).put(new a.a(this.mUri), this.mBitmap);
        }
      ImageManager.ImageReceiver localImageReceiver = (ImageManager.ImageReceiver)ImageManager.e(ImageManager.this).remove(this.mUri);
      if (localImageReceiver != null)
        a(localImageReceiver, bool);
      this.mg.countDown();
      synchronized (ImageManager.gH())
      {
        ImageManager.gI().remove(this.mUri);
        return;
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager
 * JD-Core Version:    0.6.2
 */