package com.google.a.a.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.g;
import com.google.android.gms.internal.hh;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public final class a
  implements com.google.android.gms.ads.c.c, com.google.android.gms.ads.c.e
{
  private com.google.android.gms.ads.f a;
  private g b;

  private static com.google.android.gms.ads.b a(Context paramContext, com.google.android.gms.ads.c.a parama, Bundle paramBundle1, Bundle paramBundle2)
  {
    com.google.android.gms.ads.d locald = new com.google.android.gms.ads.d();
    Date localDate = parama.a();
    if (localDate != null)
      locald.a(localDate);
    int i = parama.b();
    if (i != 0)
      locald.a(i);
    Set localSet = parama.c();
    if (localSet != null)
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
        locald.a((String)localIterator.next());
    }
    if (parama.d())
      locald.b(hh.a(paramContext));
    boolean bool;
    if (paramBundle2.getInt("tagForChildDirectedTreatment") != -1)
    {
      if (paramBundle2.getInt("tagForChildDirectedTreatment") == 1)
      {
        bool = true;
        locald.a(bool);
      }
    }
    else
      if (paramBundle1 == null)
        break label228;
    while (true)
    {
      paramBundle1.putInt("gw", 1);
      paramBundle1.putString("mad_hac", paramBundle2.getString("mad_hac"));
      if (!TextUtils.isEmpty(paramBundle2.getString("adJson")))
        paramBundle1.putString("_ad", paramBundle2.getString("adJson"));
      paramBundle1.putBoolean("_noRefresh", true);
      locald.a(a.class, paramBundle1);
      return locald.a();
      bool = false;
      break;
      label228: paramBundle1 = new Bundle();
    }
  }

  public void a()
  {
    if (this.a != null)
    {
      this.a.a();
      this.a = null;
    }
    if (this.b != null)
      this.b = null;
  }

  public void a(Context paramContext, com.google.android.gms.ads.c.d paramd, Bundle paramBundle1, com.google.android.gms.ads.e parame, com.google.android.gms.ads.c.a parama, Bundle paramBundle2)
  {
    this.a = new com.google.android.gms.ads.f(paramContext);
    this.a.setAdSize(new com.google.android.gms.ads.e(parame.b(), parame.a()));
    this.a.setAdUnitId(paramBundle1.getString("pubid"));
    this.a.setAdListener(new b(this, paramd));
    this.a.a(a(paramContext, parama, paramBundle2, paramBundle1));
  }

  public void a(Context paramContext, com.google.android.gms.ads.c.f paramf, Bundle paramBundle1, com.google.android.gms.ads.c.a parama, Bundle paramBundle2)
  {
    this.b = new g(paramContext);
    this.b.a(paramBundle1.getString("pubid"));
    this.b.a(new c(this, paramf));
    this.b.a(a(paramContext, parama, paramBundle2, paramBundle1));
  }

  public void b()
  {
    if (this.a != null)
      this.a.b();
  }

  public void c()
  {
    if (this.a != null)
      this.a.c();
  }

  public View d()
  {
    return this.a;
  }

  public void e()
  {
    this.b.b();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.a.a.a.a
 * JD-Core Version:    0.6.0
 */