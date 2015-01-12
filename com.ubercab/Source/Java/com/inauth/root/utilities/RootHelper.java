package com.inauth.root.utilities;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.inauth.utilities.InAuthUtilities;
import com.inauth.utilities.ndk.InAuthNDK;
import com.inauth.utilities.ndk.NDKLog;
import com.stericson.RootTools.RootTools;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class RootHelper
{
  private static RootHelper instance;

  private NDKLog decryptSigfile(String paramString1, String paramString2)
  {
    Object localObject = "COMPROMISED";
    int i = 0;
    String str;
    if (paramString1 != null)
    {
      str = InAuthNDK.getInstance().inAuthroot(paramString1);
      i = InAuthNDK.getInstance().getRootReturnCodeNDK();
      if (str != null)
      {
        if (!"GET_SIGFILE_VERSION".equals(paramString2))
          break label73;
        localObject = parseSigfileVersion(str);
      }
    }
    while (true)
    {
      NDKLog localNDKLog = new NDKLog();
      localNDKLog.setDecryptedList((String)localObject);
      localNDKLog.setReasonCode(i);
      return localNDKLog;
      label73: if ("GET_ROOT_LIST".equals(paramString2))
        localObject = str;
    }
  }

  private boolean foundRootApp(Application paramApplication, String[] paramArrayOfString)
  {
    boolean bool = false;
    List localList = paramApplication.getApplicationContext().getPackageManager().getInstalledPackages(0);
    for (int i = 1; ; i++)
    {
      String str;
      if (i < paramArrayOfString.length)
        str = paramArrayOfString[i];
      for (int j = 0; ; j++)
        if (j < localList.size())
        {
          if (((PackageInfo)localList.get(j)).applicationInfo.packageName.equalsIgnoreCase(str))
            bool = true;
        }
        else
        {
          if (!bool)
            break;
          return bool;
        }
    }
  }

  private boolean foundRootRelatedDirectories(String[] paramArrayOfString)
  {
    for (int i = 1; ; i++)
      if (i < paramArrayOfString.length)
      {
        File localFile = new File(paramArrayOfString[i]);
        if ((!localFile.exists()) && ((localFile.list() == null) || (!localFile.canRead()) || (!localFile.canWrite())));
      }
      else
      {
        return false;
      }
  }

  private static InputStream getInputStreamFromUrl(String paramString)
  {
    try
    {
      InputStream localInputStream = new DefaultHttpClient().execute(new HttpGet(paramString)).getEntity().getContent();
      return localInputStream;
    }
    catch (Exception localException)
    {
      Log.e("[GET REQUEST]", "Network exception");
    }
    return null;
  }

  public static RootHelper getInstance()
  {
    if (instance == null)
      instance = new RootHelper();
    return instance;
  }

  private boolean getSecureProp()
  {
    boolean bool1 = true;
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      Method localMethod = localClass.getMethod("get", new Class[] { String.class });
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = new String("ro.secure");
      boolean bool2 = "0".equals((String)localMethod.invoke(localClass, arrayOfObject));
      if (bool2)
        bool1 = true;
      return bool1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return false;
    }
    catch (SecurityException localSecurityException)
    {
      return false;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private JSONObject getValidation(String paramString1, String paramString2, String paramString3)
    throws IOException, JSONException
  {
    if (new File(paramString1).exists())
    {
      String str1 = getSigfileVersion(paramString1);
      String str2 = paramString3 + "/sigfile/status/android?account_guid=" + paramString2 + "&type=root&version=" + str1;
      InputStream localInputStream = getInputStreamFromUrl(str2);
      JSONObject localJSONObject = null;
      if (localInputStream != null)
      {
        Log.e("root sigfile version", str1);
        Log.e("URL sent", str2);
        try
        {
          BufferedReader localBufferedReader1 = new BufferedReader(new InputStreamReader(localInputStream, "UTF-8"));
          localBufferedReader2 = localBufferedReader1;
          localStringBuilder = new StringBuilder();
          while (true)
          {
            String str3 = localBufferedReader2.readLine();
            if (str3 == null)
              break;
            localStringBuilder.append(str3);
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          StringBuilder localStringBuilder;
          while (true)
          {
            Log.e("Error", "UnsupportedEncodingException");
            localUnsupportedEncodingException.printStackTrace();
            BufferedReader localBufferedReader2 = null;
          }
          localJSONObject = new JSONObject(localStringBuilder.toString());
        }
      }
      return localJSONObject;
    }
    Log.e("File path Error", paramString1);
    return null;
  }

  private boolean isAppProcessRunning(Application paramApplication, String[] paramArrayOfString)
  {
    boolean bool = false;
    List localList = ((ActivityManager)paramApplication.getSystemService("activity")).getRunningAppProcesses();
    for (int i = 1; ; i++)
    {
      String str;
      if (i < paramArrayOfString.length)
        str = paramArrayOfString[i];
      for (int j = 0; ; j++)
        if (j < localList.size())
        {
          if (((ActivityManager.RunningAppProcessInfo)localList.get(j)).processName.equals(str))
            bool = true;
        }
        else
        {
          if (!bool)
            break;
          return bool;
        }
    }
  }

  private boolean isDeviceRooted(Application paramApplication, String paramString, boolean paramBoolean)
  {
    RootTools.debugMode = false;
    String[] arrayOfString1 = paramString.split("#####");
    String[] arrayOfString2 = arrayOfString1[2].split("(\\r|\\n)");
    String[] arrayOfString3 = arrayOfString1[3].split("(\\r|\\n)");
    String[] arrayOfString4 = arrayOfString1[4].split("(\\r|\\n)");
    String[] arrayOfString5 = arrayOfString1[5].split("(\\r|\\n)");
    boolean bool2;
    int i;
    if (paramBoolean)
    {
      if (!RootTools.isRootAvailable())
      {
        boolean bool4 = RootTools.isAccessGiven();
        bool2 = false;
        if (!bool4);
      }
      else
      {
        bool2 = true;
      }
      if (!bool2)
      {
        boolean bool3 = foundRootApp(paramApplication, arrayOfString2);
        i = 0;
        if (bool3)
        {
          i = 0 + 3;
          if (isAppProcessRunning(paramApplication, arrayOfString2))
            i += 5;
        }
        if (i <= 5)
          break label159;
        bool2 = true;
      }
    }
    label159: 
    do
    {
      return bool2;
      boolean bool1 = isZTEDevice();
      bool2 = false;
      if (!bool1)
        break;
      bool2 = false;
      break;
      if (foundRootApp(paramApplication, arrayOfString3))
      {
        i += 3;
        if (isAppProcessRunning(paramApplication, arrayOfString3))
          i += 5;
      }
      if (i > 5)
        return true;
      if (foundRootApp(paramApplication, arrayOfString4))
      {
        i += 3;
        if (isAppProcessRunning(paramApplication, arrayOfString4))
          i += 5;
      }
      if (i > 5)
        return true;
      if (getSecureProp())
        i += 3;
      if (i > 5)
        return true;
      if (foundRootRelatedDirectories(arrayOfString5))
        i++;
    }
    while (i <= 5);
    return true;
  }

  private boolean isZTEDevice()
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      Method localMethod = localClass.getMethod("get", new Class[] { String.class });
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = new String("ro.product.manufacturer");
      arrayOfObject1[1] = new String("ro.build.version.release");
      arrayOfObject1[2] = new String("ro.build.version.sdk");
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = arrayOfObject1[0];
      String str1 = (String)localMethod.invoke(localClass, arrayOfObject2);
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = arrayOfObject1[2];
      String str2 = (String)localMethod.invoke(localClass, arrayOfObject3);
      boolean bool1 = str1.equalsIgnoreCase("zte");
      boolean bool2 = false;
      if (bool1)
      {
        boolean bool3 = str2.equalsIgnoreCase("10");
        bool2 = false;
        if (bool3)
          bool2 = true;
      }
      return bool2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return false;
    }
    catch (SecurityException localSecurityException)
    {
      return false;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private String parseSigfileVersion(String paramString)
  {
    return paramString.split("#####")[0].split("(\\r|\\n)")[0];
  }

  public RootLog getRootLog(Application paramApplication, String paramString, boolean paramBoolean)
  {
    String str1 = "COMPROMISED";
    String str2 = "MISSING_SIGFILE";
    if (InAuthUtilities.doesFileExist(paramString))
    {
      NDKLog localNDKLog = decryptSigfile(paramString, "GET_ROOT_LIST");
      if ((localNDKLog.getDecryptedList() != null) && (!"COMPROMISED".equals(localNDKLog.getDecryptedList())))
      {
        boolean bool = isDeviceRooted(paramApplication, localNDKLog.getDecryptedList(), paramBoolean);
        str2 = localNDKLog.getReasonCode();
        if (!bool)
          break label102;
      }
    }
    label102: for (str1 = "DEVICE_ROOTED"; ; str1 = "DEVICE_NOT_ROOTED")
    {
      RootLog localRootLog = new RootLog();
      localRootLog.setRootStatus(str1);
      localRootLog.setRootReasonCode(str2);
      return localRootLog;
    }
  }

  public String getSigfileVersion(String paramString)
  {
    String str = "MISSING_SIGFILE";
    if (InAuthUtilities.doesFileExist(paramString))
    {
      NDKLog localNDKLog = decryptSigfile(paramString, "GET_SIGFILE_VERSION");
      if (localNDKLog.getDecryptedList() != null)
        str = localNDKLog.getDecryptedList();
    }
    return str;
  }

  public String updateSignatureFile(String paramString1, String paramString2, String paramString3)
  {
    Future localFuture = Executors.newFixedThreadPool(1).submit(new HttpCall(paramString1, paramString2, paramString3));
    try
    {
      String str = (String)localFuture.get();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "INTERNAL_ERROR";
  }

  private class HttpCall
    implements Callable<String>
  {
    private final String accountGUID;
    private final String filePath;
    private final String serverURL;
    private String updateSignatureFileResponse = "";

    HttpCall(String paramString1, String paramString2, String arg4)
    {
      this.filePath = paramString1;
      this.accountGUID = paramString2;
      Object localObject;
      this.serverURL = localObject;
    }

    // ERROR //
    public String call()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: aload_0
      //   3: getfield 18	com/inauth/root/utilities/RootHelper$HttpCall:this$0	Lcom/inauth/root/utilities/RootHelper;
      //   6: aload_0
      //   7: getfield 27	com/inauth/root/utilities/RootHelper$HttpCall:filePath	Ljava/lang/String;
      //   10: aload_0
      //   11: getfield 29	com/inauth/root/utilities/RootHelper$HttpCall:accountGUID	Ljava/lang/String;
      //   14: aload_0
      //   15: getfield 31	com/inauth/root/utilities/RootHelper$HttpCall:serverURL	Ljava/lang/String;
      //   18: invokestatic 44	com/inauth/root/utilities/RootHelper:access$000	(Lcom/inauth/root/utilities/RootHelper;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
      //   21: astore 7
      //   23: aconst_null
      //   24: astore_1
      //   25: aload 7
      //   27: ifnull +226 -> 253
      //   30: aload 7
      //   32: ldc 46
      //   34: invokevirtual 52	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   37: astore 8
      //   39: aload 8
      //   41: ldc 54
      //   43: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   46: ifeq +17 -> 63
      //   49: aload_0
      //   50: ldc 62
      //   52: putfield 25	com/inauth/root/utilities/RootHelper$HttpCall:updateSignatureFileResponse	Ljava/lang/String;
      //   55: ldc 46
      //   57: ldc 54
      //   59: invokestatic 68	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   62: pop
      //   63: aload 8
      //   65: ldc 70
      //   67: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   70: istore 9
      //   72: aconst_null
      //   73: astore_1
      //   74: iload 9
      //   76: ifeq +177 -> 253
      //   79: aload 7
      //   81: ldc 72
      //   83: invokevirtual 52	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   86: astore 10
      //   88: ldc 46
      //   90: new 74	java/lang/StringBuilder
      //   93: dup
      //   94: invokespecial 75	java/lang/StringBuilder:<init>	()V
      //   97: ldc 77
      //   99: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: aload 10
      //   104: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   107: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   110: invokestatic 68	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   113: pop
      //   114: aload 10
      //   116: invokestatic 88	com/inauth/root/utilities/RootHelper:access$100	(Ljava/lang/String;)Ljava/io/InputStream;
      //   119: astore 12
      //   121: aconst_null
      //   122: astore_1
      //   123: aload 12
      //   125: ifnull +154 -> 279
      //   128: new 90	java/io/BufferedInputStream
      //   131: dup
      //   132: aload 12
      //   134: invokespecial 93	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   137: astore 13
      //   139: new 95	org/apache/http/util/ByteArrayBuffer
      //   142: dup
      //   143: sipush 5000
      //   146: invokespecial 98	org/apache/http/util/ByteArrayBuffer:<init>	(I)V
      //   149: astore 14
      //   151: aload 13
      //   153: invokevirtual 102	java/io/BufferedInputStream:read	()I
      //   156: istore 15
      //   158: iload 15
      //   160: iconst_m1
      //   161: if_icmpeq +52 -> 213
      //   164: aload 14
      //   166: iload 15
      //   168: i2b
      //   169: invokevirtual 104	org/apache/http/util/ByteArrayBuffer:append	(I)V
      //   172: goto -21 -> 151
      //   175: astore 4
      //   177: aload_0
      //   178: ldc 106
      //   180: putfield 25	com/inauth/root/utilities/RootHelper$HttpCall:updateSignatureFileResponse	Ljava/lang/String;
      //   183: ldc 108
      //   185: ldc 110
      //   187: invokestatic 68	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   190: pop
      //   191: aload 4
      //   193: invokevirtual 113	java/lang/Exception:printStackTrace	()V
      //   196: aload_1
      //   197: ifnull +11 -> 208
      //   200: aload_1
      //   201: invokevirtual 118	java/io/FileOutputStream:flush	()V
      //   204: aload_1
      //   205: invokevirtual 121	java/io/FileOutputStream:close	()V
      //   208: aload_0
      //   209: getfield 25	com/inauth/root/utilities/RootHelper$HttpCall:updateSignatureFileResponse	Ljava/lang/String;
      //   212: areturn
      //   213: new 115	java/io/FileOutputStream
      //   216: dup
      //   217: aload_0
      //   218: getfield 27	com/inauth/root/utilities/RootHelper$HttpCall:filePath	Ljava/lang/String;
      //   221: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   224: astore 16
      //   226: aload 16
      //   228: aload 14
      //   230: invokevirtual 128	org/apache/http/util/ByteArrayBuffer:toByteArray	()[B
      //   233: invokevirtual 132	java/io/FileOutputStream:write	([B)V
      //   236: aload_0
      //   237: ldc 134
      //   239: putfield 25	com/inauth/root/utilities/RootHelper$HttpCall:updateSignatureFileResponse	Ljava/lang/String;
      //   242: ldc 136
      //   244: ldc 138
      //   246: invokestatic 68	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   249: pop
      //   250: aload 16
      //   252: astore_1
      //   253: aload_1
      //   254: ifnull -46 -> 208
      //   257: aload_1
      //   258: invokevirtual 118	java/io/FileOutputStream:flush	()V
      //   261: aload_1
      //   262: invokevirtual 121	java/io/FileOutputStream:close	()V
      //   265: goto -57 -> 208
      //   268: astore 18
      //   270: aload_0
      //   271: ldc 106
      //   273: putfield 25	com/inauth/root/utilities/RootHelper$HttpCall:updateSignatureFileResponse	Ljava/lang/String;
      //   276: goto -68 -> 208
      //   279: aload_0
      //   280: ldc 106
      //   282: putfield 25	com/inauth/root/utilities/RootHelper$HttpCall:updateSignatureFileResponse	Ljava/lang/String;
      //   285: aconst_null
      //   286: astore_1
      //   287: goto -34 -> 253
      //   290: astore_2
      //   291: aload_1
      //   292: ifnull +11 -> 303
      //   295: aload_1
      //   296: invokevirtual 118	java/io/FileOutputStream:flush	()V
      //   299: aload_1
      //   300: invokevirtual 121	java/io/FileOutputStream:close	()V
      //   303: aload_2
      //   304: athrow
      //   305: astore 6
      //   307: aload_0
      //   308: ldc 106
      //   310: putfield 25	com/inauth/root/utilities/RootHelper$HttpCall:updateSignatureFileResponse	Ljava/lang/String;
      //   313: goto -105 -> 208
      //   316: astore_3
      //   317: aload_0
      //   318: ldc 106
      //   320: putfield 25	com/inauth/root/utilities/RootHelper$HttpCall:updateSignatureFileResponse	Ljava/lang/String;
      //   323: goto -20 -> 303
      //   326: astore_2
      //   327: aload 16
      //   329: astore_1
      //   330: goto -39 -> 291
      //   333: astore 4
      //   335: aload 16
      //   337: astore_1
      //   338: goto -161 -> 177
      //
      // Exception table:
      //   from	to	target	type
      //   2	23	175	java/lang/Exception
      //   30	63	175	java/lang/Exception
      //   63	72	175	java/lang/Exception
      //   79	121	175	java/lang/Exception
      //   128	151	175	java/lang/Exception
      //   151	158	175	java/lang/Exception
      //   164	172	175	java/lang/Exception
      //   213	226	175	java/lang/Exception
      //   279	285	175	java/lang/Exception
      //   257	265	268	java/lang/Exception
      //   2	23	290	finally
      //   30	63	290	finally
      //   63	72	290	finally
      //   79	121	290	finally
      //   128	151	290	finally
      //   151	158	290	finally
      //   164	172	290	finally
      //   177	196	290	finally
      //   213	226	290	finally
      //   279	285	290	finally
      //   200	208	305	java/lang/Exception
      //   295	303	316	java/lang/Exception
      //   226	250	326	finally
      //   226	250	333	java/lang/Exception
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.inauth.root.utilities.RootHelper
 * JD-Core Version:    0.6.2
 */