package com.ubercab.library.metrics.analytics.session;

public enum ForegroundIntentName
{
  private String mValue;

  static
  {
    ForegroundIntentName[] arrayOfForegroundIntentName = new ForegroundIntentName[2];
    arrayOfForegroundIntentName[0] = ICON;
    arrayOfForegroundIntentName[1] = NONE;
  }

  private ForegroundIntentName(String paramString)
  {
    this.mValue = paramString;
  }

  public String getValue()
  {
    return this.mValue;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.metrics.analytics.session.ForegroundIntentName
 * JD-Core Version:    0.6.2
 */