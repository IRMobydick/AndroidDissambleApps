package com.paypal.android.sdk.payments;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class b
{
  private Context a;

  static
  {
    b.class.getSimpleName();
  }

  b(Context paramContext)
  {
    this.a = paramContext;
  }

  final void a(Collection paramCollection)
  {
    try
    {
      PackageInfo localPackageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 1);
      HashSet localHashSet = new HashSet(paramCollection);
      if (localPackageInfo.activities != null)
      {
        ActivityInfo[] arrayOfActivityInfo = localPackageInfo.activities;
        int i = arrayOfActivityInfo.length;
        for (int j = 0; j < i; j++)
          localHashSet.remove(arrayOfActivityInfo[j].name);
      }
      if (!localHashSet.isEmpty())
        throw new RuntimeException("Missing required activities in manifest:" + localHashSet);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new RuntimeException("Exception loading manifest" + localNameNotFoundException.getMessage());
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.b
 * JD-Core Version:    0.6.2
 */