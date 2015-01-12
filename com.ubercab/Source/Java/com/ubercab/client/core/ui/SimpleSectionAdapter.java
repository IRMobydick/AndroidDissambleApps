package com.ubercab.client.core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ubercab.common.collect.ImmutableList;
import java.util.List;

public class SimpleSectionAdapter extends SectionAdapter<SimpleListItem>
{
  private List<SimpleListItem> mItems;
  private LayoutInflater mLayoutInflater;

  public SimpleSectionAdapter(Context paramContext)
  {
    super(paramContext);
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    setItemPaddingHorizontal(paramContext.getResources().getDimensionPixelSize(2131361892));
    this.mItems = ImmutableList.of();
  }

  public int getCount()
  {
    return this.mItems.size();
  }

  public SimpleListItem getItem(int paramInt)
  {
    return (SimpleListItem)this.mItems.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getItemView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = this.mLayoutInflater.inflate(17367043, paramViewGroup, false);
    SimpleListItem localSimpleListItem = getItem(paramInt);
    ((TextView)paramView.findViewById(16908308)).setText(localSimpleListItem.getTitle());
    return paramView;
  }

  public View getSectionFooterView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }

  public int getSectionForPosition(int paramInt)
  {
    return 0;
  }

  public View getSectionHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }

  public void update(List<SimpleListItem> paramList)
  {
    this.mItems = paramList;
    notifyDataSetChanged();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.SimpleSectionAdapter
 * JD-Core Version:    0.6.2
 */