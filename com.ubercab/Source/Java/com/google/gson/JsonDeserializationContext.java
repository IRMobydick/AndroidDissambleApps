package com.google.gson;

import java.lang.reflect.Type;

public abstract interface JsonDeserializationContext
{
  public abstract <T> T deserialize(JsonElement paramJsonElement, Type paramType)
    throws JsonParseException;
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.google.gson.JsonDeserializationContext
 * JD-Core Version:    0.6.2
 */