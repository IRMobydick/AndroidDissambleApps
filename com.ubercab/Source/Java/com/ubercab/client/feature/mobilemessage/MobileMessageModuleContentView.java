package com.ubercab.client.feature.mobilemessage;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout.LayoutParams;
import com.ubercab.client.core.model.MobileMessageModule;
import com.ubercab.client.core.util.TextObjectParser;

public class MobileMessageModuleContentView extends WebView
{
  int mContentIndex;
  Listener mListener;

  public MobileMessageModuleContentView(Context paramContext)
  {
    this(paramContext, null);
  }

  public MobileMessageModuleContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public MobileMessageModuleContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setScrollContainer(false);
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    setBackgroundColor(0);
    setLayerType(1, null);
    setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
  }

  public void loadContent(MobileMessageModule paramMobileMessageModule, int paramInt, Object paramObject)
  {
    this.mContentIndex = paramInt;
    TextObjectParser localTextObjectParser = new TextObjectParser(paramObject);
    setWebViewClient(new MobileMessageWebViewClient(null));
    loadDataWithBaseURL(null, localTextObjectParser.parse(paramMobileMessageModule.getHtmlContent(paramInt)), "text/html", "utf-8", null);
  }

  public void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  public static abstract interface Listener
  {
    public abstract void onPageReadyForDisplay(int paramInt);

    public abstract void onUrlClicked(String paramString);
  }

  private class MobileMessageWebViewClient extends WebViewClient
  {
    private MobileMessageWebViewClient()
    {
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (MobileMessageModuleContentView.this.mListener != null)
        MobileMessageModuleContentView.this.mListener.onPageReadyForDisplay(MobileMessageModuleContentView.this.mContentIndex);
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (TextUtils.isEmpty(paramString));
      while (MobileMessageModuleContentView.this.mListener == null)
        return true;
      MobileMessageModuleContentView.this.mListener.onUrlClicked(paramString);
      return true;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.MobileMessageModuleContentView
 * JD-Core Version:    0.6.2
 */