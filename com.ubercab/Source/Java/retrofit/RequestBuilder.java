package retrofit;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.converter.Converter;
import retrofit.mime.FormUrlEncodedTypedOutput;
import retrofit.mime.MultipartTypedOutput;
import retrofit.mime.TypedOutput;
import retrofit.mime.TypedString;

final class RequestBuilder
  implements RequestInterceptor.RequestFacade
{
  private final String apiUrl;
  private TypedOutput body;
  private String contentTypeHeader;
  private final Converter converter;
  private final FormUrlEncodedTypedOutput formBody;
  private List<Header> headers;
  private final boolean isObservable;
  private final boolean isSynchronous;
  private final MultipartTypedOutput multipartBody;
  private final String[] paramNames;
  private final RestMethodInfo.ParamUsage[] paramUsages;
  private StringBuilder queryParams;
  private String relativeUrl;
  private final String requestMethod;

  RequestBuilder(String paramString, RestMethodInfo paramRestMethodInfo, Converter paramConverter)
  {
    this.apiUrl = paramString;
    this.converter = paramConverter;
    this.paramNames = paramRestMethodInfo.requestParamNames;
    this.paramUsages = paramRestMethodInfo.requestParamUsage;
    this.requestMethod = paramRestMethodInfo.requestMethod;
    this.isSynchronous = paramRestMethodInfo.isSynchronous;
    this.isObservable = paramRestMethodInfo.isObservable;
    if (paramRestMethodInfo.headers != null)
      this.headers = new ArrayList(paramRestMethodInfo.headers);
    this.contentTypeHeader = paramRestMethodInfo.contentTypeHeader;
    this.relativeUrl = paramRestMethodInfo.requestUrl;
    String str = paramRestMethodInfo.requestQuery;
    if (str != null)
      this.queryParams = new StringBuilder().append('?').append(str);
    switch (1.$SwitchMap$retrofit$RestMethodInfo$RequestType[paramRestMethodInfo.requestType.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unknown request type: " + paramRestMethodInfo.requestType);
    case 1:
      this.formBody = new FormUrlEncodedTypedOutput();
      this.multipartBody = null;
      this.body = this.formBody;
      return;
    case 2:
      this.formBody = null;
      this.multipartBody = new MultipartTypedOutput();
      this.body = this.multipartBody;
      return;
    case 3:
    }
    this.formBody = null;
    this.multipartBody = null;
  }

  private void addPathParam(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null)
      throw new IllegalArgumentException("Path replacement name must not be null.");
    if (paramString2 == null)
      throw new IllegalArgumentException("Path replacement \"" + paramString1 + "\" value must not be null.");
    if (paramBoolean);
    try
    {
      String str = URLEncoder.encode(String.valueOf(paramString2), "UTF-8").replace("+", "%20");
      this.relativeUrl = this.relativeUrl.replace("{" + paramString1 + "}", str);
      return;
      this.relativeUrl = this.relativeUrl.replace("{" + paramString1 + "}", String.valueOf(paramString2));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("Unable to convert path parameter \"" + paramString1 + "\" value to UTF-8:" + paramString2, localUnsupportedEncodingException);
    }
  }

  private void addQueryParam(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null)
      throw new IllegalArgumentException("Query param name must not be null.");
    if (paramString2 == null)
      throw new IllegalArgumentException("Query param \"" + paramString1 + "\" value must not be null.");
    if (paramBoolean);
    try
    {
      paramString2 = URLEncoder.encode(String.valueOf(paramString2), "UTF-8");
      StringBuilder localStringBuilder = this.queryParams;
      if (localStringBuilder == null)
      {
        localStringBuilder = new StringBuilder();
        this.queryParams = localStringBuilder;
      }
      if (localStringBuilder.length() > 0);
      for (char c = '&'; ; c = '?')
      {
        localStringBuilder.append(c);
        localStringBuilder.append(paramString1).append('=').append(paramString2);
        return;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("Unable to convert query parameter \"" + paramString1 + "\" value to UTF-8: " + paramString2, localUnsupportedEncodingException);
    }
  }

  public void addEncodedPathParam(String paramString1, String paramString2)
  {
    addPathParam(paramString1, paramString2, false);
  }

  public void addEncodedQueryParam(String paramString1, String paramString2)
  {
    addQueryParam(paramString1, paramString2, false);
  }

  public void addHeader(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      throw new IllegalArgumentException("Header name must not be null.");
    if ("Content-Type".equalsIgnoreCase(paramString1))
    {
      this.contentTypeHeader = paramString2;
      return;
    }
    Object localObject = this.headers;
    if (localObject == null)
    {
      localObject = new ArrayList(2);
      this.headers = ((List)localObject);
    }
    ((List)localObject).add(new Header(paramString1, paramString2));
  }

  public void addPathParam(String paramString1, String paramString2)
  {
    addPathParam(paramString1, paramString2, true);
  }

  public void addQueryParam(String paramString1, String paramString2)
  {
    addQueryParam(paramString1, paramString2, true);
  }

  Request build()
    throws UnsupportedEncodingException
  {
    if ((this.multipartBody != null) && (this.multipartBody.getPartCount() == 0))
      throw new IllegalStateException("Multipart requests must contain at least one part.");
    String str = this.apiUrl;
    StringBuilder localStringBuilder1 = new StringBuilder(str);
    if (str.endsWith("/"))
      localStringBuilder1.deleteCharAt(-1 + localStringBuilder1.length());
    localStringBuilder1.append(this.relativeUrl);
    StringBuilder localStringBuilder2 = this.queryParams;
    if (localStringBuilder2 != null)
      localStringBuilder1.append(localStringBuilder2);
    Object localObject = this.body;
    List localList = this.headers;
    if (this.contentTypeHeader != null)
    {
      if (localObject == null)
        break label147;
      localObject = new MimeOverridingTypedOutput((TypedOutput)localObject, this.contentTypeHeader);
    }
    while (true)
    {
      return new Request(this.requestMethod, localStringBuilder1.toString(), localList, (TypedOutput)localObject);
      label147: localList.add(new Header("Content-Type", this.contentTypeHeader));
    }
  }

  void setArguments(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null);
    int i;
    int j;
    do
    {
      return;
      i = paramArrayOfObject.length;
      if ((!this.isSynchronous) && (!this.isObservable))
        i--;
      j = 0;
    }
    while (j >= i);
    String str1 = this.paramNames[j];
    Object localObject1 = paramArrayOfObject[j];
    RestMethodInfo.ParamUsage localParamUsage = this.paramUsages[j];
    switch (1.$SwitchMap$retrofit$RestMethodInfo$ParamUsage[localParamUsage.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unknown parameter usage: " + localParamUsage);
    case 1:
      if (localObject1 == null)
        throw new IllegalArgumentException("Path parameter \"" + str1 + "\" value must not be null.");
      addPathParam(str1, localObject1.toString());
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    }
    while (true)
    {
      j++;
      break;
      if (localObject1 == null)
        throw new IllegalArgumentException("Path parameter \"" + str1 + "\" value must not be null.");
      addEncodedPathParam(str1, localObject1.toString());
      continue;
      if (localObject1 != null)
      {
        if (localParamUsage == RestMethodInfo.ParamUsage.QUERY);
        for (boolean bool2 = true; ; bool2 = false)
        {
          if (!(localObject1 instanceof Iterable))
            break label344;
          Iterator localIterator5 = ((Iterable)localObject1).iterator();
          while (localIterator5.hasNext())
          {
            Object localObject8 = localIterator5.next();
            if (localObject8 != null)
              addQueryParam(str1, localObject8.toString(), bool2);
          }
          break;
        }
        label344: if (localObject1.getClass().isArray())
        {
          int n = 0;
          int i1 = Array.getLength(localObject1);
          while (n < i1)
          {
            Object localObject7 = Array.get(localObject1, n);
            if (localObject7 != null)
              addQueryParam(str1, localObject7.toString(), bool2);
            n++;
          }
        }
        else
        {
          addQueryParam(str1, localObject1.toString(), bool2);
          continue;
          if (localObject1 != null)
          {
            if (localParamUsage == RestMethodInfo.ParamUsage.QUERY_MAP);
            for (boolean bool1 = true; ; bool1 = false)
            {
              Iterator localIterator4 = ((Map)localObject1).entrySet().iterator();
              while (localIterator4.hasNext())
              {
                Map.Entry localEntry3 = (Map.Entry)localIterator4.next();
                Object localObject6 = localEntry3.getValue();
                if (localObject6 != null)
                  addQueryParam(localEntry3.getKey().toString(), localObject6.toString(), bool1);
              }
              break;
            }
            if (localObject1 != null)
            {
              addHeader(str1, localObject1.toString());
              continue;
              if (localObject1 != null)
                if ((localObject1 instanceof Iterable))
                {
                  Iterator localIterator3 = ((Iterable)localObject1).iterator();
                  while (localIterator3.hasNext())
                  {
                    Object localObject5 = localIterator3.next();
                    if (localObject5 != null)
                      this.formBody.addField(str1, localObject5.toString());
                  }
                }
                else if (localObject1.getClass().isArray())
                {
                  int k = 0;
                  int m = Array.getLength(localObject1);
                  while (k < m)
                  {
                    Object localObject4 = Array.get(localObject1, k);
                    if (localObject4 != null)
                      this.formBody.addField(str1, localObject4.toString());
                    k++;
                  }
                }
                else
                {
                  this.formBody.addField(str1, localObject1.toString());
                  continue;
                  if (localObject1 != null)
                  {
                    Iterator localIterator2 = ((Map)localObject1).entrySet().iterator();
                    while (localIterator2.hasNext())
                    {
                      Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
                      Object localObject3 = localEntry2.getValue();
                      if (localObject3 != null)
                        this.formBody.addField(localEntry2.getKey().toString(), localObject3.toString());
                    }
                    continue;
                    if (localObject1 != null)
                      if ((localObject1 instanceof TypedOutput))
                      {
                        this.multipartBody.addPart(str1, (TypedOutput)localObject1);
                      }
                      else if ((localObject1 instanceof String))
                      {
                        MultipartTypedOutput localMultipartTypedOutput2 = this.multipartBody;
                        TypedString localTypedString2 = new TypedString((String)localObject1);
                        localMultipartTypedOutput2.addPart(str1, localTypedString2);
                      }
                      else
                      {
                        this.multipartBody.addPart(str1, this.converter.toBody(localObject1));
                        continue;
                        if (localObject1 != null)
                        {
                          Iterator localIterator1 = ((Map)localObject1).entrySet().iterator();
                          while (localIterator1.hasNext())
                          {
                            Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
                            String str2 = localEntry1.getKey().toString();
                            Object localObject2 = localEntry1.getValue();
                            if (localObject2 != null)
                              if ((localObject2 instanceof TypedOutput))
                              {
                                this.multipartBody.addPart(str2, (TypedOutput)localObject2);
                              }
                              else if ((localObject2 instanceof String))
                              {
                                MultipartTypedOutput localMultipartTypedOutput1 = this.multipartBody;
                                TypedString localTypedString1 = new TypedString((String)localObject2);
                                localMultipartTypedOutput1.addPart(str2, localTypedString1);
                              }
                              else
                              {
                                this.multipartBody.addPart(str2, this.converter.toBody(localObject2));
                              }
                          }
                          continue;
                          if (localObject1 == null)
                            throw new IllegalArgumentException("Body parameter value must not be null.");
                          if ((localObject1 instanceof TypedOutput))
                            this.body = ((TypedOutput)localObject1);
                          else
                            this.body = this.converter.toBody(localObject1);
                        }
                      }
                  }
                }
            }
          }
        }
      }
    }
  }

  private static class MimeOverridingTypedOutput
    implements TypedOutput
  {
    private final TypedOutput delegate;
    private final String mimeType;

    MimeOverridingTypedOutput(TypedOutput paramTypedOutput, String paramString)
    {
      this.delegate = paramTypedOutput;
      this.mimeType = paramString;
    }

    public String fileName()
    {
      return this.delegate.fileName();
    }

    public long length()
    {
      return this.delegate.length();
    }

    public String mimeType()
    {
      return this.mimeType;
    }

    public void writeTo(OutputStream paramOutputStream)
      throws IOException
    {
      this.delegate.writeTo(paramOutputStream);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.RequestBuilder
 * JD-Core Version:    0.6.2
 */