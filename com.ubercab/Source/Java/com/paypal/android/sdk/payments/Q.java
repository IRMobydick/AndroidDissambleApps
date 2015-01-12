package com.paypal.android.sdk.payments;

import android.content.Intent;
import com.paypal.android.sdk.R;
import java.net.MalformedURLException;
import java.net.URL;

final class Q extends o
{
  Q(Intent paramIntent, PayPalConfiguration paramPayPalConfiguration)
  {
    super(paramIntent, paramPayPalConfiguration);
  }

  private static boolean a(String paramString)
  {
    try
    {
      new URL(paramString);
      return true;
    }
    catch (MalformedURLException localMalformedURLException)
    {
    }
    return false;
  }

  protected final String a()
  {
    return PayPalFuturePaymentActivity.class.getSimpleName();
  }

  final boolean e()
  {
    boolean bool1 = R.d(c().l());
    a(bool1, "merchantName");
    boolean bool2;
    if ((d.a(PayPalFuturePaymentActivity.class.getSimpleName(), c().m(), "merchantPrivacyPolicyUrl")) && (a(c().m())))
    {
      bool2 = true;
      a(bool2, "merchantPrivacyPolicyUrl");
      if ((!d.a(PayPalFuturePaymentActivity.class.getSimpleName(), c().n(), "merchantUserAgreementUrl")) || (!a(c().n())))
        break label121;
    }
    label121: for (boolean bool3 = true; ; bool3 = false)
    {
      a(bool3, "merchantUserAgreementUrl");
      if ((!bool1) || (!bool2) || (!bool3))
        break label126;
      return true;
      bool2 = false;
      break;
    }
    label126: return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.Q
 * JD-Core Version:    0.6.2
 */