package co.vine.android;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import co.vine.android.client.Session;

class DebugHomeActivity$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Log.d("VINEDEBUG", "vine-session-id: " + this.val$session.getSessionKey());
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.DebugHomeActivity.1
 * JD-Core Version:    0.6.0
 */