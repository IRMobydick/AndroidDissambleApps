package com.ubercab.client.feature.share;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.core.ui.RiderGridView;

public class ShareFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, ShareFragment paramShareFragment, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427700, "field 'mGridViewIntents' and method 'onItemClickIntentGridView'");
    paramShareFragment.mGridViewIntents = ((RiderGridView)localView);
    ((AdapterView)localView).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        this.val$target.onItemClickIntentGridView(paramAnonymousInt);
      }
    });
  }

  public static void reset(ShareFragment paramShareFragment)
  {
    paramShareFragment.mGridViewIntents = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.share.ShareFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */