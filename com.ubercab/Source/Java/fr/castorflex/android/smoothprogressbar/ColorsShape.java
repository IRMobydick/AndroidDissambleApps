package fr.castorflex.android.smoothprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

public class ColorsShape extends Shape
{
  private int[] mColors;
  private float mStrokeWidth;

  public ColorsShape(float paramFloat, int[] paramArrayOfInt)
  {
    this.mStrokeWidth = paramFloat;
    this.mColors = paramArrayOfInt;
  }

  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    float f1 = 1.0F / this.mColors.length;
    int i = 0;
    paramPaint.setStrokeWidth(this.mStrokeWidth);
    int[] arrayOfInt = this.mColors;
    int j = arrayOfInt.length;
    for (int k = 0; k < j; k++)
    {
      paramPaint.setColor(arrayOfInt[k]);
      float f2 = f1 * i * getWidth();
      float f3 = getHeight() / 2.0F;
      i++;
      paramCanvas.drawLine(f2, f3, f1 * i * getWidth(), getHeight() / 2.0F, paramPaint);
    }
  }

  public int[] getColors()
  {
    return this.mColors;
  }

  public float getStrokeWidth()
  {
    return this.mStrokeWidth;
  }

  public void setColors(int[] paramArrayOfInt)
  {
    this.mColors = paramArrayOfInt;
  }

  public void setStrokeWidth(float paramFloat)
  {
    this.mStrokeWidth = paramFloat;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     fr.castorflex.android.smoothprogressbar.ColorsShape
 * JD-Core Version:    0.6.2
 */