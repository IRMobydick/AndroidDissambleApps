package com.ubercab.client.core.analytics.event;

import android.text.TextUtils;
import com.ubercab.client.feature.signup.PaymentData;
import com.ubercab.client.feature.signup.SignupData;
import com.ubercab.library.util.TimeUtils;
import java.util.UUID;

@Deprecated
public final class SignUpEvent extends AnalyticsEvent
{
  private static final String EVENT_SIGN_UP_CANCEL = "SignUpCancel";
  private static final String EVENT_SIGN_UP_PAGE_VIEW = "SignUpPageView";
  private static final String EVENT_SIGN_UP_PENDING = "SignUpPending";
  private static final String EVENT_SIGN_UP_REQUEST = "SignUpRequest";
  private static final String EVENT_SIGN_UP_RESPONSE = "SignUpResponse";
  private static final String EVENT_SIGN_UP_SUCCESS = "SignUpSuccess";
  private long mEpoch;
  private String mUuid;

  public SignUpEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  private int hasValueToInt(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return 0;
    return 1;
  }

  public void signUpCancel(SignupData paramSignupData)
  {
    signUpCancel(paramSignupData, null);
  }

  public void signUpCancel(SignupData paramSignupData, PaymentData paramPaymentData)
  {
    EventBuilder localEventBuilder = new EventBuilder().setEventName("SignUpCancel");
    if (paramSignupData != null)
    {
      localEventBuilder.putParameter("firstName", Integer.valueOf(hasValueToInt(paramSignupData.getFirstName()))).putParameter("lastName", Integer.valueOf(hasValueToInt(paramSignupData.getLastName()))).putParameter("email", Integer.valueOf(hasValueToInt(paramSignupData.getEmail()))).putParameter("password", Integer.valueOf(hasValueToInt(paramSignupData.getPassword()))).putParameter("mobile", Integer.valueOf(hasValueToInt(paramSignupData.getMobile())));
      if (paramPaymentData == null)
        break label228;
      localEventBuilder.putParameter("cardNumber", Integer.valueOf(hasValueToInt(paramPaymentData.getCardNumber()))).putParameter("cardMonth", Integer.valueOf(hasValueToInt(paramPaymentData.getCardMonth()))).putParameter("cardYear", Integer.valueOf(hasValueToInt(paramPaymentData.getCardYear()))).putParameter("cardCode", Integer.valueOf(hasValueToInt(paramPaymentData.getCardCode())));
    }
    while (true)
    {
      sendEvent(localEventBuilder.build());
      return;
      localEventBuilder.putParameter("firstName", Integer.valueOf(0)).putParameter("lastName", Integer.valueOf(0)).putParameter("email", Integer.valueOf(0)).putParameter("password", Integer.valueOf(0)).putParameter("mobile", Integer.valueOf(0));
      break;
      label228: localEventBuilder.putParameter("cardNumber", Integer.valueOf(0)).putParameter("cardMonth", Integer.valueOf(0)).putParameter("cardYear", Integer.valueOf(0)).putParameter("cardCode", Integer.valueOf(0));
    }
  }

  public void signUpPageView()
  {
    sendEvent(new EventBuilder().setEventName("SignUpPageView").build());
  }

  public void signUpPending()
  {
    sendEvent(new EventBuilder().setEventName("SignUpPending").putParameter("requestGuid", this.mUuid).build());
  }

  public void signUpRequest()
  {
    this.mEpoch = TimeUtils.getEpochTimeMs();
    this.mUuid = UUID.randomUUID().toString();
    sendEvent(new EventBuilder().setEventName("SignUpRequest").putParameter("requestGuid", this.mUuid).build());
  }

  public void signUpResponse(int paramInt)
  {
    float f = AnalyticsUtils.calculateLatencyInSeconds(this.mEpoch);
    sendEvent(new EventBuilder().setEventName("SignUpResponse").putParameter("latency", Float.valueOf(f)).putParameter("statusCode", Integer.valueOf(paramInt)).putParameter("requestGuid", this.mUuid).build());
  }

  public void signUpSuccess()
  {
    sendEvent(new EventBuilder().setEventName("SignUpSuccess").build());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.SignUpEvent
 * JD-Core Version:    0.6.2
 */