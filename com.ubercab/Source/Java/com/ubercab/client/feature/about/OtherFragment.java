package com.ubercab.client.feature.about;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import com.squareup.otto.Bus;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.content.PingProvider;
import com.ubercab.client.core.content.RiderLocationProvider;
import com.ubercab.client.core.location.RiderLocation;
import com.ubercab.client.core.model.City;
import com.ubercab.client.core.model.Ping;
import com.ubercab.client.core.ui.SimpleListItem;
import com.ubercab.client.core.ui.SimpleSectionAdapter;
import com.ubercab.client.core.util.PingUtils;
import com.ubercab.client.core.util.UrlUtils;
import com.ubercab.client.feature.about.event.SelectPdfEvent;
import com.ubercab.client.feature.about.event.SelectWebViewEvent;
import com.ubercab.library.util.LocationUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class OtherFragment extends RiderFragment
{
  private static final int ITEM_CA_DISCLAIMER = 2;
  private static final int ITEM_CHICAGO_INSURANCE = 3;
  private static final int ITEM_JAPAN_TRAVEL_AGENCY_LICENSE = 0;
  private static final int ITEM_JAPAN_TRAVEL_AGREEMENT = 1;

  @Inject
  ActionBar mActionBar;
  private SimpleSectionAdapter mAdapterOther;

  @Inject
  Bus mBus;

  @InjectView(2131427417)
  ListView mListView;

  @Inject
  RiderLocationProvider mLocationProvider;

  @Inject
  PingProvider mPingProvider;

  public static OtherFragment newInstance()
  {
    return new OtherFragment();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903066, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDestroy()
  {
    super.onDestroy();
    ButterKnife.reset(this);
  }

  @OnItemClick({2131427417})
  public void onItemClickOther(int paramInt)
  {
    switch (this.mAdapterOther.getItem(paramInt).getId())
    {
    case 0:
    default:
      return;
    case 1:
      this.mBus.post(new SelectPdfEvent("http://www.uber.com/tokyo/travelagreement"));
      return;
    case 2:
      String str1 = UrlUtils.localizeUrl("https://www.uber.com/legal/%s/ca-tnc?plain=true");
      String str2 = getString(2131558465);
      this.mBus.post(new SelectWebViewEvent(str2, str1));
      return;
    case 3:
    }
    this.mBus.post(new SelectPdfEvent("https://s3.amazonaws.com/uber-regulatory-documents/insurance/Chicago_Certificates_of_Insurance.pdf"));
  }

  public void onResume()
  {
    super.onResume();
    this.mActionBar.setTitle(getString(2131558980));
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ArrayList localArrayList = new ArrayList();
    RiderLocation localRiderLocation = this.mLocationProvider.getDeviceLocation();
    if (LocationUtils.isInJapan(localRiderLocation))
    {
      localArrayList.add(new SimpleListItem(0, getString(2131558901)));
      localArrayList.add(new SimpleListItem(1, getString(2131558902)));
    }
    if (LocationUtils.isInCalifornia(localRiderLocation))
      localArrayList.add(new SimpleListItem(2, "CA TNC"));
    Ping localPing = this.mPingProvider.get();
    if ((PingUtils.hasCity(localPing)) && ("chicago".equals(localPing.getCity().getCityName())))
      localArrayList.add(new SimpleListItem(3, "IL Insurance Certificate"));
    this.mAdapterOther = new SimpleSectionAdapter(getActivity());
    this.mAdapterOther.update(localArrayList);
    this.mListView.setAdapter(this.mAdapterOther);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.OtherFragment
 * JD-Core Version:    0.6.2
 */