package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.a.b.j;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ks$h extends hy
  implements SafeParcelable, j
{
  public static final nk a = new nk();
  private static final HashMap b = new HashMap();
  private final Set c;
  private final int d;
  private String e;
  private final int f = 4;
  private int g;
  private String h;

  static
  {
    b.put("label", hy.a.d("label", 5));
    b.put("type", hy.a.a("type", 6, new hv().a("home", 0).a("work", 1).a("blog", 2).a("profile", 3).a("other", 4).a("otherProfile", 5).a("contributor", 6).a("website", 7), false));
    b.put("value", hy.a.d("value", 4));
  }

  public ks$h()
  {
    this.d = 2;
    this.c = new HashSet();
  }

  ks$h(Set paramSet, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    this.c = paramSet;
    this.d = paramInt1;
    this.e = paramString1;
    this.g = paramInt2;
    this.h = paramString2;
  }

  protected Object a(String paramString)
  {
    return null;
  }

  protected boolean a(hy.a parama)
  {
    return this.c.contains(Integer.valueOf(parama.g()));
  }

  protected Object b(hy.a parama)
  {
    Object localObject;
    switch (parama.g())
    {
    default:
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.g());
    case 5:
      localObject = this.e;
    case 6:
    case 4:
    }
    while (true)
    {
      return localObject;
      localObject = Integer.valueOf(this.g);
      continue;
      localObject = this.h;
    }
  }

  public HashMap b()
  {
    return b;
  }

  protected boolean b(String paramString)
  {
    return false;
  }

  public int describeContents()
  {
    return 0;
  }

  Set e()
  {
    return this.c;
  }

  public boolean equals(Object paramObject)
  {
    int i;
    if (!(paramObject instanceof h))
      i = 0;
    while (true)
    {
      return i;
      if (this == paramObject)
      {
        i = 1;
        continue;
      }
      h localh = (h)paramObject;
      Iterator localIterator = b.values().iterator();
      hy.a locala;
      label109: 
      do
      {
        while (true)
        {
          if (!localIterator.hasNext())
            break label124;
          locala = (hy.a)localIterator.next();
          if (!a(locala))
            break label109;
          if (localh.a(locala))
          {
            if (b(locala).equals(localh.b(locala)))
              continue;
            i = 0;
            break;
          }
        }
        i = 0;
        break;
      }
      while (!localh.a(locala));
      i = 0;
      continue;
      label124: i = 1;
    }
  }

  int f()
  {
    return this.d;
  }

  public String g()
  {
    return this.e;
  }

  @Deprecated
  public int h()
  {
    return 4;
  }

  public int hashCode()
  {
    Iterator localIterator = b.values().iterator();
    int i = 0;
    hy.a locala;
    if (localIterator.hasNext())
    {
      locala = (hy.a)localIterator.next();
      if (!a(locala))
        break label66;
    }
    label66: for (int j = i + locala.g() + b(locala).hashCode(); ; j = i)
    {
      i = j;
      break;
      return i;
    }
  }

  public int i()
  {
    return this.g;
  }

  public String j()
  {
    return this.h;
  }

  public h k()
  {
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nk.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ks.h
 * JD-Core Version:    0.6.0
 */