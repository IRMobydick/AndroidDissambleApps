package co.vine.android;

import android.view.View;
import android.view.View.OnClickListener;

class ActivityAdapter$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    long l = ((Long)paramView.getTag()).longValue();
    ProfileActivity.start(ActivityAdapter.access$000(this.this$0), l, null);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ActivityAdapter.2
 * JD-Core Version:    0.6.0
 */