package com.ubercab.client.feature.payment.expense;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import com.ubercab.ui.UberEditText;
import com.ubercab.ui.UberTextView;

public class ExpenseInfoFragment$$ViewInjector
{
  public static void inject(ButterKnife.Finder paramFinder, ExpenseInfoFragment paramExpenseInfoFragment, Object paramObject)
  {
    View localView1 = paramFinder.findRequiredView(paramObject, 2131427563, "field 'mEditTextCode' and method 'onExpenseCodeTextChanged'");
    paramExpenseInfoFragment.mEditTextCode = ((UberEditText)localView1);
    ((TextView)localView1).addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.val$target.onExpenseCodeTextChanged();
      }
    });
    View localView2 = paramFinder.findRequiredView(paramObject, 2131427564, "field 'mEditTextMemo' and method 'onExpenseMemoTextChanged'");
    paramExpenseInfoFragment.mEditTextMemo = ((UberEditText)localView2);
    ((TextView)localView2).addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        this.val$target.onExpenseMemoTextChanged();
      }
    });
    paramExpenseInfoFragment.mTextExpenseInfoDescription = ((UberTextView)paramFinder.findRequiredView(paramObject, 2131427562, "field 'mTextExpenseInfoDescription'"));
    View localView3 = paramFinder.findRequiredView(paramObject, 2131427565, "field 'mTextUseLastExpenseInfo' and method 'onUseLastExpenseInfoClicked'");
    paramExpenseInfoFragment.mTextUseLastExpenseInfo = ((UberTextView)localView3);
    localView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        this.val$target.onUseLastExpenseInfoClicked();
      }
    });
  }

  public static void reset(ExpenseInfoFragment paramExpenseInfoFragment)
  {
    paramExpenseInfoFragment.mEditTextCode = null;
    paramExpenseInfoFragment.mEditTextMemo = null;
    paramExpenseInfoFragment.mTextExpenseInfoDescription = null;
    paramExpenseInfoFragment.mTextUseLastExpenseInfo = null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.expense.ExpenseInfoFragment..ViewInjector
 * JD-Core Version:    0.6.2
 */