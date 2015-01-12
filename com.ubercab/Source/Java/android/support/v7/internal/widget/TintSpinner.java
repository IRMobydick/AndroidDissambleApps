package android.support.v7.internal.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.Spinner;

public class TintSpinner extends Spinner
{
  private static final int[] TINT_ATTRS = { 16842964, 16843126 };

  public TintSpinner(Context paramContext)
  {
    this(paramContext, null);
  }

  public TintSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842881);
  }

  public TintSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, TINT_ATTRS, paramInt, 0);
    setBackgroundDrawable(localTintTypedArray.getDrawable(0));
    if ((Build.VERSION.SDK_INT >= 16) && (localTintTypedArray.hasValue(1)))
      setPopupBackgroundDrawable(localTintTypedArray.getDrawable(1));
    localTintTypedArray.recycle();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintSpinner
 * JD-Core Version:    0.6.2
 */