package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class nu extends jj
  implements ItemScope
{
  public static final nv CREATOR = new nv();
  private static final HashMap<String, ji.a<?, ?>> amb = new HashMap();
  String BL;
  final int BR;
  String Tr;
  double aek;
  double ael;
  String amA;
  String amB;
  nu amC;
  String amD;
  String amE;
  String amF;
  nu amG;
  nu amH;
  nu amI;
  List<nu> amJ;
  String amK;
  String amL;
  String amM;
  String amN;
  nu amO;
  String amP;
  String amQ;
  String amR;
  nu amS;
  String amT;
  String amU;
  String amV;
  String amW;
  final Set<Integer> amc;
  nu amd;
  List<String> ame;
  nu amf;
  String amg;
  String amh;
  String ami;
  List<nu> amj;
  int amk;
  List<nu> aml;
  nu amm;
  List<nu> amn;
  String amo;
  String amp;
  nu amq;
  String amr;
  String ams;
  List<nu> amt;
  String amu;
  String amv;
  String amw;
  String amx;
  String amy;
  String amz;
  String mName;
  String ol;
  String uO;
  String uR;

  static
  {
    amb.put("about", ji.a.a("about", 2, nu.class));
    amb.put("additionalName", ji.a.m("additionalName", 3));
    amb.put("address", ji.a.a("address", 4, nu.class));
    amb.put("addressCountry", ji.a.l("addressCountry", 5));
    amb.put("addressLocality", ji.a.l("addressLocality", 6));
    amb.put("addressRegion", ji.a.l("addressRegion", 7));
    amb.put("associated_media", ji.a.b("associated_media", 8, nu.class));
    amb.put("attendeeCount", ji.a.i("attendeeCount", 9));
    amb.put("attendees", ji.a.b("attendees", 10, nu.class));
    amb.put("audio", ji.a.a("audio", 11, nu.class));
    amb.put("author", ji.a.b("author", 12, nu.class));
    amb.put("bestRating", ji.a.l("bestRating", 13));
    amb.put("birthDate", ji.a.l("birthDate", 14));
    amb.put("byArtist", ji.a.a("byArtist", 15, nu.class));
    amb.put("caption", ji.a.l("caption", 16));
    amb.put("contentSize", ji.a.l("contentSize", 17));
    amb.put("contentUrl", ji.a.l("contentUrl", 18));
    amb.put("contributor", ji.a.b("contributor", 19, nu.class));
    amb.put("dateCreated", ji.a.l("dateCreated", 20));
    amb.put("dateModified", ji.a.l("dateModified", 21));
    amb.put("datePublished", ji.a.l("datePublished", 22));
    amb.put("description", ji.a.l("description", 23));
    amb.put("duration", ji.a.l("duration", 24));
    amb.put("embedUrl", ji.a.l("embedUrl", 25));
    amb.put("endDate", ji.a.l("endDate", 26));
    amb.put("familyName", ji.a.l("familyName", 27));
    amb.put("gender", ji.a.l("gender", 28));
    amb.put("geo", ji.a.a("geo", 29, nu.class));
    amb.put("givenName", ji.a.l("givenName", 30));
    amb.put("height", ji.a.l("height", 31));
    amb.put("id", ji.a.l("id", 32));
    amb.put("image", ji.a.l("image", 33));
    amb.put("inAlbum", ji.a.a("inAlbum", 34, nu.class));
    amb.put("latitude", ji.a.j("latitude", 36));
    amb.put("location", ji.a.a("location", 37, nu.class));
    amb.put("longitude", ji.a.j("longitude", 38));
    amb.put("name", ji.a.l("name", 39));
    amb.put("partOfTVSeries", ji.a.a("partOfTVSeries", 40, nu.class));
    amb.put("performers", ji.a.b("performers", 41, nu.class));
    amb.put("playerType", ji.a.l("playerType", 42));
    amb.put("postOfficeBoxNumber", ji.a.l("postOfficeBoxNumber", 43));
    amb.put("postalCode", ji.a.l("postalCode", 44));
    amb.put("ratingValue", ji.a.l("ratingValue", 45));
    amb.put("reviewRating", ji.a.a("reviewRating", 46, nu.class));
    amb.put("startDate", ji.a.l("startDate", 47));
    amb.put("streetAddress", ji.a.l("streetAddress", 48));
    amb.put("text", ji.a.l("text", 49));
    amb.put("thumbnail", ji.a.a("thumbnail", 50, nu.class));
    amb.put("thumbnailUrl", ji.a.l("thumbnailUrl", 51));
    amb.put("tickerSymbol", ji.a.l("tickerSymbol", 52));
    amb.put("type", ji.a.l("type", 53));
    amb.put("url", ji.a.l("url", 54));
    amb.put("width", ji.a.l("width", 55));
    amb.put("worstRating", ji.a.l("worstRating", 56));
  }

  public nu()
  {
    this.BR = 1;
    this.amc = new HashSet();
  }

  nu(Set<Integer> paramSet, int paramInt1, nu paramnu1, List<String> paramList, nu paramnu2, String paramString1, String paramString2, String paramString3, List<nu> paramList1, int paramInt2, List<nu> paramList2, nu paramnu3, List<nu> paramList3, String paramString4, String paramString5, nu paramnu4, String paramString6, String paramString7, String paramString8, List<nu> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, nu paramnu5, String paramString18, String paramString19, String paramString20, String paramString21, nu paramnu6, double paramDouble1, nu paramnu7, double paramDouble2, String paramString22, nu paramnu8, List<nu> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, nu paramnu9, String paramString27, String paramString28, String paramString29, nu paramnu10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.amc = paramSet;
    this.BR = paramInt1;
    this.amd = paramnu1;
    this.ame = paramList;
    this.amf = paramnu2;
    this.amg = paramString1;
    this.amh = paramString2;
    this.ami = paramString3;
    this.amj = paramList1;
    this.amk = paramInt2;
    this.aml = paramList2;
    this.amm = paramnu3;
    this.amn = paramList3;
    this.amo = paramString4;
    this.amp = paramString5;
    this.amq = paramnu4;
    this.amr = paramString6;
    this.ams = paramString7;
    this.ol = paramString8;
    this.amt = paramList4;
    this.amu = paramString9;
    this.amv = paramString10;
    this.amw = paramString11;
    this.Tr = paramString12;
    this.amx = paramString13;
    this.amy = paramString14;
    this.amz = paramString15;
    this.amA = paramString16;
    this.amB = paramString17;
    this.amC = paramnu5;
    this.amD = paramString18;
    this.amE = paramString19;
    this.BL = paramString20;
    this.amF = paramString21;
    this.amG = paramnu6;
    this.aek = paramDouble1;
    this.amH = paramnu7;
    this.ael = paramDouble2;
    this.mName = paramString22;
    this.amI = paramnu8;
    this.amJ = paramList5;
    this.amK = paramString23;
    this.amL = paramString24;
    this.amM = paramString25;
    this.amN = paramString26;
    this.amO = paramnu9;
    this.amP = paramString27;
    this.amQ = paramString28;
    this.amR = paramString29;
    this.amS = paramnu10;
    this.amT = paramString30;
    this.amU = paramString31;
    this.uO = paramString32;
    this.uR = paramString33;
    this.amV = paramString34;
    this.amW = paramString35;
  }

  public nu(Set<Integer> paramSet, nu paramnu1, List<String> paramList, nu paramnu2, String paramString1, String paramString2, String paramString3, List<nu> paramList1, int paramInt, List<nu> paramList2, nu paramnu3, List<nu> paramList3, String paramString4, String paramString5, nu paramnu4, String paramString6, String paramString7, String paramString8, List<nu> paramList4, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17, nu paramnu5, String paramString18, String paramString19, String paramString20, String paramString21, nu paramnu6, double paramDouble1, nu paramnu7, double paramDouble2, String paramString22, nu paramnu8, List<nu> paramList5, String paramString23, String paramString24, String paramString25, String paramString26, nu paramnu9, String paramString27, String paramString28, String paramString29, nu paramnu10, String paramString30, String paramString31, String paramString32, String paramString33, String paramString34, String paramString35)
  {
    this.amc = paramSet;
    this.BR = 1;
    this.amd = paramnu1;
    this.ame = paramList;
    this.amf = paramnu2;
    this.amg = paramString1;
    this.amh = paramString2;
    this.ami = paramString3;
    this.amj = paramList1;
    this.amk = paramInt;
    this.aml = paramList2;
    this.amm = paramnu3;
    this.amn = paramList3;
    this.amo = paramString4;
    this.amp = paramString5;
    this.amq = paramnu4;
    this.amr = paramString6;
    this.ams = paramString7;
    this.ol = paramString8;
    this.amt = paramList4;
    this.amu = paramString9;
    this.amv = paramString10;
    this.amw = paramString11;
    this.Tr = paramString12;
    this.amx = paramString13;
    this.amy = paramString14;
    this.amz = paramString15;
    this.amA = paramString16;
    this.amB = paramString17;
    this.amC = paramnu5;
    this.amD = paramString18;
    this.amE = paramString19;
    this.BL = paramString20;
    this.amF = paramString21;
    this.amG = paramnu6;
    this.aek = paramDouble1;
    this.amH = paramnu7;
    this.ael = paramDouble2;
    this.mName = paramString22;
    this.amI = paramnu8;
    this.amJ = paramList5;
    this.amK = paramString23;
    this.amL = paramString24;
    this.amM = paramString25;
    this.amN = paramString26;
    this.amO = paramnu9;
    this.amP = paramString27;
    this.amQ = paramString28;
    this.amR = paramString29;
    this.amS = paramnu10;
    this.amT = paramString30;
    this.amU = paramString31;
    this.uO = paramString32;
    this.uR = paramString33;
    this.amV = paramString34;
    this.amW = paramString35;
  }

  protected boolean a(ji.a parama)
  {
    return this.amc.contains(Integer.valueOf(parama.hm()));
  }

  protected Object b(ji.a parama)
  {
    switch (parama.hm())
    {
    case 35:
    default:
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.hm());
    case 2:
      return this.amd;
    case 3:
      return this.ame;
    case 4:
      return this.amf;
    case 5:
      return this.amg;
    case 6:
      return this.amh;
    case 7:
      return this.ami;
    case 8:
      return this.amj;
    case 9:
      return Integer.valueOf(this.amk);
    case 10:
      return this.aml;
    case 11:
      return this.amm;
    case 12:
      return this.amn;
    case 13:
      return this.amo;
    case 14:
      return this.amp;
    case 15:
      return this.amq;
    case 16:
      return this.amr;
    case 17:
      return this.ams;
    case 18:
      return this.ol;
    case 19:
      return this.amt;
    case 20:
      return this.amu;
    case 21:
      return this.amv;
    case 22:
      return this.amw;
    case 23:
      return this.Tr;
    case 24:
      return this.amx;
    case 25:
      return this.amy;
    case 26:
      return this.amz;
    case 27:
      return this.amA;
    case 28:
      return this.amB;
    case 29:
      return this.amC;
    case 30:
      return this.amD;
    case 31:
      return this.amE;
    case 32:
      return this.BL;
    case 33:
      return this.amF;
    case 34:
      return this.amG;
    case 36:
      return Double.valueOf(this.aek);
    case 37:
      return this.amH;
    case 38:
      return Double.valueOf(this.ael);
    case 39:
      return this.mName;
    case 40:
      return this.amI;
    case 41:
      return this.amJ;
    case 42:
      return this.amK;
    case 43:
      return this.amL;
    case 44:
      return this.amM;
    case 45:
      return this.amN;
    case 46:
      return this.amO;
    case 47:
      return this.amP;
    case 48:
      return this.amQ;
    case 49:
      return this.amR;
    case 50:
      return this.amS;
    case 51:
      return this.amT;
    case 52:
      return this.amU;
    case 53:
      return this.uO;
    case 54:
      return this.uR;
    case 55:
      return this.amV;
    case 56:
    }
    return this.amW;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof nu))
      return false;
    if (this == paramObject)
      return true;
    nu localnu = (nu)paramObject;
    Iterator localIterator = amb.values().iterator();
    while (localIterator.hasNext())
    {
      ji.a locala = (ji.a)localIterator.next();
      if (a(locala))
      {
        if (localnu.a(locala))
        {
          if (!b(locala).equals(localnu.b(locala)))
            return false;
        }
        else
          return false;
      }
      else if (localnu.a(locala))
        return false;
    }
    return true;
  }

  public ItemScope getAbout()
  {
    return this.amd;
  }

  public List<String> getAdditionalName()
  {
    return this.ame;
  }

  public ItemScope getAddress()
  {
    return this.amf;
  }

  public String getAddressCountry()
  {
    return this.amg;
  }

  public String getAddressLocality()
  {
    return this.amh;
  }

  public String getAddressRegion()
  {
    return this.ami;
  }

  public List<ItemScope> getAssociated_media()
  {
    return (ArrayList)this.amj;
  }

  public int getAttendeeCount()
  {
    return this.amk;
  }

  public List<ItemScope> getAttendees()
  {
    return (ArrayList)this.aml;
  }

  public ItemScope getAudio()
  {
    return this.amm;
  }

  public List<ItemScope> getAuthor()
  {
    return (ArrayList)this.amn;
  }

  public String getBestRating()
  {
    return this.amo;
  }

  public String getBirthDate()
  {
    return this.amp;
  }

  public ItemScope getByArtist()
  {
    return this.amq;
  }

  public String getCaption()
  {
    return this.amr;
  }

  public String getContentSize()
  {
    return this.ams;
  }

  public String getContentUrl()
  {
    return this.ol;
  }

  public List<ItemScope> getContributor()
  {
    return (ArrayList)this.amt;
  }

  public String getDateCreated()
  {
    return this.amu;
  }

  public String getDateModified()
  {
    return this.amv;
  }

  public String getDatePublished()
  {
    return this.amw;
  }

  public String getDescription()
  {
    return this.Tr;
  }

  public String getDuration()
  {
    return this.amx;
  }

  public String getEmbedUrl()
  {
    return this.amy;
  }

  public String getEndDate()
  {
    return this.amz;
  }

  public String getFamilyName()
  {
    return this.amA;
  }

  public String getGender()
  {
    return this.amB;
  }

  public ItemScope getGeo()
  {
    return this.amC;
  }

  public String getGivenName()
  {
    return this.amD;
  }

  public String getHeight()
  {
    return this.amE;
  }

  public String getId()
  {
    return this.BL;
  }

  public String getImage()
  {
    return this.amF;
  }

  public ItemScope getInAlbum()
  {
    return this.amG;
  }

  public double getLatitude()
  {
    return this.aek;
  }

  public ItemScope getLocation()
  {
    return this.amH;
  }

  public double getLongitude()
  {
    return this.ael;
  }

  public String getName()
  {
    return this.mName;
  }

  public ItemScope getPartOfTVSeries()
  {
    return this.amI;
  }

  public List<ItemScope> getPerformers()
  {
    return (ArrayList)this.amJ;
  }

  public String getPlayerType()
  {
    return this.amK;
  }

  public String getPostOfficeBoxNumber()
  {
    return this.amL;
  }

  public String getPostalCode()
  {
    return this.amM;
  }

  public String getRatingValue()
  {
    return this.amN;
  }

  public ItemScope getReviewRating()
  {
    return this.amO;
  }

  public String getStartDate()
  {
    return this.amP;
  }

  public String getStreetAddress()
  {
    return this.amQ;
  }

  public String getText()
  {
    return this.amR;
  }

  public ItemScope getThumbnail()
  {
    return this.amS;
  }

  public String getThumbnailUrl()
  {
    return this.amT;
  }

  public String getTickerSymbol()
  {
    return this.amU;
  }

  public String getType()
  {
    return this.uO;
  }

  public String getUrl()
  {
    return this.uR;
  }

  public String getWidth()
  {
    return this.amV;
  }

  public String getWorstRating()
  {
    return this.amW;
  }

  public boolean hasAbout()
  {
    return this.amc.contains(Integer.valueOf(2));
  }

  public boolean hasAdditionalName()
  {
    return this.amc.contains(Integer.valueOf(3));
  }

  public boolean hasAddress()
  {
    return this.amc.contains(Integer.valueOf(4));
  }

  public boolean hasAddressCountry()
  {
    return this.amc.contains(Integer.valueOf(5));
  }

  public boolean hasAddressLocality()
  {
    return this.amc.contains(Integer.valueOf(6));
  }

  public boolean hasAddressRegion()
  {
    return this.amc.contains(Integer.valueOf(7));
  }

  public boolean hasAssociated_media()
  {
    return this.amc.contains(Integer.valueOf(8));
  }

  public boolean hasAttendeeCount()
  {
    return this.amc.contains(Integer.valueOf(9));
  }

  public boolean hasAttendees()
  {
    return this.amc.contains(Integer.valueOf(10));
  }

  public boolean hasAudio()
  {
    return this.amc.contains(Integer.valueOf(11));
  }

  public boolean hasAuthor()
  {
    return this.amc.contains(Integer.valueOf(12));
  }

  public boolean hasBestRating()
  {
    return this.amc.contains(Integer.valueOf(13));
  }

  public boolean hasBirthDate()
  {
    return this.amc.contains(Integer.valueOf(14));
  }

  public boolean hasByArtist()
  {
    return this.amc.contains(Integer.valueOf(15));
  }

  public boolean hasCaption()
  {
    return this.amc.contains(Integer.valueOf(16));
  }

  public boolean hasContentSize()
  {
    return this.amc.contains(Integer.valueOf(17));
  }

  public boolean hasContentUrl()
  {
    return this.amc.contains(Integer.valueOf(18));
  }

  public boolean hasContributor()
  {
    return this.amc.contains(Integer.valueOf(19));
  }

  public boolean hasDateCreated()
  {
    return this.amc.contains(Integer.valueOf(20));
  }

  public boolean hasDateModified()
  {
    return this.amc.contains(Integer.valueOf(21));
  }

  public boolean hasDatePublished()
  {
    return this.amc.contains(Integer.valueOf(22));
  }

  public boolean hasDescription()
  {
    return this.amc.contains(Integer.valueOf(23));
  }

  public boolean hasDuration()
  {
    return this.amc.contains(Integer.valueOf(24));
  }

  public boolean hasEmbedUrl()
  {
    return this.amc.contains(Integer.valueOf(25));
  }

  public boolean hasEndDate()
  {
    return this.amc.contains(Integer.valueOf(26));
  }

  public boolean hasFamilyName()
  {
    return this.amc.contains(Integer.valueOf(27));
  }

  public boolean hasGender()
  {
    return this.amc.contains(Integer.valueOf(28));
  }

  public boolean hasGeo()
  {
    return this.amc.contains(Integer.valueOf(29));
  }

  public boolean hasGivenName()
  {
    return this.amc.contains(Integer.valueOf(30));
  }

  public boolean hasHeight()
  {
    return this.amc.contains(Integer.valueOf(31));
  }

  public boolean hasId()
  {
    return this.amc.contains(Integer.valueOf(32));
  }

  public boolean hasImage()
  {
    return this.amc.contains(Integer.valueOf(33));
  }

  public boolean hasInAlbum()
  {
    return this.amc.contains(Integer.valueOf(34));
  }

  public boolean hasLatitude()
  {
    return this.amc.contains(Integer.valueOf(36));
  }

  public boolean hasLocation()
  {
    return this.amc.contains(Integer.valueOf(37));
  }

  public boolean hasLongitude()
  {
    return this.amc.contains(Integer.valueOf(38));
  }

  public boolean hasName()
  {
    return this.amc.contains(Integer.valueOf(39));
  }

  public boolean hasPartOfTVSeries()
  {
    return this.amc.contains(Integer.valueOf(40));
  }

  public boolean hasPerformers()
  {
    return this.amc.contains(Integer.valueOf(41));
  }

  public boolean hasPlayerType()
  {
    return this.amc.contains(Integer.valueOf(42));
  }

  public boolean hasPostOfficeBoxNumber()
  {
    return this.amc.contains(Integer.valueOf(43));
  }

  public boolean hasPostalCode()
  {
    return this.amc.contains(Integer.valueOf(44));
  }

  public boolean hasRatingValue()
  {
    return this.amc.contains(Integer.valueOf(45));
  }

  public boolean hasReviewRating()
  {
    return this.amc.contains(Integer.valueOf(46));
  }

  public boolean hasStartDate()
  {
    return this.amc.contains(Integer.valueOf(47));
  }

  public boolean hasStreetAddress()
  {
    return this.amc.contains(Integer.valueOf(48));
  }

  public boolean hasText()
  {
    return this.amc.contains(Integer.valueOf(49));
  }

  public boolean hasThumbnail()
  {
    return this.amc.contains(Integer.valueOf(50));
  }

  public boolean hasThumbnailUrl()
  {
    return this.amc.contains(Integer.valueOf(51));
  }

  public boolean hasTickerSymbol()
  {
    return this.amc.contains(Integer.valueOf(52));
  }

  public boolean hasType()
  {
    return this.amc.contains(Integer.valueOf(53));
  }

  public boolean hasUrl()
  {
    return this.amc.contains(Integer.valueOf(54));
  }

  public boolean hasWidth()
  {
    return this.amc.contains(Integer.valueOf(55));
  }

  public boolean hasWorstRating()
  {
    return this.amc.contains(Integer.valueOf(56));
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

  public nu nr()
  {
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nv.a(this, paramParcel, paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nu
 * JD-Core Version:    0.6.2
 */