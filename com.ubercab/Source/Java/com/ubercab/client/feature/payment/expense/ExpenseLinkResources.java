package com.ubercab.client.feature.payment.expense;

import android.content.Context;

public final class ExpenseLinkResources
{
  private final ExpenseLinkResource mConcurResource;

  public ExpenseLinkResources(Context paramContext)
  {
    this.mConcurResource = new ExpenseLinkResource(2130837681, 2130837682, paramContext.getString(2131559050));
  }

  public ExpenseLinkResource getResource(String paramString)
  {
    if (ExpenseLink.CONCUR.getTypeName().equals(paramString))
      return this.mConcurResource;
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.expense.ExpenseLinkResources
 * JD-Core Version:    0.6.2
 */