package com.ubercab.library.app;

public abstract interface BuildConfigProxy
{
  public abstract String getAppName();

  public abstract String getBuildTime();

  public abstract String getBuildType();

  public abstract String getFlavor();

  public abstract String getGitSHA();

  public abstract String getPackageName();

  public abstract int getVersionCode();

  public abstract String getVersionName();

  public abstract boolean isDebug();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.BuildConfigProxy
 * JD-Core Version:    0.6.2
 */