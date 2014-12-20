package co.vine.android;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

class BaseArrayListFragment$2
  implements AdapterView.OnItemLongClickListener
{
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return this.this$0.onListItemLongClick((ListView)paramAdapterView, paramView, paramInt, paramLong);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.BaseArrayListFragment.2
 * JD-Core Version:    0.6.0
 */