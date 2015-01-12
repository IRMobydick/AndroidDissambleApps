package com.ubercab.client.feature.trip.slider;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.util.AttributeSet;
import android.view.View;
import com.ubercab.R.styleable;

public class ArrowView extends View
{
  private static final int STROKE_WIDTH = 1;
  private final int mBgColor;
  private final int mFgColor;
  private Paint mPaintBg;
  private Paint mPaintBorder;
  private Paint mPaintFg;
  private final Path mPathFill = new Path();
  private final Path mPathStroke = new Path();
  private final int mStrokeColor;

  public ArrowView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ArrowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ArrowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ArrowView);
    try
    {
      Resources localResources = getResources();
      this.mBgColor = localTypedArray.getColor(1, localResources.getColor(2131296343));
      this.mFgColor = localTypedArray.getColor(0, localResources.getColor(2131296348));
      this.mStrokeColor = localTypedArray.getColor(2, localResources.getColor(2131296347));
      localTypedArray.recycle();
      this.mPaintBg = new Paint();
      this.mPaintBg.setColor(this.mBgColor);
      this.mPaintBg.setStyle(Paint.Style.FILL);
      this.mPaintFg = new Paint();
      this.mPaintFg.setColor(this.mFgColor);
      this.mPaintBg.setStyle(Paint.Style.FILL);
      this.mPaintBorder = new Paint();
      this.mPaintBorder.setColor(this.mStrokeColor);
      this.mPaintBorder.setStyle(Paint.Style.STROKE);
      this.mPaintBorder.setStrokeWidth(1.0F);
      this.mPaintBorder.setAntiAlias(true);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = getWidth();
    float f2 = getHeight();
    if ((f1 == 0.0F) || (f2 == 0.0F))
      return;
    this.mPathFill.reset();
    this.mPathFill.setFillType(Path.FillType.EVEN_ODD);
    this.mPathFill.moveTo(0.0F, 0.0F);
    this.mPathFill.lineTo(f1, f2 / 2.0F);
    this.mPathFill.lineTo(0.0F, f2);
    this.mPathFill.close();
    this.mPathStroke.reset();
    this.mPathStroke.setFillType(Path.FillType.EVEN_ODD);
    this.mPathStroke.moveTo(0.0F, 0.0F);
    this.mPathStroke.lineTo(f1, f2 / 2.0F);
    this.mPathStroke.lineTo(0.0F, f2);
    paramCanvas.drawPaint(this.mPaintBg);
    paramCanvas.drawPath(this.mPathFill, this.mPaintFg);
    paramCanvas.drawPath(this.mPathStroke, this.mPaintBorder);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.ArrowView
 * JD-Core Version:    0.6.2
 */