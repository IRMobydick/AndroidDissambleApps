package a.a.a;

public class cl
  implements br
{
  public void a(aw paramaw, ay paramay, short paramShort)
  {
    dj localdj = paramaw.F.ap;
    paramaw.B = -1;
    short s;
    ay localay;
    if (paramay.m == localdj.ae)
    {
      s = 2;
      localay = paramaw.b(s);
      if (localay != null)
        break label76;
      if ((0x8000 & paramay.m.c) == 0)
        paramaw.I.a(paramaw, paramay, localay, 6);
    }
    while (true)
    {
      return;
      s = 1;
      break;
      label76: if ((localay.m == paramay.m) && (localay.h == 6))
      {
        paramay.i = true;
        ay.c(paramaw, paramay);
        continue;
      }
      if (ay.c(paramay, localay))
        break;
      if (localay.h == 4)
      {
        if ((paramay.p == null) && ((s & 0x2) == 0))
          ay.c(paramaw, paramay);
        if (localay.e >= localay.f)
          break;
        paramay.c(localay);
        break;
      }
      if ((localay.m != null) && ((0x10 & localay.m.c) != 0) && ((0x400 & localay.m.c) == 0))
      {
        paramaw.I.a(paramaw, paramay, localay, 8);
        break;
      }
      if ((0x8000 & paramay.m.c) == 0)
        paramaw.I.a(paramaw, paramay, localay, 7);
      paramaw.h();
      ay.c(paramaw, paramay);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.cl
 * JD-Core Version:    0.6.0
 */