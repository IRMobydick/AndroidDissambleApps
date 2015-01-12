package retrofit;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;

final class Types
{
  private static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

  private static void checkNotPrimitive(Type paramType)
  {
    if (((paramType instanceof Class)) && (((Class)paramType).isPrimitive()))
      throw new IllegalArgumentException();
  }

  private static Class<?> declaringClassOf(TypeVariable<?> paramTypeVariable)
  {
    GenericDeclaration localGenericDeclaration = paramTypeVariable.getGenericDeclaration();
    if ((localGenericDeclaration instanceof Class))
      return (Class)localGenericDeclaration;
    return null;
  }

  private static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static boolean equals(Type paramType1, Type paramType2)
  {
    boolean bool1 = true;
    boolean bool3;
    if (paramType1 == paramType2)
      bool3 = bool1;
    boolean bool4;
    do
    {
      boolean bool2;
      do
      {
        boolean bool5;
        do
        {
          boolean bool6;
          do
          {
            boolean bool7;
            do
            {
              return bool3;
              if ((paramType1 instanceof Class))
                return paramType1.equals(paramType2);
              if (!(paramType1 instanceof ParameterizedType))
                break;
              bool7 = paramType2 instanceof ParameterizedType;
              bool3 = false;
            }
            while (!bool7);
            ParameterizedType localParameterizedType1 = (ParameterizedType)paramType1;
            ParameterizedType localParameterizedType2 = (ParameterizedType)paramType2;
            if ((equal(localParameterizedType1.getOwnerType(), localParameterizedType2.getOwnerType())) && (localParameterizedType1.getRawType().equals(localParameterizedType2.getRawType())) && (Arrays.equals(localParameterizedType1.getActualTypeArguments(), localParameterizedType2.getActualTypeArguments())));
            while (true)
            {
              return bool1;
              bool1 = false;
            }
            if (!(paramType1 instanceof GenericArrayType))
              break;
            bool6 = paramType2 instanceof GenericArrayType;
            bool3 = false;
          }
          while (!bool6);
          GenericArrayType localGenericArrayType1 = (GenericArrayType)paramType1;
          GenericArrayType localGenericArrayType2 = (GenericArrayType)paramType2;
          return equals(localGenericArrayType1.getGenericComponentType(), localGenericArrayType2.getGenericComponentType());
          if (!(paramType1 instanceof WildcardType))
            break;
          bool5 = paramType2 instanceof WildcardType;
          bool3 = false;
        }
        while (!bool5);
        WildcardType localWildcardType1 = (WildcardType)paramType1;
        WildcardType localWildcardType2 = (WildcardType)paramType2;
        if ((Arrays.equals(localWildcardType1.getUpperBounds(), localWildcardType2.getUpperBounds())) && (Arrays.equals(localWildcardType1.getLowerBounds(), localWildcardType2.getLowerBounds())));
        while (true)
        {
          return bool1;
          bool1 = false;
        }
        bool2 = paramType1 instanceof TypeVariable;
        bool3 = false;
      }
      while (!bool2);
      bool4 = paramType2 instanceof TypeVariable;
      bool3 = false;
    }
    while (!bool4);
    TypeVariable localTypeVariable1 = (TypeVariable)paramType1;
    TypeVariable localTypeVariable2 = (TypeVariable)paramType2;
    if ((localTypeVariable1.getGenericDeclaration() == localTypeVariable2.getGenericDeclaration()) && (localTypeVariable1.getName().equals(localTypeVariable2.getName())));
    while (true)
    {
      return bool1;
      bool1 = false;
    }
  }

