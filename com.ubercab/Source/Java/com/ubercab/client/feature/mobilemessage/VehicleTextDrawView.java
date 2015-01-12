package com.ubercab.client.feature.mobilemessage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;
import com.ubercab.client.feature.trip.slider.VehicleTextBitmap;

public class VehicleTextDrawView extends View
{
  private final Paint mPaint = new Paint();
  private final int mRectPadding;
  private final VehicleTextBitmap mTextBitmap;

  public VehicleTextDrawView(Context paramContext, VehicleTextBitmap paramVehicleTextBitmap)
  {
    super(paramContext);
    this.mTextBitmap = paramVehicleTextBitmap;
    this.mRectPadding = paramContext.getResources().getDimensionPixelSize(2131361898);
    this.mPaint.setColor(-1);
    this.mPaint.setStrokeWidth(paramContext.getResources().getDimensionPixelSize(2131361899));
    this.mPaint.setStyle(Paint.Style.STROKE);
  }

  public void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.mTextBitmap.getBitmap(), this.mTextBitmap.getX(), this.mTextBitmap.getY(), null);
    paramCanvas.drawRect(this.mTextBitmap.getX() - this.mRectPadding, this.mTextBitmap.getY() - this.mRectPadding, this.mTextBitmap.getX() + this.mTextBitmap.getBitmap().getWidth() + this.mRectPadding, this.mTextBitmap.getY() + this.mTextBitmap.getBitmap().getHeight() + this.mRectPadding, this.mPaint);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.mobilemessage.VehicleTextDrawView
 * JD-Core Version:    0.6.2
 */