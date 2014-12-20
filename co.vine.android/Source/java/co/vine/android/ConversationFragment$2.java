package co.vine.android;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import com.edisonwang.android.slog.SLog;

class ConversationFragment$2
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    SLog.dWithTag("ConversationFrag", "Bound to VineUploadService");
    ConversationFragment.access$102(this.this$0, new Messenger(paramIBinder));
    ConversationFragment.access$202(this.this$0, true);
    ConversationFragment.access$400(this.this$0, ConversationFragment.access$300(this.this$0));
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    SLog.dWithTag("ConversationFrag", "Connection to VineUploadService lost unexpectedly!");
    ConversationFragment.access$102(this.this$0, null);
    ConversationFragment.access$202(this.this$0, false);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationFragment.2
 * JD-Core Version:    0.6.0
 */