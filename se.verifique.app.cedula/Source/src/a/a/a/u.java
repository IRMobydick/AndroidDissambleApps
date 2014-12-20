package a.a.a;

public class u
  implements c
{
  public void a(aw paramaw, ay paramay, b paramb)
  {
    int i = 0;
    if (paramb.g == null)
    {
      paramaw.I.a(paramaw, paramay, paramb, 50);
      return;
    }
    String str1 = paramb.g;
    int j = 0;
    int k = 0;
    int m = 0;
    if (j >= str1.length())
    {
      if ((!paramaw.F.P) || (k == 0))
        break label360;
      paramb.g = paramb.g.replace('\\', '/');
    }
    label154: label330: label343: label345: label360: for (String str2 = paramb.g; ; str2 = str1)
    {
      StringBuffer localStringBuffer;
      if ((paramaw.F.ab) && (m != 0))
      {
        localStringBuffer = new StringBuffer();
        if (i >= str2.length())
          paramb.g = localStringBuffer.toString();
      }
      else
      {
        if (k != 0)
        {
          if (!paramaw.F.P)
            break label330;
          paramaw.I.a(paramaw, paramay, paramb, 62);
        }
        if (m == 0)
          break label343;
        if (!paramaw.F.ab)
          break label345;
        paramaw.I.a(paramaw, paramay, paramb, 64);
      }
      while (true)
      {
        paramaw.e = (0x51 | paramaw.e);
        break;
        int n = str1.charAt(j);
        if (n == 92)
          k = 1;
        while (true)
        {
          j++;
          break;
          if ((n <= 126) && (n > 32) && (n != 60) && (n != 62))
            continue;
          m = 1;
        }
        char c = str2.charAt(i);
        if ((c > '~') || (c <= ' ') || (c == '<') || (c == '>'))
        {
          localStringBuffer.append('%');
          localStringBuffer.append(Integer.toHexString(c).toUpperCase());
        }
        while (true)
        {
          i++;
          break;
          localStringBuffer.append(c);
        }
        paramaw.I.a(paramaw, paramay, paramb, 61);
        break label154;
        break;
        paramaw.I.a(paramaw, paramay, paramb, 63);
      }
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.u
 * JD-Core Version:    0.6.0
 */