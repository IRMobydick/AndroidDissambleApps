package a.a.a;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

public class ak
  implements Node
{
  protected ay b;

  protected ak(ay paramay)
  {
    this.b = paramay;
  }

  public Node appendChild(Node paramNode)
  {
    if (paramNode == null)
      paramNode = null;
    while (true)
    {
      return paramNode;
      if (!(paramNode instanceof ak))
        throw new DOMException(4, "newChild not instanceof DOMNodeImpl");
      ak localak = (ak)paramNode;
      if (this.b.h == 0)
      {
        if ((localak.b.h != 1) && (localak.b.h != 3))
          throw new DOMException(3, "newChild cannot be a child of this node");
      }
      else if ((this.b.h == 5) && (localak.b.h != 5) && (localak.b.h != 7) && (localak.b.h != 2) && (localak.b.h != 4) && (localak.b.h != 8))
        throw new DOMException(3, "newChild cannot be a child of this node");
      this.b.c(localak.b);
      if (this.b.h != 7)
        continue;
      this.b.a(5);
    }
  }

  public Node cloneNode(boolean paramBoolean)
  {
    ay localay = this.b.a(paramBoolean);
    localay.a = null;
    return localay.g();
  }

  public short compareDocumentPosition(Node paramNode)
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public NamedNodeMap getAttributes()
  {
    return new ad(this.b.o);
  }

  public String getBaseURI()
  {
    return null;
  }

  public NodeList getChildNodes()
  {
    return new am(this.b);
  }

  public Object getFeature(String paramString1, String paramString2)
  {
    return null;
  }

  public Node getFirstChild()
  {
    if (this.b.p != null);
    for (Node localNode = this.b.p.g(); ; localNode = null)
      return localNode;
  }

  public Node getLastChild()
  {
    if (this.b.d != null);
    for (Node localNode = this.b.d.g(); ; localNode = null)
      return localNode;
  }

  public String getLocalName()
  {
    return getNodeName();
  }

  public String getNamespaceURI()
  {
    return null;
  }

  public Node getNextSibling()
  {
    if (this.b.c != null);
    for (Node localNode = this.b.c.g(); ; localNode = null)
      return localNode;
  }

  public String getNodeName()
  {
    return this.b.n;
  }

  public short getNodeType()
  {
    int i = -1;
    switch (this.b.h)
    {
    case 6:
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 8:
    case 5:
    case 7:
    }
    while (true)
    {
      return i;
      i = 9;
      continue;
      i = 10;
      continue;
      i = 8;
      continue;
      i = 7;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 1;
    }
  }

  public String getNodeValue()
  {
    String str = "";
    if (((this.b.h == 4) || (this.b.h == 8) || (this.b.h == 2) || (this.b.h == 3)) && (this.b.g != null) && (this.b.e < this.b.f))
      str = do.a(this.b.g, this.b.e, this.b.f - this.b.e);
    return str;
  }

  public Document getOwnerDocument()
  {
    Document localDocument = null;
    ay localay = this.b;
    if ((localay != null) && (localay.h == 0));
    while (true)
    {
      return localDocument;
      do
        localay = localay.a;
      while ((localay != null) && (localay.h != 0));
      if (localay == null)
        continue;
      localDocument = (Document)localay.g();
    }
  }

  public Node getParentNode()
  {
    if (this.b.a != null);
    for (Node localNode = this.b.a.g(); ; localNode = null)
      return localNode;
  }

  public String getPrefix()
  {
    return null;
  }

  public Node getPreviousSibling()
  {
    if (this.b.b != null);
    for (Node localNode = this.b.b.g(); ; localNode = null)
      return localNode;
  }

  public String getTextContent()
  {
    return null;
  }

  public Object getUserData(String paramString)
  {
    return null;
  }

  public boolean hasAttributes()
  {
    if (this.b.o != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean hasChildNodes()
  {
    if (this.b.p != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public Node insertBefore(Node paramNode1, Node paramNode2)
  {
    if (paramNode1 == null)
      paramNode1 = null;
    while (true)
    {
      return paramNode1;
      if (!(paramNode1 instanceof ak))
        throw new DOMException(4, "newChild not instanceof DOMNodeImpl");
      ak localak = (ak)paramNode1;
      if (this.b.h == 0)
      {
        if ((localak.b.h != 1) && (localak.b.h != 3))
          throw new DOMException(3, "newChild cannot be a child of this node");
      }
      else if ((this.b.h == 5) && (localak.b.h != 5) && (localak.b.h != 7) && (localak.b.h != 2) && (localak.b.h != 4) && (localak.b.h != 8))
        throw new DOMException(3, "newChild cannot be a child of this node");
      if (paramNode2 == null)
      {
        this.b.c(localak.b);
        if (this.b.h != 7)
          continue;
        this.b.a(5);
        continue;
      }
      for (ay localay = this.b.p; ; localay = localay.c)
      {
        if (localay == null);
        do
        {
          if (localay != null)
            break;
          throw new DOMException(8, "refChild not found");
        }
        while (localay.g() == paramNode2);
      }
      ay.b(localay, localak.b);
    }
  }

  public boolean isDefaultNamespace(String paramString)
  {
    return false;
  }

  public boolean isEqualNode(Node paramNode)
  {
    return false;
  }

  public boolean isSameNode(Node paramNode)
  {
    return false;
  }

  public boolean isSupported(String paramString1, String paramString2)
  {
    return false;
  }

  public String lookupNamespaceURI(String paramString)
  {
    return null;
  }

  public String lookupPrefix(String paramString)
  {
    return null;
  }

  public void normalize()
  {
  }

  public Node removeChild(Node paramNode)
  {
    if (paramNode == null)
      paramNode = null;
    while (true)
    {
      return paramNode;
      for (ay localay = this.b.p; ; localay = localay.c)
      {
        if (localay == null);
        do
        {
          if (localay != null)
            break;
          throw new DOMException(8, "refChild not found");
        }
        while (localay.g() == paramNode);
      }
      ay.a(localay);
      if ((this.b.p != null) || (this.b.h != 5))
        continue;
      this.b.a(7);
    }
  }

  public Node replaceChild(Node paramNode1, Node paramNode2)
  {
    if (paramNode1 == null)
      paramNode2 = null;
    while (true)
    {
      return paramNode2;
      if (!(paramNode1 instanceof ak))
        throw new DOMException(4, "newChild not instanceof DOMNodeImpl");
      ak localak = (ak)paramNode1;
      if (this.b.h == 0)
      {
        if ((localak.b.h != 1) && (localak.b.h != 3))
          throw new DOMException(3, "newChild cannot be a child of this node");
      }
      else if ((this.b.h == 5) && (localak.b.h != 5) && (localak.b.h != 7) && (localak.b.h != 2) && (localak.b.h != 4) && (localak.b.h != 8))
        throw new DOMException(3, "newChild cannot be a child of this node");
      if (paramNode2 == null)
        throw new DOMException(8, "oldChild not found");
      for (ay localay1 = this.b.p; ; localay1 = localay1.c)
      {
        if (localay1 == null);
        do
        {
          if (localay1 != null)
            break;
          throw new DOMException(8, "oldChild not found");
        }
        while (localay1.g() == paramNode2);
      }
      localak.b.c = localay1.c;
      localak.b.b = localay1.b;
      localak.b.d = localay1.d;
      localak.b.a = localay1.a;
      localak.b.p = localay1.p;
      if (localay1.a != null)
      {
        if (localay1.a.p == localay1)
          localay1.a.p = localak.b;
        if (localay1.a.d == localay1)
          localay1.a.d = localak.b;
      }
      if (localay1.b != null)
        localay1.b.c = localak.b;
      if (localay1.c != null)
        localay1.c.b = localak.b;
      for (ay localay2 = localay1.p; localay2 != null; localay2 = localay2.c)
      {
        if (localay2.a != localay1)
          continue;
        localay2.a = localak.b;
      }
    }
  }

  public void setNodeValue(String paramString)
  {
    if ((this.b.h == 4) || (this.b.h == 8) || (this.b.h == 2) || (this.b.h == 3))
    {
      byte[] arrayOfByte = do.a(paramString);
      this.b.g = arrayOfByte;
      this.b.e = 0;
      this.b.f = arrayOfByte.length;
    }
  }

  public void setPrefix(String paramString)
  {
  }

  public void setTextContent(String paramString)
  {
    throw new DOMException(7, "Node is read only");
  }

  public Object setUserData(String paramString, Object paramObject, UserDataHandler paramUserDataHandler)
  {
    return null;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.ak
 * JD-Core Version:    0.6.0
 */