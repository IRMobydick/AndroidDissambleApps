package com.paypal.android.sdk;

public abstract class S extends ab
{
  public S(a parama, L paramL, d paramd, h paramh, String paramString)
  {
    super(parama, paramL, paramd, paramh, "Bearer " + paramString);
    a("Content-Type", "application/json");
    a("Accept", "application/json");
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.paypal.android.sdk.S
 * JD-Core Version:    0.6.2
 */