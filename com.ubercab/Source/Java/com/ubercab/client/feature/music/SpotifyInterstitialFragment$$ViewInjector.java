package com.ubercab.client.feature.music;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;

public class SpotifyInterstitialFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, SpotifyInterstitialFragment paramSpotifyInterstitialFragment, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427526, "field 'mButtonSpotifyAction' and method 'onSpotifyActionClick'");
    paramSpotifyInterstitialFragment.mButtonSpotifyAction = ((UberButton)localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onSpotifyActionClick();
      }
    });
  }

  public static void reset(SpotifyInterstitialFragment paramSpotifyInterstitialFragment)
  {
    paramSpotifyInterstitialFragment.mButtonSpotifyAction = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.SpotifyInterstitialFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */