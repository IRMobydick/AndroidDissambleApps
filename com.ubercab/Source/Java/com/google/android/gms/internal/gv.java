package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@ez
public class gv extends WebView
  implements DownloadListener
{
  private final WindowManager mG;
  private final Object mw = new Object();
  private ay qr;
  private final gt qs;
  private final k sX;
  private final gw wH;
  private final a wI;
  private dk wJ;
  private boolean wK;
  private boolean wL;
  private boolean wM;
  private boolean wN;

  protected gv(a parama, ay paramay, boolean paramBoolean1, boolean paramBoolean2, k paramk, gt paramgt)
  {
    super(parama);
    this.wI = parama;
    this.qr = paramay;
    this.wK = paramBoolean1;
    this.sX = paramk;
    this.qs = paramgt;
    this.mG = ((WindowManager)getContext().getSystemService("window"));
    setBackgroundColor(0);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setSavePassword(false);
    localWebSettings.setSupportMultipleWindows(true);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    gj.a(parama, paramgt.wD, localWebSettings);
    if (Build.VERSION.SDK_INT >= 17)
    {
      gp.a(getContext(), localWebSettings);
      setDownloadListener(this);
      if (Build.VERSION.SDK_INT < 11)
        break label202;
      this.wH = new gy(this, paramBoolean2);
      label149: setWebViewClient(this.wH);
      if (Build.VERSION.SDK_INT < 14)
        break label219;
      setWebChromeClient(new gz(this));
    }
    while (true)
    {
      dA();
      return;
      if (Build.VERSION.SDK_INT < 11)
        break;
      gn.a(getContext(), localWebSettings);
      break;
      label202: this.wH = new gw(this, paramBoolean2);
      break label149;
      label219: if (Build.VERSION.SDK_INT >= 11)
        setWebChromeClient(new gx(this));
    }
  }

  public static gv a(Context paramContext, ay paramay, boolean paramBoolean1, boolean paramBoolean2, k paramk, gt paramgt)
  {
    return new gv(new a(paramContext), paramay, paramBoolean1, paramBoolean2, paramk, paramgt);
  }

  private void dA()
  {
    while (true)
    {
      synchronized (this.mw)
      {
        if ((this.wK) || (this.qr.og))
        {
          if (Build.VERSION.SDK_INT < 14)
          {
            gs.S("Disabling hardware acceleration on an overlay.");
            dB();
            return;
          }
          gs.S("Enabling hardware acceleration on an overlay.");
          dC();
        }
      }
      if (Build.VERSION.SDK_INT < 18)
      {
        gs.S("Disabling hardware acceleration on an AdView.");
        dB();
      }
      else
      {
        gs.S("Enabling hardware acceleration on an AdView.");
        dC();
      }
    }
  }

  private void dB()
  {
    synchronized (this.mw)
    {
      if ((!this.wL) && (Build.VERSION.SDK_INT >= 11))
        gn.i(this);
      this.wL = true;
      return;
    }
  }

  private void dC()
  {
    synchronized (this.mw)
    {
      if ((this.wL) && (Build.VERSION.SDK_INT >= 11))
        gn.j(this);
      this.wL = false;
      return;
    }
  }

  protected void X(String paramString)
  {
    synchronized (this.mw)
    {
      if (!isDestroyed())
      {
        loadUrl(paramString);
        return;
      }
      gs.W("The webview is destroyed. Ignoring action.");
    }
  }

  public ay Y()
  {
    synchronized (this.mw)
    {
      ay localay = this.qr;
      return localay;
    }
  }

  public void a(Context paramContext, ay paramay)
  {
    synchronized (this.mw)
    {
      this.wI.setBaseContext(paramContext);
      this.wJ = null;
      this.qr = paramay;
      this.wK = false;
      this.wN = false;
      gj.b(this);
      loadUrl("about:blank");
      this.wH.reset();
      setOnTouchListener(null);
      setOnClickListener(null);
      return;
    }
  }

  public void a(ay paramay)
  {
    synchronized (this.mw)
    {
      this.qr = paramay;
      requestLayout();
      return;
    }
  }

  public void a(dk paramdk)
  {
    synchronized (this.mw)
    {
      this.wJ = paramdk;
      return;
    }
  }

  public void a(String paramString, Map<String, ?> paramMap)
  {
    try
    {
      JSONObject localJSONObject = gj.t(paramMap);
      b(paramString, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      gs.W("Could not convert parameters to JSON.");
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
    X(localStringBuilder.toString());
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
    gs.V("Dispatching AFMA event: " + localStringBuilder);
    X(localStringBuilder.toString());
  }

  public void bS()
  {
    if (!du().dE())
      return;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    Display localDisplay = this.mG.getDefaultDisplay();
    localDisplay.getMetrics(localDisplayMetrics);
    int i = gj.s(getContext());
    float f = 160.0F / localDisplayMetrics.densityDpi;
    int j = Math.round(f * localDisplayMetrics.widthPixels);
    int k = Math.round(f * (localDisplayMetrics.heightPixels - i));
    try
    {
      b("onScreenInfoChanged", new JSONObject().put("width", j).put("height", k).put("density", localDisplayMetrics.density).put("rotation", localDisplay.getRotation()));
      return;
    }
    catch (JSONException localJSONException)
    {
      gs.b("Error occured while obtaining screen information.", localJSONException);
    }
  }

  public void bZ()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.qs.wD);
    a("onshow", localHashMap);
  }

  public void ca()
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("version", this.qs.wD);
    a("onhide", localHashMap);
  }

  public void destroy()
  {
    synchronized (this.mw)
    {
      super.destroy();
      this.wM = true;
      return;
    }
  }

  public dk dt()
  {
    synchronized (this.mw)
    {
      dk localdk = this.wJ;
      return localdk;
    }
  }

  public gw du()
  {
    return this.wH;
  }

  public boolean dv()
  {
    return this.wN;
  }

  public k dw()
  {
    return this.sX;
  }

  public gt dx()
  {
    return this.qs;
  }

  public boolean dy()
  {
    synchronized (this.mw)
    {
      boolean bool = this.wK;
      return bool;
    }
  }

  public Context dz()
  {
    return this.wI.dz();
  }

  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    synchronized (this.mw)
    {
      if (isDestroyed())
      {
        gs.W("The webview is destroyed. Ignoring action.");
        if (paramValueCallback != null)
          paramValueCallback.onReceiveValue(null);
        return;
      }
      super.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
  }

  public boolean isDestroyed()
  {
    synchronized (this.mw)
    {
      boolean bool = this.wM;
      return bool;
    }
  }

  public void o(boolean paramBoolean)
  {
    synchronized (this.mw)
    {
      if (this.wJ != null)
      {
        this.wJ.o(paramBoolean);
        return;
      }
      this.wN = paramBoolean;
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
      gs.S("Couldn't find an Activity to view url/mimetype: " + paramString1 + " / " + paramString4);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n;
    for (int i = 2147483647; ; i = n)
    {
      int m;
      label284: 
      do
      {
        int k;
        while (true)
        {
          synchronized (this.mw)
          {
            if ((isInEditMode()) || (this.wK))
            {
              super.onMeasure(paramInt1, paramInt2);
              return;
            }
            int j = View.MeasureSpec.getMode(paramInt1);
            k = View.MeasureSpec.getSize(paramInt1);
            m = View.MeasureSpec.getMode(paramInt2);
            n = View.MeasureSpec.getSize(paramInt2);
            if (j == -2147483648)
              break label284;
            if (j != 1073741824)
              break;
            break label284;
            if ((this.qr.widthPixels > i1) || (this.qr.heightPixels > i))
            {
              float f = this.wI.getResources().getDisplayMetrics().density;
              gs.W("Not enough space to show ad. Needs " + (int)(this.qr.widthPixels / f) + "x" + (int)(this.qr.heightPixels / f) + " dp, but only has " + (int)(k / f) + "x" + (int)(n / f) + " dp.");
              if (getVisibility() != 8)
                setVisibility(4);
              setMeasuredDimension(0, 0);
              return;
            }
          }
          if (getVisibility() != 8)
            setVisibility(0);
          setMeasuredDimension(this.qr.widthPixels, this.qr.heightPixels);
        }
        int i1 = i;
        continue;
        i1 = k;
      }
      while ((m != -2147483648) && (m != 1073741824));
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.sX != null)
      this.sX.a(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }

  public void setContext(Context paramContext)
  {
    this.wI.setBaseContext(paramContext);
  }

  public void x(boolean paramBoolean)
  {
    synchronized (this.mw)
    {
      this.wK = paramBoolean;
      dA();
      return;
    }
  }

  @ez
  protected static class a extends MutableContextWrapper
  {
    private Context mD;
    private Activity wO;

    public a(Context paramContext)
    {
      super();
      setBaseContext(paramContext);
    }

    public Context dz()
    {
      return this.wO;
    }

    public void setBaseContext(Context paramContext)
    {
      this.mD = paramContext.getApplicationContext();
      if ((paramContext instanceof Activity));
      for (Activity localActivity = (Activity)paramContext; ; localActivity = null)
      {
        this.wO = localActivity;
        super.setBaseContext(this.mD);
        return;
      }
    }

    public void startActivity(Intent paramIntent)
    {
      if (this.wO != null)
      {
        this.wO.startActivity(paramIntent);
        return;
      }
      paramIntent.setFlags(268435456);
      this.mD.startActivity(paramIntent);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gv
 * JD-Core Version:    0.6.2
 */