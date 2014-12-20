package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ConversationActivity$RealTimeChatReceiver extends BroadcastReceiver
{
  private ConversationActivity$RealTimeChatReceiver(ConversationActivity paramConversationActivity)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("co.vine.android.service.mergeSelfNewMessage".equals(paramIntent.getAction()))
    {
      long l1 = paramIntent.getLongExtra("message_id", 0L);
      long l2 = paramIntent.getLongExtra("conversation_id", 0L);
      if ((l1 > 0L) && (l2 > 0L) && (ConversationActivity.access$200(this.this$0) != null))
        ConversationActivity.access$200(this.this$0).alertNewPrivateMessage(l2, l1);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationActivity.RealTimeChatReceiver
 * JD-Core Version:    0.6.0
 */