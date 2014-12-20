package net.photopay.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

public class Log
{
  private static final String NEW_LINE = "\n";
  private static int kLogLevel;
  private static Context mAppContext;
  private static String mLogFolder;
  private static PrintWriter mLogWriter = null;

  static
  {
    mLogFolder = null;
    mAppContext = null;
    kLogLevel = Log.LogLevel.LOG_WARNINGS_AND_ERRORS.ordinal();
  }

  public static void d(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    if (kLogLevel >= 2)
    {
      String str1 = getTag(paramObject);
      String str2 = format(paramString, paramArrayOfObject);
      android.util.Log.d(str1, str2);
      printToWriter("[D]", str1, str2, null);
    }
  }

  public static void d(Object paramObject, Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    if (kLogLevel >= 2)
    {
      String str1 = getTag(paramObject);
      String str2 = format(paramString, paramArrayOfObject);
      android.util.Log.d(str1, str2, paramThrowable);
      printToWriter("[D]", str1, str2, paramThrowable);
    }
  }

  public static void disableFileLogging()
  {
    monitorenter;
    try
    {
      if (mLogWriter != null)
      {
        mLogWriter.close();
        mLogWriter = null;
      }
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static void e(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    String str1 = getTag(paramObject);
    String str2 = format(paramString, paramArrayOfObject);
    android.util.Log.e(str1, str2);
    printToWriter("[E]", str1, str2, null);
  }

  public static void e(Object paramObject, Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    String str1 = getTag(paramObject);
    String str2 = format(paramString, paramArrayOfObject);
    android.util.Log.e(str1, str2, paramThrowable);
    printToWriter("[E]", str1, str2, paramThrowable);
  }

  public static void enableFileLogging()
  {
    monitorenter;
    try
    {
      PrintWriter localPrintWriter = mLogWriter;
      if (localPrintWriter == null);
      try
      {
        new File(getLogFolder()).mkdirs();
        mLogWriter = new PrintWriter(new BufferedWriter(new FileWriter(getLogFolder() + "/javaLog.txt", true)));
        monitorexit;
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          android.util.Log.e("LOG", "Failed to create file writer!", localIOException);
          mLogWriter = null;
        }
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static String format(String paramString, Object[] paramArrayOfObject)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = paramString.split("(?<!\\\\)\\{\\}", -1);
    int j = 0;
    while (true)
    {
      int k;
      if (j < arrayOfString.length)
      {
        k = j + 1;
        localStringBuilder.append(arrayOfString[j]);
        if (k < arrayOfString.length)
        {
          if (i >= paramArrayOfObject.length)
            throw new RuntimeException("missing parameter for log message '" + paramString + "'");
          int m = i + 1;
          localStringBuilder.append(paramArrayOfObject[i]);
          i = m;
          j = k;
          continue;
        }
      }
      else
      {
        return localStringBuilder.toString();
      }
      j = k;
    }
  }

  public static Log.LogLevel getCurrentLogLevel()
  {
    return Log.LogLevel.values()[kLogLevel];
  }

  public static int getLineNumber()
  {
    return java.lang.Thread.currentThread().getStackTrace()[5].getLineNumber();
  }

  public static String getLogFolder()
  {
    monitorenter;
    while (true)
    {
      try
      {
        if (mLogFolder != null)
          continue;
        if (!Environment.getExternalStorageState().equals("mounted"))
          continue;
        mLogFolder = Environment.getExternalStorageDirectory() + "/photopay";
        android.util.Log.i("LOG", "Log folder will be " + mLogFolder);
        String str = mLogFolder;
        return str;
        if (mAppContext != null)
        {
          mLogFolder = mAppContext.getCacheDir().getAbsolutePath() + "/photopay";
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      mLogFolder = Environment.getDataDirectory().getAbsolutePath() + "/photopay";
    }
  }

  private static String getTag(Object paramObject)
  {
    String str;
    if (paramObject == null)
      str = "";
    while (true)
    {
      return str + ":" + getLineNumber();
      if ((paramObject instanceof String))
      {
        str = (String)paramObject;
        continue;
      }
      if ((paramObject instanceof Class))
      {
        str = ((Class)paramObject).getSimpleName() + ".java";
        continue;
      }
      str = paramObject.getClass().getSimpleName() + ".java";
    }
  }

  public static void i(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    if (kLogLevel > 0)
    {
      String str1 = getTag(paramObject);
      String str2 = format(paramString, paramArrayOfObject);
      android.util.Log.i(str1, str2);
      printToWriter("[I]", str1, str2, null);
    }
  }

  public static void i(Object paramObject, Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    if (kLogLevel > 0)
    {
      String str1 = getTag(paramObject);
      String str2 = format(paramString, paramArrayOfObject);
      android.util.Log.i(str1, str2, paramThrowable);
      printToWriter("[I]", str1, str2, paramThrowable);
    }
  }

  private static void printToWriter(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if (mLogWriter != null)
    {
      mLogWriter.write(paramString1);
      Timestamp localTimestamp = new Timestamp(new Date().getTime());
      mLogWriter.write(" (");
      mLogWriter.write(localTimestamp.toString());
      mLogWriter.write(") [");
      mLogWriter.write(paramString2);
      mLogWriter.write("] ");
      mLogWriter.write(paramString3);
      mLogWriter.write("\n");
      if (paramThrowable != null)
        paramThrowable.printStackTrace(mLogWriter);
      mLogWriter.flush();
    }
  }

  public static void setApplicationContext(Context paramContext)
  {
    mAppContext = paramContext;
  }

  public static void setLogLevel(Log.LogLevel paramLogLevel)
  {
    kLogLevel = paramLogLevel.ordinal();
  }

  public static void v(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    if (kLogLevel >= 3)
    {
      String str1 = getTag(paramObject);
      String str2 = format(paramString, paramArrayOfObject);
      android.util.Log.v(str1, str2);
      printToWriter("[V]", str1, str2, null);
    }
  }

  public static void v(Object paramObject, Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    if (kLogLevel >= 3)
    {
      String str1 = getTag(paramObject);
      String str2 = format(paramString, paramArrayOfObject);
      android.util.Log.v(str1, str2, paramThrowable);
      printToWriter("[V]", str1, str2, paramThrowable);
    }
  }

  public static void w(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    String str1 = getTag(paramObject);
    String str2 = format(paramString, paramArrayOfObject);
    android.util.Log.w(str1, str2);
    printToWriter("[W]", str1, str2, null);
  }

  public static void w(Object paramObject, Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    String str1 = getTag(paramObject);
    String str2 = format(paramString, paramArrayOfObject);
    android.util.Log.w(str1, str2, paramThrowable);
    printToWriter("[W]", str1, str2, paramThrowable);
  }

  public static void wtf(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    String str1 = getTag(paramObject);
    String str2 = format(paramString, paramArrayOfObject);
    if (Build.VERSION.SDK_INT >= 8)
      android.util.Log.wtf(str1, str2);
    while (true)
    {
      printToWriter("[WTF]", str1, str2, null);
      return;
      android.util.Log.e(str1, str2);
    }
  }

  public static void wtf(Object paramObject, Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    String str1 = getTag(paramObject);
    String str2 = format(paramString, paramArrayOfObject);
    if (Build.VERSION.SDK_INT >= 8)
      android.util.Log.wtf(str1, str2, paramThrowable);
    while (true)
    {
      printToWriter("[WTF]", str1, str2, paramThrowable);
      return;
      android.util.Log.e(str1, str2, paramThrowable);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.util.Log
 * JD-Core Version:    0.6.0
 */