package com.ubercab.client.feature.employee.inject;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PreferencesInjector
{
  private static Preference findPreference(PreferenceFragment paramPreferenceFragment, int paramInt)
  {
    String str = paramPreferenceFragment.getString(paramInt);
    Preference localPreference = paramPreferenceFragment.findPreference(str);
    if (localPreference == null)
      throw new PreferenceNotFoundException(str);
    return localPreference;
  }

  public static void inject(PreferenceFragment paramPreferenceFragment)
  {
    while (true)
    {
      int j;
      try
      {
        Field[] arrayOfField = paramPreferenceFragment.getClass().getDeclaredFields();
        int i = arrayOfField.length;
        j = 0;
        if (j < i)
        {
          Field localField = arrayOfField[j];
          InjectPreference localInjectPreference = (InjectPreference)localField.getAnnotation(InjectPreference.class);
          if (localInjectPreference == null)
            break label203;
          Preference localPreference = findPreference(paramPreferenceFragment, localInjectPreference.value());
          localField.setAccessible(true);
          localField.set(paramPreferenceFragment, localPreference);
          break label203;
        }
        Method[] arrayOfMethod = paramPreferenceFragment.getClass().getDeclaredMethods();
        int k = arrayOfMethod.length;
        int m = 0;
        if (m < k)
        {
          Method localMethod = arrayOfMethod[m];
          OnPreferenceClick localOnPreferenceClick = (OnPreferenceClick)localMethod.getAnnotation(OnPreferenceClick.class);
          if (localOnPreferenceClick != null)
            findPreference(paramPreferenceFragment, localOnPreferenceClick.value()).setOnPreferenceClickListener(new OnPreferenceClickListener(localMethod, paramPreferenceFragment));
          OnPreferenceChange localOnPreferenceChange = (OnPreferenceChange)localMethod.getAnnotation(OnPreferenceChange.class);
          if (localOnPreferenceChange != null)
            findPreference(paramPreferenceFragment, localOnPreferenceChange.value()).setOnPreferenceChangeListener(new OnPreferenceChangeListener(localMethod, paramPreferenceFragment));
          m++;
          continue;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException(localIllegalAccessException);
      }
      return;
      label203: j++;
    }
  }

  private static class OnPreferenceChangeListener
    implements Preference.OnPreferenceChangeListener
  {
    private final Method mMethod;
    private final PreferenceFragment mTarget;

    public OnPreferenceChangeListener(Method paramMethod, PreferenceFragment paramPreferenceFragment)
    {
      this.mMethod = paramMethod;
      this.mTarget = paramPreferenceFragment;
    }

    public boolean onPreferenceChange(Preference paramPreference, Object paramObject)
    {
      try
      {
        this.mMethod.setAccessible(true);
        this.mMethod.invoke(this.mTarget, new Object[] { paramObject });
        return true;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
  }

  private static class OnPreferenceClickListener
    implements Preference.OnPreferenceClickListener
  {
    private final Method mMethod;
    private final PreferenceFragment mTarget;

    public OnPreferenceClickListener(Method paramMethod, PreferenceFragment paramPreferenceFragment)
    {
      this.mMethod = paramMethod;
      this.mTarget = paramPreferenceFragment;
    }

    public boolean onPreferenceClick(Preference paramPreference)
    {
      try
      {
        this.mMethod.setAccessible(true);
        this.mMethod.invoke(this.mTarget, new Object[0]);
        return true;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
  }

  public static class PreferenceNotFoundException extends RuntimeException
  {
    public PreferenceNotFoundException(String paramString)
    {
      super();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.employee.inject.PreferencesInjector
 * JD-Core Version:    0.6.2
 */