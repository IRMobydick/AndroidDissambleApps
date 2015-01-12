package com.ubercab.common.base;

public abstract class Optional<T>
{
  public static <T> Optional<T> absent()
  {
    return Absent.withType();
  }

  public static <T> Optional<T> fromNullable(T paramT)
  {
    if (paramT == null)
      return absent();
    return new Present(paramT);
  }

  public static <T> Optional<T> of(T paramT)
  {
    return new Present(Preconditions.checkNotNull(paramT));
  }

  public abstract boolean equals(Object paramObject);

  public abstract T get();

  public abstract int hashCode();

  public abstract boolean isPresent();

  public abstract Optional<T> or(Optional<? extends T> paramOptional);

  public abstract T or(T paramT);

  public abstract T orNull();

  public abstract String toString();
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.base.Optional
 * JD-Core Version:    0.6.2
 */