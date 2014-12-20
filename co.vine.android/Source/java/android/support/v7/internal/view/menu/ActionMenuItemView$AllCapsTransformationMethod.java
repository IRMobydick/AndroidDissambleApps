package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

class ActionMenuItemView$AllCapsTransformationMethod
  implements TransformationMethod
{
  private Locale mLocale;

  public ActionMenuItemView$AllCapsTransformationMethod(ActionMenuItemView paramActionMenuItemView)
  {
    this.mLocale = paramActionMenuItemView.getContext().getResources().getConfiguration().locale;
  }

  public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    if (paramCharSequence != null);
    for (String str = paramCharSequence.toString().toUpperCase(this.mLocale); ; str = null)
      return str;
  }

  public void onFocusChanged(View paramView, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, Rect paramRect)
  {
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuItemView.AllCapsTransformationMethod
 * JD-Core Version:    0.6.0
 */