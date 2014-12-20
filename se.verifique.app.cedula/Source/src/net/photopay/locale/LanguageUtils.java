package net.photopay.locale;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Locale;
import net.photopay.util.Log;

public class LanguageUtils
{
  private static final String PREFS_COUNTRY = "PREFS_COUNTRY";
  private static final String PREFS_LANGUAGE = "PREFS_LANGUAGE";
  private static String mCountry;
  private static String mLanguage;

  public static void setLanguage(Language paramLanguage, Context paramContext)
  {
    setLanguageAndCountry(paramLanguage.getLanguage(), paramLanguage.getCountry(), paramContext);
  }

  public static void setLanguageAndCountry(String paramString1, String paramString2, Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("PhotoPay.prefs", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    mLanguage = paramString1;
    mCountry = paramString2;
    if (mLanguage == null)
    {
      String str2 = localSharedPreferences.getString("PREFS_LANGUAGE", null);
      mLanguage = str2;
      if (str2 == null)
      {
        mLanguage = Locale.getDefault().getLanguage();
        localEditor.putString("PREFS_LANGUAGE", mLanguage);
      }
      if (mCountry != null)
        break label154;
      String str1 = localSharedPreferences.getString("PREFS_COUNTRY", null);
      mCountry = str1;
      if (str1 == null)
      {
        mCountry = Locale.getDefault().getCountry();
        localEditor.putString("PREFS_COUNTRY", mCountry);
      }
    }
    while (true)
    {
      localEditor.commit();
      setLanguageConfiguration(paramContext.getResources());
      return;
      localEditor.putString("PREFS_LANGUAGE", mLanguage);
      break;
      label154: localEditor.putString("PREFS_COUNTRY", mCountry);
    }
  }

  public static void setLanguageConfiguration(Resources paramResources)
  {
    Configuration localConfiguration = new Configuration();
    if ((mLanguage != null) && (!mLanguage.equals("")))
    {
      if ((mCountry == null) || (mCountry.equals("")))
        break label91;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = mLanguage;
      arrayOfObject2[1] = mCountry;
      Log.i(LanguageUtils.class, "Setting language to '{}', country to '{}'", arrayOfObject2);
    }
    for (localConfiguration.locale = new Locale(mLanguage, mCountry); ; localConfiguration.locale = new Locale(mLanguage))
    {
      paramResources.updateConfiguration(localConfiguration, null);
      return;
      label91: Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = mLanguage;
      Log.i(LanguageUtils.class, "Setting language to '{}'", arrayOfObject1);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.locale.LanguageUtils
 * JD-Core Version:    0.6.0
 */