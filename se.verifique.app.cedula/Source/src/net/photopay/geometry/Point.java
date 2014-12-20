package net.photopay.geometry;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

public class Point
{
  private float mNorm = -1.0F;
  private float mX;
  private float mY;

  public Point()
  {
    this.mX = 0.0F;
    this.mY = 0.0F;
  }

  public Point(float paramFloat1, float paramFloat2)
  {
    this.mX = paramFloat1;
    this.mY = paramFloat2;
  }

  public Point clamp(float paramFloat)
  {
    if (norm() > paramFloat);
    for (Point localPoint = normalize(paramFloat); ; localPoint = new Point(this.mX, this.mY))
      return localPoint;
  }

  public Point clone()
  {
    return new Point(this.mX, this.mY);
  }

  public float distance(Point paramPoint)
  {
    float f1 = this.mX - paramPoint.mX;
    float f2 = this.mY - paramPoint.mY;
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }

  public void draw(Canvas paramCanvas, Paint paramPaint, int paramInt)
  {
    paramCanvas.drawCircle(this.mX, this.mY, paramInt, paramPaint);
  }

  public boolean equals(Object paramObject)
  {
    int i = 0;
    if (paramObject == null);
    while (true)
    {
      return i;
      if (!(paramObject instanceof Point))
        continue;
      Point localPoint = (Point)paramObject;
      if ((this.mX != localPoint.mX) || (this.mY != localPoint.mY))
        continue;
      i = 1;
    }
  }

  public float getX()
  {
    return this.mX;
  }

  public float getY()
  {
    return this.mY;
  }

  public void log()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Float.valueOf(this.mX);
    arrayOfObject[1] = Float.valueOf(this.mY);
    Log.d("Point", String.format("(%f,%f)", arrayOfObject));
  }

  public Point mirrorX(float paramFloat)
  {
    return new Point(paramFloat - this.mX, this.mY);
  }

  public Point mirrorXY(float paramFloat1, float paramFloat2)
  {
    return new Point(paramFloat1 - this.mX, paramFloat2 - this.mY);
  }

  public Point mirrorY(float paramFloat)
  {
    return new Point(this.mX, paramFloat - this.mY);
  }

  public Point negative()
  {
    return new Point(-this.mX, -this.mY);
  }

  public float norm()
  {
    if (this.mNorm < 0.0F)
      this.mNorm = (float)Math.sqrt(this.mX * this.mX + this.mY * this.mY);
    return this.mNorm;
  }

  public Point normalize()
  {
    float f = norm();
    return new Point(this.mX / f, this.mY / f);
  }

  public Point normalize(float paramFloat)
  {
    float f = norm();
    return new Point(paramFloat * this.mX / f, paramFloat * this.mY / f);
  }

  public Point operatorMinus(Point paramPoint)
  {
    return new Point(this.mX - paramPoint.mX, this.mY - paramPoint.mY);
  }

  public Point operatorMultiply(float paramFloat)
  {
    return new Point(paramFloat * this.mX, paramFloat * this.mY);
  }

  public Point operatorPlus(Point paramPoint)
  {
    return new Point(this.mX + paramPoint.mX, this.mY + paramPoint.mY);
  }

  public void operatorPlusEquals(Point paramPoint)
  {
    this.mX += paramPoint.mX;
    this.mY += paramPoint.mY;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.geometry.Point
 * JD-Core Version:    0.6.0
 */