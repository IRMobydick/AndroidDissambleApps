package retrofit.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedOutput;

public class ApacheClient
  implements Client
{
  private final HttpClient client;

  public ApacheClient()
  {
    this(createDefaultClient());
  }

  public ApacheClient(HttpClient paramHttpClient)
  {
    this.client = paramHttpClient;
  }

  private static HttpClient createDefaultClient()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 15000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
    return new DefaultHttpClient(localBasicHttpParams);
  }

  static HttpUriRequest createRequest(Request paramRequest)
  {
    if (paramRequest.getBody() != null)
      return new GenericEntityHttpRequest(paramRequest);
    return new GenericHttpRequest(paramRequest);
  }

  static Response parseResponse(String paramString, HttpResponse paramHttpResponse)
    throws IOException
  {
    StatusLine localStatusLine = paramHttpResponse.getStatusLine();
    int i = localStatusLine.getStatusCode();
    String str1 = localStatusLine.getReasonPhrase();
    ArrayList localArrayList = new ArrayList();
    Object localObject = "application/octet-stream";
    for (org.apache.http.Header localHeader : paramHttpResponse.getAllHeaders())
    {
      String str2 = localHeader.getName();
      String str3 = localHeader.getValue();
      if ("Content-Type".equalsIgnoreCase(str2))
        localObject = str3;
      localArrayList.add(new Header(str2, str3));
    }
    HttpEntity localHttpEntity = paramHttpResponse.getEntity();
    TypedByteArray localTypedByteArray = null;
    if (localHttpEntity != null)
      localTypedByteArray = new TypedByteArray((String)localObject, EntityUtils.toByteArray(localHttpEntity));
    return new Response(paramString, i, str1, localArrayList, localTypedByteArray);
  }

  protected HttpResponse execute(HttpClient paramHttpClient, HttpUriRequest paramHttpUriRequest)
    throws IOException
  {
    return paramHttpClient.execute(paramHttpUriRequest);
  }

  public Response execute(Request paramRequest)
    throws IOException
  {
    HttpUriRequest localHttpUriRequest = createRequest(paramRequest);
    HttpResponse localHttpResponse = execute(this.client, localHttpUriRequest);
    return parseResponse(paramRequest.getUrl(), localHttpResponse);
  }

  private static class GenericEntityHttpRequest extends HttpEntityEnclosingRequestBase
  {
    private final String method;

    GenericEntityHttpRequest(Request paramRequest)
    {
      this.method = paramRequest.getMethod();
      setURI(URI.create(paramRequest.getUrl()));
      Iterator localIterator = paramRequest.getHeaders().iterator();
      while (localIterator.hasNext())
      {
        Header localHeader = (Header)localIterator.next();
        addHeader(new BasicHeader(localHeader.getName(), localHeader.getValue()));
      }
      setEntity(new ApacheClient.TypedOutputEntity(paramRequest.getBody()));
    }

    public String getMethod()
    {
      return this.method;
    }
  }

  private static class GenericHttpRequest extends HttpRequestBase
  {
    private final String method;

    public GenericHttpRequest(Request paramRequest)
    {
      this.method = paramRequest.getMethod();
      setURI(URI.create(paramRequest.getUrl()));
      Iterator localIterator = paramRequest.getHeaders().iterator();
      while (localIterator.hasNext())
      {
        Header localHeader = (Header)localIterator.next();
        addHeader(new BasicHeader(localHeader.getName(), localHeader.getValue()));
      }
    }

    public String getMethod()
    {
      return this.method;
    }
  }

  static class TypedOutputEntity extends AbstractHttpEntity
  {
    final TypedOutput typedOutput;

    TypedOutputEntity(TypedOutput paramTypedOutput)
    {
      this.typedOutput = paramTypedOutput;
      setContentType(paramTypedOutput.mimeType());
    }

    public InputStream getContent()
      throws IOException
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      this.typedOutput.writeTo(localByteArrayOutputStream);
      return new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
    }

    public long getContentLength()
    {
      return this.typedOutput.length();
    }

    public boolean isRepeatable()
    {
      return true;
    }

    public boolean isStreaming()
    {
      return false;
    }

    public void writeTo(OutputStream paramOutputStream)
      throws IOException
    {
      this.typedOutput.writeTo(paramOutputStream);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.client.ApacheClient
 * JD-Core Version:    0.6.2
 */