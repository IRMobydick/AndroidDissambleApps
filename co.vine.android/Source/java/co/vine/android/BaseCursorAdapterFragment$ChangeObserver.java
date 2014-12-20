package co.vine.android;

import android.database.ContentObserver;
import android.os.Handler;

public class BaseCursorAdapterFragment$ChangeObserver extends ContentObserver
{
  public BaseCursorAdapterFragment$ChangeObserver(BaseCursorAdapterFragment paramBaseCursorAdapterFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  public boolean deliverSelfNotifications()
  {
    return true;
  }

  public void onChange(boolean paramBoolean)
  {
    if (!this.this$0.mRefreshing)
      this.this$0.handleContentChanged();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.BaseCursorAdapterFragment.ChangeObserver
 * JD-Core Version:    0.6.0
 */