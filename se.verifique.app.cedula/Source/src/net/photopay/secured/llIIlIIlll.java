package net.photopay.secured;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.photopay.hardware.DeviceManager;
import net.photopay.hardware.llIIlIlIIl;
import net.photopay.util.Log;
import net.photopay.util.Log.LogLevel;

public abstract class llIIlIIlll
{
  protected static final Map llIIlIlIIl;
  protected int IlIIlllIIl = 600;
  protected Camera llIIlIlIIl;
  protected List llIIlIlIIl;
  protected int llIllIIlll = 230400;

  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new llIIlIlIIl("ST27i", "ST27i"), new llIIlIIlll.llIIlIlIIl(480, 320));
    localHashMap.put(new llIIlIlIIl("", "HTC Desire"), new llIIlIIlll.llIIlIlIIl(640, 480));
    localHashMap.put(new llIIlIlIIl("", "HTC HD2"), new llIIlIIlll.llIIlIlIIl(640, 480));
    localHashMap.put(new llIIlIlIIl("", "X06HT"), new llIIlIIlll.llIIlIlIIl(640, 480));
    localHashMap.put(new llIIlIlIIl("", "HTC Desire C"), new llIIlIIlll.llIIlIlIIl(640, 480));
    localHashMap.put(new llIIlIlIIl("", "HTC Desire S"), new llIIlIIlll.llIIlIlIIl(640, 480));
    localHashMap.put(new llIIlIlIIl("", "HTC Desire V"), new llIIlIIlll.llIIlIlIIl(640, 480));
    jdField_llIIlIlIIl_of_type_JavaUtilMap = Collections.unmodifiableMap(localHashMap);
  }

  public llIIlIIlll(Camera paramCamera, int paramInt)
  {
    if (paramCamera == null)
    {
      Log.e(this, "Camera cannot be null while initializing camera strategy", new Object[0]);
      throw new IllegalArgumentException("Camera for CameraStragey cannot be null");
    }
    this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera = paramCamera;
    this.llIllIIlll = paramInt;
    this.jdField_llIIlIlIIl_of_type_JavaUtilList = this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera.getParameters().getSupportedPreviewSizes();
    if (Log.getCurrentLogLevel().ordinal() >= Log.LogLevel.LOG_VERBOSE.ordinal())
    {
      Iterator localIterator = this.jdField_llIIlIlIIl_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Camera.Size localSize = (Camera.Size)localIterator.next();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(localSize.width);
        arrayOfObject[1] = Integer.valueOf(localSize.height);
        Log.d(this, "Camera supported preview size: {}x{}", arrayOfObject);
      }
    }
  }

  public final void IlIIlllIIl()
  {
    this.IlIIlllIIl = 1500;
  }

  public final boolean lIIIIIlIlI()
  {
    Iterator localIterator = this.jdField_llIIlIlIIl_of_type_JavaUtilList.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (!llIIlIlIIl((Camera.Size)localIterator.next()));
    for (int i = 0; ; i = 1)
      return i;
  }

  public final int llIIlIIlll()
  {
    return this.IlIIlllIIl;
  }

  abstract double llIIlIlIIl(Camera.Size paramSize, double paramDouble, long paramLong);

  public abstract Camera.Size llIIlIlIIl(int paramInt1, int paramInt2);

  protected final Camera.Size llIIlIlIIl(List paramList, double paramDouble, long paramLong)
  {
    Object localObject1 = null;
    double d1 = (1.0D / 0.0D);
    Iterator localIterator = paramList.iterator();
    double d2;
    Object localObject2;
    if (localIterator.hasNext())
    {
      Camera.Size localSize = (Camera.Size)localIterator.next();
      if (localSize.width % 4 != 0)
        break label147;
      double d3 = llIIlIlIIl(localSize, paramDouble, paramLong);
      if (d3 >= d1)
        break label136;
      d2 = d3;
      localObject2 = localSize;
      label75: Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(localSize.width);
      arrayOfObject[1] = Integer.valueOf(localSize.height);
      arrayOfObject[2] = Double.valueOf(d3);
      Log.v(this, "Compatibility for preview size {}x{} is {}", arrayOfObject);
    }
    while (true)
    {
      d1 = d2;
      localObject1 = localObject2;
      break;
      return localObject1;
      label136: d2 = d1;
      localObject2 = localObject1;
      break label75;
      label147: d2 = d1;
      localObject2 = localObject1;
    }
  }

  protected final Camera.Size llIIlIlIIl(Map paramMap)
  {
    llIIlIlIIl localllIIlIlIIl = new llIIlIlIIl(DeviceManager.getDevice(), DeviceManager.getModel());
    llIIlIIlll.llIIlIlIIl localllIIlIlIIl1 = (llIIlIIlll.llIIlIlIIl)paramMap.get(localllIIlIlIIl);
    Camera.Size localSize2;
    if ((localllIIlIlIIl1 != null) && (this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera != null))
    {
      Camera localCamera = this.jdField_llIIlIlIIl_of_type_AndroidHardwareCamera;
      localCamera.getClass();
      localSize2 = new Camera.Size(localCamera, localllIIlIlIIl1.getWidth(), localllIIlIlIIl1.getHeight());
      if (this.jdField_llIIlIlIIl_of_type_JavaUtilList.contains(localSize2))
      {
        localllIIlIlIIl.llIIIlllll();
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = Integer.valueOf(localllIIlIlIIl1.getWidth());
        arrayOfObject2[1] = Integer.valueOf(localllIIlIlIIl1.getHeight());
        Log.v(this, "Using device specific resolution {}x{}", arrayOfObject2);
      }
    }
    for (Camera.Size localSize1 = localSize2; ; localSize1 = null)
    {
      return localSize1;
      localllIIlIlIIl.llIIIlllll();
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(localllIIlIlIIl1.getWidth());
      arrayOfObject1[1] = Integer.valueOf(localllIIlIlIIl1.getHeight());
      Log.e(this, "Device pecific resolution {}x{}", arrayOfObject1);
      Log.e(this, "Is not supported!!", new Object[0]);
    }
  }

  protected boolean llIIlIlIIl(Camera.Size paramSize)
  {
    int i = 0;
    Camera.Size localSize = llIIlIlIIl(jdField_llIIlIlIIl_of_type_JavaUtilMap);
    boolean bool1;
    if (paramSize.height * paramSize.width >= this.llIllIIlll)
    {
      bool1 = true;
      if ((localSize == null) || (!localSize.equals(paramSize)))
        break label133;
    }
    label133: for (boolean bool2 = true; ; bool2 = false)
    {
      if (Log.getCurrentLogLevel().ordinal() >= Log.LogLevel.LOG_VERBOSE.ordinal())
      {
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[i] = Integer.valueOf(paramSize.width);
        arrayOfObject[1] = Integer.valueOf(paramSize.height);
        arrayOfObject[2] = Boolean.valueOf(bool1);
        arrayOfObject[3] = Boolean.valueOf(bool2);
        Log.v(this, "Resolution {}x{}: resolution high enough: {}, resolution supported by device: {}", arrayOfObject);
      }
      if ((bool1) || (bool2))
        i = 1;
      return i;
      bool1 = false;
      break;
    }
  }

  public abstract void log();
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.llIIlIIlll
 * JD-Core Version:    0.6.0
 */