package com.ubercab.client.core.util;

import android.widget.EditText;
import android.widget.TextView;
import com.ubercab.common.collect.ImmutableMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ValidationUtils
{
  public static boolean showValidationErrors(Map<String, ?> paramMap, ImmutableMap<String, EditText> paramImmutableMap)
  {
    if (paramMap == null);
    do
    {
      return false;
      Iterator localIterator1 = paramImmutableMap.values().iterator();
      while (localIterator1.hasNext())
        ((EditText)localIterator1.next()).setError(null);
      int i = 1;
      Iterator localIterator2 = paramImmutableMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        if (paramMap.containsKey(str))
        {
          TextView localTextView = (TextView)paramImmutableMap.get(str);
          localTextView.setError(paramMap.get(str).toString());
          if ((i != 0) && (localTextView.requestFocus()))
            i = 0;
        }
      }
    }
    while (paramMap.isEmpty());
    return true;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.util.ValidationUtils
 * JD-Core Version:    0.6.2
 */