package a.a.a;

import org.w3c.dom.DOMException;
import org.w3c.dom.ProcessingInstruction;

public class an extends ak
  implements ProcessingInstruction
{
  protected an(ay paramay)
  {
    super(paramay);
  }

  public String getData()
  {
    return getNodeValue();
  }

  public short getNodeType()
  {
    return 7;
  }

  public String getTarget()
  {
    return null;
  }

  public void setData(String paramString)
  {
    throw new DOMException(7, "Node is read only");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.an
 * JD-Core Version:    0.6.0
 */