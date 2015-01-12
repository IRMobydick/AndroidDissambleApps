package com.inauth.utilities;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

public class InAuthDynamicID
{
  String A1 = null;
  String A2 = null;
  String A3 = null;
  String A4 = null;
  String B1 = null;
  String B2 = null;
  String B3 = null;
  String B4 = null;
  String C1 = null;
  String C2 = null;
  String D = null;
  String dynamicID = null;
  String part0 = null;

  private int RandomBetween(int paramInt1, int paramInt2)
  {
    return paramInt1 + (int)Math.round(Math.random() * (paramInt2 - paramInt1));
  }

  private long getRandomDate()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", Locale.getDefault());
    int i = RandomBetween(1985, 2011);
    int j = RandomBetween(0, 11);
    int k = RandomBetween(0, 23);
    int m = RandomBetween(0, 59);
    int n = RandomBetween(0, 59);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(i, j, 1);
    localGregorianCalendar.set(i, j, RandomBetween(1, localGregorianCalendar.getActualMaximum(5)), k, m, n);
    return Timestamp.valueOf(localSimpleDateFormat.format(localGregorianCalendar.getTime())).getTime();
  }

  private String randomnum()
  {
    return String.valueOf(100000 + (int)(899900.0F * new Random().nextFloat()));
  }

  private String randomnum(int paramInt1, int paramInt2)
  {
    int i = new Random().nextInt(paramInt2);
    if (i < 101)
      i += paramInt1;
    return String.valueOf(i);
  }

  public String getDynamicID()
  {
    long l1 = getValidateCode4UploadFile();
    long l2 = getRandomDate();
    long l3 = l2 - 469975872149L;
    long l4 = l1 - l2;
    long l5 = getJulianFromUnix(l1);
    this.part0 = randomnum();
    this.A1 = randomnum(101, 999);
    this.A2 = getRandomBigInteger((int)Math.sqrt(Float.parseFloat(this.A1)));
    int i = Long.toString(l3).length();
    int j;
    if (i <= 9)
    {
      this.A3 = ("0" + Integer.toString(i));
      this.A4 = Long.toString(l3);
      this.B1 = randomnum(101, 999);
      this.B2 = getRandomBigInteger((int)Math.sqrt(Float.parseFloat(this.B1)));
      j = Long.toString(l4).length();
      if (j > 9)
        break label459;
    }
    label459: for (this.B3 = ("0" + Integer.toString(j)); ; this.B3 = Integer.toString(j))
    {
      this.B4 = Long.toString(l4);
      this.C1 = randomnum(101, 999);
      this.C2 = Long.toString(l5 * (int)Math.sqrt(Float.parseFloat(this.C1)));
      this.D = getRandomBigInteger(120 - (this.part0.length() + this.A1.length() + this.A2.length() + this.A3.length() + this.A4.length() + this.B1.length() + this.B2.length() + this.B3.length() + this.B4.length() + this.C1.length() + this.C2.length()));
      this.dynamicID = (this.part0 + this.A1 + this.A2 + this.A3 + this.A4 + this.B1 + this.B2 + this.B3 + this.B4 + this.C1 + this.C2 + this.D);
      return this.dynamicID;
      this.A3 = Integer.toString(i);
      break;
    }
  }

  int getJulianFromUnix(long paramLong)
  {
    return (int)(2440587.5D + paramLong / 86400.0D / 1000.0D);
  }

  public String getRandomBigInteger(int paramInt)
  {
    String str = "";
    for (int i = 0; i < paramInt; i++)
    {
      char c = Double.toString(10.0D * Math.random()).charAt(0);
      str = str + c;
    }
    return str;
  }

  public long getValidateCode4UploadFile()
  {
    return System.currentTimeMillis();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.utilities.InAuthDynamicID
 * JD-Core Version:    0.6.2
 */