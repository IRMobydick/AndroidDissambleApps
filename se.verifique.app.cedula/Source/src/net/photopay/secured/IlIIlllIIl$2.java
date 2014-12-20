package net.photopay.secured;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import net.photopay.util.FakeR;

final class IlIIlllIIl$2
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    boolean bool1 = true;
    IlIIlllIIl localIlIIlllIIl1 = this.IlIllIlIIl;
    boolean bool2;
    if (!IlIIlllIIl.llIIlIlIIl(this.IlIllIlIIl))
    {
      bool2 = bool1;
      if (localIlIIlllIIl1.setTorchEnabled(bool2))
      {
        IlIIlllIIl localIlIIlllIIl2 = this.IlIllIlIIl;
        if (IlIIlllIIl.llIIlIlIIl(this.IlIllIlIIl))
          break label93;
        label45: IlIIlllIIl.llIIlIlIIl(localIlIIlllIIl2, bool1);
        if (!IlIIlllIIl.llIIlIlIIl(this.IlIllIlIIl))
          break label98;
        IlIIlllIIl.llIIlIlIIl(this.IlIllIlIIl).setText(IlIIlllIIl.llIIlIlIIl(this.IlIllIlIIl).getId("string", "LightOn"));
      }
    }
    while (true)
    {
      return;
      bool2 = false;
      break;
      label93: bool1 = false;
      break label45;
      label98: IlIIlllIIl.llIIlIlIIl(this.IlIllIlIIl).setText(IlIIlllIIl.llIIlIlIIl(this.IlIllIlIIl).getId("string", "LightOff"));
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.IlIIlllIIl.2
 * JD-Core Version:    0.6.0
 */