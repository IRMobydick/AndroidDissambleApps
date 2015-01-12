package com.ubercab.client.feature.payment;

import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class ArrearsView$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, ArrearsView paramArrearsView, Object paramObject)
  {
    paramArrearsView.mTextViewArrearsAmount = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427646, "field 'mTextViewArrearsAmount'"));
    paramArrearsView.mTextViewArrearsMessage = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427645, "field 'mTextViewArrearsMessage'"));
  }

  public static void reset(ArrearsView paramArrearsView)
  {
    paramArrearsView.mTextViewArrearsAmount = null;
    paramArrearsView.mTextViewArrearsMessage = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.ArrearsView..ViewInjector
 * JD-Core Version:    0.6.2
 */