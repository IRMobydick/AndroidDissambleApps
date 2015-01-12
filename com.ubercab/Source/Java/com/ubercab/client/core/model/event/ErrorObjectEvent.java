package com.ubercab.client.core.model.event;

import java.util.List;
import java.util.Map;

public final class ErrorObjectEvent
{
  private final List<Map<String, Object>> mErrorObj;

  public ErrorObjectEvent(List<Map<String, Object>> paramList)
  {
    this.mErrorObj = paramList;
  }

  public List<Map<String, Object>> getErrorObj()
  {
    return this.mErrorObj;
  }
}

/* Location:           M:\Google Play\com.ubercab_dex2jar.jar
 * Qualified Name:     com.ubercab.client.core.model.event.ErrorObjectEvent
 * JD-Core Version:    0.6.2
 */