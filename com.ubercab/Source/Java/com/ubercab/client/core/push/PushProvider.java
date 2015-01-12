package com.ubercab.client.core.push;

public abstract interface PushProvider
{
  public abstract String getRegistrationId();

  public abstract void register(RegisterCallback paramRegisterCallback);

  public abstract void unregister(UnregisterCallback paramUnregisterCallback);

  public static abstract interface RegisterCallback
  {
    public abstract void onRegistered(String paramString1, String paramString2);
  }

  public static abstract interface UnregisterCallback
  {
    public abstract void onUnregistered(String paramString1, String paramString2);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.push.PushProvider
 * JD-Core Version:    0.6.2
 */