package se.verifique.app.a;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.CredentialsProvider;
import se.verifique.app.cedula.util.f;

public class c
{
  public static b a;

  public static String a(String paramString1, int paramInt, List paramList, Map paramMap1, a parama, CredentialsProvider paramCredentialsProvider, Map paramMap2, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    a = new b(paramString1, paramInt, paramList, paramMap1, paramCredentialsProvider, paramMap2, paramBoolean1, paramString2, paramBoolean2);
    new Thread(a).start();
    int i = 0;
    String str;
    if ((a.a) || (i >= 300))
    {
      if (!a.a)
        break label133;
      if (a.b)
        break label126;
      if (parama != null)
        parama.a(a.d);
      str = a.c;
    }
    while (true)
    {
      while (true)
      {
        return str;
        try
        {
          Thread.sleep(500L);
          i++;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      break;
      label126: str = "ERROR";
      continue;
      label133: str = "VFQ-TO";
    }
  }

  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 1);
  }

  public static String a(String paramString1, String paramString2, int paramInt)
  {
    Matcher localMatcher = Pattern.compile(paramString2).matcher(paramString1);
    int i = 0;
    while (true)
    {
      if (!localMatcher.find());
      for (String str = ""; ; str = localMatcher.group(1))
      {
        return str;
        i++;
        if (i != paramInt)
          break;
      }
      System.out.println("VALOR " + i + " = " + localMatcher.group(1));
    }
  }

  public static String a(f paramf)
  {
    return a(paramf.i(), paramf.a(), paramf.b(), paramf.c(), paramf.j(), paramf.d(), paramf.e(), paramf.f(), paramf.g(), paramf.h());
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.a.c
 * JD-Core Version:    0.6.0
 */