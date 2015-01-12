package com.ubercab.library.content;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import timber.log.Timber;

public final class SharedPreferencesWrapperUtil
{
  public static void upgradeStringToBool(SharedPreferences paramSharedPreferences, String paramString)
  {
    try
    {
      String str = paramSharedPreferences.getString(paramString, null);
      if (TextUtils.isEmpty(str))
        return;
      Boolean localBoolean = Boolean.valueOf(str);
      paramSharedPreferences.edit().putBoolean(paramString, localBoolean.booleanValue()).commit();
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      Timber.e("Unable to upgrade key to boolean: " + paramString, new Object[] { localClassCastException });
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.content.SharedPreferencesWrapperUtil
 * JD-Core Version:    0.6.2
 */