package com.ubercab.library.metrics.analytics;

import android.content.Intent;
import com.ubercab.library.metrics.analytics.session.ForegroundIntentName;
import java.util.Set;

public final class AnalyticsUtils
{
  public static ForegroundIntentName getNameForForeground(Intent paramIntent)
  {
    if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.intent.action.MAIN")) && (paramIntent.getCategories() != null) && (paramIntent.getCategories().contains("android.intent.category.LAUNCHER")))
      return ForegroundIntentName.ICON;
    return ForegroundIntentName.NONE;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.metrics.analytics.AnalyticsUtils
 * JD-Core Version:    0.6.2
 */