package com.ubercab.client.core.locale;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.ubercab.R.string;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import timber.log.Timber;

public final class Countries
{
  private static final String COUNTRY_NAME_PREFIX = "country_";
  private Context mContext;

  public Countries(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public String getCountryName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str1 = "country_" + paramString.toLowerCase(Locale.US);
      try
      {
        int i = R.string.class.getField(str1).getInt(null);
        String str2 = this.mContext.getString(i);
        return str2;
      }
      catch (Exception localException)
      {
        Timber.e("Failure to get countryName for " + paramString, new Object[] { localException });
      }
    }
    return "";
  }

  public Map<String, String> getCountryNames()
  {
    TreeMap localTreeMap = new TreeMap();
    for (String str : this.mContext.getResources().getStringArray(2131165209))
      localTreeMap.put(getCountryName(str), str);
    return localTreeMap;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.locale.Countries
 * JD-Core Version:    0.6.2
 */