package android.support.v7.internal.widget;

import android.support.v7.app.ActionBar.Tab;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

class ScrollingTabContainerView$TabAdapter extends BaseAdapter
{
  private ScrollingTabContainerView$TabAdapter(ScrollingTabContainerView paramScrollingTabContainerView)
  {
  }

  public int getCount()
  {
    return ScrollingTabContainerView.access$200(this.this$0).getChildCount();
  }

  public Object getItem(int paramInt)
  {
    return ((ScrollingTabContainerView.TabView)ScrollingTabContainerView.access$200(this.this$0).getChildAt(paramInt)).getTab();
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = ScrollingTabContainerView.access$300(this.this$0, (ActionBar.Tab)getItem(paramInt), true);
    while (true)
    {
      return paramView;
      ((ScrollingTabContainerView.TabView)paramView).bindTab((ActionBar.Tab)getItem(paramInt));
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.TabAdapter
 * JD-Core Version:    0.6.0
 */