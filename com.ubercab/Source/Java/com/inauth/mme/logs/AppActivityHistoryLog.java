package com.inauth.mme.logs;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.content.ComponentName;
import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.inauth.mme.beans.AppActivityHistoryBean;
import com.inauth.mme.header.LogHeader;
import com.inauth.mme.response.LogResponse;
import com.inauth.utilities.InAuthUtilities;
import java.util.Iterator;
import java.util.List;

public class AppActivityHistoryLog
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
    localLogHeader.setType("app_activity_history_logs");
    ActivityManager localActivityManager = (ActivityManager)paramApplication.getSystemService("activity");
    List localList1 = localActivityManager.getRunningTasks(500);
    List localList2 = localActivityManager.getRunningAppProcesses();
    for (int i = 0; i < localList2.size(); i++)
    {
      Iterator localIterator = localList1.iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)localIterator.next();
        if (((ActivityManager.RunningAppProcessInfo)localList2.get(i)).processName.equals(localRunningTaskInfo.baseActivity.getPackageName()))
        {
          AppActivityHistoryBean localAppActivityHistoryBean = new AppActivityHistoryBean();
          localAppActivityHistoryBean.setName(localRunningTaskInfo.baseActivity.getShortClassName().substring(1));
          localAppActivityHistoryBean.setPackageName(localRunningTaskInfo.baseActivity.getPackageName());
          localAppActivityHistoryBean.setProcess_number_of_activity(Integer.toString(localRunningTaskInfo.numActivities));
          localAppActivityHistoryBean.setProcessed_id(Integer.toString(localRunningTaskInfo.id));
          localAppActivityHistoryBean.setCheckedAt(InAuthUtilities.GetIsoDateTime());
          localLogHeader.addLogs(localAppActivityHistoryBean);
        }
      }
    }
    return new Gson().toJson(localLogHeader);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.AppActivityHistoryLog
 * JD-Core Version:    0.6.2
 */