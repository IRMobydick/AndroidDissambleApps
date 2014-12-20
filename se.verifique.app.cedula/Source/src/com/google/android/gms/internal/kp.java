package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.a.a.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class kp extends hy
  implements SafeParcelable, b
{
  public static final mz a = new mz();
  private static final HashMap b = new HashMap();
  private final Set c;
  private final int d;
  private String e;
  private kn f;
  private String g;
  private kn h;
  private String i;

  static
  {
    b.put("id", hy.a.d("id", 2));
    b.put("result", hy.a.a("result", 4, kn.class));
    b.put("startDate", hy.a.d("startDate", 5));
    b.put("target", hy.a.a("target", 6, kn.class));
    b.put("type", hy.a.d("type", 7));
  }

  public kp()
  {
    this.d = 1;
    this.c = new HashSet();
  }

  kp(Set paramSet, int paramInt, String paramString1, kn paramkn1, String paramString2, kn paramkn2, String paramString3)
  {
    this.c = paramSet;
    this.d = paramInt;
    this.e = paramString1;
    this.f = paramkn1;
    this.g = paramString2;
    this.h = paramkn2;
    this.i = paramString3;
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
    case 3:
    default:
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.g());
    case 2:
      localObject = this.e;
    case 4:
    case 5:
    case 6:
    case 7:
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
    int j;
    if (!(paramObject instanceof kp))
      j = 0;
    while (true)
    {
      return j;
      if (this == paramObject)
      {
        j = 1;
        continue;
      }
      kp localkp = (kp)paramObject;
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
          if (localkp.a(locala))
          {
            if (b(locala).equals(localkp.b(locala)))
              continue;
            j = 0;
            break;
          }
        }
        j = 0;
        break;
      }
      while (!localkp.a(locala));
      j = 0;
      continue;
      label124: j = 1;
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

  kn h()
  {
    return this.f;
  }

  public int hashCode()
  {
    Iterator localIterator = b.values().iterator();
    int j = 0;
    hy.a locala;
    if (localIterator.hasNext())
    {
      locala = (hy.a)localIterator.next();
      if (!a(locala))
        break label66;
    }
    label66: for (int k = j + locala.g() + b(locala).hashCode(); ; k = j)
    {
      j = k;
      break;
      return j;
    }
  }

  public String i()
  {
    return this.g;
  }

  kn j()
  {
    return this.h;
  }

  public String k()
  {
    return this.i;
  }

  public kp l()
  {
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    mz.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kp
 * JD-Core Version:    0.6.0
 */