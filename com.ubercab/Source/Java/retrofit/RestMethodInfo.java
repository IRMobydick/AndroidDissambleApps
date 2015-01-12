package retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.EncodedPath;
import retrofit.http.EncodedQuery;
import retrofit.http.EncodedQueryMap;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.Multipart;
import retrofit.http.Part;
import retrofit.http.PartMap;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import retrofit.http.RestMethod;
import retrofit.http.Streaming;
import rx.Observable;

final class RestMethodInfo
{
  private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
  private static final Pattern PARAM_NAME_REGEX = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
  private static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
  String contentTypeHeader;
  List<retrofit.client.Header> headers;
  final boolean isObservable;
  boolean isStreaming;
  final boolean isSynchronous;
  boolean loaded = false;
  final Method method;
  boolean requestHasBody;
  String requestMethod;
  String[] requestParamNames;
  ParamUsage[] requestParamUsage;
  String requestQuery;
  RequestType requestType = RequestType.SIMPLE;
  String requestUrl;
  Set<String> requestUrlParamNames;
  Type responseObjectType;
  final ResponseType responseType;

  RestMethodInfo(Method paramMethod)
  {
    this.method = paramMethod;
    this.responseType = parseResponseType();
    boolean bool2;
    if (this.responseType == ResponseType.OBJECT)
    {
      bool2 = bool1;
      this.isSynchronous = bool2;
      if (this.responseType != ResponseType.OBSERVABLE)
        break label69;
    }
    while (true)
    {
      this.isObservable = bool1;
      return;
      bool2 = false;
      break;
      label69: bool1 = false;
    }
  }

  private static Type getParameterUpperBound(ParameterizedType paramParameterizedType)
  {
    Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
    for (int i = 0; i < arrayOfType.length; i++)
    {
      Type localType = arrayOfType[i];
      if ((localType instanceof WildcardType))
        arrayOfType[i] = ((WildcardType)localType).getUpperBounds()[0];
    }
    return arrayOfType[0];
  }

