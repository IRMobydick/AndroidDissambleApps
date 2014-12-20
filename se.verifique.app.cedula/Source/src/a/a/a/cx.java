package a.a.a;

public class cx
  implements ct
{
  public void a(aw paramaw, ay paramay)
  {
    String str = null;
    paramay.a(paramaw);
    b localb = paramay.o;
    if (localb == null)
      label18: if (str != null)
      {
        if ((!"left".equalsIgnoreCase(str)) && (!"right".equalsIgnoreCase(str)))
          break label79;
        paramaw.c(8);
      }
    while (true)
    {
      return;
      if ("align".equalsIgnoreCase(localb.f))
      {
        str = localb.g;
        break label18;
      }
      localb = localb.a;
      break;
      label79: if (("top".equalsIgnoreCase(str)) || ("bottom".equalsIgnoreCase(str)))
      {
        paramaw.c(-4);
        continue;
      }
      paramaw.I.a(paramaw, paramay, localb, 51);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.cx
 * JD-Core Version:    0.6.0
 */