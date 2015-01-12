package com.ubercab.client.core.model;

import android.text.TextUtils;
import com.ubercab.common.base.Joiner;
import java.util.Map;

public class ApiResponse
{
  public static final String KEY_AUTHNET_PAYMENT_PROFILE_ID = "authnet_payment_profile";
  public static final String KEY_BILLING_COUNTRY_ISO2 = "billing_country_iso2";
  public static final String KEY_BILLING_ZIP = "billing_zip";
  public static final String KEY_BRAINTREE_TOKEN = "braintree_token";
  public static final String KEY_CARD_BIN = "card_bin";
  public static final String KEY_CARD_EXPIRATION = "card_expiration";
  public static final String KEY_CARD_NUMBER = "card_number";
  public static final String KEY_CARD_TYPE = "card_type";
  public static final String KEY_DESCRIPTION = "description";
  public static final String KEY_ERROR = "error";
  public static final String KEY_ID = "id";
  public static final String KEY_IS_CURRENT = "is_current";
  public static final String KEY_IS_GOOGLE_WALLET = "is_google_wallet";
  public static final String KEY_PAYMENT_GATEWAY_ID = "payment_gateway_id";
  public static final String KEY_PAYMENT_PROFILE_TOKEN = "payment_profile_token";
  public static final String KEY_SELECTED = "selected";
  public static final String KEY_SUBHEAD = "subhead";
  public static final String KEY_TITLE = "title";
  public static final String KEY_TOKEN_DISPLAY_NAME = "token_display_name";
  public static final String KEY_TOKEN_TYPE = "token_type";
  public static final String KEY_TOP_OF_FORM = "top_of_form";
  public static final String KEY_USE_CASE = "use_case";
  public static final String KEY_UUID = "uuid";
  public static final String KEY_VERIFIED_AT = "verified_at";
  Map<String, Object> data;
  ApiError error;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ApiResponse localApiResponse;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localApiResponse = (ApiResponse)paramObject;
      if (this.data != null)
      {
        if (this.data.equals(localApiResponse.data));
      }
      else
        while (localApiResponse.data != null)
          return false;
      if (this.error == null)
        break;
    }
    while (this.error.equals(localApiResponse.error));
    while (true)
    {
      return false;
      if (localApiResponse.error == null)
        break;
    }
  }

  public Map<String, Object> getData()
  {
    return this.data;
  }

  public ApiError getError()
  {
    return this.error;
  }

  public String getErrorMessage()
  {
    if ((this.error != null) && ("555".equals(this.error.getStatusCode())))
      return this.error.getMessage();
    if ((this.error != null) && ("406".equals(this.error.getStatusCode())))
    {
      if (this.data.containsKey("top_of_form"))
        return (String)this.data.get("top_of_form");
      if ((this.data.containsKey("title")) && (this.data.containsKey("subhead")))
      {
        String str2 = (String)this.data.get("title");
        String str3 = (String)this.data.get("subhead");
        if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)))
          return Joiner.on("\n\n").join(str2, str3, new Object[0]).trim();
        if (!TextUtils.isEmpty(str2))
          return str2;
        return str3;
      }
      if (this.data.containsKey("title"))
        return (String)this.data.get("title");
      if (this.data.containsKey("subhead"))
        return (String)this.data.get("subhead");
    }
    if ((this.data != null) && (this.data.containsKey("error")))
      return (String)this.data.get("error");
    if (this.error != null)
    {
      String str1 = this.error.getMessage();
      if ((str1.startsWith("{")) && (str1.endsWith("}")) && (this.data != null) && (!this.data.isEmpty()))
        str1 = Joiner.on("\n").join(this.data.values());
      return str1;
    }
    return null;
  }

  public int hashCode()
  {
    if (this.error != null);
    for (int i = this.error.hashCode(); ; i = 0)
    {
      int j = i * 31;
      Map localMap = this.data;
      int k = 0;
      if (localMap != null)
        k = this.data.hashCode();
      return j + k;
    }
  }

  public boolean isSuccess()
  {
    return (this.error == null) || (TextUtils.isEmpty(this.error.getStatusCode()));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.ApiResponse
 * JD-Core Version:    0.6.2
 */