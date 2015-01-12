package com.ubercab.client.core.model;

public final class TunesProvider
{
  public static final String PROVIDER_SPOTIFY = "spotify";
  String access_token;
  Long access_token_expiry;
  String id;
  Boolean linked;
  String name;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TunesProvider localTunesProvider;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTunesProvider = (TunesProvider)paramObject;
      if (this.access_token != null)
      {
        if (this.access_token.equals(localTunesProvider.access_token));
      }
      else
        while (localTunesProvider.access_token != null)
          return false;
      if (this.access_token_expiry != null)
      {
        if (this.access_token_expiry.equals(localTunesProvider.access_token_expiry));
      }
      else
        while (localTunesProvider.access_token_expiry != null)
          return false;
      if (this.id != null)
      {
        if (this.id.equals(localTunesProvider.id));
      }
      else
        while (localTunesProvider.id != null)
          return false;
      if (this.linked != null)
      {
        if (this.linked.equals(localTunesProvider.linked));
      }
      else
        while (localTunesProvider.linked != null)
          return false;
      if (this.name == null)
        break;
    }
    while (this.name.equals(localTunesProvider.name));
    while (true)
    {
      return false;
      if (localTunesProvider.name == null)
        break;
    }
  }

  public String getAccessToken()
  {
    return this.access_token;
  }

  public Long getAccessTokenExpiry()
  {
    return this.access_token_expiry;
  }

  public String getId()
  {
    return this.id;
  }

  public Boolean getLinked()
  {
    return this.linked;
  }

  public String getName()
  {
    return this.name;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i1;
    if (this.id != null)
    {
      i = this.id.hashCode();
      int j = i * 31;
      if (this.name == null)
        break label129;
      k = this.name.hashCode();
      int m = 31 * (j + k);
      if (this.linked == null)
        break label134;
      n = this.linked.hashCode();
      i1 = 31 * (m + n);
      if (this.access_token == null)
        break label140;
    }
    label129: label134: label140: for (int i2 = this.access_token.hashCode(); ; i2 = 0)
    {
      int i3 = 31 * (i1 + i2);
      Long localLong = this.access_token_expiry;
      int i4 = 0;
      if (localLong != null)
        i4 = this.access_token_expiry.hashCode();
      return i3 + i4;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.TunesProvider
 * JD-Core Version:    0.6.2
 */