package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StandardExceptionParser
  implements ExceptionParser
{
  private final TreeSet<String> Bl = new TreeSet();

  public StandardExceptionParser(Context paramContext, Collection<String> paramCollection)
  {
    setIncludedPackages(paramContext, paramCollection);
  }

  protected StackTraceElement getBestStackTraceElement(Throwable paramThrowable)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    if ((arrayOfStackTraceElement == null) || (arrayOfStackTraceElement.length == 0))
      return null;
    int i = arrayOfStackTraceElement.length;
    for (int j = 0; j < i; j++)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
      String str = localStackTraceElement.getClassName();
      Iterator localIterator = this.Bl.iterator();
      while (localIterator.hasNext())
        if (str.startsWith((String)localIterator.next()))
          return localStackTraceElement;
    }
    return arrayOfStackTraceElement[0];
  }

  protected Throwable getCause(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null)
      paramThrowable = paramThrowable.getCause();
    return paramThrowable;
  }

  public String getDescription(String paramString, Throwable paramThrowable)
  {
    return getDescription(getCause(paramThrowable), getBestStackTraceElement(getCause(paramThrowable)), paramString);
  }

  protected String getDescription(Throwable paramThrowable, StackTraceElement paramStackTraceElement, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.getClass().getSimpleName());
    if (paramStackTraceElement != null)
    {
      String[] arrayOfString = paramStackTraceElement.getClassName().split("\\.");
      String str = "unknown";
      if ((arrayOfString != null) && (arrayOfString.length > 0))
        str = arrayOfString[(-1 + arrayOfString.length)];
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = str;
      arrayOfObject[1] = paramStackTraceElement.getMethodName();
      arrayOfObject[2] = Integer.valueOf(paramStackTraceElement.getLineNumber());
      localStringBuilder.append(String.format(" (@%s:%s:%s)", arrayOfObject));
    }
    if (paramString != null)
      localStringBuilder.append(String.format(" {%s}", new Object[] { paramString }));
    return localStringBuilder.toString();
  }

  public void setIncludedPackages(Context paramContext, Collection<String> paramCollection)
  {
    this.Bl.clear();
    HashSet localHashSet = new HashSet();
    if (paramCollection != null)
      localHashSet.addAll(paramCollection);
    if (paramContext != null)
      try
      {
        String str3 = paramContext.getApplicationContext().getPackageName();
        this.Bl.add(str3);
        ActivityInfo[] arrayOfActivityInfo = paramContext.getApplicationContext().getPackageManager().getPackageInfo(str3, 15).activities;
        if (arrayOfActivityInfo != null)
        {
          int j = arrayOfActivityInfo.length;
          for (int k = 0; k < j; k++)
            localHashSet.add(arrayOfActivityInfo[k].packageName);
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        z.U("No package found");
      }
    Iterator localIterator1 = localHashSet.iterator();
    if (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      Iterator localIterator2 = this.Bl.iterator();
      for (int i = 1; ; i = 0)
      {
        if (localIterator2.hasNext())
        {
          String str2 = (String)localIterator2.next();
          if (str1.startsWith(str2))
            continue;
          if (str2.startsWith(str1))
            this.Bl.remove(str2);
        }
        if (i == 0)
          break;
        this.Bl.add(str1);
        break;
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.StandardExceptionParser
 * JD-Core Version:    0.6.2
 */