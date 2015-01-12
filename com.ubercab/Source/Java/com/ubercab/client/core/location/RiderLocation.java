package com.ubercab.client.core.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.ubercab.client.core.model.AddressComponent;
import com.ubercab.client.core.model.CnLocation;
import com.ubercab.client.core.model.LocationSearchResult;
import com.ubercab.client.core.model.ReverseGeocode;
import com.ubercab.common.base.Optional;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.Iterators;
import com.ubercab.library.location.model.UberLatLng;
import com.ubercab.library.location.model.UberLocation;
import com.ubercab.library.location.model.UberLocation.Builder;
import java.util.ArrayList;
import java.util.List;

public class RiderLocation extends UberLocation
{
  public static final Parcelable.Creator<RiderLocation> CREATOR = new Parcelable.Creator()
  {
    public RiderLocation createFromParcel(Parcel paramAnonymousParcel)
    {
      return new RiderLocation(paramAnonymousParcel);
    }

    public RiderLocation[] newArray(int paramAnonymousInt)
    {
      return new RiderLocation[paramAnonymousInt];
    }
  };
  public static final String TYPE_BACKFILL = "backfill";
  public static final String TYPE_CACHE = "cache";
  public static final String TYPE_DEVICE = "device";
  public static final String TYPE_EXTERNAL = "external";
  public static final String TYPE_GEOCOD_MANUAL = "geocodmanual";
  public static final String TYPE_GOOGLE = "google";
  public static final String TYPE_MANUAL = "manual";
  private String mAddress;
  private long mDistance;
  private String mFormattedAddress;
  private String mId;
  private List<AddressComponent> mListAddressComponents;
  private String mLongAddress;
  private String mNickname;
  private String mReference;
  private String mReferenceType;
  private String mRelevance;
  private String mShortAddress;
  private String mSubtitle;
  private String mTitle;
  private String mType;

  public RiderLocation(Parcel paramParcel)
  {
    super(paramParcel);
    this.mDistance = paramParcel.readLong();
    this.mId = paramParcel.readString();
    this.mType = paramParcel.readString();
    this.mTitle = paramParcel.readString();
    this.mSubtitle = paramParcel.readString();
    this.mNickname = paramParcel.readString();
    this.mAddress = paramParcel.readString();
    this.mRelevance = paramParcel.readString();
    this.mReference = paramParcel.readString();
    this.mLongAddress = paramParcel.readString();
    this.mShortAddress = paramParcel.readString();
    this.mReferenceType = paramParcel.readString();
    this.mFormattedAddress = paramParcel.readString();
    this.mListAddressComponents = new ArrayList();
    paramParcel.readList(this.mListAddressComponents, AddressComponent.class.getClassLoader());
  }

  private RiderLocation(String paramString, double paramDouble1, double paramDouble2)
  {
    this(paramString, new UberLocation.Builder(new UberLatLng(paramDouble1, paramDouble2)).build());
  }

  private RiderLocation(String paramString, UberLocation paramUberLocation)
  {
    super(paramUberLocation.getAccuracy(), paramUberLocation.getAltitude(), paramUberLocation.getBearing(), paramUberLocation.getSpeed(), paramUberLocation.getTime(), paramUberLocation.getUberLatLng());
    this.mType = paramString;
  }

  public static RiderLocation create(CnLocation paramCnLocation)
  {
    RiderLocation localRiderLocation = new RiderLocation(paramCnLocation.getType(), paramCnLocation.getLatitude(), paramCnLocation.getLongitude());
    localRiderLocation.mDistance = paramCnLocation.getDistance();
    localRiderLocation.mId = paramCnLocation.getId();
    localRiderLocation.mNickname = paramCnLocation.getNickname();
    localRiderLocation.mAddress = paramCnLocation.getAddress();
    localRiderLocation.mFormattedAddress = paramCnLocation.getFormattedAddress();
    localRiderLocation.mListAddressComponents = paramCnLocation.getAddressComponents();
    return localRiderLocation;
  }

