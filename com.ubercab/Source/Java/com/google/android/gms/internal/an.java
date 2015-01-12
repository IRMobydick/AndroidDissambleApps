package com.google.android.gms.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@ez
public class an extends Thread
{
  private boolean mStarted = false;
  private final Object mw;
  private final int nf;
  private final int nh;
  private boolean ns = false;
  private boolean nt = false;
  private final am nu;
  private final al nv;
  private final ey nw;
  private final int nx;
  private final int ny;
  private final int nz;

  public an(am paramam, al paramal, Bundle paramBundle, ey paramey)
  {
    this.nu = paramam;
    this.nv = paramal;
    this.nw = paramey;
    this.mw = new Object();
    this.nf = paramBundle.getInt(bn.pe.getKey());
    this.ny = paramBundle.getInt(bn.pf.getKey());
    this.nh = paramBundle.getInt(bn.pg.getKey());
    this.nz = paramBundle.getInt(bn.ph.getKey());
    this.nx = paramBundle.getInt(bn.pi.getKey(), 10);
    setName("ContentFetchTask");
  }

  private void a(Activity paramActivity)
  {
    if (paramActivity == null);
    View localView1;
    do
    {
      return;
      Window localWindow = paramActivity.getWindow();
      localView1 = null;
      if (localWindow != null)
      {
        View localView2 = paramActivity.getWindow().getDecorView();
        localView1 = null;
        if (localView2 != null)
          localView1 = paramActivity.getWindow().getDecorView().findViewById(16908290);
      }
    }
    while (localView1 == null);
    g(localView1);
  }

  private boolean a(final WebView paramWebView, final ak paramak)
  {
    if (!kc.hI())
      return false;
    paramak.aR();
    paramWebView.post(new Runnable()
    {
      ValueCallback<String> nC = new ValueCallback()
      {
        public void k(String paramAnonymous2String)
        {
          an.this.a(an.2.this.nD, an.2.this.nE, paramAnonymous2String);
        }
      };

      public void run()
      {
        if (paramWebView.getSettings().getJavaScriptEnabled())
          paramWebView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.nC);
      }
    });
    return true;
  }

  private boolean aW()
  {
    try
    {
      Context localContext = this.nu.getContext();
      if (localContext == null)
        return false;
      ActivityManager localActivityManager = (ActivityManager)localContext.getSystemService("activity");
      KeyguardManager localKeyguardManager = (KeyguardManager)localContext.getSystemService("keyguard");
      PowerManager localPowerManager = (PowerManager)localContext.getSystemService("power");
      if ((localActivityManager != null) && (localKeyguardManager != null) && (localPowerManager != null))
      {
        List localList = localActivityManager.getRunningAppProcesses();
        if (localList == null)
          return false;
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          if (Process.myPid() == localRunningAppProcessInfo.pid)
            if ((localRunningAppProcessInfo.importance == 100) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
            {
              boolean bool = localPowerManager.isScreenOn();
              if (bool)
                return true;
            }
        }
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      return false;
    }
    return false;
  }

  a a(View paramView, ak paramak)
  {
    int i = 0;
    if (paramView == null)
      return new a(0, 0);
    if (((paramView instanceof TextView)) && (!(paramView instanceof EditText)))
    {
      paramak.i(((TextView)paramView).getText().toString());
      return new a(1, 0);
    }
    if (((paramView instanceof WebView)) && (!(paramView instanceof gv)))
    {
      paramak.aR();
      if (a((WebView)paramView, paramak))
        return new a(0, 1);
      return new a(0, 0);
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = 0;
      int k = 0;
      while (i < localViewGroup.getChildCount())
      {
        a locala = a(localViewGroup.getChildAt(i), paramak);
        k += locala.nG;
        j += locala.nH;
        i++;
      }
      return new a(k, j);
    }
    return new a(0, 0);
  }

  void a(ak paramak, WebView paramWebView, String paramString)
  {
    paramak.aQ();
    try
    {
      String str;
      if (!TextUtils.isEmpty(paramString))
      {
        str = new JSONObject(paramString).optString("text");
        if (TextUtils.isEmpty(paramWebView.getTitle()))
          break label86;
        paramak.h(paramWebView.getTitle() + "\n" + str);
      }
      while (paramak.aN())
      {
        this.nv.b(paramak);
        return;
        label86: paramak.h(str);
      }
    }
    catch (JSONException localJSONException)
    {
      gs.S("Json string may be malformed.");
      return;
    }
    catch (Throwable localThrowable)
    {
      gs.a("Failed to get webview content.", localThrowable);
      this.nw.b(localThrowable);
    }
  }

  public void aV()
  {
    synchronized (this.mw)
    {
      if (this.mStarted)
      {
        gs.S("Content hash thread already started, quiting...");
        return;
      }
      this.mStarted = true;
      start();
      return;
    }
  }

  public ak aX()
  {
    return this.nv.aU();
  }

  public void aY()
  {
    synchronized (this.mw)
    {
      this.ns = true;
      gs.S("ContentFetchThread: paused, mPause = " + this.ns);
      return;
    }
  }

  public boolean aZ()
  {
    return this.ns;
  }

  boolean g(final View paramView)
  {
    if (paramView == null)
      return false;
    paramView.post(new Runnable()
    {
      public void run()
      {
        an.this.h(paramView);
      }
    });
    return true;
  }

  void h(View paramView)
  {
    try
    {
      ak localak = new ak(this.nf, this.ny, this.nh, this.nz);
      a locala = a(paramView, localak);
      localak.aS();
      if ((locala.nG == 0) && (locala.nH == 0))
        return;
      if (((locala.nH != 0) || (localak.aT() != 0)) && ((locala.nH != 0) || (!this.nv.a(localak))))
      {
        this.nv.c(localak);
        return;
      }
    }
    catch (Exception localException)
    {
      gs.b("Exception in fetchContentOnUIThread", localException);
      this.nw.b(localException);
    }
  }

  public void run()
  {
    while (!this.nt)
      try
      {
        if (aW())
        {
          localActivity = this.nu.getActivity();
          if (localActivity == null)
            gs.S("ContentFetchThread: no activity");
        }
      }
      catch (Throwable localThrowable)
      {
        Activity localActivity;
        gs.b("Error in ContentFetchTask", localThrowable);
        this.nw.b(localThrowable);
        synchronized (this.mw)
        {
          while (true)
          {
            boolean bool = this.ns;
            if (!bool)
              break;
            try
            {
              gs.S("ContentFetchTask: waiting");
              this.mw.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
            }
          }
          a(localActivity);
          while (true)
          {
            Thread.sleep(1000 * this.nx);
            break;
            gs.S("ContentFetchTask: sleeping");
            aY();
          }
        }
      }
  }

  public void wakeup()
  {
    synchronized (this.mw)
    {
      this.ns = false;
      this.mw.notifyAll();
      gs.S("ContentFetchThread: wakeup");
      return;
    }
  }

  @ez
  class a
  {
    final int nG;
    final int nH;

    a(int paramInt1, int arg3)
    {
      this.nG = paramInt1;
      int i;
      this.nH = i;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.an
 * JD-Core Version:    0.6.2
 */