package retrofit.appengine;

import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import retrofit.client.Client;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedOutput;

public class UrlFetchClient
  implements Client
{
  private final URLFetchService urlFetchService;

  public UrlFetchClient()
  {
    this(URLFetchServiceFactory.getURLFetchService());
  }

  public UrlFetchClient(URLFetchService paramURLFetchService)
  {
    this.urlFetchService = paramURLFetchService;
  }

  static HTTPRequest createRequest(Request paramRequest)
    throws IOException
  {
    HTTPMethod localHTTPMethod = getHttpMethod(paramRequest.getMethod());
    HTTPRequest localHTTPRequest = new HTTPRequest(new URL(paramRequest.getUrl()), localHTTPMethod);
    Iterator localIterator = paramRequest.getHeaders().iterator();
    while (localIterator.hasNext())
    {
      Header localHeader = (Header)localIterator.next();
      localHTTPRequest.addHeader(new HTTPHeader(localHeader.getName(), localHeader.getValue()));
    }
    TypedOutput localTypedOutput = paramRequest.getBody();
    if (localTypedOutput != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localTypedOutput.writeTo(localByteArrayOutputStream);
      localHTTPRequest.setPayload(localByteArrayOutputStream.toByteArray());
    }
    return localHTTPRequest;
  }

  private static HTTPMethod getHttpMethod(String paramString)
  {
    if ("GET".equals(paramString))
      return HTTPMethod.GET;
    if ("POST".equals(paramString))
      return HTTPMethod.POST;
    if ("PATCH".equals(paramString))
      return HTTPMethod.PATCH;
    if ("PUT".equals(paramString))
      return HTTPMethod.PUT;
    if ("DELETE".equals(paramString))
      return HTTPMethod.DELETE;
    if ("HEAD".equals(paramString))
      return HTTPMethod.HEAD;
    throw new IllegalStateException("Illegal HTTP method: " + paramString);
  }

  static Response parseResponse(HTTPResponse paramHTTPResponse)
  {
    String str1 = paramHTTPResponse.getFinalUrl().toString();
    int i = paramHTTPResponse.getResponseCode();
    List localList = paramHTTPResponse.getHeaders();
    ArrayList localArrayList = new ArrayList(localList.size());
    Object localObject = "application/octet-stream";
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      HTTPHeader localHTTPHeader = (HTTPHeader)localIterator.next();
      String str2 = localHTTPHeader.getName();
      String str3 = localHTTPHeader.getValue();
      if ("Content-Type".equalsIgnoreCase(str2))
        localObject = str3;
      localArrayList.add(new Header(str2, str3));
    }
    byte[] arrayOfByte = paramHTTPResponse.getContent();
    TypedByteArray localTypedByteArray = null;
    if (arrayOfByte != null)
      localTypedByteArray = new TypedByteArray((String)localObject, arrayOfByte);
    return new Response(str1, i, "", localArrayList, localTypedByteArray);
  }

  protected HTTPResponse execute(URLFetchService paramURLFetchService, HTTPRequest paramHTTPRequest)
    throws IOException
  {
    return paramURLFetchService.fetch(paramHTTPRequest);
  }

  public Response execute(Request paramRequest)
    throws IOException
  {
    HTTPRequest localHTTPRequest = createRequest(paramRequest);
    return parseResponse(execute(this.urlFetchService, localHTTPRequest));
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.appengine.UrlFetchClient
 * JD-Core Version:    0.6.2
 */