package com.google.gson;

import java.lang.reflect.Field;

public abstract interface FieldNamingStrategy
{
  public abstract String translateName(Field paramField);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.gson.FieldNamingStrategy
 * JD-Core Version:    0.6.2
 */