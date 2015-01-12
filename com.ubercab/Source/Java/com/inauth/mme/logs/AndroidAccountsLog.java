package com.inauth.mme.logs;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Application;
import android.content.Context;
import com.google.gson.Gson;
import com.inauth.mme.InAuthManager;
import com.inauth.mme.beans.AndroidAccountsBean;
import com.inauth.mme.header.LogHeader;
import com.inauth.mme.response.LogResponse;
import com.inauth.utilities.InAuthUtilities;

public class AndroidAccountsLog
{
  private String getAllGoogleAccounts(Context paramContext)
  {
    String str = null;
    Account[] arrayOfAccount = AccountManager.get(paramContext).getAccounts();
    int i = arrayOfAccount.length;
    int j = 0;
    if (j < i)
    {
      Account localAccount = arrayOfAccount[j];
      if (localAccount.type.equals("com.google"))
        if (str != null)
          break label59;
      label59: for (str = localAccount.name; ; str = str + "," + localAccount.name)
      {
        j++;
        break;
      }
    }
    return str;
  }

  public LogResponse deserialize(String paramString)
  {
    return (LogResponse)new Gson().fromJson(paramString, LogResponse.class);
  }

  public String serialize(Application paramApplication, String paramString1, String paramString2, String paramString3)
  {
    String str = getAllGoogleAccounts(paramApplication.getApplicationContext());
    LogHeader localLogHeader = new LogHeader();
    localLogHeader.setAccountGUID(paramString2);
    localLogHeader.setDeviceGUID(paramString1);
    localLogHeader.setDynamicID(InAuthManager.getInstance().getInAuthDynamicID());
    localLogHeader.setTransaction_id(paramString3);
    localLogHeader.setSDKVersion(InAuthManager.getInstance().getSDKVersion());
    localLogHeader.setType("android_accounts_logs");
    AndroidAccountsBean localAndroidAccountsBean = new AndroidAccountsBean();
    localAndroidAccountsBean.setEmail(str);
    localAndroidAccountsBean.setChecked_at(InAuthUtilities.GetIsoDateTime());
    localLogHeader.addLogs(localAndroidAccountsBean);
    return new Gson().toJson(localLogHeader);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.mme.logs.AndroidAccountsLog
 * JD-Core Version:    0.6.2
 */