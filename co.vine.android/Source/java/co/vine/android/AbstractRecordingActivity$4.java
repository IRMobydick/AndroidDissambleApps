package co.vine.android;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AbstractRecordingActivity$4
  implements View.OnTouchListener
{
  boolean hasMovedOut = false;

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 1:
      while (true)
      {
        return false;
        if (this.this$0.mCurrentPage == AbstractRecordingActivity.access$000(this.this$0).size())
          continue;
        AbstractRecordingActivity.access$200(this.this$0).setActivated(bool1);
        this.hasMovedOut = false;
        continue;
        AbstractRecordingActivity.access$200(this.this$0).setActivated(false);
      }
    case 2:
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    boolean bool2;
    label150: boolean bool3;
    label184: View localView2;
    if ((f1 >= 0.0F) && (f1 <= AbstractRecordingActivity.access$300(this.this$0).getWidth()) && (f2 >= 0.0F) && (f2 <= AbstractRecordingActivity.access$300(this.this$0).getHeight()))
    {
      bool2 = bool1;
      if (!bool2)
        this.hasMovedOut = bool1;
      View localView1 = AbstractRecordingActivity.access$200(this.this$0);
      if ((!bool2) || (this.hasMovedOut))
        break label227;
      bool3 = bool1;
      localView1.setActivated(bool3);
      localView2 = AbstractRecordingActivity.access$300(this.this$0);
      if ((!bool2) || (this.hasMovedOut))
        break label233;
    }
    while (true)
    {
      localView2.setActivated(bool1);
      break;
      bool2 = false;
      break label150;
      label227: bool3 = false;
      break label184;
      label233: bool1 = false;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.AbstractRecordingActivity.4
 * JD-Core Version:    0.6.0
 */