package a.a.a;

import java.util.Stack;

public class bt
  implements br
{
  public void a(aw paramaw, ay paramay, short paramShort)
  {
    int i = 0;
    dj localdj = paramaw.F.ap;
    int j = 1;
    if ((0x1 & paramay.m.c) != 0)
      return;
    if ((paramay.m == localdj.ad) && (paramay.a(localdj.ad)))
      paramaw.I.a(paramaw, paramay, null, 25);
    if ((0x800 & paramay.m.c) != 0)
    {
      i = paramaw.D;
      paramaw.D = paramaw.C.size();
    }
    if ((0x20000 & paramay.m.c) == 0)
      paramaw.m(null);
    short s = 0;
    label117: ay localay1 = paramaw.b(s);
    if (localay1 == null)
    {
      if ((0x8000 & paramay.m.c) == 0)
        paramaw.I.a(paramaw, paramay, localay1, 6);
      if ((0x800 & paramay.m.c) == 0);
    }
    while (true)
    {
      if (paramaw.C.size() <= paramaw.D)
      {
        paramaw.D = i;
        ay.c(paramaw, paramay);
        ay.a(paramaw, paramay);
        break;
        if ((localay1.h == 6) && (localay1.m != null) && ((localay1.m == paramay.m) || (paramay.l == localay1.m)))
        {
          if ((0x800 & paramay.m.c) != 0);
          while (true)
          {
            if (paramaw.C.size() <= paramaw.D)
            {
              paramaw.D = i;
              paramay.i = true;
              ay.c(paramaw, paramay);
              ay.a(paramaw, paramay);
              break;
            }
            paramaw.k(null);
          }
        }
        if ((localay1.m == localdj.b) || (localay1.m == localdj.c) || (localay1.m == localdj.d))
        {
          if ((localay1.h != 5) && (localay1.h != 7))
            break label117;
          paramaw.I.a(paramaw, paramay, localay1, 8);
          break label117;
        }
        if (localay1.h == 6)
        {
          if (localay1.m == null)
          {
            paramaw.I.a(paramaw, paramay, localay1, 8);
            break label117;
          }
          if (localay1.m != localdj.D)
            break label529;
          localay1.h = 5;
        }
        while (true)
        {
          label432: if (localay1.h != 4)
            break label847;
          int k = 0;
          if ((localay1.h == 4) && (localay1.f <= 1 + localay1.e) && (paramaw.x[localay1.e] == 32))
            k = 1;
          if ((!paramaw.F.U) || (k != 0))
            break label739;
          paramaw.h();
          ay localay3 = paramaw.b("p");
          paramay.c(localay3);
          bs.a(paramaw, localay3, 1);
          break;
          label529: if (localay1.m != localdj.q)
            break label570;
          ay.a(paramaw, localay1, localdj.D);
          paramay.c(localay1);
          localay1 = paramaw.b("br");
        }
        label570: for (ay localay4 = paramay.a; ; localay4 = localay4.a)
        {
          if (localay4 == null)
          {
            if ((!paramaw.o) || (localay1.m.c == 0) || ((0x80 & localay1.m.c) == 0))
              break label432;
            paramaw.h();
            ay.c(paramaw, paramay);
            ay.a(paramaw, paramay);
            break;
          }
          if (localay1.m != localay4.m)
            continue;
          if ((0x8000 & paramay.m.c) == 0)
            paramaw.I.a(paramaw, paramay, localay1, 7);
          paramaw.h();
          if ((0x800 & paramay.m.c) != 0);
          while (true)
          {
            if (paramaw.C.size() <= paramaw.D)
            {
              paramaw.D = i;
              ay.c(paramaw, paramay);
              ay.a(paramaw, paramay);
              break;
            }
            paramaw.k(null);
          }
        }
        label739: if (j != 0)
        {
          j = 0;
          if (((0x20000 & paramay.m.c) == 0) && (paramaw.m(localay1) > 0))
            break label117;
        }
        paramay.c(localay1);
        s = 1;
        if ((paramay.m != localdj.d) && (paramay.m != localdj.Q) && (paramay.m != localdj.af) && (paramay.m != localdj.ad) && (paramay.m != localdj.aa))
          break label117;
        paramaw.c(-5);
        break label117;
        label847: if (ay.c(paramay, localay1))
          break label117;
        if (localay1.m == localdj.M)
        {
          if (((0x1000 & paramay.m.c) != 0) && ((localay1.h == 5) || (localay1.h == 7)))
          {
            paramay.c(localay1);
            break label117;
          }
          paramaw.I.a(paramaw, paramay, localay1, 8);
          break label117;
        }
        if (localay1.m == localdj.R)
        {
          if ((paramay.m == localdj.Q) && ((localay1.h == 5) || (localay1.h == 7)))
          {
            paramay.c(localay1);
            break label117;
          }
          paramaw.I.a(paramaw, paramay, localay1, 8);
          break label117;
        }
        if (localay1.m == null)
        {
          paramaw.I.a(paramaw, paramay, localay1, 8);
          break label117;
        }
        if ((0x10 & localay1.m.c) == 0)
        {
          if ((localay1.h != 5) && (localay1.h != 7))
          {
            if (localay1.m == localdj.ad)
              bs.c(paramaw);
            paramaw.I.a(paramaw, paramay, localay1, 8);
            break label117;
          }
          if ((paramay.m == localdj.u) && ((localay1.m == localdj.f) || (localay1.m == localdj.e) || (localay1.m == localdj.O) || (localay1.m == localdj.N)))
          {
            paramaw.I.a(paramaw, paramay, localay1, 8);
            break label117;
          }
          if ((paramay.m == localdj.y) || (paramay.m == localdj.z))
          {
            if ((0x4 & localay1.m.c) != 0)
            {
              bs.a(paramaw, paramay, localay1);
              break label117;
            }
            if ((0x20 & localay1.m.c) != 0)
            {
              paramaw.h();
              localay1 = paramaw.b("ul");
              localay1.b("noindent");
              paramaw.n = true;
            }
            while (true)
            {
              if ((0x8 & localay1.m.c) != 0)
                break label1653;
              paramaw.h();
              ay.c(paramaw, paramay);
              ay.a(paramaw, paramay);
              break;
              if ((0x40 & localay1.m.c) == 0)
                continue;
              paramaw.h();
              localay1 = paramaw.b("dl");
              paramaw.n = true;
            }
          }
          if ((0x8 & localay1.m.c) != 0)
          {
            if (paramaw.n)
            {
              if ((0x8000 & paramay.m.c) == 0)
                paramaw.I.a(paramaw, paramay, localay1, 7);
              paramaw.h();
              if ((0x800 & paramay.m.c) != 0)
                paramaw.D = i;
              ay.c(paramaw, paramay);
              ay.a(paramaw, paramay);
              break;
            }
          }
          else
          {
            if ((0x4 & localay1.m.c) != 0)
            {
              bs.a(paramaw, paramay, localay1);
              break label117;
            }
            if ((paramay.m == localdj.ad) && (paramay.a.m == localdj.y) && (paramay.a.j))
            {
              if (localay1.m == localdj.y)
              {
                paramaw.I.a(paramaw, paramay, localay1, 8);
                break label117;
              }
              if (localay1.m == localdj.z)
              {
                paramaw.I.a(paramaw, paramay, localay1, 8);
                ay localay2 = paramay.a;
                localay2.n = "th";
                localay2.m = localdj.z;
                break label117;
              }
            }
            if (((0x8000 & paramay.m.c) == 0) && (!paramay.j))
              paramaw.I.a(paramaw, paramay, localay1, 7);
            paramaw.h();
            if ((0x20 & localay1.m.c) == 0)
              break label1788;
            if ((paramay.a != null) && (paramay.a.m != null) && (paramay.a.m.b() == bs.h))
            {
              ay.c(paramaw, paramay);
              ay.a(paramaw, paramay);
              break;
            }
            localay1 = paramaw.b("ul");
            localay1.b("noindent");
          }
        }
        label1653: if ((localay1.h == 5) || (localay1.h == 7))
        {
          if (do.a(0x10 & localay1.m.c))
            if ((j != 0) && (!localay1.j))
            {
              j = 0;
              if ((!do.a(0x20000 & paramay.m.c)) && (paramaw.m(localay1) > 0))
                break label117;
            }
          for (s = 1; ; s = 0)
          {
            if (localay1.m == localdj.D)
              ay.c(paramaw, paramay);
            paramay.c(localay1);
            if (localay1.j)
              paramaw.I.a(paramaw, paramay, localay1, 15);
            bs.a(paramaw, localay1, 0);
            break label117;
            label1788: if ((0x40 & localay1.m.c) != 0)
            {
              if (paramay.a.m == localdj.x)
              {
                ay.c(paramaw, paramay);
                ay.a(paramaw, paramay);
                break;
              }
              localay1 = paramaw.b("dl");
              break label1653;
            }
            if (((0x80 & localay1.m.c) != 0) || ((0x200 & localay1.m.c) != 0))
            {
              localay1 = paramaw.b("table");
              break label1653;
            }
            if ((0x800 & paramay.m.c) != 0)
              while (true)
              {
                if (paramaw.C.size() <= paramaw.D)
                {
                  paramaw.D = i;
                  ay.c(paramaw, paramay);
                  ay.a(paramaw, paramay);
                  break;
                }
                paramaw.k(null);
              }
            ay.c(paramaw, paramay);
            ay.a(paramaw, paramay);
            break;
            j = 1;
          }
        }
        if (localay1.h == 6)
          paramaw.k(localay1);
        paramaw.I.a(paramaw, paramay, localay1, 8);
        break label117;
      }
      paramaw.k(null);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.bt
 * JD-Core Version:    0.6.0
 */