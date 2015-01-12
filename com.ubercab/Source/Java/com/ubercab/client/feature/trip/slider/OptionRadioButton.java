package com.ubercab.client.feature.trip.slider;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class OptionRadioButton extends RadioButton
{
  private Drawable mDrawableSurge;
  private int mIconPadding;
  private boolean mIsSurging;
  private int[] mStateSet;
  private String mVehicleViewId;

  public OptionRadioButton(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public OptionRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  public OptionRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void addSurgeIcon(Canvas paramCanvas)
  {
    float f1 = getPaint().measureText(getText().toString());
    Drawable localDrawable = this.mDrawableSurge;
    if (isChecked());
    for (int[] arrayOfInt = this.mStateSet; ; arrayOfInt = null)
    {
      localDrawable.setState(arrayOfInt);
      this.mDrawableSurge.setBounds(0, 0, this.mDrawableSurge.getIntrinsicWidth(), this.mDrawableSurge.getIntrinsicHeight());
      float f2 = paramCanvas.getWidth() / 2.0F - f1 / 2.0F - this.mDrawableSurge.getIntrinsicWidth() - this.mIconPadding;
      float f3 = getHeight() / 2.0F - this.mDrawableSurge.getIntrinsicHeight() / 2.0F;
      paramCanvas.translate(Math.round(f2), Math.round(f3));
      this.mDrawableSurge.draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
  }

  private void init()
  {
    this.mStateSet = new int[] { 16842912 };
    this.mDrawableSurge = getResources().getDrawable(2130837921);
    this.mIconPadding = getResources().getDimensionPixelSize(2131362021);
  }

  int getLeftEdge()
  {
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    return arrayOfInt[0];
  }

  String getVehicleViewId()
  {
    return this.mVehicleViewId;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mIsSurging)
      addSurgeIcon(paramCanvas);
  }

  void setIsSurging(boolean paramBoolean)
  {
    this.mIsSurging = paramBoolean;
  }

  void setVehicleViewId(String paramString)
  {
    this.mVehicleViewId = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.slider.OptionRadioButton
 * JD-Core Version:    0.6.2
 */