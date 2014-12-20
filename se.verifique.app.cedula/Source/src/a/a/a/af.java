package a.a.a;

import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;

public class af extends ak
  implements CharacterData
{
  protected af(ay paramay)
  {
    super(paramay);
  }

  public void appendData(String paramString)
  {
    throw new DOMException(7, "Not supported");
  }

  public void deleteData(int paramInt1, int paramInt2)
  {
    throw new DOMException(7, "Not supported");
  }

  public String getData()
  {
    return getNodeValue();
  }

  public int getLength()
  {
    int i = 0;
    if ((this.b.g != null) && (this.b.e < this.b.f))
      i = this.b.f - this.b.e;
    return i;
  }

  public void insertData(int paramInt, String paramString)
  {
    throw new DOMException(7, "Not supported");
  }

  public void replaceData(int paramInt1, int paramInt2, String paramString)
  {
    throw new DOMException(7, "Not supported");
  }

  public void setData(String paramString)
  {
    throw new DOMException(7, "Not supported");
  }

  public String substringData(int paramInt1, int paramInt2)
  {
    String str = null;
    if (paramInt2 < 0)
      throw new DOMException(1, "Invalid length");
    if ((this.b.g != null) && (this.b.e < this.b.f))
    {
      if (paramInt1 + this.b.e >= this.b.f)
        throw new DOMException(1, "Invalid offset");
      if (-1 + (paramInt2 + (paramInt1 + this.b.e)) >= this.b.f)
        paramInt2 = this.b.f - this.b.e - paramInt1;
      str = do.a(this.b.g, paramInt1 + this.b.e, paramInt2);
    }
    return str;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     a.a.a.af
 * JD-Core Version:    0.6.0
 */