package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class nz extends jj
  implements Person
{
  public static final oa CREATOR = new oa();
  private static final HashMap<String, ji.a<?, ?>> amb = new HashMap();
  String BL;
  final int BR;
  String Fc;
  String NH;
  final Set<Integer> amc;
  String ana;
  a anb;
  String anc;
  String and;
  int ane;
  b anf;
  String ang;
  c anh;
  boolean ani;
  d anj;
  String ank;
  int anl;
  List<f> anm;
  List<g> ann;
  int ano;
  int anp;
  String anq;
  List<h> anr;
  boolean ans;
  int om;
  String uR;

  static
  {
    amb.put("aboutMe", ji.a.l("aboutMe", 2));
    amb.put("ageRange", ji.a.a("ageRange", 3, a.class));
    amb.put("birthday", ji.a.l("birthday", 4));
    amb.put("braggingRights", ji.a.l("braggingRights", 5));
    amb.put("circledByCount", ji.a.i("circledByCount", 6));
    amb.put("cover", ji.a.a("cover", 7, b.class));
    amb.put("currentLocation", ji.a.l("currentLocation", 8));
    amb.put("displayName", ji.a.l("displayName", 9));
    amb.put("gender", ji.a.a("gender", 12, new jf().h("male", 0).h("female", 1).h("other", 2), false));
    amb.put("id", ji.a.l("id", 14));
    amb.put("image", ji.a.a("image", 15, c.class));
    amb.put("isPlusUser", ji.a.k("isPlusUser", 16));
    amb.put("language", ji.a.l("language", 18));
    amb.put("name", ji.a.a("name", 19, d.class));
    amb.put("nickname", ji.a.l("nickname", 20));
    amb.put("objectType", ji.a.a("objectType", 21, new jf().h("person", 0).h("page", 1), false));
    amb.put("organizations", ji.a.b("organizations", 22, f.class));
    amb.put("placesLived", ji.a.b("placesLived", 23, g.class));
    amb.put("plusOneCount", ji.a.i("plusOneCount", 24));
    amb.put("relationshipStatus", ji.a.a("relationshipStatus", 25, new jf().h("single", 0).h("in_a_relationship", 1).h("engaged", 2).h("married", 3).h("its_complicated", 4).h("open_relationship", 5).h("widowed", 6).h("in_domestic_partnership", 7).h("in_civil_union", 8), false));
    amb.put("tagline", ji.a.l("tagline", 26));
    amb.put("url", ji.a.l("url", 27));
    amb.put("urls", ji.a.b("urls", 28, h.class));
    amb.put("verified", ji.a.k("verified", 29));
  }

  public nz()
  {
    this.BR = 1;
    this.amc = new HashSet();
  }

  public nz(String paramString1, String paramString2, c paramc, int paramInt, String paramString3)
  {
    this.BR = 1;
    this.amc = new HashSet();
    this.NH = paramString1;
    this.amc.add(Integer.valueOf(9));
    this.BL = paramString2;
    this.amc.add(Integer.valueOf(14));
    this.anh = paramc;
    this.amc.add(Integer.valueOf(15));
    this.anl = paramInt;
    this.amc.add(Integer.valueOf(21));
    this.uR = paramString3;
    this.amc.add(Integer.valueOf(27));
  }

  nz(Set<Integer> paramSet, int paramInt1, String paramString1, a parama, String paramString2, String paramString3, int paramInt2, b paramb, String paramString4, String paramString5, int paramInt3, String paramString6, c paramc, boolean paramBoolean1, String paramString7, d paramd, String paramString8, int paramInt4, List<f> paramList, List<g> paramList1, int paramInt5, int paramInt6, String paramString9, String paramString10, List<h> paramList2, boolean paramBoolean2)
  {
    this.amc = paramSet;
    this.BR = paramInt1;
    this.ana = paramString1;
    this.anb = parama;
    this.anc = paramString2;
    this.and = paramString3;
    this.ane = paramInt2;
    this.anf = paramb;
    this.ang = paramString4;
    this.NH = paramString5;
    this.om = paramInt3;
    this.BL = paramString6;
    this.anh = paramc;
    this.ani = paramBoolean1;
    this.Fc = paramString7;
    this.anj = paramd;
    this.ank = paramString8;
    this.anl = paramInt4;
    this.anm = paramList;
    this.ann = paramList1;
    this.ano = paramInt5;
    this.anp = paramInt6;
    this.anq = paramString9;
    this.uR = paramString10;
    this.anr = paramList2;
    this.ans = paramBoolean2;
  }

  public static nz i(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    nz localnz = CREATOR.dd(localParcel);
    localParcel.recycle();
    return localnz;
  }

  protected boolean a(ji.a parama)
  {
    return this.amc.contains(Integer.valueOf(parama.hm()));
  }

  protected Object b(ji.a parama)
  {
    switch (parama.hm())
    {
    case 10:
    case 11:
    case 13:
    case 17:
    default:
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
    case 2:
      return this.ana;
    case 3:
      return this.anb;
    case 4:
      return this.anc;
    case 5:
      return this.and;
    case 6:
      return Integer.valueOf(this.ane);
    case 7:
      return this.anf;
    case 8:
      return this.ang;
    case 9:
      return this.NH;
    case 12:
      return Integer.valueOf(this.om);
    case 14:
      return this.BL;
    case 15:
      return this.anh;
    case 16:
      return Boolean.valueOf(this.ani);
    case 18:
      return this.Fc;
    case 19:
      return this.anj;
    case 20:
      return this.ank;
    case 21:
      return Integer.valueOf(this.anl);
    case 22:
      return this.anm;
    case 23:
      return this.ann;
    case 24:
      return Integer.valueOf(this.ano);
    case 25:
      return Integer.valueOf(this.anp);
    case 26:
      return this.anq;
    case 27:
      return this.uR;
    case 28:
      return this.anr;
    case 29:
    }
    return Boolean.valueOf(this.ans);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof nz))
      return false;
    if (this == paramObject)
      return true;
    nz localnz = (nz)paramObject;
    Iterator localIterator = amb.values().iterator();
    while (localIterator.hasNext())
    {
      ji.a locala = (ji.a)localIterator.next();
      if (a(locala))
      {
        if (localnz.a(locala))
        {
          if (!b(locala).equals(localnz.b(locala)))
            return false;
        }
        else
          return false;
      }
      else if (localnz.a(locala))
        return false;
    }
    return true;
  }

  public String getAboutMe()
  {
    return this.ana;
  }

  public Person.AgeRange getAgeRange()
  {
    return this.anb;
  }

  public String getBirthday()
  {
    return this.anc;
  }

  public String getBraggingRights()
  {
    return this.and;
  }

  public int getCircledByCount()
  {
    return this.ane;
  }

  public Person.Cover getCover()
  {
    return this.anf;
  }

  public String getCurrentLocation()
  {
    return this.ang;
  }

  public String getDisplayName()
  {
    return this.NH;
  }

  public int getGender()
  {
    return this.om;
  }

  public String getId()
  {
    return this.BL;
  }

  public Person.Image getImage()
  {
    return this.anh;
  }

  public String getLanguage()
  {
    return this.Fc;
  }

  public Person.Name getName()
  {
    return this.anj;
  }

  public String getNickname()
  {
    return this.ank;
  }

  public int getObjectType()
  {
    return this.anl;
  }

  public List<Person.Organizations> getOrganizations()
  {
    return (ArrayList)this.anm;
  }

  public List<Person.PlacesLived> getPlacesLived()
  {
    return (ArrayList)this.ann;
  }

  public int getPlusOneCount()
  {
    return this.ano;
  }

  public int getRelationshipStatus()
  {
    return this.anp;
  }

  public String getTagline()
  {
    return this.anq;
  }

  public String getUrl()
  {
    return this.uR;
  }

  public List<Person.Urls> getUrls()
  {
    return (ArrayList)this.anr;
  }

  public boolean hasAboutMe()
  {
    return this.amc.contains(Integer.valueOf(2));
  }

  public boolean hasAgeRange()
  {
    return this.amc.contains(Integer.valueOf(3));
  }

  public boolean hasBirthday()
  {
    return this.amc.contains(Integer.valueOf(4));
  }

  public boolean hasBraggingRights()
  {
    return this.amc.contains(Integer.valueOf(5));
  }

  public boolean hasCircledByCount()
  {
    return this.amc.contains(Integer.valueOf(6));
  }

  public boolean hasCover()
  {
    return this.amc.contains(Integer.valueOf(7));
  }

  public boolean hasCurrentLocation()
  {
    return this.amc.contains(Integer.valueOf(8));
  }

  public boolean hasDisplayName()
  {
    return this.amc.contains(Integer.valueOf(9));
  }

  public boolean hasGender()
  {
    return this.amc.contains(Integer.valueOf(12));
  }

  public boolean hasId()
  {
    return this.amc.contains(Integer.valueOf(14));
  }

  public boolean hasImage()
  {
    return this.amc.contains(Integer.valueOf(15));
  }

  public boolean hasIsPlusUser()
  {
    return this.amc.contains(Integer.valueOf(16));
  }

  public boolean hasLanguage()
  {
    return this.amc.contains(Integer.valueOf(18));
  }

  public boolean hasName()
  {
    return this.amc.contains(Integer.valueOf(19));
  }

  public boolean hasNickname()
  {
    return this.amc.contains(Integer.valueOf(20));
  }

  public boolean hasObjectType()
  {
    return this.amc.contains(Integer.valueOf(21));
  }

  public boolean hasOrganizations()
  {
    return this.amc.contains(Integer.valueOf(22));
  }

  public boolean hasPlacesLived()
  {
    return this.amc.contains(Integer.valueOf(23));
  }

  public boolean hasPlusOneCount()
  {
    return this.amc.contains(Integer.valueOf(24));
  }

  public boolean hasRelationshipStatus()
  {
    return this.amc.contains(Integer.valueOf(25));
  }

  public boolean hasTagline()
  {
    return this.amc.contains(Integer.valueOf(26));
  }

  public boolean hasUrl()
  {
    return this.amc.contains(Integer.valueOf(27));
  }

  public boolean hasUrls()
  {
    return this.amc.contains(Integer.valueOf(28));
  }

  public boolean hasVerified()
  {
    return this.amc.contains(Integer.valueOf(29));
  }

  public int hashCode()
  {
    Iterator localIterator = amb.values().iterator();
    int i = 0;
    ji.a locala;
    if (localIterator.hasNext())
    {
      locala = (ji.a)localIterator.next();
      if (!a(locala))
        break label66;
    }
    label66: for (int j = i + locala.hm() + b(locala).hashCode(); ; j = i)
    {
      i = j;
      break;
      return i;
    }
  }

  public HashMap<String, ji.a<?, ?>> hf()
  {
    return amb;
  }

  public boolean isDataValid()
  {
    return true;
  }

  public boolean isPlusUser()
  {
    return this.ani;
  }

  public boolean isVerified()
  {
    return this.ans;
  }

  public nz nu()
  {
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    oa.a(this, paramParcel, paramInt);
  }

  public static final class a extends jj
    implements Person.AgeRange
  {
    public static final ob CREATOR = new ob();
    private static final HashMap<String, ji.a<?, ?>> amb = new HashMap();
    final int BR;
    final Set<Integer> amc;
    int ant;
    int anu;

    static
    {
      amb.put("max", ji.a.i("max", 2));
      amb.put("min", ji.a.i("min", 3));
    }

    public a()
    {
      this.BR = 1;
      this.amc = new HashSet();
    }

    a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
    {
      this.amc = paramSet;
      this.BR = paramInt1;
      this.ant = paramInt2;
      this.anu = paramInt3;
    }

    protected boolean a(ji.a parama)
    {
      return this.amc.contains(Integer.valueOf(parama.hm()));
    }

    protected Object b(ji.a parama)
    {
      switch (parama.hm())
      {
      default:
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
      case 2:
        return Integer.valueOf(this.ant);
      case 3:
      }
      return Integer.valueOf(this.anu);
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a))
        return false;
      if (this == paramObject)
        return true;
      a locala = (a)paramObject;
      Iterator localIterator = amb.values().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala1 = (ji.a)localIterator.next();
        if (a(locala1))
        {
          if (locala.a(locala1))
          {
            if (!b(locala1).equals(locala.b(locala1)))
              return false;
          }
          else
            return false;
        }
        else if (locala.a(locala1))
          return false;
      }
      return true;
    }

    public int getMax()
    {
      return this.ant;
    }

    public int getMin()
    {
      return this.anu;
    }

    public boolean hasMax()
    {
      return this.amc.contains(Integer.valueOf(2));
    }

    public boolean hasMin()
    {
      return this.amc.contains(Integer.valueOf(3));
    }

    public int hashCode()
    {
      Iterator localIterator = amb.values().iterator();
      int i = 0;
      ji.a locala;
      if (localIterator.hasNext())
      {
        locala = (ji.a)localIterator.next();
        if (!a(locala))
          break label66;
      }
      label66: for (int j = i + locala.hm() + b(locala).hashCode(); ; j = i)
      {
        i = j;
        break;
        return i;
      }
    }

    public HashMap<String, ji.a<?, ?>> hf()
    {
      return amb;
    }

    public boolean isDataValid()
    {
      return true;
    }

    public a nv()
    {
      return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ob.a(this, paramParcel, paramInt);
    }
  }

  public static final class b extends jj
    implements Person.Cover
  {
    public static final oc CREATOR = new oc();
    private static final HashMap<String, ji.a<?, ?>> amb = new HashMap();
    final int BR;
    final Set<Integer> amc;
    a anv;
    b anw;
    int anx;

    static
    {
      amb.put("coverInfo", ji.a.a("coverInfo", 2, a.class));
      amb.put("coverPhoto", ji.a.a("coverPhoto", 3, b.class));
      amb.put("layout", ji.a.a("layout", 4, new jf().h("banner", 0), false));
    }

    public b()
    {
      this.BR = 1;
      this.amc = new HashSet();
    }

    b(Set<Integer> paramSet, int paramInt1, a parama, b paramb, int paramInt2)
    {
      this.amc = paramSet;
      this.BR = paramInt1;
      this.anv = parama;
      this.anw = paramb;
      this.anx = paramInt2;
    }

    protected boolean a(ji.a parama)
    {
      return this.amc.contains(Integer.valueOf(parama.hm()));
    }

    protected Object b(ji.a parama)
    {
      switch (parama.hm())
      {
      default:
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
      case 2:
        return this.anv;
      case 3:
        return this.anw;
      case 4:
      }
      return Integer.valueOf(this.anx);
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof b))
        return false;
      if (this == paramObject)
        return true;
      b localb = (b)paramObject;
      Iterator localIterator = amb.values().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
        if (a(locala))
        {
          if (localb.a(locala))
          {
            if (!b(locala).equals(localb.b(locala)))
              return false;
          }
          else
            return false;
        }
        else if (localb.a(locala))
          return false;
      }
      return true;
    }

    public Person.Cover.CoverInfo getCoverInfo()
    {
      return this.anv;
    }

    public Person.Cover.CoverPhoto getCoverPhoto()
    {
      return this.anw;
    }

    public int getLayout()
    {
      return this.anx;
    }

    public boolean hasCoverInfo()
    {
      return this.amc.contains(Integer.valueOf(2));
    }

    public boolean hasCoverPhoto()
    {
      return this.amc.contains(Integer.valueOf(3));
    }

    public boolean hasLayout()
    {
      return this.amc.contains(Integer.valueOf(4));
    }

    public int hashCode()
    {
      Iterator localIterator = amb.values().iterator();
      int i = 0;
      ji.a locala;
      if (localIterator.hasNext())
      {
        locala = (ji.a)localIterator.next();
        if (!a(locala))
          break label66;
      }
      label66: for (int j = i + locala.hm() + b(locala).hashCode(); ; j = i)
      {
        i = j;
        break;
        return i;
      }
    }

    public HashMap<String, ji.a<?, ?>> hf()
    {
      return amb;
    }

    public boolean isDataValid()
    {
      return true;
    }

    public b nw()
    {
      return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      oc.a(this, paramParcel, paramInt);
    }

    public static final class a extends jj
      implements Person.Cover.CoverInfo
    {
      public static final od CREATOR = new od();
      private static final HashMap<String, ji.a<?, ?>> amb = new HashMap();
      final int BR;
      final Set<Integer> amc;
      int any;
      int anz;

      static
      {
        amb.put("leftImageOffset", ji.a.i("leftImageOffset", 2));
        amb.put("topImageOffset", ji.a.i("topImageOffset", 3));
      }

      public a()
      {
        this.BR = 1;
        this.amc = new HashSet();
      }

      a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3)
      {
        this.amc = paramSet;
        this.BR = paramInt1;
        this.any = paramInt2;
        this.anz = paramInt3;
      }

      protected boolean a(ji.a parama)
      {
        return this.amc.contains(Integer.valueOf(parama.hm()));
      }

      protected Object b(ji.a parama)
      {
        switch (parama.hm())
        {
        default:
          throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
        case 2:
          return Integer.valueOf(this.any);
        case 3:
        }
        return Integer.valueOf(this.anz);
      }

      public int describeContents()
      {
        return 0;
      }

      public boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof a))
          return false;
        if (this == paramObject)
          return true;
        a locala = (a)paramObject;
        Iterator localIterator = amb.values().iterator();
        while (localIterator.hasNext())
        {
          ji.a locala1 = (ji.a)localIterator.next();
          if (a(locala1))
          {
            if (locala.a(locala1))
            {
              if (!b(locala1).equals(locala.b(locala1)))
                return false;
            }
            else
              return false;
          }
          else if (locala.a(locala1))
            return false;
        }
        return true;
      }

      public int getLeftImageOffset()
      {
        return this.any;
      }

      public int getTopImageOffset()
      {
        return this.anz;
      }

      public boolean hasLeftImageOffset()
      {
        return this.amc.contains(Integer.valueOf(2));
      }

      public boolean hasTopImageOffset()
      {
        return this.amc.contains(Integer.valueOf(3));
      }

      public int hashCode()
      {
        Iterator localIterator = amb.values().iterator();
        int i = 0;
        ji.a locala;
        if (localIterator.hasNext())
        {
          locala = (ji.a)localIterator.next();
          if (!a(locala))
            break label66;
        }
        label66: for (int j = i + locala.hm() + b(locala).hashCode(); ; j = i)
        {
          i = j;
          break;
          return i;
        }
      }

      public HashMap<String, ji.a<?, ?>> hf()
      {
        return amb;
      }

      public boolean isDataValid()
      {
        return true;
      }

      public a nx()
      {
        return this;
      }

      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        od.a(this, paramParcel, paramInt);
      }
    }

    public static final class b extends jj
      implements Person.Cover.CoverPhoto
    {
      public static final oe CREATOR = new oe();
      private static final HashMap<String, ji.a<?, ?>> amb = new HashMap();
      final int BR;
      final Set<Integer> amc;
      int lf;
      int lg;
      String uR;

      static
      {
        amb.put("height", ji.a.i("height", 2));
        amb.put("url", ji.a.l("url", 3));
        amb.put("width", ji.a.i("width", 4));
      }

      public b()
      {
        this.BR = 1;
        this.amc = new HashSet();
      }

      b(Set<Integer> paramSet, int paramInt1, int paramInt2, String paramString, int paramInt3)
      {
        this.amc = paramSet;
        this.BR = paramInt1;
        this.lg = paramInt2;
        this.uR = paramString;
        this.lf = paramInt3;
      }

      protected boolean a(ji.a parama)
      {
        return this.amc.contains(Integer.valueOf(parama.hm()));
      }

      protected Object b(ji.a parama)
      {
        switch (parama.hm())
        {
        default:
          throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
        case 2:
          return Integer.valueOf(this.lg);
        case 3:
          return this.uR;
        case 4:
        }
        return Integer.valueOf(this.lf);
      }

      public int describeContents()
      {
        return 0;
      }

      public boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof b))
          return false;
        if (this == paramObject)
          return true;
        b localb = (b)paramObject;
        Iterator localIterator = amb.values().iterator();
        while (localIterator.hasNext())
        {
          ji.a locala = (ji.a)localIterator.next();
          if (a(locala))
          {
            if (localb.a(locala))
            {
              if (!b(locala).equals(localb.b(locala)))
                return false;
            }
            else
              return false;
          }
          else if (localb.a(locala))
            return false;
        }
        return true;
      }

      public int getHeight()
      {
        return this.lg;
      }

      public String getUrl()
      {
        return this.uR;
      }

      public int getWidth()
      {
        return this.lf;
      }

      public boolean hasHeight()
      {
        return this.amc.contains(Integer.valueOf(2));
      }

      public boolean hasUrl()
      {
        return this.amc.contains(Integer.valueOf(3));
      }

      public boolean hasWidth()
      {
        return this.amc.contains(Integer.valueOf(4));
      }

      public int hashCode()
      {
        Iterator localIterator = amb.values().iterator();
        int i = 0;
        ji.a locala;
        if (localIterator.hasNext())
        {
          locala = (ji.a)localIterator.next();
          if (!a(locala))
            break label66;
        }
        label66: for (int j = i + locala.hm() + b(locala).hashCode(); ; j = i)
        {
          i = j;
          break;
          return i;
        }
      }

      public HashMap<String, ji.a<?, ?>> hf()
      {
        return amb;
      }

      public boolean isDataValid()
      {
        return true;
      }

      public b ny()
      {
        return this;
      }

      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        oe.a(this, paramParcel, paramInt);
      }
    }
  }

  public static final class c extends jj
    implements Person.Image
  {
    public static final of CREATOR = new of();
    private static final HashMap<String, ji.a<?, ?>> amb = new HashMap();
    final int BR;
    final Set<Integer> amc;
    String uR;

    static
    {
      amb.put("url", ji.a.l("url", 2));
    }

    public c()
    {
      this.BR = 1;
      this.amc = new HashSet();
    }

    public c(String paramString)
    {
      this.amc = new HashSet();
      this.BR = 1;
      this.uR = paramString;
      this.amc.add(Integer.valueOf(2));
    }

    c(Set<Integer> paramSet, int paramInt, String paramString)
    {
      this.amc = paramSet;
      this.BR = paramInt;
      this.uR = paramString;
    }

    protected boolean a(ji.a parama)
    {
      return this.amc.contains(Integer.valueOf(parama.hm()));
    }

    protected Object b(ji.a parama)
    {
      switch (parama.hm())
      {
      default:
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
      case 2:
      }
      return this.uR;
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof c))
        return false;
      if (this == paramObject)
        return true;
      c localc = (c)paramObject;
      Iterator localIterator = amb.values().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
        if (a(locala))
        {
          if (localc.a(locala))
          {
            if (!b(locala).equals(localc.b(locala)))
              return false;
          }
          else
            return false;
        }
        else if (localc.a(locala))
          return false;
      }
      return true;
    }

    public String getUrl()
    {
      return this.uR;
    }

    public boolean hasUrl()
    {
      return this.amc.contains(Integer.valueOf(2));
    }

    public int hashCode()
    {
      Iterator localIterator = amb.values().iterator();
      int i = 0;
      ji.a locala;
      if (localIterator.hasNext())
      {
        locala = (ji.a)localIterator.next();
        if (!a(locala))
          break label66;
      }
      label66: for (int j = i + locala.hm() + b(locala).hashCode(); ; j = i)
      {
        i = j;
        break;
        return i;
      }
    }

    public HashMap<String, ji.a<?, ?>> hf()
    {
      return amb;
    }

    public boolean isDataValid()
    {
      return true;
    }

    public c nz()
    {
      return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      of.a(this, paramParcel, paramInt);
    }
  }

  public static final class d extends jj
    implements Person.Name
  {
    public static final og CREATOR = new og();
    private static final HashMap<String, ji.a<?, ?>> amb = new HashMap();
    final int BR;
    String amA;
    String amD;
    final Set<Integer> amc;
    String anA;
    String anB;
    String anC;
    String anD;

    static
    {
      amb.put("familyName", ji.a.l("familyName", 2));
      amb.put("formatted", ji.a.l("formatted", 3));
      amb.put("givenName", ji.a.l("givenName", 4));
      amb.put("honorificPrefix", ji.a.l("honorificPrefix", 5));
      amb.put("honorificSuffix", ji.a.l("honorificSuffix", 6));
      amb.put("middleName", ji.a.l("middleName", 7));
    }

    public d()
    {
      this.BR = 1;
      this.amc = new HashSet();
    }

    d(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.amc = paramSet;
      this.BR = paramInt;
      this.amA = paramString1;
      this.anA = paramString2;
      this.amD = paramString3;
      this.anB = paramString4;
      this.anC = paramString5;
      this.anD = paramString6;
    }

    protected boolean a(ji.a parama)
    {
      return this.amc.contains(Integer.valueOf(parama.hm()));
    }

    protected Object b(ji.a parama)
    {
      switch (parama.hm())
      {
      default:
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
      case 2:
        return this.amA;
      case 3:
        return this.anA;
      case 4:
        return this.amD;
      case 5:
        return this.anB;
      case 6:
        return this.anC;
      case 7:
      }
      return this.anD;
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof d))
        return false;
      if (this == paramObject)
        return true;
      d locald = (d)paramObject;
      Iterator localIterator = amb.values().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
        if (a(locala))
        {
          if (locald.a(locala))
          {
            if (!b(locala).equals(locald.b(locala)))
              return false;
          }
          else
            return false;
        }
        else if (locald.a(locala))
          return false;
      }
      return true;
    }

    public String getFamilyName()
    {
      return this.amA;
    }

    public String getFormatted()
    {
      return this.anA;
    }

    public String getGivenName()
    {
      return this.amD;
    }

    public String getHonorificPrefix()
    {
      return this.anB;
    }

    public String getHonorificSuffix()
    {
      return this.anC;
    }

    public String getMiddleName()
    {
      return this.anD;
    }

    public boolean hasFamilyName()
    {
      return this.amc.contains(Integer.valueOf(2));
    }

    public boolean hasFormatted()
    {
      return this.amc.contains(Integer.valueOf(3));
    }

    public boolean hasGivenName()
    {
      return this.amc.contains(Integer.valueOf(4));
    }

    public boolean hasHonorificPrefix()
    {
      return this.amc.contains(Integer.valueOf(5));
    }

    public boolean hasHonorificSuffix()
    {
      return this.amc.contains(Integer.valueOf(6));
    }

    public boolean hasMiddleName()
    {
      return this.amc.contains(Integer.valueOf(7));
    }

    public int hashCode()
    {
      Iterator localIterator = amb.values().iterator();
      int i = 0;
      ji.a locala;
      if (localIterator.hasNext())
      {
        locala = (ji.a)localIterator.next();
        if (!a(locala))
          break label66;
      }
      label66: for (int j = i + locala.hm() + b(locala).hashCode(); ; j = i)
      {
        i = j;
        break;
        return i;
      }
    }

    public HashMap<String, ji.a<?, ?>> hf()
    {
      return amb;
    }

    public boolean isDataValid()
    {
      return true;
    }

    public d nA()
    {
      return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      og.a(this, paramParcel, paramInt);
    }
  }

  public static class e
  {
    public static int ci(String paramString)
    {
      if (paramString.equals("person"))
        return 0;
      if (paramString.equals("page"))
        return 1;
      throw new IllegalArgumentException("Unknown objectType string: " + paramString);
    }
  }

  public static final class f extends jj
    implements Person.Organizations
  {
    public static final oh CREATOR = new oh();
    private static final HashMap<String, ji.a<?, ?>> amb = new HashMap();
    final int BR;
    int FD;
    String Nw;
    String Tr;
    String amP;
    final Set<Integer> amc;
    String amz;
    String anE;
    String anF;
    boolean anG;
    String mName;

    static
    {
      amb.put("department", ji.a.l("department", 2));
      amb.put("description", ji.a.l("description", 3));
      amb.put("endDate", ji.a.l("endDate", 4));
      amb.put("location", ji.a.l("location", 5));
      amb.put("name", ji.a.l("name", 6));
      amb.put("primary", ji.a.k("primary", 7));
      amb.put("startDate", ji.a.l("startDate", 8));
      amb.put("title", ji.a.l("title", 9));
      amb.put("type", ji.a.a("type", 10, new jf().h("work", 0).h("school", 1), false));
    }

    public f()
    {
      this.BR = 1;
      this.amc = new HashSet();
    }

    f(Set<Integer> paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, int paramInt2)
    {
      this.amc = paramSet;
      this.BR = paramInt1;
      this.anE = paramString1;
      this.Tr = paramString2;
      this.amz = paramString3;
      this.anF = paramString4;
      this.mName = paramString5;
      this.anG = paramBoolean;
      this.amP = paramString6;
      this.Nw = paramString7;
      this.FD = paramInt2;
    }

    protected boolean a(ji.a parama)
    {
      return this.amc.contains(Integer.valueOf(parama.hm()));
    }

    protected Object b(ji.a parama)
    {
      switch (parama.hm())
      {
      default:
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
      case 2:
        return this.anE;
      case 3:
        return this.Tr;
      case 4:
        return this.amz;
      case 5:
        return this.anF;
      case 6:
        return this.mName;
      case 7:
        return Boolean.valueOf(this.anG);
      case 8:
        return this.amP;
      case 9:
        return this.Nw;
      case 10:
      }
      return Integer.valueOf(this.FD);
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof f))
        return false;
      if (this == paramObject)
        return true;
      f localf = (f)paramObject;
      Iterator localIterator = amb.values().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
        if (a(locala))
        {
          if (localf.a(locala))
          {
            if (!b(locala).equals(localf.b(locala)))
              return false;
          }
          else
            return false;
        }
        else if (localf.a(locala))
          return false;
      }
      return true;
    }

    public String getDepartment()
    {
      return this.anE;
    }

    public String getDescription()
    {
      return this.Tr;
    }

    public String getEndDate()
    {
      return this.amz;
    }

    public String getLocation()
    {
      return this.anF;
    }

    public String getName()
    {
      return this.mName;
    }

    public String getStartDate()
    {
      return this.amP;
    }

    public String getTitle()
    {
      return this.Nw;
    }

    public int getType()
    {
      return this.FD;
    }

    public boolean hasDepartment()
    {
      return this.amc.contains(Integer.valueOf(2));
    }

    public boolean hasDescription()
    {
      return this.amc.contains(Integer.valueOf(3));
    }

    public boolean hasEndDate()
    {
      return this.amc.contains(Integer.valueOf(4));
    }

    public boolean hasLocation()
    {
      return this.amc.contains(Integer.valueOf(5));
    }

    public boolean hasName()
    {
      return this.amc.contains(Integer.valueOf(6));
    }

    public boolean hasPrimary()
    {
      return this.amc.contains(Integer.valueOf(7));
    }

    public boolean hasStartDate()
    {
      return this.amc.contains(Integer.valueOf(8));
    }

    public boolean hasTitle()
    {
      return this.amc.contains(Integer.valueOf(9));
    }

    public boolean hasType()
    {
      return this.amc.contains(Integer.valueOf(10));
    }

    public int hashCode()
    {
      Iterator localIterator = amb.values().iterator();
      int i = 0;
      ji.a locala;
      if (localIterator.hasNext())
      {
        locala = (ji.a)localIterator.next();
        if (!a(locala))
          break label66;
      }
      label66: for (int j = i + locala.hm() + b(locala).hashCode(); ; j = i)
      {
        i = j;
        break;
        return i;
      }
    }

    public HashMap<String, ji.a<?, ?>> hf()
    {
      return amb;
    }

    public boolean isDataValid()
    {
      return true;
    }

    public boolean isPrimary()
    {
      return this.anG;
    }

    public f nB()
    {
      return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      oh.a(this, paramParcel, paramInt);
    }
  }

  public static final class g extends jj
    implements Person.PlacesLived
  {
    public static final oi CREATOR = new oi();
    private static final HashMap<String, ji.a<?, ?>> amb = new HashMap();
    final int BR;
    final Set<Integer> amc;
    boolean anG;
    String mValue;

    static
    {
      amb.put("primary", ji.a.k("primary", 2));
      amb.put("value", ji.a.l("value", 3));
    }

    public g()
    {
      this.BR = 1;
      this.amc = new HashSet();
    }

    g(Set<Integer> paramSet, int paramInt, boolean paramBoolean, String paramString)
    {
      this.amc = paramSet;
      this.BR = paramInt;
      this.anG = paramBoolean;
      this.mValue = paramString;
    }

    protected boolean a(ji.a parama)
    {
      return this.amc.contains(Integer.valueOf(parama.hm()));
    }

    protected Object b(ji.a parama)
    {
      switch (parama.hm())
      {
      default:
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
      case 2:
        return Boolean.valueOf(this.anG);
      case 3:
      }
      return this.mValue;
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof g))
        return false;
      if (this == paramObject)
        return true;
      g localg = (g)paramObject;
      Iterator localIterator = amb.values().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
        if (a(locala))
        {
          if (localg.a(locala))
          {
            if (!b(locala).equals(localg.b(locala)))
              return false;
          }
          else
            return false;
        }
        else if (localg.a(locala))
          return false;
      }
      return true;
    }

    public String getValue()
    {
      return this.mValue;
    }

    public boolean hasPrimary()
    {
      return this.amc.contains(Integer.valueOf(2));
    }

    public boolean hasValue()
    {
      return this.amc.contains(Integer.valueOf(3));
    }

    public int hashCode()
    {
      Iterator localIterator = amb.values().iterator();
      int i = 0;
      ji.a locala;
      if (localIterator.hasNext())
      {
        locala = (ji.a)localIterator.next();
        if (!a(locala))
          break label66;
      }
      label66: for (int j = i + locala.hm() + b(locala).hashCode(); ; j = i)
      {
        i = j;
        break;
        return i;
      }
    }

    public HashMap<String, ji.a<?, ?>> hf()
    {
      return amb;
    }

    public boolean isDataValid()
    {
      return true;
    }

    public boolean isPrimary()
    {
      return this.anG;
    }

    public g nC()
    {
      return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      oi.a(this, paramParcel, paramInt);
    }
  }

  public static final class h extends jj
    implements Person.Urls
  {
    public static final oj CREATOR = new oj();
    private static final HashMap<String, ji.a<?, ?>> amb = new HashMap();
    final int BR;
    int FD;
    final Set<Integer> amc;
    String anH;
    private final int anI = 4;
    String mValue;

    static
    {
      amb.put("label", ji.a.l("label", 5));
      amb.put("type", ji.a.a("type", 6, new jf().h("home", 0).h("work", 1).h("blog", 2).h("profile", 3).h("other", 4).h("otherProfile", 5).h("contributor", 6).h("website", 7), false));
      amb.put("value", ji.a.l("value", 4));
    }

    public h()
    {
      this.BR = 1;
      this.amc = new HashSet();
    }

    h(Set<Integer> paramSet, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
    {
      this.amc = paramSet;
      this.BR = paramInt1;
      this.anH = paramString1;
      this.FD = paramInt2;
      this.mValue = paramString2;
    }

    protected boolean a(ji.a parama)
    {
      return this.amc.contains(Integer.valueOf(parama.hm()));
    }

    protected Object b(ji.a parama)
    {
      switch (parama.hm())
      {
      default:
        throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
      case 5:
        return this.anH;
      case 6:
        return Integer.valueOf(this.FD);
      case 4:
      }
      return this.mValue;
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof h))
        return false;
      if (this == paramObject)
        return true;
      h localh = (h)paramObject;
      Iterator localIterator = amb.values().iterator();
      while (localIterator.hasNext())
      {
        ji.a locala = (ji.a)localIterator.next();
        if (a(locala))
        {
          if (localh.a(locala))
          {
            if (!b(locala).equals(localh.b(locala)))
              return false;
          }
          else
            return false;
        }
        else if (localh.a(locala))
          return false;
      }
      return true;
    }

    public String getLabel()
    {
      return this.anH;
    }

    public int getType()
    {
      return this.FD;
    }

    public String getValue()
    {
      return this.mValue;
    }

    public boolean hasLabel()
    {
      return this.amc.contains(Integer.valueOf(5));
    }

    public boolean hasType()
    {
      return this.amc.contains(Integer.valueOf(6));
    }

    public boolean hasValue()
    {
      return this.amc.contains(Integer.valueOf(4));
    }

    public int hashCode()
    {
      Iterator localIterator = amb.values().iterator();
      int i = 0;
      ji.a locala;
      if (localIterator.hasNext())
      {
        locala = (ji.a)localIterator.next();
        if (!a(locala))
          break label66;
      }
      label66: for (int j = i + locala.hm() + b(locala).hashCode(); ; j = i)
      {
        i = j;
        break;
        return i;
      }
    }

    public HashMap<String, ji.a<?, ?>> hf()
    {
      return amb;
    }

    public boolean isDataValid()
    {
      return true;
    }

    @Deprecated
    public int nD()
    {
      return 4;
    }

    public h nE()
    {
      return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      oj.a(this, paramParcel, paramInt);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nz
 * JD-Core Version:    0.6.2
 */