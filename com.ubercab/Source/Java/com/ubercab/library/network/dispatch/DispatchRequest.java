package com.ubercab.library.network.dispatch;

import java.util.HashMap;
import java.util.Map;

public final class DispatchRequest
{
  private final DispatchCallback mCallback;
  private final boolean mIsExpectingPingResults;
  private final String mMessageType;
  private final int mMode;
  private final Map<String, Object> mParameters;

  private DispatchRequest(int paramInt, String paramString, boolean paramBoolean, Map<String, Object> paramMap, DispatchCallback paramDispatchCallback)
  {
    this.mMode = paramInt;
    this.mCallback = paramDispatchCallback;
    this.mParameters = paramMap;
    this.mMessageType = paramString;
    this.mIsExpectingPingResults = paramBoolean;
  }

  public DispatchCallback getCallback()
  {
    return this.mCallback;
  }

  public String getMessageType()
  {
    return this.mMessageType;
  }

  public int getMode()
  {
    return this.mMode;
  }

  public Map<String, Object> getParameters()
  {
    return this.mParameters;
  }

  public boolean isExpectingPingResults()
  {
    return this.mIsExpectingPingResults;
  }

  public static class Builder
  {
    private DispatchCallback mCallback;
    private boolean mIsExpectingPingResults;
    private String mMessageType = "";
    private int mMode = 1;
    private Map<String, Object> mParameters = new HashMap();

    public DispatchRequest build()
    {
      return new DispatchRequest(this.mMode, this.mMessageType, this.mIsExpectingPingResults, this.mParameters, this.mCallback, null);
    }

    public Builder setCallback(DispatchCallback paramDispatchCallback)
    {
      this.mCallback = paramDispatchCallback;
      return this;
    }

    public Builder setExpectsPingResults()
    {
      this.mIsExpectingPingResults = true;
      return this;
    }

    public Builder setMessageType(String paramString)
    {
      this.mMessageType = paramString;
      this.mParameters.put("messageType", paramString);
      return this;
    }

    public Builder setMode(int paramInt)
    {
      this.mMode = paramInt;
      return this;
    }

    public Builder setParameter(String paramString, Object paramObject)
    {
      this.mParameters.put(paramString, paramObject);
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.dispatch.DispatchRequest
 * JD-Core Version:    0.6.2
 */