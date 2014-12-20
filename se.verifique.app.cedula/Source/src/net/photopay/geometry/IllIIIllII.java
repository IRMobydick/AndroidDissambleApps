package net.photopay.geometry;

import android.graphics.Canvas;
import android.graphics.Paint;
import net.photopay.secured.lIIIIIlIlI;
import net.photopay.util.Log;
import net.photopay.util.llIIlIlIIl;

public final class IllIIIllII
{
  public static int IlIllIlIIl;
  public static int IllIIIllII;
  public static int llIIIlllll;
  public static float llIIlIlIIl;
  Point IlIllIlIIl;
  int IllIIIIllI = jdField_IlIllIlIIl_of_type_Int;
  Point IllIIIllII;
  int lIlIIIIlIl = 1;
  boolean lIllIIlIIl = false;
  Point llIIIlllll;
  Point jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint;
  lIIIIIlIlI jdField_llIIlIlIIl_of_type_NetPhotopaySecuredLIIIIIlIlI = null;

  static
  {
    jdField_llIIlIlIIl_of_type_Float = 0.3F;
    jdField_IlIllIlIIl_of_type_Int = -1;
    jdField_IllIIIllII_of_type_Int = 0;
    jdField_llIIIlllll_of_type_Int = 0;
  }

  public IllIIIllII(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    arrayOfObject[2] = Integer.valueOf(paramInt3);
    arrayOfObject[3] = Integer.valueOf(paramInt4);
    Log.v(this, "Creating new default quadrilateral with margins: top={}, bottom={}, left={}, right={}", arrayOfObject);
    if (llIIlIlIIl.isPortrait())
    {
      this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint = new Point(paramInt3, paramInt1);
      this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint = new Point(paramInt4, paramInt1);
      this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint = new Point(paramInt3, paramInt2);
    }
    for (this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint = new Point(paramInt4, paramInt2); ; this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint = new Point(paramInt4, paramInt1))
    {
      return;
      this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint = new Point(paramInt3, paramInt2);
      this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint = new Point(paramInt3, paramInt1);
      this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint = new Point(paramInt4, paramInt2);
    }
  }

  public IllIIIllII(Point paramPoint1, Point paramPoint2, Point paramPoint3, Point paramPoint4)
  {
    this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint = paramPoint1;
    this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint = paramPoint2;
    this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint = paramPoint3;
    this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint = paramPoint4;
  }

  public static IllIIIllII llIIlIlIIl(Point paramPoint1, Point paramPoint2, Point paramPoint3, Point paramPoint4, int paramInt1, int paramInt2)
  {
    if (llIIlIlIIl.isPortrait());
    for (IllIIIllII localIllIIIllII = new IllIIIllII(new Point(paramPoint1.getY() * paramInt1, paramPoint1.getX() * paramInt2), new Point(paramPoint2.getY() * paramInt1, paramPoint2.getX() * paramInt2), new Point(paramPoint3.getY() * paramInt1, paramPoint3.getX() * paramInt2), new Point(paramPoint4.getY() * paramInt1, paramPoint4.getX() * paramInt2)); ; localIllIIIllII = new IllIIIllII(new Point(paramPoint1.getX() * paramInt1, (1.0F - paramPoint1.getY()) * paramInt2), new Point(paramPoint2.getX() * paramInt1, (1.0F - paramPoint2.getY()) * paramInt2), new Point(paramPoint3.getX() * paramInt1, (1.0F - paramPoint3.getY()) * paramInt2), new Point(paramPoint4.getX() * paramInt1, (1.0F - paramPoint4.getY()) * paramInt2)))
      return localIllIIIllII;
  }

  public final Point IlIllIlIIl()
  {
    return this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint;
  }

  public final Point IllIIIllII()
  {
    return this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint;
  }

