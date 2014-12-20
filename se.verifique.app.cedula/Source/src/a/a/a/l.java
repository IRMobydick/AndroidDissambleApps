package a.a.a;

public class l
  implements c
{
  public void a(aw paramaw, ay paramay, b paramb)
  {
    if (paramb.g == null)
      paramaw.I.a(paramaw, paramay, paramb, 50);
    label221: 
    while (true)
    {
      return;
      String str;
      dj localdj;
      if ((!"width".equalsIgnoreCase(paramb.f)) || ((paramay.m != paramaw.F.ap.B) && (paramay.m != paramaw.F.ap.C)))
      {
        str = paramb.g;
        if ((str.length() == 0) || ((!Character.isDigit(str.charAt(0))) && ('%' != str.charAt(0))))
        {
          paramaw.I.a(paramaw, paramay, paramb, 51);
          continue;
        }
        localdj = paramaw.F.ap;
      }
      for (int i = 1; ; i++)
      {
        if (i >= str.length())
          break label221;
        if (((Character.isDigit(str.charAt(i))) || ((paramay.m != localdj.y) && (paramay.m != localdj.z))) && ((Character.isDigit(str.charAt(i))) || (str.charAt(i) == '%')))
          continue;
        paramaw.I.a(paramaw, paramay, paramb, 51);
        break;
        break;
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.l
 * JD-Core Version:    0.6.0
 */