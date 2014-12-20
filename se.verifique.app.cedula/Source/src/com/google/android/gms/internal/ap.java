package com.google.android.gms.internal;

import java.util.Map;

public final class ap
  implements bb
{
  private final aq a;

  public ap(aq paramaq)
  {
    this.a = paramaq;
  }

  public void a(hk paramhk, Map paramMap)
  {
    String str = (String)paramMap.get("name");
    if (str == null)
      hi.e("App event with no name parameter.");
    while (true)
    {
      return;
      this.a.a(str, (String)paramMap.get("info"));
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ap
 * JD-Core Version:    0.6.0
 */