package com.ubercab.client.core.model;

public final class Session
{
  private String sessionHash;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Session localSession;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localSession = (Session)paramObject;
      if (this.sessionHash == null)
        break;
    }
    while (this.sessionHash.equals(localSession.sessionHash));
    while (true)
    {
      return false;
      if (localSession.sessionHash == null)
        break;
    }
  }

  public String getSessionHash()
  {
    return this.sessionHash;
  }

  public int hashCode()
  {
    if (this.sessionHash != null)
      return this.sessionHash.hashCode();
    return 0;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.Session
 * JD-Core Version:    0.6.2
 */