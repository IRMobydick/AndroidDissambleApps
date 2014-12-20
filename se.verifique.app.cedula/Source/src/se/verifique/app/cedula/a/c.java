package se.verifique.app.cedula.a;

import android.content.Context;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import se.verifique.app.cedula.b.a;
import se.verifique.app.cedula.util.Parametros;

public class c
  implements Serializable
{
  private int a;
  private String b;
  private String c;
  private String d;
  private String e;
  private int f;
  private String g;
  private String h;
  private byte[] i;
  private String j;

  public c(byte[] paramArrayOfByte)
  {
    this.i = paramArrayOfByte;
    this.j = a(paramArrayOfByte);
  }

  private String a(int paramInt1, int paramInt2)
  {
    String str = "";
    int k = -1 + (paramInt1 + paramInt2);
    if (k < paramInt1);
    while (true)
    {
      if (paramInt1 > k)
      {
        return str;
        if ((this.j.charAt(k) != 0) || (this.j.charAt(k) != ' '))
          continue;
        k--;
        break;
      }
      if ((this.j.charAt(paramInt1) != 0) && (this.j.charAt(paramInt1) != ' '))
        str = str + this.j.charAt(paramInt1);
      paramInt1++;
    }
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

  private String b(String paramString)
  {
    String str;
    if ("01".equals(paramString))
      str = "ENE";
    while (true)
    {
      return str;
      if ("02".equals(paramString))
      {
        str = "FEB";
        continue;
      }
      if ("03".equals(paramString))
      {
        str = "MAR";
        continue;
      }
      if ("04".equals(paramString))
      {
        str = "ABR";
        continue;
      }
      if ("05".equals(paramString))
      {
        str = "MAY";
        continue;
      }
      if ("06".equals(paramString))
      {
        str = "JUN";
        continue;
      }
      if ("07".equals(paramString))
      {
        str = "JUL";
        continue;
      }
      if ("08".equals(paramString))
      {
        str = "AGO";
        continue;
      }
      if ("09".equals(paramString))
      {
        str = "SEP";
        continue;
      }
      if ("10".equals(paramString))
      {
        str = "OCT";
        continue;
      }
      if ("11".equals(paramString))
      {
        str = "NOV";
        continue;
      }
      if ("12".equals(paramString))
      {
        str = "DIC";
        continue;
      }
      str = "";
    }
  }

  private int i()
  {
    int k = 0;
    if ((this.i[0] == 48) && (this.i[1] == 50))
      k = 2;
    while (true)
    {
      return k;
      if ((this.i[0] == 48) && (this.i[1] == 51))
      {
        k = 3;
        continue;
      }
      if ((this.i[0] != 73) || (this.i[1] != 51))
        continue;
      k = 4;
    }
  }

  public String a()
  {
    return this.f;
  }

  public void a(String paramString)
  {
    this.g = paramString;
  }

  public void b()
  {
    if (this.i.length < 531)
      throw new a(Parametros.b().getString(2131165274));
    try
    {
      this.f = Integer.parseInt(a(48, 10));
      this.a = i();
      switch (this.a)
      {
      default:
        throw new a(Parametros.b().getString(2131165276));
      case 4:
      case 2:
      case 3:
      }
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      this.f = 0;
      throw new a(Parametros.b().getString(2131165275));
    }
    if ("PubDSK_1".equals(a(24, 8)));
    for (int k = 1; ; k = 0)
    {
      while (true)
      {
        this.d = a(k + 58, 23);
        this.e = a(k + 81, 23);
        this.b = a(k + 104, 23);
        this.c = a(k + 127, 23);
        a(a(k + 152, 8));
        this.g = (this.g.substring(6, 8) + "-" + b(this.g.substring(4, 6)) + "-" + this.g.substring(0, 4));
        this.h = a(k + 166, 2);
        return;
        throw new a(Parametros.b().getString(2131165277));
        try
        {
          Long.parseLong(a(22, 12));
          k = 0;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          throw new a(Parametros.b().getString(2131165275));
        }
      }
      if (!"PubDSK_1".equals(a(24, 8)))
        break;
    }
    throw new a(Parametros.b().getString(2131165275));
  }

  public String c()
  {
    return this.b;
  }

  public String d()
  {
    return this.c;
  }

  public String e()
  {
    return this.d;
  }

  public String f()
  {
    return this.e;
  }

  public String g()
  {
    return this.g;
  }

  public String h()
  {
    return this.h;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.a.c
 * JD-Core Version:    0.6.0
 */