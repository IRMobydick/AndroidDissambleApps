package com.ubercab.library.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

public final class KeyboardUtils
{
  public static void hideKeyboard(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.getWindow() == null) || (paramActivity.getWindow().getDecorView() == null))
      return;
    hideKeyboard(paramActivity, paramActivity.getWindow().getDecorView());
  }

  public static void hideKeyboard(Context paramContext, View paramView)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    if ((localInputMethodManager != null) && (paramView != null))
      localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }

  public static void showKeyboard(Context paramContext)
  {
    ((InputMethodManager)paramContext.getSystemService("input_method")).toggleSoftInput(2, 0);
  }

  public static void showKeyboard(Context paramContext, View paramView)
  {
    showKeyboard(paramContext);
    if (paramView != null)
      paramView.requestFocus();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.util.KeyboardUtils
 * JD-Core Version:    0.6.2
 */