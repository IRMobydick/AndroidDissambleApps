package com.ubercab.client.feature.music;

import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.ButterKnife.Finder;
import com.ubercab.client.core.ui.RiderGridView;

public class BrowseFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, BrowseFragment paramBrowseFragment, Object paramObject)
  {
    paramBrowseFragment.mGridView = ((RiderGridView)paramFinder.findRequiredView(paramObject, 2131427507, "field 'mGridView'"));
    paramBrowseFragment.mImageViewHeader = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427508, "field 'mImageViewHeader'"));
    paramBrowseFragment.mViewGroupHeader = ((ViewGroup)paramFinder.findRequiredView(paramObject, 2131427506, "field 'mViewGroupHeader'"));
  }

  public static void reset(BrowseFragment paramBrowseFragment)
  {
    paramBrowseFragment.mGridView = null;
    paramBrowseFragment.mImageViewHeader = null;
    paramBrowseFragment.mViewGroupHeader = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.BrowseFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */