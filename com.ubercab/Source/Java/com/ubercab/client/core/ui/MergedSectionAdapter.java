package com.ubercab.client.core.ui;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;

public class MergedSectionAdapter extends SectionAdapter
{
  private final List<String> mAdapterTitles;
  private final List<ListAdapter> mAdapters;
  protected Context mContext;
  private final LayoutInflater mLayoutInflater;

  public MergedSectionAdapter(Context paramContext, List<ListAdapter> paramList, List<String> paramList1)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    this.mAdapters = paramList;
    this.mAdapterTitles = paramList1;
    ChildAdapterDataSetObserver localChildAdapterDataSetObserver = new ChildAdapterDataSetObserver(null);
    Iterator localIterator = this.mAdapters.iterator();
    while (localIterator.hasNext())
      ((ListAdapter)localIterator.next()).registerDataSetObserver(localChildAdapterDataSetObserver);
    notifyDataSetChanged();
  }

  private LocalAdapterPosition getAdapterOffsetForItem(int paramInt)
  {
    int i = this.mAdapters.size();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      ListAdapter localListAdapter = (ListAdapter)this.mAdapters.get(j);
      int m = k + localListAdapter.getCount();
      if (paramInt < m)
        return new LocalAdapterPosition(localListAdapter, paramInt - k);
      k = m;
      j++;
    }
    return null;
  }

  public boolean areAllItemsEnabled()
  {
    boolean bool = true;
    Iterator localIterator = this.mAdapters.iterator();
    while (localIterator.hasNext())
      bool &= ((ListAdapter)localIterator.next()).areAllItemsEnabled();
    return bool;
  }

  public int getCount()
  {
    int i = 0;
    Iterator localIterator = this.mAdapters.iterator();
    while (localIterator.hasNext())
      i += ((ListAdapter)localIterator.next()).getCount();
    return i;
  }

  public Object getItem(int paramInt)
  {
    LocalAdapterPosition localLocalAdapterPosition = getAdapterOffsetForItem(paramInt);
    if (localLocalAdapterPosition == null)
      return null;
    return localLocalAdapterPosition.mAdapter.getItem(localLocalAdapterPosition.mLocalPosition);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getItemView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LocalAdapterPosition localLocalAdapterPosition = getAdapterOffsetForItem(paramInt);
    return localLocalAdapterPosition.mAdapter.getView(localLocalAdapterPosition.mLocalPosition, paramView, paramViewGroup);
  }

  public int getItemViewType(int paramInt)
  {
    LocalAdapterPosition localLocalAdapterPosition = getAdapterOffsetForItem(paramInt);
    int i = 0;
    Iterator localIterator = this.mAdapters.iterator();
    while (true)
    {
      ListAdapter localListAdapter;
      if (localIterator.hasNext())
      {
        localListAdapter = (ListAdapter)localIterator.next();
        if (localListAdapter != localLocalAdapterPosition.mAdapter);
      }
      else
      {
        int j = localLocalAdapterPosition.mAdapter.getItemViewType(localLocalAdapterPosition.mLocalPosition);
        if (j >= 0)
          j += i;
        return j;
      }
      i += localListAdapter.getViewTypeCount();
    }
  }

  public View getSectionFooterView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }

  public int getSectionForPosition(int paramInt)
  {
    int i = 0;
    for (int j = 0; j < this.mAdapters.size(); j++)
    {
      i += ((ListAdapter)this.mAdapters.get(j)).getCount();
      if (paramInt < i)
        return j;
    }
    return -1;
  }

  public View getSectionHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.mAdapterTitles == null) || (this.mAdapterTitles.isEmpty()))
      return null;
    if (paramView == null)
      paramView = this.mLayoutInflater.inflate(2130903174, paramViewGroup, false);
    ((TextView)paramView.findViewById(16908308)).setText((CharSequence)this.mAdapterTitles.get(paramInt));
    return paramView;
  }

  public int getViewTypeCount()
  {
    int i = 0;
    Iterator localIterator = this.mAdapters.iterator();
    while (localIterator.hasNext())
      i += ((ListAdapter)localIterator.next()).getViewTypeCount();
    return i;
  }

  public boolean isEnabled(int paramInt)
  {
    LocalAdapterPosition localLocalAdapterPosition = getAdapterOffsetForItem(paramInt);
    return localLocalAdapterPosition.mAdapter.isEnabled(localLocalAdapterPosition.mLocalPosition);
  }

  public boolean isSectionEmpty(int paramInt)
  {
    return (this.mAdapters.isEmpty()) || (this.mAdapters.size() <= paramInt) || (((ListAdapter)this.mAdapters.get(paramInt)).isEmpty());
  }

  private class ChildAdapterDataSetObserver extends DataSetObserver
  {
    private ChildAdapterDataSetObserver()
    {
    }

    public void onChanged()
    {
      MergedSectionAdapter.this.notifyDataSetChanged();
    }
  }

  private static class LocalAdapterPosition
  {
    private final ListAdapter mAdapter;
    private final int mLocalPosition;

    LocalAdapterPosition(ListAdapter paramListAdapter, int paramInt)
    {
      this.mAdapter = paramListAdapter;
      this.mLocalPosition = paramInt;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.MergedSectionAdapter
 * JD-Core Version:    0.6.2
 */