package net.photopay.secured;

import net.photopay.hardware.DeviceManager;
import net.photopay.hardware.camera.focus.AutofocusStatusView;
import net.photopay.hardware.camera.llIIIlllll;

public final class IllIIIIllI
{
  private DeviceManager llIIlIlIIl;

  public IllIIIIllI(DeviceManager paramDeviceManager)
  {
    this.llIIlIlIIl = paramDeviceManager;
    if (this.llIIlIlIIl == null)
      throw new NullPointerException("Device manager cannot be null!");
  }

  public final net.photopay.hardware.camera.llIIlIlIIl llIIlIlIIl(llIIIlllll paramllIIIlllll, AutofocusStatusView paramAutofocusStatusView, lIlIIIIlIl paramlIlIIIIlIl)
  {
    llIIlIlIIl localllIIlIlIIl = new llIIlIlIIl(this.llIIlIlIIl.getContext(), new IlIllIlIIl());
    lllIlIlIIl locallllIlIlIIl = new lllIlIlIIl();
    if (paramlIlIIIIlIl.IlIllIlllI());
    for (Object localObject = new net.photopay.hardware.camera.IllIIIIllI(localllIIlIlIIl, locallllIlIlIIl, paramllIIIlllll, paramlIlIIIIlIl, paramAutofocusStatusView); ; localObject = new net.photopay.hardware.camera.lIlIIIIlIl(localllIIlIlIIl, locallllIlIlIIl, paramllIIIlllll, paramlIlIIIIlIl, paramAutofocusStatusView))
      return localObject;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.IllIIIIllI
 * JD-Core Version:    0.6.0
 */