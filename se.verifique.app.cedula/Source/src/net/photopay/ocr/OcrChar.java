package net.photopay.ocr;

import net.photopay.geometry.Rectangle;

public class OcrChar
{
  private boolean mBold;
  private int mHeight;
  private boolean mItalic;
  private Rectangle mPosition;
  private int mQuality;
  private boolean mUncertain;
  private char mValue;

  public OcrChar(char paramChar, int paramInt1, Rectangle paramRectangle, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mValue = paramChar;
    this.mHeight = paramInt1;
    this.mPosition = paramRectangle;
    this.mQuality = paramInt2;
    this.mBold = paramBoolean1;
    this.mItalic = paramBoolean2;
    this.mUncertain = paramBoolean3;
  }

  public int getHeight()
  {
    return this.mHeight;
  }

  public Rectangle getPosition()
  {
    return this.mPosition;
  }

  public int getQuality()
  {
    return this.mQuality;
  }

  public char getValue()
  {
    return this.mValue;
  }

  public boolean isBold()
  {
    return this.mBold;
  }

  public boolean isItalic()
  {
    return this.mItalic;
  }

  public boolean isUncertain()
  {
    return this.mUncertain;
  }

  public void setBold(boolean paramBoolean)
  {
    this.mBold = paramBoolean;
  }

  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }

  public void setItalic(boolean paramBoolean)
  {
    this.mItalic = paramBoolean;
  }

  public void setPosition(Rectangle paramRectangle)
  {
    this.mPosition = paramRectangle;
  }

  public void setQuality(int paramInt)
  {
    this.mQuality = paramInt;
  }

  public void setUncertain(boolean paramBoolean)
  {
    this.mUncertain = paramBoolean;
  }

  public void setValue(char paramChar)
  {
    this.mValue = paramChar;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.ocr.OcrChar
 * JD-Core Version:    0.6.0
 */