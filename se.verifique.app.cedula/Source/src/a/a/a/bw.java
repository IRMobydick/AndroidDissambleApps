package a.a.a;

public class bw
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
        paramaw.I.a(paramaw, paramay, localay1, 6);
        ay.a(paramaw, paramay);
        break;
      }
      if ((localay1.m == paramay.m) && (localay1.h == 6))
      {
        paramay.i = true;
        ay.a(paramaw, paramay);
        break;
      }
      if (ay.c(paramay, localay1))
        continue;
      if (localay1.h == 4)
      {
        paramaw.h();
        localay1 = paramaw.b("dt");
        paramaw.I.a(paramaw, paramay, localay1, 12);
      }
      if (localay1.m == null)
      {
        paramaw.I.a(paramaw, paramay, localay1, 8);
        continue;
      }
      ay localay2;
      if (localay1.h == 6)
      {
        if (localay1.m == localdj.ad)
        {
          bs.c(paramaw);
          paramaw.I.a(paramaw, paramay, localay1, 8);
          continue;
        }
        localay2 = paramay.a;
        label212: if (localay2 != null);
      }
      else
      {
        if (localay1.m != localdj.X)
          break label328;
        if (paramay.p == null)
          break label314;
        paramay.d(localay1);
      }
      while (true)
      {
        bs.a(paramaw, localay1, paramShort);
        paramay = paramaw.b("dl");
        localay1.d(paramay);
        break label28;
        if (localay1.m == localay2.m)
        {
          paramaw.I.a(paramaw, paramay, localay1, 7);
          paramaw.h();
          ay.a(paramaw, paramay);
          break;
        }
        localay2 = localay2.a;
        break label212;
        label314: ay.b(paramay, localay1);
        ay.a(paramay);
      }
      label328: if ((localay1.m != localdj.v) && (localay1.m != localdj.w))
      {
        paramaw.h();
        if ((0x18 & localay1.m.c) == 0)
        {
          paramaw.I.a(paramaw, paramay, localay1, 11);
          ay.a(paramaw, paramay);
          break;
        }
        if (((0x10 & localay1.m.c) == 0) && (paramaw.n))
        {
          ay.a(paramaw, paramay);
          break;
        }
        localay1 = paramaw.b("dd");
        paramaw.I.a(paramaw, paramay, localay1, 12);
      }
      if (localay1.h == 6)
      {
        paramaw.I.a(paramaw, paramay, localay1, 8);
        continue;
      }
      paramay.c(localay1);
      bs.a(paramaw, localay1, 0);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.bw
 * JD-Core Version:    0.6.0
 */