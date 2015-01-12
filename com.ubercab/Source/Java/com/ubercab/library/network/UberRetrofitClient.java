package com.ubercab.library.network;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import retrofit.client.Client;
import retrofit.client.Request;
import retrofit.client.Response;

public class UberRetrofitClient
  implements Client
{
  private Client mClient;
  private List<Listener> mListeners = new CopyOnWriteArrayList();
  private UberEndpoint mUberEndpoint;

  public UberRetrofitClient(Client paramClient, UberEndpoint paramUberEndpoint)
  {
    this.mClient = paramClient;
    this.mUberEndpoint = paramUberEndpoint;
  }

  // ERROR //
  private static Request replaceRequestBody(Request paramRequest)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 37	retrofit/client/Request:getBody	()Lretrofit/mime/TypedOutput;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: instanceof 39
    //   13: ifeq +5 -> 18
    //   16: aload_0
    //   17: areturn
    //   18: new 41	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 42	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_2
    //   26: aload_1
    //   27: aload_2
    //   28: invokeinterface 48 2 0
    //   33: new 39	retrofit/mime/TypedByteArray
    //   36: dup
    //   37: aload_1
    //   38: invokeinterface 52 1 0
    //   43: aload_2
    //   44: invokevirtual 56	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   47: invokespecial 59	retrofit/mime/TypedByteArray:<init>	(Ljava/lang/String;[B)V
    //   50: astore 4
    //   52: new 33	retrofit/client/Request
    //   55: dup
    //   56: aload_0
    //   57: invokevirtual 62	retrofit/client/Request:getMethod	()Ljava/lang/String;
    //   60: aload_0
    //   61: invokevirtual 65	retrofit/client/Request:getUrl	()Ljava/lang/String;
    //   64: aload_0
    //   65: invokevirtual 69	retrofit/client/Request:getHeaders	()Ljava/util/List;
    //   68: aload 4
    //   70: invokespecial 72	retrofit/client/Request:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lretrofit/mime/TypedOutput;)V
    //   73: astore 5
    //   75: aload_2
    //   76: invokestatic 77	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   79: aload 5
    //   81: areturn
    //   82: astore_3
    //   83: aload_2
    //   84: invokestatic 77	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   87: aload_3
    //   88: athrow
    //   89: astore_3
    //   90: goto -7 -> 83
    //
    // Exception table:
    //   from	to	target	type
    //   26	52	82	finally
    //   52	75	89	finally
  }

  // ERROR //
  private static Response replaceResponseBody(Response paramResponse)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 84	retrofit/client/Response:getBody	()Lretrofit/mime/TypedInput;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: instanceof 39
    //   13: ifeq +5 -> 18
    //   16: aload_0
    //   17: areturn
    //   18: aload_1
    //   19: invokeinterface 90 1 0
    //   24: astore_2
    //   25: aload_2
    //   26: invokestatic 93	com/ubercab/common/io/IOUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   29: astore 4
    //   31: new 39	retrofit/mime/TypedByteArray
    //   34: dup
    //   35: aload_1
    //   36: invokeinterface 94 1 0
    //   41: aload 4
    //   43: invokespecial 59	retrofit/mime/TypedByteArray:<init>	(Ljava/lang/String;[B)V
    //   46: astore 5
    //   48: new 81	retrofit/client/Response
    //   51: dup
    //   52: aload_0
    //   53: invokevirtual 95	retrofit/client/Response:getUrl	()Ljava/lang/String;
    //   56: aload_0
    //   57: invokevirtual 99	retrofit/client/Response:getStatus	()I
    //   60: aload_0
    //   61: invokevirtual 102	retrofit/client/Response:getReason	()Ljava/lang/String;
    //   64: aload_0
    //   65: invokevirtual 103	retrofit/client/Response:getHeaders	()Ljava/util/List;
    //   68: aload 5
    //   70: invokespecial 106	retrofit/client/Response:<init>	(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Lretrofit/mime/TypedInput;)V
    //   73: astore 6
    //   75: aload_2
    //   76: invokestatic 109	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   79: aload 6
    //   81: areturn
    //   82: astore_3
    //   83: aload_2
    //   84: invokestatic 109	com/ubercab/common/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   87: aload_3
    //   88: athrow
    //   89: astore_3
    //   90: goto -7 -> 83
    //
    // Exception table:
    //   from	to	target	type
    //   25	48	82	finally
    //   48	75	89	finally
  }

  public void addListener(Listener paramListener)
  {
    this.mListeners.add(paramListener);
  }

  public Response execute(Request paramRequest)
    throws IOException
  {
    String str = UUID.randomUUID().toString().replace("-", "");
    Request localRequest1 = replaceRequestBody(paramRequest);
    Iterator localIterator1 = this.mListeners.iterator();
    while (localIterator1.hasNext())
      ((Listener)localIterator1.next()).onRequest(str, localRequest1);
    long l1 = System.nanoTime();
    try
    {
      Response localResponse1 = this.mClient.execute(localRequest1);
      long l3 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l1);
      localObject = replaceResponseBody(localResponse1);
      Iterator localIterator3 = this.mListeners.iterator();
      while (localIterator3.hasNext())
        ((Listener)localIterator3.next()).onResponse(str, localRequest1, (Response)localObject, l3);
    }
    catch (IOException localIOException)
    {
      Object localObject;
      long l2 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l1);
      Iterator localIterator2 = this.mListeners.iterator();
      while (localIterator2.hasNext())
      {
        ((Listener)localIterator2.next()).onNetworkError(str, localRequest1, localIOException, l2);
        continue;
        if (this.mUberEndpoint.getFailoverStrategy().interceptResponse((Response)localObject))
        {
          Request localRequest2 = new Request(localRequest1.getMethod(), this.mUberEndpoint.getUrl(), localRequest1.getHeaders(), localRequest1.getBody());
          Response localResponse2 = execute(localRequest2);
          localObject = localResponse2;
        }
        return localObject;
      }
      throw localIOException;
    }
  }

  public void removeListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }

  public static abstract interface Listener
  {
    public abstract void onNetworkError(String paramString, Request paramRequest, IOException paramIOException, long paramLong);

    public abstract void onRequest(String paramString, Request paramRequest);

    public abstract void onResponse(String paramString, Request paramRequest, Response paramResponse, long paramLong);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.library.network.UberRetrofitClient
 * JD-Core Version:    0.6.2
 */