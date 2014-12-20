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

public class lllIIIlIlI extends IIlIIIllIl
{
  protected static final Map IlIllIlIIl;
  protected int lIlllIlIlI;

  static
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(new llIIlIlIIl("", "ZTE Kis Lite"), new llIIlIIlll.llIIlIlIIl(1600, 1200));
    IlIllIlIIl = Collections.unmodifiableMap(localHashMap);
  }

  public lllIIIlIlI(Camera paramCamera, int paramInt)
  {
    super(paramCamera, 0);
    this.lIlllIlIlI = paramInt;
  }

  public Camera.Size IlIllIlIIl(int paramInt1, int paramInt2)
  {
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Integer.valueOf(paramInt1);
    arrayOfObject1[1] = Integer.valueOf(paramInt2);
    Log.d(this, "surface size is: {}x{}", arrayOfObject1);
    Object localObject1 = IlIllIlIIl(IlIllIlIIl);
    if (localObject1 != null)
      return localObject1;
    List localList = this.llIIlIlIIl.getParameters().getSupportedPictureSizes();
    localObject1 = null;
    Iterator localIterator = localList.iterator();
    int i = 0;
    label70: Object localObject2;
    int j;
    if (localIterator.hasNext())
    {
      Camera.Size localSize = (Camera.Size)localIterator.next();
      if ((localSize.width > this.lIlllIlIlI) || (localSize.height > this.lIlllIlIlI))
        break label240;
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = Integer.valueOf(localSize.width);
      arrayOfObject3[1] = Integer.valueOf(localSize.height);
      Log.d(this, "Considering size {}x{}", arrayOfObject3);
      int k = localSize.width * localSize.height;
      if (k <= i)
        break label240;
      localObject2 = localSize;
      j = k;
    }
    while (true)
    {
      i = j;
      localObject1 = localObject2;
      break label70;
      if (localObject1 == null)
        break;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(((Camera.Size)localObject1).width);
      arrayOfObject2[1] = Integer.valueOf(((Camera.Size)localObject1).height);
      Log.d(localObject1, "Chosen photo size is {}x{}", arrayOfObject2);
      break;
      label240: j = i;
      localObject2 = localObject1;
    }
  }

  protected final Camera.Size IlIllIlIIl(Map paramMap)
  {
    llIIlIlIIl localllIIlIlIIl = new llIIlIlIIl(DeviceManager.getDevice(), DeviceManager.getModel());
    llIIlIIlll.llIIlIlIIl localllIIlIlIIl1 = (llIIlIIlll.llIIlIlIIl)paramMap.get(localllIIlIlIIl);
    Camera.Size localSize2;
    if ((localllIIlIlIIl1 != null) && (this.llIIlIlIIl != null))
    {
      Camera localCamera = this.llIIlIlIIl;
      localCamera.getClass();
      localSize2 = new Camera.Size(localCamera, localllIIlIlIIl1.getWidth(), localllIIlIlIIl1.getHeight());
      if (this.llIIlIlIIl.getParameters().getSupportedPictureSizes().contains(localSize2))
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
      Log.e(this, "Device specific resolution {}x{}", arrayOfObject1);
      Log.e(this, "Is not supported!!", new Object[0]);
    }
  }

  protected final boolean llIIlIlIIl(Camera.Size paramSize)
  {
    return true;
  }

  public final void log()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(this.lIlllIlIlI);
    Log.i(this, "Using Photo preview camera strategy with max image dimension: {}", arrayOfObject);
  }

  public String toString()
  {
    return "Photo preview camera strategy with max image dimension: " + this.lIlllIlIlI;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.lllIIIlIlI
 * JD-Core Version:    0.6.0
 */