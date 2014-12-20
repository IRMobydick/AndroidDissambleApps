package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class BaseActionBarActivity$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("co.vine.android.FINISH".equals(paramIntent.getAction())))
      this.this$0.finish();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.BaseActionBarActivity.1
 * JD-Core Version:    0.6.0
 */