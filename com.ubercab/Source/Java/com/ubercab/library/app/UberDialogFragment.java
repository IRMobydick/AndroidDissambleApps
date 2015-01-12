package com.ubercab.library.app;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import com.squareup.otto.Bus;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import javax.inject.Inject;

public abstract class UberDialogFragment extends DialogFragment
{
  protected static final String BUNDLE_REQUEST_CODE = "dialog.request_code";

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  Bus mBus;
  private boolean mHasImpressionAnalytics = true;

  protected static Bundle createArguments(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("dialog.request_code", paramInt);
    return localBundle;
  }

  private void sendImpressionAnalyticsEvent()
  {
    if (this.mHasImpressionAnalytics)
    {
      ImpressionEventName localImpressionEventName = getImpressionAnalyticsName();
      if (localImpressionEventName != null)
        this.mAnalyticsClient.sendImpressionEvent(localImpressionEventName);
    }
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return null;
  }

  public void inject(Object paramObject)
  {
    ((UberActivity)getActivity()).inject(paramObject);
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    onResult(0);
  }

  public void onCreate(Bundle paramBundle)
  {
    inject(this);
    super.onCreate(paramBundle);
  }

  public void onPause()
  {
    super.onPause();
    this.mBus.unregister(this);
  }

  protected void onResult(int paramInt)
  {
    UberActivity localUberActivity = (UberActivity)getActivity();
    if (localUberActivity != null)
    {
      Bundle localBundle = getArguments();
      if (localBundle != null)
        localUberActivity.onDialogResult(localBundle.getInt("dialog.request_code"), paramInt, localBundle);
    }
  }

  public void onResume()
  {
    super.onResume();
    this.mBus.register(this);
    sendImpressionAnalyticsEvent();
  }

  protected void setHasImpressionAnalytics(boolean paramBoolean)
  {
    this.mHasImpressionAnalytics = paramBoolean;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberDialogFragment
 * JD-Core Version:    0.6.2
 */