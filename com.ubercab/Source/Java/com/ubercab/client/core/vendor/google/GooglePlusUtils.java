package com.ubercab.client.core.vendor.google;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.auth.GoogleAuthUtil;
import timber.log.Timber;

public final class GooglePlusUtils
{
  public static void clearTokenInBackground(Context paramContext, final String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return;
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          GoogleAuthUtil.clearToken(this.val$context, paramString);
          return;
        }
        catch (Exception localException)
        {
          Timber.i(localException, "Failed to clear google token", new Object[0]);
        }
      }
    }).start();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.GooglePlusUtils
 * JD-Core Version:    0.6.2
 */