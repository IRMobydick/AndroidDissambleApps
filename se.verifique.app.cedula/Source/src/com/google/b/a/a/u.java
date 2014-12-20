package com.google.b.a.a;

import android.os.Build.VERSION;
import java.io.File;

class u
{
  public static int a()
  {
    try
    {
      int j = Integer.parseInt(Build.VERSION.SDK);
      i = j;
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
      {
        ar.a("Invalid version number: " + Build.VERSION.SDK);
        int i = 0;
      }
    }
  }

  static boolean a(String paramString)
  {
    int i = 0;
    if (a() < 9);
    while (true)
    {
      return i;
      File localFile = new File(paramString);
      localFile.setReadable(false, false);
      localFile.setWritable(false, false);
      localFile.setReadable(true, true);
      localFile.setWritable(true, true);
      i = 1;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.u
 * JD-Core Version:    0.6.0
 */