package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.bh;

public final class PublisherAdView extends ViewGroup
{
  private final bh li;

  public PublisherAdView(Context paramContext)
  {
    super(paramContext);
    this.li = new bh(this);
  }

  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.li = new bh(this, paramAttributeSet, true);
  }

  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.li = new bh(this, paramAttributeSet, true);
  }

  public void destroy()
  {
    this.li.destroy();
  }

  public AdListener getAdListener()
  {
    return this.li.getAdListener();
  }

  public AdSize getAdSize()
  {
    return this.li.getAdSize();
  }

  public AdSize[] getAdSizes()
  {
    return this.li.getAdSizes();
  }

  public String getAdUnitId()
  {
    return this.li.getAdUnitId();
  }

  public AppEventListener getAppEventListener()
  {
    return this.li.getAppEventListener();
  }

  public String getMediationAdapterClassName()
  {
    return this.li.getMediationAdapterClassName();
  }

  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    this.li.a(paramPublisherAdRequest.V());
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int i = localView.getMeasuredWidth();
      int j = localView.getMeasuredHeight();
      int k = (paramInt3 - paramInt1 - i) / 2;
      int m = (paramInt4 - paramInt2 - j) / 2;
      localView.layout(k, m, i + k, j + m);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(0);
    AdSize localAdSize = getAdSize();
    int j;
    int i;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      measureChild(localView, paramInt1, paramInt2);
      j = localView.getMeasuredWidth();
      i = localView.getMeasuredHeight();
    }
    while (true)
    {
      int k = Math.max(j, getSuggestedMinimumWidth());
      int m = Math.max(i, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSize(k, paramInt1), View.resolveSize(m, paramInt2));
      return;
      if (localAdSize != null)
      {
        Context localContext = getContext();
        j = localAdSize.getWidthInPixels(localContext);
        i = localAdSize.getHeightInPixels(localContext);
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
  }

  public void pause()
  {
    this.li.pause();
  }

  public void recordManualImpression()
  {
    this.li.recordManualImpression();
  }

  public void resume()
  {
    this.li.resume();
  }

  public void setAdListener(AdListener paramAdListener)
  {
    this.li.setAdListener(paramAdListener);
  }

  public void setAdSizes(AdSize[] paramArrayOfAdSize)
  {
    if ((paramArrayOfAdSize == null) || (paramArrayOfAdSize.length < 1))
      throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
    this.li.a(paramArrayOfAdSize);
  }

  public void setAdUnitId(String paramString)
  {
    this.li.setAdUnitId(paramString);
  }

  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.li.setAppEventListener(paramAppEventListener);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.doubleclick.PublisherAdView
 * JD-Core Version:    0.6.2
 */