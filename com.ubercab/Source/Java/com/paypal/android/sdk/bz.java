package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.card.payment.CardType;
import java.util.Date;

public final class bz extends by
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new bA();
  private String b;
  private Date c;
  private String d;
  private CardType e;
  private int f;
  private int g;

  public bz()
  {
  }

  private bz(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.d = paramParcel.readString();
    this.c = ((Date)paramParcel.readSerializable());
    this.e = ((CardType)paramParcel.readSerializable());
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
  }

  public bz(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    this.a = paramString2;
    this.b = paramString1;
    this.c = v.a(paramString3);
    c(paramString4);
    d(paramString5);
    this.f = paramInt1;
    this.g = paramInt2;
  }

  public bz(String paramString1, String paramString2, Date paramDate, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    this.a = a(paramString2);
    this.b = paramString1;
    this.c = paramDate;
    c(paramString3);
    d(paramString4);
    this.f = paramInt1;
    this.g = paramInt2;
  }

  public static String b(String paramString)
  {
    if (paramString == null)
      return null;
    return "x-" + paramString.substring(-4 + paramString.length());
  }

  private void c(String paramString)
  {
    if (paramString != null)
    {
      this.d = paramString.substring(-4 + paramString.length());
      return;
    }
    this.d = null;
  }

  private void d(String paramString)
  {
    this.e = CardType.fromString(paramString);
  }

  public final boolean c()
  {
    return (!R.a(this.b)) && (!R.a(this.d)) && (!R.a(this.a)) && (this.c != null) && (!this.c.before(new Date())) && (this.e != null) && (this.e != CardType.UNKNOWN) && (this.f > 0) && (this.f <= 12) && (this.g >= 0) && (this.g <= 9999);
  }

  public final Date d()
  {
    return this.c;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String e()
  {
    return b(this.d);
  }

  public final String f()
  {
    return this.b;
  }

  public final CardType g()
  {
    return this.e;
  }

  public final int h()
  {
    return this.f;
  }

  public final int i()
  {
    return this.g;
  }

  public final String toString()
  {
    return "TokenizedCreditCard(token=" + this.b + ",lastFourDigits=" + this.d + ",payerId=" + this.a + ",tokenValidUntil=" + this.c + ",cardType=" + this.e + ",expiryMonth/year=" + this.f + "/" + this.g + ")";
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.d);
    paramParcel.writeSerializable(this.c);
    paramParcel.writeSerializable(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.bz
 * JD-Core Version:    0.6.2
 */