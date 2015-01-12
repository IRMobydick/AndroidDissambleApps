package retrofit.client;

import java.io.IOException;

public abstract interface Client
{
  public abstract Response execute(Request paramRequest)
    throws IOException;

  public static abstract interface Provider
  {
    public abstract Client get();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.client.Client
 * JD-Core Version:    0.6.2
 */