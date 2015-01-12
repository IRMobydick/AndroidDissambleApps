package retrofit.converter;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import retrofit.mime.TypedOutput;

public class GsonConverter
  implements Converter
{
  private String encoding;
  private final Gson gson;

  public GsonConverter(Gson paramGson)
  {
    this(paramGson, "UTF-8");
  }

  public GsonConverter(Gson paramGson, String paramString)
  {
    this.gson = paramGson;
    this.encoding = paramString;
  }

  // ERROR //
  public Object fromBody(retrofit.mime.TypedInput paramTypedInput, java.lang.reflect.Type paramType)
    throws ConversionException
  {
    // Byte code:
    //   0: ldc 14
    //   2: astore_3
    //   3: aload_1
    //   4: invokeinterface 38 1 0
    //   9: ifnull +13 -> 22
    //   12: aload_1
    //   13: invokeinterface 38 1 0
    //   18: invokestatic 44	retrofit/mime/MimeUtil:parseCharset	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore_3
    //   22: aconst_null
    //   23: astore 4
    //   25: new 46	java/io/InputStreamReader
    //   28: dup
    //   29: aload_1
    //   30: invokeinterface 50 1 0
    //   35: aload_3
    //   36: invokespecial 53	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   39: astore 5
    //   41: aload_0
    //   42: getfield 22	retrofit/converter/GsonConverter:gson	Lcom/google/gson/Gson;
    //   45: aload 5
    //   47: aload_2
    //   48: invokevirtual 59	com/google/gson/Gson:fromJson	(Ljava/io/Reader;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   51: astore 10
    //   53: aload 5
    //   55: ifnull +8 -> 63
    //   58: aload 5
    //   60: invokevirtual 62	java/io/InputStreamReader:close	()V
    //   63: aload 10
    //   65: areturn
    //   66: astore 6
    //   68: new 28	retrofit/converter/ConversionException
    //   71: dup
    //   72: aload 6
    //   74: invokespecial 65	retrofit/converter/ConversionException:<init>	(Ljava/lang/Throwable;)V
    //   77: athrow
    //   78: astore 7
    //   80: aload 4
    //   82: ifnull +8 -> 90
    //   85: aload 4
    //   87: invokevirtual 62	java/io/InputStreamReader:close	()V
    //   90: aload 7
    //   92: athrow
    //   93: astore 9
    //   95: new 28	retrofit/converter/ConversionException
    //   98: dup
    //   99: aload 9
    //   101: invokespecial 65	retrofit/converter/ConversionException:<init>	(Ljava/lang/Throwable;)V
    //   104: athrow
    //   105: astore 11
    //   107: aload 10
    //   109: areturn
    //   110: astore 8
    //   112: goto -22 -> 90
    //   115: astore 7
    //   117: aload 5
    //   119: astore 4
    //   121: goto -41 -> 80
    //   124: astore 9
    //   126: aload 5
    //   128: astore 4
    //   130: goto -35 -> 95
    //   133: astore 6
    //   135: aload 5
    //   137: astore 4
    //   139: goto -71 -> 68
    //
    // Exception table:
    //   from	to	target	type
    //   25	41	66	java/io/IOException
    //   25	41	78	finally
    //   68	78	78	finally
    //   95	105	78	finally
    //   25	41	93	com/google/gson/JsonParseException
    //   58	63	105	java/io/IOException
    //   85	90	110	java/io/IOException
    //   41	53	115	finally
    //   41	53	124	com/google/gson/JsonParseException
    //   41	53	133	java/io/IOException
  }

  public TypedOutput toBody(Object paramObject)
  {
    try
    {
      JsonTypedOutput localJsonTypedOutput = new JsonTypedOutput(this.gson.toJson(paramObject).getBytes(this.encoding), this.encoding);
      return localJsonTypedOutput;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError(localUnsupportedEncodingException);
    }
  }

  private static class JsonTypedOutput
    implements TypedOutput
  {
    private final byte[] jsonBytes;
    private final String mimeType;

    JsonTypedOutput(byte[] paramArrayOfByte, String paramString)
    {
      this.jsonBytes = paramArrayOfByte;
      this.mimeType = ("application/json; charset=" + paramString);
    }

    public String fileName()
    {
      return null;
    }

    public long length()
    {
      return this.jsonBytes.length;
    }

    public String mimeType()
    {
      return this.mimeType;
    }

    public void writeTo(OutputStream paramOutputStream)
      throws IOException
    {
      paramOutputStream.write(this.jsonBytes);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.converter.GsonConverter
 * JD-Core Version:    0.6.2
 */