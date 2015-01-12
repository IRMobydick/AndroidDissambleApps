package com.ubercab.client.core.locale;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import com.google.gson.Gson;
import com.ubercab.client.core.app.RiderFragment;
import com.ubercab.client.core.metrics.analytics.RiderEvents.Impression;
import com.ubercab.library.metrics.analytics.event.ImpressionEventName;
import javax.inject.Inject;

public class SelectCountryFragment extends RiderFragment
{
  private CountriesAdapter mAdapterCountries;

  @Inject
  Gson mGson;

  @InjectView(2131427426)
  ListView mListViewCountries;
  private Listener mListener;

  @InjectView(2131427425)
  ProgressBar mProgressBarLoading;

  protected ImpressionEventName getImpressionAnalyticsName()
  {
    return RiderEvents.Impression.SELECT_COUNTRY;
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mListener = ((Listener)paramActivity);
  }

  @OnItemClick({2131427426})
  public void onCountriesItemClick(int paramInt)
  {
    String str1 = this.mAdapterCountries.getCountryName(paramInt);
    String str2 = this.mAdapterCountries.getCountryIso2(paramInt);
    if (this.mListener != null)
      this.mListener.onCountrySelected(str1, str2);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903072, paramViewGroup, false);
    ButterKnife.inject(this, localView);
    return localView;
  }

  public void onDetach()
  {
    super.onDetach();
    this.mListener = null;
  }

  public void onResume()
  {
    super.onResume();
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mAdapterCountries = new CountriesAdapter(getActivity(), new Countries(getActivity()));
    this.mListViewCountries.setAdapter(this.mAdapterCountries);
    this.mListViewCountries.setEmptyView(this.mProgressBarLoading);
  }

  public static abstract interface Listener
  {
    public abstract void onCountrySelected(String paramString1, String paramString2);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.locale.SelectCountryFragment
 * JD-Core Version:    0.6.2
 */