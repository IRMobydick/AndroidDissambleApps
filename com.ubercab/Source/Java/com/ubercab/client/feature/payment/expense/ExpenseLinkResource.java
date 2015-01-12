package com.ubercab.client.feature.payment.expense;

public final class ExpenseLinkResource
{
  private final int mDrawableIcon;
  private final int mDrawableListIcon;
  private final String mLocalizedText;

  public ExpenseLinkResource(int paramInt1, int paramInt2, String paramString)
  {
    this.mLocalizedText = paramString;
    this.mDrawableListIcon = paramInt2;
    this.mDrawableIcon = paramInt1;
  }

  public int getDrawableIcon()
  {
    return this.mDrawableIcon;
  }

  public int getDrawableListIcon()
  {
    return this.mDrawableListIcon;
  }

  public String getLocalizedText()
  {
    return this.mLocalizedText;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.payment.expense.ExpenseLinkResource
 * JD-Core Version:    0.6.2
 */