package co.vine.android;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import co.vine.android.animation.MoveResizeAnimator;
import co.vine.android.util.CrashUtil;

class AbstractRecordingActivity$DraftPagerImpl$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131362006) || (AbstractRecordingActivity.access$1700(this.this$1.this$0)) || (AbstractRecordingActivity.access$1300(this.this$1.this$0)));
    while (true)
    {
      return;
      CrashUtil.log("User clicked on fragment to resume.");
      AbstractRecordingActivity.access$3002(this.this$1.this$0, true);
      AbstractRecordingActivity.access$3100(this.this$1.this$0, this.val$fragment);
      AbstractRecordingActivity.access$3200(this.this$1.this$0);
      float f = AbstractRecordingActivity.access$3300(this.this$1.this$0).x / AbstractRecordingActivity.access$3400(this.this$1.this$0).getLayoutParams().width;
      new MoveResizeAnimator(2, AbstractRecordingActivity.access$3500(this.this$1.this$0), 0, f, 2.0D, 300, null, paramView.getTag()).start();
      new MoveResizeAnimator(1, AbstractRecordingActivity.access$3400(this.this$1.this$0), 2 * AbstractRecordingActivity.access$3500(this.this$1.this$0).getLayoutParams().height, f, f, 300, this.this$1.this$0, paramView.getTag()).start();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.AbstractRecordingActivity.DraftPagerImpl.1
 * JD-Core Version:    0.6.0
 */