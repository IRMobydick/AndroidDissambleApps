package io.card.payment;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.shapes.RoundRectShape;
import java.util.Arrays;

final class ae
{
  private boolean a = false;
  private float b;
  private float c;

  public ae(float paramFloat1, float paramFloat2)
  {
    this.b = paramFloat1;
    this.c = paramFloat2;
  }

  public final void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(-this.b / 2.0F, -this.c / 2.0F);
    Paint localPaint1 = new Paint();
    localPaint1.setColor(-16777216);
    localPaint1.setStyle(Paint.Style.STROKE);
    localPaint1.setAntiAlias(true);
    localPaint1.setStrokeWidth(1.5F);
    Paint localPaint2 = new Paint();
    localPaint2.setStyle(Paint.Style.FILL);
    localPaint2.setColor(-1);
    Paint localPaint3;
    if (this.a)
    {
      localPaint2.setAlpha(192);
      float[] arrayOfFloat = new float[8];
      Arrays.fill(arrayOfFloat, 5.0F);
      RoundRectShape localRoundRectShape = new RoundRectShape(arrayOfFloat, null, null);
      localRoundRectShape.resize(this.b, this.c);
      localRoundRectShape.draw(paramCanvas, localPaint2);
      localRoundRectShape.draw(paramCanvas, localPaint1);
      localPaint3 = new Paint();
      localPaint3.setStyle(Paint.Style.FILL_AND_STROKE);
      localPaint3.setAntiAlias(true);
      if (!this.a)
        break label369;
      localPaint3.setColor(-1);
    }
    while (true)
    {
      Path localPath = new Path();
      localPath.moveTo(10.0F, 0.0F);
      localPath.lineTo(0.0F, 11.0F);
      localPath.lineTo(6.0F, 11.0F);
      localPath.lineTo(2.0F, 20.0F);
      localPath.lineTo(13.0F, 8.0F);
      localPath.lineTo(7.0F, 8.0F);
      localPath.lineTo(10.0F, 0.0F);
      localPath.setLastPoint(10.0F, 0.0F);
      Matrix localMatrix1 = new Matrix();
      localMatrix1.postTranslate(-6.5F, -10.0F);
      localMatrix1.postScale(0.05F, 0.05F);
      localPath.transform(localMatrix1);
      Matrix localMatrix2 = new Matrix();
      float f = 0.8F * this.c;
      localMatrix2.postScale(f, f);
      localPath.transform(localMatrix2);
      paramCanvas.translate(this.b / 2.0F, this.c / 2.0F);
      paramCanvas.drawPath(localPath, localPaint3);
      paramCanvas.restore();
      return;
      localPaint2.setAlpha(96);
      break;
      label369: localPaint3.setColor(-16777216);
    }
  }

  public final void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("Torch ");
    if (paramBoolean);
    for (String str = "ON"; ; str = "OFF")
    {
      localStringBuilder.append(str).toString();
      this.a = paramBoolean;
      return;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     io.card.payment.ae
 * JD-Core Version:    0.6.2
 */