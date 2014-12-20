package a.a.a;

public class z
{
  private int a = 1;
  private dj b;

  public z(dj paramdj)
  {
    this.b = paramdj;
  }

  private cs a(cs paramcs, String paramString)
  {
    int i = 0;
    int j = 0;
    if (i >= paramString.length())
      label13: return paramcs;
    do
      i++;
    while ((i < paramString.length()) && (paramString.charAt(i) == ' '));
    int k = i;
    label39: if (k >= paramString.length())
    {
      label48: if ((k >= paramString.length()) || (paramString.charAt(k) != ':'))
        break label156;
      label68: if ((j < paramString.length()) && (paramString.charAt(j) == ' '))
        break label164;
    }
    label156: label164: label187: for (int m = j; ; m++)
    {
      if (m >= paramString.length());
      for (int n = 0; ; n = 1)
      {
        paramcs = a(paramcs, paramString.substring(i, k), paramString.substring(j, m));
        if (n == 0)
          break label13;
        i = m + 1;
        break;
        if (paramString.charAt(k) == ':')
        {
          j = k + 1;
          break label48;
          break label13;
        }
        k++;
        break label39;
        j++;
        break label68;
        if (paramString.charAt(m) != ';')
          break label187;
      }
    }
  }

  private cs a(cs paramcs, String paramString1, String paramString2)
  {
    Object localObject1 = null;
    Object localObject2 = paramcs;
    cs localcs1;
    if (localObject2 == null)
    {
      localcs1 = new cs(paramString1, paramString2, null);
      if (localObject1 == null)
        break label110;
      localObject1.c = localcs1;
    }
    while (true)
    {
      return paramcs;
      int i = ((cs)localObject2).a.compareTo(paramString1);
      if (i == 0)
        continue;
      if (i > 0)
      {
        cs localcs2 = new cs(paramString1, paramString2, (cs)localObject2);
        if (localObject1 != null)
        {
          localObject1.c = localcs2;
          continue;
        }
        paramcs = localcs2;
        continue;
      }
      cs localcs3 = ((cs)localObject2).c;
      localObject1 = localObject2;
      localObject2 = localcs3;
      break;
      label110: paramcs = localcs1;
    }
  }

  private String a(aw paramaw, String paramString)
  {
    if (paramaw.F.an == null);
    for (String str = paramaw.F.an + this.a; ; str = "c" + this.a)
    {
      this.a = (1 + this.a);
      return str;
    }
  }

  private String a(aw paramaw, String paramString1, String paramString2)
  {
    for (cr localcr1 = paramaw.E; ; localcr1 = localcr1.d)
    {
      cr localcr2;
      if (localcr1 == null)
      {
        localcr2 = new cr(paramString1, a(paramaw, paramString1), paramString2, paramaw.E);
        paramaw.E = localcr2;
      }
      for (String str = localcr2.b; ; str = localcr1.b)
      {
        return str;
        if ((!localcr1.a.equals(paramString1)) || (!localcr1.c.equals(paramString2)))
          break;
      }
    }
  }

  private String a(cs paramcs)
  {
    String str = "";
    int i = 0;
    cs localcs = paramcs;
    if (localcs == null);
    while (true)
    {
      if (paramcs == null);
      do
      {
        return str;
        i = i + (2 + localcs.a.length()) + (2 + localcs.b.length());
        localcs = localcs.c;
        break;
        str = str.concat(paramcs.a).concat(": ").concat(paramcs.b);
      }
      while (paramcs.c == null);
      str = str.concat("; ");
      paramcs = paramcs.c;
    }
  }

  private String a(String paramString)
  {
    double d1 = 1.0D;
    String[] arrayOfString = new String[7];
    arrayOfString[0] = "60%";
    arrayOfString[1] = "70%";
    arrayOfString[2] = "80%";
    arrayOfString[4] = "120%";
    arrayOfString[5] = "150%";
    arrayOfString[6] = "200%";
    String str;
    if ((paramString.length() > 0) && ('0' <= paramString.charAt(0)) && (paramString.charAt(0) <= '6'))
      str = arrayOfString[('￐' + paramString.charAt(0))];
    while (true)
    {
      return str;
      if ((paramString.length() > 0) && (paramString.charAt(0) == '-'))
      {
        if ((paramString.length() > 1) && ('0' <= paramString.charAt(1)) && (paramString.charAt(1) <= '6'))
        {
          int j = '￐' + paramString.charAt(1);
          while (true)
          {
            if (j <= 0)
            {
              double d3 = d1 * 100.0D;
              str = (int)d3 + "%";
              break;
            }
            d1 *= 0.8D;
            j += -1;
          }
        }
        str = "smaller";
        continue;
      }
      if ((paramString.length() > 1) && ('0' <= paramString.charAt(1)) && (paramString.charAt(1) <= '6'))
      {
        int i = '￐' + paramString.charAt(1);
        while (true)
        {
          if (i <= 0)
          {
            double d2 = d1 * 100.0D;
            str = (int)d2 + "%";
            break;
          }
          d1 *= 1.2D;
          i += -1;
        }
      }
      str = "larger";
    }
  }

