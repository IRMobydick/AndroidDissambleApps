package a.a.a;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

public class ac extends ak
  implements Cloneable, Attr
{
  protected b a;

  protected ac(b paramb)
  {
    super(null);
    this.a = paramb;
  }

  public Node appendChild(Node paramNode)
  {
    throw new DOMException(7, "Not supported");
  }

  protected Object clone()
  {
    try
    {
      ac localac = (ac)super.clone();
      localac.a = ((b)this.a.clone());
      return localac;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
    }
    throw new RuntimeException("Clone not supported");
  }

  public Node cloneNode(boolean paramBoolean)
  {
    return (Node)clone();
  }

  public NamedNodeMap getAttributes()
  {
    return null;
  }

  public NodeList getChildNodes()
  {
    return new am(null);
  }

  public Node getFirstChild()
  {
    return null;
  }

  public Node getLastChild()
  {
    return null;
  }

  public String getName()
  {
    return this.a.f;
  }

  public Node getNextSibling()
  {
    return null;
  }

  public String getNodeName()
  {
    return getName();
  }

  public short getNodeType()
  {
    return 2;
  }

  public String getNodeValue()
  {
    return getValue();
  }

  public Document getOwnerDocument()
  {
    return null;
  }

  public Element getOwnerElement()
  {
    return null;
  }

  public Node getParentNode()
  {
    return null;
  }

  public Node getPreviousSibling()
  {
    return null;
  }

  public TypeInfo getSchemaTypeInfo()
  {
    return null;
  }

  public boolean getSpecified()
  {
    if (this.a.g != null);
    for (int i = 1; ; i = 0)
      return i;
  }

  public String getValue()
  {
    if (this.a.g == null);
    for (String str = this.a.f; ; str = this.a.g)
      return str;
  }

  public boolean hasChildNodes()
  {
    return false;
  }

  public Node insertBefore(Node paramNode1, Node paramNode2)
  {
    throw new DOMException(7, "Not supported");
  }

  public boolean isId()
  {
    return "id".equals(this.a.c());
  }

  public Node removeChild(Node paramNode)
  {
    throw new DOMException(7, "Not supported");
  }

  public Node replaceChild(Node paramNode1, Node paramNode2)
  {
    throw new DOMException(7, "Not supported");
  }

  public void setNodeValue(String paramString)
  {
    setValue(paramString);
  }

  public void setValue(String paramString)
  {
    this.a.g = paramString;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.ac
 * JD-Core Version:    0.6.0
 */