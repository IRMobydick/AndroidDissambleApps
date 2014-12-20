package net.photopay.secured;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import net.photopay.util.Log;

final class llIllIIlll$1
  implements View.OnTouchListener
{
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = 1;
    if ((llIllIIlll.llIIlIlIIl(this.IlIllIlIIl)) && (llIllIIlll.llIIlIlIIl(this.IlIllIlIIl) > 0.0F))
    {
      float f = paramMotionEvent.getY();
      llIllIIlll localllIllIIlll = this.IlIllIlIIl;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Float.valueOf(f);
      arrayOfObject[i] = Float.valueOf(llIllIIlll.llIIlIlIIl(this.IlIllIlIIl));
      arrayOfObject[2] = Float.valueOf(llIllIIlll.IlIllIlIIl(this.IlIllIlIIl));
      Log.i(localllIllIIlll, "Intercepted touch event at y: {}, overlay start is: {}, overlay end is: {}", arrayOfObject);
      if ((f >= llIllIIlll.llIIlIlIIl(this.IlIllIlIIl)) && (f <= llIllIIlll.IlIllIlIIl(this.IlIllIlIIl)))
        llIllIIlll.llIIlIlIIl(this.IlIllIlIIl);
    }
    while (true)
    {
      return i;
      i = 0;
      continue;
      i = 0;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.llIllIIlll.1
 * JD-Core Version:    0.6.0
 */