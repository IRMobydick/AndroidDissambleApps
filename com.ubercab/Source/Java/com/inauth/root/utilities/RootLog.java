package com.inauth.root.utilities;

public class RootLog
{
  private String rootReasonCode;
  private String rootStatus;

  public String getRootReasonCode()
  {
    if (this.rootReasonCode == null)
      this.rootReasonCode = "COMPROMISED";
    return this.rootReasonCode;
  }

  public String getRootStatus()
  {
    if (this.rootStatus == null)
      this.rootStatus = "COMPROMISED";
    return this.rootStatus;
  }

  public void setRootReasonCode(String paramString)
  {
    this.rootReasonCode = paramString;
  }

  public void setRootStatus(String paramString)
  {
    this.rootStatus = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.root.utilities.RootLog
 * JD-Core Version:    0.6.2
 */