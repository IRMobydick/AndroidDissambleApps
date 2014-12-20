package a.a.a;

public class s
  implements c
{
  private static final String[] a;

  static
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "_blank";
    arrayOfString[1] = "_self";
    arrayOfString[2] = "_parent";
    arrayOfString[3] = "_top";
    a = arrayOfString;
  }

  public void a(aw paramaw, ay paramay, b paramb)
  {
    paramaw.c(-5);
    if ((paramb.g == null) || (paramb.g.length() == 0))
      paramaw.I.a(paramaw, paramay, paramb, 50);
    while (true)
    {
      return;
      String str = paramb.g;
      if ((Character.isLetter(str.charAt(0))) || (do.a(a, str)))
        continue;
      paramaw.I.a(paramaw, paramay, paramb, 51);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.s
 * JD-Core Version:    0.6.0
 */