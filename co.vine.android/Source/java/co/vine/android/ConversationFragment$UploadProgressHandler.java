package co.vine.android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import co.vine.android.recorder.ProgressView;
import com.edisonwang.android.slog.SLog;

class ConversationFragment$UploadProgressHandler extends Handler
{
  private ConversationFragment$UploadProgressHandler(ConversationFragment paramConversationFragment)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Bundle localBundle;
    if (paramMessage.obj == null)
    {
      localBundle = new Bundle();
      SLog.dWithTag("ConversationFrag", "Message received, what=" + i);
      switch (i)
      {
      default:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    }
    while (true)
    {
      return;
      localBundle = (Bundle)paramMessage.obj;
      break;
      boolean bool2 = localBundle.getBoolean("is_active");
      long l = localBundle.getLong("conversation_row_id");
      String str = localBundle.getString("thumbnail");
      SLog.dWithTag("ConversationFrag", "Result receiver was set in VineUploadService, conversationId=" + l);
      if ((!bool2) || (ConversationFragment.access$700(this.this$0) != l))
        continue;
      ConversationFragment.access$800(this.this$0).setVisibility(0);
      ConversationFragment.access$902(this.this$0, (ProgressView)ConversationFragment.access$800(this.this$0).findViewById(2131361990));
      if (!TextUtils.isEmpty(str))
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(str);
        ConversationFragment.access$1000(this.this$0).setImageBitmap(localBitmap);
        continue;
      }
      ConversationFragment.access$1000(this.this$0).setVisibility(8);
      continue;
      SLog.dWithTag("ConversationFrag", "Video transcoding started");
      continue;
      double d2 = localBundle.getDouble("transcode_progress");
      SLog.dWithTag("ConversationFrag", "Transcode progress changed to p=" + d2);
      if (ConversationFragment.access$1100(this.this$0) == 0)
        ConversationFragment.access$1102(this.this$0, ConversationFragment.access$900(this.this$0).getMeasuredWidth());
      ConversationFragment.access$900(this.this$0).setProgressRatio((float)(0.65D * d2 / 100.0D));
      continue;
      double d1 = localBundle.getDouble("upload_progress");
      SLog.dWithTag("ConversationFrag", "Upload progress changed to p=" + d1);
      if (ConversationFragment.access$1100(this.this$0) == 0)
        ConversationFragment.access$1102(this.this$0, ConversationFragment.access$900(this.this$0).getMeasuredWidth());
      ConversationFragment.access$900(this.this$0).setProgressRatio((float)(0.65D + 0.33D * d1 / 100.0D));
      continue;
      boolean bool1 = localBundle.getBoolean("success");
      SLog.dWithTag("ConversationFrag", "Post completed, success=" + bool1);
      ConversationFragment.access$800(this.this$0).setVisibility(8);
      sendMessage(Message.obtain(null, 2));
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationFragment.UploadProgressHandler
 * JD-Core Version:    0.6.0
 */