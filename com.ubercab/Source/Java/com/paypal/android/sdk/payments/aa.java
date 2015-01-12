package com.paypal.android.sdk.payments;

import android.util.Log;
import com.paypal.android.sdk.C;
import com.paypal.android.sdk.J;
import com.paypal.android.sdk.T;
import com.paypal.android.sdk.U;
import com.paypal.android.sdk.W;
import com.paypal.android.sdk.ac;
import com.paypal.android.sdk.am;
import com.paypal.android.sdk.b;
import com.paypal.android.sdk.bE;
import com.paypal.android.sdk.bm;
import com.paypal.android.sdk.br;
import com.paypal.android.sdk.bs;
import com.paypal.android.sdk.bt;
import com.paypal.android.sdk.bu;
import com.paypal.android.sdk.bv;
import com.paypal.android.sdk.bx;
import com.paypal.android.sdk.bz;
import com.paypal.android.sdk.o;
import com.paypal.android.sdk.t;
import java.util.UUID;

final class aa extends C
{
  public aa(PayPalService paramPayPalService, J paramJ)
  {
    super(paramJ);
    a();
  }

  private static bm a(String paramString, long paramLong)
  {
    return new bm(paramString, 1000L * paramLong + System.currentTimeMillis(), true);
  }

  public final void a(T paramT)
  {
    PayPalService.v();
    this.a.a(bE.u, paramT.y());
    PayPalService.e(this.a).a(paramT.a);
    PayPalService.e(this.a).a();
  }

  public final void a(U paramU)
  {
    PayPalService.v();
    this.a.a(bE.j, paramU.y(), paramU.p());
    ProofOfPayment localProofOfPayment = new ProofOfPayment(paramU.o(), paramU.p(), paramU.r(), paramU.q(), paramU.s());
    PayPalService.e(this.a).a(localProofOfPayment);
    if ((paramU.f() == null) || (!paramU.m()));
    for (int i = 1; i != 0; i = 0)
    {
      if (!paramU.m())
        this.a.q();
      PayPalService.e(this.a).a();
      return;
    }
    String str = UUID.randomUUID().toString();
    this.a.a().a(this.a.b().c.b(), str, paramU.g(), paramU.f(), paramU.h(), paramU.i(), paramU.j());
  }

  public final void a(W paramW)
  {
    long l1 = 840L;
    PayPalService.v();
    long l2 = paramW.f;
    if (l2 > l1);
    while (true)
    {
      this.a.b().h = a(paramW.e, l1);
      this.a.b().f = paramW.d;
      this.a.b().g = paramW.c;
      bv localbv = new bv();
      if (paramW.a.a())
      {
        localbv.a(paramW.a.b());
        localbv.a(bx.a);
        this.a.b().e = localbv;
        if (!paramW.a.a())
          break label226;
        this.a.b().d = paramW.a.b();
        this.a.a(bE.l, Boolean.valueOf(paramW.b), paramW.y());
      }
      while (true)
      {
        if (PayPalService.c(this.a) == null)
          break label273;
        PayPalService.b(this.a, false);
        PayPalService.c(this.a).a();
        this.a.l();
        return;
        localbv.a(paramW.a.d());
        localbv.a(bx.b);
        break;
        label226: this.a.b().d = paramW.a.d().a(br.d());
        this.a.a(bE.m, Boolean.valueOf(paramW.b), paramW.y());
      }
      label273: PayPalService.b(this.a, true);
      return;
      l1 = l2;
    }
  }

  public final void a(com.paypal.android.sdk.Y paramY)
  {
    PayPalService.v();
    this.a.a(bE.j, paramY.y(), paramY.p());
    if ((!paramY.m()) || ((this.a.b().h != null) && (!this.a.b().h.a())))
      this.a.f();
    while (true)
    {
      ProofOfPayment localProofOfPayment = new ProofOfPayment(paramY.o(), paramY.p(), paramY.r(), paramY.q(), paramY.s());
      PayPalService.e(this.a).a(localProofOfPayment);
      PayPalService.e(this.a).a();
      return;
      bt.a(this.a.b().h, this.a.d());
      if (this.a.b().e != null)
        PayPalService.a(this.a, this.a.b().e);
    }
  }

  public final void a(com.paypal.android.sdk.aa paramaa)
  {
    PayPalService.v();
    this.a.a(bE.b, paramaa.y());
    this.a.b().c = a(paramaa.a, paramaa.b);
    PayPalService.a(this.a, false);
    if (PayPalService.b(this.a) != null)
    {
      PayPalService.v();
      PayPalService.b(this.a).a();
      PayPalService.a(this.a, null);
    }
  }

  public final void a(ac paramac)
  {
    PayPalService.v();
    bz localbz = new bz(paramac.f(), paramac.a, paramac.h(), paramac.g(), paramac.i(), paramac.j(), paramac.k());
    new bu(b.a().c(), this.a.d()).a(localbz, PayPalService.a(this.a).k());
    PayPalService.e(this.a).a();
  }

  public final void b(T paramT)
  {
    String str = paramT.C().a();
    PayPalService.v();
    new StringBuilder("GrantConsentRequest Error:").append(str).toString();
    Log.e(PayPalService.v(), str);
    PayPalService.e(this.a).a(PayPalService.b(this.a, paramT));
  }

  public final void b(U paramU)
  {
    PayPalService.v();
    PayPalService.c(this.a, paramU);
  }

  public final void b(W paramW)
  {
    String str = paramW.C().a();
    Log.e(PayPalService.v(), str);
    this.a.f();
    o localo = paramW.a;
    boolean bool = paramW.b;
    if (localo.a())
      PayPalService.a(this.a, bE.l, bool, str, paramW.y(), null);
    while (true)
    {
      PayPalService.d(this.a);
      if (PayPalService.c(this.a) == null)
        break;
      PayPalService.b(this.a, false);
      PayPalService.c(this.a).a(PayPalService.b(this.a, paramW));
      return;
      PayPalService.a(this.a, bE.m, bool, str, paramW.y(), null);
    }
    PayPalService.b(this.a, true);
    PayPalService.a(this.a, PayPalService.b(this.a, paramW));
  }

  public final void b(com.paypal.android.sdk.Y paramY)
  {
    PayPalService.v();
    PayPalService.c(this.a, paramY);
  }

  public final void b(com.paypal.android.sdk.aa paramaa)
  {
    PayPalService.a(this.a, paramaa);
  }

  public final void b(ac paramac)
  {
    String str = paramac.C().a();
    PayPalService.v();
    new StringBuilder("TokenizeCreditCardRequest Error:").append(str).toString();
    Log.e(PayPalService.v(), str);
    PayPalService.e(this.a).a();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.aa
 * JD-Core Version:    0.6.2
 */