package com.ubercab.client.feature.search.event;

public final class GetLocationDetailsEvent
{
  private String mReference;
  private String mType;

  public GetLocationDetailsEvent(String paramString1, String paramString2)
  {
    this.mReference = paramString1;
    this.mType = paramString2;
  }

  public String getReference()
  {
    return this.mReference;
  }

  public String getType()
  {
    return this.mType;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.feature.search.event.GetLocationDetailsEvent
 * JD-Core Version:    0.6.2
 */