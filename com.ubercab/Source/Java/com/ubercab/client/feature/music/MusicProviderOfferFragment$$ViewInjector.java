package com.ubercab.client.feature.music;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;

public class MusicProviderOfferFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, MusicProviderOfferFragment paramMusicProviderOfferFragment, Object paramObject)
  {
    paramFinder.findRequiredView(paramObject, 2131427522, "method 'onClickLinkProvider'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickLinkProvider();
      }
    });
  }

  public static void reset(MusicProviderOfferFragment paramMusicProviderOfferFragment)
  {
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicProviderOfferFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */