package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import co.vine.android.util.CrashUtil;
import co.vine.android.util.MuteUtil;
import co.vine.android.widget.GenericTimelineAdapter;

class BaseTimelineFragment$2 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null))
      CrashUtil.log("Something wrong has happened");
    while (true)
    {
      return;
      boolean bool = paramIntent.getAction().equals(MuteUtil.ACTION_CHANGED_TO_MUTE);
      this.this$0.mFeedAdapter.toggleMute(bool);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.BaseTimelineFragment.2
 * JD-Core Version:    0.6.0
 */