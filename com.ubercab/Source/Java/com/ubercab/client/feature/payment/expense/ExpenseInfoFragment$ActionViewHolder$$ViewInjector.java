package com.ubercab.client.feature.payment.expense;

import android.view.View;
import android.view.View.OnClickListener;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberTextView;

public class ExpenseInfoFragment$ActionViewHolder$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, ExpenseInfoFragment.ActionViewHolder paramActionViewHolder, Object paramObject)
  {
    paramActionViewHolder.textViewSave = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427550, "field 'textViewSave'"));
    paramActionViewHolder.textViewCancel = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427548, "field 'textViewCancel'"));
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427549, "field 'actionButtonSave' and method 'onSaveClicked'");
    paramActionViewHolder.actionButtonSave = localView1;
    localView1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onSaveClicked();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427547, "field 'actionButtonCancel' and method 'onCancelClicked'");
    paramActionViewHolder.actionButtonCancel = localView2;
    localView2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onCancelClicked();
      }
    });
  }

  public static void reset(ExpenseInfoFragment.ActionViewHolder paramActionViewHolder)
  {
    paramActionViewHolder.textViewSave = null;
    paramActionViewHolder.textViewCancel = null;
    paramActionViewHolder.actionButtonSave = null;
    paramActionViewHolder.actionButtonCancel = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.expense.ExpenseInfoFragment.ActionViewHolder..ViewInjector
 * JD-Core Version:    0.6.2
 */