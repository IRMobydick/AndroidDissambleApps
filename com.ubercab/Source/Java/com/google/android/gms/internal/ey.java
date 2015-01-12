package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;

@ez
public class ey
  implements Thread.UncaughtExceptionHandler
{
  private Context mContext;
  private Thread.UncaughtExceptionHandler sR;
  private Thread.UncaughtExceptionHandler sS;
  private gt sT;

  public ey(Context paramContext, gt paramgt, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler1, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler2)
  {
    this.sR = paramUncaughtExceptionHandler1;
    this.sS = paramUncaughtExceptionHandler2;
    this.mContext = paramContext;
    this.sT = paramgt;
  }

  public static ey a(Context paramContext, Thread paramThread, gt paramgt)
  {
    if ((paramContext == null) || (paramThread == null) || (paramgt == null))
      return null;
    gb.bD();
    if (!k(paramContext))
      return null;
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = paramThread.getUncaughtExceptionHandler();
    ey localey = new ey(paramContext, paramgt, localUncaughtExceptionHandler, Thread.getDefaultUncaughtExceptionHandler());
    if ((localUncaughtExceptionHandler == null) || (!(localUncaughtExceptionHandler instanceof ey)))
      try
      {
        paramThread.setUncaughtExceptionHandler(localey);
        return localey;
      }
      catch (SecurityException localSecurityException)
      {
        gs.c("Fail to set UncaughtExceptionHandler.", localSecurityException);
        return null;
      }
    return (ey)localUncaughtExceptionHandler;
  }

  private String cw()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if (str2.startsWith(str1))
      return str2;
    return str1 + " " + str2;
  }

  private Throwable d(Throwable paramThrowable)
  {
    Bundle localBundle = gb.bD();
    if ((localBundle != null) && (localBundle.getBoolean("gads:sdk_crash_report_full_stacktrace", false)))
      return paramThrowable;
    LinkedList localLinkedList = new LinkedList();
    while (paramThrowable != null)
    {
      localLinkedList.push(paramThrowable);
      paramThrowable = paramThrowable.getCause();
    }
    Object localObject1 = null;
    Throwable localThrowable;
    Object localObject2;
    if (!localLinkedList.isEmpty())
    {
      localThrowable = (Throwable)localLinkedList.pop();
      StackTraceElement[] arrayOfStackTraceElement = localThrowable.getStackTrace();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new StackTraceElement(localThrowable.getClass().getName(), "<filtered>", "<filtered>", 1));
      int i = arrayOfStackTraceElement.length;
      int j = 0;
      int k = 0;
      if (j < i)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
        if (G(localStackTraceElement.getClassName()))
        {
          localArrayList.add(localStackTraceElement);
          k = 1;
        }
        while (true)
        {
          j++;
          break;
          if (H(localStackTraceElement.getClassName()))
            localArrayList.add(localStackTraceElement);
          else
            localArrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
        }
      }
      if (k == 0)
        break label276;
      if (localObject1 == null)
      {
        localObject2 = new Throwable(localThrowable.getMessage());
        label230: ((Throwable)localObject2).setStackTrace((StackTraceElement[])localArrayList.toArray(new StackTraceElement[0]));
      }
    }
    while (true)
    {
      localObject1 = localObject2;
      break;
      localObject2 = new Throwable(localThrowable.getMessage(), localObject1);
      break label230;
      return localObject1;
      label276: localObject2 = localObject1;
    }
  }

  private static boolean k(Context paramContext)
  {
    Bundle localBundle = gb.bD();
    if (localBundle == null);
    while (!localBundle.getBoolean("gads:sdk_crash_report_enabled", false))
      return false;
    return true;
  }

  protected boolean G(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    if (paramString.startsWith("com.google.android.gms.ads"))
      return true;
    if (paramString.startsWith("com.google.ads"))
      return true;
    try
    {
      boolean bool = Class.forName(paramString).isAnnotationPresent(ez.class);
      return bool;
    }
    catch (Exception localException)
    {
      gs.a("Fail to check class type for class " + paramString, localException);
    }
    return false;
  }

  protected boolean H(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    while ((!paramString.startsWith("android.")) && (!paramString.startsWith("java.")))
      return false;
    return true;
  }

  protected boolean a(Throwable paramThrowable)
  {
    boolean bool = true;
    if (paramThrowable == null)
      return false;
    int i = 0;
    int j = 0;
    while (paramThrowable != null)
    {
      for (StackTraceElement localStackTraceElement : paramThrowable.getStackTrace())
      {
        if (G(localStackTraceElement.getClassName()))
          j = bool;
        if (getClass().getName().equals(localStackTraceElement.getClassName()))
          i = bool;
      }
      paramThrowable = paramThrowable.getCause();
    }
    if ((j != 0) && (i == 0));
    while (true)
    {
      return bool;
      bool = false;
    }
  }

  public void b(Throwable paramThrowable)
  {
    if (!k(this.mContext));
    Throwable localThrowable;
    do
    {
      return;
      localThrowable = d(paramThrowable);
    }
    while (localThrowable == null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(c(localThrowable));
    gj.a(this.mContext, this.sT.wD, localArrayList, gb.de());
  }

  protected String c(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("device", cw()).appendQueryParameter("js", this.sT.wD).appendQueryParameter("appid", this.mContext.getApplicationContext().getPackageName()).appendQueryParameter("stacktrace", localStringWriter.toString()).toString();
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if (a(paramThrowable))
    {
      b(paramThrowable);
      if (Looper.getMainLooper().getThread() == paramThread);
    }
    do
    {
      return;
      if (this.sR != null)
      {
        this.sR.uncaughtException(paramThread, paramThrowable);
        return;
      }
    }
    while (this.sS == null);
    this.sS.uncaughtException(paramThread, paramThrowable);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ey
 * JD-Core Version:    0.6.2
 */