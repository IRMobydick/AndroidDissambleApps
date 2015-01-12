package com.stericson.RootTools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.TimeoutException;

class InternalMethods
{
  protected long getConvertedSpace(String paramString)
  {
    double d = 1.0D;
    while (true)
    {
      char c;
      try
      {
        StringBuffer localStringBuffer = new StringBuffer();
        int i = 0;
        if (i >= paramString.length())
          return ()Math.ceil(d * Double.valueOf(localStringBuffer.toString()).doubleValue());
        c = paramString.charAt(i);
        if ((!Character.isDigit(c)) && (c != '.'))
        {
          if (c != 'm')
            if (c != 'M')
              break label112;
        }
        else
        {
          localStringBuffer.append(paramString.charAt(i));
          i++;
          continue;
        }
      }
      catch (Exception localException)
      {
        return -1L;
      }
      d = 1024.0D;
      continue;
      label112: if ((c == 'g') || (c == 'G'))
        d = 1048576.0D;
    }
  }

  protected ArrayList<Mount> getMounts()
    throws FileNotFoundException, IOException
  {
    LineNumberReader localLineNumberReader = new LineNumberReader(new FileReader("/proc/mounts"));
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      String str = localLineNumberReader.readLine();
      if (str == null)
        return localArrayList;
      RootTools.log(str);
      String[] arrayOfString = str.split(" ");
      localArrayList.add(new Mount(new File(arrayOfString[0]), new File(arrayOfString[1]), arrayOfString[2], arrayOfString[3]));
    }
  }

  protected Permissions getPermissions(String paramString)
  {
    String str = paramString.split(" ")[0];
    if ((str.length() == 10) && ((str.charAt(0) == '-') || (str.charAt(0) == 'd') || (str.charAt(0) == 'l')) && ((str.charAt(1) == '-') || (str.charAt(1) == 'r')) && ((str.charAt(2) == '-') || (str.charAt(2) == 'w')))
    {
      RootTools.log(str);
      Permissions localPermissions = new Permissions();
      localPermissions.setType(str.substring(0, 1));
      RootTools.log(localPermissions.getType());
      localPermissions.setUserPermissions(str.substring(1, 4));
      RootTools.log(localPermissions.getUserPermissions());
      localPermissions.setGroupPermissions(str.substring(4, 7));
      RootTools.log(localPermissions.getGroupPermissions());
      localPermissions.setOtherPermissions(str.substring(7, 10));
      RootTools.log(localPermissions.getOtherPermissions());
      localPermissions.setPermissions(Integer.parseInt(new StringBuilder(String.valueOf(Integer.toString(parsePermissions(localPermissions.getUserPermissions())))).append(Integer.toString(parsePermissions(localPermissions.getGroupPermissions()))).toString() + Integer.toString(parsePermissions(localPermissions.getOtherPermissions()))));
      return localPermissions;
    }
    return null;
  }

  protected ArrayList<Symlink> getSymLinks()
    throws FileNotFoundException, IOException
  {
    LineNumberReader localLineNumberReader = new LineNumberReader(new FileReader("/data/local/symlinks.txt"));
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      String str = localLineNumberReader.readLine();
      if (str == null)
        return localArrayList;
      RootTools.log(str);
      String[] arrayOfString = str.split(" ");
      localArrayList.add(new Symlink(new File(arrayOfString[(-3 + arrayOfString.length)]), new File(arrayOfString[(-1 + arrayOfString.length)])));
    }
  }

  protected int parsePermissions(String paramString)
  {
    int i;
    int j;
    if (paramString.charAt(0) == 'r')
    {
      i = 4;
      RootTools.log("permission " + i);
      RootTools.log("character " + paramString.charAt(0));
      if (paramString.charAt(1) != 'w')
        break label176;
      j = i + 2;
      label68: RootTools.log("permission " + j);
      RootTools.log("character " + paramString.charAt(1));
      if (paramString.charAt(2) != 'x')
        break label183;
    }
    label176: label183: for (int k = j + 1; ; k = j + 0)
    {
      RootTools.log("permission " + k);
      RootTools.log("character " + paramString.charAt(2));
      return k;
      i = 0;
      break;
      j = i + 0;
      break label68;
    }
  }

  protected boolean returnPath()
    throws TimeoutException
  {
    File localFile = new File("/data/local/tmp");
    try
    {
      if (!localFile.exists())
        RootTools.sendShell(new String[] { "mkdir /data/local/tmp" }, 0, InternalVariables.timeout);
      InternalVariables.path = new HashSet();
      RootTools.sendShell(new String[] { "dd if=/init.rc of=/data/local/tmp/init.rc", "chmod 0777 /data/local/tmp/init.rc" }, 0, InternalVariables.timeout);
      LineNumberReader localLineNumberReader = new LineNumberReader(new FileReader("/data/local/tmp/init.rc"));
      String str;
      do
      {
        str = localLineNumberReader.readLine();
        if (str == null)
          return false;
        RootTools.log(str);
      }
      while (!str.contains("export PATH"));
      InternalVariables.path = new HashSet(Arrays.asList(str.substring(str.indexOf("/")).split(":")));
      return true;
    }
    catch (Exception localException)
    {
      if (RootTools.debugMode)
      {
        RootTools.log("Error: " + localException.getMessage());
        localException.printStackTrace();
      }
    }
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.InternalMethods
 * JD-Core Version:    0.6.2
 */