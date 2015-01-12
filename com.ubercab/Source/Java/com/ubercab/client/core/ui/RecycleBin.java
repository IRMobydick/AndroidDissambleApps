package com.ubercab.client.core.ui;

import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;

class RecycleBin
{
  private int[] activeViewTypes = new int[0];
  private View[] activeViews = new View[0];
  private SparseArray<View> currentScrapViews;
  private SparseArray<View>[] scrapViews;
  private int viewTypeCount;

  private void pruneScrapViews()
  {
    int i = this.activeViews.length;
    int j = this.viewTypeCount;
    SparseArray[] arrayOfSparseArray = this.scrapViews;
    for (int k = 0; k < j; k++)
    {
      SparseArray localSparseArray = arrayOfSparseArray[k];
      int m = localSparseArray.size();
      int n = m - i;
      int i1 = m - 1;
      int i2 = 0;
      int i4;
      for (int i3 = i1; i2 < n; i3 = i4)
      {
        i4 = i3 - 1;
        localSparseArray.remove(localSparseArray.keyAt(i3));
        i2++;
      }
    }
  }

  static View retrieveFromScrap(SparseArray<View> paramSparseArray, int paramInt)
  {
    int i = paramSparseArray.size();
    if (i > 0)
    {
      for (int j = 0; j < i; j++)
      {
        int m = paramSparseArray.keyAt(j);
        View localView2 = (View)paramSparseArray.get(m);
        if (m == paramInt)
        {
          paramSparseArray.remove(m);
          return localView2;
        }
      }
      int k = i - 1;
      View localView1 = (View)paramSparseArray.valueAt(k);
      paramSparseArray.remove(paramSparseArray.keyAt(k));
      return localView1;
    }
    return null;
  }

  void addScrapView(View paramView, int paramInt1, int paramInt2)
  {
    if (this.viewTypeCount == 1)
      this.currentScrapViews.put(paramInt1, paramView);
    while (true)
    {
      if (Build.VERSION.SDK_INT >= 14)
        paramView.setAccessibilityDelegate(null);
      return;
      this.scrapViews[paramInt2].put(paramInt1, paramView);
    }
  }

  View getScrapView(int paramInt1, int paramInt2)
  {
    if (this.viewTypeCount == 1)
      return retrieveFromScrap(this.currentScrapViews, paramInt1);
    if ((paramInt2 >= 0) && (paramInt2 < this.scrapViews.length))
      return retrieveFromScrap(this.scrapViews[paramInt2], paramInt1);
    return null;
  }

  void scrapActiveViews()
  {
    int i = 1;
    View[] arrayOfView = this.activeViews;
    int[] arrayOfInt = this.activeViewTypes;
    SparseArray localSparseArray;
    int j;
    label32: View localView;
    int k;
    if (this.viewTypeCount > i)
    {
      localSparseArray = this.currentScrapViews;
      j = -1 + arrayOfView.length;
      if (j < 0)
        break label123;
      localView = arrayOfView[j];
      if (localView != null)
      {
        k = arrayOfInt[j];
        arrayOfView[j] = null;
        arrayOfInt[j] = -1;
        if (shouldRecycleViewType(k))
          break label84;
      }
    }
    while (true)
    {
      j--;
      break label32;
      i = 0;
      break;
      label84: if (i != 0)
        localSparseArray = this.scrapViews[k];
      localSparseArray.put(j, localView);
      if (Build.VERSION.SDK_INT >= 14)
        localView.setAccessibilityDelegate(null);
    }
    label123: pruneScrapViews();
  }

  void setViewTypeCount(int paramInt)
  {
    if (paramInt < 1)
      throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
    SparseArray[] arrayOfSparseArray = new SparseArray[paramInt];
    for (int i = 0; i < paramInt; i++)
      arrayOfSparseArray[i] = new SparseArray();
    this.viewTypeCount = paramInt;
    this.currentScrapViews = arrayOfSparseArray[0];
    this.scrapViews = arrayOfSparseArray;
  }

  boolean shouldRecycleViewType(int paramInt)
  {
    return paramInt >= 0;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.RecycleBin
 * JD-Core Version:    0.6.2
 */