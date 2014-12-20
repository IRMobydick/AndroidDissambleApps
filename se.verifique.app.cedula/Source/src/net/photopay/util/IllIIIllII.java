package net.photopay.util;

import java.util.Stack;

public final class IllIIIllII
{
  private static Stack llIIlIlIIl = new Stack();

  public static long llIIlIlIIl()
  {
    long l;
    if (!llIIlIlIIl.isEmpty())
      l = System.currentTimeMillis() - ((Long)llIIlIlIIl.pop()).longValue();
    while (true)
    {
      return l;
      l = -1L;
    }
  }

  public static void start()
  {
    llIIlIlIIl.push(Long.valueOf(System.currentTimeMillis()));
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.util.IllIIIllII
 * JD-Core Version:    0.6.0
 */