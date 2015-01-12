package com.baidu.mapapi.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.storage.StorageManager;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private static volatile e a = null;
  private boolean b = false;
  private boolean c = true;
  private final List<d> d = new ArrayList();
  private d e = null;
  private String f;

  public static e a()
  {
    if (a == null);
    try
    {
      if (a == null)
        a = new e();
      return a;
    }
    finally
    {
    }
  }

  // ERROR //
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 41	java/io/File
    //   3: dup
    //   4: new 43	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   11: aload_1
    //   12: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc 50
    //   17: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_2
    //   27: aload_2
    //   28: invokevirtual 61	java/io/File:exists	()Z
    //   31: ifeq +8 -> 39
    //   34: aload_2
    //   35: invokevirtual 64	java/io/File:delete	()Z
    //   38: pop
    //   39: aload_2
    //   40: invokevirtual 67	java/io/File:createNewFile	()Z
    //   43: istore 6
    //   45: iload 6
    //   47: istore 4
    //   49: aload_2
    //   50: invokevirtual 61	java/io/File:exists	()Z
    //   53: ifeq +8 -> 61
    //   56: aload_2
    //   57: invokevirtual 64	java/io/File:delete	()Z
    //   60: pop
    //   61: iload 4
    //   63: ireturn
    //   64: astore_3
    //   65: iconst_0
    //   66: istore 4
    //   68: aload_3
    //   69: astore 5
    //   71: aload 5
    //   73: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   76: iload 4
    //   78: ireturn
    //   79: astore 5
    //   81: goto -10 -> 71
    //
    // Exception table:
    //   from	to	target	type
    //   0	39	64	java/lang/Exception
    //   39	45	64	java/lang/Exception
    //   49	61	79	java/lang/Exception
  }

  @SuppressLint({"NewApi"})
  @TargetApi(14)
  private void c(Context paramContext)
  {
    while (true)
    {
      int j;
      try
      {
        StorageManager localStorageManager = (StorageManager)paramContext.getSystemService("storage");
        Method localMethod1 = localStorageManager.getClass().getMethod("getVolumeList", new Class[0]);
        Method localMethod2 = localStorageManager.getClass().getMethod("getVolumeState", new Class[] { String.class });
        Class localClass = Class.forName("android.os.storage.StorageVolume");
        Method localMethod3 = localClass.getMethod("isRemovable", new Class[0]);
        Method localMethod4 = localClass.getMethod("getPath", new Class[0]);
        Object[] arrayOfObject = (Object[])localMethod1.invoke(localStorageManager, new Object[0]);
        if (arrayOfObject != null)
        {
          int i = arrayOfObject.length;
          j = 0;
          if (j >= i)
            break label359;
          Object localObject = arrayOfObject[j];
          String str1 = (String)localMethod4.invoke(localObject, new Object[0]);
          if ((str1 == null) || (str1.length() <= 0))
            break label423;
          if (!"mounted".equals(localMethod2.invoke(localStorageManager, new Object[] { str1 })))
            break label423;
          if (((Boolean)localMethod3.invoke(localObject, new Object[0])).booleanValue())
            break label429;
          k = 1;
          if ((Build.VERSION.SDK_INT < 19) || (k != 0))
          {
            List localList = this.d;
            if (k == 0)
              break label435;
            str2 = "内置存储卡";
            localList.add(new d(str1, str2, paramContext));
          }
          else if ((Build.VERSION.SDK_INT >= 19) && (new File(str1 + File.separator + "BaiduMapSDK").exists()) && (str1.equals(paramContext.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", ""))))
          {
            this.f = (str1 + File.separator + "BaiduMapSDK");
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      while (true)
      {
        return;
        label359: if (Build.VERSION.SDK_INT >= 19)
        {
          File[] arrayOfFile = paramContext.getExternalFilesDirs(null);
          for (int m = 1; m < arrayOfFile.length; m++)
          {
            String str3 = arrayOfFile[m].getAbsolutePath();
            this.d.add(new d(str3, "外置存储卡", paramContext));
          }
        }
      }
      label423: j++;
      continue;
      label429: int k = 0;
      continue;
      label435: String str2 = "外置存储卡";
    }
  }

  // ERROR //
  private void d(Context paramContext)
  {
    // Byte code:
    //   0: new 29	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 30	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: new 29	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 30	java/util/ArrayList:<init>	()V
    //   15: astore_3
    //   16: new 41	java/io/File
    //   19: dup
    //   20: ldc 187
    //   22: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: aload 4
    //   29: invokevirtual 61	java/io/File:exists	()Z
    //   32: ifeq +103 -> 135
    //   35: new 189	java/util/Scanner
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 192	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   44: astore 8
    //   46: aload 8
    //   48: invokevirtual 195	java/util/Scanner:hasNext	()Z
    //   51: ifeq +79 -> 130
    //   54: aload 8
    //   56: invokevirtual 198	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   59: astore 20
    //   61: aload 20
    //   63: ldc 200
    //   65: invokevirtual 203	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   68: ifeq -22 -> 46
    //   71: aload 20
    //   73: bipush 9
    //   75: bipush 32
    //   77: invokevirtual 207	java/lang/String:replace	(CC)Ljava/lang/String;
    //   80: ldc 209
    //   82: invokevirtual 213	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   85: astore 21
    //   87: aload 21
    //   89: ifnull -43 -> 46
    //   92: aload 21
    //   94: arraylength
    //   95: ifle -49 -> 46
    //   98: aload_2
    //   99: aload 21
    //   101: iconst_1
    //   102: aaload
    //   103: invokeinterface 153 2 0
    //   108: pop
    //   109: goto -63 -> 46
    //   112: astore 7
    //   114: aload 7
    //   116: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   119: aload 8
    //   121: ifnull +8 -> 129
    //   124: aload 8
    //   126: invokevirtual 216	java/util/Scanner:close	()V
    //   129: return
    //   130: aload 8
    //   132: invokevirtual 216	java/util/Scanner:close	()V
    //   135: new 41	java/io/File
    //   138: dup
    //   139: ldc 218
    //   141: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   144: astore 9
    //   146: aload 9
    //   148: invokevirtual 61	java/io/File:exists	()Z
    //   151: ifeq +133 -> 284
    //   154: new 189	java/util/Scanner
    //   157: dup
    //   158: aload 9
    //   160: invokespecial 192	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   163: astore 8
    //   165: aload 8
    //   167: invokevirtual 195	java/util/Scanner:hasNext	()Z
    //   170: ifeq +109 -> 279
    //   173: aload 8
    //   175: invokevirtual 198	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   178: astore 16
    //   180: aload 16
    //   182: ldc 220
    //   184: invokevirtual 203	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   187: ifeq -22 -> 165
    //   190: aload 16
    //   192: bipush 9
    //   194: bipush 32
    //   196: invokevirtual 207	java/lang/String:replace	(CC)Ljava/lang/String;
    //   199: ldc 209
    //   201: invokevirtual 213	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   204: astore 17
    //   206: aload 17
    //   208: ifnull -43 -> 165
    //   211: aload 17
    //   213: arraylength
    //   214: ifle -49 -> 165
    //   217: aload 17
    //   219: iconst_2
    //   220: aaload
    //   221: astore 18
    //   223: aload 18
    //   225: ldc 222
    //   227: invokevirtual 226	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   230: ifeq +18 -> 248
    //   233: aload 18
    //   235: iconst_0
    //   236: aload 18
    //   238: ldc 222
    //   240: invokevirtual 230	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   243: invokevirtual 234	java/lang/String:substring	(II)Ljava/lang/String;
    //   246: astore 18
    //   248: aload_3
    //   249: aload 18
    //   251: invokeinterface 153 2 0
    //   256: pop
    //   257: goto -92 -> 165
    //   260: astore 5
    //   262: aload 8
    //   264: astore 6
    //   266: aload 6
    //   268: ifnull +8 -> 276
    //   271: aload 6
    //   273: invokevirtual 216	java/util/Scanner:close	()V
    //   276: aload 5
    //   278: athrow
    //   279: aload 8
    //   281: invokevirtual 216	java/util/Scanner:close	()V
    //   284: invokestatic 240	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   287: invokevirtual 183	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   290: astore 10
    //   292: aload_0
    //   293: getfield 32	com/baidu/mapapi/utils/e:d	Ljava/util/List;
    //   296: new 145	com/baidu/mapapi/utils/d
    //   299: dup
    //   300: aload 10
    //   302: ldc 242
    //   304: aload_1
    //   305: invokespecial 148	com/baidu/mapapi/utils/d:<init>	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   308: invokeinterface 153 2 0
    //   313: pop
    //   314: aload_2
    //   315: invokeinterface 246 1 0
    //   320: astore 12
    //   322: aload 12
    //   324: invokeinterface 249 1 0
    //   329: ifeq +104 -> 433
    //   332: aload 12
    //   334: invokeinterface 253 1 0
    //   339: checkcast 102	java/lang/String
    //   342: astore 13
    //   344: aload_3
    //   345: aload 13
    //   347: invokeinterface 255 2 0
    //   352: ifeq -30 -> 322
    //   355: aload 13
    //   357: aload 10
    //   359: invokevirtual 130	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   362: ifne -40 -> 322
    //   365: new 41	java/io/File
    //   368: dup
    //   369: aload 13
    //   371: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   374: astore 14
    //   376: aload 14
    //   378: invokevirtual 61	java/io/File:exists	()Z
    //   381: ifeq -59 -> 322
    //   384: aload 14
    //   386: invokevirtual 258	java/io/File:isDirectory	()Z
    //   389: ifeq -67 -> 322
    //   392: aload 14
    //   394: invokevirtual 261	java/io/File:canWrite	()Z
    //   397: ifeq -75 -> 322
    //   400: aload_0
    //   401: getfield 32	com/baidu/mapapi/utils/e:d	Ljava/util/List;
    //   404: new 145	com/baidu/mapapi/utils/d
    //   407: dup
    //   408: aload 13
    //   410: ldc 242
    //   412: aload_1
    //   413: invokespecial 148	com/baidu/mapapi/utils/d:<init>	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   416: invokeinterface 153 2 0
    //   421: pop
    //   422: goto -100 -> 322
    //   425: astore 7
    //   427: aconst_null
    //   428: astore 8
    //   430: goto -316 -> 114
    //   433: iconst_0
    //   434: ifeq -305 -> 129
    //   437: aconst_null
    //   438: invokevirtual 216	java/util/Scanner:close	()V
    //   441: return
    //   442: astore 5
    //   444: aconst_null
    //   445: astore 6
    //   447: goto -181 -> 266
    //   450: astore 5
    //   452: aload 8
    //   454: astore 6
    //   456: goto -190 -> 266
    //   459: astore 5
    //   461: aload 8
    //   463: astore 6
    //   465: goto -199 -> 266
    //
    // Exception table:
    //   from	to	target	type
    //   46	87	112	java/lang/Exception
    //   92	109	112	java/lang/Exception
    //   130	135	112	java/lang/Exception
    //   165	206	112	java/lang/Exception
    //   211	248	112	java/lang/Exception
    //   248	257	112	java/lang/Exception
    //   279	284	112	java/lang/Exception
    //   165	206	260	finally
    //   211	248	260	finally
    //   248	257	260	finally
    //   279	284	260	finally
    //   16	46	425	java/lang/Exception
    //   135	165	425	java/lang/Exception
    //   284	322	425	java/lang/Exception
    //   322	422	425	java/lang/Exception
    //   16	46	442	finally
    //   135	165	442	finally
    //   284	322	442	finally
    //   322	422	442	finally
    //   46	87	450	finally
    //   92	109	450	finally
    //   130	135	450	finally
    //   114	119	459	finally
  }

  public void a(Context paramContext)
  {
    int i = 0;
    if (this.b)
      return;
    this.b = true;
    while (true)
    {
      Object localObject1;
      try
      {
        if (Build.VERSION.SDK_INT >= 14)
          c(paramContext);
      }
      catch (Exception localException1)
      {
        try
        {
          while (true)
          {
            if (this.d.size() > 0)
            {
              localObject1 = null;
              Iterator localIterator = this.d.iterator();
              while (true)
                if (localIterator.hasNext())
                {
                  d locald = (d)localIterator.next();
                  boolean bool = new File(locald.b()).exists();
                  if (!bool)
                    break label424;
                  int k = i + 1;
                  localObject2 = locald;
                  j = k;
                  localObject1 = localObject2;
                  i = j;
                  continue;
                  d(paramContext);
                  break;
                  localException1 = localException1;
                  localException1.printStackTrace();
                  break;
                }
              if (i != 0)
                break label337;
              this.e = b(paramContext);
              if ((this.e == null) && (a(paramContext, (d)this.d.get(0))))
                this.e = ((d)this.d.get(0));
              if (this.e == null)
                this.e = ((d)this.d.get(0));
            }
            try
            {
              if ((this.e == null) || (!a(this.e.a())))
                break label383;
              File localFile1 = new File(this.e.b());
              if (!localFile1.exists())
                localFile1.mkdirs();
              File localFile2 = new File(this.e.c());
              if (!localFile2.exists())
                localFile2.mkdirs();
              File localFile3 = new File(localFile2, ".nomedia");
              if (localFile3.exists())
                break;
              localFile3.createNewFile();
              return;
            }
            catch (Exception localException3)
            {
              localException3.printStackTrace();
              return;
            }
          }
          label337: if (i == 1)
          {
            if (!a(paramContext, localObject1))
              continue;
            this.e = localObject1;
            continue;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          continue;
          this.e = b(paramContext);
          continue;
          label383: this.c = false;
          this.e = new d(paramContext);
          this.d.clear();
          this.d.add(this.e);
          return;
        }
      }
      label424: int j = i;
      Object localObject2 = localObject1;
    }
  }

  public boolean a(Context paramContext, d paramd)
  {
    String str = paramd.a();
    if (!a(str))
      return false;
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("map_pref", 0).edit();
    localEditor.putString("PREFFERED_SD_CARD", str);
    return localEditor.commit();
  }

  public d b()
  {
    return this.e;
  }

  public d b(Context paramContext)
  {
    String str = paramContext.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "");
    if ((str != null) && (str.length() > 0))
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald.a().equals(str))
          return locald;
      }
    }
    return null;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.baidu.mapapi.utils.e
 * JD-Core Version:    0.6.2
 */