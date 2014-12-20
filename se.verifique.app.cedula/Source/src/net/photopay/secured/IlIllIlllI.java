package net.photopay.secured;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import java.util.Iterator;
import java.util.List;
import net.photopay.util.Log;

public final class IlIllIlllI extends lllIIIlIlI
{
  private int lIllIIlIIl;

  public IlIllIlllI(Camera paramCamera, int paramInt)
  {
    super(paramCamera, 4096);
    this.lIllIIlIIl = paramInt;
  }

  public final Camera.Size IlIllIlIIl(int paramInt1, int paramInt2)
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
    int i = 2147483647;
    Iterator localIterator = localList.iterator();
    label71: Object localObject2;
    int k;
    if (localIterator.hasNext())
    {
      Camera.Size localSize = (Camera.Size)localIterator.next();
      Object[] arrayOfObject3 = new Object[2];
      arrayOfObject3[0] = Integer.valueOf(localSize.width);
      arrayOfObject3[1] = Integer.valueOf(localSize.height);
      Log.v(this, "Considering size {}x{}", arrayOfObject3);
      int j = Math.abs(localSize.width * localSize.height - this.lIllIIlIIl);
      if (j >= i)
        break label225;
      localObject2 = localSize;
      k = j;
    }
    while (true)
    {
      i = k;
      localObject1 = localObject2;
      break label71;
      if (localObject1 == null)
        break;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(((Camera.Size)localObject1).width);
      arrayOfObject2[1] = Integer.valueOf(((Camera.Size)localObject1).height);
      Log.v(localObject1, "Chosen photo size is {}x{}", arrayOfObject2);
      break;
      label225: k = i;
      localObject2 = localObject1;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.secured.IlIllIlllI
 * JD-Core Version:    0.6.0
 */