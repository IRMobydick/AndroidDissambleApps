package a.a.a;

import org.w3c.dom.DOMException;
import org.w3c.dom.Text;

public class ao extends af
  implements Text
{
  protected ao(ay paramay)
  {
    super(paramay);
  }

  public String getNodeName()
  {
    return "#text";
  }

  public short getNodeType()
  {
    return 3;
  }

  public String getWholeText()
  {
    return null;
  }

  public boolean isElementContentWhitespace()
  {
    return false;
  }

  public Text replaceWholeText(String paramString)
  {
    return this;
  }

  public Text splitText(int paramInt)
  {
    throw new DOMException(7, "Not supported");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.ao
 * JD-Core Version:    0.6.0
 */