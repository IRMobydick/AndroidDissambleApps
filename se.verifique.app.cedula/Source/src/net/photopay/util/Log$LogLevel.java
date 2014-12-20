package net.photopay.util;

public enum Log$LogLevel
{
  static
  {
    LOG_INFORMATION = new LogLevel("LOG_INFORMATION", 1);
    LOG_DEBUG = new LogLevel("LOG_DEBUG", 2);
    LOG_VERBOSE = new LogLevel("LOG_VERBOSE", 3);
    LogLevel[] arrayOfLogLevel = new LogLevel[4];
    arrayOfLogLevel[0] = LOG_WARNINGS_AND_ERRORS;
    arrayOfLogLevel[1] = LOG_INFORMATION;
    arrayOfLogLevel[2] = LOG_DEBUG;
    arrayOfLogLevel[3] = LOG_VERBOSE;
    $VALUES = arrayOfLogLevel;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.util.Log.LogLevel
 * JD-Core Version:    0.6.0
 */