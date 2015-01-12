package com.ubercab.client.feature.signup;

public final class PaymentData
{
  private String mCardCode;
  private String mCardMonth;
  private String mCardNumber;
  private String mCardYear;

  public PaymentData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mCardNumber = paramString1;
    this.mCardCode = paramString2;
    this.mCardMonth = paramString3;
    this.mCardYear = paramString4;
  }

  public String getCardCode()
  {
    return this.mCardCode;
  }

  public String getCardMonth()
  {
    return this.mCardMonth;
  }

  public String getCardNumber()
  {
    return this.mCardNumber;
  }

  public String getCardYear()
  {
    return this.mCardYear;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.signup.PaymentData
 * JD-Core Version:    0.6.2
 */