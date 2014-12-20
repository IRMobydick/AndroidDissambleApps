package com.google.b.a.a;

import java.util.SortedSet;
import java.util.TreeSet;

class am
{
  private static final am d = new am();
  private SortedSet a = new TreeSet();
  private StringBuilder b = new StringBuilder();
  private boolean c = false;

  public static am a()
  {
    return d;
  }

  public void a(an paraman)
  {
    monitorenter;
    try
    {
      if (!this.c)
      {
        this.a.add(paraman);
        this.b.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(paraman.ordinal()));
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

  public void a(boolean paramBoolean)
  {
    monitorenter;
    try
    {
      this.c = paramBoolean;
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

  public String b()
  {
    monitorenter;
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 6;
      int j = 0;
      while (this.a.size() > 0)
      {
        an localan = (an)this.a.first();
        this.a.remove(localan);
        int k = localan.ordinal();
        while (k >= i)
        {
          localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(j));
          i += 6;
          j = 0;
        }
        j += (1 << localan.ordinal() % 6);
      }
      if ((j > 0) || (localStringBuilder.length() == 0))
        localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(j));
      this.a.clear();
      String str = localStringBuilder.toString();
      monitorexit;
      return str;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public String c()
  {
    monitorenter;
    try
    {
      if (this.b.length() > 0)
        this.b.insert(0, ".");
      String str = this.b.toString();
      this.b = new StringBuilder();
      monitorexit;
      return str;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.b.a.a.am
 * JD-Core Version:    0.6.0
 */