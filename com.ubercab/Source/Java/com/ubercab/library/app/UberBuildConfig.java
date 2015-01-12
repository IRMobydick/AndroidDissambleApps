package com.ubercab.library.app;

public class UberBuildConfig
  implements BuildConfigProxy
{
  public String getAppName()
  {
    throw new UnsupportedOperationException("The library does not have an application name.");
  }

  public String getBuildTime()
  {
    return "2014-11-11T20:42Z";
  }

  public String getBuildType()
  {
    return "release";
  }

  public String getFlavor()
  {
    return "";
  }

  public String getGitSHA()
  {
    return "480e322";
  }

  public String getPackageName()
  {
    return "com.ubercab.library";
  }

  public int getVersionCode()
  {
    return 0;
  }

  public String getVersionName()
  {
    return "3.28.0";
  }

  public boolean isDebug()
  {
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.app.UberBuildConfig
 * JD-Core Version:    0.6.2
 */