package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.a.b.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ks$f extends hy
  implements SafeParcelable, h
{
  public static final ni a = new ni();
  private static final HashMap b = new HashMap();
  private final Set c;
  private final int d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private boolean j;
  private String k;
  private String l;
  private int m;

  static
  {
    b.put("department", hy.a.d("department", 2));
    b.put("description", hy.a.d("description", 3));
    b.put("endDate", hy.a.d("endDate", 4));
    b.put("location", hy.a.d("location", 5));
    b.put("name", hy.a.d("name", 6));
    b.put("primary", hy.a.c("primary", 7));
    b.put("startDate", hy.a.d("startDate", 8));
    b.put("title", hy.a.d("title", 9));
    b.put("type", hy.a.a("type", 10, new hv().a("work", 0).a("school", 1), false));
  }

  public ks$f()
  {
    this.d = 1;
    this.c = new HashSet();
  }

  ks$f(Set paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, int paramInt2)
  {
    this.c = paramSet;
    this.d = paramInt1;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramString4;
    this.i = paramString5;
    this.j = paramBoolean;
    this.k = paramString6;
    this.l = paramString7;
    this.m = paramInt2;
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
    case 2:
      localObject = this.e;
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    }
    while (true)
    {
      return localObject;
      localObject = this.f;
      continue;
      localObject = this.g;
      continue;
      localObject = this.h;
      continue;
      localObject = this.i;
      continue;
      localObject = Boolean.valueOf(this.j);
      continue;
      localObject = this.k;
      continue;
      localObject = this.l;
      continue;
      localObject = Integer.valueOf(this.m);
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
    int n;
    if (!(paramObject instanceof f))
      n = 0;
    while (true)
    {
      return n;
      if (this == paramObject)
      {
        n = 1;
        continue;
      }
      f localf = (f)paramObject;
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
          if (localf.a(locala))
          {
            if (b(locala).equals(localf.b(locala)))
              continue;
            n = 0;
            break;
          }
        }
        n = 0;
        break;
      }
      while (!localf.a(locala));
      n = 0;
      continue;
      label124: n = 1;
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

  public String h()
  {
    return this.f;
  }

  public int hashCode()
  {
    Iterator localIterator = b.values().iterator();
    int n = 0;
    hy.a locala;
    if (localIterator.hasNext())
    {
      locala = (hy.a)localIterator.next();
      if (!a(locala))
        break label66;
    }
    label66: for (int i1 = n + locala.g() + b(locala).hashCode(); ; i1 = n)
    {
      n = i1;
      break;
      return n;
    }
  }

  public String i()
  {
    return this.g;
  }

  public String j()
  {
    return this.h;
  }

  public String k()
  {
    return this.i;
  }

  public boolean l()
  {
    return this.j;
  }

  public String m()
  {
    return this.k;
  }

  public String n()
  {
    return this.l;
  }

  public int o()
  {
    return this.m;
  }

  public f p()
  {
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ni.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ks.f
 * JD-Core Version:    0.6.0
 */