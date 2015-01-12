package com.ubercab.client.core.ui;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class RiderGridView extends GridView
{
  private ArrayList<FixedViewInfo> mFooterViewInfos = new ArrayList();
  private ArrayList<FixedViewInfo> mHeaderViewInfos = new ArrayList();

  public RiderGridView(Context paramContext)
  {
    super(paramContext);
    initHeaderGridView();
  }

  public RiderGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initHeaderGridView();
  }

  public RiderGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initHeaderGridView();
  }

  private void initHeaderGridView()
  {
    super.setClipChildren(false);
  }

  private void removeFixedViewInfo(View paramView, ArrayList<FixedViewInfo> paramArrayList)
  {
    int i = paramArrayList.size();
    for (int j = 0; ; j++)
      if (j < i)
      {
        if (((FixedViewInfo)paramArrayList.get(j)).view == paramView)
          paramArrayList.remove(j);
      }
      else
        return;
  }

  public void addFooterView(View paramView)
  {
    addFooterView(paramView, null, true);
  }

  public void addFooterView(View paramView, Object paramObject, boolean paramBoolean)
  {
    ListAdapter localListAdapter = getAdapter();
    if ((localListAdapter != null) && (!(localListAdapter instanceof HeaderViewGridAdapter)))
      throw new IllegalStateException("Cannot add footer view to grid -- setAdapter has already been called.");
    FixedViewInfo localFixedViewInfo = new FixedViewInfo(null);
    FullWidthFixedViewLayout localFullWidthFixedViewLayout = new FullWidthFixedViewLayout(getContext());
    localFullWidthFixedViewLayout.addView(paramView);
    localFixedViewInfo.view = paramView;
    localFixedViewInfo.viewContainer = localFullWidthFixedViewLayout;
    localFixedViewInfo.data = paramObject;
    localFixedViewInfo.isSelectable = paramBoolean;
    this.mFooterViewInfos.add(localFixedViewInfo);
    if (localListAdapter != null)
      ((HeaderViewGridAdapter)localListAdapter).notifyDataSetChanged();
  }

  public void addHeaderView(View paramView)
  {
    addHeaderView(paramView, null, true);
  }

  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    ListAdapter localListAdapter = getAdapter();
    if ((localListAdapter != null) && (!(localListAdapter instanceof HeaderViewGridAdapter)))
      throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
    FixedViewInfo localFixedViewInfo = new FixedViewInfo(null);
    FullWidthFixedViewLayout localFullWidthFixedViewLayout = new FullWidthFixedViewLayout(getContext());
    localFullWidthFixedViewLayout.addView(paramView);
    localFixedViewInfo.view = paramView;
    localFixedViewInfo.viewContainer = localFullWidthFixedViewLayout;
    localFixedViewInfo.data = paramObject;
    localFixedViewInfo.isSelectable = paramBoolean;
    this.mHeaderViewInfos.add(localFixedViewInfo);
    if (localListAdapter != null)
      ((HeaderViewGridAdapter)localListAdapter).notifyDataSetChanged();
  }

  public int getFooterViewCount()
  {
    return this.mFooterViewInfos.size();
  }

  public int getHeaderViewCount()
  {
    return this.mHeaderViewInfos.size();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    ListAdapter localListAdapter = getAdapter();
    if ((localListAdapter != null) && ((localListAdapter instanceof HeaderViewGridAdapter)))
      ((HeaderViewGridAdapter)localListAdapter).setNumColumns(getNumColumns());
  }

  public boolean removeFooterView(View paramView)
  {
    if (this.mFooterViewInfos.size() > 0)
    {
      ListAdapter localListAdapter = getAdapter();
      boolean bool1 = false;
      if (localListAdapter != null)
      {
        boolean bool2 = ((HeaderViewGridAdapter)localListAdapter).removeFooter(paramView);
        bool1 = false;
        if (bool2)
          bool1 = true;
      }
      removeFixedViewInfo(paramView, this.mFooterViewInfos);
      return bool1;
    }
    return false;
  }

  public boolean removeHeaderView(View paramView)
  {
    if (this.mHeaderViewInfos.size() > 0)
    {
      ListAdapter localListAdapter = getAdapter();
      boolean bool1 = false;
      if (localListAdapter != null)
      {
        boolean bool2 = ((HeaderViewGridAdapter)localListAdapter).removeHeader(paramView);
        bool1 = false;
        if (bool2)
          bool1 = true;
      }
      removeFixedViewInfo(paramView, this.mHeaderViewInfos);
      return bool1;
    }
    return false;
  }

  public void setAdapter(ListAdapter paramListAdapter)
  {
    if ((this.mHeaderViewInfos.size() > 0) || (this.mFooterViewInfos.size() > 0))
    {
      HeaderViewGridAdapter localHeaderViewGridAdapter = new HeaderViewGridAdapter(this.mHeaderViewInfos, this.mFooterViewInfos, paramListAdapter);
      int i = getNumColumns();
      if (i > 1)
        localHeaderViewGridAdapter.setNumColumns(i);
      super.setAdapter(localHeaderViewGridAdapter);
      return;
    }
    super.setAdapter(paramListAdapter);
  }

  public void setClipChildren(boolean paramBoolean)
  {
  }

  private static class FixedViewInfo
  {
    public Object data;
    public boolean isSelectable;
    public View view;
    public ViewGroup viewContainer;
  }

  private class FullWidthFixedViewLayout extends FrameLayout
  {
    public FullWidthFixedViewLayout(Context arg2)
    {
      super();
    }

    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(RiderGridView.this.getMeasuredWidth() - RiderGridView.this.getPaddingLeft() - RiderGridView.this.getPaddingRight(), View.MeasureSpec.getMode(paramInt1)), paramInt2);
    }
  }

  private static class HeaderViewGridAdapter
    implements WrapperListAdapter, Filterable
  {
    private final ListAdapter mAdapter;
    boolean mAreAllFixedViewsSelectable;
    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    ArrayList<RiderGridView.FixedViewInfo> mFooterViewInfos;
    ArrayList<RiderGridView.FixedViewInfo> mHeaderViewInfos;
    private final boolean mIsFilterable;
    private int mNumColumns = 1;

    public HeaderViewGridAdapter(ArrayList<RiderGridView.FixedViewInfo> paramArrayList1, ArrayList<RiderGridView.FixedViewInfo> paramArrayList2, ListAdapter paramListAdapter)
    {
      this.mAdapter = paramListAdapter;
      this.mIsFilterable = (paramListAdapter instanceof Filterable);
      if (paramArrayList1 == null)
        throw new IllegalArgumentException("headerViewInfos cannot be null");
      this.mHeaderViewInfos = paramArrayList1;
      if (paramArrayList2 == null)
        throw new IllegalArgumentException("footerViewInfos cannot be null");
      this.mFooterViewInfos = paramArrayList2;
      updateAreAllListInfosSelectable();
    }

    private boolean areAllListInfosSelectable(ArrayList<RiderGridView.FixedViewInfo> paramArrayList)
    {
      if (paramArrayList != null)
      {
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
          if (!((RiderGridView.FixedViewInfo)localIterator.next()).isSelectable)
            return false;
      }
      return true;
    }

    private int getFooterOffset()
    {
      if (getFootersCount() == 0);
      int i;
      do
      {
        return 0;
        i = this.mAdapter.getCount() % this.mNumColumns;
      }
      while (i == 0);
      return this.mNumColumns - i;
    }

    private int measureItemHeight(int paramInt)
    {
      View localView = this.mAdapter.getView(paramInt, null, null);
      localView.measure(0, 0);
      return View.MeasureSpec.getSize(localView.getMeasuredHeight());
    }

    private void updateAreAllListInfosSelectable()
    {
      if ((areAllListInfosSelectable(this.mHeaderViewInfos)) && (areAllListInfosSelectable(this.mFooterViewInfos)));
      for (boolean bool = true; ; bool = false)
      {
        this.mAreAllFixedViewsSelectable = bool;
        return;
      }
    }

    public boolean areAllItemsEnabled()
    {
      return (this.mAdapter == null) || ((this.mAreAllFixedViewsSelectable) && (this.mAdapter.areAllItemsEnabled()));
    }

    public int getCount()
    {
      int i = getHeadersCount() * this.mNumColumns + getFootersCount() * this.mNumColumns;
      if (this.mAdapter != null)
        i += this.mAdapter.getCount() + getFooterOffset();
      return i;
    }

    public Filter getFilter()
    {
      if (this.mIsFilterable)
        return ((Filterable)this.mAdapter).getFilter();
      return null;
    }

    public int getFootersCount()
    {
      return this.mFooterViewInfos.size();
    }

    public int getHeadersCount()
    {
      return this.mHeaderViewInfos.size();
    }

    public Object getItem(int paramInt)
    {
      int i = getHeadersCount() * this.mNumColumns;
      if (paramInt < i)
      {
        if (paramInt % this.mNumColumns == 0)
          return ((RiderGridView.FixedViewInfo)this.mHeaderViewInfos.get(paramInt / this.mNumColumns)).data;
        return null;
      }
      int j = paramInt - i;
      ListAdapter localListAdapter = this.mAdapter;
      int k = 0;
      if (localListAdapter != null)
      {
        k = this.mAdapter.getCount();
        if (j < k)
          return this.mAdapter.getItem(j);
      }
      int m = j - k - getFooterOffset();
      if (this.mFooterViewInfos.size() > m)
        return ((RiderGridView.FixedViewInfo)this.mFooterViewInfos.get(m)).data;
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }

    public long getItemId(int paramInt)
    {
      int i = getHeadersCount() * this.mNumColumns;
      if ((this.mAdapter != null) && (paramInt >= i))
      {
        int j = paramInt - i;
        if (j < this.mAdapter.getCount())
          return this.mAdapter.getItemId(j);
      }
      return -1L;
    }

    public int getItemViewType(int paramInt)
    {
      int i = getHeadersCount() * this.mNumColumns;
      if ((paramInt < i) && (paramInt % this.mNumColumns != 0))
      {
        if (this.mAdapter != null)
          return this.mAdapter.getViewTypeCount();
        return 1;
      }
      if ((this.mAdapter != null) && (paramInt >= i))
      {
        int j = paramInt - i;
        if (j < this.mAdapter.getCount())
          return this.mAdapter.getItemViewType(j);
      }
      return -2;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = getHeadersCount() * this.mNumColumns;
      if (paramInt < i)
      {
        ViewGroup localViewGroup2 = ((RiderGridView.FixedViewInfo)this.mHeaderViewInfos.get(paramInt / this.mNumColumns)).viewContainer;
        if (paramInt % this.mNumColumns == 0)
          return localViewGroup2;
        if (paramView == null)
          paramView = new View(paramViewGroup.getContext());
        paramView.setVisibility(4);
        paramView.setMinimumHeight(localViewGroup2.getHeight());
        return paramView;
      }
      int j = paramInt - i;
      ListAdapter localListAdapter = this.mAdapter;
      int k = 0;
      if (localListAdapter != null)
      {
        k = this.mAdapter.getCount();
        if (j < k)
          return this.mAdapter.getView(j, paramView, paramViewGroup);
      }
      int m = j - k - getFooterOffset();
      if (m < 0)
      {
        View localView = new View(paramViewGroup.getContext());
        localView.setVisibility(4);
        localView.setMinimumHeight(measureItemHeight(j + m));
        return localView;
      }
      if (this.mFooterViewInfos.size() > m / this.mNumColumns)
      {
        ViewGroup localViewGroup1 = ((RiderGridView.FixedViewInfo)this.mFooterViewInfos.get(m / this.mNumColumns)).viewContainer;
        if (m % this.mNumColumns == 0)
          return localViewGroup1;
        if (paramView == null)
          paramView = new View(paramViewGroup.getContext());
        paramView.setVisibility(4);
        paramView.setMinimumHeight(localViewGroup1.getHeight());
        return paramView;
      }
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }

    public int getViewTypeCount()
    {
      if (this.mAdapter != null)
        return 1 + this.mAdapter.getViewTypeCount();
      return 2;
    }

    public ListAdapter getWrappedAdapter()
    {
      return this.mAdapter;
    }

    public boolean hasStableIds()
    {
      return (this.mAdapter != null) && (this.mAdapter.hasStableIds());
    }

    public boolean isEmpty()
    {
      return ((this.mAdapter == null) || (this.mAdapter.isEmpty())) && (getHeadersCount() == 0);
    }

    public boolean isEnabled(int paramInt)
    {
      int i = getHeadersCount() * this.mNumColumns;
      if (paramInt < i)
        return (paramInt % this.mNumColumns == 0) && (((RiderGridView.FixedViewInfo)this.mHeaderViewInfos.get(paramInt / this.mNumColumns)).isSelectable);
      int j = paramInt - i;
      ListAdapter localListAdapter = this.mAdapter;
      int k = 0;
      if (localListAdapter != null)
      {
        k = this.mAdapter.getCount();
        if (j < k)
          return this.mAdapter.isEnabled(j);
      }
      int m = j - k - getFooterOffset();
      if (this.mFooterViewInfos.size() > m)
        return ((RiderGridView.FixedViewInfo)this.mFooterViewInfos.get(m)).isSelectable;
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }

    public void notifyDataSetChanged()
    {
      this.mDataSetObservable.notifyChanged();
    }

    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      this.mDataSetObservable.registerObserver(paramDataSetObserver);
      if (this.mAdapter != null)
        this.mAdapter.registerDataSetObserver(paramDataSetObserver);
    }

    public boolean removeFooter(View paramView)
    {
      for (int i = 0; i < this.mFooterViewInfos.size(); i++)
        if (((RiderGridView.FixedViewInfo)this.mFooterViewInfos.get(i)).view == paramView)
        {
          this.mFooterViewInfos.remove(i);
          updateAreAllListInfosSelectable();
          this.mDataSetObservable.notifyChanged();
          return true;
        }
      return false;
    }

    public boolean removeHeader(View paramView)
    {
      for (int i = 0; i < this.mHeaderViewInfos.size(); i++)
        if (((RiderGridView.FixedViewInfo)this.mHeaderViewInfos.get(i)).view == paramView)
        {
          this.mHeaderViewInfos.remove(i);
          updateAreAllListInfosSelectable();
          this.mDataSetObservable.notifyChanged();
          return true;
        }
      return false;
    }

    public void setNumColumns(int paramInt)
    {
      if (paramInt < 1)
        throw new IllegalArgumentException("Number of columns must be 1 or more");
      if (this.mNumColumns != paramInt)
      {
        this.mNumColumns = paramInt;
        notifyDataSetChanged();
      }
    }

    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      this.mDataSetObservable.unregisterObserver(paramDataSetObserver);
      if (this.mAdapter != null)
        this.mAdapter.unregisterDataSetObserver(paramDataSetObserver);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.RiderGridView
 * JD-Core Version:    0.6.2
 */