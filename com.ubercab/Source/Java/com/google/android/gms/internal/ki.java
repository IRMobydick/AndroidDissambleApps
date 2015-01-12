package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;

public class ki
{
  public static <T> boolean a(List<T> paramList1, List<T> paramList2)
  {
    if (paramList1.size() != paramList2.size())
      return false;
    Iterator localIterator = paramList1.iterator();
    while (localIterator.hasNext())
      if (!paramList2.contains(localIterator.next()))
        return false;
    return true;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ki
 * JD-Core Version:    0.6.2
 */