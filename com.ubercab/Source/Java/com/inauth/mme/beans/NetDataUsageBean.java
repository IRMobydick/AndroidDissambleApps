package com.inauth.mme.beans;

public class NetDataUsageBean extends Bean
{
  private String bytes_received;
  private String bytes_sent;
  private String checked_at;
  private String connection_type;
  private String interface_type;

  public String getBytes_received()
  {
    return this.bytes_received;
  }

  public String getBytes_sent()
  {
    return this.bytes_sent;
  }

  public String getChecked_at()
  {
    return this.checked_at;
  }

  public String getConnection_type()
  {
    return this.connection_type;
  }

  public String getInterface_type()
  {
    return this.interface_type;
  }

  public void setBytes_received(String paramString)
  {
    this.bytes_received = paramString;
  }

  public void setBytes_sent(String paramString)
  {
    this.bytes_sent = paramString;
  }

  public void setChecked_at(String paramString)
  {
    this.checked_at = paramString;
  }

  public void setConnection_type(String paramString)
  {
    this.connection_type = paramString;
  }

  public void setInterface_type(String paramString)
  {
    this.interface_type = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.beans.NetDataUsageBean
 * JD-Core Version:    0.6.2
 */