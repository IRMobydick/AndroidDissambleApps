package com.ubercab.client.feature.search;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ListAdapter;
import com.ubercab.client.core.ui.MergedSectionDividerAdapter;
import java.util.List;

public class LocationSearchMergedDividerAdapter extends MergedSectionDividerAdapter
{
  private int mSectionSpace;

  public LocationSearchMergedDividerAdapter(Context paramContext, List<ListAdapter> paramList)
  {
    super(paramContext, paramList);
    this.mSectionSpace = ((int)paramContext.getResources().getDimension(2131361957));
  }

  public View getDividerView()
  {
    View localView = new View(this.mContext);
    localView.setMinimumHeight(this.mSectionSpace);
    return localView;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.LocationSearchMergedDividerAdapter
 * JD-Core Version:    0.6.2
 */