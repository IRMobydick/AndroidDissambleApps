package co.vine.android;

import android.util.SparseArray;
import android.view.View;
import android.widget.ListView;
import co.vine.android.api.VinePrivateMessage;
import co.vine.android.player.SdkVideoView;
import com.edisonwang.android.slog.SLog;

class ConversationAdapter$2
  implements Runnable
{
  public void run()
  {
    monitorenter;
    while (true)
    {
      int i;
      try
      {
        i = ConversationAdapter.access$100(this.this$0).getFirstVisiblePosition();
        VinePrivateMessage localVinePrivateMessage1 = (VinePrivateMessage)ConversationAdapter.access$200(this.this$0).get(i);
        if ((localVinePrivateMessage1 == null) || (!localVinePrivateMessage1.hasVideo))
          continue;
        int j = 1;
        View localView = ConversationAdapter.access$300(this.this$0, i);
        float f = -1.0F;
        if (localView == null)
          continue;
        int n = 0;
        if (this.this$0.getLastPlayer() == null)
          continue;
        n = this.this$0.getLastPlayer().getHeight() / 2;
        f = (localView.getBottom() + n) / (localView.getHeight() + n);
        SLog.d("Current First: {}, ratio: {}", Integer.valueOf(i), Float.valueOf(f));
        int k = -1;
        if ((f < 0.5D) || (i == -1))
          break label291;
        if (j != 0)
          continue;
        break label291;
        if (m >= this.this$0.getCount())
          continue;
        VinePrivateMessage localVinePrivateMessage2 = (VinePrivateMessage)ConversationAdapter.access$200(this.this$0).get(m);
        if (localVinePrivateMessage2 == null)
          continue;
        if (!localVinePrivateMessage2.hasVideo)
          continue;
        k = m;
        SLog.d("Current Next: {}", Integer.valueOf(k));
        if ((k == -1) || (k == ConversationAdapter.access$400(this.this$0)))
          continue;
        this.this$0.play(k);
        return;
        j = 0;
        continue;
        m++;
        continue;
        if (i != ConversationAdapter.access$400(this.this$0))
        {
          this.this$0.play(i);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      this.this$0.playFile(i, false);
      continue;
      label291: int m = i + 1;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationAdapter.2
 * JD-Core Version:    0.6.0
 */