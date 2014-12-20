package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.a.b.c;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ks$b extends hy
  implements SafeParcelable, c
{
  public static final nc a = new nc();
  private static final HashMap b = new HashMap();
  private final Set c;
  private final int d;
  private ks.b.a e;
  private ks.b.b f;
  private int g;

  static
  {
    b.put("coverInfo", hy.a.a("coverInfo", 2, ks.b.a.class));
    b.put("coverPhoto", hy.a.a("coverPhoto", 3, ks.b.b.class));
    b.put("layout", hy.a.a("layout", 4, new hv().a("banner", 0), false));
  }

  public ks$b()
  {
    this.d = 1;
    this.c = new HashSet();
  }

  ks$b(Set paramSet, int paramInt1, ks.b.a parama, ks.b.b paramb, int paramInt2)
  {
    this.c = paramSet;
    this.d = paramInt1;
    this.e = parama;
    this.f = paramb;
    this.g = paramInt2;
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
    }
    while (true)
    {
      return localObject;
      localObject = this.f;
      continue;
      localObject = Integer.valueOf(this.g);
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
    if (!(paramObject instanceof b))
      i = 0;
    while (true)
    {
      return i;
      if (this == paramObject)
      {
        i = 1;
        continue;
      }
      b localb = (b)paramObject;
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
          if (localb.a(locala))
          {
            if (b(locala).equals(localb.b(locala)))
              continue;
            i = 0;
            break;
          }
        }
        i = 0;
        break;
      }
      while (!localb.a(locala));
      i = 0;
      continue;
      label124: i = 1;
    }
  }

  int f()
  {
    return this.d;
  }

  ks.b.a g()
  {
    return this.e;
  }

  ks.b.b h()
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

  public int i()
  {
    return this.g;
  }

  public b j()
  {
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nc.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ks.b
 * JD-Core Version:    0.6.0
 */