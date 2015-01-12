package com.ubercab.client.core.util;

import android.app.Activity;
import android.content.Intent;
import io.card.payment.CardIOActivity;

public final class CardIoUtils
{
  public static Intent createScanIntent(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, CardIOActivity.class);
    localIntent.putExtra("io.card.payment.appToken", paramActivity.getString(2131559125));
    localIntent.putExtra("io.card.payment.requireExpiry", true);
    localIntent.putExtra("io.card.payment.suppressManual", true);
    return localIntent;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.CardIoUtils
 * JD-Core Version:    0.6.2
 */