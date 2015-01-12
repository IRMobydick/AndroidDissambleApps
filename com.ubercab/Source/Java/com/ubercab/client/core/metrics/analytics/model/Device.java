package com.ubercab.client.core.metrics.analytics.model;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import com.ubercab.library.util.DeviceUtils;
import com.ubercab.library.vendor.google.GoogleUtils;
import java.util.Locale;
import java.util.MissingResourceException;

final class Device
{
  private String google_play_services_status;
  private String google_play_services_version;
  private String id;
  private String language;
  private String model;
  private String os = "android";
  private String os_version;
  private String region_ios2;
  private String serial_number;
  private boolean voiceover;

  Device(Context paramContext)
  {
    this.id = DeviceUtils.getDeviceId(paramContext);
    this.os_version = Build.VERSION.RELEASE;
    this.model = Build.MODEL;
    Locale localLocale = Locale.getDefault();
    try
    {
      this.language = localLocale.getISO3Language();
      this.region_ios2 = localLocale.getISO3Country();
      this.serial_number = Build.SERIAL;
      AccessibilityManager localAccessibilityManager = (AccessibilityManager)paramContext.getSystemService("accessibility");
      if (localAccessibilityManager != null)
      {
        boolean bool1 = localAccessibilityManager.isEnabled();
        boolean bool2 = localAccessibilityManager.isTouchExplorationEnabled();
        if ((bool1) && (bool2))
        {
          bool3 = true;
          this.voiceover = bool3;
        }
      }
      else
      {
        this.google_play_services_status = GoogleUtils.getGooglePlayServicesStatus(paramContext);
        this.google_play_services_version = GoogleUtils.getGooglePlayServicesVersionName(paramContext);
        return;
      }
    }
    catch (MissingResourceException localMissingResourceException)
    {
      while (true)
      {
        this.language = null;
        this.region_ios2 = null;
        continue;
        boolean bool3 = false;
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.metrics.analytics.model.Device
 * JD-Core Version:    0.6.2
 */