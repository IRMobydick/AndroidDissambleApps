package net.photopay.ocr;

import android.graphics.Matrix;
import java.util.List;

public class OcrResult
{
  private List mBlocks;
  private String mResultName;
  private Matrix mTransformation;

  public OcrResult(List paramList, String paramString)
  {
    this.mBlocks = paramList;
    this.mResultName = paramString;
    this.mTransformation = new Matrix();
  }

  public List getBlocks()
  {
    return this.mBlocks;
  }

  public String getResultName()
  {
    return this.mResultName;
  }

  public Matrix getTransformation()
  {
    return this.mTransformation;
  }

  public void setTransformation(Matrix paramMatrix)
  {
    this.mTransformation = paramMatrix;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.ocr.OcrResult
 * JD-Core Version:    0.6.0
 */