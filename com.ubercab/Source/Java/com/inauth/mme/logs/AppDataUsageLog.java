package com.inauth.mme.logs;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.RemoteException;
import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.inauth.mme.beans.AppDataUsageBean;
import com.inauth.mme.header.LogHeader;
import com.inauth.mme.response.LogResponse;
import com.inauth.utilities.InAuthUtilities;
import java.lang.reflect.Method;
import java.util.List;

public class AppDataUsageLog
{
  private boolean chk;

  private boolean isChk()
  {
    return this.chk;
  }

  private void setChk(boolean paramBoolean)
  {
    this.chk = paramBoolean;
  }

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
    localLogHeader.setType("app_data_usage_logs");
    while (true)
    {
      int i;
      PackageInfo localPackageInfo;
      final AppDataUsageBean localAppDataUsageBean;
      try
      {
        List localList = paramApplication.getPackageManager().getInstalledPackages(0);
        PackageManager localPackageManager = paramApplication.getPackageManager();
        i = 0;
        if (i < localList.size())
        {
          localPackageInfo = (PackageInfo)localList.get(i);
          if ((localPackageInfo.packageName == null) || (localPackageInfo.packageName.equals("")))
            break label325;
          localAppDataUsageBean = new AppDataUsageBean();
          if (!localPackageInfo.packageName.equals("com.android.keyguard"))
            break label279;
          localObject1 = "com.android.keyguard";
          localAppDataUsageBean.setName((String)localObject1);
          localAppDataUsageBean.setPackageName(localPackageInfo.packageName);
          Method localMethod = localPackageManager.getClass().getMethod("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class });
          setChk(false);
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = localPackageInfo.packageName;
          arrayOfObject[1] = new IPackageStatsObserver.Stub()
          {
            public void onGetStatsCompleted(PackageStats paramAnonymousPackageStats, boolean paramAnonymousBoolean)
              throws RemoteException
            {
              AppDataUsageLog localAppDataUsageLog = AppDataUsageLog.this;
              if (paramAnonymousBoolean);
              try
              {
                localAppDataUsageBean.setCodeSize(Long.toString(paramAnonymousPackageStats.codeSize));
                localAppDataUsageBean.setDataSize(Long.toString(paramAnonymousPackageStats.dataSize));
                localAppDataUsageBean.setCacheSize(Long.toString(paramAnonymousPackageStats.cacheSize));
                AppDataUsageLog.this.notify();
                AppDataUsageLog.this.setChk(true);
                return;
              }
              finally
              {
              }
            }
          };
          localMethod.invoke(localPackageManager, arrayOfObject);
          try
          {
            if (isChk())
              break label308;
            wait();
            continue;
          }
          finally
          {
          }
        }
      }
      catch (Exception localException)
      {
      }
      return new Gson().toJson(localLogHeader);
      label279: String str = localPackageInfo.applicationInfo.loadLabel(paramApplication.getApplicationContext().getPackageManager()).toString();
      Object localObject1 = str;
      continue;
      label308: localAppDataUsageBean.setCheckedAt(InAuthUtilities.GetIsoDateTime());
      localLogHeader.addLogs(localAppDataUsageBean);
      label325: i++;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.AppDataUsageLog
 * JD-Core Version:    0.6.2
 */