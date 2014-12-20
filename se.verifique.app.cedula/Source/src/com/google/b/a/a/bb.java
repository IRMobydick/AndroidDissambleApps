package com.google.b.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

class bb
  implements n
{
  private static bb a;
  private static Object b = new Object();
  private final Context c;

  protected bb(Context paramContext)
  {
    this.c = paramContext;
  }

  public static bb a()
  {
    synchronized (b)
    {
      bb localbb = a;
      return localbb;
    }
  }

  public static void a(Context paramContext)
  {
    synchronized (b)
    {
      if (a == null)
        a = new bb(paramContext);
      return;
    }
  }

  public String a(String paramString)
  {
    String str = null;
    if (paramString == null);
    while (true)
    {
      return str;
      if (!paramString.equals("&sr"))
        continue;
      str = b();
    }
  }

  protected String b()
  {
    DisplayMetrics localDisplayMetrics = this.c.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.bb
 * JD-Core Version:    0.6.0
 */