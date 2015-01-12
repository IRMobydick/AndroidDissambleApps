package com.ubercab.client.core.vendor.paypal;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.common.collect.ImmutableList.Builder;
import com.ubercab.geo.GeoManager;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class PayPalUtils
{
  private static final Locale LOCALE_AUSTRALIA = new Locale("en", "AU");
  private static final Locale LOCALE_AUSTRIA = new Locale("de", "AT");
  private static final Locale LOCALE_BELGIUM = new Locale("nl", "BE");
  private static final Locale LOCALE_IRELAND = new Locale("en", "IE");
  private static final Locale LOCALE_NETHERLANDS = new Locale("nl", "NL");
  private static final List<Locale> LOCALE_WHITE_LIST = new ImmutableList.Builder().add(LOCALE_AUSTRALIA).add(LOCALE_AUSTRIA).add(LOCALE_BELGIUM).add(Locale.GERMANY).add(Locale.FRANCE).add(LOCALE_IRELAND).add(Locale.ITALY).add(LOCALE_NETHERLANDS).add(Locale.US).build();
  public static String TEST_CORRELATION_ID = null;

  public static String getCorrelationId(Activity paramActivity)
  {
    if ((RiderApplication.get(paramActivity).isRunningInTests()) && (!TextUtils.isEmpty(TEST_CORRELATION_ID)))
      return TEST_CORRELATION_ID;
    return PayPalConfiguration.getApplicationCorrelationId(paramActivity);
  }

  public static boolean isSupported(Context paramContext, GeoManager paramGeoManager)
  {
    if (paramGeoManager.getGeo() == 3);
    String str;
    Iterator localIterator;
    do
      while (!localIterator.hasNext())
      {
        return false;
        str = ((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso();
        if (TextUtils.isEmpty(str))
          return LOCALE_WHITE_LIST.contains(Locale.getDefault());
        localIterator = LOCALE_WHITE_LIST.iterator();
      }
    while (!str.equalsIgnoreCase(((Locale)localIterator.next()).getCountry()));
    return true;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.paypal.PayPalUtils
 * JD-Core Version:    0.6.2
 */