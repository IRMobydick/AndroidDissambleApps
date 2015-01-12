package com.ubercab.library.util;

import java.util.Iterator;
import java.util.List;
import retrofit.client.Header;
import retrofit.client.Response;

public final class NetworkUtils
{
  public static final String HEADER_LOCATION = "Location";

  public static String getHeaderValue(String paramString, Response paramResponse)
  {
    if (paramResponse.getHeaders() == null);
    Header localHeader;
    do
    {
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return null;
        localIterator = paramResponse.getHeaders().iterator();
      }
      localHeader = (Header)localIterator.next();
    }
    while ((localHeader.getName() == null) || (!localHeader.getName().equals(paramString)));
    return localHeader.getValue();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.util.NetworkUtils
 * JD-Core Version:    0.6.2
 */