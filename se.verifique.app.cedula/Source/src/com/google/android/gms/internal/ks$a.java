package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.a.b.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ks$a extends hy
  implements SafeParcelable, b
{
  public static final nb a = new nb();
  private static final HashMap b = new HashMap();
  private final Set c;
  private final int d;
  private int e;
  private int f;

  static
  {
    b.put("max", hy.a.a("max", 2));
    b.put("min", hy.a.a("min", 3));
  }

  public ks$a()
  {
    this.d = 1;
    this.c = new HashSet();
  }

  ks$a(Set paramSet, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramSet;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
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
    switch (parama.g())
    {
    default:
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.g());
    case 2:
    case 3:
    }
    for (Integer localInteger = Integer.valueOf(this.e); ; localInteger = Integer.valueOf(this.f))
      return localInteger;
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
    if (!(paramObject instanceof a))
      i = 0;
    while (true)
    {
      return i;
      if (this == paramObject)
      {
        i = 1;
        continue;
      }
      a locala = (a)paramObject;
      Iterator localIterator = b.values().iterator();
      hy.a locala1;
      label109: 
      do
      {
        while (true)
        {
          if (!localIterator.hasNext())
            break label124;
          locala1 = (hy.a)localIterator.next();
          if (!a(locala1))
            break label109;
          if (locala.a(locala1))
          {
            if (b(locala1).equals(locala.b(locala1)))
              continue;
            i = 0;
            break;
          }
        }
        i = 0;
        break;
      }
      while (!locala.a(locala1));
      i = 0;
      continue;
      label124: i = 1;
    }
  }

  int f()
  {
    return this.d;
  }

  public int g()
  {
    return this.e;
  }

  public int h()
  {
    return this.f;
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

  public a i()
  {
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nb.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ks.a
 * JD-Core Version:    0.6.0
 */