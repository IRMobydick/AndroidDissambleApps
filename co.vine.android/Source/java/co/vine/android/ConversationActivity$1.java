package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import com.edisonwang.android.slog.SLog;

class ConversationActivity$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()));
      for (boolean bool = true; ; bool = false)
      {
        if ((bool) && (ConversationActivity.access$300(this.this$0) != bool))
        {
          SLog.dWithTag("ConvActivity;RTC", "Connectivity change received, reconnecting");
          ConversationActivity.access$500(this.this$0).removeCallbacks(ConversationActivity.access$400(this.this$0));
          ConversationActivity.access$600(this.this$0);
        }
        ConversationActivity.access$302(this.this$0, bool);
        return;
      }
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
        SLog.e("We are not gangsta enough to acess the connectivity state.", localSecurityException);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationActivity.1
 * JD-Core Version:    0.6.0
 */