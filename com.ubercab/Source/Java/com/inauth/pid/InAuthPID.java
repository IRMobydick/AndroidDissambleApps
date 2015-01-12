package com.inauth.pid;

import android.app.Application;
import com.inauth.pid.utilities.PIDHelper;

public class InAuthPID
{
  private static InAuthPID instance;
  private Application app;

  private Application getApp()
  {
    return this.app;
  }

  public static InAuthPID getInstance()
  {
    if (instance == null)
      instance = new InAuthPID();
    return instance;
  }

  private void setApp(Application paramApplication)
  {
    this.app = paramApplication;
  }

  public String getInAuthPID()
  {
    return PIDHelper.getInstance().generatePID(getInstance().getApp());
  }

  public void init(Application paramApplication)
  {
    getInstance().setApp(paramApplication);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.pid.InAuthPID
 * JD-Core Version:    0.6.2
 */