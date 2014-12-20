package co.vine.android;

import android.os.Handler;
import com.edisonwang.android.slog.SLog;

class ConversationActivity$3
  implements Runnable
{
  public void run()
  {
    if (ConversationActivity.access$200(this.this$0) == null)
      ConversationActivity.access$700(this.this$0);
    VineWebSocketClient localVineWebSocketClient = ConversationActivity.access$200(this.this$0);
    ConversationActivity localConversationActivity;
    long l;
    if ((localVineWebSocketClient != null) && (!localVineWebSocketClient.isConnecting()) && (!localVineWebSocketClient.isConnected()))
    {
      localVineWebSocketClient.connect();
      localConversationActivity = this.this$0;
      if (ConversationActivity.access$800(this.this$0) >= 16000L)
        break label145;
      l = 2L * ConversationActivity.access$800(this.this$0);
    }
    while (true)
    {
      ConversationActivity.access$802(localConversationActivity, l);
      ConversationActivity.access$500(this.this$0).postDelayed(ConversationActivity.access$400(this.this$0), ConversationActivity.access$800(this.this$0));
      SLog.dWithTag("ConvActivity;RTC", "Posted reconnect with delay=" + ConversationActivity.access$800(this.this$0) + "ms");
      return;
      label145: l = ConversationActivity.access$800(this.this$0);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationActivity.3
 * JD-Core Version:    0.6.0
 */