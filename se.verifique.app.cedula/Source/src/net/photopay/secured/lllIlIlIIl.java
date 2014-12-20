package net.photopay.secured;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import java.util.Iterator;
import java.util.List;
import net.photopay.hardware.DeviceManager;
import net.photopay.util.Log;

public final class lllIlIlIIl
  implements IllIIlIIII
{
  private boolean llIIlIlIIl(Camera paramCamera)
  {
    Iterator localIterator = paramCamera.getParameters().getSupportedPreviewSizes().iterator();
    while (localIterator.hasNext())
    {
      Camera.Size localSize = (Camera.Size)localIterator.next();
      if (Math.min(localSize.width, localSize.height) < 720)
        continue;
      Log.i(this, "Device camera is HD ready!", new Object[0]);
    }
    for (int i = 1; ; i = 0)
    {
      return i;
      Log.i(this, "Device camera is not HD ready!", new Object[0]);
    }
  }

  public final llIIlIIlll llIIlIlIIl(DeviceManager paramDeviceManager, Camera paramCamera, lIlIIIIlIl paramlIlIIIIlIl)
  {
    if (paramDeviceManager == null)
    {
      Log.e(this, "Device manager must be set to create CameraStrategy", new Object[0]);
      throw new NullPointerException("Device manager must be set to create CameraStrategy");
    }
    if (paramCamera == null)
    {
      Log.e(this, "Cannot create strategy for null camera!", new Object[0]);
      throw new NullPointerException("Cannot create strategy for null camera!");
    }
    if (paramlIlIIIIlIl == null)
    {
      Log.e(this, "Cannot create strategy with empty settings", new Object[0]);
      throw new NullPointerException("Cannot create strategy with empty settings");
    }
    Object localObject;
    if (paramlIlIIIIlIl.IlIllIlllI())
      if (paramlIlIIIIlIl.IllIIlIIII())
        localObject = new IlIllIlllI(paramCamera, paramlIlIIIIlIl.IllIIIIllI());
    label194: 
    while (true)
    {
      ((llIIlIIlll)localObject).log();
      return localObject;
      localObject = new lllIIIlIlI(paramCamera, paramlIlIIIIlIl.IllIIIIllI());
      continue;
      if ((paramlIlIIIIlIl.lllIIIlIlI()) || (DeviceManager.isDeviceHQ()) || (llIIlIlIIl(paramCamera)));
      for (localObject = new IIlIIIllIl(paramCamera, paramlIlIIIIlIl.lIlIIIIlIl()); ; localObject = new lIIIIIllll(paramCamera, paramlIlIIIIlIl.lIlIIIIlIl()))
      {
        if (!"GT-S5830".equalsIgnoreCase(DeviceManager.getDevice()))
          break label194;
        ((llIIlIIlll)localObject).IlIIlllIIl();
        break;
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.lllIlIlIIl
 * JD-Core Version:    0.6.0
 */