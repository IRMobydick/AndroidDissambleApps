package com.ubercab.client.feature.about;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class AboutFragment$HeaderViewHolder$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, AboutFragment.HeaderViewHolder paramHeaderViewHolder, Object paramObject)
  {
    paramHeaderViewHolder.mTextViewTitle = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427420, "field 'mTextViewTitle'"));
    paramFinder.findRequiredView(paramObject, 2131427421, "method 'onClickUberUrl'").setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onClickUberUrl();
      }
    });
  }

  public static void reset(AboutFragment.HeaderViewHolder paramHeaderViewHolder)
  {
    paramHeaderViewHolder.mTextViewTitle = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.about.AboutFragment.HeaderViewHolder..ViewInjector
 * JD-Core Version:    0.6.2
 */