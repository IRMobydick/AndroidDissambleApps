package a.a.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;

public class dk
  implements Serializable
{
  private static final Map a = new HashMap();
  private PrintWriter b;
  private PrintWriter c;
  private aa d = new aa(this.h);
  private String e = "InputStream";
  private int f;
  private int g;
  private cn h = new cn();

  static
  {
    a.put("xml", "input-xml");
    a.put("xml", "output-xhtml");
    a.put("asxml", "output-xhtml");
    a.put("ashtml", "output-html");
    a.put("omit", "hide-endtags");
    a.put("upper", "uppercase-tags");
    a.put("raw", "output-raw");
    a.put("numeric", "numeric-entities");
    a.put("change", "write-back");
    a.put("update", "write-back");
    a.put("modify", "write-back");
    a.put("errors", "only-errors");
    a.put("slides", "split");
    a.put("lang", "language");
    a.put("w", "wrap");
    a.put("file", "error-file");
    a.put("f", "error-file");
  }

  public dk()
  {
    dj localdj = new dj();
    localdj.a(this.d);
    this.d.ap = localdj;
    this.d.h = null;
    this.c = new PrintWriter(System.err, true);
    this.b = this.c;
  }

  private ay a(co paramco, az paramaz)
  {
    ay localay1;
    if (this.b == null)
      localay1 = null;
    aw localaw;
    while (true)
    {
      return localay1;
      this.d.a();
      this.f = 0;
      this.g = 0;
      localaw = new aw(paramco, this.d, this.h);
      localaw.b = this.b;
      paramco.a(localaw);
      this.h.a(this.e);
      if (this.d.o)
      {
        localay1 = bs.b(localaw);
        if (localay1.f())
          break;
        if (!this.d.k)
          this.h.c(this.b);
        localay1 = null;
        continue;
      }
      else
      {
        localaw.g = 0;
        localay1 = bs.a(localaw);
        if (!localay1.f())
        {
          if (!this.d.k)
            this.h.c(this.b);
          localay1 = null;
          continue;
        }
        z localz = new z(this.d.ap);
        localz.a(localay1);
        localz.c(localay1);
        localz.d(localay1);
        if (this.d.x)
          localz.b(localay1);
        if ((this.d.W) && (localz.g(localay1)))
        {
          localz.c(localaw, localay1);
          localz.f(localaw, localay1);
        }
        if ((this.d.v) || (this.d.y))
          localz.a(localaw, localay1);
        if (!localay1.f())
        {
          this.h.c(this.b);
          localay1 = null;
          continue;
        }
        ay localay2 = localay1.a();
        if (localay2 != null)
          localay2 = localay2.a(false);
        if (localay1.p != null)
        {
          if (!this.d.q)
            break label686;
          localaw.f(localay1);
          label358: if (this.d.X)
            localaw.b(localay1);
        }
        if ((this.d.p) && (this.d.s))
          localaw.h(localay1);
        if ((this.d.k) || (localay1.p == null))
          break;
        this.h.a(this.b, localaw, this.e, localay2);
      }
    }
    if (!this.d.k)
    {
      this.g = localaw.g;
      this.f = localaw.h;
      this.h.a(this.b, localaw);
    }
    if ((!this.d.k) && (localaw.h > 0) && (!this.d.ag))
      this.h.a(this.b);
    if ((!this.d.i) && ((localaw.h == 0) || (this.d.ag)))
    {
      if (!this.d.E)
        break label730;
      ay localay3 = localay1.a();
      if (localay3 != null)
        ay.a(localay3);
      localaw.q = (0x8 | localaw.q);
      if (!this.d.q)
        break label696;
      localaw.f(localay1);
      label597: ay localay4 = localay1.a(this.d.ap);
      if (localay4 == null)
        break label706;
      bc localbc2 = new bc(this.d);
      if (!this.d.k)
        this.h.a(this.b, localbc2.a(localay4));
      localbc2.b(localaw, localay1);
    }
    label665: label686: label696: label706: label730: 
    do
      while (true)
      {
        if (this.d.k)
          break label803;
        this.h.a(localaw);
        break;
        localaw.g(localay1);
        break label358;
        localaw.g(localay1);
        break label597;
        if (this.d.k)
          continue;
        this.h.b(this.b);
      }
    while (paramaz == null);
    bc localbc1 = new bc(this.d);
    if (localay1.a() == null)
      this.d.F = true;
    if (this.d.aa)
      localbc1.a(paramaz, localaw, localay1, this.d.p);
    while (true)
    {
      localbc1.a(paramaz, 0);
      paramaz.b();
      break label665;
      label803: break;
      if ((this.d.p) && (!this.d.q))
      {
        localbc1.b(paramaz, 0, 0, localaw, localay1);
        continue;
      }
      localbc1.a(paramaz, 0, 0, localaw, localay1);
    }
  }

  public ay a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    co localco = cp.a(this.d, paramInputStream);
    az localaz = null;
    if (paramOutputStream != null)
      localaz = ba.a(this.d, paramOutputStream);
    return a(localco, localaz);
  }

  public void a(boolean paramBoolean)
  {
    this.d.j = paramBoolean;
  }

  public Document b(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    ay localay = a(paramInputStream, paramOutputStream);
    if (localay != null);
    for (Document localDocument = (Document)localay.g(); ; localDocument = null)
      return localDocument;
  }

  public void b(boolean paramBoolean)
  {
    this.d.k = paramBoolean;
  }

  public void c(boolean paramBoolean)
  {
    this.d.q = paramBoolean;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.dk
 * JD-Core Version:    0.6.0
 */