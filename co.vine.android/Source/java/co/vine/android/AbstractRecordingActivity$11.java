package co.vine.android;

import android.util.SparseArray;
import co.vine.android.recorder.RecordSessionManager.RecordSessionInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class AbstractRecordingActivity$11
  implements Runnable
{
  public void run()
  {
    if ((AbstractRecordingActivity.access$2500(this.this$0).getCount() != 1) && (this.this$0.mCurrentPage != -1 + AbstractRecordingActivity.access$2500(this.this$0).getCount()))
    {
      AbstractRecordingActivity.access$2602(this.this$0, (RecordSessionManager.RecordSessionInfo)AbstractRecordingActivity.access$2700(this.this$0).get(this.this$0.mCurrentPage));
      WeakReference localWeakReference = (WeakReference)AbstractRecordingActivity.access$000(this.this$0).get(this.this$0.mCurrentPage);
      if (localWeakReference != null)
      {
        DraftFragment localDraftFragment = (DraftFragment)localWeakReference.get();
        if (localDraftFragment != null)
          localDraftFragment.setSelected(true);
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.AbstractRecordingActivity.11
 * JD-Core Version:    0.6.0
 */