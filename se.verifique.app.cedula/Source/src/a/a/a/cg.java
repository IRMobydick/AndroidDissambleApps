package a.a.a;

import java.util.Stack;

public class cg
  implements br
{
  public void a(aw paramaw, ay paramay, short paramShort)
  {
    dj localdj = paramaw.F.ap;
    label22: ay localay1;
    if ((0x1 & paramay.m.c) != 0)
      while (true)
      {
        return;
        if (localay1.m == paramay.m)
        {
          if (localay1.h == 6)
          {
            paramay.i = true;
            ay.d(paramaw, paramay);
            continue;
          }
          paramaw.h();
          ay.d(paramaw, paramay);
          continue;
        }
        if (localay1.h == 6)
        {
          if (((localay1.m != null) && ((0x82 & localay1.m.c) != 0)) || ((localay1.m == localdj.ab) && (paramay.a(localay1.m))))
          {
            paramaw.h();
            continue;
          }
          if ((localay1.m != localdj.ad) && ((localay1.m == null) || ((0x18 & localay1.m.c) == 0)))
            break;
          if (localay1.m == localdj.ad)
            bs.c(paramaw);
          paramaw.I.a(paramaw, paramay, localay1, 8);
        }
      }
    while (true)
    {
      label199: localay1 = paramaw.b(0);
      if (localay1 != null)
        break label22;
      ay.a(paramaw, paramay);
      break;
      if ((localay1.m == localdj.y) || (localay1.m == localdj.z))
      {
        paramaw.I.a(paramaw, paramay, localay1, 8);
        continue;
      }
      for (ay localay2 = paramay.a; ; localay2 = localay2.a)
      {
        if (localay2 == null)
        {
          if (ay.c(paramay, localay1))
            break label199;
          if ((localay1.m != null) || (localay1.h == 4))
            break label349;
          paramaw.I.a(paramaw, paramay, localay1, 8);
          break label199;
        }
        if (localay1.m != localay2.m)
          continue;
        paramaw.h();
        ay.a(paramaw, paramay);
        break;
      }
      label349: if (localay1.m == localdj.ab)
      {
        paramaw.I.a(paramaw, paramay, localay1, 8);
        continue;
      }
      if ((localay1.m != null) && ((0x100 & localay1.m.c) != 0))
      {
        paramaw.h();
        ay.a(paramaw, paramay);
        break;
      }
      if (localay1.h == 6)
      {
        paramaw.I.a(paramaw, paramay, localay1, 8);
        continue;
      }
      if (localay1.h != 6)
      {
        if (localay1.m != localdj.ad)
          break label529;
        paramaw.h();
        localay1 = paramaw.b("td");
        paramaw.I.a(paramaw, paramay, localay1, 12);
      }
      label529: 
      do
      {
        if ((localay1.m == localdj.y) || (localay1.m == localdj.z))
          break label638;
        paramaw.I.a(paramaw, paramay, localay1, 11);
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
      label638: paramay.c(localay1);
      boolean bool = paramaw.n;
      paramaw.n = false;
      bs.a(paramaw, localay1, 0);
      paramaw.n = bool;
      while (paramaw.C.size() > paramaw.D)
        paramaw.k(null);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.cg
 * JD-Core Version:    0.6.0
 */