  private String a(String paramString1, String paramString2)
  {
    return a(a(a(null, paramString1), paramString2));
  }

  private void a(ay paramay1, ay paramay2)
  {
    b localb1 = paramay2.o;
    String str;
    label12: b localb2;
    label18: Object localObject;
    if (localb1 == null)
    {
      str = null;
      localb2 = paramay1.o;
      if (localb2 != null)
        break label96;
      localObject = null;
      label26: if (localObject == null)
        break label129;
      if (str != null)
        localb2.g = (localObject + ' ' + str);
    }
    while (true)
    {
      return;
      if ("class".equals(localb1.f))
      {
        str = localb1.g;
        break label12;
      }
      localb1 = localb1.a;
      break;
      label96: if ("class".equals(localb2.f))
      {
        localObject = localb2.g;
        break label26;
      }
      localb2 = localb2.a;
      break label18;
      label129: if (str == null)
        continue;
      b localb3 = new b(paramay1.o, null, 34, "class", str);
      localb3.b = y.a().a(localb3);
      paramay1.o = localb3;
    }
  }

  private void a(ay paramay, b paramb)
  {
    if (paramb == null)
      return;
    if (paramb.f.equals("face"))
      b(paramay, paramb.g);
    while (true)
    {
      paramb = paramb.a;
      break;
      if (paramb.f.equals("size"))
      {
        c(paramay, paramb.g);
        continue;
      }
      if (!paramb.f.equals("color"))
        continue;
      d(paramay, paramb.g);
    }
  }

  private void a(ay paramay, String paramString)
  {
    b localb1 = paramay.o;
    if (localb1 == null);
    label86: 
    while (true)
    {
      if (localb1 != null)
        localb1.g = a(localb1.g, paramString);
      while (true)
      {
        return;
        if (localb1.f.equals("style"))
          break label86;
        localb1 = localb1.a;
        break;
        b localb2 = new b(paramay.o, null, 34, "style", paramString);
        localb2.b = y.a().a(localb2);
        paramay.o = localb2;
      }
    }
  }

  private void a(ay paramay, ay[] paramArrayOfay)
  {
    ay localay1 = paramay.a;
    if (paramay.p != null)
    {
      paramay.d.c = paramay.c;
      if (paramay.c != null)
      {
        paramay.c.b = paramay.d;
        paramay.d.c = paramay.c;
        if (paramay.b == null)
          break label121;
        paramay.p.b = paramay.b;
        paramay.b.c = paramay.p;
      }
      label81: for (ay localay2 = paramay.p; ; localay2 = localay2.c)
      {
        if (localay2 == null)
        {
          paramArrayOfay[0] = paramay.p;
          paramay.c = null;
          paramay.p = null;
          return;
          localay1.d = paramay.d;
          break;
          label121: localay1.p = paramay.p;
          break label81;
        }
        localay2.a = localay1;
      }
    }
    if (paramay.c != null)
    {
      paramay.c.b = paramay.b;
      label166: if (paramay.b == null)
        break label205;
      paramay.b.c = paramay.c;
    }
    while (true)
    {
      paramArrayOfay[0] = paramay.c;
      break;
      localay1.d = paramay.b;
      break label166;
      label205: localay1.p = paramay.c;
    }
  }

  private boolean a(aw paramaw, ay paramay, ay[] paramArrayOfay)
  {
    int i = 1;
    if (paramay.m == this.b.X)
      if (paramaw.F.y)
        if (paramay.p != null)
        {
          ay localay5 = paramay.d;
          ay localay6 = paramay.a;
          a(paramay, paramArrayOfay);
          ay localay7 = paramaw.b("br");
          if (localay5.c != null)
            localay5.c.b = localay7;
          localay7.c = localay5.c;
          localay5.c = localay7;
          localay7.b = localay5;
          if (localay6.d == localay5)
            localay6.d = localay7;
          localay7.a = localay6;
        }
    while (true)
    {
      return i;
      ay localay1 = paramay.b;
      ay localay2 = paramay.c;
      ay localay3 = paramay.a;
      a(paramay, paramArrayOfay);
      ay localay4 = paramaw.b("br");
      localay4.c = localay2;
      localay4.b = localay1;
      localay4.a = localay3;
      if (localay2 != null)
        localay2.b = localay4;
      while (true)
      {
        if (localay1 == null)
          break label219;
        localay1.c = localay4;
        break;
        localay3.d = localay4;
      }
      label219: localay3.p = localay4;
      continue;
      paramay.m = this.b.ai;
      paramay.n = "div";
      a(paramay, "text-align: center");
      continue;
      i = 0;
    }
  }

