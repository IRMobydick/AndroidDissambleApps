package android.support.v7.internal.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

class SpinnerICS$DropDownAdapter
  implements ListAdapter, SpinnerAdapter
{
  private SpinnerAdapter mAdapter;
  private ListAdapter mListAdapter;

  public SpinnerICS$DropDownAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    this.mAdapter = paramSpinnerAdapter;
    if ((paramSpinnerAdapter instanceof SpinnerAdapter))
      this.mListAdapter = ((SpinnerAdapter)paramSpinnerAdapter);
  }

  public boolean areAllItemsEnabled()
  {
    ListAdapter localListAdapter = this.mListAdapter;
    if (localListAdapter != null);
    for (boolean bool = localListAdapter.areAllItemsEnabled(); ; bool = true)
      return bool;
  }

  public int getCount()
  {
    if (this.mAdapter == null);
    for (int i = 0; ; i = this.mAdapter.getCount())
      return i;
  }

  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.mAdapter == null);
    for (View localView = null; ; localView = this.mAdapter.getDropDownView(paramInt, paramView, paramViewGroup))
      return localView;
  }

  public Object getItem(int paramInt)
  {
    if (this.mAdapter == null);
    for (Object localObject = null; ; localObject = this.mAdapter.getItem(paramInt))
      return localObject;
  }

  public long getItemId(int paramInt)
  {
    long l;
    if (this.mAdapter == null)
      l = -1L;
    while (true)
    {
      return l;
      l = this.mAdapter.getItemId(paramInt);
    }
  }

  public int getItemViewType(int paramInt)
  {
    return 0;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return getDropDownView(paramInt, paramView, paramViewGroup);
  }

  public int getViewTypeCount()
  {
    return 1;
  }

  public boolean hasStableIds()
  {
    if ((this.mAdapter != null) && (this.mAdapter.hasStableIds()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean isEmpty()
  {
    if (getCount() == 0);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean isEnabled(int paramInt)
  {
    ListAdapter localListAdapter = this.mListAdapter;
    if (localListAdapter != null);
    for (boolean bool = localListAdapter.isEnabled(paramInt); ; bool = true)
      return bool;
  }

  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (this.mAdapter != null)
      this.mAdapter.registerDataSetObserver(paramDataSetObserver);
  }

  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (this.mAdapter != null)
      this.mAdapter.unregisterDataSetObserver(paramDataSetObserver);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.SpinnerICS.DropDownAdapter
 * JD-Core Version:    0.6.0
 */