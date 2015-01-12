package com.inauth.mme.logs;

import android.app.Application;
import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.inauth.mme.beans.NetDataUsageBean;
import com.inauth.mme.header.LogHeader;
import com.inauth.mme.response.LogResponse;
import com.inauth.utilities.InAuthUtilities;

public class NetDataUsageLog
{
  public LogResponse deserialize(String paramString)
  {
    return (LogResponse)new Gson().fromJson(paramString, LogResponse.class);
  }

  public String serialize(Application paramApplication, String paramString1, String paramString2, String paramString3)
  {
    LogHeader localLogHeader = new LogHeader();
    localLogHeader.setAccountGUID(paramString2);
    localLogHeader.setDeviceGUID(paramString1);
    localLogHeader.setDynamicID(InAuthManager.getInstance().getInAuthDynamicID());
    localLogHeader.setTransaction_id(paramString3);
    localLogHeader.setSDKVersion(InAuthManager.getInstance().getSDKVersion());
    localLogHeader.setType("net_data_usage_logs");
    NetDataUsageBean localNetDataUsageBean = new NetDataUsageBean();
    localNetDataUsageBean.setConnection_type(InAuthUtilities.checkActiveNetworkDataConnection(paramApplication));
    localNetDataUsageBean.setChecked_at(InAuthUtilities.GetIsoDateTime());
    localLogHeader.addLogs(localNetDataUsageBean);
    return new Gson().toJson(localLogHeader);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.NetDataUsageLog
 * JD-Core Version:    0.6.2
 */