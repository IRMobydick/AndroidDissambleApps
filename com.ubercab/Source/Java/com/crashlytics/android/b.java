package com.crashlytics.android;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

class b
{
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final int g;
  public final String h;
  public final String i;
  public final Y j;

  public b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, String paramString8, Y paramY)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramInt;
    this.h = paramString7;
    this.i = paramString8;
    this.j = paramY;
  }

  public static void a(File paramFile, FilenameFilter paramFilenameFilter, int paramInt, Comparator<File> paramComparator)
  {
    File[] arrayOfFile = paramFile.listFiles(paramFilenameFilter);
    int k;
    int m;
    if ((arrayOfFile != null) && (arrayOfFile.length > paramInt))
    {
      Arrays.sort(arrayOfFile, paramComparator);
      k = arrayOfFile.length;
      m = arrayOfFile.length;
    }
    for (int n = 0; ; n++)
    {
      File localFile;
      if (n < m)
      {
        localFile = arrayOfFile[n];
        if (k > paramInt);
      }
      else
      {
        return;
      }
      localFile.delete();
      k--;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.b
 * JD-Core Version:    0.6.2
 */