package com.inauth.mme.logs;

import android.app.Application;
import android.os.Build;
import com.google.gson.Gson;
import com.inauth.mme.beans.RegistrationBean;
import com.inauth.mme.header.RegistrationHeader;
import com.inauth.mme.response.RegistrationResponse;
import com.inauth.utilities.InAuthUtilities;
import com.inauth.utilities.network.UploadFile;

public class RegistrationLog
{
  public RegistrationResponse deserialize(String paramString)
  {
    return (RegistrationResponse)new Gson().fromJson(paramString, RegistrationResponse.class);
  }

  public String send(String paramString1, String paramString2)
  {
    byte[] arrayOfByte = InAuthUtilities.Serverpack(paramString2);
    try
    {
      String str = UploadFile.getInstance().sendLog(arrayOfByte, paramString1 + "/v1/devices");
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public String serialize(Application paramApplication, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    RegistrationHeader localRegistrationHeader = new RegistrationHeader();
    localRegistrationHeader.setAccount_guid(paramString1);
    localRegistrationHeader.setDynamic_id(paramString2);
    localRegistrationHeader.setSdk_version(paramString3);
    RegistrationBean localRegistrationBean = new RegistrationBean();
    localRegistrationBean.setId_plus(paramString4);
    localRegistrationBean.setName(Build.MODEL);
    localRegistrationBean.setClient_application_guid(paramString5);
    localRegistrationHeader.setDevice(localRegistrationBean);
    return new Gson().toJson(localRegistrationHeader);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.RegistrationLog
 * JD-Core Version:    0.6.2
 */