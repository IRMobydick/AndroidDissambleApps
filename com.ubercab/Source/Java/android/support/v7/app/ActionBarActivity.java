package android.support.v7.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActionBarDrawerToggle.DelegateProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.app.TaskStackBuilder.SupportParentable;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class ActionBarActivity extends FragmentActivity
  implements ActionBar.Callback, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider, ActionBarDrawerToggle.TmpDelegateProvider
{
  private ActionBarActivityDelegate mDelegate;

  private ActionBarActivityDelegate getDelegate()
  {
    if (this.mDelegate == null)
      this.mDelegate = ActionBarActivityDelegate.createDelegate(this);
    return this.mDelegate;
  }

  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().addContentView(paramView, paramLayoutParams);
  }

  public final android.support.v4.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return getDelegate().getDrawerToggleDelegate();
  }

  public MenuInflater getMenuInflater()
  {
    return getDelegate().getMenuInflater();
  }

  public ActionBar getSupportActionBar()
  {
    return getDelegate().getSupportActionBar();
  }

  public Intent getSupportParentActivityIntent()
  {
    return NavUtils.getParentActivityIntent(this);
  }

  @Nullable
  public ActionBarDrawerToggle.Delegate getV7DrawerToggleDelegate()
  {
    return getDelegate().getV7DrawerToggleDelegate();
  }

  public void invalidateOptionsMenu()
  {
    getDelegate().supportInvalidateOptionsMenu();
  }

  public void onBackPressed()
  {
    if (!getDelegate().onBackPressed())
      super.onBackPressed();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getDelegate().onConfigurationChanged(paramConfiguration);
  }

  public final void onContentChanged()
  {
    getDelegate().onContentChanged();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getDelegate().onCreate(paramBundle);
  }

  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return getDelegate().onCreatePanelMenu(paramInt, paramMenu);
  }

  public View onCreatePanelView(int paramInt)
  {
    if (paramInt == 0)
      return getDelegate().onCreatePanelView(paramInt);
    return super.onCreatePanelView(paramInt);
  }

  public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder paramTaskStackBuilder)
  {
    paramTaskStackBuilder.addParentStack(this);
  }

  public View onCreateView(String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    View localView = super.onCreateView(paramString, paramContext, paramAttributeSet);
    if (localView != null)
      return localView;
    return getDelegate().createView(paramString, paramAttributeSet);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    getDelegate().destroy();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (super.onKeyDown(paramInt, paramKeyEvent))
      return true;
    return getDelegate().onKeyDown(paramInt, paramKeyEvent);
  }

  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    return getDelegate().onKeyShortcut(paramInt, paramKeyEvent);
  }

  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem))
      return true;
    ActionBar localActionBar = getSupportActionBar();
    if ((paramMenuItem.getItemId() == 16908332) && (localActionBar != null) && ((0x4 & localActionBar.getDisplayOptions()) != 0))
      return onSupportNavigateUp();
    return false;
  }

  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return getDelegate().onMenuOpened(paramInt, paramMenu);
  }

  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    getDelegate().onPanelClosed(paramInt, paramMenu);
  }

  protected void onPostResume()
  {
    super.onPostResume();
    getDelegate().onPostResume();
  }

  protected boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    return getDelegate().onPrepareOptionsPanel(paramView, paramMenu);
  }

  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return getDelegate().onPreparePanel(paramInt, paramView, paramMenu);
  }

  public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder paramTaskStackBuilder)
  {
  }

  protected void onStop()
  {
    super.onStop();
    getDelegate().onStop();
  }

  public void onSupportActionModeFinished(ActionMode paramActionMode)
  {
  }

  public void onSupportActionModeStarted(ActionMode paramActionMode)
  {
  }

  public void onSupportContentChanged()
  {
  }

  public boolean onSupportNavigateUp()
  {
    Intent localIntent = getSupportParentActivityIntent();
    if (localIntent != null)
    {
      if (supportShouldUpRecreateTask(localIntent))
      {
        TaskStackBuilder localTaskStackBuilder = TaskStackBuilder.create(this);
        onCreateSupportNavigateUpTaskStack(localTaskStackBuilder);
        onPrepareSupportNavigateUpTaskStack(localTaskStackBuilder);
        localTaskStackBuilder.startActivities();
      }
      while (true)
      {
        try
        {
          ActivityCompat.finishAffinity(this);
          return true;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          finish();
          continue;
        }
        supportNavigateUpTo(localIntent);
      }
    }
    return false;
  }

  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    getDelegate().onTitleChanged(paramCharSequence);
  }

  public void setContentView(int paramInt)
  {
    getDelegate().setContentView(paramInt);
  }

  public void setContentView(View paramView)
  {
    getDelegate().setContentView(paramView);
  }

  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().setContentView(paramView, paramLayoutParams);
  }

  public void setSupportActionBar(@Nullable Toolbar paramToolbar)
  {
    getDelegate().setSupportActionBar(paramToolbar);
  }

  public void setSupportProgress(int paramInt)
  {
    getDelegate().setSupportProgress(paramInt);
  }

  public void setSupportProgressBarIndeterminate(boolean paramBoolean)
  {
    getDelegate().setSupportProgressBarIndeterminate(paramBoolean);
  }

  public void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
    getDelegate().setSupportProgressBarIndeterminateVisibility(paramBoolean);
  }

  public void setSupportProgressBarVisibility(boolean paramBoolean)
  {
    getDelegate().setSupportProgressBarVisibility(paramBoolean);
  }

  public ActionMode startSupportActionMode(ActionMode.Callback paramCallback)
  {
    return getDelegate().startSupportActionMode(paramCallback);
  }

  void superAddContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addContentView(paramView, paramLayoutParams);
  }

  boolean superOnCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }

  boolean superOnMenuOpened(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }

  void superOnPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }

  boolean superOnPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    return super.onPrepareOptionsPanel(paramView, paramMenu);
  }

  boolean superOnPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }

  void superSetContentView(int paramInt)
  {
    super.setContentView(paramInt);
  }

  void superSetContentView(View paramView)
  {
    super.setContentView(paramView);
  }

  void superSetContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
  }

  public void supportInvalidateOptionsMenu()
  {
    getDelegate().supportInvalidateOptionsMenu();
  }

  public void supportNavigateUpTo(Intent paramIntent)
  {
    NavUtils.navigateUpTo(this, paramIntent);
  }

  public boolean supportRequestWindowFeature(int paramInt)
  {
    return getDelegate().supportRequestWindowFeature(paramInt);
  }

  public boolean supportShouldUpRecreateTask(Intent paramIntent)
  {
    return NavUtils.shouldUpRecreateTask(this, paramIntent);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivity
 * JD-Core Version:    0.6.2
 */