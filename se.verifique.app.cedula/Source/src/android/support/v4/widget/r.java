package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class r extends ViewGroup.MarginLayoutParams
{
  private static final int[] e;
  public float a = 0.0F;
  boolean b;
  boolean c;
  Paint d;

  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 16843137;
    e = arrayOfInt;
  }

  public r()
  {
    super(-1, -1);
  }

  public r(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, e);
    this.a = localTypedArray.getFloat(0, 0.0F);
    localTypedArray.recycle();
  }

  public r(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }

  public r(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.r
 * JD-Core Version:    0.6.0
 */