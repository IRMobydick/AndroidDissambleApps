package a.a.a;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

public class ah extends ak
  implements Document
{
  private dj a = new dj();

  protected ah(ay paramay)
  {
    super(paramay);
  }

  public Node adoptNode(Node paramNode)
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public Attr createAttribute(String paramString)
  {
    Attr localAttr = null;
    b localb = new b(null, null, 34, paramString, null);
    if (localb != null)
    {
      localb.b = y.a().a(localb);
      localAttr = localb.b();
    }
    return localAttr;
  }

  public Attr createAttributeNS(String paramString1, String paramString2)
  {
    throw new DOMException(9, "createAttributeNS not supported");
  }

  public CDATASection createCDATASection(String paramString)
  {
    throw new DOMException(9, "HTML document");
  }

  public Comment createComment(String paramString)
  {
    byte[] arrayOfByte = do.a(paramString);
    ay localay = new ay(2, arrayOfByte, 0, arrayOfByte.length);
    if (localay != null);
    for (Comment localComment = (Comment)localay.g(); ; localComment = null)
      return localComment;
  }

  public DocumentFragment createDocumentFragment()
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public Element createElement(String paramString)
  {
    ay localay = new ay(7, null, 0, 0, paramString, this.a);
    if (localay != null)
      if (localay.m == null)
        localay.m = dj.a;
    for (Element localElement = (Element)localay.g(); ; localElement = null)
      return localElement;
  }

  public Element createElementNS(String paramString1, String paramString2)
  {
    throw new DOMException(9, "createElementNS not supported");
  }

  public EntityReference createEntityReference(String paramString)
  {
    throw new DOMException(9, "createEntityReference not supported");
  }

  public ProcessingInstruction createProcessingInstruction(String paramString1, String paramString2)
  {
    throw new DOMException(9, "HTML document");
  }

  public Text createTextNode(String paramString)
  {
    byte[] arrayOfByte = do.a(paramString);
    ay localay = new ay(4, arrayOfByte, 0, arrayOfByte.length);
    if (localay != null);
    for (Text localText = (Text)localay.g(); ; localText = null)
      return localText;
  }

  public DocumentType getDoctype()
  {
    ay localay = this.b.p;
    if (localay == null)
      label12: if (localay == null)
        break label42;
    label42: for (DocumentType localDocumentType = (DocumentType)localay.g(); ; localDocumentType = null)
    {
      return localDocumentType;
      if (localay.h == 1)
        break label12;
      localay = localay.c;
      break;
    }
  }

  public Element getDocumentElement()
  {
    ay localay = this.b.p;
    if (localay == null)
      label12: if (localay == null)
        break label51;
    label51: for (Element localElement = (Element)localay.g(); ; localElement = null)
    {
      return localElement;
      if ((localay.h == 5) || (localay.h == 7))
        break label12;
      localay = localay.c;
      break;
    }
  }

  public String getDocumentURI()
  {
    return null;
  }

  public DOMConfiguration getDomConfig()
  {
    return null;
  }

  public Element getElementById(String paramString)
  {
    return null;
  }

  public NodeList getElementsByTagName(String paramString)
  {
    return new al(this.b, paramString);
  }

  public NodeList getElementsByTagNameNS(String paramString1, String paramString2)
  {
    throw new DOMException(9, "getElementsByTagNameNS not supported");
  }

  public DOMImplementation getImplementation()
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public String getInputEncoding()
  {
    return null;
  }

  public String getNodeName()
  {
    return "#document";
  }

  public short getNodeType()
  {
    return 9;
  }

  public boolean getStrictErrorChecking()
  {
    return true;
  }

  public String getXmlEncoding()
  {
    return null;
  }

  public boolean getXmlStandalone()
  {
    return false;
  }

  public String getXmlVersion()
  {
    return "1.0";
  }

  public Node importNode(Node paramNode, boolean paramBoolean)
  {
    throw new DOMException(9, "importNode not supported");
  }

  public void normalizeDocument()
  {
  }

  public Node renameNode(Node paramNode, String paramString1, String paramString2)
  {
    throw new DOMException(9, "DOM method not supported");
  }

  public void setDocumentURI(String paramString)
  {
  }

  public void setStrictErrorChecking(boolean paramBoolean)
  {
  }

  public void setXmlStandalone(boolean paramBoolean)
  {
  }

  public void setXmlVersion(String paramString)
  {
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.ah
 * JD-Core Version:    0.6.0
 */