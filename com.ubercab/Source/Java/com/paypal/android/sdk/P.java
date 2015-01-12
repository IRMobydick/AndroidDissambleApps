package com.paypal.android.sdk;

import java.util.Calendar;

public final class P extends al
{
  private final R a;

  public P(L paramL, d paramd, h paramh, R paramR)
  {
    super(a.a, paramL, paramd, paramh);
    this.a = paramR;
  }

  public final String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(4);
    long l = -((localCalendar.get(15) + localCalendar.get(16)) / 60000);
    localStringBuilder1.append(Integer.toString(localCalendar.get(5))).append("/").append(Integer.toString(localCalendar.get(2))).append("/").append(Integer.toString(localCalendar.get(1))).append(" ").append(Integer.toString(localCalendar.get(11))).append(":").append(Integer.toString(localCalendar.get(12))).append(":").append(Integer.toString(localCalendar.get(13))).append(" ").append(Integer.toString(i)).append(" ").append(Long.toString(l));
    String str1 = localStringBuilder1.toString();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("s").append(this.a.a).append("?AQB=1").append("&ndh=1").append("&t" + R.b(str1));
    String str2 = R.b(b.a().c().e().replace("-", ""));
    localStringBuilder2.append("&ch=" + R.b(this.a.c)).append("&sv=" + this.a.d).append("&vid=" + str2);
    R.a(this.a.b, localStringBuilder2);
    localStringBuilder2.append("&AQE=1");
    return localStringBuilder2.toString();
  }

  public final String a(a parama)
  {
    return "https://paypal.112.2o7.net/b/ss/paypalglobal/0/OIP-2.1.6/";
  }

  public final void b()
  {
  }

  public final void c()
  {
  }

  public final String d()
  {
    return "mockSiteCatalystResponse";
  }

  public final boolean e()
  {
    return true;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.P
 * JD-Core Version:    0.6.2
 */