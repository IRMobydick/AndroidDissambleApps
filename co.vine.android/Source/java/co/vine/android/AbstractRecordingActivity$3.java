package co.vine.android;

import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;

class AbstractRecordingActivity$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.this$0.mCurrentPage != AbstractRecordingActivity.access$000(this.this$0).size())
    {
      AbstractRecordingActivity.access$102(this.this$0, false);
      this.this$0.showDeleteDialog();
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.AbstractRecordingActivity.3
 * JD-Core Version:    0.6.0
 */