package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.DiskLruCache.Editor;
import com.squareup.okhttp.internal.DiskLruCache.Snapshot;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.CacheStrategy;
import com.squareup.okhttp.internal.http.HttpMethod;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.CacheRequest;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public final class Cache
{
  private static final int ENTRY_BODY = 1;
  private static final int ENTRY_COUNT = 2;
  private static final int ENTRY_METADATA = 0;
  private static final int VERSION = 201105;
  private final DiskLruCache cache;
  private int hitCount;
  final InternalCache internalCache = new InternalCache()
  {
    public Response get(Request paramAnonymousRequest)
      throws IOException
    {
      return Cache.this.get(paramAnonymousRequest);
    }

    public CacheRequest put(Response paramAnonymousResponse)
      throws IOException
    {
      return Cache.this.put(paramAnonymousResponse);
    }

    public void remove(Request paramAnonymousRequest)
      throws IOException
    {
      Cache.this.remove(paramAnonymousRequest);
    }

    public void trackConditionalCacheHit()
    {
      Cache.this.trackConditionalCacheHit();
    }

    public void trackResponse(CacheStrategy paramAnonymousCacheStrategy)
    {
      Cache.this.trackResponse(paramAnonymousCacheStrategy);
    }

    public void update(Response paramAnonymousResponse1, Response paramAnonymousResponse2)
      throws IOException
    {
      Cache.this.update(paramAnonymousResponse1, paramAnonymousResponse2);
    }
  };
  private int networkCount;
  private int requestCount;
  private int writeAbortCount;
  private int writeSuccessCount;

  public Cache(File paramFile, long paramLong)
    throws IOException
  {
    this.cache = DiskLruCache.open(paramFile, 201105, 2, paramLong);
  }

  private void abortQuietly(DiskLruCache.Editor paramEditor)
  {
    if (paramEditor != null);
    try
    {
      paramEditor.abort();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  private CacheRequest put(Response paramResponse)
    throws IOException
  {
    String str = paramResponse.request().method();
    if (HttpMethod.invalidatesCache(paramResponse.request().method()));
    try
    {
      remove(paramResponse.request());
      while (true)
      {
        return null;
        if ((str.equals("GET")) && (!OkHeaders.hasVaryAll(paramResponse)))
        {
          Entry localEntry = new Entry(paramResponse);
          DiskLruCache.Editor localEditor = null;
          try
          {
            localEditor = this.cache.edit(urlToKey(paramResponse.request()));
            if (localEditor != null)
            {
              localEntry.writeTo(localEditor);
              CacheRequestImpl localCacheRequestImpl = new CacheRequestImpl(localEditor);
              return localCacheRequestImpl;
            }
          }
          catch (IOException localIOException1)
          {
            abortQuietly(localEditor);
            return null;
          }
        }
      }
    }
    catch (IOException localIOException2)
    {
    }
    return null;
  }

  private static int readInt(BufferedSource paramBufferedSource)
    throws IOException
  {
    String str = paramBufferedSource.readUtf8LineStrict();
    try
    {
      int i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    throw new IOException("Expected an integer but was \"" + str + "\"");
  }

  private void remove(Request paramRequest)
    throws IOException
  {
    this.cache.remove(urlToKey(paramRequest));
  }

  private void trackConditionalCacheHit()
  {
    try
    {
      this.hitCount = (1 + this.hitCount);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void trackResponse(CacheStrategy paramCacheStrategy)
  {
    try
    {
      this.requestCount = (1 + this.requestCount);
      if (paramCacheStrategy.networkRequest != null)
        this.networkCount = (1 + this.networkCount);
      while (true)
      {
        return;
        if (paramCacheStrategy.cacheResponse != null)
          this.hitCount = (1 + this.hitCount);
      }
    }
    finally
    {
    }
  }

  private void update(Response paramResponse1, Response paramResponse2)
  {
    Entry localEntry = new Entry(paramResponse2);
    DiskLruCache.Snapshot localSnapshot = ((CacheResponseBody)paramResponse1.body()).snapshot;
    DiskLruCache.Editor localEditor = null;
    try
    {
      localEditor = localSnapshot.edit();
      if (localEditor != null)
      {
        localEntry.writeTo(localEditor);
        localEditor.commit();
      }
      return;
    }
    catch (IOException localIOException)
    {
      abortQuietly(localEditor);
    }
  }

  private static String urlToKey(Request paramRequest)
  {
    return Util.hash(paramRequest.urlString());
  }

  public void close()
    throws IOException
  {
    this.cache.close();
  }

  public void delete()
    throws IOException
  {
    this.cache.delete();
  }

  public void flush()
    throws IOException
  {
    this.cache.flush();
  }

  Response get(Request paramRequest)
  {
    String str = urlToKey(paramRequest);
    while (true)
    {
      DiskLruCache.Snapshot localSnapshot;
      Response localResponse;
      try
      {
        localSnapshot = this.cache.get(str);
        if (localSnapshot == null)
        {
          localResponse = null;
          return localResponse;
        }
      }
      catch (IOException localIOException1)
      {
        return null;
      }
      try
      {
        Entry localEntry = new Entry(localSnapshot.getInputStream(0));
        localResponse = localEntry.response(paramRequest, localSnapshot);
        if (!localEntry.matches(paramRequest, localResponse))
        {
          Util.closeQuietly(localResponse.body());
          return null;
        }
      }
      catch (IOException localIOException2)
      {
        Util.closeQuietly(localSnapshot);
      }
    }
    return null;
  }

  public File getDirectory()
  {
    return this.cache.getDirectory();
  }

  public int getHitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public long getMaxSize()
  {
    return this.cache.getMaxSize();
  }

  public int getNetworkCount()
  {
    try
    {
      int i = this.networkCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getRequestCount()
  {
    try
    {
      int i = this.requestCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public long getSize()
  {
    return this.cache.size();
  }

  public int getWriteAbortCount()
  {
    try
    {
      int i = this.writeAbortCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int getWriteSuccessCount()
  {
    try
    {
      int i = this.writeSuccessCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean isClosed()
  {
    return this.cache.isClosed();
  }

  private final class CacheRequestImpl extends CacheRequest
  {
    private OutputStream body;
    private OutputStream cacheOut;
    private boolean done;
    private final DiskLruCache.Editor editor;

    public CacheRequestImpl(DiskLruCache.Editor arg2)
      throws IOException
    {
      final DiskLruCache.Editor localEditor;
      this.editor = localEditor;
      this.cacheOut = localEditor.newOutputStream(1);
      this.body = new FilterOutputStream(this.cacheOut)
      {
        public void close()
          throws IOException
        {
          synchronized (Cache.this)
          {
            if (Cache.CacheRequestImpl.this.done)
              return;
            Cache.CacheRequestImpl.access$602(Cache.CacheRequestImpl.this, true);
            Cache.access$708(Cache.this);
            super.close();
            localEditor.commit();
            return;
          }
        }

        public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
          throws IOException
        {
          this.out.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
        }
      };
    }

    public void abort()
    {
      synchronized (Cache.this)
      {
        if (this.done)
          return;
        this.done = true;
        Cache.access$808(Cache.this);
        Util.closeQuietly(this.cacheOut);
        try
        {
          this.editor.abort();
          return;
        }
        catch (IOException localIOException)
        {
        }
      }
    }

    public OutputStream getBody()
      throws IOException
    {
      return this.body;
    }
  }

  private static class CacheResponseBody extends ResponseBody
  {
    private final BufferedSource bodySource;
    private final String contentLength;
    private final String contentType;
    private final DiskLruCache.Snapshot snapshot;

    public CacheResponseBody(final DiskLruCache.Snapshot paramSnapshot, String paramString1, String paramString2)
    {
      this.snapshot = paramSnapshot;
      this.contentType = paramString1;
      this.contentLength = paramString2;
      this.bodySource = Okio.buffer(new ForwardingSource(Okio.source(paramSnapshot.getInputStream(1)))
      {
        public void close()
          throws IOException
        {
          paramSnapshot.close();
          super.close();
        }
      });
    }

    public long contentLength()
    {
      long l1 = -1L;
      try
      {
        if (this.contentLength != null)
        {
          long l2 = Long.parseLong(this.contentLength);
          l1 = l2;
        }
        return l1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
      return l1;
    }

    public MediaType contentType()
    {
      if (this.contentType != null)
        return MediaType.parse(this.contentType);
      return null;
    }

    public BufferedSource source()
    {
      return this.bodySource;
    }
  }

  private static final class Entry
  {
    private final int code;
    private final Handshake handshake;
    private final String message;
    private final Protocol protocol;
    private final String requestMethod;
    private final Headers responseHeaders;
    private final String url;
    private final Headers varyHeaders;

    public Entry(Response paramResponse)
    {
      this.url = paramResponse.request().urlString();
      this.varyHeaders = OkHeaders.varyHeaders(paramResponse);
      this.requestMethod = paramResponse.request().method();
      this.protocol = paramResponse.protocol();
      this.code = paramResponse.code();
      this.message = paramResponse.message();
      this.responseHeaders = paramResponse.headers();
      this.handshake = paramResponse.handshake();
    }

    public Entry(InputStream paramInputStream)
      throws IOException
    {
      BufferedSource localBufferedSource;
      try
      {
        localBufferedSource = Okio.buffer(Okio.source(paramInputStream));
        this.url = localBufferedSource.readUtf8LineStrict();
        this.requestMethod = localBufferedSource.readUtf8LineStrict();
        Headers.Builder localBuilder1 = new Headers.Builder();
        int i = Cache.readInt(localBufferedSource);
        for (int j = 0; j < i; j++)
          localBuilder1.addLine(localBufferedSource.readUtf8LineStrict());
        this.varyHeaders = localBuilder1.build();
        StatusLine localStatusLine = StatusLine.parse(localBufferedSource.readUtf8LineStrict());
        this.protocol = localStatusLine.protocol;
        this.code = localStatusLine.code;
        this.message = localStatusLine.message;
        Headers.Builder localBuilder2 = new Headers.Builder();
        int k = Cache.readInt(localBufferedSource);
        for (int m = 0; m < k; m++)
          localBuilder2.addLine(localBufferedSource.readUtf8LineStrict());
        this.responseHeaders = localBuilder2.build();
        if (isHttps())
        {
          String str = localBufferedSource.readUtf8LineStrict();
          if (str.length() > 0)
            throw new IOException("expected \"\" but was \"" + str + "\"");
        }
      }
      finally
      {
        paramInputStream.close();
      }
      for (this.handshake = Handshake.get(localBufferedSource.readUtf8LineStrict(), readCertificateList(localBufferedSource), readCertificateList(localBufferedSource)); ; this.handshake = null)
      {
        paramInputStream.close();
        return;
      }
    }

    private boolean isHttps()
    {
      return this.url.startsWith("https://");
    }

    private List<Certificate> readCertificateList(BufferedSource paramBufferedSource)
      throws IOException
    {
      int i = Cache.readInt(paramBufferedSource);
      Object localObject;
      if (i == -1)
        localObject = Collections.emptyList();
      while (true)
      {
        return localObject;
        try
        {
          CertificateFactory localCertificateFactory = CertificateFactory.getInstance("X.509");
          localObject = new ArrayList(i);
          for (int j = 0; j < i; j++)
            ((List)localObject).add(localCertificateFactory.generateCertificate(new ByteArrayInputStream(ByteString.decodeBase64(paramBufferedSource.readUtf8LineStrict()).toByteArray())));
        }
        catch (CertificateException localCertificateException)
        {
          throw new IOException(localCertificateException.getMessage());
        }
      }
    }

    private void writeCertArray(Writer paramWriter, List<Certificate> paramList)
      throws IOException
    {
      try
      {
        paramWriter.write(Integer.toString(paramList.size()));
        paramWriter.write(10);
        int i = 0;
        int j = paramList.size();
        while (i < j)
        {
          paramWriter.write(ByteString.of(((Certificate)paramList.get(i)).getEncoded()).base64());
          paramWriter.write(10);
          i++;
        }
      }
      catch (CertificateEncodingException localCertificateEncodingException)
      {
        throw new IOException(localCertificateEncodingException.getMessage());
      }
    }

    public boolean matches(Request paramRequest, Response paramResponse)
    {
      return (this.url.equals(paramRequest.urlString())) && (this.requestMethod.equals(paramRequest.method())) && (OkHeaders.varyMatches(paramResponse, this.varyHeaders, paramRequest));
    }

    public Response response(Request paramRequest, DiskLruCache.Snapshot paramSnapshot)
    {
      String str1 = this.responseHeaders.get("Content-Type");
      String str2 = this.responseHeaders.get("Content-Length");
      Request localRequest = new Request.Builder().url(this.url).method(this.message, null).headers(this.varyHeaders).build();
      return new Response.Builder().request(localRequest).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new Cache.CacheResponseBody(paramSnapshot, str1, str2)).handshake(this.handshake).build();
    }

    public void writeTo(DiskLruCache.Editor paramEditor)
      throws IOException
    {
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(paramEditor.newOutputStream(0), Util.UTF_8));
      localBufferedWriter.write(this.url);
      localBufferedWriter.write(10);
      localBufferedWriter.write(this.requestMethod);
      localBufferedWriter.write(10);
      localBufferedWriter.write(Integer.toString(this.varyHeaders.size()));
      localBufferedWriter.write(10);
      for (int i = 0; i < this.varyHeaders.size(); i++)
      {
        localBufferedWriter.write(this.varyHeaders.name(i));
        localBufferedWriter.write(": ");
        localBufferedWriter.write(this.varyHeaders.value(i));
        localBufferedWriter.write(10);
      }
      localBufferedWriter.write(new StatusLine(this.protocol, this.code, this.message).toString());
      localBufferedWriter.write(10);
      localBufferedWriter.write(Integer.toString(this.responseHeaders.size()));
      localBufferedWriter.write(10);
      for (int j = 0; j < this.responseHeaders.size(); j++)
      {
        localBufferedWriter.write(this.responseHeaders.name(j));
        localBufferedWriter.write(": ");
        localBufferedWriter.write(this.responseHeaders.value(j));
        localBufferedWriter.write(10);
      }
      if (isHttps())
      {
        localBufferedWriter.write(10);
        localBufferedWriter.write(this.handshake.cipherSuite());
        localBufferedWriter.write(10);
        writeCertArray(localBufferedWriter, this.handshake.peerCertificates());
        writeCertArray(localBufferedWriter, this.handshake.localCertificates());
      }
      localBufferedWriter.close();
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.squareup.okhttp.Cache
 * JD-Core Version:    0.6.2
 */