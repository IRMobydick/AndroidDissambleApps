package com.ubercab.client.core.model;

public class ThirdPartyIdentity
{
  public static final String SPOTIFY = "spotify";
  private String id;
  private String token;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ThirdPartyIdentity localThirdPartyIdentity;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localThirdPartyIdentity = (ThirdPartyIdentity)paramObject;
      if (this.id != null)
      {
        if (this.id.equals(localThirdPartyIdentity.id));
      }
      else
        while (localThirdPartyIdentity.id != null)
          return false;
      if (this.token == null)
        break;
    }
    while (this.token.equals(localThirdPartyIdentity.token));
    while (true)
    {
      return false;
      if (localThirdPartyIdentity.token == null)
        break;
    }
  }

  public String getId()
  {
    return this.id;
  }

  public String getToken()
  {
    return this.token;
  }

  public int hashCode()
  {
    if (this.id != null);
    for (int i = this.id.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.token;
      int k = 0;
      if (str != null)
        k = this.token.hashCode();
      return j + k;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.ThirdPartyIdentity
 * JD-Core Version:    0.6.2
 */