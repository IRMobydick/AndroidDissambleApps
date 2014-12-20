package a.a.a;

import java.util.Stack;

public class ck
  implements br
{
  public void a(aw paramaw, ay paramay, short paramShort)
  {
    dj localdj = paramaw.F.ap;
    paramaw.m();
    int i = paramaw.D;
    paramaw.D = paramaw.C.size();
    while (true)
    {
      ay localay1 = paramaw.b(0);
      if (localay1 == null)
      {
        paramaw.I.a(paramaw, paramay, localay1, 6);
        ay.a(paramaw, paramay);
        paramaw.D = i;
      }
      while (true)
      {
        return;
        if ((localay1.m != paramay.m) || (localay1.h != 6))
          break;
        paramaw.D = i;
        paramay.i = true;
        ay.a(paramaw, paramay);
      }
      if (ay.c(paramay, localay1))
        continue;
      if ((localay1.m == null) && (localay1.h != 4))
      {
        paramaw.I.a(paramaw, paramay, localay1, 8);
        continue;
      }
      if (localay1.h != 6)
      {
        if ((localay1.m != localdj.y) && (localay1.m != localdj.z) && (localay1.m != localdj.ab))
          break label289;
        paramaw.h();
        localay1 = paramaw.b("tr");
        paramaw.I.a(paramaw, paramay, localay1, 12);
      }
      label289: 
      do
      {
        if (localay1.h != 6)
          break label455;
        if ((localay1.m != localdj.ad) && ((localay1.m == null) || ((0x18 & localay1.m.c) == 0)))
          break label383;
        bs.c(paramaw);
        paramaw.I.a(paramaw, paramay, localay1, 8);
        break;
        if ((localay1.h != 4) && ((0x18 & localay1.m.c) == 0))
          continue;
        ay.b(paramay, localay1);
        paramaw.I.a(paramaw, paramay, localay1, 11);
        paramaw.o = true;
        if (localay1.h != 4)
          bs.a(paramaw, localay1, 0);
        paramaw.o = false;
        break;
      }
      while ((0x4 & localay1.m.c) == 0);
      bs.a(paramaw, paramay, localay1);
      continue;
      label383: if (((localay1.m != null) && ((0x280 & localay1.m.c) != 0)) || ((localay1.m != null) && ((0x18 & localay1.m.c) != 0)))
      {
        paramaw.I.a(paramaw, paramay, localay1, 8);
        continue;
      }
      for (ay localay2 = paramay.a; ; localay2 = localay2.a)
      {
        if (localay2 == null)
        {
          label455: if ((0x80 & localay1.m.c) != 0)
            break label555;
          paramaw.h();
          paramaw.I.a(paramaw, paramay, localay1, 11);
          paramaw.D = i;
          ay.a(paramaw, paramay);
          break;
        }
        if (localay1.m != localay2.m)
          continue;
        paramaw.I.a(paramaw, paramay, localay1, 7);
        paramaw.h();
        paramaw.D = i;
        ay.a(paramaw, paramay);
        break;
      }
      label555: if ((localay1.h == 5) || (localay1.h == 7))
      {
        paramay.c(localay1);
        bs.a(paramaw, localay1, 0);
        continue;
      }
      paramaw.I.a(paramaw, paramay, localay1, 8);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.ck
 * JD-Core Version:    0.6.0
 */