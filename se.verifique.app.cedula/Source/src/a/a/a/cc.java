package a.a.a;

public class cc
  implements br
{
  public void a(aw paramaw, ay paramay, short paramShort)
  {
    dj localdj = paramaw.F.ap;
    if ((0x1 & paramay.m.c) != 0)
      return;
    paramaw.B = -1;
    while (true)
    {
      label28: ay localay1 = paramaw.b(0);
      if (localay1 == null)
      {
        if ((0x80000 & paramay.m.c) != 0)
          ay.a(paramaw, paramay, localdj.r);
        paramaw.I.a(paramaw, paramay, localay1, 6);
        ay.a(paramaw, paramay);
        break;
      }
      if ((localay1.m == paramay.m) && (localay1.h == 6))
      {
        if ((0x80000 & paramay.m.c) != 0)
          ay.a(paramaw, paramay, localdj.r);
        paramay.i = true;
        ay.a(paramaw, paramay);
        break;
      }
      if (ay.c(paramay, localay1))
        continue;
      if ((localay1.h != 4) && (localay1.m == null))
      {
        paramaw.I.a(paramaw, paramay, localay1, 8);
        continue;
      }
      if (localay1.h == 6)
      {
        if (localay1.m == localdj.ad)
        {
          bs.c(paramaw);
          paramaw.I.a(paramaw, paramay, localay1, 8);
          continue;
        }
        if ((localay1.m != null) && ((0x10 & localay1.m.c) != 0))
        {
          paramaw.I.a(paramaw, paramay, localay1, 8);
          paramaw.k(localay1);
          continue;
        }
        for (ay localay2 = paramay.a; ; localay2 = localay2.a)
        {
          if (localay2 == null)
          {
            paramaw.I.a(paramaw, paramay, localay1, 8);
            break label28;
          }
          if (localay1.m != localay2.m)
            continue;
          paramaw.I.a(paramaw, paramay, localay1, 7);
          paramaw.h();
          if ((0x80000 & paramay.m.c) != 0)
            ay.a(paramaw, paramay, localdj.r);
          ay.a(paramaw, paramay);
          break;
        }
      }
      if (localay1.m != localdj.u)
      {
        paramaw.h();
        if ((localay1.m != null) && ((0x8 & localay1.m.c) != 0) && (paramaw.n))
        {
          paramaw.I.a(paramaw, paramay, localay1, 7);
          ay.a(paramaw, paramay);
          break;
        }
        localay1 = paramaw.b("li");
        localay1.a("style", "list-style: none");
        paramaw.I.a(paramaw, paramay, localay1, 12);
      }
      paramay.c(localay1);
      bs.a(paramaw, localay1, 0);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.cc
 * JD-Core Version:    0.6.0
 */