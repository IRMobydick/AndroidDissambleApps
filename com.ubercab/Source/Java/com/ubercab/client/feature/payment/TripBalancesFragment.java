package com.ubercab.client.feature.payment;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.squareup.otto.Subscribe;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.client.core.model.Client;
import com.ubercab.client.core.model.event.ClientEvent;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import com.ubercab.ui.UberTextView;
import javax.inject.Inject;

public class TripBalancesFragment extends RiderFragment
{

  @Inject
  ActionBar mActionBar;
  TripBalancesAdapter mAdapter;

  @InjectView(2131427654)
  ListView mListViewBalances;

  @InjectView(2131427655)
  UberTextView mTextViewFooter;

  public static TripBalancesFragment newInstance()
  {
    return new TripBalancesFragment();
  }

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.PAYMENT_METHOD_DETAIL_TRIP_BALANCE;
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.mActionBar.setTitle(getString(2131558995).toUpperCase());
  }

  @Subscribe
  public void onClientEvent(ClientEvent paramClientEvent)
  {
    Client localClient = paramClientEvent.getClient();
    this.mAdapter.update(localClient.getTripBalances());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903151, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    this.mTextViewFooter.setText(getString(2131558994));
    this.mAdapter = new TripBalancesAdapter(getActivity());
    this.mListViewBalances.setAdapter(this.mAdapter);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.TripBalancesFragment
 * JD-Core Version:    0.6.2
 */