package com.ubercab.client.feature.employeeupgrade;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class EmployeeUpgradeUtils
{
  private static final String INTENT_TYPE = "application/vnd.android.package-archive";

  public static void startInstallIntent(Context paramContext, Uri paramUri)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(paramUri, "application/vnd.android.package-archive");
    localIntent.setFlags(268435456);
    paramContext.startActivity(localIntent);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.employeeupgrade.EmployeeUpgradeUtils
 * JD-Core Version:    0.6.2
 */