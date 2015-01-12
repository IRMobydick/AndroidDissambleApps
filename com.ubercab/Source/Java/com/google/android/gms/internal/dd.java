package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.AdSize;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@ez
public class dd
{
  static final Set<String> qT = new HashSet(Arrays.asList(new String[] { "top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center" }));
  private int lf = -1;
  private int lg = -1;
  private final Context mContext;
  private final gv md;
  private final Map<String, String> qM;
  private int qU = 0;
  private int qV = 0;
  private boolean qW = true;
  private String qX = "top-right";

  public dd(gv paramgv, Map<String, String> paramMap)
  {
    this.md = paramgv;
    this.qM = paramMap;
    this.mContext = paramgv.dz();
  }

  private void bG()
  {
    int[] arrayOfInt = gj.t(this.mContext);
    if (!TextUtils.isEmpty((CharSequence)this.qM.get("width")))
    {
      int j = gj.M((String)this.qM.get("width"));
      if (b(j, arrayOfInt[0]))
        this.lf = j;
    }
    if (!TextUtils.isEmpty((CharSequence)this.qM.get("height")))
    {
      int i = gj.M((String)this.qM.get("height"));
      if (c(i, arrayOfInt[1]))
        this.lg = i;
    }
    if (!TextUtils.isEmpty((CharSequence)this.qM.get("offsetX")))
      this.qU = gj.M((String)this.qM.get("offsetX"));
    if (!TextUtils.isEmpty((CharSequence)this.qM.get("offsetY")))
      this.qV = gj.M((String)this.qM.get("offsetY"));
    if (!TextUtils.isEmpty((CharSequence)this.qM.get("allowOffscreen")))
      this.qW = Boolean.parseBoolean((String)this.qM.get("allowOffscreen"));
    String str = (String)this.qM.get("customClosePosition");
    if ((!TextUtils.isEmpty(str)) && (qT.contains(str)))
      this.qX = str;
  }

  boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 50) && (paramInt1 < paramInt2);
  }

  boolean bH()
  {
    return (this.lf > -1) && (this.lg > -1);
  }

  void bI()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", this.qU).put("y", this.qV).put("width", this.lf).put("height", this.lg);
      this.md.b("onSizeChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      gs.b("Error occured while dispatching size change.", localJSONException);
    }
  }

  void bJ()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("state", "resized");
      this.md.b("onStateChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      gs.b("Error occured while dispatching state change.", localJSONException);
    }
  }

  boolean c(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 50) && (paramInt1 < paramInt2);
  }

  public void execute()
  {
    gs.U("PLEASE IMPLEMENT mraid.resize()");
    if (this.mContext == null)
    {
      gs.W("Not an activity context. Cannot resize.");
      return;
    }
    if (this.md.Y().og)
    {
      gs.W("Is interstitial. Cannot resize an interstitial.");
      return;
    }
    if (this.md.dy())
    {
      gs.W("Is expanded. Cannot resize an expanded banner.");
      return;
    }
    bG();
    if (!bH())
    {
      gs.W("Invalid width and height options. Cannot resize.");
      return;
    }
    WindowManager localWindowManager = (WindowManager)this.mContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = 16 + gr.a(localDisplayMetrics, this.lf);
    int j = 16 + gr.a(localDisplayMetrics, this.lg);
    ViewParent localViewParent = this.md.getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
      ((ViewGroup)localViewParent).removeView(this.md);
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setBackgroundColor(0);
    PopupWindow localPopupWindow = new PopupWindow(this.mContext);
    localPopupWindow.setHeight(j);
    localPopupWindow.setWidth(i);
    if (!this.qW);
    for (boolean bool = true; ; bool = false)
    {
      localPopupWindow.setClippingEnabled(bool);
      localPopupWindow.setContentView(localLinearLayout);
      localLinearLayout.addView(this.md, -1, -1);
      localPopupWindow.showAtLocation(((Activity)this.mContext).getWindow().getDecorView(), 0, this.qU, this.qV);
      this.md.a(new ay(this.mContext, new AdSize(this.lf, this.lg)));
      bI();
      bJ();
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dd
 * JD-Core Version:    0.6.2
 */