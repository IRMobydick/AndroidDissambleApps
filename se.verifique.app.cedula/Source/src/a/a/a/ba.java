package a.a.a;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class ba
{
  public static az a(aa paramaa, OutputStream paramOutputStream)
  {
    try
    {
      bb localbb = new bb(paramaa, paramaa.c(), paramOutputStream);
      return localbb;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new RuntimeException("Unsupported encoding: " + localUnsupportedEncodingException.getMessage());
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.ba
 * JD-Core Version:    0.6.0
 */