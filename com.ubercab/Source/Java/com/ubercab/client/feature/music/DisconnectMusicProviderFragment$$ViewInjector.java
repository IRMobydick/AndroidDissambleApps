package com.ubercab.client.feature.music;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberButton;

public class DisconnectMusicProviderFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, DisconnectMusicProviderFragment paramDisconnectMusicProviderFragment, Object paramObject)
  {
    View localView = paramFinder.findRequiredView(paramObject, 2131427513, "field 'mButtonDisconnect' and method 'onClickDisconnect'");
    paramDisconnectMusicProviderFragment.mButtonDisconnect = ((UberButton)localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickDisconnect();
      }
    });
    paramDisconnectMusicProviderFragment.mTextViewName = ((TextView)paramFinder.findRequiredView(paramObject, 2131427512, "field 'mTextViewName'"));
  }

  public static void reset(DisconnectMusicProviderFragment paramDisconnectMusicProviderFragment)
  {
    paramDisconnectMusicProviderFragment.mButtonDisconnect = null;
    paramDisconnectMusicProviderFragment.mTextViewName = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.DisconnectMusicProviderFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */