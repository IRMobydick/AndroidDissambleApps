package com.ubercab.client.feature.music;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.ubercab.client.core.app.RiderPublicActivity;
import javax.inject.Inject;

public class MusicActivity extends RiderPublicActivity
{

  @Inject
  ActionBar mActionBar;

  private void addTab(String paramString, TabListener paramTabListener)
  {
    ActionBar.Tab localTab = this.mActionBar.newTab().setText(paramString).setTabListener(paramTabListener);
    this.mActionBar.addTab(localTab);
  }

  private void setupTabs()
  {
    this.mActionBar.setNavigationMode(2);
    addTab(getString(2131558463), new TabListener(this, BrowseFragment.class));
    addTab(getString(2131559005), new TabListener(this, PlaylistFragment.class));
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setupTabs();
  }

  private static class TabListener<T extends Fragment>
    implements ActionBar.TabListener
  {
    private final Activity mActivity;
    private final Class<T> mClass;
    private Fragment mFragment;

    TabListener(Activity paramActivity, Class<T> paramClass)
    {
      this.mActivity = paramActivity;
      this.mClass = paramClass;
    }

    public void onTabReselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
    {
    }

    public void onTabSelected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
    {
      if (this.mFragment == null)
      {
        this.mFragment = Fragment.instantiate(this.mActivity, this.mClass.getName());
        paramFragmentTransaction.add(16908290, this.mFragment, this.mClass.getName());
        return;
      }
      paramFragmentTransaction.attach(this.mFragment);
    }

    public void onTabUnselected(ActionBar.Tab paramTab, FragmentTransaction paramFragmentTransaction)
    {
      if (this.mFragment != null)
        paramFragmentTransaction.detach(this.mFragment);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicActivity
 * JD-Core Version:    0.6.2
 */