package net.photopay.recognition;

import java.util.Iterator;
import java.util.Set;
import net.photopay.util.Log;

public class RightsManager
{
  private Set llIIlIIlll = null;
  private boolean lllIIIllII = false;

  protected RightsManager(Set paramSet, boolean paramBoolean)
  {
    this.llIIlIIlll = paramSet;
    this.lllIIIllII = paramBoolean;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Boolean.valueOf(this.lllIIIllII);
    Log.i(this, "License is OK: {}", arrayOfObject1);
    Iterator localIterator = this.llIIlIIlll.iterator();
    while (localIterator.hasNext())
    {
      Right localRight = (Right)localIterator.next();
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = localRight;
      Log.i(this, "enabled right: {}", arrayOfObject2);
    }
    if (this.llIIlIIlll.size() == 0)
      Log.i(this, "no enabled rights", new Object[0]);
  }

  public final boolean lIllIIlIIl()
  {
    return this.lllIIIllII;
  }

  public final boolean llIIlIlIIl(Right paramRight)
  {
    return this.llIIlIIlll.contains(paramRight);
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.recognition.RightsManager
 * JD-Core Version:    0.6.0
 */