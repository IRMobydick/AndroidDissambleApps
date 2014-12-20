package co.vine.android;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v8.renderscript.RenderScript;
import android.widget.ImageView;
import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.recorder.RsBlur;

public class ConversationAdapter$BlurRunnable
  implements Runnable
{
  private final Bitmap bitmap;
  private final ImageView imageView;
  private boolean setImage;

  public ConversationAdapter$BlurRunnable(ConversationAdapter paramConversationAdapter, Bitmap paramBitmap, ImageView paramImageView)
  {
    this.bitmap = paramBitmap;
    this.imageView = paramImageView;
  }

  public void run()
  {
    if (ConversationAdapter.access$1200(this.this$0) == null)
      ConversationAdapter.access$1202(this.this$0, RecordConfigUtils.createDefaultSizeBitmap());
    if (ConversationAdapter.access$1300(this.this$0) == null)
      ConversationAdapter.access$1302(this.this$0, new RsBlur(RenderScript.create(ConversationAdapter.access$000(this.this$0)), ConversationAdapter.access$1200(this.this$0), 25.0F));
    if (this.setImage)
      this.imageView.setImageBitmap(ConversationAdapter.access$1200(this.this$0));
    while (true)
    {
      return;
      ConversationAdapter.access$1300(this.this$0).execute(this.bitmap, ConversationAdapter.access$1200(this.this$0), 6);
      this.setImage = true;
      ConversationAdapter.access$1400(this.this$0).post(this);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     co.vine.android.ConversationAdapter.BlurRunnable
 * JD-Core Version:    0.6.0
 */