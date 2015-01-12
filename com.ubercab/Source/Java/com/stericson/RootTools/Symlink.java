package com.stericson.RootTools;

import java.io.File;

public class Symlink
{
  protected final File file;
  protected final File symlinkPath;

  Symlink(File paramFile1, File paramFile2)
  {
    this.file = paramFile1;
    this.symlinkPath = paramFile2;
  }

  public File getFile()
  {
    return this.file;
  }

  public File getSymlinkPath()
  {
    return this.symlinkPath;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.Symlink
 * JD-Core Version:    0.6.2
 */