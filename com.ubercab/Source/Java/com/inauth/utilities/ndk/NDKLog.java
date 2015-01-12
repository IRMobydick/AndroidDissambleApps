package com.inauth.utilities.ndk;

public class NDKLog
{
  private String decryptedList;
  private String reasonCode;

  private String parseReasonCode(int paramInt)
  {
    String str = "NO_ERROR";
    if (paramInt == 1)
      str = "MISSING_SIGFILE";
    do
    {
      return str;
      if (paramInt == 2)
        return "DECRYPTION_FAILURE";
    }
    while (paramInt != 3);
    return "INTERNAL_ERROR";
  }

  public String getDecryptedList()
  {
    if (this.decryptedList == null)
      this.decryptedList = "";
    return this.decryptedList;
  }

  public String getReasonCode()
  {
    if (this.reasonCode == null)
      this.reasonCode = "";
    return this.reasonCode;
  }

  public void setDecryptedList(String paramString)
  {
    this.decryptedList = paramString;
  }

  public void setReasonCode(int paramInt)
  {
    this.reasonCode = parseReasonCode(paramInt);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.utilities.ndk.NDKLog
 * JD-Core Version:    0.6.2
 */