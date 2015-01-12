package com.squareup.okhttp;

import java.io.IOException;

public abstract interface Callback
{
  public abstract void onFailure(Request paramRequest, IOException paramIOException);

  public abstract void onResponse(Response paramResponse)
    throws IOException;
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.Callback
 * JD-Core Version:    0.6.2
 */