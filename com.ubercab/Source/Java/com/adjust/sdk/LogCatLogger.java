package com.adjust.sdk;

import android.util.Log;
import java.util.Locale;

public class LogCatLogger
  implements Logger
{
  private Logger.LogLevel logLevel;

  public LogCatLogger()
  {
    setLogLevel(Logger.LogLevel.INFO);
  }

  public void Assert(String paramString)
  {
    Log.println(7, "Adjust", paramString);
  }

  public void debug(String paramString)
  {
    if (this.logLevel.androidLogLevel <= 3)
      Log.d("Adjust", paramString);
  }

  public void error(String paramString)
  {
    if (this.logLevel.androidLogLevel <= 6)
      Log.e("Adjust", paramString);
  }

  public void info(String paramString)
  {
    if (this.logLevel.androidLogLevel <= 4)
      Log.i("Adjust", paramString);
  }

  public void setLogLevel(Logger.LogLevel paramLogLevel)
  {
    this.logLevel = paramLogLevel;
  }

  public void setLogLevelString(String paramString)
  {
    if (paramString != null);
    try
    {
      setLogLevel(Logger.LogLevel.valueOf(paramString.toUpperCase(Locale.US)));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      error(String.format("Malformed logLevel '%s', falling back to 'info'", new Object[] { paramString }));
    }
  }

  public void verbose(String paramString)
  {
    if (this.logLevel.androidLogLevel <= 2)
      Log.v("Adjust", paramString);
  }

  public void warn(String paramString)
  {
    if (this.logLevel.androidLogLevel <= 5)
      Log.w("Adjust", paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.LogCatLogger
 * JD-Core Version:    0.6.2
 */