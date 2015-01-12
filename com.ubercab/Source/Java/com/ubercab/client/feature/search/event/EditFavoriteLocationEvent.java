package com.ubercab.client.feature.search.event;

public final class EditFavoriteLocationEvent
{
  private int mPosition;
  private String mTag;

  public EditFavoriteLocationEvent(String paramString, int paramInt)
  {
    this.mTag = paramString;
    this.mPosition = paramInt;
  }

  public int getPosition()
  {
    return this.mPosition;
  }

  public String getTag()
  {
    return this.mTag;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.event.EditFavoriteLocationEvent
 * JD-Core Version:    0.6.2
 */