package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bm
{
  public final List a;
  public final long b;
  public final List c;
  public final List d;
  public final List e;
  public final String f;
  public final long g;
  public int h;
  public int i;

  public bm(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject(paramString);
    if (hi.a(2))
      hi.d("Mediation Response JSON: " + localJSONObject1.toString(2));
    JSONArray localJSONArray = localJSONObject1.getJSONArray("ad_networks");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    int j = -1;
    for (int k = 0; k < localJSONArray.length(); k++)
    {
      bl localbl = new bl(localJSONArray.getJSONObject(k));
      localArrayList.add(localbl);
      if ((j >= 0) || (!a(localbl)))
        continue;
      j = k;
    }
    this.h = j;
    this.i = localJSONArray.length();
    this.a = Collections.unmodifiableList(localArrayList);
    this.f = localJSONObject1.getString("qdata");
    JSONObject localJSONObject2 = localJSONObject1.optJSONObject("settings");
    long l2;
    if (localJSONObject2 != null)
    {
      this.b = localJSONObject2.optLong("ad_network_timeout_millis", -1L);
      this.c = bt.a(localJSONObject2, "click_urls");
      this.d = bt.a(localJSONObject2, "imp_urls");
      this.e = bt.a(localJSONObject2, "nofill_urls");
      long l1 = localJSONObject2.optLong("refresh", -1L);
      if (l1 > 0L)
        l2 = l1 * 1000L;
    }
    for (this.g = l2; ; this.g = -1L)
    {
      return;
      l2 = -1L;
      break;
      this.b = -1L;
      this.c = null;
      this.d = null;
      this.e = null;
    }
  }

  private boolean a(bl parambl)
  {
    Iterator localIterator = parambl.c.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (!((String)localIterator.next()).equals("com.google.ads.mediation.admob.AdMobAdapter"));
    for (int j = 1; ; j = 0)
      return j;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bm
 * JD-Core Version:    0.6.0
 */