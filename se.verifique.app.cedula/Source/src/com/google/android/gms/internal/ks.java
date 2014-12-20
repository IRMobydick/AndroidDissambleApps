package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.a.b.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ks extends hy
  implements SafeParcelable, a
{
  public static final na a = new na();
  private static final HashMap b = new HashMap();
  private List A;
  private boolean B;
  private final Set c;
  private final int d;
  private String e;
  private ks.a f;
  private String g;
  private String h;
  private int i;
  private ks.b j;
  private String k;
  private String l;
  private int m;
  private String n;
  private ks.c o;
  private boolean p;
  private String q;
  private ks.d r;
  private String s;
  private int t;
  private List u;
  private List v;
  private int w;
  private int x;
  private String y;
  private String z;

  static
  {
    b.put("aboutMe", hy.a.d("aboutMe", 2));
    b.put("ageRange", hy.a.a("ageRange", 3, ks.a.class));
    b.put("birthday", hy.a.d("birthday", 4));
    b.put("braggingRights", hy.a.d("braggingRights", 5));
    b.put("circledByCount", hy.a.a("circledByCount", 6));
    b.put("cover", hy.a.a("cover", 7, ks.b.class));
    b.put("currentLocation", hy.a.d("currentLocation", 8));
    b.put("displayName", hy.a.d("displayName", 9));
    b.put("gender", hy.a.a("gender", 12, new hv().a("male", 0).a("female", 1).a("other", 2), false));
    b.put("id", hy.a.d("id", 14));
    b.put("image", hy.a.a("image", 15, ks.c.class));
    b.put("isPlusUser", hy.a.c("isPlusUser", 16));
    b.put("language", hy.a.d("language", 18));
    b.put("name", hy.a.a("name", 19, ks.d.class));
    b.put("nickname", hy.a.d("nickname", 20));
    b.put("objectType", hy.a.a("objectType", 21, new hv().a("person", 0).a("page", 1), false));
    b.put("organizations", hy.a.b("organizations", 22, ks.f.class));
    b.put("placesLived", hy.a.b("placesLived", 23, ks.g.class));
    b.put("plusOneCount", hy.a.a("plusOneCount", 24));
    b.put("relationshipStatus", hy.a.a("relationshipStatus", 25, new hv().a("single", 0).a("in_a_relationship", 1).a("engaged", 2).a("married", 3).a("its_complicated", 4).a("open_relationship", 5).a("widowed", 6).a("in_domestic_partnership", 7).a("in_civil_union", 8), false));
    b.put("tagline", hy.a.d("tagline", 26));
    b.put("url", hy.a.d("url", 27));
    b.put("urls", hy.a.b("urls", 28, ks.h.class));
    b.put("verified", hy.a.c("verified", 29));
  }

  public ks()
  {
    this.d = 2;
    this.c = new HashSet();
  }

  ks(Set paramSet, int paramInt1, String paramString1, ks.a parama, String paramString2, String paramString3, int paramInt2, ks.b paramb, String paramString4, String paramString5, int paramInt3, String paramString6, ks.c paramc, boolean paramBoolean1, String paramString7, ks.d paramd, String paramString8, int paramInt4, List paramList1, List paramList2, int paramInt5, int paramInt6, String paramString9, String paramString10, List paramList3, boolean paramBoolean2)
  {
    this.c = paramSet;
    this.d = paramInt1;
    this.e = paramString1;
    this.f = parama;
    this.g = paramString2;
    this.h = paramString3;
    this.i = paramInt2;
    this.j = paramb;
    this.k = paramString4;
    this.l = paramString5;
    this.m = paramInt3;
    this.n = paramString6;
    this.o = paramc;
    this.p = paramBoolean1;
    this.q = paramString7;
    this.r = paramd;
    this.s = paramString8;
    this.t = paramInt4;
    this.u = paramList1;
    this.v = paramList2;
    this.w = paramInt5;
    this.x = paramInt6;
    this.y = paramString9;
    this.z = paramString10;
    this.A = paramList3;
    this.B = paramBoolean2;
  }

  public String A()
  {
    return this.y;
  }

  public String B()
  {
    return this.z;
  }

  List C()
  {
    return this.A;
  }

  public boolean D()
  {
    return this.B;
  }

  public ks E()
  {
    return this;
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
    case 10:
    case 11:
    case 13:
    case 17:
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
    case 12:
    case 14:
    case 15:
    case 16:
    case 18:
    case 19:
    case 20:
    case 21:
    case 22:
    case 23:
    case 24:
    case 25:
    case 26:
    case 27:
    case 28:
    case 29:
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
      localObject = Integer.valueOf(this.i);
      continue;
      localObject = this.j;
      continue;
      localObject = this.k;
      continue;
      localObject = this.l;
      continue;
      localObject = Integer.valueOf(this.m);
      continue;
      localObject = this.n;
      continue;
      localObject = this.o;
      continue;
      localObject = Boolean.valueOf(this.p);
      continue;
      localObject = this.q;
      continue;
      localObject = this.r;
      continue;
      localObject = this.s;
      continue;
      localObject = Integer.valueOf(this.t);
      continue;
      localObject = this.u;
      continue;
      localObject = this.v;
      continue;
      localObject = Integer.valueOf(this.w);
      continue;
      localObject = Integer.valueOf(this.x);
      continue;
      localObject = this.y;
      continue;
      localObject = this.z;
      continue;
      localObject = this.A;
      continue;
      localObject = Boolean.valueOf(this.B);
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
    int i1;
    if (!(paramObject instanceof ks))
      i1 = 0;
    while (true)
    {
      return i1;
      if (this == paramObject)
      {
        i1 = 1;
        continue;
      }
      ks localks = (ks)paramObject;
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
          if (localks.a(locala))
          {
            if (b(locala).equals(localks.b(locala)))
              continue;
            i1 = 0;
            break;
          }
        }
        i1 = 0;
        break;
      }
      while (!localks.a(locala));
      i1 = 0;
      continue;
      label124: i1 = 1;
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

  ks.a h()
  {
    return this.f;
  }

  public int hashCode()
  {
    Iterator localIterator = b.values().iterator();
    int i1 = 0;
    hy.a locala;
    if (localIterator.hasNext())
    {
      locala = (hy.a)localIterator.next();
      if (!a(locala))
        break label66;
    }
    label66: for (int i2 = i1 + locala.g() + b(locala).hashCode(); ; i2 = i1)
    {
      i1 = i2;
      break;
      return i1;
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

  public int k()
  {
    return this.i;
  }

  ks.b l()
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

  public String p()
  {
    return this.n;
  }

  ks.c q()
  {
    return this.o;
  }

  public boolean r()
  {
    return this.p;
  }

  public String s()
  {
    return this.q;
  }

  ks.d t()
  {
    return this.r;
  }

  public String u()
  {
    return this.s;
  }

  public int v()
  {
    return this.t;
  }

  List w()
  {
    return this.u;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    na.a(this, paramParcel, paramInt);
  }

  List x()
  {
    return this.v;
  }

  public int y()
  {
    return this.w;
  }

  public int z()
  {
    return this.x;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ks
 * JD-Core Version:    0.6.0
 */