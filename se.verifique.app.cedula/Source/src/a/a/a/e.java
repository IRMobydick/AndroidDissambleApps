package a.a.a;

public class e
  implements c
{
  private static final String[] a;

  static
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "left";
    arrayOfString[1] = "center";
    arrayOfString[2] = "right";
    arrayOfString[3] = "justify";
    a = arrayOfString;
  }

  public void a(aw paramaw, ay paramay, b paramb)
  {
    if ((paramay.m != null) && ((0x10000 & paramay.m.c) != 0))
      d.f.a(paramaw, paramay, paramb);
    while (true)
    {
      return;
      if (paramb.g == null)
      {
        paramaw.I.a(paramaw, paramay, paramb, 50);
        continue;
      }
      paramb.a(paramaw, paramay);
      if (do.a(a, paramb.g))
        continue;
      paramaw.I.a(paramaw, paramay, paramb, 51);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.e
 * JD-Core Version:    0.6.0
 */