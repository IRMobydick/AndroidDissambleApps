package com.ubercab.client.feature.payment.expense;

import android.text.TextUtils;

public enum ExpenseLink
{
  private final String typeName;

  static
  {
    ExpenseLink[] arrayOfExpenseLink = new ExpenseLink[1];
    arrayOfExpenseLink[0] = CONCUR;
  }

  private ExpenseLink(String paramString)
  {
    this.typeName = paramString;
  }

  public static boolean isValidExpenseLink(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    while (true)
    {
      return false;
      ExpenseLink[] arrayOfExpenseLink = values();
      int i = arrayOfExpenseLink.length;
      for (int j = 0; j < i; j++)
        if (arrayOfExpenseLink[j].getTypeName().equals(paramString))
          return true;
    }
  }

  public String getTypeName()
  {
    return this.typeName;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.expense.ExpenseLink
 * JD-Core Version:    0.6.2
 */