  public static RiderLocation create(LocationSearchResult paramLocationSearchResult)
  {
    double d1;
    if (paramLocationSearchResult.getLatitude() == null)
    {
      d1 = 0.0D;
      if (paramLocationSearchResult.getLongitude() != null)
        break label53;
    }
    label53: for (double d2 = 0.0D; ; d2 = paramLocationSearchResult.getLongitude().doubleValue())
    {
      RiderLocation localRiderLocation = new RiderLocation(paramLocationSearchResult.getServiceType(), d1, d2);
      localRiderLocation.update(paramLocationSearchResult);
      return localRiderLocation;
      d1 = paramLocationSearchResult.getLatitude().doubleValue();
      break;
    }
  }

  public static RiderLocation create(ReverseGeocode paramReverseGeocode)
  {
    RiderLocation localRiderLocation = new RiderLocation("geocodmanual", paramReverseGeocode.getLatitude(), paramReverseGeocode.getLongitude());
    localRiderLocation.mId = paramReverseGeocode.getId();
    localRiderLocation.mNickname = paramReverseGeocode.getNickname();
    localRiderLocation.mShortAddress = paramReverseGeocode.getShortName();
    localRiderLocation.mLongAddress = paramReverseGeocode.getLongName();
    return localRiderLocation;
  }

  public static RiderLocation create(UberLatLng paramUberLatLng)
  {
    return new RiderLocation("manual", paramUberLatLng.getLatitude(), paramUberLatLng.getLongitude());
  }

  public static RiderLocation create(UberLatLng paramUberLatLng, List<AddressComponent> paramList, String paramString1, String paramString2)
  {
    RiderLocation localRiderLocation = new RiderLocation("external", paramUberLatLng.getLatitude(), paramUberLatLng.getLongitude());
    localRiderLocation.mListAddressComponents = paramList;
    localRiderLocation.mFormattedAddress = paramString1;
    localRiderLocation.mNickname = paramString2;
    return localRiderLocation;
  }

