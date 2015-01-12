package com.squareup.okhttp.internal;

import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import okio.Buffer;

public class Platform
{
  private static final Platform PLATFORM = findPlatform();

  static byte[] concatLengthPrefixed(List<Protocol> paramList)
  {
    Buffer localBuffer = new Buffer();
    int i = 0;
    int j = paramList.size();
    if (i < j)
    {
      Protocol localProtocol = (Protocol)paramList.get(i);
      if (localProtocol == Protocol.HTTP_1_0);
      while (true)
      {
        i++;
        break;
        localBuffer.writeByte(localProtocol.toString().length());
        localBuffer.writeUtf8(localProtocol.toString());
      }
    }
    return localBuffer.readByteArray();
  }

  // ERROR //
  private static Platform findPlatform()
  {
    // Byte code:
    //   0: ldc 65
    //   2: invokestatic 71	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore 29
    //   7: aload 29
    //   9: astore 15
    //   11: iconst_1
    //   12: anewarray 67	java/lang/Class
    //   15: astore 16
    //   17: aload 16
    //   19: iconst_0
    //   20: getstatic 77	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   23: aastore
    //   24: aload 15
    //   26: ldc 79
    //   28: aload 16
    //   30: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   33: astore 17
    //   35: aload 15
    //   37: ldc 85
    //   39: iconst_1
    //   40: anewarray 67	java/lang/Class
    //   43: dup
    //   44: iconst_0
    //   45: ldc 44
    //   47: aastore
    //   48: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   51: astore 18
    //   53: aconst_null
    //   54: astore 19
    //   56: ldc 87
    //   58: invokestatic 71	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   61: astore 27
    //   63: aload 27
    //   65: ldc 89
    //   67: iconst_1
    //   68: anewarray 67	java/lang/Class
    //   71: dup
    //   72: iconst_0
    //   73: ldc 91
    //   75: aastore
    //   76: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   79: astore 19
    //   81: aload 27
    //   83: ldc 93
    //   85: iconst_1
    //   86: anewarray 67	java/lang/Class
    //   89: dup
    //   90: iconst_0
    //   91: ldc 91
    //   93: aastore
    //   94: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   97: astore 28
    //   99: aload 28
    //   101: astore 21
    //   103: aconst_null
    //   104: astore 22
    //   106: aload 15
    //   108: ldc 95
    //   110: iconst_1
    //   111: anewarray 67	java/lang/Class
    //   114: dup
    //   115: iconst_0
    //   116: ldc 97
    //   118: aastore
    //   119: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   122: astore 22
    //   124: aload 15
    //   126: ldc 99
    //   128: iconst_0
    //   129: anewarray 67	java/lang/Class
    //   132: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   135: astore 25
    //   137: aload 25
    //   139: astore 24
    //   141: new 101	com/squareup/okhttp/internal/Platform$Android
    //   144: dup
    //   145: aload 15
    //   147: aload 17
    //   149: aload 18
    //   151: aload 19
    //   153: aload 21
    //   155: aload 22
    //   157: aload 24
    //   159: aconst_null
    //   160: invokespecial 104	com/squareup/okhttp/internal/Platform$Android:<init>	(Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/squareup/okhttp/internal/Platform$1;)V
    //   163: areturn
    //   164: astore 12
    //   166: ldc 106
    //   168: invokestatic 71	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   171: astore 14
    //   173: aload 14
    //   175: astore 15
    //   177: goto -166 -> 11
    //   180: astore_0
    //   181: ldc 108
    //   183: astore_1
    //   184: aload_1
    //   185: invokestatic 71	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   188: astore 11
    //   190: aload 11
    //   192: astore 5
    //   194: new 110	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   201: aload_1
    //   202: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc 117
    //   207: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 71	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   216: astore 7
    //   218: new 110	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   225: aload_1
    //   226: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc 120
    //   231: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 71	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   240: astore 8
    //   242: new 110	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   249: aload_1
    //   250: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc 122
    //   255: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 71	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   264: astore 9
    //   266: new 124	com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform
    //   269: dup
    //   270: aload 5
    //   272: ldc 126
    //   274: iconst_2
    //   275: anewarray 67	java/lang/Class
    //   278: dup
    //   279: iconst_0
    //   280: ldc 128
    //   282: aastore
    //   283: dup
    //   284: iconst_1
    //   285: aload 7
    //   287: aastore
    //   288: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   291: aload 5
    //   293: ldc 129
    //   295: iconst_1
    //   296: anewarray 67	java/lang/Class
    //   299: dup
    //   300: iconst_0
    //   301: ldc 128
    //   303: aastore
    //   304: invokevirtual 83	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   307: aload 8
    //   309: aload 9
    //   311: invokespecial 132	com/squareup/okhttp/internal/Platform$JdkWithJettyBootPlatform:<init>	(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   314: astore 10
    //   316: aload 10
    //   318: areturn
    //   319: astore 6
    //   321: new 2	com/squareup/okhttp/internal/Platform
    //   324: dup
    //   325: invokespecial 133	com/squareup/okhttp/internal/Platform:<init>	()V
    //   328: areturn
    //   329: astore_3
    //   330: ldc 135
    //   332: astore_1
    //   333: aload_1
    //   334: invokestatic 71	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   337: astore 4
    //   339: aload 4
    //   341: astore 5
    //   343: goto -149 -> 194
    //   346: astore_2
    //   347: goto -26 -> 321
    //   350: astore 13
    //   352: goto -171 -> 181
    //   355: astore 23
    //   357: aconst_null
    //   358: astore 24
    //   360: goto -219 -> 141
    //   363: astore 26
    //   365: aconst_null
    //   366: astore 21
    //   368: goto -265 -> 103
    //   371: astore 20
    //   373: aconst_null
    //   374: astore 21
    //   376: goto -273 -> 103
    //
    // Exception table:
    //   from	to	target	type
    //   0	7	164	java/lang/ClassNotFoundException
    //   0	7	180	java/lang/NoSuchMethodException
    //   11	53	180	java/lang/NoSuchMethodException
    //   141	164	180	java/lang/NoSuchMethodException
    //   166	173	180	java/lang/NoSuchMethodException
    //   194	316	319	java/lang/ClassNotFoundException
    //   333	339	319	java/lang/ClassNotFoundException
    //   184	190	329	java/lang/ClassNotFoundException
    //   184	190	346	java/lang/NoSuchMethodException
    //   194	316	346	java/lang/NoSuchMethodException
    //   333	339	346	java/lang/NoSuchMethodException
    //   11	53	350	java/lang/ClassNotFoundException
    //   106	137	350	java/lang/ClassNotFoundException
    //   141	164	350	java/lang/ClassNotFoundException
    //   166	173	350	java/lang/ClassNotFoundException
    //   106	137	355	java/lang/NoSuchMethodException
    //   56	99	363	java/lang/NoSuchMethodException
    //   56	99	371	java/lang/ClassNotFoundException
  }

