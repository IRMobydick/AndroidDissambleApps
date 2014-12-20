package se.verifique.app.cedula.a;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class d
{
  private byte[] a;
  private String b;

  public d(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    this.b = a(paramArrayOfByte);
  }

  private String a(byte[] paramArrayOfByte)
  {
    try
    {
      str = new String(paramArrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
      {
        localUnsupportedEncodingException.printStackTrace();
        String str = "";
      }
    }
  }

  public String a()
  {
    new StringBuilder().append(this.b.charAt(15)).toString();
    new StringBuilder().append(this.b.charAt(27)).toString();
    if (this.b.length() == 28)
      System.out.println("Datos del documento: " + this.b);
    for (String str = this.b.substring(0, 8) + "____________________"; ; str = null)
      return str;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.a.d
 * JD-Core Version:    0.6.0
 */