package com.ubercab.client.feature.signup;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.Map;

public class SignupData
  implements Parcelable
{
  public static Parcelable.Creator<SignupData> CREATOR = new Parcelable.Creator()
  {
    public SignupData createFromParcel(Parcel paramAnonymousParcel)
    {
      return new SignupData(paramAnonymousParcel, null);
    }

    public SignupData[] newArray(int paramAnonymousInt)
    {
      return new SignupData[paramAnonymousInt];
    }
  };
  private String mAlipayAccountId;
  private String mAlipayMobile;
  private String mEmail;
  private String mFirstName;
  private String mGoogleToken;
  private String mLastName;
  private String mMobile;
  private String mMobileCountryIso2;
  private String mPassword;
  private String mPayPalAuthorizationCode;
  private String mPictureUrl;
  private PromoCode mPromoCode;
  private ThirdPartyToken mThirdPartyToken;

  public SignupData()
  {
  }

  private SignupData(Parcel paramParcel)
  {
    this.mEmail = paramParcel.readString();
    this.mMobile = paramParcel.readString();
    this.mMobileCountryIso2 = paramParcel.readString();
    this.mPassword = paramParcel.readString();
    this.mFirstName = paramParcel.readString();
    this.mGoogleToken = paramParcel.readString();
    this.mLastName = paramParcel.readString();
    this.mPictureUrl = paramParcel.readString();
    this.mPromoCode = ((PromoCode)paramParcel.readParcelable(PromoCode.class.getClassLoader()));
    this.mPayPalAuthorizationCode = paramParcel.readString();
    this.mAlipayAccountId = paramParcel.readString();
    this.mAlipayMobile = paramParcel.readString();
    this.mThirdPartyToken = ((ThirdPartyToken)paramParcel.readParcelable(ThirdPartyToken.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAlipayAccountId()
  {
    return this.mAlipayAccountId;
  }

  public String getAlipayMobile()
  {
    return this.mAlipayMobile;
  }

  public String getEmail()
  {
    return this.mEmail;
  }

  public String getFirstName()
  {
    return this.mFirstName;
  }

  public String getGoogleToken()
  {
    return this.mGoogleToken;
  }

  public String getLastName()
  {
    return this.mLastName;
  }

  public String getMobile()
  {
    return this.mMobile;
  }

  public String getMobileCountryIso2()
  {
    return this.mMobileCountryIso2;
  }

  public String getPassword()
  {
    return this.mPassword;
  }

  public String getPayPalAuthorizationCode()
  {
    return this.mPayPalAuthorizationCode;
  }

  public String getPictureUrl()
  {
    return this.mPictureUrl;
  }

  public PromoCode getPromoCode()
  {
    return this.mPromoCode;
  }

  public ThirdPartyToken getThirdPartyToken()
  {
    return this.mThirdPartyToken;
  }

  public boolean hasRequiredData()
  {
    return (!TextUtils.isEmpty(this.mFirstName)) && (!TextUtils.isEmpty(this.mLastName)) && (!TextUtils.isEmpty(this.mMobile)) && (!TextUtils.isEmpty(this.mMobileCountryIso2));
  }

  public void setAlipayAccountId(String paramString)
  {
    this.mAlipayAccountId = paramString;
  }

  public void setAlipayMobile(String paramString)
  {
    this.mAlipayMobile = paramString;
  }

  public SignupData setEmail(String paramString)
  {
    this.mEmail = paramString;
    return this;
  }

  public SignupData setFirstName(String paramString)
  {
    this.mFirstName = paramString;
    return this;
  }

  public SignupData setGoogleToken(String paramString)
  {
    this.mGoogleToken = paramString;
    return this;
  }

  public SignupData setLastName(String paramString)
  {
    this.mLastName = paramString;
    return this;
  }

  public SignupData setMobile(String paramString1, String paramString2)
  {
    this.mMobile = paramString1;
    this.mMobileCountryIso2 = paramString2;
    return this;
  }

  public SignupData setPassword(String paramString)
  {
    this.mPassword = paramString;
    return this;
  }

  public SignupData setPayPalAuthorizationCode(String paramString)
  {
    this.mPayPalAuthorizationCode = paramString;
    return this;
  }

  public void setPictureUrl(String paramString)
  {
    this.mPictureUrl = paramString;
  }

  public SignupData setPromoCode(PromoCode paramPromoCode)
  {
    this.mPromoCode = paramPromoCode;
    return this;
  }

  public SignupData setThirdPartyToken(ThirdPartyToken paramThirdPartyToken)
  {
    this.mThirdPartyToken = paramThirdPartyToken;
    return this;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mEmail);
    paramParcel.writeString(this.mMobile);
    paramParcel.writeString(this.mMobileCountryIso2);
    paramParcel.writeString(this.mPassword);
    paramParcel.writeString(this.mFirstName);
    paramParcel.writeString(this.mGoogleToken);
    paramParcel.writeString(this.mLastName);
    paramParcel.writeString(this.mPictureUrl);
    paramParcel.writeParcelable(this.mPromoCode, paramInt);
    paramParcel.writeString(this.mAlipayAccountId);
    paramParcel.writeString(this.mAlipayMobile);
    paramParcel.writeString(this.mPayPalAuthorizationCode);
    paramParcel.writeParcelable(this.mThirdPartyToken, paramInt);
  }

  public static class PromoCode
    implements Parcelable
  {
    public static Parcelable.Creator<PromoCode> CREATOR = new Parcelable.Creator()
    {
      public SignupData.PromoCode createFromParcel(Parcel paramAnonymousParcel)
      {
        return new SignupData.PromoCode(paramAnonymousParcel, null);
      }

      public SignupData.PromoCode[] newArray(int paramAnonymousInt)
      {
        return new SignupData.PromoCode[paramAnonymousInt];
      }
    };
    private String mCode;
    private String mInviterFirstName;
    private String mInviterPictureUrl;
    private String mValue;

    public PromoCode()
    {
    }

    private PromoCode(Parcel paramParcel)
    {
      this.mCode = paramParcel.readString();
      this.mValue = paramParcel.readString();
      this.mInviterFirstName = paramParcel.readString();
      this.mInviterPictureUrl = paramParcel.readString();
    }

    public static PromoCode createFromData(String paramString, Map paramMap)
    {
      PromoCode localPromoCode = new PromoCode();
      localPromoCode.mCode = paramString;
      if (paramMap != null)
      {
        localPromoCode.mValue = ((String)paramMap.get("promotion_value_string"));
        Map localMap = (Map)paramMap.get("inviter");
        if (localMap != null)
        {
          localPromoCode.mInviterFirstName = ((String)localMap.get("first_name"));
          localPromoCode.mInviterPictureUrl = ((String)localMap.get("picture_url"));
        }
      }
      return localPromoCode;
    }

    static PromoCode createFromData(Map paramMap)
    {
      if ((paramMap == null) || (paramMap.isEmpty()))
        return null;
      return createFromData((String)paramMap.get("promotion_code"), paramMap);
    }

    public int describeContents()
    {
      return 0;
    }

    public String getCode()
    {
      return this.mCode;
    }

    public String getInviterFirstName()
    {
      return this.mInviterFirstName;
    }

    public String getInviterPictureUrl()
    {
      return this.mInviterPictureUrl;
    }

    public String getValue()
    {
      return this.mValue;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mCode);
      paramParcel.writeString(this.mValue);
      paramParcel.writeString(this.mInviterFirstName);
      paramParcel.writeString(this.mInviterPictureUrl);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.SignupData
 * JD-Core Version:    0.6.2
 */