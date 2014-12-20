package net.photopay.geometry;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.Iterator;
import net.photopay.util.Log;

public class llIIlIlIIl
{
  private ArrayList llIIlIlIIl = null;

  static
  {
    if (!llIIlIlIIl.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      lIlllIlIlI = bool;
      return;
    }
  }

  public llIIlIlIIl(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if ((!lIlllIlIlI) && (paramArrayOfFloat.length % 2 != 0))
      throw new AssertionError();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[i] = Integer.valueOf(paramArrayOfFloat.length);
    Log.d(this, "Point set length: {}", arrayOfObject);
    this.llIIlIlIIl = new ArrayList(paramArrayOfFloat.length / 2);
    if (i < -1 + paramArrayOfFloat.length)
    {
      if (net.photopay.util.llIIlIlIIl.isPortrait())
        this.llIIlIlIIl.add(new Point(paramArrayOfFloat[(i + 1)] * paramInt1, paramArrayOfFloat[i] * paramInt2));
      while (true)
      {
        i += 2;
        break;
        this.llIIlIlIIl.add(new Point(paramArrayOfFloat[i] * paramInt1, (1.0F - paramArrayOfFloat[(i + 1)]) * paramInt2));
      }
    }
  }

  public final void llIIlIlIIl(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(this.llIIlIlIIl.size());
    if (net.photopay.util.llIIlIlIIl.isPortrait())
    {
      Iterator localIterator2 = this.llIIlIlIIl.iterator();
      while (localIterator2.hasNext())
        localArrayList.add(((Point)localIterator2.next()).mirrorY(paramInt2));
    }
    Iterator localIterator1 = this.llIIlIlIIl.iterator();
    while (localIterator1.hasNext())
      localArrayList.add(((Point)localIterator1.next()).mirrorX(paramInt1));
    this.llIIlIlIIl = localArrayList;
  }

  public final void llIIlIlIIl(Canvas paramCanvas, Paint paramPaint1, Paint paramPaint2, int paramInt)
  {
    if (this.llIIlIlIIl != null)
    {
      Iterator localIterator = this.llIIlIlIIl.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Point localPoint = (Point)localIterator.next();
        if (i % 2 == 0);
        for (Paint localPaint = paramPaint1; ; localPaint = paramPaint2)
        {
          localPoint.draw(paramCanvas, localPaint, paramInt);
          i++;
          break;
        }
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.geometry.llIIlIlIIl
 * JD-Core Version:    0.6.0
 */