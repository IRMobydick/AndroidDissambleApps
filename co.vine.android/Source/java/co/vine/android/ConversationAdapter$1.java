package co.vine.android;

import android.view.View;
import android.view.View.OnLongClickListener;
import co.vine.android.api.VinePrivateMessage;

class ConversationAdapter$1
  implements View.OnLongClickListener
{
  public boolean onLongClick(View paramView)
  {
    ConversationAdapter.access$000(this.this$0).showDeleteMessageDialog(this.val$vpm.messageId);
    return true;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationAdapter.1
 * JD-Core Version:    0.6.0
 */