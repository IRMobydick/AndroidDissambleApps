package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.b;
import com.paypal.android.sdk.bE;
import com.paypal.android.sdk.bF;
import com.paypal.android.sdk.bG;
import com.paypal.android.sdk.bI;
import com.paypal.android.sdk.bl;
import java.util.Iterator;
import java.util.Set;

public final class FuturePaymentConsentActivity extends Activity
{
  protected static String a;
  private static final String b = FuturePaymentConsentActivity.class.getSimpleName();
  private static PayPalScopes c;
  private x d;
  private boolean e;
  private bI f;
  private PayPalService g;
  private final ServiceConnection h = new u(this);
  private boolean i;
  private boolean j;

  static
  {
    PayPalScopes localPayPalScopes = new PayPalScopes();
    c = localPayPalScopes;
    localPayPalScopes.addFuturePaymentsScope();
  }

  private void a()
  {
    new StringBuilder().append(getClass().getSimpleName()).append(".doLogin").toString();
    if (n.a(this, this.g))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("target_client_id", this.g.c().k());
      localBundle.putString("response_type", "code");
      localBundle.putString("app_guid", b.a().c().e());
      localBundle.putString("token_request_type", "PROMPT_LOGIN");
      new StringBuilder("launching authenticator with bundle:").append(localBundle).toString();
      Intent localIntent = n.a();
      localIntent.putExtras(localBundle);
      startActivityForResult(localIntent, 2);
      return;
    }
    LoginActivity.a(this, 1, null, true, this.g.c());
  }

  private void a(int paramInt, PayPalAuthorization paramPayPalAuthorization)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("com.paypal.android.sdk.authorization", paramPayPalAuthorization);
    setResult(paramInt, localIntent);
  }

  static void a(Activity paramActivity, int paramInt, PayPalConfiguration paramPayPalConfiguration)
  {
    Intent localIntent = new Intent(paramActivity, FuturePaymentConsentActivity.class);
    localIntent.putExtras(paramActivity.getIntent());
    localIntent.putExtra("com.paypal.android.sdk.paypalConfiguration", paramPayPalConfiguration);
    paramActivity.startActivityForResult(localIntent, 1);
  }

  private void a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("authAccount");
    String str2 = paramBundle.getString("code");
    String str3 = paramBundle.getString("nonce");
    Iterator localIterator = paramBundle.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str4 = (String)localIterator.next();
      Object localObject = paramBundle.get(str4);
      if (localObject == null)
        String.format("%s:null", new Object[] { str4 });
      while (true)
      {
        break;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = str4;
        arrayOfObject[1] = localObject.toString();
        arrayOfObject[2] = localObject.getClass().getName();
        String.format("%s:%s (%s)", arrayOfObject);
      }
    }
    x localx = new x(this, str2, str3, str1);
    if (this.g == null)
    {
      this.d = localx;
      return;
    }
    a(localx);
  }

  private void a(SpannableString paramSpannableString)
  {
    int k = 0;
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramSpannableString.getSpans(0, paramSpannableString.length(), URLSpan.class);
    int m = arrayOfURLSpan.length;
    while (k < m)
    {
      URLSpan localURLSpan = arrayOfURLSpan[k];
      paramSpannableString.setSpan(new c(localURLSpan, this, FuturePaymentInfoActivity.class, new d(this)), paramSpannableString.getSpanStart(localURLSpan), paramSpannableString.getSpanEnd(localURLSpan), 33);
      paramSpannableString.removeSpan(localURLSpan);
      k++;
    }
  }

  private void a(x paramx)
  {
    this.g.b().g = paramx.b;
    this.g.b().f = paramx.c;
    this.g.b().d = paramx.a;
    this.f.h.setEnabled(true);
  }

  private void b()
  {
    this.i = bindService(d.b(this), this.h, 1);
  }

  private void b(SpannableString paramSpannableString)
  {
    int k = 0;
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramSpannableString.getSpans(0, paramSpannableString.length(), URLSpan.class);
    int m = arrayOfURLSpan.length;
    while (k < m)
    {
      URLSpan localURLSpan = arrayOfURLSpan[k];
      paramSpannableString.setSpan(new aC(localURLSpan, new s(this)), paramSpannableString.getSpanStart(localURLSpan), paramSpannableString.getSpanEnd(localURLSpan), 33);
      paramSpannableString.removeSpan(localURLSpan);
      k++;
    }
  }

  private void c(SpannableString paramSpannableString)
  {
    int k = 0;
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramSpannableString.getSpans(0, paramSpannableString.length(), URLSpan.class);
    int m = arrayOfURLSpan.length;
    while (k < m)
    {
      URLSpan localURLSpan = arrayOfURLSpan[k];
      paramSpannableString.setSpan(new aC(localURLSpan, new t(this)), paramSpannableString.getSpanStart(localURLSpan), paramSpannableString.getSpanEnd(localURLSpan), 33);
      paramSpannableString.removeSpan(localURLSpan);
      k++;
    }
  }

  public final void finish()
  {
    super.finish();
    new StringBuilder().append(getClass().getSimpleName()).append(".finish").toString();
  }

  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    new StringBuilder().append(getClass().getSimpleName()).append(".onActivityResult(").append(paramInt1).append(",").append(paramInt2).append(",").append(paramIntent).append(")").toString();
    switch (paramInt1)
    {
    default:
      Log.e(b, "unhandled requestCode " + paramInt1);
    case 1:
    case 2:
    }
    do
    {
      do
      {
        return;
        if (paramInt2 != -1)
          break;
      }
      while ((this.f == null) || (this.f.h == null));
      this.f.h.setEnabled(true);
      return;
      a(paramInt2, null);
      finish();
      return;
      if (paramInt2 != -1)
        break;
    }
    while ((this.f == null) || (this.f.h == null));
    this.f.h.setEnabled(true);
    a(paramIntent.getExtras());
    return;
    a(paramInt2, null);
    finish();
  }

  public final void onBackPressed()
  {
    this.g.a(bE.r);
    super.onBackPressed();
  }

  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    new StringBuilder().append(getClass().getSimpleName()).append(".onCreate").toString();
    if (paramBundle == null)
    {
      if (!d.a(this))
        finish();
      this.e = false;
    }
    while (true)
    {
      b();
      R.b(this);
      R.a(this);
      this.f = new bI(this);
      setContentView(this.f.a);
      d.a(this, this.f.b, null);
      this.f.g.setText(bl.a(bF.a(bG.c)));
      this.f.g.setVisibility(0);
      return;
      this.e = paramBundle.getBoolean("pageTrackingSent");
      this.j = paramBundle.getBoolean("isLoginActivityStarted");
    }
  }

  protected final Dialog onCreateDialog(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return d.a(this, bG.Z, paramBundle);
    case 2:
      return d.a(this, bG.L, bG.ae);
    case 3:
      return d.a(this, bG.y, paramBundle, paramInt);
    case 4:
    }
    return d.a(this, bG.P, paramBundle, new w(this));
  }

  protected final void onDestroy()
  {
    new StringBuilder().append(getClass().getSimpleName()).append(".onDestroy").toString();
    if (this.g != null)
      this.g.k();
    if (this.i)
    {
      unbindService(this.h);
      this.i = false;
    }
    super.onDestroy();
  }

  protected final void onRestart()
  {
    super.onRestart();
    b();
  }

  protected final void onResume()
  {
    super.onResume();
    new StringBuilder().append(getClass().getSimpleName()).append(".onResume").toString();
  }

  protected final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("pageTrackingSent", this.e);
    paramBundle.putBoolean("isLoginActivityStarted", this.j);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.FuturePaymentConsentActivity
 * JD-Core Version:    0.6.2
 */