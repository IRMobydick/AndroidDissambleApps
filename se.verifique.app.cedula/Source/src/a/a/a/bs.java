package a.a.a;

public final class bs
{
  public static final br a = new bz();
  public static final br b = new ca();
  public static final br c = new cm();
  public static final br d = new ci();
  public static final br e = new bu();
  public static final br f = new by();
  public static final br g = new cb();
  public static final br h = new cc();
  public static final br i = new bw();
  public static final br j = new cf();
  public static final br k = new bt();
  public static final br l = new ck();
  public static final br m = new bv();
  public static final br n = new ch();
  public static final br o = new cg();
  public static final br p = new cd();
  public static final br q = new cj();
  public static final br r = new cl();
  public static final br s = new bx();
  public static final br t = new ce();

  public static ay a(aw paramaw)
  {
    dj localdj = paramaw.F.ap;
    ay localay1 = paramaw.a();
    localay1.h = 0;
    paramaw.J = localay1;
    Object localObject = null;
    ay localay2 = paramaw.b(0);
    if (localay2 == null);
    while (true)
    {
      if (paramaw.J.b(paramaw.F.ap) == null)
      {
        ay localay4 = paramaw.b("html");
        paramaw.J.c(localay4);
        a.a(paramaw, localay4, 0);
      }
      if (paramaw.J.d(paramaw.F.ap) == null)
      {
        ay localay3 = paramaw.J.c(paramaw.F.ap);
        paramaw.I.a(paramaw, localay3, null, 17);
        localay3.c(paramaw.b("title"));
      }
      return localay1;
      if (ay.c(localay1, localay2))
        break;
      if (localay2.h == 1)
      {
        if (localObject == null)
        {
          localay1.c(localay2);
          localObject = localay2;
          break;
        }
        paramaw.I.a(paramaw, localay1, localay2, 8);
        break;
      }
      if (localay2.h == 6)
      {
        paramaw.I.a(paramaw, localay1, localay2, 8);
        break;
      }
      if ((localay2.h != 5) || (localay2.m != localdj.b))
      {
        paramaw.h();
        localay2 = paramaw.b("html");
      }
      if ((localay1.a() == null) && (!paramaw.F.aa))
        paramaw.I.a(paramaw, null, null, 44);
      localay1.c(localay2);
      a.a(paramaw, localay2, 0);
    }
  }

  static void a(aw paramaw, ay paramay)
  {
    paramay.c();
    paramaw.J.a(paramaw.F.ap).c(paramay);
  }

  protected static void a(aw paramaw, ay paramay1, ay paramay2)
  {
    paramay2.c();
    dj localdj = paramaw.F.ap;
    ay localay;
    if ((paramay2.h == 5) || (paramay2.h == 7))
    {
      paramaw.I.a(paramaw, paramay1, paramay2, 11);
      if (paramay1.m == localdj.b)
      {
        localay = paramay1.p;
        label58: if (localay != null)
          break label88;
        label63: if (paramay2.m.b() != null)
          a(paramaw, paramay2, 0);
      }
    }
    while (true)
    {
      return;
      paramay1 = paramay1.a;
      break;
      label88: if (localay.m == localdj.c)
      {
        localay.c(paramay2);
        break label63;
      }
      localay = localay.c;
      break label58;
      paramaw.I.a(paramaw, paramay1, paramay2, 8);
    }
  }

  protected static void a(aw paramaw, ay paramay, short paramShort)
  {
    if ((0x1 & paramay.m.c) != 0)
      paramaw.k = false;
    label82: 
    while (true)
    {
      if (paramay.m.b() == null);
      while (true)
      {
        return;
        if ((0x10 & paramay.m.c) != 0)
          break label82;
        paramaw.m = false;
        break;
        if (paramay.h == 7)
        {
          ay.a(paramaw, paramay);
          continue;
        }
        paramay.m.b().a(paramaw, paramay, paramShort);
      }
    }
  }

  public static boolean a(ay paramay, dj paramdj)
  {
    int i1 = 1;
    b localb = paramay.o;
    if (localb == null)
    {
      if (paramay.n != null)
        break label60;
      i1 = 0;
    }
    while (true)
    {
      return i1;
      if (localb.f.equals("xml:space"))
      {
        if (localb.g.equals("preserve"))
          continue;
        i1 = 0;
        continue;
      }
      localb = localb.a;
      break;
      label60: if (("pre".equalsIgnoreCase(paramay.n)) || ("script".equalsIgnoreCase(paramay.n)) || ("style".equalsIgnoreCase(paramay.n)) || ((paramdj != null) && (paramdj.b(paramay) == j)) || ("xsl:text".equalsIgnoreCase(paramay.n)))
        continue;
      i1 = 0;
    }
  }

  public static ay b(aw paramaw)
  {
    ay localay1 = paramaw.a();
    localay1.h = 0;
    paramaw.F.o = true;
    Object localObject = null;
    while (true)
    {
      ay localay2 = paramaw.b(0);
      if (localay2 == null)
      {
        if ((localObject != null) && (!paramaw.c((ay)localObject)))
          paramaw.I.a(paramaw, (ay)localObject, null, 37);
        if (paramaw.F.s)
          paramaw.h(localay1);
        return localay1;
      }
      if (localay2.h == 6)
      {
        paramaw.I.a(paramaw, null, localay2, 13);
        continue;
      }
      if (ay.c(localay1, localay2))
        continue;
      if (localay2.h == 1)
      {
        if (localObject == null)
        {
          localay1.c(localay2);
          localObject = localay2;
          continue;
        }
        paramaw.I.a(paramaw, localay1, localay2, 8);
        continue;
      }
      if (localay2.h == 7)
      {
        localay1.c(localay2);
        continue;
      }
      if (localay2.h != 5)
        continue;
      localay1.c(localay2);
      b(paramaw, localay2, 0);
    }
  }

  public static void b(aw paramaw, ay paramay, short paramShort)
  {
    if (a(paramay, paramaw.F.ap))
      paramShort = 2;
    while (true)
    {
      ay localay1 = paramaw.b(paramShort);
      if (localay1 == null);
      while (true)
      {
        ay localay2 = paramay.p;
        if ((localay2 != null) && (localay2.h == 4) && (paramShort != 2) && (localay2.g[localay2.e] == 32))
        {
          localay2.e = (1 + localay2.e);
          if (localay2.e >= localay2.f)
            ay.a(localay2);
        }
        ay localay3 = paramay.d;
        if ((localay3 != null) && (localay3.h == 4) && (paramShort != 2) && (localay3.g[(-1 + localay3.f)] == 32))
        {
          localay3.f = (-1 + localay3.f);
          if (localay3.e >= localay3.f)
            ay.a(localay3);
        }
        return;
        if ((localay1.h != 6) || (!localay1.n.equals(paramay.n)))
          break;
        paramay.i = true;
      }
      if (localay1.h == 6)
      {
        paramaw.I.b(paramaw, paramay, localay1, 13);
        continue;
      }
      if (localay1.h == 5)
        b(paramaw, localay1, paramShort);
      paramay.c(localay1);
    }
  }

  static void c(aw paramaw)
  {
    paramaw.f = 1;
    paramaw.h = (1 + paramaw.h);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.bs
 * JD-Core Version:    0.6.0
 */