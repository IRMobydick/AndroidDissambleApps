package com.inauth.mme.logs;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.inauth.mme.beans.AppInstallBean;
import com.inauth.mme.header.LogHeader;
import com.inauth.mme.response.LogResponse;
import com.inauth.utilities.InAuthUtilities;
import java.io.File;
import java.util.Date;
import java.util.List;

public class AppInstallLog
{
  private boolean firstDateSet = false;
  private Date lastTimeChecked;

  private Date getLastTimeChecked()
  {
    return this.lastTimeChecked;
  }

  private boolean isFirstDateSet()
  {
    return this.firstDateSet;
  }

  private void setFirstDateSet(boolean paramBoolean)
  {
    this.firstDateSet = paramBoolean;
  }

  private void setLastTimeChecked(Date paramDate)
  {
    this.lastTimeChecked = paramDate;
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
    localLogHeader.setType("app_installs_logs");
    while (true)
    {
      int i;
      try
      {
        List localList = paramApplication.getApplicationContext().getPackageManager().getInstalledPackages(0);
        i = 0;
        if (i < localList.size())
        {
          PackageInfo localPackageInfo = (PackageInfo)localList.get(i);
          AppInstallBean localAppInstallBean = new AppInstallBean();
          String str;
          if (localPackageInfo.packageName.equals("com.android.keyguard"))
          {
            str = "com.android.keyguard";
            Date localDate = new Date(new File(localPackageInfo.applicationInfo.sourceDir).lastModified());
            localAppInstallBean.setInstalledAt(localDate.toString());
            localAppInstallBean.setName(str);
            localAppInstallBean.setPackageName(localPackageInfo.packageName);
            localAppInstallBean.setVersionName(localPackageInfo.versionName);
            localAppInstallBean.setVersionCode(Integer.toString(localPackageInfo.versionCode));
            localAppInstallBean.setCheckedAt(InAuthUtilities.GetIsoDateTime());
            if (isFirstDateSet())
            {
              if (!localDate.after(getLastTimeChecked()))
                break label315;
              localLogHeader.addLogs(localAppInstallBean);
              break label315;
            }
          }
          else
          {
            str = localPackageInfo.applicationInfo.loadLabel(paramApplication.getApplicationContext().getPackageManager()).toString();
            continue;
          }
          localLogHeader.addLogs(localAppInstallBean);
        }
      }
      catch (Exception localException)
      {
        return new Gson().toJson(localLogHeader);
      }
      setLastTimeChecked(new Date());
      if (!isFirstDateSet())
      {
        setFirstDateSet(true);
        continue;
        label315: i++;
      }
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.AppInstallLog
 * JD-Core Version:    0.6.2
 */