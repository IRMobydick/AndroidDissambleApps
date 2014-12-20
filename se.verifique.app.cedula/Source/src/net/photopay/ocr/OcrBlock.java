package net.photopay.ocr;

import java.util.List;
import net.photopay.geometry.Rectangle;

public class OcrBlock
{
  private List mLines;
  private Rectangle mPosition;

  public OcrBlock(List paramList, Rectangle paramRectangle)
  {
    this.mLines = paramList;
    this.mPosition = paramRectangle;
  }

  public List getLines()
  {
    return this.mLines;
  }

  public Rectangle getPosition()
  {
    return this.mPosition;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.ocr.OcrBlock
 * JD-Core Version:    0.6.0
 */