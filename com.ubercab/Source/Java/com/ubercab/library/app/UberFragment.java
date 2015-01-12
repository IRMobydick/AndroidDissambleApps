package com.ubercab.library.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import com.squareup.otto.Bus;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import dagger.ObjectGraph;
import javax.inject.Inject;

public abstract class UberFragment extends Fragment
{

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  Bus mBus;
  private boolean mBusRegistered;
  private ObjectGraph mFragmentGraph;
  private boolean mHasImpressionAnalytics = true;

  private void createObjectGraphAndInject()
  {
    this.mFragmentGraph = ((UberActivity)getActivity()).getActivityGraph();
    this.mFragmentGraph = this.mFragmentGraph.plus(getModules());
    this.mFragmentGraph.inject(this);
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

  @Deprecated
  protected final View findViewById(int paramInt)
  {
    return getActivity().findViewById(paramInt);
  }

  protected ObjectGraph getFragmentGraph()
  {
    return this.mFragmentGraph;
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return null;
  }

  @Deprecated
  protected UberActivity getLibraryActivity()
  {
    return (UberActivity)getActivity();
  }

  protected Object[] getModules()
  {
    return new Object[0];
  }

  @Deprecated
  public final void hideLoadingDialog()
  {
    UberActivity localUberActivity = getLibraryActivity();
    if (localUberActivity != null)
      localUberActivity.hideLoadingDialog();
  }

  public <T> T inject(T paramT)
  {
    return this.mFragmentGraph.inject(paramT);
  }

  public void onCreate(Bundle paramBundle)
  {
    createObjectGraphAndInject();
    super.onCreate(paramBundle);
  }

  public void onPause()
  {
    super.onPause();
    if (this.mBusRegistered)
    {
      this.mBus.unregister(this);
      this.mBusRegistered = false;
    }
  }

  public void onResume()
  {
    super.onResume();
    if (!this.mBusRegistered)
    {
      this.mBus.register(this);
      this.mBusRegistered = true;
    }
    sendImpressionAnalyticsEvent();
  }

  protected void setHasImpressionAnalytics(boolean paramBoolean)
  {
    this.mHasImpressionAnalytics = paramBoolean;
  }

  @Deprecated
  public final void showLoadingDialog(String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    UberActivity localUberActivity = getLibraryActivity();
    if (localUberActivity != null)
      localUberActivity.showLoadingDialog(paramString, paramOnCancelListener);
  }

  @Deprecated
  public final void showLoadingDialog(String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    UberActivity localUberActivity = getLibraryActivity();
    if (localUberActivity != null)
      localUberActivity.showLoadingDialog(paramString, paramOnDismissListener);
  }

  @Deprecated
  public final void showLoadingDialogSticky(String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    UberActivity localUberActivity = getLibraryActivity();
    if (localUberActivity != null)
      localUberActivity.showLoadingDialogSticky(paramString, paramOnDismissListener);
  }

  @Deprecated
  public final void showToast(String paramString)
  {
    UberActivity localUberActivity = getLibraryActivity();
    if (localUberActivity != null)
      localUberActivity.showToast(paramString);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberFragment
 * JD-Core Version:    0.6.2
 */