package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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

@ez
public class gx extends WebChromeClient
{
  private final gv md;

  public gx(gv paramgv)
  {
    this.md = paramgv;
  }

  private static void a(AlertDialog.Builder paramBuilder, String paramString, JsResult paramJsResult)
  {
    paramBuilder.setMessage(paramString).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        this.wY.confirm();
      }
    }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        this.wY.cancel();
      }
    }).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        this.wY.cancel();
      }
    }).create().show();
  }

  private static void a(Context paramContext, AlertDialog.Builder paramBuilder, String paramString1, String paramString2, JsPromptResult paramJsPromptResult)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString1);
    final EditText localEditText = new EditText(paramContext);
    localEditText.setText(paramString2);
    localLinearLayout.addView(localTextView);
    localLinearLayout.addView(localEditText);
    paramBuilder.setView(localLinearLayout).setPositiveButton(17039370, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        this.wZ.confirm(localEditText.getText().toString());
      }
    }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        this.wZ.cancel();
      }
    }).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        this.wZ.cancel();
      }
    }).create().show();
  }

  private final Context c(WebView paramWebView)
  {
    Context localContext;
    if (!(paramWebView instanceof gv))
      localContext = paramWebView.getContext();
    gv localgv;
    do
    {
      return localContext;
      localgv = (gv)paramWebView;
      localContext = localgv.dz();
    }
    while (localContext != null);
    return localgv.getContext();
  }

  protected final void a(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    dk localdk = this.md.dt();
    if (localdk == null)
    {
      gs.W("Could not get ad overlay when showing custom view.");
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    localdk.a(paramView, paramCustomViewCallback);
    localdk.setRequestedOrientation(paramInt);
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
      gs.d("Fail to display Dialog.", localBadTokenException);
    }
    return true;
  }

  public final void onCloseWindow(WebView paramWebView)
  {
    if (!(paramWebView instanceof gv))
    {
      gs.W("Tried to close a WebView that wasn't an AdWebView.");
      return;
    }
    dk localdk = ((gv)paramWebView).dt();
    if (localdk == null)
    {
      gs.W("Tried to close an AdWebView not associated with an overlay.");
      return;
    }
    localdk.close();
  }

  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    String str = "JS: " + paramConsoleMessage.message() + " (" + paramConsoleMessage.sourceId() + ":" + paramConsoleMessage.lineNumber() + ")";
    if (str.contains("Application Cache"))
      return super.onConsoleMessage(paramConsoleMessage);
    switch (7.xb[paramConsoleMessage.messageLevel().ordinal()])
    {
    default:
      gs.U(str);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      gs.T(str);
      continue;
      gs.W(str);
      continue;
      gs.U(str);
      continue;
      gs.S(str);
    }
  }

  public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    WebView.WebViewTransport localWebViewTransport = (WebView.WebViewTransport)paramMessage.obj;
    WebView localWebView = new WebView(paramWebView.getContext());
    localWebView.setWebViewClient(this.md.du());
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
      return;
      paramLong2 = 0L;
      continue;
      if (paramLong2 == 0L)
      {
        paramLong2 = Math.min(paramLong1 + Math.min(131072L, l), 1048576L);
      }
      else
      {
        if (paramLong2 <= Math.min(1048576L - paramLong1, l))
          paramLong1 += paramLong2;
        paramLong2 = paramLong1;
      }
    }
  }

  public final void onHideCustomView()
  {
    dk localdk = this.md.dt();
    if (localdk == null)
    {
      gs.W("Could not get ad overlay when hiding custom view.");
      return;
    }
    localdk.bW();
  }

  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(c(paramWebView), paramString1, paramString2, null, paramJsResult, null, false);
  }

  public final boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(c(paramWebView), paramString1, paramString2, null, paramJsResult, null, false);
  }

  public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return a(c(paramWebView), paramString1, paramString2, null, paramJsResult, null, false);
  }

  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return a(c(paramWebView), paramString1, paramString2, paramString3, null, paramJsPromptResult, true);
  }

  public final void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    long l1 = 5242880L - paramLong2;
    long l2 = 131072L + paramLong1;
    if (l1 < l2)
    {
      paramQuotaUpdater.updateQuota(0L);
      return;
    }
    paramQuotaUpdater.updateQuota(l2);
  }

  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    a(paramView, -1, paramCustomViewCallback);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gx
 * JD-Core Version:    0.6.2
 */