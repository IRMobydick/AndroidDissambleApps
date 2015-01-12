package com.ubercab.client.core.model;

public class ApiError
{
  public static final String STATUS_CODE_INTERNAL_SERVER_ERROR = "555";
  public static final String STATUS_CODE_NOT_ACCEPTABLE = "406";
  String message;
  String statusCode;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ApiError localApiError;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localApiError = (ApiError)paramObject;
      if (this.message != null)
      {
        if (this.message.equals(localApiError.message));
      }
      else
        while (localApiError.message != null)
          return false;
      if (this.statusCode == null)
        break;
    }
    while (this.statusCode.equals(localApiError.statusCode));
    while (true)
    {
      return false;
      if (localApiError.statusCode == null)
        break;
    }
  }

  public String getMessage()
  {
    return this.message;
  }

  public String getStatusCode()
  {
    return this.statusCode;
  }

  public int hashCode()
  {
    if (this.message != null);
    for (int i = this.message.hashCode(); ; i = 0)
    {
      int j = i * 31;
      String str = this.statusCode;
      int k = 0;
      if (str != null)
        k = this.statusCode.hashCode();
      return j + k;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.ApiError
 * JD-Core Version:    0.6.2
 */