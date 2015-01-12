package com.google.gson;

public final class JsonNull extends JsonElement
{
  public static final JsonNull INSTANCE = new JsonNull();

  JsonNull deepCopy()
  {
    return INSTANCE;
  }

  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || ((paramObject instanceof JsonNull));
  }

  public int hashCode()
  {
    return JsonNull.class.hashCode();
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.gson.JsonNull
 * JD-Core Version:    0.6.2
 */