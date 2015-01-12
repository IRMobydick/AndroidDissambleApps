package uk.co.chrisjenx.calligraphy;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;
import java.util.HashMap;

public final class TypefaceUtils
{
  private static final HashMap<String, Typeface> sCachedFonts = new HashMap();
  private static final HashMap<Typeface, CalligraphyTypefaceSpan> sCachedSpans = new HashMap();

  public static CalligraphyTypefaceSpan getSpan(Typeface paramTypeface)
  {
    if (paramTypeface == null)
      return null;
    synchronized (sCachedSpans)
    {
      if (!sCachedSpans.containsKey(paramTypeface))
      {
        CalligraphyTypefaceSpan localCalligraphyTypefaceSpan1 = new CalligraphyTypefaceSpan(paramTypeface);
        sCachedSpans.put(paramTypeface, localCalligraphyTypefaceSpan1);
        return localCalligraphyTypefaceSpan1;
      }
    }
    CalligraphyTypefaceSpan localCalligraphyTypefaceSpan2 = (CalligraphyTypefaceSpan)sCachedSpans.get(paramTypeface);
    return localCalligraphyTypefaceSpan2;
  }

  public static Typeface load(AssetManager paramAssetManager, String paramString)
  {
    synchronized (sCachedFonts)
    {
      try
      {
        if (!sCachedFonts.containsKey(paramString))
        {
          Typeface localTypeface2 = Typeface.createFromAsset(paramAssetManager, paramString);
          sCachedFonts.put(paramString, localTypeface2);
          return localTypeface2;
        }
      }
      catch (Exception localException)
      {
        Log.w("Calligraphy", "Can't create asset from " + paramString + ". Make sure you have passed in the correct path and file name.", localException);
        sCachedFonts.put(paramString, null);
        return null;
      }
      Typeface localTypeface1 = (Typeface)sCachedFonts.get(paramString);
      return localTypeface1;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     uk.co.chrisjenx.calligraphy.TypefaceUtils
 * JD-Core Version:    0.6.2
 */