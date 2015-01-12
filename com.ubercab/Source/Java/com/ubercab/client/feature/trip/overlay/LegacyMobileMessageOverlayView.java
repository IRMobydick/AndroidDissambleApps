package com.ubercab.client.feature.trip.overlay;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnTouch;
import com.ubercab.client.core.app.RiderApplication;
import com.ubercab.client.core.model.LegacyMobileMessage;
import com.ubercab.client.core.util.HTMLUtils;
import com.ubercab.client.feature.mobilemessage.LegacyMobileMessageManager;
import javax.inject.Inject;

public class LegacyMobileMessageOverlayView extends FrameLayout
{
  private LegacyMobileMessage mLegacyMobileMessage;

  @Inject
  LegacyMobileMessageManager mLegacyMobileMessageManager;

  @InjectView(2131427487)
  WebView mWebView;

  public LegacyMobileMessageOverlayView(Context paramContext)
  {
    this(paramContext, null);
  }

  public LegacyMobileMessageOverlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public LegacyMobileMessageOverlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
      RiderApplication.get(paramContext).inject(this);
  }

  private String getHtmlToDisplay()
  {
    return HTMLUtils.setTransparentBackground(HTMLUtils.removeImage(this.mLegacyMobileMessage.getHtml(), getResources().getString(2131559284)));
  }

  private void initializeWebView()
  {
    this.mWebView.setBackgroundColor(0);
    this.mWebView.setWebViewClient(new WebViewClient()
    {
      public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        if (jdField_this.getParent() == null)
          return;
        super.onPageFinished(paramAnonymousWebView, paramAnonymousString);
        jdField_this.setVisibility(0);
      }
    });
    this.mWebView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
  }

  public void onFinishInflate()
  {
    super.onFinishInflate();
    ButterKnife.inject(this);
    initializeWebView();
  }

  @OnTouch({2131427486})
  public boolean onTouchDismissOverlay()
  {
    setVisibility(8);
    return true;
  }

  public void populateHTML(LegacyMobileMessage paramLegacyMobileMessage)
  {
    this.mLegacyMobileMessage = paramLegacyMobileMessage;
    this.mWebView.loadDataWithBaseURL(null, getHtmlToDisplay(), "text/html", "utf-8", null);
  }

  public void setVisibility(int paramInt)
  {
    if ((paramInt == 8) && (this.mLegacyMobileMessage != null))
      this.mLegacyMobileMessageManager.setMobileMessageSeen(this.mLegacyMobileMessage.getId());
    super.setVisibility(paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.overlay.LegacyMobileMessageOverlayView
 * JD-Core Version:    0.6.2
 */