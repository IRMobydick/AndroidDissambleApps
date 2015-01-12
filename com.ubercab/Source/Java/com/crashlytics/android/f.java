package com.crashlytics.android;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

final class f extends FileOutputStream
{
  public static final FilenameFilter a = new g();
  private final String b;
  private File c;
  private boolean d = false;

  public f(File paramFile, String paramString)
    throws FileNotFoundException
  {
    super(new File(paramFile, paramString + ".cls_temp"));
    this.b = (paramFile + File.separator + paramString);
    this.c = new File(this.b + ".cls_temp");
  }

  public final void a()
    throws IOException
  {
    if (this.d)
      return;
    this.d = true;
    super.flush();
    super.close();
  }

  public final void close()
    throws IOException
  {
    File localFile;
    try
    {
      boolean bool = this.d;
      if (bool);
      while (true)
      {
        return;
        this.d = true;
        super.flush();
        super.close();
        localFile = new File(this.b + ".cls");
        if (!this.c.renameTo(localFile))
          break;
        this.c = null;
      }
    }
    finally
    {
    }
    String str = "";
    if (localFile.exists())
      str = " (target already exists)";
    while (true)
    {
      throw new IOException("Could not rename temp file: " + this.c + " -> " + localFile + str);
      if (!this.c.exists())
        str = " (source does not exist)";
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.f
 * JD-Core Version:    0.6.2
 */