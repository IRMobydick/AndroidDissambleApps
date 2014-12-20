package net.photopay.secured;

import android.view.animation.AccelerateDecelerateInterpolator;
import net.photopay.geometry.IlIllIlIIl;
import net.photopay.nineoldandroids.animation.ValueAnimator;

final class llIllIIlll$2
  implements Runnable
{
  public final void run()
  {
    if (llIllIIlll.llIIlIlIIl(this.IlIllIlIIl) != null)
      llIllIIlll.llIIlIlIIl(this.IlIllIlIIl).cancel();
    llIllIIlll localllIllIIlll = this.IlIllIlIIl;
    IlIllIlIIl localIlIllIlIIl = new IlIllIlIIl();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = llIllIIlll.llIIlIlIIl(this.IlIllIlIIl);
    arrayOfObject[1] = llIllIIlll.IlIllIlIIl(this.IlIllIlIIl);
    llIllIIlll.llIIlIlIIl(localllIllIIlll, ValueAnimator.ofObject(localIlIllIlIIl, arrayOfObject));
    if (llIllIIlll.llIIlIlIIl(this.IlIllIlIIl) == 2)
      llIllIIlll.llIIlIlIIl(this.IlIllIlIIl).setDuration(100L);
    while (true)
    {
      llIllIIlll.llIIlIlIIl(this.IlIllIlIIl).setInterpolator(new AccelerateDecelerateInterpolator());
      llIllIIlll.llIIlIlIIl(this.IlIllIlIIl).addUpdateListener(this.IlIllIlIIl);
      llIllIIlll.llIIlIlIIl(this.IlIllIlIIl).start();
      return;
      llIllIIlll.llIIlIlIIl(this.IlIllIlIIl).setDuration(200L);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.llIllIIlll.2
 * JD-Core Version:    0.6.0
 */