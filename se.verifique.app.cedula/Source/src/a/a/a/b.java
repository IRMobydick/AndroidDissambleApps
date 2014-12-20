package a.a.a;

import org.w3c.dom.Attr;

public class b
  implements Cloneable
{
  protected b a;
  protected x b;
  protected ay c;
  protected ay d;
  protected int e;
  protected String f;
  protected String g;
  protected Attr h;

  public b()
  {
  }

  public b(b paramb, x paramx, int paramInt, String paramString1, String paramString2)
  {
    this.a = paramb;
    this.b = paramx;
    this.e = paramInt;
    this.f = paramString1;
    this.g = paramString2;
  }

  public b(b paramb, x paramx, ay paramay1, ay paramay2, int paramInt, String paramString1, String paramString2)
  {
    this.a = paramb;
    this.b = paramx;
    this.c = paramay1;
    this.d = paramay2;
    this.e = paramInt;
    this.f = paramString1;
    this.g = paramString2;
  }

  void a(aw paramaw, ay paramay)
  {
    if (this.g == null);
    while (true)
    {
      return;
      String str = this.g.toLowerCase();
      if (this.g.equals(str))
        continue;
      if (paramaw.p)
        paramaw.I.a(paramaw, paramay, this, 70);
      if ((!paramaw.p) && (!paramaw.F.ac))
        continue;
      this.g = str;
    }
  }

  public void a(b paramb)
  {
    this.a = paramb;
  }

  public boolean a()
  {
    x localx = this.b;
    if ((localx != null) && (localx.a() == d.g));
    for (int i = 1; ; i = 0)
      return i;
  }

  public x b(aw paramaw, ay paramay)
  {
    dj localdj = paramaw.F.ap;
    x localx = this.b;
    if (localx != null)
      if (do.a(0x20 & localx.d()))
      {
        if ((!paramaw.F.o) && (!paramaw.F.p))
          paramaw.I.a(paramaw, paramay, this, 57);
        if (localx.a() == null)
          break label131;
        localx.a().a(paramaw, paramay, this);
      }
    while (true)
    {
      return localx;
      if ((localx == y.l) && ((paramay.m == localdj.E) || (paramay.m == localdj.F)))
        break;
      paramaw.c(localx.d());
      break;
      label131: if (!do.a(0x1C0 & this.b.d()))
        continue;
      paramaw.I.a(paramaw, paramay, this, 53);
      continue;
      if ((paramaw.F.o) || (paramay.m == null) || (this.c != null) || ((paramay.m != null) && (do.a(0x1C0 & paramay.m.b))))
        continue;
      paramaw.I.a(paramaw, paramay, this, 48);
    }
  }

  protected Attr b()
  {
    if (this.h == null)
      this.h = new ac(this);
    return this.h;
  }

  public String c()
  {
    return this.f;
  }

  protected Object clone()
  {
    Object localObject = null;
    try
    {
      b localb = (b)super.clone();
      localObject = localb;
      label12: if (this.a != null)
        localObject.a = ((b)this.a.clone());
      if (this.c != null)
        localObject.c = this.c.a(false);
      if (this.d != null)
        localObject.d = this.d.a(false);
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      break label12;
    }
  }

  public b d()
  {
    return this.a;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.b
 * JD-Core Version:    0.6.0
 */