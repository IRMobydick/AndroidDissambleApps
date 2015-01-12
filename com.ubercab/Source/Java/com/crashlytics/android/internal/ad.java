package com.crashlytics.android.internal;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

 enum ad
{
  private static final Map<String, ad> k;

  static
  {
    ad[] arrayOfad = new ad[10];
    arrayOfad[0] = a;
    arrayOfad[1] = b;
    arrayOfad[2] = c;
    arrayOfad[3] = d;
    arrayOfad[4] = e;
    arrayOfad[5] = f;
    arrayOfad[6] = g;
    arrayOfad[7] = h;
    arrayOfad[8] = i;
    arrayOfad[9] = j;
    l = arrayOfad;
    HashMap localHashMap = new HashMap(4);
    k = localHashMap;
    localHashMap.put("armeabi-v7a", g);
    k.put("armeabi", f);
    k.put("x86", a);
  }

  static ad a()
  {
    String str1 = Build.CPU_ABI;
    ad localad;
    if (TextUtils.isEmpty(str1))
    {
      v.a().b().a("Crashlytics", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
      localad = h;
    }
    do
    {
      return localad;
      String str2 = str1.toLowerCase(Locale.US);
      localad = (ad)k.get(str2);
    }
    while (localad != null);
    return h;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.internal.ad
 * JD-Core Version:    0.6.2
 */