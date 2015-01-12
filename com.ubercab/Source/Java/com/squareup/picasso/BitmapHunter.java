package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.provider.ContactsContract.Contacts;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

abstract class BitmapHunter
  implements Runnable
{
  private static final Object DECODE_LOCK = new Object();
  private static final ThreadLocal<StringBuilder> NAME_BUILDER = new ThreadLocal()
  {
    protected StringBuilder initialValue()
    {
      return new StringBuilder("Picasso-");
    }
  };
  Action action;
  List<Action> actions;
  final Cache cache;
  final Request data;
  final Dispatcher dispatcher;
  Exception exception;
  int exifRotation;
  Future<?> future;
  final String key;
  Picasso.LoadedFrom loadedFrom;
  final Picasso picasso;
  Bitmap result;
  final boolean skipMemoryCache;
  final Stats stats;

  BitmapHunter(Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction)
  {
    this.picasso = paramPicasso;
    this.dispatcher = paramDispatcher;
    this.cache = paramCache;
    this.stats = paramStats;
    this.key = paramAction.getKey();
    this.data = paramAction.getRequest();
    this.skipMemoryCache = paramAction.skipCache;
    this.action = paramAction;
  }

  static Bitmap applyCustomTransformations(List<Transformation> paramList, Bitmap paramBitmap)
  {
    int i = 0;
    int j = paramList.size();
    while (true)
    {
      Transformation localTransformation;
      Bitmap localBitmap;
      if (i < j)
      {
        localTransformation = (Transformation)paramList.get(i);
        localBitmap = localTransformation.transform(paramBitmap);
        if (localBitmap == null)
        {
          StringBuilder localStringBuilder = new StringBuilder().append("Transformation ").append(localTransformation.key()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
            localStringBuilder.append(((Transformation)localIterator.next()).key()).append('\n');
          Picasso.HANDLER.post(new Runnable()
          {
            public void run()
            {
              throw new NullPointerException(this.val$builder.toString());
            }
          });
          paramBitmap = null;
        }
      }
      else
      {
        return paramBitmap;
      }
      if ((localBitmap == paramBitmap) && (paramBitmap.isRecycled()))
      {
        Picasso.HANDLER.post(new Runnable()
        {
          public void run()
          {
            throw new IllegalStateException("Transformation " + this.val$transformation.key() + " returned input Bitmap but recycled it.");
          }
        });
        return null;
      }
      if ((localBitmap != paramBitmap) && (!paramBitmap.isRecycled()))
      {
        Picasso.HANDLER.post(new Runnable()
        {
          public void run()
          {
            throw new IllegalStateException("Transformation " + this.val$transformation.key() + " mutated input Bitmap but failed to recycle the original.");
          }
        });
        return null;
      }
      paramBitmap = localBitmap;
      i++;
    }
  }

  static void calculateInSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitmapFactory.Options paramOptions)
  {
    int i = 1;
    int j;
    int k;
    if ((paramInt4 > paramInt2) || (paramInt3 > paramInt1))
    {
      j = Math.round(paramInt4 / paramInt2);
      k = Math.round(paramInt3 / paramInt1);
      if (j >= k)
        break label58;
    }
    label58: for (i = j; ; i = k)
    {
      paramOptions.inSampleSize = i;
      paramOptions.inJustDecodeBounds = false;
      return;
    }
  }

  static void calculateInSampleSize(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    calculateInSampleSize(paramInt1, paramInt2, paramOptions.outWidth, paramOptions.outHeight, paramOptions);
  }

  static BitmapFactory.Options createBitmapOptions(Request paramRequest)
  {
    boolean bool = paramRequest.hasSize();
    if (paramRequest.config != null);
    for (int i = 1; ; i = 0)
    {
      BitmapFactory.Options localOptions;
      if (!bool)
      {
        localOptions = null;
        if (i == 0);
      }
      else
      {
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = bool;
        if (i != 0)
          localOptions.inPreferredConfig = paramRequest.config;
      }
      return localOptions;
    }
  }

  static BitmapHunter forRequest(Context paramContext, Picasso paramPicasso, Dispatcher paramDispatcher, Cache paramCache, Stats paramStats, Action paramAction, Downloader paramDownloader)
  {
    if (paramAction.getRequest().resourceId != 0)
      return new ResourceBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    Uri localUri = paramAction.getRequest().uri;
    String str = localUri.getScheme();
    if ("content".equals(str))
    {
      if ((ContactsContract.Contacts.CONTENT_URI.getHost().equals(localUri.getHost())) && (!localUri.getPathSegments().contains("photo")))
        return new ContactsPhotoBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
      if ("media".equals(localUri.getAuthority()))
        return new MediaStoreBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
      return new ContentStreamBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    }
    if ("file".equals(str))
    {
      if ((!localUri.getPathSegments().isEmpty()) && ("android_asset".equals(localUri.getPathSegments().get(0))))
        return new AssetBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
      return new FileBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    }
    if ("android.resource".equals(str))
      return new ResourceBitmapHunter(paramContext, paramPicasso, paramDispatcher, paramCache, paramStats, paramAction);
    return new NetworkBitmapHunter(paramPicasso, paramDispatcher, paramCache, paramStats, paramAction, paramDownloader);
  }

  static boolean requiresInSampleSize(BitmapFactory.Options paramOptions)
  {
    return (paramOptions != null) && (paramOptions.inJustDecodeBounds);
  }

  static Bitmap transformResult(Request paramRequest, Bitmap paramBitmap, int paramInt)
  {
    int i;
    int j;
    label25: int k;
    label35: int m;
    int n;
    Matrix localMatrix;
    int i1;
    int i2;
    int i3;
    int i4;
    float f1;
    label116: float f5;
    float f6;
    float f7;
    if ((paramInt == 90) || (paramInt == 270))
    {
      i = 1;
      if (i == 0)
        break label241;
      j = paramBitmap.getHeight();
      if (i == 0)
        break label250;
      k = paramBitmap.getWidth();
      m = j;
      n = k;
      localMatrix = new Matrix();
      boolean bool = paramRequest.needsMatrixTransform();
      i1 = 0;
      i2 = 0;
      if (bool)
      {
        i3 = paramRequest.targetWidth;
        i4 = paramRequest.targetHeight;
        f1 = paramRequest.rotationDegrees;
        if (f1 != 0.0F)
        {
          if (!paramRequest.hasRotationPivot)
            break label259;
          localMatrix.setRotate(f1, paramRequest.rotationPivotX, paramRequest.rotationPivotY);
        }
        if (!paramRequest.centerCrop)
          break label308;
        f5 = i3 / j;
        f6 = i4 / k;
        if (f5 <= f6)
          break label269;
        f7 = f5;
        int i6 = (int)Math.ceil(k * (f6 / f5));
        i2 = (k - i6) / 2;
        n = i6;
        label182: localMatrix.preScale(f7, f7);
      }
    }
    while (true)
    {
      if (paramInt != 0)
        localMatrix.preRotate(paramInt);
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, i1, i2, m, n, localMatrix, true);
      if (localBitmap != paramBitmap)
      {
        paramBitmap.recycle();
        paramBitmap = localBitmap;
      }
      return paramBitmap;
      i = 0;
      break;
      label241: j = paramBitmap.getWidth();
      break label25;
      label250: k = paramBitmap.getHeight();
      break label35;
      label259: localMatrix.setRotate(f1);
      break label116;
      label269: f7 = f6;
      int i5 = (int)Math.ceil(j * (f5 / f6));
      i1 = (j - i5) / 2;
      m = i5;
      i2 = 0;
      break label182;
      label308: if (paramRequest.centerInside)
      {
        float f2 = i3 / j;
        float f3 = i4 / k;
        if (f2 < f3);
        for (float f4 = f2; ; f4 = f3)
        {
          localMatrix.preScale(f4, f4);
          i1 = 0;
          i2 = 0;
          break;
        }
      }
      i1 = 0;
      i2 = 0;
      if (i3 != 0)
      {
        i1 = 0;
        i2 = 0;
        if (i4 != 0)
          if (i3 == j)
          {
            i1 = 0;
            i2 = 0;
            if (i4 == k);
          }
          else
          {
            localMatrix.preScale(i3 / j, i4 / k);
            i1 = 0;
            i2 = 0;
          }
      }
    }
  }

  static void updateThreadName(Request paramRequest)
  {
    String str = paramRequest.getName();
    StringBuilder localStringBuilder = (StringBuilder)NAME_BUILDER.get();
    localStringBuilder.ensureCapacity("Picasso-".length() + str.length());
    localStringBuilder.replace("Picasso-".length(), localStringBuilder.length(), str);
    Thread.currentThread().setName(localStringBuilder.toString());
  }

  void attach(Action paramAction)
  {
    boolean bool = this.picasso.loggingEnabled;
    Request localRequest = paramAction.request;
    if (this.action == null)
    {
      this.action = paramAction;
      if (bool)
      {
        if ((this.actions != null) && (!this.actions.isEmpty()))
          break label65;
        Utils.log("Hunter", "joined", localRequest.logId(), "to empty hunter");
      }
    }
    label65: 
    do
    {
      return;
      Utils.log("Hunter", "joined", localRequest.logId(), Utils.getLogIdsForHunter(this, "to "));
      return;
      if (this.actions == null)
        this.actions = new ArrayList(3);
      this.actions.add(paramAction);
    }
    while (!bool);
    Utils.log("Hunter", "joined", localRequest.logId(), Utils.getLogIdsForHunter(this, "to "));
  }

  boolean cancel()
  {
    Action localAction = this.action;
    boolean bool1 = false;
    if (localAction == null)
      if (this.actions != null)
      {
        boolean bool3 = this.actions.isEmpty();
        bool1 = false;
        if (!bool3);
      }
      else
      {
        Future localFuture = this.future;
        bool1 = false;
        if (localFuture != null)
        {
          boolean bool2 = this.future.cancel(false);
          bool1 = false;
          if (bool2)
            bool1 = true;
        }
      }
    return bool1;
  }

  abstract Bitmap decode(Request paramRequest)
    throws IOException;

  void detach(Action paramAction)
  {
    if (this.action == paramAction)
      this.action = null;
    while (true)
    {
      if (this.picasso.loggingEnabled)
        Utils.log("Hunter", "removed", paramAction.request.logId(), Utils.getLogIdsForHunter(this, "from "));
      return;
      if (this.actions != null)
        this.actions.remove(paramAction);
    }
  }

  Action getAction()
  {
    return this.action;
  }

  List<Action> getActions()
  {
    return this.actions;
  }

  Request getData()
  {
    return this.data;
  }

  Exception getException()
  {
    return this.exception;
  }

  String getKey()
  {
    return this.key;
  }

  Picasso.LoadedFrom getLoadedFrom()
  {
    return this.loadedFrom;
  }

  Picasso getPicasso()
  {
    return this.picasso;
  }

  Bitmap getResult()
  {
    return this.result;
  }

  Bitmap hunt()
    throws IOException
  {
    if (!this.skipMemoryCache)
    {
      Bitmap localBitmap2 = this.cache.get(this.key);
      if (localBitmap2 != null)
      {
        this.stats.dispatchCacheHit();
        this.loadedFrom = Picasso.LoadedFrom.MEMORY;
        if (this.picasso.loggingEnabled)
          Utils.log("Hunter", "decoded", this.data.logId(), "from cache");
        return localBitmap2;
      }
    }
    Bitmap localBitmap1 = decode(this.data);
    if (localBitmap1 != null)
    {
      if (this.picasso.loggingEnabled)
        Utils.log("Hunter", "decoded", this.data.logId());
      this.stats.dispatchBitmapDecoded(localBitmap1);
      if ((!this.data.needsTransformation()) && (this.exifRotation == 0));
    }
    synchronized (DECODE_LOCK)
    {
      if ((this.data.needsMatrixTransform()) || (this.exifRotation != 0))
      {
        localBitmap1 = transformResult(this.data, localBitmap1, this.exifRotation);
        if (this.picasso.loggingEnabled)
          Utils.log("Hunter", "transformed", this.data.logId());
      }
      if (this.data.hasCustomTransformations())
      {
        localBitmap1 = applyCustomTransformations(this.data.transformations, localBitmap1);
        if (this.picasso.loggingEnabled)
          Utils.log("Hunter", "transformed", this.data.logId(), "from custom transformations");
      }
      if (localBitmap1 != null)
        this.stats.dispatchBitmapTransformed(localBitmap1);
      return localBitmap1;
    }
  }

  boolean isCancelled()
  {
    return (this.future != null) && (this.future.isCancelled());
  }

  public void run()
  {
    try
    {
      updateThreadName(this.data);
      if (this.picasso.loggingEnabled)
        Utils.log("Hunter", "executing", Utils.getLogIdsForHunter(this));
      this.result = hunt();
      if (this.result == null)
        this.dispatcher.dispatchFailed(this);
      while (true)
      {
        return;
        this.dispatcher.dispatchComplete(this);
      }
    }
    catch (Downloader.ResponseException localResponseException)
    {
      this.exception = localResponseException;
      this.dispatcher.dispatchFailed(this);
      return;
    }
    catch (IOException localIOException)
    {
      this.exception = localIOException;
      this.dispatcher.dispatchRetry(this);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      StringWriter localStringWriter = new StringWriter();
      this.stats.createSnapshot().dump(new PrintWriter(localStringWriter));
      this.exception = new RuntimeException(localStringWriter.toString(), localOutOfMemoryError);
      this.dispatcher.dispatchFailed(this);
      return;
    }
    catch (Exception localException)
    {
      this.exception = localException;
      this.dispatcher.dispatchFailed(this);
      return;
    }
    finally
    {
      Thread.currentThread().setName("Picasso-Idle");
    }
  }

  protected void setExifRotation(int paramInt)
  {
    this.exifRotation = paramInt;
  }

  boolean shouldRetry(boolean paramBoolean, NetworkInfo paramNetworkInfo)
  {
    return false;
  }

  boolean shouldSkipMemoryCache()
  {
    return this.skipMemoryCache;
  }

  boolean supportsReplay()
  {
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.BitmapHunter
 * JD-Core Version:    0.6.2
 */