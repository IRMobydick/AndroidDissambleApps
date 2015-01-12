package com.baidu.location.b.a;

import android.content.Context;
import android.text.TextUtils;

public class a
{
  private static final boolean a;
  private static final String jdField_if = a.class.getSimpleName();

  private static String a(Context paramContext)
  {
    return b.a(paramContext);
  }

  public static String jdField_if(Context paramContext)
  {
    String str1 = a(paramContext);
    String str2 = b.jdMethod_do(paramContext);
    if (TextUtils.isEmpty(str2))
      str2 = "0";
    String str3 = new StringBuffer(str2).reverse().toString();
    return str1 + "|" + str3;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.location.b.a.a
 * JD-Core Version:    0.6.2
 */