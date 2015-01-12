package com.ubercab.library.metrics.monitoring;

public class MonitoringEvent
{
  private String mApiCommandPath;
  private String mHostname;
  private String mMessageType;
  private String mMethod;
  private String mPath;
  private String mResponseType;
  private long mRoundtripTimeMs;
  private int mStatusCode;

  public MonitoringEvent(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, long paramLong)
  {
    this.mMethod = paramString1;
    this.mHostname = paramString2;
    this.mPath = paramString3;
    this.mMessageType = paramString4;
    this.mApiCommandPath = paramString5;
    this.mStatusCode = paramInt;
    this.mResponseType = paramString6;
    this.mRoundtripTimeMs = paramLong;
  }

  public String getApiCommandPath()
  {
    return this.mApiCommandPath;
  }

  public String getHostname()
  {
    return this.mHostname;
  }

  public String getMessageType()
  {
    return this.mMessageType;
  }

  public String getMethod()
  {
    return this.mMethod;
  }

  public String getPath()
  {
    return this.mPath;
  }

  public String getResponseType()
  {
    return this.mResponseType;
  }

  public long getRoundtripTimeMs()
  {
    return this.mRoundtripTimeMs;
  }

  public int getStatusCode()
  {
    return this.mStatusCode;
  }

  public static class Builder
  {
    private String mApiCommandPath;
    private String mHostname;
    private String mMessageType;
    private String mMethod;
    private String mPath;
    private String mResponseType;
    private long mRoundtripTimeMs;
    private int mStatusCode;

    public MonitoringEvent build()
    {
      return new MonitoringEvent(this.mMethod, this.mHostname, this.mPath, this.mMessageType, this.mApiCommandPath, this.mStatusCode, this.mResponseType, this.mRoundtripTimeMs);
    }

    public Builder setApiCommandPath(String paramString)
    {
      this.mApiCommandPath = paramString;
      return this;
    }

    public Builder setHostname(String paramString)
    {
      this.mHostname = paramString;
      return this;
    }

    public Builder setMessageType(String paramString)
    {
      this.mMessageType = paramString;
      return this;
    }

    public Builder setMethod(String paramString)
    {
      this.mMethod = paramString;
      return this;
    }

    public Builder setPath(String paramString)
    {
      this.mPath = paramString;
      return this;
    }

    public Builder setResponseType(String paramString)
    {
      this.mResponseType = paramString;
      return this;
    }

    public Builder setRoundtripTimeMs(long paramLong)
    {
      this.mRoundtripTimeMs = paramLong;
      return this;
    }

    public Builder setStatusCode(int paramInt)
    {
      this.mStatusCode = paramInt;
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.metrics.monitoring.MonitoringEvent
 * JD-Core Version:    0.6.2
 */