package com.google.gson;

public enum LongSerializationPolicy
{
  static
  {
    LongSerializationPolicy[] arrayOfLongSerializationPolicy = new LongSerializationPolicy[2];
    arrayOfLongSerializationPolicy[0] = DEFAULT;
    arrayOfLongSerializationPolicy[1] = STRING;
  }

  public abstract JsonElement serialize(Long paramLong);
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.gson.LongSerializationPolicy
 * JD-Core Version:    0.6.2
 */