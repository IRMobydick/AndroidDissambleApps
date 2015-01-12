package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ez
public final class cm
{
  public final List<cl> qd;
  public final long qe;
  public final List<String> qf;
  public final List<String> qg;
  public final List<String> qh;
  public final String qi;
  public final long qj;
  public int qk;
  public int ql;

  public cm(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject(paramString);
    if (gs.u(2))
      gs.V("Mediation Response JSON: " + localJSONObject1.toString(2));
    JSONArray localJSONArray = localJSONObject1.getJSONArray("ad_networks");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    int i = -1;
    for (int j = 0; j < localJSONArray.length(); j++)
    {
      cl localcl = new cl(localJSONArray.getJSONObject(j));
      localArrayList.add(localcl);
      if ((i < 0) && (a(localcl)))
        i = j;
    }
    this.qk = i;
    this.ql = localJSONArray.length();
    this.qd = Collections.unmodifiableList(localArrayList);
    this.qi = localJSONObject1.getString("qdata");
    JSONObject localJSONObject2 = localJSONObject1.optJSONObject("settings");
    if (localJSONObject2 != null)
    {
      this.qe = localJSONObject2.optLong("ad_network_timeout_millis", -1L);
      this.qf = cr.a(localJSONObject2, "click_urls");
      this.qg = cr.a(localJSONObject2, "imp_urls");
      this.qh = cr.a(localJSONObject2, "nofill_urls");
      long l1 = localJSONObject2.optLong("refresh", -1L);
      if (l1 > 0L);
      for (long l2 = l1 * 1000L; ; l2 = -1L)
      {
        this.qj = l2;
        return;
      }
    }
    this.qe = -1L;
    this.qf = null;
    this.qg = null;
    this.qh = null;
    this.qj = -1L;
  }

  private boolean a(cl paramcl)
  {
    Iterator localIterator = paramcl.pY.iterator();
    while (localIterator.hasNext())
      if (((String)localIterator.next()).equals("com.google.ads.mediation.admob.AdMobAdapter"))
        return true;
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cm
 * JD-Core Version:    0.6.2
 */