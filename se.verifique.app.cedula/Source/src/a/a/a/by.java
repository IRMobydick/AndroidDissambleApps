package a.a.a;

public class by
  implements br
{
  public void a(aw paramaw, ay paramay, short paramShort)
  {
    dj localdj = paramaw.F.ap;
    paramaw.c = (0x10 | paramaw.c);
    while (true)
    {
      ay localay = paramaw.b(0);
      if (localay == null)
        paramaw.I.a(paramaw, paramay, localay, 6);
      while (true)
      {
        return;
        if ((localay.m != paramay.m) || (localay.h != 6))
          break;
        paramay.i = true;
        ay.c(paramaw, paramay);
      }
      if (ay.c(paramay, localay))
        continue;
      if (localay.m == null)
      {
        paramaw.I.a(paramaw, paramay, localay, 8);
        continue;
      }
      if (((localay.h == 5) || (localay.h == 7)) && (localay.m != null) && ((0x4 & localay.m.c) != 0))
      {
        bs.a(paramaw, paramay, localay);
        continue;
      }
      if (localay.m == localdj.d)
      {
        paramaw.h();
        localay = paramaw.b("noframes");
        paramaw.I.a(paramaw, paramay, localay, 15);
      }
      if ((localay.h == 5) && ((0x2000 & localay.m.c) != 0))
      {
        paramay.c(localay);
        paramaw.n = false;
        bs.a(paramaw, localay, 1);
        continue;
      }
      if ((localay.h == 7) && ((0x2000 & localay.m.c) != 0))
      {
        paramay.c(localay);
        continue;
      }
      paramaw.I.a(paramaw, paramay, localay, 8);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.by
 * JD-Core Version:    0.6.0
 */