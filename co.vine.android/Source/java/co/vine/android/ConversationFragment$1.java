package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.MuteUtil;

class ConversationFragment$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null))
      CrashUtil.log("Something wrong has happened");
    while (true)
    {
      return;
      boolean bool = paramIntent.getAction().equals(MuteUtil.ACTION_CHANGED_TO_MUTE);
      ((ConversationAdapter)this.this$0.mCursorAdapter).toggleMute(bool);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationFragment.1
 * JD-Core Version:    0.6.0
 */