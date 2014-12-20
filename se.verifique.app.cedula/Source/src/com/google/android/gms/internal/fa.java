package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View.MeasureSpec;
import android.webkit.WebView;

public final class fa extends AsyncTask
{
  private final WebView b;
  private Bitmap c;

  public fa(ez paramez, WebView paramWebView)
  {
    this.b = paramWebView;
  }

  protected Boolean a(Void[] paramArrayOfVoid)
  {
    monitorenter;
    while (true)
    {
      int k;
      int n;
      try
      {
        int i = this.c.getWidth();
        int j = this.c.getHeight();
        if ((i != 0) && (j != 0))
          continue;
        Boolean localBoolean1 = Boolean.valueOf(false);
        Object localObject2 = localBoolean1;
        return localObject2;
        k = 0;
        int m = 0;
        if (k >= i)
          continue;
        n = 0;
        if (n >= j)
          break label139;
        if (this.c.getPixel(k, n) != 0)
        {
          m++;
          break label133;
          if (m / (i * j / 100.0D) <= 0.1D)
            continue;
          boolean bool = true;
          Boolean localBoolean2 = Boolean.valueOf(bool);
          localObject2 = localBoolean2;
          continue;
          bool = false;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      label133: n += 10;
      continue;
      label139: k += 10;
    }
  }

  protected void a(Boolean paramBoolean)
  {
    ez.c(this.a);
    if ((paramBoolean.booleanValue()) || (this.a.c()) || (ez.d(this.a) <= 0L))
    {
      this.a.c = paramBoolean.booleanValue();
      ez.e(this.a).a(this.a.a);
    }
    while (true)
    {
      return;
      if (ez.d(this.a) > 0L)
      {
        if (hi.a(2))
          hi.a("Ad not detected, scheduling another run.");
        ez.g(this.a).postDelayed(this.a, ez.f(this.a));
        continue;
      }
    }
  }

  protected void onPreExecute()
  {
    monitorenter;
    try
    {
      this.c = Bitmap.createBitmap(ez.a(this.a), ez.b(this.a), Bitmap.Config.ARGB_8888);
      this.b.setVisibility(0);
      this.b.measure(View.MeasureSpec.makeMeasureSpec(ez.a(this.a), 0), View.MeasureSpec.makeMeasureSpec(ez.b(this.a), 0));
      this.b.layout(0, 0, ez.a(this.a), ez.b(this.a));
      Canvas localCanvas = new Canvas(this.c);
      this.b.draw(localCanvas);
      this.b.invalidate();
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fa
 * JD-Core Version:    0.6.0
 */