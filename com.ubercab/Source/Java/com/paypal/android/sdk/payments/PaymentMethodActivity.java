package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.bE;
import com.paypal.android.sdk.bF;
import com.paypal.android.sdk.bG;
import com.paypal.android.sdk.bH;
import com.paypal.android.sdk.bJ;
import com.paypal.android.sdk.bM;
import com.paypal.android.sdk.bO;
import com.paypal.android.sdk.bl;
import com.paypal.android.sdk.bm;
import com.paypal.android.sdk.br;
import com.paypal.android.sdk.bs;
import com.paypal.android.sdk.bz;
import com.paypal.android.sdk.j;
import com.paypal.android.sdk.l;
import io.card.payment.CardIOActivity;
import io.card.payment.CardType;
import io.card.payment.CreditCard;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;

public final class PaymentMethodActivity extends Activity
{
  private static final String a = PaymentMethodActivity.class.getSimpleName();
  private static boolean e = false;
  private Timer b;
  private boolean c;
  private boolean d;
  private boolean f;
  private bM g;
  private ai h;
  private PayPalService i;
  private final ServiceConnection j = new az(this);
  private boolean k;

  private void a()
  {
    showDialog(3);
    this.c = true;
    this.b = new Timer();
    this.b.schedule(new aw(this), 1000L);
    this.c = true;
  }

  static void a(Activity paramActivity, int paramInt, String paramString, PayPalConfiguration paramPayPalConfiguration)
  {
    e = bF.c(paramString);
    Intent localIntent = new Intent(paramActivity, PaymentMethodActivity.class);
    localIntent.putExtras(paramActivity.getIntent());
    localIntent.putExtra("com.paypal.android.sdk.paypalConfiguration", paramPayPalConfiguration);
    paramActivity.startActivityForResult(localIntent, 1);
  }

