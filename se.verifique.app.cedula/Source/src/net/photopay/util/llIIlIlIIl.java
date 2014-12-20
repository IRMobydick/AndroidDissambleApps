package net.photopay.util;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Build.VERSION;
import net.photopay.hardware.DeviceManager;

public class llIIlIlIIl
{
  private static boolean IlIIlllIll;
  private static int IlIlIIllll;

  public static boolean isPortrait()
  {
    int i = 1;
    if (IlIlIIllll == i);
    while (true)
    {
      return i;
      i = 0;
    }
  }

  public static int lIIIIIllll()
  {
    int i = 0;
    if ((Build.VERSION.SDK_INT < 8) || (DeviceManager.isDisplayOrientationBlacklisted()));
    while (true)
    {
      return i;
      i = 1;
    }
  }

  public static void llIIIlllll(int paramInt)
  {
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Integer.valueOf(paramInt);
    Log.d(llIIlIlIIl.class, "Initializing default orientation to: {}", arrayOfObject1);
    if (Build.VERSION.SDK_INT >= 8)
      if (!DeviceManager.isDisplayOrientationBlacklisted())
      {
        IlIlIIllll = paramInt;
        IlIIlllIll = true;
      }
    while (true)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(IlIlIIllll);
      Log.d(llIIlIlIIl.class, "Default orientation initialized to: {}", arrayOfObject2);
      return;
      Log.d(llIIlIlIIl.class, "Display orientation is blacklisted!", new Object[0]);
      IlIlIIllll = 0;
      IlIIlllIll = false;
    }
  }

  public static void llIIlIlIIl(Activity paramActivity)
  {
    if (paramActivity.getRequestedOrientation() != IlIlIIllll)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramActivity.getRequestedOrientation());
      arrayOfObject[1] = Integer.valueOf(IlIlIIllll);
      Log.d(llIIlIlIIl.class, "Activity's requested orientation: {}. Display orientation: {}", arrayOfObject);
      paramActivity.setRequestedOrientation(IlIlIIllll);
    }
  }

  public static void llIIlIlIIl(Camera paramCamera)
  {
    if (IlIIlllIll)
      paramCamera.setDisplayOrientation(90);
    while (true)
    {
      return;
      Log.w(llIIlIlIIl.class, "Set DisplayOrientationMethod not supported.", new Object[0]);
    }
  }

  public static boolean llIIlIlIIl(Activity paramActivity)
  {
    if (paramActivity.getRequestedOrientation() == IlIlIIllll);
    for (int i = 1; ; i = 0)
      return i;
  }

  public static int lllIIIlIlI()
  {
    return IlIlIIllll;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.util.llIIlIlIIl
 * JD-Core Version:    0.6.0
 */