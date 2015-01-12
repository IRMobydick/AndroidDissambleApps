package com.ubercab.client.feature.share;

import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class ShareFragment$HeaderViewHolder$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, ShareFragment.HeaderViewHolder paramHeaderViewHolder, Object paramObject)
  {
    paramHeaderViewHolder.mTextViewCode = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427703, "field 'mTextViewCode'"));
    paramHeaderViewHolder.mTextViewDescription = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427702, "field 'mTextViewDescription'"));
    paramHeaderViewHolder.mTextViewSectionHeader = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427928, "field 'mTextViewSectionHeader'"));
  }

  public static void reset(ShareFragment.HeaderViewHolder paramHeaderViewHolder)
  {
    paramHeaderViewHolder.mTextViewCode = null;
    paramHeaderViewHolder.mTextViewDescription = null;
    paramHeaderViewHolder.mTextViewSectionHeader = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.share.ShareFragment.HeaderViewHolder..ViewInjector
 * JD-Core Version:    0.6.2
 */