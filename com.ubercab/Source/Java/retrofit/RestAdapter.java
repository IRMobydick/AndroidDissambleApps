package retrofit;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import retrofit.client.Client;
import retrofit.client.Client.Provider;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.converter.Converter;
import retrofit.mime.MimeUtil;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class RestAdapter
{
  static final String IDLE_THREAD_NAME = "Retrofit-Idle";
  static final String THREAD_PREFIX = "Retrofit-";
  final Executor callbackExecutor;
  private final Client.Provider clientProvider;
  final Converter converter;
  final ErrorHandler errorHandler;
  final Executor httpExecutor;
  final Log log;
  volatile LogLevel logLevel;
  private final Profiler profiler;
  final RequestInterceptor requestInterceptor;
  private RxSupport rxSupport;
  final Endpoint server;
  private final Map<Class<?>, Map<Method, RestMethodInfo>> serviceMethodInfoCache = new LinkedHashMap();

  private RestAdapter(Endpoint paramEndpoint, Client.Provider paramProvider, Executor paramExecutor1, Executor paramExecutor2, RequestInterceptor paramRequestInterceptor, Converter paramConverter, Profiler paramProfiler, ErrorHandler paramErrorHandler, Log paramLog, LogLevel paramLogLevel)
  {
    this.server = paramEndpoint;
    this.clientProvider = paramProvider;
    this.httpExecutor = paramExecutor1;
    this.callbackExecutor = paramExecutor2;
    this.requestInterceptor = paramRequestInterceptor;
    this.converter = paramConverter;
    this.profiler = paramProfiler;
    this.errorHandler = paramErrorHandler;
    this.log = paramLog;
    this.logLevel = paramLogLevel;
  }

  static RestMethodInfo getMethodInfo(Map<Method, RestMethodInfo> paramMap, Method paramMethod)
  {
    try
    {
      RestMethodInfo localRestMethodInfo = (RestMethodInfo)paramMap.get(paramMethod);
      if (localRestMethodInfo == null)
      {
        localRestMethodInfo = new RestMethodInfo(paramMethod);
        paramMap.put(paramMethod, localRestMethodInfo);
      }
      return localRestMethodInfo;
    }
    finally
    {
    }
  }

  private static Profiler.RequestInformation getRequestInfo(String paramString, RestMethodInfo paramRestMethodInfo, Request paramRequest)
  {
    long l = 0L;
    TypedOutput localTypedOutput = paramRequest.getBody();
    String str = null;
    if (localTypedOutput != null)
    {
      l = localTypedOutput.length();
      str = localTypedOutput.mimeType();
    }
    return new Profiler.RequestInformation(paramRestMethodInfo.requestMethod, paramString, paramRestMethodInfo.requestUrl, l, str);
  }

  private Response logAndReplaceResponse(String paramString, Response paramResponse, long paramLong)
    throws IOException
  {
    Log localLog1 = this.log;
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = Integer.valueOf(paramResponse.getStatus());
    arrayOfObject1[1] = paramString;
    arrayOfObject1[2] = Long.valueOf(paramLong);
    localLog1.log(String.format("<--- HTTP %s %s (%sms)", arrayOfObject1));
    if (this.logLevel.ordinal() >= LogLevel.HEADERS.ordinal())
    {
      Iterator localIterator = paramResponse.getHeaders().iterator();
      while (localIterator.hasNext())
      {
        Header localHeader = (Header)localIterator.next();
        this.log.log(localHeader.toString());
      }
      long l = 0L;
      TypedInput localTypedInput = paramResponse.getBody();
      if (localTypedInput != null)
      {
        l = localTypedInput.length();
        if (this.logLevel.ordinal() >= LogLevel.FULL.ordinal())
        {
          if (!paramResponse.getHeaders().isEmpty())
            this.log.log("");
          if (!(localTypedInput instanceof TypedByteArray))
          {
            paramResponse = Utils.readBodyToBytesIfNecessary(paramResponse);
            localTypedInput = paramResponse.getBody();
          }
          byte[] arrayOfByte = ((TypedByteArray)localTypedInput).getBytes();
          l = arrayOfByte.length;
          String str = MimeUtil.parseCharset(localTypedInput.mimeType());
          this.log.log(new String(arrayOfByte, str));
        }
      }
      Log localLog2 = this.log;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Long.valueOf(l);
      localLog2.log(String.format("<--- END HTTP (%s-byte body)", arrayOfObject2));
    }
    return paramResponse;
  }

  public <T> T create(Class<T> paramClass)
  {
    Utils.validateServiceClass(paramClass);
    return Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, new RestHandler(getMethodInfoCache(paramClass)));
  }

  public LogLevel getLogLevel()
  {
    return this.logLevel;
  }

  Map<Method, RestMethodInfo> getMethodInfoCache(Class<?> paramClass)
  {
    synchronized (this.serviceMethodInfoCache)
    {
      Object localObject2 = (Map)this.serviceMethodInfoCache.get(paramClass);
      if (localObject2 == null)
      {
        localObject2 = new LinkedHashMap();
        this.serviceMethodInfoCache.put(paramClass, localObject2);
      }
      return localObject2;
    }
  }

  Request logAndReplaceRequest(String paramString, Request paramRequest)
    throws IOException
  {
    Log localLog = this.log;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramString;
    arrayOfObject[1] = paramRequest.getMethod();
    arrayOfObject[2] = paramRequest.getUrl();
    localLog.log(String.format("---> %s %s %s", arrayOfObject));
    if (this.logLevel.ordinal() >= LogLevel.HEADERS.ordinal())
    {
      Iterator localIterator = paramRequest.getHeaders().iterator();
      while (localIterator.hasNext())
      {
        Header localHeader = (Header)localIterator.next();
        this.log.log(localHeader.toString());
      }
      String str1 = "no";
      TypedOutput localTypedOutput = paramRequest.getBody();
      if (localTypedOutput != null)
      {
        String str2 = localTypedOutput.mimeType();
        if (str2 != null)
          this.log.log("Content-Type: " + str2);
        long l = localTypedOutput.length();
        str1 = l + "-byte";
        if (l != -1L)
          this.log.log("Content-Length: " + l);
        if (this.logLevel.ordinal() >= LogLevel.FULL.ordinal())
        {
          if (!paramRequest.getHeaders().isEmpty())
            this.log.log("");
          if (!(localTypedOutput instanceof TypedByteArray))
          {
            paramRequest = Utils.readBodyToBytesIfNecessary(paramRequest);
            localTypedOutput = paramRequest.getBody();
          }
          byte[] arrayOfByte = ((TypedByteArray)localTypedOutput).getBytes();
          String str3 = MimeUtil.parseCharset(localTypedOutput.mimeType());
          this.log.log(new String(arrayOfByte, str3));
        }
      }
      this.log.log(String.format("---> END %s (%s body)", new Object[] { paramString, str1 }));
    }
    return paramRequest;
  }

  void logException(Throwable paramThrowable, String paramString)
  {
    Log localLog = this.log;
    Object[] arrayOfObject = new Object[1];
    if (paramString != null);
    while (true)
    {
      arrayOfObject[0] = paramString;
      localLog.log(String.format("---- ERROR %s", arrayOfObject));
      StringWriter localStringWriter = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
      this.log.log(localStringWriter.toString());
      this.log.log("---- END ERROR");
      return;
      paramString = "";
    }
  }

  public void setLogLevel(LogLevel paramLogLevel)
  {
    if (this.logLevel == null)
      throw new NullPointerException("Log level may not be null.");
    this.logLevel = paramLogLevel;
  }

  public static class Builder
  {
    private Executor callbackExecutor;
    private Client.Provider clientProvider;
    private Converter converter;
    private Endpoint endpoint;
    private ErrorHandler errorHandler;
    private Executor httpExecutor;
    private RestAdapter.Log log;
    private RestAdapter.LogLevel logLevel = RestAdapter.LogLevel.NONE;
    private Profiler profiler;
    private RequestInterceptor requestInterceptor;

    private void ensureSaneDefaults()
    {
      if (this.converter == null)
        this.converter = Platform.get().defaultConverter();
      if (this.clientProvider == null)
        this.clientProvider = Platform.get().defaultClient();
      if (this.httpExecutor == null)
        this.httpExecutor = Platform.get().defaultHttpExecutor();
      if (this.callbackExecutor == null)
        this.callbackExecutor = Platform.get().defaultCallbackExecutor();
      if (this.errorHandler == null)
        this.errorHandler = ErrorHandler.DEFAULT;
      if (this.log == null)
        this.log = Platform.get().defaultLog();
      if (this.requestInterceptor == null)
        this.requestInterceptor = RequestInterceptor.NONE;
    }

    public RestAdapter build()
    {
      if (this.endpoint == null)
        throw new IllegalArgumentException("Endpoint may not be null.");
      ensureSaneDefaults();
      return new RestAdapter(this.endpoint, this.clientProvider, this.httpExecutor, this.callbackExecutor, this.requestInterceptor, this.converter, this.profiler, this.errorHandler, this.log, this.logLevel, null);
    }

    public Builder setClient(Client.Provider paramProvider)
    {
      if (paramProvider == null)
        throw new NullPointerException("Client provider may not be null.");
      this.clientProvider = paramProvider;
      return this;
    }

    public Builder setClient(final Client paramClient)
    {
      if (paramClient == null)
        throw new NullPointerException("Client may not be null.");
      return setClient(new Client.Provider()
      {
        public Client get()
        {
          return paramClient;
        }
      });
    }

    public Builder setConverter(Converter paramConverter)
    {
      if (paramConverter == null)
        throw new NullPointerException("Converter may not be null.");
      this.converter = paramConverter;
      return this;
    }

    public Builder setEndpoint(String paramString)
    {
      if ((paramString == null) || (paramString.trim().length() == 0))
        throw new NullPointerException("Endpoint may not be blank.");
      this.endpoint = Endpoints.newFixedEndpoint(paramString);
      return this;
    }

    public Builder setEndpoint(Endpoint paramEndpoint)
    {
      if (paramEndpoint == null)
        throw new NullPointerException("Endpoint may not be null.");
      this.endpoint = paramEndpoint;
      return this;
    }

    public Builder setErrorHandler(ErrorHandler paramErrorHandler)
    {
      if (paramErrorHandler == null)
        throw new NullPointerException("Error handler may not be null.");
      this.errorHandler = paramErrorHandler;
      return this;
    }

    public Builder setExecutors(Executor paramExecutor1, Executor paramExecutor2)
    {
      if (paramExecutor1 == null)
        throw new NullPointerException("HTTP executor may not be null.");
      if (paramExecutor2 == null)
        paramExecutor2 = new Utils.SynchronousExecutor();
      this.httpExecutor = paramExecutor1;
      this.callbackExecutor = paramExecutor2;
      return this;
    }

    public Builder setLog(RestAdapter.Log paramLog)
    {
      if (paramLog == null)
        throw new NullPointerException("Log may not be null.");
      this.log = paramLog;
      return this;
    }

    public Builder setLogLevel(RestAdapter.LogLevel paramLogLevel)
    {
      if (paramLogLevel == null)
        throw new NullPointerException("Log level may not be null.");
      this.logLevel = paramLogLevel;
      return this;
    }

    public Builder setProfiler(Profiler paramProfiler)
    {
      if (paramProfiler == null)
        throw new NullPointerException("Profiler may not be null.");
      this.profiler = paramProfiler;
      return this;
    }

    public Builder setRequestInterceptor(RequestInterceptor paramRequestInterceptor)
    {
      if (paramRequestInterceptor == null)
        throw new NullPointerException("Request interceptor may not be null.");
      this.requestInterceptor = paramRequestInterceptor;
      return this;
    }
  }

  public static abstract interface Log
  {
    public static final Log NONE = new Log()
    {
      public void log(String paramAnonymousString)
      {
      }
    };

    public abstract void log(String paramString);
  }

  public static enum LogLevel
  {
    static
    {
      BASIC = new LogLevel("BASIC", 1);
      HEADERS = new LogLevel("HEADERS", 2);
      FULL = new LogLevel("FULL", 3);
      LogLevel[] arrayOfLogLevel = new LogLevel[4];
      arrayOfLogLevel[0] = NONE;
      arrayOfLogLevel[1] = BASIC;
      arrayOfLogLevel[2] = HEADERS;
      arrayOfLogLevel[3] = FULL;
    }

    public boolean log()
    {
      return this != NONE;
    }
  }

  private class RestHandler
    implements InvocationHandler
  {
    private final Map<Method, RestMethodInfo> methodDetailsCache;

    RestHandler()
    {
      Object localObject;
      this.methodDetailsCache = localObject;
    }

    // ERROR //
    private Object invokeRequest(RequestInterceptor paramRequestInterceptor, RestMethodInfo paramRestMethodInfo, Object[] paramArrayOfObject)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: aload_2
      //   4: invokevirtual 39	retrofit/RestMethodInfo:init	()V
      //   7: aload_0
      //   8: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   11: getfield 45	retrofit/RestAdapter:server	Lretrofit/Endpoint;
      //   14: invokeinterface 51 1 0
      //   19: astore 9
      //   21: new 53	retrofit/RequestBuilder
      //   24: dup
      //   25: aload 9
      //   27: aload_2
      //   28: aload_0
      //   29: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   32: getfield 57	retrofit/RestAdapter:converter	Lretrofit/converter/Converter;
      //   35: invokespecial 60	retrofit/RequestBuilder:<init>	(Ljava/lang/String;Lretrofit/RestMethodInfo;Lretrofit/converter/Converter;)V
      //   38: astore 10
      //   40: aload 10
      //   42: aload_3
      //   43: invokevirtual 64	retrofit/RequestBuilder:setArguments	([Ljava/lang/Object;)V
      //   46: aload_1
      //   47: aload 10
      //   49: invokeinterface 70 2 0
      //   54: aload 10
      //   56: invokevirtual 74	retrofit/RequestBuilder:build	()Lretrofit/client/Request;
      //   59: astore 11
      //   61: aload 11
      //   63: invokevirtual 77	retrofit/client/Request:getUrl	()Ljava/lang/String;
      //   66: astore 4
      //   68: aload_2
      //   69: getfield 81	retrofit/RestMethodInfo:isSynchronous	Z
      //   72: ifne +49 -> 121
      //   75: invokestatic 87	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   78: astore 35
      //   80: new 89	java/lang/StringBuilder
      //   83: dup
      //   84: invokespecial 90	java/lang/StringBuilder:<init>	()V
      //   87: ldc 92
      //   89: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   92: astore 36
      //   94: aload 9
      //   96: invokevirtual 102	java/lang/String:length	()I
      //   99: istore 37
      //   101: aload 35
      //   103: aload 36
      //   105: aload 4
      //   107: iload 37
      //   109: invokevirtual 106	java/lang/String:substring	(I)Ljava/lang/String;
      //   112: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   115: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   118: invokevirtual 113	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   121: aload_0
      //   122: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   125: getfield 117	retrofit/RestAdapter:logLevel	Lretrofit/RestAdapter$LogLevel;
      //   128: invokevirtual 123	retrofit/RestAdapter$LogLevel:log	()Z
      //   131: ifeq +16 -> 147
      //   134: aload_0
      //   135: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   138: ldc 125
      //   140: aload 11
      //   142: invokevirtual 129	retrofit/RestAdapter:logAndReplaceRequest	(Ljava/lang/String;Lretrofit/client/Request;)Lretrofit/client/Request;
      //   145: astore 11
      //   147: aload_0
      //   148: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   151: invokestatic 133	retrofit/RestAdapter:access$200	(Lretrofit/RestAdapter;)Lretrofit/Profiler;
      //   154: astore 12
      //   156: aconst_null
      //   157: astore 13
      //   159: aload 12
      //   161: ifnull +17 -> 178
      //   164: aload_0
      //   165: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   168: invokestatic 133	retrofit/RestAdapter:access$200	(Lretrofit/RestAdapter;)Lretrofit/Profiler;
      //   171: invokeinterface 139 1 0
      //   176: astore 13
      //   178: invokestatic 145	java/lang/System:nanoTime	()J
      //   181: lstore 14
      //   183: aload_0
      //   184: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   187: invokestatic 149	retrofit/RestAdapter:access$300	(Lretrofit/RestAdapter;)Lretrofit/client/Client$Provider;
      //   190: invokeinterface 155 1 0
      //   195: aload 11
      //   197: invokeinterface 161 2 0
      //   202: astore 16
      //   204: getstatic 167	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
      //   207: invokestatic 145	java/lang/System:nanoTime	()J
      //   210: lload 14
      //   212: lsub
      //   213: invokevirtual 171	java/util/concurrent/TimeUnit:toMillis	(J)J
      //   216: lstore 17
      //   218: aload 16
      //   220: invokevirtual 176	retrofit/client/Response:getStatus	()I
      //   223: istore 19
      //   225: aload_0
      //   226: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   229: invokestatic 133	retrofit/RestAdapter:access$200	(Lretrofit/RestAdapter;)Lretrofit/Profiler;
      //   232: ifnull +33 -> 265
      //   235: aload 9
      //   237: aload_2
      //   238: aload 11
      //   240: invokestatic 180	retrofit/RestAdapter:access$400	(Ljava/lang/String;Lretrofit/RestMethodInfo;Lretrofit/client/Request;)Lretrofit/Profiler$RequestInformation;
      //   243: astore 34
      //   245: aload_0
      //   246: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   249: invokestatic 133	retrofit/RestAdapter:access$200	(Lretrofit/RestAdapter;)Lretrofit/Profiler;
      //   252: aload 34
      //   254: lload 17
      //   256: iload 19
      //   258: aload 13
      //   260: invokeinterface 184 6 0
      //   265: aload_0
      //   266: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   269: getfield 117	retrofit/RestAdapter:logLevel	Lretrofit/RestAdapter$LogLevel;
      //   272: invokevirtual 123	retrofit/RestAdapter$LogLevel:log	()Z
      //   275: ifeq +18 -> 293
      //   278: aload_0
      //   279: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   282: aload 4
      //   284: aload 16
      //   286: lload 17
      //   288: invokestatic 188	retrofit/RestAdapter:access$500	(Lretrofit/RestAdapter;Ljava/lang/String;Lretrofit/client/Response;J)Lretrofit/client/Response;
      //   291: astore 16
      //   293: aload_2
      //   294: getfield 192	retrofit/RestMethodInfo:responseObjectType	Ljava/lang/reflect/Type;
      //   297: astore 20
      //   299: iload 19
      //   301: sipush 200
      //   304: if_icmplt +371 -> 675
      //   307: iload 19
      //   309: sipush 300
      //   312: if_icmpge +363 -> 675
      //   315: aload 20
      //   317: ldc 173
      //   319: invokevirtual 196	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   322: ifeq +81 -> 403
      //   325: aload_2
      //   326: getfield 199	retrofit/RestMethodInfo:isStreaming	Z
      //   329: ifne +10 -> 339
      //   332: aload 16
      //   334: invokestatic 205	retrofit/Utils:readBodyToBytesIfNecessary	(Lretrofit/client/Response;)Lretrofit/client/Response;
      //   337: astore 16
      //   339: aload_2
      //   340: getfield 81	retrofit/RestMethodInfo:isSynchronous	Z
      //   343: istore 33
      //   345: iload 33
      //   347: ifeq +25 -> 372
      //   350: aload_2
      //   351: getfield 81	retrofit/RestMethodInfo:isSynchronous	Z
      //   354: ifne +11 -> 365
      //   357: invokestatic 87	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   360: ldc 207
      //   362: invokevirtual 113	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   365: aload 16
      //   367: astore 25
      //   369: aload 25
      //   371: areturn
      //   372: new 209	retrofit/ResponseWrapper
      //   375: dup
      //   376: aload 16
      //   378: aload 16
      //   380: invokespecial 212	retrofit/ResponseWrapper:<init>	(Lretrofit/client/Response;Ljava/lang/Object;)V
      //   383: astore 25
      //   385: aload_2
      //   386: getfield 81	retrofit/RestMethodInfo:isSynchronous	Z
      //   389: ifne -20 -> 369
      //   392: invokestatic 87	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   395: ldc 207
      //   397: invokevirtual 113	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   400: aload 25
      //   402: areturn
      //   403: aload 16
      //   405: invokevirtual 216	retrofit/client/Response:getBody	()Lretrofit/mime/TypedInput;
      //   408: astore 23
      //   410: aload 23
      //   412: ifnonnull +68 -> 480
      //   415: aload_2
      //   416: getfield 81	retrofit/RestMethodInfo:isSynchronous	Z
      //   419: istore 24
      //   421: iload 24
      //   423: ifeq +27 -> 450
      //   426: aload_2
      //   427: getfield 81	retrofit/RestMethodInfo:isSynchronous	Z
      //   430: istore 26
      //   432: aconst_null
      //   433: astore 25
      //   435: iload 26
      //   437: ifne -68 -> 369
      //   440: invokestatic 87	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   443: ldc 207
      //   445: invokevirtual 113	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   448: aconst_null
      //   449: areturn
      //   450: new 209	retrofit/ResponseWrapper
      //   453: dup
      //   454: aload 16
      //   456: aconst_null
      //   457: invokespecial 212	retrofit/ResponseWrapper:<init>	(Lretrofit/client/Response;Ljava/lang/Object;)V
      //   460: astore 25
      //   462: aload_2
      //   463: getfield 81	retrofit/RestMethodInfo:isSynchronous	Z
      //   466: ifne -97 -> 369
      //   469: invokestatic 87	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   472: ldc 207
      //   474: invokevirtual 113	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   477: aload 25
      //   479: areturn
      //   480: new 218	retrofit/ExceptionCatchingTypedInput
      //   483: dup
      //   484: aload 23
      //   486: invokespecial 221	retrofit/ExceptionCatchingTypedInput:<init>	(Lretrofit/mime/TypedInput;)V
      //   489: astore 27
      //   491: aload_0
      //   492: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   495: getfield 57	retrofit/RestAdapter:converter	Lretrofit/converter/Converter;
      //   498: aload 27
      //   500: aload 20
      //   502: invokeinterface 227 3 0
      //   507: astore 25
      //   509: aload_2
      //   510: getfield 81	retrofit/RestMethodInfo:isSynchronous	Z
      //   513: istore 31
      //   515: iload 31
      //   517: ifeq +21 -> 538
      //   520: aload_2
      //   521: getfield 81	retrofit/RestMethodInfo:isSynchronous	Z
      //   524: ifne -155 -> 369
      //   527: invokestatic 87	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   530: ldc 207
      //   532: invokevirtual 113	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   535: aload 25
      //   537: areturn
      //   538: new 209	retrofit/ResponseWrapper
      //   541: dup
      //   542: aload 16
      //   544: aload 25
      //   546: invokespecial 212	retrofit/ResponseWrapper:<init>	(Lretrofit/client/Response;Ljava/lang/Object;)V
      //   549: astore 32
      //   551: aload_2
      //   552: getfield 81	retrofit/RestMethodInfo:isSynchronous	Z
      //   555: ifne +11 -> 566
      //   558: invokestatic 87	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   561: ldc 207
      //   563: invokevirtual 113	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   566: aload 32
      //   568: areturn
      //   569: astore 28
      //   571: aload 27
      //   573: invokevirtual 230	retrofit/ExceptionCatchingTypedInput:threwException	()Z
      //   576: ifeq +34 -> 610
      //   579: aload 27
      //   581: invokevirtual 234	retrofit/ExceptionCatchingTypedInput:getThrownException	()Ljava/io/IOException;
      //   584: athrow
      //   585: astore 8
      //   587: aload 8
      //   589: athrow
      //   590: astore 6
      //   592: aload_2
      //   593: getfield 81	retrofit/RestMethodInfo:isSynchronous	Z
      //   596: ifne +11 -> 607
      //   599: invokestatic 87	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   602: ldc 207
      //   604: invokevirtual 113	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   607: aload 6
      //   609: athrow
      //   610: aload 16
      //   612: aconst_null
      //   613: invokestatic 238	retrofit/Utils:replaceResponseBody	(Lretrofit/client/Response;Lretrofit/mime/TypedInput;)Lretrofit/client/Response;
      //   616: astore 29
      //   618: aload_0
      //   619: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   622: getfield 57	retrofit/RestAdapter:converter	Lretrofit/converter/Converter;
      //   625: astore 30
      //   627: aload 4
      //   629: aload 29
      //   631: aload 30
      //   633: aload 20
      //   635: aload 28
      //   637: invokestatic 242	retrofit/RetrofitError:conversionError	(Ljava/lang/String;Lretrofit/client/Response;Lretrofit/converter/Converter;Ljava/lang/reflect/Type;Lretrofit/converter/ConversionException;)Lretrofit/RetrofitError;
      //   640: athrow
      //   641: astore 7
      //   643: aload_0
      //   644: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   647: getfield 117	retrofit/RestAdapter:logLevel	Lretrofit/RestAdapter$LogLevel;
      //   650: invokevirtual 123	retrofit/RestAdapter$LogLevel:log	()Z
      //   653: ifeq +14 -> 667
      //   656: aload_0
      //   657: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   660: aload 7
      //   662: aload 4
      //   664: invokevirtual 246	retrofit/RestAdapter:logException	(Ljava/lang/Throwable;Ljava/lang/String;)V
      //   667: aload 4
      //   669: aload 7
      //   671: invokestatic 250	retrofit/RetrofitError:networkError	(Ljava/lang/String;Ljava/io/IOException;)Lretrofit/RetrofitError;
      //   674: athrow
      //   675: aload 16
      //   677: invokestatic 205	retrofit/Utils:readBodyToBytesIfNecessary	(Lretrofit/client/Response;)Lretrofit/client/Response;
      //   680: astore 21
      //   682: aload_0
      //   683: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   686: getfield 57	retrofit/RestAdapter:converter	Lretrofit/converter/Converter;
      //   689: astore 22
      //   691: aload 4
      //   693: aload 21
      //   695: aload 22
      //   697: aload 20
      //   699: invokestatic 254	retrofit/RetrofitError:httpError	(Ljava/lang/String;Lretrofit/client/Response;Lretrofit/converter/Converter;Ljava/lang/reflect/Type;)Lretrofit/RetrofitError;
      //   702: athrow
      //   703: astore 5
      //   705: aload_0
      //   706: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   709: getfield 117	retrofit/RestAdapter:logLevel	Lretrofit/RestAdapter$LogLevel;
      //   712: invokevirtual 123	retrofit/RestAdapter$LogLevel:log	()Z
      //   715: ifeq +14 -> 729
      //   718: aload_0
      //   719: getfield 15	retrofit/RestAdapter$RestHandler:this$0	Lretrofit/RestAdapter;
      //   722: aload 5
      //   724: aload 4
      //   726: invokevirtual 246	retrofit/RestAdapter:logException	(Ljava/lang/Throwable;Ljava/lang/String;)V
      //   729: aload 4
      //   731: aload 5
      //   733: invokestatic 258	retrofit/RetrofitError:unexpectedError	(Ljava/lang/String;Ljava/lang/Throwable;)Lretrofit/RetrofitError;
      //   736: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   491	515	569	retrofit/converter/ConversionException
      //   538	551	569	retrofit/converter/ConversionException
      //   3	121	585	retrofit/RetrofitError
      //   121	147	585	retrofit/RetrofitError
      //   147	156	585	retrofit/RetrofitError
      //   164	178	585	retrofit/RetrofitError
      //   178	265	585	retrofit/RetrofitError
      //   265	293	585	retrofit/RetrofitError
      //   293	299	585	retrofit/RetrofitError
      //   315	339	585	retrofit/RetrofitError
      //   339	345	585	retrofit/RetrofitError
      //   372	385	585	retrofit/RetrofitError
      //   403	410	585	retrofit/RetrofitError
      //   415	421	585	retrofit/RetrofitError
      //   450	462	585	retrofit/RetrofitError
      //   480	491	585	retrofit/RetrofitError
      //   491	515	585	retrofit/RetrofitError
      //   538	551	585	retrofit/RetrofitError
      //   571	585	585	retrofit/RetrofitError
      //   610	641	585	retrofit/RetrofitError
      //   675	703	585	retrofit/RetrofitError
      //   3	121	590	finally
      //   121	147	590	finally
      //   147	156	590	finally
      //   164	178	590	finally
      //   178	265	590	finally
      //   265	293	590	finally
      //   293	299	590	finally
      //   315	339	590	finally
      //   339	345	590	finally
      //   372	385	590	finally
      //   403	410	590	finally
      //   415	421	590	finally
      //   450	462	590	finally
      //   480	491	590	finally
      //   491	515	590	finally
      //   538	551	590	finally
      //   571	585	590	finally
      //   587	590	590	finally
      //   610	641	590	finally
      //   643	667	590	finally
      //   667	675	590	finally
      //   675	703	590	finally
      //   705	729	590	finally
      //   729	737	590	finally
      //   3	121	641	java/io/IOException
      //   121	147	641	java/io/IOException
      //   147	156	641	java/io/IOException
      //   164	178	641	java/io/IOException
      //   178	265	641	java/io/IOException
      //   265	293	641	java/io/IOException
      //   293	299	641	java/io/IOException
      //   315	339	641	java/io/IOException
      //   339	345	641	java/io/IOException
      //   372	385	641	java/io/IOException
      //   403	410	641	java/io/IOException
      //   415	421	641	java/io/IOException
      //   450	462	641	java/io/IOException
      //   480	491	641	java/io/IOException
      //   491	515	641	java/io/IOException
      //   538	551	641	java/io/IOException
      //   571	585	641	java/io/IOException
      //   610	641	641	java/io/IOException
      //   675	703	641	java/io/IOException
      //   3	121	703	java/lang/Throwable
      //   121	147	703	java/lang/Throwable
      //   147	156	703	java/lang/Throwable
      //   164	178	703	java/lang/Throwable
      //   178	265	703	java/lang/Throwable
      //   265	293	703	java/lang/Throwable
      //   293	299	703	java/lang/Throwable
      //   315	339	703	java/lang/Throwable
      //   339	345	703	java/lang/Throwable
      //   372	385	703	java/lang/Throwable
      //   403	410	703	java/lang/Throwable
      //   415	421	703	java/lang/Throwable
      //   450	462	703	java/lang/Throwable
      //   480	491	703	java/lang/Throwable
      //   491	515	703	java/lang/Throwable
      //   538	551	703	java/lang/Throwable
      //   571	585	703	java/lang/Throwable
      //   610	641	703	java/lang/Throwable
      //   675	703	703	java/lang/Throwable
    }

    public Object invoke(Object paramObject, Method paramMethod, final Object[] paramArrayOfObject)
      throws Throwable
    {
      if (paramMethod.getDeclaringClass() == Object.class)
        return paramMethod.invoke(this, paramArrayOfObject);
      final RestMethodInfo localRestMethodInfo = RestAdapter.getMethodInfo(this.methodDetailsCache, paramMethod);
      if (localRestMethodInfo.isSynchronous)
        try
        {
          Object localObject = invokeRequest(RestAdapter.this.requestInterceptor, localRestMethodInfo, paramArrayOfObject);
          return localObject;
        }
        catch (RetrofitError localRetrofitError)
        {
          Throwable localThrowable = RestAdapter.this.errorHandler.handleError(localRetrofitError);
          if (localThrowable == null)
            throw new IllegalStateException("Error handler returned null for wrapped exception.", localRetrofitError);
          throw localThrowable;
        }
      if ((RestAdapter.this.httpExecutor == null) || (RestAdapter.this.callbackExecutor == null))
        throw new IllegalStateException("Asynchronous invocation requires calling setExecutors.");
      if (localRestMethodInfo.isObservable)
      {
        if (RestAdapter.this.rxSupport == null)
        {
          if (Platform.HAS_RX_JAVA)
            RestAdapter.access$002(RestAdapter.this, new RxSupport(RestAdapter.this.httpExecutor, RestAdapter.this.errorHandler, RestAdapter.this.requestInterceptor));
        }
        else
          return RestAdapter.this.rxSupport.createRequestObservable(new RxSupport.Invoker()
          {
            public ResponseWrapper invoke(RequestInterceptor paramAnonymousRequestInterceptor)
            {
              return (ResponseWrapper)RestAdapter.RestHandler.this.invokeRequest(paramAnonymousRequestInterceptor, localRestMethodInfo, paramArrayOfObject);
            }
          });
        throw new IllegalStateException("Observable method found but no RxJava on classpath.");
      }
      final RequestInterceptorTape localRequestInterceptorTape = new RequestInterceptorTape();
      RestAdapter.this.requestInterceptor.intercept(localRequestInterceptorTape);
      Callback localCallback = (Callback)paramArrayOfObject[(-1 + paramArrayOfObject.length)];
      RestAdapter.this.httpExecutor.execute(new CallbackRunnable(localCallback, RestAdapter.this.callbackExecutor, RestAdapter.this.errorHandler)
      {
        public ResponseWrapper obtainResponse()
        {
          return (ResponseWrapper)RestAdapter.RestHandler.this.invokeRequest(localRequestInterceptorTape, localRestMethodInfo, paramArrayOfObject);
        }
      });
      return null;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.RestAdapter
 * JD-Core Version:    0.6.2
 */