package retrofit.mime;

import java.io.IOException;
import java.io.InputStream;

public abstract interface TypedInput
{
  public abstract InputStream in()
    throws IOException;

  public abstract long length();

  public abstract String mimeType();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.mime.TypedInput
 * JD-Core Version:    0.6.2
 */