package com.ubercab.library.network.cn.strategy;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.ubercab.common.io.IOUtils;
import com.ubercab.library.network.FailoverStrategy;
import com.ubercab.library.network.cn.CnApi;
import com.ubercab.library.network.cn.model.Cn;
import com.ubercab.library.network.cn.model.CnFile;
import com.ubercab.library.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RestAdapter.Builder;
import retrofit.RestAdapter.Log;
import retrofit.RestAdapter.LogLevel;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;
import timber.log.Timber;
import timber.log.Timber.Tree;

public class CnListFailoverStrategy
  implements FailoverStrategy
{
  private static final String FILE_NAME = "cn";
  private static final String HEADER_CN_FILE_HASH = "cn.txt";
  public static final String NAME = "cnList";
  private static final String TAG = "CnEndpointManager";
  private String mCnEndpointUrl;
  private CnFile mCnFile;
  private String mCnFileHash;
  private final Object mCnFileLock = new Object();
  private int mCnIndex;
  private Context mContext;
  private Gson mGson;

  public CnListFailoverStrategy(Context paramContext, Gson paramGson)
  {
    this.mContext = paramContext;
    this.mGson = paramGson;
    loadCnFile();
    randomizeCns();
    createCnEndpoint();
  }

  private void createCnEndpoint()
  {
    this.mCnEndpointUrl = ((Cn)this.mCnFile.getCnList().get(this.mCnIndex)).createEndpoint();
  }

  private void loadCnFile()
  {
    try
    {
      loadCnFileFromCache();
      return;
    }
    catch (IOException localIOException)
    {
      loadCnFileFromRawAssets();
      return;
    }
    finally
    {
      if (this.mCnFile == null)
        this.mCnFile = CnFile.createDefault();
    }
  }

  // ERROR //
  private void loadCnFileFromCache()
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 102	java/io/FileInputStream
    //   5: dup
    //   6: new 104	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: getfield 40	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy:mContext	Landroid/content/Context;
    //   14: invokevirtual 110	android/content/Context:getCacheDir	()Ljava/io/File;
    //   17: ldc 10
    //   19: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   22: invokespecial 116	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore_2
    //   26: aload_2
    //   27: invokestatic 122	com/ubercab/common/io/IOUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   30: astore 5
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 42	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy:mGson	Lcom/google/gson/Gson;
    //   37: new 124	java/lang/String
    //   40: dup
    //   41: aload 5
    //   43: invokespecial 127	java/lang/String:<init>	([B)V
    //   46: ldc 68
    //   48: invokevirtual 133	com/google/gson/Gson:fromJson	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   51: checkcast 68	com/ubercab/library/network/cn/model/CnFile
    //   54: putfield 57	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy:mCnFile	Lcom/ubercab/library/network/cn/model/CnFile;
    //   57: aload_0
    //   58: aload 5
    //   60: invokestatic 139	com/ubercab/library/util/StringUtils:md5	([B)Ljava/lang/String;
    //   63: putfield 61	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy:mCnFileHash	Ljava/lang/String;
    //   66: aload_2
    //   67: invokestatic 143	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   70: return
    //   71: astore_3
    //   72: aload_3
    //   73: athrow
    //   74: astore 4
    //   76: aload_1
    //   77: invokestatic 143	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   80: aload 4
    //   82: athrow
    //   83: astore 4
    //   85: aload_2
    //   86: astore_1
    //   87: goto -11 -> 76
    //   90: astore_3
    //   91: aload_2
    //   92: astore_1
    //   93: goto -21 -> 72
    //
    // Exception table:
    //   from	to	target	type
    //   2	26	71	java/io/IOException
    //   2	26	74	finally
    //   72	74	74	finally
    //   26	66	83	finally
    //   26	66	90	java/io/IOException
  }

  private void loadCnFileFromRawAssets()
  {
    InputStream localInputStream = null;
    try
    {
      Resources localResources = this.mContext.getResources();
      localInputStream = localResources.openRawResource(localResources.getIdentifier("raw/cn", "raw", this.mContext.getPackageName()));
      byte[] arrayOfByte = IOUtils.toByteArray(localInputStream);
      this.mCnFile = ((CnFile)this.mGson.fromJson(new String(arrayOfByte), CnFile.class));
      this.mCnFileHash = StringUtils.md5(arrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      Timber.e(localException, "Failed to load the cn file from raw assets.", new Object[0]);
      this.mCnFile = CnFile.createDefault();
      this.mCnFileHash = null;
      return;
    }
    finally
    {
      IOUtils.closeQuietly(localInputStream);
    }
  }

  private void randomizeCns()
  {
    Collections.shuffle(this.mCnFile.getCnList());
  }

  private void validateCnFileHash(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    while ((!TextUtils.isEmpty(this.mCnFileHash)) && (paramString.equals(this.mCnFileHash)))
      return;
    RestAdapter.Log local1 = new RestAdapter.Log()
    {
      public void log(String paramAnonymousString)
      {
        Timber.tag("CnEndpointManager").d(paramAnonymousString, new Object[0]);
      }
    };
    Callback local2 = new Callback()
    {
      public void failure(RetrofitError paramAnonymousRetrofitError)
      {
      }

      // ERROR //
      public void success(CnFile paramAnonymousCnFile, Response paramAnonymousResponse)
      {
        // Byte code:
        //   0: aload_2
        //   1: invokevirtual 33	retrofit/client/Response:getBody	()Lretrofit/mime/TypedInput;
        //   4: checkcast 35	retrofit/mime/TypedByteArray
        //   7: invokevirtual 39	retrofit/mime/TypedByteArray:getBytes	()[B
        //   10: astore_3
        //   11: aload_0
        //   12: getfield 18	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy$2:this$0	Lcom/ubercab/library/network/cn/strategy/CnListFailoverStrategy;
        //   15: invokestatic 43	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy:access$000	(Lcom/ubercab/library/network/cn/strategy/CnListFailoverStrategy;)Ljava/lang/Object;
        //   18: astore 4
        //   20: aload 4
        //   22: monitorenter
        //   23: aload_0
        //   24: getfield 18	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy$2:this$0	Lcom/ubercab/library/network/cn/strategy/CnListFailoverStrategy;
        //   27: aload_1
        //   28: invokestatic 47	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy:access$102	(Lcom/ubercab/library/network/cn/strategy/CnListFailoverStrategy;Lcom/ubercab/library/network/cn/model/CnFile;)Lcom/ubercab/library/network/cn/model/CnFile;
        //   31: pop
        //   32: aload_0
        //   33: getfield 18	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy$2:this$0	Lcom/ubercab/library/network/cn/strategy/CnListFailoverStrategy;
        //   36: aload_3
        //   37: invokestatic 53	com/ubercab/library/util/StringUtils:md5	([B)Ljava/lang/String;
        //   40: invokestatic 57	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy:access$202	(Lcom/ubercab/library/network/cn/strategy/CnListFailoverStrategy;Ljava/lang/String;)Ljava/lang/String;
        //   43: pop
        //   44: aload_0
        //   45: getfield 18	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy$2:this$0	Lcom/ubercab/library/network/cn/strategy/CnListFailoverStrategy;
        //   48: invokestatic 60	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy:access$300	(Lcom/ubercab/library/network/cn/strategy/CnListFailoverStrategy;)V
        //   51: aload_0
        //   52: getfield 18	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy$2:this$0	Lcom/ubercab/library/network/cn/strategy/CnListFailoverStrategy;
        //   55: invokestatic 63	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy:access$400	(Lcom/ubercab/library/network/cn/strategy/CnListFailoverStrategy;)V
        //   58: aload 4
        //   60: monitorexit
        //   61: aconst_null
        //   62: astore 8
        //   64: new 65	java/io/FileOutputStream
        //   67: dup
        //   68: new 67	java/io/File
        //   71: dup
        //   72: aload_0
        //   73: getfield 18	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy$2:this$0	Lcom/ubercab/library/network/cn/strategy/CnListFailoverStrategy;
        //   76: invokestatic 71	com/ubercab/library/network/cn/strategy/CnListFailoverStrategy:access$500	(Lcom/ubercab/library/network/cn/strategy/CnListFailoverStrategy;)Landroid/content/Context;
        //   79: invokevirtual 77	android/content/Context:getCacheDir	()Ljava/io/File;
        //   82: ldc 79
        //   84: invokespecial 82	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   87: invokespecial 85	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   90: astore 9
        //   92: aload 9
        //   94: aload_3
        //   95: invokevirtual 89	java/io/FileOutputStream:write	([B)V
        //   98: aload 9
        //   100: invokevirtual 92	java/io/FileOutputStream:flush	()V
        //   103: aload 9
        //   105: invokestatic 98	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
        //   108: return
        //   109: astore 5
        //   111: aload 4
        //   113: monitorexit
        //   114: aload 5
        //   116: athrow
        //   117: astore 12
        //   119: aload 8
        //   121: invokestatic 98	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
        //   124: return
        //   125: astore 11
        //   127: aload 8
        //   129: invokestatic 98	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
        //   132: aload 11
        //   134: athrow
        //   135: astore 11
        //   137: aload 9
        //   139: astore 8
        //   141: goto -14 -> 127
        //   144: astore 10
        //   146: aload 9
        //   148: astore 8
        //   150: goto -31 -> 119
        //
        // Exception table:
        //   from	to	target	type
        //   23	61	109	finally
        //   111	114	109	finally
        //   64	92	117	java/io/IOException
        //   64	92	125	finally
        //   92	103	135	finally
        //   92	103	144	java/io/IOException
      }
    };
    ((CnApi)new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL).setConverter(new GsonConverter(this.mGson)).setEndpoint(this.mCnEndpointUrl).setLog(local1).build().create(CnApi.class)).cnFile(local2);
  }

  public void changeEndpoint()
  {
    synchronized (this.mCnFileLock)
    {
      int i = 1 + this.mCnIndex;
      this.mCnIndex = i;
      if (i >= this.mCnFile.getCnList().size())
        this.mCnIndex = 0;
      createCnEndpoint();
      return;
    }
  }

  public String getName()
  {
    return "cnList";
  }

  public String getUrl()
  {
    return this.mCnEndpointUrl;
  }

  public boolean interceptResponse(Response paramResponse)
  {
    List localList = paramResponse.getHeaders();
    if (localList == null)
      return false;
    HashMap localHashMap = new HashMap();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      Header localHeader = (Header)localIterator.next();
      if ((localHeader.getName() != null) && (localHeader.getName().equals("File-Hashes")))
      {
        String[] arrayOfString = localHeader.getValue().split("=");
        localHashMap.put(arrayOfString[0], arrayOfString[1]);
      }
    }
    validateCnFileHash((String)localHashMap.get("cn.txt"));
    return false;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.cn.strategy.CnListFailoverStrategy
 * JD-Core Version:    0.6.2
 */