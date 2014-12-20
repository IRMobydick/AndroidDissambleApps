package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class hk extends WebView
  implements DownloadListener
{
  private final hm a;
  private final hl b;
  private final Object c = new Object();
  private final mw d;
  private final ev e;
  private co f;
  private al g;
  private boolean h;
  private boolean i;
  private boolean j;
  private final WindowManager k;

  private hk(hl paramhl, al paramal, boolean paramBoolean1, boolean paramBoolean2, mw parammw, ev paramev)
  {
    super(paramhl);
    this.b = paramhl;
    this.g = paramal;
    this.h = paramBoolean1;
    this.d = parammw;
    this.e = paramev;
    this.k = ((WindowManager)getContext().getSystemService("window"));
    setBackgroundColor(0);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSavePassword(false);
    localWebSettings.setSupportMultipleWindows(true);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    gw.a(paramhl, paramev.c, localWebSettings);
    if (Build.VERSION.SDK_INT >= 17)
    {
      hf.a(getContext(), localWebSettings);
      setDownloadListener(this);
      if (Build.VERSION.SDK_INT < 11)
        break label202;
      this.a = new is(this, paramBoolean2);
      label149: setWebViewClient(this.a);
      if (Build.VERSION.SDK_INT < 14)
        break label219;
      setWebChromeClient(new it(this));
    }
    while (true)
    {
      l();
      return;
      if (Build.VERSION.SDK_INT < 11)
        break;
      he.a(getContext(), localWebSettings);
      break;
      label202: this.a = new hm(this, paramBoolean2);
      break label149;
      label219: if (Build.VERSION.SDK_INT < 11)
        continue;
      setWebChromeClient(new hp(this));
    }
  }

  public static hk a(Context paramContext, al paramal, boolean paramBoolean1, boolean paramBoolean2, mw parammw, ev paramev)
  {
    return new hk(new hl(paramContext), paramal, paramBoolean1, paramBoolean2, parammw, paramev);
  }

  // ERROR //
  private void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/google/android/gms/internal/hk:c	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 44	com/google/android/gms/internal/hk:h	Z
    //   11: ifne +13 -> 24
    //   14: aload_0
    //   15: getfield 42	com/google/android/gms/internal/hk:g	Lcom/google/android/gms/internal/al;
    //   18: getfield 154	com/google/android/gms/internal/al:f	Z
    //   21: ifeq +40 -> 61
    //   24: getstatic 103	android/os/Build$VERSION:SDK_INT	I
    //   27: bipush 14
    //   29: if_icmpge +15 -> 44
    //   32: ldc 156
    //   34: invokestatic 161	com/google/android/gms/internal/hi:a	(Ljava/lang/String;)V
    //   37: aload_0
    //   38: invokespecial 164	com/google/android/gms/internal/hk:m	()V
    //   41: aload_1
    //   42: monitorexit
    //   43: return
    //   44: ldc 166
    //   46: invokestatic 161	com/google/android/gms/internal/hi:a	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: invokespecial 169	com/google/android/gms/internal/hk:n	()V
    //   53: goto -12 -> 41
    //   56: astore_2
    //   57: aload_1
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    //   61: getstatic 103	android/os/Build$VERSION:SDK_INT	I
    //   64: bipush 18
    //   66: if_icmpge +15 -> 81
    //   69: ldc 171
    //   71: invokestatic 161	com/google/android/gms/internal/hi:a	(Ljava/lang/String;)V
    //   74: aload_0
    //   75: invokespecial 164	com/google/android/gms/internal/hk:m	()V
    //   78: goto -37 -> 41
    //   81: ldc 173
    //   83: invokestatic 161	com/google/android/gms/internal/hi:a	(Ljava/lang/String;)V
    //   86: aload_0
    //   87: invokespecial 169	com/google/android/gms/internal/hk:n	()V
    //   90: goto -49 -> 41
    //
    // Exception table:
    //   from	to	target	type
    //   7	59	56	finally
    //   61	90	56	finally
  }

  private void m()
  {
    synchronized (this.c)
    {
      if ((!this.i) && (Build.VERSION.SDK_INT >= 11))
        he.a(this);
      this.i = true;
      return;
    }
  }

  private void n()
  {
    synchronized (this.c)
    {
      if ((this.i) && (Build.VERSION.SDK_INT >= 11))
        he.b(this);
      this.i = false;
      return;
    }
  }

  public void a()
  {
    if (!f().a());
    while (true)
    {
      return;
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      Display localDisplay = this.k.getDefaultDisplay();
      localDisplay.getMetrics(localDisplayMetrics);
      int m = gw.c(getContext());
      float f1 = 160.0F / localDisplayMetrics.densityDpi;
      int n = (int)(f1 * localDisplayMetrics.widthPixels);
      int i1 = (int)(f1 * (localDisplayMetrics.heightPixels - m));
      try
      {
        b("onScreenInfoChanged", new JSONObject().put("width", n).put("height", i1).put("density", localDisplayMetrics.density).put("rotation", localDisplay.getRotation()));
      }
      catch (JSONException localJSONException)
      {
        hi.b("Error occured while obtaining screen information.", localJSONException);
      }
    }
  }

  public void a(Context paramContext, al paramal)
  {
    synchronized (this.c)
    {
      this.b.setBaseContext(paramContext);
      this.f = null;
      this.g = paramal;
      this.h = false;
      gw.b(this);
      loadUrl("about:blank");
      this.a.b();
      return;
    }
  }

  public void a(al paramal)
  {
    synchronized (this.c)
    {
      this.g = paramal;
      requestLayout();
      return;
    }
  }

  public void a(co paramco)
  {
    synchronized (this.c)
    {
      this.f = paramco;
      return;
    }
  }

  protected void a(String paramString)
  {
    synchronized (this.c)
    {
      if (!k())
      {
        loadUrl(paramString);
        return;
      }
      hi.e("The webview is destroyed. Ignoring action.");
    }
  }

  public void a(String paramString, Map paramMap)
  {
    try
    {
      JSONObject localJSONObject = gw.a(paramMap);
      b(paramString, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        hi.e("Could not convert parameters to JSON.");
    }
  }

  public void a(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      paramJSONObject = new JSONObject();
    String str = paramJSONObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:" + paramString + "(");
    localStringBuilder.append(str);
    localStringBuilder.append(");");
    a(localStringBuilder.toString());
  }

  public void a(boolean paramBoolean)
  {
    synchronized (this.c)
    {
      this.h = paramBoolean;
      l();
      return;
    }
  }

  public void b()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.e.c);
    a("onhide", localHashMap);
  }

  public void b(String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      paramJSONObject = new JSONObject();
    String str = paramJSONObject.toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:AFMA_ReceiveMessage('");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    localStringBuilder.append(",");
    localStringBuilder.append(str);
    localStringBuilder.append(");");
    hi.d("Dispatching AFMA event: " + localStringBuilder);
    a(localStringBuilder.toString());
  }

  public void c()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.e.c);
    a("onshow", localHashMap);
  }

  public co d()
  {
    synchronized (this.c)
    {
      co localco = this.f;
      return localco;
    }
  }

  public void destroy()
  {
    synchronized (this.c)
    {
      super.destroy();
      this.j = true;
      return;
    }
  }

  public al e()
  {
    synchronized (this.c)
    {
      al localal = this.g;
      return localal;
    }
  }

  public hm f()
  {
    return this.a;
  }

  public mw g()
  {
    return this.d;
  }

  public ev h()
  {
    return this.e;
  }

  public boolean i()
  {
    synchronized (this.c)
    {
      boolean bool = this.h;
      return bool;
    }
  }

  public Context j()
  {
    return this.b.a();
  }

  public boolean k()
  {
    synchronized (this.c)
    {
      boolean bool = this.j;
      return bool;
    }
  }

  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setDataAndType(Uri.parse(paramString1), paramString4);
      getContext().startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      while (true)
        hi.a("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3;
    for (int m = 2147483647; ; m = i3)
    {
      int i2;
      label289: 
      do
      {
        int i1;
        synchronized (this.c)
        {
          if ((isInEditMode()) || (this.h))
          {
            super.onMeasure(paramInt1, paramInt2);
          }
          else
          {
            int n = View.MeasureSpec.getMode(paramInt1);
            i1 = View.MeasureSpec.getSize(paramInt1);
            i2 = View.MeasureSpec.getMode(paramInt2);
            i3 = View.MeasureSpec.getSize(paramInt2);
            if (n == -2147483648)
              break label289;
            if (n == 1073741824)
            {
              break label289;
              if ((this.g.h > i4) || (this.g.e > m))
              {
                float f1 = this.b.getResources().getDisplayMetrics().density;
                hi.e("Not enough space to show ad. Needs " + (int)(this.g.h / f1) + "x" + (int)(this.g.e / f1) + " dp, but only has " + (int)(i1 / f1) + "x" + (int)(i3 / f1) + " dp.");
                if (getVisibility() != 8)
                  setVisibility(4);
                setMeasuredDimension(0, 0);
              }
            }
          }
        }
        int i4 = i1;
      }
      while ((i2 != -2147483648) && (i2 != 1073741824));
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d != null)
      this.d.a(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }

  public void setContext(Context paramContext)
  {
    this.b.setBaseContext(paramContext);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hk
 * JD-Core Version:    0.6.0
 */