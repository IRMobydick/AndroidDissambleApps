package com.adjust.sdk;

public abstract interface Logger
{
  public abstract void Assert(String paramString);

  public abstract void debug(String paramString);

  public abstract void error(String paramString);

  public abstract void info(String paramString);

  public abstract void setLogLevel(LogLevel paramLogLevel);

  public abstract void setLogLevelString(String paramString);

  public abstract void verbose(String paramString);

  public abstract void warn(String paramString);

  public static enum LogLevel
  {
    final int androidLogLevel;

    static
    {
      DEBUG = new LogLevel("DEBUG", 1, 3);
      INFO = new LogLevel("INFO", 2, 4);
      WARN = new LogLevel("WARN", 3, 5);
      ERROR = new LogLevel("ERROR", 4, 6);
      ASSERT = new LogLevel("ASSERT", 5, 7);
      LogLevel[] arrayOfLogLevel = new LogLevel[6];
      arrayOfLogLevel[0] = VERBOSE;
      arrayOfLogLevel[1] = DEBUG;
      arrayOfLogLevel[2] = INFO;
      arrayOfLogLevel[3] = WARN;
      arrayOfLogLevel[4] = ERROR;
      arrayOfLogLevel[5] = ASSERT;
    }

    private LogLevel(int paramInt)
    {
      this.androidLogLevel = paramInt;
    }

    public int getAndroidLogLevel()
    {
      return this.androidLogLevel;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.Logger
 * JD-Core Version:    0.6.2
 */