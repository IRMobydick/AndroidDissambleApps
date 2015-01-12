package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.b;
import com.paypal.android.sdk.bE;
import com.paypal.android.sdk.bF;
import com.paypal.android.sdk.bG;
import com.paypal.android.sdk.bH;
import com.paypal.android.sdk.bJ;
import com.paypal.android.sdk.bL;
import com.paypal.android.sdk.bN;
import com.paypal.android.sdk.bO;
import com.paypal.android.sdk.bP;
import com.paypal.android.sdk.bl;
import com.paypal.android.sdk.bm;
import com.paypal.android.sdk.br;
import com.paypal.android.sdk.bs;
import com.paypal.android.sdk.bz;
import com.paypal.android.sdk.c;
import com.paypal.android.sdk.j;
import com.paypal.android.sdk.l;
import com.paypal.android.sdk.q;
import io.card.payment.CardType;
import io.card.payment.CreditCard;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class PaymentConfirmActivity extends Activity
{
  private static final String a = PaymentConfirmActivity.class.getSimpleName();
  private ap b;
  private boolean c;
  private bL d;
  private ai e;
  private aq f;
  private CreditCard g;
  private PayPalService h;
  private final ServiceConnection i = new ak(this);
  private boolean j;

  private void a(int paramInt)
  {
    setResult(paramInt, new Intent());
  }

  static void a(Activity paramActivity, int paramInt, aq paramaq, CreditCard paramCreditCard)
  {
    Intent localIntent = new Intent(paramActivity, PaymentConfirmActivity.class);
    localIntent.putExtras(paramActivity.getIntent());
    localIntent.putExtra("EXTRA_PAYMENT_KIND", paramaq);
    localIntent.putExtra("EXTRA_CREDIT_CARDS", paramCreditCard);
    paramActivity.startActivityForResult(localIntent, 2);
  }

  private void a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("authAccount");
    String str2 = paramBundle.getString("authtoken");
    long l = paramBundle.getLong("valid_until");
    Iterator localIterator = paramBundle.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      Object localObject = paramBundle.get(str3);
      if (localObject == null)
        String.format("%s:null", new Object[] { str3 });
      while (true)
      {
        break;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = str3;
        arrayOfObject[1] = localObject.toString();
        arrayOfObject[2] = localObject.getClass().getName();
        String.format("%s:%s (%s)", arrayOfObject);
      }
    }
    bm localbm = new bm(str2, l, false);
    if (this.h == null)
    {
      this.b = new ap(this, str1, localbm);
      return;
    }
    a(str1, localbm);
  }

  private void a(String paramString)
  {
    this.d.g.a.setVisibility(0);
    this.d.i.a.setVisibility(0);
    this.d.i.c.setText(paramString);
    if (paramString.length() > 22)
    {
      this.d.i.c.setTextSize(14.0F);
      bl.a(this.d.i.c, null, "4dip", null, null);
    }
  }

  private void a(String paramString, bm parambm)
  {
    this.h.b().d = paramString;
    a(paramString);
    this.h.b().h = parambm;
    this.d.d.setEnabled(true);
  }

  private void a(boolean paramBoolean)
  {
    if (n.a(this, this.h))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("target_client_id", this.h.c().k());
      localBundle.putString("scope", "https://api.paypal.com/v1/payments/.*");
      localBundle.putString("response_type", "token");
      localBundle.putString("app_guid", b.a().c().e());
      if (paramBoolean)
        localBundle.putString("token_request_type", "PROMPT_LOGIN");
      while (true)
      {
        new StringBuilder("launching authenticator with bundle:").append(localBundle).toString();
        Intent localIntent = n.a();
        localIntent.putExtras(localBundle);
        startActivityForResult(localIntent, 2);
        return;
        localBundle.putString("token_request_type", "USER_REQUIRED");
      }
    }
    LoginActivity.a(this, 1, this.h.n(), false, paramBoolean, "https://api.paypal.com/v1/payments/.*", this.h.c());
  }

  private void b()
  {
    if ((this.h.b().h != null) && (!this.h.b().h.a()))
    {
      this.h.b().h = null;
      this.h.b().d = null;
    }
  }

  private void c()
  {
    this.j = bindService(d.b(this), this.i, 1);
  }

  private boolean d()
  {
    boolean bool1 = this.f.equals(aq.a);
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = this.h.h();
      bool2 = false;
      if (!bool3)
      {
        a(false);
        bool2 = true;
      }
    }
    return bool2;
  }

  private void e()
  {
    PayPalPayment localPayPalPayment = this.e.a();
    this.d.b.d.setText(localPayPalPayment.b());
    br localbr = br.d();
    String str1 = l.a(localbr.c(), localbr.a().a(), localPayPalPayment.a().doubleValue(), localPayPalPayment.d(), true);
    this.d.b.c.setText(str1);
    if (this.f == aq.a)
    {
      this.d.f.setText(bF.a(bG.j));
      String str5 = this.h.o();
      if (R.b(str5))
        a(str5);
      String str6 = bF.a(bG.v);
      String str7 = bF.a(bG.ah);
      this.d.i.d.setText(str6);
      this.d.g.b.setText(str7);
    }
    while (true)
    {
      d.a(this.d.j.b, this.h.d());
      return;
      if ((this.f == aq.b) || (this.f == aq.c))
      {
        this.d.f.setText(bF.a(bG.h));
        this.d.h.a.setVisibility(0);
        this.d.k.a.setVisibility(0);
        String str2;
        int k;
        int m;
        if (this.f == aq.b)
        {
          str2 = bz.b(this.g.getRedactedCardNumber());
          k = this.g.expiryMonth;
          m = this.g.expiryYear;
        }
        bz localbz;
        for (CardType localCardType = this.g.getCardType(); ; localCardType = localbz.g())
        {
          Locale localLocale = Locale.getDefault();
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = Integer.valueOf(k);
          arrayOfObject[1] = Integer.valueOf(m);
          String str3 = String.format(localLocale, "%02d / %04d", arrayOfObject);
          this.d.h.b.setText(str2);
          this.d.h.c.setImageBitmap(bH.a(this, localCardType));
          this.d.k.c.setText(str3);
          String str4 = bF.a(bG.t);
          this.d.k.d.setText(str4);
          break;
          localbz = this.h.p();
          str2 = localbz.e();
          k = localbz.h();
          m = localbz.i();
        }
      }
      Log.wtf(a, "Unknown payment type: " + this.f.toString());
      d.a(this, "The payment is not a valid type. Please try again.", 3);
    }
  }

  private void f()
  {
    int k;
    switch (ao.a[this.f.ordinal()])
    {
    default:
      k = 1;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      if (k != 0)
        break label123;
      return;
      if (!d())
      {
        k = 1;
      }
      else
      {
        k = 0;
        continue;
        if (this.h.g())
          break;
        showDialog(2);
        new StringBuilder("token is expired, get new one. AccessToken: ").append(this.h.b().c).toString();
        this.h.a(g(), true);
        k = 0;
      }
    }
    label123: showDialog(2);
    PayPalPayment localPayPalPayment = this.e.a();
    q localq = new q(new BigDecimal(l.a(localPayPalPayment.a().doubleValue(), localPayPalPayment.d()).trim()), localPayPalPayment.d());
    HashMap localHashMap;
    if (localPayPalPayment != null)
    {
      localHashMap = new HashMap();
      PayPalPaymentDetails localPayPalPaymentDetails = localPayPalPayment.f();
      if (localPayPalPaymentDetails != null)
      {
        if (localPayPalPaymentDetails.b() != null)
          localHashMap.put("shipping", l.a(localPayPalPaymentDetails.b().doubleValue(), localPayPalPayment.d()));
        if (localPayPalPaymentDetails.a() != null)
          localHashMap.put("subtotal", l.a(localPayPalPaymentDetails.a().doubleValue(), localPayPalPayment.d()));
        if (localPayPalPaymentDetails.c() != null)
          localHashMap.put("tax", l.a(localPayPalPaymentDetails.c().doubleValue(), localPayPalPayment.d()));
      }
      if (localHashMap.isEmpty());
    }
    String str1;
    boolean bool;
    while (true)
    {
      str1 = localPayPalPayment.b();
      bool = this.h.c().j();
      switch (ao.a[this.f.ordinal()])
      {
      default:
        return;
      case 1:
        this.h.a(this.h.b().b(), localq, localHashMap, localPayPalPayment.g(), str1, bool, localPayPalPayment.e(), localPayPalPayment.c().toString());
        return;
        localHashMap = null;
      case 2:
      case 3:
      }
    }
    bz localbz = this.h.p();
    PayPalService localPayPalService2 = this.h;
    String str5 = this.h.b().b();
    String str6 = localbz.f();
    PayPalItem[] arrayOfPayPalItem2 = localPayPalPayment.g();
    String str7 = localbz.b();
    String str8 = localPayPalPayment.e();
    String str9 = localPayPalPayment.c().toString();
    localPayPalService2.a(str5, str6, localq, localHashMap, arrayOfPayPalItem2, str1, bool, str7, str8, str9);
    return;
    PayPalService localPayPalService1 = this.h;
    String str2 = this.h.b().b();
    CreditCard localCreditCard = this.g;
    PayPalItem[] arrayOfPayPalItem1 = localPayPalPayment.g();
    String str3 = localPayPalPayment.e();
    String str4 = localPayPalPayment.c().toString();
    localPayPalService1.a(str2, localCreditCard, localq, localHashMap, arrayOfPayPalItem1, str1, bool, str3, str4);
  }

  private Y g()
  {
    return new an(this);
  }

  public final void finish()
  {
    super.finish();
    new StringBuilder().append(getClass().getSimpleName()).append(".finish").toString();
  }

  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    new StringBuilder().append(getClass().getSimpleName()).append(".onActivityResult(requestCode:").append(paramInt1).append(", resultCode:").append(paramInt2).append(", data:").append(paramIntent).append(")").toString();
    switch (paramInt1)
    {
    default:
      Log.e(a, "unhandled requestCode " + paramInt1);
    case 1:
      do
      {
        do
        {
          return;
          if (paramInt2 != -1)
            break;
        }
        while ((this.d == null) || (this.d.d == null));
        this.d.d.setEnabled(true);
      }
      while (this.h == null);
      a(this.h.o());
      return;
      a(paramInt2);
      finish();
      return;
    case 2:
    }
    if (paramInt2 == -1)
    {
      this.d.d.setEnabled(true);
      a(paramIntent.getExtras());
      return;
    }
    a(paramInt2);
    finish();
  }

  public final void onBackPressed()
  {
    this.h.a(bE.i);
    b();
    super.onBackPressed();
  }

  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    new StringBuilder().append(getClass().getSimpleName()).append(".onCreate").toString();
    c();
    if (paramBundle == null)
    {
      if (!d.a(this))
        finish();
      this.c = false;
      this.f = ((aq)getIntent().getSerializableExtra("EXTRA_PAYMENT_KIND"));
      this.g = ((CreditCard)getIntent().getParcelableExtra("EXTRA_CREDIT_CARDS"));
      this.e = new ai(getIntent());
      R.b(this);
      R.a(this);
      if (this.f != aq.a)
        break label194;
    }
    label194: for (boolean bool = true; ; bool = false)
    {
      this.d = new bL(this, bool);
      setContentView(this.d.a);
      d.a(this, this.d.c, bG.f);
      this.d.d.setOnClickListener(new aj(this));
      return;
      this.c = paramBundle.getBoolean("pageTrackingSent");
      break;
    }
  }

  protected final Dialog onCreateDialog(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return d.a(this, bG.af, paramBundle);
    case 2:
      return d.a(this, bG.L, bG.ae);
    case 3:
      return d.a(this, bG.y, paramBundle, paramInt);
    case 4:
    }
    return d.a(this, bG.P, paramBundle, new am(this));
  }

  protected final void onDestroy()
  {
    new StringBuilder().append(getClass().getSimpleName()).append(".onDestroy").toString();
    if (this.h != null)
      this.h.k();
    if (this.j)
    {
      unbindService(this.i);
      this.j = false;
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
    if (this.h != null)
      e();
  }

  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("pageTrackingSent", this.c);
  }

  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    new StringBuilder().append(getClass().getSimpleName()).append(".onWindowFocusChanged").toString();
    this.d.b.a();
    if (this.d.i != null)
      this.d.i.a();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.PaymentConfirmActivity
 * JD-Core Version:    0.6.2
 */