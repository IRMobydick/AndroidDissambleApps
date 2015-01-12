package com.inauth.mme.logs;

import com.google.gson.Gson;
import com.inauth.mme.header.LogConfigHeader;
import com.inauth.mme.response.LogConfigResponse;
import com.inauth.utilities.InAuthUtilities;
import com.inauth.utilities.network.UploadFile;

public class ConfigurationLog
{
  public LogConfigResponse deserialize(String paramString)
  {
    return (LogConfigResponse)new Gson().fromJson(paramString, LogConfigResponse.class);
  }

  public String send(String paramString1, String paramString2)
  {
    byte[] arrayOfByte = InAuthUtilities.Serverpack(paramString2);
    try
    {
      String str = UploadFile.getInstance().sendLog(arrayOfByte, paramString1 + "/v1/devices/config");
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public String serialize(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    LogConfigHeader localLogConfigHeader = new LogConfigHeader();
    localLogConfigHeader.setAccountGUID(paramString1);
    localLogConfigHeader.setDeviceGUID(paramString2);
    localLogConfigHeader.setDynamicID(paramString3);
    localLogConfigHeader.setSDKVersion(paramString4);
    return new Gson().toJson(localLogConfigHeader);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.ConfigurationLog
 * JD-Core Version:    0.6.2
 */