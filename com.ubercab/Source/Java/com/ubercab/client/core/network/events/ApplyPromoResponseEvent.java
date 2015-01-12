package com.ubercab.client.core.network.events;

import com.ubercab.client.core.model.ApiResponse;
import com.ubercab.client.core.model.Ping;
import java.util.Map;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class ApplyPromoResponseEvent extends CnApiResponseEvent
{
  private static final String KEY_CANCEL_BUTTON_COPY = "confirmation_cancel_copy";
  private static final String KEY_CONFIRM_BUTTON_COPY = "confirmation_confirm_copy";
  private static final String KEY_CONFIRM_MESSAGE = "confirmation_message";
  private static final String KEY_ERROR_OBJ = "error_obj";
  private String mConfirmText;
  private String mConfirmationMessage;
  private String mDenyText;

  public ApplyPromoResponseEvent(Ping paramPing, Response paramResponse)
  {
    super(paramPing, paramResponse);
    Map localMap1 = paramPing.getApiResponse().getData();
    if ((localMap1 != null) && (localMap1.get("error_obj") != null))
    {
      Map localMap2 = (Map)localMap1.get("error_obj");
      if ((localMap2.containsKey("confirmation_message")) && (localMap2.containsKey("confirmation_confirm_copy")) && (localMap2.containsKey("confirmation_cancel_copy")))
      {
        this.mConfirmationMessage = ((String)localMap2.get("confirmation_message"));
        this.mConfirmText = ((String)localMap2.get("confirmation_confirm_copy"));
        this.mDenyText = ((String)localMap2.get("confirmation_cancel_copy"));
      }
    }
  }

  public ApplyPromoResponseEvent(RetrofitError paramRetrofitError)
  {
    super(paramRetrofitError);
  }

  public String getConfirmText()
  {
    return this.mConfirmText;
  }

  public String getConfirmationMessage()
  {
    return this.mConfirmationMessage;
  }

  public String getDenyText()
  {
    return this.mDenyText;
  }

  public boolean hasPromoConfirmation()
  {
    return this.mConfirmationMessage != null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.network.events.ApplyPromoResponseEvent
 * JD-Core Version:    0.6.2
 */