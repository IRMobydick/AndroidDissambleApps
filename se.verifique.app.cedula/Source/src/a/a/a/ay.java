package a.a.a;

import org.w3c.dom.Node;

public class ay
{
  private static final String[] r;
  protected ay a = null;
  protected ay b = null;
  protected ay c = null;
  protected ay d = null;
  protected int e;
  protected int f;
  protected byte[] g;
  protected short h;
  protected boolean i;
  protected boolean j;
  protected boolean k;
  protected ap l;
  protected ap m;
  protected String n;
  protected b o;
  protected ay p;
  protected Node q;

  static
  {
    String[] arrayOfString = new String[12];
    arrayOfString[0] = "RootNode";
    arrayOfString[1] = "DocTypeTag";
    arrayOfString[2] = "CommentTag";
    arrayOfString[3] = "ProcInsTag";
    arrayOfString[4] = "TextNode";
    arrayOfString[5] = "StartTag";
    arrayOfString[6] = "EndTag";
    arrayOfString[7] = "StartEndTag";
    arrayOfString[8] = "SectionTag";
    arrayOfString[9] = "AspTag";
    arrayOfString[10] = "PhpTag";
    arrayOfString[11] = "XmlDecl";
    r = arrayOfString;
  }

  public ay()
  {
    this(4, null, 0, 0);
  }

  public ay(short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramArrayOfByte;
    this.h = paramShort;
    this.i = false;
    this.j = false;
    this.k = false;
    this.l = null;
    this.m = null;
    this.n = null;
    this.o = null;
    this.p = null;
  }

