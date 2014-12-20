package net.photopay.geometry;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import net.photopay.util.Log;

public class Rectangle
  implements Parcelable
{
  public static Parcelable.Creator CREATOR = new Rectangle.1();
  private float mHeight;
  private float mWidth;
  private float mX;
  private float mY;

  public Rectangle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mX = paramFloat1;
    this.mY = paramFloat2;
    this.mWidth = paramFloat3;
    this.mHeight = paramFloat4;
  }

  private Rectangle(Parcel paramParcel)
  {
    this.mX = paramParcel.readFloat();
    this.mY = paramParcel.readFloat();
    this.mWidth = paramParcel.readFloat();
    this.mHeight = paramParcel.readFloat();
  }

  public static Rectangle getDefaultROI()
  {
    return new Rectangle(0.0F, 0.0F, 1.0F, 1.0F);
  }

  public int describeContents()
  {
    return 0;
  }

  public float getHeight()
  {
    return this.mHeight;
  }

  public float getWidth()
  {
    return this.mWidth;
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
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Float.valueOf(this.mX);
    arrayOfObject[1] = Float.valueOf(this.mY);
    arrayOfObject[2] = Float.valueOf(this.mWidth);
    arrayOfObject[3] = Float.valueOf(this.mHeight);
    Log.d(this, "Rectangle[{}, {}, {}, {}]", arrayOfObject);
  }

  public String toString()
  {
    return "Rectangle[" + this.mX + ", " + this.mY + ", " + this.mWidth + ", " + this.mHeight + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.mX);
    paramParcel.writeFloat(this.mY);
    paramParcel.writeFloat(this.mWidth);
    paramParcel.writeFloat(this.mHeight);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.geometry.Rectangle
 * JD-Core Version:    0.6.0
 */