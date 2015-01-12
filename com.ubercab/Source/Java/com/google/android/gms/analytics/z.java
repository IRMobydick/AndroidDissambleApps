package com.google.android.gms.analytics;

public class z
{
  private static GoogleAnalytics AT;

  public static void T(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null)
      localLogger.error(paramString);
  }

  public static void U(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null)
      localLogger.info(paramString);
  }

  public static void V(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null)
      localLogger.verbose(paramString);
  }

  public static void W(String paramString)
  {
    Logger localLogger = getLogger();
    if (localLogger != null)
      localLogger.warn(paramString);
  }

  public static boolean eK()
  {
    Logger localLogger = getLogger();
    boolean bool = false;
    if (localLogger != null)
    {
      int i = getLogger().getLogLevel();
      bool = false;
      if (i == 0)
        bool = true;
    }
    return bool;
  }

  private static Logger getLogger()
  {
    if (AT == null)
      AT = GoogleAnalytics.eD();
    if (AT != null)
      return AT.getLogger();
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.z
 * JD-Core Version:    0.6.2
 */