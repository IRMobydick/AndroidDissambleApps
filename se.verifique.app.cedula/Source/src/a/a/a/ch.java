package a.a.a;

public class ch
  implements br
{
  public void a(aw paramaw, ay paramay, short paramShort)
  {
    dj localdj = paramaw.F.ap;
    label22: ay localay1;
    if ((0x1 & paramay.m.c) != 0)
    {
      while (true)
      {
        return;
        if (localay1.m == paramay.m)
        {
          if (localay1.h == 6)
          {
            paramay.i = true;
            ay.a(paramaw, paramay);
            continue;
          }
          paramaw.h();
          continue;
        }
        if ((localay1.m != localdj.ab) || (localay1.h != 6))
          break;
        paramaw.h();
        ay.a(paramaw, paramay);
      }
      if (!ay.c(paramay, localay1))
        break label128;
    }
    while (true)
    {
      localay1 = paramaw.b(0);
      if (localay1 != null)
        break label22;
      ay.a(paramaw, paramay);
      break;
      label128: if ((localay1.m == null) && (localay1.h != 4))
      {
        paramaw.I.a(paramaw, paramay, localay1, 8);
        continue;
      }
      if (localay1.h != 6)
      {
        if ((localay1.m != localdj.y) && (localay1.m != localdj.z))
          break label300;
        paramaw.h();
        localay1 = paramaw.b("tr");
        paramaw.I.a(paramaw, paramay, localay1, 12);
      }
      label300: 
      do
      {
        if (localay1.h != 6)
          break label475;
        if ((localay1.m != localdj.ad) && ((localay1.m == null) || ((0x18 & localay1.m.c) == 0)))
          break label409;
        if (localay1.m == localdj.ad)
          bs.c(paramaw);
        paramaw.I.a(paramaw, paramay, localay1, 8);
        break;
        if ((localay1.h != 4) && ((0x18 & localay1.m.c) == 0))
          continue;
        ay.a(paramay, localay1, localdj);
        paramaw.I.a(paramaw, paramay, localay1, 11);
        paramaw.o = true;
        if (localay1.h != 4)
          bs.a(paramaw, localay1, 0);
        paramaw.o = false;
        break;
      }
      while ((0x4 & localay1.m.c) == 0);
      paramaw.I.a(paramaw, paramay, localay1, 11);
      bs.a(paramaw, paramay, localay1);
      continue;
      label409: if ((localay1.m == localdj.A) || (localay1.m == localdj.y) || (localay1.m == localdj.z))
      {
        paramaw.I.a(paramaw, paramay, localay1, 8);
        continue;
      }
      for (ay localay2 = paramay.a; ; localay2 = localay2.a)
      {
        if (localay2 == null)
        {
          label475: if ((0x100 & localay1.m.c) == 0)
            break label547;
          if (localay1.h != 6)
            paramaw.h();
          ay.a(paramaw, paramay);
          break;
        }
        if (localay1.m != localay2.m)
          continue;
        paramaw.h();
        ay.a(paramaw, paramay);
        break;
      }
      label547: if (localay1.h == 6)
      {
        paramaw.I.a(paramaw, paramay, localay1, 8);
        continue;
      }
      if (localay1.m != localdj.A)
      {
        localay1 = paramaw.b("tr");
        paramaw.I.a(paramaw, paramay, localay1, 12);
        paramaw.h();
      }
      paramay.c(localay1);
      bs.a(paramaw, localay1, 0);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.ch
 * JD-Core Version:    0.6.0
 */