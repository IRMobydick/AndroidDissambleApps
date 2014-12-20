package a.a.a;

public class db
  implements ct
{
  public void a(aw paramaw, ay paramay)
  {
    int i = 0;
    b localb1 = paramay.o;
    int j = 0;
    int k = 0;
    int m = 0;
    Object localObject = localb1;
    int n = 0;
    if (localObject == null)
    {
      if (n == 0)
      {
        paramaw.c = (0x1 | paramaw.c);
        b localb5 = new b(null, null, 34, "alt", "");
        paramaw.I.a(paramaw, paramay, localb5, 49);
        if (paramaw.F.f != null)
          paramay.a("alt", paramaw.F.f);
      }
      if ((m == 0) && (i == 0))
      {
        b localb4 = new b(null, null, 34, "src", "");
        paramaw.I.a(paramaw, paramay, localb4, 49);
      }
      if ((j != 0) && (k == 0))
      {
        b localb3 = new b(null, null, 34, "ismap", "");
        paramaw.I.a(paramaw, paramay, localb3, 56);
      }
      return;
    }
    x localx = ((b)localObject).b(paramaw, paramay);
    int i4;
    int i1;
    int i2;
    int i5;
    int i3;
    if (localx == y.f)
    {
      i4 = i;
      i1 = j;
      i2 = k;
      i5 = m;
      i3 = 1;
    }
    while (true)
    {
      b localb2 = ((b)localObject).a;
      m = i5;
      localObject = localb2;
      k = i2;
      i = i4;
      n = i3;
      j = i1;
      break;
      if (localx == y.b)
      {
        i1 = j;
        i2 = k;
        i3 = n;
        i4 = i;
        i5 = 1;
        continue;
      }
      if (localx == y.h)
      {
        i1 = j;
        i2 = 1;
        i3 = n;
        i4 = i;
        i5 = m;
        continue;
      }
      if (localx == y.i)
      {
        i1 = 1;
        i2 = k;
        i3 = n;
        i4 = i;
        i5 = m;
        continue;
      }
      if (localx == y.p)
      {
        i1 = j;
        i2 = k;
        i5 = m;
        i3 = n;
        i4 = 1;
        continue;
      }
      if ((localx == y.q) || (localx == y.r))
        paramaw.c(-2);
      i1 = j;
      i2 = k;
      i3 = n;
      i4 = i;
      i5 = m;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.db
 * JD-Core Version:    0.6.0
 */