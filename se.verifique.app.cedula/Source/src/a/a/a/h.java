package a.a.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class h
  implements c
{
  private static final Map a = new HashMap();

  static
  {
    a.put("black", "#000000");
    a.put("green", "#008000");
    a.put("silver", "#C0C0C0");
    a.put("lime", "#00FF00");
    a.put("gray", "#808080");
    a.put("olive", "#808000");
    a.put("white", "#FFFFFF");
    a.put("yellow", "#FFFF00");
    a.put("maroon", "#800000");
    a.put("navy", "#000080");
    a.put("red", "#FF0000");
    a.put("blue", "#0000FF");
    a.put("purple", "#800080");
    a.put("teal", "#008080");
    a.put("fuchsia", "#FF00FF");
    a.put("aqua", "#00FFFF");
  }

  public void a(aw paramaw, ay paramay, b paramb)
  {
    if ((paramb.g == null) || (paramb.g.length() == 0))
      paramaw.I.a(paramaw, paramay, paramb, 50);
    while (true)
    {
      return;
      String str = paramb.g;
      Iterator localIterator = a.entrySet().iterator();
      label51: int i;
      int j;
      if (!localIterator.hasNext())
      {
        i = 0;
        j = 0;
        label67: if ((i != 0) || (j != 0))
          break label315;
        if (str.charAt(0) != '#')
          break label374;
      }
      label315: label366: label368: for (int k = 1; ; k++)
      {
        if (k >= 7);
        while (true)
        {
          if (j != 0)
            break label366;
          for (int m = 1; m < 7; m++)
            paramb.g = str.toUpperCase();
          break;
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (str.charAt(0) == '#')
          {
            if (str.length() != 7)
            {
              paramaw.I.a(paramaw, paramay, paramb, 51);
              i = 0;
              j = 1;
              break label67;
            }
            if (!str.equalsIgnoreCase((String)localEntry.getValue()))
              break label51;
            if (paramaw.F.ad)
              paramb.g = ((String)localEntry.getKey());
            i = 1;
            j = 0;
            break label67;
          }
          if (do.e(str.charAt(0)))
          {
            if (!str.equalsIgnoreCase((String)localEntry.getKey()))
              break label51;
            if (paramaw.F.ad)
              paramb.g = ((String)localEntry.getKey());
            i = 1;
            j = 0;
            break label67;
          }
          paramaw.I.a(paramaw, paramay, paramb, 51);
          i = 0;
          j = 1;
          break label67;
          break;
          if ((do.d(str.charAt(k))) || ("abcdef".indexOf(Character.toLowerCase(str.charAt(k))) != -1))
            break label368;
          paramaw.I.a(paramaw, paramay, paramb, 51);
          j = 1;
        }
        break;
      }
      label374: paramaw.I.a(paramaw, paramay, paramb, 51);
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.h
 * JD-Core Version:    0.6.0
 */