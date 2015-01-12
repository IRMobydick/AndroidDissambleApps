package com.inauth.utilities.enums;

public enum NetworkState
{
  private int network;
  private String value;

  static
  {
    MOBILE = new NetworkState("MOBILE", 1, "NETWORK_STATE_MOBILE", 0);
    BLUETOOTH = new NetworkState("BLUETOOTH", 2, "NETWORK_STATE_BLUETOOTH", 0);
    ETHERNET = new NetworkState("ETHERNET", 3, "NETWORK_STATE_ETHERNET", 0);
    NONE = new NetworkState("NONE", 4, "NETWORK_STATE_NONE", 5);
    NetworkState[] arrayOfNetworkState = new NetworkState[5];
    arrayOfNetworkState[0] = WIFI;
    arrayOfNetworkState[1] = MOBILE;
    arrayOfNetworkState[2] = BLUETOOTH;
    arrayOfNetworkState[3] = ETHERNET;
    arrayOfNetworkState[4] = NONE;
  }

  private NetworkState(String paramString, int paramInt)
  {
    this.value = paramString;
    this.network = paramInt;
  }

  public int getNetwork()
  {
    return this.network;
  }

  public String getValue()
  {
    return this.value;
  }

  public void setNetwork(int paramInt)
  {
    this.network = paramInt;
  }

  public void setValue(String paramString)
  {
    this.value = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.utilities.enums.NetworkState
 * JD-Core Version:    0.6.2
 */