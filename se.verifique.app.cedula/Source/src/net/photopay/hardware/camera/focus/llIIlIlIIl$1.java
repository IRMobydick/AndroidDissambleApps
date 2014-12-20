package net.photopay.hardware.camera.focus;

import java.util.TimerTask;
import net.photopay.util.Log;

final class llIIlIlIIl$1 extends TimerTask
{
  public final void run()
  {
    Log.v(this, "invalidating focus", new Object[0]);
    monitorenter;
    try
    {
      this.llIIlIlIIl.mFocused = false;
      this.llIIlIlIIl.IlIllIlIIl = null;
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.camera.focus.llIIlIlIIl.1
 * JD-Core Version:    0.6.0
 */