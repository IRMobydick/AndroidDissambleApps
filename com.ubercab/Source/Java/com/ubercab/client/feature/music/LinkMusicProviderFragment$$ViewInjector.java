package com.ubercab.client.feature.music;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;

public class LinkMusicProviderFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, LinkMusicProviderFragment paramLinkMusicProviderFragment, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427520, "field 'mButtonLinkProvider' and method 'onClickLinkProvider'");
    paramLinkMusicProviderFragment.mButtonLinkProvider = ((UberButton)localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickLinkProvider();
      }
    });
  }

  public static void reset(LinkMusicProviderFragment paramLinkMusicProviderFragment)
  {
    paramLinkMusicProviderFragment.mButtonLinkProvider = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.LinkMusicProviderFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */