package com.ubercab.library.location.client;

public final class UberLocationClientError
{
  public static final int GOOGLE_TYPE;
  private final int mErrorCode;
  private final int mResultType;

  public UberLocationClientError(int paramInt1, int paramInt2)
  {
    this.mErrorCode = paramInt1;
    this.mResultType = paramInt2;
  }

  public int getErrorCode()
  {
    return this.mErrorCode;
  }

  public int getResultType()
  {
    return this.mResultType;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.location.client.UberLocationClientError
 * JD-Core Version:    0.6.2
 */