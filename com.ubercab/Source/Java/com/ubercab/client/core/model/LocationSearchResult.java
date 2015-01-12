package com.ubercab.client.core.model;

import android.text.TextUtils;
import com.ubercab.library.location.model.UberLatLng;

public class LocationSearchResult
{
  public static final String[] HOME_WORK_TAGS = { "home", "work" };
  public static final String TAG_HOME = "home";
  public static final String TAG_WORK = "work";
  String formattedAddress;

  @Deprecated
  String formatted_address;
  String hash;
  String id;
  Double latitude;
  String longAddress;

  @Deprecated
  String long_address;
  Double longitude;
  String nickname;
  String reference;
  String relevance;
  String serviceType;

  @Deprecated
  String service_type;
  String shortAddress;

  @Deprecated
  String short_address;
  String sourceType;

  @Deprecated
  String source_type;
  String subtitle;
  String tag;
  String title;
  String type;

  public static boolean isTagHome(String paramString)
  {
    return "home".equals(paramString);
  }

  public static boolean isTagWork(String paramString)
  {
    return "work".equals(paramString);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    LocationSearchResult localLocationSearchResult;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localLocationSearchResult = (LocationSearchResult)paramObject;
      if (this.formattedAddress != null)
      {
        if (this.formattedAddress.equals(localLocationSearchResult.formattedAddress));
      }
      else
        while (localLocationSearchResult.formattedAddress != null)
          return false;
      if (this.formatted_address != null)
      {
        if (this.formatted_address.equals(localLocationSearchResult.formatted_address));
      }
      else
        while (localLocationSearchResult.formatted_address != null)
          return false;
      if (this.hash != null)
      {
        if (this.hash.equals(localLocationSearchResult.hash));
      }
      else
        while (localLocationSearchResult.hash != null)
          return false;
      if (this.id != null)
      {
        if (this.id.equals(localLocationSearchResult.id));
      }
      else
        while (localLocationSearchResult.id != null)
          return false;
      if (this.latitude != null)
      {
        if (this.latitude.equals(localLocationSearchResult.latitude));
      }
      else
        while (localLocationSearchResult.latitude != null)
          return false;
      if (this.longAddress != null)
      {
        if (this.longAddress.equals(localLocationSearchResult.longAddress));
      }
      else
        while (localLocationSearchResult.longAddress != null)
          return false;
      if (this.long_address != null)
      {
        if (this.long_address.equals(localLocationSearchResult.long_address));
      }
      else
        while (localLocationSearchResult.long_address != null)
          return false;
      if (this.longitude != null)
      {
        if (this.longitude.equals(localLocationSearchResult.longitude));
      }
      else
        while (localLocationSearchResult.longitude != null)
          return false;
      if (this.nickname != null)
      {
        if (this.nickname.equals(localLocationSearchResult.nickname));
      }
      else
        while (localLocationSearchResult.nickname != null)
          return false;
      if (this.reference != null)
      {
        if (this.reference.equals(localLocationSearchResult.reference));
      }
      else
        while (localLocationSearchResult.reference != null)
          return false;
      if (this.relevance != null)
      {
        if (this.relevance.equals(localLocationSearchResult.relevance));
      }
      else
        while (localLocationSearchResult.relevance != null)
          return false;
      if (this.serviceType != null)
      {
        if (this.serviceType.equals(localLocationSearchResult.serviceType));
      }
      else
        while (localLocationSearchResult.serviceType != null)
          return false;
      if (this.service_type != null)
      {
        if (this.service_type.equals(localLocationSearchResult.service_type));
      }
      else
        while (localLocationSearchResult.service_type != null)
          return false;
      if (this.shortAddress != null)
      {
        if (this.shortAddress.equals(localLocationSearchResult.shortAddress));
      }
      else
        while (localLocationSearchResult.shortAddress != null)
          return false;
      if (this.short_address != null)
      {
        if (this.short_address.equals(localLocationSearchResult.short_address));
      }
      else
        while (localLocationSearchResult.short_address != null)
          return false;
      if (this.sourceType != null)
      {
        if (this.sourceType.equals(localLocationSearchResult.sourceType));
      }
      else
        while (localLocationSearchResult.sourceType != null)
          return false;
      if (this.source_type != null)
      {
        if (this.source_type.equals(localLocationSearchResult.source_type));
      }
      else
        while (localLocationSearchResult.source_type != null)
          return false;
      if (this.subtitle != null)
      {
        if (this.subtitle.equals(localLocationSearchResult.subtitle));
      }
      else
        while (localLocationSearchResult.subtitle != null)
          return false;
      if (this.tag != null)
      {
        if (this.tag.equals(localLocationSearchResult.tag));
      }
      else
        while (localLocationSearchResult.tag != null)
          return false;
      if (this.title != null)
      {
        if (this.title.equals(localLocationSearchResult.title));
      }
      else
        while (localLocationSearchResult.title != null)
          return false;
      if (this.type == null)
        break;
    }
    while (this.type.equals(localLocationSearchResult.type));
    while (true)
    {
      return false;
      if (localLocationSearchResult.type == null)
        break;
    }
  }

  public String getFormattedAddress()
  {
    if (!TextUtils.isEmpty(this.formattedAddress))
      return this.formattedAddress;
    return this.formatted_address;
  }

  public String getHash()
  {
    return this.hash;
  }

  public String getId()
  {
    return this.id;
  }

  public Double getLatitude()
  {
    return this.latitude;
  }

  public String getLongAddress()
  {
    if (!TextUtils.isEmpty(this.longAddress))
      return this.longAddress;
    return this.long_address;
  }

  public Double getLongitude()
  {
    return this.longitude;
  }

  public String getNickname()
  {
    return this.nickname;
  }

  public String getReference()
  {
    return this.reference;
  }

  public String getRelevance()
  {
    return this.relevance;
  }

  public String getServiceType()
  {
    if (!TextUtils.isEmpty(this.serviceType))
      return this.serviceType;
    return this.service_type;
  }

  public String getShortAddress()
  {
    if (!TextUtils.isEmpty(this.shortAddress))
      return this.shortAddress;
    return this.short_address;
  }

  public String getSourceType()
  {
    if (!TextUtils.isEmpty(this.sourceType))
      return this.sourceType;
    return this.source_type;
  }

  public String getSubtitle()
  {
    return this.subtitle;
  }

  public String getTag()
  {
    return this.tag;
  }

  public String getTitle()
  {
    return this.title;
  }

  public String getType()
  {
    return this.type;
  }

  public UberLatLng getUberLatLng()
  {
    if ((this.latitude == null) || (this.longitude == null))
      return null;
    return new UberLatLng(this.latitude.doubleValue(), this.longitude.doubleValue());
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label85: int i4;
    label111: int i6;
    label137: int i8;
    label163: int i10;
    label189: int i12;
    label215: int i14;
    label241: int i16;
    label267: int i18;
    label293: int i20;
    label319: int i22;
    label345: int i24;
    label371: int i26;
    label397: int i28;
    label423: int i30;
    label449: int i32;
    label475: int i33;
    if (this.latitude != null)
    {
      i = this.latitude.hashCode();
      int j = i * 31;
      if (this.longitude == null)
        break label545;
      k = this.longitude.hashCode();
      int m = 31 * (j + k);
      if (this.formatted_address == null)
        break label550;
      n = this.formatted_address.hashCode();
      int i1 = 31 * (m + n);
      if (this.long_address == null)
        break label556;
      i2 = this.long_address.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.service_type == null)
        break label562;
      i4 = this.service_type.hashCode();
      int i5 = 31 * (i3 + i4);
      if (this.source_type == null)
        break label568;
      i6 = this.source_type.hashCode();
      int i7 = 31 * (i5 + i6);
      if (this.short_address == null)
        break label574;
      i8 = this.short_address.hashCode();
      int i9 = 31 * (i7 + i8);
      if (this.formattedAddress == null)
        break label580;
      i10 = this.formattedAddress.hashCode();
      int i11 = 31 * (i9 + i10);
      if (this.hash == null)
        break label586;
      i12 = this.hash.hashCode();
      int i13 = 31 * (i11 + i12);
      if (this.id == null)
        break label592;
      i14 = this.id.hashCode();
      int i15 = 31 * (i13 + i14);
      if (this.longAddress == null)
        break label598;
      i16 = this.longAddress.hashCode();
      int i17 = 31 * (i15 + i16);
      if (this.nickname == null)
        break label604;
      i18 = this.nickname.hashCode();
      int i19 = 31 * (i17 + i18);
      if (this.reference == null)
        break label610;
      i20 = this.reference.hashCode();
      int i21 = 31 * (i19 + i20);
      if (this.relevance == null)
        break label616;
      i22 = this.relevance.hashCode();
      int i23 = 31 * (i21 + i22);
      if (this.serviceType == null)
        break label622;
      i24 = this.serviceType.hashCode();
      int i25 = 31 * (i23 + i24);
      if (this.shortAddress == null)
        break label628;
      i26 = this.shortAddress.hashCode();
      int i27 = 31 * (i25 + i26);
      if (this.sourceType == null)
        break label634;
      i28 = this.sourceType.hashCode();
      int i29 = 31 * (i27 + i28);
      if (this.subtitle == null)
        break label640;
      i30 = this.subtitle.hashCode();
      int i31 = 31 * (i29 + i30);
      if (this.tag == null)
        break label646;
      i32 = this.tag.hashCode();
      i33 = 31 * (i31 + i32);
      if (this.title == null)
        break label652;
    }
    label640: label646: label652: for (int i34 = this.title.hashCode(); ; i34 = 0)
    {
      int i35 = 31 * (i33 + i34);
      String str = this.type;
      int i36 = 0;
      if (str != null)
        i36 = this.type.hashCode();
      return i35 + i36;
      i = 0;
      break;
      label545: k = 0;
      break label35;
      label550: n = 0;
      break label59;
      label556: i2 = 0;
      break label85;
      label562: i4 = 0;
      break label111;
      label568: i6 = 0;
      break label137;
      label574: i8 = 0;
      break label163;
      label580: i10 = 0;
      break label189;
      label586: i12 = 0;
      break label215;
      label592: i14 = 0;
      break label241;
      label598: i16 = 0;
      break label267;
      label604: i18 = 0;
      break label293;
      label610: i20 = 0;
      break label319;
      label616: i22 = 0;
      break label345;
      label622: i24 = 0;
      break label371;
      label628: i26 = 0;
      break label397;
      label634: i28 = 0;
      break label423;
      i30 = 0;
      break label449;
      i32 = 0;
      break label475;
    }
  }

  public boolean isDuplicate(LocationSearchResult paramLocationSearchResult)
  {
    if ((!TextUtils.isEmpty(getHash())) && (getHash().equals(paramLocationSearchResult.getHash())));
    while ((!TextUtils.isEmpty(getReference())) && (getReference().equals(paramLocationSearchResult.getReference())))
      return true;
    return false;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }

  public void setUberLatLng(UberLatLng paramUberLatLng)
  {
    this.latitude = Double.valueOf(paramUberLatLng.getLatitude());
    this.longitude = Double.valueOf(paramUberLatLng.getLongitude());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.LocationSearchResult
 * JD-Core Version:    0.6.2
 */