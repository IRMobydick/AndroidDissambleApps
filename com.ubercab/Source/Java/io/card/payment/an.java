package io.card.payment;

import android.content.Intent;
import java.util.Iterator;
import java.util.List;

public final class an
{
  private static final j a = new j(ao.class);

  static
  {
    Iterator localIterator = B.a.iterator();
    while (localIterator.hasNext())
    {
      k localk = (k)localIterator.next();
      a.a(localk);
    }
  }

  public static String a(ao paramao)
  {
    return a.a(paramao);
  }

  public static String a(ao paramao, String paramString)
  {
    return a.a(paramao, a.b(paramString));
  }

  public static void a(Intent paramIntent)
  {
    a.a(paramIntent.getStringExtra("io.card.payment.languageOrLocale"));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.an
 * JD-Core Version:    0.6.2
 */