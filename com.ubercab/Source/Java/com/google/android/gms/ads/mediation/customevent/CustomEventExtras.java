package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras
  implements NetworkExtras
{
  private final HashMap<String, Object> xj = new HashMap();

  public Object getExtra(String paramString)
  {
    return this.xj.get(paramString);
  }

  public void setExtra(String paramString, Object paramObject)
  {
    this.xj.put(paramString, paramObject);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventExtras
 * JD-Core Version:    0.6.2
 */