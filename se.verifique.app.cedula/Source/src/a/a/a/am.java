package a.a.a;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class am
  implements NodeList
{
  private ay a;

  protected am(ay paramay)
  {
    this.a = paramay;
  }

  public int getLength()
  {
    int i = 0;
    if (this.a == null);
    while (true)
    {
      return i;
      ay localay = this.a.p;
      while (localay != null)
      {
        int j = i + 1;
        localay = localay.c;
        i = j;
      }
    }
  }

  public Node item(int paramInt)
  {
    Node localNode = null;
    label9: int i;
    if (this.a == null)
    {
      break label27;
      return localNode;
    }
    else
    {
      i = 0;
    }
    for (ay localay = this.a.p; ; localay = localay.c)
    {
      if (localay == null)
      {
        label27: if (localay == null)
          break label9;
        localNode = localay.g();
        break label9;
      }
      if (i >= paramInt)
        break;
      i++;
    }
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.am
 * JD-Core Version:    0.6.0
 */