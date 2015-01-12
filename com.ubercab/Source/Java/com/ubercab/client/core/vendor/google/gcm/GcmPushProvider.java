package com.ubercab.client.core.vendor.google.gcm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.ubercab.client.core.push.PushProvider;
import com.ubercab.client.core.push.PushProvider.RegisterCallback;
import com.ubercab.client.core.push.PushProvider.UnregisterCallback;
import java.util.concurrent.ExecutorService;

public class GcmPushProvider
  implements PushProvider
{
  private static final String PREF_APP_VERSION = "app_version";
  private static final String PREF_REG_ID = "registration_id";
  private static final String PROVIDER_NAME = "gcm";
  private static final String TAG = "GcmPushProvider";
  private final Context mContext;
  private final ExecutorService mExecutorService;

  public GcmPushProvider(Context paramContext, ExecutorService paramExecutorService)
  {
    this.mContext = paramContext;
    this.mExecutorService = paramExecutorService;
  }

  private SharedPreferences getGCMPreferences()
  {
    return this.mContext.getSharedPreferences("gcm", 0);
  }

  private void storeRegistrationId(String paramString)
  {
    SharedPreferences.Editor localEditor = getGCMPreferences().edit();
    if (!TextUtils.isEmpty(paramString))
    {
      localEditor.putString("registration_id", paramString);
      localEditor.putInt("app_version", 30723);
    }
    while (true)
    {
      localEditor.commit();
      return;
      localEditor.clear();
    }
  }

  public String getRegistrationId()
  {
    SharedPreferences localSharedPreferences = getGCMPreferences();
    String str = localSharedPreferences.getString("registration_id", null);
    if (TextUtils.isEmpty(str))
      str = null;
    while (localSharedPreferences.getInt("app_version", -2147483648) == 30723)
      return str;
    return null;
  }

  public void register(final PushProvider.RegisterCallback paramRegisterCallback)
  {
    final String str = this.mContext.getString(2131559131);
    this.mExecutorService.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          GoogleCloudMessaging localGoogleCloudMessaging = GoogleCloudMessaging.getInstance(GcmPushProvider.this.mContext);
          String[] arrayOfString = new String[1];
          arrayOfString[0] = str;
          String str = localGoogleCloudMessaging.register(arrayOfString);
          GcmPushProvider.this.storeRegistrationId(str);
          paramRegisterCallback.onRegistered("gcm", str);
          return;
        }
        catch (Exception localException)
        {
        }
      }
    });
  }

  public void unregister(final PushProvider.UnregisterCallback paramUnregisterCallback)
  {
    this.mExecutorService.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          String str = GcmPushProvider.this.getRegistrationId();
          if (TextUtils.isEmpty(str))
            return;
          GoogleCloudMessaging.getInstance(GcmPushProvider.this.mContext).unregister();
          GcmPushProvider.this.storeRegistrationId(null);
          paramUnregisterCallback.onUnregistered("gcm", str);
          return;
        }
        catch (Exception localException)
        {
        }
      }
    });
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.vendor.google.gcm.GcmPushProvider
 * JD-Core Version:    0.6.2
 */