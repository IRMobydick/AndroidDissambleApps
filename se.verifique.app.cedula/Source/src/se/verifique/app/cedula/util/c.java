package se.verifique.app.cedula.util;

public class c
{
  private static b a;

  public static void a()
  {
    a = new d();
  }

  public static b b()
  {
    if (a == null)
      a();
    return a;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.util.c
 * JD-Core Version:    0.6.0
 */