  public ay(short paramShort, byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString, dj paramdj)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramArrayOfByte;
    this.h = paramShort;
    this.i = false;
    this.j = false;
    this.k = false;
    this.l = null;
    this.m = null;
    this.n = paramString;
    this.o = null;
    this.p = null;
    if ((paramShort == 5) || (paramShort == 7) || (paramShort == 6))
      paramdj.a(this);
  }

  public static ay a(ay paramay)
  {
    ay localay = null;
    if (paramay != null)
    {
      localay = paramay.c;
      paramay.c();
    }
    return localay;
  }

  public static void a(aw paramaw, ay paramay)
  {
    dj localdj;
    if (paramaw.F.C)
    {
      localdj = paramaw.F.ap;
      if (!paramaw.n(paramay))
        break label52;
      if (paramay.h != 4)
        paramaw.I.a(paramaw, paramay, null, 23);
      a(paramay);
    }
    while (true)
    {
      return;
      label52: if ((paramay.m == localdj.q) && (paramay.p == null))
      {
        ay localay = paramaw.b("br");
        a(paramaw, paramay, localdj.D);
        paramay.d(localay);
        continue;
      }
    }
  }

  public static void a(aw paramaw, ay paramay, ap paramap)
  {
    ay localay = paramaw.b(paramap.a);
    paramaw.I.a(paramaw, paramay, localay, 20);
    paramay.l = paramay.m;
    paramay.m = paramap;
    paramay.h = 5;
    paramay.j = true;
    paramay.n = paramap.a;
  }

  public static void a(aw paramaw, ay paramay1, ay paramay2)
  {
    dj localdj = paramaw.F.ap;
    if ((paramay2 != null) && (paramay2.h == 4))
      if (paramay2.f > paramay2.e)
      {
        int i1 = paramaw.x[(-1 + paramay2.f)];
        if ((i1 == 160) || (i1 == 32))
        {
          if ((i1 != 160) || ((paramay1.m != localdj.y) && (paramay1.m != localdj.z)))
            break label131;
          if (paramay2.f > 1 + paramay2.e)
            paramay2.f = (-1 + paramay2.f);
        }
      }
    while (true)
    {
      if (paramay2.e == paramay2.f)
        a(paramaw, paramay2);
      return;
      label131: paramay2.f = (-1 + paramay2.f);
      if ((!do.a(0x10 & paramay1.m.c)) || (do.a(0x400 & paramay1.m.c)))
        continue;
      paramaw.m = true;
    }
  }

  public static void a(ay paramay1, ay paramay2)
  {
    paramay2.p = paramay1;
    paramay2.d = paramay1;
    paramay2.a = paramay1.a;
    paramay1.a = paramay2;
    if (paramay2.a.p == paramay1)
      paramay2.a.p = paramay2;
    if (paramay2.a.d == paramay1)
      paramay2.a.d = paramay2;
    paramay2.b = paramay1.b;
    paramay1.b = null;
    if (paramay2.b != null)
      paramay2.b.c = paramay2;
    paramay2.c = paramay1.c;
    paramay1.c = null;
    if (paramay2.c != null)
      paramay2.c.b = paramay2;
  }

  public static void a(ay paramay1, ay paramay2, dj paramdj)
  {
    for (ay localay = paramay1.a; ; localay = localay.a)
    {
      if (localay == null);
      while (true)
      {
        return;
        if (localay.m != paramdj.ab)
          break;
        if (localay.a.p == localay)
          localay.a.p = paramay2;
        paramay2.b = localay.b;
        paramay2.c = localay;
        localay.b = paramay2;
        paramay2.a = localay.a;
        if (paramay2.b == null)
          continue;
        paramay2.b.c = paramay2;
      }
    }
  }

  protected static ay b(aw paramaw, ay paramay)
  {
    ay localay = paramaw.a();
    localay.e = paramaw.z;
    localay.g = paramay.g;
    paramaw.a(60);
    if (paramay.h == 6)
      paramaw.a(47);
    if (paramay.n != null)
      paramaw.a(paramay.n);
    while (true)
    {
      if (paramay.h == 7)
        paramaw.a(47);
      paramaw.a(62);
      localay.f = paramaw.z;
      return localay;
      if (paramay.h != 1)
        continue;
      paramaw.a(33);
      paramaw.a(68);
      paramaw.a(79);
      paramaw.a(67);
      paramaw.a(84);
      paramaw.a(89);
      paramaw.a(80);
      paramaw.a(69);
      paramaw.a(32);
      for (int i1 = paramay.e; i1 < paramay.f; i1++)
        paramaw.a(paramaw.x[i1]);
    }
  }

  public static void b(aw paramaw, ay paramay1, ay paramay2)
  {
    ay localay1;
    if ((paramay2.h == 4) && (paramay2.g[paramay2.e] == 32) && (paramay2.e < paramay2.f))
    {
      if ((do.a(0x10 & paramay1.m.c)) && (!do.a(0x400 & paramay1.m.c)) && (paramay1.a.p != paramay1))
      {
        localay1 = paramay1.b;
        if ((localay1 != null) && (localay1.h == 4))
        {
          if (localay1.g[(-1 + localay1.f)] != 32)
          {
            byte[] arrayOfByte = localay1.g;
            int i2 = localay1.f;
            localay1.f = (i2 + 1);
            arrayOfByte[i2] = 32;
          }
          paramay1.e = (1 + paramay1.e);
        }
      }
      else
      {
        paramay2.e = (1 + paramay2.e);
      }
    }
    else
      return;
    ay localay2 = paramaw.a();
    if (paramay1.e >= paramay1.f)
    {
      localay2.e = 0;
      localay2.f = 1;
    }
    for (localay2.g = new byte[1]; ; localay2.g = paramay1.g)
    {
      localay2.g[localay2.e] = 32;
      localay2.b = localay1;
      if (localay1 != null)
        localay1.c = localay2;
      localay2.c = paramay1;
      paramay1.b = localay2;
      localay2.a = paramay1.a;
      break;
      int i1 = paramay1.e;
      paramay1.e = (i1 + 1);
      localay2.e = i1;
      localay2.f = paramay1.e;
    }
  }

  public static void b(ay paramay1, ay paramay2)
  {
    ay localay = paramay1.a;
    paramay2.a = localay;
    paramay2.c = paramay1;
    paramay2.b = paramay1.b;
    paramay1.b = paramay2;
    if (paramay2.b != null)
      paramay2.b.c = paramay2;
    if ((localay != null) && (localay.p == paramay1))
      localay.p = paramay2;
  }

  public static void c(aw paramaw, ay paramay)
  {
    ay localay1 = paramay.p;
    dj localdj = paramaw.F.ap;
    if ((localay1 != null) && (localay1.h == 4) && (paramay.m != localdj.m))
      b(paramaw, paramay, localay1);
    ay localay2 = paramay.d;
    if ((localay2 != null) && (localay2.h == 4))
      a(paramaw, paramay, localay2);
  }

  public static void c(aw paramaw, ay paramay1, ay paramay2)
  {
    dj localdj = paramaw.F.ap;
    paramaw.I.a(paramaw, paramay1, paramay2, 34);
    while (true)
    {
      if (paramay1.m == localdj.b)
      {
        b(paramay1, paramay2);
        return;
      }
      paramay1 = paramay1.a;
    }
  }

  public static boolean c(ay paramay1, ay paramay2)
  {
    if ((paramay2.h == 2) || (paramay2.h == 3) || (paramay2.h == 8) || (paramay2.h == 9) || (paramay2.h == 10) || (paramay2.h == 11) || (paramay2.h == 12) || (paramay2.h == 13))
      paramay1.c(paramay2);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public static void d(aw paramaw, ay paramay)
  {
    if (paramay.p == null)
    {
      ay localay = paramaw.b("td");
      paramay.c(localay);
      paramaw.I.a(paramaw, paramay, localay, 12);
    }
  }

  public ay a()
  {
    for (ay localay = this.p; ; localay = localay.c)
      if ((localay == null) || (localay.h == 1))
        return localay;
  }

  public ay a(dj paramdj)
  {
    ay localay1 = this.p;
    if ((localay1 == null) || (localay1.m == paramdj.b))
    {
      if (localay1 != null)
        break label36;
      localay2 = null;
    }
    label36: label41: 
    do
    {
      return localay2;
      localay1 = localay1.c;
      break;
      localay2 = localay1.p;
      if ((localay2 != null) && (localay2.m != paramdj.d) && (localay2.m != paramdj.e))
        break label130;
    }
    while (localay2.m != paramdj.e);
    for (ay localay2 = localay2.p; ; localay2 = localay2.c)
    {
      if ((localay2 != null) && (localay2.m != paramdj.h))
        continue;
      if (localay2 == null)
        break;
      for (localay2 = localay2.p; (localay2 != null) && (localay2.m != paramdj.d); localay2 = localay2.c);
      break;
      label130: localay2 = localay2.c;
      break label41;
    }
  }

  protected ay a(boolean paramBoolean)
  {
    ay localay1 = new ay(this.h, this.g, this.e, this.f);
    localay1.a = this.a;
    localay1.i = this.i;
    localay1.j = this.j;
    localay1.m = this.m;
    localay1.n = this.n;
    if (this.o != null)
      localay1.o = ((b)this.o.clone());
    if (paramBoolean);
    for (ay localay2 = this.p; ; localay2 = localay2.c)
    {
      if (localay2 == null)
        return localay1;
      localay1.c(localay2.a(paramBoolean));
    }
  }

  public b a(String paramString)
  {
    for (b localb = this.o; ; localb = localb.a)
    {
      if (localb == null);
      do
        return localb;
      while ((paramString != null) && (localb.f != null) && (localb.f.equals(paramString)));
    }
  }

  public void a(aw paramaw)
  {
    for (b localb = this.o; ; localb = localb.a)
    {
      if (localb == null)
        return;
      localb.b(paramaw, this);
    }
  }

  public void a(b paramb)
  {
    Object localObject1 = null;
    Object localObject2 = this.o;
    if (localObject2 == null)
      return;
    b localb = ((b)localObject2).a;
    if (localObject2 == paramb)
      if (localObject1 != null)
        localObject1.a = localb;
    while (true)
    {
      localObject2 = localb;
      break;
      this.o = localb;
      continue;
      localObject1 = localObject2;
    }
  }

  public void a(String paramString1, String paramString2)
  {
    b localb1 = new b(null, null, null, null, 34, paramString1, paramString2);
    localb1.b = y.a().a(localb1);
    if (this.o == null)
    {
      this.o = localb1;
      return;
    }
    for (b localb2 = this.o; ; localb2 = localb2.a)
    {
      if (localb2.a != null)
        continue;
      localb2.a = localb1;
      break;
    }
  }

  protected void a(short paramShort)
  {
    this.h = paramShort;
  }

  public boolean a(ap paramap)
  {
    for (ay localay = this.a; ; localay = localay.a)
    {
      if (localay == null);
      for (int i1 = 0; ; i1 = 1)
      {
        return i1;
        if (localay.m != paramap)
          break;
      }
    }
  }

  public ay b(dj paramdj)
  {
    for (ay localay = this.p; ; localay = localay.c)
      if ((localay == null) || (localay.m == paramdj.b))
        return localay;
  }

  public void b(aw paramaw)
  {
    b localb1 = this.o;
    while (true)
    {
      if (localb1 == null)
        return;
      if ((localb1.c == null) && (localb1.d == null))
      {
        Object localObject1 = localb1.a;
        Object localObject2 = localb1;
        while (true)
        {
          if (localObject1 == null)
          {
            localb1 = ((b)localObject2).a;
            break;
          }
          if ((((b)localObject1).c == null) && (((b)localObject1).d == null) && (((b)localObject2).f != null) && (((b)localObject2).f.equalsIgnoreCase(((b)localObject1).f)))
          {
            if (("class".equalsIgnoreCase(((b)localObject1).f)) && (paramaw.F.aj))
            {
              ((b)localObject1).g = (((b)localObject1).g + " " + ((b)localObject2).g);
              b localb5 = ((b)localObject2).a;
              if (localb5.a == null);
              for (localObject1 = null; ; localObject1 = ((b)localObject1).a)
              {
                paramaw.I.a(paramaw, this, (b)localObject2, 68);
                a((b)localObject2);
                localObject2 = localb5;
                break;
              }
            }
            if (("style".equalsIgnoreCase(((b)localObject1).f)) && (paramaw.F.ak))
            {
              int i1 = -1 + ((b)localObject1).g.length();
              label275: b localb4;
              if (((b)localObject1).g.charAt(i1) == ';')
              {
                ((b)localObject1).g = (((b)localObject1).g + " " + ((b)localObject2).g);
                localb4 = ((b)localObject2).a;
                if (localb4.a != null)
                  break label414;
              }
              label414: for (localObject1 = null; ; localObject1 = ((b)localObject1).a)
              {
                paramaw.I.a(paramaw, this, (b)localObject2, 68);
                a((b)localObject2);
                localObject2 = localb4;
                break;
                if (((b)localObject1).g.charAt(i1) == '}')
                {
                  ((b)localObject1).g = (((b)localObject1).g + " { " + ((b)localObject2).g + " }");
                  break label275;
                }
                ((b)localObject1).g = (((b)localObject1).g + "; " + ((b)localObject2).g);
                break label275;
              }
            }
            if (paramaw.F.e == 0)
            {
              b localb3 = ((b)localObject1).a;
              paramaw.I.a(paramaw, this, (b)localObject1, 55);
              a((b)localObject1);
              localObject1 = localb3;
              continue;
            }
            b localb2 = ((b)localObject2).a;
            if (((b)localObject2).a == null);
            for (localObject1 = null; ; localObject1 = ((b)localObject1).a)
            {
              paramaw.I.a(paramaw, this, (b)localObject2, 55);
              a((b)localObject2);
              localObject2 = localb2;
              break;
            }
          }
          localObject1 = ((b)localObject1).a;
        }
      }
      localb1 = localb1.a;
    }
  }

  public void b(ay paramay)
  {
    paramay.a = this;
    if (this.p == null)
      this.d = paramay;
    while (true)
    {
      paramay.c = this.p;
      paramay.b = null;
      this.p = paramay;
      return;
      this.p.b = paramay;
    }
  }

  public void b(String paramString)
  {
    b localb = a("class");
    if (localb != null)
      localb.g = (localb.g + " " + paramString);
    while (true)
    {
      return;
      a("class", paramString);
    }
  }

  public boolean b()
  {
    if ((this.h == 5) || (this.h == 7));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public ay c(dj paramdj)
  {
    ay localay = b(paramdj);
    if (localay != null);
    for (localay = localay.p; ; localay = localay.c)
      if ((localay == null) || (localay.m == paramdj.c))
        return localay;
  }

  public void c()
  {
    if (this.b != null)
      this.b.c = this.c;
    if (this.c != null)
      this.c.b = this.b;
    if (this.a != null)
    {
      if (this.a.p == this)
        this.a.p = this.c;
      if (this.a.d == this)
        this.a.d = this.b;
    }
    this.a = null;
    this.b = null;
    this.c = null;
  }

  public void c(ay paramay)
  {
    paramay.a = this;
    paramay.b = this.d;
    if (this.d != null)
      this.d.c = paramay;
    while (true)
    {
      this.d = paramay;
      return;
      this.p = paramay;
    }
  }

  public boolean c(aw paramaw)
  {
    int i1 = 1;
    if (this.h == 4)
      if (this.f != this.e);
    while (true)
    {
      return i1;
      if ((this.f == 1 + this.e) && (paramaw.x[(-1 + this.f)] == 32))
        continue;
      i1 = 0;
    }
  }

  public ay d(dj paramdj)
  {
    ay localay = c(paramdj);
    if (localay != null);
    for (localay = localay.p; ; localay = localay.c)
      if ((localay == null) || (localay.m == paramdj.j))
        return localay;
  }

  public void d(ay paramay)
  {
    ay localay = this.a;
    paramay.a = localay;
    if ((localay != null) && (localay.d == this))
      localay.d = paramay;
    while (true)
    {
      this.c = paramay;
      paramay.b = this;
      return;
      paramay.c = this.c;
      if (paramay.c == null)
        continue;
      paramay.c.b = paramay;
    }
  }

  public boolean d()
  {
    if (this.m != null);
    for (boolean bool = do.a(0x100000 & this.m.c); ; bool = true)
      return bool;
  }

  public boolean e()
  {
    if ((this.p != null) && (this.p.c == null));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public boolean f()
  {
    int i1 = 0;
    if ((this.b != null) && (this.b.c != this));
    do
      return i1;
    while (((this.c != null) && ((this.c == this) || (this.c.b != this))) || ((this.a != null) && (((this.b == null) && (this.a.p != this)) || ((this.c == null) && (this.a.d != this)))));
    for (ay localay = this.p; ; localay = localay.c)
    {
      if (localay == null)
      {
        i1 = 1;
        break;
      }
      if ((localay.a != this) || (!localay.f()))
        break;
    }
  }

  protected Node g()
  {
    if (this.q == null)
      switch (this.h)
      {
      case 6:
      default:
        this.q = new ak(this);
      case 0:
      case 5:
      case 7:
      case 1:
      case 2:
      case 4:
      case 8:
      case 3:
      }
    while (true)
    {
      return this.q;
      this.q = new ah(this);
      continue;
      this.q = new aj(this);
      continue;
      this.q = new ai(this);
      continue;
      this.q = new ag(this);
      continue;
      this.q = new ao(this);
      continue;
      this.q = new ae(this);
      continue;
      this.q = new an(this);
    }
  }

  public boolean h()
  {
    int i1 = 1;
    if (this.o == null)
      return i1;
    b localb1 = this.o;
    int i2 = 0;
    for (b localb2 = localb1; ; localb2 = localb2.a)
    {
      if (localb2 == null)
      {
        i1 = i2;
        break;
      }
      if (((!"language".equalsIgnoreCase(localb2.f)) && (!"type".equalsIgnoreCase(localb2.f))) || (!"javascript".equalsIgnoreCase(localb2.g)))
        continue;
      i2 = i1;
    }
  }

  public boolean i()
  {
    int i1 = 0;
    if (this.h != 5);
    while (true)
    {
      return i1;
      if (this.m == null)
      {
        i1 = 1;
        continue;
      }
      if (do.a(0x1 & this.m.c))
        continue;
      i1 = 1;
    }
  }

  public String toString()
  {
    String str1 = "";
    if (this == null)
      return str1;
    String str2 = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str1)).append("[Node type=").toString())).append(r[this.h]).toString() + ",element=";
    String str3;
    label103: String str4;
    label244: String str5;
    if (this.n != null)
    {
      str3 = str2 + this.n;
      if ((this.h == 4) || (this.h == 2) || (this.h == 3))
      {
        str4 = str3 + ",text=";
        if ((this.g == null) || (this.e > this.f))
          break label382;
        str3 = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str4)).append("\"").toString())).append(do.a(this.g, this.e, this.f - this.e)).toString() + "\"";
      }
      str5 = str3 + ",content=";
      if (this.p == null)
        break label407;
    }
    label407: for (String str6 = str5 + this.p.toString(); ; str6 = str5 + "null")
    {
      str1 = str6 + "]";
      if (this.c != null)
        str1 = str1 + ",";
      this = this.c;
      break;
      str3 = str2 + "null";
      break label103;
      label382: str3 = str4 + "null";
      break label244;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.ay
 * JD-Core Version:    0.6.0
 */