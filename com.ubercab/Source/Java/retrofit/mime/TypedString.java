package retrofit.mime;

import java.io.UnsupportedEncodingException;

public class TypedString extends TypedByteArray
{
  public TypedString(String paramString)
  {
    super("text/plain; charset=UTF-8", convertToBytes(paramString));
  }

  private static byte[] convertToBytes(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException(localUnsupportedEncodingException);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.mime.TypedString
 * JD-Core Version:    0.6.2
 */