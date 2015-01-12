package com.paypal.android.sdk;

import io.card.payment.CardType;

public final class bu
{
  private c a;
  private String b;
  private w c;

  static
  {
    if (!bu.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      d = bool;
      return;
    }
  }

  public bu(c paramc, String paramString)
  {
    if ((!d) && (paramc == null))
      throw new AssertionError();
    this.a = paramc;
    this.b = ("com.paypal.android.sdk." + paramString + ".");
    this.c = new w(n.b() + i.b());
  }

  public final bv a()
  {
    String str1 = this.a.a(this.b + "loginPhoneNumber", null);
    if (str1 != null);
    while (true)
    {
      String str3;
      try
      {
        t localt2 = t.a(br.d(), str1);
        localt1 = localt2;
        String str2 = this.a.a(this.b + "loginEmail", null);
        str3 = this.a.a(this.b + "loginTypePrevious", null);
        if (!R.a(str3))
          break label163;
        localbx = null;
        bv localbv1 = new bv(str2, localt1, localbx);
        boolean bool = localbv1.d();
        bv localbv2 = null;
        if (bool)
          localbv2 = localbv1;
        return localbv2;
      }
      catch (x localx)
      {
      }
      t localt1 = null;
      continue;
      label163: bx localbx = bx.valueOf(str3);
    }
  }

  public final bz a(String paramString)
  {
    String str1 = this.a.a(this.b + "tokenizedRedactedCardNumber", null);
    String str2 = this.a.a(this.b + "token", null);
    String str3 = this.a.a(this.b + "tokenPayerID", null);
    String str4 = this.a.a(this.b + "tokenValidUntil", null);
    String str5 = this.a.a(this.b + "tokenizedCardType", null);
    int i = Integer.parseInt(this.a.a(this.b + "tokenizedCardExpiryMonth", "1"));
    int j = Integer.parseInt(this.a.a(this.b + "tokenizedCardExpiryYear", "0"));
    String str6 = this.c.b(this.a.a(this.b + "tokenClientId", null));
    bz localbz;
    if ((R.c(str6)) || (!str6.equals(paramString)))
      localbz = null;
    do
    {
      return localbz;
      localbz = new bz(str2, str3, str4, str1, str5, i, j);
    }
    while (localbz.c());
    return null;
  }

  public final void a(bv parambv)
  {
    if (parambv.a() != null);
    for (String str1 = parambv.a().b(); ; str1 = null)
    {
      this.a.b(this.b + "loginPhoneNumber", str1);
      this.a.b(this.b + "loginEmail", parambv.b());
      bx localbx = parambv.c();
      String str2 = null;
      if (localbx != null)
        str2 = parambv.c().toString();
      this.a.b(this.b + "loginTypePrevious", str2);
      return;
    }
  }

  public final void a(bz parambz, String paramString)
  {
    this.a.b(this.b + "token", parambz.f());
    this.a.b(this.b + "tokenPayerID", parambz.a());
    if (parambz.d() != null);
    for (String str1 = new v().format(parambz.d()); ; str1 = null)
    {
      this.a.b(this.b + "tokenValidUntil", str1);
      this.a.b(this.b + "tokenizedRedactedCardNumber", parambz.e());
      CardType localCardType = parambz.g();
      String str2 = null;
      if (localCardType != null)
        str2 = parambz.g().toString();
      this.a.b(this.b + "tokenizedCardType", str2);
      this.a.b(this.b + "tokenizedCardExpiryMonth", String.valueOf(parambz.h()));
      this.a.b(this.b + "tokenizedCardExpiryYear", String.valueOf(parambz.i()));
      this.a.b(this.b + "tokenClientId", this.c.a(paramString));
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.bu
 * JD-Core Version:    0.6.2
 */