package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.a.b.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ks$d extends hy
  implements SafeParcelable, g
{
  public static final ng a = new ng();
  private static final HashMap b = new HashMap();
  private final Set c;
  private final int d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;

  static
  {
    b.put("familyName", hy.a.d("familyName", 2));
    b.put("formatted", hy.a.d("formatted", 3));
    b.put("givenName", hy.a.d("givenName", 4));
    b.put("honorificPrefix", hy.a.d("honorificPrefix", 5));
    b.put("honorificSuffix", hy.a.d("honorificSuffix", 6));
    b.put("middleName", hy.a.d("middleName", 7));
  }

  public ks$d()
  {
    this.d = 1;
    this.c = new HashSet();
  }

  ks$d(Set paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.c = paramSet;
    this.d = paramInt;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramString4;
    this.i = paramString5;
    this.j = paramString6;
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
    String str;
    switch (parama.g())
    {
    default:
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.g());
    case 2:
      str = this.e;
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (true)
    {
      return str;
      str = this.f;
      continue;
      str = this.g;
      continue;
      str = this.h;
      continue;
      str = this.i;
      continue;
      str = this.j;
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
    int k;
    if (!(paramObject instanceof d))
      k = 0;
    while (true)
    {
      return k;
      if (this == paramObject)
      {
        k = 1;
        continue;
      }
      d locald = (d)paramObject;
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
          if (locald.a(locala))
          {
            if (b(locala).equals(locald.b(locala)))
              continue;
            k = 0;
            break;
          }
        }
        k = 0;
        break;
      }
      while (!locald.a(locala));
      k = 0;
      continue;
      label124: k = 1;
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
    int k = 0;
    hy.a locala;
    if (localIterator.hasNext())
    {
      locala = (hy.a)localIterator.next();
      if (!a(locala))
        break label66;
    }
    label66: for (int m = k + locala.g() + b(locala).hashCode(); ; m = k)
    {
      k = m;
      break;
      return k;
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

  public String l()
  {
    return this.j;
  }

  public d m()
  {
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ng.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ks.d
 * JD-Core Version:    0.6.0
 */