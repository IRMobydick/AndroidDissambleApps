package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.View;

@TargetApi(11)
public class NativeActionModeAwareLayout extends ContentFrameLayout
{
  private OnActionModeForChildListener mActionModeForChildListener;

  public NativeActionModeAwareLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void setActionModeForChildListener(OnActionModeForChildListener paramOnActionModeForChildListener)
  {
    this.mActionModeForChildListener = paramOnActionModeForChildListener;
  }

  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    if (this.mActionModeForChildListener != null)
      return this.mActionModeForChildListener.startActionModeForChild(paramView, paramCallback);
    return super.startActionModeForChild(paramView, paramCallback);
  }

  public static abstract interface OnActionModeForChildListener
  {
    public abstract ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.NativeActionModeAwareLayout
 * JD-Core Version:    0.6.2
 */