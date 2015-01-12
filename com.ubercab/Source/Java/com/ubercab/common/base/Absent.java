package com.ubercab.common.base;

final class Absent<T> extends Optional<T>
{
  static final Absent<Object> INSTANCE = new Absent();

  static <T> Optional<T> withType()
  {
    return INSTANCE;
  }

  public boolean equals(Object paramObject)
  {
    return paramObject == this;
  }

  public T get()
  {
    throw new IllegalStateException("Optional.get() cannot be called on an absent value");
  }

  public int hashCode()
  {
    return 1502476572;
  }

  public boolean isPresent()
  {
    return false;
  }

  public Optional<T> or(Optional<? extends T> paramOptional)
  {
    return (Optional)Preconditions.checkNotNull(paramOptional);
  }

  public T or(T paramT)
  {
    return Preconditions.checkNotNull(paramT);
  }

  public T orNull()
  {
    return null;
  }

  public String toString()
  {
    return "Optional.absent()";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.base.Absent
 * JD-Core Version:    0.6.2
 */