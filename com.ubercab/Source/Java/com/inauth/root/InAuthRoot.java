package com.inauth.root;

import android.app.Application;
import com.inauth.root.utilities.RootHelper;
import com.inauth.root.utilities.RootLog;

public class InAuthRoot
{
  private static InAuthRoot instance;
  private Application app;

  private Application getApp()
  {
    return this.app;
  }

  public static InAuthRoot getInstance()
  {
    if (instance == null)
      instance = new InAuthRoot();
    return instance;
  }

  private void setApp(Application paramApplication)
  {
    this.app = paramApplication;
  }

  public RootLog getRootLog(String paramString, boolean paramBoolean)
  {
    return RootHelper.getInstance().getRootLog(getInstance().getApp(), paramString, paramBoolean);
  }

  public String getSDKVersion()
  {
    return "4.0.0";
  }

  public String getSigfileVersion(String paramString)
  {
    return RootHelper.getInstance().getSigfileVersion(paramString);
  }

  public void init(Application paramApplication)
  {
    getInstance().setApp(paramApplication);
  }

  public String updateSignatureFile(String paramString1, String paramString2, String paramString3)
  {
    return RootHelper.getInstance().updateSignatureFile(paramString1, paramString2, paramString3);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.root.InAuthRoot
 * JD-Core Version:    0.6.2
 */