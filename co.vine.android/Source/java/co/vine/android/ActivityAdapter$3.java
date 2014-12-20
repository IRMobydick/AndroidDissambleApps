package co.vine.android;

import android.view.View;
import android.view.View.OnClickListener;
import co.vine.android.api.VineEverydayNotification;

class ActivityAdapter$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    VineEverydayNotification localVineEverydayNotification = (VineEverydayNotification)paramView.getTag();
    UsersActivity.launchUserListForNotification(ActivityAdapter.access$000(this.this$0), localVineEverydayNotification.notificationId, localVineEverydayNotification.anchor);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ActivityAdapter.3
 * JD-Core Version:    0.6.0
 */