  private RuntimeException methodError(String paramString, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length > 0)
      paramString = String.format(paramString, paramArrayOfObject);
    return new IllegalArgumentException(this.method.getDeclaringClass().getSimpleName() + "." + this.method.getName() + ": " + paramString);
  }

  private RuntimeException parameterError(int paramInt, String paramString, Object[] paramArrayOfObject)
  {
    return methodError(paramString + " (parameter #" + (paramInt + 1) + ")", paramArrayOfObject);
  }

  private void parseMethodAnnotations()
  {
    Annotation[] arrayOfAnnotation1 = this.method.getAnnotations();
    int i = arrayOfAnnotation1.length;
    int j = 0;
    if (j < i)
    {
      Annotation localAnnotation1 = arrayOfAnnotation1[j];
      Class localClass = localAnnotation1.annotationType();
      Annotation[] arrayOfAnnotation2 = localClass.getAnnotations();
      int k = arrayOfAnnotation2.length;
      RestMethod localRestMethod;
      for (int m = 0; ; m++)
      {
        localRestMethod = null;
        if (m < k)
        {
          Annotation localAnnotation2 = arrayOfAnnotation2[m];
          if (RestMethod.class == localAnnotation2.annotationType())
            localRestMethod = (RestMethod)localAnnotation2;
        }
        else
        {
          if (localRestMethod == null)
            break label220;
          if (this.requestMethod == null)
            break;
          Object[] arrayOfObject3 = new Object[2];
          arrayOfObject3[0] = this.requestMethod;
          arrayOfObject3[1] = localRestMethod.value();
          throw methodError("Only one HTTP method is allowed. Found: %s and %s.", arrayOfObject3);
        }
      }
      while (true)
      {
        try
        {
          String str = (String)localClass.getMethod("value", new Class[0]).invoke(localAnnotation1, new Object[0]);
          parsePath(str);
          this.requestMethod = localRestMethod.value();
          this.requestHasBody = localRestMethod.hasBody();
          j++;
        }
        catch (Exception localException)
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = localClass.getSimpleName();
          throw methodError("Failed to extract String 'value' from @%s annotation.", arrayOfObject2);
        }
        label220: if (localClass == Headers.class)
        {
          String[] arrayOfString = ((Headers)localAnnotation1).value();
          if (arrayOfString.length == 0)
            throw methodError("@Headers annotation is empty.", new Object[0]);
          this.headers = parseHeaders(arrayOfString);
        }
        else if (localClass == Multipart.class)
        {
          if (this.requestType != RequestType.SIMPLE)
            throw methodError("Only one encoding annotation is allowed.", new Object[0]);
          this.requestType = RequestType.MULTIPART;
        }
        else if (localClass == FormUrlEncoded.class)
        {
          if (this.requestType != RequestType.SIMPLE)
            throw methodError("Only one encoding annotation is allowed.", new Object[0]);
          this.requestType = RequestType.FORM_URL_ENCODED;
        }
        else if (localClass == Streaming.class)
        {
          if (this.responseObjectType != Response.class)
          {
            Object[] arrayOfObject1 = new Object[2];
            arrayOfObject1[0] = Response.class.getSimpleName();
            arrayOfObject1[1] = Streaming.class.getSimpleName();
            throw methodError("Only methods having %s as data type are allowed to have @%s annotation.", arrayOfObject1);
          }
          this.isStreaming = true;
        }
      }
    }
    if (this.requestMethod == null)
      throw methodError("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
    if (!this.requestHasBody)
    {
      if (this.requestType == RequestType.MULTIPART)
        throw methodError("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
      if (this.requestType == RequestType.FORM_URL_ENCODED)
        throw methodError("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
    }
  }

  private void parseParameters()
  {
    Class[] arrayOfClass = this.method.getParameterTypes();
    Annotation[][] arrayOfAnnotation = this.method.getParameterAnnotations();
    int i = arrayOfAnnotation.length;
    if ((!this.isSynchronous) && (!this.isObservable))
      i--;
    String[] arrayOfString = new String[i];
    this.requestParamNames = arrayOfString;
    ParamUsage[] arrayOfParamUsage = new ParamUsage[i];
    this.requestParamUsage = arrayOfParamUsage;
    int j = 0;
    int k = 0;
    int m = 0;
    for (int n = 0; n < i; n++)
    {
      Class localClass1 = arrayOfClass[n];
      Annotation[] arrayOfAnnotation1 = arrayOfAnnotation[n];
      if (arrayOfAnnotation1 != null)
      {
        int i1 = arrayOfAnnotation1.length;
        int i2 = 0;
        if (i2 < i1)
        {
          Annotation localAnnotation = arrayOfAnnotation1[i2];
          Class localClass2 = localAnnotation.annotationType();
          if (localClass2 == Path.class)
          {
            String str5 = ((Path)localAnnotation).value();
            validatePathName(n, str5);
            arrayOfString[n] = str5;
            arrayOfParamUsage[n] = ParamUsage.PATH;
          }
          while (true)
          {
            i2++;
            break;
            if (localClass2 == EncodedPath.class)
            {
              String str4 = ((EncodedPath)localAnnotation).value();
              validatePathName(n, str4);
              arrayOfString[n] = str4;
              arrayOfParamUsage[n] = ParamUsage.ENCODED_PATH;
            }
            else if (localClass2 == Query.class)
            {
              arrayOfString[n] = ((Query)localAnnotation).value();
              arrayOfParamUsage[n] = ParamUsage.QUERY;
            }
            else if (localClass2 == EncodedQuery.class)
            {
              arrayOfString[n] = ((EncodedQuery)localAnnotation).value();
              arrayOfParamUsage[n] = ParamUsage.ENCODED_QUERY;
            }
            else if (localClass2 == QueryMap.class)
            {
              if (!Map.class.isAssignableFrom(localClass1))
                throw parameterError(n, "@QueryMap parameter type must be Map.", new Object[0]);
              arrayOfParamUsage[n] = ParamUsage.QUERY_MAP;
            }
            else if (localClass2 == EncodedQueryMap.class)
            {
              if (!Map.class.isAssignableFrom(localClass1))
                throw parameterError(n, "@EncodedQueryMap parameter type must be Map.", new Object[0]);
              arrayOfParamUsage[n] = ParamUsage.ENCODED_QUERY_MAP;
            }
            else if (localClass2 == retrofit.http.Header.class)
            {
              String str3 = ((retrofit.http.Header)localAnnotation).value();
              if (localClass1 != String.class)
              {
                Object[] arrayOfObject = new Object[1];
                arrayOfObject[0] = localClass1.getSimpleName();
                throw parameterError(n, "@Header parameter type must be String. Found: %s.", arrayOfObject);
              }
              arrayOfString[n] = str3;
              arrayOfParamUsage[n] = ParamUsage.HEADER;
            }
            else if (localClass2 == Field.class)
            {
              if (this.requestType != RequestType.FORM_URL_ENCODED)
                throw parameterError(n, "@Field parameters can only be used with form encoding.", new Object[0]);
              String str2 = ((Field)localAnnotation).value();
              j = 1;
              arrayOfString[n] = str2;
              arrayOfParamUsage[n] = ParamUsage.FIELD;
            }
            else if (localClass2 == FieldMap.class)
            {
              if (this.requestType != RequestType.FORM_URL_ENCODED)
                throw parameterError(n, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
              if (!Map.class.isAssignableFrom(localClass1))
                throw parameterError(n, "@FieldMap parameter type must be Map.", new Object[0]);
              j = 1;
              arrayOfParamUsage[n] = ParamUsage.FIELD_MAP;
            }
            else if (localClass2 == Part.class)
            {
              if (this.requestType != RequestType.MULTIPART)
                throw parameterError(n, "@Part parameters can only be used with multipart encoding.", new Object[0]);
              String str1 = ((Part)localAnnotation).value();
              k = 1;
              arrayOfString[n] = str1;
              arrayOfParamUsage[n] = ParamUsage.PART;
            }
            else if (localClass2 == PartMap.class)
            {
              if (this.requestType != RequestType.MULTIPART)
                throw parameterError(n, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
              if (!Map.class.isAssignableFrom(localClass1))
                throw parameterError(n, "@PartMap parameter type must be Map.", new Object[0]);
              k = 1;
              arrayOfParamUsage[n] = ParamUsage.PART_MAP;
            }
            else if (localClass2 == Body.class)
            {
              if (this.requestType != RequestType.SIMPLE)
                throw parameterError(n, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
              if (m != 0)
                throw methodError("Multiple @Body method annotations found.", new Object[0]);
              m = 1;
              arrayOfParamUsage[n] = ParamUsage.BODY;
            }
          }
        }
      }
      if (arrayOfParamUsage[n] == null)
        throw parameterError(n, "No Retrofit annotation found.", new Object[0]);
    }
    if ((this.requestType == RequestType.SIMPLE) && (!this.requestHasBody) && (m != 0))
      throw methodError("Non-body HTTP method cannot contain @Body or @TypedOutput.", new Object[0]);
    if ((this.requestType == RequestType.FORM_URL_ENCODED) && (j == 0))
      throw methodError("Form-encoded method must contain at least one @Field.", new Object[0]);
    if ((this.requestType == RequestType.MULTIPART) && (k == 0))
      throw methodError("Multipart method must contain at least one @Part.", new Object[0]);
  }

  private void parsePath(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramString.charAt(0) != '/'))
      throw methodError("URL path \"%s\" must start with '/'.", new Object[] { paramString });
    String str1 = paramString;
    int i = paramString.indexOf('?');
    String str2 = null;
    if (i != -1)
    {
      int j = -1 + paramString.length();
      str2 = null;
      if (i < j)
      {
        str1 = paramString.substring(0, i);
        str2 = paramString.substring(i + 1);
        if (PARAM_URL_REGEX.matcher(str2).find())
          throw methodError("URL query string \"%s\" must not have replace block.", new Object[] { str2 });
      }
    }
    Set localSet = parsePathParameters(paramString);
    this.requestUrl = str1;
    this.requestUrlParamNames = localSet;
    this.requestQuery = str2;
  }

  static Set<String> parsePathParameters(String paramString)
  {
    Matcher localMatcher = PARAM_URL_REGEX.matcher(paramString);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    while (localMatcher.find())
      localLinkedHashSet.add(localMatcher.group(1));
    return localLinkedHashSet;
  }

  private ResponseType parseResponseType()
  {
    int i = 1;
    Type localType1 = this.method.getGenericReturnType();
    Type[] arrayOfType = this.method.getGenericParameterTypes();
    int j = arrayOfType.length;
    Class localClass1 = null;
    Object localObject = null;
    if (j > 0)
    {
      Type localType3 = arrayOfType[(-1 + arrayOfType.length)];
      localObject = localType3;
      if ((localType3 instanceof ParameterizedType))
        localType3 = ((ParameterizedType)localType3).getRawType();
      boolean bool = localType3 instanceof Class;
      localClass1 = null;
      if (bool)
        localClass1 = (Class)localType3;
    }
    int k;
    if (localType1 != Void.TYPE)
    {
      k = i;
      if ((localClass1 == null) || (!Callback.class.isAssignableFrom(localClass1)))
        break label140;
    }
    while (true)
    {
      if ((k == 0) || (i == 0))
        break label145;
      throw methodError("Must have return type or Callback as last argument, not both.", new Object[0]);
      k = 0;
      break;
      label140: i = 0;
    }
    label145: if ((k == 0) && (i == 0))
      throw methodError("Must have either a return type or Callback as last argument.", new Object[0]);
    if (k != 0)
    {
      if (Platform.HAS_RX_JAVA)
      {
        Class localClass2 = Types.getRawType(localType1);
        if (RxSupport.isObservable(localClass2))
        {
          this.responseObjectType = getParameterUpperBound((ParameterizedType)RxSupport.getObservableType(localType1, localClass2));
          return ResponseType.OBSERVABLE;
        }
      }
      this.responseObjectType = localType1;
      return ResponseType.OBJECT;
    }
    Type localType2 = Types.getSupertype(localObject, Types.getRawType(localObject), Callback.class);
    if ((localType2 instanceof ParameterizedType))
    {
      this.responseObjectType = getParameterUpperBound((ParameterizedType)localType2);
      return ResponseType.VOID;
    }
    throw methodError("Last parameter must be of type Callback<X> or Callback<? super X>.", new Object[0]);
  }

  private void validatePathName(int paramInt, String paramString)
  {
    if (!PARAM_NAME_REGEX.matcher(paramString).matches())
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = PARAM_URL_REGEX.pattern();
      arrayOfObject2[1] = paramString;
      throw parameterError(paramInt, "@Path parameter name must match %s. Found: %s", arrayOfObject2);
    }
    if (!this.requestUrlParamNames.contains(paramString))
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = this.requestUrl;
      arrayOfObject1[1] = paramString;
      throw parameterError(paramInt, "URL \"%s\" does not contain \"{%s}\".", arrayOfObject1);
    }
  }

  void init()
  {
    try
    {
      boolean bool = this.loaded;
      if (bool);
      while (true)
      {
        return;
        parseMethodAnnotations();
        parseParameters();
        this.loaded = true;
      }
    }
    finally
    {
    }
  }

  List<retrofit.client.Header> parseHeaders(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfString.length;
    int j = 0;
    if (j < i)
    {
      String str1 = paramArrayOfString[j];
      int k = str1.indexOf(':');
      if ((k == -1) || (k == 0) || (k == -1 + str1.length()))
        throw methodError("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[] { str1 });
      String str2 = str1.substring(0, k);
      String str3 = str1.substring(k + 1).trim();
      if ("Content-Type".equalsIgnoreCase(str2))
        this.contentTypeHeader = str3;
      while (true)
      {
        j++;
        break;
        localArrayList.add(new retrofit.client.Header(str2, str3));
      }
    }
    return localArrayList;
  }

  static enum ParamUsage
  {
    static
    {
      ENCODED_PATH = new ParamUsage("ENCODED_PATH", 1);
      QUERY = new ParamUsage("QUERY", 2);
      ENCODED_QUERY = new ParamUsage("ENCODED_QUERY", 3);
      QUERY_MAP = new ParamUsage("QUERY_MAP", 4);
      ENCODED_QUERY_MAP = new ParamUsage("ENCODED_QUERY_MAP", 5);
      FIELD = new ParamUsage("FIELD", 6);
      FIELD_MAP = new ParamUsage("FIELD_MAP", 7);
      PART = new ParamUsage("PART", 8);
      PART_MAP = new ParamUsage("PART_MAP", 9);
      BODY = new ParamUsage("BODY", 10);
      HEADER = new ParamUsage("HEADER", 11);
      ParamUsage[] arrayOfParamUsage = new ParamUsage[12];
      arrayOfParamUsage[0] = PATH;
      arrayOfParamUsage[1] = ENCODED_PATH;
      arrayOfParamUsage[2] = QUERY;
      arrayOfParamUsage[3] = ENCODED_QUERY;
      arrayOfParamUsage[4] = QUERY_MAP;
      arrayOfParamUsage[5] = ENCODED_QUERY_MAP;
      arrayOfParamUsage[6] = FIELD;
      arrayOfParamUsage[7] = FIELD_MAP;
      arrayOfParamUsage[8] = PART;
      arrayOfParamUsage[9] = PART_MAP;
      arrayOfParamUsage[10] = BODY;
      arrayOfParamUsage[11] = HEADER;
    }
  }

  static enum RequestType
  {
    static
    {
      MULTIPART = new RequestType("MULTIPART", 1);
      FORM_URL_ENCODED = new RequestType("FORM_URL_ENCODED", 2);
      RequestType[] arrayOfRequestType = new RequestType[3];
      arrayOfRequestType[0] = SIMPLE;
      arrayOfRequestType[1] = MULTIPART;
      arrayOfRequestType[2] = FORM_URL_ENCODED;
    }
  }

  private static enum ResponseType
  {
    static
    {
      OBSERVABLE = new ResponseType("OBSERVABLE", 1);
      OBJECT = new ResponseType("OBJECT", 2);
      ResponseType[] arrayOfResponseType = new ResponseType[3];
      arrayOfResponseType[0] = VOID;
      arrayOfResponseType[1] = OBSERVABLE;
      arrayOfResponseType[2] = OBJECT;
    }
  }

  private static final class RxSupport
  {
    public static Type getObservableType(Type paramType, Class paramClass)
    {
      return Types.getSupertype(paramType, paramClass, Observable.class);
    }

    public static boolean isObservable(Class paramClass)
    {
      return paramClass == Observable.class;
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.RestMethodInfo
 * JD-Core Version:    0.6.2
 */