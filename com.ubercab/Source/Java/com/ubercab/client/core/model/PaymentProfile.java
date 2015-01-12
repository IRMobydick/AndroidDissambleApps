package com.ubercab.client.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.ubercab.common.base.Predicate;
import com.ubercab.common.collect.Iterables;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class PaymentProfile
  implements Parcelable
{
  public static final String CARD_USE_CASE_BUSINESS = "business";
  public static final String CARD_USE_CASE_PERSONAL = "personal";
  public static final Parcelable.Creator<PaymentProfile> CREATOR = new Parcelable.Creator()
  {
    public PaymentProfile createFromParcel(Parcel paramAnonymousParcel)
    {
      if (paramAnonymousParcel.readInt() == 1)
        return PaymentProfile.GOOGLE_WALLET;
      return new PaymentProfile(paramAnonymousParcel, null);
    }

    public PaymentProfile[] newArray(int paramAnonymousInt)
    {
      return new PaymentProfile[paramAnonymousInt];
    }
  };
  public static final PaymentProfile GOOGLE_WALLET = new PaymentProfile("Google Wallet");
  private static final int PARCEL_GOOGLE_WALLET_FALSE = 0;
  private static final int PARCEL_GOOGLE_WALLET_TRUE = 1;
  String accountName = "";
  String billingCountryIso2 = "";
  String billingZip = "";
  long cardExpirationEpoch = 0L;
  String cardNumber = "";
  String cardType = "";
  String id = "";
  RewardInfo rewardInfo;
  String tokenType = "";
  String useCase = "";
  String uuid = "";

  public PaymentProfile()
  {
  }

  private PaymentProfile(Parcel paramParcel)
  {
    this.cardExpirationEpoch = paramParcel.readLong();
    this.accountName = paramParcel.readString();
    this.billingCountryIso2 = paramParcel.readString();
    this.billingZip = paramParcel.readString();
    this.cardNumber = paramParcel.readString();
    this.cardType = paramParcel.readString();
    this.id = paramParcel.readString();
    this.rewardInfo = ((RewardInfo)paramParcel.readParcelable(RewardInfo.class.getClassLoader()));
    this.tokenType = paramParcel.readString();
    this.useCase = paramParcel.readString();
    this.uuid = paramParcel.readString();
  }

  private PaymentProfile(String paramString)
  {
    this.id = paramString;
    this.cardType = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    PaymentProfile localPaymentProfile;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localPaymentProfile = (PaymentProfile)paramObject;
      if (this.cardExpirationEpoch != localPaymentProfile.cardExpirationEpoch)
        return false;
      if (this.accountName != null)
      {
        if (this.accountName.equals(localPaymentProfile.accountName));
      }
      else
        while (localPaymentProfile.accountName != null)
          return false;
      if (this.billingCountryIso2 != null)
      {
        if (this.billingCountryIso2.equals(localPaymentProfile.billingCountryIso2));
      }
      else
        while (localPaymentProfile.billingCountryIso2 != null)
          return false;
      if (this.billingZip != null)
      {
        if (this.billingZip.equals(localPaymentProfile.billingZip));
      }
      else
        while (localPaymentProfile.billingZip != null)
          return false;
      if (this.cardNumber != null)
      {
        if (this.cardNumber.equals(localPaymentProfile.cardNumber));
      }
      else
        while (localPaymentProfile.cardNumber != null)
          return false;
      if (this.cardType != null)
      {
        if (this.cardType.equals(localPaymentProfile.cardType));
      }
      else
        while (localPaymentProfile.cardType != null)
          return false;
      if (this.id != null)
      {
        if (this.id.equals(localPaymentProfile.id));
      }
      else
        while (localPaymentProfile.id != null)
          return false;
      if (this.rewardInfo != null)
      {
        if (this.rewardInfo.equals(localPaymentProfile.rewardInfo));
      }
      else
        while (localPaymentProfile.rewardInfo != null)
          return false;
      if (this.tokenType != null)
      {
        if (this.tokenType.equals(localPaymentProfile.tokenType));
      }
      else
        while (localPaymentProfile.tokenType != null)
          return false;
      if (this.useCase != null)
      {
        if (this.useCase.equals(localPaymentProfile.useCase));
      }
      else
        while (localPaymentProfile.useCase != null)
          return false;
      if (this.uuid == null)
        break;
    }
    while (this.uuid.equals(localPaymentProfile.uuid));
    while (true)
    {
      return false;
      if (localPaymentProfile.uuid == null)
        break;
    }
  }

  public String getAccountName()
  {
    return this.accountName;
  }

  public String getBillingCountryIso2()
  {
    return this.billingCountryIso2;
  }

  public String getBillingZip()
  {
    return this.billingZip;
  }

  public long getCardExpirationEpoch()
  {
    return this.cardExpirationEpoch;
  }

  public String getCardNumber()
  {
    return this.cardNumber;
  }

  public String getCardType()
  {
    return this.cardType;
  }

  public String getDisplayText(Context paramContext, List<PaymentProfile> paramList)
  {
    String str = this.cardType;
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 1963873898:
    case -1911368973:
    case 344963008:
    case 76891393:
    case 883966373:
    }
    while (true)
      switch (i)
      {
      default:
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = getLocalizedUseCase(paramContext);
        arrayOfObject[1] = this.cardNumber;
        return String.format("%s •••• %s", arrayOfObject);
        if (str.equals("Alipay"))
        {
          i = 0;
          continue;
          if (str.equals("PayPal"))
          {
            i = 1;
            continue;
            if (str.equals("Google Wallet"))
            {
              i = 2;
              continue;
              if (str.equals("Paytm"))
              {
                i = 3;
                continue;
                if (str.equals("Delegate"))
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
    if (Iterables.size(Iterables.filter(paramList, new Predicate()
    {
      public boolean apply(PaymentProfile paramAnonymousPaymentProfile)
      {
        return "Alipay".equals(paramAnonymousPaymentProfile.cardType);
      }
    })) > 1)
      return this.accountName;
    return paramContext.getString(2131558441);
    if (Iterables.size(Iterables.filter(paramList, new Predicate()
    {
      public boolean apply(PaymentProfile paramAnonymousPaymentProfile)
      {
        return "PayPal".equals(paramAnonymousPaymentProfile.cardType);
      }
    })) > 1)
      return this.accountName;
    return paramContext.getString(2131558996);
    return paramContext.getString(2131558885);
    if (Iterables.size(Iterables.filter(paramList, new Predicate()
    {
      public boolean apply(PaymentProfile paramAnonymousPaymentProfile)
      {
        return "Paytm".equals(paramAnonymousPaymentProfile.cardType);
      }
    })) > 1)
      return this.accountName;
    return paramContext.getString(2131558997);
    return this.accountName;
  }

  public String getExpirationMonth()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM");
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localSimpleDateFormat.format(new Date(this.cardExpirationEpoch));
  }

  public String getExpirationYear()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy", Locale.getDefault());
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localSimpleDateFormat.format(new Date(this.cardExpirationEpoch));
  }

  public String getId()
  {
    return this.id;
  }

  public String getLocalizedUseCase(Context paramContext)
  {
    String str = getUseCase();
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 443164224:
    case -1146830912:
    }
    while (true)
      switch (i)
      {
      default:
        return str;
        if (str.equals("personal"))
        {
          i = 0;
          continue;
          if (str.equals("business"))
            i = 1;
        }
        break;
      case 0:
      case 1:
      }
    return paramContext.getString(2131559001);
    return paramContext.getString(2131558464);
  }

  public RewardInfo getRewardInfo()
  {
    return this.rewardInfo;
  }

  public String getTokenType()
  {
    return this.tokenType;
  }

  public String getUseCase()
  {
    return this.useCase;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public int hashCode()
  {
    int i = 31 * (int)(this.cardExpirationEpoch ^ this.cardExpirationEpoch >>> 32);
    int j;
    int m;
    label55: int i1;
    label80: int i3;
    label106: int i5;
    label132: int i7;
    label158: int i9;
    label184: int i11;
    label210: int i12;
    if (this.accountName != null)
    {
      j = this.accountName.hashCode();
      int k = 31 * (i + j);
      if (this.billingCountryIso2 == null)
        break label280;
      m = this.billingCountryIso2.hashCode();
      int n = 31 * (k + m);
      if (this.billingZip == null)
        break label286;
      i1 = this.billingZip.hashCode();
      int i2 = 31 * (n + i1);
      if (this.cardNumber == null)
        break label292;
      i3 = this.cardNumber.hashCode();
      int i4 = 31 * (i2 + i3);
      if (this.cardType == null)
        break label298;
      i5 = this.cardType.hashCode();
      int i6 = 31 * (i4 + i5);
      if (this.id == null)
        break label304;
      i7 = this.id.hashCode();
      int i8 = 31 * (i6 + i7);
      if (this.rewardInfo == null)
        break label310;
      i9 = this.rewardInfo.hashCode();
      int i10 = 31 * (i8 + i9);
      if (this.tokenType == null)
        break label316;
      i11 = this.tokenType.hashCode();
      i12 = 31 * (i10 + i11);
      if (this.useCase == null)
        break label322;
    }
    label280: label286: label292: label298: label304: label310: label316: label322: for (int i13 = this.useCase.hashCode(); ; i13 = 0)
    {
      int i14 = 31 * (i12 + i13);
      String str = this.uuid;
      int i15 = 0;
      if (str != null)
        i15 = this.uuid.hashCode();
      return i14 + i15;
      j = 0;
      break;
      m = 0;
      break label55;
      i1 = 0;
      break label80;
      i3 = 0;
      break label106;
      i5 = 0;
      break label132;
      i7 = 0;
      break label158;
      i9 = 0;
      break label184;
      i11 = 0;
      break label210;
    }
  }

  public boolean isBusinessCard()
  {
    return this.cardType.equals("Delegate");
  }

  public boolean isMobileWallet()
  {
    return this.cardType.equals("Paytm");
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.cardType.equals("Google Wallet"))
    {
      paramParcel.writeInt(1);
      return;
    }
    paramParcel.writeInt(0);
    paramParcel.writeLong(this.cardExpirationEpoch);
    paramParcel.writeString(this.accountName);
    paramParcel.writeString(this.billingCountryIso2);
    paramParcel.writeString(this.billingZip);
    paramParcel.writeString(this.cardNumber);
    paramParcel.writeString(this.cardType);
    paramParcel.writeString(this.id);
    paramParcel.writeParcelable(this.rewardInfo, paramInt);
    paramParcel.writeString(this.tokenType);
    paramParcel.writeString(this.useCase);
    paramParcel.writeString(this.uuid);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.PaymentProfile
 * JD-Core Version:    0.6.2
 */