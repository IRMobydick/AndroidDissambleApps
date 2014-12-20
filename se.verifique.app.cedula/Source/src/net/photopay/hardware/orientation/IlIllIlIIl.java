package net.photopay.hardware.orientation;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import net.photopay.util.Log;

public final class IlIllIlIIl extends OrientationEventListener
{
  private Orientation jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationOrientation = Orientation.ORIENTATION_UNKNOWN;
  private llIIlIlIIl jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationLlIIlIlIIl = null;
  private int lllIIlIIlI = 0;

  public IlIllIlIIl(Context paramContext, llIIlIlIIl paramllIIlIlIIl)
  {
    super(paramContext);
    this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationLlIIlIlIIl = paramllIIlIlIIl;
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int j;
    int i;
    if (Build.VERSION.SDK_INT >= 8)
      switch (localDisplay.getRotation())
      {
      default:
        j = 0;
        i = 0;
        if (i <= j)
          break;
        Log.d(this, "Natural Orientation is landscape", new Object[0]);
        this.lllIIlIIlI = 270;
      case 0:
      case 2:
      case 1:
      case 3:
      }
    while (true)
    {
      return;
      Log.d(this, "Rotation is: 0 or 180", new Object[0]);
      i = localDisplay.getWidth();
      j = localDisplay.getHeight();
      break;
      Log.d(this, "Rotation is: 90 or 270", new Object[0]);
      i = localDisplay.getHeight();
      j = localDisplay.getWidth();
      break;
      Log.d(this, "Natural Orientation is portrait", new Object[0]);
      continue;
      this.lllIIlIIlI = 0;
    }
  }

  public final void onOrientationChanged(int paramInt)
  {
    int i;
    Orientation localOrientation;
    if (this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationLlIIlIlIIl != null)
    {
      i = (paramInt + this.lllIIlIIlI) % 360;
      if (i < 0)
        break label128;
      if ((i < 315) && (i >= 45))
        break label66;
      localOrientation = Orientation.ORIENTATION_PORTRAIT;
    }
    while (true)
    {
      if (localOrientation != this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationOrientation)
      {
        this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationOrientation = localOrientation;
        this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationLlIIlIlIIl.onOrientationChange(this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationOrientation);
      }
      return;
      label66: if ((i >= 45) && (i < 135))
      {
        localOrientation = Orientation.ORIENTATION_LANDSCAPE_LEFT;
        continue;
      }
      if ((i >= 135) && (i < 225))
      {
        localOrientation = Orientation.ORIENTATION_PORTRAIT_UPSIDE;
        continue;
      }
      if ((i >= 225) && (i < 315))
      {
        localOrientation = Orientation.ORIENTATION_LANDSCAPE_RIGHT;
        continue;
      }
      label128: localOrientation = this.jdField_llIIlIlIIl_of_type_NetPhotopayHardwareOrientationOrientation;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.hardware.orientation.IlIllIlIIl
 * JD-Core Version:    0.6.0
 */