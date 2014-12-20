package se.verifique.app.cedula.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class h
  implements Serializable
{
  private static h a;
  private String b;
  private String c;
  private String d;
  private i e;
  private List f;
  private c g;
  private b h;
  private String i;
  private List j;
  private a k;
  private k l;

  public static h a()
  {
    if (a == null)
      a = new h();
    return a;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public void a(a parama)
  {
    this.k = parama;
  }

  public void a(b paramb)
  {
    this.h = paramb;
  }

  public void a(c paramc)
  {
    this.g = paramc;
    c(this.g.a());
    StringBuilder localStringBuilder1 = new StringBuilder(String.valueOf(this.g.c()));
    String str1;
    StringBuilder localStringBuilder2;
    if (this.g.d() != null)
    {
      str1 = " " + this.g.d();
      a(str1);
      localStringBuilder2 = new StringBuilder(String.valueOf(this.g.e()));
      if (this.g.f() == null)
        break label153;
    }
    label153: for (String str2 = " " + this.g.f(); ; str2 = "")
    {
      b(str2);
      return;
      str1 = "";
      break;
    }
  }

  public void a(e parame)
  {
    if (this.f == null)
      this.f = new ArrayList();
    this.f.add(parame);
  }

  public void a(f paramf)
  {
    if (this.j == null)
      this.j = new ArrayList();
    this.j.add(paramf);
  }

  public void a(i parami)
  {
    this.e = parami;
  }

  public void a(k paramk)
  {
    this.l = paramk;
  }

  public k b()
  {
    return this.l;
  }

  public void b(String paramString)
  {
    this.c = paramString;
  }

  public c c()
  {
    return this.g;
  }

  public void c(String paramString)
  {
    this.d = paramString;
  }

  public String d()
  {
    return this.b;
  }

  public void d(String paramString)
  {
    this.i = paramString;
  }

  public String e()
  {
    return this.c;
  }

  public String f()
  {
    return this.d;
  }

  public i g()
  {
    return this.e;
  }

  public List h()
  {
    return this.f;
  }

  public b i()
  {
    return this.h;
  }

  public String j()
  {
    return this.i;
  }

  public List k()
  {
    return this.j;
  }

  public a l()
  {
    return this.k;
  }

  public void m()
  {
    this.f = null;
  }

  public void n()
  {
    this.j = null;
  }

  public void o()
  {
    this.l = null;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.a.h
 * JD-Core Version:    0.6.0
 */