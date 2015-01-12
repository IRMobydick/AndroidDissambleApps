package com.ubercab.client.feature.payment;

import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class EditCreditCardFragment$ActionViewHolder$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, EditCreditCardFragment.ActionViewHolder paramActionViewHolder, Object paramObject)
  {
    paramActionViewHolder.textViewSave = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427550, "field 'textViewSave'"));
    paramActionViewHolder.textViewCancel = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427548, "field 'textViewCancel'"));
    paramActionViewHolder.actionButtonSave = paramFinder.findRequiredView(paramObject, 2131427549, "field 'actionButtonSave'");
    paramActionViewHolder.actionButtonCancel = paramFinder.findRequiredView(paramObject, 2131427547, "field 'actionButtonCancel'");
  }

  public static void reset(EditCreditCardFragment.ActionViewHolder paramActionViewHolder)
  {
    paramActionViewHolder.textViewSave = null;
    paramActionViewHolder.textViewCancel = null;
    paramActionViewHolder.actionButtonSave = null;
    paramActionViewHolder.actionButtonCancel = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.EditCreditCardFragment.ActionViewHolder..ViewInjector
 * JD-Core Version:    0.6.2
 */