package com.ubercab.client.feature.promo;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

class WindowCallbackWrapper
  implements Window.Callback
{
  private final Window.Callback mCallback;

  public WindowCallbackWrapper(Window.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }

  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return false;
  }

  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return false;
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public Window.Callback getOriginalCallback()
  {
    return this.mCallback;
  }

  public void onActionModeFinished(ActionMode paramActionMode)
  {
  }

  public void onActionModeStarted(ActionMode paramActionMode)
  {
  }

  public void onAttachedToWindow()
  {
  }

  public void onContentChanged()
  {
  }

  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return false;
  }

  public View onCreatePanelView(int paramInt)
  {
    return null;
  }

  public void onDetachedFromWindow()
  {
  }

  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return false;
  }

  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return false;
  }

  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
  }

  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return false;
  }

  public boolean onSearchRequested()
  {
    return false;
  }

  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
  }

  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.promo.WindowCallbackWrapper
 * JD-Core Version:    0.6.2
 */