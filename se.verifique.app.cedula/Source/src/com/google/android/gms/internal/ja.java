package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class ja
{
  private static final String[] a;
  private static final Map b;

  static
  {
    int i = 0;
    String[] arrayOfString = new String[9];
    arrayOfString[i] = "text1";
    arrayOfString[1] = "text2";
    arrayOfString[2] = "icon";
    arrayOfString[3] = "intent_action";
    arrayOfString[4] = "intent_data";
    arrayOfString[5] = "intent_data_id";
    arrayOfString[6] = "intent_extra_data";
    arrayOfString[7] = "suggest_large_icon";
    arrayOfString[8] = "intent_activity";
    a = arrayOfString;
    b = new HashMap(a.length);
    while (i < a.length)
    {
      b.put(a[i], Integer.valueOf(i));
      i++;
    }
  }

  public static String a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= a.length));
    for (String str = null; ; str = a[paramInt])
      return str;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ja
 * JD-Core Version:    0.6.0
 */