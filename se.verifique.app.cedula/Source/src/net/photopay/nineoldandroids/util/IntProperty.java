package net.photopay.nineoldandroids.util;

public abstract class IntProperty extends Property
{
  public IntProperty(String paramString)
  {
    super(Integer.class, paramString);
  }

  public final void set(Object paramObject, Integer paramInteger)
  {
    while (true)
      paramInteger = Integer.valueOf(paramInteger.intValue());
  }

  public abstract void setValue(Object paramObject, int paramInt);
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.nineoldandroids.util.IntProperty
 * JD-Core Version:    0.6.0
 */