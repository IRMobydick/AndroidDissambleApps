package android.support.v7.internal.view.menu;

import android.view.View;

class ActionMenuPresenter$OpenOverflowRunnable
  implements Runnable
{
  private ActionMenuPresenter.OverflowPopup mPopup;

  public ActionMenuPresenter$OpenOverflowRunnable(ActionMenuPresenter paramActionMenuPresenter, ActionMenuPresenter.OverflowPopup paramOverflowPopup)
  {
    this.mPopup = paramOverflowPopup;
  }

  public void run()
  {
    this.this$0.mMenu.changeMenuMode();
    View localView = (View)this.this$0.mMenuView;
    if ((localView != null) && (localView.getWindowToken() != null) && (this.mPopup.tryShow()))
      ActionMenuPresenter.access$102(this.this$0, this.mPopup);
    ActionMenuPresenter.access$302(this.this$0, null);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuPresenter.OpenOverflowRunnable
 * JD-Core Version:    0.6.0
 */