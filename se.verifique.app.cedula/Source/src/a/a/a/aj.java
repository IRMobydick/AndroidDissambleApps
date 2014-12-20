package a.a.a;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

public class aj extends ak
  implements Element
{
  protected aj(ay paramay)
  {
    super(paramay);
  }

  public String getAttribute(String paramString)
  {
    String str;
    if (this.b == null)
      str = null;
    while (true)
    {
      return str;
      for (b localb = this.b.o; ; localb = localb.a)
      {
        if (localb == null);
        do
        {
          if (localb == null)
            break label54;
          str = localb.g;
          break;
        }
        while (localb.f.equals(paramString));
      }
      label54: str = "";
    }
  }

  public String getAttributeNS(String paramString1, String paramString2)
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public Attr getAttributeNode(String paramString)
  {
    Attr localAttr = null;
    if (this.b == null)
    {
      break label23;
      label9: return localAttr;
    }
    for (b localb = this.b.o; ; localb = localb.a)
    {
      if (localb == null)
      {
        label23: if (localb == null)
          break label9;
        localAttr = localb.b();
        break label9;
      }
      if (localb.f.equals(paramString))
        break;
    }
  }

  public Attr getAttributeNodeNS(String paramString1, String paramString2)
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public NodeList getElementsByTagName(String paramString)
  {
    return new al(this.b, paramString);
  }

  public NodeList getElementsByTagNameNS(String paramString1, String paramString2)
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public short getNodeType()
  {
    return 1;
  }

  public TypeInfo getSchemaTypeInfo()
  {
    return null;
  }

  public String getTagName()
  {
    return super.getNodeName();
  }

  public boolean hasAttribute(String paramString)
  {
    return false;
  }

  public boolean hasAttributeNS(String paramString1, String paramString2)
  {
    return false;
  }

  public void normalize()
  {
  }

  public void removeAttribute(String paramString)
  {
    if (this.b == null)
      return;
    while (true)
    {
      label7: Object localObject1 = this.b.o;
      Object localObject3;
      for (Object localObject2 = null; ; localObject2 = localObject3)
      {
        if (localObject1 == null)
        {
          if (localObject1 == null)
            break label7;
          if (localObject2 != null)
            break label73;
          this.b.o = ((b)localObject1).a;
          break label7;
        }
        if (((b)localObject1).f.equals(paramString))
          break;
        b localb = ((b)localObject1).a;
        localObject3 = localObject1;
        localObject1 = localb;
      }
      label73: localObject2.a = ((b)localObject1).a;
    }
  }

  public void removeAttributeNS(String paramString1, String paramString2)
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public Attr removeAttributeNode(Attr paramAttr)
  {
    Object localObject1 = null;
    if (paramAttr == null)
      paramAttr = null;
    while (true)
    {
      return paramAttr;
      Object localObject2 = this.b.o;
      while (true)
      {
        if (localObject2 == null);
        do
        {
          if (localObject2 == null)
            break label81;
          if (localObject1 != null)
            break label70;
          this.b.o = ((b)localObject2).a;
          break;
        }
        while (((b)localObject2).b() == paramAttr);
        b localb = ((b)localObject2).a;
        Object localObject3 = localObject2;
        localObject2 = localb;
        localObject1 = localObject3;
      }
      label70: localObject1.a = ((b)localObject2).a;
    }
    label81: throw new DOMException(8, "oldAttr not found");
  }

  public void setAttribute(String paramString1, String paramString2)
  {
    if (this.b == null);
    while (true)
    {
      return;
      for (b localb1 = this.b.o; ; localb1 = localb1.a)
      {
        if (localb1 == null);
        do
        {
          if (localb1 == null)
            break label51;
          localb1.g = paramString2;
          break;
        }
        while (localb1.f.equals(paramString1));
      }
      label51: b localb2 = new b(null, null, 34, paramString1, paramString2);
      localb2.b = y.a().a(localb2);
      if (this.b.o == null)
      {
        this.b.o = localb2;
        continue;
      }
      localb2.a = this.b.o;
      this.b.o = localb2;
    }
  }

  public void setAttributeNS(String paramString1, String paramString2, String paramString3)
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public Attr setAttributeNode(Attr paramAttr)
  {
    Object localObject = null;
    if (paramAttr == null)
      return localObject;
    if (!(paramAttr instanceof ac))
      throw new DOMException(4, "newAttr not instanceof DOMAttrImpl");
    ac localac = (ac)paramAttr;
    String str = localac.a.f;
    b localb = this.b.o;
    label49: label54: Attr localAttr;
    if (localb == null)
    {
      if (localb == null)
        break label101;
      localAttr = localb.b();
      localb.h = paramAttr;
    }
    while (true)
    {
      localObject = localAttr;
      break;
      if (localb.f.equals(str))
        break label54;
      localb = localb.a;
      break label49;
      label101: if (this.b.o == null)
      {
        this.b.o = localac.a;
        localAttr = null;
        continue;
      }
      localac.a.a = this.b.o;
      this.b.o = localac.a;
      localAttr = null;
    }
  }

  public Attr setAttributeNodeNS(Attr paramAttr)
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public void setIdAttribute(String paramString, boolean paramBoolean)
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public void setIdAttributeNS(String paramString1, String paramString2, boolean paramBoolean)
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public void setIdAttributeNode(Attr paramAttr, boolean paramBoolean)
  {
    throw new DOMException(9, "DOM method not supported");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.aj
 * JD-Core Version:    0.6.0
 */