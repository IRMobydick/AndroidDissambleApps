package com.google.gson;

import java.lang.reflect.Type;

public abstract interface JsonDeserializer<T>
{
  public abstract T deserialize(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
    throws JsonParseException;
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.gson.JsonDeserializer
 * JD-Core Version:    0.6.2
 */