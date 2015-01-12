package com.google.gson;

import java.lang.reflect.Type;

public abstract interface InstanceCreator<T>
{
  public abstract T createInstance(Type paramType);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.gson.InstanceCreator
 * JD-Core Version:    0.6.2
 */