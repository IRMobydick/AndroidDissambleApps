package io.card.payment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class CreditCard
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new CreditCard.1();
  public static final int EXPIRY_MAX_FUTURE_YEARS = 15;
  private static final String TAG = "CardIOCreditCardResults";
  public String cardNumber;
  public String cvv;
  public int expiryMonth = 0;
  public int expiryYear = 0;
  boolean flipped = false;
  public String postalCode;
  String scanId;
  int[] xoff;
  int yoff;
  public String zip;

  public CreditCard()
  {
    this.xoff = new int[16];
    this.scanId = UUID.randomUUID().toString();
  }

  private CreditCard(Parcel paramParcel)
  {
    this.cardNumber = paramParcel.readString();
    this.expiryMonth = paramParcel.readInt();
    this.expiryYear = paramParcel.readInt();
    this.cvv = paramParcel.readString();
    this.postalCode = paramParcel.readString();
    this.zip = this.postalCode;
    this.scanId = paramParcel.readString();
    this.yoff = paramParcel.readInt();
    this.xoff = paramParcel.createIntArray();
  }

  CreditCard(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0));
    do
      while (true)
      {
        return;
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          this.cardNumber = localJSONObject.optString("numbers");
          new StringBuilder("- number: ").append(getRedactedCardNumber()).toString();
          JSONArray localJSONArray1 = localJSONObject.optJSONArray("expiry");
          if ((localJSONArray1 != null) && (localJSONArray1.length() == 2))
          {
            this.expiryYear = localJSONArray1.getInt(0);
            new StringBuilder("- year: ").append(this.expiryYear).toString();
            this.expiryMonth = localJSONArray1.getInt(1);
            new StringBuilder("- month: ").append(this.expiryMonth).toString();
          }
          this.flipped = localJSONObject.optBoolean("is_flipped");
          new StringBuilder("- isFlipped: ").append(this.flipped).toString();
          this.scanId = localJSONObject.optString("scan_id");
          new StringBuilder("- scanId: ").append(this.scanId).toString();
          this.yoff = localJSONObject.optInt("y_offset");
          JSONArray localJSONArray2 = localJSONObject.optJSONArray("x_offsets");
          this.xoff = new int[localJSONArray2.length()];
          while (i < localJSONArray2.length())
          {
            this.xoff[i] = localJSONArray2.getInt(i);
            i++;
          }
        }
        catch (Exception localException)
        {
          Log.w("CardIOCreditCardResults", "error parsing credit card response: ", localException);
        }
      }
    while ((this.cardNumber == null) || ((this.cardNumber.length() >= 15) && (P.a(this.cardNumber))));
    this.cardNumber = null;
  }

  public CreditCard(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this.cardNumber = paramString1;
    this.expiryMonth = paramInt1;
    this.expiryYear = paramInt2;
    this.cvv = paramString2;
    this.zip = paramString3;
    this.postalCode = paramString3;
  }

  public int describeContents()
  {
    return 0;
  }

  boolean failed()
  {
    return (this.cardNumber == null) || (this.cardNumber.length() == 0);
  }

  public CardType getCardType()
  {
    return CardType.fromCardNumber(this.cardNumber);
  }

  public String getFormattedCardNumber()
  {
    return P.a(this.cardNumber, true, null);
  }

  public String getLastFourDigitsOfCardNumber()
  {
    if (this.cardNumber != null)
    {
      int i = Math.min(4, this.cardNumber.length());
      return this.cardNumber.substring(this.cardNumber.length() - i);
    }
    return "";
  }

  public String getRedactedCardNumber()
  {
    if (this.cardNumber != null)
    {
      String str = "";
      if (this.cardNumber.length() > 4)
        str = str + String.format(new StringBuilder("%").append(-4 + this.cardNumber.length()).append("s").toString(), new Object[] { "" }).replace(' ', '•');
      return P.a(str + getLastFourDigitsOfCardNumber(), false, CardType.fromCardNumber(this.cardNumber));
    }
    return "";
  }

  public boolean isExpiryValid()
  {
    int i = this.expiryMonth;
    int j = this.expiryYear;
    if ((i <= 0) || (12 < i));
    int k;
    int m;
    do
    {
      return false;
      Calendar localCalendar = Calendar.getInstance();
      k = localCalendar.get(1);
      m = 1 + localCalendar.get(2);
    }
    while ((j < k) || ((j == k) && (i < m)) || (j > k + 15));
    return true;
  }

  List toNameValueList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("card_number", this.cardNumber));
    if ((this.expiryMonth > 0) && (this.expiryYear > 0))
    {
      localArrayList.add(new BasicNameValuePair("card_exp_month", String.valueOf(this.expiryMonth)));
      localArrayList.add(new BasicNameValuePair("card_exp_year", String.valueOf(this.expiryYear)));
    }
    if (this.cvv != null)
      localArrayList.add(new BasicNameValuePair("card_cvv", this.cvv));
    if (this.zip != null)
      localArrayList.add(new BasicNameValuePair("card_zip", this.zip));
    if (this.postalCode != null)
      localArrayList.add(new BasicNameValuePair("card_postal_code", this.postalCode));
    if (this.scanId != null)
      localArrayList.add(new BasicNameValuePair("scan_id", this.scanId));
    return localArrayList;
  }

  public String toString()
  {
    String str = "{" + getCardType() + ": " + getRedactedCardNumber();
    if ((this.expiryMonth > 0) || (this.expiryYear > 0))
      str = str + "  expiry:" + this.expiryMonth + "/" + this.expiryYear;
    if (this.zip != null)
      str = str + "  zip:" + this.zip;
    if (this.postalCode != null)
      str = str + "  postalCode:" + this.postalCode;
    StringBuilder localStringBuilder;
    if (this.cvv != null)
    {
      localStringBuilder = new StringBuilder().append(str).append("  cvvLength:");
      if (this.cvv == null)
        break label229;
    }
    label229: for (int i = this.cvv.length(); ; i = 0)
    {
      str = i;
      return str + "}";
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.cardNumber);
    paramParcel.writeInt(this.expiryMonth);
    paramParcel.writeInt(this.expiryYear);
    paramParcel.writeString(this.cvv);
    paramParcel.writeString(this.postalCode);
    paramParcel.writeString(this.scanId);
    paramParcel.writeInt(this.yoff);
    paramParcel.writeIntArray(this.xoff);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.CreditCard
 * JD-Core Version:    0.6.2
 */