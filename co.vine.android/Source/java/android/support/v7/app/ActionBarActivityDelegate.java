package android.support.v7.app;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle.Delegate;
import android.support.v4.app.NavUtils;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

abstract class ActionBarActivityDelegate
{
  static final String METADATA_UI_OPTIONS = "android.support.UI_OPTIONS";
  private static final String TAG = "ActionBarActivityDelegate";
  static final String UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = "splitActionBarWhenNarrow";
  private ActionBar mActionBar;
  final ActionBarActivity mActivity;
  private boolean mEnableDefaultActionBarUp;
  boolean mHasActionBar;
  private MenuInflater mMenuInflater;
  boolean mOverlayActionBar;

  ActionBarActivityDelegate(ActionBarActivity paramActionBarActivity)
  {
    this.mActivity = paramActionBarActivity;
  }

  static ActionBarActivityDelegate createDelegate(ActionBarActivity paramActionBarActivity)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 18)
      localObject = new ActionBarActivityDelegateJBMR2(paramActionBarActivity);
    while (true)
    {
      return localObject;
      if (Build.VERSION.SDK_INT >= 16)
      {
        localObject = new ActionBarActivityDelegateJB(paramActionBarActivity);
        continue;
      }
      if (Build.VERSION.SDK_INT >= 14)
      {
        localObject = new ActionBarActivityDelegateICS(paramActionBarActivity);
        continue;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject = new ActionBarActivityDelegateHC(paramActionBarActivity);
        continue;
      }
      localObject = new ActionBarActivityDelegateBase(paramActionBarActivity);
    }
  }

  abstract void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);

  abstract ActionBar createSupportActionBar();

  protected final Context getActionBarThemedContext()
  {
    Object localObject = this.mActivity;
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null)
      localObject = localActionBar.getThemedContext();
    return (Context)localObject;
  }

  final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return new ActionBarActivityDelegate.ActionBarDrawableToggleImpl(this, null);
  }

  abstract int getHomeAsUpIndicatorAttrId();

  MenuInflater getMenuInflater()
  {
    if (this.mMenuInflater == null)
      this.mMenuInflater = new SupportMenuInflater(getActionBarThemedContext());
    return this.mMenuInflater;
  }

  final ActionBar getSupportActionBar()
  {
    if ((this.mHasActionBar) || (this.mOverlayActionBar))
      if (this.mActionBar == null)
      {
        this.mActionBar = createSupportActionBar();
        if (this.mEnableDefaultActionBarUp)
          this.mActionBar.setDisplayHomeAsUpEnabled(true);
      }
    while (true)
    {
      return this.mActionBar;
      this.mActionBar = null;
    }
  }

  protected final String getUiOptionsFromMetadata()
  {
    try
    {
      ActivityInfo localActivityInfo = this.mActivity.getPackageManager().getActivityInfo(this.mActivity.getComponentName(), 128);
      localObject = null;
      if (localActivityInfo.metaData != null)
      {
        String str = localActivityInfo.metaData.getString("android.support.UI_OPTIONS");
        localObject = str;
      }
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        Log.e("ActionBarActivityDelegate", "getUiOptionsFromMetadata: Activity '" + this.mActivity.getClass().getSimpleName() + "' not in manifest");
        Object localObject = null;
      }
    }
  }

  abstract boolean onBackPressed();

  abstract void onConfigurationChanged(Configuration paramConfiguration);

  abstract void onContentChanged();

  void onCreate(Bundle paramBundle)
  {
    TypedArray localTypedArray = this.mActivity.obtainStyledAttributes(R.styleable.ActionBarWindow);
    if (!localTypedArray.hasValue(0))
    {
      localTypedArray.recycle();
      throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }
    this.mHasActionBar = localTypedArray.getBoolean(0, false);
    this.mOverlayActionBar = localTypedArray.getBoolean(1, false);
    localTypedArray.recycle();
    if (NavUtils.getParentActivityName(this.mActivity) != null)
    {
      if (this.mActionBar != null)
        break label80;
      this.mEnableDefaultActionBarUp = true;
    }
    while (true)
    {
      return;
      label80: this.mActionBar.setDisplayHomeAsUpEnabled(true);
    }
  }

  abstract boolean onCreatePanelMenu(int paramInt, Menu paramMenu);

  abstract View onCreatePanelView(int paramInt);

  abstract boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem);

  abstract void onPostResume();

  boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    if (Build.VERSION.SDK_INT < 16);
    for (boolean bool = this.mActivity.onPrepareOptionsMenu(paramMenu); ; bool = this.mActivity.superOnPrepareOptionsPanel(paramView, paramMenu))
      return bool;
  }

  abstract boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu);

  abstract void onStop();

  abstract void onTitleChanged(CharSequence paramCharSequence);

  abstract void setContentView(int paramInt);

  abstract void setContentView(View paramView);

  abstract void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);

  abstract void setSupportProgress(int paramInt);

  abstract void setSupportProgressBarIndeterminate(boolean paramBoolean);

  abstract void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean);

  abstract void setSupportProgressBarVisibility(boolean paramBoolean);

  abstract ActionMode startSupportActionMode(ActionMode.Callback paramCallback);

  abstract void supportInvalidateOptionsMenu();

  abstract boolean supportRequestWindowFeature(int paramInt);
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegate
 * JD-Core Version:    0.6.0
 */