package com.ubercab.client.feature.trip.slider;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.ubercab.ui.FontUtils;
import java.util.ArrayList;
import java.util.List;

public class VehicleLabelBar extends View
{
  private Drawable mDrawableSurge = getResources().getDrawable(2130837792);
  private Listener mListener;
  private Paint mPaintText;
  private Paint mPaintTextDisabled;
  private Rect mTextBounds;
  private List<VehicleViewGroup> mVehicleViewGroups;

  public VehicleLabelBar(Context paramContext)
  {
    this(paramContext, null);
  }

  public VehicleLabelBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public VehicleLabelBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mDrawableSurge.setBounds(0, 0, this.mDrawableSurge.getIntrinsicWidth(), this.mDrawableSurge.getIntrinsicHeight());
    int i = getResources().getDimensionPixelSize(2131362011);
    int j = getResources().getColor(2131296329);
    int k = getResources().getColor(2131296328);
    this.mTextBounds = new Rect();
    this.mPaintText = new TextPaint();
    this.mPaintText.setTextSize(i);
    this.mPaintText.setAntiAlias(true);
    this.mPaintText.setColor(j);
    this.mPaintText.getTextBounds("W", 0, 1, this.mTextBounds);
    Typeface localTypeface = FontUtils.getTypefaceFromResource(paramContext, 2131559279);
    this.mPaintText.setTypeface(localTypeface);
    this.mPaintTextDisabled = new Paint(this.mPaintText);
    this.mPaintTextDisabled.setColor(k);
  }

  private VehicleTextBitmap drawVehicleView(VehicleViewGroup paramVehicleViewGroup, Canvas paramCanvas, int paramInt, float paramFloat)
  {
    boolean bool = paramVehicleViewGroup.isSurging();
    String str = paramVehicleViewGroup.getDescription();
    Paint localPaint1;
    Paint localPaint2;
    int j;
    float f1;
    float f2;
    if (paramVehicleViewGroup.isAvailable())
    {
      localPaint1 = this.mPaintText;
      localPaint2 = new Paint(localPaint1);
      int i = this.mDrawableSurge.getIntrinsicWidth();
      j = this.mDrawableSurge.getIntrinsicHeight();
      f1 = paramFloat;
      f2 = 0.0F;
      if (bool)
      {
        f1 -= i;
        f2 = 0.0F + i;
      }
    }
    while (true)
    {
      float f3 = localPaint2.measureText(str);
      float f4 = f3 + f2;
      float f5 = paramInt - f4 / 2.0F;
      if ((f5 < 0.0F) || (f5 > getWidth() - f4));
      for (int k = 1; ; k = 0)
      {
        if ((f3 > f1) || (k != 0))
          break label309;
        float f7 = getPaddingTop();
        float f8 = getPaddingBottom();
        float f9 = getHeight() - (f7 + f8);
        if (bool)
        {
          paramCanvas.save();
          float f10 = f7 + f9 / 2.0F - j / 2.0F;
          paramCanvas.translate(Math.round(paramInt - f4 / 2.0F), Math.round(f10));
          this.mDrawableSurge.draw(paramCanvas);
          paramCanvas.restore();
        }
        int m = (int)(f7 + f9 / 2.0F + this.mTextBounds.height() / 2.0F);
        paramCanvas.drawText(str, f5 + f2, m, localPaint2);
        return generateVehicleTextBitmap(paramVehicleViewGroup.getPrimaryVehicleId(), str, localPaint2, (int)(f5 + f2), m, (int)f3, 1 + (int)f9);
        localPaint1 = this.mPaintTextDisabled;
        break;
      }
      label309: float f6 = localPaint2.getTextSize() - 0.5F;
      if (f6 <= 0.0F)
        return null;
      localPaint2.setTextSize(f6);
    }
  }

  private VehicleTextBitmap generateVehicleTextBitmap(String paramString1, String paramString2, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
    TextPaint localTextPaint = new TextPaint(paramPaint);
    localTextPaint.setColor(-1);
    localCanvas.drawText(paramString2, 0.0F, paramInt4, localTextPaint);
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    return new VehicleTextBitmap(localBitmap, paramString2, paramString1, paramInt1 + arrayOfInt[0], paramInt2 + arrayOfInt[1] - paramInt4);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    ArrayList localArrayList = new ArrayList();
    float f1 = getPaddingLeft();
    float f2 = getWidth() - getPaddingLeft() - getPaddingRight();
    int i = this.mVehicleViewGroups.size();
    float f3 = f2 / i;
    for (int j = 0; j < i; j++)
    {
      VehicleViewGroup localVehicleViewGroup = (VehicleViewGroup)this.mVehicleViewGroups.get(j);
      int k = (int)(f1 + f2 / (i - 1.0F) * j);
      if (i == 1)
        k = (int)(f1 + f2 / 2.0F);
      VehicleTextBitmap localVehicleTextBitmap = drawVehicleView(localVehicleViewGroup, paramCanvas, k, f3);
      if (localVehicleTextBitmap != null)
        localArrayList.add(localVehicleTextBitmap);
    }
    if (this.mListener != null)
      this.mListener.onDrawVehicleBitmaps(localArrayList);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1) + getPaddingLeft() + getPaddingRight();
    int j = this.mTextBounds.height() + getPaddingTop() + getPaddingBottom();
    setMeasuredDimension(resolveSize(i, paramInt1), resolveSize(j, paramInt2));
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mListener != null)
      this.mListener.onVehicleLabelBarTouchEvent(this, paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }

  void setListener(Listener paramListener)
  {
    this.mListener = paramListener;
  }

  void setVehicleGroups(List<VehicleViewGroup> paramList)
  {
    this.mVehicleViewGroups = paramList;
    invalidate();
  }

  static abstract interface Listener
  {
    public abstract void onDrawVehicleBitmaps(List<VehicleTextBitmap> paramList);

    public abstract void onVehicleLabelBarTouchEvent(VehicleLabelBar paramVehicleLabelBar, MotionEvent paramMotionEvent);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.VehicleLabelBar
 * JD-Core Version:    0.6.2
 */