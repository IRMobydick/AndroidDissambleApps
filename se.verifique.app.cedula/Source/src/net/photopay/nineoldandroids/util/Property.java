package net.photopay.nineoldandroids.util;

public abstract class Property
{
  private final String mName;
  private final Class mType;

  public Property(Class paramClass, String paramString)
  {
    this.mName = paramString;
    this.mType = paramClass;
  }

  public static Property of(Class paramClass1, Class paramClass2, String paramString)
  {
    return new ReflectiveProperty(paramClass1, paramClass2, paramString);
  }

  public abstract Object get(Object paramObject);

  public String getName()
  {
    return this.mName;
  }

  public Class getType()
  {
    return this.mType;
  }

  public boolean isReadOnly()
  {
    return false;
  }

  public void set(Object paramObject1, Object paramObject2)
  {
    throw new UnsupportedOperationException("Property " + getName() + " is read-only");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     net.photopay.nineoldandroids.util.Property
 * JD-Core Version:    0.6.0
 */