package net.photopay.secured;

import android.hardware.Camera;
import android.hardware.Camera.Size;
import net.photopay.util.Log;
import net.photopay.util.llIIlIlIIl;

public final class lIIIIIllll extends llIIlIIlll
{
  public lIIIIIllll(Camera paramCamera, int paramInt)
  {
    super(paramCamera, paramInt);
  }

  final double llIIlIlIIl(Camera.Size paramSize, double paramDouble, long paramLong)
  {
    double d;
    if (!llIIlIlIIl(paramSize))
      d = (1.0D / 0.0D);
    while (true)
    {
      return d;
      d = 2000.0D * Math.abs(paramSize.width / paramSize.height - paramDouble) + 1000.0D * Math.abs(paramSize.width * paramSize.height / paramLong - 1.0D);
    }
  }

  public final Camera.Size llIIlIlIIl(int paramInt1, int paramInt2)
  {
    Camera.Size localSize;
    if (this.jdField_llIIlIlIIl_of_type_JavaUtilList == null)
      localSize = null;
    do
    {
      return localSize;
      localSize = llIIlIlIIl(jdField_llIIlIlIIl_of_type_JavaUtilMap);
    }
    while (localSize != null);
    if (llIIlIlIIl.lllIIIlIlI() == 1);
    while (true)
    {
      double d = paramInt2 / paramInt1;
      localSize = llIIlIlIIl(this.jdField_llIIlIlIIl_of_type_JavaUtilList, d, 384000L);
      break;
      int i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
  }

  public final void log()
  {
    Log.i(this, "Using LQ strategy", new Object[0]);
  }

  public final String toString()
  {
    return "LQ camera strategy";
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.lIIIIIllll
 * JD-Core Version:    0.6.0
 */