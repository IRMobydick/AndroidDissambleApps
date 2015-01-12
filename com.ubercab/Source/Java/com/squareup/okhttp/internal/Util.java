package com.squareup.okhttp.internal;

import com.squareup.okhttp.internal.http.RetryableSink;
import com.squareup.okhttp.internal.spdy.Header;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.ByteString;
import okio.Source;

public final class Util
{
  public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private static final RetryableSink EMPTY_SINK = new RetryableSink(0);
  public static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final Charset US_ASCII = Charset.forName("US-ASCII");
  public static final Charset UTF_8 = Charset.forName("UTF-8");

  public static void checkOffsetAndCount(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) < 0L) || (paramLong2 > paramLong1) || (paramLong1 - paramLong2 < paramLong3))
      throw new ArrayIndexOutOfBoundsException();
  }

  public static void closeAll(Closeable paramCloseable1, Closeable paramCloseable2)
    throws IOException
  {
    Object localObject = null;
    try
    {
      paramCloseable1.close();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        while (true)
        {
          paramCloseable2.close();
          if (localObject != null)
            break;
          return;
          localThrowable1 = localThrowable1;
          localObject = localThrowable1;
        }
      }
      catch (Throwable localThrowable2)
      {
        while (true)
          if (localObject == null)
            localObject = localThrowable2;
        if ((localObject instanceof IOException))
          throw ((IOException)localObject);
        if ((localObject instanceof RuntimeException))
          throw ((RuntimeException)localObject);
        if ((localObject instanceof Error))
          throw ((Error)localObject);
      }
    }
    throw new AssertionError(localObject);
  }

  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
    }
  }

  public static void closeQuietly(ServerSocket paramServerSocket)
  {
    if (paramServerSocket != null);
    try
    {
      paramServerSocket.close();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
    }
  }

  public static void closeQuietly(Socket paramSocket)
  {
    if (paramSocket != null);
    try
    {
      paramSocket.close();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
    }
  }

  public static void deleteContents(File paramFile)
    throws IOException
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
      throw new IOException("not a readable directory: " + paramFile);
    int i = arrayOfFile.length;
    for (int j = 0; j < i; j++)
    {
      File localFile = arrayOfFile[j];
      if (localFile.isDirectory())
        deleteContents(localFile);
      if (!localFile.delete())
        throw new IOException("failed to delete file: " + localFile);
    }
  }

  public static RetryableSink emptySink()
  {
    return EMPTY_SINK;
  }

  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static int getDefaultPort(String paramString)
  {
    if ("http".equals(paramString))
      return 80;
    if ("https".equals(paramString))
      return 443;
    return -1;
  }

  private static int getEffectivePort(String paramString, int paramInt)
  {
    if (paramInt != -1)
      return paramInt;
    return getDefaultPort(paramString);
  }

  public static int getEffectivePort(URI paramURI)
  {
    return getEffectivePort(paramURI.getScheme(), paramURI.getPort());
  }

  public static int getEffectivePort(URL paramURL)
  {
    return getEffectivePort(paramURL.getProtocol(), paramURL.getPort());
  }

  public static String hash(String paramString)
  {
    try
    {
      String str = ByteString.of(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"))).hex();
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError(localNoSuchAlgorithmException);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError(localUnsupportedEncodingException);
    }
  }

  public static List<Header> headerEntries(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfString.length / 2);
    for (int i = 0; i < paramArrayOfString.length; i += 2)
      localArrayList.add(new Header(paramArrayOfString[i], paramArrayOfString[(i + 1)]));
    return localArrayList;
  }

  public static <T> List<T> immutableList(List<T> paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }

  public static <T> List<T> immutableList(T[] paramArrayOfT)
  {
    return Collections.unmodifiableList(Arrays.asList((Object[])paramArrayOfT.clone()));
  }

  public static boolean skipAll(Source paramSource, int paramInt)
    throws IOException
  {
    long l = System.nanoTime();
    Buffer localBuffer = new Buffer();
    while (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l) < paramInt)
    {
      if (paramSource.read(localBuffer, 2048L) == -1L)
        return true;
      localBuffer.clear();
    }
    return false;
  }

  public static ThreadFactory threadFactory(String paramString, final boolean paramBoolean)
  {
    return new ThreadFactory()
    {
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        Thread localThread = new Thread(paramAnonymousRunnable, this.val$name);
        localThread.setDaemon(paramBoolean);
        return localThread;
      }
    };
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.Util
 * JD-Core Version:    0.6.2
 */