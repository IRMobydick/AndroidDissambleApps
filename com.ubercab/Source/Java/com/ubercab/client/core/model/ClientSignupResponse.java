package com.ubercab.client.core.model;

public class ClientSignupResponse
{
  private String email;
  private String error;
  private String first_name;
  private String last_name;
  private String mobile;
  private String token;
  private String uuid;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ClientSignupResponse localClientSignupResponse;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localClientSignupResponse = (ClientSignupResponse)paramObject;
      if (this.email != null)
      {
        if (this.email.equals(localClientSignupResponse.email));
      }
      else
        while (localClientSignupResponse.email != null)
          return false;
      if (this.error != null)
      {
        if (this.error.equals(localClientSignupResponse.error));
      }
      else
        while (localClientSignupResponse.error != null)
          return false;
      if (this.first_name != null)
      {
        if (this.first_name.equals(localClientSignupResponse.first_name));
      }
      else
        while (localClientSignupResponse.first_name != null)
          return false;
      if (this.last_name != null)
      {
        if (this.last_name.equals(localClientSignupResponse.last_name));
      }
      else
        while (localClientSignupResponse.last_name != null)
          return false;
      if (this.mobile != null)
      {
        if (this.mobile.equals(localClientSignupResponse.mobile));
      }
      else
        while (localClientSignupResponse.mobile != null)
          return false;
      if (this.token != null)
      {
        if (this.token.equals(localClientSignupResponse.token));
      }
      else
        while (localClientSignupResponse.token != null)
          return false;
      if (this.uuid == null)
        break;
    }
    while (this.uuid.equals(localClientSignupResponse.uuid));
    while (true)
    {
      return false;
      if (localClientSignupResponse.uuid == null)
        break;
    }
  }

  public String getEmail()
  {
    return this.email;
  }

  public String getErrorMessage()
  {
    return this.error;
  }

  public String getFirstName()
  {
    return this.first_name;
  }

  public String getLastName()
  {
    return this.last_name;
  }

  public String getMobile()
  {
    return this.mobile;
  }

  public String getToken()
  {
    return this.token;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public int hashCode()
  {
    int i;
    int k;
    label35: int n;
    label59: int i2;
    label85: int i4;
    label111: int i5;
    if (this.error != null)
    {
      i = this.error.hashCode();
      int j = i * 31;
      if (this.uuid == null)
        break label181;
      k = this.uuid.hashCode();
      int m = 31 * (j + k);
      if (this.email == null)
        break label186;
      n = this.email.hashCode();
      int i1 = 31 * (m + n);
      if (this.mobile == null)
        break label192;
      i2 = this.mobile.hashCode();
      int i3 = 31 * (i1 + i2);
      if (this.first_name == null)
        break label198;
      i4 = this.first_name.hashCode();
      i5 = 31 * (i3 + i4);
      if (this.last_name == null)
        break label204;
    }
    label181: label186: label192: label198: label204: for (int i6 = this.last_name.hashCode(); ; i6 = 0)
    {
      int i7 = 31 * (i5 + i6);
      String str = this.token;
      int i8 = 0;
      if (str != null)
        i8 = this.token.hashCode();
      return i7 + i8;
      i = 0;
      break;
      k = 0;
      break label35;
      n = 0;
      break label59;
      i2 = 0;
      break label85;
      i4 = 0;
      break label111;
    }
  }

  public boolean isPending()
  {
    return (this.error != null) && (!this.error.isEmpty());
  }

  public void setEmail(String paramString)
  {
    this.email = paramString;
  }

  public void setErrorMessage(String paramString)
  {
    this.error = paramString;
  }

  public void setFirstName(String paramString)
  {
    this.first_name = paramString;
  }

  public void setLastName(String paramString)
  {
    this.last_name = paramString;
  }

  public void setMobile(String paramString)
  {
    this.mobile = paramString;
  }

  public void setToken(String paramString)
  {
    this.token = paramString;
  }

  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.ClientSignupResponse
 * JD-Core Version:    0.6.2
 */