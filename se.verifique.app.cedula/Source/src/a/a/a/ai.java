package a.a.a;

import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;

public class ai extends ak
  implements DocumentType
{
  protected ai(ay paramay)
  {
    super(paramay);
  }

  public NamedNodeMap getEntities()
  {
    return null;
  }

  public String getInternalSubset()
  {
    return null;
  }

  public String getName()
  {
    String str = null;
    if ((this.b.h == 1) && (this.b.g != null) && (this.b.e < this.b.f))
      str = do.a(this.b.g, this.b.e, this.b.f - this.b.e);
    return str;
  }

  public String getNodeName()
  {
    return getName();
  }

  public short getNodeType()
  {
    return 10;
  }

  public NamedNodeMap getNotations()
  {
    return null;
  }

  public String getPublicId()
  {
    return null;
  }

  public String getSystemId()
  {
    return null;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.ai
 * JD-Core Version:    0.6.0
 */