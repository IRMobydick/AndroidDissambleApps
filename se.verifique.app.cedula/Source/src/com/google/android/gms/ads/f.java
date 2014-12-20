package com.google.android.gms.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.ak;

public final class f extends ViewGroup
{
  private final ak a = new ak(this);

  public f(Context paramContext)
  {
    super(paramContext);
  }

  public void a()
  {
    this.a.a();
  }

  public void a(b paramb)
  {
    this.a.a(paramb.a());
  }

  public void b()
  {
    this.a.f();
  }

  public void c()
  {
    this.a.g();
  }

  public a getAdListener()
  {
    return this.a.b();
  }

  public e getAdSize()
  {
    return this.a.c();
  }

  public String getAdUnitId()
  {
    return this.a.d();
  }

  public com.google.android.gms.ads.d.b getInAppPurchaseListener()
  {
    return this.a.e();
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
    int i = 0;
    View localView = getChildAt(0);
    e locale = getAdSize();
    int j;
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
      if (locale != null)
      {
        Context localContext = getContext();
        j = locale.b(localContext);
        i = locale.a(localContext);
        continue;
      }
      j = 0;
    }
  }

  public void setAdListener(a parama)
  {
    this.a.a(parama);
  }

  public void setAdSize(e parame)
  {
    ak localak = this.a;
    e[] arrayOfe = new e[1];
    arrayOfe[0] = parame;
    localak.a(arrayOfe);
  }

  public void setAdUnitId(String paramString)
  {
    this.a.a(paramString);
  }

  public void setInAppPurchaseListener(com.google.android.gms.ads.d.b paramb)
  {
    this.a.a(paramb);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.f
 * JD-Core Version:    0.6.0
 */