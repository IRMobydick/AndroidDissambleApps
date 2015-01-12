package com.ubercab.client.feature.about;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import butterknife.ButterKnife.Finder;

public class OtherFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, OtherFragment paramOtherFragment, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427417, "field 'mListView' and method 'onItemClickOther'");
    paramOtherFragment.mListView = ((ListView)localView);
    ((AdapterView)localView).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        this.val$target.onItemClickOther(paramAnonymousInt);
      }
    });
  }

  public static void reset(OtherFragment paramOtherFragment)
  {
    paramOtherFragment.mListView = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.OtherFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */