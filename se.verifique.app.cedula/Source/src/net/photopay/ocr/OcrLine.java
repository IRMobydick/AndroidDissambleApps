package net.photopay.ocr;

import java.util.List;
import net.photopay.geometry.Rectangle;

public class OcrLine
{
  private List mChars;
  private Rectangle mPosition;

  public OcrLine(List paramList, Rectangle paramRectangle)
  {
    this.mChars = paramList;
    this.mPosition = paramRectangle;
  }

  public List getChars()
  {
    return this.mChars;
  }

  public Rectangle getPosition()
  {
    return this.mPosition;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.ocr.OcrLine
 * JD-Core Version:    0.6.0
 */