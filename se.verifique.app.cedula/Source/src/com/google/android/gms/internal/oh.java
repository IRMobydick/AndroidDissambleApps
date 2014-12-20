package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ViewSwitcher;

final class oh extends ViewSwitcher
{
  private final hb a;

  public oh(Context paramContext)
  {
    super(paramContext);
    this.a = new hb(paramContext);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.a(paramMotionEvent);
    return false;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.oh
 * JD-Core Version:    0.6.0
 */