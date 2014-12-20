package co.vine.android;

import android.view.View;
import android.view.View.OnClickListener;

class ActivityAdapter$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    long l = ((Long)paramView.getTag()).longValue();
    SingleActivity.start(ActivityAdapter.access$000(this.this$0), l);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ActivityAdapter.1
 * JD-Core Version:    0.6.0
 */