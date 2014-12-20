package co.vine.android;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import co.vine.android.api.VinePrivateMessage;
import co.vine.android.service.VineUploadService;

class ConversationAdapter$7
  implements Runnable
{
  public void run()
  {
    ConversationAdapter.access$1100(this.this$0).startService(VineUploadService.getVMPostIntent(ConversationAdapter.access$1000(this.this$0), this.val$vpm.uploadPath, true, this.val$vpm.messageRowId, this.val$vpm.conversationRowId, null, this.val$vpm.message, this.val$vpm.postId, this.val$vpm.videoUrl, this.val$vpm.thumbnailUrl, this.val$vpm.maxLoops));
    ViewGroup localViewGroup = (ViewGroup)this.val$v.getParent();
    View localView = localViewGroup.findViewById(2131362131);
    if (localView == null)
      localView = localViewGroup.findViewById(2131362136);
    if (localView != null)
    {
      localView.setVisibility(0);
      this.val$v.setVisibility(4);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationAdapter.7
 * JD-Core Version:    0.6.0
 */