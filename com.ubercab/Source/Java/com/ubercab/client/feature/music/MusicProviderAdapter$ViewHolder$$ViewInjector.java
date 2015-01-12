package com.ubercab.client.feature.music;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;

public class MusicProviderAdapter$ViewHolder$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, MusicProviderAdapter.ViewHolder paramViewHolder, Object paramObject)
  {
    paramViewHolder.mTextViewStatus = ((TextView)paramFinder.findRequiredView(paramObject, 2131427669, "field 'mTextViewStatus'"));
    paramFinder.findRequiredView(paramObject, 2131427668, "method 'onClickProvider'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickProvider();
      }
    });
  }

  public static void reset(MusicProviderAdapter.ViewHolder paramViewHolder)
  {
    paramViewHolder.mTextViewStatus = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.music.MusicProviderAdapter.ViewHolder..ViewInjector
 * JD-Core Version:    0.6.2
 */