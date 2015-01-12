package com.stericson.RootTools;

import android.content.Context;
import java.io.File;
import java.io.IOException;

class Installer
{
  private static final String BOGUS_FILE_NAME = "bogus";
  private static final String LOG_TAG = "RootTools::Installer";
  private Context context;
  private String filesPath;

  public Installer(Context paramContext)
    throws IOException
  {
    this.context = paramContext;
    this.filesPath = paramContext.getFilesDir().getCanonicalPath();
  }

  // ERROR //
  protected boolean installBinary(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 31	java/io/File
    //   3: dup
    //   4: new 45	java/lang/StringBuilder
    //   7: dup
    //   8: aload_0
    //   9: getfield 37	com/stericson/RootTools/Installer:filesPath	Ljava/lang/String;
    //   12: invokestatic 51	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   15: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: getstatic 57	java/io/File:separator	Ljava/lang/String;
    //   21: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_2
    //   25: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore 4
    //   36: aload 4
    //   38: invokevirtual 69	java/io/File:exists	()Z
    //   41: ifne +135 -> 176
    //   44: aload_0
    //   45: getfield 23	com/stericson/RootTools/Installer:context	Landroid/content/Context;
    //   48: ldc 8
    //   50: invokevirtual 73	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   53: invokevirtual 78	java/io/FileInputStream:close	()V
    //   56: aload_0
    //   57: getfield 23	com/stericson/RootTools/Installer:context	Landroid/content/Context;
    //   60: invokevirtual 82	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   63: iload_1
    //   64: invokevirtual 88	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   67: astore 17
    //   69: aconst_null
    //   70: astore 18
    //   72: new 90	java/io/FileOutputStream
    //   75: dup
    //   76: aload 4
    //   78: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   81: astore 19
    //   83: sipush 4096
    //   86: newarray byte
    //   88: astore 25
    //   90: aload 17
    //   92: aload 25
    //   94: invokevirtual 99	java/io/InputStream:read	([B)I
    //   97: istore 29
    //   99: iconst_m1
    //   100: iload 29
    //   102: if_icmpne +218 -> 320
    //   105: aload 19
    //   107: ifnull +8 -> 115
    //   110: aload 19
    //   112: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   115: aload 17
    //   117: invokevirtual 101	java/io/InputStream:close	()V
    //   120: iconst_1
    //   121: anewarray 47	java/lang/String
    //   124: astore 33
    //   126: aload 33
    //   128: iconst_0
    //   129: new 45	java/lang/StringBuilder
    //   132: dup
    //   133: ldc 103
    //   135: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   138: aload_3
    //   139: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc 105
    //   144: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_0
    //   148: getfield 37	com/stericson/RootTools/Installer:filesPath	Ljava/lang/String;
    //   151: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: getstatic 57	java/io/File:separator	Ljava/lang/String;
    //   157: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_2
    //   161: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: aastore
    //   168: aload 33
    //   170: iconst_0
    //   171: iconst_m1
    //   172: invokestatic 111	com/stericson/RootTools/RootTools:sendShell	([Ljava/lang/String;II)Ljava/util/List;
    //   175: pop
    //   176: iconst_1
    //   177: ireturn
    //   178: astore 7
    //   180: aconst_null
    //   181: astore 8
    //   183: aload_0
    //   184: getfield 23	com/stericson/RootTools/Installer:context	Landroid/content/Context;
    //   187: ldc 8
    //   189: iconst_0
    //   190: invokevirtual 115	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   193: astore 8
    //   195: aload 8
    //   197: ldc 117
    //   199: invokevirtual 121	java/lang/String:getBytes	()[B
    //   202: invokevirtual 125	java/io/FileOutputStream:write	([B)V
    //   205: aload 8
    //   207: ifnull -151 -> 56
    //   210: aload 8
    //   212: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   215: aload_0
    //   216: getfield 23	com/stericson/RootTools/Installer:context	Landroid/content/Context;
    //   219: ldc 8
    //   221: invokevirtual 129	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   224: pop
    //   225: goto -169 -> 56
    //   228: astore 16
    //   230: goto -174 -> 56
    //   233: astore 12
    //   235: getstatic 133	com/stericson/RootTools/RootTools:debugMode	Z
    //   238: ifeq +14 -> 252
    //   241: ldc 11
    //   243: aload 12
    //   245: invokevirtual 134	java/lang/Exception:toString	()Ljava/lang/String;
    //   248: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   251: pop
    //   252: aload 8
    //   254: ifnull +18 -> 272
    //   257: aload 8
    //   259: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   262: aload_0
    //   263: getfield 23	com/stericson/RootTools/Installer:context	Landroid/content/Context;
    //   266: ldc 8
    //   268: invokevirtual 129	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   271: pop
    //   272: iconst_0
    //   273: ireturn
    //   274: astore 9
    //   276: aload 8
    //   278: ifnull +18 -> 296
    //   281: aload 8
    //   283: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   286: aload_0
    //   287: getfield 23	com/stericson/RootTools/Installer:context	Landroid/content/Context;
    //   290: ldc 8
    //   292: invokevirtual 129	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   295: pop
    //   296: aload 9
    //   298: athrow
    //   299: astore 5
    //   301: getstatic 133	com/stericson/RootTools/RootTools:debugMode	Z
    //   304: ifeq +14 -> 318
    //   307: ldc 11
    //   309: aload 5
    //   311: invokevirtual 141	java/io/IOException:toString	()Ljava/lang/String;
    //   314: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   317: pop
    //   318: iconst_0
    //   319: ireturn
    //   320: aload 19
    //   322: aload 25
    //   324: iconst_0
    //   325: iload 29
    //   327: invokevirtual 144	java/io/FileOutputStream:write	([BII)V
    //   330: goto -240 -> 90
    //   333: astore 26
    //   335: getstatic 133	com/stericson/RootTools/RootTools:debugMode	Z
    //   338: ifeq +14 -> 352
    //   341: ldc 11
    //   343: aload 26
    //   345: invokevirtual 141	java/io/IOException:toString	()Ljava/lang/String;
    //   348: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   351: pop
    //   352: aload 19
    //   354: ifnull +8 -> 362
    //   357: aload 19
    //   359: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   362: iconst_0
    //   363: ireturn
    //   364: astore 20
    //   366: getstatic 133	com/stericson/RootTools/RootTools:debugMode	Z
    //   369: ifeq +14 -> 383
    //   372: ldc 11
    //   374: aload 20
    //   376: invokevirtual 145	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   379: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   382: pop
    //   383: aload 18
    //   385: ifnull +8 -> 393
    //   388: aload 18
    //   390: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   393: iconst_0
    //   394: ireturn
    //   395: astore 21
    //   397: aload 18
    //   399: ifnull +8 -> 407
    //   402: aload 18
    //   404: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   407: aload 21
    //   409: athrow
    //   410: astore 30
    //   412: getstatic 133	com/stericson/RootTools/RootTools:debugMode	Z
    //   415: ifeq +14 -> 429
    //   418: ldc 11
    //   420: aload 30
    //   422: invokevirtual 141	java/io/IOException:toString	()Ljava/lang/String;
    //   425: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   428: pop
    //   429: iconst_0
    //   430: ireturn
    //   431: astore 27
    //   433: goto -71 -> 362
    //   436: astore 23
    //   438: goto -45 -> 393
    //   441: astore 22
    //   443: goto -36 -> 407
    //   446: astore 35
    //   448: goto -333 -> 115
    //   451: astore 32
    //   453: goto -277 -> 176
    //   456: astore 21
    //   458: aload 19
    //   460: astore 18
    //   462: goto -65 -> 397
    //   465: astore 20
    //   467: aload 19
    //   469: astore 18
    //   471: goto -105 -> 366
    //   474: astore 10
    //   476: goto -180 -> 296
    //   479: astore 13
    //   481: goto -209 -> 272
    //
    // Exception table:
    //   from	to	target	type
    //   44	56	178	java/io/FileNotFoundException
    //   210	225	228	java/io/IOException
    //   183	205	233	java/lang/Exception
    //   183	205	274	finally
    //   235	252	274	finally
    //   44	56	299	java/io/IOException
    //   90	99	333	java/io/IOException
    //   320	330	333	java/io/IOException
    //   72	83	364	java/io/FileNotFoundException
    //   72	83	395	finally
    //   366	383	395	finally
    //   115	120	410	java/io/IOException
    //   357	362	431	java/io/IOException
    //   388	393	436	java/io/IOException
    //   402	407	441	java/io/IOException
    //   110	115	446	java/io/IOException
    //   120	176	451	java/lang/Exception
    //   83	90	456	finally
    //   90	99	456	finally
    //   320	330	456	finally
    //   335	352	456	finally
    //   83	90	465	java/io/FileNotFoundException
    //   90	99	465	java/io/FileNotFoundException
    //   320	330	465	java/io/FileNotFoundException
    //   335	352	465	java/io/FileNotFoundException
    //   281	296	474	java/io/IOException
    //   257	272	479	java/io/IOException
  }

  protected boolean isBinaryInstalled(String paramString)
  {
    boolean bool1 = new File(this.filesPath + File.separator + paramString).exists();
    boolean bool2 = false;
    if (bool1)
      bool2 = true;
    return bool2;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.Installer
 * JD-Core Version:    0.6.2
 */