package se.verifique.app.cedula.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class r
  implements Serializable
{
  protected List a;

  public List a()
  {
    if (this.a == null)
      this.a = new ArrayList();
    return this.a;
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     se.verifique.app.cedula.a.r
 * JD-Core Version:    0.6.0
 */