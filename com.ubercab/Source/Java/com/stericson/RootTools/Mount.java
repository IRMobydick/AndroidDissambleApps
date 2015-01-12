package com.stericson.RootTools;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Mount
{
  protected final File mDevice;
  protected final Set<String> mFlags;
  protected final File mMountPoint;
  protected final String mType;

  Mount(File paramFile1, File paramFile2, String paramString1, String paramString2)
  {
    this.mDevice = paramFile1;
    this.mMountPoint = paramFile2;
    this.mType = paramString1;
    this.mFlags = new HashSet(Arrays.asList(paramString2.split(",")));
  }

  public File getDevice()
  {
    return this.mDevice;
  }

  public Set<String> getFlags()
  {
    return this.mFlags;
  }

  public File getMountPoint()
  {
    return this.mMountPoint;
  }

  public String getType()
  {
    return this.mType;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.mDevice;
    arrayOfObject[1] = this.mMountPoint;
    arrayOfObject[2] = this.mType;
    arrayOfObject[3] = this.mFlags;
    return String.format("%s on %s type %s %s", arrayOfObject);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.Mount
 * JD-Core Version:    0.6.2
 */