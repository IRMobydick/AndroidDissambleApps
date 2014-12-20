package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public final class cm
{
  public static boolean a(Context paramContext, ce paramce, da paramda)
  {
    int i = 0;
    if (paramce == null)
      hi.e("No intent data for launcher overlay.");
    while (true)
    {
      return i;
      Intent localIntent = new Intent();
      if (TextUtils.isEmpty(paramce.d))
      {
        hi.e("Open GMSG did not contain a URL.");
        continue;
      }
      if (!TextUtils.isEmpty(paramce.e))
        localIntent.setDataAndType(Uri.parse(paramce.d), paramce.e);
      String[] arrayOfString;
      while (true)
      {
        localIntent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(paramce.f))
          localIntent.setPackage(paramce.f);
        if (TextUtils.isEmpty(paramce.g))
          break label182;
        arrayOfString = paramce.g.split("/", 2);
        if (arrayOfString.length >= 2)
          break label168;
        hi.e("Could not parse component name from open GMSG: " + paramce.g);
        break;
        localIntent.setData(Uri.parse(paramce.d));
      }
      label168: localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
      try
      {
        label182: hi.d("Launching an intent: " + localIntent);
        paramContext.startActivity(localIntent);
        paramda.q();
        i = 1;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        hi.e(localActivityNotFoundException.getMessage());
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cm
 * JD-Core Version:    0.6.0
 */