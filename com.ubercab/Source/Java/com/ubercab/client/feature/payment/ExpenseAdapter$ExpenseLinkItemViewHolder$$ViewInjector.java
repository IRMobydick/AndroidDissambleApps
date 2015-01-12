package com.ubercab.client.feature.payment;

import android.widget.Switch;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class ExpenseAdapter$ExpenseLinkItemViewHolder$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, ExpenseAdapter.ExpenseLinkItemViewHolder paramExpenseLinkItemViewHolder, Object paramObject)
  {
    paramExpenseLinkItemViewHolder.mTextViewExpense = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427642, "field 'mTextViewExpense'"));
    paramExpenseLinkItemViewHolder.mSwitchSendToExpense = ((Switch)paramFinder.findRequiredView(paramObject, 2131427643, "field 'mSwitchSendToExpense'"));
  }

  public static void reset(ExpenseAdapter.ExpenseLinkItemViewHolder paramExpenseLinkItemViewHolder)
  {
    paramExpenseLinkItemViewHolder.mTextViewExpense = null;
    paramExpenseLinkItemViewHolder.mSwitchSendToExpense = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.ExpenseAdapter.ExpenseLinkItemViewHolder..ViewInjector
 * JD-Core Version:    0.6.2
 */