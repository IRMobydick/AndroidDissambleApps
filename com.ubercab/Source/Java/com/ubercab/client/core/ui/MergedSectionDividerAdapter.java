package com.ubercab.client.core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import java.util.List;

public abstract class MergedSectionDividerAdapter extends MergedSectionAdapter
{
  public MergedSectionDividerAdapter(Context paramContext, List<ListAdapter> paramList)
  {
    super(paramContext, paramList, null);
  }

  public abstract View getDividerView();

  public View getSectionHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt == 0) || (isSectionEmpty(paramInt)) || (isSectionEmpty(paramInt - 1)))
      return null;
    return getDividerView();
  }

  public boolean isEnabled(int paramInt)
  {
    return (isFooter(paramInt)) || (super.isEnabled(paramInt));
  }

  public boolean isFooter(int paramInt)
  {
    return paramInt == getCount();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.MergedSectionDividerAdapter
 * JD-Core Version:    0.6.2
 */