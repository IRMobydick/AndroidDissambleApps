package co.vine.android;

import android.widget.ListView;

class ConversationFragment$4
  implements Runnable
{
  public void run()
  {
    if (this.val$smooth)
      this.val$listView.smoothScrollToPosition(-1 + this.val$count);
    while (true)
    {
      return;
      this.val$listView.setSelectionFromTop(-1 + this.val$count, 0);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationFragment.4
 * JD-Core Version:    0.6.0
 */