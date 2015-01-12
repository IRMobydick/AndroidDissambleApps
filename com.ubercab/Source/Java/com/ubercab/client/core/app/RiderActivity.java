package com.ubercab.client.core.app;

import android.app.ActionBar;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.ubercab.client.core.analytics.AnalyticsManager;
import com.ubercab.client.core.analytics.event.LocationEvent;
import com.ubercab.client.core.analytics.event.SignOutEvent;
import com.ubercab.client.core.content.SessionPreferences;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.module.RiderActivityModule;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.feature.trip.TripActivity;
import com.ubercab.common.collect.ObjectArrays;
import com.ubercab.geo.GeoManager;
import com.ubercab.library.app.UberActivity;
import com.ubercab.library.network.dispatch.DispatchCallback;
import com.ubercab.library.network.dispatch.DispatchClient;
import com.ubercab.library.network.dispatch.DispatchRequest;
import com.ubercab.library.ui.MessageDialogFragment;
import com.ubercab.library.vendor.google.GoogleUtils;
import com.ubercab.ui.FontUtils;
import javax.inject.Inject;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

abstract class RiderActivity extends UberActivity
  implements ServiceConnection, DispatchCallback<Ping>
{
  protected static final String ACTION_MOBILE_VERIFICATION_SMS = "com.ubercab.ACTION_MOBILE_VERIFICATION_SMS";
  protected static final String ACTION_MOBILE_VERIFICATION_TOKEN = "com.ubercab.ACTION_MOBILE_VERIFICATION_TOKEN";
  private static final String EXTRA_GOOGLE_PLAY_SERVICES_ERROR_INTENT = "google_play_services_error";
  public static final String INTENT_LAUNCHER = "com.ubercab.client.LAUNCHER";
  private static final int REQUEST_CODE_GOOGLE_LOCATION_SERVICE_ERROR = 2100;
  private static final int REQUEST_CODE_GOOGLE_PLAY_SERVICE_ERROR = 9010;

  @Inject
  AnalyticsManager mAnalyticsManager;

  @Inject
  DispatchClient mClient;

  @Inject
  GeoManager mGeoManager;
  private Handler mHandler = new Handler();

  @Inject
  SessionPreferences mSessionPreferences;

  private void checkIfGooglePlayServiceIsAvailable()
  {
    int i;
    if ((0x100 & getApplicationInfo().flags) != 0)
    {
      i = 1;
      if (i == 0)
        break label26;
    }
    label26: int j;
    do
    {
      do
      {
        return;
        i = 0;
        break;
      }
      while ((this.mGeoManager.getGeo() == 3) || (this.mGeoManager.getGeo() == 0));
      j = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
    }
    while ((j == 0) || (j == 1));
    GooglePlayServicesUtil.getErrorDialog(j, this, 9010).show();
  }

  private void hideNetworkError()
  {
    NetworkErrorFragment localNetworkErrorFragment = (NetworkErrorFragment)findFragment(NetworkErrorFragment.class);
    if (localNetworkErrorFragment != null)
      localNetworkErrorFragment.dismiss();
  }

  private void initActionBar()
  {
    if ((Build.VERSION.SDK_INT < 16) && (NavUtils.getParentActivityName(this) != null))
      getActionBar().setDisplayHomeAsUpEnabled(true);
    float f1 = getResources().getDimension(2131361985);
    TextView localTextView1 = (TextView)findViewById(getResources().getIdentifier("action_bar_title", "id", "android"));
    if (localTextView1 != null)
    {
      FontUtils.applyFontToTextView(this, localTextView1, 2131559274, true);
      localTextView1.setTextSize(0, f1);
    }
    float f2 = getResources().getDimension(2131361984);
    TextView localTextView2 = (TextView)findViewById(getResources().getIdentifier("action_bar_subtitle", "id", "android"));
    if (localTextView2 != null)
    {
      FontUtils.applyFontToTextView(this, localTextView2, 2131559280, true);
      localTextView2.setTextSize(0, f2);
    }
  }

  private void showNetworkError()
  {
    if ((NetworkErrorFragment)findFragment(NetworkErrorFragment.class) == null)
      new NetworkErrorFragment().show(getFragmentManager(), NetworkErrorFragment.class.getName());
  }

  protected void alertIfLocationServicesDisabled()
  {
    if (GoogleUtils.isLocationProviderAvailable(this));
    while (findFragment(MessageDialogFragment.class) != null)
      return;
    String str = getString(2131558834);
    MessageDialogFragment.show(this, 2100, getString(2131558836), getString(2131558835), str);
    getFragmentManager().executePendingTransactions();
  }

  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(new CalligraphyContextWrapper(paramContext));
  }

  protected Object[] getModules()
  {
    return ObjectArrays.concat(super.getModules(), new RiderActivityModule(this));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 9010) && (paramIntent != null));
    try
    {
      PendingIntent localPendingIntent = (PendingIntent)paramIntent.getParcelableExtra("google_play_services_error");
      if (localPendingIntent != null)
        localPendingIntent.send();
      return;
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      Timber.e(localCanceledException, "Error sending pending intent from Google Play service error.", new Object[0]);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initActionBar();
  }

  public void onDialogResult(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    super.onDialogResult(paramInt1, paramInt2, paramBundle);
    if ((paramInt1 == 2100) && (paramInt2 == -1))
    {
      this.mAnalyticsManager.locationEvent().promptEnableLocationServices();
      startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }
  }

  public void onDispatchError(DispatchRequest paramDispatchRequest, final Ping paramPing, Response paramResponse)
  {
    if (paramDispatchRequest.getMessageType().equals("PingClient"))
    {
      showNetworkError();
      if ((!PingUtils.hasClient(paramPing)) || (paramPing.getClient().hasConfirmedMobile()))
        break label76;
      if (!paramPing.getClient().hasToOptInSmsNotifications())
        break label69;
    }
    label69: for (String str = "com.ubercab.ACTION_MOBILE_VERIFICATION_SMS"; ; str = "com.ubercab.ACTION_MOBILE_VERIFICATION_TOKEN")
    {
      startActivity(new Intent(str));
      return;
      hideNetworkError();
      break;
    }
    label76: this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if ((PingUtils.hasErrorCode(paramPing, 0)) && (RiderActivity.this.mSessionPreferences.hasToken()))
        {
          RiderActivity.this.mSessionPreferences.clear();
          RiderActivity.this.startLauncherActivityAndClearTask();
          RiderActivity.this.mAnalyticsManager.signOutEvent().pingResponseStatusUnknown();
          return;
        }
        RiderActivity.this.showToast(paramPing.getDescription());
      }
    });
  }

  public void onDispatchNetworkError(DispatchRequest paramDispatchRequest, RetrofitError paramRetrofitError)
  {
    showNetworkError();
  }

  public void onDispatchSuccess(DispatchRequest paramDispatchRequest, Ping paramPing, Response paramResponse)
  {
    hideNetworkError();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      NavUtils.navigateUpFromSameTask(this);
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  public void onPause()
  {
    super.onPause();
    this.mClient.removeCallback(this);
  }

  public void onResume()
  {
    super.onResume();
    checkIfGooglePlayServiceIsAvailable();
    this.mClient.addCallback(this);
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
  }

  protected void onStart()
  {
    super.onStart();
    bindService(new Intent(this, RiderService.class), this, 1);
  }

  protected void onStop()
  {
    super.onStop();
    unbindService(this);
  }

  protected void startLauncherActivityAndClearTask()
  {
    Intent localIntent1 = getIntent();
    Intent localIntent2 = new Intent("com.ubercab.client.LAUNCHER");
    localIntent2.addCategory("android.intent.category.DEFAULT");
    localIntent2.setPackage(getPackageName());
    ComponentName localComponentName = localIntent2.resolveActivity(getPackageManager());
    Intent localIntent3 = new Intent();
    localIntent3.setComponent(localComponentName);
    localIntent3.addFlags(268435456);
    localIntent3.addFlags(32768);
    if ((this instanceof TripActivity))
      localIntent3.putExtra("trip_notification_action", localIntent1.getAction());
    localIntent3.setData(localIntent1.getData());
    startActivity(localIntent3);
    finish();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.app.RiderActivity
 * JD-Core Version:    0.6.2
 */