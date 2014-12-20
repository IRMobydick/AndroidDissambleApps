package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.a.b.i;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ks$g extends hy
  implements SafeParcelable, i
{
  public static final nj a = new nj();
  private static final HashMap b = new HashMap();
  private final Set c;
  private final int d;
  private boolean e;
  private String f;

  static
  {
    b.put("primary", hy.a.c("primary", 2));
    b.put("value", hy.a.d("value", 3));
  }

  public ks$g()
  {
    this.d = 1;
    this.c = new HashSet();
  }

  ks$g(Set paramSet, int paramInt, boolean paramBoolean, String paramString)
  {
    this.c = paramSet;
    this.d = paramInt;
    this.e = paramBoolean;
    this.f = paramString;
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
    for (Object localObject = Boolean.valueOf(this.e); ; localObject = this.f)
      return localObject;
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
    if (!(paramObject instanceof g))
      i = 0;
    while (true)
    {
      return i;
      if (this == paramObject)
      {
        i = 1;
        continue;
      }
      g localg = (g)paramObject;
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
          if (localg.a(locala))
          {
            if (b(locala).equals(localg.b(locala)))
              continue;
            i = 0;
            break;
          }
        }
        i = 0;
        break;
      }
      while (!localg.a(locala));
      i = 0;
      continue;
      label124: i = 1;
    }
  }

  int f()
  {
    return this.d;
  }

  public boolean g()
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

  public g i()
  {
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nj.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ks.g
 * JD-Core Version:    0.6.0
 */