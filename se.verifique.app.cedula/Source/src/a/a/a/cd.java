package a.a.a;

public class cd
  implements br
{
  public void a(aw paramaw, ay paramay, short paramShort)
  {
    dj localdj = paramaw.F.ap;
    paramaw.c = (0x20 | paramaw.c);
    while (true)
    {
      ay localay1 = paramaw.b(0);
      if (localay1 == null)
        paramaw.I.a(paramaw, paramay, localay1, 6);
      while (true)
      {
        return;
        if ((localay1.m == paramay.m) && (localay1.h == 6))
        {
          paramay.i = true;
          ay.c(paramaw, paramay);
          continue;
        }
        if ((localay1.m != localdj.f) && (localay1.m != localdj.e))
          break;
        ay.c(paramaw, paramay);
        if (localay1.h == 6)
        {
          paramaw.I.a(paramaw, paramay, localay1, 8);
          continue;
        }
        paramaw.I.a(paramaw, paramay, localay1, 7);
        paramaw.h();
      }
      if (localay1.m == localdj.b)
      {
        if ((localay1.h != 5) && (localay1.h != 7))
          continue;
        paramaw.I.a(paramaw, paramay, localay1, 8);
        continue;
      }
      if (ay.c(paramay, localay1))
        continue;
      if ((localay1.m == localdj.d) && (localay1.h == 5))
      {
        boolean bool = paramaw.G;
        paramay.c(localay1);
        bs.a(paramaw, localay1, 0);
        if (!bool)
          continue;
        ay.a(paramaw, localay1, localdj.ai);
        bs.a(paramaw, localay1);
        continue;
      }
      if ((localay1.h == 4) || ((localay1.m != null) && (localay1.h != 6)))
      {
        if (paramaw.G)
        {
          ay localay2 = paramaw.J.a(localdj);
          if (localay1.h == 4)
          {
            paramaw.h();
            localay1 = paramaw.b("p");
            paramaw.I.a(paramaw, paramay, localay1, 27);
          }
          localay2.c(localay1);
        }
        while (true)
        {
          bs.a(paramaw, localay1, 0);
          break;
          paramaw.h();
          localay1 = paramaw.b("body");
          if (paramaw.F.p)
            paramaw.I.a(paramaw, paramay, localay1, 15);
          paramay.c(localay1);
        }
      }
      paramaw.I.a(paramaw, paramay, localay1, 8);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.cd
 * JD-Core Version:    0.6.0
 */