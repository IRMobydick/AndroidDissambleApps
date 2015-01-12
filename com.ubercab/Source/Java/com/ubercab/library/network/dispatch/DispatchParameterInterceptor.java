package com.ubercab.library.network.dispatch;

import java.util.Map;

public abstract interface DispatchParameterInterceptor
{
  public abstract void onInterceptRequestParameters(Map<String, Object> paramMap);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.dispatch.DispatchParameterInterceptor
 * JD-Core Version:    0.6.2
 */