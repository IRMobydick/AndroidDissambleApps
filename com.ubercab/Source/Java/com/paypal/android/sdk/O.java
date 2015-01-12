package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class O extends ab
{
  private static Map b;
  private static Set c;
  private final R a;

  static
  {
    HashMap localHashMap = new HashMap();
    b = localHashMap;
    localHashMap.put("c14", "erpg");
    b.put("c25", "page");
    b.put("c26", "link");
    b.put("c27", "pgln");
    b.put("c29", "eccd");
    b.put("c35", "lgin");
    b.put("vers", "vers");
    b.put("c50", "rsta");
    b.put("gn", "pgrp");
    b.put("v49", "mapv");
    b.put("v51", "mcar");
    b.put("v52", "mosv");
    b.put("v53", "mdvs");
    b.put("clid", "clid");
    b.put("apid", "apid");
    b.put("calc", "calc");
    b.put("e", "e");
    b.put("t", "t");
    b.put("g", "g");
    b.put("srce", "srce");
    b.put("vid", "vid");
    b.put("bchn", "bchn");
    b.put("adte", "adte");
    b.put("sv", "sv");
    b.put("dsid", "dsid");
    b.put("bzsr", "bzsr");
    b.put("prid", "prid");
    HashSet localHashSet = new HashSet();
    c = localHashSet;
    localHashSet.add("v25");
    c.add("v31");
    c.add("c37");
  }

  public O(L paramL, d paramd, h paramh, R paramR, String paramString)
  {
    super(a.b, paramL, paramd, paramh, paramString);
    this.a = paramR;
    a("Accept", "application/json; charset=utf-8");
    a("Accept-Language", "en_US");
    a("Content-Type", "application/json");
  }

  private JSONObject a(Map paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramMap.keySet().iterator();
    label165: 
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!R.c(str1))
      {
        if (!c.contains(str1))
          break label110;
        new StringBuilder("SC key ").append(str1).append(" not used in FPTI, skipping").toString();
      }
      label84: for (String str2 = null; ; str2 = (String)b.get(str1))
      {
        if (str2 == null)
          break label165;
        localJSONObject.accumulate(str2, paramMap.get(str1));
        break;
        label110: if (!b.containsKey(str1))
        {
          new StringBuilder("No mapping for SC key ").append(str1).append(", skipping").toString();
          break label84;
        }
      }
    }
    return localJSONObject;
  }

  public final String a()
  {
    String str1 = R.b(b.a().c().e());
    String str2 = this.a.a;
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.accumulate("tracking_visitor_id", str1);
    localJSONObject1.accumulate("tracking_visit_id", str2);
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.accumulate("actor", localJSONObject1);
    localJSONObject2.accumulate("channel", "mobile");
    String str3 = Long.toString(System.currentTimeMillis());
    localJSONObject2.accumulate("tracking_event", str3);
    this.a.b.put("t", str3);
    this.a.b.put("dsid", str1);
    this.a.b.put("vid", str2);
    localJSONObject2.accumulate("event_params", a(this.a.b));
    return localJSONObject2.toString();
  }

  public final String a(a parama)
  {
    return "https://api.paypal.com/v1/tracking/events";
  }

  public final void b()
  {
  }

  public final void c()
  {
  }

  public final String d()
  {
    return "mockFptiResponse";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.O
 * JD-Core Version:    0.6.2
 */