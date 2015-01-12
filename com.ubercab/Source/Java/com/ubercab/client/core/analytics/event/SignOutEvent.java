package com.ubercab.client.core.analytics.event;

@Deprecated
public final class SignOutEvent extends AnalyticsEvent
{
  private static final String EVENT_SIGN_OUT = "SignOut";
  private static final String REASON_INITIAL_PING_ERROR = "initialPingError";
  private static final String REASON_INITIAL_PING_FAILED = "initialPingFailed";
  private static final String REASON_RESPONSE_STATUS_UNKNOWN = "pingResponseStatusUnknown";
  private static final String REASON_USER_INITIATED = "userInitiated";
  private boolean mInitialPing = true;

  public SignOutEvent(AnalyticsEvent.Listener paramListener)
  {
    super(paramListener);
  }

  private void signOut(String paramString)
  {
    sendEvent(new EventBuilder().setEventName("SignOut").putParameter("reason", paramString).build());
  }

  public void initialPingError()
  {
    if (!this.mInitialPing)
      return;
    signOut("initialPingError");
    this.mInitialPing = false;
  }

  public void initialPingFailed()
  {
    if (!this.mInitialPing)
      return;
    signOut("initialPingFailed");
    this.mInitialPing = false;
  }

  public void pingResponseStatusUnknown()
  {
    signOut("pingResponseStatusUnknown");
  }

  public void userInitiated()
  {
    signOut("userInitiated");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.analytics.event.SignOutEvent
 * JD-Core Version:    0.6.2
 */