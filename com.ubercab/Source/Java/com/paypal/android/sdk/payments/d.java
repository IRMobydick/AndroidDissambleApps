package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.util.Log;
import android.widget.TextView;
import com.paypal.android.sdk.R;
import com.paypal.android.sdk.bE;
import com.paypal.android.sdk.bF;
import com.paypal.android.sdk.bG;
import com.paypal.android.sdk.bl;
import java.util.Locale;

class d
{
  d(FuturePaymentConsentActivity paramFuturePaymentConsentActivity)
  {
  }

  static AlertDialog a(Activity paramActivity, bG parambG1, bG parambG2, DialogInterface.OnClickListener paramOnClickListener)
  {
    return new AlertDialog.Builder(paramActivity).setIcon(17301543).setTitle(bF.a(parambG1)).setMessage(bF.a(parambG2)).setPositiveButton(bF.a(bG.E), paramOnClickListener).setNegativeButton(bF.a(bG.c), null).create();
  }

  private static AlertDialog a(Context paramContext, bG parambG, String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    String str1 = bF.a(parambG);
    String str2 = bF.a(bG.E);
    return new AlertDialog.Builder(paramContext).setMessage(paramString).setCancelable(false).setTitle(str1).setPositiveButton(str2, paramOnClickListener).create();
  }

  static Dialog a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    return new AlertDialog.Builder(paramActivity).setIcon(17301543).setCancelable(false).setTitle(bF.a(bG.S)).setMessage(bF.a(bG.N)).setPositiveButton(bF.a(bG.S), paramOnClickListener).setNegativeButton(bF.a(bG.c), new g(paramActivity)).create();
  }

  static Dialog a(Activity paramActivity, bG parambG, Bundle paramBundle)
  {
    return a(paramActivity, parambG, paramBundle.getString("alert_errors"), new e());
  }

  static Dialog a(Activity paramActivity, bG parambG, Bundle paramBundle, int paramInt)
  {
    return a(paramActivity, parambG, paramBundle.getString("alert_errors"), new f(paramActivity, paramInt));
  }

  static Dialog a(Activity paramActivity, bG parambG, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    return a(paramActivity, parambG, paramBundle.getString("alert_errors"), paramOnClickListener);
  }

  static Dialog a(Context paramContext, bG parambG1, bG parambG2)
  {
    ProgressDialog localProgressDialog = new ProgressDialog(paramContext);
    localProgressDialog.setTitle(bF.a(parambG1));
    localProgressDialog.setMessage(bF.a(parambG2));
    localProgressDialog.setCancelable(false);
    return localProgressDialog;
  }

  static SpannableString a(String paramString)
  {
    String str1 = Locale.getDefault().getCountry().toLowerCase(Locale.US);
    if ((R.c(str1)) || (!str1.equals("jp")))
      return null;
    String str2 = bF.a(bG.z);
    Object[] arrayOfObject = new Object[2];
    if ((R.d(paramString)) && (paramString.equals("ja")));
    for (String str3 = "https://cms.paypal.com/jp/cgi-bin/marketingweb?cmd=_render-content&content_ID=ua/Legal_Hub_full&locale.x=ja_JP"; ; str3 = "https://cms.paypal.com/jp/cgi-bin/marketingweb?cmd=_render-content&content_ID=ua/Legal_Hub_full&locale.x=en_US")
    {
      arrayOfObject[0] = str3;
      arrayOfObject[1] = "https://www.paypal.jp/jp/contents/regulation/info/overseas-remittance/";
      return new SpannableString(Html.fromHtml(String.format(str2, arrayOfObject)));
    }
  }

  static void a(Activity paramActivity, TextView paramTextView, bG parambG)
  {
    if (parambG != null);
    for (String str = bF.a(parambG); ; str = "")
    {
      Bitmap localBitmap = bl.a("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyRpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoTWFjaW50b3NoKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpCNDMzRTRFQ0M2MjQxMUUzOURBQ0E3QTY0NjU3OUI5QiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpCNDMzRTRFREM2MjQxMUUzOURBQ0E3QTY0NjU3OUI5QiI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOkI0MzNFNEVBQzYyNDExRTM5REFDQTdBNjQ2NTc5QjlCIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOkI0MzNFNEVCQzYyNDExRTM5REFDQTdBNjQ2NTc5QjlCIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+Eyd0MQAABoFJREFUeNrMWl1M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", paramActivity, 240);
      R.a(paramActivity, paramTextView, str, "PayPal - ", new BitmapDrawable(paramActivity.getResources(), localBitmap));
      return;
    }
  }

  static void a(Activity paramActivity, Z paramZ, int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramZ.a != null) && (paramZ.a.intValue() >= 500)) || (paramZ.b.equals(com.paypal.android.sdk.f.b.toString())));
    for (int i = 1; i != 0; i = 0)
    {
      paramActivity.showDialog(2);
      return;
    }
    if ((paramZ.a()) && ("invalid_client".equals(paramZ.b)))
    {
      a(paramActivity, bF.a(bG.V), 3);
      return;
    }
    a(paramActivity, bF.a(bG.T), 1);
  }

  static void a(Activity paramActivity, String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("alert_errors", paramString);
    paramActivity.removeDialog(paramInt);
    paramActivity.showDialog(paramInt, localBundle);
  }

  static void a(TextView paramTextView, String paramString)
  {
    if (paramTextView != null)
    {
      if ((paramString == null) || (paramString.equals("live")))
        paramTextView.setVisibility(8);
    }
    else
      return;
    if (paramString.startsWith("sandbox"))
    {
      paramTextView.setText(bF.a(bG.s));
      return;
    }
    if (paramString.equals("mock"))
    {
      paramTextView.setText(bF.a(bG.r));
      return;
    }
    paramTextView.setText(paramString);
  }

  static boolean a(Activity paramActivity)
  {
    String str1 = paramActivity.getClass().getName();
    ComponentName localComponentName = paramActivity.getCallingActivity();
    if (localComponentName == null)
    {
      Log.e(str1, str1 + " called by a null activity, not allowed");
      return false;
    }
    String str2 = localComponentName.getClassName();
    if (!str2.startsWith("com.paypal.android.sdk.payments."))
    {
      Log.e(str1, str1 + " called by " + str2 + " which is not part of the SDK, not allowed");
      return false;
    }
    return true;
  }

  static boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = R.a(paramString2);
    if (bool1)
      Log.e(paramString1, paramString3 + " is empty.");
    boolean bool2 = R.e(paramString2);
    if (bool2)
      Log.e(paramString1, paramString3 + " contains whitespace.");
    return (!bool1) && (!bool2);
  }

  static Intent b(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), PayPalService.class);
    localIntent.putExtras(paramActivity.getIntent());
    return localIntent;
  }

  public void a()
  {
    FuturePaymentConsentActivity.a(this.a, bE.v);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.payments.d
 * JD-Core Version:    0.6.2
 */