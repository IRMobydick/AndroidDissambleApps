package a.a.a;

public class cf
  implements br
{
  public void a(aw paramaw, ay paramay, short paramShort)
  {
    dj localdj = paramaw.F.ap;
    if ((0x1 & paramay.m.c) != 0)
      return;
    if ((0x80000 & paramay.m.c) != 0)
      ay.a(paramaw, paramay, localdj.m);
    paramaw.m(null);
    while (true)
    {
      ay localay = paramaw.b(2);
      if (localay == null)
      {
        paramaw.I.a(paramaw, paramay, localay, 6);
        ay.a(paramaw, paramay);
        break;
      }
      if ((localay.m == paramay.m) && (localay.h == 6))
      {
        ay.c(paramaw, paramay);
        paramay.i = true;
        ay.a(paramaw, paramay);
        break;
      }
      if (localay.m == localdj.b)
      {
        if ((localay.h != 5) && (localay.h != 7))
          continue;
        paramaw.I.a(paramaw, paramay, localay, 8);
        continue;
      }
      if (localay.h == 4)
      {
        if (paramay.p == null)
        {
          if (localay.g[localay.e] == 10)
            localay.e = (1 + localay.e);
          if (localay.e >= localay.f)
            continue;
        }
        paramay.c(localay);
        continue;
      }
      if (ay.c(paramay, localay))
        continue;
      if (!paramaw.p(localay))
      {
        paramaw.I.a(paramaw, paramay, localay, 39);
        paramay.c(ay.b(paramaw, localay));
        continue;
      }
      if (localay.m == localdj.q)
      {
        if (localay.h == 5)
        {
          paramaw.I.a(paramaw, paramay, localay, 14);
          ay.c(paramaw, paramay);
          ay.a(paramaw, localay, localdj.D);
          paramay.c(localay);
          continue;
        }
        paramaw.I.a(paramaw, paramay, localay, 8);
        continue;
      }
      if ((localay.h == 5) || (localay.h == 7))
      {
        if (localay.m == localdj.D)
          ay.c(paramaw, paramay);
        paramay.c(localay);
        bs.a(paramaw, localay, 2);
        continue;
      }
      paramaw.I.a(paramaw, paramay, localay, 8);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.cf
 * JD-Core Version:    0.6.0
 */