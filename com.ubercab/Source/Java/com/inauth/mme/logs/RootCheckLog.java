package com.inauth.mme.logs;

import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.inauth.mme.beans.RootCheckBean;
import com.inauth.mme.header.LogHeader;
import com.inauth.mme.response.LogResponse;
import com.inauth.root.InAuthRoot;
import com.inauth.root.utilities.RootLog;
import com.inauth.utilities.InAuthUtilities;

public class RootCheckLog
{
  public LogResponse deserialize(String paramString)
  {
    return (LogResponse)new Gson().fromJson(paramString, LogResponse.class);
  }

  public RootLog getRootLog(String paramString, boolean paramBoolean)
  {
    InAuthRoot.getInstance().init(InAuthManager.getInstance().getApp());
    return InAuthRoot.getInstance().getRootLog(paramString, paramBoolean);
  }

  public String getRootSDKVersion()
  {
    InAuthRoot.getInstance().init(InAuthManager.getInstance().getApp());
    return InAuthRoot.getInstance().getSDKVersion();
  }

  public String getRootSigfileVersion(String paramString)
  {
    InAuthRoot.getInstance().init(InAuthManager.getInstance().getApp());
    return InAuthRoot.getInstance().getSigfileVersion(paramString);
  }

  public String serialize(RootLog paramRootLog, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str1 = getRootSDKVersion();
    String str2 = getRootSigfileVersion(paramString1);
    LogHeader localLogHeader = new LogHeader();
    localLogHeader.setAccountGUID(paramString3);
    localLogHeader.setDeviceGUID(paramString2);
    localLogHeader.setDynamicID(InAuthManager.getInstance().getInAuthDynamicID());
    localLogHeader.setTransaction_id(paramString4);
    localLogHeader.setSDKVersion(InAuthManager.getInstance().getSDKVersion());
    localLogHeader.setType("root_check_logs");
    RootCheckBean localRootCheckBean = new RootCheckBean();
    localRootCheckBean.setChecked_at(InAuthUtilities.GetIsoDateTime());
    localRootCheckBean.setRoot_status_code(paramRootLog.getRootStatus());
    localRootCheckBean.setRoot_status_reason_code(paramRootLog.getRootReasonCode());
    localRootCheckBean.setRoot_version(str1);
    localRootCheckBean.setSig_file_version(str2);
    localLogHeader.addLogs(localRootCheckBean);
    return new Gson().toJson(localLogHeader);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.RootCheckLog
 * JD-Core Version:    0.6.2
 */