  private String b(String paramString1, String paramString2)
  {
    return a(a(a(null, paramString1), paramString2));
  }

  private void b(aw paramaw, String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      paramaw.a(paramString1);
      paramaw.a(" { color: ");
      paramaw.a(paramString2);
      paramaw.a(" }\n");
    }
  }

  private void b(ay paramay1, ay paramay2)
  {
    a(paramay1, paramay2);
    b localb1 = paramay2.o;
    String str1;
    label18: b localb2;
    label24: String str2;
    if (localb1 == null)
    {
      str1 = null;
      localb2 = paramay1.o;
      if (localb2 != null)
        break label85;
      str2 = null;
      label32: if (str2 == null)
        break label118;
      if (str1 != null)
        localb2.g = b(str2, str1);
    }
    while (true)
    {
      return;
      if (localb1.f.equals("style"))
      {
        str1 = localb1.g;
        break label18;
      }
      localb1 = localb1.a;
      break;
      label85: if (localb2.f.equals("style"))
      {
        str2 = localb2.g;
        break label32;
      }
      localb2 = localb2.a;
      break label24;
      label118: if (str1 == null)
        continue;
      b localb3 = new b(paramay1.o, null, 34, "style", str1);
      localb3.b = y.a().a(localb3);
      paramay1.o = localb3;
    }
  }

  private void b(ay paramay, String paramString)
  {
    a(paramay, "font-family: " + paramString);
  }

  private boolean b(aw paramaw, ay paramay, ay[] paramArrayOfay)
  {
    int i = 0;
    ay localay1;
    if ((paramay.m == this.b.r) || (paramay.m == this.b.s))
    {
      localay1 = paramay.p;
      if (localay1 != null)
        break label45;
    }
    while (true)
    {
      return i;
      label45: if (localay1.c != null)
        continue;
      ay localay2 = localay1.p;
      if ((localay2 == null) || (localay2.m != paramay.m))
        continue;
      paramArrayOfay[i] = localay2;
      localay2.b = paramay.b;
      localay2.c = paramay.c;
      localay2.a = paramay.a;
      h(localay2);
      localay1.p = null;
      paramay.p = null;
      paramay.c = null;
      if ((localay2.b != null) && ((localay2.b.m == this.b.r) || (localay2.b.m == this.b.s)))
      {
        ay localay3 = localay2.b;
        localay3.c = localay2.c;
        if (localay3.c != null)
          localay3.c.b = localay3;
        ay localay4 = localay3.d;
        localay2.a = localay4;
        localay2.c = null;
        localay2.b = localay4.d;
        h(localay2);
        p(paramaw, localay2);
      }
      i = 1;
    }
  }

  private void c(ay paramay, String paramString)
  {
    if (paramString == null);
    while (true)
    {
      return;
      if (("6".equals(paramString)) && (paramay.m == this.b.q))
      {
        paramay.n = "h1";
        this.b.a(paramay);
        continue;
      }
      if (("5".equals(paramString)) && (paramay.m == this.b.q))
      {
        paramay.n = "h2";
        this.b.a(paramay);
        continue;
      }
      if (("4".equals(paramString)) && (paramay.m == this.b.q))
      {
        paramay.n = "h3";
        this.b.a(paramay);
        continue;
      }
      String str = a(paramString);
      if (str == null)
        continue;
      a(paramay, "font-size: " + str);
    }
  }

  private boolean c(aw paramaw, ay paramay, ay[] paramArrayOfay)
  {
    int i = 0;
    ay localay;
    if ((paramay.m != this.b.U) && ((0x210 & paramay.m.c) != 0))
    {
      localay = paramay.p;
      if (localay != null)
        break label45;
    }
    while (true)
    {
      return i;
      label45: if (localay.c != null)
        continue;
      if ((localay.m == this.b.G) && (paramaw.F.x))
      {
        b(paramay, localay);
        a(paramay, "font-weight: bold");
        i(paramay);
        i = 1;
        continue;
      }
      if ((localay.m == this.b.H) && (paramaw.F.x))
      {
        b(paramay, localay);
        a(paramay, "font-style: italic");
        i(paramay);
        i = 1;
        continue;
      }
      if (localay.m != this.b.U)
        continue;
      b(paramay, localay);
      a(paramay, localay.o);
      i(paramay);
      i = 1;
    }
  }

  private void d(ay paramay, String paramString)
  {
    a(paramay, "color: " + paramString);
  }

  private boolean d(aw paramaw, ay paramay, ay[] paramArrayOfay)
  {
    int i = 0;
    if (paramay.m == this.b.U)
    {
      if (!paramaw.F.y)
        break label36;
      a(paramay, paramArrayOfay);
    }
    label36: Object localObject1;
    Object localObject2;
    while (true)
    {
      return i;
      if ((paramay.a.p == paramay) && (paramay.c == null))
        continue;
      a(paramay, paramay.o);
      localObject1 = paramay.o;
      localObject2 = null;
      if (localObject1 != null)
        break;
      paramay.o = localObject2;
      paramay.m = this.b.aj;
      paramay.n = "span";
      i = 1;
    }
    b localb = ((b)localObject1).a;
    if (((b)localObject1).f.equals("style"))
      ((b)localObject1).a = null;
    while (true)
    {
      localObject2 = localObject1;
      localObject1 = localb;
      break;
      localObject1 = localObject2;
    }
  }

  private ay e(aw paramaw, ay paramay, ay[] paramArrayOfay)
  {
    ay localay1 = paramay.p;
    ay[] arrayOfay;
    if (localay1 != null)
    {
      arrayOfay = new ay[1];
      arrayOfay[0] = paramay;
    }
    while (true)
    {
      if (localay1 == null);
      for (ay localay2 = p(paramaw, paramay); ; localay2 = arrayOfay[0])
      {
        return localay2;
        localay1 = e(paramaw, localay1, arrayOfay);
        if (arrayOfay[0] == paramay)
          break;
      }
      if (localay1 == null)
        continue;
      localay1 = localay1.c;
    }
  }

  private void e(ay paramay, String paramString)
  {
    a(paramay, "text-align: " + paramString.toLowerCase());
  }

  static void g(aw paramaw, ay paramay)
  {
    Object localObject1 = null;
    if (paramay == null);
    dj localdj;
    ay localay1;
    ay localay2;
    label24: Object localObject2;
    label45: ay localay3;
    int i;
    while (true)
    {
      return;
      localdj = paramaw.F.ap;
      localay1 = paramay.p;
      localay2 = null;
      if (localay1 == null)
      {
        if ((localay2 == null) || (localObject1 == null))
          continue;
        localObject2 = localay2.p;
        if (localObject2 != null)
        {
          localay3 = ((ay)localObject2).c;
          if (((ay)localObject2).m != localdj.ah)
            break;
          i = 0;
        }
      }
    }
    label184: for (ay localay4 = ((ay)localObject2).p; ; localay4 = localay4.c)
    {
      if (localay4 == null);
      while (true)
      {
        if (i != 0)
        {
          ((ay)localObject2).c();
          localObject1.b((ay)localObject2);
        }
        localObject2 = localay3;
        break label45;
        break;
        if (localay1.m == localdj.c)
          localay2 = localay1;
        if (localay1.m == localdj.d)
          localObject1 = localay1;
        localay1 = localay1.c;
        break label24;
        if (((localay4.h != 4) || (((ay)localObject2).c(paramaw))) && (localay4.m == localdj.M))
          break label184;
        i = 1;
      }
    }
  }

  private void h(aw paramaw, ay paramay)
  {
    b localb1 = paramay.a("style");
    String str;
    if (localb1 != null)
    {
      str = a(paramaw, paramay.n, localb1.g);
      b localb2 = paramay.a("class");
      if (localb2 == null)
        break label79;
      localb2.g = (localb2.g + " " + str);
      paramay.a(localb1);
    }
    while (true)
    {
      return;
      label79: localb1.f = "class";
      localb1.g = str;
    }
  }

  private void h(ay paramay)
  {
    if (paramay.b != null)
    {
      paramay.b.c = paramay;
      if (paramay.c == null)
        break label51;
      paramay.c.b = paramay;
    }
    label30: for (ay localay = paramay.p; ; localay = localay.c)
    {
      if (localay == null)
      {
        return;
        paramay.a.p = paramay;
        break;
        label51: paramay.a.d = paramay;
        break label30;
      }
      localay.a = paramay;
    }
  }

  private void i(aw paramaw, ay paramay)
  {
    Object localObject = null;
    b localb1 = paramay.a("background");
    String str1;
    if (localb1 != null)
    {
      str1 = localb1.g;
      localb1.g = null;
      paramay.a(localb1);
    }
    while (true)
    {
      b localb2 = paramay.a("bgcolor");
      String str2;
      if (localb2 != null)
      {
        str2 = localb2.g;
        localb2.g = null;
        paramay.a(localb2);
      }
      while (true)
      {
        b localb3 = paramay.a("text");
        if (localb3 != null)
        {
          String str3 = localb3.g;
          localb3.g = null;
          paramay.a(localb3);
          localObject = str3;
        }
        if ((str1 != null) || (str2 != null) || (localObject != null))
        {
          paramaw.a(" body {\n");
          if (str1 != null)
          {
            paramaw.a("  background-image: url(");
            paramaw.a(str1);
            paramaw.a(");\n");
          }
          if (str2 != null)
          {
            paramaw.a("  background-color: ");
            paramaw.a(str2);
            paramaw.a(";\n");
          }
          if (localObject != null)
          {
            paramaw.a("  color: ");
            paramaw.a(localObject);
            paramaw.a(";\n");
          }
          paramaw.a(" }\n");
        }
        b localb4 = paramay.a("link");
        if (localb4 != null)
        {
          b(paramaw, " :link", localb4.g);
          paramay.a(localb4);
        }
        b localb5 = paramay.a("vlink");
        if (localb5 != null)
        {
          b(paramaw, " :visited", localb5.g);
          paramay.a(localb5);
        }
        b localb6 = paramay.a("alink");
        if (localb6 != null)
        {
          b(paramaw, " :active", localb6.g);
          paramay.a(localb6);
        }
        return;
        str2 = null;
      }
      str1 = null;
    }
  }

  private void i(ay paramay)
  {
    ay localay1 = paramay.p;
    paramay.p = localay1.p;
    paramay.d = localay1.d;
    localay1.p = null;
    for (ay localay2 = paramay.p; ; localay2 = localay2.c)
    {
      if (localay2 == null)
        return;
      localay2.a = paramay;
    }
  }

  private boolean j(aw paramaw, ay paramay)
  {
    ay localay = paramay.a(paramaw.F.ap);
    if ((localay != null) && ((localay.a("background") != null) || (localay.a("bgcolor") != null) || (localay.a("text") != null) || (localay.a("link") != null) || (localay.a("vlink") != null) || (localay.a("alink") != null)))
      paramaw.d = (0x10 | paramaw.d);
    for (int i = 0; ; i = 1)
      return i;
  }

  private void k(aw paramaw, ay paramay)
  {
    if ((paramaw.E == null) && (j(paramaw, paramay)))
      return;
    ay localay1 = paramaw.a(5, null, 0, 0, "style");
    localay1.j = true;
    b localb = new b(null, null, 34, "type", "text/css");
    localb.b = y.a().a(localb);
    localay1.o = localb;
    ay localay2 = paramay.a(paramaw.F.ap);
    paramaw.t = paramaw.z;
    if (localay2 != null)
      i(paramaw, localay2);
    for (cr localcr = paramaw.E; ; localcr = localcr.d)
    {
      if (localcr == null)
      {
        paramaw.u = paramaw.z;
        localay1.c(paramaw.a(4, paramaw.x, paramaw.t, paramaw.u));
        ay localay3 = paramay.c(paramaw.F.ap);
        if (localay3 == null)
          break;
        localay3.c(localay1);
        break;
      }
      paramaw.b(32);
      paramaw.a(localcr.a);
      paramaw.b(46);
      paramaw.a(localcr.b);
      paramaw.b(32);
      paramaw.b(123);
      paramaw.a(localcr.c);
      paramaw.b(125);
      paramaw.b(10);
    }
  }

  private void l(aw paramaw, ay paramay)
  {
    Object localObject1 = null;
    Object localObject2 = paramay.o;
    while (true)
    {
      if (localObject2 == null);
      label72: 
      while (true)
      {
        return;
        if (!((b)localObject2).f.equals("align"))
          break;
        if (localObject1 != null)
          localObject1.a = ((b)localObject2).a;
        while (true)
        {
          if (((b)localObject2).g == null)
            break label72;
          e(paramay, ((b)localObject2).g);
          break;
          paramay.o = ((b)localObject2).a;
        }
      }
      b localb = ((b)localObject2).a;
      Object localObject3 = localObject2;
      localObject2 = localb;
      localObject1 = localObject3;
    }
  }

  private boolean m(aw paramaw, ay paramay)
  {
    int i = 0;
    ay localay;
    if ((paramay.m == this.b.t) || (paramay.m == this.b.r) || (paramay.m == this.b.s))
    {
      localay = paramay.p;
      if (localay != null)
        break label57;
    }
    while (true)
    {
      return i;
      label57: if ((localay.c != null) || (localay.m != this.b.u) || (!localay.j))
        continue;
      paramay.m = this.b.ai;
      paramay.n = "div";
      a(paramay, "margin-left: 2em");
      i(paramay);
      i = 1;
    }
  }

  private boolean n(aw paramaw, ay paramay)
  {
    int i = 0;
    if (paramay.m != this.b.ai);
    while (true)
    {
      return i;
      ay localay = paramay.p;
      if ((localay == null) || (localay.m != this.b.ai) || (localay.c != null))
        continue;
      b(paramay, localay);
      i(paramay);
      i = 1;
    }
  }

  private boolean o(aw paramaw, ay paramay)
  {
    int i = 0;
    ay localay;
    if (((0xE8 & paramay.m.c) != 0) && (paramay.m != this.b.ab) && (paramay.m != this.b.A) && (paramay.m != this.b.u))
    {
      if (paramay.m != this.b.ac)
        l(paramaw, paramay);
      localay = paramay.p;
      if (localay != null)
        break label91;
    }
    while (true)
    {
      return i;
      label91: if (localay.c != null)
        continue;
      if (localay.m == this.b.G)
      {
        b(paramay, localay);
        a(paramay, "font-weight: bold");
        i(paramay);
        i = 1;
        continue;
      }
      if (localay.m == this.b.H)
      {
        b(paramay, localay);
        a(paramay, "font-style: italic");
        i(paramay);
        i = 1;
        continue;
      }
      if (localay.m != this.b.U)
        continue;
      b(paramay, localay);
      a(paramay, localay.o);
      i(paramay);
      i = 1;
    }
  }

  private ay p(aw paramaw, ay paramay)
  {
    ay[] arrayOfay = new ay[1];
    ay localay = paramay;
    if ((paramay == null) || (!paramay.b()))
      label19: return localay;
    arrayOfay[0] = localay;
    boolean bool1 = m(paramaw, paramay);
    localay = arrayOfay[0];
    if (bool1);
    while (true)
    {
      paramay = localay;
      break;
      boolean bool2 = b(paramaw, paramay, arrayOfay);
      localay = arrayOfay[0];
      if (bool2)
        break label19;
      boolean bool3 = a(paramaw, paramay, arrayOfay);
      localay = arrayOfay[0];
      if (bool3)
        continue;
      boolean bool4 = n(paramaw, paramay);
      localay = arrayOfay[0];
      if (bool4)
        continue;
      boolean bool5 = o(paramaw, paramay);
      localay = arrayOfay[0];
      if (bool5)
        continue;
      boolean bool6 = c(paramaw, paramay, arrayOfay);
      localay = arrayOfay[0];
      if (bool6)
        continue;
      boolean bool7 = d(paramaw, paramay, arrayOfay);
      localay = arrayOfay[0];
      if (!bool7)
        break label19;
    }
  }

  private void q(aw paramaw, ay paramay)
  {
    if (paramay.p != null);
    for (ay localay = paramay.p; ; localay = localay.c)
    {
      if (localay == null)
      {
        h(paramaw, paramay);
        return;
      }
      q(paramaw, localay);
    }
  }

  private void r(aw paramaw, ay paramay)
  {
    if (paramay == null)
      return;
    if (paramay.p != null)
      r(paramaw, paramay.p);
    int[] arrayOfInt;
    int i;
    if (paramay.h == 4)
    {
      arrayOfInt = new int[1];
      i = paramay.e;
    }
    for (int j = paramay.e; ; j++)
    {
      if (j >= paramay.f)
      {
        paramay = paramay.c;
        break;
      }
      arrayOfInt[0] = paramay.g[j];
      if (arrayOfInt[0] > 127)
        j += bc.a(paramay.g, j, arrayOfInt);
      if (arrayOfInt[0] == 160)
        arrayOfInt[0] = 32;
      i = bc.a(paramay.g, i, arrayOfInt[0]);
    }
  }

  public void a(aw paramaw, ay paramay)
  {
    ay[] arrayOfay = new ay[1];
    arrayOfay[0] = paramay;
    ay localay = e(paramaw, paramay, arrayOfay);
    if (!paramaw.F.v)
    {
      q(paramaw, localay);
      k(paramaw, localay);
    }
  }

  public void a(ay paramay)
  {
    ay[] arrayOfay = new ay[1];
    while (true)
    {
      if (paramay == null)
        return;
      ay localay = paramay.c;
      if (((paramay.m == this.b.G) || (paramay.m == this.b.H)) && (paramay.a != null) && (paramay.a.m == paramay.m))
      {
        arrayOfay[0] = localay;
        a(paramay, arrayOfay);
        paramay = arrayOfay[0];
        continue;
      }
      if (paramay.p != null)
        a(paramay.p);
      paramay = localay;
    }
  }

  public ay b(aw paramaw, ay paramay)
  {
    paramay = ay.a(paramay);
    if (paramay == null);
    for (ay localay = null; ; localay = ay.a(paramay))
    {
      return localay;
      if (paramay.h != 9)
        break;
      if (do.a(paramay.g, paramay.e, 2).equals("if"))
      {
        paramay = b(paramaw, paramay);
        break;
      }
      if (!do.a(paramay.g, paramay.e, 5).equals("endif"))
        break;
    }
  }

  public void b(ay paramay)
  {
    if (paramay == null)
      return;
    if (paramay.m == this.b.H)
    {
      paramay.n = this.b.J.a;
      paramay.m = this.b.J;
    }
    while (true)
    {
      if (paramay.p != null)
        b(paramay.p);
      paramay = paramay.c;
      break;
      if (paramay.m != this.b.G)
        continue;
      paramay.n = this.b.I.a;
      paramay.m = this.b.I;
    }
  }

  public void c(aw paramaw, ay paramay)
  {
    while (true)
    {
      if (paramay == null)
        return;
      if (paramay.h == 9)
      {
        if ((do.a(paramay.g, paramay.e, 2).equals("if")) && (!do.a(paramay.g, paramay.e, 7).equals("if !vml")))
        {
          paramay = b(paramaw, paramay);
          continue;
        }
        paramay = ay.a(paramay);
        continue;
      }
      if (paramay.p != null)
        c(paramaw, paramay.p);
      paramay = paramay.c;
    }
  }

  public void c(ay paramay)
  {
    while (true)
    {
      if (paramay == null)
        return;
      if (paramay.p != null)
        c(paramay.p);
      if ((paramay.m != null) && (paramay.m.b() == bs.h) && (paramay.e()) && (paramay.p.j))
      {
        i(paramay);
        paramay.n = this.b.af.a;
        paramay.m = this.b.af;
        paramay.j = true;
      }
      paramay = paramay.c;
    }
  }

  public ay d(aw paramaw, ay paramay)
  {
    f(paramaw, paramay.p);
    Object localObject1 = paramay.p;
    Object localObject2;
    if (paramay.b != null)
      localObject2 = paramay.b;
    while (true)
    {
      if (localObject1 == null)
      {
        if (paramay.c == null)
          paramay.a.d = ((ay)localObject2);
        ay localay2 = paramay.c;
        paramay.p = null;
        ay.a(paramay);
        return localay2;
        if (localObject1 != null)
        {
          ay localay3 = ((ay)localObject1).c;
          ((ay)localObject1).c();
          ay.b(paramay, (ay)localObject1);
          localObject2 = localObject1;
          localObject1 = localay3;
          continue;
        }
      }
      else
      {
        ay localay1 = ((ay)localObject1).c;
        ((ay)localObject1).c();
        ((ay)localObject2).d((ay)localObject1);
        localObject2 = localObject1;
        localObject1 = localay1;
        continue;
      }
      localObject2 = null;
    }
  }

  public void d(ay paramay)
  {
    if (paramay == null)
      return;
    int i;
    label28: String str;
    if ((paramay.m == this.b.af) && (paramay.j))
    {
      i = 1;
      if ((!paramay.e()) || (paramay.p.m != this.b.af) || (!paramay.j))
      {
        if (paramay.p != null)
          d(paramay.p);
        str = "margin-left: " + new Integer(i * 2).toString() + "em";
        paramay.n = this.b.ai.a;
        paramay.m = this.b.ai;
        b localb = paramay.a("style");
        if ((localb == null) || (localb.g == null))
          break label207;
        localb.g = (str + "; " + localb.g);
      }
    }
    while (true)
    {
      paramay = paramay.c;
      break;
      i++;
      i(paramay);
      break label28;
      label207: paramay.a("style", str);
      continue;
      if (paramay.p == null)
        continue;
      d(paramay.p);
    }
  }

  public void e(ay paramay)
  {
    Object localObject1 = null;
    Object localObject2 = paramay.o;
    if (localObject2 == null)
      return;
    b localb = ((b)localObject2).a;
    if ((((b)localObject2).f != null) && (((b)localObject2).g != null) && (((b)localObject2).f.equals("class")) && ((((b)localObject2).g.equals("Code")) || (!((b)localObject2).g.startsWith("Mso"))));
    while (true)
    {
      localObject1 = localObject2;
      localObject2 = localb;
      break;
      if ((((b)localObject2).f == null) || ((!((b)localObject2).f.equals("class")) && (!((b)localObject2).f.equals("style")) && (!((b)localObject2).f.equals("lang")) && (!((b)localObject2).f.startsWith("x:")) && (((!((b)localObject2).f.equals("height")) && (!((b)localObject2).f.equals("width"))) || ((paramay.m != this.b.y) && (paramay.m != this.b.A) && (paramay.m != this.b.z)))))
        continue;
      if (localObject1 != null)
      {
        localObject1.a = localb;
        localObject2 = localObject1;
        continue;
      }
      paramay.o = localb;
      localObject2 = localObject1;
    }
  }

  boolean e(aw paramaw, ay paramay)
  {
    int i = 0;
    ay localay;
    if (paramay.p != null)
    {
      localay = paramay.p;
      if (localay.c == null)
        break label25;
    }
    while (true)
    {
      return i;
      label25: if (localay.h != 4)
        continue;
      if ((localay.f - localay.e == 1) && (paramaw.x[localay.e] == 32))
      {
        i = 1;
        continue;
      }
      if (localay.f - localay.e != 2)
        continue;
      int[] arrayOfInt = new int[1];
      bc.a(paramaw.x, localay.e, arrayOfInt);
      if (arrayOfInt[0] != 160)
        continue;
      i = 1;
    }
  }

  public void f(aw paramaw, ay paramay)
  {
    ay localay1 = null;
    ay localay2 = paramay;
    if (localay2 == null);
    Object localObject;
    label117: 
    do
    {
      while (true)
      {
        return;
        if (localay2.m != this.b.b)
          break;
        if (localay2.a("xmlns:o") == null)
          continue;
        paramaw.F.ap.d(localay2);
      }
      if ((localay2.m != this.b.q) || (!f(localay2)))
        break label798;
      ay.a(paramaw, localay2, this.b.m);
      e(localay2);
      if (localay2.p != null)
        f(paramaw, localay2.p);
      localObject = localay2.c;
      if ((((ay)localObject).m == this.b.q) && (f((ay)localObject)))
        break;
    }
    while (localObject == null);
    while (true)
    {
      if ((((ay)localObject).m != null) && (do.a(0x8 & ((ay)localObject).m.c)) && (e(paramaw, (ay)localObject)))
      {
        localay2 = d(paramaw, (ay)localObject);
        break;
        ay localay4 = ((ay)localObject).c;
        ((ay)localObject).c();
        localay2.c(paramaw.b());
        localay2.c((ay)localObject);
        d(paramaw, (ay)localObject);
        localObject = localay4;
        break label117;
      }
      if ((((ay)localObject).m == this.b.Y) || (((ay)localObject).m == this.b.i) || (((ay)localObject).h == 2))
      {
        localay2 = ay.a((ay)localObject);
        break;
      }
      if ((((ay)localObject).m == this.b.aj) || (((ay)localObject).m == this.b.U))
      {
        localay2 = d(paramaw, (ay)localObject);
        break;
      }
      if (((ay)localObject).m == this.b.F)
      {
        b localb3 = ((ay)localObject).a("rel");
        if ((localb3 != null) && (localb3.g != null) && (localb3.g.equals("File-List")))
        {
          localay2 = ay.a((ay)localObject);
          break;
        }
      }
      if ((((ay)localObject).p == null) && (((ay)localObject).m == this.b.q))
      {
        localay2 = ay.a((ay)localObject);
        break;
      }
      b localb1;
      if (((ay)localObject).m == this.b.q)
      {
        localb1 = ((ay)localObject).a("class");
        b localb2 = ((ay)localObject).a("style");
        if ((localb1 != null) && (localb1.g != null) && ((localb1.g.equals("MsoListBullet")) || (localb1.g.equals("MsoListNumber")) || ((localb2 != null) && (localb2.g.indexOf("mso-list:") != -1))))
        {
          ap localap = this.b.r;
          if (localb1.g.equals("MsoListNumber"))
            localap = this.b.s;
          ay.a(paramaw, (ay)localObject, this.b.u);
          if ((localay1 == null) || (localay1.m != localap))
          {
            localay1 = paramaw.b(localap.a);
            ay.b((ay)localObject, localay1);
          }
          e((ay)localObject);
          if (((ay)localObject).p != null)
            f(paramaw, ((ay)localObject).p);
          ((ay)localObject).c();
          localay1.c((ay)localObject);
          localObject = localay1;
        }
      }
      while (true)
      {
        if ((((ay)localObject).h == 5) || (((ay)localObject).h == 7))
          e((ay)localObject);
        if (((ay)localObject).p != null)
          f(paramaw, ((ay)localObject).p);
        localay2 = ((ay)localObject).c;
        break;
        if ((localb1 != null) && (localb1.g != null) && (localb1.g.equals("Code")))
        {
          ay localay3 = paramaw.b();
          r(paramaw, (ay)localObject);
          if ((localay1 == null) || (localay1.m != this.b.m))
          {
            localay1 = paramaw.b("pre");
            ay.b((ay)localObject, localay1);
          }
          ((ay)localObject).c();
          localay1.c((ay)localObject);
          d(paramaw, (ay)localObject);
          localay1.c(localay3);
          localObject = localay1.c;
          continue;
        }
        localay1 = null;
        continue;
        localay1 = null;
      }
      label798: localObject = localay2;
    }
  }

  boolean f(ay paramay)
  {
    int i = 0;
    b localb = paramay.a("style");
    if ((localb == null) || (localb.g == null));
    while (true)
    {
      return i;
      if ((localb.g.indexOf("margin-top: 0") == -1) || (localb.g.indexOf("margin-bottom: 0") == -1))
        continue;
      i = 1;
    }
  }

  public boolean g(ay paramay)
  {
    int i = 1;
    ay localay1 = paramay.b(this.b);
    if ((localay1 != null) && (localay1.a("xmlns:o") != null));
    while (true)
    {
      return i;
      ay localay2 = paramay.c(this.b);
      ay localay3;
      if (localay2 != null)
      {
        localay3 = localay2.p;
        if (localay3 != null);
      }
      else
      {
        i = 0;
        continue;
      }
      if (localay3.m != this.b.i);
      b localb2;
      do
      {
        b localb1;
        do
        {
          localay3 = localay3.c;
          break;
          localb1 = localay3.a("name");
        }
        while ((localb1 == null) || (localb1.g == null) || (!"generator".equals(localb1.g)));
        localb2 = localay3.a("content");
      }
      while ((localb2 == null) || (localb2.g == null) || (localb2.g.indexOf("Microsoft") == -1));
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.z
 * JD-Core Version:    0.6.0
 */