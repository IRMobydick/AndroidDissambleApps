package co.vine.android;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

class ConversationActivity$ConversationSessionListener$1
  implements Runnable
{
  public void run()
  {
    Fragment localFragment = this.this$1.this$0.getSupportFragmentManager().findFragmentByTag("conversationFragment");
    if ((localFragment instanceof ConversationFragment))
      ((ConversationFragment)localFragment).showTypingIndicator(this.val$show, this.val$userId);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationActivity.ConversationSessionListener.1
 * JD-Core Version:    0.6.0
 */