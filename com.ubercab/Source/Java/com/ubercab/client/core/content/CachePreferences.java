package com.ubercab.client.core.content;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public final class CachePreferences
{
  private static final String KEY_USER_SIGNIN_NAMES = "user_sign_in_names";
  public static final String PREFERENCES_FILE_NAME = ".storage";
  private Gson mGson;
  private SharedPreferences mSharedPreferences;

  public CachePreferences(SharedPreferences paramSharedPreferences, Gson paramGson)
  {
    this.mSharedPreferences = paramSharedPreferences;
    this.mGson = paramGson;
  }

  public void addUserSignInName(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    List localList;
    do
    {
      return;
      localList = getUserSignInNames();
    }
    while (localList.contains(paramString));
    localList.add(paramString);
    this.mSharedPreferences.edit().putString("user_sign_in_names", this.mGson.toJson(localList)).apply();
  }

  public void clearUserSignInNames()
  {
    this.mSharedPreferences.edit().remove("user_sign_in_names").apply();
  }

  public List<String> getUserSignInNames()
  {
    String str = this.mSharedPreferences.getString("user_sign_in_names", "");
    if (TextUtils.isEmpty(str))
      return new ArrayList();
    return (List)this.mGson.fromJson(str, new TypeToken()
    {
    }
    .getType());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.content.CachePreferences
 * JD-Core Version:    0.6.2
 */