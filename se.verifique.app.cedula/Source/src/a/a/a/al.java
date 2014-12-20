package a.a.a;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class al
  implements NodeList
{
  private ay a;
  private String b;
  private int c;
  private int d;
  private ay e;

  protected al(ay paramay, String paramString)
  {
    this.a = paramay;
    this.b = paramString;
  }

  protected void a(ay paramay)
  {
    if (paramay == null);
    while (true)
    {
      return;
      if (((paramay.h == 5) || (paramay.h == 7)) && (this.c <= this.d) && ((this.b.equals("*")) || (this.b.equals(paramay.n))))
      {
        this.c = (1 + this.c);
        this.e = paramay;
      }
      if (this.c > this.d)
        continue;
      for (ay localay = paramay.p; localay != null; localay = localay.c)
        a(localay);
    }
  }

  public int getLength()
  {
    this.c = 0;
    this.d = 2147483647;
    a(this.a);
    return this.c;
  }

  public Node item(int paramInt)
  {
    this.c = 0;
    this.d = paramInt;
    a(this.a);
    if ((this.c > this.d) && (this.e != null));
    for (Node localNode = this.e.g(); ; localNode = null)
      return localNode;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.al
 * JD-Core Version:    0.6.0
 */