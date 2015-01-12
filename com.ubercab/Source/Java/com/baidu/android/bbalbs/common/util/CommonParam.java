package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.text.TextUtils;

public class CommonParam
{
  private static final String a = CommonParam.class.getSimpleName();

  public static String a(Context paramContext)
  {
    String str1 = b(paramContext);
    String str2 = a.b(paramContext);
    if (TextUtils.isEmpty(str2))
      str2 = "0";
    String str3 = new StringBuffer(str2).reverse().toString();
    return str1 + "|" + str3;
  }

  private static String b(Context paramContext)
  {
    return a.a(paramContext);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.android.bbalbs.common.util.CommonParam
 * JD-Core Version:    0.6.2
 */