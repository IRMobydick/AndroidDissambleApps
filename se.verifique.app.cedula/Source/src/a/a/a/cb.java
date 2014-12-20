package a.a.a;

public class cb
  implements br
{
  public void a(aw paramaw, ay paramay, short paramShort)
  {
    dj localdj = paramaw.F.ap;
    if (do.a(0x1 & paramay.m.c))
      return;
    if ((do.a(0x8 & paramay.m.c)) || (paramay.m == localdj.v))
    {
      paramaw.m(null);
      label59: if (paramay.m != localdj.S)
        break label182;
      paramaw.d = (0x4 | paramaw.d);
      label81: if (paramShort != 2)
        paramShort = 1;
    }
    while (true)
    {
      label88: ay localay1 = paramaw.b(paramShort);
      if (localay1 == null)
      {
        if ((0x8000 & paramay.m.c) == 0)
          paramaw.I.a(paramaw, paramay, localay1, 6);
        ay.a(paramaw, paramay);
        break;
        if ((!do.a(0x10 & paramay.m.c)) || (paramay.m == localdj.E) || (paramay.m == localdj.aj))
          break label59;
        paramaw.j(paramay);
        break label59;
        label182: if (paramay.m != localdj.U)
          break label81;
        paramaw.d = (0x8 | paramaw.d);
        break label81;
      }
      if ((localay1.m == paramay.m) && (localay1.h == 6))
      {
        if (do.a(0x10 & paramay.m.c))
          paramaw.k(localay1);
        if (!do.a(paramShort & 0x2))
          ay.c(paramaw, paramay);
        ay localay4;
        if ((paramay.m == localdj.U) && (paramay.p != null) && (paramay.p == paramay.d))
        {
          localay4 = paramay.p;
          if (localay4.m == localdj.E)
          {
            localay4.a = paramay.a;
            localay4.c = paramay.c;
            localay4.b = paramay.b;
            if (localay4.b == null)
              break label453;
            localay4.b.c = localay4;
            label360: if (localay4.c == null)
              break label466;
            localay4.c.b = localay4;
            label378: paramay.c = null;
            paramay.b = null;
            paramay.a = localay4;
            paramay.p = localay4.p;
            paramay.d = localay4.d;
            localay4.p = paramay;
            localay4.d = paramay;
          }
        }
        for (ay localay5 = paramay.p; ; localay5 = localay5.c)
        {
          if (localay5 == null)
          {
            paramay.i = true;
            ay.c(paramaw, paramay);
            ay.a(paramaw, paramay);
            break;
            label453: localay4.a.p = localay4;
            break label360;
            label466: localay4.a.d = localay4;
            break label378;
          }
          localay5.a = paramay;
        }
      }
      if ((localay1.h == 5) && (localay1.m == paramay.m) && (paramaw.l(localay1)) && (!localay1.j) && (!paramay.j) && (localay1.m != null) && ((0x10 & localay1.m.c) != 0) && (localay1.m != localdj.E) && (localay1.m != localdj.U) && (localay1.m != localdj.K) && (localay1.m != localdj.L) && (localay1.m != localdj.al))
      {
        if ((paramay.p != null) && (localay1.o == null))
        {
          paramaw.I.a(paramaw, paramay, localay1, 24);
          localay1.h = 6;
          paramaw.h();
          continue;
        }
        paramaw.I.a(paramaw, paramay, localay1, 9);
      }
      while (true)
      {
        if (localay1.h != 4)
          break label781;
        if ((paramay.p == null) && (!do.a(paramShort & 0x2)))
          ay.c(paramaw, paramay);
        if (localay1.e >= localay1.f)
          break;
        paramay.c(localay1);
        break;
        if ((!paramaw.l(localay1)) || (localay1.h != 5) || (localay1.m != localdj.al))
          continue;
        paramaw.I.a(paramaw, paramay, localay1, 40);
      }
      label781: if (ay.c(paramay, localay1))
        continue;
      if (localay1.m == localdj.b)
      {
        if ((localay1.h == 5) || (localay1.h == 7))
        {
          paramaw.I.a(paramaw, paramay, localay1, 8);
          continue;
        }
        paramaw.h();
        if ((paramShort & 0x2) == 0)
          ay.c(paramaw, paramay);
        ay.a(paramaw, paramay);
        break;
      }
      if ((localay1.m == localdj.q) && (localay1.h == 5) && (((paramShort & 0x2) != 0) || (paramay.m == localdj.v) || (paramay.a(localdj.v))))
      {
        localay1.m = localdj.D;
        localay1.n = "br";
        ay.c(paramaw, paramay);
        paramay.c(localay1);
        continue;
      }
      if ((localay1.m == null) || (localay1.m == localdj.M))
      {
        paramaw.I.a(paramaw, paramay, localay1, 8);
        continue;
      }
      if ((localay1.m == localdj.D) && (localay1.h == 6))
        localay1.h = 5;
      if (localay1.h == 6)
      {
        if (localay1.m == localdj.D)
          localay1.h = 5;
      }
      else
      {
        label1039: if (((0x4000 & localay1.m.c) == 0) || ((0x4000 & paramay.m.c) == 0))
          break label1404;
        if (localay1.m != paramay.m)
          break label1384;
        paramaw.I.a(paramaw, paramay, localay1, 10);
      }
      while (true)
      {
        if ((paramShort & 0x2) == 0)
          ay.c(paramaw, paramay);
        ay.a(paramaw, paramay);
        break;
        if (localay1.m == localdj.q)
        {
          if (paramay.a(localdj.q))
            break label1039;
          ay.a(paramaw, localay1, localdj.D);
          ay.c(paramaw, paramay);
          paramay.c(localay1);
          paramaw.b("br");
          break label88;
        }
        if (((0x10 & localay1.m.c) != 0) && (localay1.m != localdj.E) && ((0x800 & localay1.m.c) == 0) && ((0x10 & paramay.m.c) != 0))
        {
          paramaw.k(paramay);
          if (paramay.m != localdj.E)
          {
            if ((localay1.m == localdj.E) && (localay1.m != paramay.m))
            {
              paramaw.I.a(paramaw, paramay, localay1, 7);
              paramaw.h();
            }
            while (true)
            {
              if ((paramShort & 0x2) == 0)
                ay.c(paramaw, paramay);
              ay.a(paramaw, paramay);
              break;
              paramaw.I.a(paramaw, paramay, localay1, 10);
            }
          }
          paramaw.I.a(paramaw, paramay, localay1, 8);
          break label88;
        }
        if ((!paramaw.o) || (localay1.m.c == 0) || ((0x80 & localay1.m.c) == 0))
          break label1039;
        paramaw.h();
        ay.c(paramaw, paramay);
        ay.a(paramaw, paramay);
        break;
        label1384: paramaw.I.a(paramaw, paramay, localay1, 7);
        paramaw.h();
      }
      label1404: if ((localay1.m == localdj.E) && (!localay1.j) && ((paramay.m == localdj.E) || (paramay.a(localdj.E))))
      {
        if ((localay1.h != 6) && (localay1.o == null))
        {
          localay1.h = 6;
          paramaw.I.a(paramaw, paramay, localay1, 24);
          paramaw.h();
          continue;
        }
        paramaw.h();
        paramaw.I.a(paramaw, paramay, localay1, 7);
        if ((paramShort & 0x2) == 0)
          ay.c(paramaw, paramay);
        ay.a(paramaw, paramay);
        break;
      }
      if ((0x4000 & paramay.m.c) != 0)
      {
        if ((localay1.m == localdj.X) || (localay1.m == localdj.ai))
        {
          if ((localay1.h != 5) && (localay1.h != 7))
          {
            paramaw.I.a(paramaw, paramay, localay1, 8);
            continue;
          }
          paramaw.I.a(paramaw, paramay, localay1, 11);
          if (paramay.p == null)
          {
            ay.a(paramay, localay1);
            continue;
          }
          paramay.d(localay1);
          if ((paramShort & 0x2) == 0)
            ay.c(paramaw, paramay);
          paramay = paramaw.a(paramay);
          paramay.e = paramaw.z;
          paramay.f = paramaw.z;
          localay1.c(paramay);
          continue;
        }
        if (localay1.m == localdj.l)
        {
          if ((localay1.h != 5) && (localay1.h != 7))
          {
            paramaw.I.a(paramaw, paramay, localay1, 8);
            continue;
          }
          paramaw.I.a(paramaw, paramay, localay1, 11);
          if (paramay.p == null)
          {
            ay.b(paramay, localay1);
            continue;
          }
          paramay.d(localay1);
          if ((paramShort & 0x2) == 0)
            ay.c(paramaw, paramay);
          paramay = paramaw.a(paramay);
          paramay.e = paramaw.z;
          paramay.f = paramaw.z;
          localay1.d(paramay);
          continue;
        }
      }
      if ((paramay.m == localdj.v) && (localay1.m == localdj.l))
      {
        if ((localay1.h != 5) && (localay1.h != 7))
        {
          paramaw.I.a(paramaw, paramay, localay1, 8);
          continue;
        }
        paramaw.I.a(paramaw, paramay, localay1, 11);
        ay localay3 = paramaw.b("dd");
        if (paramay.p == null)
        {
          ay.b(paramay, localay3);
          localay3.c(localay1);
          continue;
        }
        paramay.d(localay3);
        localay3.c(localay1);
        if ((paramShort & 0x2) == 0)
          ay.c(paramaw, paramay);
        paramay = paramaw.a(paramay);
        paramay.e = paramaw.z;
        paramay.f = paramaw.z;
        localay3.d(paramay);
        continue;
      }
      if (localay1.h == 6);
      for (ay localay2 = paramay.a; ; localay2 = localay2.a)
      {
        if (localay2 == null)
        {
          if ((0x10 & localay1.m.c) != 0)
            break label2267;
          if (localay1.h == 5)
            break label2122;
          paramaw.I.a(paramaw, paramay, localay1, 8);
          break label88;
        }
        if (localay1.m != localay2.m)
          continue;
        if (((0x8000 & paramay.m.c) == 0) && (!paramay.j))
          paramaw.I.a(paramaw, paramay, localay1, 7);
        if (paramay.m == localdj.E)
          paramaw.k(paramay);
        paramaw.h();
        if ((paramShort & 0x2) == 0)
          ay.c(paramaw, paramay);
        ay.a(paramaw, paramay);
        break;
      }
      label2122: if ((0x8000 & paramay.m.c) == 0)
        paramaw.I.a(paramaw, paramay, localay1, 7);
      if (((0x4 & localay1.m.c) != 0) && ((0x8 & localay1.m.c) == 0))
      {
        bs.a(paramaw, paramay, localay1);
        continue;
      }
      if (paramay.m == localdj.E)
      {
        if ((localay1.m == null) || ((0x4000 & localay1.m.c) != 0))
          break label2248;
        paramaw.k(paramay);
      }
      label2248: 
      do
      {
        paramaw.h();
        if ((paramShort & 0x2) == 0)
          ay.c(paramaw, paramay);
        ay.a(paramaw, paramay);
        break;
      }
      while (paramay.p != null);
      ay.a(paramay);
      paramaw.h();
      break;
      label2267: if ((localay1.h == 5) || (localay1.h == 7))
      {
        if (localay1.j)
          paramaw.I.a(paramaw, paramay, localay1, 15);
        if (localay1.m == localdj.D)
          ay.c(paramaw, paramay);
        paramay.c(localay1);
        bs.a(paramaw, localay1, paramShort);
        continue;
      }
      paramaw.I.a(paramaw, paramay, localay1, 8);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.cb
 * JD-Core Version:    0.6.0
 */