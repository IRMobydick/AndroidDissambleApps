package a.a.a;

public class w
  implements c
{
  private static final String[] a;
  private static final String[] b;
  private static final String[] c;

  static
  {
    String[] arrayOfString1 = new String[4];
    arrayOfString1[0] = "top";
    arrayOfString1[1] = "middle";
    arrayOfString1[2] = "bottom";
    arrayOfString1[3] = "baseline";
    a = arrayOfString1;
    String[] arrayOfString2 = new String[2];
    arrayOfString2[0] = "left";
    arrayOfString2[1] = "right";
    b = arrayOfString2;
    String[] arrayOfString3 = new String[4];
    arrayOfString3[0] = "texttop";
    arrayOfString3[1] = "absmiddle";
    arrayOfString3[2] = "absbottom";
    arrayOfString3[3] = "textbottom";
    c = arrayOfString3;
  }

  public void a(aw paramaw, ay paramay, b paramb)
  {
    if (paramb.g == null)
      paramaw.I.a(paramaw, paramay, paramb, 50);
    while (true)
    {
      return;
      paramb.a(paramaw, paramay);
      String str = paramb.g;
      if (do.a(a, str))
        continue;
      if (do.a(b, str))
      {
        if ((paramay.m != null) && ((0x10000 & paramay.m.c) != 0))
          continue;
        paramaw.I.a(paramaw, paramay, paramb, 51);
        continue;
      }
      if (do.a(c, str))
      {
        paramaw.c(448);
        paramaw.I.a(paramaw, paramay, paramb, 54);
        continue;
      }
      paramaw.I.a(paramaw, paramay, paramb, 51);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.w
 * JD-Core Version:    0.6.0
 */