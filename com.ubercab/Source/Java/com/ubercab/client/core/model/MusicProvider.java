package com.ubercab.client.core.model;

public final class MusicProvider
{
  String id;
  Boolean linked;
  String name;

  public String getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public boolean isLinked()
  {
    if (this.linked == null)
      return false;
    return this.linked.booleanValue();
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setLinked(boolean paramBoolean)
  {
    this.linked = Boolean.valueOf(paramBoolean);
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.MusicProvider
 * JD-Core Version:    0.6.2
 */