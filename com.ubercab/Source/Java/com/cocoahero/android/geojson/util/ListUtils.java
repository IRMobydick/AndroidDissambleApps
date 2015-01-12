package com.cocoahero.android.geojson.util;

import java.util.List;

public class ListUtils
{
  public static <T> T getHead(List<T> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
      return null;
    return paramList.get(0);
  }

  public static <T> T getTail(List<T> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
      return null;
    return paramList.get(-1 + paramList.size());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.cocoahero.android.geojson.util.ListUtils
 * JD-Core Version:    0.6.2
 */