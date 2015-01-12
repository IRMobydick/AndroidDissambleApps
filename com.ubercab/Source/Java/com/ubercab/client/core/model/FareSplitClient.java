package com.ubercab.client.core.model;

import android.content.Context;
import android.text.TextUtils;
import com.ubercab.library.util.PhoneNumberUtils;

public final class FareSplitClient
{
  public static final String STATUS_ACCEPTED = "Accepted";
  public static final String STATUS_CANCELED = "Canceled";
  public static final String STATUS_DECLINED = "Declined";
  public static final String STATUS_FAILED = "InviteFailed";
  public static final String STATUS_INVALID_NUMBER = "InvalidNumber";
  public static final String STATUS_NO_ACCOUNT = "NoAccount";
  public static final String STATUS_PENDING = "Pending";
  private static final String UGLY_DEFAULT_URL = "https://uber-userpictures.s3.amazonaws.com/default.jpeg";
  private String feeString;
  private String fullName;
  private Boolean isInitiator;
  private Boolean isSelf;
  private String mobileCountryIso2;
  private String mobileDigits;
  private String name;
  private String pictureUrl;
  private String status;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    FareSplitClient localFareSplitClient;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localFareSplitClient = (FareSplitClient)paramObject;
      if (this.feeString != null)
      {
        if (this.feeString.equals(localFareSplitClient.feeString));
      }
      else
        while (localFareSplitClient.feeString != null)
          return false;
      if (this.fullName != null)
      {
        if (this.fullName.equals(localFareSplitClient.fullName));
      }
      else
        while (localFareSplitClient.fullName != null)
          return false;
      if (this.isInitiator != null)
      {
        if (this.isInitiator.equals(localFareSplitClient.isInitiator));
      }
      else
        while (localFareSplitClient.isInitiator != null)
          return false;
      if (this.isSelf != null)
      {
        if (this.isSelf.equals(localFareSplitClient.isSelf));
      }
      else
        while (localFareSplitClient.isSelf != null)
          return false;
      if (this.mobileCountryIso2 != null)
      {
        if (this.mobileCountryIso2.equals(localFareSplitClient.mobileCountryIso2));
      }
      else
        while (localFareSplitClient.mobileCountryIso2 != null)
          return false;
      if (this.mobileDigits != null)
      {
        if (this.mobileDigits.equals(localFareSplitClient.mobileDigits));
      }
      else
        while (localFareSplitClient.mobileDigits != null)
          return false;
      if (this.name != null)
      {
        if (this.name.equals(localFareSplitClient.name));
      }
      else
        while (localFareSplitClient.name != null)
          return false;
      if (this.pictureUrl != null)
      {
        if (this.pictureUrl.equals(localFareSplitClient.pictureUrl));
      }
      else
        while (localFareSplitClient.pictureUrl != null)
          return false;
      if (this.status == null)
        break;
    }
    while (this.status.equals(localFareSplitClient.status));
    while (true)
    {
      return false;
      if (localFareSplitClient.status == null)
        break;
    }
  }

  public String getDisplayName()
  {
    if (!TextUtils.isEmpty(this.fullName))
      return this.fullName;
    if (!TextUtils.isEmpty(this.name))
      return this.name;
    return "";
  }

  public String getDisplayNameOrNumber()
  {
    String str = getDisplayName();
    if (!TextUtils.isEmpty(str))
      return str;
    return PhoneNumberUtils.getDisplayPhoneNumber(this.mobileDigits, this.mobileCountryIso2);
  }

  public String getDisplayStatus(Context paramContext)
  {
    String str = this.status;
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case -2081881145:
    case 632840270:
    case -58529607:
    case -522759168:
    case 1418225932:
    }
    while (true)
      switch (i)
      {
      default:
        return this.status;
        if (str.equals("Accepted"))
        {
          i = 0;
          continue;
          if (str.equals("Declined"))
          {
            i = 1;
            continue;
            if (str.equals("Canceled"))
            {
              i = 2;
              continue;
              if (str.equals("InvalidNumber"))
              {
                i = 3;
                continue;
                if (str.equals("NoAccount"))
                  i = 4;
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    return paramContext.getString(2131558859);
    return paramContext.getString(2131558864);
    return paramContext.getString(2131558860);
    return paramContext.getString(2131558868);
    return paramContext.getString(2131558871);
  }

  public String getFeeString()
  {
    return this.feeString;
  }

  public String getFullName()
  {
    return this.fullName;
  }

  public String getMobileCountryIso2()
  {
    return this.mobileCountryIso2;
  }

  public String getMobileDigits()
  {
    return this.mobileDigits;
  }

  public String getName()
  {
    return this.name;
  }

  public String getPictureUrl()
  {
    if (!"https://uber-userpictures.s3.amazonaws.com/default.jpeg".equals(this.pictureUrl))
      return this.pictureUrl;
    return null;
  }

  public String getStatus()
  {
    return this.status;
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
    label163: int i9;
    if (this.isInitiator != null)
    {
      i = this.isInitiator.hashCode();
      int j = i * 31;
      if (this.isSelf == null)
        break label233;
      k = this.isSelf.hashCode();
      int m = 31 * (j + k);
      if (this.feeString == null)
        break label238;
      n = this.feeString.hashCode();
      int i1 = 31 * (m + n);
      if (this.fullName == null)
        break label244;
      i2 = this.fullName.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.name == null)
        break label250;
      i4 = this.name.hashCode();
      int i5 = 31 * (i3 + i4);
      if (this.mobileCountryIso2 == null)
        break label256;
      i6 = this.mobileCountryIso2.hashCode();
      int i7 = 31 * (i5 + i6);
      if (this.mobileDigits == null)
        break label262;
      i8 = this.mobileDigits.hashCode();
      i9 = 31 * (i7 + i8);
      if (this.pictureUrl == null)
        break label268;
    }
    label256: label262: label268: for (int i10 = this.pictureUrl.hashCode(); ; i10 = 0)
    {
      int i11 = 31 * (i9 + i10);
      String str = this.status;
      int i12 = 0;
      if (str != null)
        i12 = this.status.hashCode();
      return i11 + i12;
      i = 0;
      break;
      label233: k = 0;
      break label35;
      label238: n = 0;
      break label59;
      label244: i2 = 0;
      break label85;
      label250: i4 = 0;
      break label111;
      i6 = 0;
      break label137;
      i8 = 0;
      break label163;
    }
  }

  public boolean isInitiator()
  {
    if (this.isInitiator == null)
      return false;
    return this.isInitiator.booleanValue();
  }

  public boolean isSelf()
  {
    if (this.isSelf == null)
      return false;
    return this.isSelf.booleanValue();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.FareSplitClient
 * JD-Core Version:    0.6.2
 */