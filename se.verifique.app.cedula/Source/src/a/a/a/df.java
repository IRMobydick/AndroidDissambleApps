package a.a.a;

public class df
  implements ct
{
  public void a(aw paramaw, ay paramay)
  {
    paramay.a(paramaw);
    b localb1 = paramay.a("language");
    String str;
    if (paramay.a("type") == null)
    {
      b localb2 = new b(null, null, 34, "type", "");
      paramaw.I.a(paramaw, paramay, localb2, 49);
      if (localb1 == null)
        break label111;
      str = localb1.g;
      if ((!"javascript".equalsIgnoreCase(str)) && (!"jscript".equalsIgnoreCase(str)))
        break label90;
      paramay.a("type", "text/javascript");
    }
    while (true)
    {
      return;
      label90: if ("vbscript".equalsIgnoreCase(str))
      {
        paramay.a("type", "text/vbscript");
        continue;
        label111: paramay.a("type", "text/javascript");
        continue;
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.df
 * JD-Core Version:    0.6.0
 */