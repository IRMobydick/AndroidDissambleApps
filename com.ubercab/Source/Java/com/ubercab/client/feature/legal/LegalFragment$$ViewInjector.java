package com.ubercab.client.feature.legal;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import butterknife.ButterKnife.Finder;

public class LegalFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, LegalFragment paramLegalFragment, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427478, "field 'mListView' and method 'onItemClickLegal'");
    paramLegalFragment.mListView = ((ListView)localView);
    ((AdapterView)localView).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        this.val$target.onItemClickLegal(paramAnonymousInt);
      }
    });
  }

  public static void reset(LegalFragment paramLegalFragment)
  {
    paramLegalFragment.mListView = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.legal.LegalFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */