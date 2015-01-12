package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

@ez
public final class dh
{
  public static boolean a(Context paramContext, dj paramdj, dq paramdq)
  {
    if (paramdj == null)
    {
      gs.W("No intent data for launcher overlay.");
      return false;
    }
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(paramdj.rq))
    {
      gs.W("Open GMSG did not contain a URL.");
      return false;
    }
    if (!TextUtils.isEmpty(paramdj.mimeType))
      localIntent.setDataAndType(Uri.parse(paramdj.rq), paramdj.mimeType);
    String[] arrayOfString;
    while (true)
    {
      localIntent.setAction("android.intent.action.VIEW");
      if (!TextUtils.isEmpty(paramdj.packageName))
        localIntent.setPackage(paramdj.packageName);
      if (TextUtils.isEmpty(paramdj.rr))
        break label172;
      arrayOfString = paramdj.rr.split("/", 2);
      if (arrayOfString.length >= 2)
        break;
      gs.W("Could not parse component name from open GMSG: " + paramdj.rr);
      return false;
      localIntent.setData(Uri.parse(paramdj.rq));
    }
    localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
    try
    {
      label172: gs.V("Launching an intent: " + localIntent);
      paramContext.startActivity(localIntent);
      paramdq.ab();
      return true;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      gs.W(localActivityNotFoundException.getMessage());
    }
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dh
 * JD-Core Version:    0.6.2
 */