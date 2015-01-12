package uk.co.chrisjenx.calligraphy;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class CalligraphyTypefaceSpan extends MetricAffectingSpan
{
  private final Typeface typeface;

  public CalligraphyTypefaceSpan(Typeface paramTypeface)
  {
    this.typeface = paramTypeface;
  }

  private void apply(Paint paramPaint)
  {
    Typeface localTypeface = paramPaint.getTypeface();
    if (localTypeface != null);
    for (int i = localTypeface.getStyle(); ; i = 0)
    {
      int j = i & (0xFFFFFFFF ^ this.typeface.getStyle());
      if ((j & 0x1) != 0)
        paramPaint.setFakeBoldText(true);
      if ((j & 0x2) != 0)
        paramPaint.setTextSkewX(-0.25F);
      paramPaint.setTypeface(this.typeface);
      return;
    }
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    apply(paramTextPaint);
  }

  public void updateMeasureState(TextPaint paramTextPaint)
  {
    apply(paramTextPaint);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     uk.co.chrisjenx.calligraphy.CalligraphyTypefaceSpan
 * JD-Core Version:    0.6.2
 */