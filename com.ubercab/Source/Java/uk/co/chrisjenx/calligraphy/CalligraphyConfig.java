package uk.co.chrisjenx.calligraphy;

import android.text.TextUtils;

public class CalligraphyConfig
{
  private static CalligraphyConfig mInstance;
  private final int mAttrId;
  private final String mFontPath;
  private final boolean mIsFontSet;

  private CalligraphyConfig()
  {
    this(null, -1);
  }

  private CalligraphyConfig(int paramInt)
  {
    this(null, paramInt);
  }

  private CalligraphyConfig(String paramString)
  {
    this(paramString, -1);
  }

  private CalligraphyConfig(String paramString, int paramInt)
  {
    this.mFontPath = paramString;
    boolean bool;
    if (!TextUtils.isEmpty(paramString))
    {
      bool = true;
      this.mIsFontSet = bool;
      if (paramInt == -1)
        break label39;
    }
    while (true)
    {
      this.mAttrId = paramInt;
      return;
      bool = false;
      break;
      label39: paramInt = -1;
    }
  }

  static CalligraphyConfig get()
  {
    if (mInstance == null)
      mInstance = new CalligraphyConfig();
    return mInstance;
  }

  public static void initDefault(int paramInt)
  {
    mInstance = new CalligraphyConfig(paramInt);
  }

  public static void initDefault(String paramString)
  {
    mInstance = new CalligraphyConfig(paramString);
  }

  public static void initDefault(String paramString, int paramInt)
  {
    mInstance = new CalligraphyConfig(paramString, paramInt);
  }

  public int getAttrId()
  {
    return this.mAttrId;
  }

  String getFontPath()
  {
    return this.mFontPath;
  }

  boolean isFontSet()
  {
    return this.mIsFontSet;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     uk.co.chrisjenx.calligraphy.CalligraphyConfig
 * JD-Core Version:    0.6.2
 */