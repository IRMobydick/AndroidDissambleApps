package com.ubercab.common.base;

final class Present<T> extends Optional<T>
{
  private final T reference;

  Present(T paramT)
  {
    this.reference = paramT;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Present))
    {
      Present localPresent = (Present)paramObject;
      return this.reference.equals(localPresent.reference);
    }
    return false;
  }

  public T get()
  {
    return this.reference;
  }

  public int hashCode()
  {
    return 1502476572 + this.reference.hashCode();
  }

  public boolean isPresent()
  {
    return true;
  }

  public Optional<T> or(Optional<? extends T> paramOptional)
  {
    Preconditions.checkNotNull(paramOptional);
    return this;
  }

  public T or(T paramT)
  {
    Preconditions.checkNotNull(paramT);
    return this.reference;
  }

  public T orNull()
  {
    return this.reference;
  }

  public String toString()
  {
    return "Optional.of(" + this.reference + ")";
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.common.base.Present
 * JD-Core Version:    0.6.2
 */