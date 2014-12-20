package com.google.android.gms.a;

import android.os.IBinder;
import java.lang.reflect.Field;

public final class d extends b
{
  private final Object a;

  private d(Object paramObject)
  {
    this.a = paramObject;
  }

  public static a a(Object paramObject)
  {
    return new d(paramObject);
  }

  public static Object a(a parama)
  {
    Object localObject2;
    if ((parama instanceof d))
      localObject2 = ((d)parama).a;
    while (true)
    {
      return localObject2;
      IBinder localIBinder = parama.asBinder();
      Field[] arrayOfField = localIBinder.getClass().getDeclaredFields();
      if (arrayOfField.length != 1)
        break label122;
      Field localField = arrayOfField[0];
      if (localField.isAccessible())
        break;
      localField.setAccessible(true);
      try
      {
        Object localObject1 = localField.get(localIBinder);
        localObject2 = localObject1;
      }
      catch (NullPointerException localNullPointerException)
      {
        throw new IllegalArgumentException("Binder object is null.", localNullPointerException);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new IllegalArgumentException("remoteBinder is the wrong class.", localIllegalArgumentException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new IllegalArgumentException("Could not access the field in remoteBinder.", localIllegalAccessException);
      }
    }
    throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
    label122: throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
  }
}

/* Location:           M:\Google Play\APKtoJava_RC2\tools\classes-dex2jar.jar
 * Qualified Name:     com.google.android.gms.a.d
 * JD-Core Version:    0.6.0
 */