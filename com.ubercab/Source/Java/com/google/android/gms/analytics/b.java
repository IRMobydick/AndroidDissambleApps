package com.google.android.gms.analytics;

import com.google.android.gms.internal.hb;
import java.util.List;
import java.util.Map;

abstract interface b
{
  public abstract void a(Map<String, String> paramMap, long paramLong, String paramString, List<hb> paramList);

  public abstract void connect();

  public abstract void dH();

  public abstract void disconnect();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.b
 * JD-Core Version:    0.6.2
 */