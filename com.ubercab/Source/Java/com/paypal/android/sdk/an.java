package com.paypal.android.sdk;

public class an extends am
{
  public an(f paramf, Exception paramException)
  {
    this(paramf.toString(), paramException);
  }

  public an(String paramString)
  {
    super("RequestError", paramString);
  }

  public an(String paramString1, String paramString2, String paramString3)
  {
    super("RequestError", paramString1, paramString2, paramString3);
  }

  public an(String paramString, Throwable paramThrowable)
  {
    super(paramThrowable.getClass().toString(), paramString, paramThrowable.toString(), paramThrowable.getMessage());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.an
 * JD-Core Version:    0.6.2
 */