  static Type getGenericSupertype(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == paramClass1)
      return paramType;
    if (paramClass2.isInterface())
    {
      Class[] arrayOfClass = paramClass1.getInterfaces();
      int i = 0;
      int j = arrayOfClass.length;
      while (i < j)
      {
        if (arrayOfClass[i] == paramClass2)
          return paramClass1.getGenericInterfaces()[i];
        if (paramClass2.isAssignableFrom(arrayOfClass[i]))
          return getGenericSupertype(paramClass1.getGenericInterfaces()[i], arrayOfClass[i], paramClass2);
        i++;
      }
    }
    if (!paramClass1.isInterface())
      while (paramClass1 != Object.class)
      {
        Class localClass = paramClass1.getSuperclass();
        if (localClass == paramClass2)
          return paramClass1.getGenericSuperclass();
        if (paramClass2.isAssignableFrom(localClass))
          return getGenericSupertype(paramClass1.getGenericSuperclass(), localClass, paramClass2);
        paramClass1 = localClass;
      }
    return paramClass2;
  }

  public static Class<?> getRawType(Type paramType)
  {
    if ((paramType instanceof Class))
      return (Class)paramType;
    if ((paramType instanceof ParameterizedType))
    {
      Type localType = ((ParameterizedType)paramType).getRawType();
      if (!(localType instanceof Class))
        throw new IllegalArgumentException();
      return (Class)localType;
    }
    if ((paramType instanceof GenericArrayType))
      return Array.newInstance(getRawType(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
    if ((paramType instanceof TypeVariable))
      return Object.class;
    if ((paramType instanceof WildcardType))
      return getRawType(((WildcardType)paramType).getUpperBounds()[0]);
    if (paramType == null);
    for (String str = "null"; ; str = paramType.getClass().getName())
      throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + paramType + "> is of type " + str);
  }

  public static Type getSupertype(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (!paramClass2.isAssignableFrom(paramClass1))
      throw new IllegalArgumentException();
    return resolve(paramType, paramClass1, getGenericSupertype(paramType, paramClass1, paramClass2));
  }

  private static int hashCodeOrZero(Object paramObject)
  {
    if (paramObject != null)
      return paramObject.hashCode();
    return 0;
  }

  private static int indexOf(Object[] paramArrayOfObject, Object paramObject)
  {
    for (int i = 0; i < paramArrayOfObject.length; i++)
      if (paramObject.equals(paramArrayOfObject[i]))
        return i;
    throw new NoSuchElementException();
  }

  public static Type resolve(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    Object localObject1;
    while ((paramType2 instanceof TypeVariable))
    {
      TypeVariable localTypeVariable = (TypeVariable)paramType2;
      paramType2 = resolveTypeVariable(paramType1, paramClass, localTypeVariable);
      if (paramType2 == localTypeVariable)
        localObject1 = paramType2;
    }
    Type[] arrayOfType2;
    Type localType1;
    do
    {
      do
      {
        Type[] arrayOfType1;
        Type localType2;
        do
        {
          Type localType4;
          int i;
          Type[] arrayOfType3;
          do
          {
            Type localType6;
            Type localType7;
            do
            {
              return localObject1;
              if (((paramType2 instanceof Class)) && (((Class)paramType2).isArray()))
              {
                Object localObject2 = (Class)paramType2;
                Class localClass = ((Class)localObject2).getComponentType();
                Type localType8 = resolve(paramType1, paramClass, localClass);
                if (localClass == localType8);
                while (true)
                {
                  return localObject2;
                  localObject2 = new GenericArrayTypeImpl(localType8);
                }
              }
              if (!(paramType2 instanceof GenericArrayType))
                break;
              localObject1 = (GenericArrayType)paramType2;
              localType6 = ((GenericArrayType)localObject1).getGenericComponentType();
              localType7 = resolve(paramType1, paramClass, localType6);
            }
            while (localType6 == localType7);
            return new GenericArrayTypeImpl(localType7);
            if (!(paramType2 instanceof ParameterizedType))
              break;
            localObject1 = (ParameterizedType)paramType2;
            Type localType3 = ((ParameterizedType)localObject1).getOwnerType();
            localType4 = resolve(paramType1, paramClass, localType3);
            if (localType4 != localType3);
            for (i = 1; ; i = 0)
            {
              arrayOfType3 = ((ParameterizedType)localObject1).getActualTypeArguments();
              int j = 0;
              int k = arrayOfType3.length;
              while (j < k)
              {
                Type localType5 = resolve(paramType1, paramClass, arrayOfType3[j]);
                if (localType5 != arrayOfType3[j])
                {
                  if (i == 0)
                  {
                    arrayOfType3 = (Type[])arrayOfType3.clone();
                    i = 1;
                  }
                  arrayOfType3[j] = localType5;
                }
                j++;
              }
            }
          }
          while (i == 0);
          ParameterizedTypeImpl localParameterizedTypeImpl = new ParameterizedTypeImpl(localType4, ((ParameterizedType)localObject1).getRawType(), arrayOfType3);
          return localParameterizedTypeImpl;
          if (!(paramType2 instanceof WildcardType))
            break label416;
          localObject1 = (WildcardType)paramType2;
          arrayOfType1 = ((WildcardType)localObject1).getLowerBounds();
          arrayOfType2 = ((WildcardType)localObject1).getUpperBounds();
          if (arrayOfType1.length != 1)
            break;
          localType2 = resolve(paramType1, paramClass, arrayOfType1[0]);
        }
        while (localType2 == arrayOfType1[0]);
        return new WildcardTypeImpl(new Type[] { Object.class }, new Type[] { localType2 });
      }
      while (arrayOfType2.length != 1);
      localType1 = resolve(paramType1, paramClass, arrayOfType2[0]);
    }
    while (localType1 == arrayOfType2[0]);
    return new WildcardTypeImpl(new Type[] { localType1 }, EMPTY_TYPE_ARRAY);
    label416: return paramType2;
  }

  private static Type resolveTypeVariable(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Class localClass = declaringClassOf(paramTypeVariable);
    if (localClass == null);
    Type localType;
    do
    {
      return paramTypeVariable;
      localType = getGenericSupertype(paramType, paramClass, localClass);
    }
    while (!(localType instanceof ParameterizedType));
    int i = indexOf(localClass.getTypeParameters(), paramTypeVariable);
    return ((ParameterizedType)localType).getActualTypeArguments()[i];
  }

  public static String typeToString(Type paramType)
  {
    if ((paramType instanceof Class))
      return ((Class)paramType).getName();
    return paramType.toString();
  }

  private static final class GenericArrayTypeImpl
    implements GenericArrayType
  {
    private final Type componentType;

    public GenericArrayTypeImpl(Type paramType)
    {
      this.componentType = paramType;
    }

    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof GenericArrayType)) && (Types.equals(this, (GenericArrayType)paramObject));
    }

    public Type getGenericComponentType()
    {
      return this.componentType;
    }

    public int hashCode()
    {
      return this.componentType.hashCode();
    }

    public String toString()
    {
      return Types.typeToString(this.componentType) + "[]";
    }
  }

  private static final class ParameterizedTypeImpl
    implements ParameterizedType
  {
    private final Type ownerType;
    private final Type rawType;
    private final Type[] typeArguments;

    public ParameterizedTypeImpl(Type paramType1, Type paramType2, Type[] paramArrayOfType)
    {
      if ((paramType2 instanceof Class))
      {
        int m;
        if (paramType1 == null)
        {
          m = i;
          if (((Class)paramType2).getEnclosingClass() != null)
            break label56;
        }
        while (true)
        {
          if (m == i)
            break label62;
          throw new IllegalArgumentException();
          m = 0;
          break;
          label56: i = 0;
        }
      }
      label62: this.ownerType = paramType1;
      this.rawType = paramType2;
      this.typeArguments = ((Type[])paramArrayOfType.clone());
      Type[] arrayOfType = this.typeArguments;
      int k = arrayOfType.length;
      while (j < k)
      {
        Type localType = arrayOfType[j];
        if (localType == null)
          throw new NullPointerException();
        Types.checkNotPrimitive(localType);
        j++;
      }
    }

    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof ParameterizedType)) && (Types.equals(this, (ParameterizedType)paramObject));
    }

    public Type[] getActualTypeArguments()
    {
      return (Type[])this.typeArguments.clone();
    }

    public Type getOwnerType()
    {
      return this.ownerType;
    }

    public Type getRawType()
    {
      return this.rawType;
    }

    public int hashCode()
    {
      return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ Types.hashCodeOrZero(this.ownerType);
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(30 * (1 + this.typeArguments.length));
      localStringBuilder.append(Types.typeToString(this.rawType));
      if (this.typeArguments.length == 0)
        return localStringBuilder.toString();
      localStringBuilder.append("<").append(Types.typeToString(this.typeArguments[0]));
      for (int i = 1; i < this.typeArguments.length; i++)
        localStringBuilder.append(", ").append(Types.typeToString(this.typeArguments[i]));
      return ">";
    }
  }

  private static final class WildcardTypeImpl
    implements WildcardType
  {
    private final Type lowerBound;
    private final Type upperBound;

    public WildcardTypeImpl(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      if (paramArrayOfType2.length > 1)
        throw new IllegalArgumentException();
      if (paramArrayOfType1.length != 1)
        throw new IllegalArgumentException();
      if (paramArrayOfType2.length == 1)
      {
        if (paramArrayOfType2[0] == null)
          throw new NullPointerException();
        Types.checkNotPrimitive(paramArrayOfType2[0]);
        if (paramArrayOfType1[0] != Object.class)
          throw new IllegalArgumentException();
        this.lowerBound = paramArrayOfType2[0];
        this.upperBound = Object.class;
        return;
      }
      if (paramArrayOfType1[0] == null)
        throw new NullPointerException();
      Types.checkNotPrimitive(paramArrayOfType1[0]);
      this.lowerBound = null;
      this.upperBound = paramArrayOfType1[0];
    }

    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof WildcardType)) && (Types.equals(this, (WildcardType)paramObject));
    }

    public Type[] getLowerBounds()
    {
      if (this.lowerBound != null)
      {
        Type[] arrayOfType = new Type[1];
        arrayOfType[0] = this.lowerBound;
        return arrayOfType;
      }
      return Types.EMPTY_TYPE_ARRAY;
    }

    public Type[] getUpperBounds()
    {
      Type[] arrayOfType = new Type[1];
      arrayOfType[0] = this.upperBound;
      return arrayOfType;
    }

    public int hashCode()
    {
      if (this.lowerBound != null);
      for (int i = 31 + this.lowerBound.hashCode(); ; i = 1)
        return i ^ 31 + this.upperBound.hashCode();
    }

    public String toString()
    {
      if (this.lowerBound != null)
        return "? super " + Types.typeToString(this.lowerBound);
      if (this.upperBound == Object.class)
        return "?";
      return "? extends " + Types.typeToString(this.upperBound);
    }
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     retrofit.Types
 * JD-Core Version:    0.6.2
 */