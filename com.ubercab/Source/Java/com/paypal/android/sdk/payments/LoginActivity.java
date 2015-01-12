package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.bE;
import com.paypal.android.sdk.bF;
import com.paypal.android.sdk.bG;
import com.paypal.android.sdk.bJ;
import com.paypal.android.sdk.bK;
import com.paypal.android.sdk.bl;
import com.paypal.android.sdk.br;
import com.paypal.android.sdk.bs;
import com.paypal.android.sdk.bv;
import com.paypal.android.sdk.h;
import com.paypal.android.sdk.j;
import com.paypal.android.sdk.o;
import com.paypal.android.sdk.s;
import com.paypal.android.sdk.t;
import java.util.Locale;

public final class LoginActivity extends Activity
  implements TextWatcher
{
  private final String a = LoginActivity.class.getSimpleName();
  private H b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private bK m;
  private PayPalService n;
  private final ServiceConnection o = new D(this);
  private boolean p;

  static void a(Activity paramActivity, int paramInt, bv parambv, boolean paramBoolean, PayPalConfiguration paramPayPalConfiguration)
  {
    a(paramActivity, 1, null, true, false, null, paramPayPalConfiguration);
  }

  static void a(Activity paramActivity, int paramInt, bv parambv, boolean paramBoolean1, boolean paramBoolean2, String paramString, PayPalConfiguration paramPayPalConfiguration)
  {
    Intent localIntent = new Intent(paramActivity, LoginActivity.class);
    localIntent.putExtras(paramActivity.getIntent());
    localIntent.putExtra("com.paypal.android.sdk.payments.persistedLogin", parambv);
    localIntent.putExtra("com.paypal.android.sdk.payments.useResponseTypeCode", paramBoolean1);
    localIntent.putExtra("com.paypal.android.sdk.payments.forceLogin", paramBoolean2);
    localIntent.putExtra("com.paypal.android.sdk.payments.requestedScopes", paramString);
    localIntent.putExtra("com.paypal.android.sdk.paypalConfiguration", paramPayPalConfiguration);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }

  private boolean b()
  {
    return getIntent().getBooleanExtra("com.paypal.android.sdk.payments.useResponseTypeCode", false);
  }

  private void c()
  {
    setResult(-1);
    finish();
  }

  private void d()
  {
    int i1;
    if (this.b == H.b)
    {
      this.m.e.setVisibility(4);
      this.m.h.setText(bl.a(bF.a(bG.ac)));
      this.m.b.setText(this.e);
      this.m.b.setHint(bF.a(bG.I));
      this.m.b.setInputType(3);
      this.m.d.setText(this.g);
      this.m.d.setHint(bF.a(bG.J));
      EditText localEditText = this.m.d;
      if (Build.VERSION.SDK_INT < 11)
      {
        i1 = 2;
        localEditText.setInputType(i1);
        if (Build.VERSION.SDK_INT < 11)
          this.m.d.setTransformationMethod(PasswordTransformationMethod.getInstance());
      }
    }
    while (true)
    {
      f();
      if ((this.m.b.getText().length() > 0) && (this.m.d.getText().length() == 0))
        this.m.d.requestFocus();
      d.a(this.m.c.b, this.n.d());
      return;
      i1 = 18;
      break;
      this.m.e.setVisibility(0);
      this.m.h.setText(bl.a(bF.a(bG.ad)));
      this.m.b.setText(this.c);
      this.m.b.setHint(bF.a(bG.q));
      this.m.b.setInputType(33);
      this.m.d.setText(this.d);
      this.m.d.setHint(bF.a(bG.F));
      this.m.d.setInputType(129);
    }
  }

  private void e()
  {
    if (this.b == H.b)
    {
      this.e = this.m.b.getText().toString();
      this.g = this.m.d.getText().toString();
      return;
    }
    this.c = this.m.b.getText().toString();
    this.d = this.m.d.getText().toString();
  }

  private void f()
  {
    boolean bool = true;
    String str1 = this.m.b.getText().toString();
    String str2 = this.m.d.getText().toString();
    if (this.b == H.b)
      if ((!s.d(str1)) || (!s.b(str2)));
    while (true)
    {
      this.m.f.setEnabled(bool);
      this.m.f.setFocusable(bool);
      return;
      bool = false;
      continue;
      if ((!s.a(str1)) || (!s.c(str2)))
        bool = false;
    }
  }

  private void g()
  {
    this.m.f.setEnabled(false);
    if (!this.n.g())
    {
      showDialog(2);
      new StringBuilder("token is expired, get new one. AccessToken: ").append(this.n.b().c).toString();
      this.n.a(h(), true);
      return;
    }
    e();
    br localbr;
    t localt;
    o localo;
    label126: PayPalService localPayPalService;
    boolean bool;
    if (this.b == H.b)
    {
      localbr = br.d();
      if (this.f == null)
      {
        localt = new t(localbr, this.e);
        localo = new o(localt, this.g);
        showDialog(2);
        localPayPalService = this.n;
        bool = this.j;
        if (!b())
          break label218;
      }
    }
    label218: for (String str = "code"; ; str = "token")
    {
      localPayPalService.a(localo, bool, str, b(), this.h);
      return;
      localt = new t(localbr, new j(this.f), this.e);
      break;
      localo = new o(this.c, this.d);
      break label126;
    }
  }

  private Y h()
  {
    return new F(this);
  }

  final void a()
  {
    PayPalConfiguration localPayPalConfiguration = this.n.c();
    if (bF.c(this.n.c().a()))
    {
      this.m.d.setGravity(5);
      this.m.b.setGravity(5);
    }
    if (this.k)
    {
      this.c = localPayPalConfiguration.c();
      String str1 = localPayPalConfiguration.d();
      if (str1 != null)
        this.e = str1;
      String str2 = localPayPalConfiguration.e();
      if (str2 != null)
        this.f = str2;
      if ((localPayPalConfiguration.f()) && (!localPayPalConfiguration.b().equals("live")))
      {
        this.d = localPayPalConfiguration.g();
        this.g = localPayPalConfiguration.h();
      }
    }
    if ((getIntent().getBooleanExtra("com.paypal.android.sdk.payments.forceLogin", false)) && (!this.l))
    {
      this.l = true;
      this.n.f();
    }
    if (!this.n.h())
    {
      if (!this.i)
      {
        this.i = true;
        this.n.a(bE.k, Boolean.valueOf(this.j));
      }
      this.j = false;
      bv localbv = (bv)getIntent().getParcelableExtra("com.paypal.android.sdk.payments.persistedLogin");
      if (localbv != null)
      {
        this.j = true;
        if ((R.a(this.c)) && (R.b(localbv.b())))
          this.c = localbv.b();
        if ((this.e == null) && (localbv.a() != null))
          this.e = localbv.a().a(br.d());
        if (this.b == null)
        {
          if (localbv.c() != null)
            break label323;
          this.b = H.a;
        }
      }
      while (true)
      {
        d();
        this.n.a(new X(this));
        return;
        label323: switch (G.a[localbv.c().ordinal()])
        {
        default:
          break;
        case 1:
          this.b = H.a;
          break;
        case 2:
          this.b = H.b;
        }
      }
    }
    c();
  }

  public final void afterTextChanged(Editable paramEditable)
  {
    f();
  }

  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public final void onBackPressed()
  {
    this.n.a(bE.o, Boolean.valueOf(this.j));
    super.onBackPressed();
  }

  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    new StringBuilder().append(getClass().getSimpleName()).append(".onCreate").toString();
    this.h = getIntent().getExtras().getString("com.paypal.android.sdk.payments.requestedScopes");
    this.p = bindService(d.b(this), this.o, 1);
    R.b(this);
    R.a(this);
    this.m = new bK(this);
    setContentView(this.m.a);
    d.a(this, null, bG.B);
    this.m.e.setText(bl.a(bF.a(bG.u)));
    this.m.g.setText(bF.a(bG.A));
    this.m.b.addTextChangedListener(this);
    this.m.d.addTextChangedListener(this);
    this.m.f.setOnClickListener(new A(this));
    this.m.e.setOnClickListener(new B(this));
    this.m.h.setOnClickListener(new C(this));
    if (paramBundle == null)
    {
      this.i = false;
      this.k = true;
      return;
    }
    this.k = false;
    this.i = paramBundle.getBoolean("PP_PageTrackingSent");
    this.b = ((H)paramBundle.getParcelable("PP_LoginType"));
    this.c = paramBundle.getString("PP_SavedEmail");
    this.e = paramBundle.getString("PP_SavedPhone");
    this.f = paramBundle.getString("PP_savedPhoneCountryCode");
    this.d = paramBundle.getString("PP_SavedPassword");
    this.g = paramBundle.getString("PP_SavedPIN");
    this.j = paramBundle.getBoolean("PP_IsReturningUser");
    this.l = paramBundle.getBoolean("PP_IsClearedLogin");
    this.h = paramBundle.getString("PP_RequestedScopes");
  }

  protected final Dialog onCreateDialog(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return d.a(this, bG.ab, paramBundle);
    case 2:
    }
    return d.a(this, bG.a, bG.ae);
  }

  protected final void onDestroy()
  {
    new StringBuilder().append(getClass().getSimpleName()).append(".onDestroy").toString();
    if (this.n != null)
      this.n.l();
    if (this.p)
    {
      unbindService(this.o);
      this.p = false;
    }
    super.onDestroy();
  }

  public final void onForgotPasswordPress(View paramView)
  {
    br localbr = br.d();
    String str1 = localbr.b().a();
    if ((R.d(str1)) && (str1.equalsIgnoreCase("US")));
    for (String str2 = "https://www.paypal.com/webapps/accountrecovery/passwordrecovery"; ; str2 = String.format("https://www.paypal.com/%s/cgi-bin/webscr?cmd=_account-recovery&from=%s&locale.x=%s", new Object[] { str1, "PayPalMPL", localbr.c().getLanguage() }))
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
      this.n.a(bE.n, Boolean.valueOf(this.j));
      return;
    }
  }

  protected final void onResume()
  {
    super.onResume();
    new StringBuilder().append(getClass().getSimpleName()).append(".onResume").toString();
    if (this.n != null)
      d();
  }

  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    e();
    paramBundle.putParcelable("PP_LoginType", this.b);
    paramBundle.putString("PP_SavedEmail", this.c);
    paramBundle.putString("PP_SavedPhone", this.e);
    paramBundle.putString("PP_SavedPhoneCountryCode", this.f);
    paramBundle.putString("PP_SavedPassword", this.d);
    paramBundle.putString("PP_SavedPIN", this.g);
    paramBundle.putBoolean("PP_IsReturningUser", this.j);
    paramBundle.putBoolean("PP_PageTrackingSent", this.i);
    paramBundle.putBoolean("PP_IsClearedLogin", this.l);
    paramBundle.putString("PP_RequestedScopes", this.h);
  }

  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.LoginActivity
 * JD-Core Version:    0.6.2
 */