package a.a.a;

public class dh
  implements ct
{
  public void a(aw paramaw, ay paramay)
  {
    int i = 0;
    for (b localb1 = paramay.o; ; localb1 = localb1.a)
    {
      if (localb1 == null)
      {
        if ((i == 0) && (paramaw.r != 1) && (paramaw.r != 2))
          paramaw.c = (0x4 | paramaw.c);
        if (paramaw.F.p)
        {
          b localb3 = paramay.a("border");
          if ((localb3 != null) && (localb3.g == null))
            localb3.g = "1";
        }
        b localb2 = paramay.a("height");
        if (localb2 != null)
        {
          paramaw.I.a(paramaw, paramay, localb2, 53);
          paramaw.q = (0x1C0 & paramaw.q);
        }
        return;
      }
      if (localb1.b(paramaw, paramay) != y.e)
        continue;
      i = 1;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.dh
 * JD-Core Version:    0.6.0
 */