package com.ubercab.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.widget.TextView;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyUtils;

public final class FontUtils
{
  private static SparseArray<Typeface> sTypefaceCache = new SparseArray();

  public static void applyFontToTextView(Context paramContext, TextView paramTextView, int paramInt)
  {
    CalligraphyUtils.applyFontToTextView(paramTextView, getTypefaceFromResource(paramContext, paramInt));
  }

  public static void applyFontToTextView(Context paramContext, TextView paramTextView, int paramInt, boolean paramBoolean)
  {
    CalligraphyUtils.applyFontToTextView(paramTextView, getTypefaceFromResource(paramContext, paramInt), paramBoolean);
  }

  public static Typeface getDefaultTypeface(Context paramContext)
  {
    return getTypefaceFromResource(paramContext, R.string.ub__font_default);
  }

  public static Typeface getTypefaceFromResource(Context paramContext, int paramInt)
  {
    Typeface localTypeface1 = (Typeface)sTypefaceCache.get(paramInt);
    if (localTypeface1 != null)
      return localTypeface1;
    try
    {
      String str = paramContext.getResources().getString(paramInt);
      Typeface localTypeface3;
      if ((str != null) && (str.startsWith("fonts/")))
        localTypeface3 = Typeface.createFromAsset(paramContext.getAssets(), str);
      Typeface localTypeface2;
      for (localObject = localTypeface3; ; localObject = localTypeface2)
      {
        sTypefaceCache.put(paramInt, localObject);
        if (localObject != null)
          break;
        return Typeface.DEFAULT;
        localTypeface2 = Typeface.create(str, 0);
      }
      return localObject;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (true)
        Object localObject = null;
    }
  }

  public static void init(Context paramContext)
  {
    init(paramContext, R.string.ub__font_default);
  }

  public static void init(Context paramContext, int paramInt)
  {
    CalligraphyConfig.initDefault(paramContext.getResources().getString(paramInt), R.attr.fontPath);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.ui.FontUtils
 * JD-Core Version:    0.6.2
 */