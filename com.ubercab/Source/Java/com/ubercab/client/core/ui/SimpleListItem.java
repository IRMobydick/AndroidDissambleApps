package com.ubercab.client.core.ui;

public final class SimpleListItem
{
  private final int mId;
  private final String mTitle;

  public SimpleListItem(int paramInt, String paramString)
  {
    this.mId = paramInt;
    this.mTitle = paramString;
  }

  public int getId()
  {
    return this.mId;
  }

  public String getTitle()
  {
    return this.mTitle;
  }

  public String toString()
  {
    return this.mTitle;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.ui.SimpleListItem
 * JD-Core Version:    0.6.2
 */