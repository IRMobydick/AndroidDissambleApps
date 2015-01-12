package com.ubercab.client.feature.trip.dispatch;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import butterknife.ButterKnife.Finder;

public class CancelView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, CancelView paramCancelView, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427854, "field 'mButtonCancel' and method 'onTouchButtonCancel'");
    paramCancelView.mButtonCancel = ((ImageButton)localView);
    localView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return this.val$target.onTouchButtonCancel(paramAnonymousMotionEvent);
      }
    });
  }

  public static void reset(CancelView paramCancelView)
  {
    paramCancelView.mButtonCancel = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.dispatch.CancelView..ViewInjector
 * JD-Core Version:    0.6.2
 */