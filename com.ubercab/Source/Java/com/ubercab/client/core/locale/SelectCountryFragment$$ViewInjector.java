package com.ubercab.client.core.locale;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import butterknife.ButterKnife.Finder;

public class SelectCountryFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, SelectCountryFragment paramSelectCountryFragment, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427426, "field 'mListViewCountries' and method 'onCountriesItemClick'");
    paramSelectCountryFragment.mListViewCountries = ((ListView)localView);
    ((AdapterView)localView).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        this.val$target.onCountriesItemClick(paramAnonymousInt);
      }
    });
    paramSelectCountryFragment.mProgressBarLoading = ((ProgressBar)paramFinder.findRequiredView(paramObject, 2131427425, "field 'mProgressBarLoading'"));
  }

  public static void reset(SelectCountryFragment paramSelectCountryFragment)
  {
    paramSelectCountryFragment.mListViewCountries = null;
    paramSelectCountryFragment.mProgressBarLoading = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.locale.SelectCountryFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */