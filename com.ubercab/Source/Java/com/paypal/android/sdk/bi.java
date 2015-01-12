package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.List;

public final class bi
{
  private static bi c;
  private List a = new ArrayList();
  private List b = new ArrayList();

  public static bi a()
  {
    if (c == null)
      c = new bi();
    return c;
  }

  private void b()
  {
    if (!this.b.isEmpty())
    {
      bh localbh = (bh)this.b.get(0);
      this.b.remove(0);
      this.a.add(localbh);
      new Thread(localbh).start();
    }
  }

  public final void a(bh parambh)
  {
    this.b.add(parambh);
    if (this.a.size() < 3)
      b();
  }

  public final void b(bh parambh)
  {
    this.a.remove(parambh);
    b();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.bi
 * JD-Core Version:    0.6.2
 */