  public static RiderLocation create(UberLocation paramUberLocation)
  {
    return new RiderLocation("device", paramUberLocation);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    RiderLocation localRiderLocation;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      if (!super.equals(paramObject))
        return false;
      localRiderLocation = (RiderLocation)paramObject;
      if (this.mDistance != localRiderLocation.mDistance)
        return false;
      if (this.mAddress != null)
      {
        if (this.mAddress.equals(localRiderLocation.mAddress));
      }
      else
        while (localRiderLocation.mAddress != null)
          return false;
      if (this.mFormattedAddress != null)
      {
        if (this.mFormattedAddress.equals(localRiderLocation.mFormattedAddress));
      }
      else
        while (localRiderLocation.mFormattedAddress != null)
          return false;
      if (this.mId != null)
      {
        if (this.mId.equals(localRiderLocation.mId));
      }
      else
        while (localRiderLocation.mId != null)
          return false;
      if (this.mListAddressComponents != null)
      {
        if (this.mListAddressComponents.equals(localRiderLocation.mListAddressComponents));
      }
      else
        while (localRiderLocation.mListAddressComponents != null)
          return false;
      if (this.mLongAddress != null)
      {
        if (this.mLongAddress.equals(localRiderLocation.mLongAddress));
      }
      else
        while (localRiderLocation.mLongAddress != null)
          return false;
      if (this.mNickname != null)
      {
        if (this.mNickname.equals(localRiderLocation.mNickname));
      }
      else
        while (localRiderLocation.mNickname != null)
          return false;
      if (this.mReference != null)
      {
        if (this.mReference.equals(localRiderLocation.mReference));
      }
      else
        while (localRiderLocation.mReference != null)
          return false;
      if (this.mReferenceType != null)
      {
        if (this.mReferenceType.equals(localRiderLocation.mReferenceType));
      }
      else
        while (localRiderLocation.mReferenceType != null)
          return false;
      if (this.mRelevance != null)
      {
        if (this.mRelevance.equals(localRiderLocation.mRelevance));
      }
      else
        while (localRiderLocation.mRelevance != null)
          return false;
      if (this.mShortAddress != null)
      {
        if (this.mShortAddress.equals(localRiderLocation.mShortAddress));
      }
      else
        while (localRiderLocation.mShortAddress != null)
          return false;
      if (this.mSubtitle != null)
      {
        if (this.mSubtitle.equals(localRiderLocation.mSubtitle));
      }
      else
        while (localRiderLocation.mSubtitle != null)
          return false;
      if (this.mTitle != null)
      {
        if (this.mTitle.equals(localRiderLocation.mTitle));
      }
      else
        while (localRiderLocation.mTitle != null)
          return false;
      if (this.mType == null)
        break;
    }
    while (this.mType.equals(localRiderLocation.mType));
    while (true)
    {
      return false;
      if (localRiderLocation.mType == null)
        break;
    }
  }

  public AddressComponent findAddressComponent(final String paramString)
  {
    if (this.mListAddressComponents == null)
      return null;
    return (AddressComponent)Iterators.tryFind(this.mListAddressComponents.iterator(), new Predicate()
    {
      public boolean apply(AddressComponent paramAnonymousAddressComponent)
      {
        if (paramAnonymousAddressComponent.getTypes() == null)
          return false;
        return paramAnonymousAddressComponent.getTypes().contains(paramString);
      }
    }).orNull();
  }

  public CnLocation getCnLocation()
  {
    CnLocation localCnLocation = new CnLocation();
    localCnLocation.setLatitude(getUberLatLng().getLatitude());
    localCnLocation.setLongitude(getUberLatLng().getLongitude());
    localCnLocation.setDistance(this.mDistance);
    localCnLocation.setId(this.mId);
    localCnLocation.setType(this.mType);
    localCnLocation.setNickname(this.mNickname);
    localCnLocation.setAddress(this.mAddress);
    localCnLocation.setFormattedAddress(this.mFormattedAddress);
    localCnLocation.setAddressComponents(this.mListAddressComponents);
    localCnLocation.setRelevance(this.mRelevance);
    localCnLocation.setReference(this.mReference);
    localCnLocation.setReferenceType(this.mReferenceType);
    return localCnLocation;
  }

  public String getDisplayAddressDescription()
  {
    String str1;
    if (getShortFormatted() != null)
    {
      str1 = getShortFormatted();
      if (getFormattedAddress() == null)
        break label118;
    }
    label118: for (String str2 = getFormattedAddress(); ; str2 = "")
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (!TextUtils.isEmpty(this.mTitle))
      {
        localStringBuilder.append(this.mTitle);
        localStringBuilder.append(" ");
      }
      if ((TextUtils.isEmpty(this.mTitle)) || (!str1.startsWith(this.mTitle)))
        localStringBuilder.append(str1);
      if ((localStringBuilder.length() == 0) && (!TextUtils.isEmpty(str2)))
        localStringBuilder.append(str2);
      return localStringBuilder.toString();
      str1 = "";
      break;
    }
  }

  public String getFormattedAddress()
  {
    return this.mFormattedAddress;
  }

  public String getFormattedCityAddress()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    AddressComponent localAddressComponent1 = findAddressComponent("locality");
    AddressComponent localAddressComponent2 = findAddressComponent("administrative_area_level_1");
    AddressComponent localAddressComponent3 = findAddressComponent("postal_code");
    if ((localAddressComponent1 != null) && (!TextUtils.isEmpty(localAddressComponent1.getLongName())))
      localStringBuilder.append(localAddressComponent1.getLongName());
    if ((localAddressComponent2 != null) && (!TextUtils.isEmpty(localAddressComponent2.getShortName())))
    {
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append(localAddressComponent2.getShortName());
    }
    while (true)
    {
      if ((localAddressComponent3 != null) && (!TextUtils.isEmpty(localAddressComponent3.getLongName())))
      {
        if (localStringBuilder.length() > 0)
          localStringBuilder.append(", ");
        localStringBuilder.append(localAddressComponent3.getLongName());
      }
      return localStringBuilder.toString();
      if ((localAddressComponent2 != null) && (!TextUtils.isEmpty(localAddressComponent2.getLongName())))
      {
        if (localStringBuilder.length() > 0)
          localStringBuilder.append(", ");
        localStringBuilder.append(localAddressComponent2.getLongName());
      }
    }
  }

  public String getFormattedStreetAddress()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    AddressComponent localAddressComponent1 = findAddressComponent("street_number");
    AddressComponent localAddressComponent2 = findAddressComponent("route");
    if ((localAddressComponent1 != null) && (!TextUtils.isEmpty(localAddressComponent1.getLongName())))
    {
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(" ");
      localStringBuilder.append(localAddressComponent1.getLongName());
    }
    if ((localAddressComponent2 != null) && (!TextUtils.isEmpty(localAddressComponent2.getLongName())))
    {
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(" ");
      localStringBuilder.append(localAddressComponent2.getLongName());
    }
    return localStringBuilder.toString();
  }

  public String getId()
  {
    return this.mId;
  }

  public String getNickname()
  {
    return this.mNickname;
  }

  public String getReference()
  {
    return this.mReference;
  }

  public String getShortFormatted()
  {
    String str;
    if (!TextUtils.isEmpty(this.mShortAddress))
      str = this.mShortAddress;
    do
    {
      return str;
      if (!TextUtils.isEmpty(this.mLongAddress))
        return this.mLongAddress;
      if (!TextUtils.isEmpty(this.mFormattedAddress))
        return this.mFormattedAddress;
      if (!TextUtils.isEmpty(this.mAddress))
        return this.mAddress;
      str = getFormattedStreetAddress();
    }
    while (!TextUtils.isEmpty(str));
    return getFormattedCityAddress();
  }

  public String getTitle()
  {
    return this.mTitle;
  }

  public String getType()
  {
    return this.mType;
  }

  public boolean hasReverseGeocodeData()
  {
    return (!TextUtils.isEmpty(this.mId)) || (!TextUtils.isEmpty(this.mTitle)) || (!TextUtils.isEmpty(this.mSubtitle)) || (!TextUtils.isEmpty(this.mNickname)) || (!TextUtils.isEmpty(this.mAddress)) || (!TextUtils.isEmpty(this.mFormattedAddress)) || (!TextUtils.isEmpty(this.mShortAddress)) || (!TextUtils.isEmpty(this.mLongAddress)) || ((this.mListAddressComponents != null) && (!this.mListAddressComponents.isEmpty()));
  }

  public int hashCode()
  {
    int i = 31 * (31 * super.hashCode() + (int)(this.mDistance ^ this.mDistance >>> 32));
    int j;
    int m;
    label63: int i1;
    label88: int i3;
    label114: int i5;
    label140: int i7;
    label166: int i9;
    label192: int i11;
    label218: int i13;
    label244: int i15;
    label270: int i17;
    label296: int i18;
    if (this.mId != null)
    {
      j = this.mId.hashCode();
      int k = 31 * (i + j);
      if (this.mType == null)
        break label368;
      m = this.mType.hashCode();
      int n = 31 * (k + m);
      if (this.mTitle == null)
        break label374;
      i1 = this.mTitle.hashCode();
      int i2 = 31 * (n + i1);
      if (this.mSubtitle == null)
        break label380;
      i3 = this.mSubtitle.hashCode();
      int i4 = 31 * (i2 + i3);
      if (this.mNickname == null)
        break label386;
      i5 = this.mNickname.hashCode();
      int i6 = 31 * (i4 + i5);
      if (this.mAddress == null)
        break label392;
      i7 = this.mAddress.hashCode();
      int i8 = 31 * (i6 + i7);
      if (this.mRelevance == null)
        break label398;
      i9 = this.mRelevance.hashCode();
      int i10 = 31 * (i8 + i9);
      if (this.mReference == null)
        break label404;
      i11 = this.mReference.hashCode();
      int i12 = 31 * (i10 + i11);
      if (this.mLongAddress == null)
        break label410;
      i13 = this.mLongAddress.hashCode();
      int i14 = 31 * (i12 + i13);
      if (this.mShortAddress == null)
        break label416;
      i15 = this.mShortAddress.hashCode();
      int i16 = 31 * (i14 + i15);
      if (this.mReferenceType == null)
        break label422;
      i17 = this.mReferenceType.hashCode();
      i18 = 31 * (i16 + i17);
      if (this.mFormattedAddress == null)
        break label428;
    }
    label386: label392: label398: label404: label410: label416: label422: label428: for (int i19 = this.mFormattedAddress.hashCode(); ; i19 = 0)
    {
      int i20 = 31 * (i18 + i19);
      List localList = this.mListAddressComponents;
      int i21 = 0;
      if (localList != null)
        i21 = this.mListAddressComponents.hashCode();
      return i20 + i21;
      j = 0;
      break;
      label368: m = 0;
      break label63;
      label374: i1 = 0;
      break label88;
      label380: i3 = 0;
      break label114;
      i5 = 0;
      break label140;
      i7 = 0;
      break label166;
      i9 = 0;
      break label192;
      i11 = 0;
      break label218;
      i13 = 0;
      break label244;
      i15 = 0;
      break label270;
      i17 = 0;
      break label296;
    }
  }

  public boolean isDeviceLocation()
  {
    return (this.mType != null) && (this.mType.equals("device"));
  }

  public boolean isExternalLocation()
  {
    return (this.mType != null) && (this.mType.equals("external"));
  }

  public boolean isLocationSearchResult()
  {
    return (this.mType != null) && ((this.mType.equals("backfill")) || (this.mType.equals("cache")));
  }

  public void setReference(String paramString1, String paramString2)
  {
    this.mReference = paramString1;
    this.mReferenceType = paramString2;
  }

  public void setTitle(String paramString)
  {
    this.mTitle = paramString;
  }

  public void update(LocationSearchResult paramLocationSearchResult)
  {
    this.mId = paramLocationSearchResult.getId();
    this.mNickname = paramLocationSearchResult.getNickname();
    this.mShortAddress = paramLocationSearchResult.getShortAddress();
    this.mLongAddress = paramLocationSearchResult.getLongAddress();
    this.mFormattedAddress = paramLocationSearchResult.getFormattedAddress();
    this.mTitle = paramLocationSearchResult.getTitle();
    this.mSubtitle = paramLocationSearchResult.getSubtitle();
    this.mRelevance = paramLocationSearchResult.getRelevance();
    this.mReference = paramLocationSearchResult.getReference();
    this.mReferenceType = paramLocationSearchResult.getType();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mDistance);
    paramParcel.writeString(this.mId);
    paramParcel.writeString(this.mType);
    paramParcel.writeString(this.mTitle);
    paramParcel.writeString(this.mSubtitle);
    paramParcel.writeString(this.mNickname);
    paramParcel.writeString(this.mAddress);
    paramParcel.writeString(this.mRelevance);
    paramParcel.writeString(this.mReference);
    paramParcel.writeString(this.mLongAddress);
    paramParcel.writeString(this.mShortAddress);
    paramParcel.writeString(this.mReferenceType);
    paramParcel.writeString(this.mFormattedAddress);
    paramParcel.writeList(this.mListAddressComponents);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.location.RiderLocation
 * JD-Core Version:    0.6.2
 */