package net.photopay.recognition;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.photopay.util.Log;

public class RecognitionData
  implements Parcelable
{
  public static final String ACCOUNT_NUMBER = "Account";
  public static final String AMOUNT = "Amount";
  public static final String BANK_CODE = "BankCode";
  public static final String BANK_NAME = "BankName";
  public static final String BARCODE_DATA = "BarcodeData";
  public static final String BELEGNUMMER = "Belegart";
  public static final String BIC = "BIC";
  public static final String BILL_NUMBER = "BillNumber";
  public static final String CODE128_RESULT = "code128";
  public static final String CODE39_RESULT = "code39";
  public static final String CONTRACT_ACCOUNT = "Vertragskonto";
  public static final Parcelable.Creator CREATOR = new RecognitionData.1();
  public static final String CURRENCY = "Currency";
  public static final String CUSTOMER_DATA = "CustomerData";
  public static final String CUSTOMER_NUMBER = "CustomerNumber";
  public static final String DISPLAY_DATA = "DisplayData";
  public static final String DUE_DATE = "DueDate";
  public static final String FORM_ID = "FormID";
  public static final String IBAN = "IBAN";
  public static final String LIBINFO = "LibInfo";
  public static final String PAYBULL_URL = "PayBullURL";
  public static final String PAYER_ACCOUNT_NUMBER = "PayerAccount";
  public static final String PAYER_BANK_CODE = "PayerBankCode";
  public static final String PAYER_IBAN = "PayerIBAN";
  public static final String PAYER_ID = "PayerID";
  public static final String PAYER_NAME = "PayerName";
  public static final String PAYER_REFERENCE = "PayerReference";
  public static final String PAYER_REFERENCE_MODEL = "PayerReferenceModel";
  public static final String PAYMENT_DESCRIPTION = "PaymentDescription";
  public static final String PAYMENT_DESCRIPTION_CODE = "PaymentDescriptionCode";
  public static final String PDF417_RESULT = "pdf417";
  public static final String PHOTOMATH_DATA = "PhotoMathData";
  public static final String PRUFZIFFER = "Prufziffer";
  public static final String PURPOSE_CODE = "PurposeCode";
  public static final String RAW_RESULT = "rawResult";
  public static final String RECIPIENT_ADDRESS = "RecipientAddress";
  public static final String RECIPIENT_DETAILED_ADDRESS = "RecipientDetailedAddress";
  public static final String RECIPIENT_NAME = "RecipientName";
  public static final String RECOGNITIONDATA_TYPE = "PaymentDataType";
  public static final String REFERENCE = "Reference";
  public static final String REFERENCE_MODEL = "ReferenceModel";
  public static final String REFERENCE_STATUS = "ReferenceStatus";
  public static final String SLIP_ID = "SlipID";
  public static final String SORT_CODE = "SortingCode";
  public static final String TAX_NUMBER = "TaxNumber";
  public static final String TRANSACTION_CODE = "TransactionCode";
  protected Map mElements;
  protected boolean mEmpty = true;
  protected boolean mValid = false;

  protected RecognitionData()
  {
  }

  protected RecognitionData(Parcel paramParcel)
  {
    this.mElements = new HashMap();
    int i = paramParcel.readInt();
    for (int j = 0; j < i; j++)
    {
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      this.mElements.put(str1, str2);
    }
    boolean[] arrayOfBoolean = new boolean[2];
    paramParcel.readBooleanArray(arrayOfBoolean);
    this.mValid = arrayOfBoolean[0];
    this.mEmpty = arrayOfBoolean[1];
  }

  public RecognitionData(Map paramMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mValid = paramBoolean2;
    this.mEmpty = paramBoolean1;
    this.mElements = paramMap;
    if (this.mElements == null)
      throw new NullPointerException("Elements map cannot be null");
  }

  public int describeContents()
  {
    return 0;
  }

  public String getElement(String paramString)
  {
    String str = (String)this.mElements.get(paramString);
    if (str == null)
      str = "";
    return str;
  }

  public Map getElements()
  {
    return this.mElements;
  }

  public BigDecimal getParsedAmount()
  {
    String str = (String)this.mElements.get("Amount");
    Object localObject;
    if ((str == null) || (str.equals("")))
      localObject = new BigDecimal(0);
    while (true)
    {
      return localObject;
      BigDecimal localBigDecimal = new BigDecimal(str);
      if ("Ft".equals(this.mElements.get("Currency")))
      {
        localObject = localBigDecimal;
        continue;
      }
      localObject = localBigDecimal.divide(new BigDecimal(100));
    }
  }

  public boolean isEmpty()
  {
    return this.mEmpty;
  }

  public boolean isValid()
  {
    return this.mValid;
  }

  public void log()
  {
    Iterator localIterator = this.mElements.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = str;
      arrayOfObject3[1] = this.mElements.get(str);
      Log.d(this, "{}: {}", arrayOfObject3);
    }
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Boolean.valueOf(this.mValid);
    Log.d(this, "Valid: {}", arrayOfObject1);
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Boolean.valueOf(this.mEmpty);
    Log.d(this, "Empty: {}", arrayOfObject2);
  }

  protected String resolveUIName(Map paramMap, String paramString)
  {
    String str = (String)paramMap.get(paramString);
    if (str == null);
    while (true)
    {
      return paramString;
      paramString = str;
    }
  }

  public void toStringList(Map paramMap, List paramList1, List paramList2)
  {
    if (((String)this.mElements.get("PaymentDataType")).equalsIgnoreCase("US Driver's License"))
    {
      String str6 = (String)this.mElements.get("pdf417");
      if ((str6 != null) && (!str6.equals("")))
      {
        paramList1.add("pdf417");
        paramList2.add(str6);
      }
      String str7 = (String)this.mElements.get("code39");
      if ((str7 != null) && (!str7.equals("")))
      {
        paramList1.add("code39");
        paramList2.add(str7);
      }
      String str8 = (String)this.mElements.get("code128");
      if ((str8 != null) && (!str8.equals("")))
      {
        paramList1.add("code128");
        paramList2.add(str8);
      }
    }
    Iterator localIterator;
    do
    {
      return;
      localIterator = this.mElements.keySet().iterator();
    }
    while (!localIterator.hasNext());
    String str1 = (String)localIterator.next();
    String str2 = (String)this.mElements.get(str1);
    if (str1.equals("Amount"))
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = this.mElements.get(str1);
      Log.i(this, "string amount: {}", arrayOfObject1);
    }
    while (true)
    {
      try
      {
        int k = Integer.parseInt((String)this.mElements.get(str1));
        j = k;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(j);
        Log.i(this, "int amount: {}", arrayOfObject2);
        if (!"Ft".equals(this.mElements.get("Currency")))
          continue;
        Locale localLocale2 = Locale.US;
        String str5 = "%d " + (String)this.mElements.get("Currency");
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = Integer.valueOf(j);
        str2 = String.format(localLocale2, str5, arrayOfObject4);
        if (str1.equals("rawResult"))
          break;
        String str3 = resolveUIName(paramMap, str1);
        if (str3 == null)
          break;
        paramList1.add(str3);
        paramList2.add(str2);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int j = 0;
        continue;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("%d,%02d ");
        localStringBuilder2.append((String)this.mElements.get("Currency"));
        Locale localLocale1 = Locale.US;
        String str4 = localStringBuilder2.toString();
        Object[] arrayOfObject3 = new Object[2];
        arrayOfObject3[0] = Integer.valueOf(j / 100);
        arrayOfObject3[1] = Integer.valueOf(j % 100);
        str2 = String.format(localLocale1, str4, arrayOfObject3);
        continue;
      }
      if (!str1.equals("IBAN"))
        continue;
      StringBuilder localStringBuilder1 = new StringBuilder();
      for (int i = 0; i < str2.length(); i++)
      {
        localStringBuilder1.append(str2.charAt(i));
        if (i % 4 != 3)
          continue;
        localStringBuilder1.append(' ');
      }
      str2 = localStringBuilder1.toString().trim();
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (this.mElements != null)
    {
      paramParcel.writeInt(this.mElements.keySet().size());
      Iterator localIterator = this.mElements.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramParcel.writeString(str);
        paramParcel.writeString((String)this.mElements.get(str));
      }
    }
    paramParcel.writeInt(0);
    boolean[] arrayOfBoolean = new boolean[2];
    arrayOfBoolean[0] = this.mValid;
    arrayOfBoolean[1] = this.mEmpty;
    paramParcel.writeBooleanArray(arrayOfBoolean);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.RecognitionData
 * JD-Core Version:    0.6.0
 */