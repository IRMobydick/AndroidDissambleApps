package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.plus.a.a.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class kn extends hy
  implements SafeParcelable, a
{
  public static final my a = new my();
  private static final HashMap b = new HashMap();
  private String A;
  private String B;
  private String C;
  private String D;
  private String E;
  private kn F;
  private String G;
  private String H;
  private String I;
  private String J;
  private kn K;
  private double L;
  private kn M;
  private double N;
  private String O;
  private kn P;
  private List Q;
  private String R;
  private String S;
  private String T;
  private String U;
  private kn V;
  private String W;
  private String X;
  private String Y;
  private kn Z;
  private String aa;
  private String ab;
  private String ac;
  private String ad;
  private String ae;
  private String af;
  private final Set c;
  private final int d;
  private kn e;
  private List f;
  private kn g;
  private String h;
  private String i;
  private String j;
  private List k;
  private int l;
  private List m;
  private kn n;
  private List o;
  private String p;
  private String q;
  private kn r;
  private String s;
  private String t;
  private String u;
  private List v;
  private String w;
  private String x;
  private String y;
  private String z;

  static
  {
    b.put("about", hy.a.a("about", 2, kn.class));
    b.put("additionalName", hy.a.e("additionalName", 3));
    b.put("address", hy.a.a("address", 4, kn.class));
    b.put("addressCountry", hy.a.d("addressCountry", 5));
    b.put("addressLocality", hy.a.d("addressLocality", 6));
    b.put("addressRegion", hy.a.d("addressRegion", 7));
    b.put("associated_media", hy.a.b("associated_media", 8, kn.class));
    b.put("attendeeCount", hy.a.a("attendeeCount", 9));
    b.put("attendees", hy.a.b("attendees", 10, kn.class));
    b.put("audio", hy.a.a("audio", 11, kn.class));
    b.put("author", hy.a.b("author", 12, kn.class));
    b.put("bestRating", hy.a.d("bestRating", 13));
    b.put("birthDate", hy.a.d("birthDate", 14));
    b.put("byArtist", hy.a.a("byArtist", 15, kn.class));
    b.put("caption", hy.a.d("caption", 16));
    b.put("contentSize", hy.a.d("contentSize", 17));
    b.put("contentUrl", hy.a.d("contentUrl", 18));
    b.put("contributor", hy.a.b("contributor", 19, kn.class));
    b.put("dateCreated", hy.a.d("dateCreated", 20));
    b.put("dateModified", hy.a.d("dateModified", 21));
    b.put("datePublished", hy.a.d("datePublished", 22));
    b.put("description", hy.a.d("description", 23));
    b.put("duration", hy.a.d("duration", 24));
    b.put("embedUrl", hy.a.d("embedUrl", 25));
    b.put("endDate", hy.a.d("endDate", 26));
    b.put("familyName", hy.a.d("familyName", 27));
    b.put("gender", hy.a.d("gender", 28));
    b.put("geo", hy.a.a("geo", 29, kn.class));
    b.put("givenName", hy.a.d("givenName", 30));
    b.put("height", hy.a.d("height", 31));
    b.put("id", hy.a.d("id", 32));
    b.put("image", hy.a.d("image", 33));
    b.put("inAlbum", hy.a.a("inAlbum", 34, kn.class));
    b.put("latitude", hy.a.b("latitude", 36));
    b.put("location", hy.a.a("location", 37, kn.class));
    b.put("longitude", hy.a.b("longitude", 38));
    b.put("name", hy.a.d("name", 39));
    b.put("partOfTVSeries", hy.a.a("partOfTVSeries", 40, kn.class));
    b.put("performers", hy.a.b("performers", 41, kn.class));
    b.put("playerType", hy.a.d("playerType", 42));
    b.put("postOfficeBoxNumber", hy.a.d("postOfficeBoxNumber", 43));
    b.put("postalCode", hy.a.d("postalCode", 44));
    b.put("ratingValue", hy.a.d("ratingValue", 45));
    b.put("reviewRating", hy.a.a("reviewRating", 46, kn.class));
    b.put("startDate", hy.a.d("startDate", 47));
    b.put("streetAddress", hy.a.d("streetAddress", 48));
    b.put("text", hy.a.d("text", 49));
    b.put("thumbnail", hy.a.a("thumbnail", 50, kn.class));
    b.put("thumbnailUrl", hy.a.d("thumbnailUrl", 51));
    b.put("tickerSymbol", hy.a.d("tickerSymbol", 52));
    b.put("type", hy.a.d("type", 53));
    b.put("url", hy.a.d("url", 54));
    b.put("width", hy.a.d("width", 55));
    b.put("worstRating", hy.a.d("worstRating", 56));
  }

  public kn()
  {
    this.d = 1;
    this.c = new HashSet();
  }

  kn(Set paramSet, int paramInt1, kn paramkn1, List paramList1, kn paramkn2, String paramString1, String paramString2, String paramString3, List paramList2, int paramInt2, List paramList3, kn paramkn3, List paramList4, String paramString4, String paramString5, kn paramkn4, String paramString6, String paramString7, String paramString8, List paramList5, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, kn paramkn5, String paramString18, String paramString19, String paramString20, String paramString21, kn paramkn6, double paramDouble1, kn paramkn7, double paramDouble2, String paramString22, kn paramkn8, List paramList6, String paramString23, String paramString24, String paramString25, String paramString26, kn paramkn9, String paramString27, String paramString28, String paramString29, kn paramkn10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.c = paramSet;
    this.d = paramInt1;
    this.e = paramkn1;
    this.f = paramList1;
    this.g = paramkn2;
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
    this.k = paramList2;
    this.l = paramInt2;
    this.m = paramList3;
    this.n = paramkn3;
    this.o = paramList4;
    this.p = paramString4;
    this.q = paramString5;
    this.r = paramkn4;
    this.s = paramString6;
    this.t = paramString7;
    this.u = paramString8;
    this.v = paramList5;
    this.w = paramString9;
    this.x = paramString10;
    this.y = paramString11;
    this.z = paramString12;
    this.A = paramString13;
    this.B = paramString14;
    this.C = paramString15;
    this.D = paramString16;
    this.E = paramString17;
    this.F = paramkn5;
    this.G = paramString18;
    this.H = paramString19;
    this.I = paramString20;
    this.J = paramString21;
    this.K = paramkn6;
    this.L = paramDouble1;
    this.M = paramkn7;
    this.N = paramDouble2;
    this.O = paramString22;
    this.P = paramkn8;
    this.Q = paramList6;
    this.R = paramString23;
    this.S = paramString24;
    this.T = paramString25;
    this.U = paramString26;
    this.V = paramkn9;
    this.W = paramString27;
    this.X = paramString28;
    this.Y = paramString29;
    this.Z = paramkn10;
    this.aa = paramString30;
    this.ab = paramString31;
    this.ac = paramString32;
    this.ad = paramString33;
    this.ae = paramString34;
    this.af = paramString35;
  }

  public String A()
  {
    return this.y;
  }

  public String B()
  {
    return this.z;
  }

  public String C()
  {
    return this.A;
  }

  public String D()
  {
    return this.B;
  }

  public String E()
  {
    return this.C;
  }

  public String F()
  {
    return this.D;
  }

  public String G()
  {
    return this.E;
  }

  kn H()
  {
    return this.F;
  }

  public String I()
  {
    return this.G;
  }

  public String J()
  {
    return this.H;
  }

  public String K()
  {
    return this.I;
  }

  public String L()
  {
    return this.J;
  }

  kn M()
  {
    return this.K;
  }

  public double N()
  {
    return this.L;
  }

  kn O()
  {
    return this.M;
  }

  public double P()
  {
    return this.N;
  }

  public String Q()
  {
    return this.O;
  }

  kn R()
  {
    return this.P;
  }

  List S()
  {
    return this.Q;
  }

  public String T()
  {
    return this.R;
  }

  public String U()
  {
    return this.S;
  }

  public String V()
  {
    return this.T;
  }

  public String W()
  {
    return this.U;
  }

  kn X()
  {
    return this.V;
  }

  public String Y()
  {
    return this.W;
  }

  public String Z()
  {
    return this.X;
  }

  protected Object a(String paramString)
  {
    return null;
  }

  protected boolean a(hy.a parama)
  {
    return this.c.contains(Integer.valueOf(parama.g()));
  }

  public String aa()
  {
    return this.Y;
  }

  kn ab()
  {
    return this.Z;
  }

  public String ac()
  {
    return this.aa;
  }

  public String ad()
  {
    return this.ab;
  }

  public String ae()
  {
    return this.ac;
  }

  public String af()
  {
    return this.ad;
  }

  public String ag()
  {
    return this.ae;
  }

  public String ah()
  {
    return this.af;
  }

  public kn ai()
  {
    return this;
  }

  protected Object b(hy.a parama)
  {
    Object localObject;
    switch (parama.g())
    {
    case 35:
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
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 16:
    case 17:
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
    case 30:
    case 31:
    case 32:
    case 33:
    case 34:
    case 36:
    case 37:
    case 38:
    case 39:
    case 40:
    case 41:
    case 42:
    case 43:
    case 44:
    case 45:
    case 46:
    case 47:
    case 48:
    case 49:
    case 50:
    case 51:
    case 52:
    case 53:
    case 54:
    case 55:
    case 56:
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
      localObject = this.j;
      continue;
      localObject = this.k;
      continue;
      localObject = Integer.valueOf(this.l);
      continue;
      localObject = this.m;
      continue;
      localObject = this.n;
      continue;
      localObject = this.o;
      continue;
      localObject = this.p;
      continue;
      localObject = this.q;
      continue;
      localObject = this.r;
      continue;
      localObject = this.s;
      continue;
      localObject = this.t;
      continue;
      localObject = this.u;
      continue;
      localObject = this.v;
      continue;
      localObject = this.w;
      continue;
      localObject = this.x;
      continue;
      localObject = this.y;
      continue;
      localObject = this.z;
      continue;
      localObject = this.A;
      continue;
      localObject = this.B;
      continue;
      localObject = this.C;
      continue;
      localObject = this.D;
      continue;
      localObject = this.E;
      continue;
      localObject = this.F;
      continue;
      localObject = this.G;
      continue;
      localObject = this.H;
      continue;
      localObject = this.I;
      continue;
      localObject = this.J;
      continue;
      localObject = this.K;
      continue;
      localObject = Double.valueOf(this.L);
      continue;
      localObject = this.M;
      continue;
      localObject = Double.valueOf(this.N);
      continue;
      localObject = this.O;
      continue;
      localObject = this.P;
      continue;
      localObject = this.Q;
      continue;
      localObject = this.R;
      continue;
      localObject = this.S;
      continue;
      localObject = this.T;
      continue;
      localObject = this.U;
      continue;
      localObject = this.V;
      continue;
      localObject = this.W;
      continue;
      localObject = this.X;
      continue;
      localObject = this.Y;
      continue;
      localObject = this.Z;
      continue;
      localObject = this.aa;
      continue;
      localObject = this.ab;
      continue;
      localObject = this.ac;
      continue;
      localObject = this.ad;
      continue;
      localObject = this.ae;
      continue;
      localObject = this.af;
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
    if (!(paramObject instanceof kn))
      i1 = 0;
    while (true)
    {
      return i1;
      if (this == paramObject)
      {
        i1 = 1;
        continue;
      }
      kn localkn = (kn)paramObject;
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
          if (localkn.a(locala))
          {
            if (b(locala).equals(localkn.b(locala)))
              continue;
            i1 = 0;
            break;
          }
        }
        i1 = 0;
        break;
      }
      while (!localkn.a(locala));
      i1 = 0;
      continue;
      label124: i1 = 1;
    }
  }

  int f()
  {
    return this.d;
  }

  kn g()
  {
    return this.e;
  }

  public List h()
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

  kn i()
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

  List m()
  {
    return this.k;
  }

  public int n()
  {
    return this.l;
  }

  List o()
  {
    return this.m;
  }

  kn p()
  {
    return this.n;
  }

  List q()
  {
    return this.o;
  }

  public String r()
  {
    return this.p;
  }

  public String s()
  {
    return this.q;
  }

  kn t()
  {
    return this.r;
  }

  public String u()
  {
    return this.s;
  }

  public String v()
  {
    return this.t;
  }

  public String w()
  {
    return this.u;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    my.a(this, paramParcel, paramInt);
  }

  List x()
  {
    return this.v;
  }

  public String y()
  {
    return this.w;
  }

  public String z()
  {
    return this.x;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kn
 * JD-Core Version:    0.6.0
 */