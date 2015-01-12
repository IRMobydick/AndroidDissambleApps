package com.stericson.RootTools;

public class Permissions
{
  String group;
  String other;
  int permissions;
  String symlink;
  String type;
  String user;

  public String getGroupPermissions()
  {
    return this.group;
  }

  public String getOtherPermissions()
  {
    return this.other;
  }

  public int getPermissions()
  {
    return this.permissions;
  }

  public String getSymlink()
  {
    return this.symlink;
  }

  public String getType()
  {
    return this.type;
  }

  public String getUserPermissions()
  {
    return this.user;
  }

  public void setGroupPermissions(String paramString)
  {
    this.group = paramString;
  }

  public void setOtherPermissions(String paramString)
  {
    this.other = paramString;
  }

  public void setPermissions(int paramInt)
  {
    this.permissions = paramInt;
  }

  public void setSymlink(String paramString)
  {
    this.symlink = paramString;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }

  public void setUserPermissions(String paramString)
  {
    this.user = paramString;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.Permissions
 * JD-Core Version:    0.6.2
 */