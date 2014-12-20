package a.a.a;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class cp
{
  public static co a(aa paramaa, InputStream paramInputStream)
  {
    try
    {
      cq localcq = new cq(paramInputStream, paramaa.b(), paramaa.c);
      return localcq;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new RuntimeException("Unsupported encoding: " + localUnsupportedEncodingException.getMessage());
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.cp
 * JD-Core Version:    0.6.0
 */