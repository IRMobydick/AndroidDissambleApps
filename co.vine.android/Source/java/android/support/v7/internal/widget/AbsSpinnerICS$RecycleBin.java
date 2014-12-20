package android.support.v7.internal.widget;

import android.util.SparseArray;
import android.view.View;

class AbsSpinnerICS$RecycleBin
{
  private final SparseArray<View> mScrapHeap = new SparseArray();

  AbsSpinnerICS$RecycleBin(AbsSpinnerICS paramAbsSpinnerICS)
  {
  }

  void clear()
  {
    SparseArray localSparseArray = this.mScrapHeap;
    int i = localSparseArray.size();
    for (int j = 0; j < i; j++)
    {
      View localView = (View)localSparseArray.valueAt(j);
      if (localView == null)
        continue;
      AbsSpinnerICS.access$100(this.this$0, localView, true);
    }
    localSparseArray.clear();
  }

  View get(int paramInt)
  {
    View localView = (View)this.mScrapHeap.get(paramInt);
    if (localView != null)
      this.mScrapHeap.delete(paramInt);
    return localView;
  }

  public void put(int paramInt, View paramView)
  {
    this.mScrapHeap.put(paramInt, paramView);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AbsSpinnerICS.RecycleBin
 * JD-Core Version:    0.6.0
 */