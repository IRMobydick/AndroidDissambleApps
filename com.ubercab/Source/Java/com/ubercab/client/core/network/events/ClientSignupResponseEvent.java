package com.ubercab.client.core.network.events;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.ubercab.client.core.model.ClientSignupResponse;
import com.ubercab.common.base.Joiner;
import java.util.Map;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class ClientSignupResponseEvent extends ResponseEvent<ClientSignupResponse>
{
  private static final int STATUS_CODE_ACCEPTED = 202;
  private static final int STATUS_CODE_INTERNAL_SERVER_ERROR = 555;
  private static final int STATUS_CODE_NOT_ACCEPTABLE = 406;
  private RetrofitError mError;
  private Map<String, Object> mErrorHash;

  public ClientSignupResponseEvent(ClientSignupResponse paramClientSignupResponse, Response paramResponse)
  {
    super(paramClientSignupResponse, paramResponse);
  }

  public ClientSignupResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
    this.mError = paramRetrofitError;
    this.mErrorHash = ((Map)paramRetrofitError.getBodyAs(new TypeToken()
    {
    }
    .getType()));
  }

  public String getErrorMessage()
  {
    if (this.mError.getResponse() == null);
    for (int i = 0; 555 == i; i = this.mError.getResponse().getStatus())
      return this.mError.getMessage();
    if ((406 == i) && (this.mErrorHash != null))
    {
      if (this.mErrorHash.containsKey("top_of_form"))
        return (String)this.mErrorHash.get("top_of_form");
      if ((this.mErrorHash.containsKey("title")) && (this.mErrorHash.containsKey("subhead")))
      {
        String str1 = (String)this.mErrorHash.get("title");
        String str2 = (String)this.mErrorHash.get("subhead");
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
          return Joiner.on("\n\n").join(str1, str2, new Object[0]).trim();
        if (!TextUtils.isEmpty(str1))
          return str1;
        return str2;
      }
      if (this.mErrorHash.containsKey("title"))
        return (String)this.mErrorHash.get("title");
      if (this.mErrorHash.containsKey("subhead"))
        return (String)this.mErrorHash.get("subhead");
    }
    if ((this.mErrorHash != null) && (this.mErrorHash.containsKey("error")))
      return (String)this.mErrorHash.get("error");
    if ((this.mErrorHash != null) && (!this.mErrorHash.isEmpty()))
      return Joiner.on("\n").join(this.mErrorHash.values());
    return null;
  }

  public boolean isPending()
  {
    return ((isSuccess()) && ((getModel() == null) || (((ClientSignupResponse)getModel()).isPending()))) || ((getResponse() != null) && (getResponse().getStatus() == 202));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.ClientSignupResponseEvent
 * JD-Core Version:    0.6.2
 */