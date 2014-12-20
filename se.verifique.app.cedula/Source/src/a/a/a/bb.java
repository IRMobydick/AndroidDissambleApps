package a.a.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;

public class bb
  implements az
{
  private Writer a;
  private char[] b;

  protected bb(aa paramaa, String paramString, OutputStream paramOutputStream)
  {
    this.a = new OutputStreamWriter(paramOutputStream, paramString);
    this.b = paramaa.as;
  }

  public void a()
  {
    try
    {
      this.a.write(this.b);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        System.err.println("OutJavaImpl.newline: " + localIOException.getMessage());
    }
  }

  public void a(int paramInt)
  {
    try
    {
      this.a.write(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        System.err.println("OutJavaImpl.outc: " + localIOException.getMessage());
    }
  }

  public void b()
  {
    try
    {
      this.a.flush();
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        System.err.println("OutJavaImpl.flush: " + localIOException.getMessage());
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.bb
 * JD-Core Version:    0.6.0
 */