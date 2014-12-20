package co.vine.android;

import co.vine.android.client.AppController;
import co.vine.android.recorder.RecordingFile;
import co.vine.android.util.MediaUtil.GenerateThumbnailsRunnable;
import co.vine.android.util.UploadManager;
import java.io.File;

class AbstractRecordingActivity$10 extends Thread
{
  public void run()
  {
    if (this.val$grabThumbnailRunnable != null)
      this.val$grabThumbnailRunnable.run();
    if (AppController.getInstance(this.this$0.getApplicationContext()).isLoggedIn());
    try
    {
      this.this$0.mUploadFile = UploadManager.addToUploadQueue(this.this$0.getApplicationContext(), this.val$finalFile, this.val$thumbNailPath, this.val$finalFile.folder.getName(), this.this$0.mIsMessaging, this.this$0.mConversationRowId);
      AbstractRecordingActivity.access$2402(this.this$0, null);
      return;
    }
    catch (Exception localException)
    {
    }
    throw new RuntimeException(localException);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.AbstractRecordingActivity.10
 * JD-Core Version:    0.6.0
 */