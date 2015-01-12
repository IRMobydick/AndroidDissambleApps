package com.ubercab.library.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.widget.Toast;
import com.squareup.otto.Bus;
import com.ubercab.library.metrics.analytics.AnalyticsClient;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.library.ui.UberProgressDialog;
import dagger.ObjectGraph;
import javax.inject.Inject;

public abstract class UberActivity extends Activity
{
  private ObjectGraph mActivityGraph;

  @Inject
  AnalyticsClient mAnalyticsClient;

  @Inject
  LifecycleTracker mAppLifecycleTracker;

  @Inject
  Bus mBus;
  private boolean mBusRegistered;
  private boolean mHasImpressionAnalytics;
  private AlertDialog mProgressDialogLoading;

  private void createObjectGraphAndInject()
  {
    this.mActivityGraph = UberApplication.get(this).getApplicationGraph();
    this.mActivityGraph = this.mActivityGraph.plus(getModules());
    this.mActivityGraph.inject(this);
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

  protected final <T extends Fragment> T findFragment(Class<? extends Fragment> paramClass)
  {
    try
    {
      Fragment localFragment = getFragmentManager().findFragmentByTag(paramClass.getName());
      return localFragment;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected ObjectGraph getActivityGraph()
  {
    return this.mActivityGraph;
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return null;
  }

  protected Object[] getModules()
  {
    return new Object[0];
  }

  @Deprecated
  public final void hideLoadingDialog()
  {
    if ((this.mProgressDialogLoading != null) && (this.mProgressDialogLoading.isShowing()))
    {
      this.mProgressDialogLoading.dismiss();
      this.mProgressDialogLoading = null;
    }
  }

  public <T> T inject(T paramT)
  {
    return this.mActivityGraph.inject(paramT);
  }

  protected void onCreate(Bundle paramBundle)
  {
    createObjectGraphAndInject();
    super.onCreate(paramBundle);
  }

  protected void onDestroy()
  {
    this.mActivityGraph = null;
    if ((this.mProgressDialogLoading != null) && (this.mProgressDialogLoading.isShowing()))
      this.mProgressDialogLoading.dismiss();
    super.onDestroy();
  }

  public void onDialogResult(int paramInt1, int paramInt2, Bundle paramBundle)
  {
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
    this.mAppLifecycleTracker.onActivityResume(getIntent());
    sendImpressionAnalyticsEvent();
    if (!this.mBusRegistered)
    {
      this.mBus.register(this);
      this.mBusRegistered = true;
    }
  }

  protected final void popAllFragments()
  {
    try
    {
      for (int i = -1 + getFragmentManager().getBackStackEntryCount(); i >= 0; i--)
        popFragment();
      return;
    }
    finally
    {
    }
  }

  protected final void popFragment()
  {
    try
    {
      FragmentManager localFragmentManager = getFragmentManager();
      if (localFragmentManager.getBackStackEntryCount() > 0)
        localFragmentManager.popBackStack();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected final void pushFragment(int paramInt, Fragment paramFragment, boolean paramBoolean)
  {
    try
    {
      String str = paramFragment.getClass().getName();
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      if (paramBoolean)
        localFragmentTransaction.replace(paramInt, paramFragment, str);
      while (true)
      {
        localFragmentTransaction.addToBackStack(str);
        localFragmentTransaction.commit();
        return;
        localFragmentTransaction.add(paramInt, paramFragment, str);
      }
    }
    finally
    {
    }
  }

  protected final void putFragment(int paramInt, Fragment paramFragment, boolean paramBoolean)
  {
    try
    {
      String str = paramFragment.getClass().getName();
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      if (paramBoolean)
        localFragmentTransaction.replace(paramInt, paramFragment, str);
      while (true)
      {
        localFragmentTransaction.commit();
        return;
        localFragmentTransaction.add(paramInt, paramFragment, str);
      }
    }
    finally
    {
    }
  }

  protected final void removeFragment(Fragment paramFragment)
  {
    try
    {
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      localFragmentTransaction.remove(paramFragment);
      localFragmentTransaction.commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected void setHasImpressionAnalytics(boolean paramBoolean)
  {
    this.mHasImpressionAnalytics = paramBoolean;
  }

  @Deprecated
  public final void showLoadingDialog(String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if ((this.mProgressDialogLoading == null) || (!this.mProgressDialogLoading.isShowing()))
    {
      this.mProgressDialogLoading = UberProgressDialog.create(this, paramString, true, null);
      this.mProgressDialogLoading.setOnCancelListener(paramOnCancelListener);
      this.mProgressDialogLoading.show();
    }
  }

  @Deprecated
  public final void showLoadingDialog(String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if ((this.mProgressDialogLoading == null) || (!this.mProgressDialogLoading.isShowing()))
    {
      this.mProgressDialogLoading = UberProgressDialog.create(this, paramString, true, paramOnDismissListener);
      this.mProgressDialogLoading.show();
    }
  }

  @Deprecated
  public final void showLoadingDialogSticky(String paramString, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if ((this.mProgressDialogLoading == null) || (!this.mProgressDialogLoading.isShowing()))
    {
      this.mProgressDialogLoading = UberProgressDialog.create(this, paramString, false, paramOnDismissListener);
      this.mProgressDialogLoading.show();
    }
  }

  @Deprecated
  public final void showToast(String paramString)
  {
    Toast.makeText(this, paramString, 1).show();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberActivity
 * JD-Core Version:    0.6.2
 */