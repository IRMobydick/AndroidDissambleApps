package com.squareup.okhttp.internal.http;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public final class HttpMethod
{
  public static final Set<String> METHODS = new LinkedHashSet(Arrays.asList(new String[] { "OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH" }));

  public static boolean hasRequestBody(String paramString)
  {
    return (paramString.equals("POST")) || (paramString.equals("PUT")) || (paramString.equals("PATCH")) || (paramString.equals("DELETE"));
  }

  public static boolean invalidatesCache(String paramString)
  {
    return (paramString.equals("POST")) || (paramString.equals("PATCH")) || (paramString.equals("PUT")) || (paramString.equals("DELETE"));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.HttpMethod
 * JD-Core Version:    0.6.2
 */