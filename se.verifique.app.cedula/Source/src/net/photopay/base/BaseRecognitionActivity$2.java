package net.photopay.base;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class BaseRecognitionActivity$2
  implements MediaPlayer.OnCompletionListener
{
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (BaseRecognitionActivity.llIIlIlIIl(this.llIIlIlIIl) == null)
      paramMediaPlayer.release();
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.base.BaseRecognitionActivity.2
 * JD-Core Version:    0.6.0
 */