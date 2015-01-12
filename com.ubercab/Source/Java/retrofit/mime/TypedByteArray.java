package retrofit.mime;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class TypedByteArray
  implements TypedInput, TypedOutput
{
  private final byte[] bytes;
  private final String mimeType;

  public TypedByteArray(String paramString, byte[] paramArrayOfByte)
  {
    if (paramString == null)
      paramString = "application/unknown";
    if (paramArrayOfByte == null)
      throw new NullPointerException("bytes");
    this.mimeType = paramString;
    this.bytes = paramArrayOfByte;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    TypedByteArray localTypedByteArray;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localTypedByteArray = (TypedByteArray)paramObject;
      if (!Arrays.equals(this.bytes, localTypedByteArray.bytes))
        return false;
    }
    while (this.mimeType.equals(localTypedByteArray.mimeType));
    return false;
  }

  public String fileName()
  {
    return null;
  }

  public byte[] getBytes()
  {
    return this.bytes;
  }

  public int hashCode()
  {
    return 31 * this.mimeType.hashCode() + Arrays.hashCode(this.bytes);
  }

  public InputStream in()
    throws IOException
  {
    return new ByteArrayInputStream(this.bytes);
  }

  public long length()
  {
    return this.bytes.length;
  }

  public String mimeType()
  {
    return this.mimeType;
  }

  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this.bytes);
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.mime.TypedByteArray
 * JD-Core Version:    0.6.2
 */