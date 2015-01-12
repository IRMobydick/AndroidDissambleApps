package com.stericson.RootTools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RootTools
{
  public static String customShell = "";
  public static boolean debugMode = false;
  public static int lastExitCode;
  public static List<String> lastFoundBinaryPaths = new ArrayList();
  public static int shellDelay = 0;
  public static boolean useRoot = true;
  public static String utilPath;

  public static boolean checkUtil(String paramString)
  {
    Iterator localIterator;
    if (findBinary(paramString))
      localIterator = lastFoundBinaryPaths.iterator();
    String str;
    int i;
    do
    {
      Permissions localPermissions;
      do
      {
        if (!localIterator.hasNext())
          return false;
        str = (String)localIterator.next();
        localPermissions = getFilePermissionsSymlinks(str + "/" + paramString);
      }
      while (localPermissions == null);
      i = localPermissions.getPermissions();
    }
    while ((i != 755) && (i != 777) && (i != 775));
    utilPath = str + "/" + paramString;
    return true;
  }

  public static boolean checkUtils(String[] paramArrayOfString)
    throws Exception
  {
    return fixUtils(paramArrayOfString);
  }

  public static boolean copyFile(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (paramBoolean1);
    while (true)
    {
      try
      {
        remount(paramString2, "RW");
        if (checkUtil("cp"))
        {
          log("cp command is available!");
          if (paramBoolean2)
          {
            sendShell("cp -fp " + paramString1 + " " + paramString2, InternalVariables.timeout);
            if (!paramBoolean1)
              break;
            remount(paramString2, "RO");
            return bool;
          }
          sendShell("cp -f " + paramString1 + " " + paramString2, InternalVariables.timeout);
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      if ((checkUtil("busybox")) && (hasUtil("cp", "busybox")))
      {
        log("busybox cp command is available!");
        if (paramBoolean2)
          sendShell("busybox cp -fp " + paramString1 + " " + paramString2, InternalVariables.timeout);
        else
          sendShell("busybox cp -f " + paramString1 + " " + paramString2, InternalVariables.timeout);
      }
      else if (checkUtil("cat"))
      {
        log("cp is not available, use cat!");
        int i = -1;
        if (paramBoolean2)
          i = getFilePermissionsSymlinks(paramString1).permissions;
        sendShell("cat " + paramString1 + " > " + paramString2, InternalVariables.timeout);
        if (paramBoolean2)
          sendShell("chmod " + i + " " + paramString2, InternalVariables.timeout);
      }
      else
      {
        bool = false;
      }
    }
    return bool;
  }

  public static boolean findBinary(String paramString)
  {
    int i = 0;
    boolean bool1 = false;
    lastFoundBinaryPaths.clear();
    log(InternalVariables.TAG, "Checking for " + paramString);
    String str1;
    try
    {
      Iterator localIterator = getPath().iterator();
      while (true)
      {
        boolean bool2 = localIterator.hasNext();
        if (!bool2)
        {
          if (!bool1)
          {
            log(InternalVariables.TAG, "Trying second method");
            log(InternalVariables.TAG, "Checking for " + paramString);
            arrayOfString = new String[] { "/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/" };
            int j = arrayOfString.length;
            if (i < j)
              break;
          }
          return bool1;
        }
        String str2 = (String)localIterator.next();
        if (new File(str2 + "/" + paramString).exists())
        {
          log(paramString + " was found here: " + str2);
          lastFoundBinaryPaths.add(str2);
          bool1 = true;
        }
        else
        {
          log(paramString + " was NOT found here: " + str2);
        }
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      while (true)
        log(InternalVariables.TAG, "TimeoutException!!!");
    }
    catch (Exception localException)
    {
      String[] arrayOfString;
      while (true)
        log(InternalVariables.TAG, paramString + " was not found, more information MAY be available with Debugging on.");
      str1 = arrayOfString[i];
      if (!new File(str1 + paramString).exists())
        break label402;
    }
    log(paramString + " was found here: " + str1);
    lastFoundBinaryPaths.add(str1);
    bool1 = true;
    while (true)
    {
      i++;
      break;
      label402: log(paramString + " was NOT found here: " + str1);
    }
  }

  public static void fixUtil(String paramString1, String paramString2)
  {
    try
    {
      remount("/system", "rw");
      Iterator localIterator;
      if (findBinary(paramString1))
        localIterator = lastFoundBinaryPaths.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          String[] arrayOfString = new String[2];
          arrayOfString[0] = (paramString2 + " ln -s " + paramString2 + " /system/bin/" + paramString1);
          arrayOfString[1] = (paramString2 + " chmod 0755 /system/bin/" + paramString1);
          sendShell(arrayOfString, 10, InternalVariables.timeout);
          remount("/system", "ro");
          return;
        }
        String str = (String)localIterator.next();
        sendShell(paramString2 + " rm " + str + "/" + paramString1, InternalVariables.timeout);
      }
    }
    catch (Exception localException)
    {
    }
  }

  public static boolean fixUtils(String[] paramArrayOfString)
    throws Exception
  {
    int i = paramArrayOfString.length;
    int j = 0;
    boolean bool2;
    if (j >= i)
    {
      bool2 = true;
      label13: return bool2;
    }
    String str = paramArrayOfString[j];
    if (!checkUtil(str))
    {
      if (!checkUtil("busybox"))
        break label57;
      if (hasUtil(str, "busybox"))
        fixUtil(str, utilPath);
    }
    while (true)
    {
      j++;
      break;
      label57: boolean bool1 = checkUtil("toolbox");
      bool2 = false;
      if (!bool1)
        break label13;
      if (hasUtil(str, "toolbox"))
        fixUtil(str, utilPath);
    }
  }

  public static List<String> getBusyBoxApplets()
    throws Exception
  {
    List localList = sendShell("busybox --list", InternalVariables.timeout);
    if (localList != null)
      return localList;
    throw new Exception();
  }

  public static String getBusyBoxVersion()
  {
    log(InternalVariables.TAG, "Getting BusyBox Version");
    InternalVariables.busyboxVersion = null;
    try
    {
      sendShell(new String[] { "busybox" }, 0, InternalVariables.timeout);
      return InternalVariables.busyboxVersion;
    }
    catch (TimeoutException localTimeoutException)
    {
      while (true)
        log(InternalVariables.TAG, "TimeoutException!!!");
    }
    catch (Exception localException)
    {
      log(InternalVariables.TAG, "BusyBox was not found, more information MAY be available with Debugging on.");
    }
    return "";
  }

  public static Permissions getFilePermissions(String paramString)
  {
    return getFilePermissionsSymlinks(paramString);
  }

  // ERROR //
  public static Permissions getFilePermissionsSymlinks(String paramString)
  {
    // Byte code:
    //   0: getstatic 169	com/stericson/RootTools/InternalVariables:TAG	Ljava/lang/String;
    //   3: new 61	java/lang/StringBuilder
    //   6: dup
    //   7: ldc 255
    //   9: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 174	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: new 201	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 202	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: invokevirtual 205	java/io/File:exists	()Z
    //   33: ifeq +290 -> 323
    //   36: ldc 29
    //   38: astore_1
    //   39: new 61	java/lang/StringBuilder
    //   42: dup
    //   43: aload_0
    //   44: invokestatic 65	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   47: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: ldc_w 257
    //   53: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 114	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   62: iconst_4
    //   63: anewarray 59	java/lang/String
    //   66: astore_3
    //   67: aload_3
    //   68: iconst_0
    //   69: new 61	java/lang/StringBuilder
    //   72: dup
    //   73: ldc_w 259
    //   76: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: aload_0
    //   80: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: aastore
    //   87: aload_3
    //   88: iconst_1
    //   89: new 61	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 261
    //   96: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aastore
    //   107: aload_3
    //   108: iconst_2
    //   109: new 61	java/lang/StringBuilder
    //   112: dup
    //   113: ldc_w 263
    //   116: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   119: aload_0
    //   120: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: aastore
    //   127: aload_3
    //   128: iconst_3
    //   129: new 61	java/lang/StringBuilder
    //   132: dup
    //   133: ldc_w 265
    //   136: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: aload_0
    //   140: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: aastore
    //   147: aload_3
    //   148: iconst_0
    //   149: getstatic 123	com/stericson/RootTools/InternalVariables:timeout	I
    //   152: invokestatic 231	com/stericson/RootTools/RootTools:sendShell	([Ljava/lang/String;II)Ljava/util/List;
    //   155: invokeinterface 47 1 0
    //   160: astore 4
    //   162: aload 4
    //   164: invokeinterface 53 1 0
    //   169: ifne +6 -> 175
    //   172: goto +151 -> 323
    //   175: aload 4
    //   177: invokeinterface 57 1 0
    //   182: checkcast 59	java/lang/String
    //   185: astore 5
    //   187: aload 5
    //   189: ldc 118
    //   191: invokevirtual 269	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   194: iconst_0
    //   195: aaload
    //   196: invokevirtual 272	java/lang/String:length	()I
    //   199: bipush 10
    //   201: if_icmpne +122 -> 323
    //   204: new 61	java/lang/StringBuilder
    //   207: dup
    //   208: ldc_w 274
    //   211: invokespecial 68	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: aload 5
    //   216: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 114	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   225: aload 5
    //   227: ldc 118
    //   229: invokevirtual 269	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   232: astore 9
    //   234: aload 9
    //   236: bipush 254
    //   238: aload 9
    //   240: arraylength
    //   241: iadd
    //   242: aaload
    //   243: ldc_w 276
    //   246: invokevirtual 279	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   249: ifeq +18 -> 267
    //   252: ldc_w 281
    //   255: invokestatic 114	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   258: aload 9
    //   260: iconst_m1
    //   261: aload 9
    //   263: arraylength
    //   264: iadd
    //   265: aaload
    //   266: astore_1
    //   267: new 283	com/stericson/RootTools/InternalMethods
    //   270: dup
    //   271: invokespecial 284	com/stericson/RootTools/InternalMethods:<init>	()V
    //   274: aload 5
    //   276: invokevirtual 286	com/stericson/RootTools/InternalMethods:getPermissions	(Ljava/lang/String;)Lcom/stericson/RootTools/Permissions;
    //   279: astore 8
    //   281: aload 8
    //   283: ifnull -121 -> 162
    //   286: aload 8
    //   288: aload_1
    //   289: invokevirtual 289	com/stericson/RootTools/Permissions:setSymlink	(Ljava/lang/String;)V
    //   292: aload 8
    //   294: areturn
    //   295: astore 7
    //   297: aload 7
    //   299: invokevirtual 292	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   302: invokestatic 114	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   305: goto -143 -> 162
    //   308: astore_2
    //   309: aload_2
    //   310: invokevirtual 292	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   313: invokestatic 114	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   316: aconst_null
    //   317: areturn
    //   318: astore 6
    //   320: goto -53 -> 267
    //   323: aconst_null
    //   324: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   267	281	295	java/lang/Exception
    //   286	292	295	java/lang/Exception
    //   62	162	308	java/lang/Exception
    //   162	172	308	java/lang/Exception
    //   175	225	308	java/lang/Exception
    //   297	305	308	java/lang/Exception
    //   225	267	318	java/lang/Exception
  }

  public static ArrayList<Mount> getMounts()
    throws Exception
  {
    InternalVariables.mounts = new InternalMethods().getMounts();
    if (InternalVariables.mounts != null)
      return InternalVariables.mounts;
    throw new Exception();
  }

  public static Set<String> getPath()
    throws Exception
  {
    if (InternalVariables.path != null)
      return InternalVariables.path;
    if (new InternalMethods().returnPath())
      return InternalVariables.path;
    throw new Exception();
  }

  public static long getSpace(String paramString)
  {
    int i = 0;
    InternalVariables.getSpaceFor = paramString;
    int j = 0;
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = ("df " + paramString);
    try
    {
      sendShell(arrayOfString1, 0, -1);
      label40: log("Looking for Space");
      String[] arrayOfString2;
      int m;
      int n;
      int i1;
      String[] arrayOfString3;
      int i2;
      if (InternalVariables.space != null)
      {
        log("First Method");
        arrayOfString2 = InternalVariables.space;
        int k = arrayOfString2.length;
        m = 0;
        if (m < k)
          break label131;
        n = 0;
        i1 = 3;
        log("Second Method");
        if (!InternalVariables.space[0].startsWith(paramString))
          i1 = 2;
        arrayOfString3 = InternalVariables.space;
        i2 = arrayOfString3.length;
      }
      while (true)
      {
        if (i >= i2)
        {
          log("Returning -1, space could not be determined.");
          return -1L;
          label131: String str1 = arrayOfString2[m];
          log(str1);
          if (j != 0)
            return new InternalMethods().getConvertedSpace(str1);
          if (str1.equals("used,"))
            j = 1;
          m++;
          break;
        }
        String str2 = arrayOfString3[i];
        log(str2);
        if (str2.length() > 0)
        {
          log(str2 + "Valid");
          if (n == i1)
            return new InternalMethods().getConvertedSpace(str2);
          n++;
        }
        i++;
      }
    }
    catch (Exception localException)
    {
      break label40;
    }
  }

  public static String getSymlink(File paramFile)
  {
    log("Looking for Symlink for " + paramFile.toString());
    if (paramFile.exists())
    {
      log("File exists");
      try
      {
        String[] arrayOfString = ((String)sendShell("ls -l " + paramFile, InternalVariables.timeout).get(0)).split(" ");
        if (arrayOfString[(-2 + arrayOfString.length)].equals("->"))
        {
          log("Symlink found.");
          String str = arrayOfString[(-1 + arrayOfString.length)];
          return str;
        }
      }
      catch (Exception localException)
      {
      }
    }
    log("Symlink not found");
    return "";
  }

  public static ArrayList<Symlink> getSymlinks(String paramString)
    throws Exception
  {
    if (!checkUtil("find"))
      throw new Exception();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ("find " + paramString + " -type l -exec ls -l {} \\; > /data/local/symlinks.txt;");
    sendShell(arrayOfString, 0, -1);
    InternalVariables.symlinks = new InternalMethods().getSymLinks();
    if (InternalVariables.symlinks != null)
      return InternalVariables.symlinks;
    throw new Exception();
  }

  public static String getWorkingToolbox()
  {
    if (checkUtil("busybox"))
      return "busybox";
    if (checkUtil("toolbox"))
      return "toolbox";
    return "";
  }

  public static boolean hasEnoughSpaceOnSdCard(long paramLong)
  {
    log(InternalVariables.TAG, "Checking SDcard size and that it is mounted as RW");
    if (!Environment.getExternalStorageState().equals("mounted"));
    StatFs localStatFs;
    do
    {
      return false;
      localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    }
    while (paramLong >= localStatFs.getBlockSize() * localStatFs.getAvailableBlocks());
    return true;
  }

  public static boolean hasUtil(final String paramString1, String paramString2)
  {
    if ((!paramString2.equals("toolbox")) && (!paramString2.equals("busybox")))
      return false;
    try
    {
      Result local1 = new Result()
      {
        public void onComplete(int paramAnonymousInt)
        {
        }

        public void onFailure(Exception paramAnonymousException)
        {
          setError(2);
        }

        public void process(String paramAnonymousString)
          throws Exception
        {
          if (RootTools.this.equals("toolbox"))
            if (paramAnonymousString.contains("no such tool"))
              setError(1);
          while ((!RootTools.this.equals("busybox")) || (!paramAnonymousString.contains(paramString1)))
            return;
          RootTools.log("Found util!");
          setData(Integer.valueOf(1));
        }

        public void processError(String paramAnonymousString)
          throws Exception
        {
          getProcess().destroy();
        }
      };
      if (paramString2.equals("toolbox"))
      {
        String[] arrayOfString = new String[1];
        arrayOfString[0] = ("toolbox " + paramString1);
        sendShell(arrayOfString, 0, local1, false, InternalVariables.timeout);
      }
      while (true)
      {
        if (local1.getError() != 0)
          break label189;
        if (local1.getData() == null)
          break;
        log("Box contains " + paramString1 + " util!");
        return true;
        if (paramString2.equals("busybox"))
          sendShell(new String[] { "busybox --list" }, 0, local1, false, InternalVariables.timeout);
      }
    }
    catch (Exception localException)
    {
      log(localException.getMessage());
      return false;
    }
    log("Box does not contain " + paramString1 + " util!");
    return false;
    label189: log("Box does not contain " + paramString1 + " util!");
    return false;
  }

  public static boolean installBinary(Context paramContext, int paramInt, String paramString)
  {
    return installBinary(paramContext, paramInt, paramString, "700");
  }

  public static boolean installBinary(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    try
    {
      Installer localInstaller = new Installer(paramContext);
      return localInstaller.installBinary(paramInt, paramString1, paramString2);
    }
    catch (IOException localIOException)
    {
      if (debugMode)
        localIOException.printStackTrace();
    }
    return false;
  }

  public static boolean isAccessGiven()
  {
    try
    {
      shellDelay = 500;
      log(InternalVariables.TAG, "Checking for Root access");
      InternalVariables.accessGiven = false;
      sendShell(new String[] { "id" }, 0, InternalVariables.timeout);
      boolean bool = InternalVariables.accessGiven;
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return false;
    }
    finally
    {
      shellDelay = 0;
    }
  }

  public static boolean isAppletAvailable(String paramString)
  {
    try
    {
      Iterator localIterator = getBusyBoxApplets().iterator();
      boolean bool;
      do
      {
        if (!localIterator.hasNext())
          return false;
        bool = ((String)localIterator.next()).equals(paramString);
      }
      while (!bool);
      return true;
    }
    catch (Exception localException)
    {
      log(localException.toString());
    }
    return false;
  }

  public static boolean isBusyboxAvailable()
  {
    return findBinary("busybox");
  }

  public static boolean isNativeToolsReady(int paramInt, Context paramContext)
  {
    log(InternalVariables.TAG, "Preparing Native Tools");
    Installer localInstaller;
    for (InternalVariables.nativeToolsReady = false; ; InternalVariables.nativeToolsReady = localInstaller.installBinary(paramInt, "nativetools", "700"))
      try
      {
        localInstaller = new Installer(paramContext);
        if (localInstaller.isBinaryInstalled("nativetools"))
        {
          InternalVariables.nativeToolsReady = true;
          bool1 = InternalVariables.nativeToolsReady;
          return bool1;
        }
      }
      catch (IOException localIOException)
      {
        boolean bool2;
        do
        {
          bool2 = debugMode;
          boolean bool1 = false;
        }
        while (!bool2);
        localIOException.printStackTrace();
        return false;
      }
  }

  public static boolean isProcessRunning(String paramString)
  {
    log(InternalVariables.TAG, "Checks if process is running: " + paramString);
    try
    {
      Result local3 = new Result()
      {
        public void onComplete(int paramAnonymousInt)
        {
        }

        public void onFailure(Exception paramAnonymousException)
        {
          setError(1);
        }

        public void process(String paramAnonymousString)
          throws Exception
        {
          if (paramAnonymousString.contains(RootTools.this))
            setData(Integer.valueOf(1));
        }

        public void processError(String paramAnonymousString)
          throws Exception
        {
        }
      };
      sendShell(new String[] { "ps" }, 1, local3, -1);
      int i = local3.getError();
      boolean bool = false;
      if (i == 0)
      {
        Serializable localSerializable = local3.getData();
        bool = false;
        if (localSerializable != null)
          bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      log(localException.getMessage());
    }
    return false;
  }

  public static boolean isRootAvailable()
  {
    return findBinary("su");
  }

  public static boolean killProcess(String paramString)
  {
    log(InternalVariables.TAG, "Killing process " + paramString);
    try
    {
      Result local2 = new Result()
      {
        public void onComplete(int paramAnonymousInt)
        {
        }

        public void onFailure(Exception paramAnonymousException)
        {
          setError(1);
        }

        public void process(String paramAnonymousString)
          throws Exception
        {
          if (paramAnonymousString.contains(RootTools.this))
          {
            Matcher localMatcher = InternalVariables.psPattern.matcher(paramAnonymousString);
            try
            {
              if (localMatcher.find())
              {
                String str = localMatcher.group(1);
                if (getData() != null)
                  setData(getData() + " " + str);
                while (true)
                {
                  RootTools.log("Found pid: " + str);
                  return;
                  setData(str);
                }
              }
            }
            catch (Exception localException)
            {
              RootTools.log("Error with regex!");
              localException.printStackTrace();
              return;
            }
            RootTools.log("Matching in ps command failed!");
          }
        }

        public void processError(String paramAnonymousString)
          throws Exception
        {
        }
      };
      sendShell(new String[] { "ps" }, 1, local2, -1);
      int i = local2.getError();
      boolean bool = false;
      String str;
      if (i == 0)
      {
        str = (String)local2.getData();
        bool = false;
        if (str == null);
      }
      try
      {
        String[] arrayOfString = new String[1];
        arrayOfString[0] = ("kill -9 " + str);
        sendShell(arrayOfString, 1, -1);
        bool = true;
        return bool;
      }
      catch (Exception localException2)
      {
        log(localException2.getMessage());
        return false;
      }
    }
    catch (Exception localException1)
    {
      log(localException1.getMessage());
    }
    return false;
  }

  public static void log(String paramString)
  {
    log(null, paramString);
  }

  public static void log(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (!paramString2.equals("")) && (debugMode))
    {
      if (paramString1 != null)
        Log.d(paramString1, paramString2);
    }
    else
      return;
    Log.d(InternalVariables.TAG, paramString2);
  }

  public static Intent offerBusyBox(Activity paramActivity, int paramInt)
  {
    log(InternalVariables.TAG, "Launching Market for BusyBox");
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=stericson.busybox"));
    paramActivity.startActivityForResult(localIntent, paramInt);
    return localIntent;
  }

  public static void offerBusyBox(Activity paramActivity)
  {
    log(InternalVariables.TAG, "Launching Market for BusyBox");
    paramActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=stericson.busybox")));
  }

  public static Intent offerSuperUser(Activity paramActivity, int paramInt)
  {
    log(InternalVariables.TAG, "Launching Market for SuperUser");
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.noshufou.android.su"));
    paramActivity.startActivityForResult(localIntent, paramInt);
    return localIntent;
  }

  public static void offerSuperUser(Activity paramActivity)
  {
    log(InternalVariables.TAG, "Launching Market for SuperUser");
    paramActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.noshufou.android.su")));
  }

  public static boolean remount(String paramString1, String paramString2)
  {
    return new Remounter().remount(paramString1, paramString2);
  }

  public static void restartAndroid()
  {
    log(InternalVariables.TAG, "Restart Android");
    killProcess("zygote");
  }

  public static void runBinary(Context paramContext, String paramString1, String paramString2)
  {
    new Runner(paramContext, paramString1, paramString2).start();
  }

  public static List<String> sendShell(String paramString, int paramInt)
    throws IOException, RootToolsException, TimeoutException
  {
    return sendShell(paramString, null, paramInt);
  }

  public static List<String> sendShell(String paramString, Result paramResult, int paramInt)
    throws IOException, RootToolsException, TimeoutException
  {
    return sendShell(new String[] { paramString }, 0, paramResult, paramInt);
  }

  public static List<String> sendShell(String[] paramArrayOfString, int paramInt1, int paramInt2)
    throws IOException, RootToolsException, TimeoutException
  {
    return sendShell(paramArrayOfString, paramInt1, null, paramInt2);
  }

  public static List<String> sendShell(String[] paramArrayOfString, int paramInt1, Result paramResult, int paramInt2)
    throws IOException, RootToolsException, TimeoutException
  {
    return sendShell(paramArrayOfString, paramInt1, paramResult, useRoot, paramInt2);
  }

  public static List<String> sendShell(String[] paramArrayOfString, int paramInt1, Result paramResult, boolean paramBoolean, int paramInt2)
    throws IOException, RootToolsException, TimeoutException
  {
    return new Executer().sendShell(paramArrayOfString, paramInt1, paramResult, paramBoolean, paramInt2);
  }

  public static abstract class Result
    implements IResult
  {
    private Serializable data = null;
    private int error = 0;
    private Process process = null;

    public Serializable getData()
    {
      return this.data;
    }

    public int getError()
    {
      return this.error;
    }

    public Process getProcess()
    {
      return this.process;
    }

    public abstract void onComplete(int paramInt);

    public abstract void onFailure(Exception paramException);

    public abstract void process(String paramString)
      throws Exception;

    public abstract void processError(String paramString)
      throws Exception;

    public Result setData(Serializable paramSerializable)
    {
      this.data = paramSerializable;
      return this;
    }

    public Result setError(int paramInt)
    {
      this.error = paramInt;
      return this;
    }

    public Result setProcess(Process paramProcess)
    {
      this.process = paramProcess;
      return this;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.RootTools
 * JD-Core Version:    0.6.2
 */