  public final void IllIIIllII()
  {
    this.lIllIIlIIl = true;
  }

  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    if ((jdField_llIIIlllll_of_type_Int <= 0) || (jdField_IllIIIllII_of_type_Int <= 0))
    {
      jdField_llIIIlllll_of_type_Int = paramCanvas.getHeight();
      jdField_IllIIIllII_of_type_Int = paramCanvas.getWidth();
    }
    float f1 = Math.max(jdField_IllIIIllII_of_type_Int / 8, jdField_llIIIlllll_of_type_Int / 8);
    Point localPoint1 = this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint.operatorMinus(this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint).operatorMultiply(jdField_llIIlIlIIl_of_type_Float);
    Point localPoint2 = this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint.operatorMinus(this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint).operatorMultiply(jdField_llIIlIlIIl_of_type_Float);
    Point localPoint3 = this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint.operatorMinus(this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint).operatorMultiply(jdField_llIIlIlIIl_of_type_Float);
    Point localPoint4 = this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint.operatorMinus(this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint).operatorMultiply(jdField_llIIlIlIIl_of_type_Float);
    float f2 = Math.min(Math.min(Math.min(Math.min(f1, localPoint1.norm()), localPoint2.norm()), localPoint3.norm()), localPoint4.norm());
    Point localPoint5 = localPoint1.clamp(f2);
    Point localPoint6 = localPoint2.clamp(f2);
    Point localPoint7 = localPoint4.clamp(f2);
    Point localPoint8 = localPoint3.clamp(f2);
    paramPaint.setColor(this.IllIIIIllI);
    Point localPoint9 = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint.operatorPlus(localPoint5);
    Point localPoint10 = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint.operatorPlus(localPoint6);
    paramCanvas.drawLine(this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint.getX(), this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint.getY(), localPoint9.getX(), localPoint9.getY(), paramPaint);
    paramCanvas.drawLine(this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint.getX(), this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint.getY(), localPoint10.getX(), localPoint10.getY(), paramPaint);
    Point localPoint11 = this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint.operatorMinus(localPoint5);
    Point localPoint12 = this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint.operatorPlus(localPoint7);
    paramCanvas.drawLine(this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint.getX(), this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint.getY(), localPoint11.getX(), localPoint11.getY(), paramPaint);
    paramCanvas.drawLine(this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint.getX(), this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint.getY(), localPoint12.getX(), localPoint12.getY(), paramPaint);
    Point localPoint13 = this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint.operatorMinus(localPoint6);
    Point localPoint14 = this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint.operatorPlus(localPoint8);
    paramCanvas.drawLine(this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint.getX(), this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint.getY(), localPoint13.getX(), localPoint13.getY(), paramPaint);
    paramCanvas.drawLine(this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint.getX(), this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint.getY(), localPoint14.getX(), localPoint14.getY(), paramPaint);
    Point localPoint15 = this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint.operatorMinus(localPoint7);
    Point localPoint16 = this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint.operatorMinus(localPoint8);
    paramCanvas.drawLine(this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint.getX(), this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint.getY(), localPoint15.getX(), localPoint15.getY(), paramPaint);
    paramCanvas.drawLine(this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint.getX(), this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint.getY(), localPoint16.getX(), localPoint16.getY(), paramPaint);
  }

  public final int getColor()
  {
    return this.IllIIIIllI;
  }

  public final Point llIIIlllll()
  {
    return this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint;
  }

  public final int llIIlIlIIl()
  {
    return this.lIlIIIIlIl;
  }

  public final IllIIIllII llIIlIlIIl()
  {
    IllIIIllII localIllIIIllII = new IllIIIllII(this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint, this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint, this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint, this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint);
    localIllIIIllII.lIllIIlIIl = this.lIllIIlIIl;
    localIllIIIllII.IllIIIIllI = this.IllIIIIllI;
    localIllIIIllII.lIlIIIIlIl = this.lIlIIIIlIl;
    return localIllIIIllII;
  }

  public final Point llIIlIlIIl()
  {
    return this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint;
  }

  public final void llIIlIlIIl(int paramInt)
  {
    this.lIlIIIIlIl = paramInt;
  }

  public final void llIIlIlIIl(int paramInt1, int paramInt2)
  {
    Point localPoint2;
    Point localPoint4;
    Point localPoint1;
    Point localPoint3;
    if (llIIlIlIIl.isPortrait())
    {
      localPoint2 = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint.mirrorY(paramInt2);
      localPoint4 = this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint.mirrorY(paramInt2);
      localPoint1 = this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint.mirrorY(paramInt2);
      localPoint3 = this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint.mirrorY(paramInt2);
    }
    while (true)
    {
      this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint = localPoint1;
      this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint = localPoint3;
      this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint = localPoint2;
      this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint = localPoint4;
      return;
      localPoint1 = this.jdField_IlIllIlIIl_of_type_NetPhotopayGeometryPoint.mirrorX(paramInt1);
      localPoint2 = this.jdField_llIIIlllll_of_type_NetPhotopayGeometryPoint.mirrorX(paramInt1);
      localPoint3 = this.jdField_llIIlIlIIl_of_type_NetPhotopayGeometryPoint.mirrorX(paramInt1);
      localPoint4 = this.jdField_IllIIIllII_of_type_NetPhotopayGeometryPoint.mirrorX(paramInt1);
    }
  }

  public final boolean llIIlIlIIl()
  {
    return this.lIllIIlIIl;
  }

  public final void setColor(int paramInt)
  {
    this.IllIIIIllI = paramInt;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.geometry.IllIIIllII
 * JD-Core Version:    0.6.0
 */