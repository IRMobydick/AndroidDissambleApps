package a.a.a;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class ad
  implements NamedNodeMap
{
  private b a;

  protected ad(b paramb)
  {
    this.a = paramb;
  }

  public int getLength()
  {
    int i = 0;
    for (b localb = this.a; ; localb = localb.a)
    {
      if (localb == null)
        return i;
      i++;
    }
  }

  public Node getNamedItem(String paramString)
  {
    b localb = this.a;
    if (localb == null)
      label9: if (localb == null)
        break label39;
    label39: for (Attr localAttr = localb.b(); ; localAttr = null)
    {
      return localAttr;
      if (localb.f.equals(paramString))
        break label9;
      localb = localb.a;
      break;
    }
  }

  public Node getNamedItemNS(String paramString1, String paramString2)
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public Node item(int paramInt)
  {
    int i = 0;
    b localb = this.a;
    if (localb == null)
      label11: if (localb == null)
        break label40;
    label40: for (Attr localAttr = localb.b(); ; localAttr = null)
    {
      return localAttr;
      if (i >= paramInt)
        break label11;
      i++;
      localb = localb.a;
      break;
    }
  }

  public Node removeNamedItem(String paramString)
  {
    Object localObject1 = this.a;
    Object localObject3;
    for (Object localObject2 = null; ; localObject2 = localObject3)
    {
      if (localObject1 == null);
      while (true)
      {
        if (localObject1 == null)
          break label75;
        return ((b)localObject1).b();
        if (!((b)localObject1).f.equals(paramString))
          break;
        if (localObject2 == null)
        {
          this.a = ((b)localObject1).d();
          continue;
        }
        localObject2.a(((b)localObject1).d());
      }
      b localb = ((b)localObject1).a;
      localObject3 = localObject1;
      localObject1 = localb;
    }
    label75: throw new DOMException(8, "Named item " + paramString + "Not found");
  }

  public Node removeNamedItemNS(String paramString1, String paramString2)
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public Node setNamedItem(Node paramNode)
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public Node setNamedItemNS(Node paramNode)
  {
    throw new DOMException(9, "DOM method not supported");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.ad
 * JD-Core Version:    0.6.0
 */