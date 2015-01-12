package com.ubercab.client.feature.music.overlay;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;

public class AddMusicOverlayView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, AddMusicOverlayView paramAddMusicOverlayView, Object paramObject)
  {
    paramFinder.findRequiredView(paramObject, 2131427527, "method 'onClickMusicOverlay'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickMusicOverlay();
      }
    });
  }

  public static void reset(AddMusicOverlayView paramAddMusicOverlayView)
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.overlay.AddMusicOverlayView..ViewInjector
 * JD-Core Version:    0.6.2
 */