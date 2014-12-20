package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fx
{
  private static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd");

  public static du a(Context paramContext, ds paramds, String paramString)
  {
    JSONObject localJSONObject;
    String str1;
    String str3;
    String str4;
    long l1;
    String str5;
    long l2;
    int i;
    du localdu1;
    du localdu3;
    label211: Object localObject1;
    label249: int m;
    while (true)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        str1 = localJSONObject.optString("ad_base_url", null);
        String str2 = localJSONObject.optString("ad_url", null);
        str3 = localJSONObject.optString("ad_size", null);
        str4 = localJSONObject.optString("ad_html", null);
        l1 = -1L;
        str5 = localJSONObject.optString("debug_dialog", null);
        if (!localJSONObject.has("interstitial_timeout"))
          break label655;
        l2 = ()(1000.0D * localJSONObject.getDouble("interstitial_timeout"));
        String str6 = localJSONObject.optString("orientation", null);
        i = -1;
        if (!"portrait".equals(str6))
          continue;
        i = gw.c();
        if (TextUtils.isEmpty(str4))
          continue;
        if (!TextUtils.isEmpty(str1))
          break label646;
        hi.e("Could not parse the mediation config: Missing required ad_base_url field");
        localdu1 = new du(0);
        break label652;
        if (!"landscape".equals(str6))
          continue;
        i = gw.b();
        continue;
        if (TextUtils.isEmpty(str2))
          continue;
        du localdu2 = fu.a(paramContext, paramds.l.c, str2, null, null);
        str1 = localdu2.c;
        str4 = localdu2.d;
        l1 = localdu2.o;
        localdu3 = localdu2;
        JSONArray localJSONArray1 = localJSONObject.optJSONArray("click_urls");
        if (localdu3 == null)
        {
          localObject1 = null;
          if (localJSONArray1 == null)
            break;
          if (localObject1 != null)
            break label663;
          localObject1 = new LinkedList();
          break label663;
          if (m >= localJSONArray1.length())
            break label669;
          ((List)localObject1).add(localJSONArray1.getString(m));
          m++;
          continue;
          hi.e("Could not parse the mediation config: Missing required ad_html or ad_url field.");
          localdu1 = new du(0);
        }
      }
      catch (JSONException localJSONException)
      {
        hi.e("Could not parse the mediation config: " + localJSONException.getMessage());
        localdu1 = new du(0);
      }
      localObject1 = localdu3.e;
    }
    label349: JSONArray localJSONArray2 = localJSONObject.optJSONArray("impression_urls");
    Object localObject3;
    if (localdu3 == null)
      localObject3 = null;
    label387: int k;
    label428: Object localObject5;
    label466: int j;
    while (localJSONArray2 != null)
    {
      if (localObject3 != null)
        break label676;
      localObject3 = new LinkedList();
      break label676;
      while (k < localJSONArray2.length())
      {
        ((List)localObject3).add(localJSONArray2.getString(k));
        k++;
      }
      localObject3 = localdu3.g;
      continue;
      JSONArray localJSONArray3 = localJSONObject.optJSONArray("manual_impression_urls");
      if (localdu3 == null);
      for (localObject5 = null; localJSONArray3 != null; localObject5 = localdu3.k)
      {
        if (localObject5 != null)
          break label689;
        localObject5 = new LinkedList();
        break label689;
        while (j < localJSONArray3.length())
        {
          ((List)localObject5).add(localJSONArray3.getString(j));
          j++;
        }
      }
    }
    while (true)
    {
      if (localdu3 != null)
      {
        if (localdu3.m != -1)
          i = localdu3.m;
        if (localdu3.h > 0L)
          l2 = localdu3.h;
      }
      String str7 = localJSONObject.optString("active_view");
      String str8 = null;
      boolean bool = localJSONObject.optBoolean("ad_is_javascript", false);
      if (bool)
        str8 = localJSONObject.optString("ad_passback_url", null);
      localdu1 = new du(str1, str4, (List)localObject2, (List)localObject4, l2, false, -1L, (List)localObject6, -1L, i, str3, l1, str5, bool, str8, str7);
      break label652;
      Object localObject6 = localObject5;
      continue;
      Object localObject4 = localObject3;
      break label428;
      Object localObject2 = localObject1;
      break label349;
      label646: localdu3 = null;
      break label211;
      label652: return localdu1;
      label655: l2 = -1L;
      break;
      label663: m = 0;
      break label249;
      label669: localObject2 = localObject1;
      break label349;
      label676: k = 0;
      break label387;
      localObject4 = localObject3;
      break label428;
      label689: j = 0;
      break label466;
      localObject6 = localObject5;
    }
  }

  private static Integer a(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
      return Integer.valueOf(i);
  }

  private static String a(int paramInt)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(0xFFFFFF & paramInt);
    return String.format(localLocale, "#%06x", arrayOfObject);
  }

  public static String a(ds paramds, gf paramgf, Location paramLocation, String paramString)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      if ((paramString != null) && (paramString.trim() != ""))
        localHashMap.put("eid", paramString);
      if (paramds.c != null)
        localHashMap.put("ad_pos", paramds.c);
      a(localHashMap, paramds.d);
      localHashMap.put("format", paramds.e.c);
      if (paramds.e.g == -1)
        localHashMap.put("smart_w", "full");
      if (paramds.e.d == -2)
        localHashMap.put("smart_h", "auto");
      if (paramds.e.i != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        al[] arrayOfal = paramds.e.i;
        int i = arrayOfal.length;
        int j = 0;
        if (j < i)
        {
          al localal = arrayOfal[j];
          if (localStringBuilder.length() != 0)
            localStringBuilder.append("|");
          int k;
          if (localal.g == -1)
          {
            k = (int)(localal.h / paramgf.q);
            label211: localStringBuilder.append(k);
            localStringBuilder.append("x");
            if (localal.d != -2)
              break label276;
          }
          label276: for (int m = (int)(localal.e / paramgf.q); ; m = localal.d)
          {
            localStringBuilder.append(m);
            j++;
            break;
            k = localal.g;
            break label211;
          }
        }
        localHashMap.put("sz", localStringBuilder);
      }
      localHashMap.put("slotname", paramds.f);
      localHashMap.put("pn", paramds.g.packageName);
      if (paramds.h != null)
        localHashMap.put("vc", Integer.valueOf(paramds.h.versionCode));
      localHashMap.put("ms", paramds.i);
      localHashMap.put("ms2", paramds.n);
      localHashMap.put("seq_num", paramds.j);
      localHashMap.put("session_id", paramds.k);
      localHashMap.put("js", paramds.l.c);
      a(localHashMap, paramgf);
      if ((paramds.d.b >= 2) && (paramds.d.l != null))
        a(localHashMap, paramds.d.l);
      if (paramds.b >= 2)
        localHashMap.put("quality_signals", paramds.m);
      if (hi.a(2))
      {
        String str3 = gw.a(localHashMap).toString(2);
        hi.d("Ad Request JSON: " + str3);
      }
      String str2 = gw.a(localHashMap).toString();
      str1 = str2;
      return str1;
    }
    catch (JSONException localJSONException)
    {
      while (true)
      {
        hi.e("Problem serializing ad request to JSON: " + localJSONException.getMessage());
        String str1 = null;
      }
    }
  }

  private static void a(HashMap paramHashMap, Location paramLocation)
  {
    HashMap localHashMap = new HashMap();
    Float localFloat = Float.valueOf(1000.0F * paramLocation.getAccuracy());
    Long localLong1 = Long.valueOf(1000L * paramLocation.getTime());
    Long localLong2 = Long.valueOf(()(10000000.0D * paramLocation.getLatitude()));
    Long localLong3 = Long.valueOf(()(10000000.0D * paramLocation.getLongitude()));
    localHashMap.put("radius", localFloat);
    localHashMap.put("lat", localLong2);
    localHashMap.put("long", localLong3);
    localHashMap.put("time", localLong1);
    paramHashMap.put("uule", localHashMap);
  }

  private static void a(HashMap paramHashMap, ai paramai)
  {
    String str = gq.a();
    if (str != null)
      paramHashMap.put("abf", str);
    if (paramai.c != -1L)
      paramHashMap.put("cust_age", a.format(new Date(paramai.c)));
    if (paramai.d != null)
      paramHashMap.put("extras", paramai.d);
    if (paramai.e != -1)
      paramHashMap.put("cust_gender", Integer.valueOf(paramai.e));
    if (paramai.f != null)
      paramHashMap.put("kw", paramai.f);
    if (paramai.h != -1)
      paramHashMap.put("tag_for_child_directed_treatment", Integer.valueOf(paramai.h));
    if (paramai.g)
      paramHashMap.put("adtest", "on");
    if (paramai.b >= 2)
    {
      if (paramai.i)
        paramHashMap.put("d_imp_hdr", Integer.valueOf(1));
      if (!TextUtils.isEmpty(paramai.j))
        paramHashMap.put("ppid", paramai.j);
      if (paramai.k != null)
        a(paramHashMap, paramai.k);
    }
    if ((paramai.b >= 3) && (paramai.m != null))
      paramHashMap.put("url", paramai.m);
  }

  private static void a(HashMap paramHashMap, aw paramaw)
  {
    Object localObject1 = null;
    if (Color.alpha(paramaw.c) != 0)
      paramHashMap.put("acolor", a(paramaw.c));
    if (Color.alpha(paramaw.d) != 0)
      paramHashMap.put("bgcolor", a(paramaw.d));
    if ((Color.alpha(paramaw.e) != 0) && (Color.alpha(paramaw.f) != 0))
    {
      paramHashMap.put("gradientto", a(paramaw.e));
      paramHashMap.put("gradientfrom", a(paramaw.f));
    }
    if (Color.alpha(paramaw.g) != 0)
      paramHashMap.put("bcolor", a(paramaw.g));
    paramHashMap.put("bthick", Integer.toString(paramaw.h));
    Object localObject2;
    switch (paramaw.i)
    {
    default:
      localObject2 = null;
      if (localObject2 != null)
        paramHashMap.put("btype", localObject2);
      switch (paramaw.j)
      {
      default:
      case 2:
      case 0:
      case 1:
      }
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      if (localObject1 != null)
        paramHashMap.put("callbuttoncolor", localObject1);
      if (paramaw.k != null)
        paramHashMap.put("channel", paramaw.k);
      if (Color.alpha(paramaw.l) != 0)
        paramHashMap.put("dcolor", a(paramaw.l));
      if (paramaw.m != null)
        paramHashMap.put("font", paramaw.m);
      if (Color.alpha(paramaw.n) != 0)
        paramHashMap.put("hcolor", a(paramaw.n));
      paramHashMap.put("headersize", Integer.toString(paramaw.o));
      if (paramaw.p != null)
        paramHashMap.put("q", paramaw.p);
      return;
      localObject2 = "none";
      break;
      localObject2 = "dashed";
      break;
      localObject2 = "dotted";
      break;
      localObject2 = "solid";
      break;
      localObject1 = "dark";
      continue;
      localObject1 = "light";
      continue;
      localObject1 = "medium";
    }
  }

  private static void a(HashMap paramHashMap, gf paramgf)
  {
    paramHashMap.put("am", Integer.valueOf(paramgf.a));
    paramHashMap.put("cog", a(paramgf.b));
    paramHashMap.put("coh", a(paramgf.c));
    if (!TextUtils.isEmpty(paramgf.d))
      paramHashMap.put("carrier", paramgf.d);
    paramHashMap.put("gl", paramgf.e);
    if (paramgf.f)
      paramHashMap.put("simulator", Integer.valueOf(1));
    paramHashMap.put("ma", a(paramgf.g));
    paramHashMap.put("sp", a(paramgf.h));
    paramHashMap.put("hl", paramgf.i);
    if (!TextUtils.isEmpty(paramgf.j))
      paramHashMap.put("mv", paramgf.j);
    paramHashMap.put("muv", Integer.valueOf(paramgf.k));
    if (paramgf.l != -2)
      paramHashMap.put("cnt", Integer.valueOf(paramgf.l));
    paramHashMap.put("gnt", Integer.valueOf(paramgf.m));
    paramHashMap.put("pt", Integer.valueOf(paramgf.n));
    paramHashMap.put("rm", Integer.valueOf(paramgf.o));
    paramHashMap.put("riv", Integer.valueOf(paramgf.p));
    paramHashMap.put("u_sd", Float.valueOf(paramgf.q));
    paramHashMap.put("sh", Integer.valueOf(paramgf.s));
    paramHashMap.put("sw", Integer.valueOf(paramgf.r));
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("active_network_state", paramgf.w);
    localBundle1.putBoolean("active_network_metered", paramgf.v);
    paramHashMap.put("connectivity", localBundle1);
    Bundle localBundle2 = new Bundle();
    localBundle2.putBoolean("is_charging", paramgf.u);
    localBundle2.putDouble("battery_level", paramgf.t);
    paramHashMap.put("battery", localBundle2);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fx
 * JD-Core Version:    0.6.0
 */