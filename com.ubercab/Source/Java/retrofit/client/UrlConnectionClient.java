package retrofit.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class UrlConnectionClient
  implements Client
{
  private static final int CHUNK_SIZE = 4096;

  public Response execute(Request paramRequest)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = openConnection(paramRequest);
    prepareRequest(localHttpURLConnection, paramRequest);
    return readResponse(localHttpURLConnection);
  }

  protected HttpURLConnection openConnection(Request paramRequest)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramRequest.getUrl()).openConnection();
    localHttpURLConnection.setConnectTimeout(15000);
    localHttpURLConnection.setReadTimeout(20000);
    return localHttpURLConnection;
  }

  void prepareRequest(HttpURLConnection paramHttpURLConnection, Request paramRequest)
    throws IOException
  {
    paramHttpURLConnection.setRequestMethod(paramRequest.getMethod());
    paramHttpURLConnection.setDoInput(true);
    Iterator localIterator = paramRequest.getHeaders().iterator();
    while (localIterator.hasNext())
    {
      Header localHeader = (Header)localIterator.next();
      paramHttpURLConnection.addRequestProperty(localHeader.getName(), localHeader.getValue());
    }
    TypedOutput localTypedOutput = paramRequest.getBody();
    if (localTypedOutput != null)
    {
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.addRequestProperty("Content-Type", localTypedOutput.mimeType());
      long l = localTypedOutput.length();
      if (l == -1L)
        break label137;
      paramHttpURLConnection.setFixedLengthStreamingMode((int)l);
      paramHttpURLConnection.addRequestProperty("Content-Length", String.valueOf(l));
    }
    while (true)
    {
      localTypedOutput.writeTo(paramHttpURLConnection.getOutputStream());
      return;
      label137: paramHttpURLConnection.setChunkedStreamingMode(4096);
    }
  }

  Response readResponse(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    int i = paramHttpURLConnection.getResponseCode();
    String str1 = paramHttpURLConnection.getResponseMessage();
    if (str1 == null)
      str1 = "";
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramHttpURLConnection.getHeaderFields().entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      String str3 = (String)localEntry.getKey();
      Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
      while (localIterator2.hasNext())
        localArrayList.add(new Header(str3, (String)localIterator2.next()));
    }
    String str2 = paramHttpURLConnection.getContentType();
    int j = paramHttpURLConnection.getContentLength();
    if (i >= 400);
    for (InputStream localInputStream = paramHttpURLConnection.getErrorStream(); ; localInputStream = paramHttpURLConnection.getInputStream())
    {
      TypedInputStream localTypedInputStream = new TypedInputStream(str2, j, localInputStream, null);
      return new Response(paramHttpURLConnection.getURL().toString(), i, str1, localArrayList, localTypedInputStream);
    }
  }

  private static class TypedInputStream
    implements TypedInput
  {
    private final long length;
    private final String mimeType;
    private final InputStream stream;

    private TypedInputStream(String paramString, long paramLong, InputStream paramInputStream)
    {
      this.mimeType = paramString;
      this.length = paramLong;
      this.stream = paramInputStream;
    }

    public InputStream in()
      throws IOException
    {
      return this.stream;
    }

    public long length()
    {
      return this.length;
    }

    public String mimeType()
    {
      return this.mimeType;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.client.UrlConnectionClient
 * JD-Core Version:    0.6.2
 */