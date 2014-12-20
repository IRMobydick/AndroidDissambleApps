package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class hp extends WebChromeClient
{
  private final hk a;

  public hp(hk paramhk)
  {
    this.a = paramhk;
  }

  private static void a(AlertDialog.Builder paramBuilder, String paramString, JsResult paramJsResult)
  {
    paramBuilder.setMessage(paramString).setPositiveButton(17039370, new hu(paramJsResult)).setNegativeButton(17039360, new hs(paramJsResult)).setOnCancelListener(new hq(paramJsResult)).create().show();
  }

  private static void a(Context paramContext, AlertDialog.Builder paramBuilder, String paramString1, String paramString2, JsPromptResult paramJsPromptResult)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString1);
    EditText localEditText = new EditText(paramContext);
    localEditText.setText(paramString2);
    localLinearLayout.addView(localTextView);
    localLinearLayout.addView(localEditText);
    paramBuilder.setView(localLinearLayout).setPositiveButton(17039370, new hz(paramJsPromptResult, localEditText)).setNegativeButton(17039360, new hx(paramJsPromptResult)).setOnCancelListener(new hw(paramJsPromptResult)).create().show();
  }

  protected final void a(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    co localco = this.a.d();
    if (localco == null)
    {
      hi.e("Could not get ad overlay when showing custom view.");
      paramCustomViewCallback.onCustomViewHidden();
    }
    while (true)
    {
      return;
      localco.a(paramView, paramCustomViewCallback);
      localco.a(paramInt);
    }
  }

  protected boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, JsResult paramJsResult, JsPromptResult paramJsPromptResult, boolean paramBoolean)
  {
    try
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
      localBuilder.setTitle(paramString1);
      if (paramBoolean)
        a(paramContext, localBuilder, paramString2, paramString3, paramJsPromptResult);
      else
        a(localBuilder, paramString2, paramJsResult);
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      hi.c("Fail to display Dialog.", localBadTokenException);
    }
    return true;
  }

  public final void onCloseWindow(WebView paramWebView)
  {
    if (!(paramWebView instanceof hk))
      hi.e("Tried to close a WebView that wasn't an AdWebView.");
    while (true)
    {
      return;
      co localco = ((hk)paramWebView).d();
      if (localco == null)
      {
        hi.e("Tried to close an AdWebView not associated with an overlay.");
        continue;
      }
      localco.a();
    }
  }

  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    String str = "JS: " + paramConsoleMessage.message() + " (" + paramConsoleMessage.sourceId() + ":" + paramConsoleMessage.lineNumber() + ")";
    switch (ia.a[paramConsoleMessage.messageLevel().ordinal()])
    {
    default:
      hi.c(str);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      hi.b(str);
      continue;
      hi.e(str);
      continue;
      hi.c(str);
      continue;
      hi.a(str);
    }
  }

  public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    WebView.WebViewTransport localWebViewTransport = (WebView.WebViewTransport)paramMessage.obj;
    WebView localWebView = new WebView(paramWebView.getContext());
    localWebView.setWebViewClient(this.a.f());
    localWebViewTransport.setWebView(localWebView);
    paramMessage.sendToTarget();
    return true;
  }

  public final void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    long l = 5242880L - paramLong3;
    if (l <= 0L)
    {
      paramQuotaUpdater.updateQuota(paramLong1);
      return;
    }
    if (paramLong1 == 0L)
      if ((paramLong2 > l) || (paramLong2 > 1048576L));
    while (true)
    {
      paramQuotaUpdater.updateQuota(paramLong2);
      break;
      paramLong2 = 0L;
      continue;
      if (paramLong2 == 0L)
      {
        paramLong2 = Math.min(paramLong1 + Math.min(131072L, l), 1048576L);
        continue;
      }
      if (paramLong2 <= Math.min(1048576L - paramLong1, l))
        paramLong1 += paramLong2;
      paramLong2 = paramLong1;
    }
  }

  public final void onHideCustomView()
  {
    co localco = this.a.d();
    if (localco == null)
      hi.e("Could not get ad overlay when hiding custom view.");
    while (true)
    {
      return;
      localco.c();
    }
  }

  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    if (((paramWebView instanceof hk)) && (((hk)paramWebView).j() != null));
    for (boolean bool = a(((hk)paramWebView).j(), paramString1, paramString2, null, paramJsResult, null, false); ; bool = a(paramWebView.getContext(), paramString1, paramString2, null, paramJsResult, null, false))
      return bool;
  }

  public final boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(paramWebView.getContext(), paramString1, paramString2, null, paramJsResult, null, false);
  }

  public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(paramWebView.getContext(), paramString1, paramString2, null, paramJsResult, null, false);
  }

  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return a(paramWebView.getContext(), paramString1, paramString2, paramString3, null, paramJsPromptResult, true);
  }

  public final void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    long l1 = 5242880L - paramLong2;
    long l2 = 131072L + paramLong1;
    if (l1 < l2)
      paramQuotaUpdater.updateQuota(0L);
    while (true)
    {
      return;
      paramQuotaUpdater.updateQuota(l2);
    }
  }

  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    a(paramView, -1, paramCustomViewCallback);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hp
 * JD-Core Version:    0.6.0
 */