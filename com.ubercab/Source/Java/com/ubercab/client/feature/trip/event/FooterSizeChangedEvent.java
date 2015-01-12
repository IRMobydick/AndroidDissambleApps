package com.ubercab.client.feature.trip.event;

public final class FooterSizeChangedEvent
{
  private final boolean mIsOptionsBarVisible;
  private final int mMaxHFooterHeight;
  private final int mMinFooterHeight;

  public FooterSizeChangedEvent(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mIsOptionsBarVisible = paramBoolean;
    this.mMinFooterHeight = paramInt1;
    this.mMaxHFooterHeight = paramInt2;
  }

  public int getMaxFooterHeight()
  {
    return this.mMaxHFooterHeight;
  }

  public int getMinFooterHeight()
  {
    return this.mMinFooterHeight;
  }

  public boolean isOptionsBarVisible()
  {
    return this.mIsOptionsBarVisible;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.trip.event.FooterSizeChangedEvent
 * JD-Core Version:    0.6.2
 */