  public static Platform get()
  {
    return PLATFORM;
  }

  public void configureTls(SSLSocket paramSSLSocket, String paramString1, String paramString2)
  {
    if (paramString2.equals("SSLv3"))
      paramSSLSocket.setEnabledProtocols(new String[] { "SSLv3" });
  }

  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }

  public String getPrefix()
  {
    return "OkHttp";
  }

  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    return null;
  }

  public void logW(String paramString)
  {
    System.out.println(paramString);
  }

  public void setProtocols(SSLSocket paramSSLSocket, List<Protocol> paramList)
  {
  }

  public void tagSocket(Socket paramSocket)
    throws SocketException
  {
  }

  public URI toUriLenient(URL paramURL)
    throws URISyntaxException
  {
    return paramURL.toURI();
  }

  public void untagSocket(Socket paramSocket)
    throws SocketException
  {
  }

  private static class Android extends Platform
  {
    private final Method getNpnSelectedProtocol;
    protected final Class<?> openSslSocketClass;
    private final Method setHostname;
    private final Method setNpnProtocols;
    private final Method setUseSessionTickets;
    private final Method trafficStatsTagSocket;
    private final Method trafficStatsUntagSocket;

    private Android(Class<?> paramClass, Method paramMethod1, Method paramMethod2, Method paramMethod3, Method paramMethod4, Method paramMethod5, Method paramMethod6)
    {
      this.openSslSocketClass = paramClass;
      this.setUseSessionTickets = paramMethod1;
      this.setHostname = paramMethod2;
      this.trafficStatsTagSocket = paramMethod3;
      this.trafficStatsUntagSocket = paramMethod4;
      this.setNpnProtocols = paramMethod5;
      this.getNpnSelectedProtocol = paramMethod6;
    }

    public void configureTls(SSLSocket paramSSLSocket, String paramString1, String paramString2)
    {
      super.configureTls(paramSSLSocket, paramString1, paramString2);
      if ((paramString2.equals("TLSv1")) && (this.openSslSocketClass.isInstance(paramSSLSocket)));
      try
      {
        Method localMethod = this.setUseSessionTickets;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Boolean.valueOf(true);
        localMethod.invoke(paramSSLSocket, arrayOfObject);
        this.setHostname.invoke(paramSSLSocket, new Object[] { paramString1 });
        return;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(localInvocationTargetException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError(localIllegalAccessException);
      }
    }

    public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
      throws IOException
    {
      try
      {
        paramSocket.connect(paramInetSocketAddress, paramInt);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        IOException localIOException = new IOException("Exception in connect");
        localIOException.initCause(localSecurityException);
        throw localIOException;
      }
    }

    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      if (this.getNpnSelectedProtocol == null)
        return null;
      if (!this.openSslSocketClass.isInstance(paramSSLSocket))
        return null;
      try
      {
        byte[] arrayOfByte = (byte[])this.getNpnSelectedProtocol.invoke(paramSSLSocket, new Object[0]);
        if (arrayOfByte == null)
          return null;
        String str = new String(arrayOfByte, Util.UTF_8);
        return str;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(localInvocationTargetException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError(localIllegalAccessException);
      }
    }

    public void setProtocols(SSLSocket paramSSLSocket, List<Protocol> paramList)
    {
      if (this.setNpnProtocols == null);
      while (!this.openSslSocketClass.isInstance(paramSSLSocket))
        return;
      try
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = concatLengthPrefixed(paramList);
        this.setNpnProtocols.invoke(paramSSLSocket, arrayOfObject);
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError(localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(localInvocationTargetException);
      }
    }

    public void tagSocket(Socket paramSocket)
      throws SocketException
    {
      if (this.trafficStatsTagSocket == null)
        return;
      try
      {
        this.trafficStatsTagSocket.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException(localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(localInvocationTargetException);
      }
    }

    public void untagSocket(Socket paramSocket)
      throws SocketException
    {
      if (this.trafficStatsUntagSocket == null)
        return;
      try
      {
        this.trafficStatsUntagSocket.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException(localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(localInvocationTargetException);
      }
    }
  }

  private static class JdkWithJettyBootPlatform extends Platform
  {
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Class<?> serverProviderClass;

    public JdkWithJettyBootPlatform(Method paramMethod1, Method paramMethod2, Class<?> paramClass1, Class<?> paramClass2)
    {
      this.putMethod = paramMethod1;
      this.getMethod = paramMethod2;
      this.clientProviderClass = paramClass1;
      this.serverProviderClass = paramClass2;
    }

    public String getSelectedProtocol(SSLSocket paramSSLSocket)
    {
      try
      {
        Platform.JettyNegoProvider localJettyNegoProvider = (Platform.JettyNegoProvider)Proxy.getInvocationHandler(this.getMethod.invoke(null, new Object[] { paramSSLSocket }));
        if ((!Platform.JettyNegoProvider.access$100(localJettyNegoProvider)) && (Platform.JettyNegoProvider.access$200(localJettyNegoProvider) == null))
        {
          Logger.getLogger("com.squareup.okhttp.OkHttpClient").log(Level.INFO, "NPN/ALPN callback dropped: SPDY and HTTP/2 are disabled. Is npn-boot or alpn-boot on the boot class path?");
          return null;
        }
        if (!Platform.JettyNegoProvider.access$100(localJettyNegoProvider))
        {
          String str = Platform.JettyNegoProvider.access$200(localJettyNegoProvider);
          return str;
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new AssertionError();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError();
      }
      return null;
    }

    public void setProtocols(SSLSocket paramSSLSocket, List<Protocol> paramList)
    {
      while (true)
      {
        int i;
        try
        {
          localArrayList = new ArrayList(paramList.size());
          i = 0;
          int j = paramList.size();
          if (i < j)
          {
            Protocol localProtocol = (Protocol)paramList.get(i);
            if (localProtocol == Protocol.HTTP_1_0)
              break label164;
            localArrayList.add(localProtocol.toString());
          }
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          ArrayList localArrayList;
          throw new AssertionError(localInvocationTargetException);
          ClassLoader localClassLoader = Platform.class.getClassLoader();
          Class[] arrayOfClass = new Class[2];
          arrayOfClass[0] = this.clientProviderClass;
          arrayOfClass[1] = this.serverProviderClass;
          Object localObject = Proxy.newProxyInstance(localClassLoader, arrayOfClass, new Platform.JettyNegoProvider(localArrayList));
          this.putMethod.invoke(null, new Object[] { paramSSLSocket, localObject });
          return;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new AssertionError(localIllegalAccessException);
        }
        label164: i++;
      }
    }
  }

  private static class JettyNegoProvider
    implements InvocationHandler
  {
    private final List<String> protocols;
    private String selected;
    private boolean unsupported;

    public JettyNegoProvider(List<String> paramList)
    {
      this.protocols = paramList;
    }

    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      String str1 = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      if (paramArrayOfObject == null)
        paramArrayOfObject = Util.EMPTY_STRING_ARRAY;
      if ((str1.equals("supports")) && (Boolean.TYPE == localClass))
        return Boolean.valueOf(true);
      if ((str1.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.unsupported = true;
        return null;
      }
      if ((str1.equals("protocols")) && (paramArrayOfObject.length == 0))
        return this.protocols;
      if (((str1.equals("selectProtocol")) || (str1.equals("select"))) && (String.class == localClass) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof List)))
      {
        List localList = (List)paramArrayOfObject[0];
        int i = 0;
        int j = localList.size();
        while (i < j)
        {
          if (this.protocols.contains(localList.get(i)))
          {
            String str3 = (String)localList.get(i);
            this.selected = str3;
            return str3;
          }
          i++;
        }
        String str2 = (String)this.protocols.get(0);
        this.selected = str2;
        return str2;
      }
      if (((str1.equals("protocolSelected")) || (str1.equals("selected"))) && (paramArrayOfObject.length == 1))
      {
        this.selected = ((String)paramArrayOfObject[0]);
        return null;
      }
      return paramMethod.invoke(this, paramArrayOfObject);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.Platform
 * JD-Core Version:    0.6.2
 */