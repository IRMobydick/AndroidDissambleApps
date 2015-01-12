package com.ubercab.client.feature.music;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class MusicTrayView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, MusicTrayView paramMusicTrayView, Object paramObject)
  {
    paramMusicTrayView.mImageViewLeft = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427531, "field 'mImageViewLeft'"));
    paramMusicTrayView.mImageViewRight = ((ImageView)paramFinder.findRequiredView(paramObject, 2131427533, "field 'mImageViewRight'"));
    paramMusicTrayView.mTextViewTray = ((TextView)paramFinder.findRequiredView(paramObject, 2131427532, "field 'mTextViewTray'"));
    paramFinder.findRequiredView(paramObject, 2131427530, "method 'onClickMusicTray'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickMusicTray();
      }
    });
  }

  public static void reset(MusicTrayView paramMusicTrayView)
  {
    paramMusicTrayView.mImageViewLeft = null;
    paramMusicTrayView.mImageViewRight = null;
    paramMusicTrayView.mTextViewTray = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicTrayView..ViewInjector
 * JD-Core Version:    0.6.2
 */