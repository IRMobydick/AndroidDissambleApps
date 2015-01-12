package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.Header;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.squareup.okhttp.internal.spdy.SpdyStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class SpdyTransport
  implements Transport
{
  private static final List<ByteString> HTTP_2_PROHIBITED_HEADERS = Util.immutableList(arrayOfByteString2);
  private static final List<ByteString> SPDY_3_PROHIBITED_HEADERS;
  private final HttpEngine httpEngine;
  private final SpdyConnection spdyConnection;
  private SpdyStream stream;

  static
  {
    ByteString[] arrayOfByteString1 = new ByteString[5];
    arrayOfByteString1[0] = ByteString.encodeUtf8("connection");
    arrayOfByteString1[1] = ByteString.encodeUtf8("host");
    arrayOfByteString1[2] = ByteString.encodeUtf8("keep-alive");
    arrayOfByteString1[3] = ByteString.encodeUtf8("proxy-connection");
    arrayOfByteString1[4] = ByteString.encodeUtf8("transfer-encoding");
    SPDY_3_PROHIBITED_HEADERS = Util.immutableList(arrayOfByteString1);
    ByteString[] arrayOfByteString2 = new ByteString[8];
    arrayOfByteString2[0] = ByteString.encodeUtf8("connection");
    arrayOfByteString2[1] = ByteString.encodeUtf8("host");
    arrayOfByteString2[2] = ByteString.encodeUtf8("keep-alive");
    arrayOfByteString2[3] = ByteString.encodeUtf8("proxy-connection");
    arrayOfByteString2[4] = ByteString.encodeUtf8("te");
    arrayOfByteString2[5] = ByteString.encodeUtf8("transfer-encoding");
    arrayOfByteString2[6] = ByteString.encodeUtf8("encoding");
    arrayOfByteString2[7] = ByteString.encodeUtf8("upgrade");
  }

  public SpdyTransport(HttpEngine paramHttpEngine, SpdyConnection paramSpdyConnection)
  {
    this.httpEngine = paramHttpEngine;
    this.spdyConnection = paramSpdyConnection;
  }

  private static boolean isProhibitedHeader(Protocol paramProtocol, ByteString paramByteString)
  {
    if (paramProtocol == Protocol.SPDY_3)
      return SPDY_3_PROHIBITED_HEADERS.contains(paramByteString);
    if (paramProtocol == Protocol.HTTP_2)
      return HTTP_2_PROHIBITED_HEADERS.contains(paramByteString);
    throw new AssertionError(paramProtocol);
  }

  private static String joinOnNull(String paramString1, String paramString2)
  {
    return paramString1 + '\000' + paramString2;
  }

  public static Response.Builder readNameValueBlock(List<Header> paramList, Protocol paramProtocol)
    throws IOException
  {
    Object localObject1 = null;
    Object localObject2 = "HTTP/1.1";
    Headers.Builder localBuilder = new Headers.Builder();
    localBuilder.set(OkHeaders.SELECTED_PROTOCOL, paramProtocol.toString());
    for (int i = 0; i < paramList.size(); i++)
    {
      ByteString localByteString = ((Header)paramList.get(i)).name;
      String str1 = ((Header)paramList.get(i)).value.utf8();
      int j = 0;
      if (j < str1.length())
      {
        int k = str1.indexOf(0, j);
        if (k == -1)
          k = str1.length();
        String str2 = str1.substring(j, k);
        if (localByteString.equals(Header.RESPONSE_STATUS))
          localObject1 = str2;
        while (true)
        {
          j = k + 1;
          break;
          if (localByteString.equals(Header.VERSION))
            localObject2 = str2;
          else if (!isProhibitedHeader(paramProtocol, localByteString))
            localBuilder.add(localByteString.utf8(), str2);
        }
      }
    }
    if (localObject1 == null)
      throw new ProtocolException("Expected ':status' header not present");
    if (localObject2 == null)
      throw new ProtocolException("Expected ':version' header not present");
    StatusLine localStatusLine = StatusLine.parse((String)localObject2 + " " + localObject1);
    return new Response.Builder().protocol(localStatusLine.protocol).code(localStatusLine.code).message(localStatusLine.message).headers(localBuilder.build());
  }

  public static List<Header> writeNameValueBlock(Request paramRequest, Protocol paramProtocol, String paramString)
  {
    Headers localHeaders = paramRequest.headers();
    ArrayList localArrayList = new ArrayList(10 + localHeaders.size());
    localArrayList.add(new Header(Header.TARGET_METHOD, paramRequest.method()));
    localArrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(paramRequest.url())));
    String str1 = HttpEngine.hostHeader(paramRequest.url());
    LinkedHashSet localLinkedHashSet;
    int i;
    label160: ByteString localByteString;
    String str2;
    if (Protocol.SPDY_3 == paramProtocol)
    {
      localArrayList.add(new Header(Header.VERSION, paramString));
      localArrayList.add(new Header(Header.TARGET_HOST, str1));
      localArrayList.add(new Header(Header.TARGET_SCHEME, paramRequest.url().getProtocol()));
      localLinkedHashSet = new LinkedHashSet();
      i = 0;
      if (i >= localHeaders.size())
        break label436;
      localByteString = ByteString.encodeUtf8(localHeaders.name(i).toLowerCase(Locale.US));
      str2 = localHeaders.value(i);
      if (!isProhibitedHeader(paramProtocol, localByteString))
        break label247;
    }
    label434: 
    while (true)
    {
      i++;
      break label160;
      if (Protocol.HTTP_2 == paramProtocol)
      {
        localArrayList.add(new Header(Header.TARGET_AUTHORITY, str1));
        break;
      }
      throw new AssertionError();
      label247: if ((!localByteString.equals(Header.TARGET_METHOD)) && (!localByteString.equals(Header.TARGET_PATH)) && (!localByteString.equals(Header.TARGET_SCHEME)) && (!localByteString.equals(Header.TARGET_AUTHORITY)) && (!localByteString.equals(Header.TARGET_HOST)) && (!localByteString.equals(Header.VERSION)))
        if (localLinkedHashSet.add(localByteString))
          localArrayList.add(new Header(localByteString, str2));
        else
          for (int j = 0; ; j++)
          {
            if (j >= localArrayList.size())
              break label434;
            if (((Header)localArrayList.get(j)).name.equals(localByteString))
            {
              localArrayList.set(j, new Header(localByteString, joinOnNull(((Header)localArrayList.get(j)).value.utf8(), str2)));
              break;
            }
          }
    }
    label436: return localArrayList;
  }

  public boolean canReuseConnection()
  {
    return true;
  }

  public Sink createRequestBody(Request paramRequest)
    throws IOException
  {
    writeRequestHeaders(paramRequest);
    return this.stream.getSink();
  }

  public void disconnect(HttpEngine paramHttpEngine)
    throws IOException
  {
    this.stream.close(ErrorCode.CANCEL);
  }

  public void emptyTransferStream()
  {
  }

  public void flushRequest()
    throws IOException
  {
    this.stream.getSink().close();
  }

  public Source getTransferStream(CacheRequest paramCacheRequest)
    throws IOException
  {
    return new SpdySource(this.stream, paramCacheRequest);
  }

  public Response.Builder readResponseHeaders()
    throws IOException
  {
    return readNameValueBlock(this.stream.getResponseHeaders(), this.spdyConnection.getProtocol());
  }

  public void releaseConnectionOnIdle()
  {
  }

  public void writeRequestBody(RetryableSink paramRetryableSink)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }

  public void writeRequestHeaders(Request paramRequest)
    throws IOException
  {
    if (this.stream != null)
      return;
    this.httpEngine.writingRequestHeaders();
    boolean bool = this.httpEngine.hasRequestBody();
    String str = RequestLine.version(this.httpEngine.getConnection().getProtocol());
    this.stream = this.spdyConnection.newStream(writeNameValueBlock(paramRequest, this.spdyConnection.getProtocol(), str), bool, true);
    this.stream.readTimeout().timeout(this.httpEngine.client.getReadTimeout(), TimeUnit.MILLISECONDS);
  }

  private static class SpdySource
    implements Source
  {
    private final OutputStream cacheBody;
    private final CacheRequest cacheRequest;
    private boolean closed;
    private boolean inputExhausted;
    private final Source source;
    private final SpdyStream stream;

    SpdySource(SpdyStream paramSpdyStream, CacheRequest paramCacheRequest)
      throws IOException
    {
      this.stream = paramSpdyStream;
      this.source = paramSpdyStream.getSource();
      if (paramCacheRequest != null);
      for (OutputStream localOutputStream = paramCacheRequest.getBody(); ; localOutputStream = null)
      {
        if (localOutputStream == null)
          paramCacheRequest = null;
        this.cacheBody = localOutputStream;
        this.cacheRequest = paramCacheRequest;
        return;
      }
    }

    // ERROR //
    private boolean discardStream()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 26	com/squareup/okhttp/internal/http/SpdyTransport$SpdySource:stream	Lcom/squareup/okhttp/internal/spdy/SpdyStream;
      //   4: invokevirtual 50	com/squareup/okhttp/internal/spdy/SpdyStream:readTimeout	()Lokio/Timeout;
      //   7: invokevirtual 56	okio/Timeout:timeoutNanos	()J
      //   10: lstore_1
      //   11: aload_0
      //   12: getfield 26	com/squareup/okhttp/internal/http/SpdyTransport$SpdySource:stream	Lcom/squareup/okhttp/internal/spdy/SpdyStream;
      //   15: invokevirtual 50	com/squareup/okhttp/internal/spdy/SpdyStream:readTimeout	()Lokio/Timeout;
      //   18: ldc2_w 57
      //   21: getstatic 64	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   24: invokevirtual 68	okio/Timeout:timeout	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
      //   27: pop
      //   28: aload_0
      //   29: bipush 100
      //   31: invokestatic 74	com/squareup/okhttp/internal/Util:skipAll	(Lokio/Source;I)Z
      //   34: pop
      //   35: aload_0
      //   36: getfield 26	com/squareup/okhttp/internal/http/SpdyTransport$SpdySource:stream	Lcom/squareup/okhttp/internal/spdy/SpdyStream;
      //   39: invokevirtual 50	com/squareup/okhttp/internal/spdy/SpdyStream:readTimeout	()Lokio/Timeout;
      //   42: lload_1
      //   43: getstatic 77	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
      //   46: invokevirtual 68	okio/Timeout:timeout	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
      //   49: pop
      //   50: iconst_1
      //   51: ireturn
      //   52: astore 6
      //   54: aload_0
      //   55: getfield 26	com/squareup/okhttp/internal/http/SpdyTransport$SpdySource:stream	Lcom/squareup/okhttp/internal/spdy/SpdyStream;
      //   58: invokevirtual 50	com/squareup/okhttp/internal/spdy/SpdyStream:readTimeout	()Lokio/Timeout;
      //   61: lload_1
      //   62: getstatic 77	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
      //   65: invokevirtual 68	okio/Timeout:timeout	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
      //   68: pop
      //   69: iconst_0
      //   70: ireturn
      //   71: astore 4
      //   73: aload_0
      //   74: getfield 26	com/squareup/okhttp/internal/http/SpdyTransport$SpdySource:stream	Lcom/squareup/okhttp/internal/spdy/SpdyStream;
      //   77: invokevirtual 50	com/squareup/okhttp/internal/spdy/SpdyStream:readTimeout	()Lokio/Timeout;
      //   80: lload_1
      //   81: getstatic 77	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
      //   84: invokevirtual 68	okio/Timeout:timeout	(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;
      //   87: pop
      //   88: aload 4
      //   90: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   28	35	52	java/io/IOException
      //   28	35	71	finally
    }

    public void close()
      throws IOException
    {
      if (this.closed);
      do
      {
        do
        {
          return;
          if ((!this.inputExhausted) && (this.cacheBody != null))
            discardStream();
          this.closed = true;
        }
        while (this.inputExhausted);
        this.stream.closeLater(ErrorCode.CANCEL);
      }
      while (this.cacheRequest == null);
      this.cacheRequest.abort();
    }

    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      if (this.closed)
        throw new IllegalStateException("closed");
      long l;
      if (this.inputExhausted)
        l = -1L;
      do
      {
        return l;
        l = this.source.read(paramBuffer, paramLong);
        if (l == -1L)
        {
          this.inputExhausted = true;
          if (this.cacheRequest != null)
            this.cacheBody.close();
          return -1L;
        }
      }
      while (this.cacheBody == null);
      paramBuffer.copyTo(this.cacheBody, paramBuffer.size() - l, l);
      return l;
    }

    public Timeout timeout()
    {
      return this.source.timeout();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.SpdyTransport
 * JD-Core Version:    0.6.2
 */