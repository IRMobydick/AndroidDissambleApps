package com.ubercab.ui;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.widget.EditText;

public class UberEditText extends EditText
{
  private static final int[] STATE_ERROR_HIGHLIGHT = arrayOfInt;
  private boolean mHighlighted;
  private AutoDisableErrorHighlightWatcher mWatcher;

  static
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = R.attr.state_error_highlight;
  }

  public UberEditText(Context paramContext)
  {
    this(paramContext, null);
  }

  public UberEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842862);
  }

  public UberEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected AutoDisableErrorHighlightWatcher getWatcher()
  {
    return this.mWatcher;
  }

  boolean isErrorHighlighted()
  {
    return this.mHighlighted;
  }

  protected int[] onCreateDrawableState(int paramInt)
  {
    if (this.mHighlighted)
    {
      int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
      mergeDrawableStates(arrayOfInt, STATE_ERROR_HIGHLIGHT);
      return arrayOfInt;
    }
    return super.onCreateDrawableState(paramInt);
  }

  public void setErrorHighlight(boolean paramBoolean)
  {
    if (this.mHighlighted != paramBoolean)
    {
      this.mHighlighted = paramBoolean;
      if (!this.mHighlighted)
        break label46;
      this.mWatcher = new AutoDisableErrorHighlightWatcher(null);
      addTextChangedListener(this.mWatcher);
    }
    while (true)
    {
      refreshDrawableState();
      return;
      label46: removeTextChangedListener(this.mWatcher);
      this.mWatcher = null;
    }
  }

  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      setFocusable(true);
      setFocusableInTouchMode(true);
      return;
    }
    setFocusable(false);
    setFocusableInTouchMode(false);
  }

  private class AutoDisableErrorHighlightWatcher extends TextWatcherAdapter
  {
    private AutoDisableErrorHighlightWatcher()
    {
    }

    public void afterTextChanged(Editable paramEditable)
    {
      UberEditText.this.setErrorHighlight(false);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.ui.UberEditText
 * JD-Core Version:    0.6.2
 */