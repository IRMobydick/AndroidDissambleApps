package net.photopay.hardware.camera;

import android.hardware.Camera;
import net.photopay.util.Log;

final class IllIIIIllI$1
  implements Runnable
{
  public final void run()
  {
    Log.i(this, "onPhotoManagerTap", new Object[0]);
    if ((this.llIIlIlIIl.llIIlIlIIl != null) && (!this.llIIlIlIIl.IlIIIIIlll) && (this.llIIlIlIIl.IlIIlIIIII))
    {
      this.llIIlIlIIl.pauseFrameGrabbing();
      this.llIIlIlIIl.IlIIIIIlll = true;
      Log.i(this, "requesting autofocus", new Object[0]);
      this.llIIlIlIIl.llIIlIlIIl.autoFocus(new IllIIIIllI.1.1(this));
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.camera.IllIIIIllI.1
 * JD-Core Version:    0.6.0
 */