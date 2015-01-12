package com.ubercab.client.core.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import com.ubercab.common.base.Preconditions;
import com.ubercab.common.io.IOUtils;
import com.ubercab.library.util.DisplayUtils;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import timber.log.Timber;

public final class CountryFlagUtil
{
  private static final int FLAG_SIZE_DP = 24;
  private static WeakReference<Bitmap> sBitmapFlags;
  private static WeakReference<List<String>> sListFlagIndex;

  private static BitmapDrawable getFlagBitmapDrawable(Context paramContext, String paramString)
  {
    try
    {
      Bitmap localBitmap1 = getFlagsBitmap(paramContext);
      List localList = getFlagIndex(paramContext);
      if ((localList != null) && (localList.contains(paramString.toLowerCase(Locale.US))))
      {
        int i = localBitmap1.getWidth();
        int j = DisplayUtils.convertDpToPixel(24);
        Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, i * localList.indexOf(paramString.toLowerCase(Locale.US)), i, i);
        if (j > i)
          localBitmap2 = Bitmap.createScaledBitmap(localBitmap2, j, j, false);
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), localBitmap2);
        return localBitmapDrawable;
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
  }

  private static List<String> getFlagIndex(Context paramContext)
  {
    if ((sListFlagIndex != null) && (sListFlagIndex.get() != null))
      return (List)sListFlagIndex.get();
    InputStream localInputStream = null;
    try
    {
      localInputStream = paramContext.getResources().openRawResource(2131099649);
      JSONArray localJSONArray = new JSONArray(IOUtils.toString(localInputStream));
      ArrayList localArrayList = new ArrayList();
      for (int i = 0; i < localJSONArray.length(); i++)
        localArrayList.add(localJSONArray.getString(i));
      sListFlagIndex = new WeakReference(localArrayList);
      return localArrayList;
    }
    catch (Exception localException)
    {
      Timber.e(localException, "Failed to load country flag indices from raw resources", new Object[0]);
      return null;
    }
    finally
    {
      IOUtils.closeQuietly(localInputStream);
    }
  }

  private static Bitmap getFlagsBitmap(Context paramContext)
  {
    if ((sBitmapFlags == null) || (sBitmapFlags.get() == null))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inScaled = false;
      sBitmapFlags = new WeakReference(BitmapFactory.decodeResource(paramContext.getResources(), 2130837752, localOptions));
    }
    return (Bitmap)sBitmapFlags.get();
  }

  public static void loadAllFlags(Context paramContext, AllFlagListener paramAllFlagListener)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramAllFlagListener);
    new AsyncTask()
    {
      protected Map<String, Drawable> doInBackground(String[] paramAnonymousArrayOfString)
      {
        HashMap localHashMap;
        try
        {
          List localList = CountryFlagUtil.getFlagIndex(this.val$context);
          if (localList == null)
            return null;
          localHashMap = new HashMap();
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localHashMap.put(str, CountryFlagUtil.getFlagBitmapDrawable(this.val$context, str));
          }
        }
        catch (Exception localException)
        {
          localHashMap = null;
        }
        return localHashMap;
      }

      protected void onPostExecute(Map<String, Drawable> paramAnonymousMap)
      {
        CountryFlagUtil.AllFlagListener localAllFlagListener = (CountryFlagUtil.AllFlagListener)this.val$weakListener.get();
        if (localAllFlagListener != null)
          localAllFlagListener.onFlagsLoaded(paramAnonymousMap);
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
  }

  public static void loadFlag(Context paramContext, Executor paramExecutor, final String paramString, FlagListener paramFlagListener)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramFlagListener);
    new AsyncTask()
    {
      protected BitmapDrawable doInBackground(String[] paramAnonymousArrayOfString)
      {
        return CountryFlagUtil.getFlagBitmapDrawable(this.val$context, paramString);
      }

      protected void onPostExecute(BitmapDrawable paramAnonymousBitmapDrawable)
      {
        CountryFlagUtil.FlagListener localFlagListener = (CountryFlagUtil.FlagListener)this.val$weakListener.get();
        if (localFlagListener != null)
          localFlagListener.onFlagLoaded(paramAnonymousBitmapDrawable);
      }
    }
    .executeOnExecutor(paramExecutor, new String[0]);
  }

  public static abstract interface AllFlagListener
  {
    public abstract void onFlagsLoaded(Map<String, Drawable> paramMap);
  }

  public static abstract interface FlagListener
  {
    public abstract void onFlagLoaded(Drawable paramDrawable);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.CountryFlagUtil
 * JD-Core Version:    0.6.2
 */