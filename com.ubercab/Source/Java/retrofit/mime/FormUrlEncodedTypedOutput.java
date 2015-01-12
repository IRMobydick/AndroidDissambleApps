package retrofit.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

public final class FormUrlEncodedTypedOutput
  implements TypedOutput
{
  final ByteArrayOutputStream content = new ByteArrayOutputStream();

  public void addField(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      throw new NullPointerException("name");
    if (paramString2 == null)
      throw new NullPointerException("value");
    if (this.content.size() > 0)
      this.content.write(38);
    try
    {
      String str1 = URLEncoder.encode(paramString1, "UTF-8");
      String str2 = URLEncoder.encode(paramString2, "UTF-8");
      this.content.write(str1.getBytes("UTF-8"));
      this.content.write(61);
      this.content.write(str2.getBytes("UTF-8"));
      return;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }

  public String fileName()
  {
    return null;
  }

  public long length()
  {
    return this.content.size();
  }

  public String mimeType()
  {
    return "application/x-www-form-urlencoded; charset=UTF-8";
  }

  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this.content.toByteArray());
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.mime.FormUrlEncodedTypedOutput
 * JD-Core Version:    0.6.2
 */