  private void a(Bundle paramBundle)
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (localObject == null)
        String.format("%s:null", new Object[] { str });
      while (true)
      {
        break;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = str;
        arrayOfObject[1] = localObject.toString();
        arrayOfObject[2] = localObject.getClass().getName();
        String.format("%s:%s (%s)", arrayOfObject);
      }
    }
    if (n.a(paramBundle.getString("scope"), paramBundle.getString("grant_type")))
      a();
  }

  private void b()
  {
    new StringBuilder().append(getClass().getSimpleName()).append(".refreshPayment").toString();
    if (n.a(this, this.i))
      this.i.f();
    PayPalPayment localPayPalPayment = this.h.a();
    br localbr = br.d();
    String str1 = l.a(localbr.c(), localbr.a().a(), localPayPalPayment.a().doubleValue(), localPayPalPayment.d(), true);
    this.g.c.d.setText(localPayPalPayment.b());
    this.g.c.c.setText(str1);
    if ((this.i.h()) && (this.i.b().h.a()))
    {
      String str3 = this.i.o();
      if (R.b(str3))
      {
        this.g.d.setText(str3);
        this.g.d.setVisibility(0);
        this.g.b.setVisibility(0);
        if (!this.i.c().i())
          break label547;
        bz localbz = this.i.p();
        if ((localbz == null) || (!localbz.c()))
          break label438;
        this.g.m.setVisibility(8);
        this.g.e.setText(localbz.e());
        CardType localCardType = localbz.g();
        this.g.g.setImageBitmap(bH.a(this, localCardType));
        this.g.g.setContentDescription(localCardType.toString());
        this.g.g.setVisibility(0);
        String str2 = bF.a(bG.e);
        this.g.k.setText(bl.a(str2));
        this.g.k.setVisibility(0);
        this.g.h.setVisibility(0);
        this.g.k.setVisibility(0);
      }
    }
    while (true)
    {
      d.a(this.g.i.b, this.i.c().b());
      return;
      this.g.d.setVisibility(8);
      this.g.b.setVisibility(8);
      break;
      this.g.d.setVisibility(8);
      this.g.b.setVisibility(8);
      break;
      label438: this.g.g.setVisibility(8);
      if (this.d)
      {
        this.g.m.setImageBitmap(bl.c("iVBORw0KGgoAAAANSUhEUgAAADcAAAAsCAYAAADByiAeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAohJREFUeNrcWYGRgjAQJMwXQAl0IFbwWMFrBS8VvHYAFagVoBVIB2IFaAV8B08H/GUm/GA+CUouBL2ZTByEwCZ3m70LcRCsrusQutDBswranhBSOTYNgC1rM1ZA82yD+6nN2Urn21xNYAF0Jmf33Ro45DhDH9+1ObN3mMe84yVXTusd7ojjTds7iIzeoZtAU7mE1/E/5p536fj/yvbFb+VmDK2sn9c27b2RcKuVOs9vdJVnVN0QBsyHrjAQQ9RNMmhn5j5tC1g8zQ0A3AK4dbNqKbJ7nJjevIeYKN3HBpSOjy2h6DjznuxLQR4xpZvbYj4MX5+CO2S9aJvGCCEL+LnGEgBv2EEsWRXqIj4HJpeA3ML9FRq5IbhioEiHCsVz6V9s/H9WlwdiDHArSfycHpicpWSM0ia4UvJRRY+xlsiJcKwrnBPBtbSnLEt594b427O9cvisgL2cr6XobMobwbWdDXAitvvUTW8E5JTbAHcWXMOQUiHnHRcb4CrBXoYhBiYSjTooOH5GfSRB4I8BnI/xAV0eoTNxaOCUWfBjdh0DOFFsZAjgMkGtZnBCCTH3pIb2BewY2gDn8bkbU/q5xpgJ5t6pK7++BNcWHdUqmUV8GsQUj72irGD1KNvNHgQY8VJOIccGz+c8ybhxR9pyVOSCsW4+11S/asOZeMCIwWvdnyvuxygzJhgrh3pYiHiYqZ3P8XXI4t6SniTJ3WAWhjHBNUripKqNKNyQFoVXmB+DFXOqWDyw/tLEGItBCv6DpUkmTouSBlyJqOrHYlHjlocXA0Y9JGvAbSWpxrPajoaAy6mKVwBIDyHjG7ZkanyqKXxtu+IacEQ3bCmgZt8gixlhZdEBzK8AAwBIvuGtI5K/kgAAAABJRU5ErkJggg==", this));
        this.g.m.setVisibility(0);
        this.g.m.setContentDescription(bF.a(bG.ag));
      }
      while (true)
      {
        this.g.e.setText(bF.a(bG.H));
        this.g.k.setVisibility(8);
        break;
        this.g.m.setVisibility(8);
      }
      label547: this.g.h.setVisibility(8);
      this.g.k.setVisibility(8);
    }
  }

  private void c()
  {
    this.k = bindService(d.b(this), this.j, 1);
  }

  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    new StringBuilder().append(getClass().getSimpleName()).append(".onActivityResult").toString();
    switch (paramInt1)
    {
    default:
    case 1:
    case 2:
    case 3:
    }
    do
    {
      do
      {
        do
          return;
        while ((paramIntent == null) || (!paramIntent.hasExtra("io.card.payment.scanResult")));
        CreditCard localCreditCard = (CreditCard)paramIntent.getParcelableExtra("io.card.payment.scanResult");
        PaymentConfirmActivity.a(this, 2, aq.b, localCreditCard);
        return;
      }
      while (paramInt2 != -1);
      PaymentConfirmation localPaymentConfirmation = (PaymentConfirmation)paramIntent.getParcelableExtra("com.paypal.android.sdk.paymentConfirmation");
      Intent localIntent = new Intent();
      localIntent.putExtra("com.paypal.android.sdk.paymentConfirmation", localPaymentConfirmation);
      setResult(paramInt2, localIntent);
      finish();
      return;
    }
    while (paramInt2 != -1);
    a(paramIntent.getExtras());
  }

  public final void onBackPressed()
  {
    new StringBuilder().append(getClass().getSimpleName()).append(".onBackPressed").toString();
    if (this.i != null)
      this.i.a(bE.d);
    if (this.b != null)
      this.b.cancel();
    super.onBackPressed();
  }

  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    new StringBuilder().append(getClass().getSimpleName()).append(".onCreate").toString();
    R.b(this);
    R.a(this);
    c();
    this.g = new bM(this, e);
    this.h = new ai(getIntent());
    setContentView(this.g.a);
    d.a(this, this.g.l, bG.X);
    this.g.f.setText(bF.a(bG.G));
    this.g.b.setText(bl.a(bF.a(bG.C)));
    this.g.j.setOnClickListener(new as(this));
    this.g.b.setOnClickListener(new at(this));
    this.g.h.setOnClickListener(new au(this));
    this.g.k.setOnClickListener(new av(this));
    if (paramBundle == null)
      if (!d.a(this))
        finish();
    for (this.f = false; ; this.f = paramBundle.getBoolean("PP_PageTrackingSent"))
    {
      this.d = CardIOActivity.canReadCardWithCamera(getApplicationContext());
      this.b = null;
      return;
      this.c = paramBundle.getBoolean("PP_PreventAutoLogin");
    }
  }

  protected final Dialog onCreateDialog(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return d.a(this, bG.D, bG.i, new ax(this));
    case 2:
      return d.a(this, bG.Y, bG.g, new ay(this));
    case 3:
    }
    return d.a(this, bG.a, bG.ae);
  }

  protected final void onDestroy()
  {
    new StringBuilder().append(getClass().getSimpleName()).append(".onDestroy").toString();
    if (this.k)
    {
      unbindService(this.j);
      this.k = false;
    }
    super.onDestroy();
  }

  protected final void onRestart()
  {
    super.onRestart();
    c();
  }

  protected final void onResume()
  {
    super.onResume();
    new StringBuilder().append(getClass().getSimpleName()).append(".onResume").toString();
    if (this.i != null)
      b();
  }

  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    new StringBuilder().append(getClass().getSimpleName()).append(".onSaveInstanceState").toString();
    paramBundle.putBoolean("PP_PreventAutoLogin", this.c);
    paramBundle.putBoolean("PP_PageTrackingSent", this.f);
  }

  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.g.c.a();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.PaymentMethodActivity
 * JD-Core Version:    0.6.2
 */