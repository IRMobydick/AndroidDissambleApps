package android.support.v7.internal.widget;

import android.support.v7.internal.view.menu.MenuItemImpl;
import android.view.View;
import android.view.View.OnClickListener;

class ActionBarView$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    MenuItemImpl localMenuItemImpl = ActionBarView.access$100(this.this$0).mCurrentExpandedItem;
    if (localMenuItemImpl != null)
      localMenuItemImpl.collapseActionView();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarView.2
 * JD-Core Version:    0.6.0
 */