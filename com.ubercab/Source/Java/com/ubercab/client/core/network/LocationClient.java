package com.ubercab.client.core.network;

public abstract interface LocationClient
{
  public abstract void addOrModifyTagWithProphecyReference(String paramString1, String paramString2, String paramString3);

  public abstract void addOrModifyTagWithScavengerId(String paramString1, String paramString2);

  public abstract void autocomplete(double paramDouble1, double paramDouble2, String paramString);

  public abstract void deleteTag(String paramString);

  public abstract void details(String paramString1, String paramString2);

  public abstract void frequentLocations();

  public abstract void history(double paramDouble1, double paramDouble2);

  public abstract void search(double paramDouble1, double paramDouble2, String paramString);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.LocationClient
 * JD-Core Version:    0.6.2
 */