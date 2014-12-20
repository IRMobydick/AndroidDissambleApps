package com.google.b.a.a;

import android.content.Context;
import java.util.ArrayList;

public class t
  implements Thread.UncaughtExceptionHandler
{
  private final Thread.UncaughtExceptionHandler a;
  private final bh b;
  private final bd c;
  private s d;

  public t(bh parambh, bd parambd, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (parambh == null)
      throw new NullPointerException("tracker cannot be null");
    if (parambd == null)
      throw new NullPointerException("serviceManager cannot be null");
    this.a = paramUncaughtExceptionHandler;
    this.b = parambh;
    this.c = parambd;
    this.d = new bg(paramContext, new ArrayList());
    StringBuilder localStringBuilder = new StringBuilder().append("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null);
    for (String str = "null"; ; str = paramUncaughtExceptionHandler.getClass().getName())
    {
      ar.c(str);
      return;
    }
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str1 = "UncaughtException";
    if (this.d != null)
      if (paramThread == null)
        break label104;
    label104: for (String str2 = paramThread.getName(); ; str2 = null)
    {
      str1 = this.d.a(str2, paramThrowable);
      ar.c("Tracking Exception: " + str1);
      this.b.a(au.a(str1, Boolean.valueOf(true)).a());
      this.c.c();
      if (this.a != null)
      {
        ar.c("Passing exception to original handler.");
        this.a.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.t
 * JD-Core Version:    0.6.0
 */