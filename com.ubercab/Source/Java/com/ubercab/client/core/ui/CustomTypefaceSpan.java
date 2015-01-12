package com.ubercab.client.core.ui;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class CustomTypefaceSpan extends MetricAffectingSpan
{
  private final Context mContext;
  private final Typeface mTypeface;

  public CustomTypefaceSpan(Context paramContext, Typeface paramTypeface)
  {
    this.mContext = paramContext;
    this.mTypeface = paramTypeface;
  }

  private void apply(Paint paramPaint, Typeface paramTypeface)
  {
    Typeface localTypeface = paramPaint.getTypeface();
    if (localTypeface == null);
    for (int i = 0; ; i = localTypeface.getStyle())
    {
      int j = i & (0xFFFFFFFF ^ paramTypeface.getStyle());
      if ((j & 0x1) != 0)
        paramPaint.setFakeBoldText(true);
      if ((j & 0x2) != 0)
        paramPaint.setTextSkewX(-0.25F);
      paramPaint.setTypeface(paramTypeface);
      return;
    }
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    apply(paramTextPaint, this.mTypeface);
  }

  public void updateMeasureState(TextPaint paramTextPaint)
  {
    apply(paramTextPaint, this.mTypeface);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.CustomTypefaceSpan
 * JD-Core Version:    0.6.2
 */