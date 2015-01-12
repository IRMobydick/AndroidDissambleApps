package com.adjust.sdk;

public abstract interface IPackageHandler
{
  public abstract void addPackage(ActivityPackage paramActivityPackage);

  public abstract void closeFirstPackage();

  public abstract boolean dropsOfflineActivities();

  public abstract void finishedTrackingActivity(ActivityPackage paramActivityPackage, ResponseData paramResponseData);

  public abstract String getFailureMessage();

  public abstract void pauseSending();

  public abstract void resumeSending();

  public abstract void sendFirstPackage();

  public abstract void sendNextPackage();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.IPackageHandler
 * JD-Core Version:    0.6.2
 */