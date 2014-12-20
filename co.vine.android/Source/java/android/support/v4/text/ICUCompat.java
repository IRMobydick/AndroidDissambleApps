package android.support.v4.text;

import android.os.Build.VERSION;

public class ICUCompat
{
  private static final ICUCompatImpl IMPL;

  static
  {
    if (Build.VERSION.SDK_INT >= 14)
      IMPL = new ICUCompat.ICUCompatImplIcs();
    while (true)
    {
      return;
      IMPL = new ICUCompat.ICUCompatImplBase();
    }
  }

  public static String addLikelySubtags(String paramString)
  {
    return IMPL.addLikelySubtags(paramString);
  }

  public static String getScript(String paramString)
  {
    return IMPL.getScript(paramString);
  }

  static abstract interface ICUCompatImpl
  {
    public abstract String addLikelySubtags(String paramString);

    public abstract String getScript(String paramString);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.text.ICUCompat
 * JD-Core Version:    0.6.0
 */