package a.a.a;

public class bz
  implements br
{
  public void a(aw paramaw, ay paramay, short paramShort)
  {
    paramaw.F.o = false;
    paramaw.G = false;
    dj localdj = paramaw.F.ap;
    ay localay1 = paramaw.b(0);
    label42: Object localObject1;
    Object localObject2;
    if (localay1 == null)
    {
      localay1 = paramaw.b("head");
      paramay.c(localay1);
      bs.b.a(paramaw, localay1, paramShort);
      localObject1 = null;
      localObject2 = null;
    }
    label66: Object localObject3;
    while (true)
    {
      localObject3 = paramaw.b(0);
      if (localObject3 == null)
      {
        if (localObject1 == null)
        {
          ay localay4 = paramaw.b("body");
          paramay.c(localay4);
          bs.e.a(paramaw, localay4, paramShort);
        }
        label109: return;
        if (localay1.m == localdj.c)
          break label373;
        if ((localay1.m == paramay.m) && (localay1.h == 6))
        {
          paramaw.I.a(paramaw, paramay, localay1, 8);
          break;
        }
        if (ay.c(paramay, localay1))
          break;
        paramaw.h();
        localay1 = paramaw.b("head");
        break label42;
      }
      if (((ay)localObject3).m == paramay.m)
      {
        if ((((ay)localObject3).h != 5) && (localObject1 == null))
        {
          paramaw.I.a(paramaw, paramay, (ay)localObject3, 8);
          continue;
        }
        if (((ay)localObject3).h != 6)
          continue;
        paramaw.H = true;
        continue;
      }
      if (ay.c(paramay, (ay)localObject3))
        continue;
      if (((ay)localObject3).m != localdj.d)
        break label375;
      if (((ay)localObject3).h == 5)
        break label292;
      paramaw.I.a(paramaw, paramay, (ay)localObject3, 8);
    }
    label292: Object localObject7;
    if (localObject1 != null)
    {
      paramaw.h();
      if (localObject2 != null)
        break label779;
      localObject7 = paramaw.b("noframes");
      localObject1.c((ay)localObject7);
      paramaw.I.a(paramaw, paramay, (ay)localObject7, 15);
    }
    while (true)
    {
      bs.a(paramaw, (ay)localObject7, paramShort);
      localObject2 = localObject7;
      break label66;
      paramaw.c(-17);
      while (true)
      {
        label354: paramay.c((ay)localObject3);
        bs.a(paramaw, (ay)localObject3, paramShort);
        paramaw.H = true;
        break label109;
        label373: break;
        label375: if (((ay)localObject3).m == localdj.e)
        {
          if (((ay)localObject3).h != 5)
          {
            paramaw.I.a(paramaw, paramay, (ay)localObject3, 8);
            break label66;
          }
          ay localay3;
          Object localObject6;
          if (localObject1 != null)
          {
            paramaw.I.b(paramaw, paramay, (ay)localObject3, 18);
            paramay.c((ay)localObject3);
            bs.a(paramaw, (ay)localObject3, paramShort);
            ay localay2 = localObject1.p;
            Object localObject5 = localObject2;
            localay3 = localay2;
            localObject6 = localObject5;
          }
          while (true)
          {
            if (localay3 == null)
            {
              localObject2 = localObject6;
              break;
              localObject1 = localObject3;
              break label431;
            }
            if (localay3.m == localdj.h)
              localObject6 = localay3;
            localay3 = localay3.c;
          }
        }
        label431: if (((ay)localObject3).m != localdj.h)
          break label602;
        if (((ay)localObject3).h != 5)
        {
          paramaw.I.a(paramaw, paramay, (ay)localObject3, 8);
          break label66;
        }
        if (localObject1 != null)
          break label576;
        paramaw.I.a(paramaw, paramay, (ay)localObject3, 8);
        localObject3 = paramaw.b("body");
      }
      label576: if (localObject2 == null)
        localObject1.c((ay)localObject3);
      while (true)
      {
        bs.a(paramaw, (ay)localObject3, paramShort);
        localObject2 = localObject3;
        break;
        label602: if ((((ay)localObject3).h == 5) || (((ay)localObject3).h == 7))
        {
          if ((((ay)localObject3).m != null) && ((0x4 & ((ay)localObject3).m.c) != 0))
          {
            bs.a(paramaw, paramay, (ay)localObject3);
            break;
          }
          if ((localObject1 != null) && (((ay)localObject3).m == localdj.f))
          {
            paramaw.I.a(paramaw, paramay, (ay)localObject3, 8);
            break;
          }
        }
        paramaw.h();
        if (localObject1 != null)
        {
          Object localObject4;
          if (localObject2 == null)
          {
            localObject4 = paramaw.b("noframes");
            localObject1.c((ay)localObject4);
          }
          while (true)
          {
            paramaw.c(16);
            bs.a(paramaw, (ay)localObject4, paramShort);
            localObject2 = localObject4;
            break;
            paramaw.I.a(paramaw, paramay, (ay)localObject3, 26);
            localObject4 = localObject2;
          }
        }
        localObject3 = paramaw.b("body");
        paramaw.c(-17);
        break label354;
        localObject3 = localObject2;
      }
      label779: localObject7 = localObject2;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.bz
 * JD-Core Version:    0.6.0
 */