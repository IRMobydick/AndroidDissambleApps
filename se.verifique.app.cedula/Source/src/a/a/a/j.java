package a.a.a;

public class j
  implements c
{
  public void a(aw paramaw, ay paramay, b paramb)
  {
    if ((paramb.g == null) || (paramb.g.length() == 0))
      paramaw.I.a(paramaw, paramay, paramb, 50);
    while (true)
    {
      return;
      String str = paramb.g;
      char c1 = str.charAt(0);
      if ((str.length() == 0) || (!Character.isLetter(str.charAt(0))))
        if ((paramaw.p) && ((do.a(c1)) || (c1 == '_') || (c1 == ':')))
          paramaw.I.a(paramaw, paramay, paramb, 71);
      label241: 
      while (true)
      {
        ay localay = paramaw.F.ap.b(paramb.g);
        if ((localay == null) || (localay == paramay))
          break label243;
        paramaw.I.a(paramaw, paramay, paramb, 66);
        break;
        paramaw.I.a(paramaw, paramay, paramb, 51);
        continue;
        for (int i = 1; ; i++)
        {
          if (i >= str.length())
            break label241;
          char c2 = str.charAt(i);
          if (do.f(c2))
            continue;
          if ((paramaw.p) && (do.b(c2)))
          {
            paramaw.I.a(paramaw, paramay, paramb, 71);
            break;
          }
          paramaw.I.a(paramaw, paramay, paramb, 51);
          break;
        }
      }
      label243: paramaw.F.ap.an = paramaw.F.ap.a(paramb.g, paramay);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.j
 * JD-Core Version:    0.6.0
 */