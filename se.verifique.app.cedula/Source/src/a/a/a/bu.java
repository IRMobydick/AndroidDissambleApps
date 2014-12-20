package a.a.a;

public class bu
  implements br
{
  public void a(aw paramaw, ay paramay, short paramShort)
  {
    dj localdj = paramaw.F.ap;
    z.g(paramaw, paramay.a);
    int i = 1;
    short s = 0;
    label36: label341: label870: 
    while (true)
    {
      Object localObject1 = paramaw.b(s);
      if (localObject1 == null);
      while (true)
      {
        return;
        if (((ay)localObject1).m == localdj.b)
        {
          if ((((ay)localObject1).h == 5) || (((ay)localObject1).h == 7) || (paramaw.H))
          {
            paramaw.I.a(paramaw, paramay, (ay)localObject1, 8);
            break;
          }
          paramaw.H = true;
          break;
        }
        if ((paramaw.G) && ((((ay)localObject1).h == 5) || (((ay)localObject1).h == 6) || (((ay)localObject1).h == 7)))
          paramaw.I.a(paramaw, paramay, (ay)localObject1, 27);
        if ((((ay)localObject1).m == paramay.m) && (((ay)localObject1).h == 6))
        {
          paramay.i = true;
          ay.c(paramaw, paramay);
          paramaw.G = true;
          if (paramay.a.m == localdj.h)
            continue;
          s = 0;
          break;
        }
        if (((ay)localObject1).m == localdj.h)
        {
          if (((ay)localObject1).h == 5)
          {
            paramay.c((ay)localObject1);
            bs.k.a(paramaw, (ay)localObject1, s);
            break;
          }
          if ((((ay)localObject1).h == 6) && (paramay.a.m == localdj.h))
          {
            ay.c(paramaw, paramay);
            paramaw.h();
            continue;
          }
        }
        if (((((ay)localObject1).m != localdj.f) && (((ay)localObject1).m != localdj.e)) || (paramay.a.m != localdj.h))
          break label341;
        ay.c(paramaw, paramay);
        paramaw.h();
      }
      if ((((ay)localObject1).h == 4) && (((ay)localObject1).f <= 1 + ((ay)localObject1).e) && (localObject1.g[localObject1.e] == 32));
      label747: label1134: for (int j = 1; ; j = 0)
      {
        if (ay.c(paramay, (ay)localObject1))
          break label1161;
        if (((ay)localObject1).h == 4)
        {
          if ((j != 0) && (s == 0))
            break;
          if ((paramaw.F.T) && (j == 0))
          {
            paramaw.h();
            ay localay = paramaw.b("p");
            paramay.c(localay);
            bs.a(paramaw, localay, s);
            s = 1;
            break;
          }
          paramaw.c(-6);
          if (i != 0)
          {
            if (paramaw.m((ay)localObject1) > 0)
            {
              i = 0;
              break;
            }
            i = 0;
          }
          paramay.c((ay)localObject1);
          s = 1;
          break;
        }
        if (((ay)localObject1).h == 1)
        {
          ay.c(paramaw, paramay, (ay)localObject1);
          break;
        }
        if ((((ay)localObject1).m == null) || (((ay)localObject1).m == localdj.M))
        {
          paramaw.I.a(paramaw, paramay, (ay)localObject1, 8);
          break;
        }
        paramaw.n = false;
        if ((((0x8 & ((ay)localObject1).m.c) == 0) && ((0x10 & ((ay)localObject1).m.c) == 0)) || (((ay)localObject1).m == localdj.ak))
        {
          if ((0x4 & ((ay)localObject1).m.c) == 0)
            paramaw.I.a(paramaw, paramay, (ay)localObject1, 11);
          if ((0x2 & ((ay)localObject1).m.c) != 0)
          {
            if ((((ay)localObject1).m != localdj.d) || (!paramay.j) || (paramay.o != null))
              break;
            paramay.o = ((ay)localObject1).o;
            ((ay)localObject1).o = null;
            break;
          }
          if ((0x4 & ((ay)localObject1).m.c) != 0)
          {
            bs.a(paramaw, paramay, (ay)localObject1);
            break;
          }
          if ((0x20 & ((ay)localObject1).m.c) == 0)
            break label870;
          paramaw.h();
          localObject1 = paramaw.b("ul");
          ((ay)localObject1).b("noindent");
        }
        for (paramaw.n = true; ; paramaw.n = true)
        {
          if (((ay)localObject1).h == 6)
          {
            if (((ay)localObject1).m != localdj.D)
              break label1008;
            ((ay)localObject1).h = 5;
          }
          if ((((ay)localObject1).h != 5) && (((ay)localObject1).h != 7))
            break label1134;
          if (((0x10 & ((ay)localObject1).m.c) == 0) || ((0x20000 & ((ay)localObject1).m.c) != 0))
            break label1125;
          if (((ay)localObject1).m != localdj.P)
            break label1072;
          paramaw.c(-5);
          if ((i == 0) || (((ay)localObject1).j))
            break label1084;
          if (paramaw.m((ay)localObject1) <= 0)
            break label1081;
          i = 0;
          break;
          if ((0x40 & ((ay)localObject1).m.c) == 0)
            break label904;
          paramaw.h();
          localObject1 = paramaw.b("dl");
        }
        if ((0x380 & ((ay)localObject1).m.c) != 0)
        {
          if (((ay)localObject1).h == 6)
            break label1150;
          paramaw.h();
        }
        label1008: label1150: for (Object localObject2 = paramaw.b("table"); ; localObject2 = localObject1)
        {
          paramaw.n = true;
          localObject1 = localObject2;
          break label747;
          if (((ay)localObject1).m == localdj.ak)
          {
            paramaw.h();
            localObject1 = paramaw.b("form");
            paramaw.n = true;
            break label747;
          }
          if ((0x600 & ((ay)localObject1).m.c) != 0)
            break;
          paramaw.h();
          break label36;
          if (((ay)localObject1).m == localdj.q)
          {
            ay.a(paramaw, (ay)localObject1, localdj.D);
            paramay.c((ay)localObject1);
            localObject1 = paramaw.b("br");
            break label776;
          }
          if ((0x10 & ((ay)localObject1).m.c) == 0)
            break label776;
          paramaw.k((ay)localObject1);
          break label776;
          paramaw.c(-6);
          break label842;
          i = 0;
          for (s = 1; ; s = 0)
          {
            if (((ay)localObject1).j)
              paramaw.I.a(paramaw, paramay, (ay)localObject1, 15);
            paramay.c((ay)localObject1);
            bs.a(paramaw, (ay)localObject1, s);
            break;
            i = 1;
          }
          paramaw.I.a(paramaw, paramay, (ay)localObject1, 8);
          break;
        }
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.bu
 * JD-Core Version:    0.6.0
 */