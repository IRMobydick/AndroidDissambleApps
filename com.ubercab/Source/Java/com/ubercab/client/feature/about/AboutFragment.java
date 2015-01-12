package com.ubercab.client.feature.about;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnItemClick;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.content.event.PingEvent;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.ui.SimpleListItem;
import com.ubercab.client.core.ui.SimpleSectionAdapter;
import com.ubercab.client.core.util.RiderUtil;
import com.ubercab.client.feature.about.event.SelectLegalEvent;
import com.ubercab.client.feature.employee.EmployeeSettingsActivity;
import com.ubercab.common.collect.ImmutableList.Builder;
import com.ubercab.library.app.annotation.ForActivity;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class AboutFragment extends RiderFragment
{
  private static final int ITEM_DEV = 3;
  private static final int ITEM_FB = 1;
  private static final int ITEM_LEGAL = 2;
  private static final int ITEM_RATE;

  @Inject
  ActionBar mActionBar;
  private SimpleSectionAdapter mAdapterAbout;

  @Inject
  Bus mBus;

  @ForActivity
  @Inject
  Context mContext;
  private boolean mIsAdmin;

  @Inject
  LayoutInflater mLayoutInflater;

  @InjectView(2131427415)
  ListView mListViewAbout;

  @Inject
  RiderLocationProvider mLocationProvider;

  @InjectView(2131427416)
  UberTextView mTextViewVersionNumber;

  public static AboutFragment newInstance()
  {
    return new AboutFragment();
  }

  private void startEmployeeActivity()
  {
    startActivity(new Intent(getActivity(), EmployeeSettingsActivity.class));
  }

  private void startFacebookActivity()
  {
    try
    {
      getActivity().getPackageManager().getPackageInfo("com.facebook.katana", 0);
      Uri localUri2 = Uri.parse(getString(2131559272));
      localUri1 = localUri2;
      startActivity(new Intent("android.intent.action.VIEW", localUri1));
      return;
    }
    catch (Exception localException)
    {
      while (true)
        Uri localUri1 = Uri.parse(getString(2131559273));
    }
  }

  private void startGooglePlayActivity()
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(2131559283))));
  }

  private void startUberWebsiteActivity()
  {
    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://" + getString(2131559309))));
  }

  private void updateListView()
  {
    ImmutableList.Builder localBuilder = new ImmutableList.Builder();
    localBuilder.add(new SimpleListItem(0, getString(2131559018)));
    localBuilder.add(new SimpleListItem(1, getString(2131558907)));
    localBuilder.add(new SimpleListItem(2, getString(2131558906)));
    if (this.mIsAdmin)
      localBuilder.add(new SimpleListItem(3, getString(2131559215)));
    this.mAdapterAbout.update(localBuilder.build());
    this.mAdapterAbout.notifyDataSetChanged();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903065, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    ButterKnife.reset(this);
  }

  @OnItemClick({2131427415})
  public void onItemClickAbout(int paramInt)
  {
    switch (((SimpleListItem)this.mListViewAbout.getItemAtPosition(paramInt)).getId())
    {
    default:
      return;
    case 0:
      startGooglePlayActivity();
      return;
    case 1:
      startFacebookActivity();
      return;
    case 2:
      this.mBus.post(new SelectLegalEvent());
      return;
    case 3:
    }
    startEmployeeActivity();
  }

  @Subscribe
  public void onPingEvent(PingEvent paramPingEvent)
  {
    boolean bool = paramPingEvent.getPing().getClient().isAdmin();
    if ((this.mAdapterAbout.isEmpty()) || (this.mIsAdmin != bool))
    {
      this.mIsAdmin = bool;
      updateListView();
    }
  }

  public void onResume()
  {
    super.onResume();
    this.mActionBar.setTitle(getString(2131558415));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mTextViewVersionNumber.setText(String.format("%s (%s)", new Object[] { "3.23.2", "03a270b" }));
    this.mAdapterAbout = new SimpleSectionAdapter(getActivity());
    View localView = this.mLayoutInflater.inflate(2130903068, this.mListViewAbout, false);
    localView.setTag(new HeaderViewHolder(localView));
    this.mListViewAbout.addHeaderView(localView, null, false);
    this.mListViewAbout.setDrawSelectorOnTop(true);
    this.mListViewAbout.setDivider(null);
    this.mListViewAbout.setDividerHeight(0);
    this.mListViewAbout.setAdapter(this.mAdapterAbout);
  }

  class HeaderViewHolder
  {

    @InjectView(2131427420)
    UberTextView mTextViewTitle;

    HeaderViewHolder(View arg2)
    {
      View localView;
      ButterKnife.inject(this, localView);
      String str = RiderUtil.getUberSlogan(AboutFragment.this.mContext, AboutFragment.this.mLocationProvider.getDeviceLocation());
      this.mTextViewTitle.setText(str);
    }

    @OnClick({2131427421})
    public void onClickUberUrl()
    {
      AboutFragment.this.startUberWebsiteActivity();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.AboutFragment
 * JD-Core Version:    0.6.2
 */