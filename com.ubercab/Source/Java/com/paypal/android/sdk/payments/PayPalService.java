package com.paypal.android.sdk.payments;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.paypal.android.sdk.J;
import com.paypal.android.sdk.aW;
import com.paypal.android.sdk.ak;
import com.paypal.android.sdk.al;
import com.paypal.android.sdk.am;
import com.paypal.android.sdk.b;
import com.paypal.android.sdk.bE;
import com.paypal.android.sdk.bF;
import com.paypal.android.sdk.bb;
import com.paypal.android.sdk.bm;
import com.paypal.android.sdk.br;
import com.paypal.android.sdk.bs;
import com.paypal.android.sdk.bt;
import com.paypal.android.sdk.bu;
import com.paypal.android.sdk.bv;
import com.paypal.android.sdk.bz;
import com.paypal.android.sdk.c;
import com.paypal.android.sdk.d;
import com.paypal.android.sdk.g;
import com.paypal.android.sdk.o;
import com.paypal.android.sdk.q;
import io.card.payment.CardType;
import io.card.payment.CreditCard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class PayPalService extends Service
{
  public static final String EXTRA_PAYPAL_CONFIGURATION = "com.paypal.android.sdk.paypalConfiguration";
  private static final String b = PayPalService.class.getSimpleName();
  private static boolean c = true;
  private static boolean d = true;
  private static boolean e = true;
  private static Intent v;
  bz a;
  private d f;
  private bs g;
  private PayPalConfiguration h;
  private boolean i;
  private boolean j;
  private Z k;
  private a l = new a();
  private l m = new i(this);
  private String n;
  private J o;
  private Y p;
  private X q;
  private String r;
  private List s = new ArrayList();
  private boolean t = c;
  private boolean u = d;
  private aa w;
  private final IBinder x = new W(this);

  private void A()
  {
    a(new bv());
  }

  private Z a(al paramal)
  {
    return new Z(this, paramal.C().a(), paramal.E());
  }

  private void a(Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getExtras() == null))
      throw new RuntimeException("Service extras required. Please see the docs.");
    v = paramIntent;
    new StringBuilder("init:").append(paramIntent.toString()).append(" with extras:").append(paramIntent.getExtras()).toString();
    Iterator localIterator = paramIntent.getExtras().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      new StringBuilder("==SERVICE EXTRA:(").append(str3).append(",").append(paramIntent.getExtras().get(str3)).append(")").toString();
    }
    if (this.h == null)
    {
      this.h = ((PayPalConfiguration)paramIntent.getParcelableExtra("com.paypal.android.sdk.paypalConfiguration"));
      if (this.h == null)
        throw new RuntimeException("Missing EXTRA_PAYPAL_CONFIGURATION in service intent. Please see the docs.");
    }
    if (!this.h.o())
      throw new RuntimeException("Service extras invalid.  Please check the docs.");
    String str1 = this.h.b();
    String str2;
    if (str1.equals("live"))
      str2 = "https://api.paypal.com/v1/";
    g localg;
    while (true)
    {
      localg = new g();
      localg.a(str1);
      localg.a(new HashMap());
      if (str2 == null)
        break label662;
      if (str2.startsWith("https://"))
        break label358;
      throw new RuntimeException(str2 + " does not start with 'https://', ignoring " + str1);
      if (str1.startsWith("sandbox"))
      {
        str2 = "https://api.sandbox.paypal.com/v1/";
      }
      else
      {
        if (!str1.equals("mock"))
          break;
        str2 = null;
      }
    }
    throw new RuntimeException("Invalid environment selected:" + str1);
    label358: if (!str2.endsWith("/"))
    {
      Log.w(b, str2 + " does not end with a slash, adding one.");
      str2 = str2 + "/";
    }
    localg.b().put(com.paypal.android.sdk.a.c, str2 + "oauth2/token");
    localg.b().put(com.paypal.android.sdk.a.d, str2 + "oauth2/login");
    localg.b().put(com.paypal.android.sdk.a.e, str2 + "oauth2/consent");
    localg.b().put(com.paypal.android.sdk.a.f, str2 + "payments/payment");
    localg.b().put(com.paypal.android.sdk.a.g, str2 + "payments/payment");
    localg.b().put(com.paypal.android.sdk.a.h, str2 + "vault/credit-card");
    localg.b().put(com.paypal.android.sdk.a.i, str2 + "vault/credit-card");
    label662: if (this.o == null)
    {
      this.t = c;
      boolean bool = e;
      this.o = new J(localg, w(), br.d(), bool, 500);
    }
    bF.b(this.h.a());
    if (this.w == null)
      this.w = new aa(this, this.o);
    if (this.g == null)
      this.g = y();
    if (!this.h.j())
    {
      q();
      f();
      A();
    }
    z();
  }

  private void a(bE parambE, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    this.m.a(parambE, paramBoolean, paramString1, paramString2, paramString3);
  }

  private void a(bv parambv)
  {
    new bu(b.a().c(), this.h.b()).a(parambv);
  }

  private static boolean a(bm parambm)
  {
    return (parambm != null) && (parambm.c());
  }

  private ak[] a(PayPalItem[] paramArrayOfPayPalItem)
  {
    if (paramArrayOfPayPalItem == null)
      return null;
    ak[] arrayOfak = new ak[paramArrayOfPayPalItem.length];
    int i1 = paramArrayOfPayPalItem.length;
    int i2 = 0;
    int i4;
    for (int i3 = 0; i2 < i1; i3 = i4)
    {
      PayPalItem localPayPalItem = paramArrayOfPayPalItem[i2];
      i4 = i3 + 1;
      arrayOfak[i3] = new ak(localPayPalItem.getName(), localPayPalItem.getQuantity(), localPayPalItem.getPrice(), localPayPalItem.getCurrency(), localPayPalItem.getSku());
      i2++;
    }
    return arrayOfak;
  }

  private void b(bE parambE, String paramString1, String paramString2)
  {
    a(parambE, false, paramString1, paramString2, null);
  }

  private d w()
  {
    if (this.f == null)
      this.f = new m();
    return this.f;
  }

  private boolean x()
  {
    return (this.h != null) && (this.g != null);
  }

  private static bs y()
  {
    return new bs();
  }

  private void z()
  {
    a(new U(this), false);
  }

  protected final J a()
  {
    return this.o;
  }

  final void a(bE parambE)
  {
    a(parambE, false, null, null, null);
  }

  final void a(bE parambE, Boolean paramBoolean)
  {
    a(parambE, paramBoolean.booleanValue(), null, null, null);
  }

  final void a(bE parambE, Boolean paramBoolean, String paramString)
  {
    a(parambE, paramBoolean.booleanValue(), null, paramString, null);
  }

  final void a(bE parambE, String paramString)
  {
    a(parambE, false, null, paramString, null);
  }

  final void a(bE parambE, String paramString1, String paramString2)
  {
    a(parambE, false, null, paramString1, paramString2);
  }

  final void a(o paramo, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    bm localbm = this.g.c;
    String str = null;
    if (localbm != null)
      str = this.g.c.b();
    this.o.a(paramo, str, paramBoolean1, paramString1, paramBoolean2, paramString2);
  }

  final void a(V paramV)
  {
    this.l.a(paramV);
  }

  final void a(X paramX)
  {
    if (this.j)
    {
      this.j = false;
      if (this.k != null)
      {
        paramX.a(this.k);
        this.k = null;
      }
      while (true)
      {
        l();
        return;
        paramX.a();
      }
    }
    this.q = paramX;
  }

  final void a(Y paramY, boolean paramBoolean)
  {
    if (paramBoolean)
      this.g.c = null;
    this.p = paramY;
    if (this.i);
    while (this.g.c())
      return;
    this.i = true;
    a(bE.b);
    this.o.a(this.h.k());
  }

  final void a(String paramString1, q paramq, Map paramMap, PayPalItem[] paramArrayOfPayPalItem, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    this.o.a(this.g.h.b(), paramString1, null, paramq, paramMap, a(paramArrayOfPayPalItem), paramString2, paramBoolean, paramString3, this.r, paramString4);
  }

  final void a(String paramString1, CreditCard paramCreditCard, q paramq, Map paramMap, PayPalItem[] paramArrayOfPayPalItem, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    if ((paramCreditCard.cardNumber.equalsIgnoreCase("4111111111111111")) && (this.h.b().startsWith("sandbox")))
      paramCreditCard.cardNumber = "4444333322221111";
    this.o.a(this.g.c.b(), paramString1, paramCreditCard.getCardType().toString().toLowerCase(Locale.US), paramCreditCard.cardNumber, paramCreditCard.cvv, paramCreditCard.expiryMonth, paramCreditCard.expiryYear, null, paramq, paramMap, a(paramArrayOfPayPalItem), paramString2, paramBoolean, paramString3, this.r, paramString4);
  }

  final void a(String paramString1, String paramString2, q paramq, Map paramMap, PayPalItem[] paramArrayOfPayPalItem, String paramString3, boolean paramBoolean, String paramString4, String paramString5, String paramString6)
  {
    this.o.a(this.g.c.b(), paramString1, paramString2, paramString4, paramq, paramMap, a(paramArrayOfPayPalItem), paramString3, paramBoolean, paramString5, this.r, paramString6);
  }

  final void a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((PayPalScope)localIterator.next()).getScopeUri());
    bm localbm = this.g.c;
    String str = null;
    if (localbm != null)
      str = this.g.c.b();
    this.o.a(this.h.k(), this.g.g, this.g.f, str, localArrayList);
  }

  protected final boolean a(ab paramab)
  {
    if (x())
      return true;
    if (paramab != null)
      this.s.add(paramab);
    return false;
  }

  protected final bs b()
  {
    return this.g;
  }

  final PayPalConfiguration c()
  {
    return this.h;
  }

  protected final String d()
  {
    return this.h.b();
  }

  protected final String e()
  {
    return this.h.k();
  }

  final void f()
  {
    this.g.h = null;
    bt.b(this.h.b());
    this.g.e = null;
    this.g.d = null;
  }

  final boolean g()
  {
    return this.g.c();
  }

  final boolean h()
  {
    bs localbs = this.g;
    return (localbs.h != null) && (localbs.h.c());
  }

  final boolean i()
  {
    return this.g.g != null;
  }

  final void j()
  {
    bv localbv = n();
    if (localbv == null)
    {
      f();
      return;
    }
    bm localbm1 = this.g.h;
    bm localbm2 = bt.a(this.h.b());
    if ((!a(localbm1)) && (a(localbm2)))
      this.g.h = localbm2;
    while (true)
    {
      this.g.d = localbv.e();
      return;
    }
  }

  final void k()
  {
    this.l.b();
  }

  final void l()
  {
    this.q = null;
  }

  final void m()
  {
    this.p = null;
  }

  final bv n()
  {
    return new bu(b.a().c(), this.h.b()).a();
  }

  final String o()
  {
    return this.g.d;
  }

  public final IBinder onBind(Intent paramIntent)
  {
    new aB(this).a();
    if (!x())
      a(v);
    return this.x;
  }

  public final void onCreate()
  {
    new StringBuilder("service created: ").append(this).toString();
    b localb = b.a();
    if (localb.b() == null)
      localb.a(getApplicationContext(), w().c());
    try
    {
      this.r = aW.a().a(b.a().b(), b.a().c().e(), bb.b, "2.2.2", null, false);
      aW.a().d();
      StringBuilder localStringBuilder = new StringBuilder("Initialilzed risk component: ");
      aW.a();
      localStringBuilder.append(aW.c()).toString();
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e(b, "Risk component failed to initialize, threw " + localThrowable.getMessage());
    }
  }

  public final void onDestroy()
  {
    if (this.w != null)
    {
      this.w.b();
      this.w = null;
    }
    if (this.o != null)
    {
      this.o.a();
      this.o = null;
    }
    new StringBuilder("service destroyed: ").append(this).toString();
  }

  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    new StringBuilder("onStartCommand: Received start id: ").append(paramInt2).toString();
    a(paramIntent);
    this.n = paramIntent.getComponent().getPackageName();
    a(bE.a);
    if (this.s.size() > 0)
    {
      Iterator localIterator = this.s.iterator();
      while (localIterator.hasNext())
        ((ab)localIterator.next()).a();
      this.s.clear();
    }
    return 3;
  }

  final bz p()
  {
    return new bu(b.a().c(), this.h.b()).a(this.h.k());
  }

  final void q()
  {
    this.a = p();
    new bu(b.a().c(), this.h.b()).a(new bz(), null);
    if ((this.a != null) && (this.g.c != null))
    {
      this.o.a(this.g.c.b(), this.a.f());
      this.a = null;
    }
  }

  final void r()
  {
    if ((this.h != null) && (this.h.o()))
    {
      this.g = y();
      z();
      return;
    }
  }

  protected final String s()
  {
    return this.n;
  }

  final boolean t()
  {
    return this.t;
  }

  final boolean u()
  {
    return this.u;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.PayPalService
 * JD-Core Version:    0.6.2
 */