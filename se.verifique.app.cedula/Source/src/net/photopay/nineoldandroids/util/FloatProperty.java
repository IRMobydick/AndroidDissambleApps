package net.photopay.nineoldandroids.util;

public abstract class FloatProperty extends Property
{
  public FloatProperty(String paramString)
  {
    super(Float.class, paramString);
  }

  public final void set(Object paramObject, Float paramFloat)
  {
    setValue(paramObject, paramFloat.floatValue());
  }

  public abstract void setValue(Object paramObject, float paramFloat);
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.nineoldandroids.util.FloatProperty
 * JD-Core Version:    0.6.0
 */