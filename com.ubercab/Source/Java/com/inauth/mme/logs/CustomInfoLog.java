package com.inauth.mme.logs;

import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.inauth.mme.beans.CustomLogInfoBean;
import com.inauth.mme.header.CustomLogInfoHeader;
import com.inauth.utilities.InAuthUtilities;
import java.util.Map;

public class CustomInfoLog
{
  public String serialize(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    CustomLogInfoHeader localCustomLogInfoHeader = new CustomLogInfoHeader();
    localCustomLogInfoHeader.setAccountGUID(paramString2);
    localCustomLogInfoHeader.setDeviceGUID(paramString1);
    localCustomLogInfoHeader.setDynamicID(InAuthManager.getInstance().getInAuthDynamicID());
    localCustomLogInfoHeader.setSDKVersion(InAuthManager.getInstance().getSDKVersion());
    localCustomLogInfoHeader.setType("event");
    CustomLogInfoBean localCustomLogInfoBean = new CustomLogInfoBean();
    localCustomLogInfoBean.setVars(paramMap);
    localCustomLogInfoBean.setOccured_at(InAuthUtilities.GetIsoDateTime());
    localCustomLogInfoHeader.addLogsPayload(localCustomLogInfoBean);
    return new Gson().toJson(localCustomLogInfoHeader);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.CustomInfoLog
 * JD-Core Version:    0.6.2
 */