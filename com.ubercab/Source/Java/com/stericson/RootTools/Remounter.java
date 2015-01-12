package com.stericson.RootTools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class Remounter
{
  private Mount findMountPointRecursive(String paramString)
  {
    File localFile;
    do
      try
      {
        ArrayList localArrayList = RootTools.getMounts();
        localFile = new File(paramString);
        continue;
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          Mount localMount = (Mount)localIterator.next();
          boolean bool = localMount.getMountPoint().equals(localFile);
          if (bool)
            return localMount;
        }
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException(localIOException);
      }
      catch (Exception localException)
      {
        if (RootTools.debugMode)
          localException.printStackTrace();
        return null;
      }
    while (localFile != null);
    return null;
  }

  // ERROR //
  protected boolean remount(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 67
    //   2: astore_3
    //   3: ldc 69
    //   5: invokestatic 73	com/stericson/RootTools/RootTools:checkUtil	(Ljava/lang/String;)Z
    //   8: ifeq +358 -> 366
    //   11: getstatic 77	com/stericson/RootTools/RootTools:utilPath	Ljava/lang/String;
    //   14: astore_3
    //   15: aload_1
    //   16: ldc 79
    //   18: invokevirtual 84	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   21: ifeq +15 -> 36
    //   24: aload_1
    //   25: iconst_0
    //   26: aload_1
    //   27: ldc 79
    //   29: invokevirtual 88	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   32: invokevirtual 92	java/lang/String:substring	(II)Ljava/lang/String;
    //   35: astore_1
    //   36: iconst_0
    //   37: istore 4
    //   39: iload 4
    //   41: ifeq +340 -> 381
    //   44: aload_0
    //   45: aload_1
    //   46: invokespecial 94	com/stericson/RootTools/Remounter:findMountPointRecursive	(Ljava/lang/String;)Lcom/stericson/RootTools/Mount;
    //   49: astore 12
    //   51: getstatic 99	com/stericson/RootTools/InternalVariables:TAG	Ljava/lang/String;
    //   54: new 101	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 103
    //   60: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload 12
    //   65: invokevirtual 47	com/stericson/RootTools/Mount:getMountPoint	()Ljava/io/File;
    //   68: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   71: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 114
    //   76: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_2
    //   80: invokevirtual 117	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   83: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 126	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   92: pop
    //   93: aload 12
    //   95: invokevirtual 130	com/stericson/RootTools/Mount:getFlags	()Ljava/util/Set;
    //   98: aload_2
    //   99: invokevirtual 117	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   102: invokeinterface 135 2 0
    //   107: ifne +192 -> 299
    //   110: iconst_3
    //   111: anewarray 81	java/lang/String
    //   114: astore 16
    //   116: new 101	java/lang/StringBuilder
    //   119: dup
    //   120: aload_3
    //   121: invokestatic 139	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   124: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: ldc 141
    //   129: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore 17
    //   137: iconst_3
    //   138: anewarray 4	java/lang/Object
    //   141: astore 18
    //   143: aload 18
    //   145: iconst_0
    //   146: aload_2
    //   147: invokevirtual 117	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   150: aastore
    //   151: aload 18
    //   153: iconst_1
    //   154: aload 12
    //   156: invokevirtual 144	com/stericson/RootTools/Mount:getDevice	()Ljava/io/File;
    //   159: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   162: aastore
    //   163: aload 18
    //   165: iconst_2
    //   166: aload 12
    //   168: invokevirtual 47	com/stericson/RootTools/Mount:getMountPoint	()Ljava/io/File;
    //   171: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   174: aastore
    //   175: aload 16
    //   177: iconst_0
    //   178: aload 17
    //   180: aload 18
    //   182: invokestatic 148	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   185: aastore
    //   186: iconst_3
    //   187: anewarray 4	java/lang/Object
    //   190: astore 19
    //   192: aload 19
    //   194: iconst_0
    //   195: aload_2
    //   196: invokevirtual 117	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   199: aastore
    //   200: aload 19
    //   202: iconst_1
    //   203: aload 12
    //   205: invokevirtual 144	com/stericson/RootTools/Mount:getDevice	()Ljava/io/File;
    //   208: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   211: aastore
    //   212: aload 19
    //   214: iconst_2
    //   215: aload 12
    //   217: invokevirtual 47	com/stericson/RootTools/Mount:getMountPoint	()Ljava/io/File;
    //   220: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   223: aastore
    //   224: aload 16
    //   226: iconst_1
    //   227: ldc 150
    //   229: aload 19
    //   231: invokestatic 148	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   234: aastore
    //   235: iconst_3
    //   236: anewarray 4	java/lang/Object
    //   239: astore 20
    //   241: aload 20
    //   243: iconst_0
    //   244: aload_2
    //   245: invokevirtual 117	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   248: aastore
    //   249: aload 20
    //   251: iconst_1
    //   252: aload 12
    //   254: invokevirtual 144	com/stericson/RootTools/Mount:getDevice	()Ljava/io/File;
    //   257: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   260: aastore
    //   261: aload 20
    //   263: iconst_2
    //   264: aload 12
    //   266: invokevirtual 47	com/stericson/RootTools/Mount:getMountPoint	()Ljava/io/File;
    //   269: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   272: aastore
    //   273: aload 16
    //   275: iconst_2
    //   276: ldc 152
    //   278: aload 20
    //   280: invokestatic 148	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   283: aastore
    //   284: aload 16
    //   286: iconst_0
    //   287: iconst_m1
    //   288: invokestatic 156	com/stericson/RootTools/RootTools:sendShell	([Ljava/lang/String;II)Ljava/util/List;
    //   291: pop
    //   292: aload_0
    //   293: aload_1
    //   294: invokespecial 94	com/stericson/RootTools/Remounter:findMountPointRecursive	(Ljava/lang/String;)Lcom/stericson/RootTools/Mount;
    //   297: astore 12
    //   299: getstatic 99	com/stericson/RootTools/InternalVariables:TAG	Ljava/lang/String;
    //   302: new 101	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   309: aload 12
    //   311: invokevirtual 130	com/stericson/RootTools/Mount:getFlags	()Ljava/util/Set;
    //   314: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   317: ldc 162
    //   319: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_2
    //   323: invokevirtual 117	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   326: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 126	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   335: pop
    //   336: aload 12
    //   338: invokevirtual 130	com/stericson/RootTools/Mount:getFlags	()Ljava/util/Set;
    //   341: aload_2
    //   342: invokevirtual 117	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   345: invokeinterface 135 2 0
    //   350: ifeq +152 -> 502
    //   353: aload 12
    //   355: invokevirtual 130	com/stericson/RootTools/Mount:getFlags	()Ljava/util/Set;
    //   358: invokevirtual 163	java/lang/Object:toString	()Ljava/lang/String;
    //   361: invokestatic 166	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   364: iconst_1
    //   365: ireturn
    //   366: ldc 168
    //   368: invokestatic 73	com/stericson/RootTools/RootTools:checkUtil	(Ljava/lang/String;)Z
    //   371: ifeq -356 -> 15
    //   374: getstatic 77	com/stericson/RootTools/RootTools:utilPath	Ljava/lang/String;
    //   377: astore_3
    //   378: goto -363 -> 15
    //   381: invokestatic 20	com/stericson/RootTools/RootTools:getMounts	()Ljava/util/ArrayList;
    //   384: invokevirtual 31	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   387: astore 6
    //   389: aload 6
    //   391: invokeinterface 37 1 0
    //   396: istore 7
    //   398: iload 7
    //   400: ifne +30 -> 430
    //   403: iload 4
    //   405: ifne -366 -> 39
    //   408: new 22	java/io/File
    //   411: dup
    //   412: aload_1
    //   413: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   416: invokevirtual 171	java/io/File:getParent	()Ljava/lang/String;
    //   419: invokevirtual 172	java/lang/String:toString	()Ljava/lang/String;
    //   422: astore 11
    //   424: aload 11
    //   426: astore_1
    //   427: goto -388 -> 39
    //   430: aload 6
    //   432: invokeinterface 41 1 0
    //   437: checkcast 43	com/stericson/RootTools/Mount
    //   440: astore 8
    //   442: aload 8
    //   444: invokevirtual 47	com/stericson/RootTools/Mount:getMountPoint	()Ljava/io/File;
    //   447: invokevirtual 173	java/io/File:toString	()Ljava/lang/String;
    //   450: invokestatic 166	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   453: aload_1
    //   454: aload 8
    //   456: invokevirtual 47	com/stericson/RootTools/Mount:getMountPoint	()Ljava/io/File;
    //   459: invokevirtual 173	java/io/File:toString	()Ljava/lang/String;
    //   462: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   465: istore 9
    //   467: iload 9
    //   469: ifeq -80 -> 389
    //   472: iconst_1
    //   473: istore 4
    //   475: goto -72 -> 403
    //   478: astore 5
    //   480: getstatic 60	com/stericson/RootTools/RootTools:debugMode	Z
    //   483: ifeq +8 -> 491
    //   486: aload 5
    //   488: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   491: iconst_0
    //   492: ireturn
    //   493: astore 10
    //   495: aload 10
    //   497: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   500: iconst_0
    //   501: ireturn
    //   502: aload 12
    //   504: invokevirtual 130	com/stericson/RootTools/Mount:getFlags	()Ljava/util/Set;
    //   507: invokevirtual 163	java/lang/Object:toString	()Ljava/lang/String;
    //   510: invokestatic 166	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   513: iconst_0
    //   514: ireturn
    //   515: astore 15
    //   517: goto -225 -> 292
    //
    // Exception table:
    //   from	to	target	type
    //   381	389	478	java/lang/Exception
    //   389	398	478	java/lang/Exception
    //   430	467	478	java/lang/Exception
    //   408	424	493	java/lang/Exception
    //   110	292	515	java/lang/Exception
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.Remounter
 * JD-Core Version:    0.6.2
 */