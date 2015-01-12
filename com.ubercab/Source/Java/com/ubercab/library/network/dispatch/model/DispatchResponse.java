package com.ubercab.library.network.dispatch.model;

public class DispatchResponse
{
  public static final int ERROR_LOGOUT;
  private String description = "";
  private Integer errorCode;
  private String messageType = "";

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    DispatchResponse localDispatchResponse;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localDispatchResponse = (DispatchResponse)paramObject;
      if (this.description != null)
      {
        if (this.description.equals(localDispatchResponse.description));
      }
      else
        while (localDispatchResponse.description != null)
          return false;
      if (this.errorCode != null)
      {
        if (this.errorCode.equals(localDispatchResponse.errorCode));
      }
      else
        while (localDispatchResponse.errorCode != null)
          return false;
      if (this.messageType == null)
        break;
    }
    while (this.messageType.equals(localDispatchResponse.messageType));
    while (true)
    {
      return false;
      if (localDispatchResponse.messageType == null)
        break;
    }
  }

  public String getDescription()
  {
    return this.description;
  }

  public Integer getErrorCode()
  {
    return this.errorCode;
  }

  public String getMessageType()
  {
    return this.messageType;
  }

  public int hashCode()
  {
    int i;
    int j;
    if (this.errorCode != null)
    {
      i = this.errorCode.hashCode();
      j = i * 31;
      if (this.messageType == null)
        break label77;
    }
    label77: for (int k = this.messageType.hashCode(); ; k = 0)
    {
      int m = 31 * (j + k);
      String str = this.description;
      int n = 0;
      if (str != null)
        n = this.description.hashCode();
      return m + n;
      i = 0;
      break;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.dispatch.model.DispatchResponse
 * JD-Core Version:    0.6.2
 */