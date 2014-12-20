package co.vine.android;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class CaptchaActivity$1 extends WebViewClient
{
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    paramWebView.setVisibility(8);
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    int i = 0;
    Uri localUri = Uri.parse(paramString);
    if ((localUri.getScheme().equals("vine")) || (localUri.getScheme().equals("vine-dev")))
    {
      if ("_captcha_complete".equals(localUri.getHost()))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("rid", CaptchaActivity.access$000(this.this$0));
        this.this$0.setResult(-1, localIntent);
        new CaptchaActivity.1.1(this).execute(new Void[0]);
        this.this$0.finish();
      }
      i = 1;
    }
    return i;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.CaptchaActivity.1
 * JD-Core Version:    0.6.0
 */