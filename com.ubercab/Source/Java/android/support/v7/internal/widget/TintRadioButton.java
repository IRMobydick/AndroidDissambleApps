package android.support.v7.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class TintRadioButton extends RadioButton
{
  private static final int[] TINT_ATTRS = { 16843015 };
  private final TintManager mTintManager;

  public TintRadioButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public TintRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842878);
  }

  public TintRadioButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, TINT_ATTRS, paramInt, 0);
    setButtonDrawable(localTintTypedArray.getDrawable(0));
    localTintTypedArray.recycle();
    this.mTintManager = localTintTypedArray.getTintManager();
  }

  public void setButtonDrawable(int paramInt)
  {
    setButtonDrawable(this.mTintManager.getDrawable(paramInt));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintRadioButton
 * JD-Core Version:    0.6.2
 */