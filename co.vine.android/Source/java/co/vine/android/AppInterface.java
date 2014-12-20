package co.vine.android;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import co.vine.android.client.AppController;
import org.json.JSONObject;

public abstract interface AppInterface
{
  public abstract void appendDebugInfo(Context paramContext, StringBuilder paramStringBuilder, boolean paramBoolean);

  public abstract void clearUploadCaptchas(Context paramContext);

  public abstract boolean doAddWidget(Context paramContext, AccountManager paramAccountManager, Account paramAccount);

  public abstract Intent getClearNotificationsIntent(Context paramContext);

  public abstract Intent getDiscardAllIntent(Context paramContext);

  public abstract Intent getNotifyFailedIntent(Context paramContext);

  public abstract Intent getRecordingIntent(Activity paramActivity, int paramInt, String paramString);

  public abstract void setupWidget(Activity paramActivity);

  public abstract void startCameraService(Activity paramActivity);

  public abstract void startCapture(Activity paramActivity);

  public abstract void startConversationActivity(Activity paramActivity, long paramLong1, String paramString, long paramLong2, boolean paramBoolean);

  public abstract void startUploadsListActivity(Activity paramActivity);

  public abstract void updateClientProfile(Context paramContext, AppController paramAppController, boolean paramBoolean);

  public abstract void updateRecordConfigs(Context paramContext, JSONObject paramJSONObject);
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.AppInterface
 * JD-Core Version:    0.6.0
 */